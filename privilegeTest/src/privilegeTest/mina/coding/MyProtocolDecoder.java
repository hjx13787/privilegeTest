package privilegeTest.mina.coding;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import privilegeTest.util.ByteUtils;

public class MyProtocolDecoder extends ProtocolDecoderAdapter  {

	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		int limit = in.limit();
		byte[] bytes = new byte[limit];
		
		in.get(bytes);
		
		out.write(ByteUtils.byteArrayToHexString(bytes));
	}

}
