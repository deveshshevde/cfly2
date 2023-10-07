package com.afollestad.materialdialogs.bottomsheets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.h;

public final class HeightMatchesWidthImageView extends AppCompatImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeightMatchesWidthImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i2);
    }
}
