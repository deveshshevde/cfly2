package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() {
        /* renamed from: a */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        /* renamed from: a */
        public TimeModel[] newArray(int i2) {
            return new TimeModel[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f19927a;

    /* renamed from: b  reason: collision with root package name */
    int f19928b;

    /* renamed from: c  reason: collision with root package name */
    int f19929c;

    /* renamed from: d  reason: collision with root package name */
    int f19930d;

    /* renamed from: e  reason: collision with root package name */
    int f19931e;

    /* renamed from: f  reason: collision with root package name */
    private final c f19932f;

    /* renamed from: g  reason: collision with root package name */
    private final c f19933g;

    public TimeModel() {
        this(0);
    }

    public TimeModel(int i2) {
        this(0, 0, 10, i2);
    }

    public TimeModel(int i2, int i3, int i4, int i5) {
        this.f19928b = i2;
        this.f19929c = i3;
        this.f19930d = i4;
        this.f19927a = i5;
        this.f19931e = d(i2);
        this.f19932f = new c(59);
        this.f19933g = new c(i5 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return a(resources, charSequence, "%02d");
    }

    public static String a(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
    }

    private static int d(int i2) {
        return i2 >= 12 ? 1 : 0;
    }

    public int a() {
        if (this.f19927a == 1) {
            return this.f19928b % 24;
        }
        int i2 = this.f19928b;
        if (i2 % 12 == 0) {
            return 12;
        }
        return this.f19931e == 1 ? i2 - 12 : i2;
    }

    public void a(int i2) {
        if (this.f19927a == 1) {
            this.f19928b = i2;
            return;
        }
        int i3 = 12;
        int i4 = i2 % 12;
        if (this.f19931e != 1) {
            i3 = 0;
        }
        this.f19928b = i4 + i3;
    }

    public c b() {
        return this.f19932f;
    }

    public void b(int i2) {
        this.f19929c = i2 % 60;
    }

    public c c() {
        return this.f19933g;
    }

    public void c(int i2) {
        int i3;
        if (i2 != this.f19931e) {
            this.f19931e = i2;
            int i4 = this.f19928b;
            if (i4 < 12 && i2 == 1) {
                i3 = i4 + 12;
            } else if (i4 >= 12 && i2 == 0) {
                i3 = i4 - 12;
            } else {
                return;
            }
            this.f19928b = i3;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f19928b == timeModel.f19928b && this.f19929c == timeModel.f19929c && this.f19927a == timeModel.f19927a && this.f19930d == timeModel.f19930d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f19927a), Integer.valueOf(this.f19928b), Integer.valueOf(this.f19929c), Integer.valueOf(this.f19930d)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f19928b);
        parcel.writeInt(this.f19929c);
        parcel.writeInt(this.f19930d);
        parcel.writeInt(this.f19927a);
    }
}
