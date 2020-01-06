package wang.diff.my.shop.web.admin.dao;

import wang.diff.my.shop.domain.User;

public interface UserDao {

    public User getUser(String email, String password);
}
