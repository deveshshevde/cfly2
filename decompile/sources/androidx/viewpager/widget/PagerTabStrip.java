package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.b;

public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: g  reason: collision with root package name */
    private int f4908g;

    /* renamed from: h  reason: collision with root package name */
    private int f4909h;

    /* renamed from: i  reason: collision with root package name */
    private int f4910i;

    /* renamed from: j  reason: collision with root package name */
    private int f4911j;

    /* renamed from: k  reason: collision with root package name */
    private int f4912k;

    /* renamed from: l  reason: collision with root package name */
    private int f4913l;

    /* renamed from: m  reason: collision with root package name */
    private final Paint f4914m;

    /* renamed from: n  reason: collision with root package name */
    private final Rect f4915n;

    /* renamed from: o  reason: collision with root package name */
    private int f4916o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f4917p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4918q;

    /* renamed from: r  reason: collision with root package name */
    private int f4919r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f4920s;

    /* renamed from: t  reason: collision with root package name */
    private float f4921t;

    /* renamed from: u  reason: collision with root package name */
    private float f4922u;

    /* renamed from: v  reason: collision with root package name */
    private int f4923v;

    public PagerTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f4914m = paint;
        this.f4915n = new Rect();
        this.f4916o = 255;
        this.f4917p = false;
        this.f4918q = false;
        int i2 = this.f4933f;
        this.f4908g = i2;
        paint.setColor(i2);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f4909h = (int) ((3.0f * f2) + 0.5f);
        this.f4910i = (int) ((6.0f * f2) + 0.5f);
        this.f4911j = (int) (64.0f * f2);
        this.f4913l = (int) ((16.0f * f2) + 0.5f);
        this.f4919r = (int) ((1.0f * f2) + 0.5f);
        this.f4912k = (int) ((f2 * 32.0f) + 0.5f);
        this.f4923v = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f4929b.setFocusable(true);
        this.f4929b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.f4928a.setCurrentItem(PagerTabStrip.this.f4928a.getCurrentItem() - 1);
            }
        });
        this.f4931d.setFocusable(true);
        this.f4931d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.f4928a.setCurrentItem(PagerTabStrip.this.f4928a.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.f4917p = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2, boolean z2) {
        Rect rect = this.f4915n;
        int height = getHeight();
        int left = this.f4930c.getLeft() - this.f4913l;
        int right = this.f4930c.getRight() + this.f4913l;
        int i3 = height - this.f4909h;
        rect.set(left, i3, right, height);
        super.a(i2, f2, z2);
        this.f4916o = (int) (Math.abs(f2 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f4930c.getLeft() - this.f4913l, i3, this.f4930c.getRight() + this.f4913l, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f4917p;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f4912k);
    }

    public int getTabIndicatorColor() {
        return this.f4908g;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f4930c.getLeft() - this.f4913l;
        int right = this.f4930c.getRight() + this.f4913l;
        this.f4914m.setColor((this.f4916o << 24) | (this.f4908g & 16777215));
        float f2 = (float) height;
        canvas.drawRect((float) left, (float) (height - this.f4909h), (float) right, f2, this.f4914m);
        if (this.f4917p) {
            this.f4914m.setColor(-16777216 | (this.f4908g & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.f4919r), (float) (getWidth() - getPaddingRight()), f2, this.f4914m);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewPager viewPager;
        int currentItem;
        int action = motionEvent.getAction();
        if (action != 0 && this.f4920s) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (action == 0) {
            this.f4921t = x2;
            this.f4922u = y2;
            this.f4920s = false;
        } else if (action == 1) {
            if (x2 < ((float) (this.f4930c.getLeft() - this.f4913l))) {
                viewPager = this.f4928a;
                currentItem = this.f4928a.getCurrentItem() - 1;
            } else if (x2 > ((float) (this.f4930c.getRight() + this.f4913l))) {
                viewPager = this.f4928a;
                currentItem = this.f4928a.getCurrentItem() + 1;
            }
            viewPager.setCurrentItem(currentItem);
        } else if (action == 2 && (Math.abs(x2 - this.f4921t) > ((float) this.f4923v) || Math.abs(y2 - this.f4922u) > ((float) this.f4923v))) {
            this.f4920s = true;
        }
        return true;
    }

    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        if (!this.f4918q) {
            this.f4917p = (i2 & -16777216) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f4918q) {
            this.f4917p = drawable == null;
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        if (!this.f4918q) {
            this.f4917p = i2 == 0;
        }
    }

    public void setDrawFullUnderline(boolean z2) {
        this.f4917p = z2;
        this.f4918q = true;
        invalidate();
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        int i6 = this.f4910i;
        if (i5 < i6) {
            i5 = i6;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    public void setTabIndicatorColor(int i2) {
        this.f4908g = i2;
        this.f4914m.setColor(i2);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i2) {
        setTabIndicatorColor(b.c(getContext(), i2));
    }

    public void setTextSpacing(int i2) {
        int i3 = this.f4911j;
        if (i2 < i3) {
            i2 = i3;
        }
        super.setTextSpacing(i2);
    }
}
