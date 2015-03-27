package test;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.*;

/**
 * Backing Bean for JSF pages. <br/>
 * This bean has reference of <code>ContactService</code> using @EJB Annotation
 */
@ManagedBean
@SessionScoped
public class MovieBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private MovieServiceLocal service;
	
	private String name, year, actors;
	
	private List<Movie> movieList;
	
	private List<String> moviesFromYear;

	private String searchYear;

	
	public MovieBean() {
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String addMovie() {
		service.save(name, year, actors);
		return "success";
	}
	
	public String backToNewMovie() {
		clearState();
		return "backnewmovie";
	}

	public List<Movie> getMovieList() {
		movieList = service.loadAll();
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public List<String> getMoviesFromYear() {
		moviesFromYear = service.findFromYear(searchYear);
		return moviesFromYear;
	}

	public void setMoviesFromYear(List<String> moviesFromYear) {
		this.moviesFromYear = moviesFromYear;
	}
	
	public void searchForYear(String searchYear){
		this.searchYear = searchYear;
	}
	
	private void clearState() {
		name = year = actors = null;
	}

}