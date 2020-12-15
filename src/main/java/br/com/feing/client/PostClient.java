package br.com.feing.client;

import java.util.List;


import br.com.feing.model.Post;

import br.com.feing.resource.PostResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PostClient {
	
	@RequestLine("GET /{userId}")
    PostResource findByUserId(@Param("userId") String userId);

    @RequestLine("GET")
    List<PostResource> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(Post post);

}
