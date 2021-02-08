package Springann.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Bean2 {
	private String valor;
	public Bean2(String valor) {
		this.setValor(valor);
	}
	public String getValor() {
		return "Valor do bean interno é: " +valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@PostConstruct
	public void exibir() {
		System.out.println("Executando @PostConstruct do Bean Interno");
	}
	
	@PreDestroy
	public void destroir() {
		System.out.println("Executando @PreDestroy do Bean Interno");
	}
}
