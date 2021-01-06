package jinop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jinop.mapper.TransactionMapper;
import jinop.model.Transaction;
import jinop.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ransactionServiceImpl
 * @Description TODO  交易信息业务层实现类
 **/

@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public int checkTransaction(Map<String, Object> map) {
        return transactionMapper.checkTransaction(map);
    }

    @Override
    public void addTransaction(Map<String, Object> map) {
        transactionMapper.addTransaction(map);
    }

    @Override
    public void deleteTransaction(Integer id) {
        transactionMapper.deleteTransaction(id);
    }

    @Override
    public void editTransaction(Map<String, Object> map) {
        transactionMapper.editTransaction(map);
    }

    @Override
    public Map<String,Object> showTransaction(Map<String, Object> map) {
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
        List<Transaction> transactionList = transactionMapper.showTransaction(map);
        PageInfo pageInfo=new PageInfo(transactionList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows",transactionList);
        return resultMap;
    }

    @Override
    public Map<String,Object> findTransaction(Map<String, Object> map) {
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
        List<Transaction> transactionList = transactionMapper.findTransaction(map);
        PageInfo pageInfo=new PageInfo(transactionList);
        long total = pageInfo.getTotal();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("total",total);
        resultMap.put("rows",transactionList);
        return resultMap;
    }

}
