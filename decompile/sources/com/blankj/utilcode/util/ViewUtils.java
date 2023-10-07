package com.blankj.utilcode.util;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewUtils {
    public static void fixScrollViewTopping(View view) {
        view.setFocusable(false);
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                childAt.setFocusable(false);
                if (childAt instanceof ViewGroup) {
                    fixScrollViewTopping(childAt);
                }
            }
        }
    }

    public static boolean isLayoutRtl() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        return TextUtils.getLayoutDirectionFromLocale(Build.VERSION.SDK_INT >= 24 ? Utils.getApp().getResources().getConfiguration().getLocales().get(0) : Utils.getApp().getResources().getConfiguration().locale) == 1;
    }

    public static View layoutId2View(int i2) {
        return ((LayoutInflater) Utils.getApp().getSystemService("layout_inflater")).inflate(i2, (ViewGroup) null);
    }

    public static void runOnUiThread(Runnable runnable) {
        UtilsBridge.runOnUiThread(runnable);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j2) {
        UtilsBridge.runOnUiThreadDelayed(runnable, j2);
    }

    public static void setViewEnabled(View view, boolean z2) {
        setViewEnabled(view, z2, null);
    }

    public static void setViewEnabled(View view, boolean z2, View... viewArr) {
        if (view != null) {
            if (viewArr != null) {
                int length = viewArr.length;
                int i2 = 0;
                while (i2 < length) {
                    if (view != viewArr[i2]) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    setViewEnabled(viewGroup.getChildAt(i3), z2, viewArr);
                }
            }
            view.setEnabled(z2);
        }
    }
}
