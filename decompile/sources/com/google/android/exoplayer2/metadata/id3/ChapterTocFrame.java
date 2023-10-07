package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator<ChapterTocFrame>() {
        /* renamed from: a */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        /* renamed from: a */
        public ChapterTocFrame[] newArray(int i2) {
            return new ChapterTocFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f15898a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f15899b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f15900c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f15901d;

    /* renamed from: e  reason: collision with root package name */
    private final Id3Frame[] f15902e;

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f15898a = (String) ad.a(parcel.readString());
        boolean z2 = true;
        this.f15899b = parcel.readByte() != 0;
        this.f15900c = parcel.readByte() == 0 ? false : z2;
        this.f15901d = (String[]) ad.a(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.f15902e = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f15902e[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterTocFrame(String str, boolean z2, boolean z3, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f15898a = str;
        this.f15899b = z2;
        this.f15900c = z3;
        this.f15901d = strArr;
        this.f15902e = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.f15899b == chapterTocFrame.f15899b && this.f15900c == chapterTocFrame.f15900c && ad.a((Object) this.f15898a, (Object) chapterTocFrame.f15898a) && Arrays.equals(this.f15901d, chapterTocFrame.f15901d) && Arrays.equals(this.f15902e, chapterTocFrame.f15902e);
    }

    public int hashCode() {
        int i2 = (((true + (this.f15899b ? 1 : 0)) * 31) + (this.f15900c ? 1 : 0)) * 31;
        String str = this.f15898a;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15898a);
        parcel.writeByte(this.f15899b ? (byte) 1 : 0);
        parcel.writeByte(this.f15900c ? (byte) 1 : 0);
        parcel.writeStringArray(this.f15901d);
        parcel.writeInt(this.f15902e.length);
        for (Id3Frame writeParcelable : this.f15902e) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
