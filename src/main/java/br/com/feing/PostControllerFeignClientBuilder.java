package br.com.feing;

import br.com.feing.client.BookClient;
import br.com.feing.client.PostClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;

@Getter
public class PostControllerFeignClientBuilder {
	String endPoint = "";
	String endPoint2 = "https://jsonplaceholder.typicode.com/posts";
	private PostClient postClient = createClient(PostClient.class, endPoint2);
	
	
	

    public PostClient getPostClient() {
		return postClient;
	}




	public void setPostClient(PostClient postClient) {
		this.postClient = postClient;
	}




	private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(type))
            .logLevel(Logger.Level.FULL)
            .target(type, uri);
    }

}
