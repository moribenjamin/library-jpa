package library;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long authorId;
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	protected Set<Book> booksByAuthor = new HashSet<Book>();

	// JPA required no args constructor
	protected Author() {
	}

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public Long getAuthorId() {
		return authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Set<Book> getBooksByAuthor() {
		return booksByAuthor;
	}

	@Override
	public String toString() {
		return String.format("Author[authorId=%d, firstName='%s', lastName='%s']", authorId, firstName, lastName);
	}
}
