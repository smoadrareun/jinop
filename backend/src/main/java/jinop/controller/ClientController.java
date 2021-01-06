package jinop.controller;

import jinop.common.AssembleResponseMsg;
import jinop.model.Client;
import jinop.model.ResponseBody;
import jinop.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ClientController
 * @Description TODO 客户控制层
 **/

@CrossOrigin
@RestController
public class ClientController {
    @Autowired
    private IClientService clientService;

    @RequestMapping(value = "/queryclient",produces = "application/json;charset=utf-8")
    public ResponseBody queryClient(@RequestBody Map<String,Object> map){
        int flag = clientService.queryClient(map);
        if (flag==1){
            Map<String, Object> resultMap = clientService.findClient(map);
            return new AssembleResponseMsg().success(resultMap,200,"客户登录成功！");
        }else{
            return new AssembleResponseMsg().failure(201,"error","用户名或密码错误！");
        }
    }

    @RequestMapping(value = "/addclient", produces = "application/json;charset=utf-8")
    public ResponseBody addClient(@RequestBody Map<String, Object> map) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("username", map.get("username"));
            int flag = clientService.checkClient(map);
            if (flag==0){
                clientService.addClient(map);
                Map<String, Object> resultMap = clientService.findClient(map);
                return new AssembleResponseMsg().success(resultMap,200,"添加客户成功！");
            }else{
                return new AssembleResponseMsg().failure(203,"error","用户名已存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "添加客户失败！");
        }
    }

    @RequestMapping(value = "/deleteclient/{id}", produces = "application/json;charset=utf-8")
    public ResponseBody deleteClient(@PathVariable("id") Integer id) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id",id);
            int flag = clientService.checkClient(checkMap);
            if (flag==1){
                clientService.deleteClient(id);
                return new AssembleResponseMsg().success("OK",200,"删除客户成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该客户不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "删除客户失败！");
        }
    }

    @RequestMapping(value = "/editclient", produces = "application/json;charset=utf-8")
    public ResponseBody editClient(@RequestBody Map<String, Object> map) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id", map.get("id"));
            int flag = clientService.checkClient(map);
            if (flag==1){
                clientService.editClient(map);
                Map<String, Object> resultMap = clientService.findClient(map);
                return new AssembleResponseMsg().success(resultMap,200,"修改客户成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该客户不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "修改客户失败！");
        }
    }

    @RequestMapping(value = "/showclient",produces = "application/json;charset=utf-8")
    public ResponseBody showClient(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = clientService.showClient(map);
            return new AssembleResponseMsg().success(resultMap,200,"模糊查询客户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "模糊查询客户失败！");
        }
    }

    @RequestMapping(value = "/findclient",produces = "application/json;charset=utf-8")
    public ResponseBody findClient(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = clientService.findClient(map);
            return new AssembleResponseMsg().success(resultMap,200,"精确查询客户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "精确查询客户失败！");
        }
    }

}

