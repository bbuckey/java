package traversal;

import tabstract.FileT;
import tapi.IFileT;

import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;


public class FileTraversal {

	FileTraversal() {
	}

	public static void main(String[] args) {
		FileTraversal ft = new FileTraversal();
		FileT theAction;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out
					.println("Please enter the file path and Action below or type exit to exit.");
			while (true) {
				String actionInput = br.readLine();
				if ("exit".equals(actionInput.trim().toLowerCase())) {
					break;
				}
				String actionInput2;
				actionInput2 = (new String(actionInput.substring(actionInput
						.lastIndexOf(" ")))).trim();
				actionInput = (actionInput.substring(0,
						actionInput.lastIndexOf(" "))).trim();
				if (actionInput != null && actionInput2 != null) {
					theAction = (FileT) ft.getActionToUse(actionInput,
							actionInput2);
					File f = new File(actionInput);
					theAction.defaultAction(new File(f.getAbsolutePath()
							+ File.separator + "file_list.txt"));
					f = null;
					System.out
							.println("Please enter the file path and Action below or type exit to exit.");
				} else {
					System.out
							.println("Please make sure you have entered the file path and an Action below or type exit to exit.\n");
				}
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	public IFileT<? extends FileT> getActionToUse(String path, String action) {
		Class cl;
		FileT ft = null;
		
		String clazz , pack;
		
		try {
			 clazz = (new String(action.substring(action
						.lastIndexOf(".")))).trim();
			 pack = (action.substring(0,
						action.lastIndexOf("."))).trim();
			cl = getClass().getClassLoader().loadClass(action);
			System.err.println(cl.getCanonicalName());
			Constructor[] m = cl.getConstructors();
			ft = (FileT) m[0].newInstance(path);
		} catch (Throwable t){
			t.printStackTrace();
		} finally {
			if(ft == null){
				ft = new DefaultActionToDo(path, action);
			}
			return ft;
		}

	}

	protected class DefaultActionToDo extends FileT {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1264222181028073154L;

		DefaultActionToDo(String path) {
			super(path);
		}

		DefaultActionToDo(String path, String action) {
			super(path, action);
		}

		@Override
		public void run() {
			return;
		}

		@Override
		public DefaultActionToDo getClazzType() {
			return this;
		}

	}

}
