package com.blankj.utilcode.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import androidx.core.content.b;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Objects;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class ImageUtils {

    public enum ImageType {
        TYPE_JPG("jpg"),
        TYPE_PNG("png"),
        TYPE_GIF("gif"),
        TYPE_TIFF("tiff"),
        TYPE_BMP("bmp"),
        TYPE_WEBP("webp"),
        TYPE_ICO("ico"),
        TYPE_UNKNOWN(IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN);
        
        String value;

        private ImageType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    private ImageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Bitmap addBorder(Bitmap bitmap, float f2, int i2, boolean z2, float f3, boolean z3) {
        return addBorder(bitmap, f2, i2, z2, new float[]{f3, f3, f3, f3, f3, f3, f3, f3}, z3);
    }

    private static Bitmap addBorder(Bitmap bitmap, float f2, int i2, boolean z2, float[] fArr, boolean z3) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (!z3) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f2);
        if (z2) {
            canvas.drawCircle(((float) width) / 2.0f, ((float) height) / 2.0f, (((float) Math.min(width, height)) / 2.0f) - (f2 / 2.0f), paint);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
            float f3 = f2 / 2.0f;
            rectF.inset(f3, f3);
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
        return bitmap;
    }

    public static Bitmap addCircleBorder(Bitmap bitmap, float f2, int i2) {
        return addBorder(bitmap, f2, i2, true, 0.0f, false);
    }

    public static Bitmap addCircleBorder(Bitmap bitmap, float f2, int i2, boolean z2) {
        return addBorder(bitmap, f2, i2, true, 0.0f, z2);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, float f2, int i2, float f3) {
        return addBorder(bitmap, f2, i2, false, f3, false);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, float f2, int i2, float f3, boolean z2) {
        return addBorder(bitmap, f2, i2, false, f3, z2);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, float f2, int i2, float[] fArr) {
        return addBorder(bitmap, f2, i2, false, fArr, false);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, float f2, int i2, float[] fArr, boolean z2) {
        return addBorder(bitmap, f2, i2, false, fArr, z2);
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i2, int i3, int i4) {
        return addImageWatermark(bitmap, bitmap2, i2, i3, i4, false);
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i2, int i3, int i4, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (!isEmptyBitmap(bitmap2)) {
            Paint paint = new Paint(1);
            Canvas canvas = new Canvas(copy);
            paint.setAlpha(i4);
            canvas.drawBitmap(bitmap2, (float) i2, (float) i3, paint);
        }
        if (z2 && !bitmap.isRecycled() && copy != bitmap) {
            bitmap.recycle();
        }
        return copy;
    }

    public static Bitmap addReflection(Bitmap bitmap, int i2) {
        return addReflection(bitmap, i2, false);
    }

    public static Bitmap addReflection(Bitmap bitmap, int i2, boolean z2) {
        Bitmap bitmap2 = bitmap;
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height - i2, width, i2, matrix, false);
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height + i2, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        float f2 = (float) (height + 0);
        canvas.drawBitmap(createBitmap, 0.0f, f2, (Paint) null);
        Paint paint = new Paint(1);
        paint.setShader(new LinearGradient(0.0f, (float) height, 0.0f, (float) (createBitmap2.getHeight() + 0), 1895825407, 16777215, Shader.TileMode.MIRROR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, f2, (float) width, (float) createBitmap2.getHeight(), paint);
        if (!createBitmap.isRecycled()) {
            createBitmap.recycle();
        }
        if (z2 && !bitmap.isRecycled() && createBitmap2 != bitmap2) {
            bitmap.recycle();
        }
        return createBitmap2;
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, float f2, int i2, float f3, float f4, boolean z2) {
        if (isEmptyBitmap(bitmap) || str == null) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(1);
        Canvas canvas = new Canvas(copy);
        paint.setColor(i2);
        paint.setTextSize(f2);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, f3, f4 + f2, paint);
        if (z2 && !bitmap.isRecycled() && copy != bitmap) {
            bitmap.recycle();
        }
        return copy;
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, int i2, int i3, float f2, float f3) {
        return addTextWatermark(bitmap, str, (float) i2, i3, f2, f3, false);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        return bitmap2Bytes(bitmap, Bitmap.CompressFormat.PNG, 100);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        Objects.requireNonNull(compressFormat, "Argument 'format' of type CompressFormat (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i2, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Drawable bitmap2Drawable(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(Utils.getApp().getResources(), bitmap);
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static Drawable bytes2Drawable(byte[] bArr) {
        return bitmap2Drawable(bytes2Bitmap(bArr));
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        while (true) {
            if (i4 <= i3 && i5 <= i2) {
                return i6;
            }
            i4 >>= 1;
            i5 >>= 1;
            i6 <<= 1;
        }
    }

    public static Bitmap clip(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        return clip(bitmap, i2, i3, i4, i5, false);
    }

    public static Bitmap clip(Bitmap bitmap, int i2, int i3, int i4, int i5, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i5);
        if (z2 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static byte[] compressByQuality(Bitmap bitmap, int i2) {
        return compressByQuality(bitmap, i2, false);
    }

    public static byte[] compressByQuality(Bitmap bitmap, int i2, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z2 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static byte[] compressByQuality(Bitmap bitmap, long j2) {
        return compressByQuality(bitmap, j2, false);
    }

    public static byte[] compressByQuality(Bitmap bitmap, long j2, boolean z2) {
        int i2 = 0;
        if (isEmptyBitmap(bitmap) || j2 <= 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (((long) byteArrayOutputStream.size()) > j2) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
            if (((long) byteArrayOutputStream.size()) < j2) {
                int i4 = 0;
                while (i2 < i3) {
                    i4 = (i2 + i3) / 2;
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                    long size = (long) byteArrayOutputStream.size();
                    if (size == j2) {
                        break;
                    } else if (size > j2) {
                        i3 = i4 - 1;
                    } else {
                        i2 = i4 + 1;
                    }
                }
                if (i3 == i4 - 1) {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z2 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i2) {
        return compressBySampleSize(bitmap, i2, false);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i2, int i3) {
        return compressBySampleSize(bitmap, i2, i3, false);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i2, int i3, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        if (z2 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i2, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z2 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f2, float f3) {
        return scale(bitmap, f2, f3, false);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f2, float f3, boolean z2) {
        return scale(bitmap, f2, f3, z2);
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i2, int i3) {
        return scale(bitmap, i2, i3, false);
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i2, int i3, boolean z2) {
        return scale(bitmap, i2, i3, z2);
    }

    public static Bitmap drawColor(Bitmap bitmap, int i2) {
        Objects.requireNonNull(bitmap, "Argument 'src' of type Bitmap (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return drawColor(bitmap, i2, false);
    }

    public static Bitmap drawColor(Bitmap bitmap, int i2, boolean z2) {
        Objects.requireNonNull(bitmap, "Argument 'src' of type Bitmap (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (!z2) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        new Canvas(bitmap).drawColor(i2, PorterDuff.Mode.DARKEN);
        return bitmap;
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static byte[] drawable2Bytes(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return bitmap2Bytes(drawable2Bitmap(drawable));
    }

    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat, int i2) {
        if (drawable == null) {
            return null;
        }
        return bitmap2Bytes(drawable2Bitmap(drawable), compressFormat, i2);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f2, float f3) {
        return fastBlur(bitmap, f2, f3, false, false);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f2, float f3, boolean z2) {
        return fastBlur(bitmap, f2, f3, z2, false);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f2, float f3, boolean z2, boolean z3) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Paint paint = new Paint(3);
        Canvas canvas = new Canvas();
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.scale(f2, f2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        Bitmap renderScriptBlur = Build.VERSION.SDK_INT >= 17 ? renderScriptBlur(createBitmap, f3, z2) : stackBlur(createBitmap, (int) f3, z2);
        if (f2 == 1.0f || z3) {
            if (z2 && !bitmap.isRecycled() && renderScriptBlur != bitmap) {
                bitmap.recycle();
            }
            return renderScriptBlur;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(renderScriptBlur, width, height, true);
        if (!renderScriptBlur.isRecycled()) {
            renderScriptBlur.recycle();
        }
        if (z2 && !bitmap.isRecycled() && createScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static Bitmap getBitmap(int i2) {
        Drawable a2 = b.a((Context) Utils.getApp(), i2);
        if (a2 == null) {
            return null;
        }
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(a2.getIntrinsicWidth(), a2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
        a2.draw(canvas);
        return createBitmap;
    }

    public static Bitmap getBitmap(int i2, int i3, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Resources resources = Utils.getApp().getResources();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i2, options);
        options.inSampleSize = calculateInSampleSize(options, i3, i4);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i2, options);
    }

    public static Bitmap getBitmap(File file) {
        if (file == null) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static Bitmap getBitmap(File file, int i2, int i3) {
        if (file == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            return null;
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor, int i2, int i3) {
        if (fileDescriptor == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
    }

    public static Bitmap getBitmap(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap getBitmap(InputStream inputStream, int i2, int i3) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
    }

    public static Bitmap getBitmap(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    public static Bitmap getBitmap(String str, int i2, int i3) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmap(byte[] bArr, int i2) {
        if (bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, i2, bArr.length);
    }

    public static Bitmap getBitmap(byte[] bArr, int i2, int i3, int i4) {
        if (bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i2, bArr.length, options);
        options.inSampleSize = calculateInSampleSize(options, i3, i4);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, i2, bArr.length, options);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0027 A[SYNTHETIC, Splitter:B:22:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0034 A[SYNTHETIC, Splitter:B:30:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blankj.utilcode.util.ImageUtils.ImageType getImageType(java.io.File r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            com.blankj.utilcode.util.ImageUtils$ImageType r2 = getImageType((java.io.InputStream) r1)     // Catch:{ IOException -> 0x001c }
            if (r2 == 0) goto L_0x0018
            r1.close()     // Catch:{ IOException -> 0x0013 }
            goto L_0x0017
        L_0x0013:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0017:
            return r2
        L_0x0018:
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x001c:
            r2 = move-exception
            goto L_0x0022
        L_0x001e:
            r2 = move-exception
            goto L_0x0032
        L_0x0020:
            r2 = move-exception
            r1 = r0
        L_0x0022:
            r2.printStackTrace()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r2 = move-exception
            r2.printStackTrace()
        L_0x002f:
            return r0
        L_0x0030:
            r2 = move-exception
            r0 = r1
        L_0x0032:
            if (r0 == 0) goto L_0x003c
            r0.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ImageUtils.getImageType(java.io.File):com.blankj.utilcode.util.ImageUtils$ImageType");
    }

    private static ImageType getImageType(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[12];
            if (inputStream.read(bArr) != -1) {
                return getImageType(bArr);
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ImageType getImageType(String str) {
        return getImageType(UtilsBridge.getFileByPath(str));
    }

    private static ImageType getImageType(byte[] bArr) {
        String upperCase = UtilsBridge.bytes2HexString(bArr).toUpperCase();
        return upperCase.contains("FFD8FF") ? ImageType.TYPE_JPG : upperCase.contains("89504E47") ? ImageType.TYPE_PNG : upperCase.contains("47494638") ? ImageType.TYPE_GIF : (upperCase.contains("49492A00") || upperCase.contains("4D4D002A")) ? ImageType.TYPE_TIFF : upperCase.contains("424D") ? ImageType.TYPE_BMP : (!upperCase.startsWith("52494646") || !upperCase.endsWith("57454250")) ? (upperCase.contains("00000100") || upperCase.contains("00000200")) ? ImageType.TYPE_ICO : ImageType.TYPE_UNKNOWN : ImageType.TYPE_WEBP;
    }

    public static int getRotateDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int[] getSize(File file) {
        if (file == null) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int[] getSize(String str) {
        return getSize(UtilsBridge.getFileByPath(str));
    }

    private static boolean isBMP(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 66 && bArr[1] == 77;
    }

    private static boolean isEmptyBitmap(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    private static boolean isGIF(byte[] bArr) {
        return bArr.length >= 6 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && (bArr[4] == 55 || bArr[4] == 57) && bArr[5] == 97;
    }

    public static boolean isImage(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return isImage(file.getPath());
    }

    public static boolean isImage(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return options.outWidth > 0 && options.outHeight > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isJPEG(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == -1 && bArr[1] == -40;
    }

    private static boolean isPNG(byte[] bArr) {
        return bArr.length >= 8 && bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    public static Bitmap renderScriptBlur(Bitmap bitmap, float f2) {
        return renderScriptBlur(bitmap, f2, false);
    }

    public static Bitmap renderScriptBlur(Bitmap bitmap, float f2, boolean z2) {
        if (!z2) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        RenderScript renderScript = null;
        try {
            renderScript = RenderScript.create(Utils.getApp());
            renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius(f2);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
            return bitmap;
        } finally {
            if (renderScript != null) {
                renderScript.destroy();
            }
        }
    }

    public static Bitmap rotate(Bitmap bitmap, int i2, float f2, float f3) {
        return rotate(bitmap, i2, f2, f3, false);
    }

    public static Bitmap rotate(Bitmap bitmap, int i2, float f2, float f3, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (i2 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i2, f2, f3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z2 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, file, compressFormat, 100, false);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i2) {
        return save(bitmap, file, compressFormat, i2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066 A[SYNTHETIC, Splitter:B:33:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006c A[SYNTHETIC, Splitter:B:37:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean save(android.graphics.Bitmap r4, java.io.File r5, android.graphics.Bitmap.CompressFormat r6, int r7, boolean r8) {
        /*
            boolean r0 = isEmptyBitmap(r4)
            java.lang.String r1 = "ImageUtils"
            r2 = 0
            if (r0 == 0) goto L_0x000f
            java.lang.String r4 = "bitmap is empty."
        L_0x000b:
            android.util.Log.e(r1, r4)
            return r2
        L_0x000f:
            boolean r0 = r4.isRecycled()
            if (r0 == 0) goto L_0x0018
            java.lang.String r4 = "bitmap is recycled."
            goto L_0x000b
        L_0x0018:
            boolean r0 = com.blankj.utilcode.util.UtilsBridge.createFileByDeleteOldFile(r5)
            if (r0 != 0) goto L_0x0035
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "create or delete file <"
            r4.append(r6)
            r4.append(r5)
            java.lang.String r5 = "> failed."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x000b
        L_0x0035:
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0060 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0060 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0060 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0060 }
            boolean r2 = r4.compress(r6, r7, r1)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            if (r8 == 0) goto L_0x004f
            boolean r5 = r4.isRecycled()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            if (r5 != 0) goto L_0x004f
            r4.recycle()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        L_0x004f:
            r1.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0069
        L_0x0053:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0069
        L_0x0058:
            r4 = move-exception
            r0 = r1
            goto L_0x006a
        L_0x005b:
            r4 = move-exception
            r0 = r1
            goto L_0x0061
        L_0x005e:
            r4 = move-exception
            goto L_0x006a
        L_0x0060:
            r4 = move-exception
        L_0x0061:
            r4.printStackTrace()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0069
            r0.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0069:
            return r2
        L_0x006a:
            if (r0 == 0) goto L_0x0074
            r0.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0074:
            goto L_0x0076
        L_0x0075:
            throw r4
        L_0x0076:
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ImageUtils.save(android.graphics.Bitmap, java.io.File, android.graphics.Bitmap$CompressFormat, int, boolean):boolean");
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z2) {
        return save(bitmap, file, compressFormat, 100, z2);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, str, compressFormat, 100, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2) {
        return save(bitmap, UtilsBridge.getFileByPath(str), compressFormat, i2, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2, boolean z2) {
        return save(bitmap, UtilsBridge.getFileByPath(str), compressFormat, i2, z2);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z2) {
        return save(bitmap, str, compressFormat, 100, z2);
    }

    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return save2Album(bitmap, "", compressFormat, 100, false);
    }

    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        return save2Album(bitmap, "", compressFormat, i2, false);
    }

    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2, boolean z2) {
        return save2Album(bitmap, "", compressFormat, i2, z2);
    }

    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z2) {
        return save2Album(bitmap, "", compressFormat, 100, z2);
    }

    public static File save2Album(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save2Album(bitmap, str, compressFormat, 100, false);
    }

    public static File save2Album(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2) {
        return save2Album(bitmap, str, compressFormat, i2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0120 A[SYNTHETIC, Splitter:B:42:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012d A[SYNTHETIC, Splitter:B:50:0x012d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File save2Album(android.graphics.Bitmap r6, java.lang.String r7, android.graphics.Bitmap.CompressFormat r8, int r9, boolean r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x000e
            android.app.Application r7 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r7 = r7.getPackageName()
        L_0x000e:
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = "JPG"
            goto L_0x001d
        L_0x0019:
            java.lang.String r0 = r8.name()
        L_0x001d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r2 = "_"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "."
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            java.lang.String r3 = "/"
            r4 = 0
            if (r1 >= r2) goto L_0x0082
            java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            boolean r1 = com.blankj.utilcode.util.UtilsBridge.isGranted(r1)
            if (r1 != 0) goto L_0x005a
            java.lang.String r6 = "ImageUtils"
            java.lang.String r7 = "save to album need storage permission"
            android.util.Log.e(r6, r7)
            return r4
        L_0x005a:
            java.lang.String r1 = android.os.Environment.DIRECTORY_DCIM
            java.io.File r1 = android.os.Environment.getExternalStoragePublicDirectory(r1)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            r5.append(r3)
            r5.append(r0)
            java.lang.String r7 = r5.toString()
            r2.<init>(r1, r7)
            boolean r6 = save((android.graphics.Bitmap) r6, (java.io.File) r2, (android.graphics.Bitmap.CompressFormat) r8, (int) r9, (boolean) r10)
            if (r6 != 0) goto L_0x007e
            return r4
        L_0x007e:
            com.blankj.utilcode.util.UtilsBridge.notifySystemToScan(r2)
            return r2
        L_0x0082:
            android.content.ContentValues r10 = new android.content.ContentValues
            r10.<init>()
            java.lang.String r1 = "_display_name"
            r10.put(r1, r0)
            java.lang.String r0 = "mime_type"
            java.lang.String r1 = "image/*"
            r10.put(r0, r1)
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a2
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x00a4
        L_0x00a2:
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI
        L_0x00a4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = android.os.Environment.DIRECTORY_DCIM
            r1.append(r2)
            r1.append(r3)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String r1 = "relative_path"
            r10.put(r1, r7)
            r7 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r1 = "is_pending"
            r10.put(r1, r7)
            android.app.Application r7 = com.blankj.utilcode.util.Utils.getApp()
            android.content.ContentResolver r7 = r7.getContentResolver()
            android.net.Uri r7 = r7.insert(r0, r10)
            if (r7 != 0) goto L_0x00d6
            return r4
        L_0x00d6:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            java.io.OutputStream r0 = r0.openOutputStream(r7)     // Catch:{ Exception -> 0x010e, all -> 0x010c }
            r6.compress(r8, r9, r0)     // Catch:{ Exception -> 0x010a }
            r10.clear()     // Catch:{ Exception -> 0x010a }
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x010a }
            r10.put(r1, r6)     // Catch:{ Exception -> 0x010a }
            android.app.Application r6 = com.blankj.utilcode.util.Utils.getApp()     // Catch:{ Exception -> 0x010a }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ Exception -> 0x010a }
            r6.update(r7, r10, r4, r4)     // Catch:{ Exception -> 0x010a }
            java.io.File r6 = com.blankj.utilcode.util.UtilsBridge.uri2File(r7)     // Catch:{ Exception -> 0x010a }
            if (r0 == 0) goto L_0x0109
            r0.close()     // Catch:{ IOException -> 0x0105 }
            goto L_0x0109
        L_0x0105:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0109:
            return r6
        L_0x010a:
            r6 = move-exception
            goto L_0x0110
        L_0x010c:
            r6 = move-exception
            goto L_0x012b
        L_0x010e:
            r6 = move-exception
            r0 = r4
        L_0x0110:
            android.app.Application r8 = com.blankj.utilcode.util.Utils.getApp()     // Catch:{ all -> 0x0129 }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ all -> 0x0129 }
            r8.delete(r7, r4, r4)     // Catch:{ all -> 0x0129 }
            r6.printStackTrace()     // Catch:{ all -> 0x0129 }
            if (r0 == 0) goto L_0x0128
            r0.close()     // Catch:{ IOException -> 0x0124 }
            goto L_0x0128
        L_0x0124:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0128:
            return r4
        L_0x0129:
            r6 = move-exception
            r4 = r0
        L_0x012b:
            if (r4 == 0) goto L_0x0135
            r4.close()     // Catch:{ IOException -> 0x0131 }
            goto L_0x0135
        L_0x0131:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0135:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ImageUtils.save2Album(android.graphics.Bitmap, java.lang.String, android.graphics.Bitmap$CompressFormat, int, boolean):java.io.File");
    }

    public static File save2Album(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z2) {
        return save2Album(bitmap, str, compressFormat, 100, z2);
    }

    public static Bitmap scale(Bitmap bitmap, float f2, float f3) {
        return scale(bitmap, f2, f3, false);
    }

    public static Bitmap scale(Bitmap bitmap, float f2, float f3, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z2 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap scale(Bitmap bitmap, int i2, int i3) {
        return scale(bitmap, i2, i3, false);
    }

    public static Bitmap scale(Bitmap bitmap, int i2, int i3, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        if (z2 && !bitmap.isRecycled() && createScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static Bitmap skew(Bitmap bitmap, float f2, float f3) {
        return skew(bitmap, f2, f3, 0.0f, 0.0f, false);
    }

    public static Bitmap skew(Bitmap bitmap, float f2, float f3, float f4, float f5) {
        return skew(bitmap, f2, f3, f4, f5, false);
    }

    public static Bitmap skew(Bitmap bitmap, float f2, float f3, float f4, float f5, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setSkew(f2, f3, f4, f5);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z2 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap skew(Bitmap bitmap, float f2, float f3, boolean z2) {
        return skew(bitmap, f2, f3, 0.0f, 0.0f, z2);
    }

    public static Bitmap stackBlur(Bitmap bitmap, int i2) {
        return stackBlur(bitmap, i2, false);
    }

    public static Bitmap stackBlur(Bitmap bitmap, int i2, boolean z2) {
        Bitmap bitmap2;
        int i3;
        int i4;
        int[] iArr;
        int[] iArr2;
        Bitmap copy = z2 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        int i5 = i2;
        int i6 = i5 < 1 ? 1 : i5;
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i7 = width * height;
        int[] iArr3 = new int[i7];
        copy.getPixels(iArr3, 0, width, 0, 0, width, height);
        int i8 = width - 1;
        int i9 = height - 1;
        int i10 = i6 + i6 + 1;
        int[] iArr4 = new int[i7];
        int[] iArr5 = new int[i7];
        int[] iArr6 = new int[i7];
        int[] iArr7 = new int[Math.max(width, height)];
        int i11 = (i10 + 1) >> 1;
        int i12 = i11 * i11;
        int i13 = i12 * 256;
        int[] iArr8 = new int[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            iArr8[i14] = i14 / i12;
        }
        int[] iArr9 = new int[2];
        iArr9[1] = 3;
        iArr9[0] = i10;
        int[][] iArr10 = (int[][]) Array.newInstance(int.class, iArr9);
        int i15 = i6 + 1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            bitmap2 = copy;
            if (i16 >= height) {
                break;
            }
            int i19 = height;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = -i6;
            int i29 = 0;
            while (true) {
                i4 = i9;
                iArr = iArr7;
                if (i28 > i6) {
                    break;
                }
                int i30 = iArr3[i17 + Math.min(i8, Math.max(i28, 0))];
                int[] iArr11 = iArr10[i28 + i6];
                iArr11[0] = (i30 & 16711680) >> 16;
                iArr11[1] = (i30 & 65280) >> 8;
                iArr11[2] = i30 & 255;
                int abs = i15 - Math.abs(i28);
                i29 += iArr11[0] * abs;
                i20 += iArr11[1] * abs;
                i21 += iArr11[2] * abs;
                if (i28 > 0) {
                    i25 += iArr11[0];
                    i26 += iArr11[1];
                    i27 += iArr11[2];
                } else {
                    i22 += iArr11[0];
                    i23 += iArr11[1];
                    i24 += iArr11[2];
                }
                i28++;
                i9 = i4;
                iArr7 = iArr;
            }
            int i31 = i29;
            int i32 = i6;
            int i33 = 0;
            while (i33 < width) {
                iArr4[i17] = iArr8[i31];
                iArr5[i17] = iArr8[i20];
                iArr6[i17] = iArr8[i21];
                int i34 = i31 - i22;
                int i35 = i20 - i23;
                int i36 = i21 - i24;
                int[] iArr12 = iArr10[((i32 - i6) + i10) % i10];
                int i37 = i22 - iArr12[0];
                int i38 = i23 - iArr12[1];
                int i39 = i24 - iArr12[2];
                if (i16 == 0) {
                    iArr2 = iArr8;
                    iArr[i33] = Math.min(i33 + i6 + 1, i8);
                } else {
                    iArr2 = iArr8;
                }
                int i40 = iArr3[i18 + iArr[i33]];
                iArr12[0] = (i40 & 16711680) >> 16;
                iArr12[1] = (i40 & 65280) >> 8;
                iArr12[2] = i40 & 255;
                int i41 = i25 + iArr12[0];
                int i42 = i26 + iArr12[1];
                int i43 = i27 + iArr12[2];
                i31 = i34 + i41;
                i20 = i35 + i42;
                i21 = i36 + i43;
                i32 = (i32 + 1) % i10;
                int[] iArr13 = iArr10[i32 % i10];
                i22 = i37 + iArr13[0];
                i23 = i38 + iArr13[1];
                i24 = i39 + iArr13[2];
                i25 = i41 - iArr13[0];
                i26 = i42 - iArr13[1];
                i27 = i43 - iArr13[2];
                i17++;
                i33++;
                iArr8 = iArr2;
            }
            int[] iArr14 = iArr8;
            i18 += width;
            i16++;
            copy = bitmap2;
            height = i19;
            i9 = i4;
            iArr7 = iArr;
        }
        int i44 = i9;
        int[] iArr15 = iArr7;
        int i45 = height;
        int[] iArr16 = iArr8;
        int i46 = 0;
        while (i46 < width) {
            int i47 = -i6;
            int i48 = i10;
            int[] iArr17 = iArr3;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = i47;
            int i57 = i47 * width;
            int i58 = 0;
            int i59 = 0;
            while (true) {
                i3 = width;
                if (i56 > i6) {
                    break;
                }
                int max = Math.max(0, i57) + i46;
                int[] iArr18 = iArr10[i56 + i6];
                iArr18[0] = iArr4[max];
                iArr18[1] = iArr5[max];
                iArr18[2] = iArr6[max];
                int abs2 = i15 - Math.abs(i56);
                i58 += iArr4[max] * abs2;
                i59 += iArr5[max] * abs2;
                i49 += iArr6[max] * abs2;
                if (i56 > 0) {
                    i53 += iArr18[0];
                    i54 += iArr18[1];
                    i55 += iArr18[2];
                } else {
                    i50 += iArr18[0];
                    i51 += iArr18[1];
                    i52 += iArr18[2];
                }
                int i60 = i44;
                if (i56 < i60) {
                    i57 += i3;
                }
                i56++;
                i44 = i60;
                width = i3;
            }
            int i61 = i44;
            int i62 = i46;
            int i63 = i59;
            int i64 = i6;
            int i65 = i45;
            int i66 = i58;
            int i67 = 0;
            while (i67 < i65) {
                iArr17[i62] = (iArr17[i62] & -16777216) | (iArr16[i66] << 16) | (iArr16[i63] << 8) | iArr16[i49];
                int i68 = i66 - i50;
                int i69 = i63 - i51;
                int i70 = i49 - i52;
                int[] iArr19 = iArr10[((i64 - i6) + i48) % i48];
                int i71 = i50 - iArr19[0];
                int i72 = i51 - iArr19[1];
                int i73 = i52 - iArr19[2];
                int i74 = i6;
                if (i46 == 0) {
                    iArr15[i67] = Math.min(i67 + i15, i61) * i3;
                }
                int i75 = iArr15[i67] + i46;
                iArr19[0] = iArr4[i75];
                iArr19[1] = iArr5[i75];
                iArr19[2] = iArr6[i75];
                int i76 = i53 + iArr19[0];
                int i77 = i54 + iArr19[1];
                int i78 = i55 + iArr19[2];
                i66 = i68 + i76;
                i63 = i69 + i77;
                i49 = i70 + i78;
                i64 = (i64 + 1) % i48;
                int[] iArr20 = iArr10[i64];
                i50 = i71 + iArr20[0];
                i51 = i72 + iArr20[1];
                i52 = i73 + iArr20[2];
                i53 = i76 - iArr20[0];
                i54 = i77 - iArr20[1];
                i55 = i78 - iArr20[2];
                i62 += i3;
                i67++;
                i6 = i74;
            }
            int i79 = i6;
            i46++;
            i44 = i61;
            i45 = i65;
            i10 = i48;
            iArr3 = iArr17;
            width = i3;
        }
        int i80 = width;
        bitmap2.setPixels(iArr3, 0, i80, 0, 0, i80, i45);
        return bitmap2;
    }

    public static Bitmap toAlpha(Bitmap bitmap) {
        return toAlpha(bitmap, false);
    }

    public static Bitmap toAlpha(Bitmap bitmap, Boolean bool) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap extractAlpha = bitmap.extractAlpha();
        if (bool.booleanValue() && !bitmap.isRecycled() && extractAlpha != bitmap) {
            bitmap.recycle();
        }
        return extractAlpha;
    }

    public static Bitmap toGray(Bitmap bitmap) {
        return toGray(bitmap, false);
    }

    public static Bitmap toGray(Bitmap bitmap, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (z2 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRound(Bitmap bitmap) {
        return toRound(bitmap, 0, 0, false);
    }

    public static Bitmap toRound(Bitmap bitmap, int i2, int i3) {
        return toRound(bitmap, i2, i3, false);
    }

    public static Bitmap toRound(Bitmap bitmap, int i2, int i3, boolean z2) {
        Bitmap bitmap2 = bitmap;
        int i4 = i2;
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        Paint paint = new Paint(1);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        float f2 = (float) min;
        float f3 = f2 / 2.0f;
        float f4 = (float) width;
        float f5 = (float) height;
        RectF rectF = new RectF(0.0f, 0.0f, f4, f5);
        rectF.inset(((float) (width - min)) / 2.0f, ((float) (height - min)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.setTranslate(rectF.left, rectF.top);
        if (width != height) {
            matrix.preScale(f2 / f4, f2 / f5);
        }
        BitmapShader bitmapShader = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRoundRect(rectF, f3, f3, paint);
        if (i4 > 0) {
            paint.setShader((Shader) null);
            paint.setColor(i3);
            paint.setStyle(Paint.Style.STROKE);
            float f6 = (float) i4;
            paint.setStrokeWidth(f6);
            canvas.drawCircle(f4 / 2.0f, f5 / 2.0f, f3 - (f6 / 2.0f), paint);
        }
        if (z2 && !bitmap.isRecycled() && createBitmap != bitmap2) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRound(Bitmap bitmap, boolean z2) {
        return toRound(bitmap, 0, 0, z2);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f2) {
        return toRoundCorner(bitmap, f2, 0.0f, 0, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f2, float f3, int i2) {
        return toRoundCorner(bitmap, f2, f3, i2, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f2, float f3, int i2, boolean z2) {
        return toRoundCorner(bitmap, new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, f3, i2, z2);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f2, boolean z2) {
        return toRoundCorner(bitmap, f2, 0.0f, 0, z2);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float[] fArr, float f2, int i2) {
        return toRoundCorner(bitmap, fArr, f2, i2, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float[] fArr, float f2, int i2, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint(1);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
        float f3 = f2 / 2.0f;
        rectF.inset(f3, f3);
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        if (f2 > 0.0f) {
            paint.setShader((Shader) null);
            paint.setColor(i2);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f2);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawPath(path, paint);
        }
        if (z2 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap view2Bitmap(View view) {
        Bitmap bitmap;
        if (view == null) {
            return null;
        }
        boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null || drawingCache.isRecycled()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache2 = view.getDrawingCache();
            if (drawingCache2 == null || drawingCache2.isRecycled()) {
                bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(bitmap));
            } else {
                bitmap = Bitmap.createBitmap(drawingCache2);
            }
        } else {
            bitmap = Bitmap.createBitmap(drawingCache);
        }
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return bitmap;
    }
}
