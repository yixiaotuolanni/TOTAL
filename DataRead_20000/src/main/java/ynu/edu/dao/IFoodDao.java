package ynu.edu.dao;

import ynu.edu.pojo.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFoodDao extends JpaRepository<Food, Integer> {
    List<Food> findFoodsByBusiness_BusinessIdOrderByFoodId(Integer businessId);
    Food findFoodByFoodId(Integer foodId);

}
