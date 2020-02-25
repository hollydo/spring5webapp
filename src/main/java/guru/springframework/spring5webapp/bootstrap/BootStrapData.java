package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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

        Publisher addison = new Publisher("Addison-WesleyProfessional", "123 Main", "Seattle", "Washington","32233");
        publisherRepository.save(addison);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(addison);
        addison.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(addison);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2345432");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(addison);
        addison.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(addison);




        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher: " + publisherRepository.count());
    }
}
