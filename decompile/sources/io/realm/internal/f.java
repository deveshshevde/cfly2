package io.realm.internal;

import io.realm.exceptions.RealmException;
import io.realm.h;
import java.lang.reflect.InvocationTargetException;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final f f29036a = new f();

    /* renamed from: b  reason: collision with root package name */
    private static f f29037b;

    static {
        f29037b = null;
        try {
            f29037b = (f) Class.forName("io.realm.internal.SyncObjectServerFacade").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
        } catch (InstantiationException e2) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e2);
        } catch (IllegalAccessException e3) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e3);
        } catch (NoSuchMethodException e4) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e4);
        } catch (InvocationTargetException e5) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e5.getTargetException());
        }
    }

    public static f a() {
        f fVar = f29037b;
        return fVar != null ? fVar : f29036a;
    }

    public static f a(boolean z2) {
        return z2 ? f29037b : f29036a;
    }

    public void a(h hVar) {
    }

    public void a(OsRealmConfig osRealmConfig) {
    }

    public Object[] b(h hVar) {
        return new Object[8];
    }
}
