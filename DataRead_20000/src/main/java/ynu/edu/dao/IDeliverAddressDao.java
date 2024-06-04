package ynu.edu.dao;

import ynu.edu.pojo.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDeliverAddressDao extends JpaRepository<DeliveryAddress, Integer> {
    List<DeliveryAddress> findDeliveryAddressesByUser_UserId(String userId);
    DeliveryAddress findDeliveryAddressByDaId(Integer daId);
}
