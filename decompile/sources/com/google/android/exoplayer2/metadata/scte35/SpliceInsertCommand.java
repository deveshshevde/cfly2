package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() {
        /* renamed from: a */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        /* renamed from: a */
        public SpliceInsertCommand[] newArray(int i2) {
            return new SpliceInsertCommand[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f15933a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f15934b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f15935c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f15936d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15937e;

    /* renamed from: f  reason: collision with root package name */
    public final long f15938f;

    /* renamed from: g  reason: collision with root package name */
    public final long f15939g;

    /* renamed from: h  reason: collision with root package name */
    public final List<a> f15940h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f15941i;

    /* renamed from: j  reason: collision with root package name */
    public final long f15942j;

    /* renamed from: k  reason: collision with root package name */
    public final int f15943k;

    /* renamed from: l  reason: collision with root package name */
    public final int f15944l;

    /* renamed from: m  reason: collision with root package name */
    public final int f15945m;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f15946a;

        /* renamed from: b  reason: collision with root package name */
        public final long f15947b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15948c;

        private a(int i2, long j2, long j3) {
            this.f15946a = i2;
            this.f15947b = j2;
            this.f15948c = j3;
        }

        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void a(Parcel parcel) {
            parcel.writeInt(this.f15946a);
            parcel.writeLong(this.f15947b);
            parcel.writeLong(this.f15948c);
        }
    }

    private SpliceInsertCommand(long j2, boolean z2, boolean z3, boolean z4, boolean z5, long j3, long j4, List<a> list, boolean z6, long j5, int i2, int i3, int i4) {
        this.f15933a = j2;
        this.f15934b = z2;
        this.f15935c = z3;
        this.f15936d = z4;
        this.f15937e = z5;
        this.f15938f = j3;
        this.f15939g = j4;
        this.f15940h = Collections.unmodifiableList(list);
        this.f15941i = z6;
        this.f15942j = j5;
        this.f15943k = i2;
        this.f15944l = i3;
        this.f15945m = i4;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f15933a = parcel.readLong();
        boolean z2 = false;
        this.f15934b = parcel.readByte() == 1;
        this.f15935c = parcel.readByte() == 1;
        this.f15936d = parcel.readByte() == 1;
        this.f15937e = parcel.readByte() == 1;
        this.f15938f = parcel.readLong();
        this.f15939g = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(a.b(parcel));
        }
        this.f15940h = Collections.unmodifiableList(arrayList);
        this.f15941i = parcel.readByte() == 1 ? true : z2;
        this.f15942j = parcel.readLong();
        this.f15943k = parcel.readInt();
        this.f15944l = parcel.readInt();
        this.f15945m = parcel.readInt();
    }

    static SpliceInsertCommand a(q qVar, long j2, aa aaVar) {
        boolean z2;
        int i2;
        int i3;
        int i4;
        long j3;
        boolean z3;
        List list;
        long j4;
        boolean z4;
        boolean z5;
        long j5;
        boolean z6;
        aa aaVar2 = aaVar;
        long n2 = qVar.n();
        boolean z7 = (qVar.h() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z7) {
            int h2 = qVar.h();
            boolean z8 = (h2 & 128) != 0;
            boolean z9 = (h2 & 64) != 0;
            boolean z10 = (h2 & 32) != 0;
            boolean z11 = (h2 & 16) != 0;
            long a2 = (!z9 || z11) ? -9223372036854775807L : TimeSignalCommand.a(qVar, j2);
            if (!z9) {
                int h3 = qVar.h();
                ArrayList arrayList = new ArrayList(h3);
                for (int i5 = 0; i5 < h3; i5++) {
                    int h4 = qVar.h();
                    long a3 = !z11 ? TimeSignalCommand.a(qVar, j2) : -9223372036854775807L;
                    arrayList.add(new a(h4, a3, aaVar2.b(a3)));
                }
                emptyList = arrayList;
            }
            if (z10) {
                long h5 = (long) qVar.h();
                boolean z12 = (128 & h5) != 0;
                j5 = ((((h5 & 1) << 32) | qVar.n()) * 1000) / 90;
                z6 = z12;
            } else {
                z6 = false;
                j5 = -9223372036854775807L;
            }
            i4 = qVar.i();
            z2 = z9;
            i3 = qVar.h();
            i2 = qVar.h();
            list = emptyList;
            long j6 = a2;
            z3 = z6;
            j3 = j5;
            z4 = z11;
            z5 = z8;
            j4 = j6;
        } else {
            list = emptyList;
            z5 = false;
            z4 = false;
            j4 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z2 = false;
        }
        return new SpliceInsertCommand(n2, z7, z5, z2, z4, j4, aaVar2.b(j4), list, z3, j3, i4, i3, i2);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f15933a);
        parcel.writeByte(this.f15934b ? (byte) 1 : 0);
        parcel.writeByte(this.f15935c ? (byte) 1 : 0);
        parcel.writeByte(this.f15936d ? (byte) 1 : 0);
        parcel.writeByte(this.f15937e ? (byte) 1 : 0);
        parcel.writeLong(this.f15938f);
        parcel.writeLong(this.f15939g);
        int size = this.f15940h.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f15940h.get(i3).a(parcel);
        }
        parcel.writeByte(this.f15941i ? (byte) 1 : 0);
        parcel.writeLong(this.f15942j);
        parcel.writeInt(this.f15943k);
        parcel.writeInt(this.f15944l);
        parcel.writeInt(this.f15945m);
    }
}
