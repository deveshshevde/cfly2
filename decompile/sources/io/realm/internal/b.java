package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Map;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f29027a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f29028b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f29029a;

        /* renamed from: b  reason: collision with root package name */
        public final RealmFieldType f29030b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29031c;

        public String toString() {
            return "ColumnDetails[" + this.f29029a + ", " + this.f29030b + ", " + this.f29031c + "]";
        }
    }

    public a a(String str) {
        return this.f29027a.get(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColumnInfo[");
        sb.append(this.f29028b);
        sb.append(",");
        Map<String, a> map = this.f29027a;
        if (map != null) {
            boolean z2 = false;
            for (Map.Entry next : map.entrySet()) {
                if (z2) {
                    sb.append(",");
                }
                sb.append((String) next.getKey());
                sb.append("->");
                sb.append(next.getValue());
                z2 = true;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
