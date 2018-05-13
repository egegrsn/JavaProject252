import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DB {
	private static Connection connection=null;
	private static Statement statement=null;
	
	public static void initializeDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MYSQL DBMS connection provided");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/252project","std","");
			System.out.println("Database connection is provided");
			
			statement = connection.createStatement();
			System.out.println("Statement object created");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	public static ResultSet executeQ(String sql) {
		ResultSet rs=null;
		try {
			rs = statement.executeQuery(sql); //select * from student
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	
	public static int executeU(String sql) {
		int res=0;
		try {
			res = statement.executeUpdate(sql); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static DefaultTableModel showTable(String sql){
		
		//Assume that sql is aselect type of sql statemnt
		DefaultTableModel dtm=null;

		try {
			ResultSet rs = statement.executeQuery(sql);
			if(rs !=null){
				dtm = new DefaultTableModel();
				Vector header = new Vector();
				Vector rows = new Vector();
				
				ResultSetMetaData rsmd = rs.getMetaData();
				int numOfFiled = rsmd.getColumnCount();
				for(int i=1; i<=numOfFiled; i++){
					header.add(rsmd.getColumnName(i));
				
				}
				while(rs.next()){
					Vector  row = new Vector();
					for(int i=1; i<=numOfFiled; i++){						
						row.add(rs.getObject(i));
					}
					rows.add(row);
				}
				
				dtm.setDataVector(rows, header);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dtm;
	}
	
	public static Vector<String> getTableNames(String sql ){
		
		Vector<String> tablenames=new Vector<String>();
		
		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				tablenames.add(rs.getString(1));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (tablenames);
	}

	public static Vector getCoulumnAt(String sql, int index) {
		Vector<String> typenames=new Vector<String>();		

		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				typenames.add(rs.getString(index));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return (typenames);		
	}
	
	public static DefaultComboBoxModel<String> getColumnAtToFillComboBox(String sql, int index) {		
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel();
		
		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){					
				dcbm.addElement(rs.getString(index));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (dcbm);		
	}
}