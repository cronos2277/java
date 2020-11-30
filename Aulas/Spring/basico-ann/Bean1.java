package Springann.annotations;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bean1 {
	private long id;
	private String value;
	
	@Autowired
	private Bean2 bean2;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@PostConstruct
	public void exibir() {
		System.out.println("Executando @PostConstruct do Bean Externo");
	}
	
	@PreDestroy
	public void destroir() {
		System.out.println("Executando @PreDestroy do Bean Externo");
	}
	
	public Bean2 getBean() {
		return bean2;
	}
	public void setBean(Bean2 bean) {
		this.bean2 = bean;
	}
	
	@Override
	public String toString() {
		return this.bean2.getValor();
	}
	
}
