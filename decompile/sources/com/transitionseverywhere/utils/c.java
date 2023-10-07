package com.transitionseverywhere.utils;

import android.os.Build;
import android.util.Property;
import android.util.a;

public abstract class c<T> extends Property<T, Integer> {
    public c() {
        super(Integer.class, (String) null);
    }

    public Property<T, Integer> a() {
        return Build.VERSION.SDK_INT > 18 ? new a<T>((String) null) {
            /* renamed from: a */
            public Integer get(T t2) {
                return c.this.get(t2);
            }

            public void a(T t2, int i2) {
                c.this.a(t2, i2);
            }
        } : this;
    }

    /* renamed from: a */
    public Integer get(T t2) {
        return 0;
    }

    public abstract void a(T t2, int i2);

    /* renamed from: a */
    public final void set(T t2, Integer num) {
        a(t2, num.intValue());
    }
}
