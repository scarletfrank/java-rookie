package pro.scarlet.spring.login.dao;

import pro.scarlet.spring.login.pojo.Book;
import pro.scarlet.spring.login.pojo.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Integer>{
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
