package zhang.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhang.bean.User;
import zhang.dao.UserDao;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhang on 2016/6/19.
 */
@Service
@Transactional
public class UserService {
    @Resource
    private UserDao userDao;

    public void add(User user) {
        if(user.getId()==null||user.getId().equals("")){
            user.setId(UUID.randomUUID().toString());
        }
        userDao.insert(user);
//        System.out.println(1/0);
    }

    public void delete(String id){
        userDao.delete(id);
    }

    public List<User> queryAll() {
        return userDao.list();
    }
}
