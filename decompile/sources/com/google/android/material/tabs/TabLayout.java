package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ah;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.s;
import gw.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import s.e;
import t.ac;
import t.j;
import t.y;
import u.c;

@ViewPager.a
public class TabLayout extends HorizontalScrollView {

    /* renamed from: y  reason: collision with root package name */
    private static final int f19660y = R.style.Widget_Design_TabLayout;

    /* renamed from: z  reason: collision with root package name */
    private static final e.a<f> f19661z = new e.c(16);
    private final ArrayList<f> A;
    private f B;
    /* access modifiers changed from: private */
    public int C;
    private final int D;
    private final int E;
    private final int F;
    private int G;
    /* access modifiers changed from: private */
    public b H;
    private b I;
    private final ArrayList<b> J;
    private b K;
    private ValueAnimator L;
    private androidx.viewpager.widget.a M;
    private DataSetObserver N;
    private g O;
    private a P;
    private boolean Q;
    private final e.a<TabView> R;

    /* renamed from: a  reason: collision with root package name */
    final e f19662a;

    /* renamed from: b  reason: collision with root package name */
    int f19663b;

    /* renamed from: c  reason: collision with root package name */
    int f19664c;

    /* renamed from: d  reason: collision with root package name */
    int f19665d;

    /* renamed from: e  reason: collision with root package name */
    int f19666e;

    /* renamed from: f  reason: collision with root package name */
    int f19667f;

    /* renamed from: g  reason: collision with root package name */
    ColorStateList f19668g;

    /* renamed from: h  reason: collision with root package name */
    ColorStateList f19669h;

    /* renamed from: i  reason: collision with root package name */
    ColorStateList f19670i;

    /* renamed from: j  reason: collision with root package name */
    Drawable f19671j;

    /* renamed from: k  reason: collision with root package name */
    PorterDuff.Mode f19672k;

    /* renamed from: l  reason: collision with root package name */
    float f19673l;

    /* renamed from: m  reason: collision with root package name */
    float f19674m;

    /* renamed from: n  reason: collision with root package name */
    final int f19675n;

    /* renamed from: o  reason: collision with root package name */
    int f19676o;

    /* renamed from: p  reason: collision with root package name */
    int f19677p;

    /* renamed from: q  reason: collision with root package name */
    int f19678q;

    /* renamed from: r  reason: collision with root package name */
    int f19679r;

    /* renamed from: s  reason: collision with root package name */
    int f19680s;

    /* renamed from: t  reason: collision with root package name */
    boolean f19681t;

    /* renamed from: u  reason: collision with root package name */
    boolean f19682u;

    /* renamed from: v  reason: collision with root package name */
    int f19683v;

    /* renamed from: w  reason: collision with root package name */
    boolean f19684w;

    /* renamed from: x  reason: collision with root package name */
    ViewPager f19685x;

    public final class TabView extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private f f19688b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f19689c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f19690d;

        /* renamed from: e  reason: collision with root package name */
        private View f19691e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public BadgeDrawable f19692f;

        /* renamed from: g  reason: collision with root package name */
        private View f19693g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f19694h;

        /* renamed from: i  reason: collision with root package name */
        private ImageView f19695i;

        /* renamed from: j  reason: collision with root package name */
        private Drawable f19696j;

        /* renamed from: k  reason: collision with root package name */
        private int f19697k = 2;

        public TabView(Context context) {
            super(context);
            a(context);
            ac.b(this, TabLayout.this.f19663b, TabLayout.this.f19664c, TabLayout.this.f19665d, TabLayout.this.f19666e);
            setGravity(17);
            setOrientation(TabLayout.this.f19681t ^ true ? 1 : 0);
            setClickable(true);
            ac.a((View) this, y.a(getContext(), 1002));
        }

