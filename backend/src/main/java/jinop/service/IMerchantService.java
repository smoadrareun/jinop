package jinop.service;

import jinop.model.Merchant;

import java.util.Map;

/**
 * @ClassName IMerchantService
 * @Description TODO 商户业务层接口
 **/

public interface IMerchantService {

    int checkMerchant(Map<String, Object> map);

    int queryMerchant(Map<String, Object> map);

    void addMerchant(Map<String, Object> map);

    void deleteMerchant(Integer id);

    void editMerchant(Map<String, Object> map);

    Map<String, Object> showMerchant(Map<String, Object> map);

    Map<String, Object> findMerchant(Map<String, Object> map);


}
