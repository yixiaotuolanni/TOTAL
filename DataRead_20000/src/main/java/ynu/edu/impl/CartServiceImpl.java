package ynu.edu.impl;

import ynu.edu.dao.IBusinessDao;
import ynu.edu.dao.ICartDao;
import ynu.edu.dao.IFoodDao;
import ynu.edu.dao.IUserDao;
import ynu.edu.pojo.Business;
import ynu.edu.pojo.Cart;
import ynu.edu.pojo.Food;
import ynu.edu.pojo.User;
import ynu.edu.service.ICartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CartServiceImpl implements ICartService {
    @Resource
    ICartDao iCartDao;
    @Resource
    IUserDao iUserDao;
    @Resource
    IBusinessDao iBusinessDao;
    @Resource
    IFoodDao iFoodDao;
    @Override
    public List<Cart> listCart(String userId, Integer businessId){
        if (businessId == null) {
            // 查询此用户所有购物车信息
            return iCartDao.findCartsByUser_UserId(userId);
        } else {
            // 查询此用户某个商家的所有购物车信息
            return iCartDao.findCartsByUser_UserIdAndBusiness_BusinessId(userId, businessId);
        }
    }
    @Transactional
    @Override
    public int saveCart(String userId, Integer businessId, Integer foodId) {
        User user = iUserDao.findUserByUserId(userId);
        Business business = iBusinessDao.findBusinessByBusinessId(businessId);
        Food food = iFoodDao.findFoodByFoodId(foodId);
        if (user == null || business == null || food == null){
            return 0;
        }
        Cart cart = new Cart();
        cart.setBusiness(business);
        cart.setFood(food);
        cart.setQuantity(1);
        user.addCarts(cart);
        iUserDao.save(user);
        return 1;
    }
    @Override
    public int updateCart(String userId, Integer businessId, Integer foodId, Integer quantity){
        Cart cart = iCartDao.findCartsByUser_UserIdAndBusiness_BusinessIdAndFood_FoodId(userId, businessId, foodId);
        cart.setQuantity(quantity);
        iCartDao.save(cart);
        return 1;
    }
    @Override
    public int removeCart(String userId,
                              Integer businessId,
                              Integer foodId){
        return iCartDao.removeCart(userId, businessId, foodId);
    }
}
