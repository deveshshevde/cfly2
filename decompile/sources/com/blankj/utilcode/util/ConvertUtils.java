package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.xeagle.android.login.common.StorageUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class ConvertUtils {
    private static final int BUFFER_SIZE = 8192;
    private static final char[] HEX_DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] HEX_DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private ConvertUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        return UtilsBridge.bitmap2Bytes(bitmap);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        return UtilsBridge.bitmap2Bytes(bitmap, compressFormat, i2);
    }

    public static Drawable bitmap2Drawable(Bitmap bitmap) {
        return UtilsBridge.bitmap2Drawable(bitmap);
    }

    public static byte[] bits2Bytes(String str) {
        int length = str.length() % 8;
        int length2 = str.length() / 8;
        if (length != 0) {
            while (length < 8) {
                str = "0" + str;
                length++;
            }
            length2++;
        }
        byte[] bArr = new byte[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                bArr[i2] = (byte) (bArr[i2] << 1);
                bArr[i2] = (byte) (bArr[i2] | (str.charAt((i2 * 8) + i3) - '0'));
            }
        }
        return bArr;
    }

    public static String byte2FitMemorySize(long j2) {
        return byte2FitMemorySize(j2, 3);
    }

    public static String byte2FitMemorySize(long j2, int i2) {
        StringBuilder sb;
        if (i2 < 0) {
            throw new IllegalArgumentException("precision shouldn't be less than zero!");
        } else if (j2 < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        } else if (j2 < 1024) {
            return String.format("%." + i2 + "fB", new Object[]{Double.valueOf((double) j2)});
        } else if (j2 < StorageUtil.M) {
            String str = "%." + i2 + "fKB";
            double d2 = (double) j2;
            Double.isNaN(d2);
            return String.format(str, new Object[]{Double.valueOf(d2 / 1024.0d)});
        } else if (j2 < IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            sb.append("%.");
            sb.append(i2);
            sb.append("fMB");
            String sb2 = sb.toString();
            double d3 = (double) j2;
            Double.isNaN(d3);
            return String.format(sb2, new Object[]{Double.valueOf(d3 / 1048576.0d)});
        } else {
            sb = new StringBuilder();
            sb.append("%.");
            sb.append(i2);
            sb.append("fGB");
            String sb3 = sb.toString();
            double d4 = (double) j2;
            Double.isNaN(d4);
            return String.format(sb3, new Object[]{Double.valueOf(d4 / 1.073741824E9d)});
        }
    }

    public static double byte2MemorySize(long j2, int i2) {
        if (j2 < 0) {
            return -1.0d;
        }
        double d2 = (double) j2;
        double d3 = (double) i2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        return UtilsBridge.bytes2Bitmap(bArr);
    }

    public static String bytes2Bits(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            for (int i2 = 7; i2 >= 0; i2--) {
                sb.append(((b2 >> i2) & 1) == 0 ? '0' : '1');
            }
        }
        return sb.toString();
    }

    public static char[] bytes2Chars(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = (char) (bArr[i2] & 255);
        }
        return cArr;
    }

    public static Drawable bytes2Drawable(byte[] bArr) {
        return UtilsBridge.bytes2Drawable(bArr);
    }

    public static String bytes2HexString(byte[] bArr) {
        return bytes2HexString(bArr, true);
    }

    public static String bytes2HexString(byte[] bArr, boolean z2) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = z2 ? HEX_DIGITS_UPPER : HEX_DIGITS_LOWER;
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr2 = new char[(length << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] >> 4) & 15];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & 15];
        }
        return new String(cArr2);
    }

    public static InputStream bytes2InputStream(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return new ByteArrayInputStream(bArr);
    }

    public static JSONArray bytes2JSONArray(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new JSONArray(new String(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject bytes2JSONObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new JSONObject(new String(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0033 A[SYNTHETIC, Splitter:B:27:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object bytes2Object(byte[] r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x001f, all -> 0x001d }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x001f, all -> 0x001d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x001f, all -> 0x001d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x001f, all -> 0x001d }
            java.lang.Object r3 = r1.readObject()     // Catch:{ Exception -> 0x001b }
            r1.close()     // Catch:{ IOException -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r0 = move-exception
            r0.printStackTrace()
        L_0x001a:
            return r3
        L_0x001b:
            r3 = move-exception
            goto L_0x0021
        L_0x001d:
            r3 = move-exception
            goto L_0x0031
        L_0x001f:
            r3 = move-exception
            r1 = r0
        L_0x0021:
            r3.printStackTrace()     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x002e
            r1.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002e:
            return r0
        L_0x002f:
            r3 = move-exception
            r0 = r1
        L_0x0031:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ConvertUtils.bytes2Object(byte[]):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0023 A[SYNTHETIC, Splitter:B:20:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0030 A[SYNTHETIC, Splitter:B:28:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.OutputStream bytes2OutputStream(byte[] r2) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x0039
            int r1 = r2.length
            if (r1 > 0) goto L_0x0007
            goto L_0x0039
        L_0x0007:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x001c, all -> 0x001a }
            r1.<init>()     // Catch:{ IOException -> 0x001c, all -> 0x001a }
            r1.write(r2)     // Catch:{ IOException -> 0x0018 }
            r1.close()     // Catch:{ IOException -> 0x0013 }
            goto L_0x0017
        L_0x0013:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0017:
            return r1
        L_0x0018:
            r2 = move-exception
            goto L_0x001e
        L_0x001a:
            r2 = move-exception
            goto L_0x002e
        L_0x001c:
            r2 = move-exception
            r1 = r0
        L_0x001e:
            r2.printStackTrace()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x002b
        L_0x0027:
            r2 = move-exception
            r2.printStackTrace()
        L_0x002b:
            return r0
        L_0x002c:
            r2 = move-exception
            r0 = r1
        L_0x002e:
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0038:
            throw r2
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ConvertUtils.bytes2OutputStream(byte[]):java.io.OutputStream");
    }

    public static <T> T bytes2Parcelable(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static String bytes2String(byte[] bArr) {
        return bytes2String(bArr, "");
    }

    public static String bytes2String(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, getSafeCharset(str));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return new String(bArr);
        }
    }

    public static byte[] chars2Bytes(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return null;
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) cArr[i2];
        }
        return bArr;
    }

    public static int dp2px(float f2) {
        return UtilsBridge.dp2px(f2);
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        return UtilsBridge.drawable2Bitmap(drawable);
    }

    public static byte[] drawable2Bytes(Drawable drawable) {
        return UtilsBridge.drawable2Bytes(drawable);
    }

    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat, int i2) {
        return UtilsBridge.drawable2Bytes(drawable, compressFormat, i2);
    }

    private static String getSafeCharset(String str) {
        return (UtilsBridge.isSpace(str) || !Charset.isSupported(str)) ? "UTF-8" : str;
    }

    private static int hex2Dec(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'A' && c2 <= 'F') {
            return (c2 - 'A') + 10;
        }
        throw new IllegalArgumentException();
    }

    public static byte[] hexString2Bytes(String str) {
        if (UtilsBridge.isSpace(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        char[] charArray = str.toUpperCase().toCharArray();
        byte[] bArr = new byte[(length >> 1)];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 >> 1] = (byte) ((hex2Dec(charArray[i2]) << 4) | hex2Dec(charArray[i2 + 1]));
        }
        return bArr;
    }

    public static int hexString2Int(String str) {
        return Integer.parseInt(str, 16);
    }

    public static ByteArrayOutputStream input2OutputStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr, 0, BUFFER_SIZE);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            inputStream.close();
            return byteArrayOutputStream;
        } catch (IOException e3) {
            e3.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static byte[] inputStream2Bytes(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return input2OutputStream(inputStream).toByteArray();
    }

    public static List<String> inputStream2Lines(InputStream inputStream) {
        return inputStream2Lines(inputStream, "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[SYNTHETIC, Splitter:B:19:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f A[SYNTHETIC, Splitter:B:27:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> inputStream2Lines(java.io.InputStream r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ IOException -> 0x002b, all -> 0x0029 }
            r1.<init>()     // Catch:{ IOException -> 0x002b, all -> 0x0029 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x002b, all -> 0x0029 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x002b, all -> 0x0029 }
            java.lang.String r5 = getSafeCharset(r5)     // Catch:{ IOException -> 0x002b, all -> 0x0029 }
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x002b, all -> 0x0029 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x002b, all -> 0x0029 }
        L_0x0014:
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0027 }
            if (r4 == 0) goto L_0x001e
            r1.add(r4)     // Catch:{ IOException -> 0x0027 }
            goto L_0x0014
        L_0x001e:
            r2.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0026:
            return r1
        L_0x0027:
            r4 = move-exception
            goto L_0x002d
        L_0x0029:
            r4 = move-exception
            goto L_0x003d
        L_0x002b:
            r4 = move-exception
            r2 = r0
        L_0x002d:
            r4.printStackTrace()     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003a:
            return r0
        L_0x003b:
            r4 = move-exception
            r0 = r2
        L_0x003d:
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0047:
            goto L_0x0049
        L_0x0048:
            throw r4
        L_0x0049:
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ConvertUtils.inputStream2Lines(java.io.InputStream, java.lang.String):java.util.List");
    }

    public static String inputStream2String(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        try {
            ByteArrayOutputStream input2OutputStream = input2OutputStream(inputStream);
            return input2OutputStream == null ? "" : input2OutputStream.toString(getSafeCharset(str));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String int2HexString(int i2) {
        return Integer.toHexString(i2);
    }

    public static byte[] jsonArray2Bytes(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString().getBytes();
    }

    public static byte[] jsonObject2Bytes(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString().getBytes();
    }

    public static long memorySize2Byte(long j2, int i2) {
        if (j2 < 0) {
            return -1;
        }
        return j2 * ((long) i2);
    }

    public static String millis2FitTimeSpan(long j2, int i2) {
        return UtilsBridge.millis2FitTimeSpan(j2, i2);
    }

    public static long millis2TimeSpan(long j2, int i2) {
        return j2 / ((long) i2);
    }

    public static ByteArrayInputStream output2InputStream(OutputStream outputStream) {
        if (outputStream == null) {
            return null;
        }
        return new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
    }

    public static byte[] outputStream2Bytes(OutputStream outputStream) {
        if (outputStream == null) {
            return null;
        }
        return ((ByteArrayOutputStream) outputStream).toByteArray();
    }

    public static String outputStream2String(OutputStream outputStream, String str) {
        if (outputStream == null) {
            return "";
        }
        try {
            return new String(outputStream2Bytes(outputStream), getSafeCharset(str));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static byte[] parcelable2Bytes(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static int px2dp(float f2) {
        return UtilsBridge.px2dp(f2);
    }

    public static int px2sp(float f2) {
        return UtilsBridge.px2sp(f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029 A[SYNTHETIC, Splitter:B:19:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0036 A[SYNTHETIC, Splitter:B:27:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] serializable2Bytes(java.io.Serializable r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0022, all -> 0x0020 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0022, all -> 0x0020 }
            r2.<init>()     // Catch:{ Exception -> 0x0022, all -> 0x0020 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0022, all -> 0x0020 }
            r1.writeObject(r3)     // Catch:{ Exception -> 0x001e }
            byte[] r3 = r2.toByteArray()     // Catch:{ Exception -> 0x001e }
            r1.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r0 = move-exception
            r0.printStackTrace()
        L_0x001d:
            return r3
        L_0x001e:
            r3 = move-exception
            goto L_0x0024
        L_0x0020:
            r3 = move-exception
            goto L_0x0034
        L_0x0022:
            r3 = move-exception
            r1 = r0
        L_0x0024:
            r3.printStackTrace()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0031:
            return r0
        L_0x0032:
            r3 = move-exception
            r0 = r1
        L_0x0034:
            if (r0 == 0) goto L_0x003e
            r0.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ConvertUtils.serializable2Bytes(java.io.Serializable):byte[]");
    }

    public static int sp2px(float f2) {
        return UtilsBridge.sp2px(f2);
    }

    public static byte[] string2Bytes(String str) {
        return string2Bytes(str, "");
    }

    public static byte[] string2Bytes(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(getSafeCharset(str2));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str.getBytes();
        }
    }

    public static InputStream string2InputStream(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new ByteArrayInputStream(str.getBytes(getSafeCharset(str2)));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static OutputStream string2OutputStream(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return bytes2OutputStream(str.getBytes(getSafeCharset(str2)));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static long timeSpan2Millis(long j2, int i2) {
        return j2 * ((long) i2);
    }

    public static Bitmap view2Bitmap(View view) {
        return UtilsBridge.view2Bitmap(view);
    }
}
