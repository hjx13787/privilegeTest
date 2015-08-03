package privilegeTest.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import privilegeTest.MainPresenter;
import privilegeTest.Task;
import privilegeTest.TaskDAO;

/**
 * 消息处理类
 * 
 * @author 何明
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
//     * 当客户端接受到消息时
//     */
//    @Override
//    public void messageReceived(IoSession session, Object message)
//	    throws Exception {
//
//	// 我们已设定了服务器的消息规则是一行一行读取，这里就可以转为String:
//	String s = (String) message;
//
//	// Writer the received data back to remote peer
//	System.out.println("服务器发来的收到消息: " + s);
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
	// TODO 自动生成的方法存根
	return false;
    }

    @Override
    public void messageSent(IoSession arg0, Object arg1) throws Exception {
	System.out.println(msg);
	arg0.write(msg);
    }
}
