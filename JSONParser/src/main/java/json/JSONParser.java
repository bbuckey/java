package json;

import json.IJSONParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.LinkedList;



public abstract class JSONParser implements IJSONParser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List parse(BufferedReader sr){
		List v = new LinkedList();
		Class cl;
		Object ft;
		while(true){
			try{
			String line = sr.readLine();
			if(line.contains(";")){
				for(String jstr : line.split(";")){
			String obj = jstr.substring(0, jstr.indexOf(":")).trim();
			String val = jstr.substring(jstr.indexOf(":")).trim();
			cl = getClass().getClassLoader().loadClass(obj);
			System.err.println(cl.getCanonicalName());
			Constructor[] m = cl.getConstructors();
			if(val.contains(",")){
			ft = (Object) m[0].newInstance(val.split(","));
			} else {
				ft = (Object) m[0].newInstance(val);
			}
			v.add(ft);
				}
			} else {
				String obj = line.substring(0, line.indexOf(":")).trim();
				String val = line.substring(line.indexOf(":")).trim();
				cl = getClass().getClassLoader().loadClass(obj);
				System.err.println(cl.getCanonicalName());
				Constructor[] m = cl.getConstructors();
				if(val.contains(",")){
				ft = (Object) m[0].newInstance(val.split(","));
				} else {
					ft = (Object) m[0].newInstance(val);
				}
				v.add(ft);
			}
			} catch (Throwable t){
				t.printStackTrace();
			}finally {
				break;
			}
		}
		return v;
	}
	
	public List parse(String sr){
		List v = new LinkedList();
		Class cl;
		Object ft;
		while(true){
			try{
				if(sr.contains(";")){
					for(String jstr : sr.split(";")){
				String obj = jstr.substring(0, jstr.indexOf(":")).trim();
				String val = jstr.substring(jstr.indexOf(":")).trim();
				cl = getClass().getClassLoader().loadClass(obj);
				System.err.println(cl.getCanonicalName());
				Constructor[] m = cl.getConstructors();
				if(val.contains(",")){
				ft = (Object) m[0].newInstance(val.split(","));
				} else {
					ft = (Object) m[0].newInstance(val);
				}
				v.add(ft);
					}
				} else {
					String obj = sr.substring(0, sr.indexOf(":")).trim();
					String val = sr.substring(sr.indexOf(":")).trim();
					cl = getClass().getClassLoader().loadClass(obj);
					System.err.println(cl.getCanonicalName());
					Constructor[] m = cl.getConstructors();
					if(val.contains(",")){
					ft = (Object) m[0].newInstance(val.split(","));
					} else {
						ft = (Object) m[0].newInstance(val);
					}
					v.add(ft);
				}
			} catch (Throwable t){
				t.printStackTrace();
			}finally {
				break;
			}
		}
		return v;
	}
	
	public List parse(FileReader sr){
		List v = new LinkedList();
		Class cl;
		Object ft;
		BufferedReader br = new BufferedReader(sr);
		while(true){
			try{
			String line = br.readLine();
			if(line.contains(";")){
				for(String jstr : line.split(";")){
			String obj = jstr.substring(0, jstr.indexOf(":")).trim();
			String val = jstr.substring(jstr.indexOf(":")).trim();
			cl = getClass().getClassLoader().loadClass(obj);
			System.err.println(cl.getCanonicalName());
			Constructor[] m = cl.getConstructors();
			if(val.contains(",")){
			ft = (Object) m[0].newInstance(val.split(","));
			} else {
				ft = (Object) m[0].newInstance(val);
			}
			v.add(ft);
				}
			} else {
				String obj = line.substring(0, line.indexOf(":")).trim();
				String val = line.substring(line.indexOf(":")).trim();
				cl = getClass().getClassLoader().loadClass(obj);
				System.err.println(cl.getCanonicalName());
				Constructor[] m = cl.getConstructors();
				if(val.contains(",")){
				ft = (Object) m[0].newInstance(val.split(","));
				} else {
					ft = (Object) m[0].newInstance(val);
				}
				v.add(ft);
			}
			} catch (Throwable t){
				t.printStackTrace();
			}finally {
				break;
			}
		}
		return v;
	}
	
	public List parse(InputStreamReader sr){
		List v = new LinkedList();
		Class cl;
		Object ft;
		BufferedReader br = new BufferedReader(sr);
		while(true){
			try{ 
			String line = br.readLine();
			if(line.contains(";")){
				for(String jstr : line.split(";")){
			String obj = jstr.substring(0, jstr.indexOf(":")).trim();
			String val = jstr.substring(jstr.indexOf(":")).trim();
			cl = getClass().getClassLoader().loadClass(obj);
			System.err.println(cl.getCanonicalName());
			Constructor[] m = cl.getConstructors();
			if(val.contains(",")){
			ft = (Object) m[0].newInstance(val.split(","));
			} else {
				ft = (Object) m[0].newInstance(val);
			}
			v.add(ft);
				}
			} else {
				String obj = line.substring(0, line.indexOf(":")).trim();
				String val = line.substring(line.indexOf(":")).trim();
				cl = getClass().getClassLoader().loadClass(obj);
				System.err.println(cl.getCanonicalName());
				Constructor[] m = cl.getConstructors();
				if(val.contains(",")){
				ft = (Object) m[0].newInstance(val.split(","));
				} else {
					ft = (Object) m[0].newInstance(val);
				}
				v.add(ft);
			}
			} catch (Throwable t){
				t.printStackTrace();
			}finally {
				break;
			}
		}
		return v;
	}
	
}
