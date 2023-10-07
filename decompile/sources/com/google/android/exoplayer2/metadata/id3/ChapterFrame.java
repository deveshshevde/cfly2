package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator<ChapterFrame>() {
        /* renamed from: a */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        /* renamed from: a */
        public ChapterFrame[] newArray(int i2) {
            return new ChapterFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15892a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15893b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15894c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15895d;

    /* renamed from: e  reason: collision with root package name */
    public final long f15896e;

    /* renamed from: g  reason: collision with root package name */
    private final Id3Frame[] f15897g;

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f15892a = (String) ad.a(parcel.readString());
        this.f15893b = parcel.readInt();
        this.f15894c = parcel.readInt();
        this.f15895d = parcel.readLong();
        this.f15896e = parcel.readLong();
        int readInt = parcel.readInt();
        this.f15897g = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f15897g[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(String str, int i2, int i3, long j2, long j3, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f15892a = str;
        this.f15893b = i2;
        this.f15894c = i3;
        this.f15895d = j2;
        this.f15896e = j3;
        this.f15897g = id3FrameArr;
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
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        return this.f15893b == chapterFrame.f15893b && this.f15894c == chapterFrame.f15894c && this.f15895d == chapterFrame.f15895d && this.f15896e == chapterFrame.f15896e && ad.a((Object) this.f15892a, (Object) chapterFrame.f15892a) && Arrays.equals(this.f15897g, chapterFrame.f15897g);
    }

    public int hashCode() {
        int i2 = (((((((527 + this.f15893b) * 31) + this.f15894c) * 31) + ((int) this.f15895d)) * 31) + ((int) this.f15896e)) * 31;
        String str = this.f15892a;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15892a);
        parcel.writeInt(this.f15893b);
        parcel.writeInt(this.f15894c);
        parcel.writeLong(this.f15895d);
        parcel.writeLong(this.f15896e);
        parcel.writeInt(this.f15897g.length);
        for (Id3Frame writeParcelable : this.f15897g) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
