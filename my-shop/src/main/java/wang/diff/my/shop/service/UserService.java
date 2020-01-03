package wang.diff.my.shop.service;

import wang.diff.my.shop.entity.User;

public interface UserService {
    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    public User login(String email, String password);
}
