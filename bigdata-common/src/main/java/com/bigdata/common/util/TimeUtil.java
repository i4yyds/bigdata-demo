package com.bigdata.common.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static String getCurrentTime() {
        // 获取当前日期和时间
        LocalDateTime now = LocalDateTime.now();
        // 创建一个日期时间格式器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 使用格式器格式化日期时间
        String formattedDate = now.format(formatter);
        return formattedDate;
    }

    public static Long getCurrentTms() {
        return Instant.now().getEpochSecond();
    }
}
