package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.drawee.R;
import com.facebook.imagepipeline.request.ImageRequest;
import df.c;
import df.d;
import dk.b;

public class SimpleDraweeView extends GenericDraweeView {

    /* renamed from: a  reason: collision with root package name */
    private static d<? extends b> f11305a;

    /* renamed from: b  reason: collision with root package name */
    private b f11306b;

    public SimpleDraweeView(Context context) {
        super(context);
        b(context, (AttributeSet) null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        int resourceId;
        try {
            if (ds.b.b()) {
                ds.b.a("SimpleDraweeView#init");
            }
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                c.a(f11305a, (Object) "SimpleDraweeView was not initialized!");
                this.f11306b = (b) f11305a.a();
            }
            if (attributeSet != null) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleDraweeView);
                if (obtainStyledAttributes.hasValue(R.styleable.SimpleDraweeView_actualImageUri)) {
                    a(Uri.parse(obtainStyledAttributes.getString(R.styleable.SimpleDraweeView_actualImageUri)), (Object) null);
                } else if (obtainStyledAttributes.hasValue(R.styleable.SimpleDraweeView_actualImageResource) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.SimpleDraweeView_actualImageResource, -1)) != -1) {
                    if (isInEditMode()) {
                        setImageResource(resourceId);
                    } else {
                        setActualImageResource(resourceId);
                    }
                }
                obtainStyledAttributes.recycle();
            }
            if (ds.b.b()) {
                ds.b.a();
            }
        } catch (Throwable th) {
            if (ds.b.b()) {
                ds.b.a();
            }
            throw th;
        }
    }

    public void a(int i2, Object obj) {
        a(di.b.a(i2), obj);
    }

    public void a(Uri uri, Object obj) {
        setController(this.f11306b.a(obj).a(uri).b(getController()).i());
    }

    public void a(String str, Object obj) {
        a(str != null ? Uri.parse(str) : null, obj);
    }

    /* access modifiers changed from: protected */
    public b getControllerBuilder() {
        return this.f11306b;
    }

    public void setActualImageResource(int i2) {
        a(i2, (Object) null);
    }

    public void setImageRequest(ImageRequest imageRequest) {
        setController(this.f11306b.b(imageRequest).b(getController()).i());
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
    }

    public void setImageURI(Uri uri) {
        a(uri, (Object) null);
    }

    public void setImageURI(String str) {
        a(str, (Object) null);
    }
}
