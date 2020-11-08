package controller;
import java.util.Date;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;

public class Database {
	private JdbcTemplate jdbc;
	private String table = "create table if not exists";
	private String tableName;	
	private List<Integer> ids;
	private List<String> names;
	private List<Date> records;
	private int size = 0;
	
	public Database(JdbcTemplate jdbc,String tableName) {
		this.jdbc = jdbc;
		this.tableName = tableName;
		this.table += " "+tableName;	
		this.createTable();
		this.charge();
	}
	
	private void createTable() {
		try {
			String query = this.table;
			query += " (";
			query += "id serial primary key,";
			query += "name varchar(50) not null,";
			query += "recorded date not null";
			query +=");";		
			jdbc.execute(query);
			System.out.println("Table OK!");
		}catch(Exception e) {
			System.err.println("Problem on database table: "+e.getMessage());
		}		
	}
	
	public int insert(String name, Date recorded) {
		try {
			String sql = "insert into cliente (name,recorded) values (?,?);";
			return jdbc.update(sql,new Object[] {name, recorded});
		}catch(Exception e) {
			System.err.println("Problem on insert into database: "+e.getMessage());
			return -1;
		}
	}
	
	public void charge(){
		try {			
			this.ids = jdbc.queryForList("select id from "+this.tableName,Integer.class);		
			this.names = jdbc.queryForList("select name from "+this.tableName,String.class);
			this.records = jdbc.queryForList("select recorded from "+this.tableName,Date.class);
			if(this.ids.size() != this.names.size()) throw new java.lang.ExceptionInInitializerError("Error on charge list: Wrong on ids and names size");
			if(this.ids.size() != this.records.size()) throw new java.lang.ExceptionInInitializerError("Error on charge list: Wrong on ids and records size");
			this.size = this.ids.size();
			System.out.print("Database charged");
		}catch(Exception e) {
			System.err.print("Problem on reading databases: "+e.getMessage());			
		}		
	}		
	
	public List<Integer> getIds(){
		return this.ids;
	}
	
	public List<String> getNames(){
		return this.names;
	}
	
	public List<Date> getRecords(){
		return this.records;
	}
	
	public int size() {
		return this.size;
	}
	
}
