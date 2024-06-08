package edu.controller;

import edu.feign.OrdersFeignClient;
import edu.pojo.Orders;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@CrossOrigin
@RestController
public class OrdersController {
    @Resource
    OrdersFeignClient ordersFeignClient;
    @PostMapping("/createOrders")
    int createOrders(@RequestParam("userId") String userId,
                     @RequestParam("businessId") Integer businessId,
                     @RequestParam("daId") Integer daId,
                     @RequestParam("orderTotal") Double orderTotal){
        return ordersFeignClient.createOrders(userId, businessId, daId, orderTotal);
    }
    @PostMapping("/getOrdersById")
    Orders getOrdersById(@RequestParam("orderId") Integer orderId){
        return ordersFeignClient.getOrdersById(orderId);
    }
    @PostMapping("/listOrdersByUserId")
    List<Orders> listOrdersByUserId(@RequestParam("userId") String userId){
        return ordersFeignClient.listOrdersByUserId(userId);
    }
    @PostMapping("/payment")
    int payment(@RequestParam("orderId") int orderId){
        return ordersFeignClient.payment(orderId);
    }
}