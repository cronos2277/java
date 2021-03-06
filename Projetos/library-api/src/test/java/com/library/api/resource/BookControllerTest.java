package com.library.api.resource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.library.api.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.api.service.BookService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class BookControllerTest {
	
	static String BOOK_API = "/api/books/";

	@Autowired
	MockMvc mvc;
	
	@MockBean	
	BookService service;
	
	@Test
	@DisplayName("Deve criar um livro com sucesso.")
	public void createBookTest() throws Exception{
		
		Long id = 10l;
		String author = "Arthur";
		String title = "As aventuras";
		String isbn = "001";
		
		
		BookDTO dto = BookDTO.builder(author,title,isbn);
		dto.setId(id);
		Book savedBook = Book.builder(author, title, isbn);
		savedBook.setId(id);
		
		BDDMockito.given(service.save(Mockito.any(Book.class))).willReturn(savedBook);
		
		String json = new ObjectMapper().writeValueAsString(dto);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(BOOK_API)
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)
		.content(json);		
		
		
		
		
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("title").value(dto.getTitle()))
		.andExpect(MockMvcResultMatchers.jsonPath("author").value(dto.getAuthor()))
		.andExpect(MockMvcResultMatchers.jsonPath("isbn").value(dto.getIsbn()));
		
	}
	
	@Test
	@DisplayName("Deve lancar erro de validacao quando nao houver dados suficiente.")
	public void createInvalidBookTest() {
		
	}
}
