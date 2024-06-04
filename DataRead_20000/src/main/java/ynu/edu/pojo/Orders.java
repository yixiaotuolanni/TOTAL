package ynu.edu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(nullable = false, length = 30)
    private String orderDate;

    @Column(nullable = false, columnDefinition = "decimal(7,2) default 0.00")
    private Double orderTotal;

    @Column(nullable = false, columnDefinition = "INTEGER default 0")
    private Integer orderState;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name = "daId",
            referencedColumnName = "daId",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "orders_delivery_address_FK"
            )
    )
    private DeliveryAddress deliveryAddress;

    @JoinColumn(
            name = "userId",
            referencedColumnName = "userId",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "orders_user_FK"
            )
    )
    @ManyToOne
    @JsonIgnore
    private User user;

    @JoinColumn(
            name = "businessId",
            referencedColumnName = "businessId",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "orders_business_FK"
            )
    )
    @ManyToOne
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
