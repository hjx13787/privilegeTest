package privilegeTest.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import privilegeTest.MainPresenter;
import privilegeTest.Task;
import privilegeTest.TaskDAO;

/**
 * ��Ϣ������
 * 
 * @author ����
 * 
 */
public class SamplMinaClientHander extends IoHandlerAdapter {
    TaskDAO td = new TaskDAO();
    Task t;
    private String msg;

    public SamplMinaClientHander(String msg) {
	this.msg = msg;
    }

    @Override
    public void exceptionCaught(IoSession arg0, Throwable arg1)
	    throws Exception {
	arg1.printStackTrace();
    }

//    /**
//     * ���ͻ��˽��ܵ���Ϣʱ
//     */
//    @Override
//    public void messageReceived(IoSession session, Object message)
//	    throws Exception {
//
//	// �������趨�˷���������Ϣ������һ��һ�ж�ȡ������Ϳ���תΪString:
//	String s = (String) message;
//
//	// Writer the received data back to remote peer
//	System.out.println("�������������յ���Ϣ: " + s);
//	if (t != null) {
//	    boolean flag = checkMsg(s);
//	    if (flag) {
//		if (t.getStatustype().equals(
//			MainPresenter.privilegeType.waitupload.toString())) {
//		    t.setStatustype(MainPresenter.privilegeType.uploaded
//			    .toString());
//		    td.attachDirty(t);
//		}
//
//		if (t.getStatustype().equals(
//			MainPresenter.privilegeType.waitdelete.toString())) {
//		    t.setStatustype(MainPresenter.privilegeType.deleteed
//			    .toString());
//		    td.attachDirty(t);
//		}
//	    } else {
//		if (t.getStatustype().equals(
//			MainPresenter.privilegeType.waitupload.toString())) {
//		    t.setStatustype(MainPresenter.privilegeType.unupload
//			    .toString());
//		    td.attachDirty(t);
//		}
//
//		if (t.getStatustype().equals(
//			MainPresenter.privilegeType.waitdelete.toString())) {
//		    t.setStatustype(MainPresenter.privilegeType.undelete
//			    .toString());
//		    td.attachDirty(t);
//		}
//	    }
//	}
//
//    }

    private boolean checkMsg(String s) {
	// TODO �Զ����ɵķ������
	return false;
    }

    @Override
    public void messageSent(IoSession arg0, Object arg1) throws Exception {
	System.out.println(msg);
	arg0.write(msg);
    }
}
