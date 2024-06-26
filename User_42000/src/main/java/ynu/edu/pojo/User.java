package ynu.edu.pojo;


import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;

    private String password;

    private String userName;

    private Integer userSex;

    private String userImg;
    private Integer delTag;

    private List<Cart> carts = new ArrayList<>();

    private List<Orders> orders = new ArrayList<>();

    private List<DeliveryAddress> deliverAddresses = new ArrayList<>();

    public void addCarts(Cart cart){
        this.carts.add(cart);
        cart.setUser(this);
    }

    public void addOrders(Orders orders){
        this.orders.add(orders);
        orders.setUser(this);
    }

    public void addDeliveryAddresses(DeliveryAddress deliveryAddress){
        this.deliverAddresses.add(deliveryAddress);
        deliveryAddress.setUser(this);
    }

    public void removeDeliveryAddresses(DeliveryAddress deliveryAddress){
        this.deliverAddresses.remove(deliveryAddress);
        deliveryAddress.setUser(null);
    }


    public void removeCarts(Cart cart){
        this.carts.remove(cart);
        cart.setUser(null);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Integer getDelTag() {
        return delTag;
    }

    public void setDelTag(Integer delTag) {
        this.delTag = delTag;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<DeliveryAddress> getDeliverAddresses() {
        return deliverAddresses;
    }

    public void setDeliverAddresses(List<DeliveryAddress> deliverAddresses) {
        this.deliverAddresses = deliverAddresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userImg='" + userImg + '\'' +
                ", delTag=" + delTag +
                ", carts=" + carts +
                ", orders=" + orders +
                ", deliverAddresses=" + deliverAddresses +
                '}';
    }
}
