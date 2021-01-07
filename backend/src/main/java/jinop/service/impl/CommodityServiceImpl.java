package jinop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jinop.model.Commodity;
import jinop.mapper.CommodityMapper;
import jinop.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommodityServiceImpl
 * @Description TODO  商品业务层实现类
 **/

@Service
public class CommodityServiceImpl implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public int checkCommodity(Map<String, Object> map) {
        return commodityMapper.checkCommodity(map);
    }

    @Override
    public void addCommodity(Map<String, Object> map) {
        commodityMapper.addCommodity(map);
    }

    @Override
    public void deleteCommodity(Integer id) {
        commodityMapper.deleteCommodity(id);
    }

    @Override
    public void editCommodity(Map<String, Object> map) {
        commodityMapper.editCommodity(map);
    }

    @Override
    public Map<String,Object> showCommodity(Map<String, Object> map) {
        int pageNum;     //当前页
        int pageSize;    //每页几条
        if (map.get("pageNum") == null || map.get("pageNum") == "") {
            pageNum = 1;
        } else {
            pageNum = Integer.parseInt(map.get("pageNum").toString());
        }
        if (map.get("pageSize") == null || map.get("pageSize") == "") {
            pageSize = 10;
        } else {
            pageSize = Integer.parseInt(map.get("pageSize").toString());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> commodityList = commodityMapper.showCommodity(map);
        PageInfo pageInfo=new PageInfo(commodityList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows",commodityList);
        return resultMap;
    }

    @Override
    public Map<String,Object> findCommodity(Map<String, Object> map) {
        int pageNum;     //当前页
        int pageSize;    //每页几条
        if (map.get("pageNum") == null || map.get("pageNum") == "") {
            pageNum = 1;
        } else {
            pageNum = Integer.parseInt(map.get("pageNum").toString());
        }
        if (map.get("pageSize") == null || map.get("pageSize") == "") {
            pageSize = 10;
        } else {
            pageSize = Integer.parseInt(map.get("pageSize").toString());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> commodityList = commodityMapper.findCommodity(map);
        PageInfo pageInfo=new PageInfo(commodityList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows",commodityList);
        return resultMap;
    }

}
