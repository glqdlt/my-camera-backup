package com.glqdlt.myho;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public interface DateParser {

    class DefaultdateParser implements DateParser {

    }

    interface Mp4DateParser extends DateParser {

        @Override
        default String parsing(String originDate) {
            DateTimeFormatter aaa = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            LocalDateTime zzz = LocalDateTime.parse(originDate, aaa);
            return (zzz.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")));
        }
    }

    interface JpgDateParser extends DateParser {

        @Override
        default String parsing(String originDate) {
            DateTimeFormatter zzzz = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
            return LocalDateTime.parse(originDate, zzzz).format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        }
    }

    default String parsing(String originDate) {
        return originDate.replace(" ", ":")
                .replace(":", "_");
    }
}
