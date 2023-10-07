package com.sun.mail.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASCIIUtility {
    private ASCIIUtility() {
    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        if (inputStream instanceof ByteArrayInputStream) {
            int available = inputStream.available();
            byte[] bArr = new byte[available];
            inputStream.read(bArr, 0, available);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr2, 0, 1024);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static byte[] getBytes(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) charArray[i2];
        }
        return bArr;
    }

    public static int parseInt(byte[] bArr, int i2, int i3) throws NumberFormatException {
        return parseInt(bArr, i2, i3, 10);
    }

    public static int parseInt(byte[] bArr, int i2, int i3, int i4) throws NumberFormatException {
        boolean z2;
        int i5;
        int i6;
        if (bArr == null) {
            throw new NumberFormatException("null");
        } else if (i3 > i2) {
            int i7 = 0;
            if (bArr[i2] == 45) {
                i6 = Integer.MIN_VALUE;
                i5 = i2 + 1;
                z2 = true;
            } else {
                i6 = -2147483647;
                i5 = i2;
                z2 = false;
            }
            int i8 = i6 / i4;
            if (i5 < i3) {
                int i9 = i5 + 1;
                int digit = Character.digit((char) bArr[i5], i4);
                if (digit >= 0) {
                    int i10 = i9;
                    i7 = -digit;
                    i5 = i10;
                } else {
                    throw new NumberFormatException("illegal number: " + toString(bArr, i2, i3));
                }
            }
            while (i5 < i3) {
                int i11 = i5 + 1;
                int digit2 = Character.digit((char) bArr[i5], i4);
                if (digit2 < 0) {
                    throw new NumberFormatException("illegal number");
                } else if (i7 >= i8) {
                    int i12 = i7 * i4;
                    if (i12 >= i6 + digit2) {
                        i7 = i12 - digit2;
                        i5 = i11;
                    } else {
                        throw new NumberFormatException("illegal number");
                    }
                } else {
                    throw new NumberFormatException("illegal number");
                }
            }
            if (!z2) {
                return -i7;
            }
            if (i5 > i2 + 1) {
                return i7;
            }
            throw new NumberFormatException("illegal number");
        } else {
            throw new NumberFormatException("illegal number");
        }
    }

    public static long parseLong(byte[] bArr, int i2, int i3) throws NumberFormatException {
        return parseLong(bArr, i2, i3, 10);
    }

    public static long parseLong(byte[] bArr, int i2, int i3, int i4) throws NumberFormatException {
        long j2;
        boolean z2;
        int i5;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (bArr != null) {
            long j3 = 0;
            if (i7 > i6) {
                if (bArr[i6] == 45) {
                    i5 = i6 + 1;
                    j2 = Long.MIN_VALUE;
                    z2 = true;
                } else {
                    i5 = i6;
                    j2 = -9223372036854775807L;
                    z2 = false;
                }
                long j4 = (long) i8;
                long j5 = j2 / j4;
                if (i5 < i7) {
                    int i9 = i5 + 1;
                    int digit = Character.digit((char) bArr[i5], i8);
                    if (digit >= 0) {
                        i5 = i9;
                        j3 = (long) (-digit);
                    } else {
                        throw new NumberFormatException("illegal number: " + toString(bArr, i2, i3));
                    }
                }
                while (i5 < i7) {
                    int i10 = i5 + 1;
                    int digit2 = Character.digit((char) bArr[i5], i8);
                    if (digit2 < 0) {
                        throw new NumberFormatException("illegal number");
                    } else if (j3 >= j5) {
                        long j6 = j3 * j4;
                        long j7 = (long) digit2;
                        if (j6 >= j2 + j7) {
                            j3 = j6 - j7;
                            i6 = i2;
                            i7 = i3;
                            i5 = i10;
                        } else {
                            throw new NumberFormatException("illegal number");
                        }
                    } else {
                        throw new NumberFormatException("illegal number");
                    }
                }
                if (!z2) {
                    return -j3;
                }
                if (i5 > i6 + 1) {
                    return j3;
                }
                throw new NumberFormatException("illegal number");
            }
            throw new NumberFormatException("illegal number");
        }
        throw new NumberFormatException("null");
    }

    public static String toString(ByteArrayInputStream byteArrayInputStream) {
        int available = byteArrayInputStream.available();
        char[] cArr = new char[available];
        byte[] bArr = new byte[available];
        byteArrayInputStream.read(bArr, 0, available);
        for (int i2 = 0; i2 < available; i2++) {
            cArr[i2] = (char) (bArr[i2] & 255);
        }
        return new String(cArr);
    }

    public static String toString(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        char[] cArr = new char[i4];
        int i5 = 0;
        while (i5 < i4) {
            cArr[i5] = (char) (bArr[i2] & 255);
            i5++;
            i2++;
        }
        return new String(cArr);
    }
}
