package za.ac.cput.util;

/* CustomerOrderHelper.java
Helper Class for the CustomerOrderFactory
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import java.time.*;
import java.time.format.*;
import java.util.*;

public class CustomerOrderHelper {
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isInvalidDouble(Double d) {
        if (d == null || d.isNaN()) {
            return true;
        } else if (d < 0) {
            return true;
        }
        return false;
    }

    public static LocalDate isValidDate(String dateStr){
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd-MM-yyyy")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);

            if(dateStr == "" || dateStr == null){
                return null;
            }

            int dayOfMonth = date.getDayOfMonth();
            if(dayOfMonth < 1 || dayOfMonth > date.getMonth().maxLength()) {
                return null;
            }

            if (date.getDayOfMonth() == 29 && date.getMonth() == Month.FEBRUARY && !date.isLeapYear()) {
                return null;
            }

            return date;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
