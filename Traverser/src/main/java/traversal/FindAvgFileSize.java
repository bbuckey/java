package traversal;

import java.util.List;
import java.util.ArrayList;
import tabstract.FileT;
import java.io.File;
import java.io.FileWriter;

public class FindAvgFileSize extends FileT{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7168389583990683726L;
	
	List<Long> fileList = new ArrayList<Long>();
	
	public FindAvgFileSize(String filepath){
		super(filepath);
		super.actionToDo = "averageFileSize";
	}
	
	public FindAvgFileSize(String filepath, String actionToDo){
		super(filepath,actionToDo);
	}
	
	public synchronized void addFileToList(File file){
		fileList.add(file.length());	
	}
	
	public synchronized long getTotalFileSize(){
		long totalSize =0;
		for(long sz : fileList){
			totalSize += sz;
		}
		return totalSize;
	}
	
	public long avgSize(){
		if(fileList != null && !fileList.isEmpty()){
			return getTotalFileSize()/fileList.size();
		} else {
			return 0;
		}
	}
	
	
	@Override
	public void run(){
		try {
		File sf = new File(actionTwo);
		System.err.println(actionTwo);
		sf.createNewFile();
		FileWriter fw = new FileWriter(sf);
		String dir = super.filePath;
		File dirLoc = new File(dir);
		if(dirLoc != null && dirLoc.isDirectory()){
			for(File f : dirLoc.listFiles()){
				if(f != null && f.isFile()){
					addFileToList(f);
				}	
			}	
		}
		fw.write("The Average File Size: " + avgSize());
		fw.flush();
		fw.close();
		System.out.println("The Average File Size: " + avgSize());
		} catch (Throwable t){
			t.printStackTrace();
		}
	}

	@Override
	public FindAvgFileSize getClazzType() {
		return this;
	}
	
	@Override
	public void cleanupHeap(){
		this.fileList.clear();
		this.fileList = null;
		super.cleanupHeap();
	}
	
}
