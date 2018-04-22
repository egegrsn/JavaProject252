import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	AddFrame af = new AddFrame(this);
	private static JTable table;
	private JTextField deleteTF;
	

	public MainFrame() {
		setTitle("Movie Archive");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(12, 105, 412, 273);
		contentPane.add(scrollPane);

	
		
		setTable(new JTable());
		scrollPane.setColumnHeaderView(getTable());
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(436, 105, 144, 93);
		contentPane.add(panel_1);
		
		JLabel lblOrderBy = new JLabel("Order Movies:");
		lblOrderBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrderBy.setBounds(6, 7, 101, 17);
		panel_1.add(lblOrderBy);
		
		JComboBox OrderComboBox = new JComboBox();
		OrderComboBox.setBounds(6, 46, 131, 22);
		panel_1.add(OrderComboBox);
		
		JButton btnShow = new JButton("SHOW MOVIES");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DB.initializeDB();
				DefaultTableModel dtm = MovieSYS.getAllMovies();
				getTable().setModel(dtm);
			}
		});
		btnShow.setBounds(12, 26, 144, 51);
		contentPane.add(btnShow);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(436, 210, 149, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblChooseMovie = new JLabel("Choose a Movie:");
		lblChooseMovie.setBounds(6, 7, 101, 17);
		panel.add(lblChooseMovie);
		lblChooseMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox MovieListComboBox = new JComboBox();
		MovieListComboBox.setBounds(6, 46, 131, 22);
		panel.add(MovieListComboBox);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				af.setVisible(true);
			}
		});
		btnAdd.setBounds(436, 64, 144, 25);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(deleteTF.getText());
			MovieSYS.delete(id);
			DefaultTableModel dtm = MovieSYS.getAllMovies();
			getTable().setModel(dtm);
			}
		});
		btnDelete.setBounds(441, 353, 144, 25);
		contentPane.add(btnDelete);
		
		DefaultComboBoxModel dcbm = MovieSYS.getItemsToFillComboBox(2);
		MovieListComboBox.setModel(dcbm);
		
		deleteTF = new JTextField();
		deleteTF.setBounds(446, 318, 116, 22);
		contentPane.add(deleteTF);
		deleteTF.setColumns(10);
			
		
		
	}


	public static JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}
}
