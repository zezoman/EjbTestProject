package test;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Movie
 *
 */
@Entity
@NamedQueries(value = { 
		@NamedQuery(name = "Movie.findAll", query = "select m from Movie m"), 
		@NamedQuery(name = "Movie.findFromYear", query = "select m.name from Movie as m where m.year=:year") 
})


public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String year;
	private String actors;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;

	public Movie() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String param) {
		this.year = param;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String param) {
		this.actors = param;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int param) {
		this.movieId = param;
	}

}
