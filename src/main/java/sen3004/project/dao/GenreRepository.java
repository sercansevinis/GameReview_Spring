package sen3004.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sen3004.project.model.Game;
import sen3004.project.model.Genre;

@Repository
public class GenreRepository implements IGenre {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Genre findById(long id) {
		return entityManager.find(Genre.class, id);
	}

	@Override
	public List<Genre> findAll() {
		return entityManager.createQuery("from Genre", Genre.class).getResultList();
	}

	@Override
	public void create(Genre genre) {
		entityManager.persist(genre);
	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Genre.class, id));
	}

	@Override
	public List<Game> findGames(long id) {
		// return entityManager.createQuery("from game where genre.id = :id", Game.class).getResultList();
		return null;
	}

	@Override
	public void deleteByGID(long id) {
		entityManager.createQuery("delete from game_genre where game_genre.geid = :id", Game.class);
		// Değiştir remove()
	}

	@Override
	public List<Genre> searchByName(String name) {
		return (List<Genre>)entityManager.createQuery("FROM Genre WHERE gname LIKE '%" + name +"%'").getResultList();
	}

	@Override
	public ArrayList<Object> findGamesOfGenre(long id) {
		List q=entityManager.createNativeQuery("select gname from game where id in (select gaid FROM game_genre WHERE geid =" + id+ ")").getResultList();
		 ArrayList<Object> arr=new ArrayList<Object>();
		 for (int i = 0; i < q.size(); i++) {
			 Object o=q.get(i);
			 System.out.println(o);
			 arr.add(o);
	}
		 return arr;
	}
	
	public Genre findByName(String name) {
		return entityManager.createQuery("FROM Genre WHERE gname ='" + name +"'", Genre.class).getSingleResult();
	}
}
