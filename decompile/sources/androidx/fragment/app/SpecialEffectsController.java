package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.b;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import t.ac;

abstract class SpecialEffectsController {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<Operation> f3287a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<Operation> f3288b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    boolean f3289c = false;

    /* renamed from: d  reason: collision with root package name */
    boolean f3290d = false;

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f3291e;

    /* renamed from: androidx.fragment.app.SpecialEffectsController$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3296a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3297b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3297b = r0
                r1 = 1
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r2 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3297b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r3 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f3297b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r4 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f3296a = r3
                androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f3296a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f3296a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f3296a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.AnonymousClass3.<clinit>():void");
        }
    }

    static class Operation {

        /* renamed from: a  reason: collision with root package name */
        private State f3298a;

        /* renamed from: b  reason: collision with root package name */
        private LifecycleImpact f3299b;

        /* renamed from: c  reason: collision with root package name */
        private final Fragment f3300c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Runnable> f3301d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private final HashSet<b> f3302e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        private boolean f3303f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f3304g = false;

        enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static State a(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i2);
            }

            static State a(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : a(view.getVisibility());
            }

            /* access modifiers changed from: package-private */
            public void b(View view) {
                int i2;
                int i3 = AnonymousClass3.f3296a[ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                        }
                        i2 = 0;
                    } else if (i3 == 3) {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        i2 = 8;
                    } else if (i3 == 4) {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    } else {
                        return;
                    }
                    view.setVisibility(i2);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                    }
                    viewGroup.removeView(view);
                }
            }
        }

        Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, b bVar) {
            this.f3298a = state;
            this.f3299b = lifecycleImpact;
            this.f3300c = fragment;
            bVar.a(new b.a() {
                public void a() {
                    Operation.this.g();
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void a() {
        }

        public final void a(b bVar) {
            a();
            this.f3302e.add(bVar);
        }

        /* access modifiers changed from: package-private */
        public final void a(State state, LifecycleImpact lifecycleImpact) {
            LifecycleImpact lifecycleImpact2;
            int i2 = AnonymousClass3.f3297b[lifecycleImpact.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3300c + " mFinalState = " + this.f3298a + " -> REMOVED. mLifecycleImpact  = " + this.f3299b + " to REMOVING.");
                    }
                    this.f3298a = State.REMOVED;
                    lifecycleImpact2 = LifecycleImpact.REMOVING;
                } else if (i2 == 3 && this.f3298a != State.REMOVED) {
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3300c + " mFinalState = " + this.f3298a + " -> " + state + ". ");
                    }
                    this.f3298a = state;
                    return;
                } else {
                    return;
                }
            } else if (this.f3298a == State.REMOVED) {
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3300c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f3299b + " to ADDING.");
                }
                this.f3298a = State.VISIBLE;
                lifecycleImpact2 = LifecycleImpact.ADDING;
            } else {
                return;
            }
            this.f3299b = lifecycleImpact2;
        }

        /* access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.f3301d.add(runnable);
        }

        public void b() {
            if (!this.f3304g) {
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f3304g = true;
                for (Runnable run : this.f3301d) {
                    run.run();
                }
            }
        }

        public final void b(b bVar) {
            if (this.f3302e.remove(bVar) && this.f3302e.isEmpty()) {
                b();
            }
        }

        public State c() {
            return this.f3298a;
        }

        /* access modifiers changed from: package-private */
        public LifecycleImpact d() {
            return this.f3299b;
        }

        public final Fragment e() {
            return this.f3300c;
        }

        /* access modifiers changed from: package-private */
        public final boolean f() {
            return this.f3303f;
        }

        /* access modifiers changed from: package-private */
        public final void g() {
            if (!f()) {
                this.f3303f = true;
                if (this.f3302e.isEmpty()) {
                    b();
                    return;
                }
                Iterator it2 = new ArrayList(this.f3302e).iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).c();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean h() {
            return this.f3304g;
        }

        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.f3298a + "} " + "{" + "mLifecycleImpact = " + this.f3299b + "} " + "{" + "mFragment = " + this.f3300c + "}";
        }
    }

    private static class a extends Operation {

        /* renamed from: a  reason: collision with root package name */
        private final p f3315a;

        a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, p pVar, b bVar) {
            super(state, lifecycleImpact, pVar.a(), bVar);
            this.f3315a = pVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (d() == Operation.LifecycleImpact.ADDING) {
                Fragment a2 = this.f3315a.a();
                View findFocus = a2.mView.findFocus();
                if (findFocus != null) {
                    a2.setFocusedView(findFocus);
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + a2);
                    }
                }
                View requireView = e().requireView();
                if (requireView.getParent() == null) {
                    this.f3315a.s();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(a2.getPostOnViewCreatedAlpha());
            }
        }

        public void b() {
            super.b();
            this.f3315a.c();
        }
    }

    SpecialEffectsController(ViewGroup viewGroup) {
        this.f3291e = viewGroup;
    }

    private Operation a(Fragment fragment) {
        Iterator<Operation> it2 = this.f3287a.iterator();
        while (it2.hasNext()) {
            Operation next = it2.next();
            if (next.e().equals(fragment) && !next.f()) {
                return next;
            }
        }
        return null;
    }

    static SpecialEffectsController a(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return a(viewGroup, fragmentManager.F());
    }

    static SpecialEffectsController a(ViewGroup viewGroup, aa aaVar) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController a2 = aaVar.a(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, a2);
        return a2;
    }

    private void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, p pVar) {
        synchronized (this.f3287a) {
            b bVar = new b();
            Operation a2 = a(pVar.a());
            if (a2 != null) {
                a2.a(state, lifecycleImpact);
                return;
            }
            final a aVar = new a(state, lifecycleImpact, pVar, bVar);
            this.f3287a.add(aVar);
            aVar.a((Runnable) new Runnable() {
                public void run() {
                    if (SpecialEffectsController.this.f3287a.contains(aVar)) {
                        aVar.c().b(aVar.e().mView);
                    }
                }
            });
            aVar.a((Runnable) new Runnable() {
                public void run() {
                    SpecialEffectsController.this.f3287a.remove(aVar);
                    SpecialEffectsController.this.f3288b.remove(aVar);
                }
            });
        }
    }

    private Operation b(Fragment fragment) {
        Iterator<Operation> it2 = this.f3288b.iterator();
        while (it2.hasNext()) {
            Operation next = it2.next();
            if (next.e().equals(fragment) && !next.f()) {
                return next;
            }
        }
        return null;
    }

    private void f() {
        Iterator<Operation> it2 = this.f3287a.iterator();
        while (it2.hasNext()) {
            Operation next = it2.next();
            if (next.d() == Operation.LifecycleImpact.ADDING) {
                next.a(Operation.State.a(next.e().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public ViewGroup a() {
        return this.f3291e;
    }

    /* access modifiers changed from: package-private */
    public Operation.LifecycleImpact a(p pVar) {
        Operation a2 = a(pVar.a());
        if (a2 != null) {
            return a2.d();
        }
        Operation b2 = b(pVar.a());
        if (b2 != null) {
            return b2.d();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(Operation.State state, p pVar) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + pVar.a());
        }
        a(state, Operation.LifecycleImpact.ADDING, pVar);
    }

    /* access modifiers changed from: package-private */
    public abstract void a(List<Operation> list, boolean z2);

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f3289c = z2;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        synchronized (this.f3287a) {
            f();
            this.f3290d = false;
            int size = this.f3287a.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Operation operation = this.f3287a.get(size);
                Operation.State a2 = Operation.State.a(operation.e().mView);
                if (operation.c() == Operation.State.VISIBLE && a2 != Operation.State.VISIBLE) {
                    this.f3290d = operation.e().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(p pVar) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + pVar.a());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, pVar);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f3290d) {
            this.f3290d = false;
            d();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(p pVar) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + pVar.a());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, pVar);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (!this.f3290d) {
            if (!ac.J(this.f3291e)) {
                e();
                this.f3289c = false;
                return;
            }
            synchronized (this.f3287a) {
                if (!this.f3287a.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f3288b);
                    this.f3288b.clear();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Operation operation = (Operation) it2.next();
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.g();
                        if (!operation.h()) {
                            this.f3288b.add(operation);
                        }
                    }
                    f();
                    ArrayList arrayList2 = new ArrayList(this.f3287a);
                    this.f3287a.clear();
                    this.f3288b.addAll(arrayList2);
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        ((Operation) it3.next()).a();
                    }
                    a((List<Operation>) arrayList2, this.f3289c);
                    this.f3289c = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(p pVar) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + pVar.a());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, pVar);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        String str;
        String str2;
        boolean J = ac.J(this.f3291e);
        synchronized (this.f3287a) {
            f();
            Iterator<Operation> it2 = this.f3287a.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
            Iterator it3 = new ArrayList(this.f3288b).iterator();
            while (it3.hasNext()) {
                Operation operation = (Operation) it3.next();
                if (FragmentManager.a(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (J) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f3291e + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    Log.v("FragmentManager", sb.toString());
                }
                operation.g();
            }
            Iterator it4 = new ArrayList(this.f3287a).iterator();
            while (it4.hasNext()) {
                Operation operation2 = (Operation) it4.next();
                if (FragmentManager.a(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (J) {
                        str = "";
                    } else {
                        str = "Container " + this.f3291e + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(operation2);
                    Log.v("FragmentManager", sb2.toString());
                }
                operation2.g();
            }
        }
    }
}
