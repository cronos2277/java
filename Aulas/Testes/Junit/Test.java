class Test {
	
	@org.junit.jupiter.api.Test
	public void soma1() {
		Calculadora cal = new Calculadora();		
		org.junit.Assert.assertTrue(10 == cal.somar(5, 5));
	}
	
	@org.junit.jupiter.api.Test
	public void soma2() {
		org.junit.Assert.assertEquals(10, new Calculadora().somar(5, 5));
	}

}
