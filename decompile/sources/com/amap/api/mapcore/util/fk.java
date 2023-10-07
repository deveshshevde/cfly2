package com.amap.api.mapcore.util;

import com.xeagle.android.login.common.NetworkUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class fk {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f8780a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f8781b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f8782c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, NetworkUtil.CURRENT_NETWORK_TYPE_CUC, NetworkUtil.CURRENT_NETWORK_TYPE_CM, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f8783d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f8784e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, NetworkUtil.CURRENT_NETWORK_TYPE_CUC, NetworkUtil.CURRENT_NETWORK_TYPE_CM, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f8785f = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f8786g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, NetworkUtil.CURRENT_NETWORK_TYPE_CUC, NetworkUtil.CURRENT_NETWORK_TYPE_CM, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private fk() {
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, bArr.length);
        } catch (IOException e2) {
            if (f8780a) {
                str = null;
            } else {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (f8780a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    private static String a(byte[] bArr, int i2) throws IOException {
        Objects.requireNonNull(bArr, "Cannot serialize a null array.");
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i2)));
        } else if (i2 + 0 <= bArr.length) {
            int i3 = 4;
            int i4 = (i2 / 3) * 4;
            if (i2 % 3 <= 0) {
                i3 = 0;
            }
            int i5 = i4 + i3;
            byte[] bArr2 = new byte[i5];
            int i6 = i2 - 2;
            int i7 = 0;
            int i8 = 0;
            while (i7 < i6) {
                a(bArr, i7 + 0, 3, bArr2, i8);
                i7 += 3;
                i8 += 4;
            }
            if (i7 < i2) {
                a(bArr, i7 + 0, i2 - i7, bArr2, i8);
                i8 += 4;
            }
            if (i8 <= i5 - 1) {
                byte[] bArr3 = new byte[i8];
                System.arraycopy(bArr2, 0, bArr3, 0, i8);
                bArr2 = bArr3;
            }
            try {
                return new String(bArr2, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr2);
            }
        } else {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{0, Integer.valueOf(i2), Integer.valueOf(bArr.length)}));
        }
    }

    public static byte[] a(String str) throws IOException {
        return b(str);
    }

    private static byte[] a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        byte[] bArr3 = f8781b;
        int i5 = 0;
        int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0);
        if (i3 > 2) {
            i5 = (bArr[i2 + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i3 == 1) {
            bArr2[i4] = bArr3[i7 >>> 18];
            bArr2[i4 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 == 2) {
            bArr2[i4] = bArr3[i7 >>> 18];
            bArr2[i4 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i4 + 2] = bArr3[(i7 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 != 3) {
            return bArr2;
        } else {
            bArr2[i4] = bArr3[i7 >>> 18];
            bArr2[i4 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i4 + 2] = bArr3[(i7 >>> 6) & 63];
            bArr2[i4 + 3] = bArr3[i7 & 63];
            return bArr2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:9|10|11|12|13|14|15|(3:16|17|(1:19)(1:58))|20|21|22|23|24|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|(10:10|11|12|13|14|15|(3:16|17|(1:19)(1:58))|20|21|22)|23|24|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:47|48|49|50|51|(2:52|53)|54) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0055 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x007f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0082 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b(java.lang.String r6) throws java.io.IOException {
        /*
            java.lang.String r0 = "Input string was null."
            java.util.Objects.requireNonNull(r6, r0)
            java.lang.String r0 = "US-ASCII"
            byte[] r6 = r6.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x000c }
            goto L_0x0010
        L_0x000c:
            byte[] r6 = r6.getBytes()
        L_0x0010:
            int r0 = r6.length
            byte[] r6 = b(r6, r0)
            int r0 = r6.length
            r1 = 4
            if (r0 < r1) goto L_0x0086
            r0 = 0
            byte r1 = r6[r0]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 1
            byte r2 = r6[r2]
            int r2 = r2 << 8
            r3 = 65280(0xff00, float:9.1477E-41)
            r2 = r2 & r3
            r1 = r1 | r2
            r2 = 35615(0x8b1f, float:4.9907E-41)
            if (r2 != r1) goto L_0x0086
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0071, all -> 0x006d }
            r3.<init>()     // Catch:{ IOException -> 0x0071, all -> 0x006d }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            r4.<init>(r6)     // Catch:{ IOException -> 0x0068, all -> 0x0063 }
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
        L_0x0041:
            int r2 = r5.read(r1)     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            if (r2 < 0) goto L_0x004b
            r3.write(r1, r0, r2)     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            goto L_0x0041
        L_0x004b:
            byte[] r6 = r3.toByteArray()     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            r3.close()     // Catch:{ Exception -> 0x0052 }
        L_0x0052:
            r5.close()     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            r4.close()     // Catch:{ Exception -> 0x0086 }
            goto L_0x0086
        L_0x0059:
            r6 = move-exception
            goto L_0x0066
        L_0x005b:
            r0 = move-exception
            goto L_0x006b
        L_0x005d:
            r6 = move-exception
            r5 = r2
            goto L_0x0066
        L_0x0060:
            r0 = move-exception
            r5 = r2
            goto L_0x006b
        L_0x0063:
            r6 = move-exception
            r4 = r2
            r5 = r4
        L_0x0066:
            r2 = r3
            goto L_0x007c
        L_0x0068:
            r0 = move-exception
            r4 = r2
            r5 = r4
        L_0x006b:
            r2 = r3
            goto L_0x0074
        L_0x006d:
            r6 = move-exception
            r4 = r2
            r5 = r4
            goto L_0x007c
        L_0x0071:
            r0 = move-exception
            r4 = r2
            r5 = r4
        L_0x0074:
            r0.printStackTrace()     // Catch:{ all -> 0x007b }
            r2.close()     // Catch:{ Exception -> 0x0052 }
            goto L_0x0052
        L_0x007b:
            r6 = move-exception
        L_0x007c:
            r2.close()     // Catch:{ Exception -> 0x007f }
        L_0x007f:
            r5.close()     // Catch:{ Exception -> 0x0082 }
        L_0x0082:
            r4.close()     // Catch:{ Exception -> 0x0085 }
        L_0x0085:
            throw r6
        L_0x0086:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fk.b(java.lang.String):byte[]");
    }

    private static byte[] b(byte[] bArr, int i2) throws IOException {
        int i3;
        byte[] bArr2 = bArr;
        int i4 = i2;
        Objects.requireNonNull(bArr2, "Cannot decode null source array.");
        int i5 = i4 + 0;
        int i6 = 1;
        if (i5 > bArr2.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(bArr2.length), 0, Integer.valueOf(i2)}));
        } else if (i4 == 0) {
            return new byte[0];
        } else {
            if (i4 >= 4) {
                byte[] bArr3 = f8782c;
                int i7 = (i4 * 3) / 4;
                byte[] bArr4 = new byte[i7];
                byte[] bArr5 = new byte[4];
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (i8 < i5) {
                    byte b2 = bArr3[bArr2[i8] & 255];
                    if (b2 >= -5) {
                        if (b2 >= -1) {
                            int i11 = i9 + 1;
                            bArr5[i9] = bArr2[i8];
                            if (i11 <= 3) {
                                i9 = i11;
                            } else if (i10 < 0 || (i3 = i10 + 2) >= i7) {
                                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(i7), Integer.valueOf(i10)}));
                            } else {
                                byte[] bArr6 = f8782c;
                                if (bArr5[2] == 61) {
                                    bArr4[i10] = (byte) ((((bArr6[bArr5[0]] & 255) << 18) | ((bArr6[bArr5[i6]] & 255) << NetworkUtil.CURRENT_NETWORK_TYPE_CM)) >>> 16);
                                } else if (bArr5[3] == 61) {
                                    int i12 = ((bArr6[bArr5[0]] & 255) << 18) | ((bArr6[bArr5[i6]] & 255) << NetworkUtil.CURRENT_NETWORK_TYPE_CM) | ((bArr6[bArr5[2]] & 255) << 6);
                                    bArr4[i10] = (byte) (i12 >>> 16);
                                    bArr4[i10 + 1] = (byte) (i12 >>> 8);
                                    i6 = 2;
                                } else {
                                    byte b3 = ((bArr6[bArr5[i6]] & 255) << NetworkUtil.CURRENT_NETWORK_TYPE_CM) | ((bArr6[bArr5[0]] & 255) << 18) | ((bArr6[bArr5[2]] & 255) << 6) | (bArr6[bArr5[3]] & 255);
                                    bArr4[i10] = (byte) (b3 >> 16);
                                    bArr4[i10 + 1] = (byte) (b3 >> 8);
                                    bArr4[i3] = (byte) b3;
                                    i6 = 3;
                                }
                                i10 += i6;
                                if (bArr2[i8] == 61) {
                                    break;
                                }
                                i9 = 0;
                            }
                        }
                        i8++;
                        i6 = 1;
                    } else {
                        throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", new Object[]{Integer.valueOf(bArr2[i8] & 255), Integer.valueOf(i8)}));
                    }
                }
                byte[] bArr7 = new byte[i10];
                System.arraycopy(bArr4, 0, bArr7, 0, i10);
                return bArr7;
            }
            throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(i2)));
        }
    }
}
