package jinop.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName merchant
 * @Description TODO  商户类
 **/
public class Merchant implements Serializable {
    private String id;
    private String username;
    private String password;
    private BigDecimal money;
    private String name;
    private Long num;
    private String address;
    private Integer level;
    private String location;
    private BigDecimal price;

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

    public Integer getLevel() {
        return level;
    }

    public void getLevel(Integer level) { this.level = level; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) { this.location = location; }

    public BigDecimal getPrice() {
        return price;
    }

    public void getPrice(BigDecimal price) { this.price = price; }

    @Override
    public String toString() {
        return "Merchant{" +
                "id='" + id + '\'' +
                ", username'" + username + '\'' +
                ", password='" + password + '\'' +
                ", money='" + money + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                ", location='" + location + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}


