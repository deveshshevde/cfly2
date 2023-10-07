package com.xeagle.android.widgets.spinners;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Spinner;
import com.xeagle.R;

public class SpinnerSelfSelect extends Spinner {

    /* renamed from: a  reason: collision with root package name */
    private a f26087a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26088b;

    public interface a {
        void a(Spinner spinner, int i2);
    }

    public SpinnerSelfSelect(Context context) {
        this(context, (AttributeSet) null);
    }

    public SpinnerSelfSelect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SpinnerSelfSelect, 0, 0);
        try {
            this.f26088b = obtainStyledAttributes.getBoolean(0, true);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void a(int i2) {
        super.setSelection(i2);
    }

    public void setOnSpinnerItemSelectedListener(a aVar) {
        this.f26087a = aVar;
    }

    public void setSelectable(boolean z2) {
        this.f26088b = z2;
        invalidate();
    }

    public void setSelection(int i2) {
        Log.d("SPIN", "selected - " + i2);
        if (this.f26088b) {
            a(i2);
        }
        a aVar = this.f26087a;
        if (aVar != null) {
            aVar.a(this, i2);
        }
    }
}
