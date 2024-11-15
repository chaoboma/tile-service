package com.application.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTransform {
    public static LocalDateTime longToLocalDateTime(Long time) {
        if (time != null && time != 0) {
            Instant instant = Instant.ofEpochMilli(time);
            ZoneId zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone);
        } else {
            return null;
        }
    }


    public static Long localDateTimeToLong(LocalDateTime time) {
        if (time != null) {
            ZoneId zone = ZoneId.systemDefault();
            Instant instant = time.atZone(zone).toInstant();
            return instant.toEpochMilli();
        } else {
            return null;
        }
    }

    public static LocalDate longToLocalDate(Long time) {
        if (time != null && time != 0) {
            Instant instant = Instant.ofEpochMilli(time);
            ZoneId zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone).toLocalDate();
        } else {
            return null;
        }
    }

    public static Long localDateToLong(LocalDate localDate) {
        if (localDate == null){
            return null;
        }
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay(zone).toInstant();
        return instant.toEpochMilli();
    }
}