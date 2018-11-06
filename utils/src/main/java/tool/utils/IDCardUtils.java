package tool.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述:身份证处理相关类
 * @author: Calvin(qiudong@copowercpa.com)
 * @data: 2017/7/26
 * @time: 9:42
 */
public class IDCardUtils {
      /**
     * <p>
     * 判断18位身份证的合法性
     *
     * @param idcard
     * @return
     */
    public static boolean isValidate18Idcard(String idcard) {
        // 非18位为假
        if (idcard.length() != 18) {
            return false;
        }
        // 获取前17位
        String idcard17 = idcard.substring(0, 17);
        // 获取第18位
        String idcard18Code = idcard.substring(17, 18);
        char c[] = null;
        String checkCode = "";
        // 是否都为数字
        if (isDigital(idcard17)) {
            c = idcard17.toCharArray();
        } else {
            return false;
        }

        if (null != c) {
            int bit[] = converCharToInt(c);
            int sum17 = 0;
            sum17 = getPowerSum(bit);
            // 将和值与11取模得到余数进行校验码判断
            checkCode = getCheckCodeBySum(sum17);
            if (null == checkCode) {
                return false;
            }
            // 将身份证的第18位与算出来的校码进行匹配，不相等就为假
            if (!idcard18Code.equalsIgnoreCase(checkCode)) {
                return false;
            }
        }
        return true;
    }
    /**
     * 将字符数组转为整型数组
     *
     * @param c
     * @return
     * @throws NumberFormatException
     */
    private static int[] converCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }
        return a;
    }
    /**
     * 数字验证
     * @param str
     * @return
     */
    private static boolean isDigital(String str) {
        return str == null || "".equals(str) ? false : str.matches("^[0-9]*$");
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     * @param bit
     * @return
     */
    private static int getPowerSum(int[] bit) {
        int power[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        int sum = 0;
        if (power.length != bit.length) {
            return sum;
        }

        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < power.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * power[j];
                }
            }
        }
        return sum;
    }

    /**
     * 将和值与11取模得到余数进行校验码判断
     * @param sum17
     * @return 校验位
     */
    private static String getCheckCodeBySum(int sum17) {
        String verifyCode[] = { "1", "0", "X", "9", "8", "7", "6", "5",
                "4", "3", "2" };
        return verifyCode[sum17%11];
    }

    /**
     * 根据身份证取得出生日期
     * @param idcard
     * @return
     * @throws ParseException
     */
    public static Date BirthdayByIdcard(String idcard) throws ParseException {
        String birthday = idcard.substring(6, 14);
        Date birthdate = new SimpleDateFormat("yyyyMMdd")
                .parse(birthday);
        return birthdate;
    }

    /**
     * 根据身份证号取性别
     * @param idcard
     * @return
     */
    public static String GenderByIdcard(String idcard)
    {
        String id17 = idcard.substring(16, 17);
        if (Integer.parseInt(id17) % 2 != 0) {
            return  "男";
        } else {
            return "女";
        }
    }



}
