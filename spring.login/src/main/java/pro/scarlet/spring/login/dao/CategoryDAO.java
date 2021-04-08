package pro.scarlet.spring.login.dao;

import pro.scarlet.spring.login.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
    
}
