package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.pojo.User;
import ynu.edu.service.IUserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {
    @Resource
    private IUserService userService;
    @PostMapping("/saveUser")
    public int saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PostMapping("/getUserById")
    public User getUserById(@RequestParam("userId") String userId) {
        return userService.getUserById(userId);
    }
    @PostMapping("/logIn")
    public User logIn(@RequestParam("userId") String userId,
                        @RequestParam("password") String password) {
        User user = userService.getUserByIdByPass(userId, password);
        return user;
    }
    @PostMapping(value = "/updatePwd")
    public Boolean updatePwd(@RequestParam String id,
                             @RequestParam String oldPwd,
                             @RequestParam String newPwd){
        return userService.updatePassword(id, oldPwd, newPwd);
    }

}
