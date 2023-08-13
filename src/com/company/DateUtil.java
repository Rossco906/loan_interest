package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static LocalDate stringToLocalDate(String dateString){
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
    }
}
