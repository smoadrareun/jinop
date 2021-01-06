package jinop.mapper;

import jinop.model.Transaction;
import java.util.List;
import java.util.Map;

public interface TransactionMapper {

    //检查交易信息数据
    int checkTransaction(Map<String, Object> map);

    //添加交易信息
    void addTransaction(Transaction transaction);

    //删除交易信息
    void deleteTransaction(Integer id);

    //编辑交易信息
    void editTransaction(Transaction transaction);

    //模糊查询交易信息和显示所有交易信息
    List<Transaction> showTransaction(Map<String, Object> map);

    //精确查询交易信息
    List<Transaction> findTransaction(Map<String, Object> map);

}

