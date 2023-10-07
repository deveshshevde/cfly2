package com.xeagle.android.vjoystick.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.cfly.uav_pro.R;

public class DrawRectangleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f25395a;

    /* renamed from: b  reason: collision with root package name */
    private int f25396b = 5;

    /* renamed from: c  reason: collision with root package name */
    private int f25397c = Color.parseColor("#23DFD5");

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f25398d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f25399e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f25400f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f25401g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f25402h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f25403i;

    /* renamed from: j  reason: collision with root package name */
    private int f25404j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f25405k = ((int) TypedValue.applyDimension(2, 30.0f, getResources().getDisplayMetrics()));

    /* renamed from: l  reason: collision with root package name */
    private TextPaint f25406l;

    /* renamed from: m  reason: collision with root package name */
    private String f25407m;

    /* renamed from: n  reason: collision with root package name */
    private volatile Rect f25408n = new Rect(0, 0, 0, 0);

    /* renamed from: o  reason: collision with root package name */
    private boolean f25409o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f25410p = true;

    /* renamed from: q  reason: collision with root package name */
    private boolean f25411q = false;

    /* renamed from: r  reason: collision with root package name */
    private a f25412r;

    public interface a {
        void a();

        void a(Rect rect);
    }

    public DrawRectangleView(Context context) {
        super(context);
        c();
    }

    public DrawRectangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void c() {
        Paint paint = new Paint();
        this.f25395a = paint;
        paint.setColor(this.f25397c);
        this.f25395a.setStyle(Paint.Style.STROKE);
        this.f25395a.setStrokeWidth((float) this.f25396b);
        this.f25395a.setAntiAlias(true);
        this.f25398d = BitmapFactory.decodeResource(getResources(), R.drawable.ic_close_choise);
        this.f25399e = BitmapFactory.decodeResource(getResources(), R.drawable.ic_follow_close);
        this.f25400f = BitmapFactory.decodeResource(getResources(), R.drawable.ic_follow_bottom_left);
        this.f25401g = BitmapFactory.decodeResource(getResources(), R.drawable.ic_follow_bottom_right);
        this.f25402h = BitmapFactory.decodeResource(getResources(), R.drawable.ic_follow_mid_person);
        this.f25403i = BitmapFactory.decodeResource(getResources(), R.drawable.ic_follow_top_right);
        TextPaint textPaint = new TextPaint();
        this.f25406l = textPaint;
        textPaint.setColor(this.f25404j);
        this.f25406l.setAntiAlias(true);
        this.f25406l.setTextSize((float) this.f25405k);
    }

    private void d() {
        this.f25409o = true;
        setEnabled(false);
        invalidate();
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (!isEnabled()) {
            this.f25408n.left = i2;
            this.f25408n.top = i3;
            this.f25408n.right = i4;
            this.f25408n.bottom = i5;
            invalidate(this.f25408n);
        }
    }

    public boolean a() {
        return this.f25409o;
    }

    public void b() {
        this.f25408n.left = 0;
        this.f25408n.top = 0;
        this.f25408n.right = 0;
        this.f25408n.bottom = 0;
        this.f25395a.setColor(this.f25397c);
        this.f25409o = false;
        this.f25410p = true;
        this.f25411q = false;
        setEnabled(true);
        invalidate();
    }

    public Rect getCurrentRect() {
        return new Rect(this.f25408n.left, this.f25408n.top, this.f25408n.right, this.f25408n.bottom);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f25409o) {
            int width = this.f25408n.left + this.f25408n.width();
            int height = this.f25408n.top + this.f25408n.height();
            int width2 = this.f25408n.left + (this.f25408n.width() / 2);
            canvas.drawBitmap(this.f25399e, (float) (this.f25408n.left - (this.f25403i.getWidth() / 2)), (float) (this.f25408n.top - (this.f25403i.getHeight() / 2)), this.f25395a);
            Bitmap bitmap = this.f25403i;
            canvas.drawBitmap(bitmap, (float) (width - (bitmap.getWidth() / 2)), (float) (this.f25408n.top - (this.f25403i.getHeight() / 2)), this.f25395a);
            canvas.drawBitmap(this.f25400f, (float) (this.f25408n.left - (this.f25400f.getWidth() / 2)), (float) (height - (this.f25400f.getHeight() / 2)), this.f25395a);
            Bitmap bitmap2 = this.f25401g;
            canvas.drawBitmap(bitmap2, (float) (width - (bitmap2.getWidth() / 2)), (float) (height - (this.f25401g.getHeight() / 2)), this.f25395a);
            Bitmap bitmap3 = this.f25402h;
            canvas.drawBitmap(bitmap3, (float) (width2 - (bitmap3.getWidth() / 2)), (float) (height - (this.f25402h.getHeight() / 2)), this.f25395a);
            String str = this.f25407m;
            if (str != null && str.length() > 0) {
                Rect rect = new Rect();
                TextPaint textPaint = this.f25406l;
                String str2 = this.f25407m;
                textPaint.getTextBounds(str2, 0, str2.length(), rect);
                canvas.drawText(this.f25407m, ((float) width2) - (Layout.getDesiredWidth(this.f25407m, this.f25406l) / 2.0f), (float) (((this.f25408n.top + this.f25408n.bottom) - rect.height()) / 2), this.f25406l);
                return;
            }
            return;
        }
        canvas.drawRect(this.f25408n, this.f25395a);
        canvas.drawBitmap(this.f25398d, (float) (this.f25408n.left - (this.f25398d.getWidth() / 2)), (float) (this.f25408n.top - (this.f25398d.getHeight() / 2)), this.f25395a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (this.f25411q) {
            return false;
        }
        if (isEnabled() || !this.f25410p) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.f25408n.right = x2 + this.f25396b;
                        this.f25408n.bottom = y2 + this.f25396b;
                        invalidate(this.f25408n);
                    }
                } else if (this.f25408n.left < this.f25408n.right) {
                    d();
                    a aVar = this.f25412r;
                    if (aVar != null) {
                        aVar.a(getCurrentRect());
                    }
                    if (!this.f25410p) {
                        this.f25411q = true;
                    }
                }
                return false;
            }
            this.f25408n.left = x2;
            this.f25408n.top = y2;
            this.f25408n.right = this.f25408n.left + this.f25396b;
            this.f25408n.bottom = this.f25408n.top + this.f25396b;
            invalidate(this.f25408n);
            return true;
        }
        if (Math.abs(x2 - this.f25408n.left) < 50 && Math.abs(y2 - this.f25408n.top) < 50) {
            a aVar2 = this.f25412r;
            if (aVar2 != null) {
                aVar2.a();
            }
            b();
        }
        return false;
    }

    public void setOnDrawRectFinishListener(a aVar) {
        this.f25412r = aVar;
    }

    public void setShowMode(boolean z2) {
        Bitmap bitmap;
        this.f25410p = z2;
        if (z2) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_follow_close);
        } else {
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f);
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.ic_follow_bottom_left);
            bitmap = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, false);
        }
        this.f25399e = bitmap;
        invalidate();
    }

    public void setText(String str) {
        this.f25407m = str;
        invalidate();
    }
}
