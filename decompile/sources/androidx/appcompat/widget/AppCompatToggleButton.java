package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ToggleButton;
import t.aa;

public class AppCompatToggleButton extends ToggleButton implements aa {

    /* renamed from: a  reason: collision with root package name */
    private final d f1162a;

    /* renamed from: b  reason: collision with root package name */
    private final m f1163b;

    public AppCompatToggleButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        aa.a((View) this, getContext());
        d dVar = new d(this);
        this.f1162a = dVar;
        dVar.a(attributeSet, i2);
        m mVar = new m(this);
        this.f1163b = mVar;
        mVar.a(attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1162a;
        if (dVar != null) {
            dVar.c();
        }
        m mVar = this.f1163b;
        if (mVar != null) {
            mVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1162a;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1162a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1162a;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1162a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1162a;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1162a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }
}
