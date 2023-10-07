package com.xeagle.android.login.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
    public static final float MAX_IMAGE_RATIO = 5.0f;

    public static class ImageSize {
        public int height = 0;
        public int width = 0;

        public ImageSize(int i2, int i3) {
            this.width = i2;
            this.height = i3;
        }
    }

    public static final Bitmap getBitmap(Drawable drawable) {
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    public static Bitmap getBitmapFromDrawableRes(Context context, int i2) {
        try {
            return getBitmapImmutableCopy(context.getResources(), i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static final Bitmap getBitmapImmutableCopy(Resources resources, int i2) {
        return getBitmap(resources.getDrawable(i2)).copy(Bitmap.Config.RGB_565, false);
    }

    public static int[] getBoundWithLength(Context context, int i2, Object obj, boolean z2) {
        int i3;
        int i4 = -1;
        if (String.class.isInstance(obj)) {
            int[] decodeBound = BitmapDecoder.decodeBound((String) obj);
            i4 = decodeBound[0];
            i3 = decodeBound[1];
        } else if (Integer.class.isInstance(obj)) {
            int[] decodeBound2 = BitmapDecoder.decodeBound(context.getResources(), ((Integer) obj).intValue());
            i4 = decodeBound2[0];
            i3 = decodeBound2[1];
        } else if (InputStream.class.isInstance(obj)) {
            int[] decodeBound3 = BitmapDecoder.decodeBound((InputStream) obj);
            i4 = decodeBound3[0];
            i3 = decodeBound3[1];
        } else {
            i3 = -1;
        }
        if (i4 <= 0 || i3 <= 0) {
            i3 = i2;
        } else if (z2) {
            float f2 = (float) i2;
            if (i4 > i3) {
                i3 = (int) (f2 * (((float) i3) / ((float) i4)));
            } else {
                int i5 = i2;
                i2 = (int) (f2 * (((float) i4) / ((float) i3)));
                i3 = i5;
            }
        } else {
            i2 = i4;
        }
        return new int[]{i2, i3};
    }

    public static Bitmap getDefaultBitmapWhenGetFail(Context context) {
        try {
            return getBitmapImmutableCopy(context.getResources(), R.drawable.video_error_default_drawable);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static float getImageRotate(int i2) {
        if (i2 == 6) {
            return 90.0f;
        }
        if (i2 == 3) {
            return 180.0f;
        }
        return i2 == 8 ? 270.0f : 0.0f;
    }

    public static String getImageType(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outMimeType;
    }

    public static BitmapFactory.Options getOptions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    public static File getScaledImageFileWithMD5(Context context, File file, String str) {
        File create;
        String path = file.getPath();
        if (isInvalidPictureFile(str) && (create = AttachmentStore.create(getTempFilePath(context, FileUtil.getExtensionName(path)))) != null && scaleImage(file, create, Constants.PORTRAIT_IMAGE_WIDTH, Bitmap.CompressFormat.JPEG, 60).booleanValue()) {
            return create;
        }
        return null;
    }

    private static String getTempFilePath(Context context, String str) {
        return StorageUtil.getWritePath(context, "temp_image_" + StringUtil.get36UUID() + "." + str, StorageType.TYPE_TEMP);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r4 > r5) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xeagle.android.login.common.ImageUtil.ImageSize getThumbnailDisplaySize(float r3, float r4, float r5, float r6) {
        /*
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x003f
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x000a
            goto L_0x003f
        L_0x000a:
            int r0 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0013
            r0 = 0
            r2 = r4
            r4 = r3
            r3 = r2
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x0021
            float r3 = r6 / r3
            float r4 = r4 * r3
            int r3 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0031
            goto L_0x0032
        L_0x0021:
            int r1 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0030
            float r4 = r5 / r4
            float r3 = r3 * r4
            int r4 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x002e
            goto L_0x0032
        L_0x002e:
            r6 = r3
            goto L_0x0032
        L_0x0030:
            r6 = r3
        L_0x0031:
            r5 = r4
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r2 = r6
            r6 = r5
            r5 = r2
        L_0x0037:
            com.xeagle.android.login.common.ImageUtil$ImageSize r3 = new com.xeagle.android.login.common.ImageUtil$ImageSize
            int r4 = (int) r5
            int r5 = (int) r6
            r3.<init>(r4, r5)
            return r3
        L_0x003f:
            com.xeagle.android.login.common.ImageUtil$ImageSize r3 = new com.xeagle.android.login.common.ImageUtil$ImageSize
            int r4 = (int) r6
            r3.<init>(r4, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.ImageUtil.getThumbnailDisplaySize(float, float, float, float):com.xeagle.android.login.common.ImageUtil$ImageSize");
    }

    public static ImageSize getThumbnailDisplaySize(int i2, int i3, String str) {
        int[] decodeBound = BitmapDecoder.decodeBound(str);
        return getThumbnailDisplaySize((float) decodeBound[0], (float) decodeBound[1], (float) i2, (float) i3);
    }

    public static boolean isGif(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().equals("gif");
    }

    public static boolean isInvalidPictureFile(String str) {
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("jpg") || lowerCase.contains("jpeg") || lowerCase.toLowerCase().contains("png") || lowerCase.toLowerCase().contains("bmp") || lowerCase.toLowerCase().contains("gif");
    }

    public static Bitmap rotateBitmapInNeeded(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return null;
        }
        try {
            float imageRotate = getImageRotate(new ExifInterface(str).getAttributeInt("Orientation", 1));
            if (imageRotate == 0.0f) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(imageRotate);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            if (createBitmap == null) {
                return bitmap;
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dc, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dd, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dc A[ExcHandler: Exception (r11v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:17:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Boolean scaleImage(java.io.File r11, java.io.File r12, int r13, android.graphics.Bitmap.CompressFormat r14, int r15) {
        /*
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r1 = r11.getAbsolutePath()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            int r2 = r13 * r13
            int r1 = com.xeagle.android.login.common.SampleSizeUtil.calculateSampleSize(r1, r2)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            java.lang.String r2 = r11.getPath()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            android.graphics.Bitmap r1 = com.xeagle.android.login.common.BitmapDecoder.decodeSampled(r2, r1)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            if (r1 != 0) goto L_0x001a
            return r0
        L_0x001a:
            java.lang.String r2 = r11.getAbsolutePath()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            java.lang.String r2 = getImageType(r2)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r10 = 1
            r4 = 0
            if (r3 != 0) goto L_0x0034
            java.lang.String r3 = "image/png"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            if (r2 == 0) goto L_0x0034
            r11 = 0
            goto L_0x0047
        L_0x0034:
            android.media.ExifInterface r2 = new android.media.ExifInterface     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            java.lang.String r11 = r11.getAbsolutePath()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r2.<init>(r11)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            java.lang.String r11 = "Orientation"
            int r11 = r2.getAttributeInt(r11, r10)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            float r11 = getImageRotate(r11)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
        L_0x0047:
            float r13 = (float) r13     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            float r13 = r13 * r13
            int r2 = r1.getWidth()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            float r2 = (float) r2     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            int r3 = r1.getHeight()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            float r3 = (float) r3     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            float r2 = r2 * r3
            float r13 = r13 / r2
            double r2 = (double) r13     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            double r2 = java.lang.Math.sqrt(r2)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            float r13 = (float) r2
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0069
            int r3 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x0069
            r11 = r1
            goto L_0x008c
        L_0x0069:
            android.graphics.Matrix r8 = new android.graphics.Matrix     // Catch:{ OutOfMemoryError -> 0x00b6, Exception -> 0x00dc }
            r8.<init>()     // Catch:{ OutOfMemoryError -> 0x00b6, Exception -> 0x00dc }
            int r3 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0075
            r8.postRotate(r11)     // Catch:{ OutOfMemoryError -> 0x00b6, Exception -> 0x00dc }
        L_0x0075:
            int r11 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r11 >= 0) goto L_0x007c
            r8.postScale(r13, r13)     // Catch:{ OutOfMemoryError -> 0x00b6, Exception -> 0x00dc }
        L_0x007c:
            r4 = 0
            r5 = 0
            int r6 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x00b6, Exception -> 0x00dc }
            int r7 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x00b6, Exception -> 0x00dc }
            r9 = 1
            r3 = r1
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ OutOfMemoryError -> 0x00b6, Exception -> 0x00dc }
        L_0x008c:
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r2.<init>(r12)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r13.<init>(r2)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r11.compress(r14, r15, r13)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r13.flush()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r13.close()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            boolean r12 = r1.isRecycled()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            if (r12 != 0) goto L_0x00ac
            r1.recycle()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
        L_0x00ac:
            boolean r12 = r11.isRecycled()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            if (r12 != 0) goto L_0x00e0
            r11.recycle()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            goto L_0x00e0
        L_0x00b6:
            java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r13.<init>(r12)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r11.<init>(r13)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r1.compress(r14, r15, r11)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r11.flush()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            r11.close()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            boolean r11 = r1.isRecycled()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
            if (r11 != 0) goto L_0x00d6
            r1.recycle()     // Catch:{ Exception -> 0x00dc, OutOfMemoryError -> 0x00d7 }
        L_0x00d6:
            return r0
        L_0x00d7:
            r11 = move-exception
            r11.printStackTrace()
            goto L_0x00e0
        L_0x00dc:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00e0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.ImageUtil.scaleImage(java.io.File, java.io.File, int, android.graphics.Bitmap$CompressFormat, int):java.lang.Boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f2, code lost:
        if (r1.isRecycled() == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f4, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0139, code lost:
        if (r1.isRecycled() == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x015e, code lost:
        if (r1.isRecycled() == false) goto L_0x00f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af A[Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b1 A[Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011f A[SYNTHETIC, Splitter:B:68:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0144 A[SYNTHETIC, Splitter:B:84:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0166 A[SYNTHETIC, Splitter:B:99:0x0166] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:65:0x011a=Splitter:B:65:0x011a, B:81:0x013f=Splitter:B:81:0x013f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Boolean scaleThumbnail(java.io.File r16, java.io.File r17, int r18, int r19, android.graphics.Bitmap.CompressFormat r20, int r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r4 = 0
            int[] r5 = com.xeagle.android.login.common.BitmapDecoder.decodeBound((java.io.File) r16)     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            r2 = r5[r2]     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            float r2 = (float) r2     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            r6 = 1
            r5 = r5[r6]     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            float r5 = (float) r5     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            float r7 = (float) r0     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            float r8 = (float) r1     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            com.xeagle.android.login.common.ImageUtil$ImageSize r2 = getThumbnailDisplaySize(r2, r5, r7, r8)     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            java.lang.String r5 = r16.getPath()     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            int r7 = r2.width     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            int r8 = r2.height     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            android.graphics.Bitmap r5 = com.xeagle.android.login.common.BitmapDecoder.decodeSampled((java.lang.String) r5, (int) r7, (int) r8)     // Catch:{ OutOfMemoryError -> 0x013c, IOException -> 0x0117, all -> 0x0112 }
            android.media.ExifInterface r7 = new android.media.ExifInterface     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            java.lang.String r8 = r16.getAbsolutePath()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r7.<init>(r8)     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            java.lang.String r8 = "Orientation"
            int r7 = r7.getAttributeInt(r8, r6)     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r7 = getImageRotate(r7)     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            android.graphics.Matrix r14 = new android.graphics.Matrix     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r14.<init>()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r14.postRotate(r7)     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            int r8 = r5.getWidth()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r9 = 1065353216(0x3f800000, float:1.0)
            if (r8 < r1) goto L_0x005d
            int r8 = r5.getHeight()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            if (r8 > r0) goto L_0x005d
            int r8 = r5.getWidth()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            if (r8 < r1) goto L_0x005d
            int r1 = r5.getHeight()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            if (r1 > r0) goto L_0x005d
            goto L_0x006e
        L_0x005d:
            int r0 = r5.getWidth()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            int r1 = r2.width     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            if (r0 != r1) goto L_0x0071
            int r0 = r5.getHeight()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            int r1 = r2.height     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            if (r0 == r1) goto L_0x006e
            goto L_0x0071
        L_0x006e:
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00a3
        L_0x0071:
            int r0 = r2.width     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r0 = (float) r0     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            int r1 = r5.getWidth()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r1 = (float) r1     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r0 = r0 / r1
            int r1 = r2.height     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r1 = (float) r1     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            int r8 = r5.getHeight()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r8 = (float) r8     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r1 = r1 / r8
            int r8 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r8 < 0) goto L_0x0095
            int r1 = r5.getWidth()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r2.width = r1     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            int r1 = r2.height     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r1 = (float) r1     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r1 = r1 / r0
            int r1 = (int) r1     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r2.height = r1     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            goto L_0x00a3
        L_0x0095:
            int r0 = r2.width     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r0 = (float) r0     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            float r0 = r0 / r1
            int r0 = (int) r0     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r2.width = r0     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            int r0 = r5.getHeight()     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r2.height = r0     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r0 = r1
        L_0x00a3:
            r14.postScale(r0, r0)     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r1 = 0
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00b1
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x00b1
            r1 = r5
            goto L_0x00be
        L_0x00b1:
            r10 = 0
            r11 = 0
            int r12 = r2.width     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            int r13 = r2.height     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r15 = 1
            r9 = r5
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ OutOfMemoryError -> 0x010f, IOException -> 0x010c, all -> 0x0107 }
            r1 = r0
        L_0x00be:
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ OutOfMemoryError -> 0x0105, IOException -> 0x0103 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ OutOfMemoryError -> 0x0105, IOException -> 0x0103 }
            r7 = r17
            r0.<init>(r7)     // Catch:{ OutOfMemoryError -> 0x0105, IOException -> 0x0103 }
            r2.<init>(r0)     // Catch:{ OutOfMemoryError -> 0x0105, IOException -> 0x0103 }
            r0 = r20
            r4 = r21
            r1.compress(r0, r4, r2)     // Catch:{ OutOfMemoryError -> 0x0100, IOException -> 0x00fd, all -> 0x00f9 }
            r2.flush()     // Catch:{ OutOfMemoryError -> 0x0100, IOException -> 0x00fd, all -> 0x00f9 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)     // Catch:{ OutOfMemoryError -> 0x0100, IOException -> 0x00fd, all -> 0x00f9 }
            r2.close()     // Catch:{ IOException -> 0x00dc }
            goto L_0x00e1
        L_0x00dc:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x00e1:
            if (r5 == 0) goto L_0x00ec
            boolean r0 = r5.isRecycled()
            if (r0 != 0) goto L_0x00ec
            r5.recycle()
        L_0x00ec:
            if (r1 == 0) goto L_0x0161
            boolean r0 = r1.isRecycled()
            if (r0 != 0) goto L_0x0161
        L_0x00f4:
            r1.recycle()
            goto L_0x0161
        L_0x00f9:
            r0 = move-exception
            r4 = r2
            goto L_0x0163
        L_0x00fd:
            r0 = move-exception
            r4 = r2
            goto L_0x011a
        L_0x0100:
            r0 = move-exception
            r4 = r2
            goto L_0x013f
        L_0x0103:
            r0 = move-exception
            goto L_0x011a
        L_0x0105:
            r0 = move-exception
            goto L_0x013f
        L_0x0107:
            r0 = move-exception
            r2 = r0
            r1 = r4
            goto L_0x0164
        L_0x010c:
            r0 = move-exception
            r1 = r4
            goto L_0x011a
        L_0x010f:
            r0 = move-exception
            r1 = r4
            goto L_0x013f
        L_0x0112:
            r0 = move-exception
            r2 = r0
            r1 = r4
            r5 = r1
            goto L_0x0164
        L_0x0117:
            r0 = move-exception
            r1 = r4
            r5 = r1
        L_0x011a:
            r0.printStackTrace()     // Catch:{ all -> 0x0162 }
            if (r4 == 0) goto L_0x0128
            r4.close()     // Catch:{ IOException -> 0x0123 }
            goto L_0x0128
        L_0x0123:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0128:
            if (r5 == 0) goto L_0x0133
            boolean r0 = r5.isRecycled()
            if (r0 != 0) goto L_0x0133
            r5.recycle()
        L_0x0133:
            if (r1 == 0) goto L_0x0161
            boolean r0 = r1.isRecycled()
            if (r0 != 0) goto L_0x0161
            goto L_0x00f4
        L_0x013c:
            r0 = move-exception
            r1 = r4
            r5 = r1
        L_0x013f:
            r0.printStackTrace()     // Catch:{ all -> 0x0162 }
            if (r4 == 0) goto L_0x014d
            r4.close()     // Catch:{ IOException -> 0x0148 }
            goto L_0x014d
        L_0x0148:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x014d:
            if (r5 == 0) goto L_0x0158
            boolean r0 = r5.isRecycled()
            if (r0 != 0) goto L_0x0158
            r5.recycle()
        L_0x0158:
            if (r1 == 0) goto L_0x0161
            boolean r0 = r1.isRecycled()
            if (r0 != 0) goto L_0x0161
            goto L_0x00f4
        L_0x0161:
            return r3
        L_0x0162:
            r0 = move-exception
        L_0x0163:
            r2 = r0
        L_0x0164:
            if (r4 == 0) goto L_0x016f
            r4.close()     // Catch:{ IOException -> 0x016a }
            goto L_0x016f
        L_0x016a:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x016f:
            if (r5 == 0) goto L_0x017a
            boolean r0 = r5.isRecycled()
            if (r0 != 0) goto L_0x017a
            r5.recycle()
        L_0x017a:
            if (r1 == 0) goto L_0x0185
            boolean r0 = r1.isRecycled()
            if (r0 != 0) goto L_0x0185
            r1.recycle()
        L_0x0185:
            goto L_0x0187
        L_0x0186:
            throw r2
        L_0x0187:
            goto L_0x0186
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.ImageUtil.scaleThumbnail(java.io.File, java.io.File, int, int, android.graphics.Bitmap$CompressFormat, int):java.lang.Boolean");
    }
}
