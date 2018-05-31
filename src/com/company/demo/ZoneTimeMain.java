package com.company.demo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneTimeMain {

    public static void main(String[] args) {
        //Zones
        //ZoneId - contains the Set of all zones
        //ZoneDateTime -> LocalDateTime

        LocalDateTime currentTime = LocalDateTime.now();
        ZonedDateTime myZoneTime = ZonedDateTime.of(currentTime, ZoneId.systemDefault());
        ;

        System.out.println(myZoneTime);


        //NEW API                         OLD API
        //LocalDateTime   -> Instant  ->   Date
        //LocalDateTime   <- Instant  <-   Date

        ZonedDateTime losAngelesZoneTime = myZoneTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        System.out.println(losAngelesZoneTime);

        ZonedDateTime newYorkTime = losAngelesZoneTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.printf("%tT", newYorkTime);
    }
}
