package Jotape.test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class JUNIT5C {

	@Mock
	private Classe classe;	
	
	@Test
	@DisplayName("Verificando setId e setValue")
	public void teste() {
		this.classe.setId(1);
		this.classe.setValue("123");
		Mockito.verify(classe).setId(1);
		Mockito.verify(classe).setValue("123");
	}
	
}
