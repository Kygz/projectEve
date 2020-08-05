package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public static <T> List<T>[] splitList(List<T> list, int num) {
        if (isEmpty((Collection)list)) {
            return new ArrayList[0];
        } else if (num < 2) {
            throw new IllegalArgumentException("Argument num [" + num + "] must greater then 2");
        } else {
            int length = (int)Math.ceil((double)list.size() / (double)num);
            List[] result = new ArrayList[length];

            for(int i = 0; i < length; ++i) {
                int first = i * num;
                int max = Math.min(list.size(), first + num);
                List<T> temp = list.subList(first, max);
                result[i] = new ArrayList(temp);
            }
            return result;
        }
    }
}
