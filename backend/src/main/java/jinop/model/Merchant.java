package jinop.model;

import java.io.Serializable;

/**
 * @ClassName merchant
 * @Description TODO  商户类
 **/
public class Merchant implements Serializable {
    private Integer id;		//商户唯一标识符
    private String username;	//商户账号名称
    private String passwd;	//商户账号密码
    private String name;	//商户姓名
    private Long num;	//商户电话
    private String addinfo;		//商户地址
    private Boolean level;		//商户等级

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

    public Boolean getLevel() {
        return level;
    }

    public void getLevel(Boolean level) {
    	this.level = level; 
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id='" + id + '\'' +
                ", username'" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", addinfo='" + addinfo + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

}


