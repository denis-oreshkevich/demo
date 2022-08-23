package by.denis.project.test.controller;

import by.denis.project.test.model.Author;
import by.denis.project.test.service.AuthorService;
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
@RequestMapping(path = "/author")
public class AuthorController {

  private final AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping
  public Object readAll() {
    return authorService.readAll();
  }

  @GetMapping("/{id}")
  public Object readById(@PathVariable Long id) {
    return authorService.readById(id);
  }

  @PostMapping
  public Object createAuthor(@RequestBody Author author) {
    return authorService.create(author);
  }

  @PutMapping
  public Object updateAuthor(@RequestBody Author author) {
    return authorService.update(author);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthor(@PathVariable Long id) {
    authorService.deleteById(id);
  }
}
