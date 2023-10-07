package com.amap.api.maps.model;

import android.graphics.Typeface;
import com.amap.api.mapcore.util.cc;

public final class Text {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    private Marker marker;
    private TextOptions textOptions;

    public Text(Marker marker2, TextOptions textOptions2) {
        this.marker = marker2;
        this.textOptions = textOptions2;
    }

    private void a() {
        this.marker.setIcon(cc.b(this.textOptions));
    }

    public final void destroy() {
        try {
            this.marker.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Text)) {
            return false;
        }
        try {
            return this.marker.equals(((Text) obj).marker);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int getAlignX() {
        try {
            return this.textOptions.getAlignX();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getAlignY() {
        try {
            this.textOptions.getAlignY();
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getBackgroundColor() {
        try {
            return this.textOptions.getBackgroundColor();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getFontColor() {
        try {
            return this.textOptions.getFontColor();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getFontSize() {
        try {
            return this.textOptions.getFontSize();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final String getId() {
        try {
            return this.marker.getId();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Object getObject() {
        return this.marker.getObject();
    }

    public final LatLng getPosition() {
        try {
            return this.marker.getPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getRotate() {
        return this.marker.getRotateAngle();
    }

    public final String getText() {
        try {
            return this.textOptions.getText();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Typeface getTypeface() {
        try {
            return this.textOptions.getTypeface();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getZIndex() {
        return this.marker.getZIndex();
    }

    public final int hashCode() {
        return this.marker.hashCode();
    }

    public final boolean isVisible() {
        try {
            return this.marker.isVisible();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            this.marker.remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setAlign(int i2, int i3) {
        try {
            this.textOptions.align(i2, i3);
            this.marker.setAnchor(cc.a(this.textOptions.getAlignX(), true), cc.a(this.textOptions.getAlignY(), false));
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setBackgroundColor(int i2) {
        try {
            this.textOptions.backgroundColor(i2);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFontColor(int i2) {
        try {
            this.textOptions.fontColor(i2);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFontSize(int i2) {
        try {
            this.textOptions.fontSize(i2);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setObject(Object obj) {
        this.marker.setObject(obj);
    }

    public final void setPosition(LatLng latLng) {
        try {
            this.marker.setPosition(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotate(float f2) {
        try {
            this.marker.setRotateAngle(f2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setText(String str) {
        try {
            this.textOptions.text(str);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTypeface(Typeface typeface) {
        try {
            this.textOptions.typeface(typeface);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z2) {
        try {
            this.marker.setVisible(z2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f2) {
        this.marker.setZIndex(f2);
    }
}
