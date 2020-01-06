package wang.diff.my.shop.service.impl;

import org.springframework.stereotype.Service;
import wang.diff.my.shop.commons.context.SpringContext;
import wang.diff.my.shop.dao.UserDao;
import wang.diff.my.shop.entity.User;
import wang.diff.my.shop.service.UserService;

// all ok

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao = SpringContext.getBean("userDao");

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
