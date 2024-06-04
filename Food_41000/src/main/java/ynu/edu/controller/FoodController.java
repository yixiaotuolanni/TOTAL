package ynu.edu.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.feign.FoodFeignClient;
import ynu.edu.pojo.Food;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/food")
public class FoodController {
    @Resource
    FoodFeignClient foodFeignClient;
    @GetMapping("/listFoodByBusinessId")
    public List<Food> listBusinessByOrderTypeId(@RequestParam(name = "businessId") Integer businessId){
        return foodFeignClient.listBusinessByOrderTypeId(businessId);
    }
}
