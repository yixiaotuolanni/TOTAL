package ynu.edu.service;


import ynu.edu.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
        User getUserByIdByPass(String userId, String password);
        User getUserById(String userId);
        int saveUser(User user);
        public Boolean updatePassword(String userId, String oldPwd, String newPwd);
}
