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
	
		/**
	 * Given the class and the object the Fields and methods
	 * are then cycled through looking for the getters if one is found a   
	 * @param clazz
	 * @param obj
	 * @return
	 */
	public  String jsonify(Class<?> clazz, Object obj) throws Throwable{
		String json = "";
		Method[] methods = clazz.getMethods();
		Field[] fields = clazz.getDeclaredFields(); 
		for(Field f : fields){
			String fieldName = f.getName().toUpperCase();
			for(Method m : methods){
				String methodName = m.getName().toUpperCase();
				if(methodName.startsWith("get") && methodName.endsWith(fieldName)){
					try{
					Object o = m.invoke(obj);
					json += json.equals("") ? "{" + fieldName + " : " +o.toString() :  " , " + fieldName + " : " + o.toString();
					} catch (Throwable t){
						throw t;
					}
				}
				
			}
		}
		json = json.equals("") ? "{}" : json + " }";
		return json;
	}
	
	
}

