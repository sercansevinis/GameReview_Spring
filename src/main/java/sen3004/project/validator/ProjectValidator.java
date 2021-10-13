package sen3004.project.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sen3004.project.model.Game;
import sen3004.project.model.Publisher;
import sen3004.project.service.TermProjectService;

@Component
public class ProjectValidator implements Validator {
	
	@Autowired
	TermProjectService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Game.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Game g = (Game) target;
		if(g.getName().contains("*") || g.getName().contains(";") || g.getName().contains("[") || g.getName().contains("{") || g.getName().contains("#") || g.getName().contains("%")) {
			errors.rejectValue("name", "Invalid.characters");
		}
		
		List<Game> allGames = service.findAllGames();
		Publisher p = service.findByPublisherName(g.getPubName()).get(0);
		for (int i = 0; i < allGames.size(); i++) {
			if(g.getName().equals(allGames.get(i).getName()) && g.getPubName().equals(p.getName()) && g.getReviewRate().equals(allGames.get(i).getReviewRate()) && g.getRdate().equals(allGames.get(i).getRdate()) && g.getPlatforms().equals(allGames.get(i).getPlatforms())) {
				errors.rejectValue("pubName", "Same.game");
			}
		}
	}
}
