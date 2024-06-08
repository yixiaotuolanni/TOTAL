package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.pojo.Business;
import ynu.edu.service.IBusinessService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/business")
public class BusinessController {
    @Resource
    IBusinessService iBusinessService;
    @GetMapping("/listBusiness")
    public List<Business> listBusiness(){
        return iBusinessService.listBusiness();
    }

//    功能：根据点餐分类编号查询所属商家信息
    @GetMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(@RequestParam("orderTypeId") Integer orderTypeId){
        return iBusinessService.listBusinessByOrderTypeId(orderTypeId);
    }

    @GetMapping("/getBusinessById")
    public Business getBusinessById(@RequestParam("businessId") Integer businessId){
        return iBusinessService.getBusinessById(businessId);
    }

}
