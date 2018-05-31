package com.company.demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class LocalTimeMain {
//Date API before Java 8 -> Date, Calendar..
    //vs
    //Java Date/Time API in Java 8

    //Problems with old API

    //1
    //Date and time calculation: plus 1 day, minus 2 seconds, plus 1 week
    //by the end of next day
    //time now + plus 2 days + get start of the day (2.06) - 1 second =
    //1/06/2018   23:59:59

    //2
    //TIME ZONES
    //Impossible to calculate date with time zones for different countries

    //3
    //Thread safe (multithreading)

    //Solutions before Java 8:
    //1. Joda Time
    //2. Apache Commons
    //3. Date4J


    public static void main(String[] args) {
        //      Local       -     Zone
        //LocalTime
        //LocalDate
        //LocalDateTime         ZoneDateTime

        //Difference between:
        //LocalDate - Period (dates only)
        //LocalTime - Duration
        //Everyone - ChronoUnit

        LocalTime start = LocalTime.of(9, 45, 31);
        LocalTime end = LocalTime.of(17, 21, 1);

        System.out.println(Duration.between(start, end).toHours());

        System.out.println();

        LocalDate startDate = LocalDate.of(2018, 1, 1);
        LocalDate endDate = LocalDate.now();

        System.out.println(ChronoUnit.DAYS.between(startDate, endDate));

        LocalDateTime fullDateStart = LocalDateTime.of(2000, 1, 1, 0, 0);
        LocalDateTime fullDateEnd = LocalDateTime.now();
        long between = ChronoUnit.MONTHS.between(fullDateStart, fullDateEnd);
        System.out.println(between);


    }

    public static void localTime() {
        LocalTime localTime = LocalTime.now();
        localTime = localTime.plusHours(3);
        System.out.println("Now plus 3 hours: " + localTime);
        System.out.println(localTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH - mm - ss");
        int hour = LocalTime.parse("21 - 00 - 00", formatter).minusMinutes(200).getHour();

        System.out.println(hour);
    }

    public static void localDate() {
        System.out.println(LocalDate.now());

        System.out.println(LocalDate.of(2006, 5, 1));

        System.out.println(LocalDate.of(2006, 5, 1));

        String standardDate = "2018-12-31";
        System.out.println(LocalDate.parse(standardDate).getDayOfWeek());
        //MONDAY


        String nonStandardDate = "2018/12/30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(LocalDate.parse(nonStandardDate, formatter).getDayOfWeek());
        //SUNDAY

        System.out.println("LocalDate calculations");
        LocalDate localDate = LocalDate.now();
        ;
        System.out.println(localDate.plusWeeks(1));

        System.out.printf("Day of week in 10 years: %s\n", localDate.plusYears(10).getDayOfWeek());

        LocalDate randomDate = localDate.minusDays(1).plusMonths(1).minusYears(2).plusWeeks(3);
        System.out.println(randomDate);

        System.out.println(" ---------------------- ");
        System.out.println("Comparison");

        LocalDate now = LocalDate.now();
        LocalDate twoDaysAhead = LocalDate.now().plusDays(2);

        ;
        System.out.println(now.isAfter(twoDaysAhead));
        System.out.println();
        System.out.println("Is 2018 a leap year? ");
        System.out.println(LocalDate.now().isLeapYear());

        System.out.println("Leap years 1990 - 2020");

        LocalDate startDate = LocalDate.of(1990, 1, 1);

        LocalDate endDate = LocalDate.of(2021, 1, 1);
        while (startDate.isBefore(endDate)) {
            if (startDate.isLeapYear()) {
                System.out.println(startDate.getYear());
            }
            startDate = startDate.plusYears(1);
        }

        System.out.println();
        System.out.println(" ------ Immutability -------");
        startDate = LocalDate.now();

        System.out.println(startDate);

        //startDate.plusWeeks(1); the same as string.toUpperCase()
    }
}
