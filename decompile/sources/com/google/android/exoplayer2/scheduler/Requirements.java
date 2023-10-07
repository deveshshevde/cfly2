package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;

public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new Parcelable.Creator<Requirements>() {
        /* renamed from: a */
        public Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        /* renamed from: a */
        public Requirements[] newArray(int i2) {
            return new Requirements[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f16004a;

    public Requirements(int i2) {
        this.f16004a = (i2 & 2) != 0 ? i2 | 1 : i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r3 = r3.getNetworkCapabilities(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.net.ConnectivityManager r3) {
        /*
            int r0 = com.google.android.exoplayer2.util.ad.f11755a
            r1 = 1
            r2 = 24
            if (r0 >= r2) goto L_0x0008
            return r1
        L_0x0008:
            android.net.Network r0 = r3.getActiveNetwork()
            r2 = 0
            if (r0 != 0) goto L_0x0010
            return r2
        L_0x0010:
            android.net.NetworkCapabilities r3 = r3.getNetworkCapabilities(r0)
            if (r3 == 0) goto L_0x001f
            r0 = 16
            boolean r3 = r3.hasCapability(r0)
            if (r3 == 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.scheduler.Requirements.a(android.net.ConnectivityManager):boolean");
    }

    private int c(Context context) {
        if (!a()) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) a.b(context.getSystemService("connectivity"));
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || !a(connectivityManager)) ? this.f16004a & 3 : (!b() || !connectivityManager.isActiveNetworkMetered()) ? 0 : 2;
    }

    private boolean d(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean e(Context context) {
        PowerManager powerManager = (PowerManager) a.b(context.getSystemService("power"));
        if (ad.f11755a >= 23) {
            return powerManager.isDeviceIdleMode();
        }
        if (ad.f11755a >= 20) {
            if (!powerManager.isInteractive()) {
                return true;
            }
        } else if (!powerManager.isScreenOn()) {
            return true;
        }
        return false;
    }

    public boolean a() {
        return (this.f16004a & 1) != 0;
    }

    public boolean a(Context context) {
        return b(context) == 0;
    }

    public int b(Context context) {
        int c2 = c(context);
        if (c() && !d(context)) {
            c2 |= 8;
        }
        return (!d() || e(context)) ? c2 : c2 | 4;
    }

    public boolean b() {
        return (this.f16004a & 2) != 0;
    }

    public boolean c() {
        return (this.f16004a & 8) != 0;
    }

    public boolean d() {
        return (this.f16004a & 4) != 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f16004a == ((Requirements) obj).f16004a;
    }

    public int hashCode() {
        return this.f16004a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f16004a);
    }
}
