package jinop.mapper;

import jinop.model.Commodity;
import java.util.List;
import java.util.Map;

public interface CommodityMapper {

    //检查商品数据
    int checkCommodity(Map<String, Object> map);

    //添加商品信息
    void addCommodity(Commodity commodity);

    //删除商品信息
    void deleteCommodity(Integer id);

    //编辑商品信息
    void editCommodity(Commodity commodity);

    //模糊查询商品信息和显示所有商品信息
    List<Commodity> showCommodity(Map<String, Object> map);

    //精确查询商品信息
    List<Commodity> findCommodity(Map<String, Object> map);

}

