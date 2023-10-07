package com.xeagle.android.utils;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;

public class r {
    public static Object a(Object obj, String str, Object[] objArr) {
        Class[] clsArr;
        if (obj != null && !TextUtils.isEmpty(str)) {
            Class<?> cls = obj.getClass();
            if (objArr != null) {
                try {
                    clsArr = new Class[objArr.length];
                    for (int i2 = 0; i2 < objArr.length; i2++) {
                        clsArr[i2] = objArr[i2].getClass();
                    }
                } catch (NoSuchMethodException unused) {
                    Log.i("reflect", "method " + str + " not found in " + obj.getClass().getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                clsArr = null;
            }
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        }
        return null;
    }
}
