package com.xeagle.android.widgets.MenuImageview;

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
    private int f25610a;

    /* renamed from: b  reason: collision with root package name */
    private int f25611b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f25612c;

    /* renamed from: d  reason: collision with root package name */
    private int f25613d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f25614e;

    /* renamed from: f  reason: collision with root package name */
    private BitmapShader f25615f;

    /* renamed from: g  reason: collision with root package name */
    private int f25616g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f25617h;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        this.f25614e = new Matrix();
        Paint paint = new Paint();
        this.f25612c = paint;
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundImageView);
        this.f25611b = obtainStyledAttributes.getDimensionPixelSize(0, (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics()));
        this.f25610a = obtainStyledAttributes.getInt(1, 0);
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
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap a2 = a(drawable);
            this.f25615f = new BitmapShader(a2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            int i2 = this.f25610a;
            float f2 = 1.0f;
            if (i2 == 0) {
                f2 = (((float) this.f25616g) * 1.0f) / ((float) Math.min(a2.getWidth(), a2.getHeight()));
            } else if (i2 == 1) {
                Log.e("TAG", "b'w = " + a2.getWidth() + " , b'h = " + a2.getHeight());
                if (!(a2.getWidth() == getWidth() && a2.getHeight() == getHeight())) {
                    f2 = Math.max((((float) getWidth()) * 1.0f) / ((float) a2.getWidth()), (((float) getHeight()) * 1.0f) / ((float) a2.getHeight()));
                }
            }
            this.f25614e.setScale(f2, f2);
            this.f25615f.setLocalMatrix(this.f25614e);
            this.f25612c.setShader(this.f25615f);
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
            if (this.f25610a == 1) {
                RectF rectF = this.f25617h;
                int i2 = this.f25611b;
                canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.f25612c);
                return;
            }
            int i3 = this.f25613d;
            canvas.drawCircle((float) i3, (float) i3, (float) i3, this.f25612c);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f25610a == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.f25616g = min;
            this.f25613d = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
            this.f25610a = bundle.getInt("state_type");
            this.f25611b = bundle.getInt("state_border_radius");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f25610a);
        bundle.putInt("state_border_radius", this.f25611b);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.f25610a == 1) {
            this.f25617h = new RectF(0.0f, 0.0f, (float) i2, (float) i3);
        }
    }

    public void setBorderRadius(int i2) {
        int a2 = a(i2);
        if (this.f25611b != a2) {
            this.f25611b = a2;
            invalidate();
        }
    }

    public void setType(int i2) {
        if (this.f25610a != i2) {
            this.f25610a = i2;
            if (!(i2 == 1 || i2 == 0)) {
                this.f25610a = 0;
            }
            requestLayout();
        }
    }
}
