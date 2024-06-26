package ynu.edu.controller;

import ynu.edu.pojo.Orders;
import ynu.edu.service.IOrdersService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@CrossOrigin
@RestController
public class OrdersController {
    @Resource
    IOrdersService iOrdersService;
    @PostMapping("/createOrders")
    int createOrders(@RequestParam("userId") String userId,
                     @RequestParam("businessId") Integer businessId,
                     @RequestParam("daId") Integer daId,
                     @RequestParam("orderTotal") Double orderTotal){
        return iOrdersService.createOrders(userId, businessId, daId, orderTotal);
    }
    @PostMapping("/getOrdersById")
    Orders getOrdersById(@RequestParam("orderId") Integer orderId){
        return iOrdersService.getOrdersById(orderId);
    }
    @PostMapping("/listOrdersByUserId")
    List<Orders> listOrdersByUserId(@RequestParam("userId") String userId){
        return iOrdersService.listOrdersByUserId(userId);
    }
    @PostMapping("/payment")
    int payment(@RequestParam("orderId") int orderId){
        return iOrdersService.payment(orderId);
    }
}
