package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.n;
import androidx.fragment.app.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import t.ac;
import t.x;

class t {

    /* renamed from: a  reason: collision with root package name */
    static final v f3452a = (Build.VERSION.SDK_INT >= 21 ? new u() : null);

    /* renamed from: b  reason: collision with root package name */
    static final v f3453b = b();

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f3454c = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    interface a {
        void a(Fragment fragment, androidx.core.os.b bVar);

        void b(Fragment fragment, androidx.core.os.b bVar);
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f3489a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3490b;

        /* renamed from: c  reason: collision with root package name */
        public a f3491c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f3492d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3493e;

        /* renamed from: f  reason: collision with root package name */
        public a f3494f;

        b() {
        }
    }

    static View a(j.a<String, View> aVar, b bVar, Object obj, boolean z2) {
        a aVar2 = bVar.f3491c;
        if (obj == null || aVar == null || aVar2.f3440q == null || aVar2.f3440q.isEmpty()) {
            return null;
        }
        return aVar.get((String) (z2 ? aVar2.f3440q : aVar2.f3441r).get(0));
    }

    private static b a(b bVar, SparseArray<b> sparseArray, int i2) {
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        sparseArray.put(i2, bVar2);
        return bVar2;
    }

    private static v a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        v vVar = f3452a;
        if (vVar != null && a(vVar, (List<Object>) arrayList)) {
            return vVar;
        }
        v vVar2 = f3453b;
        if (vVar2 != null && a(vVar2, (List<Object>) arrayList)) {
            return vVar2;
        }
        if (vVar == null && vVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static j.a<String, String> a(int i2, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        j.a<String, String> aVar = new j.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            a aVar2 = arrayList.get(i5);
            if (aVar2.b(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                if (aVar2.f3440q != null) {
                    int size = aVar2.f3440q.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f3440q;
                        arrayList4 = aVar2.f3441r;
                    } else {
                        ArrayList arrayList5 = aVar2.f3440q;
                        arrayList3 = aVar2.f3441r;
                        arrayList4 = arrayList5;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = (String) arrayList4.get(i6);
                        String str2 = (String) arrayList3.get(i6);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    static j.a<String, View> a(v vVar, j.a<String, String> aVar, Object obj, b bVar) {
        n nVar;
        ArrayList arrayList;
        String a2;
        Fragment fragment = bVar.f3489a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        j.a<String, View> aVar2 = new j.a<>();
        vVar.a((Map<String, View>) aVar2, view);
        a aVar3 = bVar.f3491c;
        if (bVar.f3490b) {
            nVar = fragment.getExitTransitionCallback();
            arrayList = aVar3.f3440q;
        } else {
            nVar = fragment.getEnterTransitionCallback();
            arrayList = aVar3.f3441r;
        }
        if (arrayList != null) {
            aVar2.a(arrayList);
            aVar2.a(aVar.values());
        }
        if (nVar != null) {
            nVar.a((List<String>) arrayList, (Map<String, View>) aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = aVar2.get(str);
                if (view2 == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(ac.u(view2)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, ac.u(view2));
                }
            }
        } else {
            a(aVar, aVar2);
        }
        return aVar2;
    }

    private static Object a(v vVar, ViewGroup viewGroup, View view, j.a<String, String> aVar, b bVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final View view2;
        v vVar2 = vVar;
        View view3 = view;
        j.a<String, String> aVar2 = aVar;
        b bVar2 = bVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj4 = obj;
        Fragment fragment = bVar2.f3489a;
        Fragment fragment2 = bVar2.f3492d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z2 = bVar2.f3490b;
        Object a2 = aVar.isEmpty() ? null : a(vVar, fragment, fragment2, z2);
        j.a<String, View> b2 = b(vVar, aVar2, a2, bVar2);
        j.a<String, View> a3 = a(vVar, aVar2, a2, bVar2);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList3, b2, (Collection<String>) aVar.keySet());
            a(arrayList4, a3, aVar.values());
            obj3 = a2;
        }
        if (obj4 == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z2, b2, true);
        if (obj3 != null) {
            arrayList4.add(view3);
            vVar.a(obj3, view3, arrayList3);
            a(vVar, obj3, obj2, b2, bVar2.f3493e, bVar2.f3494f);
            Rect rect2 = new Rect();
            View a4 = a(a3, bVar2, obj4, z2);
            if (a4 != null) {
                vVar.a(obj4, rect2);
            }
            rect = rect2;
            view2 = a4;
        } else {
            view2 = null;
            rect = null;
        }
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z3 = z2;
        final j.a<String, View> aVar3 = a3;
        final v vVar3 = vVar;
        x.a(viewGroup, new Runnable() {
            public void run() {
                t.a(Fragment.this, fragment4, z3, (j.a<String, View>) aVar3, false);
                View view = view2;
                if (view != null) {
                    vVar3.a(view, rect);
                }
            }
        });
        return obj3;
    }

    private static Object a(v vVar, Fragment fragment, Fragment fragment2, boolean z2) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return vVar.c(vVar.b(z2 ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object a(v vVar, Fragment fragment, boolean z2) {
        if (fragment == null) {
            return null;
        }
        return vVar.b(z2 ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object a(v vVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z2) {
        return (obj == null || obj2 == null || fragment == null) ? true : z2 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? vVar.a(obj2, obj, obj3) : vVar.b(obj2, obj, obj3);
    }

    static String a(j.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(aVar.c(i2))) {
                return aVar.b(i2);
            }
        }
        return null;
    }

    static ArrayList<View> a(v vVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            vVar.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        vVar.a(obj, arrayList2);
        return arrayList2;
    }

    static void a(Context context, e eVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z2, a aVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            a aVar2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                b(aVar2, (SparseArray<b>) sparseArray, z2);
            } else {
                a(aVar2, (SparseArray<b>) sparseArray, z2);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = sparseArray.keyAt(i5);
                j.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i2, i3);
                b bVar = (b) sparseArray.valueAt(i5);
                if (eVar.a() && (viewGroup = (ViewGroup) eVar.a(keyAt)) != null) {
                    if (z2) {
                        a(viewGroup, bVar, view, a2, aVar);
                    } else {
                        b(viewGroup, bVar, view, a2, aVar);
                    }
                }
            }
        }
    }

    private static void a(ViewGroup viewGroup, b bVar, View view, j.a<String, String> aVar, a aVar2) {
        Object obj;
        b bVar2 = bVar;
        View view2 = view;
        a aVar3 = aVar2;
        Fragment fragment = bVar2.f3489a;
        final Fragment fragment2 = bVar2.f3492d;
        v a2 = a(fragment2, fragment);
        if (a2 != null) {
            boolean z2 = bVar2.f3490b;
            boolean z3 = bVar2.f3493e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object a3 = a(a2, fragment, z2);
            Object b2 = b(a2, fragment2, z3);
            ArrayList arrayList3 = arrayList2;
            Object a4 = a(a2, viewGroup, view, aVar, bVar, (ArrayList<View>) arrayList2, (ArrayList<View>) arrayList, a3, b2);
            Object obj2 = a3;
            if (obj2 == null && a4 == null) {
                obj = b2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = b2;
            }
            ArrayList<View> a5 = a(a2, obj, fragment2, (ArrayList<View>) arrayList3, view2);
            ArrayList<View> a6 = a(a2, obj2, fragment, (ArrayList<View>) arrayList, view2);
            a(a6, 4);
            Fragment fragment3 = fragment;
            ArrayList<View> arrayList4 = a5;
            Object a7 = a(a2, obj2, obj, a4, fragment3, z2);
            if (!(fragment2 == null || arrayList4 == null || (arrayList4.size() <= 0 && arrayList3.size() <= 0))) {
                final androidx.core.os.b bVar3 = new androidx.core.os.b();
                final a aVar4 = aVar2;
                aVar4.a(fragment2, bVar3);
                a2.a(fragment2, a7, bVar3, new Runnable() {
                    public void run() {
                        a.this.b(fragment2, bVar3);
                    }
                });
            }
            if (a7 != null) {
                a(a2, obj, fragment2, arrayList4);
                ArrayList<String> a8 = a2.a((ArrayList<View>) arrayList);
                v vVar = a2;
                vVar.a(a7, obj2, a6, obj, arrayList4, a4, arrayList);
                ViewGroup viewGroup2 = viewGroup;
                a2.a(viewGroup2, a7);
                vVar.a(viewGroup2, arrayList3, arrayList, a8, aVar);
                a(a6, 0);
                a2.a(a4, (ArrayList<View>) arrayList3, (ArrayList<View>) arrayList);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z2, j.a<String, View> aVar, boolean z3) {
        n enterTransitionCallback = z2 ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(aVar.b(i2));
                arrayList.add(aVar.c(i2));
            }
            if (z3) {
                enterTransitionCallback.a((List<String>) arrayList2, (List<View>) arrayList, (List<View>) null);
            } else {
                enterTransitionCallback.b(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    public static void a(a aVar, SparseArray<b> sparseArray, boolean z2) {
        int size = aVar.f3427d.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(aVar, (s.a) aVar.f3427d.get(i2), sparseArray, false, z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0070, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x008a, code lost:
        if (r0.mHidden == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008c, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(androidx.fragment.app.a r8, androidx.fragment.app.s.a r9, android.util.SparseArray<androidx.fragment.app.t.b> r10, boolean r11, boolean r12) {
        /*
            androidx.fragment.app.Fragment r0 = r9.f3445b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r1 = r0.mContainerId
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r11 == 0) goto L_0x0013
            int[] r2 = f3454c
            int r9 = r9.f3444a
            r9 = r2[r9]
            goto L_0x0015
        L_0x0013:
            int r9 = r9.f3444a
        L_0x0015:
            r2 = 0
            r3 = 1
            if (r9 == r3) goto L_0x007f
            r4 = 3
            if (r9 == r4) goto L_0x0057
            r4 = 4
            if (r9 == r4) goto L_0x003f
            r4 = 5
            if (r9 == r4) goto L_0x002d
            r4 = 6
            if (r9 == r4) goto L_0x0057
            r4 = 7
            if (r9 == r4) goto L_0x007f
            r9 = 0
            r3 = 0
        L_0x002a:
            r4 = 0
            goto L_0x0092
        L_0x002d:
            if (r12 == 0) goto L_0x003c
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x008e
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008e
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x008e
            goto L_0x008c
        L_0x003c:
            boolean r9 = r0.mHidden
            goto L_0x008f
        L_0x003f:
            if (r12 == 0) goto L_0x004e
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mHidden
            if (r9 == 0) goto L_0x0072
        L_0x004d:
            goto L_0x0070
        L_0x004e:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0072
            goto L_0x004d
        L_0x0057:
            boolean r9 = r0.mAdded
            if (r12 == 0) goto L_0x0074
            if (r9 != 0) goto L_0x0072
            android.view.View r9 = r0.mView
            if (r9 == 0) goto L_0x0072
            android.view.View r9 = r0.mView
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x0072
            float r9 = r0.mPostponedAlpha
            r4 = 0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0072
        L_0x0070:
            r9 = 1
            goto L_0x007b
        L_0x0072:
            r9 = 0
            goto L_0x007b
        L_0x0074:
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0072
            goto L_0x0070
        L_0x007b:
            r4 = r9
            r9 = 1
            r3 = 0
            goto L_0x0092
        L_0x007f:
            if (r12 == 0) goto L_0x0084
            boolean r9 = r0.mIsNewlyAdded
            goto L_0x008f
        L_0x0084:
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x008e
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008e
        L_0x008c:
            r9 = 1
            goto L_0x008f
        L_0x008e:
            r9 = 0
        L_0x008f:
            r2 = r9
            r9 = 0
            goto L_0x002a
        L_0x0092:
            java.lang.Object r5 = r10.get(r1)
            androidx.fragment.app.t$b r5 = (androidx.fragment.app.t.b) r5
            if (r2 == 0) goto L_0x00a4
            androidx.fragment.app.t$b r5 = a((androidx.fragment.app.t.b) r5, (android.util.SparseArray<androidx.fragment.app.t.b>) r10, (int) r1)
            r5.f3489a = r0
            r5.f3490b = r11
            r5.f3491c = r8
        L_0x00a4:
            r2 = 0
            if (r12 != 0) goto L_0x00c5
            if (r3 == 0) goto L_0x00c5
            if (r5 == 0) goto L_0x00b1
            androidx.fragment.app.Fragment r3 = r5.f3492d
            if (r3 != r0) goto L_0x00b1
            r5.f3492d = r2
        L_0x00b1:
            boolean r3 = r8.f3442s
            if (r3 != 0) goto L_0x00c5
            androidx.fragment.app.FragmentManager r3 = r8.f3316a
            androidx.fragment.app.p r6 = r3.i(r0)
            androidx.fragment.app.r r7 = r3.p()
            r7.a((androidx.fragment.app.p) r6)
            r3.g(r0)
        L_0x00c5:
            if (r4 == 0) goto L_0x00d7
            if (r5 == 0) goto L_0x00cd
            androidx.fragment.app.Fragment r3 = r5.f3492d
            if (r3 != 0) goto L_0x00d7
        L_0x00cd:
            androidx.fragment.app.t$b r5 = a((androidx.fragment.app.t.b) r5, (android.util.SparseArray<androidx.fragment.app.t.b>) r10, (int) r1)
            r5.f3492d = r0
            r5.f3493e = r11
            r5.f3494f = r8
        L_0x00d7:
            if (r12 != 0) goto L_0x00e3
            if (r9 == 0) goto L_0x00e3
            if (r5 == 0) goto L_0x00e3
            androidx.fragment.app.Fragment r8 = r5.f3489a
            if (r8 != r0) goto L_0x00e3
            r5.f3489a = r2
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.t.a(androidx.fragment.app.a, androidx.fragment.app.s$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static void a(v vVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final v vVar2 = vVar;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ViewGroup viewGroup2 = viewGroup;
        x.a(viewGroup, new Runnable() {
            public void run() {
                Object obj = obj3;
                if (obj != null) {
                    vVar2.c(obj, view2);
                    arrayList5.addAll(t.a(vVar2, obj3, fragment2, (ArrayList<View>) arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        vVar2.b(obj4, (ArrayList<View>) arrayList6, (ArrayList<View>) arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static void a(v vVar, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            vVar.b(obj, fragment.getView(), arrayList);
            x.a(fragment.mContainer, new Runnable() {
                public void run() {
                    t.a((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    private static void a(v vVar, Object obj, Object obj2, j.a<String, View> aVar, boolean z2, a aVar2) {
        if (aVar2.f3440q != null && !aVar2.f3440q.isEmpty()) {
            View view = aVar.get((String) (z2 ? aVar2.f3441r : aVar2.f3440q).get(0));
            vVar.a(obj, view);
            if (obj2 != null) {
                vVar.a(obj2, view);
            }
        }
    }

    static void a(j.a<String, String> aVar, j.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    static void a(ArrayList<View> arrayList, int i2) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i2);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, j.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (collection.contains(ac.u(c2))) {
                arrayList.add(c2);
            }
        }
    }

    static boolean a() {
        return (f3452a == null && f3453b == null) ? false : true;
    }

    private static boolean a(v vVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!vVar.a(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static v b() {
        try {
            return (v) Class.forName("androidx.transition.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static j.a<String, View> b(v vVar, j.a<String, String> aVar, Object obj, b bVar) {
        n nVar;
        ArrayList arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = bVar.f3492d;
        j.a<String, View> aVar2 = new j.a<>();
        vVar.a((Map<String, View>) aVar2, fragment.requireView());
        a aVar3 = bVar.f3494f;
        if (bVar.f3493e) {
            nVar = fragment.getEnterTransitionCallback();
            arrayList = aVar3.f3441r;
        } else {
            nVar = fragment.getExitTransitionCallback();
            arrayList = aVar3.f3440q;
        }
        if (arrayList != null) {
            aVar2.a(arrayList);
        }
        if (nVar != null) {
            nVar.a((List<String>) arrayList, (Map<String, View>) aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(ac.u(view))) {
                    aVar.put(ac.u(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a(aVar2.keySet());
        }
        return aVar2;
    }

    private static Object b(v vVar, ViewGroup viewGroup, View view, j.a<String, String> aVar, b bVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        j.a<String, String> aVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        v vVar2 = vVar;
        b bVar2 = bVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = bVar2.f3489a;
        Fragment fragment2 = bVar2.f3492d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z2 = bVar2.f3490b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            obj3 = null;
        } else {
            obj3 = a(vVar2, fragment, fragment2, z2);
            aVar2 = aVar;
        }
        j.a<String, View> b2 = b(vVar2, aVar2, obj3, bVar2);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b2.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(fragment, fragment2, z2, b2, true);
        if (obj4 != null) {
            rect = new Rect();
            vVar2.a(obj4, view, arrayList3);
            a(vVar, obj4, obj2, b2, bVar2.f3493e, bVar2.f3494f);
            if (obj5 != null) {
                vVar2.a(obj5, rect);
            }
        } else {
            rect = null;
        }
        final v vVar3 = vVar;
        final j.a<String, String> aVar3 = aVar;
        final Object obj6 = obj4;
        final b bVar3 = bVar;
        AnonymousClass6 r13 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z3 = z2;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj7 = obj;
        final Rect rect2 = rect;
        AnonymousClass6 r0 = new Runnable() {
            public void run() {
                j.a<String, View> a2 = t.a(v.this, (j.a<String, String>) aVar3, obj6, bVar3);
                if (a2 != null) {
                    arrayList4.addAll(a2.values());
                    arrayList4.add(view2);
                }
                t.a(fragment3, fragment4, z3, a2, false);
                Object obj = obj6;
                if (obj != null) {
                    v.this.a(obj, (ArrayList<View>) arrayList5, (ArrayList<View>) arrayList4);
                    View a3 = t.a(a2, bVar3, obj7, z3);
                    if (a3 != null) {
                        v.this.a(a3, rect2);
                    }
                }
            }
        };
        x.a(viewGroup, r13);
        return obj4;
    }

    private static Object b(v vVar, Fragment fragment, boolean z2) {
        if (fragment == null) {
            return null;
        }
        return vVar.b(z2 ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static void b(ViewGroup viewGroup, b bVar, View view, j.a<String, String> aVar, a aVar2) {
        Object obj;
        ViewGroup viewGroup2 = viewGroup;
        b bVar2 = bVar;
        View view2 = view;
        j.a<String, String> aVar3 = aVar;
        final a aVar4 = aVar2;
        Fragment fragment = bVar2.f3489a;
        final Fragment fragment2 = bVar2.f3492d;
        v a2 = a(fragment2, fragment);
        if (a2 != null) {
            boolean z2 = bVar2.f3490b;
            boolean z3 = bVar2.f3493e;
            Object a3 = a(a2, fragment, z2);
            Object b2 = b(a2, fragment2, z3);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = b2;
            v vVar = a2;
            Object b3 = b(a2, viewGroup, view, aVar, bVar, arrayList, arrayList2, a3, obj2);
            Object obj3 = a3;
            if (obj3 == null && b3 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList<View> a4 = a(vVar, obj, fragment2, (ArrayList<View>) arrayList4, view2);
            if (a4 == null || a4.isEmpty()) {
                obj = null;
            }
            Object obj4 = obj;
            vVar.b(obj3, view2);
            Object a5 = a(vVar, obj3, obj4, b3, fragment, bVar2.f3490b);
            if (!(fragment2 == null || a4 == null || (a4.size() <= 0 && arrayList4.size() <= 0))) {
                final androidx.core.os.b bVar3 = new androidx.core.os.b();
                aVar4.a(fragment2, bVar3);
                vVar.a(fragment2, a5, bVar3, new Runnable() {
                    public void run() {
                        a.this.b(fragment2, bVar3);
                    }
                });
            }
            if (a5 != null) {
                ArrayList arrayList5 = new ArrayList();
                v vVar2 = vVar;
                vVar2.a(a5, obj3, arrayList5, obj4, a4, b3, arrayList2);
                a(vVar2, viewGroup, fragment, view, (ArrayList<View>) arrayList2, obj3, (ArrayList<View>) arrayList5, obj4, a4);
                ViewGroup viewGroup3 = viewGroup;
                v vVar3 = vVar;
                ArrayList arrayList6 = arrayList2;
                vVar3.a((View) viewGroup3, (ArrayList<View>) arrayList6, (Map<String, String>) aVar3);
                vVar3.a(viewGroup3, a5);
                vVar3.a(viewGroup3, (ArrayList<View>) arrayList6, (Map<String, String>) aVar3);
            }
        }
    }

    public static void b(a aVar, SparseArray<b> sparseArray, boolean z2) {
        if (aVar.f3316a.o().a()) {
            for (int size = aVar.f3427d.size() - 1; size >= 0; size--) {
                a(aVar, (s.a) aVar.f3427d.get(size), sparseArray, true, z2);
            }
        }
    }
}
