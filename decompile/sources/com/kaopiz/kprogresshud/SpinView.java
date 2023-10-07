package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

class SpinView extends ImageView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public float f20994a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f20995b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f20996c;

    /* renamed from: d  reason: collision with root package name */
    private Runnable f20997d;

    public SpinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        setImageResource(R.drawable.kprogresshud_spinner);
        this.f20995b = 83;
        this.f20997d = new Runnable() {
            public void run() {
                SpinView spinView = SpinView.this;
                float unused = spinView.f20994a = spinView.f20994a + 30.0f;
                SpinView spinView2 = SpinView.this;
                float unused2 = spinView2.f20994a = spinView2.f20994a < 360.0f ? SpinView.this.f20994a : SpinView.this.f20994a - 360.0f;
                SpinView.this.invalidate();
                if (SpinView.this.f20996c) {
                    SpinView spinView3 = SpinView.this;
                    spinView3.postDelayed(this, (long) spinView3.f20995b);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f20996c = true;
        post(this.f20997d);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f20996c = false;
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.rotate(this.f20994a, (float) (getWidth() / 2), (float) (getHeight() / 2));
        super.onDraw(canvas);
    }
}
