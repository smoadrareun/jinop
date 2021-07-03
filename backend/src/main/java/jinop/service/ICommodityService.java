package jinop.service;

import jinop.model.Commodity;

import java.util.Map;

/**
 * @ClassName ICommodityService
 * @Description TODO 商品业务层接口
 **/

public interface ICommodityService {

    int checkCommodity(Map<String, Object> map);

    void addCommodity(Map<String, Object> map);

    void deleteCommodity(Integer id);

    void editCommodity(Map<String, Object> map);

    Map<String, Object> showCommodity(Map<String, Object> map);

    Map<String, Object> findCommodity(Map<String, Object> map);

}