package pattern.model;

import java.sql.SQLException;

public class Dao {
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() {
		return dao;
	}
	
	public NoteBook findNoteBook(String model) throws SQLException{
		//디비 연결 되었다고 가정하고 
		System.out.println(model);
		NoteBook notebook = new NoteBook(model, 1500000);
		
		return notebook;
	}
}
