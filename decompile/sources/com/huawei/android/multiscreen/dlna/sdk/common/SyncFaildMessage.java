package com.huawei.android.multiscreen.dlna.sdk.common;

import android.os.Parcel;
import android.os.Parcelable;
import ie.a;

public class SyncFaildMessage implements Parcelable {
    public static final Parcelable.Creator<SyncFaildMessage> CREATOR = new Parcelable.Creator<SyncFaildMessage>() {
        /* renamed from: a */
        public SyncFaildMessage createFromParcel(Parcel parcel) {
            SyncFaildMessage syncFaildMessage = new SyncFaildMessage();
            syncFaildMessage.a(parcel.readString());
            try {
                syncFaildMessage.a((Object) parcel.readParcelable(Class.forName(parcel.readString()).getClassLoader()));
            } catch (ClassNotFoundException unused) {
                a.d("SyncFaildMessage", "SyncFaildMessage.createFromParcel() has ClassNotFoundException");
            }
            return syncFaildMessage;
        }

        /* renamed from: a */
        public SyncFaildMessage[] newArray(int i2) {
            return new SyncFaildMessage[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f20726a;

    /* renamed from: b  reason: collision with root package name */
    private Object f20727b;

    public void a(Object obj) {
        this.f20727b = obj;
    }

    public void a(String str) {
        this.f20726a = str;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SyncFaildMessage [message=" + this.f20726a + ", lastValue=" + this.f20727b + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f20726a);
        parcel.writeString(this.f20727b.getClass().getName());
        parcel.writeParcelable((Parcelable) this.f20727b, i2);
    }
}
