package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class PhotoView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private k f14701a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView.ScaleType f14702b;

    public PhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f14701a = new k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f14702b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f14702b = null;
        }
    }

    public k getAttacher() {
        return this.f14701a;
    }

    public RectF getDisplayRect() {
        return this.f14701a.a();
    }

    public Matrix getImageMatrix() {
        return this.f14701a.h();
    }

    public float getMaximumScale() {
        return this.f14701a.d();
    }

    public float getMediumScale() {
        return this.f14701a.c();
    }

    public float getMinimumScale() {
        return this.f14701a.b();
    }

    public float getScale() {
        return this.f14701a.e();
    }

    public ImageView.ScaleType getScaleType() {
        return this.f14701a.f();
    }

    public void setAllowParentInterceptOnEdge(boolean z2) {
        this.f14701a.a(z2);
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.f14701a.g();
        }
        return frame;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f14701a;
        if (kVar != null) {
            kVar.g();
        }
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        k kVar = this.f14701a;
        if (kVar != null) {
            kVar.g();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f14701a;
        if (kVar != null) {
            kVar.g();
        }
    }

    public void setMaximumScale(float f2) {
        this.f14701a.e(f2);
    }

    public void setMediumScale(float f2) {
        this.f14701a.d(f2);
    }

    public void setMinimumScale(float f2) {
        this.f14701a.c(f2);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f14701a.a(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f14701a.a(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f14701a.a(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f14701a.a(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f14701a.a(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f14701a.a(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f14701a.a(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f14701a.a(hVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.f14701a.a(iVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.f14701a.a(jVar);
    }

    public void setRotationBy(float f2) {
        this.f14701a.b(f2);
    }

    public void setRotationTo(float f2) {
        this.f14701a.a(f2);
    }

    public void setScale(float f2) {
        this.f14701a.f(f2);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.f14701a;
        if (kVar == null) {
            this.f14702b = scaleType;
        } else {
            kVar.a(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i2) {
        this.f14701a.a(i2);
    }

    public void setZoomable(boolean z2) {
        this.f14701a.b(z2);
    }
}
