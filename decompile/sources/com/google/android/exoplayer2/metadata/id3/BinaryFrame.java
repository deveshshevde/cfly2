package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() {
        /* renamed from: a */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        /* renamed from: a */
        public BinaryFrame[] newArray(int i2) {
            return new BinaryFrame[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f15891a;

    BinaryFrame(Parcel parcel) {
        super((String) ad.a(parcel.readString()));
        this.f15891a = (byte[]) ad.a(parcel.createByteArray());
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f15891a = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        return this.f15910f.equals(binaryFrame.f15910f) && Arrays.equals(this.f15891a, binaryFrame.f15891a);
    }

    public int hashCode() {
        return ((527 + this.f15910f.hashCode()) * 31) + Arrays.hashCode(this.f15891a);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15910f);
        parcel.writeByteArray(this.f15891a);
    }
}
