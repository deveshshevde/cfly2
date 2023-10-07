package com.sun.mail.imap.protocol;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class BASE64MailboxDecoder {
    static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', ','};
    private static final byte[] pem_convert_array = new byte[256];

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 255; i3++) {
            pem_convert_array[i3] = -1;
        }
        while (true) {
            char[] cArr = pem_array;
            if (i2 < cArr.length) {
                pem_convert_array[cArr[i2]] = (byte) i2;
                i2++;
            } else {
                return;
            }
        }
    }

    protected static int base64decode(char[] cArr, int i2, CharacterIterator characterIterator) {
        byte b2;
        byte b3;
        boolean z2 = true;
        while (true) {
            byte b4 = -1;
            while (true) {
                byte next = (byte) characterIterator.next();
                if (next == -1) {
                    return i2;
                }
                if (next != 45) {
                    z2 = false;
                    byte next2 = (byte) characterIterator.next();
                    if (next2 == -1 || next2 == 45) {
                        return i2;
                    }
                    byte[] bArr = pem_convert_array;
                    byte b5 = bArr[next & 255];
                    byte b6 = bArr[next2 & 255];
                    byte b7 = (byte) (((b5 << 2) & 252) | ((b6 >>> 4) & 3));
                    if (b4 != -1) {
                        cArr[i2] = (char) ((b4 << 8) | (b7 & 255));
                        i2++;
                        b4 = -1;
                    } else {
                        b4 = b7 & 255;
                    }
                    byte next3 = (byte) characterIterator.next();
                    if (next3 != 61) {
                        if (next3 == -1 || next3 == 45) {
                            return i2;
                        }
                        byte b8 = bArr[next3 & 255];
                        byte b9 = (byte) (((b6 << 4) & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) | ((b8 >>> 2) & 15));
                        if (b4 != -1) {
                            cArr[i2] = (char) ((b4 << 8) | (b9 & 255));
                            i2++;
                            b3 = -1;
                        } else {
                            b3 = b9 & 255;
                        }
                        byte next4 = (byte) characterIterator.next();
                        if (next4 == 61) {
                            continue;
                        } else if (next4 == -1 || next4 == 45) {
                            return i2;
                        } else {
                            b2 = (byte) (((b8 << 6) & 192) | (bArr[next4 & 255] & 63));
                            if (b4 != -1) {
                                break;
                            }
                            b4 = b2 & 255;
                        }
                    }
                } else if (!z2) {
                    return i2;
                } else {
                    cArr[i2] = '&';
                    return i2 + 1;
                }
            }
            cArr[i2] = (char) ((b4 << 8) | (b2 & 255));
            i2++;
        }
    }

    public static String decode(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cArr = new char[str.length()];
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        boolean z2 = false;
        int i2 = 0;
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '&') {
                z2 = true;
                i2 = base64decode(cArr, i2, stringCharacterIterator);
            } else {
                cArr[i2] = first;
                i2++;
            }
        }
        return z2 ? new String(cArr, 0, i2) : str;
    }
}
