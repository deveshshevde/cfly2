package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() {
        /* renamed from: a */
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        /* renamed from: a */
        public Format[] newArray(int i2) {
            return new Format[i2];
        }
    };
    public final String A;
    public final int B;
    public final Class<? extends d> C;
    private int D;

    /* renamed from: a  reason: collision with root package name */
    public final String f15084a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15085b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15086c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15087d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15088e;

    /* renamed from: f  reason: collision with root package name */
    public final String f15089f;

    /* renamed from: g  reason: collision with root package name */
    public final Metadata f15090g;

    /* renamed from: h  reason: collision with root package name */
    public final String f15091h;

    /* renamed from: i  reason: collision with root package name */
    public final String f15092i;

    /* renamed from: j  reason: collision with root package name */
    public final int f15093j;

    /* renamed from: k  reason: collision with root package name */
    public final List<byte[]> f15094k;

    /* renamed from: l  reason: collision with root package name */
    public final DrmInitData f15095l;

    /* renamed from: m  reason: collision with root package name */
    public final long f15096m;

    /* renamed from: n  reason: collision with root package name */
    public final int f15097n;

    /* renamed from: o  reason: collision with root package name */
    public final int f15098o;

    /* renamed from: p  reason: collision with root package name */
    public final float f15099p;

    /* renamed from: q  reason: collision with root package name */
    public final int f15100q;

    /* renamed from: r  reason: collision with root package name */
    public final float f15101r;

    /* renamed from: s  reason: collision with root package name */
    public final int f15102s;

    /* renamed from: t  reason: collision with root package name */
    public final byte[] f15103t;

    /* renamed from: u  reason: collision with root package name */
    public final ColorInfo f15104u;

    /* renamed from: v  reason: collision with root package name */
    public final int f15105v;

    /* renamed from: w  reason: collision with root package name */
    public final int f15106w;

    /* renamed from: x  reason: collision with root package name */
    public final int f15107x;

    /* renamed from: y  reason: collision with root package name */
    public final int f15108y;

    /* renamed from: z  reason: collision with root package name */
    public final int f15109z;

    Format(Parcel parcel) {
        this.f15084a = parcel.readString();
        this.f15085b = parcel.readString();
        this.f15086c = parcel.readInt();
        this.f15087d = parcel.readInt();
        this.f15088e = parcel.readInt();
        this.f15089f = parcel.readString();
        this.f15090g = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        this.f15091h = parcel.readString();
        this.f15092i = parcel.readString();
        this.f15093j = parcel.readInt();
        int readInt = parcel.readInt();
        this.f15094k = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f15094k.add(parcel.createByteArray());
        }
        this.f15095l = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.f15096m = parcel.readLong();
        this.f15097n = parcel.readInt();
        this.f15098o = parcel.readInt();
        this.f15099p = parcel.readFloat();
        this.f15100q = parcel.readInt();
        this.f15101r = parcel.readFloat();
        this.f15103t = ad.a(parcel) ? parcel.createByteArray() : null;
        this.f15102s = parcel.readInt();
        this.f15104u = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.f15105v = parcel.readInt();
        this.f15106w = parcel.readInt();
        this.f15107x = parcel.readInt();
        this.f15108y = parcel.readInt();
        this.f15109z = parcel.readInt();
        this.A = parcel.readString();
        this.B = parcel.readInt();
        this.C = null;
    }

    Format(String str, String str2, int i2, int i3, int i4, String str3, Metadata metadata, String str4, String str5, int i5, List<byte[]> list, DrmInitData drmInitData, long j2, int i6, int i7, float f2, int i8, float f3, byte[] bArr, int i9, ColorInfo colorInfo, int i10, int i11, int i12, int i13, int i14, String str6, int i15, Class<? extends d> cls) {
        this.f15084a = str;
        this.f15085b = str2;
        this.f15086c = i2;
        this.f15087d = i3;
        this.f15088e = i4;
        this.f15089f = str3;
        this.f15090g = metadata;
        this.f15091h = str4;
        this.f15092i = str5;
        this.f15093j = i5;
        this.f15094k = list == null ? Collections.emptyList() : list;
        this.f15095l = drmInitData;
        this.f15096m = j2;
        this.f15097n = i6;
        this.f15098o = i7;
        this.f15099p = f2;
        int i16 = 0;
        int i17 = i8;
        this.f15100q = i17 == -1 ? 0 : i17;
        this.f15101r = f3 == -1.0f ? 1.0f : f3;
        this.f15103t = bArr;
        this.f15102s = i9;
        this.f15104u = colorInfo;
        this.f15105v = i10;
        this.f15106w = i11;
        this.f15107x = i12;
        int i18 = i13;
        this.f15108y = i18 == -1 ? 0 : i18;
        int i19 = i14;
        this.f15109z = i19 != -1 ? i19 : i16;
        this.A = ad.b(str6);
        this.B = i15;
        this.C = cls;
    }

    public static Format a(String str, String str2, int i2, String str3) {
        return a(str, str2, i2, str3, (DrmInitData) null);
    }

    public static Format a(String str, String str2, int i2, String str3, DrmInitData drmInitData) {
        return a(str, str2, (String) null, -1, i2, str3, -1, drmInitData, Long.MAX_VALUE, (List<byte[]>) Collections.emptyList());
    }

    public static Format a(String str, String str2, long j2) {
        return new Format(str, (String) null, 0, 0, -1, (String) null, (Metadata) null, (String) null, str2, -1, (List<byte[]>) null, (DrmInitData) null, j2, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, (String) null, -1, (Class<? extends d>) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, DrmInitData drmInitData) {
        return a(str, str2, str3, i2, i3, i4, i5, f2, list, i6, f3, (byte[]) null, -1, (ColorInfo) null, drmInitData);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, byte[] bArr, int i7, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, (String) null, 0, 0, i2, str3, (Metadata) null, (String) null, str2, i3, list, drmInitData, Long.MAX_VALUE, i4, i5, f2, i6, f3, bArr, i7, colorInfo, -1, -1, -1, -1, -1, (String) null, -1, (Class<? extends d>) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<byte[]> list, DrmInitData drmInitData, int i9, String str4, Metadata metadata) {
        return new Format(str, (String) null, i9, 0, i2, str3, metadata, (String) null, str2, i3, list, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, i4, i5, i6, i7, i8, str4, -1, (Class<? extends d>) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, DrmInitData drmInitData, int i7, String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, i6, -1, -1, list, drmInitData, i7, str4, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, -1, list, drmInitData, i6, str4);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, String str4, int i4, DrmInitData drmInitData, long j2, List<byte[]> list) {
        return new Format(str, (String) null, i3, 0, i2, str3, (Metadata) null, (String) null, str2, -1, list, drmInitData, j2, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, str4, i4, (Class<? extends d>) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, String str4, DrmInitData drmInitData, long j2) {
        return a(str, str2, str3, i2, i3, str4, -1, drmInitData, j2, (List<byte[]>) Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, (String) null, i3, 0, i2, str3, (Metadata) null, (String) null, str2, -1, list, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, str4, -1, (Class<? extends d>) null);
    }

    public static Format a(String str, String str2, String str3, int i2, DrmInitData drmInitData) {
        return new Format(str, (String) null, 0, 0, i2, str3, (Metadata) null, (String) null, str2, -1, (List<byte[]>) null, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, (String) null, -1, (Class<? extends d>) null);
    }

    public static Format a(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6) {
        return a(str, str2, str3, str4, str5, i2, i3, i4, str6, -1);
    }

    public static Format a(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6, int i5) {
        return new Format(str, str2, i3, i4, i2, str5, (Metadata) null, str3, str4, -1, (List<byte[]>) null, (DrmInitData) null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, str6, i5, (Class<? extends d>) null);
    }

    public static Format a(String str, String str2, String str3, String str4, String str5, Metadata metadata, int i2, int i3, int i4, float f2, List<byte[]> list, int i5, int i6) {
        return new Format(str, str2, i5, i6, i2, str5, metadata, str3, str4, -1, list, (DrmInitData) null, Long.MAX_VALUE, i3, i4, f2, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, (String) null, -1, (Class<? extends d>) null);
    }

    public static Format a(String str, String str2, String str3, String str4, String str5, Metadata metadata, int i2, int i3, int i4, List<byte[]> list, int i5, int i6, String str6) {
        return new Format(str, str2, i5, i6, i2, str5, metadata, str3, str4, -1, list, (DrmInitData) null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, i3, i4, -1, -1, -1, str6, -1, (Class<? extends d>) null);
    }

    public static Format b(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6) {
        return new Format(str, str2, i3, i4, i2, str5, (Metadata) null, str3, str4, -1, (List<byte[]>) null, (DrmInitData) null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, str6, -1, (Class<? extends d>) null);
    }

    public int a() {
        int i2;
        int i3 = this.f15097n;
        if (i3 == -1 || (i2 = this.f15098o) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    public Format a(float f2) {
        return new Format(this.f15084a, this.f15085b, this.f15086c, this.f15087d, this.f15088e, this.f15089f, this.f15090g, this.f15091h, this.f15092i, this.f15093j, this.f15094k, this.f15095l, this.f15096m, this.f15097n, this.f15098o, f2, this.f15100q, this.f15101r, this.f15103t, this.f15102s, this.f15104u, this.f15105v, this.f15106w, this.f15107x, this.f15108y, this.f15109z, this.A, this.B, this.C);
    }

    public Format a(int i2) {
        return new Format(this.f15084a, this.f15085b, this.f15086c, this.f15087d, this.f15088e, this.f15089f, this.f15090g, this.f15091h, this.f15092i, i2, this.f15094k, this.f15095l, this.f15096m, this.f15097n, this.f15098o, this.f15099p, this.f15100q, this.f15101r, this.f15103t, this.f15102s, this.f15104u, this.f15105v, this.f15106w, this.f15107x, this.f15108y, this.f15109z, this.A, this.B, this.C);
    }

    public Format a(int i2, int i3) {
        return new Format(this.f15084a, this.f15085b, this.f15086c, this.f15087d, this.f15088e, this.f15089f, this.f15090g, this.f15091h, this.f15092i, this.f15093j, this.f15094k, this.f15095l, this.f15096m, this.f15097n, this.f15098o, this.f15099p, this.f15100q, this.f15101r, this.f15103t, this.f15102s, this.f15104u, this.f15105v, this.f15106w, this.f15107x, i2, i3, this.A, this.B, this.C);
    }

    public Format a(long j2) {
        return new Format(this.f15084a, this.f15085b, this.f15086c, this.f15087d, this.f15088e, this.f15089f, this.f15090g, this.f15091h, this.f15092i, this.f15093j, this.f15094k, this.f15095l, j2, this.f15097n, this.f15098o, this.f15099p, this.f15100q, this.f15101r, this.f15103t, this.f15102s, this.f15104u, this.f15105v, this.f15106w, this.f15107x, this.f15108y, this.f15109z, this.A, this.B, this.C);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r6 = r1.A;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.Format a(com.google.android.exoplayer2.Format r35) {
        /*
            r34 = this;
            r0 = r34
            r1 = r35
            if (r0 != r1) goto L_0x0007
            return r0
        L_0x0007:
            java.lang.String r2 = r0.f15092i
            int r2 = com.google.android.exoplayer2.util.n.h(r2)
            java.lang.String r4 = r1.f15084a
            java.lang.String r3 = r1.f15085b
            if (r3 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            java.lang.String r3 = r0.f15085b
        L_0x0016:
            r5 = r3
            java.lang.String r3 = r0.A
            r6 = 3
            r7 = 1
            if (r2 == r6) goto L_0x001f
            if (r2 != r7) goto L_0x0026
        L_0x001f:
            java.lang.String r6 = r1.A
            if (r6 == 0) goto L_0x0026
            r31 = r6
            goto L_0x0028
        L_0x0026:
            r31 = r3
        L_0x0028:
            int r3 = r0.f15088e
            r6 = -1
            if (r3 != r6) goto L_0x002f
            int r3 = r1.f15088e
        L_0x002f:
            r8 = r3
            java.lang.String r3 = r0.f15089f
            if (r3 != 0) goto L_0x0043
            java.lang.String r6 = r1.f15089f
            java.lang.String r6 = com.google.android.exoplayer2.util.ad.a((java.lang.String) r6, (int) r2)
            java.lang.String[] r9 = com.google.android.exoplayer2.util.ad.g((java.lang.String) r6)
            int r9 = r9.length
            if (r9 != r7) goto L_0x0043
            r9 = r6
            goto L_0x0044
        L_0x0043:
            r9 = r3
        L_0x0044:
            com.google.android.exoplayer2.metadata.Metadata r3 = r0.f15090g
            if (r3 != 0) goto L_0x004b
            com.google.android.exoplayer2.metadata.Metadata r3 = r1.f15090g
            goto L_0x0051
        L_0x004b:
            com.google.android.exoplayer2.metadata.Metadata r6 = r1.f15090g
            com.google.android.exoplayer2.metadata.Metadata r3 = r3.a((com.google.android.exoplayer2.metadata.Metadata) r6)
        L_0x0051:
            r10 = r3
            float r3 = r0.f15099p
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0062
            r6 = 2
            if (r2 != r6) goto L_0x0062
            float r2 = r1.f15099p
            r20 = r2
            goto L_0x0064
        L_0x0062:
            r20 = r3
        L_0x0064:
            int r2 = r0.f15086c
            int r3 = r1.f15086c
            r6 = r2 | r3
            int r2 = r0.f15087d
            int r3 = r1.f15087d
            r7 = r2 | r3
            com.google.android.exoplayer2.drm.DrmInitData r1 = r1.f15095l
            com.google.android.exoplayer2.drm.DrmInitData r2 = r0.f15095l
            com.google.android.exoplayer2.drm.DrmInitData r15 = com.google.android.exoplayer2.drm.DrmInitData.a((com.google.android.exoplayer2.drm.DrmInitData) r1, (com.google.android.exoplayer2.drm.DrmInitData) r2)
            com.google.android.exoplayer2.Format r1 = new com.google.android.exoplayer2.Format
            r3 = r1
            java.lang.String r11 = r0.f15091h
            java.lang.String r12 = r0.f15092i
            int r13 = r0.f15093j
            java.util.List<byte[]> r14 = r0.f15094k
            r35 = r1
            long r1 = r0.f15096m
            r16 = r1
            int r1 = r0.f15097n
            r18 = r1
            int r1 = r0.f15098o
            r19 = r1
            int r1 = r0.f15100q
            r21 = r1
            float r1 = r0.f15101r
            r22 = r1
            byte[] r1 = r0.f15103t
            r23 = r1
            int r1 = r0.f15102s
            r24 = r1
            com.google.android.exoplayer2.video.ColorInfo r1 = r0.f15104u
            r25 = r1
            int r1 = r0.f15105v
            r26 = r1
            int r1 = r0.f15106w
            r27 = r1
            int r1 = r0.f15107x
            r28 = r1
            int r1 = r0.f15108y
            r29 = r1
            int r1 = r0.f15109z
            r30 = r1
            int r1 = r0.B
            r32 = r1
            java.lang.Class<? extends com.google.android.exoplayer2.drm.d> r1 = r0.C
            r33 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            return r35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.Format.a(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.Format");
    }

    public Format a(DrmInitData drmInitData) {
        return a(drmInitData, this.f15090g);
    }

    public Format a(DrmInitData drmInitData, Metadata metadata) {
        if (drmInitData != this.f15095l) {
            Metadata metadata2 = metadata;
        } else if (metadata == this.f15090g) {
            return this;
        }
        return new Format(this.f15084a, this.f15085b, this.f15086c, this.f15087d, this.f15088e, this.f15089f, metadata, this.f15091h, this.f15092i, this.f15093j, this.f15094k, drmInitData, this.f15096m, this.f15097n, this.f15098o, this.f15099p, this.f15100q, this.f15101r, this.f15103t, this.f15102s, this.f15104u, this.f15105v, this.f15106w, this.f15107x, this.f15108y, this.f15109z, this.A, this.B, this.C);
    }

    public Format a(Metadata metadata) {
        return a(this.f15095l, metadata);
    }

    public Format a(Class<? extends d> cls) {
        return new Format(this.f15084a, this.f15085b, this.f15086c, this.f15087d, this.f15088e, this.f15089f, this.f15090g, this.f15091h, this.f15092i, this.f15093j, this.f15094k, this.f15095l, this.f15096m, this.f15097n, this.f15098o, this.f15099p, this.f15100q, this.f15101r, this.f15103t, this.f15102s, this.f15104u, this.f15105v, this.f15106w, this.f15107x, this.f15108y, this.f15109z, this.A, this.B, cls);
    }

    public Format a(String str, String str2, String str3, String str4, Metadata metadata, int i2, int i3, int i4, int i5, int i6, String str5) {
        Metadata metadata2 = this.f15090g;
        Metadata metadata3 = metadata;
        return new Format(str, str2, i6, this.f15087d, i2, str4, metadata2 != null ? metadata2.a(metadata3) : metadata3, this.f15091h, str3, this.f15093j, this.f15094k, this.f15095l, this.f15096m, i3, i4, this.f15099p, this.f15100q, this.f15101r, this.f15103t, this.f15102s, this.f15104u, i5, this.f15106w, this.f15107x, this.f15108y, this.f15109z, str5, this.B, this.C);
    }

    public Format b(int i2) {
        return new Format(this.f15084a, this.f15085b, this.f15086c, this.f15087d, i2, this.f15089f, this.f15090g, this.f15091h, this.f15092i, this.f15093j, this.f15094k, this.f15095l, this.f15096m, this.f15097n, this.f15098o, this.f15099p, this.f15100q, this.f15101r, this.f15103t, this.f15102s, this.f15104u, this.f15105v, this.f15106w, this.f15107x, this.f15108y, this.f15109z, this.A, this.B, this.C);
    }

    public boolean b(Format format) {
        if (this.f15094k.size() != format.f15094k.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f15094k.size(); i2++) {
            if (!Arrays.equals(this.f15094k.get(i2), format.f15094k.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        r3 = r8.D;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r8 == 0) goto L_0x0107
            java.lang.Class r2 = r7.getClass()
            java.lang.Class r3 = r8.getClass()
            if (r2 == r3) goto L_0x0013
            goto L_0x0107
        L_0x0013:
            com.google.android.exoplayer2.Format r8 = (com.google.android.exoplayer2.Format) r8
            int r2 = r7.D
            if (r2 == 0) goto L_0x0020
            int r3 = r8.D
            if (r3 == 0) goto L_0x0020
            if (r2 == r3) goto L_0x0020
            return r1
        L_0x0020:
            int r2 = r7.f15086c
            int r3 = r8.f15086c
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15087d
            int r3 = r8.f15087d
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15088e
            int r3 = r8.f15088e
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15093j
            int r3 = r8.f15093j
            if (r2 != r3) goto L_0x0105
            long r2 = r7.f15096m
            long r4 = r8.f15096m
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0105
            int r2 = r7.f15097n
            int r3 = r8.f15097n
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15098o
            int r3 = r8.f15098o
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15100q
            int r3 = r8.f15100q
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15102s
            int r3 = r8.f15102s
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15105v
            int r3 = r8.f15105v
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15106w
            int r3 = r8.f15106w
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15107x
            int r3 = r8.f15107x
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15108y
            int r3 = r8.f15108y
            if (r2 != r3) goto L_0x0105
            int r2 = r7.f15109z
            int r3 = r8.f15109z
            if (r2 != r3) goto L_0x0105
            int r2 = r7.B
            int r3 = r8.B
            if (r2 != r3) goto L_0x0105
            float r2 = r7.f15099p
            float r3 = r8.f15099p
            int r2 = java.lang.Float.compare(r2, r3)
            if (r2 != 0) goto L_0x0105
            float r2 = r7.f15101r
            float r3 = r8.f15101r
            int r2 = java.lang.Float.compare(r2, r3)
            if (r2 != 0) goto L_0x0105
            java.lang.Class<? extends com.google.android.exoplayer2.drm.d> r2 = r7.C
            java.lang.Class<? extends com.google.android.exoplayer2.drm.d> r3 = r8.C
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            java.lang.String r2 = r7.f15084a
            java.lang.String r3 = r8.f15084a
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            java.lang.String r2 = r7.f15085b
            java.lang.String r3 = r8.f15085b
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            java.lang.String r2 = r7.f15089f
            java.lang.String r3 = r8.f15089f
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            java.lang.String r2 = r7.f15091h
            java.lang.String r3 = r8.f15091h
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            java.lang.String r2 = r7.f15092i
            java.lang.String r3 = r8.f15092i
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            java.lang.String r2 = r7.A
            java.lang.String r3 = r8.A
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            byte[] r2 = r7.f15103t
            byte[] r3 = r8.f15103t
            boolean r2 = java.util.Arrays.equals(r2, r3)
            if (r2 == 0) goto L_0x0105
            com.google.android.exoplayer2.metadata.Metadata r2 = r7.f15090g
            com.google.android.exoplayer2.metadata.Metadata r3 = r8.f15090g
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            com.google.android.exoplayer2.video.ColorInfo r2 = r7.f15104u
            com.google.android.exoplayer2.video.ColorInfo r3 = r8.f15104u
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            com.google.android.exoplayer2.drm.DrmInitData r2 = r7.f15095l
            com.google.android.exoplayer2.drm.DrmInitData r3 = r8.f15095l
            boolean r2 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0105
            boolean r8 = r7.b((com.google.android.exoplayer2.Format) r8)
            if (r8 == 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r0 = 0
        L_0x0106:
            return r0
        L_0x0107:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.Format.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (this.D == 0) {
            String str = this.f15084a;
            int i2 = 0;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f15085b;
            int hashCode2 = (((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f15086c) * 31) + this.f15087d) * 31) + this.f15088e) * 31;
            String str3 = this.f15089f;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Metadata metadata = this.f15090g;
            int hashCode4 = (hashCode3 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str4 = this.f15091h;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f15092i;
            int hashCode6 = (((((((((((((((((((((((((((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f15093j) * 31) + ((int) this.f15096m)) * 31) + this.f15097n) * 31) + this.f15098o) * 31) + Float.floatToIntBits(this.f15099p)) * 31) + this.f15100q) * 31) + Float.floatToIntBits(this.f15101r)) * 31) + this.f15102s) * 31) + this.f15105v) * 31) + this.f15106w) * 31) + this.f15107x) * 31) + this.f15108y) * 31) + this.f15109z) * 31;
            String str6 = this.A;
            int hashCode7 = (((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.B) * 31;
            Class<? extends d> cls = this.C;
            if (cls != null) {
                i2 = cls.hashCode();
            }
            this.D = hashCode7 + i2;
        }
        return this.D;
    }

    public String toString() {
        String str = this.f15084a;
        String str2 = this.f15085b;
        String str3 = this.f15091h;
        String str4 = this.f15092i;
        String str5 = this.f15089f;
        int i2 = this.f15088e;
        String str6 = this.A;
        int i3 = this.f15097n;
        int i4 = this.f15098o;
        float f2 = this.f15099p;
        int i5 = this.f15105v;
        int i6 = this.f15106w;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 104 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str4);
        sb.append(", ");
        sb.append(str5);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(str6);
        sb.append(", [");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(f2);
        sb.append("], [");
        sb.append(i5);
        sb.append(", ");
        sb.append(i6);
        sb.append("])");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f15084a);
        parcel.writeString(this.f15085b);
        parcel.writeInt(this.f15086c);
        parcel.writeInt(this.f15087d);
        parcel.writeInt(this.f15088e);
        parcel.writeString(this.f15089f);
        boolean z2 = false;
        parcel.writeParcelable(this.f15090g, 0);
        parcel.writeString(this.f15091h);
        parcel.writeString(this.f15092i);
        parcel.writeInt(this.f15093j);
        int size = this.f15094k.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(this.f15094k.get(i3));
        }
        parcel.writeParcelable(this.f15095l, 0);
        parcel.writeLong(this.f15096m);
        parcel.writeInt(this.f15097n);
        parcel.writeInt(this.f15098o);
        parcel.writeFloat(this.f15099p);
        parcel.writeInt(this.f15100q);
        parcel.writeFloat(this.f15101r);
        if (this.f15103t != null) {
            z2 = true;
        }
        ad.a(parcel, z2);
        byte[] bArr = this.f15103t;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.f15102s);
        parcel.writeParcelable(this.f15104u, i2);
        parcel.writeInt(this.f15105v);
        parcel.writeInt(this.f15106w);
        parcel.writeInt(this.f15107x);
        parcel.writeInt(this.f15108y);
        parcel.writeInt(this.f15109z);
        parcel.writeString(this.A);
        parcel.writeInt(this.B);
    }
}
