package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.List;

public class FileDownloadHeader implements Parcelable {
    public static final Parcelable.Creator<FileDownloadHeader> CREATOR = new Parcelable.Creator<FileDownloadHeader>() {
        /* renamed from: a */
        public FileDownloadHeader createFromParcel(Parcel parcel) {
            return new FileDownloadHeader(parcel);
        }

        /* renamed from: a */
        public FileDownloadHeader[] newArray(int i2) {
            return new FileDownloadHeader[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, List<String>> f21405a;

    public FileDownloadHeader() {
    }

    protected FileDownloadHeader(Parcel parcel) {
        this.f21405a = parcel.readHashMap(String.class.getClassLoader());
    }

    public HashMap<String, List<String>> a() {
        return this.f21405a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f21405a.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeMap(this.f21405a);
    }
}
