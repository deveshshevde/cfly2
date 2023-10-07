package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() {
        /* renamed from: a */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        /* renamed from: a */
        public PrivateCommand[] newArray(int i2) {
            return new PrivateCommand[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f15930a;

    /* renamed from: b  reason: collision with root package name */
    public final long f15931b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f15932c;

    private PrivateCommand(long j2, byte[] bArr, long j3) {
        this.f15930a = j3;
        this.f15931b = j2;
        this.f15932c = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.f15930a = parcel.readLong();
        this.f15931b = parcel.readLong();
        this.f15932c = (byte[]) ad.a(parcel.createByteArray());
    }

    static PrivateCommand a(q qVar, int i2, long j2) {
        long n2 = qVar.n();
        int i3 = i2 - 4;
        byte[] bArr = new byte[i3];
        qVar.a(bArr, 0, i3);
        return new PrivateCommand(n2, bArr, j2);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f15930a);
        parcel.writeLong(this.f15931b);
        parcel.writeByteArray(this.f15932c);
    }
}
