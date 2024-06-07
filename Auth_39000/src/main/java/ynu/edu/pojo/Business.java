package ynu.edu.pojo;
import java.util.ArrayList;
import java.util.List;

public class Business {
    private Integer businessId;

    private String businessName;

    private String businessAddress;

    private String businessExplain;

    private String businessImg;

    private Integer orderTypeId;

    private Double starPrice;

    private Double deliveryPrice;

    private String remarks;

    private List<Food> foods = new ArrayList<>();

    private List<Orders> orders = new ArrayList<>();

    public void addFood(Food food){
        if (!this.foods.contains(food)){
            this.foods.add(food);
            food.setBusiness(this);
        }
    }

    public void removeFood(Food food){
        if (!this.foods.contains(food)){
            this.foods.remove(food);
            food.setBusiness(null);
        }
    }

    public void addOrder(Orders order){
        if (!this.orders.contains(order)){
            this.orders.add(order);
            order.setBusiness(this);
        }
    }

    public void removeOrder(Orders order){
        if (!this.orders.contains(order)){
            this.orders.remove(order);
            order.setBusiness(null);
        }
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public Double getStarPrice() {
        return starPrice;
    }

    public void setStarPrice(Double starPrice) {
        this.starPrice = starPrice;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}


