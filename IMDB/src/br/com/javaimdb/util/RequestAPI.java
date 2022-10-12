package br.com.javaimdb.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestAPI{

	
	public static String get(String url, String key) throws Exception {
		
		HttpClient client = HttpClient.newHttpClient();
		URI uri = new URI(url + key);
		var request = HttpRequest
				.newBuilder(uri)
				.GET()
				.build();
		
		String stringAllMovies = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
		
		return stringAllMovies;
	}
	
	
}
