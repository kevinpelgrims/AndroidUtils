package com.kevinpelgrims.utils.library;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PlatformHelper {
    public static String getAppVersion(Context context) {
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            return packageInfo.versionName;
        }
        catch (Exception x) {
            return "0";
        }
    }

    public static List<String> getUserEmailAddresses(Context context) {
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        Account[] accounts = AccountManager.get(context).getAccounts();
        ArrayList<String> emailAddresses = new ArrayList<String>();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches() && !emailAddresses.contains(account.name)) {
                emailAddresses.add(account.name);
            }
        }
        return emailAddresses;
    }

    public static boolean isPackageAvailable(Context context, String packageName) {
        final PackageManager pm = context.getPackageManager();
        try {
            pm.getApplicationInfo(packageName, 0);
            return true;
        }
        catch (Exception x) {
            return false;
        }
    }

    public static void shareIntentWithPackage(Context context, Intent intent, String partialPackageName) {
        final PackageManager pm = context.getPackageManager();
        final List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
        ResolveInfo match = null;

        try {
            for (final ResolveInfo info : matches) {
                if (info.activityInfo.name.toLowerCase().contains(partialPackageName)) match = info;
            }
            if (match != null) {
                intent.setClassName(match.activityInfo.packageName, match.activityInfo.name);
            }
        }
        catch (Exception x) { /* Ignore, we'll send the share intent anyway and see what happens */ }

        context.startActivity(intent);
    }

    public static boolean isGingerbreadOrHigher() {
        return android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    public static boolean isHoneycombOrHigher() {
        return android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean isJellyBeanOrHigher() {
        return android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean isScreenSmall(Configuration configuration) {
        return (configuration.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL;
    }
}