package com.xeagle.android.widgets.marquee;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ViewFlipper;
import java.util.List;

public class FlipperMarqueeView extends ViewFlipper {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f25885a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f25886b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f25887c;

    public class ScrollTextView extends View {

        /* renamed from: b  reason: collision with root package name */
        private String f25894b;

        /* renamed from: c  reason: collision with root package name */
        private Paint f25895c;

        /* renamed from: d  reason: collision with root package name */
        private ValueAnimator f25896d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f25897e;

        /* renamed from: f  reason: collision with root package name */
        private Rect f25898f;

        public ScrollTextView(FlipperMarqueeView flipperMarqueeView, Context context) {
            this(flipperMarqueeView, context, (AttributeSet) null);
        }

        public ScrollTextView(FlipperMarqueeView flipperMarqueeView, Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public ScrollTextView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f25895c = new Paint();
            this.f25896d = new ValueAnimator();
            this.f25897e = 0;
            this.f25898f = new Rect();
            this.f25895c.setAntiAlias(true);
            this.f25895c.setDither(true);
            this.f25895c.setTextSize(TypedValue.applyDimension(2, 15.0f, getResources().getDisplayMetrics()));
            this.f25895c.setColor(-16777216);
            this.f25896d.setInterpolator(new LinearInterpolator());
            this.f25896d.setDuration(1000);
            this.f25896d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(FlipperMarqueeView.this) {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int unused = ScrollTextView.this.f25897e = -((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ScrollTextView.this.invalidate();
                }
            });
        }

        public void a() {
            this.f25897e = 0;
        }

        public void a(int i2) {
            this.f25896d.setIntValues(new int[]{0, i2});
            this.f25896d.start();
        }

        public int getTextWidth() {
            String str = this.f25894b;
            if (str == null) {
                return 0;
            }
            this.f25895c.getTextBounds(str, 0, str.length(), this.f25898f);
            return this.f25898f.width();
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            String str = this.f25894b;
            if (str != null) {
                this.f25895c.getTextBounds(str, 0, str.length(), this.f25898f);
                Paint.FontMetrics fontMetrics = this.f25895c.getFontMetrics();
                canvas.drawText(this.f25894b, (float) this.f25897e, ((((float) getHeight()) - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.f25895c);
            }
        }

        public void setText(String str) {
            this.f25894b = str;
        }
    }

    public FlipperMarqueeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlipperMarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25887c = new Runnable() {
            public void run() {
                if (FlipperMarqueeView.this.f25886b) {
                    FlipperMarqueeView.this.showNext();
                    FlipperMarqueeView flipperMarqueeView = FlipperMarqueeView.this;
                    flipperMarqueeView.postDelayed(flipperMarqueeView.f25887c, 5000);
                }
            }
        };
    }

    private void a() {
        removeAllViews();
        for (String text : this.f25885a) {
            ScrollTextView scrollTextView = new ScrollTextView(this, getContext());
            scrollTextView.setText(text);
            addView(scrollTextView);
        }
    }

    public void setContentList(List<String> list) {
        this.f25885a = list;
        if (list != null && list.size() > 0) {
            a();
        }
        getOutAnimation().setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                int childCount = FlipperMarqueeView.this.getChildCount();
                FlipperMarqueeView flipperMarqueeView = FlipperMarqueeView.this;
                ((ScrollTextView) FlipperMarqueeView.this.getChildAt(((flipperMarqueeView.indexOfChild(flipperMarqueeView.getCurrentView()) - 1) + childCount) % childCount)).a();
                final ScrollTextView scrollTextView = (ScrollTextView) FlipperMarqueeView.this.getCurrentView();
                final int textWidth = scrollTextView.getTextWidth() - scrollTextView.getWidth();
                if (textWidth > 0) {
                    FlipperMarqueeView.this.postDelayed(new Runnable() {
                        public void run() {
                            scrollTextView.a(textWidth);
                        }
                    }, 500);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
    }
}
