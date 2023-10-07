package or;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class d {

    /* renamed from: a  reason: collision with root package name */
    static final a f32517a = new a() {
    };

    /* renamed from: b  reason: collision with root package name */
    private static final d f32518b = new d();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<a> f32519c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<b> f32520d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<f> f32521e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<e> f32522f = new AtomicReference<>();

    d() {
    }

    static Object a(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            Iterator it2 = properties2.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it2.next();
                String obj = entry.getKey().toString();
                if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                    String property2 = properties2.getProperty(str);
                    if (property2 != null) {
                        property = property2;
                    } else {
                        throw new RuntimeException("Implementing class declaration for " + simpleName + " missing: " + str);
                    }
                }
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException unused) {
            throw new RuntimeException(simpleName + " implementation is not an instance of " + simpleName + ": " + property);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(simpleName + " implementation class not found: " + property, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(simpleName + " implementation not able to be instantiated: " + property, e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(simpleName + " implementation not able to be accessed: " + property, e4);
        }
    }

    public static d a() {
        return f32518b;
    }

    public a b() {
        if (this.f32519c.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.f32519c.compareAndSet((Object) null, f32517a);
            } else {
                this.f32519c.compareAndSet((Object) null, (a) a2);
            }
        }
        return this.f32519c.get();
    }

    public b c() {
        if (this.f32520d.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.f32520d.compareAndSet((Object) null, c.a());
            } else {
                this.f32520d.compareAndSet((Object) null, (b) a2);
            }
        }
        return this.f32520d.get();
    }

    public f d() {
        if (this.f32521e.get() == null) {
            Object a2 = a(f.class, System.getProperties());
            if (a2 == null) {
                this.f32521e.compareAndSet((Object) null, g.a());
            } else {
                this.f32521e.compareAndSet((Object) null, (f) a2);
            }
        }
        return this.f32521e.get();
    }

    public e e() {
        if (this.f32522f.get() == null) {
            Object a2 = a(e.class, System.getProperties());
            if (a2 == null) {
                this.f32522f.compareAndSet((Object) null, e.g());
            } else {
                this.f32522f.compareAndSet((Object) null, (e) a2);
            }
        }
        return this.f32522f.get();
    }
}
