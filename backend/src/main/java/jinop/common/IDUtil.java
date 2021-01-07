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

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    public static String getShortUUID() {
        StringBuffer shortBuffer = new StringBuffer();
        String suuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = suuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getID(){
        String id = "CNY";
        id = id + DateUtil.getCurrentDateStr("yyyy-MM-dd HH:mm:ss").replaceAll("-|:|\\s*", "");
        return id;
    }
}

