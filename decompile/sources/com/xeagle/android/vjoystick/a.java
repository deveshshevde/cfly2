package com.xeagle.android.vjoystick;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class a implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f24944a;

    /* renamed from: b  reason: collision with root package name */
    private Sensor f24945b;

    /* renamed from: c  reason: collision with root package name */
    private C0152a f24946c;

    /* renamed from: d  reason: collision with root package name */
    private Context f24947d;

    /* renamed from: e  reason: collision with root package name */
    private float f24948e;

    /* renamed from: f  reason: collision with root package name */
    private float f24949f;

    /* renamed from: g  reason: collision with root package name */
    private float f24950g;

    /* renamed from: h  reason: collision with root package name */
    private long f24951h;

    /* renamed from: com.xeagle.android.vjoystick.a$a  reason: collision with other inner class name */
    public interface C0152a {
        void onSensor(float f2, float f3, float f4);
    }

    public a(Context context) {
        this.f24947d = context;
    }

    public void a() {
        SensorManager sensorManager;
        if (this.f24944a == null) {
            this.f24944a = (SensorManager) this.f24947d.getSystemService("sensor");
        }
        SensorManager sensorManager2 = this.f24944a;
        if (sensorManager2 != null && this.f24945b == null) {
            this.f24945b = sensorManager2.getDefaultSensor(1);
        }
        Sensor sensor = this.f24945b;
        if (sensor != null && (sensorManager = this.f24944a) != null) {
            sensorManager.registerListener(this, sensor, 1);
        }
    }

    public void a(C0152a aVar) {
        this.f24946c = aVar;
    }

    public void b() {
        SensorManager sensorManager = this.f24944a;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        C0152a aVar;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.f24951h;
        if (j2 >= 20) {
            this.f24951h = currentTimeMillis;
            float f2 = sensorEvent.values[0];
            float f3 = sensorEvent.values[1];
            float f4 = sensorEvent.values[2];
            float f5 = f2 - this.f24948e;
            float f6 = f3 - this.f24949f;
            float f7 = f4 - this.f24950g;
            this.f24948e = f2;
            this.f24949f = f3;
            this.f24950g = f4;
            double sqrt = Math.sqrt((double) ((f5 * f5) + (f6 * f6) + (f7 * f7)));
            double d2 = (double) j2;
            Double.isNaN(d2);
            if ((sqrt / d2) * 10000.0d >= 100.0d && (aVar = this.f24946c) != null) {
                aVar.onSensor(f2, f3, f4);
            }
        }
    }
}
