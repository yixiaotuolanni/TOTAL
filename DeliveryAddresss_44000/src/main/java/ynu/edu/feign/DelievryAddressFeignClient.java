package ynu.edu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ynu.edu.pojo.DeliveryAddress;

import java.util.List;

@FeignClient(name = "data-read")
public interface DelievryAddressFeignClient {
    static String path = "/dataread/deliveryaddress";

    @PostMapping(path+"/listDeliveryAddressByUserId")
    List<DeliveryAddress> listDeliveryAddressByUserId(@RequestParam("userId") String userId);
    @PostMapping(path+"/getDeliveryAddressById")
    DeliveryAddress getDeliveryAddressById(@RequestParam("daId") Integer daId);
    @PostMapping(path+"/saveDeliveryAddress")
    int saveDeliveryAddress(@RequestParam("contactName") String contactName,
                            @RequestParam("contactSex") Integer contactSex,
                            @RequestParam("contactTel") String contactTel,
                            @RequestParam("address") String address,
                            @RequestParam("userId") String userId);

    @PostMapping(path+"/updateDeliveryAddress")
    int updateDeliveryAddress(@RequestParam("daId") Integer daId,
                              @RequestParam("contactName") String contactName,
                              @RequestParam("contactSex") Integer contactSex,
                              @RequestParam("contactTel") String contactTel,
                              @RequestParam("address") String address,
                              @RequestParam("userId") String userId);

    @PostMapping(path+"/removeDeliveryAddress")
    int removeDeliveryAddress(@RequestParam("daId") Integer daId);

}
