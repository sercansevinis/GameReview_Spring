package sen3004.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sen3004.project.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUser {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User findById(long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void create(User user) {
		entityManager.persist(user);
	}

	@Override
	public void update(User user) {
		entityManager.merge(user);
	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(User.class, id));	
	}

	@Override
	public List<User> findAll() {
		return entityManager.createQuery("from User", User.class).getResultList();
	}
	public User getUser(Long id)
	{
		return (User)entityManager.createQuery("SELECT * FROM User u Where u.id=:id",User.class).setParameter("id", id).getSingleResult();
	}
}
