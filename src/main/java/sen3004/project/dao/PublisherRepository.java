package sen3004.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sen3004.project.model.Game;
import sen3004.project.model.Publisher;

@Repository
public class PublisherRepository implements IPublisher {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Publisher findById(long id) {
		return entityManager.find(Publisher.class, id);
	}

	@Override
	public List<Publisher> findAll() {
		return entityManager.createQuery("from Publisher", Publisher.class).getResultList();
	}

	@Override
	public void create(Publisher publisher) {
		entityManager.persist(publisher);
	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Publisher.class, id));
	}

	@Override
	public List<Game> findGames(long id) {
		return entityManager.createQuery("from Game where pid ="+id,Game.class).getResultList();
	}

	@Override
	public void deleteByPID(long id) {
		entityManager.createQuery("delete from game where game.PublisherID = :id", Game.class);
	}

	@Override
	public List<Publisher> searchByName(String name) {
		return (List<Publisher>)entityManager.createQuery("FROM Publisher WHERE pname LIKE '%" + name +"%'").getResultList();
	}
	
	public List<Publisher> findAllByDesc() {
    	return entityManager.createQuery("from Publisher ORDER BY avgscore ASC", Publisher.class).setMaxResults(5).getResultList();
    }
}
