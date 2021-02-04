package Jotape.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockTesteModelo {
	
	@Mock
	private Modelo modelo;
	
	@Test
	public void callingNumber() {		
		this.modelo.setNumero(1000);
		this.modelo.getNumero();
		
		//Verifica se foi chamado independente da ordem
		Mockito.verify(this.modelo).getNumero();
		Mockito.verify(this.modelo).setNumero(1000);				
	}
	
	@Test
	public void workingId() {
		InOrder order1 = Mockito.inOrder(this.modelo);
		this.modelo.setId(1);
		this.modelo.getId();		
		
		//Verifica se os metodos foram chamados seguindo a ordem abaixo.		
		order1.verify(this.modelo).setId(1);
		order1.verify(this.modelo).getId();
	}	
	
	@Test
	public void workingValue() {
		this.modelo.setValue("Exemplo");
		Mockito.verify(this.modelo,Mockito.times(1)).setValue("Exemplo");
		Mockito.verify(this.modelo,Mockito.never()).getValue();		
	}	

}
