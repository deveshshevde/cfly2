package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.drawee.view.a;
import df.b;
import dm.b;

public class DraweeView<DH extends b> extends ImageView {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f11299f = false;

    /* renamed from: a  reason: collision with root package name */
    private final a.C0088a f11300a = new a.C0088a();

    /* renamed from: b  reason: collision with root package name */
    private float f11301b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private b<DH> f11302c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11303d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11304e = false;

    public DraweeView(Context context) {
        super(context);
        a(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        try {
            if (ds.b.b()) {
                ds.b.a("DraweeView#init");
            }
            if (!this.f11303d) {
                boolean z2 = true;
                this.f11303d = true;
                this.f11302c = b.a(null, context);
                if (Build.VERSION.SDK_INT >= 21) {
                    ColorStateList imageTintList = getImageTintList();
                    if (imageTintList != null) {
                        setColorFilter(imageTintList.getDefaultColor());
                    } else if (ds.b.b()) {
                        ds.b.a();
                        return;
                    } else {
                        return;
                    }
                }
                if (!f11299f || context.getApplicationInfo().targetSdkVersion < 24) {
                    z2 = false;
                }
                this.f11304e = z2;
                if (ds.b.b()) {
                    ds.b.a();
                }
            }
        } finally {
            if (ds.b.b()) {
                ds.b.a();
            }
        }
    }

    private void e() {
        Drawable drawable;
        if (this.f11304e && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z2) {
        f11299f = z2;
    }

    /* access modifiers changed from: protected */
    public void a() {
        c();
    }

    /* access modifiers changed from: protected */
    public void b() {
        d();
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f11302c.b();
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.f11302c.c();
    }

    public float getAspectRatio() {
        return this.f11301b;
    }

    public dm.a getController() {
        return this.f11302c.d();
    }

    public DH getHierarchy() {
        return this.f11302c.e();
    }

    public Drawable getTopLevelDrawable() {
        return this.f11302c.f();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
        a();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        e();
        a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        this.f11300a.f11307a = i2;
        this.f11300a.f11308b = i3;
        a.a(this.f11300a, this.f11301b, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.f11300a.f11307a, this.f11300a.f11308b);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        e();
        b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11302c.a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        e();
    }

    public void setAspectRatio(float f2) {
        if (f2 != this.f11301b) {
            this.f11301b = f2;
            requestLayout();
        }
    }

    public void setController(dm.a aVar) {
        this.f11302c.a(aVar);
        super.setImageDrawable(this.f11302c.f());
    }

    public void setHierarchy(DH dh2) {
        this.f11302c.a(dh2);
        super.setImageDrawable(this.f11302c.f());
    }

    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        a(getContext());
        this.f11302c.a((dm.a) null);
        super.setImageBitmap(bitmap);
    }

    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        a(getContext());
        this.f11302c.a((dm.a) null);
        super.setImageDrawable(drawable);
    }

    @Deprecated
    public void setImageResource(int i2) {
        a(getContext());
        this.f11302c.a((dm.a) null);
        super.setImageResource(i2);
    }

    @Deprecated
    public void setImageURI(Uri uri) {
        a(getContext());
        this.f11302c.a((dm.a) null);
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z2) {
        this.f11304e = z2;
    }

    public String toString() {
        b.a a2 = df.b.a((Object) this);
        b<DH> bVar = this.f11302c;
        return a2.a("holder", (Object) bVar != null ? bVar.toString() : "<no holder set>").toString();
    }
}
