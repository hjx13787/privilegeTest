package privilegeTest.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;


public class MinaTimeServer {
    // �����������˿�
    private static final int PORT = 8899;

    /**
	 * 
	 */
    public MinaTimeServer() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// �������˵���Ҫ����
	IoAcceptor acceptor = new NioSocketAcceptor();

	// ����Filter��
	acceptor.getFilterChain().addLast("logger", new LoggingFilter());
	// Э�����������mina�ֳɵ�UTF-8�ַ�������ʽ
	acceptor.getFilterChain().addLast(
		"codec",
		new ProtocolCodecFilter(new TextLineCodecFactory(Charset
			.forName("UTF-8"))));

	// ������Ϣ�����ࣨ�������ر�Session���ɶ���д�ȵȣ��̳��Խӿ�IoHandler��
	acceptor.setHandler(new TimeServerHandler());
	// ���ý��ջ�������С
	acceptor.getSessionConfig().setReadBufferSize(2048);
	acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
	try {
	    // ��������ʼ����
	    acceptor.bind(new InetSocketAddress(PORT));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}