package com.ctoo.mediaedit.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.ctoo.mediaedit.tools.e;
import cz.a;
import java.util.ArrayList;
import java.util.List;

abstract class BaseGLTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    protected e f10871a;

    /* renamed from: b  reason: collision with root package name */
    protected e.b f10872b;

    /* renamed from: c  reason: collision with root package name */
    private List<Runnable> f10873c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private TextureView.SurfaceTextureListener f10874d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public e.l f10875e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10876f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10877g = false;

    /* renamed from: h  reason: collision with root package name */
    private a f10878h;

    public BaseGLTextureView(Context context) {
        super(context);
        c();
    }

    public BaseGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public BaseGLTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void b(int i2, int i3) {
        j_();
        a_(i2, i3);
        k_();
    }

    /* access modifiers changed from: protected */
    public void a_(int i2, int i3) {
        this.f10871a.a(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void c() {
        super.setSurfaceTextureListener(this);
    }

    /* access modifiers changed from: protected */
    public void d() {
        Log.d("BaseGLTextureView", "createGLThread: ");
        this.f10876f = true;
        if (this.f10877g) {
            e a2 = this.f10872b.a();
            this.f10871a = a2;
            a2.a((e.l) new e.l() {
                public void a(final a aVar) {
                    BaseGLTextureView.this.post(new Runnable() {
                        public void run() {
                            if (BaseGLTextureView.this.f10875e != null) {
                                BaseGLTextureView.this.f10875e.a(aVar);
                            }
                        }
                    });
                }
            });
            this.f10871a.start();
            b(getWidth(), getHeight());
            for (Runnable a3 : this.f10873c) {
                this.f10871a.a(a3);
            }
            this.f10873c.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            e eVar = this.f10871a;
            if (eVar != null) {
                eVar.f();
            }
        } finally {
            super.finalize();
        }
    }

    public a getCurrentEglContext() {
        e eVar = this.f10871a;
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    /* access modifiers changed from: protected */
    public int getRenderMode() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void j_() {
        this.f10871a.e();
    }

    /* access modifiers changed from: protected */
    public void k_() {
        e eVar = this.f10871a;
        if (eVar != null) {
            eVar.d();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        Log.d("BaseGLTextureView", "onDetachedFromWindow: ");
        e eVar = this.f10871a;
        if (eVar != null) {
            eVar.f();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Log.d("BaseGLTextureView", "onSizeChanged: ");
        super.onSizeChanged(i2, i3, i4, i5);
        e eVar = this.f10871a;
        if (eVar != null) {
            eVar.a(i2, i3);
        }
    }

    public void setOnCreateGLContextListener(e.l lVar) {
        this.f10875e = lVar;
    }

    public void setRenderer(a aVar) {
        this.f10878h = aVar;
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.f10874d = surfaceTextureListener;
    }
}
