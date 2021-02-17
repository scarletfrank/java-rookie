package pro.scarlet.spring.login.dao;

import pro.scarlet.spring.login.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User getByUsernameAndPassword(String username, String password);
}
