package com.xeagle.android.newUI.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.cfly.uav_pro.R;

public class RadarSearchView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Paint f24115a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f24116b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f24117c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f24118d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Matrix f24119e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Handler f24120f = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f24121g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Runnable f24122h = new Runnable() {
        public void run() {
            RadarSearchView radarSearchView = RadarSearchView.this;
            int unused = radarSearchView.f24121g = radarSearchView.f24121g + 2;
            Matrix unused2 = RadarSearchView.this.f24119e = new Matrix();
            RadarSearchView.this.f24119e.postRotate((float) RadarSearchView.this.f24121g, (float) (RadarSearchView.this.f24117c / 2), (float) (RadarSearchView.this.f24118d / 2));
            RadarSearchView.this.invalidate();
            RadarSearchView.this.f24120f.postDelayed(RadarSearchView.this.f24122h, 20);
        }
    };

    public RadarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        setBackgroundResource(R.drawable.avchat_call_bg);
        this.f24117c = context.getResources().getDisplayMetrics().widthPixels;
        this.f24118d = context.getResources().getDisplayMetrics().heightPixels;
        this.f24120f.post(this.f24122h);
    }

    private void a() {
        Paint paint = new Paint();
        this.f24115a = paint;
        paint.setColor(Color.parseColor("#A1A1A1"));
        this.f24115a.setStrokeWidth(3.0f);
        this.f24115a.setAntiAlias(true);
        this.f24115a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f24116b = paint2;
        paint2.setColor(-1660879104);
        this.f24116b.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2 = this.f24118d;
        int i3 = this.f24117c;
        if (i2 > i3) {
            canvas.drawCircle((float) (i3 / 2), (float) (i2 / 2), (float) (i3 / 12), this.f24115a);
            int i4 = this.f24117c;
            canvas.drawCircle((float) (i4 / 2), (float) (this.f24118d / 2), (float) ((i4 * 2) / 12), this.f24115a);
            int i5 = this.f24117c;
            canvas.drawCircle((float) (i5 / 2), (float) (this.f24118d / 2), (float) ((i5 * 11) / 40), this.f24115a);
            int i6 = this.f24118d;
            canvas.drawCircle((float) (this.f24117c / 2), (float) (i6 / 2), (float) ((i6 * 7) / 32), this.f24115a);
        } else {
            canvas.drawCircle((float) (i3 / 2), (float) (i2 / 2), (float) (i2 / 12), this.f24115a);
            int i7 = this.f24118d;
            canvas.drawCircle((float) (this.f24117c / 2), (float) (i7 / 2), (float) ((i7 * 2) / 12), this.f24115a);
            int i8 = this.f24118d;
            canvas.drawCircle((float) (this.f24117c / 2), (float) (i8 / 2), (float) ((i8 * 11) / 40), this.f24115a);
            int i9 = this.f24117c;
            canvas.drawCircle((float) (i9 / 2), (float) (this.f24118d / 2), (float) ((i9 * 7) / 32), this.f24115a);
        }
        this.f24116b.setShader(new SweepGradient((float) (this.f24117c / 2), (float) (this.f24118d / 2), 0, Color.parseColor("#AAAAAAAA")));
        canvas.concat(this.f24119e);
        int i10 = this.f24118d;
        int i11 = this.f24117c;
        if (i10 > i11) {
            canvas.drawCircle((float) (i11 / 2), (float) (i10 / 2), (float) ((i10 * 7) / 32), this.f24116b);
        } else {
            canvas.drawCircle((float) (i11 / 2), (float) (i10 / 2), (float) ((i11 * 7) / 32), this.f24116b);
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(this.f24117c, this.f24118d);
    }
}
