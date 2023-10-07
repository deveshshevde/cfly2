package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.blankj.utilcode.constant.MemoryConstants;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.b;
import in.srain.cube.views.ptr.d;
import lq.a;

public class MaterialHeader extends View implements b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f13681a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f13682b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private PtrFrameLayout f13683c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Animation f13684d = new Animation() {
        public void applyTransformation(float f2, Transformation transformation) {
            float unused = MaterialHeader.this.f13682b = 1.0f - f2;
            MaterialHeader.this.f13681a.setAlpha((int) (MaterialHeader.this.f13682b * 255.0f));
            MaterialHeader.this.invalidate();
        }
    };

    public MaterialHeader(Context context) {
        super(context);
        a();
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MaterialHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        a aVar = new a(getContext(), this);
        this.f13681a = aVar;
        aVar.b(-1);
        this.f13681a.setCallback(this);
    }

    public void a(PtrFrameLayout ptrFrameLayout) {
        this.f13682b = 1.0f;
        this.f13681a.stop();
    }

    public void a(PtrFrameLayout ptrFrameLayout, boolean z2, byte b2, a aVar) {
        float min = Math.min(1.0f, aVar.w());
        if (b2 == 2) {
            this.f13681a.setAlpha((int) (255.0f * min));
            this.f13681a.a(true);
            this.f13681a.a(0.0f, Math.min(0.8f, min * 0.8f));
            this.f13681a.a(Math.min(1.0f, min));
            this.f13681a.b((((0.4f * min) - 16.0f) + (min * 2.0f)) * 0.5f);
            invalidate();
        }
    }

    public void b(PtrFrameLayout ptrFrameLayout) {
    }

    public void c(PtrFrameLayout ptrFrameLayout) {
        this.f13681a.setAlpha(255);
        this.f13681a.start();
    }

    public void d(PtrFrameLayout ptrFrameLayout) {
        this.f13681a.stop();
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.f13681a) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = this.f13681a.getBounds();
        canvas.translate((float) (getPaddingLeft() + ((getMeasuredWidth() - this.f13681a.getIntrinsicWidth()) / 2)), (float) getPaddingTop());
        float f2 = this.f13682b;
        canvas.scale(f2, f2, bounds.exactCenterX(), bounds.exactCenterY());
        this.f13681a.draw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int intrinsicHeight = this.f13681a.getIntrinsicHeight();
        this.f13681a.setBounds(0, 0, intrinsicHeight, intrinsicHeight);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.f13681a.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom(), MemoryConstants.GB));
    }

    public void setColorSchemeColors(int[] iArr) {
        this.f13681a.a(iArr);
        invalidate();
    }

    public void setPtrFrameLayout(PtrFrameLayout ptrFrameLayout) {
        final AnonymousClass2 r0 = new d() {
            public void run() {
                MaterialHeader materialHeader = MaterialHeader.this;
                materialHeader.startAnimation(materialHeader.f13684d);
            }
        };
        this.f13684d.setDuration(200);
        this.f13684d.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                r0.b();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.f13683c = ptrFrameLayout;
        ptrFrameLayout.setRefreshCompleteHook(r0);
    }
}
