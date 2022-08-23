package by.denis.project.test.controller;

import by.denis.project.test.model.Book;
import by.denis.project.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/book")
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public Object readAll() {
    return bookService.readAll();
  }

  @GetMapping("/{id}")
  public Object readById(@PathVariable Long id) {
    return bookService.readById(id);
  }

  @PostMapping
  public Object createBook(@RequestBody Book book) {
    return bookService.create(book);
  }

  @PutMapping
  public Object updateBook(@RequestBody Book book) {
    return bookService.update(book);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Long id) {
    bookService.deleteById(id);
  }
}
