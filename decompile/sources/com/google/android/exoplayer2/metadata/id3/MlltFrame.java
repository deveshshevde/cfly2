package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new Parcelable.Creator<MlltFrame>() {
        /* renamed from: a */
        public MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }

        /* renamed from: a */
        public MlltFrame[] newArray(int i2) {
            return new MlltFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f15914a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15915b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15916c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f15917d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f15918e;

    public MlltFrame(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f15914a = i2;
        this.f15915b = i3;
        this.f15916c = i4;
        this.f15917d = iArr;
        this.f15918e = iArr2;
    }

    MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f15914a = parcel.readInt();
        this.f15915b = parcel.readInt();
        this.f15916c = parcel.readInt();
        this.f15917d = (int[]) ad.a(parcel.createIntArray());
        this.f15918e = (int[]) ad.a(parcel.createIntArray());
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
        MlltFrame mlltFrame = (MlltFrame) obj;
        return this.f15914a == mlltFrame.f15914a && this.f15915b == mlltFrame.f15915b && this.f15916c == mlltFrame.f15916c && Arrays.equals(this.f15917d, mlltFrame.f15917d) && Arrays.equals(this.f15918e, mlltFrame.f15918e);
    }

    public int hashCode() {
        return ((((((((527 + this.f15914a) * 31) + this.f15915b) * 31) + this.f15916c) * 31) + Arrays.hashCode(this.f15917d)) * 31) + Arrays.hashCode(this.f15918e);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f15914a);
        parcel.writeInt(this.f15915b);
        parcel.writeInt(this.f15916c);
        parcel.writeIntArray(this.f15917d);
        parcel.writeIntArray(this.f15918e);
    }
}
