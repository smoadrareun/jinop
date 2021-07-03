package jinop.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import jinop.common.DateUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Transaction
 * @Description TODO  交易信息类
 **/
public class Transaction implements Serializable {
    private String id;           //交易信息唯一标识符
    private int cliid;        //客户id
    private int retid;        //商户id
    private String cliname;       //客户名称
    private String retname;       //商户名称
    private String date;          //交易日期
    private BigDecimal money;     //交易金额
    private JSONArray info;       //交易详情
    private String remark;        //订单备注
    private Boolean status;       //订单状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCliid() {
        return cliid;
    }

    public void setCliid(int cliid) {
        this.cliid = cliid;
    }

    public int getRetid() {
        return retid;
    }

    public void setRetid(int retid) {
        this.retid = retid;
    }

    public String getCliname() {
        return cliname;
    }

    public void setCliname(String cliname) {
        this.cliname = cliname;
    }

    public String getRetname() {
        return retname;
    }

    public void setRetname(String retname) {
        this.retname = retname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public JSONArray getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseArray(info);
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "id='" + id + '\'' +
                ", cliid='" + cliid + '\'' +
                ", retid='" + retid + '\'' +
                ", date='" + date + '\'' +
                ", money='" + money + '\'' +
                ", info='" + info + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
