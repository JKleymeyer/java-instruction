package db;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import buisness.Movie;

public class MovieCollection {

	private List<Movie> movieList;

	public MovieCollection() {
		movieList = new ArrayList<>();
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public void add(Movie m) {
		movieList.add(m);
	}
	
	public List<Movie> filterMovies(Predicate<Movie> condition) {
		List<Movie> filteredMovies = new ArrayList<>();
		for (Movie m : movieList) {
			if(condition.test(m)) {
				filteredMovies.add(m);
			}
		}
		return filteredMovies;
	}

	public double getLowestRating() {
		double lowestRating = movieList.stream()
				.map(m-> m.getRating())
				.reduce(5.0, (a,b) -> Math.min(a,b));
		return lowestRating;
	}

	public double getHighestRating() {
		double highestRating = movieList.stream()
				.map(m-> m.getRating())
				.reduce(0.0, (a,b) -> Math.max(a,b));
		return highestRating;
	}

	public double getAverageRating() {
		double sum = movieList.stream()
				.mapToDouble(m-> m.getRating())
				.sum();
		return sum / movieList.size();
	}

	public int getSize() {
		return movieList.size();
	}
	
}
