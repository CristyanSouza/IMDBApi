package br.com.javaimdb;

import java.util.List;

import br.com.javaimdb.util.HTMLGenerator;
import br.com.javaimdb.util.ParseJson;
import br.com.javaimdb.util.RequestAPI;

public class Main {
	public static void main(String[] args) throws Exception {
		
		String key = "k_d0mbm2vu";
		String url = "https://imdb-api.com/en/API/Top250Movies/";

		String stringAllMovies = RequestAPI.get(url, key);
		
		ParseJson parser = new ParseJson(stringAllMovies);
		List<Movie> AllMovies = parser.parse();
		
		
		
		HTMLGenerator html = new HTMLGenerator();
		html.generate(AllMovies);
			
		
	}
}
