import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class AuthFrame extends JFrame {

	Client client;
	private JPanel contentPane;
	private JTextField usernameTF;
	private JTextField passwordTF;
	MainFrame mf = new MainFrame(this);
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public AuthFrame(Client c) {
		
		setTitle("Movie Archive Login Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("T\u00FCrk\u00E7e");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(72, 27, 67, 25);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("English");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBounds(190, 27, 76, 25);
		contentPane.add(rdbtnNewRadioButton_1);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(42, 245, 308, 167);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel UsernameLbl = new JLabel("Username:");
		UsernameLbl.setBounds(32, 15, 124, 16);
		panel.add(UsernameLbl);
		UsernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel PasswordLbl = new JLabel("Password:");
		PasswordLbl.setBounds(32, 42, 124, 16);
		panel.add(PasswordLbl);
		PasswordLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));

		usernameTF = new JTextField();
		usernameTF.setBounds(168, 13, 116, 22);
		panel.add(usernameTF);
		usernameTF.setColumns(10);

		passwordTF = new JPasswordField();
		passwordTF.setBounds(168, 42, 116, 22);
		panel.add(passwordTF);
		passwordTF.setColumns(10);

		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = usernameTF.getText();
				String pass = passwordTF.getText();
				String sql = "select * from auth where username like '%" + name + "%'";
				ResultSet rs = DB.executeQ(sql);
				try {
					if (rs != null) {
						if (rs.next()) {
							if (rs.getString(1).equals(name) && rs.getString(2).equals(pass)) {
								mf.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(panel, "Username or password is wrong!! Try Again.");
							}
						}
						else{
							JOptionPane.showMessageDialog(panel, "Username or password is wrong!! Try Again.");
						}
					}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		loginBtn.setBounds(69, 93, 97, 25);
		panel.add(loginBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(42, 64, 308, 167);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel imageLbl = new JLabel("");
		panel_1.add(imageLbl);
		
		ImageIcon image = new ImageIcon(getClass().getResource("imaj.jpg"));
		imageLbl.setIcon(image);
		
		
	}
}
