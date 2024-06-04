package ynu.edu.service;

import org.springframework.stereotype.Service;
import ynu.edu.pojo.Cart;

import java.util.List;

@Service
public interface ICartService {
    public List<Cart> listCart(String userId,
                               Integer businessId);
    public int saveCart(String userId,
                        Integer businessId,
                        Integer foodId);
    public int updateCart(String userId,
                          Integer businessId,
                          Integer foodId,
                          Integer quantity);
    public int removeCart(String userId,
                              Integer businessId,
                              Integer foodId);
}
