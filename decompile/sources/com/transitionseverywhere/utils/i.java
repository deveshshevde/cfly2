package com.transitionseverywhere.utils;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21964a = "i";

    /* renamed from: b  reason: collision with root package name */
    private static final Object[] f21965b = new Object[0];

    /* renamed from: c  reason: collision with root package name */
    private static final Object[] f21966c = new Object[1];

    /* renamed from: d  reason: collision with root package name */
    private static final Object[] f21967d = new Object[2];

    /* renamed from: e  reason: collision with root package name */
    private static final Object[] f21968e = new Object[3];

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f21969f = new Object[4];

    private i() {
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Object a(Object obj, Object obj2, Field field) {
        if (field == null) {
            return obj2;
        }
        try {
            return field.get(obj);
        } catch (Exception e2) {
            Log.e(f21964a, "Exception in getFieldValue", e2);
            return obj2;
        }
    }

    public static Object a(Object obj, Object obj2, Method method) {
        return a(obj, obj2, method, f21965b);
    }

    public static Object a(Object obj, Object obj2, Method method, Object obj3) {
        Object[] objArr = f21966c;
        objArr[0] = obj3;
        Object a2 = a(obj, obj2, method, objArr);
        objArr[0] = null;
        return a2;
    }

    public static Object a(Object obj, Object obj2, Method method, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = f21968e;
        objArr[0] = obj3;
        objArr[1] = obj4;
        objArr[2] = obj5;
        Object a2 = a(obj, obj2, method, objArr);
        objArr[0] = null;
        objArr[1] = null;
        objArr[2] = null;
        return a2;
    }

    public static Object a(Object obj, Object obj2, Method method, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = f21969f;
        objArr[0] = obj3;
        objArr[1] = obj4;
        objArr[2] = obj5;
        objArr[3] = obj6;
        Object a2 = a(obj, obj2, method, objArr);
        objArr[0] = null;
        objArr[1] = null;
        objArr[2] = null;
        objArr[3] = null;
        return a2;
    }

    public static Object a(Object obj, Object obj2, Method method, Object... objArr) {
        if (method == null) {
            return obj2;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e2) {
            Log.e(f21964a, "Exception in invoke", e2);
            return obj2;
        }
    }

    public static Field a(Class<?> cls, String str) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (SecurityException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException | SecurityException unused) {
            }
        }
        return null;
    }

    public static void a(Object obj, Field field, Object obj2) {
        if (field != null) {
            try {
                field.set(obj, obj2);
            } catch (Exception e2) {
                Log.e(f21964a, "Exception in setFieldValue", e2);
            }
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException unused) {
            }
        }
        return null;
    }
}
