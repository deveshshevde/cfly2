package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.b;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import ja.h;
import ja.i;
import ja.j;

public abstract class InternalClassics<T extends InternalClassics> extends InternalAbstract implements h {
    public static final int A = R.id.srl_classics_title;
    public static final int B = R.id.srl_classics_arrow;
    public static final int C = R.id.srl_classics_progress;
    protected TextView D;
    protected ImageView E;
    protected ImageView F;
    protected i G;
    protected b H;
    protected b I;
    protected boolean J;
    protected boolean K;
    protected int L;
    protected int M = 500;
    protected int N = 20;
    protected int O = 20;
    protected int P = 0;

    public InternalClassics(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12189y = b.f12099a;
    }

    public int a(j jVar, boolean z2) {
        ImageView imageView = this.F;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0);
        }
        imageView.setVisibility(8);
        return this.M;
    }

    public T a(float f2) {
        ImageView imageView = this.E;
        ImageView imageView2 = this.F;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int a2 = jc.b.a(f2);
        layoutParams2.width = a2;
        layoutParams.width = a2;
        int a3 = jc.b.a(f2);
        layoutParams2.height = a3;
        layoutParams.height = a3;
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        return b();
    }

    public void a(i iVar, int i2, int i3) {
        this.G = iVar;
        iVar.a((h) this, this.L);
    }

    public void a(j jVar, int i2, int i3) {
        b(jVar, i2, i3);
    }

    /* access modifiers changed from: protected */
    public T b() {
        return this;
    }

    public T b(int i2) {
        this.J = true;
        this.D.setTextColor(i2);
        b bVar = this.H;
        if (bVar != null) {
            bVar.a(i2);
            this.E.invalidateDrawable(this.H);
        }
        b bVar2 = this.I;
        if (bVar2 != null) {
            bVar2.a(i2);
            this.F.invalidateDrawable(this.I);
        }
        return b();
    }

    public void b(j jVar, int i2, int i3) {
        ImageView imageView = this.F;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Drawable drawable = this.F.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000);
            }
        }
    }

    public T c(int i2) {
        this.K = true;
        this.L = i2;
        i iVar = this.G;
        if (iVar != null) {
            iVar.a((h) this, i2);
        }
        return b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 14) {
            ImageView imageView = this.E;
            ImageView imageView2 = this.F;
            imageView.animate().cancel();
            imageView2.animate().cancel();
        }
        Drawable drawable = this.F.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.P == 0) {
            this.N = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.O = paddingBottom;
            if (this.N == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i4 = this.N;
                if (i4 == 0) {
                    i4 = jc.b.a(20.0f);
                }
                this.N = i4;
                int i5 = this.O;
                if (i5 == 0) {
                    i5 = jc.b.a(20.0f);
                }
                this.O = i5;
                setPadding(paddingLeft, this.N, paddingRight, i5);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            int size = View.MeasureSpec.getSize(i3);
            int i6 = this.P;
            if (size < i6) {
                int i7 = (size - i6) / 2;
                setPadding(getPaddingLeft(), i7, getPaddingRight(), i7);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.N, getPaddingRight(), this.O);
        }
        super.onMeasure(i2, i3);
        if (this.P == 0) {
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                int measuredHeight = getChildAt(i8).getMeasuredHeight();
                if (this.P < measuredHeight) {
                    this.P = measuredHeight;
                }
            }
        }
    }

    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.K) {
                c(iArr[0]);
                this.K = false;
            }
            if (!this.J) {
                if (iArr.length > 1) {
                    b(iArr[1]);
                } else {
                    int i2 = -1;
                    if (iArr[0] == -1) {
                        i2 = -10066330;
                    }
                    b(i2);
                }
                this.J = false;
            }
        }
    }
}
