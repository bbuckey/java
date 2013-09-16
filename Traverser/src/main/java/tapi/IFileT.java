package tapi;

import java.io.Serializable;

public interface IFileT<T> extends Runnable, Serializable {

	public abstract T getClazzType();
	public abstract void cleanupHeap();
	
}
