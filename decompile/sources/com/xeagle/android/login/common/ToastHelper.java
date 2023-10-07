package com.xeagle.android.login.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;

public class ToastHelper {
    private static Toast sToast;
    /* access modifiers changed from: private */
    public static Toast viewToast;

    private ToastHelper() {
    }

    private static void ensureToast(Context context) {
        if (sToast == null) {
            synchronized (ToastHelper.class) {
                if (sToast == null) {
                    sToast = Toast.makeText(context.getApplicationContext(), " ", 0);
                }
            }
        }
    }

    public static void showCenterToastShort(Context context, int i2) {
        showToastWithCenter(context.getApplicationContext(), i2, 0);
    }

    public static void showToast(Context context, int i2) {
        showToastInner(context.getApplicationContext(), context.getApplicationContext().getString(i2), 0);
    }

    public static void showToast(Context context, String str) {
        showToastInner(context.getApplicationContext(), str, 0);
    }

    private static void showToastInner(Context context, String str, int i2) {
        ensureToast(context.getApplicationContext());
        sToast.setText(str);
        sToast.setDuration(i2);
        sToast.show();
    }

    public static void showToastInnerWithTopCenter(Context context, String str, int i2) {
        if (viewToast == null) {
            viewToast = new Toast(context.getApplicationContext());
        }
        viewToast.setGravity(49, 20, 460);
        View inflate = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.toast_view_layout, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_warn);
        ((TextView) inflate.findViewById(R.id.toast_text)).setText(str);
        ((IImageButton) inflate.findViewById(R.id.toast_close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToastHelper.viewToast.cancel();
            }
        });
        viewToast.setDuration(i2);
        viewToast.setView(inflate);
        viewToast.show();
    }

    public static void showToastInnerWithTopLeft(Context context, String str, int i2) {
        if (viewToast == null) {
            viewToast = new Toast(context.getApplicationContext());
        }
        viewToast.setGravity(51, 20, 460);
        View inflate = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.toast_view_layout, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_warn);
        ((TextView) inflate.findViewById(R.id.toast_text)).setText(str);
        ((IImageButton) inflate.findViewById(R.id.toast_close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToastHelper.viewToast.cancel();
            }
        });
        viewToast.setDuration(i2);
        viewToast.setView(inflate);
        viewToast.show();
    }

    public static void showToastLong(Context context, int i2) {
        showToastInner(context.getApplicationContext(), context.getApplicationContext().getString(i2), 1);
    }

    public static void showToastLong(Context context, String str) {
        showToastInner(context.getApplicationContext(), str, 1);
    }

    public static void showToastWithCenter(Context context, int i2, int i3) {
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(17, 0, 0);
        View inflate = LayoutInflater.from(context.getApplicationContext()).inflate(i2, (ViewGroup) null);
        toast.setDuration(i3);
        toast.setView(inflate);
        toast.show();
    }
}
