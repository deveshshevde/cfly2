package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.widget.b;
import androidx.core.widget.j;
import androidx.core.widget.m;
import c.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import m.d;
import r.c;
import t.aa;

public class AppCompatTextView extends TextView implements b, m, aa {

    /* renamed from: a  reason: collision with root package name */
    private final d f1157a;

    /* renamed from: b  reason: collision with root package name */
    private final m f1158b;

    /* renamed from: c  reason: collision with root package name */
    private final l f1159c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1160e;

    /* renamed from: f  reason: collision with root package name */
    private Future<c> f1161f;

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(ac.a(context), attributeSet, i2);
        this.f1160e = false;
        aa.a((View) this, getContext());
        d dVar = new d(this);
        this.f1157a = dVar;
        dVar.a(attributeSet, i2);
        m mVar = new m(this);
        this.f1158b = mVar;
        mVar.a(attributeSet, i2);
        mVar.b();
        this.f1159c = new l(this);
    }

    private void a() {
        Future<c> future = this.f1161f;
        if (future != null) {
            try {
                this.f1161f = null;
                j.a((TextView) this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1157a;
        if (dVar != null) {
            dVar.c();
        }
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (f3067d) {
            return super.getAutoSizeMaxTextSize();
        }
        m mVar = this.f1158b;
        if (mVar != null) {
            return mVar.h();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f3067d) {
            return super.getAutoSizeMinTextSize();
        }
        m mVar = this.f1158b;
        if (mVar != null) {
            return mVar.g();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (f3067d) {
            return super.getAutoSizeStepGranularity();
        }
        m mVar = this.f1158b;
        if (mVar != null) {
            return mVar.f();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f3067d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        m mVar = this.f1158b;
        return mVar != null ? mVar.i() : new int[0];
    }

    public int getAutoSizeTextType() {
        if (f3067d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        m mVar = this.f1158b;
        if (mVar != null) {
            return mVar.e();
        }
        return 0;
    }

    public int getFirstBaselineToTopHeight() {
        return j.c(this);
    }

    public int getLastBaselineToBottomHeight() {
        return j.d(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1157a;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1157a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1158b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1158b.k();
    }

    public CharSequence getText() {
        a();
        return super.getText();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.f1159c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L_0x0010
            androidx.appcompat.widget.l r0 = r2.f1159c
            if (r0 != 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            android.view.textclassifier.TextClassifier r0 = r0.a()
            return r0
        L_0x0010:
            android.view.textclassifier.TextClassifier r0 = super.getTextClassifier()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextView.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    public c.a getTextMetricsParamsCompat() {
        return j.e(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1158b.a((TextView) this, onCreateInputConnection, editorInfo);
        return g.a(onCreateInputConnection, editorInfo, this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a(z2, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        a();
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        if (this.f1158b != null && !f3067d && this.f1158b.d()) {
            this.f1158b.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (f3067d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (f3067d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (f3067d) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1157a;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1157a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b3 = i3 != 0 ? a.b(context, i3) : null;
        Drawable b4 = i4 != 0 ? a.b(context, i4) : null;
        if (i5 != 0) {
            drawable = a.b(context, i5);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b3, b4, drawable);
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b3 = i3 != 0 ? a.b(context, i3) : null;
        Drawable b4 = i4 != 0 ? a.b(context, i4) : null;
        if (i5 != 0) {
            drawable = a.b(context, i5);
        }
        setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, drawable);
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            j.b(this, i2);
        }
    }

    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            j.c(this, i2);
        }
    }

    public void setLineHeight(int i2) {
        j.d(this, i2);
    }

    public void setPrecomputedText(c cVar) {
        j.a((TextView) this, cVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1157a;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1157a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1158b.a(colorStateList);
        this.f1158b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1158b.a(mode);
        this.f1158b.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a(context, i2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        l lVar;
        if (Build.VERSION.SDK_INT >= 28 || (lVar = this.f1159c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            lVar.a(textClassifier);
        }
    }

    public void setTextFuture(Future<c> future) {
        this.f1161f = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        j.a((TextView) this, aVar);
    }

    public void setTextSize(int i2, float f2) {
        if (f3067d) {
            super.setTextSize(i2, f2);
            return;
        }
        m mVar = this.f1158b;
        if (mVar != null) {
            mVar.a(i2, f2);
        }
    }

    public void setTypeface(Typeface typeface, int i2) {
        if (!this.f1160e) {
            Typeface typeface2 = null;
            if (typeface != null && i2 > 0) {
                typeface2 = d.a(getContext(), typeface, i2);
            }
            this.f1160e = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i2);
            } finally {
                this.f1160e = false;
            }
        }
    }
}
