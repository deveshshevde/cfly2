package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.s;
import androidx.fragment.app.t;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ac;
import androidx.lifecycle.k;
import androidx.lifecycle.n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager {

    /* renamed from: a  reason: collision with root package name */
    static boolean f3199a = true;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f3200f = false;
    private aa A = null;
    private aa B = new aa() {
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new b(viewGroup);
        }
    };
    private androidx.activity.result.b<Intent> C;
    private androidx.activity.result.b<IntentSenderRequest> D;
    private androidx.activity.result.b<String[]> E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private ArrayList<a> K;
    private ArrayList<Boolean> L;
    private ArrayList<Fragment> M;
    private ArrayList<g> N;
    private l O;
    private Runnable P = new Runnable() {
        public void run() {
            FragmentManager.this.a(true);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    ArrayList<a> f3201b;

    /* renamed from: c  reason: collision with root package name */
    int f3202c = -1;

    /* renamed from: d  reason: collision with root package name */
    Fragment f3203d;

    /* renamed from: e  reason: collision with root package name */
    ArrayDeque<LaunchedFragmentInfo> f3204e = new ArrayDeque<>();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<e> f3205g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private boolean f3206h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final r f3207i = new r();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Fragment> f3208j;

    /* renamed from: k  reason: collision with root package name */
    private final i f3209k = new i(this);

    /* renamed from: l  reason: collision with root package name */
    private OnBackPressedDispatcher f3210l;

    /* renamed from: m  reason: collision with root package name */
    private final androidx.activity.b f3211m = new androidx.activity.b(false) {
        public void c() {
            FragmentManager.this.c();
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private final AtomicInteger f3212n = new AtomicInteger();
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final Map<String, Bundle> f3213o = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Map<String, Object> f3214p = Collections.synchronizedMap(new HashMap());

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<d> f3215q;

    /* renamed from: r  reason: collision with root package name */
    private Map<Fragment, HashSet<androidx.core.os.b>> f3216r = Collections.synchronizedMap(new HashMap());

    /* renamed from: s  reason: collision with root package name */
    private final t.a f3217s = new t.a() {
        public void a(Fragment fragment, androidx.core.os.b bVar) {
            FragmentManager.this.a(fragment, bVar);
        }

        public void b(Fragment fragment, androidx.core.os.b bVar) {
            if (!bVar.a()) {
                FragmentManager.this.b(fragment, bVar);
            }
        }
    };

    /* renamed from: t  reason: collision with root package name */
    private final j f3218t = new j(this);

    /* renamed from: u  reason: collision with root package name */
    private final CopyOnWriteArrayList<m> f3219u = new CopyOnWriteArrayList<>();

    /* renamed from: v  reason: collision with root package name */
    private h<?> f3220v;

    /* renamed from: w  reason: collision with root package name */
    private e f3221w;

    /* renamed from: x  reason: collision with root package name */
    private Fragment f3222x;

    /* renamed from: y  reason: collision with root package name */
    private g f3223y = null;

    /* renamed from: z  reason: collision with root package name */
    private g f3224z = new g() {
        public Fragment c(ClassLoader classLoader, String str) {
            return FragmentManager.this.m().a(FragmentManager.this.m().g(), str, (Bundle) null);
        }
    };

    /* renamed from: androidx.fragment.app.FragmentManager$6  reason: invalid class name */
    class AnonymousClass6 implements k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f3233a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f3234b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Lifecycle f3235c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FragmentManager f3236d;

        public void a(n nVar, Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) this.f3236d.f3213o.get(this.f3233a)) != null) {
                this.f3234b.a(this.f3233a, bundle);
                this.f3236d.a(this.f3233a);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.f3235c.b(this);
                this.f3236d.f3214p.remove(this.f3233a);
            }
        }
    }

    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>() {
            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: a */
            public LaunchedFragmentInfo[] newArray(int i2) {
                return new LaunchedFragmentInfo[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        String f3243a;

        /* renamed from: b  reason: collision with root package name */
        int f3244b;

        LaunchedFragmentInfo(Parcel parcel) {
            this.f3243a = parcel.readString();
            this.f3244b = parcel.readInt();
        }

        LaunchedFragmentInfo(String str, int i2) {
            this.f3243a = str;
            this.f3244b = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f3243a);
            parcel.writeInt(this.f3244b);
        }
    }

    public interface a {
        int a();

        String i();
    }

    static class b extends b.a<IntentSenderRequest, ActivityResult> {
        b() {
        }

        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent b2 = intentSenderRequest.b();
            if (!(b2 == null || (bundleExtra = b2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                b2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (b2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.a()).a((Intent) null).a(intentSenderRequest.d(), intentSenderRequest.c()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* renamed from: b */
        public ActivityResult a(int i2, Intent intent) {
            return new ActivityResult(i2, intent);
        }
    }

    public static abstract class c {
        public void a(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void a(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void a(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void c(FragmentManager fragmentManager, Fragment fragment) {
        }

        @Deprecated
        public void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void d(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void d(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void e(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void f(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void g(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    public interface d {
        void a();
    }

    interface e {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class f implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f3245a;

        /* renamed from: b  reason: collision with root package name */
        final int f3246b;

        /* renamed from: c  reason: collision with root package name */
        final int f3247c;

        f(String str, int i2, int i3) {
            this.f3245a = str;
            this.f3246b = i2;
            this.f3247c = i3;
        }

        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            if (FragmentManager.this.f3203d != null && this.f3246b < 0 && this.f3245a == null && FragmentManager.this.f3203d.getChildFragmentManager().e()) {
                return false;
            }
            return FragmentManager.this.a(arrayList, arrayList2, this.f3245a, this.f3246b, this.f3247c);
        }
    }

    static class g implements Fragment.c {

        /* renamed from: a  reason: collision with root package name */
        final boolean f3249a;

        /* renamed from: b  reason: collision with root package name */
        final a f3250b;

        /* renamed from: c  reason: collision with root package name */
        private int f3251c;

        g(a aVar, boolean z2) {
            this.f3249a = z2;
            this.f3250b = aVar;
        }

        public void a() {
            int i2 = this.f3251c - 1;
            this.f3251c = i2;
            if (i2 == 0) {
                this.f3250b.f3316a.j();
            }
        }

        public void b() {
            this.f3251c++;
        }

        public boolean c() {
            return this.f3251c == 0;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z2 = this.f3251c > 0;
            for (Fragment next : this.f3250b.f3316a.g()) {
                next.setOnStartEnterTransitionListener((Fragment.c) null);
                if (z2 && next.isPostponed()) {
                    next.startPostponedEnterTransition();
                }
            }
            this.f3250b.f3316a.a(this.f3250b, this.f3249a, !z2, true);
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f3250b.f3316a.a(this.f3250b, this.f3249a, false, false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (f() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (a(r3.f3222x) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f3211m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void J() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$e> r0 = r3.f3205g
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$e> r1 = r3.f3205g     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.b r1 = r3.f3211m     // Catch:{ all -> 0x002a }
            r1.a((boolean) r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.b r0 = r3.f3211m
            int r1 = r3.f()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.f3222x
            boolean r1 = r3.a((androidx.fragment.app.Fragment) r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.a((boolean) r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.J():void");
    }

    private void K() {
        for (p a2 : this.f3207i.g()) {
            a(a2);
        }
    }

    private void L() {
        if (i()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void M() {
        this.f3206h = false;
        this.L.clear();
        this.K.clear();
    }

    private void N() {
        if (f3199a) {
            for (SpecialEffectsController c2 : P()) {
                c2.c();
            }
        } else if (this.N != null) {
            while (!this.N.isEmpty()) {
                this.N.remove(0).d();
            }
        }
    }

    private void O() {
        if (f3199a) {
            for (SpecialEffectsController e2 : P()) {
                e2.e();
            }
        } else if (!this.f3216r.isEmpty()) {
            for (Fragment next : this.f3216r.keySet()) {
                t(next);
                g(next);
            }
        }
    }

    private Set<SpecialEffectsController> P() {
        HashSet hashSet = new HashSet();
        for (p a2 : this.f3207i.g()) {
            ViewGroup viewGroup = a2.a().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.a(viewGroup, F()));
            }
        }
        return hashSet;
    }

    private void Q() {
        if (this.J) {
            this.J = false;
            K();
        }
    }

    private void R() {
        if (this.f3215q != null) {
            for (int i2 = 0; i2 < this.f3215q.size(); i2++) {
                this.f3215q.get(i2).a();
            }
        }
    }

    private int a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, j.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.h() && !aVar.a(arrayList, i5 + 1, i3)) {
                if (this.N == null) {
                    this.N = new ArrayList<>();
                }
                g gVar = new g(aVar, booleanValue);
                this.N.add(gVar);
                aVar.a((Fragment.c) gVar);
                if (booleanValue) {
                    aVar.g();
                } else {
                    aVar.b(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                b(bVar);
            }
        }
        return i4;
    }

    static Fragment a(View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private Set<SpecialEffectsController> a(ArrayList<a> arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator it2 = arrayList.get(i2).f3427d.iterator();
            while (it2.hasNext()) {
                Fragment fragment = ((s.a) it2.next()).f3445b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(SpecialEffectsController.a(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    private void a(j.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment b2 = bVar.b(i2);
            if (!b2.mAdded) {
                View requireView = b2.requireView();
                b2.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new z("FragmentManager"));
        h<?> hVar = this.f3220v;
        if (hVar != null) {
            try {
                hVar.a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    private void a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<g> arrayList3 = this.N;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = this.N.get(i2);
            if (arrayList == null || gVar.f3249a || (indexOf2 = arrayList.indexOf(gVar.f3250b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if (gVar.c() || (arrayList != null && gVar.f3250b.a(arrayList, 0, arrayList.size()))) {
                    this.N.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || gVar.f3249a || (indexOf = arrayList.indexOf(gVar.f3250b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        gVar.d();
                    }
                }
                i2++;
            } else {
                this.N.remove(i2);
                i2--;
                size--;
            }
            gVar.e();
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.ArrayList<androidx.fragment.app.a> r18, java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            r15 = r18
            r5 = r19
            r4 = r20
            r3 = r21
            java.lang.Object r0 = r15.get(r4)
            androidx.fragment.app.a r0 = (androidx.fragment.app.a) r0
            boolean r2 = r0.f3442s
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.M
            if (r0 != 0) goto L_0x001e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.M = r0
            goto L_0x0021
        L_0x001e:
            r0.clear()
        L_0x0021:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.M
            androidx.fragment.app.r r1 = r6.f3207i
            java.util.List r1 = r1.h()
            r0.addAll(r1)
            androidx.fragment.app.Fragment r0 = r17.D()
            r1 = 0
            r7 = r4
            r16 = 0
        L_0x0034:
            r14 = 1
            if (r7 >= r3) goto L_0x0065
            java.lang.Object r8 = r15.get(r7)
            androidx.fragment.app.a r8 = (androidx.fragment.app.a) r8
            java.lang.Object r9 = r5.get(r7)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0050
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.M
            androidx.fragment.app.Fragment r0 = r8.a((java.util.ArrayList<androidx.fragment.app.Fragment>) r9, (androidx.fragment.app.Fragment) r0)
            goto L_0x0056
        L_0x0050:
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.M
            androidx.fragment.app.Fragment r0 = r8.b(r9, r0)
        L_0x0056:
            if (r16 != 0) goto L_0x0060
            boolean r8 = r8.f3433j
            if (r8 == 0) goto L_0x005d
            goto L_0x0060
        L_0x005d:
            r16 = 0
            goto L_0x0062
        L_0x0060:
            r16 = 1
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0034
        L_0x0065:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.M
            r0.clear()
            if (r2 != 0) goto L_0x00bd
            int r0 = r6.f3202c
            if (r0 < r14) goto L_0x00bd
            boolean r0 = f3199a
            if (r0 == 0) goto L_0x00a4
            r0 = r4
        L_0x0075:
            if (r0 >= r3) goto L_0x00bd
            java.lang.Object r1 = r15.get(r0)
            androidx.fragment.app.a r1 = (androidx.fragment.app.a) r1
            java.util.ArrayList r1 = r1.f3427d
            java.util.Iterator r1 = r1.iterator()
        L_0x0083:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00a1
            java.lang.Object r7 = r1.next()
            androidx.fragment.app.s$a r7 = (androidx.fragment.app.s.a) r7
            androidx.fragment.app.Fragment r7 = r7.f3445b
            if (r7 == 0) goto L_0x0083
            androidx.fragment.app.FragmentManager r8 = r7.mFragmentManager
            if (r8 == 0) goto L_0x0083
            androidx.fragment.app.p r7 = r6.i(r7)
            androidx.fragment.app.r r8 = r6.f3207i
            r8.a((androidx.fragment.app.p) r7)
            goto L_0x0083
        L_0x00a1:
            int r0 = r0 + 1
            goto L_0x0075
        L_0x00a4:
            androidx.fragment.app.h<?> r0 = r6.f3220v
            android.content.Context r7 = r0.g()
            androidx.fragment.app.e r8 = r6.f3221w
            r13 = 0
            androidx.fragment.app.t$a r0 = r6.f3217s
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            r1 = 1
            r14 = r0
            androidx.fragment.app.t.a(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00be
        L_0x00bd:
            r1 = 1
        L_0x00be:
            b(r18, r19, r20, r21)
            boolean r0 = f3199a
            if (r0 == 0) goto L_0x0143
            int r0 = r3 + -1
            java.lang.Object r0 = r5.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = r4
        L_0x00d2:
            if (r2 >= r3) goto L_0x011c
            java.lang.Object r7 = r15.get(r2)
            androidx.fragment.app.a r7 = (androidx.fragment.app.a) r7
            if (r0 == 0) goto L_0x00fb
            java.util.ArrayList r8 = r7.f3427d
            int r8 = r8.size()
            int r8 = r8 - r1
        L_0x00e3:
            if (r8 < 0) goto L_0x0119
            java.util.ArrayList r9 = r7.f3427d
            java.lang.Object r9 = r9.get(r8)
            androidx.fragment.app.s$a r9 = (androidx.fragment.app.s.a) r9
            androidx.fragment.app.Fragment r9 = r9.f3445b
            if (r9 == 0) goto L_0x00f8
            androidx.fragment.app.p r9 = r6.i(r9)
            r9.c()
        L_0x00f8:
            int r8 = r8 + -1
            goto L_0x00e3
        L_0x00fb:
            java.util.ArrayList r7 = r7.f3427d
            java.util.Iterator r7 = r7.iterator()
        L_0x0101:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0119
            java.lang.Object r8 = r7.next()
            androidx.fragment.app.s$a r8 = (androidx.fragment.app.s.a) r8
            androidx.fragment.app.Fragment r8 = r8.f3445b
            if (r8 == 0) goto L_0x0101
            androidx.fragment.app.p r8 = r6.i(r8)
            r8.c()
            goto L_0x0101
        L_0x0119:
            int r2 = r2 + 1
            goto L_0x00d2
        L_0x011c:
            int r2 = r6.f3202c
            r6.a((int) r2, (boolean) r1)
            java.util.Set r1 = r6.a((java.util.ArrayList<androidx.fragment.app.a>) r15, (int) r4, (int) r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0129:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x013f
            java.lang.Object r2 = r1.next()
            androidx.fragment.app.SpecialEffectsController r2 = (androidx.fragment.app.SpecialEffectsController) r2
            r2.a((boolean) r0)
            r2.b()
            r2.d()
            goto L_0x0129
        L_0x013f:
            r0 = r3
            r3 = r5
            goto L_0x0199
        L_0x0143:
            if (r2 == 0) goto L_0x0165
            j.b r7 = new j.b
            r7.<init>()
            r6.b((j.b<androidx.fragment.app.Fragment>) r7)
            r0 = r17
            r14 = 1
            r1 = r18
            r8 = r2
            r2 = r19
            r13 = r3
            r3 = r20
            r12 = r4
            r4 = r21
            r11 = r5
            r5 = r7
            int r0 = r0.a((java.util.ArrayList<androidx.fragment.app.a>) r1, (java.util.ArrayList<java.lang.Boolean>) r2, (int) r3, (int) r4, (j.b<androidx.fragment.app.Fragment>) r5)
            r6.a((j.b<androidx.fragment.app.Fragment>) r7)
            goto L_0x016b
        L_0x0165:
            r8 = r2
            r13 = r3
            r12 = r4
            r11 = r5
            r14 = 1
            r0 = r13
        L_0x016b:
            if (r0 == r12) goto L_0x0197
            if (r8 == 0) goto L_0x0197
            int r1 = r6.f3202c
            if (r1 < r14) goto L_0x018e
            androidx.fragment.app.h<?> r1 = r6.f3220v
            android.content.Context r7 = r1.g()
            androidx.fragment.app.e r8 = r6.f3221w
            r1 = 1
            androidx.fragment.app.t$a r2 = r6.f3217s
            r9 = r18
            r10 = r19
            r3 = r11
            r11 = r20
            r12 = r0
            r0 = r13
            r13 = r1
            r1 = 1
            r14 = r2
            androidx.fragment.app.t.a(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0191
        L_0x018e:
            r3 = r11
            r0 = r13
            r1 = 1
        L_0x0191:
            int r2 = r6.f3202c
            r6.a((int) r2, (boolean) r1)
            goto L_0x0199
        L_0x0197:
            r3 = r11
            r0 = r13
        L_0x0199:
            r1 = r20
        L_0x019b:
            if (r1 >= r0) goto L_0x01bc
            java.lang.Object r2 = r15.get(r1)
            androidx.fragment.app.a r2 = (androidx.fragment.app.a) r2
            java.lang.Object r4 = r3.get(r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01b6
            int r4 = r2.f3318c
            if (r4 < 0) goto L_0x01b6
            r4 = -1
            r2.f3318c = r4
        L_0x01b6:
            r2.b()
            int r1 = r1 + 1
            goto L_0x019b
        L_0x01bc:
            if (r16 == 0) goto L_0x01c1
            r17.R()
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.a(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    static boolean a(int i2) {
        return f3200f || Log.isLoggable("FragmentManager", i2);
    }

    private boolean a(String str, int i2, int i3) {
        a(false);
        d(true);
        Fragment fragment = this.f3203d;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().e()) {
            return true;
        }
        boolean a2 = a(this.K, this.L, str, i2, i3);
        if (a2) {
            this.f3206h = true;
            try {
                b(this.K, this.L);
            } finally {
                M();
            }
        }
        J();
        Q();
        this.f3207i.d();
        return a2;
    }

    private void b(j.b<Fragment> bVar) {
        int i2 = this.f3202c;
        if (i2 >= 1) {
            int min = Math.min(i2, 5);
            for (Fragment next : this.f3207i.h()) {
                if (next.mState < min) {
                    a(next, min);
                    if (next.mView != null && !next.mHidden && next.mIsNewlyAdded) {
                        bVar.add(next);
                    }
                }
            }
        }
    }

    private void b(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                a(arrayList, arrayList2);
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).f3442s) {
                        if (i3 != i2) {
                            a(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).f3442s) {
                                i3++;
                            }
                        }
                        a(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    a(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private static void b(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            a aVar = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                aVar.a(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                aVar.b(z2);
            } else {
                aVar.a(1);
                aVar.g();
            }
            i2++;
        }
    }

    private boolean c(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f3205g) {
            if (this.f3205g.isEmpty()) {
                return false;
            }
            int size = this.f3205g.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                z2 |= this.f3205g.get(i2).a(arrayList, arrayList2);
            }
            this.f3205g.clear();
            this.f3220v.h().removeCallbacks(this.P);
            return z2;
        }
    }

    private void d(boolean z2) {
        if (this.f3206h) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f3220v == null) {
            if (this.I) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f3220v.h().getLooper()) {
            if (!z2) {
                L();
            }
            if (this.K == null) {
                this.K = new ArrayList<>();
                this.L = new ArrayList<>();
            }
            this.f3206h = true;
            try {
                a((ArrayList<a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.f3206h = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    static int e(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* JADX INFO: finally extract failed */
    private void f(int i2) {
        try {
            this.f3206h = true;
            this.f3207i.a(i2);
            a(i2, false);
            if (f3199a) {
                for (SpecialEffectsController e2 : P()) {
                    e2.e();
                }
            }
            this.f3206h = false;
            a(true);
        } catch (Throwable th) {
            this.f3206h = false;
            throw th;
        }
    }

    private l s(Fragment fragment) {
        return this.O.d(fragment);
    }

    private void t(Fragment fragment) {
        HashSet hashSet = this.f3216r.get(fragment);
        if (hashSet != null) {
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ((androidx.core.os.b) it2.next()).c();
            }
            hashSet.clear();
            u(fragment);
            this.f3216r.remove(fragment);
        }
    }

    private void u(Fragment fragment) {
        fragment.performDestroyView();
        this.f3218t.g(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.b(null);
        fragment.mInLayout = false;
    }

    private void v(final Fragment fragment) {
        if (fragment.mView != null) {
            d.a a2 = d.a(this.f3220v.g(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (a2 == null || a2.f3379b == null) {
                if (a2 != null) {
                    fragment.mView.startAnimation(a2.f3378a);
                    a2.f3378a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                a2.f3379b.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    a2.f3379b.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView != null && fragment.mHidden) {
                                fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }
                a2.f3379b.start();
            }
        }
        r(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void w(Fragment fragment) {
        ViewGroup x2 = x(fragment);
        if (x2 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            if (x2.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                x2.setTag(R.id.visible_removing_fragment_view_tag, fragment);
            }
            ((Fragment) x2.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
        }
    }

    private ViewGroup x(Fragment fragment) {
        if (fragment.mContainer != null) {
            return fragment.mContainer;
        }
        if (fragment.mContainerId > 0 && this.f3221w.a()) {
            View a2 = this.f3221w.a(fragment.mContainerId);
            if (a2 instanceof ViewGroup) {
                return (ViewGroup) a2;
            }
        }
        return null;
    }

    private void y(Fragment fragment) {
        if (fragment != null && fragment.equals(d(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    private boolean z(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.H();
    }

    /* access modifiers changed from: package-private */
    public void A() {
        this.I = true;
        a(true);
        O();
        f(-1);
        this.f3220v = null;
        this.f3221w = null;
        this.f3222x = null;
        if (this.f3210l != null) {
            this.f3211m.b();
            this.f3210l = null;
        }
        androidx.activity.result.b<Intent> bVar = this.C;
        if (bVar != null) {
            bVar.a();
            this.D.a();
            this.E.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void B() {
        for (Fragment next : this.f3207i.h()) {
            if (next != null) {
                next.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void C() {
        J();
        y(this.f3203d);
    }

    public Fragment D() {
        return this.f3203d;
    }

    public g E() {
        g gVar = this.f3223y;
        if (gVar != null) {
            return gVar;
        }
        Fragment fragment = this.f3222x;
        return fragment != null ? fragment.mFragmentManager.E() : this.f3224z;
    }

    /* access modifiers changed from: package-private */
    public aa F() {
        aa aaVar = this.A;
        if (aaVar != null) {
            return aaVar;
        }
        Fragment fragment = this.f3222x;
        return fragment != null ? fragment.mFragmentManager.F() : this.B;
    }

    /* access modifiers changed from: package-private */
    public j G() {
        return this.f3218t;
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        boolean z2 = false;
        for (Fragment next : this.f3207i.i()) {
            if (next != null) {
                z2 = z(next);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 I() {
        return this.f3209k;
    }

    public Fragment a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment d2 = d(string);
        if (d2 == null) {
            a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return d2;
    }

    public s a() {
        return new a(this);
    }

    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((e) new f((String) null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2) {
        h<?> hVar;
        if (this.f3220v == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.f3202c) {
            this.f3202c = i2;
            if (f3199a) {
                this.f3207i.c();
            } else {
                for (Fragment h2 : this.f3207i.h()) {
                    h(h2);
                }
                for (p next : this.f3207i.g()) {
                    Fragment a2 = next.a();
                    if (!a2.mIsNewlyAdded) {
                        h(a2);
                    }
                    if (a2.mRemoving && !a2.isInBackStack()) {
                        this.f3207i.b(next);
                    }
                }
            }
            K();
            if (this.F && (hVar = this.f3220v) != null && this.f3202c == 7) {
                hVar.d();
                this.F = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        for (Fragment next : this.f3207i.h()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
            }
        }
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    /* access modifiers changed from: package-private */
    public void a(Parcelable parcelable) {
        p pVar;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f3252a != null) {
                this.f3207i.b();
                Iterator<FragmentState> it2 = fragmentManagerState.f3252a.iterator();
                while (it2.hasNext()) {
                    FragmentState next = it2.next();
                    if (next != null) {
                        Fragment a2 = this.O.a(next.f3261b);
                        if (a2 != null) {
                            if (a(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + a2);
                            }
                            pVar = new p(this.f3218t, this.f3207i, a2, next);
                        } else {
                            pVar = new p(this.f3218t, this.f3207i, this.f3220v.g().getClassLoader(), E(), next);
                        }
                        Fragment a3 = pVar.a();
                        a3.mFragmentManager = this;
                        if (a(2)) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + a3.mWho + "): " + a3);
                        }
                        pVar.a(this.f3220v.g().getClassLoader());
                        this.f3207i.a(pVar);
                        pVar.a(this.f3202c);
                    }
                }
                for (Fragment next2 : this.O.c()) {
                    if (!this.f3207i.b(next2.mWho)) {
                        if (a(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + next2 + " that was not found in the set of active Fragments " + fragmentManagerState.f3252a);
                        }
                        this.O.c(next2);
                        next2.mFragmentManager = this;
                        p pVar2 = new p(this.f3218t, this.f3207i, next2);
                        pVar2.a(1);
                        pVar2.c();
                        next2.mRemoving = true;
                        pVar2.c();
                    }
                }
                this.f3207i.a((List<String>) fragmentManagerState.f3253b);
                if (fragmentManagerState.f3254c != null) {
                    this.f3201b = new ArrayList<>(fragmentManagerState.f3254c.length);
                    for (int i2 = 0; i2 < fragmentManagerState.f3254c.length; i2++) {
                        a a4 = fragmentManagerState.f3254c[i2].a(this);
                        if (a(2)) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a4.f3318c + "): " + a4);
                            PrintWriter printWriter = new PrintWriter(new z("FragmentManager"));
                            a4.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f3201b.add(a4);
                    }
                } else {
                    this.f3201b = null;
                }
                this.f3212n.set(fragmentManagerState.f3255d);
                if (fragmentManagerState.f3256e != null) {
                    Fragment d2 = d(fragmentManagerState.f3256e);
                    this.f3203d = d2;
                    y(d2);
                }
                ArrayList<String> arrayList = fragmentManagerState.f3257f;
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        Bundle bundle = fragmentManagerState.f3258g.get(i3);
                        bundle.setClassLoader(this.f3220v.g().getClassLoader());
                        this.f3213o.put(arrayList.get(i3), bundle);
                    }
                }
                this.f3204e = new ArrayDeque<>(fragmentManagerState.f3259h);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r2 != 5) goto L_0x016e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.fragment.app.Fragment r11, int r12) {
        /*
            r10 = this;
            androidx.fragment.app.r r0 = r10.f3207i
            java.lang.String r1 = r11.mWho
            androidx.fragment.app.p r0 = r0.c((java.lang.String) r1)
            r1 = 1
            if (r0 != 0) goto L_0x0017
            androidx.fragment.app.p r0 = new androidx.fragment.app.p
            androidx.fragment.app.j r2 = r10.f3218t
            androidx.fragment.app.r r3 = r10.f3207i
            r0.<init>(r2, r3, r11)
            r0.a((int) r1)
        L_0x0017:
            boolean r2 = r11.mFromLayout
            r3 = 2
            if (r2 == 0) goto L_0x0028
            boolean r2 = r11.mInLayout
            if (r2 == 0) goto L_0x0028
            int r2 = r11.mState
            if (r2 != r3) goto L_0x0028
            int r12 = java.lang.Math.max(r12, r3)
        L_0x0028:
            int r2 = r0.b()
            int r12 = java.lang.Math.min(r12, r2)
            int r2 = r11.mState
            r4 = 3
            java.lang.String r5 = "FragmentManager"
            r6 = -1
            r7 = 5
            r8 = 4
            if (r2 > r12) goto L_0x007e
            int r2 = r11.mState
            if (r2 >= r12) goto L_0x0049
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.b>> r2 = r10.f3216r
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0049
            r10.t(r11)
        L_0x0049:
            int r2 = r11.mState
            if (r2 == r6) goto L_0x0059
            if (r2 == 0) goto L_0x005e
            if (r2 == r1) goto L_0x0063
            if (r2 == r3) goto L_0x006d
            if (r2 == r8) goto L_0x0072
            if (r2 == r7) goto L_0x0077
            goto L_0x016e
        L_0x0059:
            if (r12 <= r6) goto L_0x005e
            r0.e()
        L_0x005e:
            if (r12 <= 0) goto L_0x0063
            r0.f()
        L_0x0063:
            if (r12 <= r6) goto L_0x0068
            r0.d()
        L_0x0068:
            if (r12 <= r1) goto L_0x006d
            r0.g()
        L_0x006d:
            if (r12 <= r3) goto L_0x0072
            r0.h()
        L_0x0072:
            if (r12 <= r8) goto L_0x0077
            r0.i()
        L_0x0077:
            if (r12 <= r7) goto L_0x016e
            r0.j()
            goto L_0x016e
        L_0x007e:
            int r2 = r11.mState
            if (r2 <= r12) goto L_0x016e
            int r2 = r11.mState
            if (r2 == 0) goto L_0x0167
            if (r2 == r1) goto L_0x0159
            if (r2 == r3) goto L_0x00cc
            if (r2 == r8) goto L_0x009d
            if (r2 == r7) goto L_0x0098
            r9 = 7
            if (r2 == r9) goto L_0x0093
            goto L_0x016e
        L_0x0093:
            if (r12 >= r9) goto L_0x0098
            r0.k()
        L_0x0098:
            if (r12 >= r7) goto L_0x009d
            r0.l()
        L_0x009d:
            if (r12 >= r8) goto L_0x00cc
            boolean r2 = a((int) r4)
            if (r2 == 0) goto L_0x00b9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "movefrom ACTIVITY_CREATED: "
            r2.append(r7)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r5, r2)
        L_0x00b9:
            android.view.View r2 = r11.mView
            if (r2 == 0) goto L_0x00cc
            androidx.fragment.app.h<?> r2 = r10.f3220v
            boolean r2 = r2.a((androidx.fragment.app.Fragment) r11)
            if (r2 == 0) goto L_0x00cc
            android.util.SparseArray<android.os.Parcelable> r2 = r11.mSavedViewState
            if (r2 != 0) goto L_0x00cc
            r0.o()
        L_0x00cc:
            if (r12 >= r3) goto L_0x0159
            r2 = 0
            android.view.View r7 = r11.mView
            if (r7 == 0) goto L_0x014e
            android.view.ViewGroup r7 = r11.mContainer
            if (r7 == 0) goto L_0x014e
            android.view.ViewGroup r7 = r11.mContainer
            android.view.View r8 = r11.mView
            r7.endViewTransition(r8)
            android.view.View r7 = r11.mView
            r7.clearAnimation()
            boolean r7 = r11.isRemovingParent()
            if (r7 != 0) goto L_0x014e
            int r7 = r10.f3202c
            r8 = 0
            if (r7 <= r6) goto L_0x010f
            boolean r6 = r10.I
            if (r6 != 0) goto L_0x010f
            android.view.View r6 = r11.mView
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x010f
            float r6 = r11.mPostponedAlpha
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x010f
            androidx.fragment.app.h<?> r2 = r10.f3220v
            android.content.Context r2 = r2.g()
            r6 = 0
            boolean r7 = r11.getPopDirection()
            androidx.fragment.app.d$a r2 = androidx.fragment.app.d.a(r2, r11, r6, r7)
        L_0x010f:
            r11.mPostponedAlpha = r8
            android.view.ViewGroup r6 = r11.mContainer
            android.view.View r7 = r11.mView
            if (r2 == 0) goto L_0x011c
            androidx.fragment.app.t$a r8 = r10.f3217s
            androidx.fragment.app.d.a((androidx.fragment.app.Fragment) r11, (androidx.fragment.app.d.a) r2, (androidx.fragment.app.t.a) r8)
        L_0x011c:
            r6.removeView(r7)
            boolean r2 = a((int) r3)
            if (r2 == 0) goto L_0x0149
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Removing view "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " for fragment "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r3 = " from container "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            android.util.Log.v(r5, r2)
        L_0x0149:
            android.view.ViewGroup r2 = r11.mContainer
            if (r6 == r2) goto L_0x014e
            return
        L_0x014e:
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.b>> r2 = r10.f3216r
            java.lang.Object r2 = r2.get(r11)
            if (r2 != 0) goto L_0x0159
            r0.p()
        L_0x0159:
            if (r12 >= r1) goto L_0x0167
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.b>> r2 = r10.f3216r
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x0164
            goto L_0x0168
        L_0x0164:
            r0.q()
        L_0x0167:
            r1 = r12
        L_0x0168:
            if (r1 >= 0) goto L_0x016d
            r0.r()
        L_0x016d:
            r12 = r1
        L_0x016e:
            int r0 = r11.mState
            if (r0 == r12) goto L_0x01a0
            boolean r0 = a((int) r4)
            if (r0 == 0) goto L_0x019e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r11.mState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r5, r0)
        L_0x019e:
            r11.mState = r12
        L_0x01a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.a(androidx.fragment.app.Fragment, int):void");
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (this.C != null) {
            this.f3204e.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
            if (!(intent == null || bundle == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.C.a(intent);
            return;
        }
        this.f3220v.a(fragment, intent, i2, bundle);
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.D != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (a(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            IntentSenderRequest a2 = new IntentSenderRequest.a(intentSender).a(intent2).a(i4, i3).a();
            int i6 = i2;
            this.f3204e.addLast(new LaunchedFragmentInfo(fragment2.mWho, i2));
            if (a(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.D.a(a2);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        this.f3220v.a(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, androidx.core.os.b bVar) {
        if (this.f3216r.get(fragment) == null) {
            this.f3216r.put(fragment, new HashSet());
        }
        this.f3216r.get(fragment).add(bVar);
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(d(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, boolean z2) {
        ViewGroup x2 = x(fragment);
        if (x2 != null && (x2 instanceof FragmentContainerView)) {
            ((FragmentContainerView) x2).setDrawDisappearingViewsLast(!z2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, String[] strArr, int i2) {
        if (this.E != null) {
            this.f3204e.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
            this.E.a(strArr);
            return;
        }
        this.f3220v.a(fragment, strArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void a(FragmentContainerView fragmentContainerView) {
        for (p next : this.f3207i.g()) {
            Fragment a2 = next.a();
            if (a2.mContainerId == fragmentContainerView.getId() && a2.mView != null && a2.mView.getParent() == null) {
                a2.mContainer = fragmentContainerView;
                next.s();
            }
        }
    }

    public void a(c cVar) {
        this.f3218t.a(cVar);
    }

    public void a(c cVar, boolean z2) {
        this.f3218t.a(cVar, z2);
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar, boolean z2) {
        if (!z2) {
            if (this.f3220v != null) {
                L();
            } else if (this.I) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f3205g) {
            if (this.f3220v != null) {
                this.f3205g.add(eVar);
                j();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        if (this.f3201b == null) {
            this.f3201b = new ArrayList<>();
        }
        this.f3201b.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.b(z4);
        } else {
            aVar.g();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3 && this.f3202c >= 1) {
            t.a(this.f3220v.g(), this.f3221w, arrayList, arrayList2, 0, 1, true, this.f3217s);
        }
        if (z4) {
            a(this.f3202c, true);
        }
        for (Fragment next : this.f3207i.i()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && aVar.b(next.mContainerId)) {
                if (next.mPostponedAlpha > 0.0f) {
                    next.mView.setAlpha(next.mPostponedAlpha);
                }
                if (z4) {
                    next.mPostponedAlpha = 0.0f;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: androidx.activity.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.fragment.app.h<?> r3, androidx.fragment.app.e r4, final androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.h<?> r0 = r2.f3220v
            if (r0 != 0) goto L_0x0103
            r2.f3220v = r3
            r2.f3221w = r4
            r2.f3222x = r5
            if (r5 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$10 r4 = new androidx.fragment.app.FragmentManager$10
            r4.<init>(r5)
        L_0x0011:
            r2.a((androidx.fragment.app.m) r4)
            goto L_0x001d
        L_0x0015:
            boolean r4 = r3 instanceof androidx.fragment.app.m
            if (r4 == 0) goto L_0x001d
            r4 = r3
            androidx.fragment.app.m r4 = (androidx.fragment.app.m) r4
            goto L_0x0011
        L_0x001d:
            androidx.fragment.app.Fragment r4 = r2.f3222x
            if (r4 == 0) goto L_0x0024
            r2.J()
        L_0x0024:
            boolean r4 = r3 instanceof androidx.activity.c
            if (r4 == 0) goto L_0x0039
            r4 = r3
            androidx.activity.c r4 = (androidx.activity.c) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f3210l = r0
            if (r5 == 0) goto L_0x0034
            r4 = r5
        L_0x0034:
            androidx.activity.b r1 = r2.f3211m
            r0.a(r4, r1)
        L_0x0039:
            if (r5 == 0) goto L_0x0044
            androidx.fragment.app.FragmentManager r3 = r5.mFragmentManager
            androidx.fragment.app.l r3 = r3.s(r5)
        L_0x0041:
            r2.O = r3
            goto L_0x005a
        L_0x0044:
            boolean r4 = r3 instanceof androidx.lifecycle.ad
            if (r4 == 0) goto L_0x0053
            androidx.lifecycle.ad r3 = (androidx.lifecycle.ad) r3
            androidx.lifecycle.ac r3 = r3.getViewModelStore()
            androidx.fragment.app.l r3 = androidx.fragment.app.l.a((androidx.lifecycle.ac) r3)
            goto L_0x0041
        L_0x0053:
            androidx.fragment.app.l r3 = new androidx.fragment.app.l
            r4 = 0
            r3.<init>(r4)
            goto L_0x0041
        L_0x005a:
            androidx.fragment.app.l r3 = r2.O
            boolean r4 = r2.i()
            r3.a((boolean) r4)
            androidx.fragment.app.r r3 = r2.f3207i
            androidx.fragment.app.l r4 = r2.O
            r3.a((androidx.fragment.app.l) r4)
            androidx.fragment.app.h<?> r3 = r2.f3220v
            boolean r4 = r3 instanceof androidx.activity.result.d
            if (r4 == 0) goto L_0x0102
            androidx.activity.result.d r3 = (androidx.activity.result.d) r3
            androidx.activity.result.c r3 = r3.getActivityResultRegistry()
            if (r5 == 0) goto L_0x008c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r5.mWho
            r4.append(r5)
            java.lang.String r5 = ":"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x008e
        L_0x008c:
            java.lang.String r4 = ""
        L_0x008e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "FragmentManager:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartActivityForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            b.b$b r0 = new b.b$b
            r0.<init>()
            androidx.fragment.app.FragmentManager$11 r1 = new androidx.fragment.app.FragmentManager$11
            r1.<init>()
            androidx.activity.result.b r5 = r3.a((java.lang.String) r5, r0, r1)
            r2.C = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartIntentSenderForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.fragment.app.FragmentManager$b r0 = new androidx.fragment.app.FragmentManager$b
            r0.<init>()
            androidx.fragment.app.FragmentManager$2 r1 = new androidx.fragment.app.FragmentManager$2
            r1.<init>()
            androidx.activity.result.b r5 = r3.a((java.lang.String) r5, r0, r1)
            r2.D = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "RequestPermissions"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            b.b$a r5 = new b.b$a
            r5.<init>()
            androidx.fragment.app.FragmentManager$3 r0 = new androidx.fragment.app.FragmentManager$3
            r0.<init>()
            androidx.activity.result.b r3 = r3.a((java.lang.String) r4, r5, r0)
            r2.E = r3
        L_0x0102:
            return
        L_0x0103:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            goto L_0x010c
        L_0x010b:
            throw r3
        L_0x010c:
            goto L_0x010b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.a(androidx.fragment.app.h, androidx.fragment.app.e, androidx.fragment.app.Fragment):void");
    }

    public void a(m mVar) {
        this.f3219u.add(mVar);
    }

    /* access modifiers changed from: package-private */
    public void a(p pVar) {
        Fragment a2 = pVar.a();
        if (!a2.mDeferStart) {
            return;
        }
        if (this.f3206h) {
            this.J = true;
            return;
        }
        a2.mDeferStart = false;
        if (f3199a) {
            pVar.c();
        } else {
            g(a2);
        }
    }

    public final void a(String str) {
        this.f3213o.remove(str);
    }

    public void a(String str, int i2) {
        a((e) new f(str, -1, i2), false);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f3207i.a(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f3208j;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f3208j.get(i2).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f3201b;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.f3201b.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3212n.get());
        synchronized (this.f3205g) {
            int size3 = this.f3205g.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.f3205g.get(i4));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3220v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3221w);
        if (this.f3222x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3222x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3202c);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.G);
        printWriter.print(" mStopped=");
        printWriter.print(this.H);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.I);
        if (this.F) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.F);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(Menu menu) {
        boolean z2 = false;
        if (this.f3202c < 1) {
            return false;
        }
        for (Fragment next : this.f3207i.h()) {
            if (next != null && b(next) && next.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.f3202c < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment next : this.f3207i.h()) {
            if (next != null && b(next) && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z2 = true;
            }
        }
        if (this.f3208j != null) {
            for (int i2 = 0; i2 < this.f3208j.size(); i2++) {
                Fragment fragment = this.f3208j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.f3208j = arrayList;
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(MenuItem menuItem) {
        if (this.f3202c < 1) {
            return false;
        }
        for (Fragment next : this.f3207i.h()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.D()) && a(fragmentManager.f3222x);
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<a> arrayList3 = this.f3201b;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f3201b.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f3201b.get(size2);
                    if ((str != null && str.equals(aVar.i())) || (i2 >= 0 && i2 == aVar.f3318c)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = this.f3201b.get(size2);
                        if ((str == null || !str.equals(aVar2.i())) && (i2 < 0 || i2 != aVar2.f3318c)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f3201b.size() - 1) {
                return false;
            }
            for (int size3 = this.f3201b.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f3201b.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean a(boolean z2) {
        d(z2);
        boolean z3 = false;
        while (c(this.K, this.L)) {
            this.f3206h = true;
            try {
                b(this.K, this.L);
                M();
                z3 = true;
            } catch (Throwable th) {
                M();
                throw th;
            }
        }
        J();
        Q();
        this.f3207i.d();
        return z3;
    }

    public Fragment b(String str) {
        return this.f3207i.a(str);
    }

    public a b(int i2) {
        return this.f3201b.get(i2);
    }

    /* access modifiers changed from: package-private */
    public void b(Menu menu) {
        if (this.f3202c >= 1) {
            for (Fragment next : this.f3207i.h()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, androidx.core.os.b bVar) {
        HashSet hashSet = this.f3216r.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.f3216r.remove(fragment);
            if (fragment.mState < 5) {
                u(fragment);
                g(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(e eVar, boolean z2) {
        if (!z2 || (this.f3220v != null && !this.I)) {
            d(z2);
            if (eVar.a(this.K, this.L)) {
                this.f3206h = true;
                try {
                    b(this.K, this.L);
                } finally {
                    M();
                }
            }
            J();
            Q();
            this.f3207i.d();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        for (Fragment next : this.f3207i.h()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z2);
            }
        }
    }

    public boolean b() {
        boolean a2 = a(true);
        N();
        return a2;
    }

    public boolean b(int i2, int i3) {
        if (i2 >= 0) {
            return a((String) null, i2, i3);
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    /* access modifiers changed from: package-private */
    public boolean b(MenuItem menuItem) {
        if (this.f3202c < 1) {
            return false;
        }
        for (Fragment next : this.f3207i.h()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean b(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public boolean b(String str, int i2) {
        return a(str, -1, i2);
    }

    /* access modifiers changed from: package-private */
    public Fragment c(String str) {
        return this.f3207i.d(str);
    }

    /* access modifiers changed from: package-private */
    public ac c(Fragment fragment) {
        return this.O.e(fragment);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a(true);
        if (this.f3211m.a()) {
            e();
        } else {
            this.f3210l.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z2) {
        for (Fragment next : this.f3207i.h()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2) {
        return this.f3202c >= i2;
    }

    public Fragment d(int i2) {
        return this.f3207i.b(i2);
    }

    /* access modifiers changed from: package-private */
    public Fragment d(String str) {
        return this.f3207i.e(str);
    }

    public void d() {
        a((e) new f((String) null, -1, 0), false);
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment) {
        this.O.a(fragment);
    }

    /* access modifiers changed from: package-private */
    public void e(Fragment fragment) {
        this.O.c(fragment);
    }

    public boolean e() {
        return a((String) null, -1, 0);
    }

    public int f() {
        ArrayList<a> arrayList = this.f3201b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public Fragment.SavedState f(Fragment fragment) {
        p c2 = this.f3207i.c(fragment.mWho);
        if (c2 == null || !c2.a().equals(fragment)) {
            a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return c2.n();
    }

    public List<Fragment> g() {
        return this.f3207i.h();
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment) {
        a(fragment, this.f3202c);
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        if (this.f3207i.b(fragment.mWho)) {
            g(fragment);
            if (!(fragment.mView == null || !fragment.mIsNewlyAdded || fragment.mContainer == null)) {
                if (fragment.mPostponedAlpha > 0.0f) {
                    fragment.mView.setAlpha(fragment.mPostponedAlpha);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                d.a a2 = d.a(this.f3220v.g(), fragment, true, fragment.getPopDirection());
                if (a2 != null) {
                    if (a2.f3378a != null) {
                        fragment.mView.startAnimation(a2.f3378a);
                    } else {
                        a2.f3379b.setTarget(fragment.mView);
                        a2.f3379b.start();
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                v(fragment);
            }
        } else if (a(3)) {
            Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f3202c + "since it is not added to " + this);
        }
    }

    public boolean h() {
        return this.I;
    }

    /* access modifiers changed from: package-private */
    public p i(Fragment fragment) {
        p c2 = this.f3207i.c(fragment.mWho);
        if (c2 != null) {
            return c2;
        }
        p pVar = new p(this.f3218t, this.f3207i, fragment);
        pVar.a(this.f3220v.g().getClassLoader());
        pVar.a(this.f3202c);
        return pVar;
    }

    public boolean i() {
        return this.G || this.H;
    }

    /* access modifiers changed from: package-private */
    public p j(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        p i2 = i(fragment);
        fragment.mFragmentManager = this;
        this.f3207i.a(i2);
        if (!fragment.mDetached) {
            this.f3207i.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (z(fragment)) {
                this.F = true;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        synchronized (this.f3205g) {
            ArrayList<g> arrayList = this.N;
            boolean z2 = false;
            boolean z3 = arrayList != null && !arrayList.isEmpty();
            if (this.f3205g.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.f3220v.h().removeCallbacks(this.P);
                this.f3220v.h().post(this.P);
                J();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f3212n.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public void k(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            this.f3207i.b(fragment);
            if (z(fragment)) {
                this.F = true;
            }
            fragment.mRemoving = true;
            w(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public Parcelable l() {
        int size;
        N();
        O();
        a(true);
        this.G = true;
        this.O.a(true);
        ArrayList<FragmentState> e2 = this.f3207i.e();
        BackStackState[] backStackStateArr = null;
        if (e2.isEmpty()) {
            if (a(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> f2 = this.f3207i.f();
        ArrayList<a> arrayList = this.f3201b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.f3201b.get(i2));
                if (a(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f3201b.get(i2));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f3252a = e2;
        fragmentManagerState.f3253b = f2;
        fragmentManagerState.f3254c = backStackStateArr;
        fragmentManagerState.f3255d = this.f3212n.get();
        Fragment fragment = this.f3203d;
        if (fragment != null) {
            fragmentManagerState.f3256e = fragment.mWho;
        }
        fragmentManagerState.f3257f.addAll(this.f3213o.keySet());
        fragmentManagerState.f3258g.addAll(this.f3213o.values());
        fragmentManagerState.f3259h = new ArrayList<>(this.f3204e);
        return fragmentManagerState;
    }

    /* access modifiers changed from: package-private */
    public void l(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            w(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public h<?> m() {
        return this.f3220v;
    }

    /* access modifiers changed from: package-private */
    public void m(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment n() {
        return this.f3222x;
    }

    /* access modifiers changed from: package-private */
    public void n(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (a(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f3207i.b(fragment);
                if (z(fragment)) {
                    this.F = true;
                }
                w(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public e o() {
        return this.f3221w;
    }

    /* access modifiers changed from: package-private */
    public void o(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f3207i.a(fragment);
                if (a(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (z(fragment)) {
                    this.F = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public r p() {
        return this.f3207i;
    }

    /* access modifiers changed from: package-private */
    public void p(Fragment fragment) {
        if (fragment == null || (fragment.equals(d(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f3203d;
            this.f3203d = fragment;
            y(fragment2);
            y(this.f3203d);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* access modifiers changed from: package-private */
    public void q() {
        if (this.f3220v != null) {
            this.G = false;
            this.H = false;
            this.O.a(false);
            for (Fragment next : this.f3207i.h()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(Fragment fragment) {
        Iterator<m> it2 = this.f3219u.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(0);
    }

    /* access modifiers changed from: package-private */
    public void r(Fragment fragment) {
        if (fragment.mAdded && z(fragment)) {
            this.F = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(1);
    }

    /* access modifiers changed from: package-private */
    public void t() {
        f(2);
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f3222x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            obj = this.f3222x;
        } else {
            h<?> hVar = this.f3220v;
            if (hVar != null) {
                sb.append(hVar.getClass().getSimpleName());
                sb.append("{");
                obj = this.f3220v;
            } else {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(4);
    }

    /* access modifiers changed from: package-private */
    public void v() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(5);
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        f(7);
    }

    /* access modifiers changed from: package-private */
    public void x() {
        f(5);
    }

    /* access modifiers changed from: package-private */
    public void y() {
        this.H = true;
        this.O.a(true);
        f(4);
    }

    /* access modifiers changed from: package-private */
    public void z() {
        f(1);
    }
}
