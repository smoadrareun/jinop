package jinop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jinop.common.AssembleResponseMsg;
import jinop.common.IDUtil;
import jinop.model.Commodity;
import jinop.model.ResponseBody;
import jinop.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CommodityController
 * @Description TODO 商品控制层
 **/

@CrossOrigin
@RestController
public class CommodityController {
    @Autowired
    private ICommodityService commodityService;

    @RequestMapping(value = "/addcommodity", produces = "application/json;charset=utf-8")
    public ResponseBody addCommodity(@RequestBody Map<String, Object> map) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("name", map.get("name"));
            int flag = commodityService.checkCommodity(checkMap);
            if (flag==0){
                map.put("id", IDUtil.getID());
                commodityService.addCommodity(map);
                Map<String, Object> resultMap = commodityService.findCommodity(map);
                return new AssembleResponseMsg().success(resultMap,200,"添加商品成功！");
            }else{
                return new AssembleResponseMsg().failure(203,"error","商品名已存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "添加商品失败！");
        }
    }

    @RequestMapping(value = "/deletecommodity/{id}", produces = "application/json;charset=utf-8")
    public ResponseBody deleteCommodity(@PathVariable("id") String id) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id",id);
            int flag = commodityService.checkCommodity(checkMap);
            if (flag==1){
                commodityService.deleteCommodity(id);
                return new AssembleResponseMsg().success("OK",200,"删除商品成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该商品不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "删除商品失败！");
        }
    }

    @RequestMapping(value = "/editcommodity", produces = "application/json;charset=utf-8")
    public ResponseBody editCommodity(@RequestBody Map<String, Object> map) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id", map.get("id"));
            int flag = commodityService.checkCommodity(checkMap);
            if (flag==1){
                commodityService.editCommodity(map);
                Map<String, Object> resultMap = commodityService.findCommodity(map);
                return new AssembleResponseMsg().success(resultMap,200,"修改商品成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该商品不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "修改商品失败！");
        }
    }

    @RequestMapping(value = "/showcommodity",produces = "application/json;charset=utf-8")
    public ResponseBody showCommodity(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = commodityService.showCommodity(map);
            if(map.isEmpty()==true)
            {
                return new AssembleResponseMsg().success(resultMap,200,"显示所有商品成功！");
            }else {
                return new AssembleResponseMsg().success(resultMap, 200, "模糊查询商品成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "模糊查询商品失败！");
        }
    }

    @RequestMapping(value = "/findcommodity",produces = "application/json;charset=utf-8")
    public ResponseBody findCommodity(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = commodityService.findCommodity(map);
            if(map.isEmpty()==true)
            {
                return new AssembleResponseMsg().success(resultMap,200,"显示所有商品成功！");
            }else{
                return new AssembleResponseMsg().success(resultMap,200,"精确查询商品成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "精确查询商品失败！");
        }
    }

}

