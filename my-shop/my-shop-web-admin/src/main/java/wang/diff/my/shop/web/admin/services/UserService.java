package wang.diff.my.shop.web.admin.services;

import wang.diff.my.shop.domain.User;

public interface UserService {
    public User login(String email, String password);
}
