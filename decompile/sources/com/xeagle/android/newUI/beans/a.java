package com.xeagle.android.newUI.beans;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.listener.ListenerHome;

public class a extends ListenerHome {

    /* renamed from: a  reason: collision with root package name */
    private String f23936a;

    public a(ef.a aVar) {
        super(aVar);
    }

    public void a(String str) {
        this.f23936a = str;
    }

    public Bitmap getIcon(Resources resources) {
        return BitmapFactory.decodeResource(resources, R.drawable.drone_loc);
    }

    public String getTitle() {
        return this.f23936a;
    }
}
