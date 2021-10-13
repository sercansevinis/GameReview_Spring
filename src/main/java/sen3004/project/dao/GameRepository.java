package sen3004.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sen3004.project.model.Game;
import sen3004.project.model.Genre;
import sen3004.project.model.Publisher;

@Repository
public class GameRepository implements IGame {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Game> findAll() {
		return entityManager.createQuery("from Game ORDER BY ReviewRate DESC", Game.class).getResultList();
	}

	@Override
	public Game findById(long id) {
		return entityManager.find(Game.class, id);
	}

	@Override
	public void create(Game game) {
		entityManager.persist(game);
	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Game.class, id));

	}

	@Override
	public void update(Game game) {
		entityManager.merge(game);

	}

	@Override
	public List<Genre> listGenre(long id) {
		List<Query> a = entityManager.createQuery("SELECT geid from game_genre where game.id = :id").getResultList();
		List<Genre> foundGenres = null;
		for (int i = 0; i < a.size(); i++) {

			foundGenres.add((Genre) entityManager.createQuery("from genre where genre.id=" + a.get(i).toString()).getSingleResult());
		}
		return foundGenres;
	}

	@Override
	public List<Game> findByName(String name) {
		return (List<Game>) entityManager.createQuery("FROM Game WHERE gname LIKE '%" + name + "%'").getResultList();
	}

	@Override
	public Publisher findPublisherOfGame(long id) {
		return (Publisher) entityManager.createQuery("FROM Publisher WHERE id=(select publisher.id from Game where id=" + id + ")").getSingleResult();
	}

	@Override
	public ArrayList<Object> findGenresOfGame(long id) {

		List q = entityManager.createNativeQuery("select gname from genre where id in (select geid FROM game_genre WHERE gaid =" + id + ")").getResultList();
		ArrayList<Object> arr = new ArrayList<Object>();
		for (int i = 0; i < q.size(); i++) {
			Object o = q.get(i);
			System.out.println(o);
			arr.add(o);
		}

		return arr;
		// return (List<Genre>)entityManager.createQuery("from Genre where id IN (select
		// genres.id FROM Game WHERE id ="+id+")").getResultList();
	}

	public List<Game> findAllByDesc() {
		return entityManager.createQuery("from Game ORDER BY ReviewRate DESC", Game.class).setMaxResults(5).getResultList();
	}

	/*
	 * @Override public Game findByPID(long id) { return
	 * entityManager.createQuery("from game WHERE publisher.PublisherID = :id",Game.
	 * class).setParameter("id",id).getSingleResult(); }
	 */
	public List<Game> findTopFive() {
		return entityManager.createQuery("select top 5 name from Game ORDER BY ReviewRate DESC", Game.class).getResultList();
	}
}