package jinop.controller;

import jinop.common.AssembleResponseMsg;
import jinop.model.Merchant;
import jinop.model.ResponseBody;
import jinop.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MerchantController
 * @Description TODO 商户控制层
 **/

@CrossOrigin
@RestController
public class MerchantController {
    @Autowired
    private IMerchantService merchantService;

    @RequestMapping(value = "/querymerchant",produces = "application/json;charset=utf-8")
    public ResponseBody queryMerchant(@RequestBody Map<String,Object> map){
        int flag = merchantService.queryMerchant(map);
        if (flag==1){
            Map<String, Object> resultMap = merchantService.findMerchant(map);
            return new AssembleResponseMsg().success(resultMap,200,"商户登录成功！");
        }else{
            return new AssembleResponseMsg().failure(201,"error","用户名或密码错误！");
        }
    }

    @RequestMapping(value = "/addmerchant", produces = "application/json;charset=utf-8")
    public ResponseBody addMerchant(@RequestBody Map<String, Object> map) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("username", map.get("username"));
            checkMap.put("level", map.get("level"));
            int flag = merchantService.checkMerchant(checkMap);
            if (flag==0){
                merchantService.addMerchant(map);
                Map<String, Object> resultMap = merchantService.findMerchant(map);
                return new AssembleResponseMsg().success(resultMap,200,"添加商户成功！");
            }else{
                return new AssembleResponseMsg().failure(203,"error","用户名已存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "添加商户失败！");
        }
    }

    @RequestMapping(value = "/deletemerchant/{id}", produces = "application/json;charset=utf-8")
    public ResponseBody deleteMerchant(@PathVariable("id") Integer id) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id",id);
            int flag = merchantService.checkMerchant(checkMap);
            if (flag==1){
                merchantService.deleteMerchant(id);
                return new AssembleResponseMsg().success("OK",200,"删除商户成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该商户不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "删除商户失败！");
        }
    }

    @RequestMapping(value = "/editmerchant", produces = "application/json;charset=utf-8")
    public ResponseBody editMerchant(@RequestBody Map<String, Object> map) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id", map.get("id"));
            int flag = merchantService.checkMerchant(checkMap);
            if (flag==1){
                merchantService.editMerchant(map);
                Map<String, Object> resultMap = merchantService.findMerchant(map);
                return new AssembleResponseMsg().success(resultMap,200,"修改商户成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该商户不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "修改商户失败！");
        }
    }

    @RequestMapping(value = "/showmerchant",produces = "application/json;charset=utf-8")
    public ResponseBody showMerchant(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = merchantService.showMerchant(map);
            if(map.isEmpty()==true)
            {
                return new AssembleResponseMsg().success(resultMap,200,"显示所有商户成功！");
            }else{
                return new AssembleResponseMsg().success(resultMap,200,"模糊查询商户成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "模糊查询商户失败！");
        }
    }

    @RequestMapping(value = "/findmerchant",produces = "application/json;charset=utf-8")
    public ResponseBody findMerchant(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = merchantService.findMerchant(map);
            if(map.isEmpty()==true)
            {
                return new AssembleResponseMsg().success(resultMap,200,"显示所有商户成功！");
            }else{
                return new AssembleResponseMsg().success(resultMap,200,"精确查询商户成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "精确查询商户失败！");
        }
    }

}

