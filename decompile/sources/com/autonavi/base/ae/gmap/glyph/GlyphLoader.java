package com.autonavi.base.ae.gmap.glyph;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import java.nio.ByteBuffer;

public class GlyphLoader {
    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    private static String decodeUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static String decodeUnicode(short s2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char) s2);
        return stringBuffer.toString();
    }

    public static void destroyGlyphLoader(long j2) {
        nativeDestroyGlyphLoader(j2);
    }

    private static FontMetricsRequestParam genFontMetricsParam(byte[] bArr) {
        FontMetricsRequestParam fontMetricsRequestParam = new FontMetricsRequestParam();
        fontMetricsRequestParam.fFontSize = ((float) GLConvertUtil.getInt(bArr, 0)) * 0.001f;
        fontMetricsRequestParam.nFontStyleCode = GLConvertUtil.getInt(bArr, 4);
        int i2 = 12;
        if (1 == GLConvertUtil.getInt(bArr, 8)) {
            int i3 = GLConvertUtil.getInt(bArr, 12);
            fontMetricsRequestParam.strName = new String(bArr, 16, i3);
            i2 = i3 + 16;
        }
        fontMetricsRequestParam.languageArr = new String(bArr, i2 + 4, GLConvertUtil.getInt(bArr, i2));
        return fontMetricsRequestParam;
    }

    private static GlyphRequestParam genGlyphRequestParam(byte[] bArr) {
        GlyphRequestParam glyphRequestParam = new GlyphRequestParam();
        int i2 = GLConvertUtil.getInt(bArr, 0);
        glyphRequestParam.strBuffer = new String(bArr, 4, i2);
        int i3 = i2 + 4;
        Font font = new Font();
        font.nFontStyleCode = GLConvertUtil.getInt(bArr, i3);
        int i4 = i3 + 4;
        font.nFontSize = GLConvertUtil.getInt(bArr, i4);
        int i5 = i4 + 4;
        int i6 = GLConvertUtil.getInt(bArr, i5);
        int i7 = i5 + 4;
        font.strName = new String(bArr, i7, i6);
        int i8 = i7 + i6;
        FontMetrics fontMetrics = new FontMetrics();
        int i9 = GLConvertUtil.getInt(bArr, i8);
        int i10 = i8 + 4;
        fontMetrics.fAscent = ((float) i9) * 0.001f;
        int i11 = GLConvertUtil.getInt(bArr, i10);
        int i12 = i10 + 4;
        fontMetrics.fDescent = ((float) i11) * 0.001f;
        int i13 = GLConvertUtil.getInt(bArr, i12);
        int i14 = i12 + 4;
        fontMetrics.fLeading = ((float) i13) * 0.001f;
        int i15 = GLConvertUtil.getInt(bArr, i14);
        int i16 = i14 + 4;
        fontMetrics.fHeight = ((float) i15) * 0.001f;
        font.fontMetrics = fontMetrics;
        glyphRequestParam.font = font;
        glyphRequestParam.drawingMode = GLConvertUtil.getInt(bArr, i16);
        int i17 = i16 + 4;
        int i18 = GLConvertUtil.getInt(bArr, i17);
        int i19 = i17 + 4;
        glyphRequestParam.strokeWidth = ((float) i18) * 0.001f;
        int i20 = GLConvertUtil.getInt(bArr, i19);
        int i21 = i19 + 4;
        glyphRequestParam.languageArr = new String(bArr, i21, i20);
        int i22 = GLConvertUtil.getInt(bArr, i21);
        int i23 = i21 + 4;
        if (1 == i22) {
            GlyphMetrics glyphMetrics = new GlyphMetrics();
            glyphMetrics.nWidth = GLConvertUtil.getInt(bArr, i23);
            int i24 = i23 + 4;
            glyphMetrics.nHeight = GLConvertUtil.getInt(bArr, i24);
            int i25 = i24 + 4;
            int i26 = GLConvertUtil.getInt(bArr, i25);
            int i27 = i25 + 4;
            glyphMetrics.fLeft = ((float) i26) * 0.001f;
            glyphMetrics.fTop = ((float) GLConvertUtil.getInt(bArr, i27)) * 0.001f;
            glyphMetrics.fAdvance = ((float) GLConvertUtil.getInt(bArr, i27 + 4)) * 0.001f;
            glyphRequestParam.fGlyphMetrics = glyphMetrics;
        }
        return glyphRequestParam;
    }

    private static FontMetrics getFontMetrics(byte[] bArr) {
        FontMetricsRequestParam genFontMetricsParam = genFontMetricsParam(bArr);
        Paint.FontMetrics fontMetrics = newTextPaint(new FontStyle(genFontMetricsParam.nFontStyleCode), genFontMetricsParam.fFontSize, genFontMetricsParam.languageArr, false, 0.0f).getFontMetrics();
        FontMetrics fontMetrics2 = new FontMetrics();
        fontMetrics2.bSuccess = true;
        fontMetrics2.fAscent = Math.abs(fontMetrics.ascent);
        fontMetrics2.fDescent = Math.abs(fontMetrics.descent);
        fontMetrics2.fLeading = Math.abs(fontMetrics.leading);
        fontMetrics2.fHeight = Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent);
        return fontMetrics2;
    }

    private static GlyphMetrics getGlyphMetrics(byte[] bArr) {
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        return loadGlyphMetrics(genGlyphRequestParam.strBuffer, new FontStyle(genGlyphRequestParam.font.nFontStyleCode), (float) genGlyphRequestParam.font.nFontSize, genGlyphRequestParam.languageArr, genGlyphRequestParam.drawingMode == 1, genGlyphRequestParam.strokeWidth);
    }

    private static GlyphRaster getGlyphRaster(byte[] bArr) {
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        return loadGlyphRaster(genGlyphRequestParam.strBuffer, new FontStyle(genGlyphRequestParam.font.nFontStyleCode), (float) genGlyphRequestParam.font.nFontSize, genGlyphRequestParam.languageArr, genGlyphRequestParam.drawingMode == 1, genGlyphRequestParam.strokeWidth);
    }

    private static GlyphMetrics loadGlyphMetrics(String str, FontStyle fontStyle, float f2, String str2, boolean z2, float f3) {
        GlyphMetrics glyphMetrics = new GlyphMetrics();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphMetrics;
        }
        try {
            TextPaint newTextPaint = newTextPaint(fontStyle, f2, str2, z2, f3);
            Rect rect = new Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            if (rect.width() == 0 && rect.height() == 0) {
                float measureText = newTextPaint.measureText(" ", 0, 1);
                rect.top = 0;
                rect.left = 0;
                rect.right = (int) measureText;
                rect.bottom = (int) (Math.abs(newTextPaint.getFontMetrics().ascent) + Math.abs(newTextPaint.getFontMetrics().descent));
            }
            if (z2 && f3 > 0.0f) {
                float f4 = f3 / 2.0f;
                rect.top = (int) (((float) rect.top) - f4);
                rect.left = (int) (((float) rect.left) - f4);
                rect.right = (int) (((float) rect.right) + f4);
                rect.bottom = (int) (((float) rect.bottom) + f4);
            }
            glyphMetrics.bSuccess = true;
            glyphMetrics.fLeft = (float) rect.left;
            glyphMetrics.fTop = Math.abs(newTextPaint.getFontMetrics().ascent) - ((float) Math.abs(rect.top));
            glyphMetrics.nWidth = rect.width();
            glyphMetrics.nHeight = rect.height();
            glyphMetrics.fAdvance = newTextPaint.measureText(str);
        } catch (Exception unused) {
            glyphMetrics.bSuccess = false;
        }
        return glyphMetrics;
    }

    private static GlyphRaster loadGlyphRaster(String str, FontStyle fontStyle, float f2, String str2, boolean z2, float f3) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            TextPaint newTextPaint = newTextPaint(fontStyle, f2, str2, z2, f3);
            Rect rect = new Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            if (rect.width() == 0 && rect.height() == 0) {
                rect.right = (int) newTextPaint.measureText(" ", 0, 1);
                rect.bottom = (int) (Math.abs(newTextPaint.getFontMetrics().ascent) + Math.abs(newTextPaint.getFontMetrics().descent));
                rect.left = 0;
                rect.top = 0;
            }
            if (z2 && f3 > 0.0f) {
                float f4 = f3 / 2.0f;
                rect.top = (int) (((float) rect.top) - f4);
                rect.left = (int) (((float) rect.left) - f4);
                rect.right = (int) (((float) rect.right) + f4);
                rect.bottom = (int) (((float) rect.bottom) + f4);
            }
            if (!rect.isEmpty()) {
                Bitmap createBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ALPHA_8);
                new Canvas(createBitmap).drawText(str, (float) (0 - rect.left), (float) (0 - rect.top), newTextPaint);
                int width = rect.width() * rect.height();
                byte[] bArr = new byte[width];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                glyphRaster.bitmapWidth = rect.width();
                glyphRaster.bitmapHeight = rect.height();
                glyphRaster.bitmapPixelMode = 0;
                glyphRaster.bitmapSize = width;
                createBitmap.copyPixelsToBuffer(wrap);
                createBitmap.recycle();
                glyphRaster.bitmapBuffer = bArr;
                glyphRaster.bSuccess = true;
            }
        } catch (Exception unused) {
            glyphRaster.bSuccess = false;
        }
        return glyphRaster;
    }

    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long j2);

    private static TextPaint newTextPaint(FontStyle fontStyle, float f2, String str, boolean z2, float f3) {
        boolean z3;
        TextPaint textPaint = new TextPaint();
        if (fontStyle == null) {
            return textPaint;
        }
        textPaint.setColor(-1);
        int i2 = 1;
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTextSize(f2);
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (z2) {
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(f3);
        } else {
            textPaint.setStyle(Paint.Style.FILL);
        }
        int slant = fontStyle.getSlant();
        boolean z4 = slant != 0 && (slant == 1 || slant == 2);
        switch (fontStyle.getWeight()) {
            case 500:
            case 600:
            case 700:
            case 800:
            case 900:
            case 1000:
                z3 = true;
                break;
            default:
                z3 = false;
                break;
        }
        if (z3 && z4) {
            i2 = 3;
        } else if (!z3) {
            i2 = z4 ? 2 : 0;
        }
        textPaint.setTypeface(str.isEmpty() ? Typeface.create(Typeface.DEFAULT, i2) : Typeface.create(str, i2));
        return textPaint;
    }
}
