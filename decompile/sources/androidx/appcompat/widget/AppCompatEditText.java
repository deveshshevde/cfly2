package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.widget.j;
import androidx.core.widget.k;
import t.aa;
import t.ac;
import t.c;
import t.w;
import v.a;
import v.b;

public class AppCompatEditText extends EditText implements aa, w {

    /* renamed from: a  reason: collision with root package name */
    private final d f1112a;

    /* renamed from: b  reason: collision with root package name */
    private final m f1113b;

    /* renamed from: c  reason: collision with root package name */
    private final l f1114c;

    /* renamed from: d  reason: collision with root package name */
    private final k f1115d;

    public AppCompatEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i2) {
        super(ac.a(context), attributeSet, i2);
        aa.a((View) this, getContext());
        d dVar = new d(this);
        this.f1112a = dVar;
        dVar.a(attributeSet, i2);
        m mVar = new m(this);
        this.f1113b = mVar;
        mVar.a(attributeSet, i2);
        mVar.b();
        this.f1114c = new l(this);
        this.f1115d = new k();
    }

    public c a(c cVar) {
        return this.f1115d.a((View) this, cVar);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.c();
        }
        m mVar = this.f1113b;
        if (mVar != null) {
            mVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1112a;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1112a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.f1114c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L_0x0010
            androidx.appcompat.widget.l r0 = r2.f1114c
            if (r0 != 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            android.view.textclassifier.TextClassifier r0 = r0.a()
            return r0
        L_0x0010:
            android.view.textclassifier.TextClassifier r0 = super.getTextClassifier()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatEditText.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1113b.a((TextView) this, onCreateInputConnection, editorInfo);
        InputConnection a2 = g.a(onCreateInputConnection, editorInfo, this);
        String[] z2 = ac.z(this);
        if (a2 == null || z2 == null) {
            return a2;
        }
        a.a(editorInfo, z2);
        return b.a(a2, editorInfo, j.b(this));
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        if (j.a((View) this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public boolean onTextContextMenuItem(int i2) {
        if (j.a((TextView) this, i2)) {
            return true;
        }
        return super.onTextContextMenuItem(i2);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1112a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        m mVar = this.f1113b;
        if (mVar != null) {
            mVar.a(context, i2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        l lVar;
        if (Build.VERSION.SDK_INT >= 28 || (lVar = this.f1114c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            lVar.a(textClassifier);
        }
    }
}
