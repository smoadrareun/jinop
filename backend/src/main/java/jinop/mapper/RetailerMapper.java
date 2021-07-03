package jinop.mapper;

import jinop.model.Retailer;
import java.util.List;
import java.util.Map;

public interface RetailerMapper {

    //检查店铺数据
    int checkRetailer(Map<String, Object> map);

    //添加店铺信息
    void addRetailer(Map<String, Object> map);

    //删除店铺信息
    void deleteRetailer(Integer id);

    //编辑店铺信息
    void editRetailer(Map<String, Object> map);

    //模糊查询店铺信息和显示所有店铺信息
    List<Retailer> showRetailer(Map<String, Object> map);

    //精确查询店铺信息
    List<Retailer> findRetailer(Map<String, Object> map);

}