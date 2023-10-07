package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.R;
import androidx.core.widget.n;
import t.aa;

public class AppCompatImageButton extends ImageButton implements n, aa {

    /* renamed from: a  reason: collision with root package name */
    private final d f1116a;

    /* renamed from: b  reason: collision with root package name */
    private final h f1117b;

    public AppCompatImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(ac.a(context), attributeSet, i2);
        aa.a((View) this, getContext());
        d dVar = new d(this);
        this.f1116a = dVar;
        dVar.a(attributeSet, i2);
        h hVar = new h(this);
        this.f1117b = hVar;
        hVar.a(attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1116a;
        if (dVar != null) {
            dVar.c();
        }
        h hVar = this.f1117b;
        if (hVar != null) {
            hVar.d();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1116a;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1116a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        h hVar = this.f1117b;
        if (hVar != null) {
            return hVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        h hVar = this.f1117b;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f1117b.a() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1116a;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1116a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        h hVar = this.f1117b;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        h hVar = this.f1117b;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setImageResource(int i2) {
        this.f1117b.a(i2);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        h hVar = this.f1117b;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1116a;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1116a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        h hVar = this.f1117b;
        if (hVar != null) {
            hVar.a(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        h hVar = this.f1117b;
        if (hVar != null) {
            hVar.a(mode);
        }
    }
}
