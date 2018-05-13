
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c = new Client();
		c.connectToServer();
		AuthFrame authf = new AuthFrame(c);
		authf.setVisible(true);
	}

}
