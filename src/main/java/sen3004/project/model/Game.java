package sen3004.project.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "gname")
	@Size(min = 3, max = 50, message = "Length of game name must be between 3 and 50")
	private String name;

	@ManyToOne
	@JoinColumn(name = "pid")
	private Publisher publisher;

	@NotNull(message = "This cannot be empty")
	@Column(name = "rdate")
	@Past(message = "This cannot be a future date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate rdate;

	@ManyToMany
	@OrderBy(value = "id")
	@JoinTable(name = "game_genre", joinColumns = @JoinColumn(name = "gaid"), inverseJoinColumns = @JoinColumn(name = "geid"))
	private Set<Genre> genres = new HashSet<>();

	@NotNull(message = "Score must be entered")
	@Column(name = "rrate")
	@Min(value = 0, message = "Game score cannot be below than zero")
	@Max(value = 100, message = "Game score cannot be above than a hundred")
	private Integer ReviewRate;

	@Column(name = "Platforms")
	@Size(min = 2, max = 50, message="Length must be between 2 and 50")
	@NotEmpty(message = "This cannot be empty")
	private String platforms;

	@Transient
	public String[] genreNames;

	@Transient
	public String pubName;

	public void addGenre(Genre genre) {
		genres.add(genre);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public LocalDate getRdate() {
		return rdate;
	}

	public void setRdate(LocalDate rdate) {
		this.rdate = rdate;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Integer getReviewRate() {
		return ReviewRate;
	}

	public void setReviewRate(Integer avgrate) {
		this.ReviewRate = avgrate;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public String[] getGenreNames() {
		return genreNames;
	}

	public void setGenreNames(String[] genreNames) {
		this.genreNames = genreNames;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
}
