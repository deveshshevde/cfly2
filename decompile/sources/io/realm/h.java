package io.realm;

import io.realm.exceptions.RealmException;
import io.realm.f;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.i;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Locale;
import mc.a;

public class h {

    /* renamed from: a  reason: collision with root package name */
    protected static final i f28934a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f28935b;

    /* renamed from: c  reason: collision with root package name */
    private final File f28936c;

    /* renamed from: d  reason: collision with root package name */
    private final String f28937d;

    /* renamed from: e  reason: collision with root package name */
    private final String f28938e;

    /* renamed from: f  reason: collision with root package name */
    private final String f28939f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f28940g;

    /* renamed from: h  reason: collision with root package name */
    private final long f28941h;

    /* renamed from: i  reason: collision with root package name */
    private final i f28942i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f28943j;

    /* renamed from: k  reason: collision with root package name */
    private final OsRealmConfig.Durability f28944k;

    /* renamed from: l  reason: collision with root package name */
    private final i f28945l;

    /* renamed from: m  reason: collision with root package name */
    private final a f28946m;

    /* renamed from: n  reason: collision with root package name */
    private final f.a f28947n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f28948o;

    /* renamed from: p  reason: collision with root package name */
    private final CompactOnLaunchCallback f28949p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f28950q;

    static {
        i iVar;
        Object d2 = f.d();
        f28935b = d2;
        if (d2 != null) {
            iVar = a(d2.getClass().getCanonicalName());
            if (!iVar.b()) {
                throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://realm.io/news/android-installation-change/");
            }
        } else {
            iVar = null;
        }
        f28934a = iVar;
    }

    private static i a(String str) {
        String[] split = str.split("\\.");
        String str2 = split[split.length - 1];
        String format = String.format(Locale.US, "io.realm.%s%s", new Object[]{str2, "Mediator"});
        try {
            Constructor constructor = Class.forName(format).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return (i) constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e2) {
            throw new RealmException("Could not find " + format, e2);
        } catch (InvocationTargetException e3) {
            throw new RealmException("Could not create an instance of " + format, e3);
        } catch (InstantiationException e4) {
            throw new RealmException("Could not create an instance of " + format, e4);
        } catch (IllegalAccessException e5) {
            throw new RealmException("Could not create an instance of " + format, e5);
        }
    }

    public byte[] a() {
        byte[] bArr = this.f28940g;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public long b() {
        return this.f28941h;
    }

    public boolean c() {
        return this.f28943j;
    }

    public OsRealmConfig.Durability d() {
        return this.f28944k;
    }

    public CompactOnLaunchCallback e() {
        return this.f28949p;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f28941h != hVar.f28941h || this.f28943j != hVar.f28943j || this.f28948o != hVar.f28948o || this.f28950q != hVar.f28950q) {
            return false;
        }
        File file = this.f28936c;
        if (file == null ? hVar.f28936c != null : !file.equals(hVar.f28936c)) {
            return false;
        }
        String str = this.f28937d;
        if (str == null ? hVar.f28937d != null : !str.equals(hVar.f28937d)) {
            return false;
        }
        if (!this.f28938e.equals(hVar.f28938e)) {
            return false;
        }
        String str2 = this.f28939f;
        if (str2 == null ? hVar.f28939f != null : !str2.equals(hVar.f28939f)) {
            return false;
        }
        if (!Arrays.equals(this.f28940g, hVar.f28940g)) {
            return false;
        }
        i iVar = this.f28942i;
        if (iVar == null ? hVar.f28942i != null : !iVar.equals(hVar.f28942i)) {
            return false;
        }
        if (this.f28944k != hVar.f28944k || !this.f28945l.equals(hVar.f28945l)) {
            return false;
        }
        a aVar = this.f28946m;
        if (aVar == null ? hVar.f28946m != null : !aVar.equals(hVar.f28946m)) {
            return false;
        }
        f.a aVar2 = this.f28947n;
        if (aVar2 == null ? hVar.f28947n != null : !aVar2.equals(hVar.f28947n)) {
            return false;
        }
        CompactOnLaunchCallback compactOnLaunchCallback = this.f28949p;
        CompactOnLaunchCallback compactOnLaunchCallback2 = hVar.f28949p;
        return compactOnLaunchCallback != null ? compactOnLaunchCallback.equals(compactOnLaunchCallback2) : compactOnLaunchCallback2 == null;
    }

    public String f() {
        return this.f28938e;
    }

    public boolean g() {
        return this.f28948o;
    }

    public boolean h() {
        return this.f28950q;
    }

    public int hashCode() {
        File file = this.f28936c;
        int i2 = 0;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        String str = this.f28937d;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f28938e.hashCode()) * 31;
        String str2 = this.f28939f;
        int hashCode3 = str2 != null ? str2.hashCode() : 0;
        long j2 = this.f28941h;
        int hashCode4 = (((((hashCode2 + hashCode3) * 31) + Arrays.hashCode(this.f28940g)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        i iVar = this.f28942i;
        int hashCode5 = (((((((hashCode4 + (iVar != null ? iVar.hashCode() : 0)) * 31) + (this.f28943j ? 1 : 0)) * 31) + this.f28944k.hashCode()) * 31) + this.f28945l.hashCode()) * 31;
        a aVar = this.f28946m;
        int hashCode6 = (hashCode5 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        f.a aVar2 = this.f28947n;
        int hashCode7 = (((hashCode6 + (aVar2 != null ? aVar2.hashCode() : 0)) * 31) + (this.f28948o ? 1 : 0)) * 31;
        CompactOnLaunchCallback compactOnLaunchCallback = this.f28949p;
        if (compactOnLaunchCallback != null) {
            i2 = compactOnLaunchCallback.hashCode();
        }
        return ((hashCode7 + i2) * 31) + (this.f28950q ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("realmDirectory: ");
        File file = this.f28936c;
        sb.append(file != null ? file.toString() : "");
        sb.append("\n");
        sb.append("realmFileName : ");
        sb.append(this.f28937d);
        sb.append("\n");
        sb.append("canonicalPath: ");
        sb.append(this.f28938e);
        sb.append("\n");
        sb.append("key: ");
        sb.append("[length: ");
        sb.append(this.f28940g == null ? 0 : 64);
        sb.append("]");
        sb.append("\n");
        sb.append("schemaVersion: ");
        sb.append(Long.toString(this.f28941h));
        sb.append("\n");
        sb.append("migration: ");
        sb.append(this.f28942i);
        sb.append("\n");
        sb.append("deleteRealmIfMigrationNeeded: ");
        sb.append(this.f28943j);
        sb.append("\n");
        sb.append("durability: ");
        sb.append(this.f28944k);
        sb.append("\n");
        sb.append("schemaMediator: ");
        sb.append(this.f28945l);
        sb.append("\n");
        sb.append("readOnly: ");
        sb.append(this.f28948o);
        sb.append("\n");
        sb.append("compactOnLaunch: ");
        sb.append(this.f28949p);
        return sb.toString();
    }
}
