import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class MovieSYS {

	public static HashMap<Integer,Movie> movieList = new HashMap<Integer,Movie>();
	
	public static DefaultTableModel getAllMovies(){
		String sql="select * from student";
		DefaultTableModel dtm = DB.showTable(sql);
		return dtm;
	}
	
	public static DefaultComboBoxModel getItemsToFillComboBox(int colum) {
		DB.initializeDB();
		String sql = "select * from movie"; 		
		DefaultComboBoxModel dcbm =DB.getColumnAtToFillComboBox("select * from movie", colum);
		
		DB.close();
		
		return dcbm;
	}
	
public static int insert(int id,String name,String year,String genre,String director,String rating) {
		
		String query = "insert into ctis252.movie values"+"("+id+",'"+name+"','"+year+"','"+genre+"','"+director+"','"+rating+"')"; //query needs to change.
		System.out.println(query);
		return DB.executeU(query);
	}
   
	public static int update(int id,String name,String year,String genre,String director,String rating)
	{		
		String query = "update movie set name='"+name+"', year='"+year+"', genre='"+genre+"', director='"+director+"' where id="+id;//query needs to change.
		System.out.println(query);
		return DB.executeU(query);
	}
	
	public static int delete(int id)
	{
	
		String query = "delete from movie where id=" + id;	
		return DB.executeU(query);
	}

	
}
