package jinop.service;

import jinop.model.Retailer;

import java.util.Map;

/**
 * @ClassName IRetailerService
 * @Description TODO 店铺业务层接口
 **/

public interface IRetailerService {

    int checkRetailer(Map<String, Object> map);

    void addRetailer(Map<String, Object> map);

    void deleteRetailer(Integer id);

    void editRetailer(Map<String, Object> map);

    Map<String, Object> showRetailer(Map<String, Object> map);

    Map<String, Object> findRetailer(Map<String, Object> map);

}