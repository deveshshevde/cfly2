package io.realm;

import io.realm.exceptions.RealmException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class f extends a {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f28933f = new Object();

    public interface a {
    }

    public static Object d() {
        try {
            Constructor constructor = Class.forName("io.realm.DefaultRealmModule").getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (InvocationTargetException e2) {
            throw new RealmException("Could not create an instance of " + "io.realm.DefaultRealmModule", e2);
        } catch (InstantiationException e3) {
            throw new RealmException("Could not create an instance of " + "io.realm.DefaultRealmModule", e3);
        } catch (IllegalAccessException e4) {
            throw new RealmException("Could not create an instance of " + "io.realm.DefaultRealmModule", e4);
        }
    }

    public /* bridge */ /* synthetic */ String a() {
        return super.a();
    }

    public /* bridge */ /* synthetic */ h b() {
        return super.b();
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }
}
