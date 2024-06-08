package edu.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Orders {

    private Integer orderId;
    private String orderDate;

    private Double orderTotal;

    private Integer orderState;

    private List<OrderDetail> orderDetails = new ArrayList<>();

    private DeliveryAddress deliveryAddress;

    private User user;

    private Business business;

    public void addOrderDetail(OrderDetail orderDetail){
        this.orderDetails.add(orderDetail);
        orderDetail.setOrder(this);
    }

    public Orders(){
        this.orderDate = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString();
        this.orderState = 0;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
