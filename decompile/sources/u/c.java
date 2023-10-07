package u;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R;
import com.blankj.utilcode.constant.MemoryConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u.f;

public class c {

    /* renamed from: d  reason: collision with root package name */
    private static int f34527d;

    /* renamed from: a  reason: collision with root package name */
    public int f34528a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityNodeInfo f34529b;

    /* renamed from: c  reason: collision with root package name */
    private int f34530c = -1;

    public static class a {
        public static final a A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a C = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a D = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a E = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a F = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a G = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a H = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (f) null, f.C0259f.class);
        public static final a I = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (f) null, f.d.class);
        public static final a J = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a K = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a L = new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a M;

        /* renamed from: a  reason: collision with root package name */
        public static final a f34531a = new a(1, (CharSequence) null);

        /* renamed from: b  reason: collision with root package name */
        public static final a f34532b = new a(2, (CharSequence) null);

        /* renamed from: c  reason: collision with root package name */
        public static final a f34533c = new a(4, (CharSequence) null);

        /* renamed from: d  reason: collision with root package name */
        public static final a f34534d = new a(8, (CharSequence) null);

        /* renamed from: e  reason: collision with root package name */
        public static final a f34535e = new a(16, (CharSequence) null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f34536f = new a(32, (CharSequence) null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f34537g = new a(64, (CharSequence) null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f34538h = new a(128, (CharSequence) null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f34539i = new a(256, (CharSequence) null, (Class<? extends f.a>) f.b.class);

        /* renamed from: j  reason: collision with root package name */
        public static final a f34540j = new a(512, (CharSequence) null, (Class<? extends f.a>) f.b.class);

        /* renamed from: k  reason: collision with root package name */
        public static final a f34541k = new a(1024, (CharSequence) null, (Class<? extends f.a>) f.c.class);

        /* renamed from: l  reason: collision with root package name */
        public static final a f34542l = new a(2048, (CharSequence) null, (Class<? extends f.a>) f.c.class);

        /* renamed from: m  reason: collision with root package name */
        public static final a f34543m = new a(4096, (CharSequence) null);

        /* renamed from: n  reason: collision with root package name */
        public static final a f34544n = new a(8192, (CharSequence) null);

        /* renamed from: o  reason: collision with root package name */
        public static final a f34545o = new a(16384, (CharSequence) null);

        /* renamed from: p  reason: collision with root package name */
        public static final a f34546p = new a(32768, (CharSequence) null);

        /* renamed from: q  reason: collision with root package name */
        public static final a f34547q = new a(65536, (CharSequence) null);

        /* renamed from: r  reason: collision with root package name */
        public static final a f34548r = new a(131072, (CharSequence) null, (Class<? extends f.a>) f.g.class);

        /* renamed from: s  reason: collision with root package name */
        public static final a f34549s = new a(262144, (CharSequence) null);

        /* renamed from: t  reason: collision with root package name */
        public static final a f34550t = new a(524288, (CharSequence) null);

        /* renamed from: u  reason: collision with root package name */
        public static final a f34551u = new a(MemoryConstants.MB, (CharSequence) null);

        /* renamed from: v  reason: collision with root package name */
        public static final a f34552v = new a(2097152, (CharSequence) null, (Class<? extends f.a>) f.h.class);

        /* renamed from: w  reason: collision with root package name */
        public static final a f34553w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (CharSequence) null, (f) null, (Class<? extends f.a>) null);

        /* renamed from: x  reason: collision with root package name */
        public static final a f34554x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (CharSequence) null, (f) null, f.e.class);

        /* renamed from: y  reason: collision with root package name */
        public static final a f34555y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (CharSequence) null, (f) null, (Class<? extends f.a>) null);

        /* renamed from: z  reason: collision with root package name */
        public static final a f34556z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        final Object N;
        protected final f O;
        private final int P;
        private final Class<? extends f.a> Q;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            if (Build.VERSION.SDK_INT >= 30) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            }
            M = new a(accessibilityAction, 16908372, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        }

        public a(int i2, CharSequence charSequence) {
            this((Object) null, i2, charSequence, (f) null, (Class<? extends f.a>) null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends f.a> cls) {
            this((Object) null, i2, charSequence, (f) null, cls);
        }

        public a(int i2, CharSequence charSequence, f fVar) {
            this((Object) null, i2, charSequence, fVar, (Class<? extends f.a>) null);
        }

        a(Object obj) {
            this(obj, 0, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        }

        a(Object obj, int i2, CharSequence charSequence, f fVar, Class<? extends f.a> cls) {
            this.P = i2;
            this.O = fVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                obj = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            }
            this.N = obj;
            this.Q = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.N).getId();
            }
            return 0;
        }

        public a a(CharSequence charSequence, f fVar) {
            return new a((Object) null, this.P, charSequence, fVar, this.Q);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                u.f r0 = r4.O
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends u.f$a> r2 = r4.Q
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                u.f$a r1 = (u.f.a) r1     // Catch:{ Exception -> 0x0020 }
                r1.a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends u.f$a> r1 = r4.Q
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r1, r6)
            L_0x0042:
                u.f r6 = r4.O
                boolean r5 = r6.a(r5, r0)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: u.c.a.a(android.view.View, android.os.Bundle):boolean");
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.N).getLabel();
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.N;
            Object obj3 = ((a) obj).N;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.N;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f34557a;

        b(Object obj) {
            this.f34557a = obj;
        }

        public static b a(int i2, int i3, boolean z2) {
            return Build.VERSION.SDK_INT >= 19 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z2)) : new b((Object) null);
        }

        public static b a(int i2, int i3, boolean z2, int i4) {
            return Build.VERSION.SDK_INT >= 21 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z2, i4)) : Build.VERSION.SDK_INT >= 19 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z2)) : new b((Object) null);
        }
    }

    /* renamed from: u.c$c  reason: collision with other inner class name */
    public static class C0258c {

        /* renamed from: a  reason: collision with root package name */
        final Object f34558a;

        C0258c(Object obj) {
            this.f34558a = obj;
        }

        public static C0258c a(int i2, int i3, int i4, int i5, boolean z2, boolean z3) {
            return Build.VERSION.SDK_INT >= 21 ? new C0258c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z2, z3)) : Build.VERSION.SDK_INT >= 19 ? new C0258c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z2)) : new C0258c((Object) null);
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        final Object f34559a;

        d(Object obj) {
            this.f34559a = obj;
        }

        public static d a(int i2, float f2, float f3, float f4) {
            return Build.VERSION.SDK_INT >= 19 ? new d(AccessibilityNodeInfo.RangeInfo.obtain(i2, f2, f3, f4)) : new d((Object) null);
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f34529b = accessibilityNodeInfo;
    }

    private boolean A() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private void B() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f34529b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f34529b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f34529b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f34527d;
        f34527d = i3 + 1;
        return i3;
    }

    private List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f34529b.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f34529b.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public static c a(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    public static c a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static c a(c cVar) {
        return a(AccessibilityNodeInfo.obtain(cVar.f34529b));
    }

    private void a(int i2, boolean z2) {
        Bundle y2 = y();
        if (y2 != null) {
            int i3 = y2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i2 ^ -1);
            if (!z2) {
                i2 = 0;
            }
            y2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
    }

    public static c b() {
        return a(AccessibilityNodeInfo.obtain());
    }

    private boolean d(int i2) {
        Bundle y2 = y();
        return y2 != null && (y2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i2) == i2;
    }

    public static ClickableSpan[] d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private static String e(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908372:
                return "ACTION_IME_ENTER";
            default:
                switch (i2) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    private SparseArray<WeakReference<ClickableSpan>> f(View view) {
        SparseArray<WeakReference<ClickableSpan>> g2 = g(view);
        if (g2 != null) {
            return g2;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(R.id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> g(View view) {
        return (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
    }

    private void h(View view) {
        SparseArray<WeakReference<ClickableSpan>> g2 = g(view);
        if (g2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < g2.size(); i2++) {
                if (g2.valueAt(i2).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                g2.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    public AccessibilityNodeInfo a() {
        return this.f34529b;
    }

    public void a(int i2) {
        this.f34529b.addAction(i2);
    }

    @Deprecated
    public void a(Rect rect) {
        this.f34529b.getBoundsInParent(rect);
    }

    public void a(View view, int i2) {
        this.f34530c = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f34529b.setSource(view, i2);
        }
    }

    public void a(CharSequence charSequence) {
        this.f34529b.setPackageName(charSequence);
    }

    public void a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 26) {
            B();
            h(view);
            ClickableSpan[] d2 = d(charSequence);
            if (d2 != null && d2.length > 0) {
                y().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> f2 = f(view);
                int i2 = 0;
                while (d2 != null && i2 < d2.length) {
                    int a2 = a(d2[i2], f2);
                    f2.put(a2, new WeakReference(d2[i2]));
                    a(d2[i2], (Spanned) charSequence, a2);
                    i2++;
                }
            }
        }
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f34557a);
        }
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f34529b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.N);
        }
    }

    public void a(d dVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.setRangeInfo((AccessibilityNodeInfo.RangeInfo) dVar.f34559a);
        }
    }

    public void a(boolean z2) {
        this.f34529b.setCheckable(z2);
    }

    public boolean a(int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f34529b.performAction(i2, bundle);
        }
        return false;
    }

    public void b(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f34529b.setMovementGranularities(i2);
        }
    }

    @Deprecated
    public void b(Rect rect) {
        this.f34529b.setBoundsInParent(rect);
    }

    public void b(View view) {
        this.f34530c = -1;
        this.f34529b.setSource(view);
    }

    public void b(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f34529b.addChild(view, i2);
        }
    }

    public void b(CharSequence charSequence) {
        this.f34529b.setClassName(charSequence);
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0258c) obj).f34558a);
        }
    }

    public void b(boolean z2) {
        this.f34529b.setChecked(z2);
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f34529b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.N);
        }
        return false;
    }

    public int c() {
        return this.f34529b.getChildCount();
    }

    public void c(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f34529b.setMaxTextLength(i2);
        }
    }

    public void c(Rect rect) {
        this.f34529b.getBoundsInScreen(rect);
    }

    public void c(View view) {
        this.f34529b.addChild(view);
    }

    public void c(View view, int i2) {
        this.f34528a = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f34529b.setParent(view, i2);
        }
    }

    public void c(CharSequence charSequence) {
        this.f34529b.setText(charSequence);
    }

    public void c(boolean z2) {
        this.f34529b.setFocusable(z2);
    }

    public int d() {
        return this.f34529b.getActions();
    }

    public void d(Rect rect) {
        this.f34529b.setBoundsInScreen(rect);
    }

    public void d(View view) {
        this.f34528a = -1;
        this.f34529b.setParent(view);
    }

    public void d(boolean z2) {
        this.f34529b.setFocused(z2);
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f34529b.getMovementGranularities();
        }
        return 0;
    }

    public void e(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f34529b.setTraversalAfter(view);
        }
    }

    public void e(CharSequence charSequence) {
        this.f34529b.setContentDescription(charSequence);
    }

    public void e(boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f34529b.setVisibleToUser(z2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f34529b;
        if (accessibilityNodeInfo == null) {
            if (cVar.f34529b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f34529b)) {
            return false;
        }
        return this.f34530c == cVar.f34530c && this.f34528a == cVar.f34528a;
    }

    public void f(CharSequence charSequence) {
        if (androidx.core.os.a.a()) {
            this.f34529b.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void f(boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f34529b.setAccessibilityFocused(z2);
        }
    }

    public boolean f() {
        return this.f34529b.isCheckable();
    }

    public void g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f34529b.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void g(boolean z2) {
        this.f34529b.setSelected(z2);
    }

    public boolean g() {
        return this.f34529b.isChecked();
    }

    public void h(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f34529b.setError(charSequence);
        }
    }

    public void h(boolean z2) {
        this.f34529b.setClickable(z2);
    }

    public boolean h() {
        return this.f34529b.isFocusable();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f34529b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f34529b.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void i(boolean z2) {
        this.f34529b.setLongClickable(z2);
    }

    public boolean i() {
        return this.f34529b.isFocused();
    }

    public void j(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public void j(boolean z2) {
        this.f34529b.setEnabled(z2);
    }

    public boolean j() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f34529b.isVisibleToUser();
        }
        return false;
    }

    public void k(boolean z2) {
        this.f34529b.setScrollable(z2);
    }

    public boolean k() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f34529b.isAccessibilityFocused();
        }
        return false;
    }

    public void l(boolean z2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.setCanOpenPopup(z2);
        }
    }

    public boolean l() {
        return this.f34529b.isSelected();
    }

    public void m(boolean z2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f34529b.setDismissable(z2);
        }
    }

    public boolean m() {
        return this.f34529b.isClickable();
    }

    public void n(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f34529b.setScreenReaderFocusable(z2);
        } else {
            a(1, z2);
        }
    }

    public boolean n() {
        return this.f34529b.isLongClickable();
    }

    public void o(boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f34529b.setShowingHintText(z2);
        } else {
            a(4, z2);
        }
    }

    public boolean o() {
        return this.f34529b.isEnabled();
    }

    public void p(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f34529b.setHeading(z2);
        } else {
            a(2, z2);
        }
    }

    public boolean p() {
        return this.f34529b.isPassword();
    }

    public boolean q() {
        return this.f34529b.isScrollable();
    }

    public CharSequence r() {
        return this.f34529b.getPackageName();
    }

    public CharSequence s() {
        return this.f34529b.getClassName();
    }

    public CharSequence t() {
        if (!A()) {
            return this.f34529b.getText();
        }
        List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f34529b.getText(), 0, this.f34529b.getText().length()));
        for (int i2 = 0; i2 < a2.size(); i2++) {
            spannableString.setSpan(new a(a5.get(i2).intValue(), this, y().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i2).intValue(), a3.get(i2).intValue(), a4.get(i2).intValue());
        }
        return spannableString;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(r());
        sb.append("; className: ");
        sb.append(s());
        sb.append("; text: ");
        sb.append(t());
        sb.append("; contentDescription: ");
        sb.append(u());
        sb.append("; viewId: ");
        sb.append(w());
        sb.append("; checkable: ");
        sb.append(f());
        sb.append("; checked: ");
        sb.append(g());
        sb.append("; focusable: ");
        sb.append(h());
        sb.append("; focused: ");
        sb.append(i());
        sb.append("; selected: ");
        sb.append(l());
        sb.append("; clickable: ");
        sb.append(m());
        sb.append("; longClickable: ");
        sb.append(n());
        sb.append("; enabled: ");
        sb.append(o());
        sb.append("; password: ");
        sb.append(p());
        sb.append("; scrollable: " + q());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> x2 = x();
            for (int i2 = 0; i2 < x2.size(); i2++) {
                a aVar = x2.get(i2);
                String e2 = e(aVar.a());
                if (e2.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    e2 = aVar.b().toString();
                }
                sb.append(e2);
                if (i2 != x2.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int d2 = d();
            while (d2 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(d2);
                d2 &= numberOfTrailingZeros ^ -1;
                sb.append(e(numberOfTrailingZeros));
                if (d2 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.f34529b.getContentDescription();
    }

    public void v() {
        this.f34529b.recycle();
    }

    public String w() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f34529b.getViewIdResourceName();
        }
        return null;
    }

    public List<a> x() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f34529b.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new a(actionList.get(i2)));
        }
        return arrayList;
    }

    public Bundle y() {
        return Build.VERSION.SDK_INT >= 19 ? this.f34529b.getExtras() : new Bundle();
    }

    public boolean z() {
        return Build.VERSION.SDK_INT >= 26 ? this.f34529b.isShowingHintText() : d(4);
    }
}
