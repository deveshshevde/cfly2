package com.autonavi.base.amap.mapcore;

import android.graphics.Rect;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.IPoint;

public class Rectangle {
    private int beyond180Mode = 0;
    public float bottom;
    public FPoint[] clipMapRect = null;
    public IPoint[] clipRect = null;
    private int[] jniClipRect = new int[8];
    public float left;
    public Rect rect = new Rect();
    public float right;
    public float top;

    public Rectangle() {
    }

    public Rectangle(float f2, float f3, float f4, float f5) {
        if (f2 < f3 && f5 > f4) {
            this.left = f2;
            this.right = f3;
            this.top = f5;
            this.bottom = f4;
        }
    }

    public Rectangle(Rect rect2, int i2, int i3) {
        this.rect = rect2;
        if (rect2 != null) {
            updateRect(rect2, i2, i3);
            updateClipRect();
            updateClipMapRect(rect2.centerX(), rect2.centerY());
        }
    }

    private void updateClipMapRect(int i2, int i3) {
        int i4 = 0;
        if (this.clipMapRect == null) {
            FPoint[] fPointArr = new FPoint[4];
            this.clipMapRect = fPointArr;
            fPointArr[0] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[1] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[2] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[3] = FPoint.obtain(0.0f, 0.0f);
        }
        Rect rect2 = this.rect;
        if (rect2 != null) {
            this.clipMapRect[0].x = (float) (rect2.left - i2);
            this.clipMapRect[0].y = (float) (this.rect.top - i3);
            this.clipMapRect[1].x = (float) (this.rect.right - i2);
            this.clipMapRect[1].y = (float) (this.rect.top - i3);
            this.clipMapRect[2].x = (float) (this.rect.right - i2);
            this.clipMapRect[2].y = (float) (this.rect.bottom - i3);
            this.clipMapRect[3].x = (float) (this.rect.left - i2);
            this.clipMapRect[3].y = (float) (this.rect.bottom - i3);
        }
        if (this.jniClipRect == null) {
            this.jniClipRect = new int[(this.clipMapRect.length * 2)];
        }
        while (true) {
            FPoint[] fPointArr2 = this.clipMapRect;
            if (i4 < fPointArr2.length) {
                int i5 = i4 * 2;
                this.jniClipRect[i5] = (int) fPointArr2[i4].x;
                this.jniClipRect[i5 + 1] = (int) this.clipMapRect[i4].y;
                i4++;
            } else {
                return;
            }
        }
    }

    private void updateClipRect() {
        if (this.clipRect == null) {
            IPoint[] iPointArr = new IPoint[4];
            this.clipRect = iPointArr;
            iPointArr[0] = IPoint.obtain(0, 0);
            this.clipRect[1] = IPoint.obtain(0, 0);
            this.clipRect[2] = IPoint.obtain(0, 0);
            this.clipRect[3] = IPoint.obtain(0, 0);
        }
        Rect rect2 = this.rect;
        if (rect2 != null) {
            this.clipRect[0].x = rect2.left;
            this.clipRect[0].y = this.rect.top;
            this.clipRect[1].x = this.rect.right;
            this.clipRect[1].y = this.rect.top;
            this.clipRect[2].x = this.rect.right;
            this.clipRect[2].y = this.rect.bottom;
            this.clipRect[3].x = this.rect.left;
            this.clipRect[3].y = this.rect.bottom;
        }
    }

    public boolean contains(int i2, int i3) {
        Rect rect2 = this.rect;
        if (rect2 == null) {
            return false;
        }
        if (rect2.contains(i2, i3)) {
            return true;
        }
        if (this.beyond180Mode != 0) {
            return this.rect.contains(i2 - AMapEngineUtils.MAX_P20_WIDTH, i3) || this.rect.contains(i2 + AMapEngineUtils.MAX_P20_WIDTH, i3);
        }
        return false;
    }

    public boolean contains(Rect rect2) {
        if (rect2 == null) {
            return false;
        }
        return this.rect.contains(rect2);
    }

    public boolean contains(IPoint iPoint) {
        if (iPoint == null) {
            return false;
        }
        return contains(iPoint.x, iPoint.y);
    }

    public int getBeyond180Mode() {
        return this.beyond180Mode;
    }

    public FPoint[] getClipMapRect() {
        return this.clipMapRect;
    }

    public IPoint[] getClipRect() {
        return this.clipRect;
    }

    public Rect getRect() {
        return this.rect;
    }

    public boolean isOverlap(int i2, int i3, int i4, int i5) {
        Rect rect2 = this.rect;
        return rect2 != null && rect2.left + this.rect.width() > i2 && i2 + i4 > this.rect.left && this.rect.top + this.rect.height() > i3 && i3 + i5 > this.rect.top;
    }

    public boolean isOverlap(Rect rect2) {
        Rect rect3 = this.rect;
        return rect3 != null && rect2 != null && rect3.left + this.rect.width() > rect2.left && rect2.left + rect2.width() > this.rect.left && this.rect.top + this.rect.height() > rect2.top && rect2.top + rect2.height() > this.rect.top;
    }

    public void updateRect(Rect rect2, int i2, int i3) {
        if (rect2 != null) {
            this.rect = rect2;
            rect2.inset((-rect2.width()) / 8, (-rect2.height()) / 8);
            this.beyond180Mode = (((float) this.rect.left) / 100000.0f) * (((float) this.rect.right) / 100000.0f) < 0.0f ? -1 : this.rect.right > 268435456 ? 1 : 0;
            updateClipRect();
            updateClipMapRect(i2, i3);
        }
    }
}
