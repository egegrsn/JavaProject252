import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int portNumber = 8000;

	public Server() {
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			System.out.println("Server started");

			System.out.println("Server status: waiting for client connection");
			while (true) {
				Socket clientSocket = serverSocket.accept();

				ClientThreadTaskClass clientTask = new ClientThreadTaskClass(clientSocket);
				Thread clientThread = new Thread(clientTask);
				clientThread.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	class ClientThreadTaskClass implements Runnable {
		Socket clientSocket;
		DataOutputStream dos;
		DataInputStream dis;

		public ClientThreadTaskClass(Socket clientSocket) {
			this.clientSocket = clientSocket;

			System.out.println("Server status: Client connected" + clientSocket.getInetAddress().toString());
			try {
				dos = new DataOutputStream(clientSocket.getOutputStream());

				dis = new DataInputStream(clientSocket.getInputStream());

				System.out.println("Server Status : I/O streams created for the client"
						+ clientSocket.getInetAddress().toString());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		@Override
		public void run() {

			System.out.println("Server Status: waiting for radius from client");
			int radius;
			try {
				radius = Integer.parseInt(dis.readUTF());
				System.out.println(
						"Server Status: radius is taken from client" + clientSocket.getInetAddress().toString());
				double area = radius * radius * Math.PI;
				dos.writeUTF("Area of circle with " + radius + " radius : " + area);
				System.out.println("Area send to client" + clientSocket.getInetAddress().toString());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("END of service for client" + clientSocket.getInetAddress().toString());

		}

	}

	public static void main(String[] args) {
		Server server = new Server();
		System.out.println("Server Status: STOPED");
	}

}
