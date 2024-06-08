package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.feign.DelievryAddressFeignClient;
import ynu.edu.pojo.DeliveryAddress;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/deliveryaddress")
public class DeliveryAddressController {
    @Resource
    DelievryAddressFeignClient deliveryAddressFeignClient;

    @PostMapping("/listDeliveryAddressByUserId")
    List<DeliveryAddress> listDeliveryAddressByUserId(@RequestParam("userId") String userId){
        return deliveryAddressFeignClient.listDeliveryAddressByUserId(userId);
    }
    @PostMapping("/getDeliveryAddressById")
    DeliveryAddress getDeliveryAddressById(@RequestParam("daId") Integer daId){
        return deliveryAddressFeignClient.getDeliveryAddressById(daId);
    }
    @PostMapping("/saveDeliveryAddress")
    int saveDeliveryAddress(@RequestParam("contactName") String contactName,
                            @RequestParam("contactSex") Integer contactSex,
                            @RequestParam("contactTel") String contactTel,
                            @RequestParam("address") String address,
                            @RequestParam("userId") String userId){
        return deliveryAddressFeignClient.saveDeliveryAddress(contactName,contactSex,contactTel,address,userId);
    }

    @PostMapping("/updateDeliveryAddress")
    int updateDeliveryAddress(@RequestParam("daId") Integer daId,
                              @RequestParam("contactName") String contactName,
                              @RequestParam("contactSex") Integer contactSex,
                              @RequestParam("contactTel") String contactTel,
                              @RequestParam("address") String address,
                              @RequestParam("userId") String userId){
        return deliveryAddressFeignClient.updateDeliveryAddress(daId,contactName,contactSex,contactTel,address,userId);
    }

    @PostMapping("/removeDeliveryAddress")
    int removeDeliveryAddress(@RequestParam("daId") Integer daId){
        return deliveryAddressFeignClient.removeDeliveryAddress(daId);
    }


}
