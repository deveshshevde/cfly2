package com.xeagle.android.widgets.menu;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuObject implements Parcelable {
    public static final Parcelable.Creator<MenuObject> CREATOR = new Parcelable.Creator<MenuObject>() {
        /* renamed from: a */
        public MenuObject createFromParcel(Parcel parcel) {
            return new MenuObject(parcel);
        }

        /* renamed from: a */
        public MenuObject[] newArray(int i2) {
            return new MenuObject[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f25929a;

    /* renamed from: b  reason: collision with root package name */
    private int f25930b;

    private MenuObject(Parcel parcel) {
        this.f25929a = parcel.readString();
        this.f25930b = parcel.readInt();
    }

    public String a() {
        return this.f25929a;
    }

    public int b() {
        return this.f25930b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25929a);
        parcel.writeInt(this.f25930b);
    }
}
