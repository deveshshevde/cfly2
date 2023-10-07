package com.xeagle.android.widgets.marquee;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import com.xeagle.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerMarqueeView extends AppCompatTextView {
    /* access modifiers changed from: private */
    public int A;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<a> f25852a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f25853b;

    /* renamed from: c  reason: collision with root package name */
    private int f25854c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f25855e;

    /* renamed from: f  reason: collision with root package name */
    private int f25856f;

    /* renamed from: g  reason: collision with root package name */
    private int f25857g;

    /* renamed from: h  reason: collision with root package name */
    private int f25858h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f25859i;

    /* renamed from: j  reason: collision with root package name */
    private int f25860j;

    /* renamed from: k  reason: collision with root package name */
    private int f25861k;

    /* renamed from: l  reason: collision with root package name */
    private int f25862l;

    /* renamed from: m  reason: collision with root package name */
    private int f25863m;

    /* renamed from: n  reason: collision with root package name */
    private int f25864n;

    /* renamed from: o  reason: collision with root package name */
    private String f25865o;

    /* renamed from: p  reason: collision with root package name */
    private String f25866p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f25867q;

    /* renamed from: r  reason: collision with root package name */
    private float f25868r;

    /* renamed from: s  reason: collision with root package name */
    private int f25869s;

    /* renamed from: t  reason: collision with root package name */
    private int f25870t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f25871u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f25872v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f25873w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f25874x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f25875y;

    /* renamed from: z  reason: collision with root package name */
    private int f25876z;

    public CustomerMarqueeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomerMarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomerMarqueeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25852a = new ArrayList<>();
        this.f25860j = -16777216;
        this.f25861k = 46;
        this.f25864n = 0;
        this.f25867q = 0.0f;
        this.f25868r = 0.0f;
        this.f25871u = false;
        this.f25872v = false;
        this.f25873w = false;
        this.f25874x = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomerMarqueeView);
        this.A = obtainStyledAttributes.getInt(2, GSYVideoView.CHANGE_DELAY_TIME);
        this.f25876z = obtainStyledAttributes.getInt(3, 1000);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f25861k = (int) obtainStyledAttributes.getDimension(3, 46.0f);
        }
        this.f25860j = obtainStyledAttributes.getColor(0, -16777216);
        obtainStyledAttributes.recycle();
        b();
    }

    private Rect a(String str) {
        Rect rect = new Rect();
        this.f25859i.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    private void a(int i2, int i3, int i4, TimeInterpolator timeInterpolator, AnimatorListenerAdapter animatorListenerAdapter) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) i2, (float) i3});
        ofFloat.setDuration((long) i4);
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CustomerMarqueeView customerMarqueeView = CustomerMarqueeView.this;
                float unused = customerMarqueeView.f25867q = (-floatValue) + ((float) customerMarqueeView.f25855e);
                CustomerMarqueeView.this.postInvalidate();
            }
        });
        ofFloat.addListener(animatorListenerAdapter);
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, TimeInterpolator timeInterpolator, AnimatorListenerAdapter animatorListenerAdapter) {
        a(i2, i3, this.f25876z, timeInterpolator, animatorListenerAdapter);
    }

    /* access modifiers changed from: private */
    public void a(int i2, Runnable runnable) {
        new Handler().postDelayed(runnable, (long) i2);
    }

    private void b() {
        Paint paint = new Paint();
        this.f25859i = paint;
        paint.setFlags(64);
        this.f25859i.setAntiAlias(true);
        this.f25859i.setDither(true);
        this.f25859i.setTextSize((float) this.f25861k);
        this.f25859i.setColor(this.f25860j);
    }

    private void c() {
        this.f25872v = true;
        a(0, (this.f25875y - 1) * this.f25853b, 3000, (TimeInterpolator) new LinearInterpolator(), (AnimatorListenerAdapter) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CustomerMarqueeView customerMarqueeView = CustomerMarqueeView.this;
                customerMarqueeView.a(customerMarqueeView.A, (Runnable) new Runnable() {
                    public void run() {
                        boolean unused = CustomerMarqueeView.this.f25871u = true;
                        CustomerMarqueeView.this.a((CustomerMarqueeView.this.f25875y - 1) * CustomerMarqueeView.this.f25853b, CustomerMarqueeView.this.f25875y * CustomerMarqueeView.this.f25853b, new AccelerateDecelerateInterpolator(), new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                CustomerMarqueeView.this.a(CustomerMarqueeView.this.A, (Runnable) new Runnable() {
                                    public void run() {
                                        boolean unused = CustomerMarqueeView.this.f25871u = false;
                                        boolean unused2 = CustomerMarqueeView.this.f25872v = false;
                                        CustomerMarqueeView.this.d();
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f25864n++;
        this.f25867q = (float) this.f25855e;
        postInvalidate();
    }

    public void a() {
        this.f25871u = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (float) this.f25853b});
        ofFloat.setDuration((long) this.f25876z);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CustomerMarqueeView customerMarqueeView = CustomerMarqueeView.this;
                float unused = customerMarqueeView.f25867q = (-floatValue) + ((float) customerMarqueeView.f25855e);
                CustomerMarqueeView.this.postInvalidate();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CustomerMarqueeView customerMarqueeView = CustomerMarqueeView.this;
                customerMarqueeView.a(customerMarqueeView.A, (Runnable) new Runnable() {
                    public void run() {
                        boolean unused = CustomerMarqueeView.this.f25871u = false;
                        CustomerMarqueeView.this.d();
                    }
                });
            }
        });
    }

    public int getCurrentIndex() {
        if (!this.f25871u) {
            return this.f25864n;
        }
        if (this.f25864n + 1 >= this.f25852a.size()) {
            return 0;
        }
        return this.f25864n + 1;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f25864n >= this.f25852a.size()) {
            this.f25864n = 0;
        }
        this.f25865o = this.f25852a.get(this.f25864n).b();
        ArrayList<a> arrayList = this.f25852a;
        this.f25866p = arrayList.get(this.f25864n + 1 >= arrayList.size() ? 0 : this.f25864n + 1).b();
        ArrayList<a> arrayList2 = this.f25852a;
        int a2 = arrayList2.get(this.f25864n + 1 >= arrayList2.size() ? 0 : this.f25864n + 1).a();
        this.f25860j = a2;
        this.f25859i.setColor(a2);
        this.f25869s = a(this.f25865o).width();
        this.f25870t = a(this.f25865o).height();
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            double d2 = (double) this.f25870t;
            Double.isNaN(d2);
            double d3 = (double) ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin;
            Double.isNaN(d3);
            double d4 = (d2 * 1.7d) + d3;
            double d5 = (double) this.f25856f;
            Double.isNaN(d5);
            this.f25868r = (float) (d4 + d5);
        }
        int i2 = (this.f25869s / this.f25853b) + 1;
        this.f25875y = i2;
        if (i2 > 1) {
            if (!this.f25872v && this.f25873w) {
                Log.i("picker", "onDraw: ----startScrollNow");
                c();
            }
        } else if (!this.f25871u && this.f25873w) {
            Log.i("picker", "onDraw: ----startScrollNext");
            a();
            if (this.f25852a.size() > 1) {
                this.f25852a.remove(0);
            }
        }
        canvas.drawText(this.f25865o, this.f25867q, this.f25868r, this.f25859i);
        canvas.drawText(this.f25866p, this.f25867q + ((float) (this.f25875y * this.f25853b)), this.f25868r, this.f25859i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f25853b = getMeasuredWidth();
        this.f25854c = getMeasuredHeight();
        this.f25855e = getPaddingLeft();
        this.f25856f = getPaddingTop();
        this.f25857g = getPaddingRight();
        this.f25858h = getPaddingBottom();
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        ArrayList<a> arrayList = this.f25852a;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i4 = 0; i4 < this.f25852a.size(); i4++) {
                a aVar = this.f25852a.get(i4);
                Rect rect = new Rect();
                this.f25859i.getTextBounds(aVar.b(), 0, aVar.b().length(), rect);
                this.f25859i.setColor(aVar.a());
                int width = rect.width();
                this.f25862l = Math.max(this.f25854c, rect.height());
                this.f25863m = Math.max(this.f25853b, width);
            }
        }
        if (mode == 1073741824 && mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else if (mode == 1073741824) {
            setMeasuredDimension(size, this.f25862l);
        } else {
            int i5 = this.f25863m;
            if (mode2 == 1073741824) {
                setMeasuredDimension(i5, size2);
            } else {
                setMeasuredDimension(i5, this.f25862l);
            }
        }
    }

    public void setContentColor(int i2) {
        this.f25860j = i2;
        this.f25859i.setColor(i2);
    }

    public void setContentList(List<a> list) {
        if (this.f25852a.size() > 1) {
            this.f25852a.remove(0);
        }
        this.f25852a.addAll(list);
    }
}
