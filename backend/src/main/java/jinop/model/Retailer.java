package jinop.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Retailer
 * @Description TODO  店铺类
 **/
public class Retailer implements Serializable {
    private Integer id;          //店铺唯一标识符
    private BigDecimal money;    //店铺余额
    private String name;         //店铺名称
    private Long num;          //店铺电话
    private String addinfo;         //店铺地址
    private BigDecimal disc;    //会员折扣
    private BigDecimal dist;    //外送距离
    private BigDecimal price;    //外送费
    private BigDecimal longi;    //经度度数
    private BigDecimal lati;    //纬度度数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getAddinfo() {
        return addinfo;
    }

    public void setAddinfo(String addinfo) {
        this.addinfo = addinfo;
    }

    public BigDecimal getDisc() {
        return disc;
    }

    public void setDisc(BigDecimal disc) {
        this.disc = disc;
    }

    public BigDecimal getDist() {
        return dist;
    }

    public void setDist(BigDecimal dist) {
        this.dist = dist;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public BigDecimal getLongi() {
        return longi;
    }

    public void setLongi(BigDecimal longi) {
        this.longi = longi;
    }
    
    public BigDecimal getLati() {
        return lati;
    }

    public void setLati(BigDecimal lati) {
        this.lati = lati;
    }

    @Override
    public String toString() {
        return "commodity{" +
                "id='" + id + '\'' +
                ", money='" + money + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", addinfo='" + addinfo + '\'' +
                ", disc='" + disc + '\'' +
                ", dist='" + dist + '\'' +
                ", price='" + price + '\'' +
                ", long='" + longi + '\'' +
                ", lat='" + lati + '\'' +
                '}';
    }
}