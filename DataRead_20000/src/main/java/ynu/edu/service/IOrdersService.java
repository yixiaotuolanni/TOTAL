package ynu.edu.service;

import ynu.edu.pojo.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IOrdersService {
    int createOrders(String userId, Integer businessId,Integer daId,Double orderTotal);

    Orders getOrdersById(Integer orderId);

    List<Orders> listOrdersByUserId(String userId);

    int payment(Integer orderId);
}
