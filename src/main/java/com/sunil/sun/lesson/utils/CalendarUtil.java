package com.sunil.sun.lesson.utils;

/**
 * @ClassName CalendarUtil
 * @Description 日历工具类
 * @Author jian.sun.qd
 * @Date 04/11/2020 11:52
 * @Version 1.0
 **/
import java.util.Calendar;

public class CalendarUtil {
    /**
     * 获得当前年份
     * @return
     */
    public static int getYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    /**
     * 计算指定日期为当年第几周
     * @param year       指定的年份
     * @param month      指定的月份
     * @param day        指定的日
     * @return           指定日期为当年的第几周
     */
    public static int caculateWeekOfYear(int year,int month,int day){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DATE, day);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取本月第一天是星期几
     * @return
     */
    public static int getWeekOfFirstDay(Calendar c){
        Calendar calendar = c;
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取本月1号是该年的第几周
     * @return
     */
    public static int getMonthStartWeek(Calendar c){
        Calendar calendar = c;
        calendar.set(Calendar.DATE, 1);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取当天是该年的第几周
     */
    public static int getCurrentWeekOfYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取上月的总天数
     * @return
     */
    public static int getLastMonthDays(Calendar c){
        Calendar calendar = c;
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定月份的总天数
     * @return
     */
    public static int getCurrentMonthDays(int month){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month - 1);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定年份有多少周
     * @param year
     * @return
     */
    public static int getTotalWeekOfYear(int year){
        Calendar c = Calendar.getInstance();
        return c.getActualMaximum(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 判断指定月份是否是当前月
     * @param month
     * @return
     */
    public static boolean isCurrentMonth(int month){
        Calendar c = Calendar.getInstance();
        return (c.get(Calendar.MONTH) == month - 1)?true:false;
    }

    /**
     * 计算指定的月份共有多少天
     */
    public static int getTotalDaysOfMonth(int year, int month){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DATE, 1);
        /**
         * 计算这个月有多少天
         */
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 指定日期零点(一天的开始)来获取毫秒数
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static long getStartTimeByDay(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return  calendar.getTimeInMillis();
    }

    /**
     * 获取year对应的今天的零点时的毫秒数
     * @param year
     * @return
     */
    public static long getOtherYearInTodayMinTime(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取year对应的今天23:59:59(一天的结束)来获取毫秒数
     * @param year
     * @return
     */
    public static long getOtherYearInTodayMaxTime(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTimeInMillis();
    }

    /**
     * 根据时间获取对应的日历时间
     * @param time
     * @return
     */
    public static Calendar getCalendar(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar;
    }
    /**
     * 根据指定日历查找年份
     * @param calendar
     * @return
     */
    public static int getYearByCalendar(Calendar calendar){
        return calendar.get(Calendar.YEAR);
    }
    /**
     * 根据指定日历及年份修改日历年份后的对应的时间(毫秒)
     * @param calendar
     * @param year
     * @return
     */
    public static long getTimeByCalendarNewYear(Calendar calendar, int year){
        calendar.set(Calendar.YEAR, year);
        return calendar.getTimeInMillis();
    }
    /**
     * 根据指定日历及增减年数修改日历年份后的对应的时间(毫秒)
     * @param calendar
     * @param v
     * @return
     */
    public static long getTimeByCalendarAddYearsAfter(Calendar calendar,int v ){
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + v);
        return calendar.getTimeInMillis();
    }
    /**
     *
     * @param calendar
     * @return
     */
    public static long getTimeByCalendar(Calendar calendar){
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当前所在的月份
     * @return
     */
    public static int getCurrentMonth(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 指定日期23:59:59(一天的结束)来获取毫秒数
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static long getEndTimeByDay(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取今天0点的毫秒数
     * @return
     */
    public static long getTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取当前天为几号
     * @return
     */
    public static int getCurrentDay(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前日期:yyyy-mm-dd
     * @return
     */
    public static String getDate(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = "" + year + "-" + (month >= 10?month:"0"+month) + "-" + (day >= 10?day:"0"+day);
        return date;
    }


    /**
     * 获取指定日历下的日期:yyyy-mm-dd
     * @return
     */
    public static String getDate(Calendar calendar){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = "" + year + "-" + (month >= 10?month:"0"+month) + "-" + (day >= 10?day:"0"+day);
        return date;
    }

    /**
     * 获取指定时间对应的日期:yyyy-mm-dd
     * @return
     */
    public static String getDate(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = "" + year + "-" + (month >= 10?month:"0"+month) + "-" + (day >= 10?day:"0"+day);
        return date;
    }

}