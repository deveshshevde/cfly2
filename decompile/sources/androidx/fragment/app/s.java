package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import t.ac;

public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    private final g f3425a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader f3426b;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f3427d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    int f3428e;

    /* renamed from: f  reason: collision with root package name */
    int f3429f;

    /* renamed from: g  reason: collision with root package name */
    int f3430g;

    /* renamed from: h  reason: collision with root package name */
    int f3431h;

    /* renamed from: i  reason: collision with root package name */
    int f3432i;

    /* renamed from: j  reason: collision with root package name */
    boolean f3433j;

    /* renamed from: k  reason: collision with root package name */
    boolean f3434k = true;

    /* renamed from: l  reason: collision with root package name */
    String f3435l;

    /* renamed from: m  reason: collision with root package name */
    int f3436m;

    /* renamed from: n  reason: collision with root package name */
    CharSequence f3437n;

    /* renamed from: o  reason: collision with root package name */
    int f3438o;

    /* renamed from: p  reason: collision with root package name */
    CharSequence f3439p;

    /* renamed from: q  reason: collision with root package name */
    ArrayList<String> f3440q;

    /* renamed from: r  reason: collision with root package name */
    ArrayList<String> f3441r;

    /* renamed from: s  reason: collision with root package name */
    boolean f3442s = false;

    /* renamed from: t  reason: collision with root package name */
    ArrayList<Runnable> f3443t;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f3444a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f3445b;

        /* renamed from: c  reason: collision with root package name */
        int f3446c;

        /* renamed from: d  reason: collision with root package name */
        int f3447d;

        /* renamed from: e  reason: collision with root package name */
        int f3448e;

        /* renamed from: f  reason: collision with root package name */
        int f3449f;

        /* renamed from: g  reason: collision with root package name */
        Lifecycle.State f3450g;

        /* renamed from: h  reason: collision with root package name */
        Lifecycle.State f3451h;

        a() {
        }

        a(int i2, Fragment fragment) {
            this.f3444a = i2;
            this.f3445b = fragment;
            this.f3450g = Lifecycle.State.RESUMED;
            this.f3451h = Lifecycle.State.RESUMED;
        }

        a(int i2, Fragment fragment, Lifecycle.State state) {
            this.f3444a = i2;
            this.f3445b = fragment;
            this.f3450g = fragment.mMaxState;
            this.f3451h = state;
        }
    }

    s(g gVar, ClassLoader classLoader) {
        this.f3425a = gVar;
        this.f3426b = classLoader;
    }

    public s a(int i2, int i3, int i4, int i5) {
        this.f3428e = i2;
        this.f3429f = i3;
        this.f3430g = i4;
        this.f3431h = i5;
        return this;
    }

    public s a(int i2, Fragment fragment) {
        a(i2, fragment, (String) null, 1);
        return this;
    }

    public s a(int i2, Fragment fragment, String str) {
        a(i2, fragment, str, 1);
        return this;
    }

    public s a(View view, String str) {
        if (t.a()) {
            String u2 = ac.u(view);
            if (u2 != null) {
                if (this.f3440q == null) {
                    this.f3440q = new ArrayList<>();
                    this.f3441r = new ArrayList<>();
                } else if (this.f3441r.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.f3440q.contains(u2)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + u2 + "' has already been added to the transaction.");
                }
                this.f3440q.add(u2);
                this.f3441r.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public s a(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return a(viewGroup.getId(), fragment, str);
    }

    public s a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public s a(Fragment fragment, Lifecycle.State state) {
        a(new a(10, fragment, state));
        return this;
    }

    public s a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public s a(String str) {
        if (this.f3434k) {
            this.f3433j = true;
            this.f3435l = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i2) {
                fragment.mFragmentId = i2;
                fragment.mContainerId = i2;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
        }
        a(new a(i3, fragment));
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f3427d.add(aVar);
        aVar.f3446c = this.f3428e;
        aVar.f3447d = this.f3429f;
        aVar.f3448e = this.f3430g;
        aVar.f3449f = this.f3431h;
    }

    public s b(int i2, Fragment fragment) {
        return b(i2, fragment, (String) null);
    }

    public s b(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            a(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public s b(Fragment fragment) {
        a(new a(4, fragment));
        return this;
    }

    public abstract int c();

    public s c(int i2) {
        this.f3432i = i2;
        return this;
    }

    public s c(Fragment fragment) {
        a(new a(5, fragment));
        return this;
    }

    public s c(boolean z2) {
        this.f3442s = z2;
        return this;
    }

    public abstract int d();

    public s d(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    public s e(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    public abstract void e();

    public abstract void f();

    public boolean j() {
        return this.f3427d.isEmpty();
    }

    public s k() {
        if (!this.f3433j) {
            this.f3434k = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }
}
