package com.flypro.photoview_library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.flypro.photoview_library.d;

public class PhotoView extends ImageView implements c {

    /* renamed from: a  reason: collision with root package name */
    private final d f14471a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView.ScaleType f14472b;

    public PhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.f14471a = new d(this);
        ImageView.ScaleType scaleType = this.f14472b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f14472b = null;
        }
    }

    public Matrix getDisplayMatrix() {
        return this.f14471a.l();
    }

    public RectF getDisplayRect() {
        return this.f14471a.b();
    }

    public c getIPhotoViewImplementation() {
        return this.f14471a;
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.f14471a.f();
    }

    public float getMediumScale() {
        return this.f14471a.e();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.f14471a.d();
    }

    public d.C0104d getOnPhotoTapListener() {
        return this.f14471a.i();
    }

    public d.e getOnViewTapListener() {
        return this.f14471a.j();
    }

    public float getScale() {
        return this.f14471a.g();
    }

    public ImageView.ScaleType getScaleType() {
        return this.f14471a.h();
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.f14471a.m();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f14471a.a();
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean z2) {
        this.f14471a.a(z2);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d dVar = this.f14471a;
        if (dVar != null) {
            dVar.k();
        }
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        d dVar = this.f14471a;
        if (dVar != null) {
            dVar.k();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d dVar = this.f14471a;
        if (dVar != null) {
            dVar.k();
        }
    }

    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    public void setMaximumScale(float f2) {
        this.f14471a.e(f2);
    }

    public void setMediumScale(float f2) {
        this.f14471a.d(f2);
    }

    @Deprecated
    public void setMidScale(float f2) {
        setMediumScale(f2);
    }

    @Deprecated
    public void setMinScale(float f2) {
        setMinimumScale(f2);
    }

    public void setMinimumScale(float f2) {
        this.f14471a.c(f2);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f14471a.a(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f14471a.a(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d.c cVar) {
        this.f14471a.a(cVar);
    }

    public void setOnPhotoTapListener(d.C0104d dVar) {
        this.f14471a.a(dVar);
    }

    public void setOnViewTapListener(d.e eVar) {
        this.f14471a.a(eVar);
    }

    public void setPhotoViewRotation(float f2) {
        this.f14471a.a(f2);
    }

    public void setRotationBy(float f2) {
        this.f14471a.b(f2);
    }

    public void setRotationTo(float f2) {
        this.f14471a.a(f2);
    }

    public void setScale(float f2) {
        this.f14471a.f(f2);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        d dVar = this.f14471a;
        if (dVar != null) {
            dVar.a(scaleType);
        } else {
            this.f14472b = scaleType;
        }
    }

    public void setZoomTransitionDuration(int i2) {
        this.f14471a.a(i2);
    }

    public void setZoomable(boolean z2) {
        this.f14471a.b(z2);
    }
}
