package privilegeTest.mina;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * @author aniyo
 * blog: http://aniyo.iteye.com
 * �̳���IoHandlerAdapter��IoHandlerAdapter�̳нӿ� IoHandler
        ��IoHandlerAdapterʵ����IoHandler�����з�����ֻҪ���ع��ĵļ��������Ϳ�����
 */
public class TimeServerHandler extends IoHandlerAdapter {

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		cause.printStackTrace();
	}

    /*
     * ���������Ŀǰ�����������Ҫ�ģ�
     * �����յ���Ϣ��ֻҪ����quit���Ͱѷ�������ǰ��ʱ�䷵�ظ��ͻ���
     * �����quit����رտͻ�������*/
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String str = message.toString();
		
		Date date = new Date();
		System.out.println("hello"+str+session.getRemoteAddress()+date.toString());
		
		session.write("i am recived");
		System.out.println("Message written..."+str);
		

	}
}
