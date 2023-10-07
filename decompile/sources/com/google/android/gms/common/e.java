package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.aa;

public final class e extends f {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f17694a = f.f17696b;

    @Deprecated
    public static int a(Context context) {
        return f.d(context);
    }

    @Deprecated
    public static int a(Context context, int i2) {
        return f.b(context, i2);
    }

    @Deprecated
    public static boolean a(int i2, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return a(i2, activity, (Fragment) null, i3, onCancelListener);
    }

    public static boolean a(int i2, Activity activity, Fragment fragment, int i3, DialogInterface.OnCancelListener onCancelListener) {
        if (true == f.c(activity, i2)) {
            i2 = 18;
        }
        c a2 = c.a();
        if (fragment == null) {
            return a2.b(activity, i2, i3, onCancelListener);
        }
        Dialog a3 = a2.a((Context) activity, i2, aa.a(fragment, c.a().a((Context) activity, i2, "d"), i3), onCancelListener);
        if (a3 == null) {
            return false;
        }
        a2.a(activity, a3, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public static Context b(Context context) {
        return f.e(context);
    }

    public static Resources c(Context context) {
        return f.f(context);
    }
}
