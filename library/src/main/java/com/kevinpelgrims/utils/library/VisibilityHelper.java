package com.kevinpelgrims.utils.library;

import android.view.View;

public class VisibilityHelper {
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }

    public static int convertBooleanToVisibilityKeepSpace(boolean visible) {
        return visible ? View.VISIBLE : View.INVISIBLE;
    }
}