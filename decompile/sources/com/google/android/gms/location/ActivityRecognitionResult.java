package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new af();

    /* renamed from: a  reason: collision with root package name */
    private List<DetectedActivity> f18033a;

    /* renamed from: b  reason: collision with root package name */
    private long f18034b;

    /* renamed from: c  reason: collision with root package name */
    private long f18035c;

    /* renamed from: d  reason: collision with root package name */
    private int f18036d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f18037e;

    public ActivityRecognitionResult(List<DetectedActivity> list, long j2, long j3, int i2, Bundle bundle) {
        boolean z2 = true;
        m.a(list != null && list.size() > 0, (Object) "Must have at least 1 detected activity");
        m.a((j2 <= 0 || j3 <= 0) ? false : z2, (Object) "Must set times");
        this.f18033a = list;
        this.f18034b = j2;
        this.f18035c = j3;
        this.f18036d = i2;
        this.f18037e = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0023 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.os.Bundle r9, android.os.Bundle r10) {
        /*
            r0 = 1
            if (r9 != 0) goto L_0x0006
            if (r10 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            if (r9 != 0) goto L_0x000b
            if (r10 != 0) goto L_0x000f
        L_0x000b:
            if (r9 == 0) goto L_0x0010
            if (r10 != 0) goto L_0x0010
        L_0x000f:
            return r1
        L_0x0010:
            int r2 = r9.size()
            int r3 = r10.size()
            if (r2 == r3) goto L_0x001b
            return r1
        L_0x001b:
            java.util.Set r2 = r9.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0023:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00b9
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = r10.containsKey(r3)
            if (r4 != 0) goto L_0x0036
            return r1
        L_0x0036:
            java.lang.Object r4 = r9.get(r3)
            if (r4 != 0) goto L_0x0043
            java.lang.Object r3 = r10.get(r3)
            if (r3 == 0) goto L_0x0023
            return r1
        L_0x0043:
            java.lang.Object r4 = r9.get(r3)
            boolean r4 = r4 instanceof android.os.Bundle
            if (r4 == 0) goto L_0x005a
            android.os.Bundle r4 = r9.getBundle(r3)
            android.os.Bundle r3 = r10.getBundle(r3)
            boolean r3 = a(r4, r3)
            if (r3 != 0) goto L_0x0023
            return r1
        L_0x005a:
            java.lang.Object r4 = r9.get(r3)
            java.lang.Class r4 = r4.getClass()
            boolean r4 = r4.isArray()
            if (r4 == 0) goto L_0x00aa
            java.lang.Object r4 = r10.get(r3)
            if (r4 == 0) goto L_0x00a9
            java.lang.Object r4 = r10.get(r3)
            java.lang.Class r4 = r4.getClass()
            boolean r4 = r4.isArray()
            if (r4 != 0) goto L_0x007d
            goto L_0x00a9
        L_0x007d:
            java.lang.Object r4 = r9.get(r3)
            java.lang.Object r3 = r10.get(r3)
            int r5 = java.lang.reflect.Array.getLength(r4)
            int r6 = java.lang.reflect.Array.getLength(r3)
            if (r5 == r6) goto L_0x0091
        L_0x008f:
            r3 = 0
            goto L_0x00a7
        L_0x0091:
            r6 = 0
        L_0x0092:
            if (r6 >= r5) goto L_0x00a6
            java.lang.Object r7 = java.lang.reflect.Array.get(r4, r6)
            java.lang.Object r8 = java.lang.reflect.Array.get(r3, r6)
            boolean r7 = com.google.android.gms.common.internal.l.a(r7, r8)
            if (r7 != 0) goto L_0x00a3
            goto L_0x008f
        L_0x00a3:
            int r6 = r6 + 1
            goto L_0x0092
        L_0x00a6:
            r3 = 1
        L_0x00a7:
            if (r3 != 0) goto L_0x0023
        L_0x00a9:
            return r1
        L_0x00aa:
            java.lang.Object r4 = r9.get(r3)
            java.lang.Object r3 = r10.get(r3)
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0023
            return r1
        L_0x00b9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.ActivityRecognitionResult.a(android.os.Bundle, android.os.Bundle):boolean");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            return this.f18034b == activityRecognitionResult.f18034b && this.f18035c == activityRecognitionResult.f18035c && this.f18036d == activityRecognitionResult.f18036d && l.a(this.f18033a, activityRecognitionResult.f18033a) && a(this.f18037e, activityRecognitionResult.f18037e);
        }
    }

    public int hashCode() {
        return l.a(Long.valueOf(this.f18034b), Long.valueOf(this.f18035c), Integer.valueOf(this.f18036d), this.f18033a, this.f18037e);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f18033a);
        long j2 = this.f18034b;
        long j3 = this.f18035c;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 124);
        sb.append("ActivityRecognitionResult [probableActivities=");
        sb.append(valueOf);
        sb.append(", timeMillis=");
        sb.append(j2);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j3);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.c(parcel, 1, this.f18033a, false);
        a.a(parcel, 2, this.f18034b);
        a.a(parcel, 3, this.f18035c);
        a.a(parcel, 4, this.f18036d);
        a.a(parcel, 5, this.f18037e, false);
        a.a(parcel, a2);
    }
}
