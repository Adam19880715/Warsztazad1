package utils;

import java.sql.Timestamp;

public class TimeStamp {

    public static String timestamp() {
        return String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
    }
}
