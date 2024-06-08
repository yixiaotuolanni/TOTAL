package edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.feign.CartFeignClient;
import ynu.edu.pojo.Cart;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/business")
public class CartController {
    @Resource
    CartFeignClient cartFeignClient;

    @PostMapping("/listCart")
    public List<Cart> listCart(@RequestParam String userId,
                               @RequestParam(required = false) Integer businessId) {
        return cartFeignClient.listCart(userId,businessId);
    }

    @PostMapping("/saveCart")
    public int saveCart(@RequestParam String userId,
                        @RequestParam Integer businessId,
                        @RequestParam Integer foodId) {
        return cartFeignClient.saveCart(userId, businessId, foodId);
    }

    @PostMapping("/updateCart")
    public int updateCart(@RequestParam String userId,
                          @RequestParam Integer businessId,
                          @RequestParam Integer foodId,
                          @RequestParam Integer quantity) {
        return cartFeignClient.updateCart(userId, businessId, foodId, quantity);
    }


    @PostMapping("/removeCart")
    public int removeCart(@RequestParam String userId,
                          @RequestParam Integer businessId,
                          @RequestParam(required = false) Integer foodId) {
        return cartFeignClient.removeCart(userId, businessId, foodId);
    }

}
