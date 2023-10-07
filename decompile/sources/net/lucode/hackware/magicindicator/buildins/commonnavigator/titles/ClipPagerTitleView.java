package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import mz.b;

public class ClipPagerTitleView extends View implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f31517a;

    /* renamed from: b  reason: collision with root package name */
    private int f31518b;

    /* renamed from: c  reason: collision with root package name */
    private int f31519c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31520d;

    /* renamed from: e  reason: collision with root package name */
    private float f31521e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f31522f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f31523g = new Rect();

    public ClipPagerTitleView(Context context) {
        super(context);
        a(context);
    }

    private int a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.f31523g.width() + getPaddingLeft() + getPaddingRight() : Math.min(this.f31523g.width() + getPaddingLeft() + getPaddingRight(), size);
    }

    private void a() {
        Paint paint = this.f31522f;
        String str = this.f31517a;
        paint.getTextBounds(str, 0, str == null ? 0 : str.length(), this.f31523g);
    }

    private void a(Context context) {
        int a2 = my.b.a(context, 16.0d);
        Paint paint = new Paint(1);
        this.f31522f = paint;
        paint.setTextSize((float) a2);
        int a3 = my.b.a(context, 10.0d);
        setPadding(a3, 0, a3, 0);
    }

    private int b(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.f31523g.height() + getPaddingTop() + getPaddingBottom() : Math.min(this.f31523g.height() + getPaddingTop() + getPaddingBottom(), size);
    }

    public void a(int i2, int i3) {
    }

    public void a(int i2, int i3, float f2, boolean z2) {
        this.f31520d = z2;
        this.f31521e = f2;
        invalidate();
    }

    public void b(int i2, int i3) {
    }

    public void b(int i2, int i3, float f2, boolean z2) {
        this.f31520d = !z2;
        this.f31521e = 1.0f - f2;
        invalidate();
    }

    public int getClipColor() {
        return this.f31519c;
    }

    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.f31522f.getFontMetrics();
        return (int) (((float) (getHeight() / 2)) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getContentLeft() {
        return (getLeft() + (getWidth() / 2)) - (this.f31523g.width() / 2);
    }

    public int getContentRight() {
        return getLeft() + (getWidth() / 2) + (this.f31523g.width() / 2);
    }

    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.f31522f.getFontMetrics();
        return (int) (((float) (getHeight() / 2)) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public String getText() {
        return this.f31517a;
    }

    public int getTextColor() {
        return this.f31518b;
    }

    public float getTextSize() {
        return this.f31522f.getTextSize();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.f31522f.getFontMetrics();
        int height = (int) (((((float) getHeight()) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.f31522f.setColor(this.f31518b);
        float width = (float) ((getWidth() - this.f31523g.width()) / 2);
        float f2 = (float) height;
        canvas.drawText(this.f31517a, width, f2, this.f31522f);
        canvas.save();
        if (this.f31520d) {
            canvas.clipRect(0.0f, 0.0f, ((float) getWidth()) * this.f31521e, (float) getHeight());
        } else {
            canvas.clipRect(((float) getWidth()) * (1.0f - this.f31521e), 0.0f, (float) getWidth(), (float) getHeight());
        }
        this.f31522f.setColor(this.f31519c);
        canvas.drawText(this.f31517a, width, f2, this.f31522f);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        a();
        setMeasuredDimension(a(i2), b(i3));
    }

    public void setClipColor(int i2) {
        this.f31519c = i2;
        invalidate();
    }

    public void setText(String str) {
        this.f31517a = str;
        requestLayout();
    }

    public void setTextColor(int i2) {
        this.f31518b = i2;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.f31522f.setTextSize(f2);
        requestLayout();
    }
}
