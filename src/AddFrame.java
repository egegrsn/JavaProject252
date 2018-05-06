import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField yearTF;
	private JTextField genreTF;
	private JTextField directorTF;
	private JLabel lblRating;
	private JTextField ratingTF;
	private JButton btnNewButton;
	private JPanel panel;
	DefaultTableModel dtm = new DefaultTableModel();
	ActorFrame acf = new ActorFrame(this);
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField idTF;

	
	public AddFrame(MainFrame mf) {
		setTitle("Add Movie Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton addRadioButton = new JRadioButton("Add");
		addRadioButton.setSelected(true);
		buttonGroup.add(addRadioButton);
		addRadioButton.setBounds(316, 13, 69, 25);
		contentPane.add(addRadioButton);
		
		JRadioButton updateRadioButton = new JRadioButton("Update");
		buttonGroup.add(updateRadioButton);
		updateRadioButton.setBounds(393, 13, 127, 25);
		contentPane.add(updateRadioButton);
		
		btnNewButton = new JButton("Add/Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idTF.getText());
				if(addRadioButton.isSelected()){
					int res=MovieSYS.insert(id,nameTF.getText(), yearTF.getText(),genreTF.getText(),directorTF.getText(), ratingTF.getText());
				}
				else{
					
					int res=MovieSYS.update(id,nameTF.getText(), yearTF.getText(),genreTF.getText(),directorTF.getText(), ratingTF.getText());				
				}
				mf.setTableContent();
				dispose();
			}
		});
		btnNewButton.setBounds(322, 47, 133, 52);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(12, 13, 298, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movie name:");
		lblNewLabel.setBounds(23, 63, 118, 16);
		panel.add(lblNewLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(123, 57, 116, 22);
		panel.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(23, 95, 118, 16);
		panel.add(lblYear);
		
		yearTF = new JTextField();
		yearTF.setBounds(123, 89, 116, 22);
		panel.add(yearTF);
		yearTF.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(23, 127, 118, 16);
		panel.add(lblGenre);
		
		genreTF = new JTextField();
		genreTF.setBounds(123, 121, 116, 22);
		panel.add(genreTF);
		genreTF.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(23, 159, 118, 16);
		panel.add(lblDirector);
		
		directorTF = new JTextField();
		directorTF.setBounds(123, 153, 116, 22);
		panel.add(directorTF);
		directorTF.setColumns(10);
		
		lblRating = new JLabel("Rating:");
		lblRating.setBounds(23, 194, 118, 16);
		panel.add(lblRating);
		
		ratingTF = new JTextField();
		ratingTF.setBounds(123, 188, 116, 22);
		panel.add(ratingTF);
		ratingTF.setColumns(10);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(23, 24, 56, 16);
		panel.add(lblId);
		
		idTF = new JTextField();
		idTF.setBounds(123, 22, 116, 22);
		panel.add(idTF);
		idTF.setColumns(10);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(331, 231, 97, 25);
		contentPane.add(btnClose);
		
	
	}
}
