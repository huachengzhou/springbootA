package tool.utils;

import org.apache.http.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 *
 * 实现描述：MD5加密工具，主要用于HMAC签名
 *
 * @author red
 * @version v1.0.0
 */
public class Md5Utils {

    private static final String HEX_DIGITS[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };

    private final static Logger logger = LoggerFactory.getLogger(Md5Utils.class);

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (byte element : b) {
            resultSb.append(Md5Utils.byteToHexString(element));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return Md5Utils.HEX_DIGITS[d1] + Md5Utils.HEX_DIGITS[d2];
    }

    public static String md5Encode(String origin) {
        return Md5Utils.md5Encode(origin, Consts.UTF_8.name());
    }

    public static String md5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = Md5Utils.byteArrayToHexString(md.digest(origin.getBytes(charsetname)));
        } catch (Exception e) {
            Md5Utils.logger.error("ERROR ## md5 encode happend error, the trace is ", e);
        }
        return resultString;
    }

}
