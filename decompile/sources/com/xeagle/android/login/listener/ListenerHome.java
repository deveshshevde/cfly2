package com.xeagle.android.login.listener;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cfly.uav_pro.R;
import ef.a;
import kh.b;

public class ListenerHome extends b.a {
    private a coord2D;

    public ListenerHome(a aVar) {
        this.coord2D = aVar;
    }

    public float getAnchorU() {
        return 0.5f;
    }

    public float getAnchorV() {
        return 0.5f;
    }

    public Bitmap getIcon(Resources resources) {
        return BitmapFactory.decodeResource(resources, R.drawable.home_location);
    }

    public a getPosition() {
        return this.coord2D;
    }

    public float getRotation() {
        return 30.0f;
    }

    public String getTitle() {
        return "Launcher";
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

    public void setHomePosition(a aVar) {
        this.coord2D = aVar;
    }
}
