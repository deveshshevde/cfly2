package com.autonavi.base.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.amap.api.mapcore.util.dl;
import java.nio.ByteBuffer;

public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE = -1;
    private int TEXT_FONTSIZE_TRUE = -1;
    private float base_line = 0.0f;
    private float start_x = 0.0f;
    private Paint text_paint = null;

    public TextTextureGenerator() {
        createTextParam();
    }

    public static int GetNearstSize2N(int i2) {
        int i3 = 1;
        while (i2 > i3) {
            i3 *= 2;
        }
        return i3;
    }

    private void createTextParam() {
        float f2;
        int i2 = this.TEXT_FONTSIZE - 2;
        this.TEXT_FONTSIZE_TRUE = i2;
        Paint newPaint = newPaint((String) null, i2, 49);
        this.text_paint = newPaint;
        float f3 = ((float) (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE)) / 2.0f;
        this.start_x = f3;
        float f4 = -27.832031f;
        try {
            Paint.FontMetrics fontMetrics = newPaint.getFontMetrics();
            f2 = fontMetrics.descent;
            try {
                f4 = fontMetrics.ascent;
                float f5 = fontMetrics.top;
                float f6 = fontMetrics.bottom;
                float f7 = fontMetrics.leading;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            f2 = 7.3242188f;
        }
        this.base_line = ((((float) this.TEXT_FONTSIZE_TRUE) - (f2 + f4)) / 2.0f) + f3 + 0.5f;
    }

    public static float getFontHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    private static Paint newPaint(String str, int i2, int i3) {
        Paint.Align align;
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize((float) i2);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        switch (i3) {
            case 50:
                align = Paint.Align.RIGHT;
                break;
            case 51:
                align = Paint.Align.CENTER;
                break;
            default:
                align = Paint.Align.LEFT;
                break;
        }
        textPaint.setTextAlign(align);
        return textPaint;
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        float[] fArr = new float[1];
        for (int i2 = 0; i2 < length; i2++) {
            Paint paint = this.text_paint;
            StringBuilder sb = new StringBuilder();
            sb.append((char) iArr[i2]);
            fArr[0] = paint.measureText(sb.toString());
            bArr[i2] = (byte) ((int) (fArr[0] + ((float) (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE))));
        }
        return bArr;
    }

    public byte[] getTextPixelBuffer(int i2, int i3) {
        if (this.TEXT_FONTSIZE != i3) {
            this.TEXT_FONTSIZE = i3;
            createTextParam();
        }
        try {
            char c2 = (char) i2;
            char[] cArr = {c2};
            float f2 = this.base_line;
            int i4 = this.TEXT_FONTSIZE;
            Bitmap createBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            int i5 = this.TEXT_FONTSIZE;
            byte[] bArr = new byte[(i5 * i5)];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.text_paint.measureText(String.valueOf(c2));
            if (cArr[0] > 0 && cArr[0] < 256) {
                f2 -= 1.5f;
            }
            float f3 = f2;
            Paint.Align textAlign = this.text_paint.getTextAlign();
            float textSize = this.text_paint.getTextSize();
            float f4 = measureText - ((float) this.TEXT_FONTSIZE_TRUE);
            if (textAlign == Paint.Align.CENTER || f4 < 4.0f) {
                canvas.drawText(cArr, 0, 1, this.start_x, f3, this.text_paint);
            } else {
                this.text_paint.setTextAlign(Paint.Align.CENTER);
                this.text_paint.setTextSize(((float) this.TEXT_FONTSIZE_TRUE) - f4);
                canvas.drawText(cArr, 0, 1, (((float) this.TEXT_FONTSIZE_TRUE) - f4) / 2.0f, f3, this.text_paint);
                this.text_paint.setTextAlign(textAlign);
                this.text_paint.setTextSize(textSize);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            dl.a(createBitmap);
            return bArr;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }
}
