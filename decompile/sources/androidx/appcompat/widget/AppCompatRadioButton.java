package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.R;
import androidx.core.widget.l;
import c.a;
import t.aa;

public class AppCompatRadioButton extends RadioButton implements l, aa {

    /* renamed from: a  reason: collision with root package name */
    private final e f1123a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1124b;

    /* renamed from: c  reason: collision with root package name */
    private final m f1125c;

    public AppCompatRadioButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i2) {
        super(ac.a(context), attributeSet, i2);
        aa.a((View) this, getContext());
        e eVar = new e(this);
        this.f1123a = eVar;
        eVar.a(attributeSet, i2);
        d dVar = new d(this);
        this.f1124b = dVar;
        dVar.a(attributeSet, i2);
        m mVar = new m(this);
        this.f1125c = mVar;
        mVar.a(attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1124b;
        if (dVar != null) {
            dVar.c();
        }
        m mVar = this.f1125c;
        if (mVar != null) {
            mVar.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        e eVar = this.f1123a;
        return eVar != null ? eVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1124b;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1124b;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        e eVar = this.f1123a;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        e eVar = this.f1123a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1124b;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1124b;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setButtonDrawable(int i2) {
        setButtonDrawable(a.b(getContext(), i2));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        e eVar = this.f1123a;
        if (eVar != null) {
            eVar.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1124b;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1124b;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        e eVar = this.f1123a;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1123a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }
}
