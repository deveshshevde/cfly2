package kh;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class c {
    public static Bitmap a(int i2, String str, String str2, Resources resources) {
        return a(resources, i2, str, str2);
    }

    private static Bitmap a(Resources resources, int i2, String str, String str2) {
        Rect rect;
        float f2 = resources.getDisplayMetrics().density;
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i2);
        Bitmap.Config config = decodeResource.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap copy = decodeResource.copy(config, true);
        Paint paint = new Paint();
        Canvas canvas = new Canvas(copy);
        canvas.drawBitmap(copy, 0.0f, 0.0f, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setTextSize((float) ((int) (8.0f * f2)));
        paint2.setFakeBoldText(true);
        paint2.setShadowLayer(1.0f, 0.0f, 1.0f, -16777216);
        Rect rect2 = new Rect();
        paint2.getTextBounds(str, 0, str.length(), rect2);
        rect2.offsetTo(-6, rect2.height() / 2);
        Paint paint3 = new Paint(1);
        paint3.setColor(-1);
        paint3.setTextSize((float) ((int) (f2 * 10.0f)));
        paint2.setFakeBoldText(true);
        paint3.setShadowLayer(1.0f, 0.0f, 1.0f, -16777216);
        if (str2 != null) {
            paint3.getTextBounds(str2, 0, str2.length(), rect);
            rect.offsetTo(0, rect2.bottom + 2);
        } else {
            rect = new Rect(0, 0, 0, 0);
        }
        Rect rect3 = new Rect(rect2);
        rect3.union(rect);
        rect3.offsetTo((copy.getWidth() - rect3.width()) / 2, (rect2.top + ((copy.getHeight() - rect3.height()) / 2)) - rect2.height());
        rect3.set(rect3.left - 6, rect3.top - 6, rect3.right + 6, rect3.bottom + 6);
        int height = rect2.top + ((copy.getHeight() - (rect2.height() + rect.height())) / 2);
        canvas.drawText(str, (float) ((copy.getWidth() - rect2.width()) / 2), (float) height, paint2);
        if (str2 != null) {
            canvas.drawText(str2, (float) ((copy.getWidth() - rect.width()) / 2), (float) (height + rect2.height() + 2), paint3);
        }
        return copy;
    }
}
