/**
 * 
 */
package API.PSI;

import API.StreamType;
import API.Descriptor.DescriptorMethod;
import Core.ByteRepresentation;
import Core.XMLRepresentation;

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public interface PMTStream extends ByteRepresentation, XMLRepresentation, DescriptorMethod {
	/**
	 * return a value of 'stream_type'.
	 * @return
	 */
	StreamType getStreamType();

	/**
	 * return a value of 'elementary_PID'.
	 * @return
	 */
	int getElementaryPID();

	/**
	 * set a value of 'stream_type'.
	 * @param type
	 */
	void setStreamType(StreamType type);

	/**
	 * set a value of 'elementary_PID'.
	 * @param pid
	 */
	void setElementaryPID(int pid);
}
