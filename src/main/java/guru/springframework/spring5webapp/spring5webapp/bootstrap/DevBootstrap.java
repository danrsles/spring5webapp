package guru.springframework.spring5webapp.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.spring5webapp.model.Author;
import guru.springframework.spring5webapp.spring5webapp.model.Book;
import guru.springframework.spring5webapp.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.spring5webapp.repositories.PublisherRepository;
/**
 * Created by jt on 5/16/17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
    		PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
    	
    	  Publisher ppp = new Publisher("Harper Collins","test");
          publisherRepository.save(ppp);
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234",ppp);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod

        Publisher pp1 = new Publisher( "Wrox","test");
        publisherRepository.save(pp1);
        
        publisherRepository.save(pp1);
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", pp1 );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
       
    }
}