package af;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f67a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f68b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<b> f69c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<d> f70d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f71a;

        /* renamed from: b  reason: collision with root package name */
        public final String f72b;

        /* renamed from: c  reason: collision with root package name */
        public final int f73c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f74d;

        /* renamed from: e  reason: collision with root package name */
        public final int f75e;

        /* renamed from: f  reason: collision with root package name */
        public final String f76f;

        /* renamed from: g  reason: collision with root package name */
        private final int f77g;

        public a(String str, String str2, boolean z2, int i2, String str3, int i3) {
            this.f71a = str;
            this.f72b = str2;
            this.f74d = z2;
            this.f75e = i2;
            this.f73c = a(str2);
            this.f76f = str3;
            this.f77g = i3;
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean a() {
            return this.f75e > 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0072, code lost:
            r2 = r5.f76f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r0 = 1
                if (r5 != r6) goto L_0x0004
                return r0
            L_0x0004:
                r1 = 0
                if (r6 == 0) goto L_0x008d
                java.lang.Class r2 = r5.getClass()
                java.lang.Class r3 = r6.getClass()
                if (r2 == r3) goto L_0x0013
                goto L_0x008d
            L_0x0013:
                af.f$a r6 = (af.f.a) r6
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 20
                if (r2 < r3) goto L_0x0022
                int r2 = r5.f75e
                int r3 = r6.f75e
                if (r2 == r3) goto L_0x002d
                return r1
            L_0x0022:
                boolean r2 = r5.a()
                boolean r3 = r6.a()
                if (r2 == r3) goto L_0x002d
                return r1
            L_0x002d:
                java.lang.String r2 = r5.f71a
                java.lang.String r3 = r6.f71a
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0038
                return r1
            L_0x0038:
                boolean r2 = r5.f74d
                boolean r3 = r6.f74d
                if (r2 == r3) goto L_0x003f
                return r1
            L_0x003f:
                int r2 = r5.f77g
                r3 = 2
                if (r2 != r0) goto L_0x0055
                int r2 = r6.f77g
                if (r2 != r3) goto L_0x0055
                java.lang.String r2 = r5.f76f
                if (r2 == 0) goto L_0x0055
                java.lang.String r4 = r6.f76f
                boolean r2 = r2.equals(r4)
                if (r2 != 0) goto L_0x0055
                return r1
            L_0x0055:
                int r2 = r5.f77g
                if (r2 != r3) goto L_0x006a
                int r2 = r6.f77g
                if (r2 != r0) goto L_0x006a
                java.lang.String r2 = r6.f76f
                if (r2 == 0) goto L_0x006a
                java.lang.String r3 = r5.f76f
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x006a
                return r1
            L_0x006a:
                int r2 = r5.f77g
                if (r2 == 0) goto L_0x0084
                int r3 = r6.f77g
                if (r2 != r3) goto L_0x0084
                java.lang.String r2 = r5.f76f
                if (r2 == 0) goto L_0x007f
                java.lang.String r3 = r6.f76f
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0084
                goto L_0x0083
            L_0x007f:
                java.lang.String r2 = r6.f76f
                if (r2 == 0) goto L_0x0084
            L_0x0083:
                return r1
            L_0x0084:
                int r2 = r5.f73c
                int r6 = r6.f73c
                if (r2 != r6) goto L_0x008b
                goto L_0x008c
            L_0x008b:
                r0 = 0
            L_0x008c:
                return r0
            L_0x008d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: af.f.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return (((((this.f71a.hashCode() * 31) + this.f73c) * 31) + (this.f74d ? 1231 : 1237)) * 31) + this.f75e;
        }

        public String toString() {
            return "Column{name='" + this.f71a + '\'' + ", type='" + this.f72b + '\'' + ", affinity='" + this.f73c + '\'' + ", notNull=" + this.f74d + ", primaryKeyPosition=" + this.f75e + ", defaultValue='" + this.f76f + '\'' + '}';
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f78a;

        /* renamed from: b  reason: collision with root package name */
        public final String f79b;

        /* renamed from: c  reason: collision with root package name */
        public final String f80c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f81d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f82e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f78a = str;
            this.f79b = str2;
            this.f80c = str3;
            this.f81d = Collections.unmodifiableList(list);
            this.f82e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f78a.equals(bVar.f78a) && this.f79b.equals(bVar.f79b) && this.f80c.equals(bVar.f80c) && this.f81d.equals(bVar.f81d)) {
                return this.f82e.equals(bVar.f82e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f78a.hashCode() * 31) + this.f79b.hashCode()) * 31) + this.f80c.hashCode()) * 31) + this.f81d.hashCode()) * 31) + this.f82e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f78a + '\'' + ", onDelete='" + this.f79b + '\'' + ", onUpdate='" + this.f80c + '\'' + ", columnNames=" + this.f81d + ", referenceColumnNames=" + this.f82e + '}';
        }
    }

    static class c implements Comparable<c> {

        /* renamed from: a  reason: collision with root package name */
        final int f83a;

        /* renamed from: b  reason: collision with root package name */
        final int f84b;

        /* renamed from: c  reason: collision with root package name */
        final String f85c;

        /* renamed from: d  reason: collision with root package name */
        final String f86d;

        c(int i2, int i3, String str, String str2) {
            this.f83a = i2;
            this.f84b = i3;
            this.f85c = str;
            this.f86d = str2;
        }

        /* renamed from: a */
        public int compareTo(c cVar) {
            int i2 = this.f83a - cVar.f83a;
            return i2 == 0 ? this.f84b - cVar.f84b : i2;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f87a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f88b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f89c;

        public d(String str, boolean z2, List<String> list) {
            this.f87a = str;
            this.f88b = z2;
            this.f89c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f88b == dVar.f88b && this.f89c.equals(dVar.f89c)) {
                return this.f87a.startsWith("index_") ? dVar.f87a.startsWith("index_") : this.f87a.equals(dVar.f87a);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f87a.startsWith("index_") ? -1184239155 : this.f87a.hashCode()) * 31) + (this.f88b ? 1 : 0)) * 31) + this.f89c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f87a + '\'' + ", unique=" + this.f88b + ", columns=" + this.f89c + '}';
        }
    }

    public f(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        this.f67a = str;
        this.f68b = Collections.unmodifiableMap(map);
        this.f69c = Collections.unmodifiableSet(set);
        this.f70d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    private static d a(ag.b bVar, String str, boolean z2) {
        Cursor b2 = bVar.b("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("seqno");
            int columnIndex2 = b2.getColumnIndex("cid");
            int columnIndex3 = b2.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (b2.moveToNext()) {
                        if (b2.getInt(columnIndex2) >= 0) {
                            int i2 = b2.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i2), b2.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    d dVar = new d(str, z2, arrayList);
                    b2.close();
                    return dVar;
                }
            }
            return null;
        } finally {
            b2.close();
        }
    }

    public static f a(ag.b bVar, String str) {
        return new f(str, c(bVar, str), b(bVar, str), d(bVar, str));
    }

    private static List<c> a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < count; i2++) {
            cursor.moveToPosition(i2);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<b> b(ag.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor b2 = bVar.b("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("id");
            int columnIndex2 = b2.getColumnIndex("seq");
            int columnIndex3 = b2.getColumnIndex("table");
            int columnIndex4 = b2.getColumnIndex("on_delete");
            int columnIndex5 = b2.getColumnIndex("on_update");
            List<c> a2 = a(b2);
            int count = b2.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                b2.moveToPosition(i2);
                if (b2.getInt(columnIndex2) == 0) {
                    int i3 = b2.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c next : a2) {
                        if (next.f83a == i3) {
                            arrayList.add(next.f85c);
                            arrayList2.add(next.f86d);
                        }
                    }
                    hashSet.add(new b(b2.getString(columnIndex3), b2.getString(columnIndex4), b2.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            b2.close();
        }
    }

    private static Map<String, a> c(ag.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (b2.getColumnCount() > 0) {
                int columnIndex = b2.getColumnIndex("name");
                int columnIndex2 = b2.getColumnIndex("type");
                int columnIndex3 = b2.getColumnIndex("notnull");
                int columnIndex4 = b2.getColumnIndex("pk");
                int columnIndex5 = b2.getColumnIndex("dflt_value");
                while (b2.moveToNext()) {
                    String string = b2.getString(columnIndex);
                    hashMap.put(string, new a(string, b2.getString(columnIndex2), b2.getInt(columnIndex3) != 0, b2.getInt(columnIndex4), b2.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            b2.close();
        }
    }

    private static Set<d> d(ag.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("name");
            int columnIndex2 = b2.getColumnIndex("origin");
            int columnIndex3 = b2.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    HashSet hashSet = new HashSet();
                    while (b2.moveToNext()) {
                        if ("c".equals(b2.getString(columnIndex2))) {
                            String string = b2.getString(columnIndex);
                            boolean z2 = true;
                            if (b2.getInt(columnIndex3) != 1) {
                                z2 = false;
                            }
                            d a2 = a(bVar, string, z2);
                            if (a2 == null) {
                                b2.close();
                                return null;
                            }
                            hashSet.add(a2);
                        }
                    }
                    b2.close();
                    return hashSet;
                }
            }
            return null;
        } finally {
            b2.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f67a;
        if (str == null ? fVar.f67a != null : !str.equals(fVar.f67a)) {
            return false;
        }
        Map<String, a> map = this.f68b;
        if (map == null ? fVar.f68b != null : !map.equals(fVar.f68b)) {
            return false;
        }
        Set<b> set2 = this.f69c;
        if (set2 == null ? fVar.f69c != null : !set2.equals(fVar.f69c)) {
            return false;
        }
        Set<d> set3 = this.f70d;
        if (set3 == null || (set = fVar.f70d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f67a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f68b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f69c;
        if (set != null) {
            i2 = set.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "TableInfo{name='" + this.f67a + '\'' + ", columns=" + this.f68b + ", foreignKeys=" + this.f69c + ", indices=" + this.f70d + '}';
    }
}
