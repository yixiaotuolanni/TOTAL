package ynu.edu.controller;

import ynu.edu.pojo.Orders;
import ynu.edu.service.IOrdersService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/OrdersController")
@CrossOrigin
@RestController
public class OrdersController {
    @Resource
    IOrdersService iOrdersService;
    @PostMapping("/createOrders")
    int createOrders(@RequestParam String userId,
                     @RequestParam Integer businessId,
                     @RequestParam Integer daId,
                     @RequestParam Double orderTotal){
        return iOrdersService.createOrders(userId, businessId, daId, orderTotal);
    }
    @PostMapping("/getOrdersById")
    Orders getOrdersById(@RequestParam Integer orderId){
        return iOrdersService.getOrdersById(orderId);
    }
    @PostMapping("/listOrdersByUserId")
    List<Orders> listOrdersByUserId(@RequestParam String userId){
        return iOrdersService.listOrdersByUserId(userId);
    }
    @PostMapping("/payment")
    int payment(@RequestParam int orderId){
        return iOrdersService.payment(orderId);
    }
}
