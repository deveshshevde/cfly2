package com.xeagle.android.login.listener;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.variables.ListenerData;
import ef.a;
import kh.b;

public class ListenerDrone extends b.a {
    private int flag = 0;
    private int icon = R.drawable.drone_icon1;
    private ListenerData listenerData;
    private String snippet;

    private void updateIcon() {
        int i2;
        int i3 = this.flag;
        if (i3 == 0) {
            this.flag = 1;
            i2 = R.drawable.drone_icon1;
        } else if (i3 == 1) {
            this.flag = 2;
            i2 = R.drawable.drone_icon2;
        } else if (i3 == 2) {
            this.flag = 3;
            i2 = R.drawable.drone_icon3;
        } else {
            this.flag = 0;
            i2 = R.drawable.drone_icon4;
        }
        this.icon = i2;
    }

    public float getAnchorU() {
        return 0.5f;
    }

    public float getAnchorV() {
        return 0.5f;
    }

    public Bitmap getIcon(Resources resources) {
        return BitmapFactory.decodeResource(resources, R.drawable.drone_loc);
    }

    public a getPosition() {
        return this.listenerData.h();
    }

    public float getRotation() {
        return ((float) this.listenerData.g()) - 90.0f;
    }

    public String getTitle() {
        return this.snippet;
    }

    public boolean isDraggable() {
        return false;
    }

    public boolean isFlat() {
        return true;
    }

    public boolean isVisible() {
        return true;
    }

    public void setSnippet(String str) {
        this.snippet = str;
    }

    public void updateListenerData(ListenerData listenerData2) {
        this.listenerData = listenerData2;
    }
}
