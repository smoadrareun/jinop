package jinop.mapper;

import jinop.model.Merchant;
import java.util.List;
import java.util.Map;

public interface MerchantMapper {

    //检查商户数据
    int checkMerchant(Map<String, Object> map);

    //商户登录请求
    int queryMerchant(Map<String, Object> map);

    //添加商户信息
    void addMerchant(Map<String, Object> map);

    //删除商户信息
    void deleteMerchant(String id);

    //编辑商户信息
    void editMerchant(Map<String, Object> map);

    //模糊查询商户信息和显示所有商户信息
    List<Merchant> showMerchant(Map<String, Object> map);

    //精确查询商户信息
    List<Merchant> findMerchant(Map<String, Object> map);

}

