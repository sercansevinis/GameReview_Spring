package sen3004.project.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sen3004.project.model.User;
import sen3004.project.service.TermProjectService;



@Component
public class ProjectUserValidator implements Validator {
	private boolean success=true;
	private User user;
		
	public User getApplicant() {
		return user;
	}


	@Autowired
	TermProjectService service;
	@Override
	public boolean supports(Class<?> clazz) {

		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User a=(User)target;
		
		List<User> list=service.findAllUsers();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getUserName().equals(a.getUserName()) && list.get(i).getPassword().equals(a.getPassword()))
			{
				user=list.get(i);
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
