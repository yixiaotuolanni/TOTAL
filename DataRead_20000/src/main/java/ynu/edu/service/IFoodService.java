package ynu.edu.service;

import ynu.edu.pojo.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFoodService {
    public List<Food> listBusinessByOrderTypeId(Integer businessId);

}
