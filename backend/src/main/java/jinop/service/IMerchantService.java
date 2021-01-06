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

    void addMerchant(Merchant merchant);

    void deleteMerchant(Integer id);

    void editMerchant(Merchant merchant);

    Map<String, Object> showMerchant(Map<String, Object> map);

    Map<String, Object> findMerchant(Map<String, Object> map);


}
