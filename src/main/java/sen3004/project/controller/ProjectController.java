package sen3004.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sen3004.project.model.Admin;
import sen3004.project.model.Game;
import sen3004.project.model.Genre;
import sen3004.project.model.Publisher;
import sen3004.project.model.SearchEngine;
import sen3004.project.model.User;
import sen3004.project.service.TermProjectService;
import sen3004.project.validator.ProjectAdminValidator;
import sen3004.project.validator.ProjectUserValidator;
import sen3004.project.validator.ProjectValidator;

@Controller
public class ProjectController {

	@Autowired
	ProjectAdminValidator adminValidator;

	@Autowired
	ProjectUserValidator userValidator;

	@Autowired
	TermProjectService service;

	@Autowired
	ProjectValidator validator;

	boolean isAdmin, isUser = false;

	@RequestMapping(value = "/display-form", method = RequestMethod.GET)
	public ModelAndView displayLogin() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());

		return mv;
	}

	@RequestMapping(value = "/login-admin", method = RequestMethod.POST)
	public ModelAndView processAdminForm(@Valid @ModelAttribute("admin") Admin admin, BindingResult result) {
		ModelAndView mv = new ModelAndView("menu");
		mv.addObject("admin", admin);
		mv.addObject("user", new User());

		adminValidator.validate(admin, result);
		if (result.hasErrors()) {
			mv.setViewName("login-admin");
		} else {
			isAdmin = true;
			isUser = false;
			return new ModelAndView("redirect:/menu.html");
		}
		return mv;
	}

	@RequestMapping(value = "/display-admin-form", method = RequestMethod.GET)
	public ModelAndView displayAdminForm() {
		ModelAndView mv = new ModelAndView("login-admin");
		mv.addObject("admin", new Admin());

		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView processForm(@Valid @ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);

		userValidator.validate(user, result);
		if (result.hasErrors()) {
			mv.setViewName("login");
		} else {
			isUser = true;
			isAdmin = false;
			return new ModelAndView("redirect:/menu.html");
		}
		return mv;
	}

	@RequestMapping(value = { "/menu", "/menu.html" }, method = RequestMethod.GET)
	public ModelAndView displayForm() {
		ModelAndView mv = new ModelAndView("main-menu");

		List<Game> games = service.findGamesDesc();
		List<Publisher> publishers = service.findAllPublishers();
		for (int i = 0; i < publishers.size() - 1; i++) {
			for (int j = 0; j < publishers.size() - i - 1; j++) {
				if (publishers.get(j).getAvgscore() < publishers.get(j + 1).getAvgscore()) {
					Publisher publisherTemp = publishers.get(j);
					publishers.set(j, publishers.get(j + 1));
					publishers.set(j + 1, publisherTemp);
				}
			}
		}
		List<Publisher> publishersTop5 = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			publishersTop5.add(publishers.get(i));
		}

		mv.addObject("topFive", games);
		mv.addObject("topFiveP", publishersTop5);
		mv.addObject("searchEngine", new SearchEngine());

		return mv;
	}

	@RequestMapping(value = "/searchedItem", method = RequestMethod.POST)
	public ModelAndView searchedGame(@ModelAttribute("searchEngine") SearchEngine it) {
		ModelAndView mv = new ModelAndView("SearchedItem");

		if (it.getType().equals("Game")) {
			List<Game> game = service.findByGameName(it.getSearchedItem());
			mv.addObject("game", game);
		} else if (it.getType().equals("Genre")) {
			List<Genre> genre = service.findByGenreName(it.getSearchedItem());
			mv.addObject("genre", genre);
		} else if (it.getType().equals("Publisher")) {
			List<Publisher> p = service.findByPublisherName(it.getSearchedItem());
			mv.addObject("publisher", p);
		}

		mv.addObject("type", it);

		return mv;
	}

	@RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
	public ModelAndView aboutGame(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("game-view");

		Publisher p = service.findPublisherOfGame(id);
		Game game = service.FindGameById(id);
		List<Object> oGenres = service.findGenresOfGame(id);
		List<Genre> genres = new ArrayList<Genre>();
		for (int i = 0; i < oGenres.size(); i++) {
			genres.add(service.findByGenreName(oGenres.get(i).toString()).get(0));
		}
		mv.addObject("publisher", p);
		mv.addObject("game", game);
		mv.addObject("genres", genres);

		return mv;
	}

	@RequestMapping(value = "/publisher/{id}", method = RequestMethod.GET)
	public ModelAndView aboutPublisher(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("publisher-view");

		Publisher p = service.FindPublisherById(id);
		List<Game> games = service.findGames_Publisher(id);
		mv.addObject("publisher", p);
		mv.addObject("games", games);

		return mv;
	}

	@RequestMapping(value = "/add-game", method = RequestMethod.GET)
	public ModelAndView addGame() {
		ModelAndView mv = null;
		if (isAdmin) {
			mv = new ModelAndView("add-game");
			List<Genre> genres = service.findAllGenres();
			mv.addObject("genres", genres);
			mv.addObject("newgame", new Game());
			mv.addObject("publisher", new Publisher());
		} else {
			return new ModelAndView("redirect:/menu.html");
		}

		return mv;
	}

	@RequestMapping(value = "/added", method = RequestMethod.POST)
	public ModelAndView addedGame(@Valid @ModelAttribute("newgame") Game game, BindingResult result) {
		ModelAndView mv = new ModelAndView("success");

		mv.addObject("games", service.findAllGames());
		mv.addObject("genres", service.findAllGenres());

		validator.validate(game, result);
		if (result.hasErrors()) {
			mv.setViewName("add-game");
		} else {
			for (int i = 0; i < game.getGenreNames().length; i++) {
				String genreName = game.getGenreNames()[i];
				Genre g = service.findGenreByName(genreName);
				game.addGenre(g);
			}
			game.setPublisher(service.findByPublisherName(game.getPubName()).get(0));
			service.createGame(game);
		}

		return mv;
	}

	@RequestMapping(value = "/genre/{id}", method = RequestMethod.GET)
	public ModelAndView aboutGenre(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("genre-view");

		Genre g = service.FindGenreById(id);
		List<Object> oGames = service.findGamesOfGenre(id);
		List<Game> games = new ArrayList<Game>();
		for (int i = 0; i < oGames.size(); i++) {
			games.add(service.findByGameName(oGames.get(i).toString()).get(0));
			games.get(i).setPublisher(service.findPublisherOfGame(games.get(i).getId()));
		}

		mv.addObject("genre", g);
		mv.addObject("game", games);
		return mv;
	}

	@RequestMapping(value = "/game/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateGenre(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("update-game");

		if (isAdmin) {
			Game g = service.FindGameById(id);
			Set<Genre> genres = g.getGenres();
			List<Genre> allGenres = service.findAllGenres();
			Publisher p = g.getPublisher();
			g.setPubName(p.getName());

			mv.addObject("game", g);
			mv.addObject("genre", genres);
			mv.addObject("allGenres", allGenres);
			mv.addObject("publisher", p);
		} else {
			return new ModelAndView("redirect:/menu.html");
		}

		return mv;
	}

	@RequestMapping(value = "/updated/{id}", method = RequestMethod.POST)
	public ModelAndView updatedGame(@Valid @ModelAttribute("game") Game game, BindingResult result, @PathVariable long id) {
		ModelAndView mv = new ModelAndView("game-view");
		if (isAdmin) {
			mv.addObject("game", game);
			mv.addObject("games", service.findAllGames());
			mv.addObject("allGenres", service.findAllGenres());

			for (int i = 0; i < game.getGenreNames().length; i++) {
				String genreName = game.getGenreNames()[i];
				Genre g = service.findGenreByName(genreName);
				game.addGenre(g);
			}
			game.setPublisher(service.findByPublisherName(game.getPubName()).get(0));

			validator.validate(game, result);
			if (result.hasErrors()) {
				mv.setViewName("update-game");
			} else {
				service.updateGame(game);
				mv.setViewName("success");
			}
		} else {
			return new ModelAndView("redirect:/menu.html");

		}
		return mv;
	}
	
	@RequestMapping(value = "/list-games", method = RequestMethod.GET)
	public ModelAndView listGames() {
		ModelAndView mv = new ModelAndView("all-game");
		mv.addObject("games", service.findAllGames());

		return mv;
	}
	
	@RequestMapping(value = "/list-genres", method = RequestMethod.GET)
	public ModelAndView listGenres() {
		ModelAndView mv = new ModelAndView("all-genre");
		mv.addObject("genres", service.findAllGenres());

		return mv;
	}
	
	@RequestMapping(value = "/list-publishers", method = RequestMethod.GET)
	public ModelAndView listPublishers() {
		ModelAndView mv = new ModelAndView("all-publisher");
		mv.addObject("publishers", service.findAllPublishers());
		
		return mv;
	}

	@RequestMapping(value = "/game/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteGame(@PathVariable long id) {
		ModelAndView mv = new ModelAndView();
		if (isAdmin) {
			service.deleteGame(id);
			mv.addObject("games", service.findAllGames());
			mv.setViewName("all-game");
		} else {
			return new ModelAndView("redirect:/menu.html");

		}
		return mv;
	}
	
	@RequestMapping(value = "/create-user", method = RequestMethod.GET)
	public ModelAndView displayCreateUser() {
		ModelAndView mv = new ModelAndView("create-user");
		mv.addObject("user", new User());

		return mv;
	}

	@RequestMapping(value = "/create/user", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mv = new ModelAndView("login");

		if (result.hasErrors()) {
			mv.setViewName("create-user");
		} else {
			service.createUser(user);
			mv.addObject("user", new User());
		}
		return mv;
	}
}
