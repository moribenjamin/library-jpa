package library;

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
	private Author author;

	protected Book() {

	}

	@ManyToMany(mappedBy = "books")
	public Set getAuthors() {
		return authors;
	}

	public Book(String bookTitle, Author author) {
		this.bookTitle = bookTitle;
		this.author = author;
	}

	public Long getBookId() {
		return bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public Author getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return String.format("Book[bookID=%d, bookTitle='%s', author='%s']", bookId, bookTitle, author);
	}
}
