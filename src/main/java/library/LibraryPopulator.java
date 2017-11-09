package library;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LibraryPopulator implements CommandLineRunner {

	@Resource
	private AuthorRepository authorRepo;

	@Resource
	private GenreRepository genreRepo;

	@Resource
	private BookRepository bookRepo;

	@Override
	public void run(String... args) throws Exception {
		// save a couple of customers
		Author kathy = new Author("Kathy", "Sierra");
		authorRepo.save(kathy);
		Author bert = new Author("Bert", "Bates");
		authorRepo.save(bert);
		Author elisabeth = new Author("Elisabeth", "Freeman");
		authorRepo.save(elisabeth);
		Author clifford = new Author("Clifford", "Stoll");
		authorRepo.save(clifford);

		Genre genre1 = new Genre("fiction");
		genreRepo.save(genre1);
		Genre genre2 = new Genre("non-fiction");
		genreRepo.save(genre2);

		Book book1 = new Book(genre2, "Head First Design Patterns", kathy, bert);
		bookRepo.save(book1);
		Book book2 = new Book(genre2, "Head Fist Java", kathy, elisabeth);
		bookRepo.save(book2);
		Book book3 = new Book(genre1, "The Cukoo's Egg", clifford);
		bookRepo.save(book3);

	}

	public LibraryPopulator() {

	}
}