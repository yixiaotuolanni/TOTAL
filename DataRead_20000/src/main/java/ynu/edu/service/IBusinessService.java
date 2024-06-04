package ynu.edu.service;

import ynu.edu.pojo.Business;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBusinessService {
    List<Business> listBusiness();
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
    public Business getBusinessById(Integer businessId);

}
