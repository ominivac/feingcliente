package br.com.feing;


import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import br.com.feing.client.BookClient;
import br.com.feing.model.Book;
import br.com.feing.resource.BookResource;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@Slf4j
public class ClientTest {

	private BookClient bookClient;
	
	@Before
    public void setup() {
        BookControllerFeignClientBuilder feignClientBuilder = new BookControllerFeignClientBuilder();
        bookClient = feignClientBuilder.getBookClient();
    }
	
	
	@Test
	public void givenBookClient_shouldRunSuccessfully() throws Exception {
	   List<Book> books = bookClient.findAll().stream()
	     .map(BookResource::getBook)
	     .collect(Collectors.toList());

	   assertTrue(books.size() > 2);
	}

	@Test
	public void givenBookClient_shouldFindOneBook() throws Exception {
	    Book book = bookClient.findByIsbn("0151072558").getBook();
	    assertThat(book.getAuthor(), containsString("Orwell"));
	}

	@Test
	public void givenBookClient_shouldPostBook() throws Exception {
	    String isbn = UUID.randomUUID().toString();
	    Book book = new Book(isbn, "Me", "It's me!", null, null);
	    bookClient.create(book);
	    book = bookClient.findByIsbn(isbn).getBook();

	    assertThat(book.getAuthor(), is("Me"));
	}
}
