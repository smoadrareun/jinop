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
    private String cliid;        //客户id
    private String merid;        //商户id
    private String cliname;       //客户名称
    private String mername;       //商户名称
    private String date;          //交易日期
    private BigDecimal money;     //交易金额
    private JSONArray info;       //交易详情
    private String remark;        //订单备注
    private BigDecimal demoney;   //配送费
    private Integer status;       //订单状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliid() {
        return cliid;
    }

    public void setCliid(String cliid) {
        this.cliid = cliid;
    }

    public String getMerid() {
        return merid;
    }

    public void setMerid(String merid) {
        this.merid = merid;
    }

    public String getCliname() {
        return cliname;
    }

    public void setCliname(String cliname) {
        this.cliname = cliname;
    }

    public String getMername() {
        return mername;
    }

    public void setMername(String mername) {
        this.mername = mername;
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

    public BigDecimal getDemoney() {
        return demoney;
    }

    public void setDemoney(BigDecimal demoney) {
        this.demoney = demoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "id='" + id + '\'' +
                ", cliid='" + cliid + '\'' +
                ", merid='" + merid + '\'' +
                ", date='" + date + '\'' +
                ", money='" + money + '\'' +
                ", info='" + info + '\'' +
                ", remark='" + remark + '\'' +
                ", demoney='" + demoney + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
