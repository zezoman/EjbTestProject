package test;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class MovieService implements MovieServiceRemote, MovieServiceLocal {

	@PersistenceContext(unitName = "TestUnit")
	private EntityManager em;

	public MovieService() {
		System.out.println("Instance created for Movie Service");
	}

	public void save(String name, String year, String actors) {
		Movie m = new Movie();
		m.setName(name);
		m.setYear(year);
		m.setActors(actors);
		em.persist(m);
	}
	
	public List<Movie> loadAll() {
		List<Movie> list = null;
		TypedQuery<Movie> q = em.createNamedQuery("Movie.findAll", Movie.class);
		list = q.getResultList();
		return list;
	}
	
	public List<String> findFromYear(String year) {
		List<String> list = null;
		TypedQuery<String> q = em.createNamedQuery("Movie.findFromYear", String.class);
		q.setParameter("year", year);
		list = q.getResultList();
		return list;
	}

}
