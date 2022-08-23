package by.denis.project.test.service;

import by.denis.project.test.model.Author;
import java.util.Optional;

public interface AuthorService {

  Iterable<Author> readAll();

  Optional<Author> readById(Long id);

  Author create(Author author);

  Author update(Author author);

  void deleteById(long id);
}
