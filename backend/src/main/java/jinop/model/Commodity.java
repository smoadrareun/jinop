package jinop.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Commodity
 * @Description TODO  商品类
 **/
public class Commodity implements Serializable {
    private Integer id;          //商品唯一标识符
    private String name;         //商品名称
    private BigDecimal price;    //商品价格
    private String num;          //商品剩余数量
    private Integer sales;       //商品销量
    private String info;         //商品描述信息
    private String pic;          //商品图片
    private String kind;         //商品分类
    private String spec;          //商品父级id

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "commodity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                ", sales='" + sales + '\'' +
                ", info='" + info + '\'' +
                ", pic='" + pic + '\'' +
                ", kind='" + kind + '\'' +
                ", spec='" + spec + '\'' +
                '}';
    }
}