package com.library.api.resource;


public class BookDTO {
	private Long id;
	private String title;
	private String author;
	private String isbn;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}	
	
	
	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}
	public static BookDTO builder(String author, String title, String isbn) {
		BookDTO dto = new BookDTO();
		dto.setAuthor(author);
		dto.setTitle(title);
		dto.setIsbn(isbn);
		return dto;
	}
	
}
