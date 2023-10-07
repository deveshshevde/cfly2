package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class l {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f17847a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final Object f17848b;

        /* synthetic */ a(Object obj, aq aqVar) {
            m.a(obj);
            this.f17848b = obj;
        }

        public a a(String str, Object obj) {
            List<String> list = this.f17847a;
            m.a(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(valueOf).length());
            sb.append(str);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f17848b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f17847a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.f17847a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a a(Object obj) {
        return new a(obj, (aq) null);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
