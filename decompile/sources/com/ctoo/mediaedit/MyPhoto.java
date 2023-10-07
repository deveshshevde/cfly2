package com.ctoo.mediaedit;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.xeagle.android.login.pickImage.data.GLImage;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.h;

public final class MyPhoto implements Parcelable {
    public static final a CREATOR = new a((f) null);

    /* renamed from: a  reason: collision with root package name */
    private String f10772a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f10773b;

    /* renamed from: c  reason: collision with root package name */
    private String f10774c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f10775d;

    /* renamed from: e  reason: collision with root package name */
    private String f10776e;

    /* renamed from: f  reason: collision with root package name */
    private int f10777f;

    /* renamed from: g  reason: collision with root package name */
    private int f10778g;

    /* renamed from: h  reason: collision with root package name */
    private int f10779h;

    /* renamed from: i  reason: collision with root package name */
    private long f10780i;

    /* renamed from: j  reason: collision with root package name */
    private long f10781j;

    /* renamed from: k  reason: collision with root package name */
    private long f10782k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10783l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10784m;

    public static final class a implements Parcelable.Creator<MyPhoto> {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        /* renamed from: a */
        public MyPhoto createFromParcel(Parcel parcel) {
            h.d(parcel, "parcel");
            return new MyPhoto(parcel);
        }

        /* renamed from: a */
        public MyPhoto[] newArray(int i2) {
            return new MyPhoto[i2];
        }
    }

