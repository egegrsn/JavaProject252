import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	AddFrame af = new AddFrame(this);
	

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
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JButton btnShow = new JButton("SHOW MOVIES");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnAdd.setBounds(441, 315, 144, 25);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(441, 353, 144, 25);
		contentPane.add(btnDelete);
		
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
	}
}
