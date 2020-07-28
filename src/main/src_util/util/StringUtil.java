package util;

import java.util.Collection;

public class StringUtil {

    public static boolean isBlank(String text){
        return (text == null || "".equals(text.trim()));
    }

    public static boolean isNotBlank(String text){
        return !isBlank(text);
    }

    public static boolean isEmpty(Collection collection){
        return (collection == null || collection.size() == 0);
    }

    public static boolean isNotEmpty(Collection collection){
        return !isEmpty(collection);
    }

}
