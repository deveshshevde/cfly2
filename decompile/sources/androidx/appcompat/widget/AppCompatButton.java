package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.widget.b;
import androidx.core.widget.j;
import androidx.core.widget.m;
import t.aa;

public class AppCompatButton extends Button implements b, m, aa {

    /* renamed from: a  reason: collision with root package name */
    private final d f1108a;

    /* renamed from: b  reason: collision with root package name */
    private final m f1109b;

    public AppCompatButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i2) {
        super(ac.a(context), attributeSet, i2);
        aa.a((View) this, getContext());
        d dVar = new d(this);
        this.f1108a = dVar;
        dVar.a(attributeSet, i2);
        m mVar = new m(this);
        this.f1109b = mVar;
        mVar.a(attributeSet, i2);
        mVar.b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1108a;
        if (dVar != null) {
            dVar.c();
        }
        m mVar = this.f1109b;
        if (mVar != null) {
            mVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (f3067d) {
            return super.getAutoSizeMaxTextSize();
        }
        m mVar = this.f1109b;
        if (mVar != null) {
            return mVar.h();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f3067d) {
            return super.getAutoSizeMinTextSize();
        }
        m mVar = this.f1109b;
        if (mVar != null) {
            return mVar.g();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (f3067d) {
            return super.getAutoSizeStepGranularity();
        }
        m mVar = this.f1109b;
        if (mVar != null) {
            return mVar.f();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f3067d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        m mVar = this.f1109b;
        return mVar != null ? mVar.i() : new int[0];
    }

    public int getAutoSizeTextType() {
        if (f3067d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        m mVar = this.f1109b;
        if (mVar != null) {
            return mVar.e();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1108a;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1108a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1109b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1109b.k();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        m mVar = this.f1109b;
        if (mVar != null) {
            mVar.a(z2, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        if (this.f1109b != null && !f3067d && this.f1109b.d()) {
            this.f1109b.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (f3067d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        m mVar = this.f1109b;
        if (mVar != null) {
            mVar.a(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (f3067d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        m mVar = this.f1109b;
        if (mVar != null) {
            mVar.a(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (f3067d) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        m mVar = this.f1109b;
        if (mVar != null) {
            mVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1108a;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1108a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setSupportAllCaps(boolean z2) {
        m mVar = this.f1109b;
        if (mVar != null) {
            mVar.a(z2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1108a;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1108a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1109b.a(colorStateList);
        this.f1109b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1109b.a(mode);
        this.f1109b.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        m mVar = this.f1109b;
        if (mVar != null) {
            mVar.a(context, i2);
        }
    }

    public void setTextSize(int i2, float f2) {
        if (f3067d) {
            super.setTextSize(i2, f2);
            return;
        }
        m mVar = this.f1109b;
        if (mVar != null) {
            mVar.a(i2, f2);
        }
    }
}
