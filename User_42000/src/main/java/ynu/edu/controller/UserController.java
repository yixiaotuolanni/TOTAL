package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ynu.edu.ImplFeign.ImplAuth;
import ynu.edu.feign.UserFeignClient;
import ynu.edu.pojo.Result;
import ynu.edu.pojo.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserFeignClient userFeignClient;

    @Resource
    private ImplAuth implAuth;

    @PostMapping("/saveUser")
    public int saveUser(@RequestBody User user) {
        logger.info("Saving user: {}", user);
        int result = userFeignClient.saveUser(user);
        logger.info("Saved user with result: {}", result);
        return result;
    }

    @PostMapping("/getUserById")
    public User getUserById(@RequestParam("userId") String userId) {
        logger.info("Getting user by ID: {}", userId);
        User user = userFeignClient.getUserById(userId);
        logger.info("Retrieved user: {}", user);
        return user;
    }

    @PostMapping("/logIn")
    public Mono<Result<User>> logIn(@RequestParam("userId") String userId,
                                    @RequestParam("password") String password) {
        logger.info("Logging in user with ID: {}", userId);
        return Mono.fromCallable(() -> userFeignClient.logIn(userId, password))
                .flatMap(user -> implAuth.getToken(user.getUserId())
                        .flatMap(token -> {
                            Result<User> result = new Result<>();
                            result.setStatus(HttpStatus.OK);
                            result.setToken(token);
                            result.setMessage(user);
                            logger.info("User logged in successfully: {}", user);
                            return Mono.just(result);
                        }))
                .onErrorResume(e -> {
                    logger.error("Error occurred during login: {}", e.getMessage());
                    Result<User> result = new Result<>();
                    result.setStatus(HttpStatus.UNAUTHORIZED);
                    result.setMessage(null);
                    result.setToken(null);
                    return Mono.just(result);
                });
    }

    @PostMapping(value = "/updatePwd")
    public Boolean updatePwd(@RequestParam String id,
                             @RequestParam String oldPwd,
                             @RequestParam String newPwd) {
        logger.info("Updating password for user with ID: {}", id);
        Boolean result = userFeignClient.updatePwd(id, oldPwd, newPwd);
        logger.info("Password updated successfully: {}", result);
        return result;
    }
}
