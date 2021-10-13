package sen3004.project.dao;

import java.util.List;

import sen3004.project.model.Game;
import sen3004.project.model.Genre;
import sen3004.project.model.Publisher;

public interface IPublisher {

	public Publisher findById(long id);
	
	public List<Publisher> findAll();
	
	public void create(Publisher publisher);
	
	public void delete(long id);
	
	public List<Game> findGames(long id);
	
	public void deleteByPID(long id);
	
	public List<Publisher> searchByName(String name);
}
