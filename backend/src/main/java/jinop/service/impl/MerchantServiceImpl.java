package jinop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jinop.mapper.MerchantMapper;
import jinop.model.Merchant;
import jinop.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MerchantServiceImpl
 * @Description TODO  商户业务层实现类
 **/

@Service
public class MerchantServiceImpl implements IMerchantService {
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public int checkMerchant(Map<String, Object> map) {
        return merchantMapper.checkMerchant(map);
    }

    @Override
    public int queryMerchant(Map<String, Object> map) {
        return merchantMapper.queryMerchant(map);
    }

    @Override
    public void addMerchant(Map<String, Object> map) {
        merchantMapper.addMerchant(map);
    }

    @Override
    public void deleteMerchant(Integer id) {
        merchantMapper.deleteMerchant(id);
    }

    @Override
    public void editMerchant(Map<String, Object> map) {
        merchantMapper.editMerchant(map);
    }

    @Override
    public Map<String,Object> showMerchant(Map<String, Object> map) {
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
        List<Merchant> merchantList = merchantMapper.showMerchant(map);
        PageInfo pageInfo=new PageInfo(merchantList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows", merchantList);
        return resultMap;
    }

    @Override
    public Map<String,Object> findMerchant(Map<String, Object> map) {
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
        List<Merchant> merchantList = merchantMapper.findMerchant(map);
        PageInfo pageInfo=new PageInfo(merchantList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows", merchantList);
        return resultMap;
    }

}

