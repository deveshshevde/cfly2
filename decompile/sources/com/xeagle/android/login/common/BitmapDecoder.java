package com.xeagle.android.login.common;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.os.Build;
import com.xeagle.android.utils.s;
import java.io.IOException;
import java.io.InputStream;

public class BitmapDecoder {
    private static Bitmap checkInBitmap(Bitmap bitmap, BitmapFactory.Options options, String str) {
        if (!(!(Build.VERSION.SDK_INT >= 11) || bitmap == options.inBitmap || options.inBitmap == null)) {
            options.inBitmap.recycle();
            options.inBitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static Bitmap decode(InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            if (inputStream.markSupported()) {
                inputStream.reset();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static int[] decodeBound(Resources resources, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i2, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0021 A[SYNTHETIC, Splitter:B:19:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0032 A[SYNTHETIC, Splitter:B:26:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] decodeBound(java.io.File r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x001b }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x001b }
            int[] r2 = decodeBound((java.io.InputStream) r1)     // Catch:{ FileNotFoundException -> 0x0016, all -> 0x0013 }
            r1.close()     // Catch:{ IOException -> 0x000e }
            goto L_0x0012
        L_0x000e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0012:
            return r2
        L_0x0013:
            r2 = move-exception
            r0 = r1
            goto L_0x0030
        L_0x0016:
            r2 = move-exception
            r0 = r1
            goto L_0x001c
        L_0x0019:
            r2 = move-exception
            goto L_0x0030
        L_0x001b:
            r2 = move-exception
        L_0x001c:
            r2.printStackTrace()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0029
            r0.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0029:
            r2 = 2
            int[] r2 = new int[r2]
            r2 = {0, 0} // fill-array
            return r2
        L_0x0030:
            if (r0 == 0) goto L_0x003a
            r0.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.BitmapDecoder.decodeBound(java.io.File):int[]");
    }

    public static int[] decodeBound(InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int[] decodeBound(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static Bitmap decodeSampled(Resources resources, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i3;
        try {
            return BitmapFactory.decodeResource(resources, i2, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap decodeSampled(Resources resources, int i2, int i3, int i4) {
        return decodeSampled(resources, i2, getSampleSize(resources, i2, i3, i4));
    }

    public static Bitmap decodeSampled(InputStream inputStream, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = getSampleSize(inputStream, i2, i3);
        try {
            return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap decodeSampled(String str, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i2;
        try {
            return checkInBitmap(BitmapFactory.decodeFile(str, options), options, str);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap decodeSampled(String str, int i2, int i3) {
        return decodeSampled(str, getSampleSize(str, i2, i3));
    }

    public static Bitmap decodeSampledForDisplay(String str) {
        return decodeSampledForDisplay(str, true);
    }

    public static Bitmap decodeSampledForDisplay(String str, boolean z2) {
        Bitmap decodeSampled;
        int[] iArr = {s.f24510a * 2, s.f24511b};
        int[] iArr2 = {s.f24510a, s.f24511b * 2};
        double d2 = (double) s.f24510a;
        Double.isNaN(d2);
        double d3 = (double) s.f24511b;
        Double.isNaN(d3);
        int[] decodeBound = decodeBound(str);
        int[] pickReqBoundWithRatio = pickReqBoundWithRatio(decodeBound, new int[][]{iArr, iArr2, new int[]{(int) (d2 * 1.414d), (int) (d3 * 1.414d)}}, 5.0f);
        int i2 = decodeBound[0];
        int i3 = decodeBound[1];
        int calculateSampleSize = SampleSizeUtil.calculateSampleSize(i2, i3, pickReqBoundWithRatio[0], pickReqBoundWithRatio[1]);
        if (z2) {
            calculateSampleSize = SampleSizeUtil.adjustSampleSizeWithTexture(calculateSampleSize, i2, i3);
        }
        int i4 = 5;
        while (true) {
            decodeSampled = decodeSampled(str, calculateSampleSize);
            if (decodeSampled != null || i4 <= 0) {
                return decodeSampled;
            }
            calculateSampleSize++;
            i4--;
        }
        return decodeSampled;
    }

    public static boolean extractThumbnail(String str, String str2) {
        Bitmap createVideoThumbnail;
        if (AttachmentStore.isFileExist(str2) || (createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1)) == null) {
            return false;
        }
        AttachmentStore.saveBitmap(createVideoThumbnail, str2, true);
        return true;
    }

    public static int getSampleSize(Resources resources, int i2, int i3, int i4) {
        int[] decodeBound = decodeBound(resources, i2);
        return SampleSizeUtil.calculateSampleSize(decodeBound[0], decodeBound[1], i3, i4);
    }

    public static int getSampleSize(InputStream inputStream, int i2, int i3) {
        int[] decodeBound = decodeBound(inputStream);
        return SampleSizeUtil.calculateSampleSize(decodeBound[0], decodeBound[1], i2, i3);
    }

    public static int getSampleSize(String str, int i2, int i3) {
        int[] decodeBound = decodeBound(str);
        return SampleSizeUtil.calculateSampleSize(decodeBound[0], decodeBound[1], i2, i3);
    }

    private static int[] pickReqBoundWithRatio(int[] iArr, int[][] iArr2, float f2) {
        float f3 = 0.0f;
        float f4 = iArr[1] == 0 ? 0.0f : ((float) iArr[0]) / ((float) iArr[1]);
        if (iArr[0] != 0) {
            f3 = ((float) iArr[1]) / ((float) iArr[0]);
        }
        return f4 >= f2 ? iArr2[0] : f3 >= f2 ? iArr2[1] : iArr2[2];
    }
}
