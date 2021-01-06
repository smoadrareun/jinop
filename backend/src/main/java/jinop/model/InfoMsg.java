package jinop.model;

import java.io.Serializable;

/**
 * @ClassName InfoMsg
 * @Description TODO   错误信息消息体
 **/

public class InfoMsg implements Serializable {
    private String code;     //错误码
    private String message;  //错误信息

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
