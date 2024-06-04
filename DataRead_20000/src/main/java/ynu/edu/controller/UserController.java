package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.pojo.User;
import ynu.edu.service.IUserService;

@RestController
@RequestMapping(value = "/UserController")
@CrossOrigin
public class UserController {
    @Resource
    private IUserService userService;
    @PostMapping("/saveUser")
    public int saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PostMapping("/getUserById")
    public User getUserById(@RequestParam String userId) {
        return userService.getUserById(userId);
    }
    @PostMapping("/logIn")
    public String logIn(@RequestParam String userId,@RequestParam String password) {
        if (userService.getUserByIdByPass(userId,password) == null){
            return null;
        }
        return null;
    }
    @PostMapping(value = "/updatePwd")
    public Boolean updatePwd(@RequestParam String id,
                             @RequestParam String oldPwd,
                             @RequestParam String newPwd){
        return userService.updatePassword(id, oldPwd, newPwd);
    }

}
