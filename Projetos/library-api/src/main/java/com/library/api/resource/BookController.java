package com.library.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.api.entity.Book;
import com.library.api.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private BookService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDTO create(@RequestBody BookDTO dto) {	
		Book entity = Book.builder(dto.getAuthor(), dto.getTitle(), dto.getIsbn());
		entity.setId(dto.getId());
		entity = service.save(entity);
		BookDTO bookDTO = BookDTO.builder(entity.getAuthor(), entity.getTitle(), entity.getIsbn());
		bookDTO.setId(entity.getId());		
		return bookDTO;
	}

}
