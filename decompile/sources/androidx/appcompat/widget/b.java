package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f1453a;

    public b(ActionBarContainer actionBarContainer) {
        this.f1453a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        if (!this.f1453a.f975d) {
            if (this.f1453a.f972a != null) {
                this.f1453a.f972a.draw(canvas);
            }
            if (this.f1453a.f973b != null && this.f1453a.f976e) {
                drawable = this.f1453a.f973b;
            } else {
                return;
            }
        } else if (this.f1453a.f974c != null) {
            drawable = this.f1453a.f974c;
        } else {
            return;
        }
        drawable.draw(canvas);
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        Drawable drawable;
        if (this.f1453a.f975d) {
            if (this.f1453a.f974c != null) {
                drawable = this.f1453a.f974c;
            } else {
                return;
            }
        } else if (this.f1453a.f972a != null) {
            drawable = this.f1453a.f972a;
        } else {
            return;
        }
        drawable.getOutline(outline);
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
