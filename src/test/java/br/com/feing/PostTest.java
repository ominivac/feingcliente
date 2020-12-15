package br.com.feing;


import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import br.com.feing.client.BookClient;
import br.com.feing.client.PostClient;
import br.com.feing.model.Book;
import br.com.feing.model.Post;
import br.com.feing.resource.BookResource;
import br.com.feing.resource.PostResource;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@Slf4j
public class PostTest {

	private PostClient postClient;
	
	//@Before
    public  void setup() {
        PostControllerFeignClientBuilder feignClientBuilder = new PostControllerFeignClientBuilder();
        postClient = feignClientBuilder.getPostClient();
    }
	
	
	//@Test
	public void givenPostClient_shouldRunSuccessfully() throws Exception {
	   List<Post> posts = postClient.findAll().stream()
	     .map(PostResource::getPost)
	     .collect(Collectors.toList());

	   	System.out.println(posts);
	   
	  // assertTrue(posts.size() > 2);
	}

	/*
	
	@Test
	public void givenPostClient_shouldFindOneBook() throws Exception {
	    Post post = postClient.findByUserId("1").getPost() ;
	    assertThat(book.getAuthor(), containsString("Orwell"));
	} */

	
	
	//@Test
	public void givenPostClient_shouldPostBook() throws Exception {
	    String isbn = UUID.randomUUID().toString();
	    Post post  = new Post();
	    
	    post.setId("8334");
	    post.setTitle("titulo com 8334");
	    post.setBody("body com 8334");
	    post.setUserId("user8334");
	    
	    
	    postClient.create(post);
	    post = postClient.findByUserId("user8334").getPost();
	    		
	    //book = bookClient.findByIsbn(isbn).getBook();

	   // assertThat(book.getAuthor(), is("Me"));
	 //   assertThat(post.getUserId(), is("user8334"));
	    System.out.println(post);
	}
	
	
	public static void main(String[] args) throws Exception {
		PostTest test = new PostTest();
		test.setup();
	//	test.givenPostClient_shouldRunSuccessfully();
		test.givenPostClient_shouldPostBook();
	}
}
