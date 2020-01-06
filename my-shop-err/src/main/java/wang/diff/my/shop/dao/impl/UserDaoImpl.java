package wang.diff.my.shop.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import wang.diff.my.shop.dao.UserDao;
import wang.diff.my.shop.entity.User;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User getUser(String email, String password) {
        logger.debug("调试 getUser(), email : {} , password : {}", email, password);
        User user = null;

        if ("admin@diff.wang".equals(email)){
            if ("admin".equals(password)) {
                user = new User();
                user.setEmail("admin@diff.wang");
                user.setUsername("airvip");

                logger.info("成功获取 {} 的用户名信息", user.getUsername());
            }
        } else {
            logger.warn("获取 {} 失败", email);
        }

        return user;
    }
}
