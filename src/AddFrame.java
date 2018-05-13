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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField yearTF;
	private JTextField genreTF;
	private JTextField directorTF;
	private JLabel lblRating;
	private JTextField ratingTF;
	private JButton AddUpdateBtn;
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
		JPanel idPanel = new JPanel();
		
		
		AddUpdateBtn = new JButton("Add");
		AddUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idTF.getText());
				if(addRadioButton.isSelected()){
					int res=MovieSYS.insert(nameTF.getText(), yearTF.getText(),genreTF.getText(),directorTF.getText(), ratingTF.getText());
				}
				else{
					if(!idTF.getText().isEmpty()){
						int res=MovieSYS.update(id,nameTF.getText(), yearTF.getText(),genreTF.getText(),directorTF.getText(), ratingTF.getText());				
					}
					
				}
				mf.setTableContent();
				dispose();
			}
		});
		AddUpdateBtn.setBounds(321, 93, 133, 52);
		contentPane.add(AddUpdateBtn);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(12, 13, 298, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movie name:");
		lblNewLabel.setBounds(29, 83, 118, 16);
		panel.add(lblNewLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(129, 77, 116, 22);
		panel.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(29, 115, 118, 16);
		panel.add(lblYear);
		
		yearTF = new JTextField();
		yearTF.setBounds(129, 109, 116, 22);
		panel.add(yearTF);
		yearTF.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(29, 147, 118, 16);
		panel.add(lblGenre);
		
		genreTF = new JTextField();
		genreTF.setBounds(129, 141, 116, 22);
		panel.add(genreTF);
		genreTF.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(29, 179, 118, 16);
		panel.add(lblDirector);
		
		directorTF = new JTextField();
		directorTF.setBounds(129, 173, 116, 22);
		panel.add(directorTF);
		directorTF.setColumns(10);
		
		lblRating = new JLabel("Rating:");
		lblRating.setBounds(29, 214, 118, 16);
		panel.add(lblRating);
		
		ratingTF = new JTextField();
		ratingTF.setBounds(129, 208, 116, 22);
		panel.add(ratingTF);
		ratingTF.setColumns(10);
		
		
		addRadioButton.setBounds(29, 9, 69, 25);
		panel.add(addRadioButton);
		addRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					idPanel.setVisible(false);
					AddUpdateBtn.setText("Add");
			}
		});
		addRadioButton.setSelected(true);
		buttonGroup.add(addRadioButton);
		
		JRadioButton updateRadioButton = new JRadioButton("Update");
		updateRadioButton.setBounds(106, 9, 127, 25);
		panel.add(updateRadioButton);
		updateRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idPanel.setVisible(true);
				AddUpdateBtn.setText("Update");
			}
		});
		buttonGroup.add(updateRadioButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(331, 231, 97, 25);
		contentPane.add(btnClose);
	
		idPanel.setBounds(322, 13, 188, 52);
		contentPane.add(idPanel);
		idPanel.setVisible(false);
		idPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		idPanel.setLayout(null);
		
		idTF = new JTextField();
		idTF.setBounds(53, 13, 116, 22);
		idPanel.add(idTF);
		idTF.setColumns(10);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(12, 16, 56, 16);
		idPanel.add(lblId);

	
	
	}
}
