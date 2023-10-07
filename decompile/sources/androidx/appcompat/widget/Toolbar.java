package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.customview.view.AbsSavedState;
import com.blankj.utilcode.constant.MemoryConstants;
import f.c;
import java.util.ArrayList;
import java.util.List;
import t.ac;
import t.f;
import t.j;

public class Toolbar extends ViewGroup {
    private ColorStateList A;
    private ColorStateList B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    private final ActionMenuView.d H;
    private ag I;
    private ActionMenuPresenter J;
    private a K;
    private m.a L;
    private g.a M;
    private boolean N;
    private final Runnable O;

    /* renamed from: a  reason: collision with root package name */
    ImageButton f1335a;

    /* renamed from: b  reason: collision with root package name */
    View f1336b;

    /* renamed from: c  reason: collision with root package name */
    int f1337c;

    /* renamed from: d  reason: collision with root package name */
    b f1338d;

    /* renamed from: e  reason: collision with root package name */
    private ActionMenuView f1339e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f1340f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f1341g;

    /* renamed from: h  reason: collision with root package name */
    private ImageButton f1342h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f1343i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f1344j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f1345k;

    /* renamed from: l  reason: collision with root package name */
    private Context f1346l;

    /* renamed from: m  reason: collision with root package name */
    private int f1347m;

    /* renamed from: n  reason: collision with root package name */
    private int f1348n;

    /* renamed from: o  reason: collision with root package name */
    private int f1349o;

    /* renamed from: p  reason: collision with root package name */
    private int f1350p;

    /* renamed from: q  reason: collision with root package name */
    private int f1351q;

    /* renamed from: r  reason: collision with root package name */
    private int f1352r;

    /* renamed from: s  reason: collision with root package name */
    private int f1353s;

    /* renamed from: t  reason: collision with root package name */
    private int f1354t;

    /* renamed from: u  reason: collision with root package name */
    private y f1355u;

    /* renamed from: v  reason: collision with root package name */
    private int f1356v;

    /* renamed from: w  reason: collision with root package name */
    private int f1357w;

    /* renamed from: x  reason: collision with root package name */
    private int f1358x;

    /* renamed from: y  reason: collision with root package name */
    private CharSequence f1359y;

