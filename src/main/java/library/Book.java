package library;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long bookId;
	private String bookTitle;

	@ManyToOne
	private Genre genre;

	@ManyToMany
	private Set<Author> authors;

	protected Book() {

	}

	public Book(Genre genre, String bookTitle, Author... authors) {
		this.bookTitle = bookTitle;
		this.authors = new HashSet<>(Arrays.asList(authors));
		this.genre = genre;
	}

	public Genre getGenre() {
		return genre;
	}

	public Long getBookId() {
		return bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	@Override
	public String toString() {
		return String.format("Book[bookID=%d, genre='%s', bookTitle='%s', author='%s']", bookId, genre, bookTitle,
				authors);
	}
}
