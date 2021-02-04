package Jotape.test;

public class Modelo {
	private String value;
	private int id;
	private double numero;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(this.isNotBiggerThanZero(id)) {
			throw new IllegalArgumentException();
		}
		
		this.id = id;
	}

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		if(this.isNotBiggerThanZero(numero)) {
			throw new IllegalArgumentException();
		}
		
		this.numero = numero;
	}
	
	private boolean isNotBiggerThanZero(double num) {
		if(num < 0) return false;
		else return true;
	}
	
	private boolean isNotBiggerThanZero(int num) {
		if(num < 1) return false;
		else return true;
	}	
}
