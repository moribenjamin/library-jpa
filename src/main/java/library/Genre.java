package library;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long genreId;

	private String genreName;

	@OneToMany(mappedBy = "genre")
	private Set<Book> booksInGenre = new HashSet<Book>();

	protected Genre() {

	}

	public Genre(String genreName) {
		this.genreName = genreName;
	}

	public Long getGenreId() {
		return genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public Set<Book> getBooksInGenre() {
		return booksInGenre;
	}

	@Override
	public String toString() {
		return String.format("Genre[genreId=%d, genreName='%s']", genreId, genreName);
	}
}
