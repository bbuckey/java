

import ar.com.hjg.pngj.ChunkReader;
import ar.com.hjg.pngj.PngReader;
import ar.com.hjg.pngj.IImageLine;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class pngviewwer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("/users/badmin/desktop/UIApplicationAutomaticSnapshotDefault-Portrait@2x.png");
		PngReader pr = new PngReader(f);
		IImageLine ii = pr.readRow();
		List<IImageLine> pnglist =  new ArrayList<IImageLine>();
		
	}

}
