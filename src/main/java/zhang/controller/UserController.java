package zhang.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zhang.bean.User;
import zhang.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2016/6/19.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        List<User> users = userService.queryAll();
        map.put("users",users);
        return "list";
    }

    @RequestMapping(value = "/add",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Boolean add(User user){
        try {
            userService.add(user);
        } catch (Exception e) {
            LoggerFactory.getLogger(getClass()).error(e.getMessage(),e);
            return false;
        }
        return true;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Boolean delete(@RequestParam String id){
        try {
            userService.delete(id);
        } catch (Exception e) {
            LoggerFactory.getLogger(getClass()).error(e.getMessage(),e);
            return false;
        }
        return true;
    }

}
