package jp.co.cyberagent.android.gpuimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import java.io.File;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class GPUImageView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public b f29636a = null;

    /* renamed from: b  reason: collision with root package name */
    private GLSurfaceView f29637b;

    /* renamed from: c  reason: collision with root package name */
    private GPUImage f29638c;

    /* renamed from: d  reason: collision with root package name */
    private a f29639d;

    /* renamed from: e  reason: collision with root package name */
    private float f29640e = 0.0f;

    private class a extends GLSurfaceView {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            if (GPUImageView.this.f29636a != null) {
                i2 = View.MeasureSpec.makeMeasureSpec(GPUImageView.this.f29636a.f29642a, MemoryConstants.GB);
                i3 = View.MeasureSpec.makeMeasureSpec(GPUImageView.this.f29636a.f29643b, MemoryConstants.GB);
            }
            super.onMeasure(i2, i3);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f29642a;

        /* renamed from: b  reason: collision with root package name */
        int f29643b;
    }

    public GPUImageView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public GPUImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        a aVar = new a(context, attributeSet);
        this.f29637b = aVar;
        addView(aVar);
        GPUImage gPUImage = new GPUImage(getContext());
        this.f29638c = gPUImage;
        gPUImage.a(this.f29637b);
    }

    public void a() {
        this.f29637b.requestRender();
    }

    public a getFilter() {
        return this.f29639d;
    }

    public GPUImage getGPUImage() {
        return this.f29638c;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f29640e != 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            float f2 = (float) size;
            float f3 = this.f29640e;
            float f4 = (float) size2;
            if (f2 / f3 < f4) {
                size2 = Math.round(f2 / f3);
            } else {
                size = Math.round(f4 * f3);
            }
            i2 = View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB);
            i3 = View.MeasureSpec.makeMeasureSpec(size2, MemoryConstants.GB);
        }
        super.onMeasure(i2, i3);
    }

    public void setFilter(a aVar) {
        this.f29639d = aVar;
        this.f29638c.a(aVar);
        a();
    }

    public void setImage(Bitmap bitmap) {
        this.f29638c.a(bitmap);
    }

    public void setImage(Uri uri) {
        this.f29638c.a(uri);
    }

    public void setImage(File file) {
        this.f29638c.a(file);
    }

    public void setRatio(float f2) {
        this.f29640e = f2;
        this.f29637b.requestLayout();
        this.f29638c.b();
    }

    public void setRotation(Rotation rotation) {
        this.f29638c.a(rotation);
        a();
    }

    public void setScaleType(GPUImage.ScaleType scaleType) {
        this.f29638c.a(scaleType);
    }
}
