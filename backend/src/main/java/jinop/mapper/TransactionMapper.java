package jinop.mapper;

import jinop.model.Transaction;
import java.util.List;
import java.util.Map;

public interface TransactionMapper {

    //检查交易信息数据
    int checkTransaction(Map<String, Object> map);

    //添加交易信息
    void addTransaction(Map<String, Object> map);

    //删除交易信息
    void deleteTransaction(String id);

    //编辑交易信息
    void editTransaction(Map<String, Object> map);

    //模糊查询交易信息和显示所有交易信息
    List<Transaction> showTransaction(Map<String, Object> map);

    //精确查询交易信息
    List<Transaction> findTransaction(Map<String, Object> map);

}

