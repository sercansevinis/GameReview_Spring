package sen3004.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "pname")
	@Size(min = 3, max = 20)
	private String name;

	@OneToMany(mappedBy = "publisher")
	@org.hibernate.annotations.OrderBy(clause = "id")
	private Set<Game> gamesP = new HashSet<>();

	@Column(name = "loc")
	@Size(min = 3, max = 20)
	private String location;

	@Column(name = "avgrate")
	private Double avgscore;

	@Column(name = "url")
	@URL
	private String url;

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

	public Set<Game> getGames() {
		return gamesP;
	}

	public void setGames(Set<Game> games) {
		this.gamesP = games;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getAvgscore() {
		double sum = 0;
		Object[] gamesArr = gamesP.toArray();
		for (int i = 0; i < gamesArr.length; i++) {
			sum += ((Game) gamesArr[i]).getReviewRate();
		}
		double result = Math.round(sum / gamesArr.length * 100.) / 100.0;
		return result;
	}

	public void setAvgscore(Double avgscore) {
		this.avgscore = avgscore;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
