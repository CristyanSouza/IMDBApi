package br.com.javaimdb;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	
	private String title;
	private String rating;
	private String image;
	private String year;
	private static List<Movie> AllMovies = new ArrayList<Movie>();	
	
	
	public Movie(String title, String rating, String image, String year) {
		this.title = title;
		this.rating = rating;
		this.image = image;
		this.year = year;
		
		
		Movie.AllMovies.add(this);
	}
	
	
	public String getTitle() {
		return this.title;
	}
	public String getRating() {
		return this.rating;
	}
	public String getImage() {
		return this.image;
	}
	public String getYear() {
		return this.year;
	}
	
	public static List<Movie> getAllMovies() {
		List<Movie> MoviesList = AllMovies; 
		return MoviesList;
	}
	
	
	
	@Override
	public String toString() {
		return "Titulo: " + this.title + ", Ano: " + this.year + ", Nota: " + this.rating;
		
	}
	

}
