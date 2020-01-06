package wang.diff.my.shop.web.admin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.diff.my.shop.domain.User;
import wang.diff.my.shop.web.admin.dao.UserDao;
import wang.diff.my.shop.web.admin.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