    public MyPhoto() {
        this((String) null, (Uri) null, (String) null, (Bitmap) null, (String) null, 0, 0, 0, 0, 0, 0, false, false, 8191, (f) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MyPhoto(android.os.Parcel r20) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "parcel"
            kotlin.jvm.internal.h.d(r0, r1)
            java.lang.String r3 = r20.readString()
            kotlin.jvm.internal.h.a((java.lang.Object) r3)
            java.lang.String r1 = "parcel.readString()!!"
            kotlin.jvm.internal.h.b(r3, r1)
            java.lang.Class<android.net.Uri> r2 = android.net.Uri.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r2 = r0.readParcelable(r2)
            kotlin.jvm.internal.h.a((java.lang.Object) r2)
            r4 = r2
            android.net.Uri r4 = (android.net.Uri) r4
            java.lang.String r5 = r20.readString()
            kotlin.jvm.internal.h.a((java.lang.Object) r5)
            kotlin.jvm.internal.h.b(r5, r1)
            java.lang.Class<android.graphics.Bitmap> r2 = android.graphics.Bitmap.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r2 = r0.readParcelable(r2)
            r6 = r2
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            java.lang.String r7 = r20.readString()
            kotlin.jvm.internal.h.a((java.lang.Object) r7)
            kotlin.jvm.internal.h.b(r7, r1)
            int r8 = r20.readInt()
            int r9 = r20.readInt()
            int r10 = r20.readInt()
            long r11 = r20.readLong()
            long r13 = r20.readLong()
            long r15 = r20.readLong()
            byte r1 = r20.readByte()
            r2 = 0
            byte r0 = (byte) r2
            r17 = 1
            if (r1 == r0) goto L_0x0068
            r1 = 1
            goto L_0x0069
        L_0x0068:
            r1 = 0
        L_0x0069:
            byte r2 = r20.readByte()
            if (r2 == r0) goto L_0x0072
            r18 = 1
            goto L_0x0074
        L_0x0072:
            r18 = 0
        L_0x0074:
            r2 = r19
            r17 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.MyPhoto.<init>(android.os.Parcel):void");
    }

    public MyPhoto(String str, Uri uri, String str2, Bitmap bitmap, String str3, int i2, int i3, int i4, long j2, long j3, long j4, boolean z2, boolean z3) {
        h.d(str, "name");
        h.d(uri, "uri");
        h.d(str2, GLImage.KEY_PATH);
        h.d(str3, "type");
        this.f10772a = str;
        this.f10773b = uri;
        this.f10774c = str2;
        this.f10775d = bitmap;
        this.f10776e = str3;
        this.f10777f = i2;
        this.f10778g = i3;
        this.f10779h = i4;
        this.f10780i = j2;
        this.f10781j = j3;
        this.f10782k = j4;
        this.f10783l = z2;
        this.f10784m = z3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MyPhoto(java.lang.String r18, android.net.Uri r19, java.lang.String r20, android.graphics.Bitmap r21, java.lang.String r22, int r23, int r24, int r25, long r26, long r28, long r30, boolean r32, boolean r33, int r34, kotlin.jvm.internal.f r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r18
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0018
            android.net.Uri r3 = android.net.Uri.EMPTY
            java.lang.String r4 = "Uri.EMPTY"
            kotlin.jvm.internal.h.b(r3, r4)
            goto L_0x001a
        L_0x0018:
            r3 = r19
        L_0x001a:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0020
            r4 = r2
            goto L_0x0022
        L_0x0020:
            r4 = r20
        L_0x0022:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002a
            r5 = 0
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            goto L_0x002c
        L_0x002a:
            r5 = r21
        L_0x002c:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r2 = r22
        L_0x0033:
            r6 = r0 & 32
            r7 = 0
            if (r6 == 0) goto L_0x003a
            r6 = 0
            goto L_0x003c
        L_0x003a:
            r6 = r23
        L_0x003c:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0042
            r8 = 0
            goto L_0x0044
        L_0x0042:
            r8 = r24
        L_0x0044:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x004a
            r9 = 0
            goto L_0x004c
        L_0x004a:
            r9 = r25
        L_0x004c:
            r10 = r0 & 256(0x100, float:3.59E-43)
            r11 = 0
            if (r10 == 0) goto L_0x0054
            r13 = r11
            goto L_0x0056
        L_0x0054:
            r13 = r26
        L_0x0056:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x005c
            r15 = r11
            goto L_0x005e
        L_0x005c:
            r15 = r28
        L_0x005e:
            r10 = r0 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r11 = r30
        L_0x0065:
            r10 = r0 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x006b
            r10 = 0
            goto L_0x006d
        L_0x006b:
            r10 = r32
        L_0x006d:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r7 = r33
        L_0x0074:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r2
            r24 = r6
            r25 = r8
            r26 = r9
            r27 = r13
            r29 = r15
            r31 = r11
            r33 = r10
            r34 = r7
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r31, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.MyPhoto.<init>(java.lang.String, android.net.Uri, java.lang.String, android.graphics.Bitmap, java.lang.String, int, int, int, long, long, long, boolean, boolean, int, kotlin.jvm.internal.f):void");
    }

    public final String a() {
        return this.f10774c;
    }

    public final void a(int i2) {
        this.f10777f = i2;
    }

    public final Bitmap b() {
        return this.f10775d;
    }

    public final void b(int i2) {
        this.f10778g = i2;
    }

    public final int c() {
        return this.f10777f;
    }

    public final int d() {
        return this.f10778g;
    }

    public int describeContents() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public final int e() {
        return this.f10779h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyPhoto)) {
            return false;
        }
        MyPhoto myPhoto = (MyPhoto) obj;
        return h.a((Object) this.f10772a, (Object) myPhoto.f10772a) && h.a((Object) this.f10773b, (Object) myPhoto.f10773b) && h.a((Object) this.f10774c, (Object) myPhoto.f10774c) && h.a((Object) this.f10775d, (Object) myPhoto.f10775d) && h.a((Object) this.f10776e, (Object) myPhoto.f10776e) && this.f10777f == myPhoto.f10777f && this.f10778g == myPhoto.f10778g && this.f10779h == myPhoto.f10779h && this.f10780i == myPhoto.f10780i && this.f10781j == myPhoto.f10781j && this.f10782k == myPhoto.f10782k && this.f10783l == myPhoto.f10783l && this.f10784m == myPhoto.f10784m;
    }

    public final long f() {
        return this.f10781j;
    }

    public int hashCode() {
        String str = this.f10772a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Uri uri = this.f10773b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str2 = this.f10774c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Bitmap bitmap = this.f10775d;
        int hashCode4 = (hashCode3 + (bitmap != null ? bitmap.hashCode() : 0)) * 31;
        String str3 = this.f10776e;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        long j2 = this.f10780i;
        long j3 = this.f10781j;
        long j4 = this.f10782k;
        int i3 = (((((((((((((hashCode4 + i2) * 31) + this.f10777f) * 31) + this.f10778g) * 31) + this.f10779h) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        boolean z2 = this.f10783l;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        boolean z4 = this.f10784m;
        if (!z4) {
            z3 = z4;
        }
        return i4 + (z3 ? 1 : 0);
    }

    public String toString() {
        return "MyPhoto(name=" + this.f10772a + ", uri=" + this.f10773b + ", path=" + this.f10774c + ", bitmap=" + this.f10775d + ", type=" + this.f10776e + ", width=" + this.f10777f + ", height=" + this.f10778g + ", orientation=" + this.f10779h + ", size=" + this.f10780i + ", duration=" + this.f10781j + ", time=" + this.f10782k + ", selected=" + this.f10783l + ", selectedOriginal=" + this.f10784m + ")";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
