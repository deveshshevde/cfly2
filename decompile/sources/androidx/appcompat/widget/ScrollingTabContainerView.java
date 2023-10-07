package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.constant.MemoryConstants;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: l  reason: collision with root package name */
    private static final Interpolator f1231l = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    Runnable f1232a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayoutCompat f1233b;

    /* renamed from: c  reason: collision with root package name */
    int f1234c;

    /* renamed from: d  reason: collision with root package name */
    int f1235d;

    /* renamed from: e  reason: collision with root package name */
    protected ViewPropertyAnimator f1236e;

    /* renamed from: f  reason: collision with root package name */
    protected final d f1237f = new d();

    /* renamed from: g  reason: collision with root package name */
    private b f1238g;

    /* renamed from: h  reason: collision with root package name */
    private Spinner f1239h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1240i;

    /* renamed from: j  reason: collision with root package name */
    private int f1241j;

    /* renamed from: k  reason: collision with root package name */
    private int f1242k;

    private class a extends BaseAdapter {
        a() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.f1233b.getChildCount();
        }

        public Object getItem(int i2) {
            return ((c) ScrollingTabContainerView.this.f1233b.getChildAt(i2)).b();
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.a((ActionBar.b) getItem(i2), true);
            }
            ((c) view).a((ActionBar.b) getItem(i2));
            return view;
        }
    }

    private class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            ((c) view).b().d();
            int childCount = ScrollingTabContainerView.this.f1233b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ScrollingTabContainerView.this.f1233b.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class c extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private final int[] f1248b;

        /* renamed from: c  reason: collision with root package name */
        private ActionBar.b f1249c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f1250d;

        /* renamed from: e  reason: collision with root package name */
        private ImageView f1251e;

        /* renamed from: f  reason: collision with root package name */
        private View f1252f;

        public c(Context context, ActionBar.b bVar, boolean z2) {
            super(context, (AttributeSet) null, R.attr.actionBarTabStyle);
            int[] iArr = {16842964};
            this.f1248b = iArr;
            this.f1249c = bVar;
            af a2 = af.a(context, (AttributeSet) null, iArr, R.attr.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.a(0));
            }
            a2.b();
            if (z2) {
                setGravity(8388627);
            }
            a();
        }

        public void a() {
            ActionBar.b bVar = this.f1249c;
            View c2 = bVar.c();
            CharSequence charSequence = null;
            if (c2 != null) {
                ViewParent parent = c2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c2);
                    }
                    addView(c2);
                }
                this.f1252f = c2;
                TextView textView = this.f1250d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1251e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1251e.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f1252f;
            if (view != null) {
                removeView(view);
                this.f1252f = null;
            }
            Drawable a2 = bVar.a();
            CharSequence b2 = bVar.b();
            if (a2 != null) {
                if (this.f1251e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1251e = appCompatImageView;
                }
                this.f1251e.setImageDrawable(a2);
                this.f1251e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1251e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1251e.setImageDrawable((Drawable) null);
                }
            }
            boolean z2 = !TextUtils.isEmpty(b2);
            if (z2) {
                if (this.f1250d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1250d = appCompatTextView;
                }
                this.f1250d.setText(b2);
                this.f1250d.setVisibility(0);
            } else {
                TextView textView2 = this.f1250d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1250d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1251e;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.e());
            }
            if (!z2) {
                charSequence = bVar.e();
            }
            ah.a(this, charSequence);
        }

        public void a(ActionBar.b bVar) {
            this.f1249c = bVar;
            a();
        }

        public ActionBar.b b() {
            return this.f1249c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (ScrollingTabContainerView.this.f1234c > 0 && getMeasuredWidth() > ScrollingTabContainerView.this.f1234c) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.f1234c, MemoryConstants.GB), i3);
            }
        }

        public void setSelected(boolean z2) {
            boolean z3 = isSelected() != z2;
            super.setSelected(z2);
            if (z3 && z2) {
                sendAccessibilityEvent(4);
            }
        }
    }

    protected class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1254b = false;

        /* renamed from: c  reason: collision with root package name */
        private int f1255c;

        protected d() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f1254b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f1254b) {
                ScrollingTabContainerView.this.f1236e = null;
                ScrollingTabContainerView.this.setVisibility(this.f1255c);
            }
        }

        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f1254b = false;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        f.a a2 = f.a.a(context);
        setContentHeight(a2.e());
        this.f1235d = a2.g();
        LinearLayoutCompat d2 = d();
        this.f1233b = d2;
        addView(d2, new ViewGroup.LayoutParams(-2, -1));
    }

    private boolean a() {
        Spinner spinner = this.f1239h;
        return spinner != null && spinner.getParent() == this;
    }

    private void b() {
        if (!a()) {
            if (this.f1239h == null) {
                this.f1239h = e();
            }
            removeView(this.f1233b);
            addView(this.f1239h, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1239h.getAdapter() == null) {
                this.f1239h.setAdapter(new a());
            }
            Runnable runnable = this.f1232a;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f1232a = null;
            }
            this.f1239h.setSelection(this.f1242k);
        }
    }

    private boolean c() {
        if (!a()) {
            return false;
        }
        removeView(this.f1239h);
        addView(this.f1233b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1239h.getSelectedItemPosition());
        return false;
    }

    private LinearLayoutCompat d() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private Spinner e() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    /* access modifiers changed from: package-private */
    public c a(ActionBar.b bVar, boolean z2) {
        c cVar = new c(getContext(), bVar, z2);
        if (z2) {
            cVar.setBackgroundDrawable((Drawable) null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1241j));
        } else {
            cVar.setFocusable(true);
            if (this.f1238g == null) {
                this.f1238g = new b();
            }
            cVar.setOnClickListener(this.f1238g);
        }
        return cVar;
    }

    public void a(int i2) {
        final View childAt = this.f1233b.getChildAt(i2);
        Runnable runnable = this.f1232a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f1232a = null;
            }
        };
        this.f1232a = r0;
        post(r0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1232a;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f.a a2 = f.a.a(getContext());
        setContentHeight(a2.e());
        this.f1235d = a2.g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1232a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((c) view).b().d();
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        boolean z2 = true;
        boolean z3 = mode == 1073741824;
        setFillViewport(z3);
        int childCount = this.f1233b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i4 = -1;
        } else {
            if (childCount > 2) {
                this.f1234c = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.f1234c = View.MeasureSpec.getSize(i2) / 2;
            }
            i4 = Math.min(this.f1234c, this.f1235d);
        }
        this.f1234c = i4;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1241j, MemoryConstants.GB);
        if (z3 || !this.f1240i) {
            z2 = false;
        }
        if (z2) {
            this.f1233b.measure(0, makeMeasureSpec);
            if (this.f1233b.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                b();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i2, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z3 && measuredWidth != measuredWidth2) {
                    setTabSelected(this.f1242k);
                    return;
                }
            }
        }
        c();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z3) {
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z2) {
        this.f1240i = z2;
    }

    public void setContentHeight(int i2) {
        this.f1241j = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f1242k = i2;
        int childCount = this.f1233b.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f1233b.getChildAt(i3);
            boolean z2 = i3 == i2;
            childAt.setSelected(z2);
            if (z2) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.f1239h;
        if (spinner != null && i2 >= 0) {
            spinner.setSelection(i2);
        }
    }
}
