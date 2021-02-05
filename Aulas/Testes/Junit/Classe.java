package Jotape.test;

public class Classe {
	private int id;
	private String value;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id < 1) throw new IllegalArgumentException();
		this.id = id;
	}
	
	public void kill() {
		try {
			this.finalize();
		} catch (Throwable e) {		
			System.out.println(e.getMessage());
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if(value == null || value == "") throw new IllegalArgumentException();
		this.value = value;
	}
	
}
