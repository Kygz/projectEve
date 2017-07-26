package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.UUID;

public class SysUtil {
    public SysUtil() {}

    public static long longUUID() {
        return UUID.randomUUID().getMostSignificantBits();
    }

    public static long absLongUUID() {
        long r;
        do {
            r = longUUID();
        } while(r <= 0L);

        return r;
    }

    /**
     * 如果 Long 的数字超过15位，转换为String，在json中数字两边有引号
     * @return
     */
    public static Gson createGson(){
        class LongSerializer implements JsonSerializer<Long> {
            public JsonElement serialize(Long src, Type typeOfSrc, JsonSerializationContext context) {
                if(src!=null){
                    String strSrc = src.toString();
                    if(strSrc.length()>15){
                        return new JsonPrimitive(strSrc);
                    }
                }
                return new JsonPrimitive(src);
            }
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        LongSerializer serializer = new LongSerializer();
        gsonBuilder.registerTypeAdapter(Long.class, serializer);
        gsonBuilder.registerTypeAdapter(long.class, serializer);
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        return gsonBuilder.create();
    }


}