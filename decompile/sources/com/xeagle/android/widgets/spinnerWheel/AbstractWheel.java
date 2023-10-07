package com.xeagle.android.widgets.spinnerWheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.xeagle.R;
import com.xeagle.android.widgets.spinnerWheel.g;
import java.util.LinkedList;
import java.util.List;
import ll.d;

public abstract class AbstractWheel extends View {

    /* renamed from: m  reason: collision with root package name */
    private static int f26020m = -1;

    /* renamed from: a  reason: collision with root package name */
    protected int f26021a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected int f26022b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f26023c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f26024d;

    /* renamed from: e  reason: collision with root package name */
    protected g f26025e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f26026f;

    /* renamed from: g  reason: collision with root package name */
    protected int f26027g;

    /* renamed from: h  reason: collision with root package name */
    protected LinearLayout f26028h;

    /* renamed from: i  reason: collision with root package name */
    protected int f26029i;

    /* renamed from: j  reason: collision with root package name */
    protected d f26030j;

    /* renamed from: k  reason: collision with root package name */
    protected int f26031k;

    /* renamed from: l  reason: collision with root package name */
    protected int f26032l;

    /* renamed from: n  reason: collision with root package name */
    private final String f26033n;

    /* renamed from: o  reason: collision with root package name */
    private f f26034o = new f(this);

    /* renamed from: p  reason: collision with root package name */
    private List<b> f26035p = new LinkedList();

    /* renamed from: q  reason: collision with root package name */
    private List<d> f26036q = new LinkedList();

    /* renamed from: r  reason: collision with root package name */
    private List<c> f26037r = new LinkedList();

    /* renamed from: s  reason: collision with root package name */
    private DataSetObserver f26038s;

    static class SavedState extends View.BaseSavedState {
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

