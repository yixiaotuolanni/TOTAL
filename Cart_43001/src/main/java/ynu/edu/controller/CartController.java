package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.feign.CartFeignClient;
import ynu.edu.pojo.Cart;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/cart")
public class CartController {
    @Resource
    CartFeignClient cartFeignClient;

    @PostMapping("/listCart")
    public List<Cart> listCart(@RequestParam("userId") String userId,
                               @RequestParam(name = "businessId",required = false) Integer businessId) {
        return cartFeignClient.listCart(userId,businessId);
    }

    @PostMapping("/saveCart")
    public int saveCart(@RequestParam("userId") String userId,
                        @RequestParam("businessId") Integer businessId,
                        @RequestParam("foodId") Integer foodId) {
        return cartFeignClient.saveCart(userId, businessId, foodId);
    }

    @PostMapping("/updateCart")
    public int updateCart(@RequestParam("userId") String userId,
                          @RequestParam("businessId") Integer businessId,
                          @RequestParam("foodId") Integer foodId,
                          @RequestParam("quantity") Integer quantity) {
        return cartFeignClient.updateCart(userId, businessId, foodId, quantity);
    }


    @PostMapping("/removeCart")
    public int removeCart(@RequestParam("userId") String userId,
                          @RequestParam("businessId") Integer businessId,
                          @RequestParam("foodId") Integer foodId) {
        return cartFeignClient.removeCart(userId, businessId, foodId);
    }

}
