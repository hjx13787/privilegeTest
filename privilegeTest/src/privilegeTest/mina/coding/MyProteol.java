package privilegeTest.mina.coding;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class MyProteol implements ProtocolCodecFactory {

	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		// TODO 自动生成的方法存根2015年8月3日，Michael
		return new MyProtocolEncoder();
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		// TODO 自动生成的方法存根2015年8月3日，Michael
		return new MyProtocolDecoder();
	}

}
