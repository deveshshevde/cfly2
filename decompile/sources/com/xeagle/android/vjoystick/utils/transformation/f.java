package com.xeagle.android.vjoystick.utils.transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import bl.e;
import cc.l;
import dd.a;
import java.security.MessageDigest;

public class f extends com.bumptech.glide.load.resource.bitmap.f {

    /* renamed from: b  reason: collision with root package name */
    private final String f25393b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    private int f25394c;

    public f(Context context, int i2) {
        this.f25394c = a.f26693a.a((float) i2);
    }

    /* access modifiers changed from: protected */
    public Bitmap a(e eVar, Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap a2 = eVar.a(width, height, Bitmap.Config.ARGB_8888);
        a2.setHasAlpha(true);
        Canvas canvas = new Canvas(a2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
        int i4 = this.f25394c;
        canvas.drawRoundRect(rectF, (float) i4, (float) i4, paint);
        return a2;
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update((this.f25393b + this.f25394c).getBytes(f10157a));
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f25394c == ((f) obj).f25394c;
    }

    public int hashCode() {
        return l.b(this.f25393b.hashCode(), l.b(this.f25394c));
    }
}
