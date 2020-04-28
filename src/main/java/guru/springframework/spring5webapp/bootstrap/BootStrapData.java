package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Author paulo = new Author("Paulo","Salazar");
		Book elprincipito = new Book("El Principito","666");

		paulo.getBooks().add(elprincipito);
		elprincipito.getAuthors().add(paulo);

		authorRepository.save(paulo);
		bookRepository.save(elprincipito);

		System.out.println("Numnber of books saved : "+bookRepository.count());

	}
}
