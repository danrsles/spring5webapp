package guru.springframework.spring5webapp.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

//import guru.springframework.spring5webapp.spring5webapp.model.Author;
import guru.springframework.spring5webapp.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}