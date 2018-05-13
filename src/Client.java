import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private Socket socket;
	private int port=8000;
	private String host="localhost";
	
	DataOutputStream dos;
	DataInputStream dis ;
	
	public void connectToServer(){
		try {
			socket = new Socket(host, port);
			
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			
			System.out.println("On client side: I/O streams created");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String findArea(String radius){
		String res="";
		
		try {
			dos.writeUTF(radius);
			res = dis.readUTF();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
				
	}

}
