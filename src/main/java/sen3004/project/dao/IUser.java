package sen3004.project.dao;

import java.util.List;

import sen3004.project.model.User;

public interface IUser {

	public User findById(long id);
	
	public void create(User user);
	
	public void update(User user);
	
	public void delete(long id);
	
	public List<User> findAll();
}
