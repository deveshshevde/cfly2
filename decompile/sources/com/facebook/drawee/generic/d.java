package com.facebook.drawee.generic;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.q;
import com.facebook.drawee.drawable.r;

public class d extends g implements q {

    /* renamed from: a  reason: collision with root package name */
    Drawable f11296a = null;

    /* renamed from: c  reason: collision with root package name */
    private r f11297c;

    public d(Drawable drawable) {
        super(drawable);
    }

    public void a(r rVar) {
        this.f11297c = rVar;
    }

    public void d(Drawable drawable) {
        this.f11296a = drawable;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (isVisible()) {
            r rVar = this.f11297c;
            if (rVar != null) {
                rVar.a();
            }
            super.draw(canvas);
            Drawable drawable = this.f11296a;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.f11296a.draw(canvas);
            }
        }
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public boolean setVisible(boolean z2, boolean z3) {
        r rVar = this.f11297c;
        if (rVar != null) {
            rVar.a(z2);
        }
        return super.setVisible(z2, z3);
    }
}
