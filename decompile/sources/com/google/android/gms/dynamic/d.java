package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.dynamic.b;
import java.lang.reflect.Field;

public final class d<T> extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private final T f17992a;

    private d(T t2) {
        this.f17992a = t2;
    }

    public static <T> b a(T t2) {
        return new d(t2);
    }

    public static <T> T a(b bVar) {
        if (bVar instanceof d) {
            return ((d) bVar).f17992a;
        }
        IBinder asBinder = bVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i2 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
        }
        if (i2 == 1) {
            m.a(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e2) {
                    throw new IllegalArgumentException("Binder object is null.", e2);
                } catch (IllegalAccessException e3) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
