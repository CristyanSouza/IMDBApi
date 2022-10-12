package br.com.javaimdb.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegexParseJson {
	
	//Regex to parse json string
	public static String[] parseJsonMovies(String json) {
		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("no match in " + json);
		}

		String[] moviesArray = matcher.group(1).split("\\},\\{");
		moviesArray[0] = moviesArray[0].substring(1);
		int last = moviesArray.length - 1;
		String lastString = moviesArray[last];
		moviesArray[last] = lastString.substring(0, lastString.length() - 1);
		return moviesArray;
	}
	
	//Regex to extract attributes of json string
	
	private static List<String> parseAttribute(String[] moviesArray, int pos) {
		return Stream.of(moviesArray)
			.map(e -> e.split("\",\"")[pos]) 
			.map(e -> e.split(":\"")[1]) 
			.map(e -> e.replaceAll("\"", ""))
			.collect(Collectors.toList());
	}
	
	//Method to extract titles 
	
	public static List<String> parseTitles(String[] moviesArray) {
		return parseAttribute(moviesArray, 2);
	}
	
	//Method to extract URL Images 
	
	public static List<String> parseUrlImages(String[] moviesArray) {
		return parseAttribute(moviesArray, 5);
	}
	
	
	public static List<String> parseYear(String[] moviesArray) {
		return parseAttribute(moviesArray, 4);
	}
	

	public static List<String> parseRating(String[] moviesArray) {
		return parseAttribute(moviesArray, 7);
	}

	

}
