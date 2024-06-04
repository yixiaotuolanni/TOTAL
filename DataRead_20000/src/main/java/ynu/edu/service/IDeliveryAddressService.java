package ynu.edu.service;


import ynu.edu.pojo.DeliveryAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDeliveryAddressService {
    List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
    DeliveryAddress getDeliveryAddressById(Integer daId);
    int saveDeliveryAddress(String contactName,
                            Integer contactSex,
                            String contactTel,
                            String address,
                            String userId);

    int updateDeliveryAddress(Integer daId,
                              String contactName,
                              Integer contactSex,
                              String contactTel,
                              String address,
                              String userId);

    int removeDeliveryAddress(Integer daId);
}
