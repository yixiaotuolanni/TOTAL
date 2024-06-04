package ynu.edu.dao;

import ynu.edu.pojo.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICartDao extends JpaRepository<Cart, Integer> {
    public List<Cart> findCartsByUser_UserId(String userId);
    public List<Cart> findCartsByUser_UserIdAndBusiness_BusinessId(String userId,
                                                     Integer businessId);
    public Cart findCartsByUser_UserIdAndBusiness_BusinessIdAndFood_FoodId(String userId,
                                                        Integer businessId,
                                                        Integer foodId);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM elm_jpa.cart WHERE cart.user_id = :userId AND cart.business_id = :businessId AND cart.food_id = :foodId", nativeQuery = true)
    public int removeCart(@Param("userId") String userId, @Param("businessId") Integer businessId, @Param("foodId") Integer foodId);
}
