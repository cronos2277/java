package Jotape.test;

public class Bean {
	private int id;
	private String nome;
	
	public void setNome(String nome) {	
		if(
				nome.isEmpty() || 
				nome.matches("\\d+") ||
				nome.trim().length() < 4
		) {
			throw new RuntimeException();
		}
		this.nome = nome;
	}
	
	public String getNome() {		
		return this.nome;
	}
	
	public void setId(int id) {	
		if(id < 1) throw new RuntimeException();
		this.id = id;
	}

}
