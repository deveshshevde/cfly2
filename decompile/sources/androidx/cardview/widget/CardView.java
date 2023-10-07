package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R;

public class CardView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f1626e = {16842801};

    /* renamed from: f  reason: collision with root package name */
    private static final e f1627f = (Build.VERSION.SDK_INT >= 21 ? new b() : Build.VERSION.SDK_INT >= 17 ? new a() : new c());

    /* renamed from: a  reason: collision with root package name */
    int f1628a;

    /* renamed from: b  reason: collision with root package name */
    int f1629b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f1630c;

    /* renamed from: d  reason: collision with root package name */
    final Rect f1631d;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1632g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1633h;

    /* renamed from: i  reason: collision with root package name */
    private final d f1634i;

    static {
        f1627f.a();
    }

    public CardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources;
        int i3;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1630c = rect;
        this.f1631d = new Rect();
        AnonymousClass1 r3 = new d() {

            /* renamed from: b  reason: collision with root package name */
            private Drawable f1636b;

            public void a(int i2, int i3) {
                if (i2 > CardView.this.f1628a) {
                    CardView.super.setMinimumWidth(i2);
                }
                if (i3 > CardView.this.f1629b) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            public void a(int i2, int i3, int i4, int i5) {
                CardView.this.f1631d.set(i2, i3, i4, i5);
                CardView cardView = CardView.this;
                CardView.super.setPadding(i2 + cardView.f1630c.left, i3 + CardView.this.f1630c.top, i4 + CardView.this.f1630c.right, i5 + CardView.this.f1630c.bottom);
            }

            public void a(Drawable drawable) {
                this.f1636b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            public boolean a() {
                return CardView.this.getUseCompatPadding();
            }

            public boolean b() {
                return CardView.this.getPreventCornerOverlap();
            }

            public Drawable c() {
                return this.f1636b;
            }

            public View d() {
                return CardView.this;
            }
        };
        this.f1634i = r3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        if (obtainStyledAttributes.hasValue(R.styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1626e);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i3 = R.color.cardview_light_background;
            } else {
                resources = getResources();
                i3 = R.color.cardview_dark_background;
            }
            valueOf = ColorStateList.valueOf(resources.getColor(i3));
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f1632g = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
        this.f1633h = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1628a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
        this.f1629b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f1627f.a(r3, context, colorStateList, dimension, dimension2, f2);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f1630c.set(i2, i3, i4, i5);
        f1627f.f(this.f1634i);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1627f.i(this.f1634i);
    }

    public float getCardElevation() {
        return f1627f.e(this.f1634i);
    }

    public int getContentPaddingBottom() {
        return this.f1630c.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1630c.left;
    }

    public int getContentPaddingRight() {
        return this.f1630c.right;
    }

    public int getContentPaddingTop() {
        return this.f1630c.top;
    }

    public float getMaxCardElevation() {
        return f1627f.a(this.f1634i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1633h;
    }

    public float getRadius() {
        return f1627f.d(this.f1634i);
    }

    public boolean getUseCompatPadding() {
        return this.f1632g;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        e eVar = f1627f;
        if (!(eVar instanceof b)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) eVar.b(this.f1634i)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) eVar.c(this.f1634i)), View.MeasureSpec.getSize(i3)), mode2);
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f1627f.a(this.f1634i, ColorStateList.valueOf(i2));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1627f.a(this.f1634i, colorStateList);
    }

    public void setCardElevation(float f2) {
        f1627f.c(this.f1634i, f2);
    }

    public void setMaxCardElevation(float f2) {
        f1627f.b(this.f1634i, f2);
    }

    public void setMinimumHeight(int i2) {
        this.f1629b = i2;
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        this.f1628a = i2;
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z2) {
        if (z2 != this.f1633h) {
            this.f1633h = z2;
            f1627f.h(this.f1634i);
        }
    }

    public void setRadius(float f2) {
        f1627f.a(this.f1634i, f2);
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f1632g != z2) {
            this.f1632g = z2;
            f1627f.g(this.f1634i);
        }
    }
}
