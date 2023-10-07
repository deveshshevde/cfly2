package org.opencv.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import java.text.DecimalFormat;
import org.opencv.core.Core;

public class e {

    /* renamed from: e  reason: collision with root package name */
    private static final DecimalFormat f34044e = new DecimalFormat("0.00");

    /* renamed from: a  reason: collision with root package name */
    Paint f34045a;

    /* renamed from: b  reason: collision with root package name */
    boolean f34046b = false;

    /* renamed from: c  reason: collision with root package name */
    int f34047c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f34048d = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f34049f;

    /* renamed from: g  reason: collision with root package name */
    private double f34050g;

    /* renamed from: h  reason: collision with root package name */
    private long f34051h;

    /* renamed from: i  reason: collision with root package name */
    private String f34052i;

    public void a() {
        this.f34049f = 0;
        this.f34050g = Core.c();
        this.f34051h = Core.b();
        this.f34052i = "";
        Paint paint = new Paint();
        this.f34045a = paint;
        paint.setColor(-16776961);
        this.f34045a.setTextSize(20.0f);
    }

    public void a(int i2, int i3) {
        this.f34047c = i2;
        this.f34048d = i3;
    }

    public void a(Canvas canvas, float f2, float f3) {
        Log.d("FpsMeter", this.f34052i);
        canvas.drawText(this.f34052i, f2, f3, this.f34045a);
    }

    public void b() {
        StringBuilder sb;
        if (!this.f34046b) {
            a();
            this.f34046b = true;
            return;
        }
        int i2 = this.f34049f + 1;
        this.f34049f = i2;
        if (i2 % 20 == 0) {
            long b2 = Core.b();
            double d2 = (double) (b2 - this.f34051h);
            Double.isNaN(d2);
            double d3 = (this.f34050g * 20.0d) / d2;
            this.f34051h = b2;
            if (this.f34047c == 0 || this.f34048d == 0) {
                sb = new StringBuilder();
                sb.append(f34044e.format(d3));
                sb.append(" FPS");
            } else {
                sb = new StringBuilder();
                sb.append(f34044e.format(d3));
                sb.append(" FPS@");
                sb.append(Integer.valueOf(this.f34047c));
                sb.append("x");
                sb.append(Integer.valueOf(this.f34048d));
            }
            this.f34052i = sb.toString();
            Log.i("FpsMeter", this.f34052i);
        }
    }
}
