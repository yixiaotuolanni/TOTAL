package ynu.edu.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.pojo.Food;
import ynu.edu.service.IFoodService;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/food")
public class FoodController {
    @Resource
    IFoodService iFoodService;
    @GetMapping("/listFoodByBusinessId")
    public List<Food> listBusinessByOrderTypeId(@RequestParam("businessId") Integer businessId){
        return iFoodService.listBusinessByOrderTypeId(businessId);
    }
}
