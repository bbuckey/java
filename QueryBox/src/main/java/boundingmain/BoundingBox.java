package boundingmain;

import grid.Grid;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.SocketImplFactory;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.Reader;

public class BoundingBox {
	public ServerSocket sserver;

	public BoundingBox() throws Exception {
		sserver = new ServerSocket(4353, 0);
	}

	public static void main(String[] args) {
		//BoundingBox bb;
		Grid g;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out
					.println("Please enter x and y coordinates in the form upperX,Y, lowerX,Y, upperX2,Y2, lowerX2,Y2:");
			/*
			 * SocketImplFactory si = (SocketImplFactory) new
			 * java.net.ServerSocket(); bb = new BoundingBox();
			 * ServerSocket.setSocketFactory(si); // SocketImplFactory si =
			 * (SocketImplFactory) new java.net.ServerSocket();// =
			 * (SocketImplFactory)new Socket(); //
			 * Socket.setSocketImplFactory(si); Socket s; s =
			 * bb.sserver.accept(); Reader socketInput =new
			 * InputStreamReader(s.getInputStream()); char[] readerChar = new
			 * char[100]; socketInput.read(readerChar);
			 */
			String request = br.readLine();
			/*
			 * = String.copyValueOf(readerChar) ; while(true){
			 * socketInput.read(readerChar); if(readerChar != null &&
			 * readerChar.length > 0){ request +=
			 * String.copyValueOf(readerChar); } else { break; } }
			 */
			String[] box = request.split(",");
			double ux, uy, lx, ly, ux2, uy2, lx2, ly2;
			ux = Double.parseDouble(box[0].trim());
			uy = Double.parseDouble(box[1].trim());
			lx = Double.parseDouble(box[2].trim());
			ly = Double.parseDouble(box[3].trim());
			ux2 = Double.parseDouble(box[4].trim());
			uy2 = Double.parseDouble(box[5].trim());
			lx2 = Double.parseDouble(box[6].trim());
			ly2 = Double.parseDouble(box[7].trim());
			g = new Grid(ux, uy, lx, ly, ux2, uy2, lx2, ly2);
			try {
				FileReader input = new FileReader(new File(
						"sample_data.csv"));
				if (input != null) {
					g.findList(new BufferedReader(input));
				}
				input.close();
			} catch (Throwable t) {
				t.printStackTrace();

			}

			if (g != null && g.getNodeList() != null) {
				try {
					File f = new File("query_results.txt");
					if (!f.exists()) {
						f.createNewFile();
					}
					FileWriter fw = new FileWriter(f);

					g.writeOutList(fw);

					fw.flush();
					fw.close();

					if (fw != null) {
						fw = null;
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
