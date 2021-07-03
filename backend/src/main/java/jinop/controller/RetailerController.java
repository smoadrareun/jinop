package jinop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jinop.common.AssembleResponseMsg;
import jinop.common.IDUtil;
import jinop.model.Retailer;
import jinop.model.ResponseBody;
import jinop.service.IRetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RetailerController
 * @Description TODO 店铺控制层
 **/

@CrossOrigin
@RestController
public class RetailerController {
    @Autowired
    private IRetailerService retailerService;

    @RequestMapping(value = "/addret", produces = "application/json;charset=utf-8")
    public ResponseBody addRetailer(@RequestBody Map<String, Object> map) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("name", map.get("name"));
            int flag = retailerService.checkRetailer(checkMap);
            if (flag==0){
                map.put("id", IDUtil.getID());
                retailerService.addRetailer(map);
                Map<String, Object> resultMap = retailerService.findRetailer(map);
                return new AssembleResponseMsg().success(resultMap,200,"添加店铺成功！");
            }else{
                return new AssembleResponseMsg().failure(203,"error","店铺名已存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "添加店铺失败！");
        }
    }

    @RequestMapping(value = "/delret/{id}", produces = "application/json;charset=utf-8")
    public ResponseBody deleteRetailer(@PathVariable("id") Integer id) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id",id);
            int flag = retailerService.checkRetailer(checkMap);
            if (flag==1){
                retailerService.deleteRetailer(id);
                return new AssembleResponseMsg().success("OK",200,"删除店铺成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该店铺不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "删除店铺失败！");
        }
    }

    @RequestMapping(value = "/editret", produces = "application/json;charset=utf-8")
    public ResponseBody editRetailer(@RequestBody Map<String, Object> map) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id", map.get("id"));
            int flag = retailerService.checkRetailer(checkMap);
            if (flag==1){
                retailerService.editRetailer(map);
                Map<String, Object> resultMap = retailerService.findRetailer(map);
                return new AssembleResponseMsg().success(resultMap,200,"修改店铺成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该店铺不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "修改店铺失败！");
        }
    }

    @RequestMapping(value = "/showret",produces = "application/json;charset=utf-8")
    public ResponseBody showRetailer(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = retailerService.showRetailer(map);
            if(map.isEmpty()==true)
            {
                return new AssembleResponseMsg().success(resultMap,200,"显示所有店铺成功！");
            }else {
                return new AssembleResponseMsg().success(resultMap, 200, "模糊查询店铺成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "模糊查询店铺失败！");
        }
    }

    @RequestMapping(value = "/findret",produces = "application/json;charset=utf-8")
    public ResponseBody findRetailer(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = retailerService.findRetailer(map);
            if(map.isEmpty()==true)
            {
                return new AssembleResponseMsg().success(resultMap,200,"显示所有店铺成功！");
            }else{
                return new AssembleResponseMsg().success(resultMap,200,"精确查询店铺成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "精确查询店铺失败！");
        }
    }

}