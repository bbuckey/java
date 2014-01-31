package json;

import java.io.BufferedReader;
import java.util.List;
import java.util.Map;
import java.io.Reader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSON extends JSONParser {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4913043501745082298L;

	JSON() {;}
	
	/**
	 * 
	 * @param sr - takes the abstract reader type and creates a new buffered reader
	 * @return List of objects created when the json is parsed
	 * @throws Exception
	 */
	public Map parse(Reader sr) throws Exception{
		return super.parse(new BufferedReader(sr));
	}
	
	/**
	 * 
	 * @param dis takes the abstract inputstream and creates a inputstreamreader
	 * @return List of objects created when the json is parsed
	 * @throws Exception
	 */
	public Map parse(InputStream dis)throws Exception{
		return super.parse(new InputStreamReader(dis));
	}

	
	/**
	 * 
	 * @param sr takes a string
	 * @return List of objects created when the json is parsed
	 * @throws Exception
	 */
	public Map parse(String sr)throws Exception{
		return super.parse(new String(sr));
	}
	
}

