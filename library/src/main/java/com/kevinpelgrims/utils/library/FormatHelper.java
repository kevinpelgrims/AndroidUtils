package com.kevinpelgrims.utils.library;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormatHelper {
    public static String formatDecimal(String format, double value) {
        NumberFormat formatter = new DecimalFormat(format);
        return formatter.format(value);
    }

    public static String formatDecimalNoDecimals(double value) {
        return formatDecimal("#0", value);
    }

    public static String formatCurrencyNoDecimals(double value, String currency) {
        return String.format("%s %s", currency, formatDecimalNoDecimals(value));
    }
}