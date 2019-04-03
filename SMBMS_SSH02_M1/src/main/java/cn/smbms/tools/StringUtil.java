package cn.smbms.tools;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 张鸿杰
 * Date：2019-04-01
 * Time:17:28
 */
public class StringUtil {
    public static boolean isNull(String str) {
        if (str == null || str.equals("")){
            return true;
        }
        return false;
    }
}
