package Jotape.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class BeanTeste {

	private Bean bean;
	
	@Before
	public void setUp() {
		this.bean = new Bean();
	}
	
	@Test
	public void nomeIsNotNull() {
		this.bean.setNome("Nome");
		Assert.assertNotNull(this.bean.getNome());
	}
	
	@Test(expected = RuntimeException.class)
	public void nomeIsNotDigit() {
		this.bean.setNome("123");		
	}
	
	@Test(expected = RuntimeException.class)
	public void idIsNotNegative() {
		this.bean.setId(-1);
	}
	
	@Test(expected = RuntimeException.class)
	public void idIsNotZero() {
		this.bean.setId(0);
	}
	
	@Test(expected = RuntimeException.class)
	public void nomeIsNotEmpty() {
		this.bean.setNome("");		
	}
	
	@Test(expected = RuntimeException.class)
	public void tooShortName() {
		this.bean.setNome("abc");		
	}
}
