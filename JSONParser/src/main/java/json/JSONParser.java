package json;

import json.IJSONParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public abstract class JSONParser  implements IJSONParser<JSONParser> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Map parse(BufferedReader sr)throws Exception{
		Map map = new HashMap();
		List v = new LinkedList();
		Class cl;
		Object ft;
		while(true){
			try{
			String line = sr.readLine();
			if(line == null ){
				break;
			}
			if(line.isEmpty()){
			line = sr.readLine();
			}
			if(line.indexOf("{") < line.indexOf(":")){
				line = line.substring(line.indexOf("{")+1, line.lastIndexOf("}"));
			}
			if(line.contains(",")){
				for(String jstr : line.split(",")){
			String obj = jstr.substring(0, jstr.indexOf(":")).trim().replace("\"", "");
			String val = jstr.substring(jstr.indexOf(":")).trim().replace("\"", "");
	/*		cl = getClass().getClassLoader().loadClass(obj);
			System.err.println(cl.getCanonicalName());
			Constructor[] m = cl.getConstructors();
			ft = (Object) m[0].newInstance(val);
			v.add(ft);*/
			map.put(obj, val);
				}
			} else {
				String obj = line.substring(0, line.indexOf(":")).trim().replace("\"", "");
				String val = line.substring(line.indexOf(":")).trim().replace("\"", "");
/*				cl = getClass().getClassLoader().loadClass(obj);
				System.err.println(cl.getCanonicalName());
				Constructor[] m = cl.getConstructors();
				ft = (Object) m[0].newInstance(val);
				v.add(ft);*/
				map.put(obj, val);
			}
			} catch (Throwable t){
				t.printStackTrace();
				break;
			}
		}
		return map;
	}
	
	protected Map parse(String sr)throws Exception{
		Map map = new HashMap();
		List v = new LinkedList();
		Class cl;
		Object ft;
		while(true){
			try{
				if(sr == null || sr.isEmpty()){
					break;
				}
				if(sr.indexOf("{") < sr.indexOf(":")){
					sr = sr.substring(sr.indexOf("{")+1, sr.lastIndexOf("}"));
				}
				if(sr.contains(",")){
					for(String jstr : sr.split(",")){
				String obj = jstr.substring(0, jstr.indexOf(":")).trim().replace("\"", "");
				String val = jstr.substring(jstr.indexOf(":")).trim().replace("\"", "");
/*				cl = getClass().getClassLoader().loadClass(obj);
				System.err.println(cl.getCanonicalName());
				Constructor[] m = cl.getConstructors();
				ft = (Object) m[0].newInstance(val);
				v.add(ft);*/
				map.put(obj, val);
					}
				} else {
					String obj = sr.substring(0, sr.indexOf(":")).trim().replace("\"", "");
					String val = sr.substring(sr.indexOf(":")).trim().replace("\"", "");
	/*				cl = getClass().getClassLoader().loadClass(obj);
					System.err.println(cl.getCanonicalName());
					Constructor[] m = cl.getConstructors();
					ft = (Object) m[0].newInstance(val);
					v.add(ft);*/
					map.put(obj, val);
				}
			} catch (Throwable t){
				t.printStackTrace();
				break;
			}
		}
		return mqp;
	}
	
	protected Map parse(FileReader sr)throws Exception{
		Map map = new HashMap();
		List v = new LinkedList();
		Class cl;
		Object ft;
		BufferedReader br = new BufferedReader(sr);
		while(true){
			try{
			String line = br.readLine();
			if(line == null ){
				break;
			}
			if(line.isEmpty()){
			line = br.readLine();
			}
			if(line.indexOf("{") < line.indexOf(":")){
				line = line.substring(line.indexOf("{")+1, line.lastIndexOf("}"));
			}
			if(line.contains(",")){
				for(String jstr : line.split(",")){
			String obj = jstr.substring(0, jstr.indexOf(":")).trim().replace("\"", "");
			String val = jstr.substring(jstr.indexOf(":")).trim().replace("\"", "");
/*			cl = getClass().getClassLoader().loadClass(obj);
			System.err.println(cl.getCanonicalName());
			Constructor[] m = cl.getConstructors();
			ft = (Object) m[0].newInstance(val);
			v.add(ft);*/
			map.put(obj, val);
				}
			} else {
				String obj = line.substring(0, line.indexOf(":")).trim().replace("\"", "");
				String val = line.substring(line.indexOf(":")).trim().replace("\"", "");
	/*			cl = getClass().getClassLoader().loadClass(obj);
				System.err.println(cl.getCanonicalName());
				Constructor[] m = cl.getConstructors();
				ft = (Object) m[0].newInstance(val);
				v.add(ft);*/
				map.put(obj, val);
			}
			} catch (Throwable t){
				t.printStackTrace();
				break;
			}
		}
		return map;
	}
	
	protected Map parse(InputStreamReader sr)throws Exception{
		Map map = new HashMap();
		List v = new LinkedList();
		Class cl;
		Object ft;
		BufferedReader br = new BufferedReader(sr);
		while(true){
			try{ 
			String line = br.readLine();
			if(line == null ){
				break;
			}
			if(line.isEmpty()){
			line = br.readLine();
			}
			if(line.indexOf("{") < line.indexOf(":")){
				line = line.substring(line.indexOf("{")+1, line.lastIndexOf("}"));
			}
			if(line.contains(",")){
				for(String jstr : line.split(",")){
			String obj = jstr.substring(0, jstr.indexOf(":")).trim().replace("\"", "");
			String val = jstr.substring(jstr.indexOf(":")).trim().replace("\"", "");
/*			cl = getClass().getClassLoader().loadClass(obj);
			System.err.println(cl.getCanonicalName());
			Constructor[] m = cl.getConstructors();
			ft = (Object) m[0].newInstance(val);
			v.add(ft);*/
			map.put(obj, val);
				}
			} else {
				String obj = line.substring(0, line.indexOf(":")).trim().replace("\"", "");
				String val = line.substring(line.indexOf(":")).trim().replace("\"", "");
		/*		cl = getClass().getClassLoader().loadClass(obj);
				System.err.println(cl.getCanonicalName());
				Constructor[] m = cl.getConstructors();
				ft = (Object) m[0].newInstance(val);
				v.add(ft);*/
				map.put(obj, val);
			}
			} catch (Throwable t){
				t.printStackTrace();
				break;
			}
		}
		return map;
	}
	
}
