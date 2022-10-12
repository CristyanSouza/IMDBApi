package br.com.javaimdb.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.javaimdb.Movie;

public class HTMLGenerator {
	
public void generate(List <Movie> list) throws IOException {
	
	
	StringBuilder HTML = new StringBuilder();
	
	String head = """
	<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
    	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
		+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
	    <title>TOP 250 FILMES</title>
	</head>
	<body style ="background-color: rgb(33, 37, 41);">
	<h1 style="margin-block: 1.5em;color: white; text-align: center;">TOP 250 - Filmes </h1>
				
	 <div class="card" style=" background-color: rgb(33, 37, 41); width: 18rem; display:flex; gap: 16px; margin: auto;">

	""";
	
	HTML.append(head);
	
	
	
	list.forEach((movie) -> {
			String movieCard = 
					"""
					<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
					  <h4 class=\"card-header\">%s</h4>
					  <div class=\"card-body\">
						<img class=\"card-img\" src=\"%s\" alt=\"%s\">
						<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
					  </div>
					</div>
				""";
			
			
			HTML.append(String.format(movieCard, movie.getTitle(), movie.getImage(), movie.getTitle(), movie.getRating(), movie.getYear()));
				
	});
	
	String footer = """
			
			</div>
			</body>
			
			""";
	
	HTML.append(footer);
	
	String stringHtml = HTML.toString();
	
	FileWriter fw = new FileWriter("Movies.html");
	fw.write(stringHtml);
	fw.close();
	}
}
