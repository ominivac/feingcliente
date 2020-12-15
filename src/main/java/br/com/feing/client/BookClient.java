package br.com.feing.client;

import java.util.List;

import br.com.feing.model.Book;
import br.com.feing.resource.BookResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface BookClient {
	
	@RequestLine("GET /{isbn}")
    BookResource findByIsbn(@Param("isbn") String isbn);

    @RequestLine("GET")
    List<BookResource> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(Book book);

}
