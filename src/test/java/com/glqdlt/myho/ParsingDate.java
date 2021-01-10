package com.glqdlt.myho;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParsingDate {


    /**
     * @see <a href='https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns'>https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns</a>
     */
    @Test
    public void name2() {
        String t = "Wed Jan 01 00:05:28 KST 2020";
        DateTimeFormatter aaa = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        LocalDateTime zzz = LocalDateTime.parse(t, aaa);
        String aaaaaaa = (zzz.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH:mm_ss")));
        Assert.assertEquals("2020_01_01_00:05_28", aaaaaaa);
    }

    @Test
    public void name() {
        String t = "2021:01:09 14:20:51";
        DateTimeFormatter zzzz = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
        String ss = LocalDateTime.parse(t,zzzz).format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        Assert.assertEquals("2021_01_09_14_20_51", ss);
    }
}
