package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.Toolbar;
import f.b;
import j.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static int f657a = -100;

    /* renamed from: b  reason: collision with root package name */
    private static final b<WeakReference<d>> f658b = new b<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f659c = new Object();

    d() {
    }

    public static d a(Activity activity, c cVar) {
        return new AppCompatDelegateImpl(activity, cVar);
    }

    public static d a(Dialog dialog, c cVar) {
        return new AppCompatDelegateImpl(dialog, cVar);
    }

    static void a(d dVar) {
        synchronized (f659c) {
            c(dVar);
            f658b.add(new WeakReference(dVar));
        }
    }

    static void b(d dVar) {
        synchronized (f659c) {
            c(dVar);
        }
    }

    private static void c(d dVar) {
        synchronized (f659c) {
            Iterator<WeakReference<d>> it2 = f658b.iterator();
            while (it2.hasNext()) {
                d dVar2 = (d) it2.next().get();
                if (dVar2 == dVar || dVar2 == null) {
                    it2.remove();
                }
            }
        }
    }

    public static int k() {
        return f657a;
    }

    public abstract View a(View view, String str, Context context, AttributeSet attributeSet);

    public abstract ActionBar a();

    public abstract f.b a(b.a aVar);

    public void a(int i2) {
    }

    @Deprecated
    public void a(Context context) {
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(Toolbar toolbar);

    public abstract void a(CharSequence charSequence);

    public Context b(Context context) {
        a(context);
        return context;
    }

    public abstract MenuInflater b();

    public abstract <T extends View> T b(int i2);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(int i2);

    public abstract void c(Bundle bundle);

    public abstract void d();

    public abstract boolean d(int i2);

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract a.C0017a h();

    public abstract void i();

    public int j() {
        return -100;
    }
}
