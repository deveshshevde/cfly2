package me.yokeyword.fragmentation;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation.helper.internal.b;

public class f {

    /* renamed from: a  reason: collision with root package name */
    FragmentAnimator f31140a;

    /* renamed from: b  reason: collision with root package name */
    me.yokeyword.fragmentation.helper.internal.a f31141b;

    /* renamed from: c  reason: collision with root package name */
    boolean f31142c;

    /* renamed from: d  reason: collision with root package name */
    int f31143d;

    /* renamed from: e  reason: collision with root package name */
    protected FragmentActivity f31144e;

    /* renamed from: f  reason: collision with root package name */
    boolean f31145f = true;

    /* renamed from: g  reason: collision with root package name */
    a f31146g;

    /* renamed from: h  reason: collision with root package name */
    private int f31147h = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31148i;

    /* renamed from: j  reason: collision with root package name */
    private int f31149j = Integer.MIN_VALUE;

    /* renamed from: k  reason: collision with root package name */
    private int f31150k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    private int f31151l = Integer.MIN_VALUE;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Handler f31152m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f31153n = true;

    /* renamed from: o  reason: collision with root package name */
    private boolean f31154o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f31155p = true;

    /* renamed from: q  reason: collision with root package name */
    private h f31156q;

    /* renamed from: r  reason: collision with root package name */
    private b f31157r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public Bundle f31158s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public c f31159t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public Fragment f31160u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public b f31161v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f31162w;

