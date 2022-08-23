package by.denis.project.test.repository;

import by.denis.project.test.model.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorCrudRepository extends CrudRepository<Author, Long> {

  @Modifying
  @Query("update Author a set a.name = :name where a.code = :code")
  void update(@Param("code") Long code, @Param("name") String name);
}
