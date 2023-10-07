package com.recyclerview.swipe;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Method;

public class d {
    public static Drawable a(Context context, int i2) {
        return a(context, i2, (Resources.Theme) null);
    }

    public static Drawable a(Context context, int i2, Resources.Theme theme) {
        Resources resources = context.getResources();
        Class<?> cls = resources.getClass();
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Method method = cls.getMethod("getDrawable", new Class[]{Integer.TYPE, Resources.Theme.class});
                method.setAccessible(true);
                return (Drawable) method.invoke(resources, new Object[]{Integer.valueOf(i2), theme});
            } catch (Throwable unused) {
                return null;
            }
        } else {
            Method method2 = cls.getMethod("getDrawable", new Class[]{Integer.TYPE});
            method2.setAccessible(true);
            return (Drawable) method2.invoke(resources, new Object[]{Integer.valueOf(i2)});
        }
    }

    public static void a(View view, Drawable drawable) {
        a(Build.VERSION.SDK_INT >= 16 ? "setBackground" : "setBackgroundDrawable", view, drawable);
    }

    public static void a(TextView textView, int i2) {
        Class<?> cls = textView.getClass();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Method method = cls.getMethod("setTextAppearance", new Class[]{Context.class, Integer.TYPE});
                method.setAccessible(true);
                method.invoke(textView, new Object[]{textView.getContext(), Integer.valueOf(i2)});
            } catch (Throwable unused) {
            }
        } else {
            Method method2 = cls.getMethod("setTextAppearance", new Class[]{Integer.TYPE});
            method2.setAccessible(true);
            method2.invoke(textView, new Object[]{Integer.valueOf(i2)});
        }
    }

    public static void a(String str, View view, Drawable drawable) {
        try {
            Method method = view.getClass().getMethod(str, new Class[]{Drawable.class});
            method.setAccessible(true);
            method.invoke(view, new Object[]{drawable});
        } catch (Throwable unused) {
        }
    }
}
