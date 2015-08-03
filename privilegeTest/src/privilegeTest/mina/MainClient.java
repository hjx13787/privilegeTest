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
 * �����ͻ���
 * @author
 *
 */
public class MainClient {

	public static void main(String []args)throws Exception{
		
		//Create TCP/IP connection
		NioSocketConnector connector = new NioSocketConnector();
		
		//�����������ݵĹ�����
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		
		//�趨�����������һ��һ��(/r/n)�Ķ�ȡ����
		chain.addLast("myChin", new ProtocolCodecFilter(new TextLineCodecFactory()));
		
		//����������Ϣ��������һ��SamplMinaServerHander����
		connector.setHandler(new SamplMinaClientHander("11"));
		
		//set connect timeout
		connector.setConnectTimeout(30);
		
		//���ӵ���������
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
					throw new Exception("����ʧ��");
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
					throw new Exception("������Ϣʧ��");
				}
				ReadFuture read = session.read();
				read.awaitUninterruptibly(400);
				if (read.getException()!=null) {
					read.setClosed();
					session.getConfig().setUseReadOperation(false);
					read.getException().printStackTrace();
					throw new Exception("��ȡ��Ϣʧ��");
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