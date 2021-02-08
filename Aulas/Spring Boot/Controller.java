package br.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {	
	
	private List<Bean> beans = new ArrayList<Bean>();	
	
	public Controller() {
		this.beans.add(new Bean(1, "Joao"));
		this.beans.add(new Bean(2, "Maria"));
		this.beans.add(new Bean(3, "Paulo"));
	}
		
	@RequestMapping(value = "/api/", method=RequestMethod.GET)
	public List<Bean> index() {
		System.out.println("Acessando Index");		
		return beans;
	}	
	
	@GetMapping("/api/{id}")
	public Bean get(@PathVariable int id) {
		System.out.println("Pegando valor de: "+id);
		Iterator<Bean> iterator = beans.iterator();
		while(iterator.hasNext()) {
			Bean bean = iterator.next();
			if(bean.getId() == id) {
				return bean;
			}
		}
		
		return null;		
	}
	
	@PostMapping("/api/")	
	public ResponseEntity<Bean> save(@RequestBody Bean bean) {
		System.out.println("Gravando "+bean.getName());
		this.beans.add(bean);
		return new ResponseEntity<Bean>(bean,HttpStatus.CREATED);
	}
	
	@PutMapping("/api/")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void update(@RequestBody Bean bean){
		this.beans.get(bean.getId() - 1).setName(bean.getName());
		System.out.println("Atualizando "+bean.getName());		
	}
	
	@DeleteMapping("/api/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		Bean bean = this.beans.get(id - 1);
		this.beans.remove(id);
		System.out.println("Excluído "+bean.getName());
	}
}
