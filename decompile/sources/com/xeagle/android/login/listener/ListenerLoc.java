package com.xeagle.android.login.listener;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.variables.ListenerData;
import ef.a;
import kh.b;

public class ListenerLoc extends b.a {
    private ListenerData listenerData;

    public float getAnchorU() {
        return 0.5f;
    }

    public float getAnchorV() {
        return 0.5f;
    }

    public Bitmap getIcon(Resources resources) {
        return BitmapFactory.decodeResource(resources, R.drawable.user_location);
    }

    public a getPosition() {
        return this.listenerData.i();
    }

    public float getRotation() {
        return (float) this.listenerData.g();
    }

    public boolean isFlat() {
        return true;
    }

    public boolean isVisible() {
        return true;
    }

    public void updateListenerData(ListenerData listenerData2) {
        this.listenerData = listenerData2;
    }
}
