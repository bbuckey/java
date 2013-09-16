package tabstract;

import tapi.IFileT;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.io.FileWriter;
import tabstract.ActionEnumType;

//extends WeakReference<T> 

public abstract class FileT implements IFileT<FileT> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8866352453947666949L;
	/**
	 * 
	 */

	protected String filePath = "";
	protected String actionToDo = "defaultAction";
	protected ActionEnumType aet;
	protected String actionOne = "";
	protected String actionTwo ="";	
	protected FileT(String filepath, String _ActionToDo){filePath = filepath; aet = new ActionEnumType();actionToDo =_ActionToDo; }
	
	protected FileT(String filepath){filePath = filepath; aet = new ActionEnumType();}
	
	public Date fileDate(File file){
		synchronized(file){
		Date lastModified = new Date(file.lastModified());
		return lastModified;
		}
	}
	
	public String filePath(File file){
		synchronized(file){
		String path = file.getAbsolutePath();
		return path;
		}
	}
	
	public void defaultAction(File defaultOutput){
		this.actionOne = defaultOutput.getAbsolutePath();
		this.actionTwo = filePath + File.separator + "secondary_action.txt";
		try {
			defaultOutput.createNewFile();
			FileWriter fw = new FileWriter(defaultOutput);
			String dir = this.filePath;
			File dirLoc = new File(dir);
			if(dirLoc != null && dirLoc.isDirectory()){
				for(File f : dirLoc.listFiles()){
					if(f != null && f.isFile()){
						fw.write(filePath(f) + " " + fileDate(f) + "\n");
					} else if (f.isDirectory()){
						defaultAction(fw, f);
						System.err.println(f.getAbsolutePath());
					}
				}	
			}
			fw.flush();
			fw.close();
			run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void defaultAction(FileWriter fw, File dirLoc){
		try {
			if(dirLoc != null && dirLoc.isDirectory()){
				for(File f : dirLoc.listFiles()){
					if(f != null && f.isFile()){
						fw.write(filePath(f) + " " + fileDate(f) + "\n");
					} else if (f.isDirectory()){
						defaultAction(fw, f);
					}
				}	
			}
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void cleanupHeap(){
		this.actionToDo = null;
		this.aet = null;
		this.filePath = null;
	}
	
	
	public abstract void run();
	
	public abstract FileT getClazzType();
}
