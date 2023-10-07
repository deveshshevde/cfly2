package com.amap.api.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.WearMapView;

public class SwipeDismissView extends RelativeLayout {
    protected WearMapView.OnDismissCallback onDismissCallback = null;

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i2, View view) {
        super(context, attributeSet, i2);
        setOnTouchListener(view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        setOnTouchListener(view);
    }

    public SwipeDismissView(Context context, View view) {
        super(context);
        setOnTouchListener(view);
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback2) {
        this.onDismissCallback = onDismissCallback2;
    }

    /* access modifiers changed from: protected */
    public void setOnTouchListener(View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new SwipeDismissCallBack(this)));
    }
}
