package jinop.service;

import jinop.model.Transaction;

import java.util.Map;

/**
 * @ClassName ITransactionService
 * @Description TODO 交易信息业务层接口
 **/

public interface ITransactionService {

    int checkTransaction(Map<String, Object> map);

    void addTransaction(Transaction transaction);

    void deleteTransaction(Integer id);

    void editTransaction(Transaction transaction);

    Map<String, Object> showTransaction(Map<String, Object> map);

    Map<String, Object> findTransaction(Map<String, Object> map);

}