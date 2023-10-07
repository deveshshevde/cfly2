package com.transitionseverywhere;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

public abstract class PathMotion {

    /* renamed from: a  reason: collision with root package name */
    public static final PathMotion f21832a = new PathMotion() {
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };

    public PathMotion() {
    }

    public PathMotion(Context context, AttributeSet attributeSet) {
    }

    public abstract Path a(float f2, float f3, float f4, float f5);
}
