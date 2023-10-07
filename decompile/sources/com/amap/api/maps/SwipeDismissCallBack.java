package com.amap.api.maps;

import android.view.View;
import com.amap.api.maps.SwipeDismissTouchListener;

public class SwipeDismissCallBack implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a  reason: collision with root package name */
    SwipeDismissView f9722a;

    public SwipeDismissCallBack(SwipeDismissView swipeDismissView) {
        this.f9722a = swipeDismissView;
    }

    public boolean canDismiss(Object obj) {
        return true;
    }

    public void onDismiss(View view, Object obj) {
        if (this.f9722a.onDismissCallback != null) {
            this.f9722a.onDismissCallback.onDismiss();
        }
    }

    public void onNotifySwipe() {
        if (this.f9722a.onDismissCallback != null) {
            this.f9722a.onDismissCallback.onNotifySwipe();
        }
    }
}
