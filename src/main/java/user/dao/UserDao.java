package user.dao;

import user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User, Integer> {

    User findByAccount(String account);

    User findById(int Id);
}



