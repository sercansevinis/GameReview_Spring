package sen3004.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sen3004.project.dao.AdminRepository;
import sen3004.project.dao.GameRepository;
import sen3004.project.dao.GenreRepository;
import sen3004.project.dao.PublisherRepository;
import sen3004.project.dao.UserRepository;
import sen3004.project.model.Admin;
import sen3004.project.model.Game;
import sen3004.project.model.Genre;
import sen3004.project.model.Publisher;
import sen3004.project.model.User;

@Service
@Transactional
public class TermProjectService {

	@Autowired
	GameRepository gameRepo;

	@Autowired
	PublisherRepository pubRepo;

	@Autowired
	GenreRepository genRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	AdminRepository adminRepo;

	public List<Game> findAllGames() {
		return gameRepo.findAll();
	}

	public Game FindGameById(long id) {
		return gameRepo.findById(id);
	}

	public void createGame(Game game) {
		gameRepo.create(game);
	}

	public void deleteGame(long id) {
		gameRepo.delete(id);
	}

	public void updateGame(Game game) {
		gameRepo.update(game);
	}

	public List<Game> findByGameName(String name) {
		return gameRepo.findByName(name);
	}

	public ArrayList<Object> findGenresOfGame(long id) {
		return gameRepo.findGenresOfGame(id);
	}

	public ArrayList<Object> findGamesOfGenre(long id) {
		return genRepo.findGamesOfGenre(id);
	}

	public List<Genre> findByGenreName(String name) {
		return genRepo.searchByName(name);
	}

	public List<Publisher> findByPublisherName(String name) {
		return pubRepo.searchByName(name);
	}

	public List<Genre> findGenres_Game(long id) {
		return gameRepo.listGenre(id);
	}

	/*
	 * public Game findGameByPID(long id) { return gameRepo.findByPID(id); }
	 */

	public List<Publisher> findAllPublishers() {
		return pubRepo.findAll();
	}

	public Publisher FindPublisherById(long id) {
		return pubRepo.findById(id);
	}

	public void createPublisher(Publisher Publisher) {
		pubRepo.create(Publisher);
	}

	public void deletePublisher(long id) {
		pubRepo.delete(id);
	}

	public List<Game> findGames_Publisher(long id) {
		return pubRepo.findGames(id);
	}

	public void deleteGameByPID(long id) {
		pubRepo.deleteByPID(id);
	}

	public List<Genre> findAllGenres() {
		return genRepo.findAll();
	}

	public Genre FindGenreById(long id) {
		return genRepo.findById(id);
	}

	public void createGenre(Genre Genre) {
		genRepo.create(Genre);
	}

	public void deleteGenre(long id) {
		genRepo.delete(id);
	}

	public List<Game> findGames_Genre(long id) {
		return genRepo.findGames(id);
	}

	public void deleteGameByGID(long id) {
		genRepo.deleteByGID(id);
	}

	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	public User FindUserById(long id) {
		return userRepo.findById(id);
	}

	public void createUser(User User) {
		userRepo.create(User);
	}

	public void deleteUser(long id) {
		userRepo.delete(id);
	}

	public void updateUser(User User) {
		userRepo.update(User);
	}

	public List<Admin> findAllAdmins() {
		return adminRepo.findAll();
	}

	public Admin FindAdminById(long id) {
		return adminRepo.findById(id);
	}

	public void createAdmin(Admin Admin) {
		adminRepo.create(Admin);
	}

	public void deleteAdmin(long id) {
		adminRepo.delete(id);
	}

	public void updateAdmin(Admin Admin) {
		adminRepo.update(Admin);
	}

	public Publisher findPublisherOfGame(long id) {
		return gameRepo.findPublisherOfGame(id);
	}

	public List<Publisher> findTopFivePublisher() {
		return pubRepo.findAllByDesc();
	}

	public List<Game> findTopFive() {
		return gameRepo.findTopFive();
	}

	public List<Game> findGamesDesc() {
		return gameRepo.findAllByDesc();
	}

	public Genre findGenreByName(String name) {
		return genRepo.findByName(name);
	}
}
