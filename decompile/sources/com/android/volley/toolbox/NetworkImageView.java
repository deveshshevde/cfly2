package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.h;

public class NetworkImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private String f9943a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f9944b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f9945c;

    /* renamed from: d  reason: collision with root package name */
    private h f9946d;

    /* renamed from: e  reason: collision with root package name */
    private h.c f9947e;

    public NetworkImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private void a(final boolean z2) {
        int width = getWidth();
        int height = getHeight();
        if (width != 0 || height != 0) {
            if (TextUtils.isEmpty(this.f9943a)) {
                h.c cVar = this.f9947e;
                if (cVar != null) {
                    cVar.a();
                    this.f9947e = null;
                }
                setImageBitmap((Bitmap) null);
                return;
            }
            h.c cVar2 = this.f9947e;
            if (!(cVar2 == null || cVar2.c() == null)) {
                if (!this.f9947e.c().equals(this.f9943a)) {
                    this.f9947e.a();
                    setImageBitmap((Bitmap) null);
                } else {
                    return;
                }
            }
            this.f9947e = this.f9946d.a(this.f9943a, (h.d) new h.d() {
                public void a(VolleyError volleyError) {
                    if (NetworkImageView.this.f9945c != 0) {
                        NetworkImageView networkImageView = NetworkImageView.this;
                        networkImageView.setImageResource(networkImageView.f9945c);
                    }
                }

                public void a(final h.c cVar, boolean z2) {
                    if (z2 && z2) {
                        NetworkImageView.this.post(new Runnable() {
                            public void run() {
                                AnonymousClass1.this.a(cVar, false);
                            }
                        });
                    } else if (cVar.b() != null) {
                        NetworkImageView.this.setImageBitmap(cVar.b());
                    } else if (NetworkImageView.this.f9944b != 0) {
                        NetworkImageView networkImageView = NetworkImageView.this;
                        networkImageView.setImageResource(networkImageView.f9944b);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        h.c cVar = this.f9947e;
        if (cVar != null) {
            cVar.a();
            setImageBitmap((Bitmap) null);
            this.f9947e = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        a(true);
    }

    public void setDefaultImageResId(int i2) {
        this.f9944b = i2;
    }

    public void setErrorImageResId(int i2) {
        this.f9945c = i2;
    }
}
