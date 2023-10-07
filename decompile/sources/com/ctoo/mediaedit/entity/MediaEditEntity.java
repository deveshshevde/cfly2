package com.ctoo.mediaedit.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.ctoo.mediaedit.MyPhoto;
import kotlin.jvm.internal.h;

public class MediaEditEntity implements Parcelable {
    public static final a CREATOR = new a((f) null);

    /* renamed from: a  reason: collision with root package name */
    private MyPhoto f10816a;

    /* renamed from: b  reason: collision with root package name */
    private long f10817b;

    /* renamed from: c  reason: collision with root package name */
    private float f10818c;

    /* renamed from: d  reason: collision with root package name */
    private long f10819d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10820e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10821f;

    /* renamed from: g  reason: collision with root package name */
    private float f10822g;

    /* renamed from: h  reason: collision with root package name */
    private String f10823h;

    /* renamed from: i  reason: collision with root package name */
    private String f10824i;

    /* renamed from: j  reason: collision with root package name */
    private String f10825j;

    /* renamed from: k  reason: collision with root package name */
    private String f10826k;

    /* renamed from: l  reason: collision with root package name */
    private int f10827l;

    /* renamed from: m  reason: collision with root package name */
    private int f10828m;

    /* renamed from: n  reason: collision with root package name */
    private int f10829n;

    /* renamed from: o  reason: collision with root package name */
    private int f10830o;

    /* renamed from: p  reason: collision with root package name */
    private int f10831p;

    /* renamed from: q  reason: collision with root package name */
    private int f10832q;

    /* renamed from: r  reason: collision with root package name */
    private int f10833r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f10834s;

    public static final class a implements Parcelable.Creator<MediaEditEntity> {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        /* renamed from: a */
        public MediaEditEntity createFromParcel(Parcel parcel) {
            h.d(parcel, "parcel");
            return new MediaEditEntity(parcel);
        }

        /* renamed from: a */
        public MediaEditEntity[] newArray(int i2) {
            return new MediaEditEntity[i2];
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaEditEntity(android.os.Parcel r25) {
        /*
            r24 = this;
            r0 = r25
            java.lang.String r1 = "parcel"
            kotlin.jvm.internal.h.d(r0, r1)
            java.lang.Class<com.ctoo.mediaedit.MyPhoto> r1 = com.ctoo.mediaedit.MyPhoto.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r0.readParcelable(r1)
            r3 = r1
            com.ctoo.mediaedit.MyPhoto r3 = (com.ctoo.mediaedit.MyPhoto) r3
            long r4 = r25.readLong()
            float r6 = r25.readFloat()
            long r7 = r25.readLong()
            byte r1 = r25.readByte()
            r2 = 0
            byte r9 = (byte) r2
            r10 = 1
            if (r1 == r9) goto L_0x002b
            r1 = 1
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            byte r11 = r25.readByte()
            if (r11 == r9) goto L_0x0034
            r11 = 1
            goto L_0x0035
        L_0x0034:
            r11 = 0
        L_0x0035:
            float r12 = r25.readFloat()
            java.lang.String r13 = r25.readString()
            java.lang.String r14 = r25.readString()
            java.lang.String r15 = r25.readString()
            java.lang.String r16 = r25.readString()
            int r17 = r25.readInt()
            int r18 = r25.readInt()
            int r19 = r25.readInt()
            int r20 = r25.readInt()
            int r21 = r25.readInt()
            int r22 = r25.readInt()
            int r23 = r25.readInt()
            byte r0 = r25.readByte()
            if (r0 == r9) goto L_0x006d
            r0 = 1
            goto L_0x006e
        L_0x006d:
            r0 = 0
        L_0x006e:
            r2 = r24
            r9 = r1
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r23 = r0
            r2.<init>(r3, r4, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.entity.MediaEditEntity.<init>(android.os.Parcel):void");
    }

    public MediaEditEntity(MyPhoto myPhoto, long j2, float f2, long j3, boolean z2, boolean z3, float f3, String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z4) {
        this.f10816a = myPhoto;
        this.f10817b = j2;
        this.f10818c = f2;
        this.f10819d = j3;
        this.f10820e = z2;
        this.f10821f = z3;
        this.f10822g = f3;
        this.f10823h = str;
        this.f10824i = str2;
        this.f10825j = str3;
        this.f10826k = str4;
        this.f10827l = i2;
        this.f10828m = i3;
        this.f10829n = i4;
        this.f10830o = i5;
        this.f10831p = i6;
        this.f10832q = i7;
        this.f10833r = i8;
        this.f10834s = z4;
    }

    public final MyPhoto a() {
        return this.f10816a;
    }

    public final long b() {
        return this.f10817b;
    }

    public final long c() {
        return this.f10819d;
    }

    public final String d() {
        return this.f10824i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.d(parcel, "parcel");
        parcel.writeParcelable(this.f10816a, i2);
        parcel.writeLong(this.f10817b);
        parcel.writeFloat(this.f10818c);
        parcel.writeLong(this.f10819d);
        parcel.writeByte(this.f10820e ? (byte) 1 : 0);
        parcel.writeByte(this.f10821f ? (byte) 1 : 0);
        parcel.writeFloat(this.f10822g);
        parcel.writeString(this.f10823h);
        parcel.writeString(this.f10824i);
        parcel.writeString(this.f10825j);
        parcel.writeString(this.f10826k);
        parcel.writeInt(this.f10827l);
        parcel.writeInt(this.f10828m);
        parcel.writeInt(this.f10829n);
        parcel.writeInt(this.f10830o);
        parcel.writeInt(this.f10831p);
        parcel.writeInt(this.f10832q);
        parcel.writeInt(this.f10833r);
        parcel.writeByte(this.f10834s ? (byte) 1 : 0);
    }
}
