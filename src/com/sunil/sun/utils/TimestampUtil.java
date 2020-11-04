package com.sunil.sun.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @ClassName TimestampUtil
 * @Description 时间戳工具类
 * @Author jian.sun.qd
 * @Date 04/11/2020 14:47
 * @Version 1.0
 **/
public class TimestampUtil {

    private static SimpleDateFormat tsdf = null;  //timestamp date formatter
    private static SimpleDateFormat dtdf = null; //date time date formatter
    private static SimpleDateFormat tsdp = null;  //timestamp date parser
    private static SimpleDateFormat dtdp = null; //date time date parser
    private static SimpleDateFormat tp_dt = null;//日期时间格式 yyyy-MM-dd HH:mm:ss

    private static void init() {
        if (null == dtdp) {

//          TimeZone utcTz= TimeZone.getTimeZone("GMT+0:00");
            TimeZone cnTz = TimeZone.getTimeZone("GMT+8:00");

            tsdf = new SimpleDateFormat("yyyyMMddHHmmss");
            tsdf.setTimeZone(cnTz);
            dtdf = new SimpleDateFormat("yyyyMMdd");
            dtdf.setTimeZone(cnTz);

            tsdp = new SimpleDateFormat("yyyyMMddHHmmss");
//          tsdp.setTimeZone(utcTz);
            tsdp.setTimeZone(cnTz);
            dtdp = new SimpleDateFormat("yyyyMMdd");
//          dtdp.setTimeZone(utcTz);
            dtdp.setTimeZone(cnTz);

            tp_dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tp_dt.setTimeZone(cnTz);
        }
    }

    public static String toTimestamp(Timestamp ts) {
        init();
        return tsdf.format(ts);
    }

    public static String toTimestamp(Date ts) {
        init();
        return tsdf.format(ts);
    }

    public static String toDateStr(Timestamp ts) {
        init();
        return dtdf.format(ts);
    }

    public static String toDateStr(Date ts) {
        init();
        return dtdf.format(ts);
    }

    //String2Timestamp:
    public static Timestamp parse(String str) {
        init();

        if (null == str || 8 > str.length()) {
            return null;
        }

        if (14 < str.length()) {
            str = str.substring(0, 14);
        }
        int size = str.length();
        for (int i = 0; i < size; ++i) {
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                return null;
            }
        }

        Date ret = null;
        if (8 == str.length()) {
            try {
                ret = dtdp.parse(str);
            } catch (Exception ex) {
                ret = null;
            }

            return new Timestamp(ret.getTime());
        }

        if (14 > size) {
            for (int i = size; i < 14; i++) {
                str += "0";
            }
        }

        try {
            ret = tsdp.parse(str);
        } catch (Exception ex) {
            ret = null;
        }

        return new Timestamp(ret.getTime());
    }

    /**
     * 当前年月日-yyyyMMdd
     *
     * @return
     */
    public static String getTimeIsDate() {
        init();
        return dtdp.format(System.currentTimeMillis());
    }

    /**
     * 当前年月日-yyyyMMdd HH:mm:ss
     *
     * @return
     */
    public static String getTimeInDateTime() {
        init();
        return tp_dt.format(System.currentTimeMillis());
    }

    /**
     * 获取当前的时间戳yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static Timestamp getTimestampByCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 根据time获取时间戳yyyy-MM-dd HH:mm:ss
     *
     * @param time
     * @return
     */
    public static Timestamp getTimestampByTimeMillis(long time) {
        return new Timestamp(time);
    }

    /**
     * 获取当前的时间yyyyMMddHHmmss
     *
     * @return
     */
    public static String getTimeInTime() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis())).toString();
    }

}