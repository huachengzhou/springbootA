package tool.utils;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by wangpc on 2017/10/25.
 */
public class ImageUtils {

    /**
     * base64编码转图片
     *
     * @param base64Str
     * @param filePath
     * @return
     * @throws Exception
     */
    public static boolean base64ToImage(String base64Str, String filePath) throws Exception { //对字节数组字符串进行Base64解码并生成图片
        if (base64Str == null) // 图像数据为空
            throw new Exception("参数为空");
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            base64Str = base64Str.replaceAll("^data:.*?,", "");
            byte[] b = decoder.decodeBuffer(base64Str);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(filePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * base64编码转byte
     *
     * @param base64Str
     * @return
     * @throws Exception
     */
    public static byte[] base64ToByte(String base64Str) throws Exception { //对字节数组字符串进行Base64解码
        if (base64Str == null) // 图像数据为空
            throw new Exception("参数为空");
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            base64Str = base64Str.replaceAll("^data:.*?,", "");
            byte[] b = decoder.decodeBuffer(base64Str);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            return b;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
