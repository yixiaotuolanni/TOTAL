package ynu.edu.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import ynu.edu.dao.IBusinessDao;
import ynu.edu.pojo.Business;
import ynu.edu.service.IBusinessService;

import java.util.List;

@Component
public class BusinessServiceImpl implements IBusinessService {
    @Resource
    IBusinessDao iBusinessDao;

    @Override
    public List<Business> listBusiness() {
        return iBusinessDao.findAll();
    }

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return iBusinessDao.findBusinessesByOrderTypeId(orderTypeId);
    }
    @Override
    public Business getBusinessById(Integer businessId) {
        return iBusinessDao.findBusinessByBusinessId(businessId);
    }

}
