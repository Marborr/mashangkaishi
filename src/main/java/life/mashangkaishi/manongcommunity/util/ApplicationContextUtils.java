package life.mashangkaishi.manongcommunity.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    //参数一是已经创建好了的工厂对象
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
    //工具方法根据beanid获取对象
    public static Object getBean(String id){
        return context.getBean(id);
    }
    //根据类型获取工厂中的对象
    public static Object getBean(Class clazz){
        return context.getBean(clazz);
    }
}
