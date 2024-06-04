package ynu.edu.impl;

import ynu.edu.dao.IUserDao;
import ynu.edu.pojo.User;
import ynu.edu.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao iUserDao;

    @Override
    public User getUserByIdByPass(String userId, String password) {
        return iUserDao.findUserByUserIdAndPassword(userId, password);
    }

    @Override
    public User getUserById(String userId) {
        User user = iUserDao.findUserByUserId(userId);
        return user;
    }

    @Override
    public int saveUser(User user) {
        user.setDelTag(1);
        user = iUserDao.save(user);
        return user.getUserId() != null ? 1 : 0;
    }

    @Override
    public Boolean updatePassword(String userId, String oldPwd, String newPwd) {
        User user = this.iUserDao.findUserByUserIdAndPassword(userId,oldPwd);
        if (user == null){
            return false;
        }
        user.setPassword(newPwd);
        iUserDao.save(user);
        return true;
    }
}
