package ynu.edu.impl;

import ynu.edu.dao.*;
import ynu.edu.pojo.*;
import ynu.edu.service.IOrdersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OrdersServiceImpl implements IOrdersService {
    @Resource
    IOrdersDao iOrdersDao;
    @Resource
    IOrderDetailetDao iOrderDetailetDao;
    @Resource
    IUserDao iUserDao;
    @Resource
    IBusinessDao iBusinessDao;
    @Resource
    IDeliverAddressDao iDeliverAddressDao;
    @Resource
    ICartDao iCartDao;
    @Override
    @Transactional
    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal) {
        User user = iUserDao.findUserByUserId(userId);
        Business business = iBusinessDao.findBusinessByBusinessId(businessId);
        DeliveryAddress deliveryAddress = iDeliverAddressDao.findDeliveryAddressByDaId(daId);

        Orders orders = new Orders();
        orders.setBusiness(business);
        orders.setDeliveryAddress(deliveryAddress);
        orders.setOrderTotal(orderTotal);

        user.addOrders(orders);

        List<Cart> carts = iCartDao.findCartsByUser_UserIdAndBusiness_BusinessId(userId,businessId);
        for (Cart cart: carts){
            OrderDetail orderDetailet = new OrderDetail();
            orderDetailet.setFood(cart.getFood());
            orderDetailet.setQuantity(cart.getQuantity());
            orders.addOrderDetail(orderDetailet);
            user.removeCarts(cart);
        }
        iUserDao.save(user);
        return orders.getOrderId();
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return iOrdersDao.listOrdersById(orderId);
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        User user = iUserDao.findUserByUserId(userId);
        return user.getOrders();
    }

    public int payment(Integer orderId){
        Orders order = iOrdersDao.getReferenceById(orderId);
        order.setOrderState(1);
        iOrdersDao.save(order);
        return order.getOrderState();
    }
}
