package br.com.feing;

import br.com.feing.client.BookClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;

@Getter
public class BookControllerFeignClientBuilder {
	String endPoint = "";
	String endPoint2 = "https://jsonplaceholder.typicode.com/posts";
	private BookClient bookClient = createClient(BookClient.class, endPoint2);
	
	
	

    public BookClient getBookClient() {
		return bookClient;
	}




	public void setBookClient(BookClient bookClient) {
		this.bookClient = bookClient;
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
