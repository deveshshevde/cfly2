package io.realm.internal;

import io.realm.exceptions.RealmException;
import io.realm.h;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.OsResults;
import io.realm.internal.android.AndroidRealmNotifier;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class OsSharedRealm implements e, Closeable {
    public static final byte FILE_EXCEPTION_INCOMPATIBLE_SYNC_FILE = 7;
    public static final byte FILE_EXCEPTION_KIND_ACCESS_ERROR = 0;
    public static final byte FILE_EXCEPTION_KIND_BAD_HISTORY = 1;
    public static final byte FILE_EXCEPTION_KIND_EXISTS = 3;
    public static final byte FILE_EXCEPTION_KIND_FORMAT_UPGRADE_REQUIRED = 6;
    public static final byte FILE_EXCEPTION_KIND_INCOMPATIBLE_LOCK_FILE = 5;
    public static final byte FILE_EXCEPTION_KIND_NOT_FOUND = 4;
    public static final byte FILE_EXCEPTION_KIND_PERMISSION_DENIED = 2;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private static volatile File temporaryDirectory;
    public final a capabilities;
    final d context;
    final List<WeakReference<OsResults.a>> iterators = new ArrayList();
    private final long nativePtr;
    private final OsRealmConfig osRealmConfig;
    private final List<WeakReference<h>> pendingRows = new CopyOnWriteArrayList();
    public final RealmNotifier realmNotifier;
    private final OsSchemaInfo schemaInfo;

    public interface InitializationCallback {
        void onInit(OsSharedRealm osSharedRealm);
    }

    public interface MigrationCallback {
        void onMigrationNeeded(OsSharedRealm osSharedRealm, long j2, long j3);
    }

    public static abstract class PartialSyncCallback {
        /* access modifiers changed from: private */
        public final String className;

        protected PartialSyncCallback(String str) {
            this.className = str;
        }

        public abstract void onError(RealmException realmException);

        public abstract void onSuccess(OsResults osResults);
    }

    public interface SchemaChangedCallback {
        void onSchemaChanged();
    }

    public static class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public final long f29006a;

        /* renamed from: b  reason: collision with root package name */
        public final long f29007b;

        a(long j2, long j3) {
            this.f29006a = j2;
            this.f29007b = j3;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            if (aVar != null) {
                long j2 = this.f29006a;
                long j3 = aVar.f29006a;
                if (j2 > j3) {
                    return 1;
                }
                return j2 < j3 ? -1 : 0;
            }
            throw new IllegalArgumentException("Version cannot be compared to a null value.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f29006a == aVar.f29006a && this.f29007b == aVar.f29007b;
        }

        public int hashCode() {
            long j2 = this.f29006a;
            long j3 = this.f29007b;
            return (((super.hashCode() * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        public String toString() {
            return "VersionID{version=" + this.f29006a + ", index=" + this.f29007b + '}';
        }
    }

    private OsSharedRealm(long j2, OsRealmConfig osRealmConfig2) {
        this.nativePtr = j2;
        this.osRealmConfig = osRealmConfig2;
        this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(j2), this);
        d b2 = osRealmConfig2.b();
        this.context = b2;
        b2.a(this);
        this.capabilities = new io.realm.internal.android.a();
        this.realmNotifier = null;
        nativeSetAutoRefresh(j2, false);
    }

    private OsSharedRealm(OsRealmConfig osRealmConfig2) {
        io.realm.internal.android.a aVar = new io.realm.internal.android.a();
        AndroidRealmNotifier androidRealmNotifier = new AndroidRealmNotifier(this, aVar);
        long nativeGetSharedRealm = nativeGetSharedRealm(osRealmConfig2.getNativePtr(), androidRealmNotifier);
        this.nativePtr = nativeGetSharedRealm;
        this.osRealmConfig = osRealmConfig2;
        this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(nativeGetSharedRealm), this);
        d b2 = osRealmConfig2.b();
        this.context = b2;
        b2.a(this);
        this.capabilities = aVar;
        this.realmNotifier = androidRealmNotifier;
        nativeSetAutoRefresh(nativeGetSharedRealm, aVar.a());
    }

    private void detachIterators() {
        for (WeakReference<OsResults.a> weakReference : this.iterators) {
            OsResults.a aVar = (OsResults.a) weakReference.get();
            if (aVar != null) {
                aVar.a();
            }
        }
        this.iterators.clear();
    }

    private void executePendingRowQueries() {
        for (WeakReference<h> weakReference : this.pendingRows) {
            h hVar = (h) weakReference.get();
            if (hVar != null) {
                hVar.a();
            }
        }
        this.pendingRows.clear();
    }

    public static OsSharedRealm getInstance(h hVar) {
        return getInstance(new OsRealmConfig.a(hVar));
    }

    public static OsSharedRealm getInstance(OsRealmConfig.a aVar) {
        OsRealmConfig a2 = aVar.a();
        f.a().a(a2);
        return new OsSharedRealm(a2);
    }

    public static File getTemporaryDirectory() {
        return temporaryDirectory;
    }

    public static void initialize(File file) {
        if (temporaryDirectory == null) {
            String absolutePath = file.getAbsolutePath();
            if (file.isDirectory() || file.mkdirs() || file.isDirectory()) {
                if (!absolutePath.endsWith("/")) {
                    absolutePath = absolutePath + "/";
                }
                nativeInit(absolutePath);
                temporaryDirectory = file;
                return;
            }
            throw new IOException("failed to create temporary directory: " + absolutePath);
        }
    }

    private static native void nativeBeginTransaction(long j2);

    private static native void nativeCancelTransaction(long j2);

    private static native void nativeCloseSharedRealm(long j2);

    private static native void nativeCommitTransaction(long j2);

    private static native boolean nativeCompact(long j2);

    private static native long nativeCreateTable(long j2, String str);

    private static native long nativeCreateTableWithPrimaryKeyField(long j2, String str, String str2, boolean z2, boolean z3);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetSchemaInfo(long j2);

    private static native long nativeGetSharedRealm(long j2, RealmNotifier realmNotifier2);

    private static native long nativeGetTable(long j2, String str);

    private static native String nativeGetTableName(long j2, int i2);

    private static native long[] nativeGetVersionID(long j2);

    private static native boolean nativeHasTable(long j2, String str);

    private static native void nativeInit(String str);

    private static native boolean nativeIsAutoRefresh(long j2);

    private static native boolean nativeIsClosed(long j2);

    private static native boolean nativeIsEmpty(long j2);

    private static native boolean nativeIsInTransaction(long j2);

    private static native void nativeRefresh(long j2);

    private native void nativeRegisterPartialSyncQuery(long j2, String str, String str2, PartialSyncCallback partialSyncCallback);

    private static native void nativeRegisterSchemaChangedCallback(long j2, SchemaChangedCallback schemaChangedCallback);

    private static native void nativeRenameTable(long j2, String str, String str2);

    private static native void nativeSetAutoRefresh(long j2, boolean z2);

    private static native long nativeSize(long j2);

    private static native void nativeStopWaitForChange(long j2);

    private static native boolean nativeWaitForChange(long j2);

    private static native void nativeWriteCopy(long j2, String str, byte[] bArr);

    private static void runInitializationCallback(long j2, OsRealmConfig osRealmConfig2, InitializationCallback initializationCallback) {
        initializationCallback.onInit(new OsSharedRealm(j2, osRealmConfig2));
    }

    private static void runMigrationCallback(long j2, OsRealmConfig osRealmConfig2, MigrationCallback migrationCallback, long j3) {
        migrationCallback.onMigrationNeeded(new OsSharedRealm(j2, osRealmConfig2), j3, osRealmConfig2.a().b());
    }

    private void runPartialSyncRegistrationCallback(String str, long j2, PartialSyncCallback partialSyncCallback) {
        if (str != null) {
            partialSyncCallback.onError(new RealmException(str));
            return;
        }
        partialSyncCallback.onSuccess(new OsResults(this, getTable(Table.c(partialSyncCallback.className)), j2, true));
    }

    /* access modifiers changed from: package-private */
    public void addIterator(OsResults.a aVar) {
        this.iterators.add(new WeakReference(aVar));
    }

    /* access modifiers changed from: package-private */
    public void addPendingRow(h hVar) {
        this.pendingRows.add(new WeakReference(hVar));
    }

    public void beginTransaction() {
        detachIterators();
        executePendingRowQueries();
        nativeBeginTransaction(this.nativePtr);
    }

    public void cancelTransaction() {
        nativeCancelTransaction(this.nativePtr);
    }

    public void close() {
        RealmNotifier realmNotifier2 = this.realmNotifier;
        if (realmNotifier2 != null) {
            realmNotifier2.close();
        }
        synchronized (this.context) {
            nativeCloseSharedRealm(this.nativePtr);
        }
    }

    public void commitTransaction() {
        nativeCommitTransaction(this.nativePtr);
    }

    public boolean compact() {
        return nativeCompact(this.nativePtr);
    }

    public Table createTable(String str) {
        return new Table(this, nativeCreateTable(this.nativePtr, str));
    }

    public Table createTableWithPrimaryKey(String str, String str2, boolean z2, boolean z3) {
        return new Table(this, nativeCreateTableWithPrimaryKeyField(this.nativePtr, str, str2, z2, z3));
    }

    public h getConfiguration() {
        return this.osRealmConfig.a();
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public String getPath() {
        return this.osRealmConfig.a().f();
    }

    public OsSchemaInfo getSchemaInfo() {
        return this.schemaInfo;
    }

    public Table getTable(String str) {
        return new Table(this, nativeGetTable(this.nativePtr, str));
    }

    public String getTableName(int i2) {
        return nativeGetTableName(this.nativePtr, i2);
    }

    public a getVersionID() {
        long[] nativeGetVersionID = nativeGetVersionID(this.nativePtr);
        return new a(nativeGetVersionID[0], nativeGetVersionID[1]);
    }

    public boolean hasTable(String str) {
        return nativeHasTable(this.nativePtr, str);
    }

    /* access modifiers changed from: package-private */
    public void invalidateIterators() {
        for (WeakReference<OsResults.a> weakReference : this.iterators) {
            OsResults.a aVar = (OsResults.a) weakReference.get();
            if (aVar != null) {
                aVar.b();
            }
        }
        this.iterators.clear();
    }

    public boolean isAutoRefresh() {
        return nativeIsAutoRefresh(this.nativePtr);
    }

    public boolean isClosed() {
        return nativeIsClosed(this.nativePtr);
    }

    public boolean isEmpty() {
        return nativeIsEmpty(this.nativePtr);
    }

    public boolean isInTransaction() {
        return nativeIsInTransaction(this.nativePtr);
    }

    public void refresh() {
        nativeRefresh(this.nativePtr);
    }

    public void registerPartialSyncQuery(String str, PartialSyncCallback partialSyncCallback) {
        nativeRegisterPartialSyncQuery(this.nativePtr, partialSyncCallback.className, str, partialSyncCallback);
    }

    public void registerSchemaChangedCallback(SchemaChangedCallback schemaChangedCallback) {
        nativeRegisterSchemaChangedCallback(this.nativePtr, schemaChangedCallback);
    }

    /* access modifiers changed from: package-private */
    public void removePendingRow(h hVar) {
        for (WeakReference next : this.pendingRows) {
            h hVar2 = (h) next.get();
            if (hVar2 == null || hVar2 == hVar) {
                this.pendingRows.remove(next);
            }
        }
    }

    public void renameTable(String str, String str2) {
        nativeRenameTable(this.nativePtr, str, str2);
    }

    public void setAutoRefresh(boolean z2) {
        this.capabilities.a((String) null);
        nativeSetAutoRefresh(this.nativePtr, z2);
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public void stopWaitForChange() {
        nativeStopWaitForChange(this.nativePtr);
    }

    public boolean waitForChange() {
        return nativeWaitForChange(this.nativePtr);
    }

    public void writeCopy(File file, byte[] bArr) {
        if (!file.isFile() || !file.exists()) {
            nativeWriteCopy(this.nativePtr, file.getAbsolutePath(), bArr);
            return;
        }
        throw new IllegalArgumentException("The destination file must not exist");
    }
}
