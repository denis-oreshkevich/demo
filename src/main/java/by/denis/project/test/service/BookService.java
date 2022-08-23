package by.denis.project.test.service;

import by.denis.project.test.model.Book;
import java.util.Optional;

public interface BookService {

  Iterable<Book> readAll();

  Optional<Book> readById(Long id);

  Book create(Book book);

  Book update(Book book);

  void deleteById(long id);
}
