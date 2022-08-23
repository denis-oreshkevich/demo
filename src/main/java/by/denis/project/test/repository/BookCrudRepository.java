package by.denis.project.test.repository;

import by.denis.project.test.model.Author;
import by.denis.project.test.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookCrudRepository extends CrudRepository<Book, Long> {

  @Modifying
  @Query("update Book a set a.name = :name, a.author = :author where a.code = :code")
  void update(@Param("code") Long code, @Param("name") String name, @Param("author") Author author);
}
