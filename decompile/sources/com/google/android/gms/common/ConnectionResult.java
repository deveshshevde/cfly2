package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public static final ConnectionResult f17353a = new ConnectionResult(0);

    /* renamed from: b  reason: collision with root package name */
    final int f17354b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17355c;

    /* renamed from: d  reason: collision with root package name */
    private final PendingIntent f17356d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17357e;

    public ConnectionResult(int i2) {
        this(i2, (PendingIntent) null, (String) null);
    }

    ConnectionResult(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f17354b = i2;
        this.f17355c = i3;
        this.f17356d = pendingIntent;
        this.f17357e = str;
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, (String) null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }

    static String a(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i2);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public int a() {
        return this.f17355c;
    }

    public void a(Activity activity, int i2) throws IntentSender.SendIntentException {
        if (d()) {
            PendingIntent pendingIntent = this.f17356d;
            m.a(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, (Intent) null, 0, 0, 0);
        }
    }

    public PendingIntent b() {
        return this.f17356d;
    }

    public String c() {
        return this.f17357e;
    }

    public boolean d() {
        return (this.f17355c == 0 || this.f17356d == null) ? false : true;
    }

    public boolean e() {
        return this.f17355c == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f17355c == connectionResult.f17355c && l.a(this.f17356d, connectionResult.f17356d) && l.a(this.f17357e, connectionResult.f17357e);
    }

    public int hashCode() {
        return l.a(Integer.valueOf(this.f17355c), this.f17356d, this.f17357e);
    }

    public String toString() {
        l.a a2 = l.a((Object) this);
        a2.a("statusCode", a(this.f17355c));
        a2.a("resolution", this.f17356d);
        a2.a("message", this.f17357e);
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17354b);
        a.a(parcel, 2, a());
        a.a(parcel, 3, (Parcelable) b(), i2, false);
        a.a(parcel, 4, c(), false);
        a.a(parcel, a2);
    }
}
