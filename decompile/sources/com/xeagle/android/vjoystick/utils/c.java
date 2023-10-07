package com.xeagle.android.vjoystick.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.i;
import com.bumptech.glide.request.h;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.utils.transformation.f;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static Bitmap f25363a;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f25364a = new c();
    }

    public static c a() {
        return a.f25364a;
    }

    public void a(Context context, Object obj, ImageView imageView, int i2, int i3) {
        h hVar = new h();
        if (i2 != 0) {
            hVar.a(i2);
        }
        if (i3 != 0) {
            hVar.b(i3);
        }
        hVar.i();
        hVar.c(200, 200);
        com.bumptech.glide.c.b(context).a(obj).a(0.2f).b((com.bumptech.glide.request.a<?>) hVar).a(imageView);
    }

    public void a(Context context, Object obj, ImageView imageView, int i2, int i3, int i4, boolean z2) {
        h hVar = new h();
        if (i2 != 0) {
            hVar.a(i2);
        }
        if (i3 != 0) {
            hVar.b(i3);
        }
        if (i4 >= 50) {
            hVar.a((int) R.drawable.ic_launcher);
            hVar.b((int) R.drawable.ic_launcher);
        }
        hVar.a((i<Bitmap>) new d(new com.bumptech.glide.load.resource.bitmap.i(), new f(context, i4)));
        if (z2) {
            hVar.a(com.bumptech.glide.load.engine.h.f10301a);
            hVar.b(false);
        } else {
            hVar.b(true);
            hVar.a(com.bumptech.glide.load.engine.h.f10302b);
        }
        com.bumptech.glide.c.b(context).a(obj).a(0.2f).b((com.bumptech.glide.request.a<?>) hVar).a(imageView);
    }

    public void a(Context context, Object obj, ImageView imageView, int i2, int i3, boolean z2) {
        h hVar = new h();
        if (i2 != 0) {
            hVar.a(i2);
        }
        if (i3 != 0) {
            hVar.b(i3);
        }
        if (z2) {
            hVar.a(com.bumptech.glide.load.engine.h.f10301a);
            hVar.b(false);
        } else {
            hVar.b(true);
            hVar.a(com.bumptech.glide.load.engine.h.f10302b);
        }
        hVar.i();
        com.bumptech.glide.c.b(context).a(obj).a(0.2f).b((com.bumptech.glide.request.a<?>) hVar).a(imageView);
    }
}
