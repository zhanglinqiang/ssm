package zhang.dao;

import zhang.bean.User;

import java.util.List;

/**
 * Created by zhang on 2016/6/5.
 */
public interface UserDao {
    List<User> list();
    void insert(User user);
    void delete(String id);
}
