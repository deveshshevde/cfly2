package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final j.a<String, Method> f4896a;

    /* renamed from: b  reason: collision with root package name */
    protected final j.a<String, Method> f4897b;

    /* renamed from: c  reason: collision with root package name */
    protected final j.a<String, Class> f4898c;

    public a(j.a<String, Method> aVar, j.a<String, Method> aVar2, j.a<String, Class> aVar3) {
        this.f4896a = aVar;
        this.f4897b = aVar2;
        this.f4898c = aVar3;
    }

    private Method a(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f4897b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class b2 = b((Class<? extends c>) cls);
        System.currentTimeMillis();
        Method declaredMethod = b2.getDeclaredMethod("write", new Class[]{cls, a.class});
        this.f4897b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private Class b(Class<? extends c> cls) throws ClassNotFoundException {
        Class cls2 = this.f4898c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f4898c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method b(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Class<a> cls = a.class;
        Method method = this.f4896a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f4896a.put(str, declaredMethod);
        return declaredMethod;
    }

    private void b(c cVar) {
        try {
            a(b((Class<? extends c>) cVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    /* access modifiers changed from: protected */
    public <T extends c> T a(String str, a aVar) {
        try {
            return (c) b(str).invoke((Object) null, new Object[]{aVar});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i2);

    public void a(int i2, int i3) {
        c(i3);
        a(i2);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Parcelable parcelable);

    public void a(Parcelable parcelable, int i2) {
        c(i2);
        a(parcelable);
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
        if (cVar == null) {
            a((String) null);
            return;
        }
        b(cVar);
        a c2 = c();
        a(cVar, c2);
        c2.b();
    }

    public void a(c cVar, int i2) {
        c(i2);
        a(cVar);
    }

    /* access modifiers changed from: protected */
    public <T extends c> void a(T t2, a aVar) {
        try {
            a((Class) t2.getClass()).invoke((Object) null, new Object[]{t2, aVar});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(CharSequence charSequence);

    public void a(CharSequence charSequence, int i2) {
        c(i2);
        a(charSequence);
    }

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    public void a(String str, int i2) {
        c(i2);
        a(str);
    }

    /* access modifiers changed from: protected */
    public abstract void a(boolean z2);

    public void a(boolean z2, int i2) {
        c(i2);
        a(z2);
    }

    public void a(boolean z2, boolean z3) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr);

    public void a(byte[] bArr, int i2) {
        c(i2);
        a(bArr);
    }

    public boolean a() {
        return false;
    }

    public int b(int i2, int i3) {
        return !b(i3) ? i2 : d();
    }

    public <T extends Parcelable> T b(T t2, int i2) {
        return !b(i2) ? t2 : h();
    }

    public <T extends c> T b(T t2, int i2) {
        return !b(i2) ? t2 : j();
    }

    public CharSequence b(CharSequence charSequence, int i2) {
        return !b(i2) ? charSequence : g();
    }

    public String b(String str, int i2) {
        return !b(i2) ? str : e();
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public abstract boolean b(int i2);

    public boolean b(boolean z2, int i2) {
        return !b(i2) ? z2 : i();
    }

    public byte[] b(byte[] bArr, int i2) {
        return !b(i2) ? bArr : f();
    }

    /* access modifiers changed from: protected */
    public abstract a c();

    /* access modifiers changed from: protected */
    public abstract void c(int i2);

    /* access modifiers changed from: protected */
    public abstract int d();

    /* access modifiers changed from: protected */
    public abstract String e();

    /* access modifiers changed from: protected */
    public abstract byte[] f();

    /* access modifiers changed from: protected */
    public abstract CharSequence g();

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T h();

    /* access modifiers changed from: protected */
    public abstract boolean i();

    /* access modifiers changed from: protected */
    public <T extends c> T j() {
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        return a(e2, c());
    }
}
