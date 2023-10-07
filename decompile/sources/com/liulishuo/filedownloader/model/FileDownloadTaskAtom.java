package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FileDownloadTaskAtom implements Parcelable {
    public static final Parcelable.Creator<FileDownloadTaskAtom> CREATOR = new Parcelable.Creator<FileDownloadTaskAtom>() {
        /* renamed from: a */
        public FileDownloadTaskAtom createFromParcel(Parcel parcel) {
            return new FileDownloadTaskAtom(parcel);
        }

        /* renamed from: a */
        public FileDownloadTaskAtom[] newArray(int i2) {
            return new FileDownloadTaskAtom[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f21418a;

    /* renamed from: b  reason: collision with root package name */
    private String f21419b;

    /* renamed from: c  reason: collision with root package name */
    private long f21420c;

    protected FileDownloadTaskAtom(Parcel parcel) {
        this.f21418a = parcel.readString();
        this.f21419b = parcel.readString();
        this.f21420c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f21418a);
        parcel.writeString(this.f21419b);
        parcel.writeLong(this.f21420c);
    }
}
