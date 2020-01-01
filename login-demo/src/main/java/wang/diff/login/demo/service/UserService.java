package wang.diff.login.demo.service;

import wang.diff.login.demo.entity.User;

public interface UserService {
    public User login(String loginId, String loginPwd);
}
