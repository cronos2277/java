package Jotape.test;
import org.junit.Before;
import org.junit.Test;

//Novidade
import org.assertj.core.api.Assertions;

public class ExemploTeste {
	
	private Exemplo exemplo;
	@Before
	public void init() {
		this.exemplo = new Exemplo();
	}
	
	@Test
	public void validId() {
		this.exemplo.setId(1);
		Assertions.assertThat(this.exemplo.getId())
		.isGreaterThan(0)
		.isNotNull();
	}
	
	@Test(expected = RuntimeException.class)
	public void notNegativeId() {
		this.exemplo.setId(-1);		
	}
	
	@Test(expected = RuntimeException.class)
	public void notZeroId() {
		this.exemplo.setId(0);
	}
	
	@Test
	public void validValue() {
		this.exemplo.setValue("abcd");
		Assertions.assertThat(this.exemplo.getValue())
		.hasSizeGreaterThan(3)
		.isNotNull()
		.isNotEmpty();		
	}
	
	@Test(expected = NullPointerException.class)
	public void notNullValue() {
		this.exemplo.setValue(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void notEmptyValue() {
		this.exemplo.setValue("");
	}
	
	@Test(expected = RuntimeException.class)
	public void notDigitsValue() {
		this.exemplo.setValue("12345");		
	}
}
