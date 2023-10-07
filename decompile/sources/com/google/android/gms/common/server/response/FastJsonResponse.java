package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.j;
import java.util.Map;

public abstract class FastJsonResponse {

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final a CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        protected final int f17899a;

        /* renamed from: b  reason: collision with root package name */
        protected final boolean f17900b;

        /* renamed from: c  reason: collision with root package name */
        protected final int f17901c;

        /* renamed from: d  reason: collision with root package name */
        protected final boolean f17902d;

        /* renamed from: e  reason: collision with root package name */
        protected final String f17903e;

        /* renamed from: f  reason: collision with root package name */
        protected final int f17904f;

        /* renamed from: g  reason: collision with root package name */
        protected final Class<? extends FastJsonResponse> f17905g;

        /* renamed from: h  reason: collision with root package name */
        protected final String f17906h;

        /* renamed from: i  reason: collision with root package name */
        private final int f17907i;

        /* renamed from: j  reason: collision with root package name */
        private zan f17908j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public a<I, O> f17909k;

        Field(int i2, int i3, boolean z2, int i4, boolean z3, String str, int i5, String str2, zaa zaa) {
            this.f17907i = i2;
            this.f17899a = i3;
            this.f17900b = z2;
            this.f17901c = i4;
            this.f17902d = z3;
            this.f17903e = str;
            this.f17904f = i5;
            if (str2 == null) {
                this.f17905g = null;
                this.f17906h = null;
            } else {
                this.f17905g = SafeParcelResponse.class;
                this.f17906h = str2;
            }
            if (zaa == null) {
                this.f17909k = null;
            } else {
                this.f17909k = zaa.a();
            }
        }

        public int a() {
            return this.f17904f;
        }

        public final I a(O o2) {
            m.a(this.f17909k);
            return this.f17909k.a(o2);
        }

        public final void a(zan zan) {
            this.f17908j = zan;
        }

        /* access modifiers changed from: package-private */
        public final zaa b() {
            a<I, O> aVar = this.f17909k;
            if (aVar == null) {
                return null;
            }
            return zaa.a(aVar);
        }

