package jinop.common;

import java.util.UUID;

/**
 * 各种ID工具类
 * @ClassName IDUtil
 * @Description TODO
 **/

public class IDUtil {

    /**
     * 获取uuid（以去掉'-'字符）
     * @Param []
     * @return java.lang.String
     **/

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}

