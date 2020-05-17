package com.hjj.toy.util.java8.time;


import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TimeDemo {

    //java.time对象都是不可变的
    //t

    public static void main(String[] args) {

        //获取当前瞬时点Instant  并转为北京时间

        System.out.println(Instant.now().atOffset(ZoneOffset.ofHours(8)));


        //Duration表示两个瞬时点之间的时间量
        OffsetDateTime o = Instant.now().atOffset(ZoneOffset.ofHours(8));
        System.out.println(o.toLocalDateTime());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OffsetDateTime oo = Instant.now().atOffset(ZoneOffset.ofHours(8));
        Duration time = Duration.between(o, oo);
        System.out.println(time.toMillis()+"ms");

        //本地日期 无法与瞬时点对应 时段Period
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //两个日期的距离
        long period = localDate.until(localDate, ChronoUnit.DAYS);
        long periodTime = localDateTime.until(localDateTime, ChronoUnit.NANOS);
        System.out.println(period);
        System.out.println(periodTime);

        //日期矫正器TemporalAdjuster
        LocalDate firstTuesday = LocalDate.of(2017, 2, 11).with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println(firstTuesday);

        //实现自己的日期矫正器
        TemporalAdjuster next_work = w -> {
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= 6);

            return result;

        };


        LocalDate backToWork = LocalDate.now().with(next_work);
        System.out.println(backToWork);

        //本地时间LocalTime

        //LocalDateTime表示一个日期和时间，适合用来存储确定时区中的某个时间点。

        //带时区的ZonedDateTime

        //格式化和解析DateTimeFormatter

    }

}
