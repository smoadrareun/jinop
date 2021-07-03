package jinop.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Client
 * @Description TODO  客户类
 **/
public class Client implements Serializable {
    private Integer id;		//客户唯一标识符
    private String username;	//客户账号名称
    private String passwd;		//客户账号密码
    private BigDecimal money;	//客户余额
    private String name;	//客户姓名
    private Long num;	//客户电话
    private String addinfo;		//客户地址
    private Integer paypass;	//客户支付密码
    private Boolean level;	//客户等级
    private BigDecimal longi;	//经度度数
    private BigDecimal lati;		//纬度度数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
    	this.passwd = passwd; 
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

    public Integer getPaypass() {
        return paypass;
    }

    public void getPaypass(Integer paypass) {
    	this.paypass = paypass; 
    }

    public Boolean getLevel() {
        return level;
    }

    public void getLevel(Boolean level) { 
    	this.level = level; 
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
        return "client{" +
                "id='" + id + '\'' +
                ", username'" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", money='" + money + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", addinfo='" + addinfo + '\'' +
                ", paypass='" + paypass + '\'' +
                ", level='" + level + '\'' +
                ", long='" + longi + '\'' +
                 ", lat='" + lati + '\'' +
                '}';
    }

}


