package br.com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.Bean;


@RestController
public class ControllerBasico {	
	
	@RequestMapping(value = "/api/", method=RequestMethod.GET)
	public Bean index() {
		System.out.println("Acessando Index");		
		Bean bean = new Bean(1,"João");
		return bean;
	}
}
