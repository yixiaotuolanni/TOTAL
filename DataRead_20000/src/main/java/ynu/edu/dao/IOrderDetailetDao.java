package ynu.edu.dao;

import ynu.edu.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDetailetDao extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findOrderDetailsByOrder_OrderId(Integer orderId);
}
