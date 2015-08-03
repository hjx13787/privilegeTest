package privilegeTest.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import privilegeTest.Task;

/**
 * 启动客户端
 * @author
 *
 */
public class MainClient {

	public static void main(String []args)throws Exception{
		
		//Create TCP/IP connection
		NioSocketConnector connector = new NioSocketConnector();
		
		//创建接受数据的过滤器
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		
		//设定这个过滤器将一行一行(/r/n)的读取数据
		chain.addLast("myChin", new ProtocolCodecFilter(new TextLineCodecFactory()));
		
		//服务器的消息处理器：一个SamplMinaServerHander对象
		connector.setHandler(new SamplMinaClientHander("11"));
		
		//set connect timeout
		connector.setConnectTimeout(30);
		
		//连接到服务器：
		ConnectFuture cf = connector.connect(new InetSocketAddress("localhost",8899));
		System.out.println(cf);
		//Wait for the connection attempt to be finished.
		cf.awaitUninterruptibly();
		IoSession session = cf.getSession();
		session.getConfig().setUseReadOperation(true);
		Object message = session.read().awaitUninterruptibly().getMessage();
		byte[] bytes = (byte[]) message;
		System.out.println("byte==="+new String(bytes));
		cf.getSession().getCloseFuture().awaitUninterruptibly();
		
		connector.dispose();
	}
	
	public synchronized byte[] send(String ip,Object msg){
		try {
			IoConnector connector = new NioSocketConnector();
			connector.setConnectTimeoutMillis(1000);
			connector.getFilterChain().addLast(
				"codec",
				(IoFilter) new ProtocolCodecFilter(new TextLineCodecFactory(
					Charset.forName("UTF-8"))));
			
			    connector.setHandler(new ClientHandler());
				ConnectFuture connFuture = connector.connect(new InetSocketAddress(
					ip, 10001));
				if(connFuture==null){
					throw new Exception("连接失败");
				}
				connFuture.awaitUninterruptibly(400);
				IoSession session = connFuture.getSession();
				if(session==null){
					return null;
				}
				session.getConfig().setUseReadOperation(true);
				WriteFuture write = session.write(msg);
				write.awaitUninterruptibly(50);
				if (write.getException()!=null) {
					write.getException().printStackTrace();
					throw new Exception("发送消息失败");
				}
				ReadFuture read = session.read();
				read.awaitUninterruptibly(400);
				if (read.getException()!=null) {
					read.setClosed();
					session.getConfig().setUseReadOperation(false);
					read.getException().printStackTrace();
					throw new Exception("读取消息失败");
				}
				Object message = read.getMessage();
				System.out.println("msg===="+message);
				byte[] bytes = (byte[]) message;
				session.getCloseFuture().awaitUninterruptibly();
				connector.dispose();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}