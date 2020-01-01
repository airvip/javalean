package wang.diff.login.demo.dao;

import wang.diff.login.demo.entity.User;

public interface UserDao {
    public User login(String loginId, String loginPwd);
}
