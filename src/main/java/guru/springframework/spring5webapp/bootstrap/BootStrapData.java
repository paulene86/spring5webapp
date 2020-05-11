package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Author paulo = new Author("Paulo","Salazar");
		Book elprincipito = new Book("El Principito","666");
		Book kamasutra = new Book("kamasutra","99");

		paulo.getBooks().add(elprincipito);
		elprincipito.getAuthors().add(paulo);

		Publisher pedroPub = new Publisher();
		pedroPub.setAddressLine1("Vk");
		pedroPub.setCity("Mad");
		publisherRepository.save(pedroPub);

		elprincipito.setPublisher(pedroPub);
		pedroPub.getBooks().add(elprincipito);

		pedroPub.getBooks().add(kamasutra);

		authorRepository.save(paulo);
		bookRepository.save(elprincipito);
		publisherRepository.save(pedroPub);



		System.out.println("Numnber of books saved : "+bookRepository.count());
		System.out.println("Numnber of publisher saved : "+publisherRepository.count());

	}
}