        /* renamed from: a  reason: collision with root package name */
        int f26042a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f26042a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f26042a);
        }
    }

    public AbstractWheel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractWheel.class.getName());
        sb.append(" #");
        int i3 = f26020m + 1;
        f26020m = i3;
        sb.append(i3);
        this.f26033n = sb.toString();
        a(attributeSet, i2);
        a(context);
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        this.f26027g += i2;
        int itemDimension = getItemDimension();
        int i3 = this.f26027g / itemDimension;
        int i4 = this.f26021a - i3;
        int a2 = this.f26030j.a();
        int i5 = this.f26027g % itemDimension;
        if (Math.abs(i5) <= itemDimension / 2) {
            i5 = 0;
        }
        if (this.f26024d && a2 > 0) {
            if (i5 > 0) {
                i4--;
                i3++;
            } else if (i5 < 0) {
                i4++;
                i3--;
            }
            while (i4 < 0) {
                i4 += a2;
            }
            i4 %= a2;
        } else if (i4 < 0) {
            i3 = this.f26021a;
            i4 = 0;
        } else if (i4 >= a2) {
            i3 = (this.f26021a - a2) + 1;
            i4 = a2 - 1;
        } else if (i4 > 0 && i5 > 0) {
            i4--;
            i3++;
        } else if (i4 < a2 - 1 && i5 < 0) {
            i4++;
            i3--;
        }
        int i6 = this.f26027g;
        if (i4 != this.f26021a) {
            a(i4, false);
        } else {
            invalidate();
        }
        int baseDimension = getBaseDimension();
        int i7 = i6 - (i3 * itemDimension);
        this.f26027g = i7;
        if (i7 > baseDimension) {
            this.f26027g = (i7 % baseDimension) + baseDimension;
        }
    }

    private View c(int i2) {
        d dVar = this.f26030j;
        if (dVar == null || dVar.a() == 0) {
            return null;
        }
        int a2 = this.f26030j.a();
        if (!a(i2)) {
            return this.f26030j.a(this.f26034o.b(), this.f26028h);
        }
        while (i2 < 0) {
            i2 += a2;
        }
        return this.f26030j.a(i2 % a2, this.f26034o.a(), this.f26028h);
    }

    private boolean c(int i2, boolean z2) {
        View c2 = c(i2);
        if (c2 == null) {
            return false;
        }
        if (z2) {
            this.f26028h.addView(c2, 0);
            return true;
        }
        this.f26028h.addView(c2);
        return true;
    }

    private a getItemsRange() {
        if (this.f26023c) {
            int baseDimension = getBaseDimension();
            int itemDimension = getItemDimension();
            if (itemDimension != 0) {
                this.f26022b = (baseDimension / itemDimension) + 1;
            }
        }
        int i2 = this.f26021a;
        int i3 = this.f26022b;
        int i4 = i2 - (i3 / 2);
        int i5 = 0;
        int i6 = (i4 + i3) - (i3 % 2 == 0 ? 0 : 1);
        int i7 = this.f26027g;
        if (i7 != 0) {
            if (i7 > 0) {
                i4--;
            } else {
                i6++;
            }
        }
        if (!g()) {
            if (i4 < 0) {
                i4 = 0;
            }
            d dVar = this.f26030j;
            if (dVar != null) {
                if (i6 > dVar.a()) {
                    i5 = this.f26030j.a();
                }
            }
            return new a(i4, (i5 - i4) + 1);
        }
        i5 = i6;
        return new a(i4, (i5 - i4) + 1);
    }

    /* access modifiers changed from: protected */
    public abstract float a(MotionEvent motionEvent);

    /* access modifiers changed from: protected */
    public abstract g a(g.a aVar);

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i2, int i3);

    public void a(int i2, boolean z2) {
        int min;
        d dVar = this.f26030j;
        if (dVar != null && dVar.a() != 0) {
            int a2 = this.f26030j.a();
            if (i2 < 0 || i2 >= a2) {
                if (this.f26024d) {
                    while (i2 < 0) {
                        i2 += a2;
                    }
                    i2 %= a2;
                } else {
                    return;
                }
            }
            int i3 = this.f26021a;
            if (i2 == i3) {
                return;
            }
            if (z2) {
                int i4 = i2 - i3;
                if (this.f26024d && (min = (a2 + Math.min(i2, i3)) - Math.max(i2, this.f26021a)) < Math.abs(i4)) {
                    i4 = i4 < 0 ? min : -min;
                }
                b(i4, 0);
                return;
            }
            this.f26027g = 0;
            this.f26021a = i2;
            c(i3, i2);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        this.f26038s = new DataSetObserver() {
            public void onChanged() {
                AbstractWheel.this.a(false);
            }

            public void onInvalidated() {
                AbstractWheel.this.a(true);
            }
        };
        this.f26025e = a((g.a) new g.a() {
            public void a() {
                AbstractWheel.this.f26026f = true;
                AbstractWheel.this.h();
                AbstractWheel.this.a();
            }

            public void a(int i2) {
                AbstractWheel.this.b(i2);
                int baseDimension = AbstractWheel.this.getBaseDimension();
                if (AbstractWheel.this.f26027g > baseDimension || AbstractWheel.this.f26027g < (baseDimension = -baseDimension)) {
                    AbstractWheel.this.f26027g = baseDimension;
                    AbstractWheel.this.f26025e.c();
                }
            }

            public void b() {
                AbstractWheel.this.b();
            }

            public void c() {
                if (!AbstractWheel.this.f26026f) {
                    AbstractWheel.this.c();
                }
            }

            public void d() {
                if (AbstractWheel.this.f26026f) {
                    AbstractWheel.this.i();
                    AbstractWheel.this.f26026f = false;
                    AbstractWheel.this.d();
                }
                AbstractWheel.this.f26027g = 0;
                AbstractWheel.this.invalidate();
            }

            public void e() {
                if (Math.abs(AbstractWheel.this.f26027g) > 1) {
                    AbstractWheel.this.f26025e.b(AbstractWheel.this.f26027g, 0);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AbstractWheelView, i2, 0);
        this.f26022b = obtainStyledAttributes.getInt(8, 4);
        this.f26023c = obtainStyledAttributes.getBoolean(0, false);
        this.f26024d = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    public void a(b bVar) {
        this.f26035p.add(bVar);
    }

    public void a(c cVar) {
        this.f26037r.add(cVar);
    }

    public void a(d dVar) {
        this.f26036q.add(dVar);
    }

    public void a(boolean z2) {
        if (z2) {
            this.f26034o.c();
            LinearLayout linearLayout = this.f26028h;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.f26027g = 0;
        } else {
            LinearLayout linearLayout2 = this.f26028h;
            if (linearLayout2 != null) {
                this.f26034o.a(linearLayout2, this.f26029i, new a());
            }
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2) {
        d dVar = this.f26030j;
        return dVar != null && dVar.a() > 0 && (this.f26024d || (i2 >= 0 && i2 < this.f26030j.a()));
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public void b(int i2, int i3) {
        int itemDimension = (i2 * getItemDimension()) - this.f26027g;
        b();
        this.f26025e.b(itemDimension, i3);
    }

    /* access modifiers changed from: protected */
    public void b(int i2, boolean z2) {
        for (c a2 : this.f26037r) {
            a2.a(this, i2, z2);
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public void c(int i2, int i3) {
        for (b a2 : this.f26035p) {
            a2.a(this, i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    /* access modifiers changed from: protected */
    public abstract void e();

    /* access modifiers changed from: protected */
    public abstract void f();

    public boolean g() {
        return this.f26024d;
    }

    /* access modifiers changed from: protected */
    public abstract int getBaseDimension();

    public int getCurrentItem() {
        return this.f26021a;
    }

    /* access modifiers changed from: protected */
    public abstract int getItemDimension();

    public d getViewAdapter() {
        return this.f26030j;
    }

    public int getVisibleItems() {
        return this.f26022b;
    }

    /* access modifiers changed from: protected */
    public void h() {
        for (d a2 : this.f26036q) {
            a2.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        for (d b2 : this.f26036q) {
            b2.b(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean j() {
        boolean z2;
        a itemsRange = getItemsRange();
        LinearLayout linearLayout = this.f26028h;
        if (linearLayout != null) {
            int a2 = this.f26034o.a(linearLayout, this.f26029i, itemsRange);
            z2 = this.f26029i != a2;
            this.f26029i = a2;
        } else {
            e();
            z2 = true;
        }
        if (!z2) {
            z2 = (this.f26029i == itemsRange.a() && this.f26028h.getChildCount() == itemsRange.c()) ? false : true;
        }
        if (this.f26029i <= itemsRange.a() || this.f26029i > itemsRange.b()) {
            this.f26029i = itemsRange.a();
        } else {
            int i2 = this.f26029i - 1;
            while (i2 >= itemsRange.a() && c(i2, true)) {
                this.f26029i = i2;
                i2--;
            }
        }
        int i3 = this.f26029i;
        for (int childCount = this.f26028h.getChildCount(); childCount < itemsRange.c(); childCount++) {
            if (!c(this.f26029i + childCount, false) && this.f26028h.getChildCount() == 0) {
                i3++;
            }
        }
        this.f26029i = i3;
        return z2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (z2) {
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            f();
            if (!(this.f26032l == i6 && this.f26031k == i7)) {
                a(getMeasuredWidth(), getMeasuredHeight());
            }
            this.f26032l = i6;
            this.f26031k = i7;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f26021a = savedState.f26042a;
        postDelayed(new Runnable() {
            public void run() {
                AbstractWheel.this.a(false);
            }
        }, 100);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f26042a = getCurrentItem();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2 = true;
        if (!isEnabled() || getViewAdapter() == null) {
            return true;
        }
        if (motionEvent.getAction() == 1 && !this.f26026f) {
            int a2 = ((int) a(motionEvent)) - (getBaseDimension() / 2);
            int itemDimension = getItemDimension() / 2;
            int itemDimension2 = (a2 > 0 ? a2 + itemDimension : a2 - itemDimension) / getItemDimension();
            if (a(this.f26021a + itemDimension2)) {
                int i2 = this.f26021a + itemDimension2;
                if (itemDimension2 != 0) {
                    z2 = false;
                }
                b(i2, z2);
            }
        }
        return this.f26025e.a(getParent(), motionEvent);
    }

    public void setAllItemsVisible(boolean z2) {
        this.f26023c = z2;
        a(false);
    }

    public void setCurrentItem(int i2) {
        a(i2, false);
    }

    public void setCyclic(boolean z2) {
        this.f26024d = z2;
        a(false);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f26025e.a(interpolator);
    }

    public void setViewAdapter(d dVar) {
        d dVar2 = this.f26030j;
        if (dVar2 != null) {
            dVar2.b(this.f26038s);
        }
        this.f26030j = dVar;
        if (dVar != null) {
            dVar.a(this.f26038s);
        }
        a(true);
    }

    public void setVisibleItems(int i2) {
        this.f26022b = i2;
    }
}
