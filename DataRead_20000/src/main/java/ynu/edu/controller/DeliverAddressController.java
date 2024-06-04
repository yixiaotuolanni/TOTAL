package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.pojo.DeliveryAddress;
import ynu.edu.service.IDeliveryAddressService;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/DeliverAddressController")
public class DeliverAddressController {
    @Resource
    IDeliveryAddressService iDeliverAddressService;

    @PostMapping("/listDeliveryAddressByUserId")
    List<DeliveryAddress> listDeliveryAddressByUserId(@RequestParam String userId){
        return iDeliverAddressService.listDeliveryAddressByUserId(userId);
    }
    @PostMapping("/getDeliveryAddressById")
    DeliveryAddress getDeliveryAddressById(@RequestParam Integer daId){
        return iDeliverAddressService.getDeliveryAddressById(daId);
    }
    @PostMapping("/saveDeliveryAddress")
    int saveDeliveryAddress(@RequestParam String contactName,
                            @RequestParam Integer contactSex,
                            @RequestParam String contactTel,
                            @RequestParam String address,
                            @RequestParam String userId){
        return iDeliverAddressService.saveDeliveryAddress(contactName,contactSex,contactTel,address,userId);
    }

    @PostMapping("/updateDeliveryAddress")
    int updateDeliveryAddress(@RequestParam Integer daId,
                              @RequestParam String contactName,
                              @RequestParam Integer contactSex,
                              @RequestParam String contactTel,
                              @RequestParam String address,
                              @RequestParam String userId){
        return iDeliverAddressService.updateDeliveryAddress(daId,contactName,contactSex,contactTel,address,userId);
    }

    @PostMapping("/removeDeliveryAddress")
    int removeDeliveryAddress(@RequestParam Integer daId){
        return iDeliverAddressService.removeDeliveryAddress(daId);
    }

}
