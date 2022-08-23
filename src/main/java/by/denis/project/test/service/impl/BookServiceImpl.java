package by.denis.project.test.service.impl;

import by.denis.project.test.model.Book;
import by.denis.project.test.repository.BookCrudRepository;
import by.denis.project.test.service.BookService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

  private final BookCrudRepository bookCrudRepository;

  @Autowired
  public BookServiceImpl(BookCrudRepository bookCrudRepository) {
    this.bookCrudRepository = bookCrudRepository;
  }

  @Override
  public Iterable<Book> readAll() {
    return bookCrudRepository.findAll();
  }

  @Override
  public Optional<Book> readById(Long id) {
    return bookCrudRepository.findById(id);
  }

  @Override
  @Transactional
  public Book create(Book book) {
    return bookCrudRepository.save(book);
  }

  @Override
  @Transactional
  public Book update(Book book) {
    bookCrudRepository.update(book.getCode(), book.getName(), book.getAuthor());
    return book;
  }

  @Override
  @Transactional
  public void deleteById(long id) {
    bookCrudRepository.deleteById(id);
  }
}
