package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.p;
import androidx.core.widget.h;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.reflect.Method;
import t.ac;

public class ListPopupWindow implements p {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1192a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f1193b;

    /* renamed from: h  reason: collision with root package name */
    private static Method f1194h;
    private AdapterView.OnItemClickListener A;
    private AdapterView.OnItemSelectedListener B;
    private final d C;
    private final c D;
    private final a E;
    private Runnable F;
    private final Rect G;
    private Rect H;
    private boolean I;

    /* renamed from: c  reason: collision with root package name */
    r f1195c;

    /* renamed from: d  reason: collision with root package name */
    int f1196d;

    /* renamed from: e  reason: collision with root package name */
    final e f1197e;

    /* renamed from: f  reason: collision with root package name */
    final Handler f1198f;

    /* renamed from: g  reason: collision with root package name */
    PopupWindow f1199g;

    /* renamed from: i  reason: collision with root package name */
    private Context f1200i;

    /* renamed from: j  reason: collision with root package name */
    private ListAdapter f1201j;

    /* renamed from: k  reason: collision with root package name */
    private int f1202k;

    /* renamed from: l  reason: collision with root package name */
    private int f1203l;

    /* renamed from: m  reason: collision with root package name */
    private int f1204m;

    /* renamed from: n  reason: collision with root package name */
    private int f1205n;

    /* renamed from: o  reason: collision with root package name */
    private int f1206o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1207p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1208q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1209r;

    /* renamed from: s  reason: collision with root package name */
    private int f1210s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1211t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f1212u;

    /* renamed from: v  reason: collision with root package name */
    private View f1213v;

    /* renamed from: w  reason: collision with root package name */
    private int f1214w;

    /* renamed from: x  reason: collision with root package name */
    private DataSetObserver f1215x;

