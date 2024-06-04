package ynu.edu.impl;

import ynu.edu.dao.IFoodDao;
import ynu.edu.pojo.Food;
import ynu.edu.service.IFoodService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FoodServiceImpl implements IFoodService {
    @Resource
    IFoodDao iFoodDao;
    @Override
    public List<Food> listBusinessByOrderTypeId(Integer businessId){
        return iFoodDao.findFoodsByBusiness_BusinessIdOrderByFoodId(businessId);
    }
}
