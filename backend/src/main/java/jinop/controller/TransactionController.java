package jinop.controller;

import jinop.common.AssembleResponseMsg;
import jinop.common.DateUtil;
import jinop.common.IDUtil;
import jinop.mapper.ClientMapper;
import jinop.mapper.RetailerMapper;
import jinop.model.Client;
import jinop.model.Retailer;
import jinop.model.ResponseBody;
import jinop.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TransactionController
 * @Description TODO 交易信息控制层
 **/

@CrossOrigin
@RestController
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private RetailerMapper retailerMapper;

    @RequestMapping(value = "/addtran", produces = "application/json;charset=utf-8")
    public ResponseBody addTransaction(@RequestBody Map<String, Object> map) {
        try {
            map.put("id", IDUtil.getCID());
            if(map.get("date")==null||map.get("date")=="")
                map.put("date",DateUtil.getCurrentDateStr("yyyy-MM-dd HH:mm:ss"));
            Map<String,Object> newMap = new HashMap<String, Object>();
            if(map.get("cliid")!=null&&map.get("cliid")!="") {
                newMap.put("id",map.get("cliid"));
                List<Client> clientList = clientMapper.findClient(newMap);
                for (Client client : clientList) {
                    map.put("cliname",client.getName());
                }
            }
            if(map.get("retid")!=null&&map.get("retid")!="") {
                newMap.put("id",map.get("retid"));
                List<Retailer> retailerList = retailerMapper.findRetailer(newMap);
                for (Retailer retailer : retailerList) {
                    map.put("retname",retailer.getName());
                }
            }
            transactionService.addTransaction(map);
            Map<String, Object> resultMap = transactionService.findTransaction(map);
            return new AssembleResponseMsg().success(resultMap,200,"添加交易信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "添加交易信息失败！");
        }
    }

    @RequestMapping(value = "/deltran/{id}", produces = "application/json;charset=utf-8")
    public ResponseBody deleteTransaction(@PathVariable("id") String id) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id",id);
            int flag = transactionService.checkTransaction(checkMap);
            if (flag==1){
                transactionService.deleteTransaction(id);
                return new AssembleResponseMsg().success("OK",200,"删除交易信息成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该交易信息不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "删除交易信息失败！");
        }
    }

    @RequestMapping(value = "/edittran", produces = "application/json;charset=utf-8")
    public ResponseBody editTransaction(@RequestBody Map<String, Object> map) {
        try {
            Map<String,Object> checkMap = new HashMap<String, Object>();
            checkMap.put("id", map.get("id"));
            int flag = transactionService.checkTransaction(checkMap);
            if (flag==1){
                transactionService.editTransaction(map);
                Map<String, Object> resultMap = transactionService.findTransaction(map);
                return new AssembleResponseMsg().success(resultMap,200,"修改交易信息成功！");
            }else{
                return new AssembleResponseMsg().failure(202,"error","该交易信息不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "修改交易信息失败！");
        }
    }

    @RequestMapping(value = "/showtran",produces = "application/json;charset=utf-8")
    public ResponseBody showTransaction(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = transactionService.showTransaction(map);
            if(map.isEmpty()==true)
            {
                return new AssembleResponseMsg().success(resultMap,200,"显示所有交易信息成功！");
            }else{
                return new AssembleResponseMsg().success(resultMap,200,"模糊查询交易信息成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "模糊查询交易信息失败！");
        }
    }

    @RequestMapping(value = "/findtran",produces = "application/json;charset=utf-8")
    public ResponseBody findTransaction(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = transactionService.findTransaction(map);
            if(map.isEmpty()==true)
            {
                return new AssembleResponseMsg().success(resultMap,200,"显示所有交易信息成功！");
            }else{
                return new AssembleResponseMsg().success(resultMap,200,"精确查询交易信息成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "精确查询交易信息失败！");
        }
    }

}

