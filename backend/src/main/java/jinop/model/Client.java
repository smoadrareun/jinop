package jinop.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Client
 * @Description TODO  客户类
 **/
public class Client implements Serializable {
    private String id;
    private String username;
    private String password;
    private BigDecimal money;
    private String name;
    private Long num;
    private String address;
    private Integer paypass;
    private Integer viplevel;
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) { this.money = money; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) { this.num = num; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) { this.address = address; }

    public Integer getPaypass() {
        return paypass;
    }

    public void getPaypass(Integer paypass) { this.paypass = paypass; }

    public Integer getViplevel() {
        return viplevel;
    }

    public void getViplevel(Integer viplevel) { this.viplevel = viplevel; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return "client{" +
                "id='" + id + '\'' +
                ", username'" + username + '\'' +
                ", password='" + password + '\'' +
                ", money='" + money + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", address='" + address + '\'' +
                ", paypass='" + paypass + '\'' +
                ", viplevel='" + viplevel + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

}


