package util;

import java.util.UUID;

public class SysUtil {
    public SysUtil() {
    }

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
}