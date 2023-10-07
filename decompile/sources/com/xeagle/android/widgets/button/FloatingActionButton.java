package com.xeagle.android.widgets.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;
import com.cfly.uav_pro.R;

public class FloatingActionButton extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private int f25728a;

    /* renamed from: b  reason: collision with root package name */
    int f25729b;

    /* renamed from: c  reason: collision with root package name */
    int f25730c;

    /* renamed from: d  reason: collision with root package name */
    int f25731d;

    /* renamed from: e  reason: collision with root package name */
    String f25732e;

    /* renamed from: f  reason: collision with root package name */
    boolean f25733f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f25734g;

    /* renamed from: h  reason: collision with root package name */
    private int f25735h;

    /* renamed from: i  reason: collision with root package name */
    private float f25736i;

    /* renamed from: j  reason: collision with root package name */
    private float f25737j;

    /* renamed from: k  reason: collision with root package name */
    private float f25738k;

    /* renamed from: l  reason: collision with root package name */
    private int f25739l;

    private static class a extends LayerDrawable {

        /* renamed from: a  reason: collision with root package name */
        private final int f25746a;

        public a(int i2, Drawable... drawableArr) {
            super(drawableArr);
            this.f25746a = i2;
        }

        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.saveLayerAlpha((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f25746a, 31);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private Drawable a(int i2, float f2) {
        int alpha = Color.alpha(i2);
        int f3 = f(i2);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(f3);
        Drawable[] drawableArr = {shapeDrawable, c(f3, f2)};
        LayerDrawable layerDrawable = (alpha == 255 || !this.f25733f) ? new LayerDrawable(drawableArr) : new a(alpha, drawableArr);
        int i3 = (int) (f2 / 2.0f);
        layerDrawable.setLayerInset(1, i3, i3, i3, i3);
        return layerDrawable;
    }

    private StateListDrawable a(float f2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, a(this.f25731d, f2));
        stateListDrawable.addState(new int[]{16842919}, a(this.f25730c, f2));
        stateListDrawable.addState(new int[0], a(this.f25729b, f2));
        return stateListDrawable;
    }

    private int b(int i2, float f2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        fArr[2] = Math.min(fArr[2] * f2, 1.0f);
        return Color.HSVToColor(Color.alpha(i2), fArr);
    }

    private Drawable b(float f2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-16777216);
        paint.setAlpha(c(0.02f));
        return shapeDrawable;
    }

    private void b() {
        this.f25739l = (int) (this.f25736i + (this.f25737j * 2.0f));
    }

    private int c(float f2) {
        return (int) (f2 * 255.0f);
    }

    private int c(int i2) {
        return b(i2, 0.9f);
    }

    private Drawable c(int i2, float f2) {
        if (!this.f25733f) {
            return new ColorDrawable(0);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        final int c2 = c(i2);
        final int e2 = e(c2);
        final int d2 = d(i2);
        final int e3 = e(d2);
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        final int i3 = i2;
        shapeDrawable.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            public Shader resize(int i2, int i3) {
                float f2 = (float) (i2 / 2);
                return new LinearGradient(f2, 0.0f, f2, (float) i3, new int[]{d2, e3, i3, e2, c2}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
            }
        });
        return shapeDrawable;
    }

    private void c() {
        this.f25736i = b(this.f25735h == 0 ? R.dimen.fab_size_normal : R.dimen.fab_size_mini);
    }

    private int d(int i2) {
        return b(i2, 1.1f);
    }

    private int e(int i2) {
        return Color.argb(Color.alpha(i2) / 2, Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    private int f(int i2) {
        return Color.rgb(Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    private void setBackgroundCompat(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i2) {
        return getResources().getColor(i2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        float b2 = b((int) R.dimen.fab_stroke_width);
        float f2 = b2 / 2.0f;
        Resources resources = getResources();
        int i2 = this.f25735h;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{resources.getDrawable(R.drawable.radius), a(b2), b(b2), getIconDrawable()});
        int b3 = ((int) (this.f25736i - b((int) R.dimen.fab_icon_size))) / 2;
        float f3 = this.f25737j;
        int i3 = (int) f3;
        float f4 = this.f25738k;
        int i4 = (int) (f3 - f4);
        int i5 = (int) (f3 + f4);
        layerDrawable.setLayerInset(1, i3, i4, i3, i5);
        int i6 = (int) (((float) i3) - f2);
        LayerDrawable layerDrawable2 = layerDrawable;
        layerDrawable2.setLayerInset(2, i6, (int) (((float) i4) - f2), i6, (int) (((float) i5) - f2));
        int i7 = i3 + b3;
        layerDrawable2.setLayerInset(3, i7, i4 + b3, i7, i5 + b3);
        setBackgroundCompat(layerDrawable);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.xeagle.R.styleable.FloatingActionButton, 0, 0);
        this.f25729b = obtainStyledAttributes.getColor(9, a(17170445));
        this.f25730c = obtainStyledAttributes.getColor(10, a(17170445));
        this.f25731d = obtainStyledAttributes.getColor(8, a(17170445));
        this.f25735h = obtainStyledAttributes.getInt(12, 0);
        this.f25728a = obtainStyledAttributes.getResourceId(11, 0);
        this.f25732e = obtainStyledAttributes.getString(14);
        this.f25733f = obtainStyledAttributes.getBoolean(13, true);
        obtainStyledAttributes.recycle();
        c();
        this.f25737j = b((int) R.dimen.fab_shadow_radius);
        this.f25738k = b((int) R.dimen.fab_shadow_offset);
        b();
        a();
    }

    /* access modifiers changed from: package-private */
    public float b(int i2) {
        return getResources().getDimension(i2);
    }

    public int getColorDisabled() {
        return this.f25731d;
    }

    public int getColorNormal() {
        return this.f25729b;
    }

    public int getColorPressed() {
        return this.f25730c;
    }

    /* access modifiers changed from: package-private */
    public Drawable getIconDrawable() {
        Drawable drawable = this.f25734g;
        return drawable != null ? drawable : this.f25728a != 0 ? getResources().getDrawable(this.f25728a) : new ColorDrawable(0);
    }

    /* access modifiers changed from: package-private */
    public TextView getLabelView() {
        return (TextView) getTag(R.id.fab_label);
    }

    public int getSize() {
        return this.f25735h;
    }

    public String getTitle() {
        return this.f25732e;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = this.f25739l;
        setMeasuredDimension(i4, i4);
    }

    public void setColorDisabled(int i2) {
        if (this.f25731d != i2) {
            this.f25731d = i2;
            a();
        }
    }

    public void setColorDisabledResId(int i2) {
        setColorDisabled(a(i2));
    }

    public void setColorNormal(int i2) {
        if (this.f25729b != i2) {
            this.f25729b = i2;
            a();
        }
    }

    public void setColorNormalResId(int i2) {
        setColorNormal(a(i2));
    }

    public void setColorPressed(int i2) {
        if (this.f25730c != i2) {
            this.f25730c = i2;
            a();
        }
    }

    public void setColorPressedResId(int i2) {
        setColorPressed(a(i2));
    }

    public void setIcon(int i2) {
        if (this.f25728a != i2) {
            this.f25728a = i2;
            this.f25734g = null;
            a();
        }
    }

    public void setIconDrawable(Drawable drawable) {
        if (this.f25734g != drawable) {
            this.f25728a = 0;
            this.f25734g = drawable;
            a();
        }
    }

    public void setSize(int i2) {
        if (i2 != 1 && i2 != 0) {
            throw new IllegalArgumentException("Use @FAB_SIZE constants only!");
        } else if (this.f25735h != i2) {
            this.f25735h = i2;
            c();
            b();
            a();
        }
    }

    public void setStrokeVisible(boolean z2) {
        if (this.f25733f != z2) {
            this.f25733f = z2;
            a();
        }
    }

    public void setTitle(String str) {
        this.f25732e = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    public void setVisibility(int i2) {
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i2);
        }
        super.setVisibility(i2);
    }
}
