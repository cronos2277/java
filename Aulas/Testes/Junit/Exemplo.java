package Jotape.test;

public class Exemplo {
	private int id;
	private String value;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {		
		if(id < 1) throw new RuntimeException();
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if(value == null) throw new NullPointerException();
		if(value == "" || value.trim().length() == 0) throw new NullPointerException();
		if(value.matches("\\d+")) throw new RuntimeException();
		this.value = value;
	}
}
