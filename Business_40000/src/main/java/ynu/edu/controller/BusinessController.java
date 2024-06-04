package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.feign.BusinessFeignClient;
import ynu.edu.pojo.Business;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/business")
public class BusinessController {
    @Resource
    BusinessFeignClient businessFeignClient;
    @RequestMapping("/test")
    public String test(){
        return "接口可以正常调用";
    }
    @GetMapping("/listBusiness")
    public List<Business> listBusiness(){
        return businessFeignClient.listBusiness();
    }
    @GetMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(@RequestParam Integer orderTypeId){
        return businessFeignClient.listBusinessByOrderTypeId(orderTypeId);
    }
    @GetMapping("/getBusinessById")
    public Business getBusinessById(@RequestParam Integer businessId){
        return businessFeignClient.getBusinessById(businessId);
    }

}
