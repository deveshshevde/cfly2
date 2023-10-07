package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.android.material.internal.i;
import com.google.android.material.internal.l;
import gt.c;
import gt.d;
import gw.h;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import t.ac;

public class BadgeDrawable extends Drawable implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18489a = R.style.Widget_MaterialComponents_Badge;

    /* renamed from: b  reason: collision with root package name */
    private static final int f18490b = R.attr.badgeStyle;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<Context> f18491c;

    /* renamed from: d  reason: collision with root package name */
    private final h f18492d = new h();

    /* renamed from: e  reason: collision with root package name */
    private final i f18493e;

    /* renamed from: f  reason: collision with root package name */
    private final Rect f18494f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final float f18495g;

    /* renamed from: h  reason: collision with root package name */
    private final float f18496h;

    /* renamed from: i  reason: collision with root package name */
    private final float f18497i;

    /* renamed from: j  reason: collision with root package name */
    private final SavedState f18498j;

    /* renamed from: k  reason: collision with root package name */
    private float f18499k;

    /* renamed from: l  reason: collision with root package name */
    private float f18500l;

    /* renamed from: m  reason: collision with root package name */
    private int f18501m;

    /* renamed from: n  reason: collision with root package name */
    private float f18502n;

    /* renamed from: o  reason: collision with root package name */
    private float f18503o;

    /* renamed from: p  reason: collision with root package name */
    private float f18504p;

    /* renamed from: q  reason: collision with root package name */
    private WeakReference<View> f18505q;

    /* renamed from: r  reason: collision with root package name */
    private WeakReference<FrameLayout> f18506r;

    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f18510a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f18511b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f18512c = 255;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f18513d = -1;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f18514e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f18515f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f18516g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f18517h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f18518i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public boolean f18519j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public int f18520k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public int f18521l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f18522m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public int f18523n;

        public SavedState(Context context) {
            this.f18511b = new d(context, R.style.TextAppearance_MaterialComponents_Badge).f28572a.getDefaultColor();
            this.f18515f = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.f18516g = R.plurals.mtrl_badge_content_description;
            this.f18517h = R.string.mtrl_exceed_max_badge_number_content_description;
            this.f18519j = true;
        }

        protected SavedState(Parcel parcel) {
            this.f18510a = parcel.readInt();
            this.f18511b = parcel.readInt();
            this.f18512c = parcel.readInt();
            this.f18513d = parcel.readInt();
            this.f18514e = parcel.readInt();
            this.f18515f = parcel.readString();
            this.f18516g = parcel.readInt();
            this.f18518i = parcel.readInt();
            this.f18520k = parcel.readInt();
            this.f18521l = parcel.readInt();
            this.f18522m = parcel.readInt();
            this.f18523n = parcel.readInt();
            this.f18519j = parcel.readInt() != 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f18510a);
            parcel.writeInt(this.f18511b);
            parcel.writeInt(this.f18512c);
            parcel.writeInt(this.f18513d);
            parcel.writeInt(this.f18514e);
            parcel.writeString(this.f18515f.toString());
            parcel.writeInt(this.f18516g);
            parcel.writeInt(this.f18518i);
            parcel.writeInt(this.f18520k);
            parcel.writeInt(this.f18521l);
            parcel.writeInt(this.f18522m);
            parcel.writeInt(this.f18523n);
            parcel.writeInt(this.f18519j ? 1 : 0);
        }
    }

    private BadgeDrawable(Context context) {
        this.f18491c = new WeakReference<>(context);
        l.b(context);
        Resources resources = context.getResources();
        this.f18495g = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.f18497i = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.f18496h = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        i iVar = new i(this);
        this.f18493e = iVar;
        iVar.a().setTextAlign(Paint.Align.CENTER);
        this.f18498j = new SavedState(context);
        j(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private static int a(Context context, TypedArray typedArray, int i2) {
        return c.a(context, typedArray, i2).getDefaultColor();
    }

    public static BadgeDrawable a(Context context) {
        return a(context, (AttributeSet) null, f18490b, f18489a);
    }

    private static BadgeDrawable a(Context context, AttributeSet attributeSet, int i2, int i3) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.b(context, attributeSet, i2, i3);
        return badgeDrawable;
    }

    static BadgeDrawable a(Context context, SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.a(savedState);
        return badgeDrawable;
    }

    private void a(Context context, Rect rect, View view) {
        float f2;
        int g2 = this.f18498j.f18521l + this.f18498j.f18523n;
        int e2 = this.f18498j.f18518i;
        this.f18500l = (float) ((e2 == 8388691 || e2 == 8388693) ? rect.bottom - g2 : rect.top + g2);
        if (d() <= 9) {
            f2 = !c() ? this.f18495g : this.f18496h;
            this.f18502n = f2;
            this.f18504p = f2;
        } else {
            float f3 = this.f18496h;
            this.f18502n = f3;
            this.f18504p = f3;
            f2 = (this.f18493e.a(j()) / 2.0f) + this.f18497i;
        }
        this.f18503o = f2;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(c() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int f4 = this.f18498j.f18520k + this.f18498j.f18522m;
        int e3 = this.f18498j.f18518i;
        this.f18499k = (e3 == 8388659 || e3 == 8388691 ? ac.i(view) != 0 : ac.i(view) == 0) ? ((((float) rect.right) + this.f18503o) - ((float) dimensionPixelSize)) - ((float) f4) : (((float) rect.left) - this.f18503o) + ((float) dimensionPixelSize) + ((float) f4);
    }

    private void a(Canvas canvas) {
        Rect rect = new Rect();
        String j2 = j();
        this.f18493e.a().getTextBounds(j2, 0, j2.length(), rect);
        canvas.drawText(j2, this.f18499k, this.f18500l + ((float) (rect.height() / 2)), this.f18493e.a());
    }

    private void a(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f18506r;
            if (weakReference == null || weakReference.get() != viewGroup) {
                b(view);
                final FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.f18506r = new WeakReference<>(frameLayout);
                frameLayout.post(new Runnable() {
                    public void run() {
                        BadgeDrawable.this.a(view, frameLayout);
                    }
                });
            }
        }
    }

    private void a(SavedState savedState) {
        d(savedState.f18514e);
        if (savedState.f18513d != -1) {
            c(savedState.f18513d);
        }
        a(savedState.f18510a);
        b(savedState.f18511b);
        e(savedState.f18518i);
        f(savedState.f18520k);
        h(savedState.f18521l);
        g(savedState.f18522m);
        i(savedState.f18523n);
        a(savedState.f18519j);
    }

    private void a(d dVar) {
        Context context;
        if (this.f18493e.b() != dVar && (context = (Context) this.f18491c.get()) != null) {
            this.f18493e.a(dVar, context);
            i();
        }
    }

    private void b(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray a2 = l.a(context, attributeSet, R.styleable.Badge, i2, i3, new int[0]);
        d(a2.getInt(R.styleable.Badge_maxCharacterCount, 4));
        if (a2.hasValue(R.styleable.Badge_number)) {
            c(a2.getInt(R.styleable.Badge_number, 0));
        }
        a(a(context, a2, R.styleable.Badge_backgroundColor));
        if (a2.hasValue(R.styleable.Badge_badgeTextColor)) {
            b(a(context, a2, R.styleable.Badge_badgeTextColor));
        }
        e(a2.getInt(R.styleable.Badge_badgeGravity, 8388661));
        f(a2.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        h(a2.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        a2.recycle();
    }

    private static void b(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void i() {
        Context context = (Context) this.f18491c.get();
        WeakReference<View> weakReference = this.f18505q;
        ViewGroup viewGroup = null;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f18494f);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.f18506r;
            if (weakReference2 != null) {
                viewGroup = (FrameLayout) weakReference2.get();
            }
            if (viewGroup != null || a.f18524a) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            a(context, rect2, view);
            a.a(this.f18494f, this.f18499k, this.f18500l, this.f18503o, this.f18504p);
            this.f18492d.o(this.f18502n);
            if (!rect.equals(this.f18494f)) {
                this.f18492d.setBounds(this.f18494f);
            }
        }
    }

    private String j() {
        if (d() <= this.f18501m) {
            return NumberFormat.getInstance().format((long) d());
        }
        Context context = (Context) this.f18491c.get();
        if (context == null) {
            return "";
        }
        return context.getString(R.string.mtrl_exceed_max_badge_number_suffix, new Object[]{Integer.valueOf(this.f18501m), "+"});
    }

    private void j(int i2) {
        Context context = (Context) this.f18491c.get();
        if (context != null) {
            a(new d(context, i2));
        }
    }

    private void k() {
        double e2 = (double) e();
        Double.isNaN(e2);
        this.f18501m = ((int) Math.pow(10.0d, e2 - 1.0d)) - 1;
    }

    public SavedState a() {
        return this.f18498j;
    }

    public void a(int i2) {
        int unused = this.f18498j.f18510a = i2;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (this.f18492d.N() != valueOf) {
            this.f18492d.g(valueOf);
            invalidateSelf();
        }
    }

    public void a(View view, FrameLayout frameLayout) {
        this.f18505q = new WeakReference<>(view);
        if (!a.f18524a || frameLayout != null) {
            this.f18506r = new WeakReference<>(frameLayout);
        } else {
            a(view);
        }
        if (!a.f18524a) {
            b(view);
        }
        i();
        invalidateSelf();
    }

    public void a(boolean z2) {
        setVisible(z2, false);
        boolean unused = this.f18498j.f18519j = z2;
        if (a.f18524a && b() != null && !z2) {
            ((ViewGroup) b().getParent()).invalidate();
        }
    }

    public FrameLayout b() {
        WeakReference<FrameLayout> weakReference = this.f18506r;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public void b(int i2) {
        int unused = this.f18498j.f18511b = i2;
        if (this.f18493e.a().getColor() != i2) {
            this.f18493e.a().setColor(i2);
            invalidateSelf();
        }
    }

    public void c(int i2) {
        int max = Math.max(0, i2);
        if (this.f18498j.f18513d != max) {
            int unused = this.f18498j.f18513d = max;
            this.f18493e.a(true);
            i();
            invalidateSelf();
        }
    }

    public boolean c() {
        return this.f18498j.f18513d != -1;
    }

    public int d() {
        if (!c()) {
            return 0;
        }
        return this.f18498j.f18513d;
    }

    public void d(int i2) {
        if (this.f18498j.f18514e != i2) {
            int unused = this.f18498j.f18514e = i2;
            k();
            this.f18493e.a(true);
            i();
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f18492d.draw(canvas);
            if (c()) {
                a(canvas);
            }
        }
    }

    public int e() {
        return this.f18498j.f18514e;
    }

    public void e(int i2) {
        if (this.f18498j.f18518i != i2) {
            int unused = this.f18498j.f18518i = i2;
            WeakReference<View> weakReference = this.f18505q;
            if (weakReference != null && weakReference.get() != null) {
                View view = (View) this.f18505q.get();
                WeakReference<FrameLayout> weakReference2 = this.f18506r;
                a(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
            }
        }
    }

    public void f() {
        invalidateSelf();
    }

    public void f(int i2) {
        int unused = this.f18498j.f18520k = i2;
        i();
    }

    public CharSequence g() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!c()) {
            return this.f18498j.f18515f;
        }
        if (this.f18498j.f18516g <= 0 || (context = (Context) this.f18491c.get()) == null) {
            return null;
        }
        if (d() <= this.f18501m) {
            return context.getResources().getQuantityString(this.f18498j.f18516g, d(), new Object[]{Integer.valueOf(d())});
        }
        return context.getString(this.f18498j.f18517h, new Object[]{Integer.valueOf(this.f18501m)});
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        int unused = this.f18498j.f18522m = i2;
        i();
    }

    public int getAlpha() {
        return this.f18498j.f18512c;
    }

    public int getIntrinsicHeight() {
        return this.f18494f.height();
    }

    public int getIntrinsicWidth() {
        return this.f18494f.width();
    }

    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.f18498j.f18520k;
    }

    public void h(int i2) {
        int unused = this.f18498j.f18521l = i2;
        i();
    }

    /* access modifiers changed from: package-private */
    public void i(int i2) {
        int unused = this.f18498j.f18523n = i2;
        i();
    }

    public boolean isStateful() {
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void setAlpha(int i2) {
        int unused = this.f18498j.f18512c = i2;
        this.f18493e.a().setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
