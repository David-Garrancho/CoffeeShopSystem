package za.ac.cput.util;

/* CustomerHelper.java
Helper Class for the CustomerFactory
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.UUID;
import java.util.regex.*;

public class Helper {

    public static boolean isNullOrEmpty(String str){
        if (str == null || str.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }

    public static boolean isValidPhoneNumber(String phoneNumber){
        Pattern phoneNumberPattern = Pattern.compile("^\\d{10}$");
        Matcher findAMatch = phoneNumberPattern.matcher(phoneNumber);
        return (findAMatch.matches());
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
        if (dateStr == null) {
            return null;
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd-MM-uuuu")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
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
