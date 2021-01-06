package jinop.mapper;

import jinop.model.Client;
import java.util.Map;
import java.util.List;


public interface ClientMapper {

    //检查客户数据
    int checkClient(Map<String, Object> map);

    //客户登录请求
    int queryClient(Map<String, Object> map);

    //添加客户信息
    void addClient(Map<String, Object> map);

    //删除客户信息
    void deleteClient(Integer id);

    //编辑客户信息
    void editClient(Map<String, Object> map);

    //模糊查询客户信息和显示所有客户信息
    List<Client> showClient(Map<String, Object> map);

    //精确查询客户信息
    List<Client> findClient(Map<String, Object> map);

}

