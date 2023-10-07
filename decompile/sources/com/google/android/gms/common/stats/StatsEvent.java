package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int a();

    public abstract long b();

    public abstract long c();

    public abstract String d();

    public final String toString() {
        long c2 = c();
        int a2 = a();
        long b2 = b();
        String d2 = d();
        StringBuilder sb = new StringBuilder(d2.length() + 53);
        sb.append(c2);
        sb.append("\t");
        sb.append(a2);
        sb.append("\t");
        sb.append(b2);
        sb.append(d2);
        return sb.toString();
    }
}
