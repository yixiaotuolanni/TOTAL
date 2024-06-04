package ynu.edu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ynu.edu.pojo.Business;
import ynu.edu.pojo.Food;

import java.util.List;

@FeignClient(name = "data-read")
public interface FoodFeignClient {
    @GetMapping("/dataread/food/listFoodByBusinessId")
    List<Food> listBusinessByOrderTypeId(@RequestParam("businessId") Integer businessId);
}
