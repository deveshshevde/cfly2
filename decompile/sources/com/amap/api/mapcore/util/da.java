package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class da {
    private static int a(byte[] bArr, int i2) {
        byte b2 = bArr[i2 + 0];
        byte b3 = bArr[i2 + 1];
        byte b4 = bArr[i2 + 2];
        return (bArr[i2 + 3] << 24) | (b2 & 255) | (b3 << 8) | (b4 << 16);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(java.io.InputStream r6) throws java.lang.Exception {
        /*
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r6)
            byte[] r0 = a((android.graphics.Bitmap) r6)
            boolean r1 = android.graphics.NinePatch.isNinePatchChunk(r0)
            if (r1 == 0) goto L_0x0055
            int r1 = r6.getWidth()
            int r1 = r1 + -2
            int r2 = r6.getHeight()
            int r2 = r2 + -2
            r3 = 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r6, r3, r3, r1, r2)
            com.amap.api.mapcore.util.dl.a((android.graphics.Bitmap) r6)
            int r6 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r6 < r2) goto L_0x0044
            java.lang.Class r6 = r1.getClass()
            java.lang.Class[] r2 = new java.lang.Class[r3]
            java.lang.Class<byte[]> r4 = byte[].class
            r5 = 0
            r2[r5] = r4
            java.lang.String r4 = "setNinePatchChunk"
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r4, r2)
            r6.setAccessible(r3)
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r5] = r0
            r6.invoke(r1, r2)
            goto L_0x0054
        L_0x0044:
            java.lang.Class r6 = r1.getClass()
            java.lang.String r2 = "mNinePatchChunk"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r2)
            r6.setAccessible(r3)
            r6.set(r1, r0)
        L_0x0054:
            return r1
        L_0x0055:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.da.a(java.io.InputStream):android.graphics.Bitmap");
    }

    public static Drawable a(Context context, String str) throws Exception {
        Bitmap b2 = b(context, str);
        if (b2.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), b2);
        }
        Rect rect = new Rect();
        a(b2.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), b2, b2.getNinePatchChunk(), rect, (String) null);
    }

    private static void a(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= width) {
                break;
            } else if (-16777216 == iArr[i3]) {
                a(bArr, 12, i3);
                break;
            } else {
                i3++;
            }
        }
        int i4 = width - 1;
        while (true) {
            if (i4 < 0) {
                break;
            } else if (-16777216 == iArr[i4]) {
                a(bArr, 16, (width - i4) - 2);
                break;
            } else {
                i4--;
            }
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        while (true) {
            if (i2 >= height) {
                break;
            } else if (-16777216 == iArr2[i2]) {
                a(bArr, 20, i2);
                break;
            } else {
                i2++;
            }
        }
        for (int i5 = height - 1; i5 >= 0; i5--) {
            if (-16777216 == iArr2[i5]) {
                a(bArr, 24, (height - i5) - 2);
                return;
            }
        }
    }

    private static void a(OutputStream outputStream, int i2) throws IOException {
        outputStream.write((i2 >> 0) & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write((i2 >> 24) & 255);
    }

    private static void a(byte[] bArr, int i2, int i3) {
        bArr[i2 + 0] = (byte) (i3 >> 0);
        bArr[i2 + 1] = (byte) (i3 >> 8);
        bArr[i2 + 2] = (byte) (i3 >> 16);
        bArr[i2 + 3] = (byte) (i3 >> 24);
    }

    private static void a(byte[] bArr, Rect rect) {
        rect.left = a(bArr, 12);
        rect.right = a(bArr, 16);
        rect.top = a(bArr, 20);
        rect.bottom = a(bArr, 24);
    }

    private static byte[] a(Bitmap bitmap) throws IOException {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < 32; i2++) {
            byteArrayOutputStream.write(0);
        }
        int i3 = width - 2;
        int[] iArr = new int[i3];
        bitmap.getPixels(iArr, 0, width, 1, 0, i3, 1);
        boolean z2 = iArr[0] == -16777216;
        boolean z3 = iArr[i3 + -1] == -16777216;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            if (i4 != iArr[i6]) {
                i5++;
                a((OutputStream) byteArrayOutputStream, i6);
                i4 = iArr[i6];
            }
        }
        if (z3) {
            i5++;
            a((OutputStream) byteArrayOutputStream, i3);
        }
        int i7 = i5 + 1;
        if (z2) {
            i7--;
        }
        if (z3) {
            i7--;
        }
        int i8 = height - 2;
        int[] iArr2 = new int[i8];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i8);
        boolean z4 = iArr2[0] == -16777216;
        boolean z5 = iArr2[i8 + -1] == -16777216;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i8; i11++) {
            if (i9 != iArr2[i11]) {
                i10++;
                a((OutputStream) byteArrayOutputStream, i11);
                i9 = iArr2[i11];
            }
        }
        if (z5) {
            i10++;
            a((OutputStream) byteArrayOutputStream, i8);
        }
        int i12 = i10 + 1;
        if (z4) {
            i12--;
        }
        if (z5) {
            i12--;
        }
        int i13 = 0;
        while (true) {
            int i14 = i7 * i12;
            if (i13 < i14) {
                a((OutputStream) byteArrayOutputStream, 1);
                i13++;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i5;
                byteArray[2] = (byte) i10;
                byteArray[3] = (byte) i14;
                a(bitmap, byteArray);
                return byteArray;
            }
        }
    }

    private static Bitmap b(Context context, String str) throws Exception {
        InputStream open = df.a(context).open(str);
        Bitmap a2 = a(open);
        open.close();
        return a2;
    }
}
