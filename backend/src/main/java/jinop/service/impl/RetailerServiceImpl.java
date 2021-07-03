package jinop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jinop.mapper.RetailerMapper;
import jinop.model.Retailer;
import jinop.service.IRetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RetailerServiceImpl
 * @Description TODO  店铺业务层实现类
 **/

@Service
public class RetailerServiceImpl implements IRetailerService {
    @Autowired
    private RetailerMapper retailerMapper;

    @Override
    public int checkRetailer(Map<String, Object> map) {
        return retailerMapper.checkRetailer(map);
    }

    @Override
    public void addRetailer(Map<String, Object> map) {
        retailerMapper.addRetailer(map);
    }

    @Override
    public void deleteRetailer(Integer id) {
        retailerMapper.deleteRetailer(id);
    }

    @Override
    public void editRetailer(Map<String, Object> map) {
        retailerMapper.editRetailer(map);
    }

    @Override
    public Map<String,Object> showRetailer(Map<String, Object> map) {
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
        PageHelper.startPage(pageNum, pageSize);
        List<Retailer> retailerList = retailerMapper.showRetailer(map);
        PageInfo pageInfo=new PageInfo(retailerList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows",retailerList);
        return resultMap;
    }

    @Override
    public Map<String,Object> findRetailer(Map<String, Object> map) {
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
        PageHelper.startPage(pageNum, pageSize);
        List<Retailer> retailerList = retailerMapper.findRetailer(map);
        PageInfo pageInfo=new PageInfo(retailerList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows",retailerList);
        return resultMap;
    }

}