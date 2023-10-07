package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.a;
import t.ac;

class k extends i {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f1505a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f1506b;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f1507c = null;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f1508d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1509e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1510f = false;

    k(SeekBar seekBar) {
        super(seekBar);
        this.f1505a = seekBar;
    }

    private void d() {
        Drawable drawable = this.f1506b;
        if (drawable == null) {
            return;
        }
        if (this.f1509e || this.f1510f) {
            Drawable g2 = a.g(drawable.mutate());
            this.f1506b = g2;
            if (this.f1509e) {
                a.a(g2, this.f1507c);
            }
            if (this.f1510f) {
                a.a(this.f1506b, this.f1508d);
            }
            if (this.f1506b.isStateful()) {
                this.f1506b.setState(this.f1505a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.f1506b != null) {
            int max = this.f1505a.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1506b.getIntrinsicWidth();
                int intrinsicHeight = this.f1506b.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f1506b.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f1505a.getWidth() - this.f1505a.getPaddingLeft()) - this.f1505a.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1505a.getPaddingLeft(), (float) (this.f1505a.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f1506b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        Drawable drawable2 = this.f1506b;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1506b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1505a);
            a.b(drawable, ac.i(this.f1505a));
            if (drawable.isStateful()) {
                drawable.setState(this.f1505a.getDrawableState());
            }
            d();
        }
        this.f1505a.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        af a2 = af.a(this.f1505a.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i2, 0);
        SeekBar seekBar = this.f1505a;
        ac.a(seekBar, seekBar.getContext(), R.styleable.AppCompatSeekBar, attributeSet, a2.a(), i2, 0);
        Drawable b2 = a2.b(R.styleable.AppCompatSeekBar_android_thumb);
        if (b2 != null) {
            this.f1505a.setThumb(b2);
        }
        a(a2.a(R.styleable.AppCompatSeekBar_tickMark));
        if (a2.g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1508d = q.a(a2.a(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f1508d);
            this.f1510f = true;
        }
        if (a2.g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f1507c = a2.e(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f1509e = true;
        }
        a2.b();
        d();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f1506b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f1506b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1505a.getDrawableState())) {
            this.f1505a.invalidateDrawable(drawable);
        }
    }
}
