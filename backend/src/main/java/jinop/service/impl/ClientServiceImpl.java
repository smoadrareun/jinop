package jinop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jinop.mapper.ClientMapper;
import jinop.model.Client;
import jinop.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ClientServiceImpl
 * @Description TODO  客户业务层实现类
 **/

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public int checkClient(Map<String, Object> map) {
        return clientMapper.checkClient(map);
    }

    @Override
    public int queryClient(Map<String, Object> map) {
        return clientMapper.queryClient(map);
    }

    @Override
    public void addClient(Map<String, Object> map) {
        clientMapper.addClient(map);
    }

    @Override
    public void deleteClient(Integer id) {
        clientMapper.deleteClient(id);
    }

    @Override
    public void editClient(Map<String, Object> map) {
        clientMapper.editClient(map);
    }

    @Override
    public Map<String,Object> showClient(Map<String, Object> map) {
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
        List<Client> clientList = clientMapper.showClient(map);
        PageInfo pageInfo=new PageInfo(clientList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows",clientList);
        return resultMap;
    }

    @Override
    public Map<String,Object> findClient(Map<String, Object> map) {
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
        List<Client> clientList = clientMapper.findClient(map);
        PageInfo pageInfo=new PageInfo(clientList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows",clientList);
        return resultMap;
    }

}

