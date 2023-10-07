package com.xeagle.android.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import java.util.Arrays;

public class ProgressView extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    RectF f25618a;

    /* renamed from: b  reason: collision with root package name */
    Paint f25619b;

    /* renamed from: c  reason: collision with root package name */
    int f25620c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f25621d = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;

    /* renamed from: e  reason: collision with root package name */
    int f25622e = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;

    /* renamed from: f  reason: collision with root package name */
    int[] f25623f = {0, 0, 0};

    /* renamed from: g  reason: collision with root package name */
    boolean f25624g = false;

    /* renamed from: h  reason: collision with root package name */
    int f25625h = 1;

    /* renamed from: i  reason: collision with root package name */
    final int[][] f25626i = {new int[]{224, 187, 63}, new int[]{224, 46, 25}, new int[]{39, 105, 227}, new int[]{51, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, 49}};

    public ProgressView(Context context) {
        super(context.getApplicationContext());
        a();
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        a();
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context.getApplicationContext(), attributeSet, i2);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f25619b = paint;
        paint.setStrokeWidth(6.0f);
        this.f25619b.setStrokeCap(Paint.Cap.ROUND);
        this.f25619b.setAntiAlias(true);
        this.f25619b.setStyle(Paint.Style.STROKE);
        Paint paint2 = this.f25619b;
        int[][] iArr = this.f25626i;
        paint2.setColor(Color.argb(255, iArr[0][0], iArr[0][1], iArr[0][2]));
        int[][] iArr2 = this.f25626i;
        this.f25623f = Arrays.copyOf(iArr2[0], iArr2[0].length);
    }

    private void a(int i2) {
        int[] iArr = this.f25623f;
        int i3 = iArr[i2];
        int[][] iArr2 = this.f25626i;
        int i4 = this.f25625h;
        if (i3 > iArr2[i4][i2]) {
            iArr[i2] = iArr[i2] - 1;
        }
        if (iArr[i2] < iArr2[i4][i2]) {
            iArr[i2] = iArr[i2] + 1;
        }
    }

    private void b() {
        a(0);
        a(1);
        a(2);
        int[] iArr = this.f25623f;
        int i2 = iArr[0];
        int[][] iArr2 = this.f25626i;
        int i3 = this.f25625h;
        if (i2 != iArr2[i3][0] || iArr[1] != iArr2[i3][1] || iArr[2] != iArr2[i3][2]) {
            return;
        }
        if (i3 == 3) {
            this.f25625h = 0;
        } else {
            this.f25625h = i3 + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z2 = this.f25624g;
        int i2 = this.f25620c;
        this.f25620c = z2 ? i2 + 15 : i2 + 5;
        if (this.f25620c == 360) {
            this.f25620c = 1;
        }
        int i3 = this.f25622e;
        this.f25622e = !z2 ? i3 - 10 : i3 + 10;
        int i4 = this.f25622e;
        if (i4 == 0 || i4 == this.f25621d) {
            this.f25624g = !z2;
        }
        b();
        Paint paint = this.f25619b;
        int[] iArr = this.f25623f;
        paint.setColor(Color.argb(255, iArr[0], iArr[1], iArr[2]));
        canvas.drawArc(this.f25618a, (float) this.f25620c, (float) (this.f25621d - this.f25622e), false, this.f25619b);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f25618a = new RectF(5.0f, 5.0f, (float) (i2 - 5), (float) (i3 - 5));
    }
}
