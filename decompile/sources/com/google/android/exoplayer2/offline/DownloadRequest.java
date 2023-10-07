package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() {
        /* renamed from: a */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        /* renamed from: a */
        public DownloadRequest[] newArray(int i2) {
            return new DownloadRequest[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15973a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15974b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f15975c;

    /* renamed from: d  reason: collision with root package name */
    public final List<StreamKey> f15976d;

    /* renamed from: e  reason: collision with root package name */
    public final String f15977e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f15978f;

    DownloadRequest(Parcel parcel) {
        this.f15973a = (String) ad.a(parcel.readString());
        this.f15974b = (String) ad.a(parcel.readString());
        this.f15975c = Uri.parse((String) ad.a(parcel.readString()));
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f15976d = Collections.unmodifiableList(arrayList);
        this.f15977e = parcel.readString();
        this.f15978f = (byte[]) ad.a(parcel.createByteArray());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.f15973a.equals(downloadRequest.f15973a) && this.f15974b.equals(downloadRequest.f15974b) && this.f15975c.equals(downloadRequest.f15975c) && this.f15976d.equals(downloadRequest.f15976d) && ad.a((Object) this.f15977e, (Object) downloadRequest.f15977e) && Arrays.equals(this.f15978f, downloadRequest.f15978f);
    }

    public final int hashCode() {
        int hashCode = ((((((((this.f15974b.hashCode() * 31) + this.f15973a.hashCode()) * 31) + this.f15974b.hashCode()) * 31) + this.f15975c.hashCode()) * 31) + this.f15976d.hashCode()) * 31;
        String str = this.f15977e;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f15978f);
    }

    public String toString() {
        String str = this.f15974b;
        String str2 = this.f15973a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15973a);
        parcel.writeString(this.f15974b);
        parcel.writeString(this.f15975c.toString());
        parcel.writeInt(this.f15976d.size());
        for (int i3 = 0; i3 < this.f15976d.size(); i3++) {
            parcel.writeParcelable(this.f15976d.get(i3), 0);
        }
        parcel.writeString(this.f15977e);
        parcel.writeByteArray(this.f15978f);
    }
}
