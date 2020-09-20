package xyz.hpwyx.manager.common;

import java.util.UUID;

/**
 * @author tid
 * @create 2019-07-14 18:40
 **/

public class TokenUtils {
    /**
     * token生成
     * @return
     */

    public static String getPayToken() {
        return "TOKEN_pay" + "-" + UUID.randomUUID();
    }
}
