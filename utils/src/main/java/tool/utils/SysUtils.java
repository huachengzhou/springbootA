package tool.utils;

/**
 * Created by wangpc on 2017/10/19.
 */
public class SysUtils {

    /**
     * 是否为linux系统
     * @return
     */
    public static boolean isLinux(){
        String os = System.getProperty("os.name");
        return os.toLowerCase().startsWith("linux");
    }
}
