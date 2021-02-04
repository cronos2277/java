package Jotape.test;
import Jotape.test.Modelo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ModeloTeste {
	
	@Test
	public void basicoTeste() {
		Modelo modelo = Mockito.mock(Modelo.class);
		Mockito.when(modelo.getId()).thenReturn(1);
		int scene1 = modelo.getId();
		Assertions.assertThat(scene1).isEqualTo(1);
		
	}
}
