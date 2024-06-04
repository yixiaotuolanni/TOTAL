package ynu.edu.dao;

import ynu.edu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, String> {
//    User findUserByUserIdAndPassword(String userID, String pwd);
    User findUserByUserId(String userId);
    User findUserByUserIdAndPassword(String userId,String password);
}
