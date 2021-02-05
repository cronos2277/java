package Jotape.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUNIT5A {

	private static Classe classe;
	
	@BeforeAll
	public static void beforeAll() {
		classe = new Classe();
	}
	
	@BeforeEach
	public void beforeEach() {		
		classe = new Classe();
	}
	
	@AfterEach
	public void afterEach() {
		classe.kill();
	}
	
	@AfterAll
	public static void afterAll() {
		classe.kill();
	}
	
	@Test	
	@Order(3)
	@DisplayName("ID nao deve aceitar o valor zero")
	public void isNotZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> classe.setId(0));
	}
	
	@Test
	@Order(2)
	@DisplayName("ID nao deve aceitar valores negativos")
	public void isNotNegative() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> classe.setId(-1));
	}
	
	@Test
	@Order(1)
	@DisplayName("Value nao deve aceitar valores vazio ou nulo")
	public void isNotEmptyOrNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> classe.setValue(""));
		Assertions.assertThrows(IllegalArgumentException.class, () -> classe.setValue(null));
	}	
	
}
