import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class MovieSYS {

	public static HashMap<Integer,Movie> movieList = new HashMap<Integer,Movie>();
	
	public static DefaultTableModel getAllMovies(){
		DB.initializeDB();
		String sql="select * from movie";
		DefaultTableModel dtm = DB.showTable(sql);
		return dtm;
	}
	
	public static DefaultTableModel getActors(int id){
		DB.initializeDB();
		String sql="select * from actor where actor.actorid in (select actorid from moviesact where moviesact.movieid="+id+")";
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
	
public static int insert(String name,String year,String genre,String director,String rating) {
		
		String sql = "insert into `ctis252`.`movie` values"+"('"+name+"','"+genre+"','"+year+"','"+director+"','"+rating+"')";
		System.out.println(sql);
		return DB.executeU(sql);
	}
   
	public static int update(int id,String name,String year,String genre,String director,String rating)
	{		
		String sql = "update `ctis252`.`movie` set name='"+name+"', year='"+year+"', genre='"+genre+"', director='"+director+"' where id="+id;
		System.out.println(sql);
		return DB.executeU(sql);			
	}
	
	public static DefaultTableModel delete(int id)
	{
		String sql = "delete from movie where id="+id;
		DB.executeU(sql);
		sql = "select * from movie";	
		DefaultTableModel dtm = DB.showTable(sql);
		return dtm;		
	}

	public static DefaultTableModel find(String key) {
		String sql = "select * from movie where name like '%"+key+"%'";
		System.out.println(sql);
		DefaultTableModel dtm = DB.showTable(sql);
		return dtm;
	}
	
}
