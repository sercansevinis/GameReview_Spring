package sen3004.project.dao;

import java.util.List;

import sen3004.project.model.Game;
import sen3004.project.model.Genre;

public interface IGenre {

	public Genre findById(long id);
	
	public List<Genre> findAll();
	
	public void create(Genre genre);
	
	public void delete(long id);
	
	public List<Game> findGames(long id);
	
	public void deleteByGID(long id);
	
	public List<Genre> searchByName(String name);
	
	public List<Object> findGamesOfGenre(long id);
}
