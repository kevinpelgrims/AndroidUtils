package com.kevinpelgrims.utils.library;

import android.text.format.DateUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public static String formatDate(Date date, String format) {
        if (date == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static CharSequence formatDateToRelativeTimeSpan(Date date) {
        if (date == null) return "";
        return DateUtils.getRelativeTimeSpanString(date.getTime(), Calendar.getInstance().getTimeInMillis(), DateUtils.MINUTE_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE);
    }
}