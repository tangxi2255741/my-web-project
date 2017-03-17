package com.jd.tx;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.Date;

/**
 * @author cdtangxi
 * @Date 2017/3/17 10:32
 */
public class JodaTimeTest {
    /** 年-月-日 小时：分：秒*/
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 年-月-日 */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /** yyyy年MM月dd日 */
    public static final String DATE_CH_FORMAT = "yyyy年MM月dd日";
    /** 小时:分*/
    public static final String HHMM_FORMAT = "HH:mm";
    /** 小时:分:秒 */
    public static final String HHMMSS_FORMAT = "HH:mm:ss";
    /** 年月日数值 */
    public static final String DATE_FORMAT_NEW = "yyyyMMdd";

    @Test
    public void testInitDate(){
        // 1、无参构造：当前系统所在时区的当前时间，精确到毫秒
        DateTime dateTime1 = new DateTime();
        System.out.println(dateTime1.toString(DATE_TIME_FORMAT));//2017-03-17 13:49:52
        // 2、构造指定年,月,日,时,分,秒,毫秒
        DateTime dateTime2 = new DateTime(2012, 12, 13, 18, 23,55);
        System.out.println(dateTime2.toString(DATE_TIME_FORMAT));// 2012-12-13 18:23:55
        DateTime dateTime3 = new DateTime(2012, 12, 13, 18, 23,55, 333);
        System.out.println(dateTime3.toString("yyyy-MM-dd HH:mm:ss.SSS a"));//2012-12-13 18:23:55.333 下午
        // 3、时间戳初始化：
        DateTime dateTime4 = new DateTime(1456473917004L);
        System.out.println(dateTime4.toString(DATE_TIME_FORMAT));//2016-02-26 16:05:17
        // 4、对象构造时间：可以是ReadableInstant, String, Calendar和Date
        DateTime dateTime5 = new DateTime(new Date());
        System.out.println(dateTime5.toString(DATE_TIME_FORMAT));//2017-03-17 13:49:52
    }

    @Test
    public void testPuls(){
        DateTime now = DateTime.now();
        System.out.println("当前时间：" + now.toString(DATE_TIME_FORMAT));
        System.out.println("一小时后：" + now.plusHours(1).toString(DATE_TIME_FORMAT));
        System.out.println("一天前：" + now.minusDays(1).toString(DATE_TIME_FORMAT));
    }

    @Test
    public void testStringToDate(){
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format);
        //时间格式化，输出==> 2012/12/21 23:22:45 星期五
        System.out.println(dateTime2.toString("yyyy/MM/dd HH:mm:ss EE"));
    }

    @Test
    public void testWith(){
        DateTime dateTime = new DateTime(2017,03,17,13,50);
        System.out.println(dateTime.toString(DATE_TIME_FORMAT));//2017-03-17 13:50:00
        DateTime modifyYear = dateTime.withYear(2016);//2016-03-17 13:50:00
        System.out.println(modifyYear.toString(DATE_TIME_FORMAT));
        DateTime modifyDay = dateTime.withDayOfMonth(15);
        System.out.println(modifyDay.toString(DATE_TIME_FORMAT));//2017-03-15 13:50:00
        DateTime modifyDay2 = dateTime.withDayOfWeek(1);// 修改到一周的第五天，周一是第一天
        System.out.println(modifyDay2.toString(DATE_TIME_FORMAT));//2017-03-13 13:50:00
    }

    @Test
    public void testLocal(){
        // 当前日期:年月日 2017-03-17
        LocalDate now = LocalDate.now();
        System.out.println(now);
        // 下一周：2017-03-24
        LocalDate nextWeek = now.plusWeeks(1);
        System.out.println(nextWeek);
        // 判断当前时间是否在下一周之后：false
        System.out.println(now.isAfter(nextWeek));
        // 当前时间 时、分、秒、毫秒 14:08:07.362
        LocalTime time = LocalTime.now();
        System.out.println(time);
    }
}
