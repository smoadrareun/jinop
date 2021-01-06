package jinop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Transaction
 * @Description TODO  交易信息类
 **/
public class Transaction implements Serializable {
    private Integer id;           //交易信息唯一标识符
    private Integer cliid;        //客户id
    private Integer merid;        //商户id
    private Date date;            //交易日期
    private BigDecimal money;     //交易金额
    private String info;          //交易详情
    private String remark;        //订单备注
    private BigDecimal demoney;   //配送费
    private Integer status;       //订单状态

    public Integer getId() {
        return id;
    }

    public Integer getCliid() {
        return cliid;
    }

    public void setCliid(Integer cliid) {
        this.cliid = cliid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
