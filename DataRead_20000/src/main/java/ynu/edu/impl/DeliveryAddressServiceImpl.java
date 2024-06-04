package ynu.edu.impl;

import ynu.edu.dao.IDeliverAddressDao;
import ynu.edu.dao.IUserDao;
import ynu.edu.pojo.DeliveryAddress;
import ynu.edu.pojo.User;
import ynu.edu.service.IDeliveryAddressService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeliveryAddressServiceImpl implements IDeliveryAddressService {

    @Resource
    IDeliverAddressDao iDeliverAddressDao;

    @Resource
    IUserDao iUserDao;
    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        return iDeliverAddressDao.findDeliveryAddressesByUser_UserId(userId);
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return iDeliverAddressDao.findDeliveryAddressByDaId(daId);
    }

    @Override
    public int saveDeliveryAddress(String contactName, Integer contactSex, String contactTel, String address, String userId) {
        User user = iUserDao.findUserByUserId(userId);
        DeliveryAddress deliverAddress = new DeliveryAddress();
        deliverAddress.setContactName(contactName);
        deliverAddress.setContactSex(contactSex);
        deliverAddress.setContactTel(contactTel);
        deliverAddress.setAddress(address);
        user.addDeliveryAddresses(deliverAddress);
        iUserDao.save(user);
        return 1;
    }

    @Override
    public int updateDeliveryAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address, String userId) {
        User user = iUserDao.findUserByUserId(userId);
        DeliveryAddress deliverAddress = iDeliverAddressDao.findDeliveryAddressByDaId(daId);
        deliverAddress.setContactName(contactName);
        deliverAddress.setContactSex(contactSex);
        deliverAddress.setContactTel(contactTel);
        deliverAddress.setAddress(address);
        user.addDeliveryAddresses(deliverAddress);
        iUserDao.save(user);
        return 1;
    }
    @Override
    public int removeDeliveryAddress(Integer daId) {
        DeliveryAddress deliveryAddress = iDeliverAddressDao.findDeliveryAddressByDaId(daId);
        User user = deliveryAddress.getUser();
        user.removeDeliveryAddresses(deliveryAddress);
        iUserDao.save(user);
        return 1;
    }
}
