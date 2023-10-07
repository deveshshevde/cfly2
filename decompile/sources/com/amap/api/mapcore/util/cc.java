package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;

public final class cc {

    /* renamed from: a  reason: collision with root package name */
    private static Paint f8124a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private static Rect f8125b = new Rect();

    public static float a(int i2, boolean z2) {
        if (z2) {
            if (i2 != 1) {
                return i2 != 2 ? 0.5f : 1.0f;
            }
            return 0.0f;
        } else if (i2 != 8) {
            return i2 != 16 ? 0.5f : 1.0f;
        } else {
            return 0.0f;
        }
    }

    public static MarkerOptions a(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(textOptions.getPosition());
        markerOptions.visible(textOptions.isVisible());
        markerOptions.zIndex(textOptions.getZIndex());
        markerOptions.rotateAngle(textOptions.getRotate());
        markerOptions.icon(b(textOptions));
        markerOptions.anchor(a(textOptions.getAlignX(), true), a(textOptions.getAlignY(), false));
        return markerOptions;
    }

    public static BitmapDescriptor b(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        f8124a.setTypeface(textOptions.getTypeface());
        f8124a.setSubpixelText(true);
        f8124a.setAntiAlias(true);
        f8124a.setStrokeWidth(5.0f);
        f8124a.setStrokeCap(Paint.Cap.ROUND);
        f8124a.setTextSize((float) textOptions.getFontSize());
        f8124a.setTextAlign(Paint.Align.CENTER);
        f8124a.setColor(textOptions.getFontColor());
        Paint.FontMetrics fontMetrics = f8124a.getFontMetrics();
        int i2 = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i3 = (int) (((((float) i2) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            f8124a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), f8125b);
        }
        Bitmap createBitmap = Bitmap.createBitmap(f8125b.width() + 6, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), (float) (f8125b.centerX() + 3), (float) i3, f8124a);
        }
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }
}
