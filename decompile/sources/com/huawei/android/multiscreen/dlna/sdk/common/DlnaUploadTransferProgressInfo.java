package com.huawei.android.multiscreen.dlna.sdk.common;

import android.os.Parcel;
import android.os.Parcelable;

public class DlnaUploadTransferProgressInfo implements Parcelable {
    public static final Parcelable.Creator<DlnaUploadTransferProgressInfo> CREATOR = new Parcelable.Creator<DlnaUploadTransferProgressInfo>() {
        /* renamed from: a */
        public DlnaUploadTransferProgressInfo createFromParcel(Parcel parcel) {
            DlnaUploadTransferProgressInfo dlnaUploadTransferProgressInfo = new DlnaUploadTransferProgressInfo();
            dlnaUploadTransferProgressInfo.a(ETransferProgressInfo.valueOf(parcel.readString()));
            dlnaUploadTransferProgressInfo.a(parcel.readString());
            dlnaUploadTransferProgressInfo.b(parcel.readString());
            return dlnaUploadTransferProgressInfo;
        }

        /* renamed from: a */
        public DlnaUploadTransferProgressInfo[] newArray(int i2) {
            return new DlnaUploadTransferProgressInfo[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private ETransferProgressInfo f20663a;

    /* renamed from: b  reason: collision with root package name */
    private String f20664b;

    /* renamed from: c  reason: collision with root package name */
    private String f20665c;

    public void a(ETransferProgressInfo eTransferProgressInfo) {
        this.f20663a = eTransferProgressInfo;
    }

    public void a(String str) {
        this.f20664b = str;
    }

    public void b(String str) {
        this.f20665c = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f20663a.toString());
        parcel.writeString(this.f20664b);
        parcel.writeString(this.f20665c);
    }
}