    /* renamed from: y  reason: collision with root package name */
    private View f1216y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f1217z;

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ListPopupWindow.this.m();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.e()) {
                ListPopupWindow.this.c_();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.d();
        }
    }

    private class c implements AbsListView.OnScrollListener {
        c() {
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1 && !ListPopupWindow.this.n() && ListPopupWindow.this.f1199g.getContentView() != null) {
                ListPopupWindow.this.f1198f.removeCallbacks(ListPopupWindow.this.f1197e);
                ListPopupWindow.this.f1197e.run();
            }
        }
    }

    private class d implements View.OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.f1199g != null && ListPopupWindow.this.f1199g.isShowing() && x2 >= 0 && x2 < ListPopupWindow.this.f1199g.getWidth() && y2 >= 0 && y2 < ListPopupWindow.this.f1199g.getHeight()) {
                ListPopupWindow.this.f1198f.postDelayed(ListPopupWindow.this.f1197e, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow.this.f1198f.removeCallbacks(ListPopupWindow.this.f1197e);
                return false;
            }
        }
    }

    private class e implements Runnable {
        e() {
        }

        public void run() {
            if (ListPopupWindow.this.f1195c != null && ac.J(ListPopupWindow.this.f1195c) && ListPopupWindow.this.f1195c.getCount() > ListPopupWindow.this.f1195c.getChildCount() && ListPopupWindow.this.f1195c.getChildCount() <= ListPopupWindow.this.f1196d) {
                ListPopupWindow.this.f1199g.setInputMethodMode(2);
                ListPopupWindow.this.c_();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f1192a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f1194h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                f1193b = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f1202k = -2;
        this.f1203l = -2;
        this.f1206o = 1002;
        this.f1210s = 0;
        this.f1211t = false;
        this.f1212u = false;
        this.f1196d = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1214w = 0;
        this.f1197e = new e();
        this.C = new d();
        this.D = new c();
        this.E = new a();
        this.G = new Rect();
        this.f1200i = context;
        this.f1198f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i2, i3);
        this.f1204m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1205n = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1207p = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i2, i3);
        this.f1199g = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    private int a(View view, int i2, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.f1199g.getMaxAvailableHeight(view, i2, z2);
        }
        Method method = f1193b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f1199g, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z2)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1199g.getMaxAvailableHeight(view, i2);
    }

    private void c(boolean z2) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1192a;
            if (method != null) {
                try {
                    method.invoke(this.f1199g, new Object[]{Boolean.valueOf(z2)});
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.f1199g.setIsClippedToScreen(z2);
        }
    }

    private void h() {
        View view = this.f1213v;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1213v);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.r} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int i() {
        /*
            r12 = this;
            androidx.appcompat.widget.r r0 = r12.f1195c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00bf
            android.content.Context r0 = r12.f1200i
            androidx.appcompat.widget.ListPopupWindow$1 r5 = new androidx.appcompat.widget.ListPopupWindow$1
            r5.<init>()
            r12.F = r5
            boolean r5 = r12.I
            r5 = r5 ^ r3
            androidx.appcompat.widget.r r5 = r12.a(r0, r5)
            r12.f1195c = r5
            android.graphics.drawable.Drawable r6 = r12.f1217z
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.r r5 = r12.f1195c
            android.widget.ListAdapter r6 = r12.f1201j
            r5.setAdapter(r6)
            androidx.appcompat.widget.r r5 = r12.f1195c
            android.widget.AdapterView$OnItemClickListener r6 = r12.A
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.r r5 = r12.f1195c
            r5.setFocusable(r3)
            androidx.appcompat.widget.r r5 = r12.f1195c
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.r r5 = r12.f1195c
            androidx.appcompat.widget.ListPopupWindow$2 r6 = new androidx.appcompat.widget.ListPopupWindow$2
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.r r5 = r12.f1195c
            androidx.appcompat.widget.ListPopupWindow$c r6 = r12.D
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.B
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.r r6 = r12.f1195c
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.r r5 = r12.f1195c
            android.view.View r6 = r12.f1213v
            if (r6 == 0) goto L_0x00b8
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f1214w
            if (r8 == 0) goto L_0x008f
            if (r8 == r3) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.f1214w
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0095
        L_0x0088:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0095
        L_0x008f:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0095:
            int r0 = r12.f1203l
            if (r0 < 0) goto L_0x009c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x009e
        L_0x009c:
            r0 = 0
            r5 = 0
        L_0x009e:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b9
        L_0x00b8:
            r0 = 0
        L_0x00b9:
            android.widget.PopupWindow r6 = r12.f1199g
            r6.setContentView(r5)
            goto L_0x00dd
        L_0x00bf:
            android.widget.PopupWindow r0 = r12.f1199g
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f1213v
            if (r0 == 0) goto L_0x00dc
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00dd
        L_0x00dc:
            r0 = 0
        L_0x00dd:
            android.widget.PopupWindow r5 = r12.f1199g
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00ff
            android.graphics.Rect r6 = r12.G
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.G
            int r5 = r5.top
            android.graphics.Rect r6 = r12.G
            int r6 = r6.bottom
            int r5 = r5 + r6
            boolean r6 = r12.f1207p
            if (r6 != 0) goto L_0x0105
            android.graphics.Rect r6 = r12.G
            int r6 = r6.top
            int r6 = -r6
            r12.f1205n = r6
            goto L_0x0105
        L_0x00ff:
            android.graphics.Rect r5 = r12.G
            r5.setEmpty()
            r5 = 0
        L_0x0105:
            android.widget.PopupWindow r6 = r12.f1199g
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x010f
            goto L_0x0110
        L_0x010f:
            r3 = 0
        L_0x0110:
            android.view.View r4 = r12.k()
            int r6 = r12.f1205n
            int r3 = r12.a(r4, r6, r3)
            boolean r4 = r12.f1211t
            if (r4 != 0) goto L_0x016a
            int r4 = r12.f1202k
            if (r4 != r2) goto L_0x0123
            goto L_0x016a
        L_0x0123:
            int r4 = r12.f1203l
            r6 = -2
            if (r4 == r6) goto L_0x0131
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x0131
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x014b
        L_0x0131:
            android.content.Context r2 = r12.f1200i
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.G
            int r4 = r4.left
            android.graphics.Rect r6 = r12.G
            int r6 = r6.right
            int r4 = r4 + r6
            int r2 = r2 - r4
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x014b:
            r7 = r1
            androidx.appcompat.widget.r r6 = r12.f1195c
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.a(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0168
            androidx.appcompat.widget.r r2 = r12.f1195c
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.r r3 = r12.f1195c
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0168:
            int r1 = r1 + r0
            return r1
        L_0x016a:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.i():int");
    }

    /* access modifiers changed from: package-private */
    public r a(Context context, boolean z2) {
        return new r(context, z2);
    }

    public void a(int i2) {
        this.f1205n = i2;
        this.f1207p = true;
    }

    public void a(Rect rect) {
        this.H = rect != null ? new Rect(rect) : null;
    }

    public void a(Drawable drawable) {
        this.f1199g.setBackgroundDrawable(drawable);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.A = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1215x;
        if (dataSetObserver == null) {
            this.f1215x = new b();
        } else {
            ListAdapter listAdapter2 = this.f1201j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1201j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1215x);
        }
        r rVar = this.f1195c;
        if (rVar != null) {
            rVar.setAdapter(this.f1201j);
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1199g.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z2) {
        this.I = z2;
        this.f1199g.setFocusable(z2);
    }

    public Drawable b() {
        return this.f1199g.getBackground();
    }

    public void b(int i2) {
        this.f1204m = i2;
    }

    public void b(View view) {
        this.f1216y = view;
    }

    public void b(boolean z2) {
        this.f1209r = true;
        this.f1208q = z2;
    }

    public int c() {
        if (!this.f1207p) {
            return 0;
        }
        return this.f1205n;
    }

    public void c_() {
        int i2 = i();
        boolean n2 = n();
        h.a(this.f1199g, this.f1206o);
        boolean z2 = true;
        if (!this.f1199g.isShowing()) {
            int i3 = this.f1203l;
            if (i3 == -1) {
                i3 = -1;
            } else if (i3 == -2) {
                i3 = k().getWidth();
            }
            int i4 = this.f1202k;
            if (i4 == -1) {
                i2 = -1;
            } else if (i4 != -2) {
                i2 = i4;
            }
            this.f1199g.setWidth(i3);
            this.f1199g.setHeight(i2);
            c(true);
            this.f1199g.setOutsideTouchable(!this.f1212u && !this.f1211t);
            this.f1199g.setTouchInterceptor(this.C);
            if (this.f1209r) {
                h.a(this.f1199g, this.f1208q);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = f1194h;
                if (method != null) {
                    try {
                        method.invoke(this.f1199g, new Object[]{this.H});
                    } catch (Exception e2) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                    }
                }
            } else {
                this.f1199g.setEpicenterBounds(this.H);
            }
            h.a(this.f1199g, k(), this.f1204m, this.f1205n, this.f1210s);
            this.f1195c.setSelection(-1);
            if (!this.I || this.f1195c.isInTouchMode()) {
                m();
            }
            if (!this.I) {
                this.f1198f.post(this.E);
            }
        } else if (ac.J(k())) {
            int i5 = this.f1203l;
            if (i5 == -1) {
                i5 = -1;
            } else if (i5 == -2) {
                i5 = k().getWidth();
            }
            int i6 = this.f1202k;
            if (i6 == -1) {
                if (!n2) {
                    i2 = -1;
                }
                if (n2) {
                    this.f1199g.setWidth(this.f1203l == -1 ? -1 : 0);
                    this.f1199g.setHeight(0);
                } else {
                    this.f1199g.setWidth(this.f1203l == -1 ? -1 : 0);
                    this.f1199g.setHeight(-1);
                }
            } else if (i6 != -2) {
                i2 = i6;
            }
            PopupWindow popupWindow = this.f1199g;
            if (this.f1212u || this.f1211t) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.f1199g.update(k(), this.f1204m, this.f1205n, i5 < 0 ? -1 : i5, i2 < 0 ? -1 : i2);
        }
    }

    public void d() {
        this.f1199g.dismiss();
        h();
        this.f1199g.setContentView((View) null);
        this.f1195c = null;
        this.f1198f.removeCallbacks(this.f1197e);
    }

    public void d(int i2) {
        this.f1214w = i2;
    }

    public void e(int i2) {
        this.f1199g.setAnimationStyle(i2);
    }

    public boolean e() {
        return this.f1199g.isShowing();
    }

    public int f() {
        return this.f1204m;
    }

    public void f(int i2) {
        this.f1210s = i2;
    }

    public ListView g() {
        return this.f1195c;
    }

    public void g(int i2) {
        this.f1203l = i2;
    }

    public void h(int i2) {
        Drawable background = this.f1199g.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            this.f1203l = this.G.left + this.G.right + i2;
            return;
        }
        g(i2);
    }

    public void i(int i2) {
        this.f1199g.setInputMethodMode(i2);
    }

    public void j(int i2) {
        r rVar = this.f1195c;
        if (e() && rVar != null) {
            rVar.setListSelectionHidden(false);
            rVar.setSelection(i2);
            if (rVar.getChoiceMode() != 0) {
                rVar.setItemChecked(i2, true);
            }
        }
    }

    public boolean j() {
        return this.I;
    }

    public View k() {
        return this.f1216y;
    }

    public int l() {
        return this.f1203l;
    }

    public void m() {
        r rVar = this.f1195c;
        if (rVar != null) {
            rVar.setListSelectionHidden(true);
            rVar.requestLayout();
        }
    }

    public boolean n() {
        return this.f1199g.getInputMethodMode() == 2;
    }

    public Object o() {
        if (!e()) {
            return null;
        }
        return this.f1195c.getSelectedItem();
    }

    public int p() {
        if (!e()) {
            return -1;
        }
        return this.f1195c.getSelectedItemPosition();
    }

    public long q() {
        if (!e()) {
            return Long.MIN_VALUE;
        }
        return this.f1195c.getSelectedItemId();
    }

    public View r() {
        if (!e()) {
            return null;
        }
        return this.f1195c.getSelectedView();
    }
}
