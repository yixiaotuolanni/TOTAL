package ynu.edu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    @Column(nullable = false, length = 30)
    private String foodName;

    @Column(nullable = false, length = 30)
    private String foodExplain;

    @Column(nullable = false)
    private String foodImg;

    @Column(length = 30, columnDefinition = "decimal(5,2)")
    private Double foodPrice;

    @ManyToOne
    @JoinColumn(
            name = "businessId",
            referencedColumnName = "businessId",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "food_business_FK"
            )
    )
    @JsonIgnore
    private Business business;

    @Column(length = 40)
    private String remarks;

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodExplain() {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
