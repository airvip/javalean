package wang.diff.login.demo.dao.impl;

import wang.diff.login.demo.dao.UserDao;
import wang.diff.login.demo.entity.User;

public class UserDaoImpl implements UserDao {

    /**
     * 用户登录
     * @param loginId 登录ID
     * @param loginPwd 登录密码
     * @return
     */
    public User login(String loginId, String loginPwd) {

        User user = null;

        // 直接根据 loginid 查询出用户
        if ("admin".equals(loginId))
            // 再根据传入的密码进行匹配
            if ("admin".equals(loginPwd))
            {
                user = new User();
                user.setLoginId("admin");
                user.setLoginPwd("admin");
                user.setUsername("airvip");
            }


        return user;
    }
}
