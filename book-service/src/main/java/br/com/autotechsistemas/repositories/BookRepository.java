package br.com.autotechsistemas.repositories;

import br.com.autotechsistemas.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
