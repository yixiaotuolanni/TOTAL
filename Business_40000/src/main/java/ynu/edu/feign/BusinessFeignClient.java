package ynu.edu.feign;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ynu.edu.pojo.Business;

import java.util.List;

@FeignClient(name = "data-read")
public interface BusinessFeignClient {
    @GetMapping("/dataread/business/listBusiness")
    public List<Business> listBusiness();
    @GetMapping("/dataread/business/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(@RequestParam("orderTypeId") Integer orderTypeId);
    @GetMapping("/dataread/business/getBusinessById")
    public Business getBusinessById(@RequestParam("businessId") Integer businessId);
}
