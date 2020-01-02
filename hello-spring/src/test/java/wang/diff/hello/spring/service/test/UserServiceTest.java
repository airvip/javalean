package wang.diff.hello.spring.service.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wang.diff.hello.spring.service.UserService;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void before() {
        System.out.println("初始化数据库");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        userService = (UserService) applicationContext.getBean("userService");
    }

    @Test
    public void testSayHi()
    {
        userService.sayHi();
    }

    @Test
    public void testSayHello()
    {
        System.out.println("Hello JUnit");
    }


    @After
    public void after() {
        System.out.println("关闭数据库连接");
    }
}
