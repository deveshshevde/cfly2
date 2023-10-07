package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.b;
import com.google.android.gms.common.util.j;
import com.google.android.gms.common.util.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f17910a;

    /* renamed from: b  reason: collision with root package name */
    private final Parcel f17911b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17912c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final zan f17913d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17914e;

    /* renamed from: f  reason: collision with root package name */
    private int f17915f;

    /* renamed from: g  reason: collision with root package name */
    private int f17916g;

    SafeParcelResponse(int i2, Parcel parcel, zan zan) {
        this.f17910a = i2;
        this.f17911b = (Parcel) m.a(parcel);
        this.f17913d = zan;
        this.f17914e = zan == null ? null : zan.a();
        this.f17915f = 2;
    }

    private static final void a(StringBuilder sb, int i2, Object obj) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(j.a(m.a(obj).toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(b.a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(b.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                k.a(sb, (HashMap) m.a(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    private static final void a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.f17900b) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                a(sb, field.f17899a, arrayList.get(i2));
            }
            sb.append("]");
            return;
        }
        a(sb, field.f17899a, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0109, code lost:
        r3 = a(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010d, code lost:
        a(r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0216, code lost:
        r11.append(r3);
        r11.append("\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x024b, code lost:
        r11.append(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.StringBuilder r11, java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>> r12, android.os.Parcel r13) {
        /*
            r10 = this;
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x000d:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r12.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r2 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r2
            int r2 = r2.a()
            r0.put(r2, r1)
            goto L_0x000d
        L_0x0027:
            r12 = 123(0x7b, float:1.72E-43)
            r11.append(r12)
            int r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.b(r13)
            r1 = 0
            r2 = 1
            r3 = 0
        L_0x0033:
            int r4 = r13.dataPosition()
            if (r4 >= r12) goto L_0x0259
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.a((android.os.Parcel) r13)
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.a((int) r4)
            java.lang.Object r5 = r0.get(r5)
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            if (r5 == 0) goto L_0x0033
            java.lang.String r6 = ","
            if (r3 == 0) goto L_0x0050
            r11.append(r6)
        L_0x0050:
            java.lang.Object r3 = r5.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r5.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r5 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r5
            java.lang.String r7 = "\""
            r11.append(r7)
            r11.append(r3)
            java.lang.String r3 = "\":"
            r11.append(r3)
            boolean r3 = r5.e()
            if (r3 == 0) goto L_0x0113
            int r3 = r5.f17901c
            switch(r3) {
                case 0: goto L_0x0101;
                case 1: goto L_0x00fc;
                case 2: goto L_0x00f3;
                case 3: goto L_0x00ea;
                case 4: goto L_0x00e1;
                case 5: goto L_0x00dc;
                case 6: goto L_0x00d3;
                case 7: goto L_0x00ce;
                case 8: goto L_0x00c5;
                case 9: goto L_0x00c5;
                case 10: goto L_0x0095;
                case 11: goto L_0x008d;
                default: goto L_0x0074;
            }
        L_0x0074:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r13 = 36
            r12.<init>(r13)
            java.lang.String r13 = "Unknown field out type = "
            r12.append(r13)
            r12.append(r3)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x008d:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Method does not accept concrete type."
            r11.<init>(r12)
            throw r11
        L_0x0095:
            android.os.Bundle r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.g(r13, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.Set r6 = r3.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x00a6:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00c0
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = r3.getString(r7)
            java.lang.Object r8 = com.google.android.gms.common.internal.m.a(r8)
            java.lang.String r8 = (java.lang.String) r8
            r4.put(r7, r8)
            goto L_0x00a6
        L_0x00c0:
            java.lang.Object r3 = a(r5, r4)
            goto L_0x010d
        L_0x00c5:
            byte[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.t(r13, r4)
            java.lang.Object r3 = a(r5, r3)
            goto L_0x010d
        L_0x00ce:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.l(r13, r4)
            goto L_0x0109
        L_0x00d3:
            boolean r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.s(r13, r4)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x0109
        L_0x00dc:
            java.math.BigDecimal r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.m(r13, r4)
            goto L_0x0109
        L_0x00e1:
            double r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.b(r13, r4)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            goto L_0x0109
        L_0x00ea:
            float r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.c(r13, r4)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x0109
        L_0x00f3:
            long r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.f(r13, r4)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            goto L_0x0109
        L_0x00fc:
            java.math.BigInteger r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r4)
            goto L_0x0109
        L_0x0101:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.d(r13, r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0109:
            java.lang.Object r3 = a(r5, r3)
        L_0x010d:
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
        L_0x0110:
            r3 = 1
            goto L_0x0033
        L_0x0113:
            boolean r3 = r5.f17902d
            if (r3 == 0) goto L_0x0195
            java.lang.String r3 = "["
            r11.append(r3)
            int r3 = r5.f17901c
            switch(r3) {
                case 0: goto L_0x0187;
                case 1: goto L_0x017f;
                case 2: goto L_0x0177;
                case 3: goto L_0x016f;
                case 4: goto L_0x0167;
                case 5: goto L_0x015f;
                case 6: goto L_0x0157;
                case 7: goto L_0x014f;
                case 8: goto L_0x0147;
                case 9: goto L_0x0147;
                case 10: goto L_0x0147;
                case 11: goto L_0x0129;
                default: goto L_0x0121;
            }
        L_0x0121:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Unknown field type out."
            r11.<init>(r12)
            throw r11
        L_0x0129:
            android.os.Parcel[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.y(r13, r4)
            int r4 = r3.length
            r7 = 0
        L_0x012f:
            if (r7 >= r4) goto L_0x018e
            if (r7 <= 0) goto L_0x0136
            r11.append(r6)
        L_0x0136:
            r8 = r3[r7]
            r8.setDataPosition(r1)
            java.util.Map r8 = r5.d()
            r9 = r3[r7]
            r10.a((java.lang.StringBuilder) r11, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r8, (android.os.Parcel) r9)
            int r7 = r7 + 1
            goto L_0x012f
        L_0x0147:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.String r12 = "List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported"
            r11.<init>(r12)
            throw r11
        L_0x014f:
            java.lang.String[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.z(r13, r4)
            com.google.android.gms.common.util.a.a((java.lang.StringBuilder) r11, (java.lang.String[]) r3)
            goto L_0x018e
        L_0x0157:
            boolean[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.C(r13, r4)
            com.google.android.gms.common.util.a.a((java.lang.StringBuilder) r11, (boolean[]) r3)
            goto L_0x018e
        L_0x015f:
            java.math.BigDecimal[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.A(r13, r4)
            com.google.android.gms.common.util.a.a((java.lang.StringBuilder) r11, (T[]) r3)
            goto L_0x018e
        L_0x0167:
            double[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.u(r13, r4)
            com.google.android.gms.common.util.a.a((java.lang.StringBuilder) r11, (double[]) r3)
            goto L_0x018e
        L_0x016f:
            float[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.v(r13, r4)
            com.google.android.gms.common.util.a.a((java.lang.StringBuilder) r11, (float[]) r3)
            goto L_0x018e
        L_0x0177:
            long[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.x(r13, r4)
            com.google.android.gms.common.util.a.a((java.lang.StringBuilder) r11, (long[]) r3)
            goto L_0x018e
        L_0x017f:
            java.math.BigInteger[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.B(r13, r4)
            com.google.android.gms.common.util.a.a((java.lang.StringBuilder) r11, (T[]) r3)
            goto L_0x018e
        L_0x0187:
            int[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.w(r13, r4)
            com.google.android.gms.common.util.a.a((java.lang.StringBuilder) r11, (int[]) r3)
        L_0x018e:
            java.lang.String r3 = "]"
        L_0x0190:
            r11.append(r3)
            goto L_0x0110
        L_0x0195:
            int r3 = r5.f17901c
            switch(r3) {
                case 0: goto L_0x0250;
                case 1: goto L_0x0247;
                case 2: goto L_0x023e;
                case 3: goto L_0x0235;
                case 4: goto L_0x022c;
                case 5: goto L_0x0227;
                case 6: goto L_0x021e;
                case 7: goto L_0x020b;
                case 8: goto L_0x01ff;
                case 9: goto L_0x01f3;
                case 10: goto L_0x01b2;
                case 11: goto L_0x01a2;
                default: goto L_0x019a;
            }
        L_0x019a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Unknown field type out"
            r11.<init>(r12)
            throw r11
        L_0x01a2:
            android.os.Parcel r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.i(r13, r4)
            r3.setDataPosition(r1)
            java.util.Map r4 = r5.d()
            r10.a((java.lang.StringBuilder) r11, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r4, (android.os.Parcel) r3)
            goto L_0x0110
        L_0x01b2:
            android.os.Bundle r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.g(r13, r4)
            java.util.Set r4 = r3.keySet()
            java.lang.String r5 = "{"
            r11.append(r5)
            java.util.Iterator r4 = r4.iterator()
            r5 = 1
        L_0x01c4:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x01f0
            java.lang.Object r8 = r4.next()
            java.lang.String r8 = (java.lang.String) r8
            if (r5 != 0) goto L_0x01d5
            r11.append(r6)
        L_0x01d5:
            r11.append(r7)
            r11.append(r8)
            java.lang.String r5 = "\":\""
            r11.append(r5)
            java.lang.String r5 = r3.getString(r8)
            java.lang.String r5 = com.google.android.gms.common.util.j.a(r5)
            r11.append(r5)
            r11.append(r7)
            r5 = 0
            goto L_0x01c4
        L_0x01f0:
            java.lang.String r3 = "}"
            goto L_0x0190
        L_0x01f3:
            byte[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.t(r13, r4)
            r11.append(r7)
            java.lang.String r3 = com.google.android.gms.common.util.b.b(r3)
            goto L_0x0216
        L_0x01ff:
            byte[] r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.t(r13, r4)
            r11.append(r7)
            java.lang.String r3 = com.google.android.gms.common.util.b.a(r3)
            goto L_0x0216
        L_0x020b:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.l(r13, r4)
            r11.append(r7)
            java.lang.String r3 = com.google.android.gms.common.util.j.a(r3)
        L_0x0216:
            r11.append(r3)
            r11.append(r7)
            goto L_0x0110
        L_0x021e:
            boolean r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.s(r13, r4)
            r11.append(r3)
            goto L_0x0110
        L_0x0227:
            java.math.BigDecimal r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.m(r13, r4)
            goto L_0x024b
        L_0x022c:
            double r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.b(r13, r4)
            r11.append(r3)
            goto L_0x0110
        L_0x0235:
            float r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.c(r13, r4)
            r11.append(r3)
            goto L_0x0110
        L_0x023e:
            long r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.f(r13, r4)
            r11.append(r3)
            goto L_0x0110
        L_0x0247:
            java.math.BigInteger r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r4)
        L_0x024b:
            r11.append(r3)
            goto L_0x0110
        L_0x0250:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.d(r13, r4)
            r11.append(r3)
            goto L_0x0110
        L_0x0259:
            int r0 = r13.dataPosition()
            if (r0 != r12) goto L_0x0265
            r12 = 125(0x7d, float:1.75E-43)
            r11.append(r12)
            return
        L_0x0265:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r11 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 37
            r0.<init>(r1)
            java.lang.String r1 = "Overread allowed size end="
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r11.<init>(r12, r13)
            goto L_0x027f
        L_0x027e:
            throw r11
        L_0x027f:
            goto L_0x027e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.a(java.lang.StringBuilder, java.util.Map, android.os.Parcel):void");
    }

    public final Object a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> a() {
        zan zan = this.f17913d;
        if (zan == null) {
            return null;
        }
        return zan.a((String) m.a(this.f17914e));
    }

    public final Parcel b() {
        int i2 = this.f17915f;
        if (i2 != 0) {
            if (i2 == 1) {
                a.a(this.f17911b, this.f17916g);
            }
            return this.f17911b;
        }
        int a2 = a.a(this.f17911b);
        this.f17916g = a2;
        a.a(this.f17911b, a2);
        this.f17915f = 2;
        return this.f17911b;
    }

    public final boolean b(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final String toString() {
        m.a(this.f17913d, (Object) "Cannot convert to JSON on client side.");
        Parcel b2 = b();
        b2.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        a(sb, (Map<String, FastJsonResponse.Field<?, ?>>) (Map) m.a(this.f17913d.a((String) m.a(this.f17914e))), b2);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17910a);
        a.a(parcel, 2, b(), false);
        a.a(parcel, 3, (Parcelable) this.f17912c != 0 ? this.f17913d : null, i2, false);
        a.a(parcel, a2);
    }
}
