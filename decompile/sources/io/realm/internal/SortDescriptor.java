package io.realm.internal;

import io.realm.RealmFieldType;
import io.realm.Sort;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import mb.c;

public class SortDescriptor {
    static final Set<RealmFieldType> DISTINCT_VALID_FIELD_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new RealmFieldType[]{RealmFieldType.BOOLEAN, RealmFieldType.INTEGER, RealmFieldType.STRING, RealmFieldType.DATE})));
    static final Set<RealmFieldType> SORT_VALID_FIELD_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new RealmFieldType[]{RealmFieldType.BOOLEAN, RealmFieldType.INTEGER, RealmFieldType.FLOAT, RealmFieldType.DOUBLE, RealmFieldType.STRING, RealmFieldType.DATE})));
    private final boolean[] ascendings;
    private final long[][] columnIndices;
    private final Table table;

    private SortDescriptor(Table table2, long[][] jArr, Sort[] sortArr) {
        this.table = table2;
        this.columnIndices = jArr;
        if (sortArr != null) {
            this.ascendings = new boolean[sortArr.length];
            for (int i2 = 0; i2 < sortArr.length; i2++) {
                this.ascendings[i2] = sortArr[i2].a();
            }
            return;
        }
        this.ascendings = null;
    }

    private static void checkFieldType(c cVar, Set<RealmFieldType> set, String str, String str2) {
        if (!set.contains(cVar.c())) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s on '%s' field '%s' in '%s'.", new Object[]{str, cVar.c(), cVar.b(), str2}));
        }
    }

    private static SortDescriptor getInstance(c.a aVar, Table table2, String[] strArr, Sort[] sortArr, Set<RealmFieldType> set, Set<RealmFieldType> set2, String str) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("You must provide at least one field name.");
        }
        long[][] jArr = new long[strArr.length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            c a2 = c.a(aVar, table2, strArr[i2], set, (Set<RealmFieldType>) null);
            checkFieldType(a2, set2, str, strArr[i2]);
            jArr[i2] = a2.a();
        }
        return new SortDescriptor(table2, jArr, sortArr);
    }

    public static SortDescriptor getInstanceForDistinct(c.a aVar, Table table2, String str) {
        return getInstanceForDistinct(aVar, table2, new String[]{str});
    }

    public static SortDescriptor getInstanceForDistinct(c.a aVar, Table table2, String[] strArr) {
        return getInstance(aVar, table2, strArr, (Sort[]) null, c.f31082e, DISTINCT_VALID_FIELD_TYPES, "Distinct is not supported");
    }

    public static SortDescriptor getInstanceForSort(c.a aVar, Table table2, String str, Sort sort) {
        return getInstanceForSort(aVar, table2, new String[]{str}, new Sort[]{sort});
    }

    public static SortDescriptor getInstanceForSort(c.a aVar, Table table2, String[] strArr, Sort[] sortArr) {
        if (sortArr == null || sortArr.length == 0) {
            throw new IllegalArgumentException("You must provide at least one sort order.");
        } else if (strArr.length == sortArr.length) {
            return getInstance(aVar, table2, strArr, sortArr, c.f31081d, SORT_VALID_FIELD_TYPES, "Sort is not supported");
        } else {
            throw new IllegalArgumentException("Number of fields and sort orders do not match.");
        }
    }

    private long getTablePtr() {
        return this.table.getNativePtr();
    }

    static SortDescriptor getTestInstance(Table table2, long[] jArr) {
        return new SortDescriptor(table2, new long[][]{jArr}, (Sort[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean[] getAscendings() {
        return this.ascendings;
    }

    /* access modifiers changed from: package-private */
    public long[][] getColumnIndices() {
        return this.columnIndices;
    }
}
