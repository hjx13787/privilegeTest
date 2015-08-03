package privilegeTest.mina.coding;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import privilegeTest.util.ByteUtils;

public class MyProtocolEncoder extends ProtocolEncoderAdapter{

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		byte[] bytes = ByteUtils.hexStringToByteArray((String)message);
		
		IoBuffer buffer = IoBuffer.allocate(256);
		buffer.setAutoExpand(true);
		
		buffer.put(bytes);
		buffer.flip();
		
		out.write(buffer);
		out.flush();
	}

}