        /* access modifiers changed from: package-private */
        public final String c() {
            String str = this.f17906h;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final Map<String, Field<?, ?>> d() {
            m.a(this.f17906h);
            m.a(this.f17908j);
            return (Map) m.a(this.f17908j.a(this.f17906h));
        }

        public final boolean e() {
            return this.f17909k != null;
        }

        public final String toString() {
            l.a a2 = l.a((Object) this).a("versionCode", Integer.valueOf(this.f17907i)).a("typeIn", Integer.valueOf(this.f17899a)).a("typeInArray", Boolean.valueOf(this.f17900b)).a("typeOut", Integer.valueOf(this.f17901c)).a("typeOutArray", Boolean.valueOf(this.f17902d)).a("outputFieldName", this.f17903e).a("safeParcelFieldId", Integer.valueOf(this.f17904f)).a("concreteTypeName", c());
            Class<? extends FastJsonResponse> cls = this.f17905g;
            if (cls != null) {
                a2.a("concreteType.class", cls.getCanonicalName());
            }
            a<I, O> aVar = this.f17909k;
            if (aVar != null) {
                a2.a("converterName", aVar.getClass().getCanonicalName());
            }
            return a2.toString();
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, 1, this.f17907i);
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, 2, this.f17899a);
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, 3, this.f17900b);
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, 4, this.f17901c);
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, 5, this.f17902d);
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, 6, this.f17903e, false);
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, 7, a());
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, 8, c(), false);
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, 9, (Parcelable) b(), i2, false);
            com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2);
        }
    }

    public interface a<I, O> {
        I a(O o2);
    }

    protected static final <O, I> I a(Field<I, O> field, Object obj) {
        return field.f17909k != null ? field.a(obj) : obj;
    }

    private static final void a(StringBuilder sb, Field field, Object obj) {
        String fastJsonResponse;
        int i2 = field.f17899a;
        if (i2 == 11) {
            Class<? extends FastJsonResponse> cls = field.f17905g;
            m.a(cls);
            fastJsonResponse = ((FastJsonResponse) cls.cast(obj)).toString();
        } else if (i2 == 7) {
            fastJsonResponse = "\"";
            sb.append(fastJsonResponse);
            sb.append(j.a((String) obj));
        } else {
            sb.append(obj);
            return;
        }
        sb.append(fastJsonResponse);
    }

    /* access modifiers changed from: protected */
    public Object a(Field field) {
        String str = field.f17903e;
        if (field.f17905g == null) {
            return a(str);
        }
        m.b(a(str) == null, "Concrete field shouldn't be value object: %s", field.f17903e);
        boolean z2 = field.f17902d;
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(substring);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object a(String str);

    public abstract Map<String, Field<?, ?>> a();

    /* access modifiers changed from: protected */
    public boolean b(Field field) {
        UnsupportedOperationException unsupportedOperationException;
        if (field.f17901c != 11) {
            return b(field.f17903e);
        }
        boolean z2 = field.f17902d;
        String str = field.f17903e;
        if (z2) {
            throw unsupportedOperationException;
        }
        unsupportedOperationException = new UnsupportedOperationException("Concrete types not supported");
        throw unsupportedOperationException;
    }

    /* access modifiers changed from: protected */
    public abstract boolean b(String str);

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0088, code lost:
        r1.append(r3);
        r1.append("\"");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r9 = this;
            java.util.Map r0 = r9.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 100
            r1.<init>(r2)
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0013:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00aa
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.get(r3)
            com.google.android.gms.common.server.response.FastJsonResponse$Field r4 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r4
            boolean r5 = r9.b((com.google.android.gms.common.server.response.FastJsonResponse.Field) r4)
            if (r5 == 0) goto L_0x0013
            java.lang.Object r5 = r9.a((com.google.android.gms.common.server.response.FastJsonResponse.Field) r4)
            java.lang.Object r5 = a(r4, r5)
            int r6 = r1.length()
            java.lang.String r7 = ","
            if (r6 != 0) goto L_0x0041
            java.lang.String r6 = "{"
            r1.append(r6)
            goto L_0x0044
        L_0x0041:
            r1.append(r7)
        L_0x0044:
            java.lang.String r6 = "\""
            r1.append(r6)
            r1.append(r3)
            java.lang.String r3 = "\":"
            r1.append(r3)
            if (r5 != 0) goto L_0x0059
            java.lang.String r3 = "null"
        L_0x0055:
            r1.append(r3)
            goto L_0x0013
        L_0x0059:
            int r3 = r4.f17901c
            switch(r3) {
                case 8: goto L_0x007f;
                case 9: goto L_0x0075;
                case 10: goto L_0x006f;
                default: goto L_0x005e;
            }
        L_0x005e:
            boolean r3 = r4.f17900b
            if (r3 == 0) goto L_0x00a5
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.String r3 = "["
            r1.append(r3)
            int r3 = r5.size()
            r6 = 0
            goto L_0x008f
        L_0x006f:
            java.util.HashMap r5 = (java.util.HashMap) r5
            com.google.android.gms.common.util.k.a(r1, r5)
            goto L_0x0013
        L_0x0075:
            r1.append(r6)
            byte[] r5 = (byte[]) r5
            java.lang.String r3 = com.google.android.gms.common.util.b.b(r5)
            goto L_0x0088
        L_0x007f:
            r1.append(r6)
            byte[] r5 = (byte[]) r5
            java.lang.String r3 = com.google.android.gms.common.util.b.a(r5)
        L_0x0088:
            r1.append(r3)
            r1.append(r6)
            goto L_0x0013
        L_0x008f:
            if (r6 >= r3) goto L_0x00a2
            if (r6 <= 0) goto L_0x0096
            r1.append(r7)
        L_0x0096:
            java.lang.Object r8 = r5.get(r6)
            if (r8 == 0) goto L_0x009f
            a(r1, r4, r8)
        L_0x009f:
            int r6 = r6 + 1
            goto L_0x008f
        L_0x00a2:
            java.lang.String r3 = "]"
            goto L_0x0055
        L_0x00a5:
            a(r1, r4, r5)
            goto L_0x0013
        L_0x00aa:
            int r0 = r1.length()
            if (r0 <= 0) goto L_0x00b3
            java.lang.String r0 = "}"
            goto L_0x00b5
        L_0x00b3:
            java.lang.String r0 = "{}"
        L_0x00b5:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastJsonResponse.toString():java.lang.String");
    }
}
