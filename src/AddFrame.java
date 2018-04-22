import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField yearTF;
	private JTextField genreTF;
	private JTextField directorTF;
	private JLabel lblRating;
	private JTextField textField;
	private JButton btnAddActors;
	private JButton btnNewButton;
	private JPanel panel;
	ActorFrame acf = new ActorFrame(this);

	
	public AddFrame(MainFrame mf) {
		setTitle("Add Movie Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Add Movie");
		btnNewButton.setBounds(331, 13, 97, 52);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(12, 13, 298, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movie name:");
		lblNewLabel.setBounds(22, 19, 118, 16);
		panel.add(lblNewLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(122, 13, 116, 22);
		panel.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(22, 51, 118, 16);
		panel.add(lblYear);
		
		yearTF = new JTextField();
		yearTF.setBounds(122, 45, 116, 22);
		panel.add(yearTF);
		yearTF.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(22, 83, 118, 16);
		panel.add(lblGenre);
		
		genreTF = new JTextField();
		genreTF.setBounds(122, 77, 116, 22);
		panel.add(genreTF);
		genreTF.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(22, 115, 118, 16);
		panel.add(lblDirector);
		
		directorTF = new JTextField();
		directorTF.setBounds(122, 109, 116, 22);
		panel.add(directorTF);
		directorTF.setColumns(10);
		
		lblRating = new JLabel("Rating:");
		lblRating.setBounds(22, 150, 118, 16);
		panel.add(lblRating);
		
		textField = new JTextField();
		textField.setBounds(122, 144, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		btnAddActors = new JButton("Add Actors");
		btnAddActors.setBounds(12, 206, 97, 25);
		panel.add(btnAddActors);
	}
}
