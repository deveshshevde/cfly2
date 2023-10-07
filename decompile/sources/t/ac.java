package t;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import t.a;
import t.ak;
import u.c;

public class ac {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f34405a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static Field f34406b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f34407c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f34408d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f34409e;

    /* renamed from: f  reason: collision with root package name */
    private static WeakHashMap<View, String> f34410f;

    /* renamed from: g  reason: collision with root package name */
    private static WeakHashMap<View, ag> f34411g = null;

    /* renamed from: h  reason: collision with root package name */
    private static Field f34412h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f34413i = false;

    /* renamed from: j  reason: collision with root package name */
    private static ThreadLocal<Rect> f34414j;

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f34415k = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: l  reason: collision with root package name */
    private static final w f34416l = new w() {
        public c a(c cVar) {
            return cVar;
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private static a f34417m = new a();

    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f34418a = new WeakHashMap<>();

        a() {
        }

        private void a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void a(View view, boolean z2) {
            boolean z3 = view.getVisibility() == 0;
            if (z2 != z3) {
                ac.g(view, z3 ? 16 : 32);
                this.f34418a.put(view, Boolean.valueOf(z3));
            }
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry next : this.f34418a.entrySet()) {
                    a((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            a(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f34419a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f34420b;

        /* renamed from: c  reason: collision with root package name */
        private final int f34421c;

        /* renamed from: d  reason: collision with root package name */
        private final int f34422d;

        b(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
        }

        b(int i2, Class<T> cls, int i3, int i4) {
            this.f34419a = i2;
            this.f34420b = cls;
            this.f34422d = i3;
            this.f34421c = i4;
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= this.f34421c;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(View view, T t2);

        /* access modifiers changed from: package-private */
        public boolean a(T t2, T t3) {
            return !t3.equals(t2);
        }

        /* access modifiers changed from: package-private */
        public abstract T b(View view);

        /* access modifiers changed from: package-private */
        public void b(View view, T t2) {
            if (a()) {
                a(view, t2);
            } else if (b() && a(c(view), (Object) t2)) {
                ac.c(view);
                view.setTag(this.f34419a, t2);
                ac.g(view, this.f34422d);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        /* access modifiers changed from: package-private */
        public T c(View view) {
            if (a()) {
                return b(view);
            }
            if (!b()) {
                return null;
            }
            T tag = view.getTag(this.f34419a);
            if (this.f34420b.isInstance(tag)) {
                return tag;
            }
            return null;
        }
    }

    private static class c {
        public static ak a(View view) {
            return ak.a.a(view);
        }

        static ak a(View view, ak akVar, Rect rect) {
            WindowInsets m2 = akVar.m();
            if (m2 != null) {
                return ak.a(view.computeSystemWindowInsets(m2, rect), view);
            }
            rect.setEmpty();
            return akVar;
        }

        static void a(final View view, final u uVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, uVar);
            }
            if (uVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {

                    /* renamed from: a  reason: collision with root package name */
                    ak f34423a = null;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ak a2 = ak.a(windowInsets, view);
                        if (Build.VERSION.SDK_INT < 30) {
                            c.a(windowInsets, view);
                            if (a2.equals(this.f34423a)) {
                                return uVar.a(view, a2).m();
                            }
                        }
                        this.f34423a = a2;
                        ak a3 = uVar.a(view, a2);
                        if (Build.VERSION.SDK_INT >= 30) {
                            return a3.m();
                        }
                        ac.w(view);
                        return a3.m();
                    }
                });
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }
    }

    private static class d {
        public static ak a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            ak a2 = ak.a(rootWindowInsets);
            a2.a(a2);
            a2.a(view.getRootView());
            return a2;
        }
    }

    private static class e {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public interface f {
        boolean a(View view, KeyEvent keyEvent);
    }

    static class g {

        /* renamed from: a  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f34426a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f34427b = null;

        /* renamed from: c  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f34428c = null;

        /* renamed from: d  reason: collision with root package name */
        private WeakReference<KeyEvent> f34429d = null;

        g() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.f34428c == null) {
                this.f34428c = new SparseArray<>();
            }
            return this.f34428c;
        }

        static g a(View view) {
            g gVar = (g) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (gVar != null) {
                return gVar;
            }
            g gVar2 = new g();
            view.setTag(R.id.tag_unhandled_key_event_manager, gVar2);
            return gVar2;
        }

        private View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f34427b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b2 = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b2 != null) {
                            return b2;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f34427b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f34426a;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f34427b == null) {
                        this.f34427b = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f34426a;
                        View view = (View) arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f34427b.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f34427b.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((f) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f34429d;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f34429d = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray<WeakReference<View>> a2 = a();
            if (keyEvent.getAction() == 1 && (indexOfKey = a2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = a2.valueAt(indexOfKey);
                a2.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = a2.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && ac.J(view)) {
                c(view, keyEvent);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b2 = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference(b2));
                }
            }
            return b2 != null;
        }
    }

    public static boolean A(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean B(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static ColorStateList C(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof aa) {
            return ((aa) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static PorterDuff.Mode D(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof aa) {
            return ((aa) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static boolean E(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof m) {
            return ((m) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static void F(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof m) {
            ((m) view).stopNestedScroll();
        }
    }

    public static boolean G(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float H(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static Rect I(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean J(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean K(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static Display L(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (J(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static boolean M(View view) {
        Boolean c2 = c().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    public static CharSequence N(View view) {
        return d().c(view);
    }

    public static boolean O(View view) {
        Boolean c2 = f().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    private static View.AccessibilityDelegate P(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : Q(view);
    }

    private static View.AccessibilityDelegate Q(View view) {
        if (f34413i) {
            return null;
        }
        if (f34412h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f34412h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f34413i = true;
                return null;
            }
        }
        try {
            Object obj = f34412h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f34413i = true;
            return null;
        }
    }

    private static List<c.a> R(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    private static w S(View view) {
        return view instanceof w ? (w) view : f34416l;
    }

    private static void T(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    private static void U(View view) {
        if (f(view) == 0) {
            b(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (f((View) parent) == 4) {
                b(view, 2);
                return;
            }
        }
    }

    public static int a() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f34405a;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static int a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int a(View view, CharSequence charSequence, u.f fVar) {
        int b2 = b(view, charSequence);
        if (b2 != -1) {
            a(view, new c.a(b2, charSequence, fVar));
        }
        return b2;
    }

    public static ak a(View view, ak akVar) {
        WindowInsets m2;
        if (Build.VERSION.SDK_INT >= 21 && (m2 = akVar.m()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(m2);
            if (!onApplyWindowInsets.equals(m2)) {
                return ak.a(onApplyWindowInsets, view);
            }
        }
        return akVar;
    }

    public static ak a(View view, ak akVar, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? c.a(view, akVar, rect) : akVar;
    }

    public static c a(View view, c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        v vVar = (v) view.getTag(R.id.tag_on_receive_content_listener);
        if (vVar == null) {
            return S(view).a(cVar);
        }
        c a2 = vVar.a(view, cVar);
        if (a2 == null) {
            return null;
        }
        return S(view).a(a2);
    }

    private static void a(int i2, View view) {
        List<c.a> R = R(view);
        for (int i3 = 0; i3 < R.size(); i3++) {
            if (R.get(i3).a() == i2) {
                R.remove(i3);
                return;
            }
        }
    }

    @Deprecated
    public static void a(View view, float f2) {
        view.setTranslationX(f2);
    }

    public static void a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static void a(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    public static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            e.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z2 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z2) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof aa) {
            ((aa) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void a(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z2 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z2) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof aa) {
            ((aa) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            e().b(view, charSequence);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f34410f == null) {
            f34410f = new WeakHashMap<>();
        }
        f34410f.put(view, str);
    }

    public static void a(View view, a aVar) {
        if (aVar == null && (P(view) instanceof a.C0256a)) {
            aVar = new a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.a());
    }

    public static void a(View view, u uVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.a(view, uVar);
        }
    }

    public static void a(View view, y yVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (yVar != null ? yVar.a() : null));
        }
    }

    private static void a(View view, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            c(view);
            a(aVar.a(), view);
            R(view).add(aVar);
            g(view, 0);
        }
    }

    public static void a(View view, c.a aVar, CharSequence charSequence, u.f fVar) {
        if (fVar == null && charSequence == null) {
            c(view, aVar.a());
        } else {
            a(view, aVar.a(charSequence, fVar));
        }
    }

    public static void a(View view, u.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.a());
    }

    public static void a(View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z2);
        }
    }

    public static boolean a(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.a(view).a(keyEvent);
    }

    private static int b(View view, CharSequence charSequence) {
        List<c.a> R = R(view);
        for (int i2 = 0; i2 < R.size(); i2++) {
            if (TextUtils.equals(charSequence, R.get(i2).b())) {
                return R.get(i2).a();
            }
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            int[] iArr = f34415k;
            if (i3 >= iArr.length || i4 != -1) {
                return i4;
            }
            int i5 = iArr[i3];
            boolean z2 = true;
            for (int i6 = 0; i6 < R.size(); i6++) {
                z2 &= R.get(i6).a() != i5;
            }
            if (z2) {
                i4 = i5;
            }
            i3++;
        }
        return i4;
    }

    private static Rect b() {
        if (f34414j == null) {
            f34414j = new ThreadLocal<>();
        }
        Rect rect = f34414j.get();
        if (rect == null) {
            rect = new Rect();
            f34414j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static a b(View view) {
        View.AccessibilityDelegate P = P(view);
        if (P == null) {
            return null;
        }
        return P instanceof a.C0256a ? ((a.C0256a) P).f34404a : new a(P);
    }

    public static ak b(View view, ak akVar) {
        WindowInsets m2;
        if (Build.VERSION.SDK_INT >= 21 && (m2 = akVar.m()) != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(m2);
            if (!dispatchApplyWindowInsets.equals(m2)) {
                return ak.a(dispatchApplyWindowInsets, view);
            }
        }
        return akVar;
    }

    @Deprecated
    public static void b(View view, float f2) {
        view.setTranslationY(f2);
    }

    public static void b(View view, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            if (i2 == 4) {
                i2 = 2;
            }
        }
        view.setImportantForAccessibility(i2);
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    @Deprecated
    public static void b(View view, boolean z2) {
        view.setFitsSystemWindows(z2);
    }

    static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.a(view).a(view, keyEvent);
    }

    static a c(View view) {
        a b2 = b(view);
        if (b2 == null) {
            b2 = new a();
        }
        a(view, b2);
        return b2;
    }

    private static b<Boolean> c() {
        return new b<Boolean>(R.id.tag_screen_reader_focusable, Boolean.class, 28) {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }

            /* access modifiers changed from: package-private */
            public void a(View view, Boolean bool) {
                view.setScreenReaderFocusable(bool.booleanValue());
            }

            /* access modifiers changed from: package-private */
            public boolean a(Boolean bool, Boolean bool2) {
                return !b(bool, bool2);
            }
        };
    }

    @Deprecated
    public static void c(View view, float f2) {
        view.setAlpha(f2);
    }

    public static void c(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i2, view);
            g(view, 0);
        }
    }

    public static void c(View view, boolean z2) {
        f().b(view, Boolean.valueOf(z2));
    }

    private static b<CharSequence> d() {
        return new b<CharSequence>(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28) {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public CharSequence b(View view) {
                return view.getAccessibilityPaneTitle();
            }

            /* access modifiers changed from: package-private */
            public void a(View view, CharSequence charSequence) {
                view.setAccessibilityPaneTitle(charSequence);
            }

            /* access modifiers changed from: package-private */
            public boolean a(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static void d(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static void d(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static boolean d(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    private static b<CharSequence> e() {
        return new b<CharSequence>(R.id.tag_state_description, CharSequence.class, 64, 30) {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public CharSequence b(View view) {
                return view.getStateDescription();
            }

            /* access modifiers changed from: package-private */
            public void a(View view, CharSequence charSequence) {
                view.setStateDescription(charSequence);
            }

            /* access modifiers changed from: package-private */
            public boolean a(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static void e(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void e(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static void e(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect b2 = b();
            boolean z2 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z2 = !b2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            h(view, i2);
            if (z2 && b2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b2);
            }
        } else {
            h(view, i2);
        }
    }

    public static int f(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    private static b<Boolean> f() {
        return new b<Boolean>(R.id.tag_accessibility_heading, Boolean.class, 28) {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }

            /* access modifiers changed from: package-private */
            public void a(View view, Boolean bool) {
                view.setAccessibilityHeading(bool.booleanValue());
            }

            /* access modifiers changed from: package-private */
            public boolean a(Boolean bool, Boolean bool2) {
                return !b(bool, bool2);
            }
        };
    }

    public static void f(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(f2);
        }
    }

    public static void f(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect b2 = b();
            boolean z2 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z2 = !b2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            i(view, i2);
            if (z2 && b2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b2);
            }
        } else {
            i(view, i2);
        }
    }

    public static final CharSequence g(View view) {
        return e().c(view);
    }

    static void g(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z2 = N(view) != null && view.getVisibility() == 0;
            int i3 = 32;
            if (k(view) != 0 || z2) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z2) {
                    i3 = 2048;
                }
                obtain.setEventType(i3);
                obtain.setContentChangeTypes(i2);
                if (z2) {
                    obtain.getText().add(N(view));
                    U(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(N(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    @Deprecated
    public static float h(View view) {
        return view.getAlpha();
    }

    private static void h(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            T(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                T((View) parent);
            }
        }
    }

    public static int i(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    private static void i(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            T(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                T((View) parent);
            }
        }
    }

    public static ViewParent j(View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    public static int k(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static int l(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    public static int m(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    @Deprecated
    public static float n(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float o(View view) {
        return view.getTranslationY();
    }

    public static int p(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f34407c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f34406b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f34407c = true;
        }
        Field field = f34406b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static int q(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f34409e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f34408d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f34409e = true;
        }
        Field field = f34408d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static ag r(View view) {
        if (f34411g == null) {
            f34411g = new WeakHashMap<>();
        }
        ag agVar = f34411g.get(view);
        if (agVar != null) {
            return agVar;
        }
        ag agVar2 = new ag(view);
        f34411g.put(view, agVar2);
        return agVar2;
    }

    public static float s(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static float t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static String u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f34410f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int v(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void w(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean x(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static ak y(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return d.a(view);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return c.a(view);
        }
        return null;
    }

    public static String[] z(View view) {
        return (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }
}