    /* renamed from: z  reason: collision with root package name */
    private CharSequence f1360z;

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: b  reason: collision with root package name */
        int f1364b = 0;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f490a = 8388627;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            a(marginLayoutParams);
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f1364b = layoutParams.f1364b;
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f1365a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1366b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1365a = parcel.readInt();
            this.f1366b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1365a);
            parcel.writeInt(this.f1366b ? 1 : 0);
        }
    }

    private class a implements m {

        /* renamed from: a  reason: collision with root package name */
        g f1367a;

        /* renamed from: b  reason: collision with root package name */
        i f1368b;

        a() {
        }

        public void a(Context context, g gVar) {
            i iVar;
            g gVar2 = this.f1367a;
            if (!(gVar2 == null || (iVar = this.f1368b) == null)) {
                gVar2.d(iVar);
            }
            this.f1367a = gVar;
        }

        public void a(Parcelable parcelable) {
        }

        public void a(g gVar, boolean z2) {
        }

        public void a(m.a aVar) {
        }

        public void a(boolean z2) {
            if (this.f1368b != null) {
                g gVar = this.f1367a;
                boolean z3 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (this.f1367a.getItem(i2) == this.f1368b) {
                            z3 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (!z3) {
                    b(this.f1367a, this.f1368b);
                }
            }
        }

        public boolean a(g gVar, i iVar) {
            Toolbar.this.i();
            ViewParent parent = Toolbar.this.f1335a.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1335a);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1335a);
            }
            Toolbar.this.f1336b = iVar.getActionView();
            this.f1368b = iVar;
            ViewParent parent2 = Toolbar.this.f1336b.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1336b);
                }
                LayoutParams j2 = Toolbar.this.generateDefaultLayoutParams();
                j2.f490a = 8388611 | (Toolbar.this.f1337c & 112);
                j2.f1364b = 2;
                Toolbar.this.f1336b.setLayoutParams(j2);
                Toolbar toolbar4 = Toolbar.this;
                toolbar4.addView(toolbar4.f1336b);
            }
            Toolbar.this.k();
            Toolbar.this.requestLayout();
            iVar.e(true);
            if (Toolbar.this.f1336b instanceof c) {
                ((c) Toolbar.this.f1336b).a();
            }
            return true;
        }

        public boolean a(r rVar) {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean b(g gVar, i iVar) {
            if (Toolbar.this.f1336b instanceof c) {
                ((c) Toolbar.this.f1336b).b();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1336b);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1335a);
            Toolbar.this.f1336b = null;
            Toolbar.this.l();
            this.f1368b = null;
            Toolbar.this.requestLayout();
            iVar.e(false);
            return true;
        }

        public int c() {
            return 0;
        }

        public Parcelable f() {
            return null;
        }
    }

    public interface b {
        boolean a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1358x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.H = new ActionMenuView.d() {
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.f1338d != null) {
                    return Toolbar.this.f1338d.a(menuItem);
                }
                return false;
            }
        };
        this.O = new Runnable() {
            public void run() {
                Toolbar.this.d();
            }
        };
        af a2 = af.a(getContext(), attributeSet, R.styleable.Toolbar, i2, 0);
        ac.a(this, context, R.styleable.Toolbar, attributeSet, a2.a(), i2, 0);
        this.f1348n = a2.g(R.styleable.Toolbar_titleTextAppearance, 0);
        this.f1349o = a2.g(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f1358x = a2.c(R.styleable.Toolbar_android_gravity, this.f1358x);
        this.f1337c = a2.c(R.styleable.Toolbar_buttonGravity, 48);
        int d2 = a2.d(R.styleable.Toolbar_titleMargin, 0);
        d2 = a2.g(R.styleable.Toolbar_titleMargins) ? a2.d(R.styleable.Toolbar_titleMargins, d2) : d2;
        this.f1354t = d2;
        this.f1353s = d2;
        this.f1352r = d2;
        this.f1351q = d2;
        int d3 = a2.d(R.styleable.Toolbar_titleMarginStart, -1);
        if (d3 >= 0) {
            this.f1351q = d3;
        }
        int d4 = a2.d(R.styleable.Toolbar_titleMarginEnd, -1);
        if (d4 >= 0) {
            this.f1352r = d4;
        }
        int d5 = a2.d(R.styleable.Toolbar_titleMarginTop, -1);
        if (d5 >= 0) {
            this.f1353s = d5;
        }
        int d6 = a2.d(R.styleable.Toolbar_titleMarginBottom, -1);
        if (d6 >= 0) {
            this.f1354t = d6;
        }
        this.f1350p = a2.e(R.styleable.Toolbar_maxButtonHeight, -1);
        int d7 = a2.d(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d8 = a2.d(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e2 = a2.e(R.styleable.Toolbar_contentInsetLeft, 0);
        int e3 = a2.e(R.styleable.Toolbar_contentInsetRight, 0);
        s();
        this.f1355u.b(e2, e3);
        if (!(d7 == Integer.MIN_VALUE && d8 == Integer.MIN_VALUE)) {
            this.f1355u.a(d7, d8);
        }
        this.f1356v = a2.d(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1357w = a2.d(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1344j = a2.a(R.styleable.Toolbar_collapseIcon);
        this.f1345k = a2.c(R.styleable.Toolbar_collapseContentDescription);
        CharSequence c2 = a2.c(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(c2)) {
            setTitle(c2);
        }
        CharSequence c3 = a2.c(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c3)) {
            setSubtitle(c3);
        }
        this.f1346l = getContext();
        setPopupTheme(a2.g(R.styleable.Toolbar_popupTheme, 0));
        Drawable a3 = a2.a(R.styleable.Toolbar_navigationIcon);
        if (a3 != null) {
            setNavigationIcon(a3);
        }
        CharSequence c4 = a2.c(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c4)) {
            setNavigationContentDescription(c4);
        }
        Drawable a4 = a2.a(R.styleable.Toolbar_logo);
        if (a4 != null) {
            setLogo(a4);
        }
        CharSequence c5 = a2.c(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c5)) {
            setLogoDescription(c5);
        }
        if (a2.g(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.e(R.styleable.Toolbar_titleTextColor));
        }
        if (a2.g(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.e(R.styleable.Toolbar_subtitleTextColor));
        }
        if (a2.g(R.styleable.Toolbar_menu)) {
            a(a2.g(R.styleable.Toolbar_menu, 0));
        }
        a2.b();
    }

    private int a(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int b2 = b(layoutParams.f490a);
        if (b2 == 48) {
            return getPaddingTop() - i3;
        }
        if (b2 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (i4 < layoutParams.topMargin) {
            i4 = layoutParams.topMargin;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            if (i5 < layoutParams.bottomMargin) {
                i4 = Math.max(0, i4 - (layoutParams.bottomMargin - i5));
            }
        }
        return paddingTop + i4;
    }

    private int a(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(View view, int i2, int[] iArr, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    private int a(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View view = list.get(i4);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i6 = layoutParams.leftMargin - i2;
            int i7 = layoutParams.rightMargin - i3;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            int max4 = Math.max(0, -i7);
            i5 += max + view.getMeasuredWidth() + max2;
            i4++;
            i3 = max4;
            i2 = max3;
        }
        return i5;
    }

    private void a(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, MemoryConstants.GB);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams j2 = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        j2.f1364b = 1;
        if (!z2 || this.f1336b == null) {
            addView(view, j2);
            return;
        }
        view.setLayoutParams(j2);
        this.F.add(view);
    }

    private void a(List<View> list, int i2) {
        boolean z2 = ac.i(this) == 1;
        int childCount = getChildCount();
        int a2 = f.a(i2, ac.i(this));
        list.clear();
        if (z2) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1364b == 0 && a(childAt) && c(layoutParams.f490a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f1364b == 0 && a(childAt2) && c(layoutParams2.f490a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.f1358x & 112;
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return j.a(marginLayoutParams) + j.b(marginLayoutParams);
    }

    private int b(View view, int i2, int[] iArr, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    private int c(int i2) {
        int i3 = ac.i(this);
        int a2 = f.a(i2, i3) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : i3 == 1 ? 5 : 3;
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new f.g(getContext());
    }

    private void m() {
        if (this.f1343i == null) {
            this.f1343i = new AppCompatImageView(getContext());
        }
    }

    private void n() {
        o();
        if (this.f1339e.d() == null) {
            g gVar = (g) this.f1339e.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.f1339e.setExpandedActionViewsExclusive(true);
            gVar.a((m) this.K, this.f1346l);
        }
    }

    private void o() {
        if (this.f1339e == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1339e = actionMenuView;
            actionMenuView.setPopupTheme(this.f1347m);
            this.f1339e.setOnMenuItemClickListener(this.H);
            this.f1339e.a(this.L, this.M);
            LayoutParams j2 = generateDefaultLayoutParams();
            j2.f490a = 8388613 | (this.f1337c & 112);
            this.f1339e.setLayoutParams(j2);
            a((View) this.f1339e, false);
        }
    }

    private void p() {
        if (this.f1342h == null) {
            this.f1342h = new AppCompatImageButton(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams j2 = generateDefaultLayoutParams();
            j2.f490a = 8388611 | (this.f1337c & 112);
            this.f1342h.setLayoutParams(j2);
        }
    }

    private void q() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean r() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.f1355u == null) {
            this.f1355u = new y();
        }
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ActionBar.LayoutParams ? new LayoutParams((ActionBar.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void a(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public void a(int i2, int i3) {
        s();
        this.f1355u.a(i2, i3);
    }

    public void a(Context context, int i2) {
        this.f1348n = i2;
        TextView textView = this.f1340f;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void a(g gVar, ActionMenuPresenter actionMenuPresenter) {
        if (gVar != null || this.f1339e != null) {
            o();
            g d2 = this.f1339e.d();
            if (d2 != gVar) {
                if (d2 != null) {
                    d2.b((m) this.J);
                    d2.b((m) this.K);
                }
                if (this.K == null) {
                    this.K = new a();
                }
                actionMenuPresenter.c(true);
                if (gVar != null) {
                    gVar.a((m) actionMenuPresenter, this.f1346l);
                    gVar.a((m) this.K, this.f1346l);
                } else {
                    actionMenuPresenter.a(this.f1346l, (g) null);
                    this.K.a(this.f1346l, (g) null);
                    actionMenuPresenter.a(true);
                    this.K.a(true);
                }
                this.f1339e.setPopupTheme(this.f1347m);
                this.f1339e.setPresenter(actionMenuPresenter);
                this.J = actionMenuPresenter;
            }
        }
    }

    public void a(m.a aVar, g.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        ActionMenuView actionMenuView = this.f1339e;
        if (actionMenuView != null) {
            actionMenuView.a(aVar, aVar2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f1339e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.f1339e
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.a():boolean");
    }

    public void b(Context context, int i2) {
        this.f1349o = i2;
        TextView textView = this.f1341g;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public boolean b() {
        ActionMenuView actionMenuView = this.f1339e;
        return actionMenuView != null && actionMenuView.g();
    }

    public boolean c() {
        ActionMenuView actionMenuView = this.f1339e;
        return actionMenuView != null && actionMenuView.h();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public boolean d() {
        ActionMenuView actionMenuView = this.f1339e;
        return actionMenuView != null && actionMenuView.e();
    }

    public boolean e() {
        ActionMenuView actionMenuView = this.f1339e;
        return actionMenuView != null && actionMenuView.f();
    }

    public void f() {
        ActionMenuView actionMenuView = this.f1339e;
        if (actionMenuView != null) {
            actionMenuView.i();
        }
    }

    public boolean g() {
        a aVar = this.K;
        return (aVar == null || aVar.f1368b == null) ? false : true;
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1335a;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1335a;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        y yVar = this.f1355u;
        if (yVar != null) {
            return yVar.d();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.f1357w;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        y yVar = this.f1355u;
        if (yVar != null) {
            return yVar.a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        y yVar = this.f1355u;
        if (yVar != null) {
            return yVar.b();
        }
        return 0;
    }

    public int getContentInsetStart() {
        y yVar = this.f1355u;
        if (yVar != null) {
            return yVar.c();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.f1356v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCurrentContentInsetEnd() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.f1339e
            r1 = 0
            if (r0 == 0) goto L_0x0013
            androidx.appcompat.view.menu.g r0 = r0.d()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0025
            int r0 = r3.getContentInsetEnd()
            int r2 = r3.f1357w
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x0029
        L_0x0025:
            int r0 = r3.getContentInsetEnd()
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        return ac.i(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return ac.i(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1356v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1343i;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1343i;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        n();
        return this.f1339e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1342h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1342h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        n();
        return this.f1339e.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.f1346l;
    }

    public int getPopupTheme() {
        return this.f1347m;
    }

    public CharSequence getSubtitle() {
        return this.f1360z;
    }

    /* access modifiers changed from: package-private */
    public final TextView getSubtitleTextView() {
        return this.f1341g;
    }

    public CharSequence getTitle() {
        return this.f1359y;
    }

    public int getTitleMarginBottom() {
        return this.f1354t;
    }

    public int getTitleMarginEnd() {
        return this.f1352r;
    }

    public int getTitleMarginStart() {
        return this.f1351q;
    }

    public int getTitleMarginTop() {
        return this.f1353s;
    }

    /* access modifiers changed from: package-private */
    public final TextView getTitleTextView() {
        return this.f1340f;
    }

    public p getWrapper() {
        if (this.I == null) {
            this.I = new ag(this, true);
        }
        return this.I;
    }

    public void h() {
        a aVar = this.K;
        i iVar = aVar == null ? null : aVar.f1368b;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (this.f1335a == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            this.f1335a = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1344j);
            this.f1335a.setContentDescription(this.f1345k);
            LayoutParams j2 = generateDefaultLayoutParams();
            j2.f490a = 8388611 | (this.f1337c & 112);
            j2.f1364b = 2;
            this.f1335a.setLayoutParams(j2);
            this.f1335a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.h();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: package-private */
    public void k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).f1364b == 2 || childAt == this.f1339e)) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0295 A[LOOP:0: B:105:0x0293->B:106:0x0295, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02b7 A[LOOP:1: B:108:0x02b5->B:109:0x02b7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02f0 A[LOOP:2: B:116:0x02ee->B:117:0x02f0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x021c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = t.ac.i(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.G
            r11[r2] = r3
            r11[r3] = r3
            int r12 = t.ac.q(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = 0
        L_0x003b:
            android.widget.ImageButton r13 = r0.f1342h
            boolean r13 = r0.a((android.view.View) r13)
            if (r13 == 0) goto L_0x0053
            android.widget.ImageButton r13 = r0.f1342h
            if (r1 == 0) goto L_0x004e
            int r13 = r0.b(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0055
        L_0x004e:
            int r13 = r0.a(r13, r6, r11, r12)
            goto L_0x0054
        L_0x0053:
            r13 = r6
        L_0x0054:
            r14 = r10
        L_0x0055:
            android.widget.ImageButton r15 = r0.f1335a
            boolean r15 = r0.a((android.view.View) r15)
            if (r15 == 0) goto L_0x006a
            android.widget.ImageButton r15 = r0.f1335a
            if (r1 == 0) goto L_0x0066
            int r14 = r0.b(r15, r14, r11, r12)
            goto L_0x006a
        L_0x0066:
            int r13 = r0.a(r15, r13, r11, r12)
        L_0x006a:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1339e
            boolean r15 = r0.a((android.view.View) r15)
            if (r15 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1339e
            if (r1 == 0) goto L_0x007b
            int r13 = r0.a(r15, r13, r11, r12)
            goto L_0x007f
        L_0x007b:
            int r14 = r0.b(r15, r14, r11, r12)
        L_0x007f:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.f1336b
            boolean r13 = r0.a((android.view.View) r13)
            if (r13 == 0) goto L_0x00ba
            android.view.View r13 = r0.f1336b
            if (r1 == 0) goto L_0x00b6
            int r10 = r0.b(r13, r10, r11, r12)
            goto L_0x00ba
        L_0x00b6:
            int r2 = r0.a(r13, r2, r11, r12)
        L_0x00ba:
            android.widget.ImageView r13 = r0.f1343i
            boolean r13 = r0.a((android.view.View) r13)
            if (r13 == 0) goto L_0x00cf
            android.widget.ImageView r13 = r0.f1343i
            if (r1 == 0) goto L_0x00cb
            int r10 = r0.b(r13, r10, r11, r12)
            goto L_0x00cf
        L_0x00cb:
            int r2 = r0.a(r13, r2, r11, r12)
        L_0x00cf:
            android.widget.TextView r13 = r0.f1340f
            boolean r13 = r0.a((android.view.View) r13)
            android.widget.TextView r14 = r0.f1341g
            boolean r14 = r0.a((android.view.View) r14)
            if (r13 == 0) goto L_0x00f6
            android.widget.TextView r15 = r0.f1340f
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r15 = (androidx.appcompat.widget.Toolbar.LayoutParams) r15
            int r3 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.f1340f
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x00f9
        L_0x00f6:
            r23 = r7
            r3 = 0
        L_0x00f9:
            if (r14 == 0) goto L_0x0113
            android.widget.TextView r7 = r0.f1341g
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.f1341g
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x0115
        L_0x0113:
            r16 = r4
        L_0x0115:
            if (r13 != 0) goto L_0x0121
            if (r14 == 0) goto L_0x011a
            goto L_0x0121
        L_0x011a:
            r18 = r6
            r22 = r12
        L_0x011e:
            r1 = 0
            goto L_0x0286
        L_0x0121:
            if (r13 == 0) goto L_0x0126
            android.widget.TextView r4 = r0.f1340f
            goto L_0x0128
        L_0x0126:
            android.widget.TextView r4 = r0.f1341g
        L_0x0128:
            if (r14 == 0) goto L_0x012d
            android.widget.TextView r7 = r0.f1341g
            goto L_0x012f
        L_0x012d:
            android.widget.TextView r7 = r0.f1340f
        L_0x012f:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r4 = (androidx.appcompat.widget.Toolbar.LayoutParams) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            if (r13 == 0) goto L_0x0145
            android.widget.TextView r15 = r0.f1340f
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x014f
        L_0x0145:
            if (r14 == 0) goto L_0x0152
            android.widget.TextView r15 = r0.f1341g
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x0152
        L_0x014f:
            r17 = 1
            goto L_0x0154
        L_0x0152:
            r17 = 0
        L_0x0154:
            int r15 = r0.f1358x
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x019d
            r6 = 80
            if (r15 == r6) goto L_0x0191
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.f1353s
            int r15 = r15 + r12
            if (r6 >= r15) goto L_0x0178
            int r3 = r4.topMargin
            int r4 = r0.f1353s
            int r6 = r3 + r4
            goto L_0x018f
        L_0x0178:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r3 = r4.bottomMargin
            int r4 = r0.f1354t
            int r3 = r3 + r4
            if (r5 >= r3) goto L_0x018f
            int r3 = r7.bottomMargin
            int r4 = r0.f1354t
            int r3 = r3 + r4
            int r3 = r3 - r5
            int r6 = r6 - r3
            r3 = 0
            int r6 = java.lang.Math.max(r3, r6)
        L_0x018f:
            int r8 = r8 + r6
            goto L_0x01aa
        L_0x0191:
            r22 = r12
            int r5 = r5 - r9
            int r4 = r7.bottomMargin
            int r5 = r5 - r4
            int r4 = r0.f1354t
            int r5 = r5 - r4
            int r8 = r5 - r3
            goto L_0x01aa
        L_0x019d:
            r22 = r12
            int r3 = r19.getPaddingTop()
            int r4 = r4.topMargin
            int r3 = r3 + r4
            int r4 = r0.f1353s
            int r8 = r3 + r4
        L_0x01aa:
            if (r1 == 0) goto L_0x021c
            if (r17 == 0) goto L_0x01b1
            int r1 = r0.f1351q
            goto L_0x01b2
        L_0x01b1:
            r1 = 0
        L_0x01b2:
            r3 = 1
            r4 = r11[r3]
            int r1 = r1 - r4
            r4 = 0
            int r5 = java.lang.Math.max(r4, r1)
            int r10 = r10 - r5
            int r1 = -r1
            int r1 = java.lang.Math.max(r4, r1)
            r11[r3] = r1
            if (r13 == 0) goto L_0x01e9
            android.widget.TextView r1 = r0.f1340f
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r3 = r0.f1340f
            int r3 = r3.getMeasuredWidth()
            int r3 = r10 - r3
            android.widget.TextView r4 = r0.f1340f
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.f1340f
            r5.layout(r3, r8, r10, r4)
            int r5 = r0.f1352r
            int r3 = r3 - r5
            int r1 = r1.bottomMargin
            int r8 = r4 + r1
            goto L_0x01ea
        L_0x01e9:
            r3 = r10
        L_0x01ea:
            if (r14 == 0) goto L_0x0212
            android.widget.TextView r1 = r0.f1341g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r4 = r1.topMargin
            int r8 = r8 + r4
            android.widget.TextView r4 = r0.f1341g
            int r4 = r4.getMeasuredWidth()
            int r4 = r10 - r4
            android.widget.TextView r5 = r0.f1341g
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1341g
            r6.layout(r4, r8, r10, r5)
            int r4 = r0.f1352r
            int r4 = r10 - r4
            int r1 = r1.bottomMargin
            goto L_0x0213
        L_0x0212:
            r4 = r10
        L_0x0213:
            if (r17 == 0) goto L_0x011e
            int r1 = java.lang.Math.min(r3, r4)
            r10 = r1
            goto L_0x011e
        L_0x021c:
            if (r17 == 0) goto L_0x0222
            int r7 = r0.f1351q
            r1 = 0
            goto L_0x0224
        L_0x0222:
            r1 = 0
            r7 = 0
        L_0x0224:
            r3 = r11[r1]
            int r7 = r7 - r3
            int r3 = java.lang.Math.max(r1, r7)
            int r2 = r2 + r3
            int r3 = -r7
            int r3 = java.lang.Math.max(r1, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x0258
            android.widget.TextView r3 = r0.f1340f
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r3 = (androidx.appcompat.widget.Toolbar.LayoutParams) r3
            android.widget.TextView r4 = r0.f1340f
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.f1340f
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1340f
            r6.layout(r2, r8, r4, r5)
            int r6 = r0.f1352r
            int r4 = r4 + r6
            int r3 = r3.bottomMargin
            int r8 = r5 + r3
            goto L_0x0259
        L_0x0258:
            r4 = r2
        L_0x0259:
            if (r14 == 0) goto L_0x027f
            android.widget.TextView r3 = r0.f1341g
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r3 = (androidx.appcompat.widget.Toolbar.LayoutParams) r3
            int r5 = r3.topMargin
            int r8 = r8 + r5
            android.widget.TextView r5 = r0.f1341g
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 + r2
            android.widget.TextView r6 = r0.f1341g
            int r6 = r6.getMeasuredHeight()
            int r6 = r6 + r8
            android.widget.TextView r7 = r0.f1341g
            r7.layout(r2, r8, r5, r6)
            int r6 = r0.f1352r
            int r5 = r5 + r6
            int r3 = r3.bottomMargin
            goto L_0x0280
        L_0x027f:
            r5 = r2
        L_0x0280:
            if (r17 == 0) goto L_0x0286
            int r2 = java.lang.Math.max(r4, r5)
        L_0x0286:
            java.util.ArrayList<android.view.View> r3 = r0.E
            r4 = 3
            r0.a((java.util.List<android.view.View>) r3, (int) r4)
            java.util.ArrayList<android.view.View> r3 = r0.E
            int r3 = r3.size()
            r7 = 0
        L_0x0293:
            if (r7 >= r3) goto L_0x02a6
            java.util.ArrayList<android.view.View> r4 = r0.E
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r2 = r0.a(r4, r2, r11, r12)
            int r7 = r7 + 1
            goto L_0x0293
        L_0x02a6:
            r12 = r22
            java.util.ArrayList<android.view.View> r3 = r0.E
            r4 = 5
            r0.a((java.util.List<android.view.View>) r3, (int) r4)
            java.util.ArrayList<android.view.View> r3 = r0.E
            int r3 = r3.size()
            r7 = 0
        L_0x02b5:
            if (r7 >= r3) goto L_0x02c6
            java.util.ArrayList<android.view.View> r4 = r0.E
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.b(r4, r10, r11, r12)
            int r7 = r7 + 1
            goto L_0x02b5
        L_0x02c6:
            java.util.ArrayList<android.view.View> r3 = r0.E
            r4 = 1
            r0.a((java.util.List<android.view.View>) r3, (int) r4)
            java.util.ArrayList<android.view.View> r3 = r0.E
            int r3 = r0.a((java.util.List<android.view.View>) r3, (int[]) r11)
            int r4 = r16 - r18
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r18 + r4
            int r4 = r3 / 2
            int r6 = r6 - r4
            int r3 = r3 + r6
            if (r6 >= r2) goto L_0x02e1
            goto L_0x02e8
        L_0x02e1:
            if (r3 <= r10) goto L_0x02e7
            int r3 = r3 - r10
            int r2 = r6 - r3
            goto L_0x02e8
        L_0x02e7:
            r2 = r6
        L_0x02e8:
            java.util.ArrayList<android.view.View> r3 = r0.E
            int r3 = r3.size()
        L_0x02ee:
            if (r1 >= r3) goto L_0x02ff
            java.util.ArrayList<android.view.View> r4 = r0.E
            java.lang.Object r4 = r4.get(r1)
            android.view.View r4 = (android.view.View) r4
            int r2 = r0.a(r4, r2, r11, r12)
            int r1 = r1 + 1
            goto L_0x02ee
        L_0x02ff:
            java.util.ArrayList<android.view.View> r1 = r0.E
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.G;
        int i11 = 0;
        if (al.a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c3 = 0;
            c2 = 1;
        }
        if (a((View) this.f1342h)) {
            a((View) this.f1342h, i2, 0, i3, 0, this.f1350p);
            i6 = this.f1342h.getMeasuredWidth() + b((View) this.f1342h);
            i5 = Math.max(0, this.f1342h.getMeasuredHeight() + c((View) this.f1342h));
            i4 = View.combineMeasuredStates(0, this.f1342h.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (a((View) this.f1335a)) {
            a((View) this.f1335a, i2, 0, i3, 0, this.f1350p);
            i6 = this.f1335a.getMeasuredWidth() + b((View) this.f1335a);
            i5 = Math.max(i5, this.f1335a.getMeasuredHeight() + c((View) this.f1335a));
            i4 = View.combineMeasuredStates(i4, this.f1335a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i6);
        iArr[c3] = Math.max(0, currentContentInsetStart - i6);
        if (a((View) this.f1339e)) {
            a((View) this.f1339e, i2, max, i3, 0, this.f1350p);
            i7 = this.f1339e.getMeasuredWidth() + b((View) this.f1339e);
            i5 = Math.max(i5, this.f1339e.getMeasuredHeight() + c((View) this.f1339e));
            i4 = View.combineMeasuredStates(i4, this.f1339e.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i7);
        if (a(this.f1336b)) {
            max2 += a(this.f1336b, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f1336b.getMeasuredHeight() + c(this.f1336b));
            i4 = View.combineMeasuredStates(i4, this.f1336b.getMeasuredState());
        }
        if (a((View) this.f1343i)) {
            max2 += a((View) this.f1343i, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f1343i.getMeasuredHeight() + c((View) this.f1343i));
            i4 = View.combineMeasuredStates(i4, this.f1343i.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((LayoutParams) childAt.getLayoutParams()).f1364b == 0 && a(childAt)) {
                max2 += a(childAt, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, childAt.getMeasuredHeight() + c(childAt));
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        int i13 = this.f1353s + this.f1354t;
        int i14 = this.f1351q + this.f1352r;
        if (a((View) this.f1340f)) {
            a((View) this.f1340f, i2, max2 + i14, i3, i13, iArr);
            int measuredWidth = this.f1340f.getMeasuredWidth() + b((View) this.f1340f);
            i8 = this.f1340f.getMeasuredHeight() + c((View) this.f1340f);
            i10 = View.combineMeasuredStates(i4, this.f1340f.getMeasuredState());
            i9 = measuredWidth;
        } else {
            i10 = i4;
            i9 = 0;
            i8 = 0;
        }
        if (a((View) this.f1341g)) {
            int i15 = i8 + i13;
            i9 = Math.max(i9, a((View) this.f1341g, i2, max2 + i14, i3, i15, iArr));
            i8 += this.f1341g.getMeasuredHeight() + c((View) this.f1341g);
            i10 = View.combineMeasuredStates(i10, this.f1341g.getMeasuredState());
        } else {
            int i16 = i10;
        }
        int max3 = Math.max(i5, i8);
        int paddingLeft = max2 + i9 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, -16777216 & i10);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, i10 << 16);
        if (!r()) {
            i11 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i11);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f1339e;
        g d2 = actionMenuView != null ? actionMenuView.d() : null;
        if (!(savedState.f1365a == 0 || this.K == null || d2 == null || (findItem = d2.findItem(savedState.f1365a)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.f1366b) {
            q();
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        s();
        y yVar = this.f1355u;
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        yVar.a(z2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        a aVar = this.K;
        if (!(aVar == null || aVar.f1368b == null)) {
            savedState.f1365a = this.K.f1368b.getItemId();
        }
        savedState.f1366b = b();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageButton imageButton = this.f1335a;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(c.a.b(getContext(), i2));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            i();
            this.f1335a.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f1335a;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f1344j);
        }
    }

    public void setCollapsible(boolean z2) {
        this.N = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1357w) {
            this.f1357w = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1356v) {
            this.f1356v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(c.a.b(getContext(), i2));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!d(this.f1343i)) {
                a((View) this.f1343i, true);
            }
        } else {
            ImageView imageView = this.f1343i;
            if (imageView != null && d(imageView)) {
                removeView(this.f1343i);
                this.F.remove(this.f1343i);
            }
        }
        ImageView imageView2 = this.f1343i;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        ImageView imageView = this.f1343i;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            p();
        }
        ImageButton imageButton = this.f1342h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(c.a.b(getContext(), i2));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            p();
            if (!d(this.f1342h)) {
                a((View) this.f1342h, true);
            }
        } else {
            ImageButton imageButton = this.f1342h;
            if (imageButton != null && d(imageButton)) {
                removeView(this.f1342h);
                this.F.remove(this.f1342h);
            }
        }
        ImageButton imageButton2 = this.f1342h;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        p();
        this.f1342h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(b bVar) {
        this.f1338d = bVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        n();
        this.f1339e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.f1347m != i2) {
            this.f1347m = i2;
            if (i2 == 0) {
                this.f1346l = getContext();
            } else {
                this.f1346l = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1341g == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1341g = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1341g.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1349o;
                if (i2 != 0) {
                    this.f1341g.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f1341g.setTextColor(colorStateList);
                }
            }
            if (!d(this.f1341g)) {
                a((View) this.f1341g, true);
            }
        } else {
            TextView textView = this.f1341g;
            if (textView != null && d(textView)) {
                removeView(this.f1341g);
                this.F.remove(this.f1341g);
            }
        }
        TextView textView2 = this.f1341g;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1360z = charSequence;
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f1341g;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1340f == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1340f = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1340f.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1348n;
                if (i2 != 0) {
                    this.f1340f.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f1340f.setTextColor(colorStateList);
                }
            }
            if (!d(this.f1340f)) {
                a((View) this.f1340f, true);
            }
        } else {
            TextView textView = this.f1340f;
            if (textView != null && d(textView)) {
                removeView(this.f1340f);
                this.F.remove(this.f1340f);
            }
        }
        TextView textView2 = this.f1340f;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1359y = charSequence;
    }

    public void setTitleMarginBottom(int i2) {
        this.f1354t = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.f1352r = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.f1351q = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.f1353s = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f1340f;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
