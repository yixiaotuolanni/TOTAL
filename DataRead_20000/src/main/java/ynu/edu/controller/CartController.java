package ynu.edu.controller;



import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.pojo.Cart;
import ynu.edu.service.ICartService;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/CartController")
public class CartController {
    @Resource
    ICartService iCartService;

    @PostMapping("/listCart")
    public List<Cart> listCart(@RequestParam String userId,
                               @RequestParam(required = false) Integer businessId) {
        return iCartService.listCart(userId,businessId);
    }

    @PostMapping("/saveCart")
    public int saveCart(@RequestParam String userId,
                        @RequestParam Integer businessId,
                        @RequestParam Integer foodId) {
        return iCartService.saveCart(userId, businessId, foodId);
    }

    @PostMapping("/updateCart")
    public int updateCart(@RequestParam String userId,
                          @RequestParam Integer businessId,
                          @RequestParam Integer foodId,
                          @RequestParam Integer quantity) {
        return iCartService.updateCart(userId, businessId, foodId, quantity);
    }


    @PostMapping("/removeCart")
    public int removeCart(@RequestParam String userId,
                          @RequestParam Integer businessId,
                          @RequestParam(required = false) Integer foodId) {
        return iCartService.removeCart(userId, businessId, foodId);
    }




}
