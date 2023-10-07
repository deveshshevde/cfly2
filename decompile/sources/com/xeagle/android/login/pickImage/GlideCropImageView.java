package com.xeagle.android.login.pickImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class GlideCropImageView extends CropImageView {
    public GlideCropImageView(Context context) {
        super(context);
    }

    public GlideCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GlideCropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private static Bitmap fromDrawable(Drawable drawable) {
        try {
            if (drawable.getIntrinsicWidth() * drawable.getIntrinsicHeight() == 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Bitmap getBitmap() {
        Drawable drawable = getDrawable();
        return drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : fromDrawable(drawable);
    }
}
