package com.xeagle.android.camera.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import com.xeagle.R;

public class RoundImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f22396a;

    /* renamed from: b  reason: collision with root package name */
    private int f22397b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f22398c;

    /* renamed from: d  reason: collision with root package name */
    private int f22399d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f22400e;

    /* renamed from: f  reason: collision with root package name */
    private BitmapShader f22401f;

    /* renamed from: g  reason: collision with root package name */
    private int f22402g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f22403h;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22400e = new Matrix();
        Paint paint = new Paint();
        this.f22398c = paint;
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundImageView);
        this.f22397b = obtainStyledAttributes.getDimensionPixelSize(0, (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics()));
        this.f22396a = obtainStyledAttributes.getInt(1, 0);
        obtainStyledAttributes.recycle();
    }

    private Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void a() {
        Bitmap a2;
        Drawable drawable = getDrawable();
        if (drawable != null && (a2 = a(drawable)) != null) {
            this.f22401f = new BitmapShader(a2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            int i2 = this.f22396a;
            float f2 = 1.0f;
            if (i2 == 0) {
                f2 = (((float) this.f22402g) * 1.0f) / ((float) Math.min(a2.getWidth(), a2.getHeight()));
            } else if (i2 == 1) {
                Log.e("TAG", "b'w = " + a2.getWidth() + " , b'h = " + a2.getHeight());
                if (!(a2.getWidth() == getWidth() && a2.getHeight() == getHeight())) {
                    f2 = Math.max((((float) getWidth()) * 1.0f) / ((float) a2.getWidth()), (((float) getHeight()) * 1.0f) / ((float) a2.getHeight()));
                }
            }
            this.f22400e.setScale(f2, f2);
            this.f22401f.setLocalMatrix(this.f22400e);
            this.f22398c.setShader(this.f22401f);
        }
    }

    public int a(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Log.e("TAG", "onDraw");
        if (getDrawable() != null) {
            a();
            if (this.f22396a == 1) {
                RectF rectF = this.f22403h;
                int i2 = this.f22397b;
                canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.f22398c);
                return;
            }
            int i3 = this.f22399d;
            canvas.drawCircle((float) i3, (float) i3, (float) i3, this.f22398c);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f22396a == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.f22402g = min;
            this.f22399d = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
            this.f22396a = bundle.getInt("state_type");
            this.f22397b = bundle.getInt("state_border_radius");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f22396a);
        bundle.putInt("state_border_radius", this.f22397b);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.f22396a == 1) {
            this.f22403h = new RectF(0.0f, 0.0f, (float) i2, (float) i3);
        }
    }

    public void setBorderRadius(int i2) {
        int a2 = a(i2);
        if (this.f22397b != a2) {
            this.f22397b = a2;
            invalidate();
        }
    }

    public void setType(int i2) {
        if (this.f22396a != i2) {
            this.f22396a = i2;
            if (!(i2 == 1 || i2 == 0)) {
                this.f22396a = 0;
            }
            requestLayout();
        }
    }
}
