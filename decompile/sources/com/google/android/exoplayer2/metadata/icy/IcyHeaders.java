package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;

public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new Parcelable.Creator<IcyHeaders>() {
        /* renamed from: a */
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        /* renamed from: a */
        public IcyHeaders[] newArray(int i2) {
            return new IcyHeaders[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f15875a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15876b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15877c;

    /* renamed from: d  reason: collision with root package name */
    public final String f15878d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15879e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15880f;

    public IcyHeaders(int i2, String str, String str2, String str3, boolean z2, int i3) {
        a.a(i3 == -1 || i3 > 0);
        this.f15875a = i2;
        this.f15876b = str;
        this.f15877c = str2;
        this.f15878d = str3;
        this.f15879e = z2;
        this.f15880f = i3;
    }

    IcyHeaders(Parcel parcel) {
        this.f15875a = parcel.readInt();
        this.f15876b = parcel.readString();
        this.f15877c = parcel.readString();
        this.f15878d = parcel.readString();
        this.f15879e = ad.a(parcel);
        this.f15880f = parcel.readInt();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.metadata.icy.IcyHeaders a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r13) {
        /*
            java.lang.String r0 = "Invalid metadata interval: "
            java.lang.String r1 = "icy-br"
            java.lang.Object r1 = r13.get(r1)
            java.util.List r1 = (java.util.List) r1
            java.lang.String r2 = "IcyHeaders"
            r3 = -1
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x005e
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            int r6 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0041 }
            int r6 = r6 * 1000
            if (r6 <= 0) goto L_0x0021
            r1 = 1
            goto L_0x003d
        L_0x0021:
            java.lang.String r7 = "Invalid bitrate: "
            java.lang.String r8 = java.lang.String.valueOf(r1)     // Catch:{ NumberFormatException -> 0x003f }
            int r9 = r8.length()     // Catch:{ NumberFormatException -> 0x003f }
            if (r9 == 0) goto L_0x0032
            java.lang.String r7 = r7.concat(r8)     // Catch:{ NumberFormatException -> 0x003f }
            goto L_0x0038
        L_0x0032:
            java.lang.String r8 = new java.lang.String     // Catch:{ NumberFormatException -> 0x003f }
            r8.<init>(r7)     // Catch:{ NumberFormatException -> 0x003f }
            r7 = r8
        L_0x0038:
            com.google.android.exoplayer2.util.k.c(r2, r7)     // Catch:{ NumberFormatException -> 0x003f }
            r1 = 0
            r6 = -1
        L_0x003d:
            r7 = r6
            goto L_0x0060
        L_0x003f:
            goto L_0x0042
        L_0x0041:
            r6 = -1
        L_0x0042:
            java.lang.String r7 = "Invalid bitrate header: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r8 = r1.length()
            if (r8 == 0) goto L_0x0053
            java.lang.String r1 = r7.concat(r1)
            goto L_0x0058
        L_0x0053:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r7)
        L_0x0058:
            com.google.android.exoplayer2.util.k.c(r2, r1)
            r7 = r6
            r1 = 0
            goto L_0x0060
        L_0x005e:
            r1 = 0
            r7 = -1
        L_0x0060:
            java.lang.String r6 = "icy-genre"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            r8 = 0
            if (r6 == 0) goto L_0x0074
            java.lang.Object r1 = r6.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            r1 = 1
            goto L_0x0075
        L_0x0074:
            r9 = r8
        L_0x0075:
            java.lang.String r6 = "icy-name"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x0088
            java.lang.Object r1 = r6.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            r1 = 1
            goto L_0x0089
        L_0x0088:
            r10 = r8
        L_0x0089:
            java.lang.String r6 = "icy-url"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x009c
            java.lang.Object r1 = r6.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            r1 = 1
            goto L_0x009d
        L_0x009c:
            r11 = r8
        L_0x009d:
            java.lang.String r6 = "icy-pub"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x00b6
            java.lang.Object r1 = r6.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r6 = "1"
            boolean r1 = r1.equals(r6)
            r12 = r1
            r1 = 1
            goto L_0x00b7
        L_0x00b6:
            r12 = 0
        L_0x00b7:
            java.lang.String r6 = "icy-metaint"
            java.lang.Object r13 = r13.get(r6)
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L_0x0103
            java.lang.Object r13 = r13.get(r5)
            java.lang.String r13 = (java.lang.String) r13
            int r5 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x00eb }
            if (r5 <= 0) goto L_0x00cf
            r3 = r5
            goto L_0x00e7
        L_0x00cf:
            java.lang.String r4 = java.lang.String.valueOf(r13)     // Catch:{ NumberFormatException -> 0x00e9 }
            int r6 = r4.length()     // Catch:{ NumberFormatException -> 0x00e9 }
            if (r6 == 0) goto L_0x00de
            java.lang.String r4 = r0.concat(r4)     // Catch:{ NumberFormatException -> 0x00e9 }
            goto L_0x00e3
        L_0x00de:
            java.lang.String r4 = new java.lang.String     // Catch:{ NumberFormatException -> 0x00e9 }
            r4.<init>(r0)     // Catch:{ NumberFormatException -> 0x00e9 }
        L_0x00e3:
            com.google.android.exoplayer2.util.k.c(r2, r4)     // Catch:{ NumberFormatException -> 0x00e9 }
            r4 = r1
        L_0x00e7:
            r1 = r4
            goto L_0x0103
        L_0x00e9:
            r3 = r5
            goto L_0x00ec
        L_0x00eb:
        L_0x00ec:
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r4 = r13.length()
            if (r4 == 0) goto L_0x00fb
            java.lang.String r13 = r0.concat(r13)
            goto L_0x0100
        L_0x00fb:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r0)
        L_0x0100:
            com.google.android.exoplayer2.util.k.c(r2, r13)
        L_0x0103:
            if (r1 == 0) goto L_0x0111
            com.google.android.exoplayer2.metadata.icy.IcyHeaders r13 = new com.google.android.exoplayer2.metadata.icy.IcyHeaders
            r6 = r13
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r8 = r13
        L_0x0111:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.icy.IcyHeaders.a(java.util.Map):com.google.android.exoplayer2.metadata.icy.IcyHeaders");
    }

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
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
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        return this.f15875a == icyHeaders.f15875a && ad.a((Object) this.f15876b, (Object) icyHeaders.f15876b) && ad.a((Object) this.f15877c, (Object) icyHeaders.f15877c) && ad.a((Object) this.f15878d, (Object) icyHeaders.f15878d) && this.f15879e == icyHeaders.f15879e && this.f15880f == icyHeaders.f15880f;
    }

    public int hashCode() {
        int i2 = (527 + this.f15875a) * 31;
        String str = this.f15876b;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f15877c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f15878d;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return ((((hashCode2 + i3) * 31) + (this.f15879e ? 1 : 0)) * 31) + this.f15880f;
    }

    public String toString() {
        String str = this.f15877c;
        String str2 = this.f15876b;
        int i2 = this.f15875a;
        int i3 = this.f15880f;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80 + String.valueOf(str2).length());
        sb.append("IcyHeaders: name=\"");
        sb.append(str);
        sb.append("\", genre=\"");
        sb.append(str2);
        sb.append("\", bitrate=");
        sb.append(i2);
        sb.append(", metadataInterval=");
        sb.append(i3);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f15875a);
        parcel.writeString(this.f15876b);
        parcel.writeString(this.f15877c);
        parcel.writeString(this.f15878d);
        ad.a(parcel, this.f15879e);
        parcel.writeInt(this.f15880f);
    }
}
