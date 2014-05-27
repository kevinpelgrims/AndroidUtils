package com.kevinpelgrims.utils.library;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;

public class DialogHelper {
    public static void showAlert(final Context context, final int titleResource, final int messageResource) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle(titleResource)
                        .setMessage(messageResource)
                        .setPositiveButton(android.R.string.ok, null);
                alertDialog.show();
            }
        });
    }

    public static void showActionAlert(final Context context, final int messageResource, final int positiveTextResource, final DialogInterface.OnClickListener positiveClickListener, final int negativeTextResource, final DialogInterface.OnClickListener negativeClickListener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setMessage(messageResource)
                        .setCancelable(true)
                        .setPositiveButton(positiveTextResource, positiveClickListener)
                        .setNegativeButton(negativeTextResource, negativeClickListener);
                alertDialog.show();
            }
        });
    }

    public static ProgressDialog showProgressDialog(Context context, int titleResource) {
        return ProgressDialog.show(context, "", context.getText(titleResource), true);
    }

    public static void killDialog(AlertDialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}