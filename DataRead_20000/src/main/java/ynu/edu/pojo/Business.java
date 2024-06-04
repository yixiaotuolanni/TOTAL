package ynu.edu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer businessId;

    @Column(nullable = false, length = 40)
    private String businessName;

    @Column(length = 50)
    private String businessAddress;

    @Column(length = 40)
    private String businessExplain;

    private String businessImg;

    @Column(nullable = false)
    private Integer orderTypeId;

    @Column(columnDefinition = "decimal(5,2) DEFAULT 0.00")
    private Double starPrice;

    @Column(columnDefinition = "decimal(5,2) DEFAULT 0.00")
    private Double deliveryPrice;

    @Column(length = 40)
    private String remarks;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "business",
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Food> foods = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "business",
            fetch = FetchType.LAZY
    )
    @JsonIgnore
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


