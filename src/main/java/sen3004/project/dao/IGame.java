package sen3004.project.dao;

import java.util.ArrayList;
import java.util.List;

import sen3004.project.model.Game;
import sen3004.project.model.Genre;
import sen3004.project.model.Publisher;

public interface IGame {

	public List<Game> findAll();
	
	public Game findById(long id);
	
	public void create(Game game);
	
	public void delete(long id);
	
	public void update(Game game);
	
	public List<Genre> listGenre(long id);
	
	public List<Game> findByName(String name);
	
	public Publisher findPublisherOfGame(long id);
	
	public ArrayList<Object> findGenresOfGame(long id);
	
	//public Game findByPID(long id);
}
