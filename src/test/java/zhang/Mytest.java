package zhang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhang.bean.User;
import zhang.dao.UserDao;
import zhang.service.UserService;

import java.util.UUID;

/**
 * Created by zhang on 2016/6/18.
 */
public class Mytest {
     ApplicationContext context=new ClassPathXmlApplicationContext("spring-application.xml");

    public static void main(String[] args) {
//        new Mytest().daoSelect();
//        new Mytest().daoInsert();
//        new Mytest().serviceInsert();
        new Mytest().daoDelete();
    }

    public void serviceInsert(){
        User user=new User(UUID.randomUUID().toString(),"哈哈哈",25);
        UserService bean = context.getBean(UserService.class);
//        bean.add(user);
    }

    public void daoSelect(){
        UserDao bean = context.getBean(UserDao.class);
        System.out.println("size:"+bean.list().size());
        System.out.println(bean.list());
    }

    public void daoInsert(){
        User user=new User(UUID.randomUUID().toString(),"哈哈哈",25);
        UserDao bean = context.getBean(UserDao.class);
//        bean.insert(user);
    }

    public void daoDelete(){
        UserDao bean = context.getBean(UserDao.class);
//        bean.delete("44242fbf-7c58-496d-8ede-60de4d7848b0");
    }
}
