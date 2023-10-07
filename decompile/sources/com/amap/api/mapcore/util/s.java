package com.amap.api.mapcore.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public final class s implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f9685a;

    /* renamed from: b  reason: collision with root package name */
    private Sensor f9686b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f9687c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public float f9688d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f9689e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public IAMapDelegate f9690f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Marker f9691g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f9692h = true;

    public s(Context context, IAMapDelegate iAMapDelegate) {
        this.f9689e = context.getApplicationContext();
        this.f9690f = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f9685a = sensorManager;
            if (sensorManager != null) {
                this.f9686b = sensorManager.getDefaultSensor(3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int a(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        try {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation == 1) {
                return 90;
            }
            if (rotation != 2) {
                return rotation != 3 ? 0 : -90;
            }
            return 180;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final void a() {
        Sensor sensor;
        SensorManager sensorManager = this.f9685a;
        if (sensorManager != null && (sensor = this.f9686b) != null) {
            sensorManager.registerListener(this, sensor, 3);
        }
    }

    public final void a(Marker marker) {
        this.f9691g = marker;
    }

    public final void a(boolean z2) {
        this.f9692h = z2;
    }

    public final void b() {
        Sensor sensor;
        SensorManager sensorManager = this.f9685a;
        if (sensorManager != null && (sensor = this.f9686b) != null) {
            sensorManager.unregisterListener(this, sensor);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(final SensorEvent sensorEvent) {
        try {
            if (System.currentTimeMillis() - this.f9687c >= 100) {
                if (this.f9690f.getGLMapEngine() == null || this.f9690f.getGLMapEngine().getAnimateionsCount() <= 0) {
                    dj.a().a(new ie() {
                        public final void runTask() {
                            if (sensorEvent.sensor.getType() == 3) {
                                float a2 = (sensorEvent.values[0] + ((float) s.a(s.this.f9689e))) % 360.0f;
                                if (a2 > 180.0f) {
                                    a2 -= 360.0f;
                                } else if (a2 < -180.0f) {
                                    a2 += 360.0f;
                                }
                                if (Math.abs(s.this.f9688d - a2) >= 3.0f) {
                                    s sVar = s.this;
                                    if (Float.isNaN(a2)) {
                                        a2 = 0.0f;
                                    }
                                    float unused = sVar.f9688d = a2;
                                    if (s.this.f9691g != null) {
                                        try {
                                            if (s.this.f9692h) {
                                                s.this.f9690f.moveCamera(z.d(s.this.f9688d));
                                                s.this.f9691g.setRotateAngle(-s.this.f9688d);
                                            } else {
                                                s.this.f9691g.setRotateAngle(360.0f - s.this.f9688d);
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                    long unused2 = s.this.f9687c = System.currentTimeMillis();
                                }
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
