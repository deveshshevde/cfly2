package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() {
        /* renamed from: a */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        /* renamed from: a */
        public EventMessage[] newArray(int i2) {
            return new EventMessage[i2];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static final Format f15855f = Format.a((String) null, "application/id3", Long.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    private static final Format f15856g = Format.a((String) null, "application/x-scte35", Long.MAX_VALUE);

    /* renamed from: a  reason: collision with root package name */
    public final String f15857a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15858b;

    /* renamed from: c  reason: collision with root package name */
    public final long f15859c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15860d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f15861e;

    /* renamed from: h  reason: collision with root package name */
    private int f15862h;

    EventMessage(Parcel parcel) {
        this.f15857a = (String) ad.a(parcel.readString());
        this.f15858b = (String) ad.a(parcel.readString());
        this.f15859c = parcel.readLong();
        this.f15860d = parcel.readLong();
        this.f15861e = (byte[]) ad.a(parcel.createByteArray());
    }

    public EventMessage(String str, String str2, long j2, long j3, byte[] bArr) {
        this.f15857a = str;
        this.f15858b = str2;
        this.f15859c = j2;
        this.f15860d = j3;
        this.f15861e = bArr;
    }

    public Format a() {
        String str = this.f15857a;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals("urn:scte:scte35:2014:bin")) {
                    c2 = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals("https://aomedia.org/emsg/ID3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return f15856g;
            case 1:
            case 2:
                return f15855f;
            default:
                return null;
        }
    }

    public byte[] b() {
        if (a() != null) {
            return this.f15861e;
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.f15859c == eventMessage.f15859c && this.f15860d == eventMessage.f15860d && ad.a((Object) this.f15857a, (Object) eventMessage.f15857a) && ad.a((Object) this.f15858b, (Object) eventMessage.f15858b) && Arrays.equals(this.f15861e, eventMessage.f15861e);
    }

    public int hashCode() {
        if (this.f15862h == 0) {
            String str = this.f15857a;
            int i2 = 0;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f15858b;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long j2 = this.f15859c;
            long j3 = this.f15860d;
            this.f15862h = ((((((hashCode + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.f15861e);
        }
        return this.f15862h;
    }

    public String toString() {
        String str = this.f15857a;
        long j2 = this.f15860d;
        long j3 = this.f15859c;
        String str2 = this.f15858b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(str2).length());
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j2);
        sb.append(", durationMs=");
        sb.append(j3);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15857a);
        parcel.writeString(this.f15858b);
        parcel.writeLong(this.f15859c);
        parcel.writeLong(this.f15860d);
        parcel.writeByteArray(this.f15861e);
    }
}
