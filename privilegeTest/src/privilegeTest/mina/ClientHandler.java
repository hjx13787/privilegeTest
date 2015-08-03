package privilegeTest.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientHandler extends IoHandlerAdapter {
    private String values=null;

    public ClientHandler(String values) {
	this.values = values;
    }
    public ClientHandler(){
    	
    }
}
