package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ynu.edu.feign.BusinessFeignClient;
import ynu.edu.pojo.Business;

import java.util.List;

@RefreshScope
@RestController
@CrossOrigin
@RequestMapping(value = "/business")
public class BusinessController {
    @Resource
    BusinessFeignClient businessFeignClient;
    @Value("${protectSignal}")
    private Boolean protectSignal;
    @RequestMapping("/test")
    public String test(){
        return "接口可以正常调用";
    }

    @GetMapping("/listBusiness")
    public List<Business> listBusiness() throws InterruptedException {
        if (protectSignal){
            Thread.sleep(4_000L);
        }
        return businessFeignClient.listBusiness();
    }
    @GetMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(@RequestParam("orderTypeId") Integer orderTypeId){
        return businessFeignClient.listBusinessByOrderTypeId(orderTypeId);
    }
    @GetMapping("/listBusinessById")
    public Business getBusinessById(@RequestParam("businessId") Integer businessId){
        return businessFeignClient.getBusinessById(businessId);
    }

}
