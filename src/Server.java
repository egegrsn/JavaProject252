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


		}

	}

	public static void main(String[] args) {
		Server server = new Server();
		System.out.println("Server Status: STOPED");
	}

}