    /* renamed from: x  reason: collision with root package name */
    private Runnable f31163x = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
            r0 = me.yokeyword.fragmentation.f.c(r7.f31168a).getView();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                me.yokeyword.fragmentation.f r0 = me.yokeyword.fragmentation.f.this
                androidx.fragment.app.Fragment r0 = r0.f31160u
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                me.yokeyword.fragmentation.f r0 = me.yokeyword.fragmentation.f.this
                me.yokeyword.fragmentation.c r0 = r0.f31159t
                me.yokeyword.fragmentation.f r1 = me.yokeyword.fragmentation.f.this
                android.os.Bundle r1 = r1.f31158s
                r0.a(r1)
                me.yokeyword.fragmentation.f r0 = me.yokeyword.fragmentation.f.this
                boolean r0 = r0.f31162w
                if (r0 == 0) goto L_0x0021
                return
            L_0x0021:
                me.yokeyword.fragmentation.f r0 = me.yokeyword.fragmentation.f.this
                androidx.fragment.app.Fragment r0 = r0.f31160u
                android.view.View r0 = r0.getView()
                if (r0 != 0) goto L_0x002e
                return
            L_0x002e:
                me.yokeyword.fragmentation.f r1 = me.yokeyword.fragmentation.f.this
                androidx.fragment.app.Fragment r1 = r1.f31160u
                me.yokeyword.fragmentation.c r1 = me.yokeyword.fragmentation.g.a((androidx.fragment.app.Fragment) r1)
                if (r1 != 0) goto L_0x003b
                return
            L_0x003b:
                me.yokeyword.fragmentation.f r1 = r1.i()
                long r1 = r1.t()
                me.yokeyword.fragmentation.f r3 = me.yokeyword.fragmentation.f.this
                long r3 = r3.s()
                me.yokeyword.fragmentation.f r5 = me.yokeyword.fragmentation.f.this
                android.os.Handler r5 = r5.f31152m
                me.yokeyword.fragmentation.f$3$1 r6 = new me.yokeyword.fragmentation.f$3$1
                r6.<init>(r0)
                long r1 = r1 - r3
                r5.postDelayed(r6, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: me.yokeyword.fragmentation.f.AnonymousClass3.run():void");
        }
    };

    interface a {
        void a();
    }

    public f(c cVar) {
        if (cVar instanceof Fragment) {
            this.f31159t = cVar;
            this.f31160u = (Fragment) cVar;
            return;
        }
        throw new RuntimeException("Must extends Fragment");
    }

    private void a(Animation animation) {
        q().postDelayed(this.f31163x, animation.getDuration());
        this.f31161v.g().f31106b = true;
        if (this.f31146g != null) {
            q().post(new Runnable() {
                public void run() {
                    f.this.f31146g.a();
                    f.this.f31146g = null;
                }
            });
        }
    }

    private void n() {
        p();
    }

    private int o() {
        TypedArray obtainStyledAttributes = this.f31144e.getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private void p() {
        q().post(this.f31163x);
        this.f31161v.g().f31106b = true;
    }

    private Handler q() {
        if (this.f31152m == null) {
            this.f31152m = new Handler(Looper.getMainLooper());
        }
        return this.f31152m;
    }

    private Animation r() {
        int i2 = this.f31149j;
        if (i2 == Integer.MIN_VALUE) {
            me.yokeyword.fragmentation.helper.internal.a aVar = this.f31141b;
            if (aVar == null || aVar.f31180a == null) {
                return null;
            }
            return this.f31141b.f31180a;
        }
        try {
            return AnimationUtils.loadAnimation(this.f31144e, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public long s() {
        Animation r2 = r();
        if (r2 != null) {
            return r2.getDuration();
        }
        return 300;
    }

    /* access modifiers changed from: private */
    public long t() {
        int i2 = this.f31151l;
        if (i2 == Integer.MIN_VALUE) {
            me.yokeyword.fragmentation.helper.internal.a aVar = this.f31141b;
            if (aVar == null || aVar.f31183d == null) {
                return 300;
            }
            return this.f31141b.f31183d.getDuration();
        }
        try {
            return AnimationUtils.loadAnimation(this.f31144e, i2).getDuration();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 300;
        }
    }

    public Animation a(int i2, boolean z2, int i3) {
        if (this.f31161v.g().f31105a || this.f31142c) {
            return (i2 != 8194 || !z2) ? this.f31141b.a() : this.f31141b.b();
        }
        if (i2 == 4097) {
            if (!z2) {
                return this.f31141b.f31183d;
            }
            if (this.f31147h == 1) {
                return this.f31141b.a();
            }
            Animation animation = this.f31141b.f31180a;
            a(animation);
            return animation;
        } else if (i2 == 8194) {
            me.yokeyword.fragmentation.helper.internal.a aVar = this.f31141b;
            return z2 ? aVar.f31182c : aVar.f31181b;
        } else {
            if (this.f31148i && z2) {
                n();
            }
            if (!z2) {
                return this.f31141b.a(this.f31160u);
            }
            return null;
        }
    }

    public void a() {
        k().a();
    }

    public void a(int i2, int i3, Bundle bundle) {
    }

    public void a(Activity activity) {
        if (activity instanceof b) {
            b bVar = (b) activity;
            this.f31161v = bVar;
            this.f31144e = (FragmentActivity) activity;
            this.f31156q = bVar.g().a();
            return;
        }
        throw new RuntimeException(activity.getClass().getSimpleName() + " must impl ISupportActivity!");
    }

    public void a(Bundle bundle) {
        k().a(bundle);
        Bundle arguments = this.f31160u.getArguments();
        if (arguments != null) {
            this.f31147h = arguments.getInt("fragmentation_arg_root_status", 0);
            this.f31148i = arguments.getBoolean("fragmentation_arg_is_shared_element", false);
            this.f31143d = arguments.getInt("fragmentation_arg_container");
            this.f31154o = arguments.getBoolean("fragmentation_arg_replace", false);
            this.f31149j = arguments.getInt("fragmentation_arg_custom_enter_anim", Integer.MIN_VALUE);
            this.f31150k = arguments.getInt("fragmentation_arg_custom_exit_anim", Integer.MIN_VALUE);
            this.f31151l = arguments.getInt("fragmentation_arg_custom_pop_exit_anim", Integer.MIN_VALUE);
        }
        if (bundle == null) {
            i();
        } else {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f31158s = bundle;
            this.f31140a = (FragmentAnimator) bundle.getParcelable("fragmentation_state_save_animator");
            this.f31155p = bundle.getBoolean("fragmentation_state_save_status");
            this.f31143d = bundle.getInt("fragmentation_arg_container");
        }
        this.f31141b = new me.yokeyword.fragmentation.helper.internal.a(this.f31144e.getApplicationContext(), this.f31140a);
        final Animation r2 = r();
        if (r2 != null) {
            r().setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    f.this.f31161v.g().f31106b = false;
                    f.this.f31152m.postDelayed(new Runnable() {
                        public void run() {
                            f.this.f31161v.g().f31106b = true;
                        }
                    }, r2.getDuration());
                }
            });
        }
    }

    public void a(View view) {
        if ((this.f31160u.getTag() == null || !this.f31160u.getTag().startsWith("android:switcher:")) && this.f31147h == 0 && view.getBackground() == null) {
            int d2 = this.f31161v.g().d();
            if (d2 == 0) {
                d2 = o();
            }
            view.setBackgroundResource(d2);
        }
    }

    public void a(boolean z2) {
        k().a(z2);
    }

    public void b() {
        k().b();
    }

    public void b(Bundle bundle) {
        k().b(bundle);
        bundle.putParcelable("fragmentation_state_save_animator", this.f31140a);
        bundle.putBoolean("fragmentation_state_save_status", this.f31160u.isHidden());
        bundle.putInt("fragmentation_arg_container", this.f31143d);
    }

    public void b(boolean z2) {
        k().b(z2);
    }

    public void c() {
        this.f31161v.g().f31106b = true;
        k().c();
        q().removeCallbacks(this.f31163x);
    }

    public void c(Bundle bundle) {
        k().c(bundle);
        View view = this.f31160u.getView();
        if (view != null) {
            this.f31162w = view.isClickable();
            view.setClickable(true);
            a(view);
        }
        if (bundle != null || this.f31147h == 1 || ((this.f31160u.getTag() != null && this.f31160u.getTag().startsWith("android:switcher:")) || (this.f31154o && !this.f31153n))) {
            p();
        } else {
            int i2 = this.f31149j;
            if (i2 != Integer.MIN_VALUE) {
                a(i2 == 0 ? this.f31141b.a() : AnimationUtils.loadAnimation(this.f31144e, i2));
            }
        }
        if (this.f31153n) {
            this.f31153n = false;
        }
    }

    public void d() {
        this.f31156q.a(this.f31160u);
    }

    public void d(Bundle bundle) {
    }

    public void e() {
    }

    public void e(Bundle bundle) {
    }

    public void f() {
    }

    public final boolean g() {
        return k().d();
    }

    public FragmentAnimator h() {
        return this.f31161v.h();
    }

    public FragmentAnimator i() {
        if (this.f31161v != null) {
            if (this.f31140a == null) {
                FragmentAnimator k2 = this.f31159t.k();
                this.f31140a = k2;
                if (k2 == null) {
                    this.f31140a = this.f31161v.h();
                }
            }
            return this.f31140a;
        }
        throw new RuntimeException("Fragment has not been attached to Activity!");
    }

    public boolean j() {
        return false;
    }

    public b k() {
        if (this.f31157r == null) {
            this.f31157r = new b(this.f31159t);
        }
        return this.f31157r;
    }

    public FragmentActivity l() {
        return this.f31144e;
    }

    public long m() {
        int i2 = this.f31150k;
        if (i2 == Integer.MIN_VALUE) {
            me.yokeyword.fragmentation.helper.internal.a aVar = this.f31141b;
            if (aVar == null || aVar.f31181b == null) {
                return 300;
            }
            return this.f31141b.f31181b.getDuration();
        }
        try {
            return AnimationUtils.loadAnimation(this.f31144e, i2).getDuration();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 300;
        }
    }
}
