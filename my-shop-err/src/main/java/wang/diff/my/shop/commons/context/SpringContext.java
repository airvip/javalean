package wang.diff.my.shop.commons.context;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringContext implements ApplicationContextAware, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(SpringContext.class);
    
    private static ApplicationContext applicationContext;

    /**
     *使用 ApplicationContext，根据beanId 获取实例
     * @param beadId
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beadId){
        assertContextInjected();
        return (T) applicationContext.getBean(beadId);
    }

    /**
     * 使用 ApplicationContext，根据 class 获取实例
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        assertContextInjected();
        return  applicationContext.getBean(clazz);
    }
    
    @Override
    public void destroy() throws Exception {
        logger.debug("清空 ApplicationContext");
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         SpringContext.applicationContext = applicationContext;
    }

    private static void assertContextInjected() {
        Validate.validState(applicationContext == null, "您还没在 spring-context.xml 中配置 SpringContext 对象");
    }
}
