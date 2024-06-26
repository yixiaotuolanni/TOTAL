package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.pojo.DeliveryAddress;
import ynu.edu.service.IDeliveryAddressService;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/deliveryaddress")
public class DeliverAddressController {
    @Resource
    IDeliveryAddressService iDeliverAddressService;

    @PostMapping("/listDeliveryAddressByUserId")
    List<DeliveryAddress> listDeliveryAddressByUserId(@RequestParam("userId") String userId){
        return iDeliverAddressService.listDeliveryAddressByUserId(userId);
    }
    @PostMapping("/getDeliveryAddressById")
    DeliveryAddress getDeliveryAddressById(@RequestParam("daId") Integer daId){
        return iDeliverAddressService.getDeliveryAddressById(daId);
    }
    @PostMapping("/saveDeliveryAddress")
    int saveDeliveryAddress(@RequestParam("contactName") String contactName,
                            @RequestParam("contactSex") Integer contactSex,
                            @RequestParam("contactTel") String contactTel,
                            @RequestParam("address") String address,
                            @RequestParam("userId") String userId){
        return iDeliverAddressService.saveDeliveryAddress(contactName,contactSex,contactTel,address,userId);
    }

    @PostMapping("/updateDeliveryAddress")
    int updateDeliveryAddress(@RequestParam("daId") Integer daId,
                              @RequestParam("contactName") String contactName,
                              @RequestParam("contactSex") Integer contactSex,
                              @RequestParam("contactTel") String contactTel,
                              @RequestParam("address") String address,
                              @RequestParam("userId") String userId){
        return iDeliverAddressService.updateDeliveryAddress(daId,contactName,contactSex,contactTel,address,userId);
    }

    @PostMapping("/removeDeliveryAddress")
    int removeDeliveryAddress(@RequestParam("daId") Integer daId){
        return iDeliverAddressService.removeDeliveryAddress(daId);
    }

}
