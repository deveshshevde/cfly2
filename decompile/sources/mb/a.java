package mb;

import io.realm.RealmFieldType;
import io.realm.internal.b;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import mb.c;

class a extends c {

    /* renamed from: f  reason: collision with root package name */
    private final c.a f31075f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31076g;

    a(c.a aVar, String str, String str2, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str2, set, set2);
        this.f31076g = str;
        this.f31075f = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(List<String> list) {
        int size = list.size();
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        String str = null;
        RealmFieldType realmFieldType = null;
        String str2 = this.f31076g;
        int i2 = 0;
        while (i2 < size) {
            str = list.get(i2);
            if (str == null || str.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            b a2 = this.f31075f.a(str2);
            if (a2 != null) {
                b.a a3 = a2.a(str);
                if (a3 != null) {
                    RealmFieldType realmFieldType2 = a3.f29030b;
                    if (i2 < size - 1) {
                        a(str2, str, realmFieldType2);
                        str2 = a3.f29031c;
                    }
                    jArr[i2] = a3.f29029a;
                    jArr2[i2] = realmFieldType2 != RealmFieldType.LINKING_OBJECTS ? 0 : this.f31075f.b(a3.f29031c);
                    i2++;
                    realmFieldType = realmFieldType2;
                } else {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in class '%s'.", new Object[]{str, str2}));
                }
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: class '%s' not found in this schema.", new Object[]{str2}));
            }
        }
        a(str2, str, realmFieldType, jArr, jArr2);
    }
}
