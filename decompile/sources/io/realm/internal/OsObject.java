package io.realm.internal;

import io.realm.RealmFieldType;
import io.realm.exceptions.RealmException;
import io.realm.internal.g;
import io.realm.j;
import io.realm.k;

public class OsObject implements e {
    private static final String OBJECT_ID_COLUMN_NAME = nativeGetObjectIdColumName();
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final long nativePtr;
    private g<b> observerPairs = new g<>();

    private static class a implements g.a<b> {

        /* renamed from: a  reason: collision with root package name */
        private final String[] f28965a;

        a(String[] strArr) {
            this.f28965a = strArr;
        }

        private io.realm.c a() {
            String[] strArr = this.f28965a;
            boolean z2 = strArr == null;
            if (z2) {
                strArr = new String[0];
            }
            return new c(strArr, z2);
        }

        public void a(b bVar, Object obj) {
            bVar.a((j) obj, a());
        }
    }

    public static class b<T extends j> extends g.b<T, k<T>> {
        public b(T t2, k<T> kVar) {
            super(t2, kVar);
        }

        public void a(T t2, io.realm.c cVar) {
            ((k) this.f29041b).a(t2, cVar);
        }
    }

    private static class c implements io.realm.c {

        /* renamed from: a  reason: collision with root package name */
        final String[] f28966a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f28967b;

        c(String[] strArr, boolean z2) {
            this.f28966a = strArr;
            this.f28967b = z2;
        }
    }

    public OsObject(OsSharedRealm osSharedRealm, UncheckedRow uncheckedRow) {
        this.nativePtr = nativeCreate(osSharedRealm.getNativePtr(), uncheckedRow.getNativePtr());
        osSharedRealm.context.a(this);
    }

    public static UncheckedRow create(Table table) {
        OsSharedRealm c2 = table.c();
        return new UncheckedRow(c2.context, table, nativeCreateNewObject(c2.getNativePtr(), table.getNativePtr()));
    }

    public static long createRow(Table table) {
        return nativeCreateRow(table.c().getNativePtr(), table.getNativePtr());
    }

    public static long createRowWithPrimaryKey(Table table, long j2, Object obj) {
        Object obj2 = obj;
        RealmFieldType b2 = table.b(j2);
        OsSharedRealm c2 = table.c();
        if (b2 == RealmFieldType.STRING) {
            if (obj2 == null || (obj2 instanceof String)) {
                return nativeCreateRowWithStringPrimaryKey(c2.getNativePtr(), table.getNativePtr(), j2, (String) obj2);
            }
            throw new IllegalArgumentException("Primary key value is not a String: " + obj2);
        } else if (b2 == RealmFieldType.INTEGER) {
            return nativeCreateRowWithLongPrimaryKey(c2.getNativePtr(), table.getNativePtr(), j2, obj2 == null ? 0 : Long.parseLong(obj.toString()), obj2 == null);
        } else {
            throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + b2);
        }
    }

    public static UncheckedRow createWithPrimaryKey(Table table, Object obj) {
        long andVerifyPrimaryKeyColumnIndex = getAndVerifyPrimaryKeyColumnIndex(table);
        RealmFieldType b2 = table.b(andVerifyPrimaryKeyColumnIndex);
        OsSharedRealm c2 = table.c();
        if (b2 == RealmFieldType.STRING) {
            if (obj == null || (obj instanceof String)) {
                return new UncheckedRow(c2.context, table, nativeCreateNewObjectWithStringPrimaryKey(c2.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, (String) obj));
            }
            throw new IllegalArgumentException("Primary key value is not a String: " + obj);
        } else if (b2 == RealmFieldType.INTEGER) {
            return new UncheckedRow(c2.context, table, nativeCreateNewObjectWithLongPrimaryKey(c2.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, obj == null ? 0 : Long.parseLong(obj.toString()), obj == null));
        } else {
            throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + b2);
        }
    }

    private static long getAndVerifyPrimaryKeyColumnIndex(Table table) {
        String a2 = OsObjectStore.a(table.c(), table.e());
        if (a2 != null) {
            return table.a(a2);
        }
        throw new IllegalStateException(table.d() + " has no primary key defined.");
    }

    public static boolean isObjectIdColumn(String str) {
        return OBJECT_ID_COLUMN_NAME.equals(str);
    }

    private static native long nativeCreate(long j2, long j3);

    private static native long nativeCreateNewObject(long j2, long j3);

    private static native long nativeCreateNewObjectWithLongPrimaryKey(long j2, long j3, long j4, long j5, boolean z2);

    private static native long nativeCreateNewObjectWithStringPrimaryKey(long j2, long j3, long j4, String str);

    private static native long nativeCreateRow(long j2, long j3);

    private static native long nativeCreateRowWithLongPrimaryKey(long j2, long j3, long j4, long j5, boolean z2);

    private static native long nativeCreateRowWithStringPrimaryKey(long j2, long j3, long j4, String str);

    private static native long nativeGetFinalizerPtr();

    private static native String nativeGetObjectIdColumName();

    private native void nativeStartListening(long j2);

    private native void nativeStopListening(long j2);

    private void notifyChangeListeners(String[] strArr) {
        this.observerPairs.a(new a(strArr));
    }

    public <T extends j> void addListener(T t2, k<T> kVar) {
        if (this.observerPairs.a()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.a(new b(t2, kVar));
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public <T extends j> void removeListener(T t2) {
        this.observerPairs.a((Object) t2);
        if (this.observerPairs.a()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public <T extends j> void removeListener(T t2, k<T> kVar) {
        this.observerPairs.a(t2, kVar);
        if (this.observerPairs.a()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public void setObserverPairs(g<b> gVar) {
        if (this.observerPairs.a()) {
            this.observerPairs = gVar;
            if (!gVar.a()) {
                nativeStartListening(this.nativePtr);
                return;
            }
            return;
        }
        throw new IllegalStateException("'observerPairs' is not empty. Listeners have been added before.");
    }
}
