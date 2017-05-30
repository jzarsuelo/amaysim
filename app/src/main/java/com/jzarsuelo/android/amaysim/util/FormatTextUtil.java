package com.jzarsuelo.android.amaysim.util;

/**
 * Created by Pao on 30/5/17.
 */

public class FormatTextUtil {

    private FormatTextUtil() {}

    /**
     * Converts data value from MB to GB
     */
    public static String convertToGb(long mbSize) {
        return String.format("%.2f GB", (float) mbSize/1024);
    }

    /**
     * Converts cents to dollars
     */
    public static String covertToDollar(long cents) {
        return  String.format("$%.2f", (float) cents/100);
    }
    
}
