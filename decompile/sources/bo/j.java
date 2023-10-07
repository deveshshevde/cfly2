package bo;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<i>> f5882c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f5883d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final String f5884a;

        /* renamed from: b  reason: collision with root package name */
        private static final Map<String, List<i>> f5885b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5886c = true;

        /* renamed from: d  reason: collision with root package name */
        private Map<String, List<i>> f5887d = f5885b;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5888e = true;

        static {
            String b2 = b();
            f5884a = b2;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b2)));
            }
            f5885b = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt <= 31 && charAt != 9) || charAt >= 127) {
                    charAt = '?';
                }
                sb.append(charAt);
            }
            return sb.toString();
        }

        public j a() {
            this.f5886c = true;
            return new j(this.f5887d);
        }
    }

    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final String f5889a;

        b(String str) {
            this.f5889a = str;
        }

        public String a() {
            return this.f5889a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f5889a.equals(((b) obj).f5889a);
            }
            return false;
        }

        public int hashCode() {
            return this.f5889a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f5889a + '\'' + '}';
        }
    }

    j(Map<String, List<i>> map) {
        this.f5882c = Collections.unmodifiableMap(map);
    }

    private String a(List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = list.get(i2).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f5882c.entrySet()) {
            String a2 = a((List) next.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(next.getKey(), a2);
            }
        }
        return hashMap;
    }

    public Map<String, String> a() {
        if (this.f5883d == null) {
            synchronized (this) {
                if (this.f5883d == null) {
                    this.f5883d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f5883d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f5882c.equals(((j) obj).f5882c);
        }
        return false;
    }

    public int hashCode() {
        return this.f5882c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f5882c + '}';
    }
}
