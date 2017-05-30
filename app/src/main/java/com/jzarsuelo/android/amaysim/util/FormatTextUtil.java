package com.jzarsuelo.android.amaysim.util;

/**
 * Utility class for formatting text
 */

public class FormatTextUtil {

    private FormatTextUtil() {}

    /**
     * Converts data value from MB to GB
     */
    public static String convertToGb(long mbSize) {
        return mbSize > 0
                    ? String.format("%.2f GB", (float) mbSize/1024)
                        : "0 GB";
    }

    /**
     * Converts cents to dollars
     */
    public static String covertToDollar(long cents) {
        return  String.format("$%.2f", (float) cents/100);
    }

    /**
     * Get the user friendly equivalent of boolean
     */
    public static String getUserFriendlyBoolean(boolean value) {
        return (value) ? "Yes" : "No";
    }

}
