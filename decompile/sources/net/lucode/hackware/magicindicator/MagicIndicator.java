package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import mx.a;

public class MagicIndicator extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private a f31419a;

    public MagicIndicator(Context context) {
        super(context);
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(int i2) {
        a aVar = this.f31419a;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void a(int i2, float f2, int i3) {
        a aVar = this.f31419a;
        if (aVar != null) {
            aVar.a(i2, f2, i3);
        }
    }

    public void b(int i2) {
        a aVar = this.f31419a;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    public a getNavigator() {
        return this.f31419a;
    }

    public void setNavigator(a aVar) {
        a aVar2 = this.f31419a;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.b();
            }
            this.f31419a = aVar;
            removeAllViews();
            if (this.f31419a instanceof View) {
                addView((View) this.f31419a, new FrameLayout.LayoutParams(-1, -1));
                this.f31419a.a();
            }
        }
    }
}
