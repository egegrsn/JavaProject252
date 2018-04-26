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
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	AddFrame af = new AddFrame(this);
	private JTable table;
	private JTextField deleteTF;
	DefaultTableModel dtm = new DefaultTableModel();
	private JScrollPane scrollPane;
	

	public MainFrame() {
		setTitle("Movie Archive");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 31, 781, 129);
		contentPane.add(scrollPane);

	
		
		table= new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setLayout(null);
		orderPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		orderPanel.setBounds(12, 183, 229, 129);
		contentPane.add(orderPanel);
		
		JLabel lblOrderBy = new JLabel("Order Movies:");
		lblOrderBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrderBy.setBounds(6, 7, 101, 17);
		orderPanel.add(lblOrderBy);
		
		JComboBox OrderComboBox = new JComboBox();
		OrderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Id", "Name", "Genre", "Year", "Director", "Rating Ascending", "Rating Descending"}));
		OrderComboBox.setSelectedIndex(0);
		OrderComboBox.setBounds(6, 46, 131, 22);
		orderPanel.add(OrderComboBox);
		
		JButton orderBtn = new JButton("Order");
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = OrderComboBox.getSelectedItem().toString();
				String sql;
				if(selected.equalsIgnoreCase("Rating Descending")){
					sql = "select * from movie order by rating DESC";
				}
				else if(selected.equalsIgnoreCase("Rating Ascending")){
					sql = "select * from movie order by rating ASC";
				}
				else{
					sql = "select * from movie order by "+selected;
				}
				
				dtm = DB.showTable(sql);
				table.setModel(dtm);
				
			}
		});
		orderBtn.setBounds(10, 91, 97, 25);
		orderPanel.add(orderBtn);
		
		
		JPanel choosePanel = new JPanel();
		choosePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		choosePanel.setBounds(253, 183, 229, 129);
		contentPane.add(choosePanel);
		choosePanel.setLayout(null);
		
		JLabel lblChooseMovie = new JLabel("Choose a Movie:");
		lblChooseMovie.setBounds(6, 7, 101, 17);
		choosePanel.add(lblChooseMovie);
		lblChooseMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox MovieListComboBox = new JComboBox();
		MovieListComboBox.setBounds(6, 46, 193, 22);
		choosePanel.add(MovieListComboBox);
		
		JButton btnAdd = new JButton("Add Movie");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				af.setVisible(true);
			}
		});
		btnAdd.setBounds(494, 287, 144, 25);
		contentPane.add(btnAdd);
		
		DefaultComboBoxModel dcbm = MovieSYS.getItemsToFillComboBox(2);
		MovieListComboBox.setModel(dcbm);
		
		JButton btnNewButton = new JButton("Show Movie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 91, 155, 25);
		choosePanel.add(btnNewButton);
		
		JPanel deletePanel = new JPanel();
		deletePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		deletePanel.setBounds(494, 184, 229, 90);
		contentPane.add(deletePanel);
		deletePanel.setLayout(null);
		
		deleteTF = new JTextField();
		deleteTF.setBounds(44, 13, 116, 22);
		deletePanel.add(deleteTF);
		deleteTF.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(12, 48, 75, 25);
		deletePanel.add(btnDelete);
		
		JLabel lblid = new JLabel("ID:");
		lblid.setBounds(12, 16, 34, 16);
		deletePanel.add(lblid);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(deleteTF.getText());
			dtm = MovieSYS.delete(id);
			table.setModel(dtm);
			}
		});
			
		setTableContent();
		
	}
	

	public void setTableContent(){
		DefaultTableModel dtm = MovieSYS.getAllMovies();
		table.setModel(dtm);
	}
	

}
