package com.xeagle.android.login.common;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;

public class DialogMaker {
    private static WeakReference<EasyProgressDialog> sProgressDialogRef;

    public static void dismissProgressDialog() {
        EasyProgressDialog dialog = getDialog();
        if (dialog != null) {
            sProgressDialogRef.clear();
            if (dialog.isShowing()) {
                try {
                    dialog.dismiss();
                } catch (Exception unused) {
                }
            }
        }
    }

    private static EasyProgressDialog getDialog() {
        WeakReference<EasyProgressDialog> weakReference = sProgressDialogRef;
        if (weakReference == null) {
            return null;
        }
        return (EasyProgressDialog) weakReference.get();
    }

    public static boolean isShowing() {
        EasyProgressDialog dialog = getDialog();
        return dialog != null && dialog.isShowing();
    }

    public static void setMessage(String str) {
        EasyProgressDialog dialog = getDialog();
        if (dialog != null && dialog.isShowing() && !TextUtils.isEmpty(str)) {
            dialog.setMessage(str);
        }
    }

    public static EasyProgressDialog showProgressDialog(Context context, String str) {
        return showProgressDialog(context, (String) null, str, true, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static EasyProgressDialog showProgressDialog(Context context, String str, String str2, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        EasyProgressDialog dialog = getDialog();
        if (!(dialog == null || dialog.getContext() == context)) {
            dismissProgressDialog();
            Log.e("dialog", "there is a leaked window here,orign context: " + dialog.getContext() + " now: " + context);
            dialog = null;
        }
        if (dialog == null) {
            dialog = new EasyProgressDialog(context, str2);
            sProgressDialogRef = new WeakReference<>(dialog);
        }
        if (!TextUtils.isEmpty(str)) {
            dialog.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            dialog.setMessage(str2);
        }
        dialog.setCancelable(z2);
        dialog.setOnCancelListener(onCancelListener);
        dialog.show();
        return dialog;
    }

    public static EasyProgressDialog showProgressDialog(Context context, String str, boolean z2) {
        return showProgressDialog(context, (String) null, str, z2, (DialogInterface.OnCancelListener) null);
    }

    public static void updateLoadingMessage(String str) {
        EasyProgressDialog dialog = getDialog();
        if (dialog != null && dialog.isShowing() && !TextUtils.isEmpty(str)) {
            dialog.updateLoadingMessage(str);
        }
    }
}
