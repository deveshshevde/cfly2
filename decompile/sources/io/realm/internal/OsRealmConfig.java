package io.realm.internal;

import io.realm.CompactOnLaunchCallback;
import io.realm.h;
import io.realm.internal.OsSharedRealm;
import io.realm.log.RealmLog;
import java.net.URI;
import java.net.URISyntaxException;

public class OsRealmConfig implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final long f28968a = nativeGetFinalizerPtr();

    /* renamed from: b  reason: collision with root package name */
    private final h f28969b;

    /* renamed from: c  reason: collision with root package name */
    private final URI f28970c;

    /* renamed from: d  reason: collision with root package name */
    private final long f28971d;

    /* renamed from: e  reason: collision with root package name */
    private final d f28972e;

    /* renamed from: f  reason: collision with root package name */
    private final CompactOnLaunchCallback f28973f;

    /* renamed from: g  reason: collision with root package name */
    private final OsSharedRealm.MigrationCallback f28974g;

    /* renamed from: h  reason: collision with root package name */
    private final OsSharedRealm.InitializationCallback f28975h;

    public enum Durability {
        FULL(0),
        MEM_ONLY(1);
        

        /* renamed from: c  reason: collision with root package name */
        final int f28979c;

        private Durability(int i2) {
            this.f28979c = i2;
        }
    }

    public enum SchemaMode {
        SCHEMA_MODE_AUTOMATIC((byte) 0),
        SCHEMA_MODE_IMMUTABLE((byte) 1),
        SCHEMA_MODE_READONLY((byte) 2),
        SCHEMA_MODE_RESET_FILE((byte) 3),
        SCHEMA_MODE_ADDITIVE((byte) 4),
        SCHEMA_MODE_MANUAL((byte) 5);
        

        /* renamed from: g  reason: collision with root package name */
        final byte f28987g;

        private SchemaMode(byte b2) {
            this.f28987g = b2;
        }

        public byte a() {
            return this.f28987g;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private h f28988a;

        /* renamed from: b  reason: collision with root package name */
        private OsSchemaInfo f28989b = null;

        /* renamed from: c  reason: collision with root package name */
        private OsSharedRealm.MigrationCallback f28990c = null;

        /* renamed from: d  reason: collision with root package name */
        private OsSharedRealm.InitializationCallback f28991d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f28992e = false;

        public a(h hVar) {
            this.f28988a = hVar;
        }

        /* access modifiers changed from: package-private */
        public OsRealmConfig a() {
            return new OsRealmConfig(this.f28988a, this.f28992e, this.f28989b, this.f28990c, this.f28991d);
        }
    }

    private OsRealmConfig(h hVar, boolean z2, OsSchemaInfo osSchemaInfo, OsSharedRealm.MigrationCallback migrationCallback, OsSharedRealm.InitializationCallback initializationCallback) {
        h hVar2 = hVar;
        OsSharedRealm.InitializationCallback initializationCallback2 = initializationCallback;
        this.f28972e = new d();
        this.f28969b = hVar2;
        boolean z3 = true;
        long nativeCreate = nativeCreate(hVar.f(), false, true);
        this.f28971d = nativeCreate;
        d.f29033a.a(this);
        Object[] b2 = f.a().b(hVar2);
        String str = (String) b2[0];
        String str2 = (String) b2[1];
        String str3 = (String) b2[2];
        String str4 = (String) b2[3];
        boolean equals = Boolean.TRUE.equals(b2[4]);
        String str5 = (String) b2[5];
        Byte b3 = (Byte) b2[6];
        boolean equals2 = Boolean.TRUE.equals(b2[7]);
        byte[] a2 = hVar.a();
        if (a2 != null) {
            nativeSetEncryptionKey(nativeCreate, a2);
        }
        nativeSetInMemory(nativeCreate, hVar.d() != Durability.MEM_ONLY ? false : z3);
        nativeEnableChangeNotification(nativeCreate, z2);
        SchemaMode schemaMode = SchemaMode.SCHEMA_MODE_MANUAL;
        if (hVar.h()) {
            schemaMode = SchemaMode.SCHEMA_MODE_IMMUTABLE;
        } else if (hVar.g()) {
            schemaMode = SchemaMode.SCHEMA_MODE_READONLY;
        } else if (str2 != null) {
            schemaMode = SchemaMode.SCHEMA_MODE_ADDITIVE;
        } else if (hVar.c()) {
            schemaMode = SchemaMode.SCHEMA_MODE_RESET_FILE;
        }
        long b4 = hVar.b();
        long nativePtr = osSchemaInfo == null ? 0 : osSchemaInfo.getNativePtr();
        this.f28974g = migrationCallback;
        String str6 = str5;
        boolean z4 = equals;
        nativeSetSchemaConfig(nativeCreate, schemaMode.a(), b4, nativePtr, migrationCallback);
        CompactOnLaunchCallback e2 = hVar.e();
        this.f28973f = e2;
        if (e2 != null) {
            nativeSetCompactOnLaunchCallback(nativeCreate, e2);
        }
        this.f28975h = initializationCallback2;
        if (initializationCallback2 != null) {
            nativeSetInitializationCallback(nativeCreate, initializationCallback2);
        }
        URI uri = null;
        if (str2 != null) {
            try {
                uri = new URI(nativeCreateAndSetSyncConfig(nativeCreate, str2, str3, str, str4, equals2, b3.byteValue()));
            } catch (URISyntaxException e3) {
                RealmLog.b(e3, "Cannot create a URI from the Realm URL address", new Object[0]);
            }
            nativeSetSyncConfigSslSettings(this.f28971d, z4, str6);
        }
        this.f28970c = uri;
    }

    private static native long nativeCreate(String str, boolean z2, boolean z3);

    private static native String nativeCreateAndSetSyncConfig(long j2, String str, String str2, String str3, String str4, boolean z2, byte b2);

    private static native void nativeEnableChangeNotification(long j2, boolean z2);

    private static native long nativeGetFinalizerPtr();

    private static native void nativeSetCompactOnLaunchCallback(long j2, CompactOnLaunchCallback compactOnLaunchCallback);

    private static native void nativeSetEncryptionKey(long j2, byte[] bArr);

    private static native void nativeSetInMemory(long j2, boolean z2);

    private native void nativeSetInitializationCallback(long j2, OsSharedRealm.InitializationCallback initializationCallback);

    private native void nativeSetSchemaConfig(long j2, byte b2, long j3, long j4, OsSharedRealm.MigrationCallback migrationCallback);

    private static native void nativeSetSyncConfigSslSettings(long j2, boolean z2, String str);

    public h a() {
        return this.f28969b;
    }

    /* access modifiers changed from: package-private */
    public d b() {
        return this.f28972e;
    }

    public long getNativeFinalizerPtr() {
        return f28968a;
    }

    public long getNativePtr() {
        return this.f28971d;
    }
}
