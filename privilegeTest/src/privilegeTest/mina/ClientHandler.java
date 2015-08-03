package privilegeTest.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientHandler extends IoHandlerAdapter {
    private final static Logger LOGGER = LoggerFactory
	    .getLogger(ClientHandler.class);
    private final String values;

    public ClientHandler(String values) {
	this.values = values;
    }

    @Override
    public void sessionOpened(IoSession session) {
	session.write(values+"å¼?§‹è¯·æ±‚");
    }

    @Override
    public void messageReceived(IoSession session, Object message)
	    throws Exception {
	System.out.println("client"+message.toString()+"==="+session);
    }
    
    
}
