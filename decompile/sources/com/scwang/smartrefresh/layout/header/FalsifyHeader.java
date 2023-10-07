package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.constant.MemoryConstants;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import ja.g;
import ja.i;
import ja.j;
import jc.b;

public class FalsifyHeader extends InternalAbstract implements g {

    /* renamed from: a  reason: collision with root package name */
    protected i f21564a;

    public FalsifyHeader(Context context) {
        this(context, (AttributeSet) null);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void a(i iVar, int i2, int i3) {
        this.f21564a = iVar;
    }

    public void a(j jVar, int i2, int i3) {
        i iVar = this.f21564a;
        if (iVar != null) {
            iVar.a(RefreshState.None);
            this.f21564a.a(RefreshState.RefreshFinish);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int a2 = b.a(5.0f);
            Context context = getContext();
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-858993460);
            paint.setStrokeWidth((float) b.a(1.0f));
            float f2 = (float) a2;
            paint.setPathEffect(new DashPathEffect(new float[]{f2, f2, f2, f2}, 1.0f));
            canvas.drawRect(f2, f2, (float) (getWidth() - a2), (float) (getBottom() - a2), paint);
            TextView textView = new TextView(context);
            textView.setText(context.getString(R.string.srl_component_falsify, new Object[]{getClass().getSimpleName(), Float.valueOf(b.a(getHeight()))}));
            textView.setTextColor(-858993460);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(getHeight(), MemoryConstants.GB));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }
}
