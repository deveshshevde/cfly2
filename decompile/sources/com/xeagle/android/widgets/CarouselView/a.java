package com.xeagle.android.widgets.CarouselView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;

public class a {
    public static Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.preScale(1.0f, -1.0f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height / 2, width, height / 2, matrix, false);
            Bitmap createBitmap2 = Bitmap.createBitmap(width, (height / 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            float f2 = (float) height;
            float f3 = (float) width;
            float f4 = (float) (height + 1);
            canvas.drawRect(0.0f, f2, f3, f4, new Paint());
            canvas.drawBitmap(createBitmap, 0.0f, f4, (Paint) null);
            Paint paint = new Paint();
            paint.setShader(new LinearGradient(0.0f, (float) bitmap.getHeight(), 0.0f, (float) (createBitmap2.getHeight() + 1), 1895825407, 16777215, Shader.TileMode.CLAMP));
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawRect(0.0f, f2, f3, (float) (createBitmap2.getHeight() + 1), paint);
            return createBitmap2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bitmap2;
        }
    }
}
