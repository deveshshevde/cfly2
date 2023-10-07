package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.widget.j;
import c.a;
import t.aa;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements aa {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1105a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final d f1106b;

    /* renamed from: c  reason: collision with root package name */
    private final m f1107c;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(ac.a(context), attributeSet, i2);
        aa.a((View) this, getContext());
        af a2 = af.a(getContext(), attributeSet, f1105a, i2, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.a(0));
        }
        a2.b();
        d dVar = new d(this);
        this.f1106b = dVar;
        dVar.a(attributeSet, i2);
        m mVar = new m(this);
        this.f1107c = mVar;
        mVar.a(attributeSet, i2);
        mVar.b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1106b;
        if (dVar != null) {
            dVar.c();
        }
        m mVar = this.f1107c;
        if (mVar != null) {
            mVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1106b;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1106b;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return g.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1106b;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1106b;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(a.b(getContext(), i2));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1106b;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1106b;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        m mVar = this.f1107c;
        if (mVar != null) {
            mVar.a(context, i2);
        }
    }
}
