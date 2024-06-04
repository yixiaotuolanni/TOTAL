package ynu.edu.dao;

import ynu.edu.pojo.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersDao extends JpaRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o where o.orderId = ?1")
    Orders listOrdersById(Integer orderId);
}
