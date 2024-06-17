package ynu.edu.feign;

import jakarta.annotation.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ynu.edu.pojo.Business;
import ynu.edu.pojo.Cart;

import java.util.List;

@FeignClient(name = "data-read")
public interface CartFeignClient {
    static String path = "/dataread/cart";
    @PostMapping(path+"/listCart")
    public List<Cart> listCart(@RequestParam("userId") String userId,
                               @RequestParam(name = "businessId",required = false) Integer businessId);

    @PostMapping(path+"/saveCart")
    public int saveCart(@RequestParam("userId") String userId,
                        @RequestParam("businessId") Integer businessId,
                        @RequestParam("foodId") Integer foodId);

    @PostMapping(path+"/updateCart")
    public int updateCart(@RequestParam("userId") String userId,
                          @RequestParam("businessId") Integer businessId,
                          @RequestParam("foodId") Integer foodId,
                          @RequestParam("quantity") Integer quantity);


    @PostMapping(path+"/removeCart")
    public int removeCart(@RequestParam("userId") String userId,
                          @RequestParam("businessId") Integer businessId,
                          @RequestParam("foodId") Integer foodId);
}
