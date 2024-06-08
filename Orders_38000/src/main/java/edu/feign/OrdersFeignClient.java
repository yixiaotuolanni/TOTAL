package edu.feign;

import edu.pojo.Orders;
import edu.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "data-read")
public interface OrdersFeignClient {
    String path = "/dataread/orders";
    @PostMapping(path+"/createOrders")
    int createOrders(@RequestParam("userId") String userId,
                     @RequestParam("businessId") Integer businessId,
                     @RequestParam("daId") Integer daId,
                     @RequestParam("orderTotal") Double orderTotal);
    @PostMapping(path+"/getOrdersById")
    Orders getOrdersById(@RequestParam("orderId") Integer orderId);
    @PostMapping(path+"/listOrdersByUserId")
    List<Orders> listOrdersByUserId(@RequestParam("userId") String userId);
    @PostMapping(path+"/payment")
    int payment(@RequestParam("orderId") int orderId);
}
