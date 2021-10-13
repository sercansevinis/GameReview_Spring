package sen3004.project.dao;

import java.util.List;

import sen3004.project.model.Admin;

public interface IAdmin {

	public Admin findById(long id);
	
	public void create(Admin admin);
	
	public void update(Admin admin);
	
	public void delete(long id);
	
	public List<Admin> findAll();
}
