package jinop.service;

import jinop.model.Client;

import java.util.Map;

/**
 * @ClassName IClientService
 * @Description TODO 客户业务层接口
 **/

public interface IClientService {

    int checkClient(Map<String, Object> map);

    int queryClient(Map<String, Object> map);

    void addClient(Map<String, Object> map);

    void deleteClient(Integer id);

    void editClient(Map<String, Object> map);

    Map<String, Object> showClient(Map<String, Object> map);

    Map<String, Object> findClient(Map<String, Object> map);


}