        private float a(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: android.graphics.drawable.GradientDrawable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.graphics.drawable.GradientDrawable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: android.graphics.drawable.GradientDrawable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: android.graphics.drawable.GradientDrawable} */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.content.Context r7) {
            /*
                r6 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.f19675n
                r1 = 0
                if (r0 == 0) goto L_0x0023
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.f19675n
                android.graphics.drawable.Drawable r7 = c.a.b(r7, r0)
                r6.f19696j = r7
                if (r7 == 0) goto L_0x0025
                boolean r7 = r7.isStateful()
                if (r7 == 0) goto L_0x0025
                android.graphics.drawable.Drawable r7 = r6.f19696j
                int[] r0 = r6.getDrawableState()
                r7.setState(r0)
                goto L_0x0025
            L_0x0023:
                r6.f19696j = r1
            L_0x0025:
                android.graphics.drawable.GradientDrawable r7 = new android.graphics.drawable.GradientDrawable
                r7.<init>()
                r0 = r7
                android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
                r2 = 0
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.f19670i
                if (r0 == 0) goto L_0x007f
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r3 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r3)
                r3 = -1
                r0.setColor(r3)
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r3 = r3.f19670i
                android.content.res.ColorStateList r3 = gu.b.a((android.content.res.ColorStateList) r3)
                int r4 = android.os.Build.VERSION.SDK_INT
                r5 = 21
                if (r4 < r5) goto L_0x006a
                android.graphics.drawable.RippleDrawable r2 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.f19684w
                if (r4 == 0) goto L_0x005d
                r7 = r1
            L_0x005d:
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.f19684w
                if (r4 == 0) goto L_0x0064
                goto L_0x0065
            L_0x0064:
                r1 = r0
            L_0x0065:
                r2.<init>(r3, r7, r1)
                r7 = r2
                goto L_0x007f
            L_0x006a:
                android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.a.g(r0)
                androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r0, (android.content.res.ColorStateList) r3)
                android.graphics.drawable.LayerDrawable r1 = new android.graphics.drawable.LayerDrawable
                r3 = 2
                android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r3]
                r3[r2] = r7
                r7 = 1
                r3[r7] = r0
                r1.<init>(r3)
                r7 = r1
            L_0x007f:
                t.ac.a((android.view.View) r6, (android.graphics.drawable.Drawable) r7)
                com.google.android.material.tabs.TabLayout r7 = com.google.android.material.tabs.TabLayout.this
                r7.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.a(android.content.Context):void");
        }

        /* access modifiers changed from: private */
        public void a(Canvas canvas) {
            Drawable drawable = this.f19696j;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f19696j.draw(canvas);
            }
        }

        private void a(final View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                        if (view.getVisibility() == 0) {
                            TabView.this.c(view);
                        }
                    }
                });
            }
        }

        private void a(TextView textView, ImageView imageView) {
            f fVar = this.f19688b;
            CharSequence charSequence = null;
            Drawable mutate = (fVar == null || fVar.b() == null) ? null : androidx.core.graphics.drawable.a.g(this.f19688b.b()).mutate();
            f fVar2 = this.f19688b;
            CharSequence d2 = fVar2 != null ? fVar2.d() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z2 = !TextUtils.isEmpty(d2);
            if (textView != null) {
                if (z2) {
                    textView.setText(d2);
                    if (this.f19688b.f19721i == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int a2 = (!z2 || imageView.getVisibility() != 0) ? 0 : (int) s.a(getContext(), 8);
                if (TabLayout.this.f19681t) {
                    if (a2 != j.b(marginLayoutParams)) {
                        j.b(marginLayoutParams, a2);
                        marginLayoutParams.bottomMargin = 0;
                    }
                } else if (a2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a2;
                    j.b(marginLayoutParams, 0);
                }
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
            f fVar3 = this.f19688b;
            if (fVar3 != null) {
                charSequence = fVar3.f19718f;
            }
            if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 23) {
                if (!z2) {
                    d2 = charSequence;
                }
                ah.a(this, d2);
            }
        }

        private void a(boolean z2) {
            setClipChildren(z2);
            setClipToPadding(z2);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z2);
                viewGroup.setClipToPadding(z2);
            }
        }

        private void b(View view) {
            if (i() && view != null) {
                a(false);
                com.google.android.material.badge.a.a(this.f19692f, view, d(view));
                this.f19691e = view;
            }
        }

        /* access modifiers changed from: private */
        public void c(View view) {
            if (i() && view == this.f19691e) {
                com.google.android.material.badge.a.b(this.f19692f, view, d(view));
            }
        }

        private FrameLayout d(View view) {
            if ((view == this.f19690d || view == this.f19689c) && com.google.android.material.badge.a.f18524a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        private void d() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.a.f18524a) {
                viewGroup = f();
                addView(viewGroup, 0);
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, viewGroup, false);
            this.f19690d = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void e() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.a.f18524a) {
                viewGroup = f();
                addView(viewGroup);
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, viewGroup, false);
            this.f19689c = textView;
            viewGroup.addView(textView);
        }

        private FrameLayout f() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        private void g() {
            f fVar;
            View view;
            View view2;
            f fVar2;
            if (i()) {
                if (this.f19693g == null) {
                    if (this.f19690d != null && (fVar2 = this.f19688b) != null && fVar2.b() != null) {
                        View view3 = this.f19691e;
                        view = this.f19690d;
                        if (view3 != view) {
                            h();
                            view2 = this.f19690d;
                        }
                        c(view);
                        return;
                    } else if (!(this.f19689c == null || (fVar = this.f19688b) == null || fVar.e() != 1)) {
                        View view4 = this.f19691e;
                        view = this.f19689c;
                        if (view4 != view) {
                            h();
                            view2 = this.f19689c;
                        }
                        c(view);
                        return;
                    }
                    b(view2);
                    return;
                }
                h();
            }
        }

        private BadgeDrawable getBadge() {
            return this.f19692f;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.f19692f == null) {
                this.f19692f = BadgeDrawable.a(getContext());
            }
            g();
            BadgeDrawable badgeDrawable = this.f19692f;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h() {
            if (i()) {
                a(true);
                View view = this.f19691e;
                if (view != null) {
                    com.google.android.material.badge.a.a(this.f19692f, view);
                    this.f19691e = null;
                }
            }
        }

        /* access modifiers changed from: private */
        public boolean i() {
            return this.f19692f != null;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            setTab((f) null);
            setSelected(false);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            f fVar = this.f19688b;
            Drawable drawable = null;
            View a2 = fVar != null ? fVar.a() : null;
            if (a2 != null) {
                ViewParent parent = a2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(a2);
                    }
                    addView(a2);
                }
                this.f19693g = a2;
                TextView textView = this.f19689c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f19690d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f19690d.setImageDrawable((Drawable) null);
                }
                TextView textView2 = (TextView) a2.findViewById(16908308);
                this.f19694h = textView2;
                if (textView2 != null) {
                    this.f19697k = androidx.core.widget.j.a(textView2);
                }
                this.f19695i = (ImageView) a2.findViewById(16908294);
            } else {
                View view = this.f19693g;
                if (view != null) {
                    removeView(view);
                    this.f19693g = null;
                }
                this.f19694h = null;
                this.f19695i = null;
            }
            if (this.f19693g == null) {
                if (this.f19690d == null) {
                    d();
                }
                if (!(fVar == null || fVar.b() == null)) {
                    drawable = androidx.core.graphics.drawable.a.g(fVar.b()).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.a(drawable, TabLayout.this.f19669h);
                    if (TabLayout.this.f19672k != null) {
                        androidx.core.graphics.drawable.a.a(drawable, TabLayout.this.f19672k);
                    }
                }
                if (this.f19689c == null) {
                    e();
                    this.f19697k = androidx.core.widget.j.a(this.f19689c);
                }
                androidx.core.widget.j.a(this.f19689c, TabLayout.this.f19667f);
                if (TabLayout.this.f19668g != null) {
                    this.f19689c.setTextColor(TabLayout.this.f19668g);
                }
                a(this.f19689c, this.f19690d);
                g();
                a((View) this.f19690d);
                a((View) this.f19689c);
            } else {
                TextView textView3 = this.f19694h;
                if (!(textView3 == null && this.f19695i == null)) {
                    a(textView3, this.f19695i);
                }
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.f19718f)) {
                setContentDescription(fVar.f19718f);
            }
            setSelected(fVar != null && fVar.g());
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            ImageView imageView;
            setOrientation(TabLayout.this.f19681t ^ true ? 1 : 0);
            TextView textView = this.f19694h;
            if (textView == null && this.f19695i == null) {
                textView = this.f19689c;
                imageView = this.f19690d;
            } else {
                imageView = this.f19695i;
            }
            a(textView, imageView);
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f19696j;
            boolean z2 = false;
            if (drawable != null && drawable.isStateful()) {
                z2 = false | this.f19696j.setState(drawableState);
            }
            if (z2) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public int getContentHeight() {
            View[] viewArr = {this.f19689c, this.f19690d, this.f19693g};
            int i2 = 0;
            int i3 = 0;
            boolean z2 = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z2 ? Math.min(i3, view.getTop()) : view.getTop();
                    i2 = z2 ? Math.max(i2, view.getBottom()) : view.getBottom();
                    z2 = true;
                }
            }
            return i2 - i3;
        }

        /* access modifiers changed from: package-private */
        public int getContentWidth() {
            View[] viewArr = {this.f19689c, this.f19690d, this.f19693g};
            int i2 = 0;
            int i3 = 0;
            boolean z2 = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z2 ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z2 ? Math.max(i2, view.getRight()) : view.getRight();
                    z2 = true;
                }
            }
            return i2 - i3;
        }

        public f getTab() {
            return this.f19688b;
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f19692f;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(contentDescription + ", " + this.f19692f.g());
            }
            u.c a2 = u.c.a(accessibilityNodeInfo);
            a2.b((Object) c.C0258c.a(0, 1, this.f19688b.c(), 1, false, isSelected()));
            if (isSelected()) {
                a2.h(false);
                a2.b(c.a.f34535e);
            }
            a2.j((CharSequence) getResources().getString(R.string.item_view_role_description));
        }

        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f19676o, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f19689c != null) {
                float f2 = TabLayout.this.f19673l;
                int i4 = this.f19697k;
                ImageView imageView = this.f19690d;
                boolean z2 = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f19689c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.f19674m;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f19689c.getTextSize();
                int lineCount = this.f19689c.getLineCount();
                int a2 = androidx.core.widget.j.a(this.f19689c);
                if (f2 != textSize || (a2 >= 0 && i4 != a2)) {
                    if (TabLayout.this.f19680s == 1 && f2 > textSize && lineCount == 1 && ((layout = this.f19689c.getLayout()) == null || a(layout, 0, f2) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z2 = false;
                    }
                    if (z2) {
                        this.f19689c.setTextSize(0, f2);
                        this.f19689c.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f19688b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f19688b.f();
            return true;
        }

        public void setSelected(boolean z2) {
            boolean z3 = isSelected() != z2;
            super.setSelected(z2);
            if (z3 && z2 && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f19689c;
            if (textView != null) {
                textView.setSelected(z2);
            }
            ImageView imageView = this.f19690d;
            if (imageView != null) {
                imageView.setSelected(z2);
            }
            View view = this.f19693g;
            if (view != null) {
                view.setSelected(z2);
            }
        }

        /* access modifiers changed from: package-private */
        public void setTab(f fVar) {
            if (fVar != this.f19688b) {
                this.f19688b = fVar;
                b();
            }
        }
    }

    private class a implements ViewPager.d {

        /* renamed from: b  reason: collision with root package name */
        private boolean f19701b;

        a() {
        }

        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            if (TabLayout.this.f19685x == viewPager) {
                TabLayout.this.a(aVar2, this.f19701b);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z2) {
            this.f19701b = z2;
        }
    }

    @Deprecated
    public interface b<T extends f> {
        void a(T t2);

        void b(T t2);

        void c(T t2);
    }

    public interface c extends b<f> {
    }

    private class d extends DataSetObserver {
        d() {
        }

        public void onChanged() {
            TabLayout.this.e();
        }

        public void onInvalidated() {
            TabLayout.this.e();
        }
    }

    class e extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        ValueAnimator f19703a;

        /* renamed from: b  reason: collision with root package name */
        int f19704b = -1;

        /* renamed from: c  reason: collision with root package name */
        float f19705c;

        /* renamed from: e  reason: collision with root package name */
        private int f19707e = -1;

        e(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        /* access modifiers changed from: private */
        public void a(View view, View view2, float f2) {
            if (view != null && view.getWidth() > 0) {
                b a2 = TabLayout.this.H;
                TabLayout tabLayout = TabLayout.this;
                a2.a(tabLayout, view, view2, f2, tabLayout.f19671j);
            } else {
                TabLayout.this.f19671j.setBounds(-1, TabLayout.this.f19671j.getBounds().top, -1, TabLayout.this.f19671j.getBounds().bottom);
            }
            ac.e(this);
        }

        private void a(boolean z2, final int i2, int i3) {
            final View childAt = getChildAt(this.f19704b);
            final View childAt2 = getChildAt(i2);
            if (childAt2 == null) {
                b();
                return;
            }
            AnonymousClass1 r2 = new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    e.this.a(childAt, childAt2, valueAnimator.getAnimatedFraction());
                }
            };
            if (z2) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f19703a = valueAnimator;
                valueAnimator.setInterpolator(gl.a.f28536b);
                valueAnimator.setDuration((long) i3);
                valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator.addUpdateListener(r2);
                valueAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        e.this.f19704b = i2;
                    }

                    public void onAnimationStart(Animator animator) {
                        e.this.f19704b = i2;
                    }
                });
                valueAnimator.start();
                return;
            }
            this.f19703a.removeAllUpdateListeners();
            this.f19703a.addUpdateListener(r2);
        }

        private void b() {
            View childAt = getChildAt(this.f19704b);
            b a2 = TabLayout.this.H;
            TabLayout tabLayout = TabLayout.this;
            a2.a(tabLayout, childAt, tabLayout.f19671j);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            Rect bounds = TabLayout.this.f19671j.getBounds();
            TabLayout.this.f19671j.setBounds(bounds.left, 0, bounds.right, i2);
            requestLayout();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, float f2) {
            ValueAnimator valueAnimator = this.f19703a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f19703a.cancel();
            }
            this.f19704b = i2;
            this.f19705c = f2;
            a(getChildAt(i2), getChildAt(this.f19704b + 1), this.f19705c);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            ValueAnimator valueAnimator = this.f19703a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f19703a.cancel();
            }
            a(true, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void draw(android.graphics.Canvas r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.f19671j
                android.graphics.Rect r0 = r0.getBounds()
                int r0 = r0.height()
                if (r0 >= 0) goto L_0x0016
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.f19671j
                int r0 = r0.getIntrinsicHeight()
            L_0x0016:
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                int r1 = r1.f19679r
                r2 = 0
                if (r1 == 0) goto L_0x0037
                r3 = 1
                r4 = 2
                if (r1 == r3) goto L_0x0028
                if (r1 == r4) goto L_0x0041
                r0 = 3
                if (r1 == r0) goto L_0x003d
                r0 = 0
                goto L_0x0041
            L_0x0028:
                int r1 = r5.getHeight()
                int r1 = r1 - r0
                int r2 = r1 / 2
                int r1 = r5.getHeight()
                int r1 = r1 + r0
                int r0 = r1 / 2
                goto L_0x0041
            L_0x0037:
                int r1 = r5.getHeight()
                int r2 = r1 - r0
            L_0x003d:
                int r0 = r5.getHeight()
            L_0x0041:
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r1 = r1.f19671j
                android.graphics.Rect r1 = r1.getBounds()
                int r1 = r1.width()
                if (r1 <= 0) goto L_0x0090
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r1 = r1.f19671j
                android.graphics.Rect r1 = r1.getBounds()
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r3 = r3.f19671j
                int r4 = r1.left
                int r1 = r1.right
                r3.setBounds(r4, r2, r1, r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.f19671j
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                int r1 = r1.C
                if (r1 == 0) goto L_0x008d
                android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.a.g(r0)
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 21
                if (r1 != r2) goto L_0x0084
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                int r1 = r1.C
                android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
                r0.setColorFilter(r1, r2)
                goto L_0x008d
            L_0x0084:
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                int r1 = r1.C
                androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r0, (int) r1)
            L_0x008d:
                r0.draw(r6)
            L_0x0090:
                super.draw(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.e.draw(android.graphics.Canvas):void");
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            super.onLayout(z2, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f19703a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                b();
            } else {
                a(false, this.f19704b, -1);
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                boolean z2 = true;
                if (TabLayout.this.f19677p == 1 || TabLayout.this.f19680s == 2) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (((int) s.a(getContext(), 16)) * 2)) {
                            boolean z3 = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = 0.0f;
                                    z3 = true;
                                }
                            }
                            z2 = z3;
                        } else {
                            TabLayout.this.f19677p = 0;
                            TabLayout.this.a(false);
                        }
                        if (z2) {
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.f19707e != i2) {
                requestLayout();
                this.f19707e = i2;
            }
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TabLayout f19713a;

        /* renamed from: b  reason: collision with root package name */
        public TabView f19714b;

        /* renamed from: c  reason: collision with root package name */
        private Object f19715c;

        /* renamed from: d  reason: collision with root package name */
        private Drawable f19716d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f19717e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f19718f;

        /* renamed from: g  reason: collision with root package name */
        private int f19719g = -1;

        /* renamed from: h  reason: collision with root package name */
        private View f19720h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f19721i = 1;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public int f19722j = -1;

        public View a() {
            return this.f19720h;
        }

        public f a(int i2) {
            return a(LayoutInflater.from(this.f19714b.getContext()).inflate(i2, this.f19714b, false));
        }

        public f a(Drawable drawable) {
            this.f19716d = drawable;
            if (this.f19713a.f19677p == 1 || this.f19713a.f19680s == 2) {
                this.f19713a.a(true);
            }
            h();
            if (com.google.android.material.badge.a.f18524a && this.f19714b.i() && this.f19714b.f19692f.isVisible()) {
                this.f19714b.invalidate();
            }
            return this;
        }

        public f a(View view) {
            this.f19720h = view;
            h();
            return this;
        }

        public f a(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f19718f) && !TextUtils.isEmpty(charSequence)) {
                this.f19714b.setContentDescription(charSequence);
            }
            this.f19717e = charSequence;
            h();
            return this;
        }

        public Drawable b() {
            return this.f19716d;
        }

        public f b(CharSequence charSequence) {
            this.f19718f = charSequence;
            h();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.f19719g = i2;
        }

        public int c() {
            return this.f19719g;
        }

        public CharSequence d() {
            return this.f19717e;
        }

        public int e() {
            return this.f19721i;
        }

        public void f() {
            TabLayout tabLayout = this.f19713a;
            if (tabLayout != null) {
                tabLayout.c(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean g() {
            TabLayout tabLayout = this.f19713a;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f19719g;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public void h() {
            TabView tabView = this.f19714b;
            if (tabView != null) {
                tabView.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            this.f19713a = null;
            this.f19714b = null;
            this.f19715c = null;
            this.f19716d = null;
            this.f19722j = -1;
            this.f19717e = null;
            this.f19718f = null;
            this.f19719g = -1;
            this.f19720h = null;
        }
    }

    public static class g implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f19723a;

        /* renamed from: b  reason: collision with root package name */
        private int f19724b;

        /* renamed from: c  reason: collision with root package name */
        private int f19725c;

        public g(TabLayout tabLayout) {
            this.f19723a = new WeakReference<>(tabLayout);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f19725c = 0;
            this.f19724b = 0;
        }

        public void onPageScrollStateChanged(int i2) {
            this.f19724b = this.f19725c;
            this.f19725c = i2;
        }

        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = (TabLayout) this.f19723a.get();
            if (tabLayout != null) {
                int i4 = this.f19725c;
                boolean z2 = false;
                boolean z3 = i4 != 2 || this.f19724b == 1;
                if (!(i4 == 2 && this.f19724b == 0)) {
                    z2 = true;
                }
                tabLayout.a(i2, f2, z3, z2);
            }
        }

        public void onPageSelected(int i2) {
            TabLayout tabLayout = (TabLayout) this.f19723a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i2 && i2 < tabLayout.getTabCount()) {
                int i3 = this.f19725c;
                tabLayout.b(tabLayout.a(i2), i3 == 0 || (i3 == 2 && this.f19724b == 0));
            }
        }
    }

    public static class h implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f19726a;

        public h(ViewPager viewPager) {
            this.f19726a = viewPager;
        }

        public void a(f fVar) {
            this.f19726a.setCurrentItem(fVar.c());
        }

        public void b(f fVar) {
        }

        public void c(f fVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = f19660y
            android.content.Context r11 = gx.a.a(r11, r12, r13, r4)
            r10.<init>(r11, r12, r13)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r10.A = r11
            android.graphics.drawable.GradientDrawable r11 = new android.graphics.drawable.GradientDrawable
            r11.<init>()
            r10.f19671j = r11
            r11 = 0
            r10.C = r11
            r0 = 2147483647(0x7fffffff, float:NaN)
            r10.f19676o = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.J = r0
            s.e$b r0 = new s.e$b
            r1 = 12
            r0.<init>(r1)
            r10.R = r0
            android.content.Context r6 = r10.getContext()
            r10.setHorizontalScrollBarEnabled(r11)
            com.google.android.material.tabs.TabLayout$e r7 = new com.google.android.material.tabs.TabLayout$e
            r7.<init>(r6)
            r10.f19662a = r7
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -2
            r8 = -1
            r0.<init>(r1, r8)
            super.addView(r7, r11, r0)
            int[] r2 = com.google.android.material.R.styleable.TabLayout
            r9 = 1
            int[] r5 = new int[r9]
            int r0 = com.google.android.material.R.styleable.TabLayout_tabTextAppearance
            r5[r11] = r0
            r0 = r6
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r12 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            android.graphics.drawable.Drawable r13 = r10.getBackground()
            boolean r13 = r13 instanceof android.graphics.drawable.ColorDrawable
            if (r13 == 0) goto L_0x0082
            android.graphics.drawable.Drawable r13 = r10.getBackground()
            android.graphics.drawable.ColorDrawable r13 = (android.graphics.drawable.ColorDrawable) r13
            gw.h r0 = new gw.h
            r0.<init>()
            int r13 = r13.getColor()
            android.content.res.ColorStateList r13 = android.content.res.ColorStateList.valueOf(r13)
            r0.g((android.content.res.ColorStateList) r13)
            r0.a((android.content.Context) r6)
            float r13 = t.ac.s(r10)
            r0.r(r13)
            t.ac.a((android.view.View) r10, (android.graphics.drawable.Drawable) r0)
        L_0x0082:
            int r13 = com.google.android.material.R.styleable.TabLayout_tabIndicator
            android.graphics.drawable.Drawable r13 = gt.c.b(r6, r12, r13)
            r10.setSelectedTabIndicator((android.graphics.drawable.Drawable) r13)
            int r13 = com.google.android.material.R.styleable.TabLayout_tabIndicatorColor
            int r13 = r12.getColor(r13, r11)
            r10.setSelectedTabIndicatorColor(r13)
            int r13 = com.google.android.material.R.styleable.TabLayout_tabIndicatorHeight
            int r13 = r12.getDimensionPixelSize(r13, r8)
            r7.a(r13)
            int r13 = com.google.android.material.R.styleable.TabLayout_tabIndicatorGravity
            int r13 = r12.getInt(r13, r11)
            r10.setSelectedTabIndicatorGravity(r13)
            int r13 = com.google.android.material.R.styleable.TabLayout_tabIndicatorFullWidth
            boolean r13 = r12.getBoolean(r13, r9)
            r10.setTabIndicatorFullWidth(r13)
            int r13 = com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationMode
            int r13 = r12.getInt(r13, r11)
            r10.setTabIndicatorAnimationMode(r13)
            int r13 = com.google.android.material.R.styleable.TabLayout_tabPadding
            int r13 = r12.getDimensionPixelSize(r13, r11)
            r10.f19666e = r13
            r10.f19665d = r13
            r10.f19664c = r13
            r10.f19663b = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabPaddingStart
            int r0 = r10.f19663b
            int r13 = r12.getDimensionPixelSize(r13, r0)
            r10.f19663b = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabPaddingTop
            int r0 = r10.f19664c
            int r13 = r12.getDimensionPixelSize(r13, r0)
            r10.f19664c = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabPaddingEnd
            int r0 = r10.f19665d
            int r13 = r12.getDimensionPixelSize(r13, r0)
            r10.f19665d = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabPaddingBottom
            int r0 = r10.f19666e
            int r13 = r12.getDimensionPixelSize(r13, r0)
            r10.f19666e = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabTextAppearance
            int r0 = com.google.android.material.R.style.TextAppearance_Design_Tab
            int r13 = r12.getResourceId(r13, r0)
            r10.f19667f = r13
            int[] r0 = androidx.appcompat.R.styleable.TextAppearance
            android.content.res.TypedArray r13 = r6.obtainStyledAttributes(r13, r0)
            int r0 = androidx.appcompat.R.styleable.TextAppearance_android_textSize     // Catch:{ all -> 0x01bf }
            int r0 = r13.getDimensionPixelSize(r0, r11)     // Catch:{ all -> 0x01bf }
            float r0 = (float) r0     // Catch:{ all -> 0x01bf }
            r10.f19673l = r0     // Catch:{ all -> 0x01bf }
            int r0 = androidx.appcompat.R.styleable.TextAppearance_android_textColor     // Catch:{ all -> 0x01bf }
            android.content.res.ColorStateList r0 = gt.c.a((android.content.Context) r6, (android.content.res.TypedArray) r13, (int) r0)     // Catch:{ all -> 0x01bf }
            r10.f19668g = r0     // Catch:{ all -> 0x01bf }
            r13.recycle()
            int r13 = com.google.android.material.R.styleable.TabLayout_tabTextColor
            boolean r13 = r12.hasValue(r13)
            if (r13 == 0) goto L_0x0122
            int r13 = com.google.android.material.R.styleable.TabLayout_tabTextColor
            android.content.res.ColorStateList r13 = gt.c.a((android.content.Context) r6, (android.content.res.TypedArray) r12, (int) r13)
            r10.f19668g = r13
        L_0x0122:
            int r13 = com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor
            boolean r13 = r12.hasValue(r13)
            if (r13 == 0) goto L_0x013c
            int r13 = com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor
            int r13 = r12.getColor(r13, r11)
            android.content.res.ColorStateList r0 = r10.f19668g
            int r0 = r0.getDefaultColor()
            android.content.res.ColorStateList r13 = a((int) r0, (int) r13)
            r10.f19668g = r13
        L_0x013c:
            int r13 = com.google.android.material.R.styleable.TabLayout_tabIconTint
            android.content.res.ColorStateList r13 = gt.c.a((android.content.Context) r6, (android.content.res.TypedArray) r12, (int) r13)
            r10.f19669h = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabIconTintMode
            int r13 = r12.getInt(r13, r8)
            r0 = 0
            android.graphics.PorterDuff$Mode r13 = com.google.android.material.internal.s.a((int) r13, (android.graphics.PorterDuff.Mode) r0)
            r10.f19672k = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabRippleColor
            android.content.res.ColorStateList r13 = gt.c.a((android.content.Context) r6, (android.content.res.TypedArray) r12, (int) r13)
            r10.f19670i = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationDuration
            r0 = 300(0x12c, float:4.2E-43)
            int r13 = r12.getInt(r13, r0)
            r10.f19678q = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabMinWidth
            int r13 = r12.getDimensionPixelSize(r13, r8)
            r10.D = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabMaxWidth
            int r13 = r12.getDimensionPixelSize(r13, r8)
            r10.E = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabBackground
            int r13 = r12.getResourceId(r13, r11)
            r10.f19675n = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabContentStart
            int r13 = r12.getDimensionPixelSize(r13, r11)
            r10.G = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabMode
            int r13 = r12.getInt(r13, r9)
            r10.f19680s = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabGravity
            int r13 = r12.getInt(r13, r11)
            r10.f19677p = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabInlineLabel
            boolean r13 = r12.getBoolean(r13, r11)
            r10.f19681t = r13
            int r13 = com.google.android.material.R.styleable.TabLayout_tabUnboundedRipple
            boolean r11 = r12.getBoolean(r13, r11)
            r10.f19684w = r11
            r12.recycle()
            android.content.res.Resources r11 = r10.getResources()
            int r12 = com.google.android.material.R.dimen.design_tab_text_size_2line
            int r12 = r11.getDimensionPixelSize(r12)
            float r12 = (float) r12
            r10.f19674m = r12
            int r12 = com.google.android.material.R.dimen.design_tab_scrollable_min_width
            int r11 = r11.getDimensionPixelSize(r12)
            r10.F = r11
            r10.i()
            return
        L_0x01bf:
            r11 = move-exception
            r13.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private int a(int i2, float f2) {
        int i3 = this.f19680s;
        int i4 = 0;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.f19662a.getChildAt(i2);
        int i5 = i2 + 1;
        View childAt2 = i5 < this.f19662a.getChildCount() ? this.f19662a.getChildAt(i5) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i6 = (int) (((float) (width + i4)) * 0.5f * f2);
        return ac.i(this) == 0 ? left + i6 : left - i6;
    }

    private static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private void a(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        float f2;
        if (this.f19680s == 1 && this.f19677p == 0) {
            layoutParams.width = 0;
            f2 = 1.0f;
        } else {
            layoutParams.width = -2;
            f2 = 0.0f;
        }
        layoutParams.weight = f2;
    }

    private void a(ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.f19685x;
        if (viewPager2 != null) {
            g gVar = this.O;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            a aVar = this.P;
            if (aVar != null) {
                this.f19685x.removeOnAdapterChangeListener(aVar);
            }
        }
        b bVar = this.K;
        if (bVar != null) {
            b(bVar);
            this.K = null;
        }
        if (viewPager != null) {
            this.f19685x = viewPager;
            if (this.O == null) {
                this.O = new g(this);
            }
            this.O.a();
            viewPager.addOnPageChangeListener(this.O);
            h hVar = new h(viewPager);
            this.K = hVar;
            a((b) hVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z2);
            }
            if (this.P == null) {
                this.P = new a();
            }
            this.P.a(z2);
            viewPager.addOnAdapterChangeListener(this.P);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f19685x = null;
            a((androidx.viewpager.widget.a) null, false);
        }
        this.Q = z3;
    }

    private void a(TabItem tabItem) {
        f a2 = a();
        if (tabItem.f19657a != null) {
            a2.a(tabItem.f19657a);
        }
        if (tabItem.f19658b != null) {
            a2.a(tabItem.f19658b);
        }
        if (tabItem.f19659c != 0) {
            a2.a(tabItem.f19659c);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            a2.b(tabItem.getContentDescription());
        }
        a(a2);
    }

    private void a(f fVar, int i2) {
        fVar.b(i2);
        this.A.add(i2, fVar);
        int size = this.A.size();
        while (true) {
            i2++;
            if (i2 < size) {
                this.A.get(i2).b(i2);
            } else {
                return;
            }
        }
    }

    private void b(int i2) {
        TabView tabView = (TabView) this.f19662a.getChildAt(i2);
        this.f19662a.removeViewAt(i2);
        if (tabView != null) {
            tabView.a();
            this.R.a(tabView);
        }
        requestLayout();
    }

    private void c(int i2) {
        if (i2 != -1) {
            if (getWindowToken() == null || !ac.G(this) || this.f19662a.a()) {
                a(i2, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int a2 = a(i2, 0.0f);
            if (scrollX != a2) {
                h();
                this.L.setIntValues(new int[]{scrollX, a2});
                this.L.start();
            }
            this.f19662a.a(i2, this.f19678q);
        }
    }

    private TabView d(f fVar) {
        e.a<TabView> aVar = this.R;
        TabView a2 = aVar != null ? aVar.a() : null;
        if (a2 == null) {
            a2 = new TabView(getContext());
        }
        a2.setTab(fVar);
        a2.setFocusable(true);
        a2.setMinimumWidth(getTabMinWidth());
        a2.setContentDescription(TextUtils.isEmpty(fVar.f19718f) ? fVar.f19717e : fVar.f19718f);
        return a2;
    }

    private void d(int i2) {
        e eVar;
        int i3;
        if (i2 != 0) {
            i3 = 1;
            if (i2 == 1) {
                eVar = this.f19662a;
                eVar.setGravity(i3);
            } else if (i2 != 2) {
                return;
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        eVar = this.f19662a;
        i3 = 8388611;
        eVar.setGravity(i3);
    }

    private void e(f fVar) {
        TabView tabView = fVar.f19714b;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f19662a.addView(tabView, fVar.c(), g());
    }

    private void f() {
        int size = this.A.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.A.get(i2).h();
        }
    }

    private void f(f fVar) {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            this.J.get(size).a(fVar);
        }
    }

    private LinearLayout.LayoutParams g() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void g(f fVar) {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            this.J.get(size).b(fVar);
        }
    }

    private int getDefaultHeight() {
        int size = this.A.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.A.get(i2);
                if (fVar != null && fVar.b() != null && !TextUtils.isEmpty(fVar.d())) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z2 || this.f19681t) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.D;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.f19680s;
        if (i3 == 0 || i3 == 2) {
            return this.F;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f19662a.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h() {
        if (this.L == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.L = valueAnimator;
            valueAnimator.setInterpolator(gl.a.f28536b);
            this.L.setDuration((long) this.f19678q);
            this.L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private void h(f fVar) {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            this.J.get(size).c(fVar);
        }
    }

    private void i() {
        int i2 = this.f19680s;
        ac.b(this.f19662a, (i2 == 0 || i2 == 2) ? Math.max(0, this.G - this.f19663b) : 0, 0, 0, 0);
        int i3 = this.f19680s;
        if (i3 == 0) {
            d(this.f19677p);
        } else if (i3 == 1 || i3 == 2) {
            if (this.f19677p == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f19662a.setGravity(1);
        }
        a(true);
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f19662a.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f19662a.getChildAt(i3);
                boolean z2 = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i3++;
            }
        }
    }

    public f a() {
        f b2 = b();
        b2.f19713a = this;
        b2.f19714b = d(b2);
        if (b2.f19722j != -1) {
            b2.f19714b.setId(b2.f19722j);
        }
        return b2;
    }

    public f a(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.A.get(i2);
    }

    public void a(int i2, float f2, boolean z2) {
        a(i2, f2, z2, true);
    }

    public void a(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.f19662a.getChildCount()) {
            if (z3) {
                this.f19662a.a(i2, f2);
            }
            ValueAnimator valueAnimator = this.L;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.L.cancel();
            }
            scrollTo(a(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public void a(ViewPager viewPager, boolean z2) {
        a(viewPager, z2, false);
    }

    /* access modifiers changed from: package-private */
    public void a(androidx.viewpager.widget.a aVar, boolean z2) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.M;
        if (!(aVar2 == null || (dataSetObserver = this.N) == null)) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.M = aVar;
        if (z2 && aVar != null) {
            if (this.N == null) {
                this.N = new d();
            }
            aVar.registerDataSetObserver(this.N);
        }
        e();
    }

    @Deprecated
    public void a(b bVar) {
        if (!this.J.contains(bVar)) {
            this.J.add(bVar);
        }
    }

    public void a(f fVar) {
        a(fVar, this.A.isEmpty());
    }

    public void a(f fVar, int i2, boolean z2) {
        if (fVar.f19713a == this) {
            a(fVar, i2);
            e(fVar);
            if (z2) {
                fVar.f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void a(f fVar, boolean z2) {
        a(fVar, this.A.size(), z2);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        for (int i2 = 0; i2 < this.f19662a.getChildCount(); i2++) {
            View childAt = this.f19662a.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public void addView(View view) {
        a(view);
    }

    public void addView(View view, int i2) {
        a(view);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    /* access modifiers changed from: protected */
    public f b() {
        f a2 = f19661z.a();
        return a2 == null ? new f() : a2;
    }

    @Deprecated
    public void b(b bVar) {
        this.J.remove(bVar);
    }

    public void b(f fVar, boolean z2) {
        f fVar2 = this.B;
        if (fVar2 != fVar) {
            int c2 = fVar != null ? fVar.c() : -1;
            if (z2) {
                if ((fVar2 == null || fVar2.c() == -1) && c2 != -1) {
                    a(c2, 0.0f, true);
                } else {
                    c(c2);
                }
                if (c2 != -1) {
                    setSelectedTabView(c2);
                }
            }
            this.B = fVar;
            if (fVar2 != null) {
                g(fVar2);
            }
            if (fVar != null) {
                f(fVar);
            }
        } else if (fVar2 != null) {
            h(fVar);
            c(fVar.c());
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(f fVar) {
        return f19661z.a(fVar);
    }

    public void c() {
        for (int childCount = this.f19662a.getChildCount() - 1; childCount >= 0; childCount--) {
            b(childCount);
        }
        Iterator<f> it2 = this.A.iterator();
        while (it2.hasNext()) {
            f next = it2.next();
            it2.remove();
            next.i();
            b(next);
        }
        this.B = null;
    }

    public void c(f fVar) {
        b(fVar, true);
    }

    public boolean d() {
        return this.f19682u;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        int currentItem;
        c();
        androidx.viewpager.widget.a aVar = this.M;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                a(a().a(this.M.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.f19685x;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                c(a(currentItem));
            }
        }
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        f fVar = this.B;
        if (fVar != null) {
            return fVar.c();
        }
        return -1;
    }

    public int getTabCount() {
        return this.A.size();
    }

    public int getTabGravity() {
        return this.f19677p;
    }

    public ColorStateList getTabIconTint() {
        return this.f19669h;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f19683v;
    }

    public int getTabIndicatorGravity() {
        return this.f19679r;
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.f19676o;
    }

    public int getTabMode() {
        return this.f19680s;
    }

    public ColorStateList getTabRippleColor() {
        return this.f19670i;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f19671j;
    }

    public ColorStateList getTabTextColors() {
        return this.f19668g;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
        if (this.f19685x == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Q) {
            setupWithViewPager((ViewPager) null);
            this.Q = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.f19662a.getChildCount(); i2++) {
            View childAt = this.f19662a.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).a(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        u.c.a(accessibilityNodeInfo).a((Object) c.b.a(1, getTabCount(), false, 1));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.s.a((android.content.Context) r0, (int) r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L_0x002e
            if (r1 == 0) goto L_0x001f
            goto L_0x0041
        L_0x001f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L_0x0041
        L_0x002e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L_0x0041
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L_0x0041
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L_0x0041:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L_0x005f
            int r1 = r6.E
            if (r1 <= 0) goto L_0x0050
            goto L_0x005d
        L_0x0050:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.s.a((android.content.Context) r1, (int) r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L_0x005d:
            r6.f19676o = r1
        L_0x005f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto L_0x00ad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.f19680s
            if (r0 == 0) goto L_0x0082
            if (r0 == r5) goto L_0x0076
            r1 = 2
            if (r0 == r1) goto L_0x0082
            goto L_0x008d
        L_0x0076:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L_0x008d
        L_0x0080:
            r4 = 1
            goto L_0x008d
        L_0x0082:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L_0x008d
            goto L_0x0080
        L_0x008d:
            if (r4 == 0) goto L_0x00ad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a((View) this, f2);
    }

    public void setInlineLabel(boolean z2) {
        if (this.f19681t != z2) {
            this.f19681t = z2;
            for (int i2 = 0; i2 < this.f19662a.getChildCount(); i2++) {
                View childAt = this.f19662a.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).c();
                }
            }
            i();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        b bVar2 = this.I;
        if (bVar2 != null) {
            b(bVar2);
        }
        this.I = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        setOnTabSelectedListener((b) cVar);
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        h();
        this.L.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(int i2) {
        setSelectedTabIndicator(i2 != 0 ? c.a.b(getContext(), i2) : null);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.f19671j != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f19671j = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.C = i2;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.f19679r != i2) {
            this.f19679r = i2;
            ac.e(this.f19662a);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f19662a.a(i2);
    }

    public void setTabGravity(int i2) {
        if (this.f19677p != i2) {
            this.f19677p = i2;
            i();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f19669h != colorStateList) {
            this.f19669h = colorStateList;
            f();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(c.a.a(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        b bVar;
        this.f19683v = i2;
        if (i2 == 0) {
            bVar = new b();
        } else if (i2 == 1) {
            bVar = new a();
        } else {
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
        this.H = bVar;
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.f19682u = z2;
        ac.e(this.f19662a);
    }

    public void setTabMode(int i2) {
        if (i2 != this.f19680s) {
            this.f19680s = i2;
            i();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f19670i != colorStateList) {
            this.f19670i = colorStateList;
            for (int i2 = 0; i2 < this.f19662a.getChildCount(); i2++) {
                View childAt = this.f19662a.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(c.a.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f19668g != colorStateList) {
            this.f19668g = colorStateList;
            f();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        a(aVar, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.f19684w != z2) {
            this.f19684w = z2;
            for (int i2 = 0; i2 < this.f19662a.getChildCount(); i2++) {
                View childAt = this.f19662a.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }
}
