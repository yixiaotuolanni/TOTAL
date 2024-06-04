package ynu.edu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OrderDetailId;

    @ManyToOne
    @JoinColumn(
            name = "orderId",
            referencedColumnName = "orderId",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "order_detailet_orders_FK"
            )
    )
    @JsonIgnore
    private Orders order;

    @OneToOne
    @JoinColumn(
            name = "food_id",
            referencedColumnName = "foodId",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "order_detailet_food_FK"
            )
    )
    private Food food;

    @Column(nullable = false)
    private Integer quantity;

    public Integer getOrderDetailId() {
        return OrderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        OrderDetailId = orderDetailId;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
