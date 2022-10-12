package br.com.javaimdb.util;

import java.util.List;

import br.com.javaimdb.Movie;

public class ParseJson {
	
	private String data;
	
	public ParseJson (String data) {
		this.data = data;
	}
	
	
	public List<Movie> parse () {
	String [] parseMovies = RegexParseJson.parseJsonMovies(data);
	List <String> moviesTitles = RegexParseJson.parseTitles(parseMovies);
	List <String> moviesUrlImages = RegexParseJson.parseUrlImages(parseMovies);
	List <String> moviesRating = RegexParseJson.parseRating(parseMovies);
	List <String> moviesYear = RegexParseJson.parseYear(parseMovies); 
	
	for (int i = 0 ; i < parseMovies.length ; i++) {
		String title = moviesTitles.get(i);
		String rating = moviesRating.get(i);
		String image = moviesUrlImages.get(i);
		String year = moviesYear.get(i);
		
		new Movie (title, rating, image, year);
		}
	return Movie.getAllMovies();
	
	}
	
	

}

