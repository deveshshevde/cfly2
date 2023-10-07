package org.jcodec.containers.mp4;

import java.util.Calendar;
import java.util.TimeZone;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final long f33556a;

    static {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        instance.set(1904, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        f33556a = instance.getTimeInMillis();
    }

    public static int a(long j2) {
        return (int) ((j2 - f33556a) / 1000);
    }
}
