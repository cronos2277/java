package Jotape.test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class JUNIT5B {

	private static Classe classe;	
	
	static {
		classe = new Classe();
	}
	
	@Test	
	public void isNotZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> classe.setId(0));
	}
	
	@Test	
	public void isNotNegative() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> classe.setId(-1));
	}
	
	@Test	
	public void isNotEmptyOrNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> classe.setValue(""));
		Assertions.assertThrows(IllegalArgumentException.class, () -> classe.setValue(null));
	}	
	
}
