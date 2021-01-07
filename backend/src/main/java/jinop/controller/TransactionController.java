package jinop.controller;

import jinop.common.AssembleResponseMsg;
import jinop.common.DateUtil;
import jinop.model.ResponseBody;
import jinop.model.Transaction;
import jinop.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @RequestMapping(value = "/addtransaction", produces = "application/json;charset=utf-8")
    public ResponseBody addTransaction(@RequestBody Map<String, Object> map) {
        try {
            if(map.get("date")==null||map.get("date")=="")
                map.put("date",DateUtil.getCurrentDateStr("yyyy-MM-dd HH:mm:ss"));
            transactionService.addTransaction(map);
            Map<String, Object> resultMap = transactionService.findTransaction(map);
            return new AssembleResponseMsg().success(resultMap,200,"添加交易信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "添加交易信息失败！");
        }
    }

    @RequestMapping(value = "/deletetransaction/{id}", produces = "application/json;charset=utf-8")
    public ResponseBody deleteTransaction(@PathVariable("id") Integer id) {
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

    @RequestMapping(value = "/edittransaction", produces = "application/json;charset=utf-8")
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
                return new AssembleResponseMsg().failure(202,"error","该信息不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "修改交易信息失败！");
        }
    }

    @RequestMapping(value = "/showtransaction",produces = "application/json;charset=utf-8")
    public ResponseBody showTransaction(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = transactionService.showTransaction(map);
            return new AssembleResponseMsg().success(resultMap,200,"模糊查询交易信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "模糊查询交易信息失败！");
        }
    }

    @RequestMapping(value = "/findtransaction",produces = "application/json;charset=utf-8")
    public ResponseBody findTransaction(@RequestBody Map<String,Object> map){
        try {
            Map<String, Object> resultMap = transactionService.findTransaction(map);
            return new AssembleResponseMsg().success(resultMap,200,"精确查询交易信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(201, "error", "精确查询交易信息失败！");
        }
    }

}

