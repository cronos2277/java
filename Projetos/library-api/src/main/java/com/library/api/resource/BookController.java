package com.library.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDTO create() {
		BookDTO dto = new BookDTO();
		dto.setAuthor("Autor");
		dto.setTitle("Meu livro");
		dto.setIsbn("1213212");
		dto.setId(1l);
		return dto;
	}

}
