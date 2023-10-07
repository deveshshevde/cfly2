package com.google.android.exoplayer2.ui.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import ge.c;

final class a implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f16870a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f16871b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private final float[] f16872c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f16873d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    private final Display f16874e;

    /* renamed from: f  reason: collision with root package name */
    private final C0117a[] f16875f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16876g;

    /* renamed from: com.google.android.exoplayer2.ui.spherical.a$a  reason: collision with other inner class name */
    public interface C0117a {
        void a(float[] fArr, float f2);
    }

    public a(Display display, C0117a... aVarArr) {
        this.f16874e = display;
        this.f16875f = aVarArr;
    }

    private void a(float[] fArr) {
        if (!this.f16876g) {
            c.a(this.f16872c, fArr);
            this.f16876g = true;
        }
        float[] fArr2 = this.f16871b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f16871b, 0, this.f16872c, 0);
    }

    private void a(float[] fArr, float f2) {
        for (C0117a a2 : this.f16875f) {
            a2.a(fArr, f2);
        }
    }

    private void a(float[] fArr, int i2) {
        if (i2 != 0) {
            int i3 = IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR;
            int i4 = IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN;
            if (i2 == 1) {
                i3 = 2;
            } else if (i2 == 2) {
                i3 = IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN;
                i4 = IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR;
            } else if (i2 == 3) {
                i4 = 1;
            } else {
                throw new IllegalStateException();
            }
            float[] fArr2 = this.f16871b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f16871b, i3, i4, fArr);
        }
    }

    private float b(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, this.f16871b);
        SensorManager.getOrientation(this.f16871b, this.f16873d);
        return this.f16873d[2];
    }

    private static void c(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f16870a, sensorEvent.values);
        a(this.f16870a, this.f16874e.getRotation());
        float b2 = b(this.f16870a);
        c(this.f16870a);
        a(this.f16870a);
        a(this.f16870a, b2);
    }
}
