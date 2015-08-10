package privilegeTest.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import privilegeTest.Task;
import privilegeTest.mina.coding.MyProteol;
import privilegeTest.util.ByteUtils;

/**
 * 启动客户端
 * @author
 *
 */
public class MainClient {
	IoConnector connector;
	ConnectFuture connFuture;
	public MainClient(){
		connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(1000);
		connector.getFilterChain().addLast(
			"codec",
			(IoFilter) new ProtocolCodecFilter(new MyProteol()));
		
		    connector.setHandler(new ClientHandler());
	}
	
	public synchronized String send(String ip,String msg){
		try {
    			if(connFuture==null||!connFuture.isConnected()){
    				connFuture = connector.connect(new InetSocketAddress(
    						ip, 10001));
    				connFuture.awaitUninterruptibly(400);
    			}
    			if(connFuture==null){
    				return null;
    			}
				IoSession session = connFuture.getSession();
				if(session==null){
					return null;
				}
				WriteFuture write = session.write(msg);
				write.awaitUninterruptibly(50);
				if (write.getException()!=null) {
					write.getException().printStackTrace();
					throw new Exception("发送消息失败");
				}
				session.getConfig().setUseReadOperation(true);
				ReadFuture read = session.read();
				read.awaitUninterruptibly(800);
				if (read.getException()!=null) {
					read.setClosed();
					read.getException().printStackTrace();
					throw new Exception("读取消息失败");
				}
				String message = (String)read.getMessage();
				session.getConfig().setUseReadOperation(false);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
		}
	}
	
}