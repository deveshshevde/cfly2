package mb;

import io.realm.RealmFieldType;
import io.realm.internal.Table;
import java.util.List;
import java.util.Locale;
import java.util.Set;

class b extends c {

    /* renamed from: f  reason: collision with root package name */
    private final Table f31077f;

    b(Table table, String str, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        super(str, set, set2);
        this.f31077f = table;
    }

    /* access modifiers changed from: protected */
    public void a(List<String> list) {
        int size = list.size();
        long[] jArr = new long[size];
        Table table = this.f31077f;
        String str = null;
        String str2 = null;
        RealmFieldType realmFieldType = null;
        int i2 = 0;
        while (i2 < size) {
            str2 = list.get(i2);
            if (str2 == null || str2.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            str = table.e();
            long a2 = table.a(str2);
            if (a2 >= 0) {
                realmFieldType = table.b(a2);
                if (i2 < size - 1) {
                    a(str, str2, realmFieldType);
                    table = table.c(a2);
                }
                jArr[i2] = a2;
                i2++;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in table '%s'.", new Object[]{str2, str}));
            }
        }
        a(str, str2, realmFieldType, jArr, new long[size]);
    }
}
