package test;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface MovieServiceRemote {
	public List<Movie> loadAll();
	public List<String> findFromYear(String year);
}
