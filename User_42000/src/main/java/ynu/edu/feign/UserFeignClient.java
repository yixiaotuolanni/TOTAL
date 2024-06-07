package ynu.edu.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ynu.edu.pojo.Food;
import ynu.edu.pojo.User;

import java.util.List;

@FeignClient(name = "data-read")
public interface UserFeignClient {
    String path = "/dataread/user";
    @PostMapping(path+"/saveUser")
    int saveUser(@RequestBody User user);
    @PostMapping(path+"/getUserById")
    User getUserById(@RequestParam("userId") String userId);
    @PostMapping(path+"/logIn")
    User logIn(@RequestParam("userId") String userId,
                        @RequestParam("password") String password);
    @PostMapping(path+"/updatePwd")
    Boolean updatePwd(@RequestParam("id") String id,
                             @RequestParam("oldPwd") String oldPwd,
                             @RequestParam("newPwd") String newPwd);
}
