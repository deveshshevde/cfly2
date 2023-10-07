package com.github.barteksc.pdfviewer.util;

import android.content.Context;
import android.util.TypedValue;

public class d {
    public static int a(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }
}
