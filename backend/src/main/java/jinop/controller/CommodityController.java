package jinop.controller;

import jinop.common.AssembleResponseMsg;
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
    public ResponseBody addCommodity(@RequestBody Commodity commodity) {
        try {
            commodityService.addCommodity(commodity);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "添加商品失败！");
        }
    }

    @RequestMapping(value = "/deletecommodity/{id}", produces = "application/json;charset=utf-8")
    public ResponseBody deleteCommodity(@PathVariable("id") Integer id) {
        try {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("id",id);
            int flag = commodityService.checkCommodity(map);
            if (flag==1){
                commodityService.deleteCommodity(id);
                return new AssembleResponseMsg().success("OK");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该商品不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "删除商品失败！");
        }
    }

    @RequestMapping(value = "/editcommodity", produces = "application/json;charset=utf-8")
    public ResponseBody editCommodity(@RequestBody Commodity commodity) {
        try {
            commodityService.editCommodity(commodity);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "修改商品失败！");
        }
    }

    @RequestMapping(value = "/showcommodity",produces = "application/json;charset=utf-8")
    public ResponseBody showCommodity(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = commodityService.showCommodity(map);
            return new AssembleResponseMsg().success(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "模糊查询商品失败！");
        }
    }

    @RequestMapping(value = "/findcommodity",produces = "application/json;charset=utf-8")
    public ResponseBody findCommodity(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = commodityService.findCommodity(map);
            return new AssembleResponseMsg().success(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "精确查询商品失败！");
        }
    }

}

