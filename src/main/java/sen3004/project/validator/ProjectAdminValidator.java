package sen3004.project.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sen3004.project.model.Admin;
import sen3004.project.service.TermProjectService;

@Component
public class ProjectAdminValidator implements Validator {
	private boolean success=true;
	private Admin admin;
	
	@Autowired
	TermProjectService service;
		
	public Admin getAdmin() {
		return admin;
	}

	
	@Override
	public boolean supports(Class<?> clazz) {
		return Admin.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Admin a=(Admin)target;
		
		List<Admin> list=service.findAllAdmins();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getUserName().equals(a.getUserName()) && list.get(i).getPassword().equals(a.getPassword()))
			{
				admin=list.get(i);
				success=true;
				break;
			}
			else {
				success=false;
				continue;	
			}
		}
		if(!success)
		{
			errors.rejectValue("password", "login.err");
		}
		
	}

}

