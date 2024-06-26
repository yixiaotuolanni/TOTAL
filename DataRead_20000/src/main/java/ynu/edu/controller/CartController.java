package ynu.edu.controller;



import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.pojo.Cart;
import ynu.edu.service.ICartService;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    @Resource
    ICartService iCartService;

    @PostMapping("/listCart")
    public List<Cart> listCart(@RequestParam("userId") String userId,
                               @RequestParam(name = "businessId",required = false) Integer businessId) {
        return iCartService.listCart(userId,businessId);
    }

    @PostMapping("/saveCart")
    public int saveCart(@RequestParam("userId") String userId,
                        @RequestParam("businessId") Integer businessId,
                        @RequestParam("foodId") Integer foodId) {
        return iCartService.saveCart(userId, businessId, foodId);
    }

    @PostMapping("/updateCart")
    public int updateCart(@RequestParam("userId") String userId,
                          @RequestParam("businessId") Integer businessId,
                          @RequestParam("foodId") Integer foodId,
                          @RequestParam("quantity") Integer quantity) {
        return iCartService.updateCart(userId, businessId, foodId, quantity);
    }


    @PostMapping("/removeCart")
    public int removeCart(@RequestParam("userId") String userId,
                          @RequestParam("businessId") Integer businessId,
                          @RequestParam("foodId") Integer foodId) {
        return iCartService.removeCart(userId, businessId, foodId);
    }




}
