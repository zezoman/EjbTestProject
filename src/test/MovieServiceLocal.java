package test;

import javax.ejb.Local;

@Local
public interface MovieServiceLocal extends MovieServiceRemote {
	public void save(String name, String year, String actors);
}
