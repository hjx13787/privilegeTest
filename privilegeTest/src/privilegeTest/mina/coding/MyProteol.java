package privilegeTest.mina.coding;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class MyProteol implements ProtocolCodecFactory {

	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		// TODO �Զ����ɵķ������2015��8��3�գ�Michael
		return new MyProtocolEncoder();
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		// TODO �Զ����ɵķ������2015��8��3�գ�Michael
		return new MyProtocolDecoder();
	}

}
