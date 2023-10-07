package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() {
        /* renamed from: a */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        /* renamed from: a */
        public SpliceScheduleCommand[] newArray(int i2) {
            return new SpliceScheduleCommand[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f15949a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f15950a;

        /* renamed from: b  reason: collision with root package name */
        public final long f15951b;

        private a(int i2, long j2) {
            this.f15950a = i2;
            this.f15951b = j2;
        }

        /* access modifiers changed from: private */
        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        public void c(Parcel parcel) {
            parcel.writeInt(this.f15950a);
            parcel.writeLong(this.f15951b);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f15952a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f15953b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f15954c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f15955d;

        /* renamed from: e  reason: collision with root package name */
        public final long f15956e;

        /* renamed from: f  reason: collision with root package name */
        public final List<a> f15957f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f15958g;

        /* renamed from: h  reason: collision with root package name */
        public final long f15959h;

        /* renamed from: i  reason: collision with root package name */
        public final int f15960i;

        /* renamed from: j  reason: collision with root package name */
        public final int f15961j;

        /* renamed from: k  reason: collision with root package name */
        public final int f15962k;

        private b(long j2, boolean z2, boolean z3, boolean z4, List<a> list, long j3, boolean z5, long j4, int i2, int i3, int i4) {
            this.f15952a = j2;
            this.f15953b = z2;
            this.f15954c = z3;
            this.f15955d = z4;
            this.f15957f = Collections.unmodifiableList(list);
            this.f15956e = j3;
            this.f15958g = z5;
            this.f15959h = j4;
            this.f15960i = i2;
            this.f15961j = i3;
            this.f15962k = i4;
        }

        private b(Parcel parcel) {
            this.f15952a = parcel.readLong();
            boolean z2 = false;
            this.f15953b = parcel.readByte() == 1;
            this.f15954c = parcel.readByte() == 1;
            this.f15955d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(a.b(parcel));
            }
            this.f15957f = Collections.unmodifiableList(arrayList);
            this.f15956e = parcel.readLong();
            this.f15958g = parcel.readByte() == 1 ? true : z2;
            this.f15959h = parcel.readLong();
            this.f15960i = parcel.readInt();
            this.f15961j = parcel.readInt();
            this.f15962k = parcel.readInt();
        }

        /* access modifiers changed from: private */
        public static b b(q qVar) {
            boolean z2;
            int i2;
            int i3;
            int i4;
            long j2;
            boolean z3;
            long j3;
            ArrayList arrayList;
            boolean z4;
            long j4;
            boolean z5;
            long n2 = qVar.n();
            boolean z6 = (qVar.h() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (!z6) {
                int h2 = qVar.h();
                boolean z7 = (h2 & 128) != 0;
                boolean z8 = (h2 & 64) != 0;
                boolean z9 = (h2 & 32) != 0;
                long n3 = z8 ? qVar.n() : -9223372036854775807L;
                if (!z8) {
                    int h3 = qVar.h();
                    ArrayList arrayList3 = new ArrayList(h3);
                    for (int i5 = 0; i5 < h3; i5++) {
                        arrayList3.add(new a(qVar.h(), qVar.n()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z9) {
                    long h4 = (long) qVar.h();
                    boolean z10 = (128 & h4) != 0;
                    j4 = ((((h4 & 1) << 32) | qVar.n()) * 1000) / 90;
                    z5 = z10;
                } else {
                    z5 = false;
                    j4 = -9223372036854775807L;
                }
                int i6 = qVar.i();
                int h5 = qVar.h();
                z2 = z8;
                i2 = qVar.h();
                j2 = j4;
                arrayList = arrayList2;
                long j5 = n3;
                i4 = i6;
                i3 = h5;
                j3 = j5;
                boolean z11 = z7;
                z3 = z5;
                z4 = z11;
            } else {
                arrayList = arrayList2;
                z4 = false;
                j3 = -9223372036854775807L;
                z3 = false;
                j2 = -9223372036854775807L;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                z2 = false;
            }
            return new b(n2, z6, z4, z2, arrayList, j3, z3, j2, i4, i3, i2);
        }

        /* access modifiers changed from: private */
        public void b(Parcel parcel) {
            parcel.writeLong(this.f15952a);
            parcel.writeByte(this.f15953b ? (byte) 1 : 0);
            parcel.writeByte(this.f15954c ? (byte) 1 : 0);
            parcel.writeByte(this.f15955d ? (byte) 1 : 0);
            int size = this.f15957f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f15957f.get(i2).c(parcel);
            }
            parcel.writeLong(this.f15956e);
            parcel.writeByte(this.f15958g ? (byte) 1 : 0);
            parcel.writeLong(this.f15959h);
            parcel.writeInt(this.f15960i);
            parcel.writeInt(this.f15961j);
            parcel.writeInt(this.f15962k);
        }

        /* access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel);
        }
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(b.c(parcel));
        }
        this.f15949a = Collections.unmodifiableList(arrayList);
    }

    private SpliceScheduleCommand(List<b> list) {
        this.f15949a = Collections.unmodifiableList(list);
    }

    static SpliceScheduleCommand a(q qVar) {
        int h2 = qVar.h();
        ArrayList arrayList = new ArrayList(h2);
        for (int i2 = 0; i2 < h2; i2++) {
            arrayList.add(b.b(qVar));
        }
        return new SpliceScheduleCommand((List<b>) arrayList);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int size = this.f15949a.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f15949a.get(i3).b(parcel);
        }
    }
}
