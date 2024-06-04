package ynu.edu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ynu.edu.pojo.Business;

import java.util.List;

@Repository
public interface IBusinessDao extends CrudRepository<Business, Integer> {
    List<Business> findAll();
    List<Business> findBusinessesByOrderTypeId(Integer orderTypeId);
    Business findBusinessByBusinessId(Integer businessId);
}
