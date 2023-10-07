package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.n;
import androidx.core.os.b;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s.f;
import t.ac;
import t.x;

class b extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.b$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3324a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3324a = r0
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3324a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3324a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3324a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b.AnonymousClass2.<clinit>():void");
        }
    }

    private static class a extends C0028b {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3353a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3354b = false;

        /* renamed from: c  reason: collision with root package name */
        private d.a f3355c;

        a(SpecialEffectsController.Operation operation, androidx.core.os.b bVar, boolean z2) {
            super(operation, bVar);
            this.f3353a = z2;
        }

        /* access modifiers changed from: package-private */
        public d.a a(Context context) {
            if (this.f3354b) {
                return this.f3355c;
            }
            d.a a2 = d.a(context, a().e(), a().c() == SpecialEffectsController.Operation.State.VISIBLE, this.f3353a);
            this.f3355c = a2;
            this.f3354b = true;
            return a2;
        }
    }

    /* renamed from: androidx.fragment.app.b$b  reason: collision with other inner class name */
    private static class C0028b {

        /* renamed from: a  reason: collision with root package name */
        private final SpecialEffectsController.Operation f3356a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.core.os.b f3357b;

        C0028b(SpecialEffectsController.Operation operation, androidx.core.os.b bVar) {
            this.f3356a = operation;
            this.f3357b = bVar;
        }

        /* access modifiers changed from: package-private */
        public SpecialEffectsController.Operation a() {
            return this.f3356a;
        }

        /* access modifiers changed from: package-private */
        public androidx.core.os.b b() {
            return this.f3357b;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            SpecialEffectsController.Operation.State a2 = SpecialEffectsController.Operation.State.a(this.f3356a.e().mView);
            SpecialEffectsController.Operation.State c2 = this.f3356a.c();
            return a2 == c2 || !(a2 == SpecialEffectsController.Operation.State.VISIBLE || c2 == SpecialEffectsController.Operation.State.VISIBLE);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f3356a.b(this.f3357b);
        }
    }

    private static class c extends C0028b {

        /* renamed from: a  reason: collision with root package name */
        private final Object f3358a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f3359b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f3360c;

        c(SpecialEffectsController.Operation operation, androidx.core.os.b bVar, boolean z2, boolean z3) {
            super(operation, bVar);
            boolean z4;
            Object obj;
            if (operation.c() == SpecialEffectsController.Operation.State.VISIBLE) {
                Fragment e2 = operation.e();
                this.f3358a = z2 ? e2.getReenterTransition() : e2.getEnterTransition();
                Fragment e3 = operation.e();
                z4 = z2 ? e3.getAllowReturnTransitionOverlap() : e3.getAllowEnterTransitionOverlap();
            } else {
                Fragment e4 = operation.e();
                this.f3358a = z2 ? e4.getReturnTransition() : e4.getExitTransition();
                z4 = true;
            }
            this.f3359b = z4;
            if (z3) {
                Fragment e5 = operation.e();
                obj = z2 ? e5.getSharedElementReturnTransition() : e5.getSharedElementEnterTransition();
            } else {
                obj = null;
            }
            this.f3360c = obj;
        }

        private v a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (t.f3452a != null && t.f3452a.a(obj)) {
                return t.f3452a;
            }
            if (t.f3453b != null && t.f3453b.a(obj)) {
                return t.f3453b;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().e() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* access modifiers changed from: package-private */
        public Object e() {
            return this.f3358a;
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            return this.f3359b;
        }

        public boolean g() {
            return this.f3360c != null;
        }

        public Object h() {
            return this.f3360c;
        }

        /* access modifiers changed from: package-private */
        public v i() {
            v a2 = a(this.f3358a);
            v a3 = a(this.f3360c);
            if (a2 == null || a3 == null || a2 == a3) {
                return a2 != null ? a2 : a3;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().e() + " returned Transition " + this.f3358a + " which uses a different Transition  type than its shared element transition " + this.f3360c);
        }
    }

    b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private Map<SpecialEffectsController.Operation, Boolean> a(List<c> list, List<SpecialEffectsController.Operation> list2, boolean z2, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        View view;
        View view2;
        HashMap hashMap;
        Object obj;
        Object obj2;
        SpecialEffectsController.Operation operation3;
        j.a aVar;
        HashMap hashMap2;
        v vVar;
        SpecialEffectsController.Operation operation4;
        ArrayList arrayList3;
        Rect rect;
        SpecialEffectsController.Operation operation5;
        View view3;
        n nVar;
        n nVar2;
        ArrayList<String> arrayList4;
        final Rect rect2;
        String a2;
        ArrayList<String> arrayList5;
        boolean z3 = z2;
        SpecialEffectsController.Operation operation6 = operation;
        SpecialEffectsController.Operation operation7 = operation2;
        HashMap hashMap3 = new HashMap();
        final v vVar2 = null;
        for (c next : list) {
            if (!next.c()) {
                v i2 = next.i();
                if (vVar2 == null) {
                    vVar2 = i2;
                } else if (!(i2 == null || vVar2 == i2)) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + next.a().e() + " returned Transition " + next.e() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (vVar2 == null) {
            for (c next2 : list) {
                hashMap3.put(next2.a(), false);
                next2.d();
            }
            return hashMap3;
        }
        View view4 = new View(a().getContext());
        Rect rect3 = new Rect();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        j.a aVar2 = new j.a();
        Object obj3 = null;
        View view5 = null;
        boolean z4 = false;
        for (c next3 : list) {
            if (!next3.g() || operation6 == null || operation7 == null) {
                aVar = aVar2;
                operation5 = operation7;
                view3 = view4;
                vVar = vVar2;
                hashMap2 = hashMap3;
                operation4 = operation6;
                arrayList3 = arrayList7;
                rect = rect3;
                view5 = view5;
            } else {
                Object c2 = vVar2.c(vVar2.b(next3.h()));
                ArrayList<String> sharedElementSourceNames = operation2.e().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.e().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.e().getSharedElementTargetNames();
                Object obj4 = c2;
                View view6 = view5;
                int i3 = 0;
                while (i3 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i3));
                    ArrayList<String> arrayList8 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i3));
                    }
                    i3++;
                    sharedElementTargetNames = arrayList8;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.e().getSharedElementTargetNames();
                Fragment e2 = operation.e();
                if (!z3) {
                    nVar2 = e2.getExitTransitionCallback();
                    nVar = operation2.e().getEnterTransitionCallback();
                } else {
                    nVar2 = e2.getEnterTransitionCallback();
                    nVar = operation2.e().getExitTransitionCallback();
                }
                int i4 = 0;
                for (int size = sharedElementSourceNames.size(); i4 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i4), sharedElementTargetNames2.get(i4));
                    i4++;
                    SpecialEffectsController.Operation operation8 = operation;
                }
                j.a aVar3 = new j.a();
                a((Map<String, View>) aVar3, operation.e().mView);
                aVar3.a(sharedElementSourceNames);
                if (nVar2 != null) {
                    nVar2.a((List<String>) sharedElementSourceNames, (Map<String, View>) aVar3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view7 = (View) aVar3.get(str);
                        if (view7 == null) {
                            aVar2.remove(str);
                            arrayList5 = sharedElementSourceNames;
                        } else {
                            arrayList5 = sharedElementSourceNames;
                            if (!str.equals(ac.u(view7))) {
                                aVar2.put(ac.u(view7), (String) aVar2.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList5;
                    }
                    arrayList4 = sharedElementSourceNames;
                } else {
                    arrayList4 = sharedElementSourceNames;
                    aVar2.a(aVar3.keySet());
                }
                j.a aVar4 = new j.a();
                a((Map<String, View>) aVar4, operation2.e().mView);
                aVar4.a(sharedElementTargetNames2);
                aVar4.a(aVar2.values());
                if (nVar != null) {
                    nVar.a((List<String>) sharedElementTargetNames2, (Map<String, View>) aVar4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view8 = (View) aVar4.get(str2);
                        if (view8 == null) {
                            String a3 = t.a((j.a<String, String>) aVar2, str2);
                            if (a3 != null) {
                                aVar2.remove(a3);
                            }
                        } else if (!str2.equals(ac.u(view8)) && (a2 = t.a((j.a<String, String>) aVar2, str2)) != null) {
                            aVar2.put(a2, ac.u(view8));
                        }
                    }
                } else {
                    t.a((j.a<String, String>) aVar2, (j.a<String, View>) aVar4);
                }
                a((j.a<String, View>) aVar3, (Collection<String>) aVar2.keySet());
                a((j.a<String, View>) aVar4, (Collection<String>) aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList6.clear();
                    arrayList7.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList7;
                    rect = rect3;
                    view3 = view4;
                    vVar = vVar2;
                    view5 = view6;
                    obj3 = null;
                    operation5 = operation2;
                    hashMap2 = hashMap3;
                    operation4 = operation;
                } else {
                    t.a(operation2.e(), operation.e(), z3, (j.a<String, View>) aVar3, true);
                    ViewGroup a4 = a();
                    ArrayList<String> arrayList9 = arrayList4;
                    Object obj5 = obj4;
                    HashMap hashMap4 = hashMap3;
                    View view9 = view6;
                    AnonymousClass7 r10 = r0;
                    final SpecialEffectsController.Operation operation9 = operation2;
                    aVar = aVar2;
                    final SpecialEffectsController.Operation operation10 = operation;
                    View view10 = view4;
                    ArrayList arrayList10 = arrayList7;
                    final boolean z5 = z2;
                    Rect rect4 = rect3;
                    ArrayList arrayList11 = arrayList6;
                    final j.a aVar5 = aVar4;
                    AnonymousClass7 r0 = new Runnable() {
                        public void run() {
                            t.a(operation9.e(), operation10.e(), z5, (j.a<String, View>) aVar5, false);
                        }
                    };
                    x.a(a4, r10);
                    for (View a5 : aVar3.values()) {
                        a((ArrayList<View>) arrayList11, a5);
                    }
                    if (!arrayList4.isEmpty()) {
                        View view11 = (View) aVar3.get(arrayList4.get(0));
                        vVar2.a(obj5, view11);
                        view5 = view11;
                    } else {
                        view5 = view9;
                    }
                    for (View a6 : aVar4.values()) {
                        a((ArrayList<View>) arrayList10, a6);
                    }
                    if (!sharedElementTargetNames2.isEmpty()) {
                        final View view12 = (View) aVar4.get(sharedElementTargetNames2.get(0));
                        if (view12 != null) {
                            rect2 = rect4;
                            x.a(a(), new Runnable() {
                                public void run() {
                                    vVar2.a(view12, rect2);
                                }
                            });
                            view3 = view10;
                            z4 = true;
                            vVar2.a(obj5, view3, (ArrayList<View>) arrayList11);
                            rect = rect2;
                            arrayList6 = arrayList11;
                            arrayList3 = arrayList10;
                            vVar = vVar2;
                            vVar2.a(obj5, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj5, arrayList3);
                            operation4 = operation;
                            hashMap2 = hashMap4;
                            hashMap2.put(operation4, true);
                            operation5 = operation2;
                            hashMap2.put(operation5, true);
                            obj3 = obj5;
                        } else {
                            rect2 = rect4;
                        }
                    } else {
                        rect2 = rect4;
                    }
                    view3 = view10;
                    vVar2.a(obj5, view3, (ArrayList<View>) arrayList11);
                    rect = rect2;
                    arrayList6 = arrayList11;
                    arrayList3 = arrayList10;
                    vVar = vVar2;
                    vVar2.a(obj5, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj5, arrayList3);
                    operation4 = operation;
                    hashMap2 = hashMap4;
                    hashMap2.put(operation4, true);
                    operation5 = operation2;
                    hashMap2.put(operation5, true);
                    obj3 = obj5;
                }
            }
            z3 = z2;
            view4 = view3;
            operation7 = operation5;
            rect3 = rect;
            arrayList7 = arrayList3;
            operation6 = operation4;
            hashMap3 = hashMap2;
            aVar2 = aVar;
            vVar2 = vVar;
        }
        View view13 = view5;
        j.a aVar6 = aVar2;
        SpecialEffectsController.Operation operation11 = operation7;
        View view14 = view4;
        v vVar3 = vVar2;
        boolean z6 = false;
        HashMap hashMap5 = hashMap3;
        SpecialEffectsController.Operation operation12 = operation6;
        ArrayList arrayList12 = arrayList7;
        Rect rect5 = rect3;
        ArrayList arrayList13 = new ArrayList();
        Iterator<c> it2 = list.iterator();
        Object obj6 = null;
        Object obj7 = null;
        while (it2.hasNext()) {
            c next4 = it2.next();
            if (next4.c()) {
                hashMap5.put(next4.a(), Boolean.valueOf(z6));
                next4.d();
                it2 = it2;
            } else {
                Iterator<c> it3 = it2;
                Object b2 = vVar3.b(next4.e());
                SpecialEffectsController.Operation a7 = next4.a();
                boolean z7 = obj3 != null && (a7 == operation12 || a7 == operation11);
                if (b2 == null) {
                    if (!z7) {
                        hashMap5.put(a7, Boolean.valueOf(z6));
                        next4.d();
                    }
                    List<SpecialEffectsController.Operation> list3 = list2;
                    view = view14;
                    arrayList2 = arrayList6;
                    arrayList = arrayList12;
                    obj2 = obj6;
                    obj = obj7;
                    hashMap = hashMap5;
                    view2 = view13;
                } else {
                    final ArrayList arrayList14 = new ArrayList();
                    Object obj8 = obj6;
                    a((ArrayList<View>) arrayList14, a7.e().mView);
                    if (z7) {
                        if (a7 == operation12) {
                            arrayList14.removeAll(arrayList6);
                        } else {
                            arrayList14.removeAll(arrayList12);
                        }
                    }
                    if (arrayList14.isEmpty()) {
                        vVar3.b(b2, view14);
                        view = view14;
                        arrayList2 = arrayList6;
                        arrayList = arrayList12;
                        operation3 = a7;
                        obj = obj7;
                        hashMap = hashMap5;
                        obj2 = obj8;
                        List<SpecialEffectsController.Operation> list4 = list2;
                    } else {
                        vVar3.a(b2, (ArrayList<View>) arrayList14);
                        view = view14;
                        SpecialEffectsController.Operation operation13 = a7;
                        obj2 = obj8;
                        arrayList2 = arrayList6;
                        obj = obj7;
                        arrayList = arrayList12;
                        hashMap = hashMap5;
                        vVar3.a(b2, b2, arrayList14, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null);
                        if (operation13.c() == SpecialEffectsController.Operation.State.GONE) {
                            operation3 = operation13;
                            list2.remove(operation3);
                            vVar3.b(b2, operation3.e().mView, (ArrayList<View>) arrayList14);
                            x.a(a(), new Runnable() {
                                public void run() {
                                    t.a((ArrayList<View>) arrayList14, 4);
                                }
                            });
                        } else {
                            List<SpecialEffectsController.Operation> list5 = list2;
                            operation3 = operation13;
                        }
                    }
                    if (operation3.c() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList13.addAll(arrayList14);
                        if (z4) {
                            vVar3.a(b2, rect5);
                        }
                        view2 = view13;
                    } else {
                        view2 = view13;
                        vVar3.a(b2, view2);
                    }
                    hashMap.put(operation3, true);
                    if (next4.f()) {
                        obj = vVar3.a(obj, b2, (Object) null);
                    } else {
                        obj2 = vVar3.a(obj2, b2, (Object) null);
                    }
                }
                it2 = it3;
                obj6 = obj2;
                obj7 = obj;
                hashMap5 = hashMap;
                view13 = view2;
                view14 = view;
                arrayList6 = arrayList2;
                arrayList12 = arrayList;
                z6 = false;
            }
        }
        ArrayList arrayList15 = arrayList6;
        ArrayList arrayList16 = arrayList12;
        HashMap hashMap6 = hashMap5;
        Object b3 = vVar3.b(obj7, obj6, obj3);
        for (final c next5 : list) {
            if (!next5.c()) {
                Object e3 = next5.e();
                SpecialEffectsController.Operation a8 = next5.a();
                boolean z8 = obj3 != null && (a8 == operation12 || a8 == operation11);
                if (e3 != null || z8) {
                    if (!ac.G(a())) {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + a() + " has not been laid out. Completing operation " + a8);
                        }
                        next5.d();
                    } else {
                        vVar3.a(next5.a().e(), b3, next5.b(), new Runnable() {
                            public void run() {
                                next5.d();
                            }
                        });
                    }
                }
            }
        }
        if (!ac.G(a())) {
            return hashMap6;
        }
        t.a((ArrayList<View>) arrayList13, 4);
        ArrayList arrayList17 = arrayList16;
        ArrayList<String> a9 = vVar3.a((ArrayList<View>) arrayList17);
        vVar3.a(a(), b3);
        vVar3.a(a(), arrayList15, arrayList17, a9, aVar6);
        t.a((ArrayList<View>) arrayList13, 0);
        vVar3.a(obj3, (ArrayList<View>) arrayList15, (ArrayList<View>) arrayList17);
        return hashMap6;
    }

    private void a(List<a> list, List<SpecialEffectsController.Operation> list2, boolean z2, Map<SpecialEffectsController.Operation, Boolean> map) {
        StringBuilder sb;
        String str;
        d.a a2;
        final ViewGroup a3 = a();
        Context context = a3.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        for (a next : list) {
            if (!next.c() && (a2 = next.a(context)) != null) {
                final Animator animator = a2.f3379b;
                if (animator == null) {
                    arrayList.add(next);
                } else {
                    final SpecialEffectsController.Operation a4 = next.a();
                    Fragment e2 = a4.e();
                    if (Boolean.TRUE.equals(map.get(a4))) {
                        if (FragmentManager.a(2)) {
                            Log.v("FragmentManager", "Ignoring Animator set on " + e2 + " as this Fragment was involved in a Transition.");
                        }
                        next.d();
                    } else {
                        final boolean z4 = a4.c() == SpecialEffectsController.Operation.State.GONE;
                        List<SpecialEffectsController.Operation> list3 = list2;
                        if (z4) {
                            list3.remove(a4);
                        }
                        final View view = e2.mView;
                        a3.startViewTransition(view);
                        AnonymousClass3 r13 = r0;
                        final ViewGroup viewGroup = a3;
                        final a aVar = next;
                        AnonymousClass3 r0 = new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                if (z4) {
                                    a4.c().b(view);
                                }
                                aVar.d();
                            }
                        };
                        animator.addListener(r13);
                        animator.setTarget(view);
                        animator.start();
                        next.b().a(new b.a() {
                            public void a() {
                                animator.end();
                            }
                        });
                        z3 = true;
                    }
                }
            } else {
                next.d();
            }
            Map<SpecialEffectsController.Operation, Boolean> map2 = map;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final a aVar2 = (a) it2.next();
            SpecialEffectsController.Operation a5 = aVar2.a();
            Fragment e3 = a5.e();
            if (z2) {
                if (FragmentManager.a(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(e3);
                    str = " as Animations cannot run alongside Transitions.";
                }
                aVar2.d();
            } else if (z3) {
                if (FragmentManager.a(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(e3);
                    str = " as Animations cannot run alongside Animators.";
                }
                aVar2.d();
            } else {
                final View view2 = e3.mView;
                Animation animation = (Animation) f.a(((d.a) f.a(aVar2.a(context))).f3378a);
                if (a5.c() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation);
                    aVar2.d();
                } else {
                    a3.startViewTransition(view2);
                    d.b bVar = new d.b(animation, a3, view2);
                    bVar.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            a3.post(new Runnable() {
                                public void run() {
                                    a3.endViewTransition(view2);
                                    aVar2.d();
                                }
                            });
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    view2.startAnimation(bVar);
                }
                aVar2.b().a(new b.a() {
                    public void a() {
                        view2.clearAnimation();
                        a3.endViewTransition(view2);
                        aVar2.d();
                    }
                });
            }
            sb.append(str);
            Log.v("FragmentManager", sb.toString());
            aVar2.d();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(SpecialEffectsController.Operation operation) {
        operation.c().b(operation.e().mView);
    }

    /* access modifiers changed from: package-private */
    public void a(j.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it2 = aVar.entrySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(ac.u((View) it2.next().getValue()))) {
                it2.remove();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            if (!arrayList.contains(view) && ac.u(view) != null) {
                arrayList.add(view);
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    a(arrayList, childAt);
                }
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<SpecialEffectsController.Operation> list, boolean z2) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation next : list) {
            SpecialEffectsController.Operation.State a2 = SpecialEffectsController.Operation.State.a(next.e().mView);
            int i2 = AnonymousClass2.f3324a[next.c().ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (a2 == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = next;
                }
            } else if (i2 == 4 && a2 != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = next;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList<SpecialEffectsController.Operation> arrayList3 = new ArrayList<>(list);
        for (final SpecialEffectsController.Operation next2 : list) {
            androidx.core.os.b bVar = new androidx.core.os.b();
            next2.a(bVar);
            arrayList.add(new a(next2, bVar, z2));
            androidx.core.os.b bVar2 = new androidx.core.os.b();
            next2.a(bVar2);
            boolean z3 = false;
            if (z2) {
                if (next2 != operation) {
                    arrayList2.add(new c(next2, bVar2, z2, z3));
                    next2.a((Runnable) new Runnable() {
                        public void run() {
                            if (arrayList3.contains(next2)) {
                                arrayList3.remove(next2);
                                b.this.a(next2);
                            }
                        }
                    });
                }
            } else if (next2 != operation2) {
                arrayList2.add(new c(next2, bVar2, z2, z3));
                next2.a((Runnable) new Runnable() {
                    public void run() {
                        if (arrayList3.contains(next2)) {
                            arrayList3.remove(next2);
                            b.this.a(next2);
                        }
                    }
                });
            }
            z3 = true;
            arrayList2.add(new c(next2, bVar2, z2, z3));
            next2.a((Runnable) new Runnable() {
                public void run() {
                    if (arrayList3.contains(next2)) {
                        arrayList3.remove(next2);
                        b.this.a(next2);
                    }
                }
            });
        }
        Map<SpecialEffectsController.Operation, Boolean> a3 = a(arrayList2, arrayList3, z2, operation, operation2);
        a(arrayList, arrayList3, a3.containsValue(true), a3);
        for (SpecialEffectsController.Operation a4 : arrayList3) {
            a(a4);
        }
        arrayList3.clear();
    }

    /* access modifiers changed from: package-private */
    public void a(Map<String, View> map, View view) {
        String u2 = ac.u(view);
        if (u2 != null) {
            map.put(u2, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    a(map, childAt);
                }
            }
        }
    }
}
