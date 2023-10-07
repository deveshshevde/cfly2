package com.autonavi.base.ae.gmap.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.amap.api.mapcore.util.dl;
import com.amap.api.mapcore.util.p;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.mapcore.FileUtil;

public class NativeTextGenerate {
    private static volatile NativeTextGenerate instance;
    private float density;
    private final int kTextAlignmentCenter;
    private final int kTextAlignmentLeft;
    private final int kTextAlignmentRight;
    private final int kTextLayoutLeftToRight;
    private final int kTextLayoutUpToDown;
    private TextPaint text_paint;

    class TextGeneratePOIStyleDesc {
        int boldFont = 0;
        int fontBgColor = 0;
        int fontBorderColor = 0;
        int fontColor = 0;
        int fontSize = 0;

        TextGeneratePOIStyleDesc() {
        }
    }

    class TextGenerateTextBitmap {
        double height;
        BitmapDescriptor imageData;
        String text;
        double width;

        TextGenerateTextBitmap() {
        }
    }

    class TextGenerateTextStyle {
        int layoutDirection = 0;
        int singleLineCharaterLimit = 7;
        int textAlignment = 0;

        TextGenerateTextStyle() {
        }
    }

    private NativeTextGenerate() {
        this.text_paint = null;
        this.density = 1.0f;
        this.kTextLayoutLeftToRight = 0;
        this.kTextLayoutUpToDown = 1;
        this.kTextAlignmentCenter = 0;
        this.kTextAlignmentLeft = 1;
        this.kTextAlignmentRight = 2;
        this.text_paint = new TextPaint();
    }

    public static NativeTextGenerate getInstance() {
        if (instance == null) {
            synchronized (NativeTextGenerate.class) {
                if (instance == null) {
                    instance = new NativeTextGenerate();
                }
            }
        }
        return instance;
    }

    private StaticLayout setPaintStyle(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        TextPaint textPaint;
        Paint.Align align;
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return null;
        }
        float f2 = ((float) textGeneratePOIStyleDesc.fontSize) * this.density;
        this.text_paint.setColor(textGeneratePOIStyleDesc.fontColor);
        this.text_paint.setTextSize(f2);
        this.text_paint.setStyle(Paint.Style.FILL);
        int i2 = 1;
        this.text_paint.setAntiAlias(true);
        this.text_paint.setFilterBitmap(true);
        this.text_paint.setTypeface(textGeneratePOIStyleDesc.boldFont == 1 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        int i3 = textGenerateTextStyle.textAlignment;
        if (i3 == 0) {
            textPaint = this.text_paint;
            align = Paint.Align.CENTER;
        } else if (i3 != 2) {
            textPaint = this.text_paint;
            align = Paint.Align.LEFT;
        } else {
            textPaint = this.text_paint;
            align = Paint.Align.RIGHT;
        }
        textPaint.setTextAlign(align);
        int length = textGenerateTextBitmap.text.length();
        int i4 = textGenerateTextStyle.singleLineCharaterLimit;
        if (length > textGenerateTextStyle.singleLineCharaterLimit || length % textGenerateTextStyle.singleLineCharaterLimit != 0) {
            int i5 = (length / textGenerateTextStyle.singleLineCharaterLimit) + 1;
            int i6 = length / i5;
            if (length % i5 <= 0) {
                i2 = 0;
            }
            i4 = i6 + i2;
        }
        return new StaticLayout(textGenerateTextBitmap.text, this.text_paint, (int) (f2 * ((float) i4)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    /* access modifiers changed from: package-private */
    public void calculateTextBoundSize(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap != null && textGenerateTextStyle != null && textGeneratePOIStyleDesc != null) {
            StaticLayout paintStyle = setPaintStyle(textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
            float measureText = this.text_paint.measureText(textGenerateTextBitmap.text);
            Paint.FontMetrics fontMetrics = this.text_paint.getFontMetrics();
            textGenerateTextBitmap.width = (double) measureText;
            textGenerateTextBitmap.height = (double) (fontMetrics.descent - fontMetrics.ascent);
            textGenerateTextBitmap.width = (double) paintStyle.getWidth();
            textGenerateTextBitmap.height = (double) paintStyle.getHeight();
        }
    }

    /* access modifiers changed from: package-private */
    public void generateTextBitmap(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        float f2;
        if (textGenerateTextBitmap != null && textGenerateTextStyle != null && textGeneratePOIStyleDesc != null) {
            setPaintStyle(textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
            StaticLayout paintStyle = setPaintStyle(textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
            Bitmap createBitmap = Bitmap.createBitmap((int) textGenerateTextBitmap.width, (int) textGenerateTextBitmap.height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            if (textGenerateTextStyle.textAlignment == 0) {
                f2 = ((float) textGenerateTextBitmap.width) / 2.0f;
            } else {
                if (textGenerateTextStyle.textAlignment == 2) {
                    f2 = (float) textGenerateTextBitmap.width;
                }
                paintStyle.draw(canvas);
                this.text_paint.setStyle(Paint.Style.STROKE);
                this.text_paint.setStrokeWidth(1.0f);
                this.text_paint.setColor(textGeneratePOIStyleDesc.fontBorderColor);
                paintStyle.draw(canvas);
                textGenerateTextBitmap.imageData = BitmapDescriptorFactory.fromBitmap(createBitmap);
            }
            canvas.translate(f2, 0.0f);
            paintStyle.draw(canvas);
            this.text_paint.setStyle(Paint.Style.STROKE);
            this.text_paint.setStrokeWidth(1.0f);
            this.text_paint.setColor(textGeneratePOIStyleDesc.fontBorderColor);
            paintStyle.draw(canvas);
            textGenerateTextBitmap.imageData = BitmapDescriptorFactory.fromBitmap(createBitmap);
        }
    }

    /* access modifiers changed from: package-private */
    public BitmapDescriptor getIconBitmap(String str) {
        if (str == null) {
            return null;
        }
        try {
            Context context = p.f9676a;
            byte[] uncompress = FileUtil.uncompress(FileUtil.readFileContentsFromAssetsByPreName(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME, str + "_"));
            if (uncompress != null) {
                return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeByteArray(uncompress, 0, uncompress.length));
            }
        } catch (Throwable th) {
            dl.a(th);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public byte[] getMapStyleJsonData() {
        try {
            return FileUtil.uncompress(FileUtil.readFileContentsFromAssets(p.f9676a, "map_custom/terrain/terrainStyle.data"));
        } catch (Throwable th) {
            dl.a(th);
            return null;
        }
    }

    public void setDensity(float f2) {
        this.density = f2;
    }
}
