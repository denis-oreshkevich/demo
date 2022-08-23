package by.denis.project.test.service.impl;

import by.denis.project.test.model.Author;
import by.denis.project.test.repository.AuthorCrudRepository;
import by.denis.project.test.service.AuthorService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

  private final AuthorCrudRepository authorCrudRepository;

  @Autowired
  public AuthorServiceImpl(AuthorCrudRepository authorCrudRepository) {
    this.authorCrudRepository = authorCrudRepository;
  }

  @Override
  public Iterable<Author> readAll() {
    return authorCrudRepository.findAll();
  }

  @Override
  public Optional<Author> readById(Long id) {
    return authorCrudRepository.findById(id);
  }

  @Override
  @Transactional
  public Author create(Author author) {
    return authorCrudRepository.save(author);
  }

  @Override
  @Transactional
  public Author update(Author author) {
    authorCrudRepository.update(author.getCode(), author.getName());
    return author;
  }

  @Override
  @Transactional
  public void deleteById(long id) {
    authorCrudRepository.deleteById(id);
  }
}
