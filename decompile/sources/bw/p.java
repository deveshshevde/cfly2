package bw;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.s;
import cc.k;
import cc.l;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.bumptech.glide.f;
import com.bumptech.glide.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class p implements Handler.Callback {

    /* renamed from: j  reason: collision with root package name */
    private static final a f6067j = new a() {
        public h a(c cVar, l lVar, q qVar, Context context) {
            return new h(cVar, lVar, qVar, context);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final Map<FragmentManager, o> f6068a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, t> f6069b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private volatile h f6070c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f6071d;

    /* renamed from: e  reason: collision with root package name */
    private final a f6072e;

    /* renamed from: f  reason: collision with root package name */
    private final j.a<View, Fragment> f6073f = new j.a<>();

    /* renamed from: g  reason: collision with root package name */
    private final j.a<View, android.app.Fragment> f6074g = new j.a<>();

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f6075h = new Bundle();

    /* renamed from: i  reason: collision with root package name */
    private final k f6076i;

    public interface a {
        h a(c cVar, l lVar, q qVar, Context context);
    }

    public p(a aVar, f fVar) {
        this.f6072e = aVar == null ? f6067j : aVar;
        this.f6071d = new Handler(Looper.getMainLooper(), this);
        this.f6076i = a(fVar);
    }

    @Deprecated
    private android.app.Fragment a(View view, Activity activity) {
        this.f6074g.clear();
        a(activity.getFragmentManager(), this.f6074g);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f6074g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f6074g.clear();
        return fragment;
    }

    private Fragment a(View view, FragmentActivity fragmentActivity) {
        this.f6073f.clear();
        a((Collection<Fragment>) fragmentActivity.getSupportFragmentManager().g(), (Map<View, Fragment>) this.f6073f);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f6073f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f6073f.clear();
        return fragment;
    }

    private static k a(f fVar) {
        return (!com.bumptech.glide.load.resource.bitmap.p.f10489b || !com.bumptech.glide.load.resource.bitmap.p.f10488a) ? new g() : fVar.a(d.C0079d.class) ? new i() : new j();
    }

    private o a(FragmentManager fragmentManager, android.app.Fragment fragment) {
        o oVar = this.f6068a.get(fragmentManager);
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = (o) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (oVar2 == null) {
            oVar2 = new o();
            oVar2.a(fragment);
            this.f6068a.put(fragmentManager, oVar2);
            fragmentManager.beginTransaction().add(oVar2, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f6071d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return oVar2;
    }

    private t a(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment) {
        t tVar = this.f6069b.get(fragmentManager);
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = (t) fragmentManager.b("com.bumptech.glide.manager");
        if (tVar2 == null) {
            tVar2 = new t();
            tVar2.a(fragment);
            this.f6069b.put(fragmentManager, tVar2);
            fragmentManager.a().a((Fragment) tVar2, "com.bumptech.glide.manager").d();
            this.f6071d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return tVar2;
    }

    @Deprecated
    private h a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z2) {
        o a2 = a(fragmentManager, fragment);
        h b2 = a2.b();
        if (b2 == null) {
            b2 = this.f6072e.a(c.a(context), a2.a(), a2.c(), context);
            if (z2) {
                b2.e();
            }
            a2.a(b2);
        }
        return b2;
    }

    private h a(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z2) {
        t a2 = a(fragmentManager, fragment);
        h b2 = a2.b();
        if (b2 == null) {
            b2 = this.f6072e.a(c.a(context), a2.a(), a2.c(), context);
            if (z2) {
                b2.e();
            }
            a2.a(b2);
        }
        return b2;
    }

    @Deprecated
    private void a(FragmentManager fragmentManager, j.a<View, android.app.Fragment> aVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment next : fragmentManager.getFragments()) {
                if (next.getView() != null) {
                    aVar.put(next.getView(), next);
                    a(next.getChildFragmentManager(), aVar);
                }
            }
            return;
        }
        b(fragmentManager, aVar);
    }

    private static void a(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment next : collection) {
                if (!(next == null || next.getView() == null)) {
                    map.put(next.getView(), next);
                    a((Collection<Fragment>) next.getChildFragmentManager().g(), map);
                }
            }
        }
    }

    private boolean a(FragmentManager fragmentManager, boolean z2) {
        o oVar = this.f6068a.get(fragmentManager);
        o oVar2 = (o) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (oVar2 == oVar) {
            return true;
        }
        if (oVar2 != null && oVar2.b() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + oVar2 + " New: " + oVar);
        } else if (z2 || fragmentManager.isDestroyed()) {
            if (Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", fragmentManager.isDestroyed() ? "Parent was destroyed before our Fragment could be added" : "Tried adding Fragment twice and failed twice, giving up!");
            }
            oVar.a().c();
            return true;
        } else {
            FragmentTransaction add = fragmentManager.beginTransaction().add(oVar, "com.bumptech.glide.manager");
            if (oVar2 != null) {
                add.remove(oVar2);
            }
            add.commitAllowingStateLoss();
            this.f6071d.obtainMessage(1, 1, 0, fragmentManager).sendToTarget();
            if (Log.isLoggable("RMRetriever", 3)) {
                Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
            }
            return false;
        }
    }

    private boolean a(androidx.fragment.app.FragmentManager fragmentManager, boolean z2) {
        t tVar = this.f6069b.get(fragmentManager);
        t tVar2 = (t) fragmentManager.b("com.bumptech.glide.manager");
        if (tVar2 == tVar) {
            return true;
        }
        if (tVar2 != null && tVar2.b() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + tVar2 + " New: " + tVar);
        } else if (z2 || fragmentManager.h()) {
            if (fragmentManager.h()) {
                if (Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
                }
            } else if (Log.isLoggable("RMRetriever", 6)) {
                Log.e("RMRetriever", "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
            }
            tVar.a().c();
            return true;
        } else {
            s a2 = fragmentManager.a().a((Fragment) tVar, "com.bumptech.glide.manager");
            if (tVar2 != null) {
                a2.a((Fragment) tVar2);
            }
            a2.f();
            this.f6071d.obtainMessage(2, 1, 0, fragmentManager).sendToTarget();
            if (Log.isLoggable("RMRetriever", 3)) {
                Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
            }
            return false;
        }
    }

    private h b(Context context) {
        if (this.f6070c == null) {
            synchronized (this) {
                if (this.f6070c == null) {
                    this.f6070c = this.f6072e.a(c.a(context.getApplicationContext()), new b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.f6070c;
    }

    @Deprecated
    private void b(FragmentManager fragmentManager, j.a<View, android.app.Fragment> aVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.f6075h.putInt("key", i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f6075h, "key");
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    aVar.put(fragment.getView(), fragment);
                    if (Build.VERSION.SDK_INT >= 17) {
                        a(fragment.getChildFragmentManager(), aVar);
                    }
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    private static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static boolean d(Context context) {
        Activity c2 = c(context);
        return c2 == null || !c2.isFinishing();
    }

    /* access modifiers changed from: package-private */
    public t a(androidx.fragment.app.FragmentManager fragmentManager) {
        return a(fragmentManager, (Fragment) null);
    }

    public h a(Activity activity) {
        if (l.d()) {
            return a(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return a((FragmentActivity) activity);
        }
        c(activity);
        this.f6076i.a(activity);
        return a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    @Deprecated
    public h a(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (l.d() || Build.VERSION.SDK_INT < 17) {
            return a(fragment.getActivity().getApplicationContext());
        } else {
            if (fragment.getActivity() != null) {
                this.f6076i.a(fragment.getActivity());
            }
            return a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }

    public h a(Context context) {
        if (context != null) {
            if (l.c() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return a((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return a(contextWrapper.getBaseContext());
                    }
                }
            }
            return b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public h a(View view) {
        if (!l.d()) {
            k.a(view);
            k.a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
            Activity c2 = c(view.getContext());
            if (c2 != null) {
                if (c2 instanceof FragmentActivity) {
                    FragmentActivity fragmentActivity = (FragmentActivity) c2;
                    Fragment a2 = a(view, fragmentActivity);
                    return a2 != null ? a(a2) : a(fragmentActivity);
                }
                android.app.Fragment a3 = a(view, c2);
                return a3 == null ? a(c2) : a(a3);
            }
        }
        return a(view.getContext().getApplicationContext());
    }

    public h a(Fragment fragment) {
        k.a(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (l.d()) {
            return a(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.f6076i.a(fragment.getActivity());
        }
        return a(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public h a(FragmentActivity fragmentActivity) {
        if (l.d()) {
            return a(fragmentActivity.getApplicationContext());
        }
        c((Activity) fragmentActivity);
        this.f6076i.a(fragmentActivity);
        return a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, d(fragmentActivity));
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public o b(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: android.app.FragmentManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: androidx.fragment.app.FragmentManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: android.app.FragmentManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: android.app.FragmentManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: android.app.FragmentManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r7) {
        /*
            r6 = this;
            int r0 = r7.arg1
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            int r3 = r7.what
            r4 = 0
            if (r3 == r2) goto L_0x0021
            r5 = 2
            if (r3 == r5) goto L_0x0014
            r7 = r4
            r2 = 0
            goto L_0x0034
        L_0x0014:
            java.lang.Object r7 = r7.obj
            androidx.fragment.app.FragmentManager r7 = (androidx.fragment.app.FragmentManager) r7
            boolean r0 = r6.a((androidx.fragment.app.FragmentManager) r7, (boolean) r0)
            if (r0 == 0) goto L_0x0033
            java.util.Map<androidx.fragment.app.FragmentManager, bw.t> r0 = r6.f6069b
            goto L_0x002d
        L_0x0021:
            java.lang.Object r7 = r7.obj
            android.app.FragmentManager r7 = (android.app.FragmentManager) r7
            boolean r0 = r6.a((android.app.FragmentManager) r7, (boolean) r0)
            if (r0 == 0) goto L_0x0033
            java.util.Map<android.app.FragmentManager, bw.o> r0 = r6.f6068a
        L_0x002d:
            java.lang.Object r4 = r0.remove(r7)
            r1 = 1
            goto L_0x0034
        L_0x0033:
            r7 = r4
        L_0x0034:
            r0 = 5
            java.lang.String r3 = "RMRetriever"
            boolean r0 = android.util.Log.isLoggable(r3, r0)
            if (r0 == 0) goto L_0x0055
            if (r1 == 0) goto L_0x0055
            if (r4 != 0) goto L_0x0055
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to remove expected request manager fragment, manager: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            android.util.Log.w(r3, r7)
        L_0x0055:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bw.p.handleMessage(android.os.Message):boolean");
    }
}
