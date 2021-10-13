package sen3004.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sen3004.project.model.Admin;

@Repository
public class AdminRepository implements IAdmin {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Admin findById(long id) {
		return entityManager.find(Admin.class, id);
	}

	@Override
	public void create(Admin admin) {
		entityManager.persist(admin);
	}

	@Override
	public void update(Admin admin) {
		entityManager.merge(admin);
	}

	@Override
	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Admin.class, id));	
	}

	@Override
	public List<Admin> findAll() {
		return entityManager.createQuery("from Admin", Admin.class).getResultList();
	}
}
