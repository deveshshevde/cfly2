package com.amap.api.mapcore.util;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import com.amap.api.mapcore.util.dt;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

public interface dw extends IInfoWindowAction {
    float a(int i2);

    Point a();

    void a(Canvas canvas);

    void a(dt.a aVar);

    void a(CameraPosition cameraPosition);

    void a(Boolean bool);

    void a(Float f2);

    void a(Integer num);

    void a(Integer num, Float f2);

    void a(String str, Boolean bool, Integer num);

    void a(boolean z2);

    void b(Boolean bool);

    void b(Integer num);

    boolean b();

    void c();

    void c(Boolean bool);

    void c(Integer num);

    dr d();

    void d(Boolean bool);

    void d(Integer num);

    dt e();

    void e(Boolean bool);

    dz f();

    void f(Boolean bool);

    void g();

    void g(Boolean bool);

    void h();

    void h(Boolean bool);

    void i();

    void i(Boolean bool);

    View j();
}
