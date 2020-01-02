package wang.diff.hello.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wang.diff.hello.spring.service.UserService;

import java.util.Arrays;

public class MyTest {

    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.sayHi();

        logger.info("info 级别的日志");
        logger.debug("debug 级别的日志");
        logger.warn("warn 级别的日志");
        logger.error("error 级别的日志");

        String message = "测试";
        logger.info("message is : {}" , message);

        System.out.println(String.format("message is : %s %s", message, message));
    }
}
