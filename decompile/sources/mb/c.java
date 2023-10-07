package mb;

import io.realm.RealmFieldType;
import io.realm.internal.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<RealmFieldType> f31078a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<RealmFieldType> f31079b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<RealmFieldType> f31080c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<RealmFieldType> f31081d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<RealmFieldType> f31082e = Collections.emptySet();

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f31083f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<RealmFieldType> f31084g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<RealmFieldType> f31085h;

    /* renamed from: i  reason: collision with root package name */
    private String f31086i;

    /* renamed from: j  reason: collision with root package name */
    private RealmFieldType f31087j;

    /* renamed from: k  reason: collision with root package name */
    private long[] f31088k;

    /* renamed from: l  reason: collision with root package name */
    private long[] f31089l;

    public interface a {
        b a(String str);

        boolean a();

        long b(String str);
    }

    static {
        HashSet hashSet = new HashSet(3);
        hashSet.add(RealmFieldType.OBJECT);
        hashSet.add(RealmFieldType.LIST);
        hashSet.add(RealmFieldType.LINKING_OBJECTS);
        f31078a = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(RealmFieldType.OBJECT);
        hashSet2.add(RealmFieldType.LIST);
        f31079b = Collections.unmodifiableSet(hashSet2);
        HashSet hashSet3 = new HashSet(1);
        hashSet3.add(RealmFieldType.LIST);
        f31080c = Collections.unmodifiableSet(hashSet3);
        HashSet hashSet4 = new HashSet(1);
        hashSet4.add(RealmFieldType.OBJECT);
        f31081d = Collections.unmodifiableSet(hashSet4);
    }

    protected c(String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        List<String> a2 = a(str);
        this.f31083f = a2;
        if (a2.size() > 0) {
            this.f31084g = set;
            this.f31085h = set2;
            return;
        }
        throw new IllegalArgumentException("Invalid query: Empty field descriptor");
    }

    private List<String> a(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Invalid query: field name is empty");
        } else if (!str.endsWith(".")) {
            return Arrays.asList(str.split("\\."));
        } else {
            throw new IllegalArgumentException("Invalid query: field name must not end with a period ('.')");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: mb.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: mb.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: mb.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: mb.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static mb.c a(mb.c.a r7, io.realm.internal.Table r8, java.lang.String r9, java.util.Set<io.realm.RealmFieldType> r10, java.util.Set<io.realm.RealmFieldType> r11) {
        /*
            if (r7 == 0) goto L_0x001d
            boolean r0 = r7.a()
            if (r0 != 0) goto L_0x0009
            goto L_0x001d
        L_0x0009:
            mb.a r0 = new mb.a
            java.lang.String r3 = r8.e()
            if (r10 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            java.util.Set<io.realm.RealmFieldType> r10 = f31078a
        L_0x0014:
            r5 = r10
            r1 = r0
            r2 = r7
            r4 = r9
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0027
        L_0x001d:
            mb.b r0 = new mb.b
            if (r10 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            java.util.Set<io.realm.RealmFieldType> r10 = f31079b
        L_0x0024:
            r0.<init>(r8, r9, r10, r11)
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.c.a(mb.c$a, io.realm.internal.Table, java.lang.String, java.util.Set, java.util.Set):mb.c");
    }

    private void a(String str, String str2, RealmFieldType realmFieldType, Set<RealmFieldType> set) {
        if (!set.contains(realmFieldType)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' in class '%s' is of invalid type '%s'.", new Object[]{str2, str, realmFieldType.toString()}));
        }
    }

    private void d() {
        if (this.f31087j == null) {
            a(this.f31083f);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, RealmFieldType realmFieldType) {
        a(str, str2, realmFieldType, this.f31084g);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, RealmFieldType realmFieldType, long[] jArr, long[] jArr2) {
        Set<RealmFieldType> set = this.f31085h;
        if (set != null && set.size() > 0) {
            a(str, str2, realmFieldType, this.f31085h);
        }
        this.f31086i = str2;
        this.f31087j = realmFieldType;
        this.f31088k = jArr;
        this.f31089l = jArr2;
    }

    /* access modifiers changed from: protected */
    public abstract void a(List<String> list);

    public final long[] a() {
        d();
        long[] jArr = this.f31088k;
        return Arrays.copyOf(jArr, jArr.length);
    }

    public final String b() {
        d();
        return this.f31086i;
    }

    public final RealmFieldType c() {
        d();
        return this.f31087j;
    }
}
