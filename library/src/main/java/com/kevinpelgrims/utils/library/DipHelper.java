package com.kevinpelgrims.utils.library;

import android.content.Context;

public class DipHelper {
    public static int convertToDip(Context context, int size) {
        final Float scale = context.getResources().getDisplayMetrics().density;
        return (int) (size * scale + 0.5f);
    }
}