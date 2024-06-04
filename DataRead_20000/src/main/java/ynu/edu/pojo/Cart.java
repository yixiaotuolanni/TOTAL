package ynu.edu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @ManyToOne
    @JoinColumn(name = "foodId",
            referencedColumnName = "foodId",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "cart_food_FK"
            )
    )
    private Food food;

    @ManyToOne
    @JoinColumn(name = "businessId",
            referencedColumnName = "businessId",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "cart_business_FK"
            )
    )
    @JsonIgnore
    private Business business;

    @ManyToOne
    @JoinColumn(
            name = "userId",
            referencedColumnName = "userId",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "cart_user_FK"
            )
    )
    @JsonIgnore
    private User user;

    @Column(nullable = false)
    private Integer quantity;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
