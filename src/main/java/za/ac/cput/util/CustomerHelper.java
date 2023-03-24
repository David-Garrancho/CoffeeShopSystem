package za.ac.cput.util;

/* CustomerHelper.java
Helper Class for the CustomerFactory
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;
import java.util.regex.*;

public class CustomerHelper {

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

    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
