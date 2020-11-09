package model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
	private int id;
	private String name;
	private Date recorded;
	public int getId() {
		return id;
	}
	
	public Person() {
		this.name = "";
		this.id = 0;
		this.recorded = null;
	}
	
	public Person(int id, String name,Date date) {
		this.id = id;
		this.name = name;
		this.recorded = date;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return recorded;
	}
	public void setDate(Date date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			this.recorded = format.parse(format.format(date));
		}catch(Exception error) {
			System.err.print("Error on date: "+error.getMessage());
		}		
	}
	
	@Override
	public boolean equals(Object obj) {	
		Person person = (Person) obj;
		return (this.id == person.id) ? true : false;
	}	
	
	@Override
	public String toString() {
		return "ID: "+this.id+", Name:"+this.name;		
	}
	
	
}
