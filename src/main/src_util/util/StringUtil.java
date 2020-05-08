package util;

public class StringUtil {

    public static boolean isBlank(String text){
        return (text == null || "".equals(text.trim()));
    }

    public static boolean isNotBlank(String text){
        return !isBlank(text);
    }

}
