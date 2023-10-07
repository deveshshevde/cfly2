package com.sun.mail.util;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BASE64DecoderStream extends FilterInputStream {
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] pem_convert_array = new byte[256];
    private byte[] buffer;
    private int bufsize;
    private boolean ignoreErrors;
    private int index;
    private byte[] input_buffer;
    private int input_len;
    private int input_pos;

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

    public BASE64DecoderStream(InputStream inputStream) {
        super(inputStream);
        this.buffer = new byte[3];
        boolean z2 = false;
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = false;
        try {
            String property = System.getProperty("mail.mime.base64.ignoreerrors");
            if (property != null && !property.equalsIgnoreCase("false")) {
                z2 = true;
            }
            this.ignoreErrors = z2;
        } catch (SecurityException unused) {
        }
    }

    public BASE64DecoderStream(InputStream inputStream, boolean z2) {
        super(inputStream);
        this.buffer = new byte[3];
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = false;
        this.ignoreErrors = z2;
    }

    private int decode(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i2;
        while (i3 >= 3) {
            boolean z2 = false;
            int i5 = 0;
            int i6 = 0;
            while (i5 < 4) {
                int i7 = getByte();
                if (i7 == -1 || i7 == -2) {
                    if (i7 == -1) {
                        if (i5 == 0) {
                            return i4 - i2;
                        }
                        if (this.ignoreErrors) {
                            z2 = true;
                        } else {
                            throw new IOException("Error in encoded stream: needed 4 valid base64 characters but only got " + i5 + " before EOF" + recentChars());
                        }
                    } else if (i5 < 2 && !this.ignoreErrors) {
                        throw new IOException("Error in encoded stream: needed at least 2 valid base64 characters, but only got " + i5 + " before padding character (=)" + recentChars());
                    } else if (i5 == 0) {
                        return i4 - i2;
                    }
                    int i8 = i5 - 1;
                    if (i8 == 0) {
                        i8 = 1;
                    }
                    int i9 = i6 << 6;
                    for (int i10 = i5 + 1; i10 < 4; i10++) {
                        if (!z2) {
                            int i11 = getByte();
                            if (i11 == -1) {
                                if (!this.ignoreErrors) {
                                    throw new IOException("Error in encoded stream: hit EOF while looking for padding characters (=)" + recentChars());
                                }
                            } else if (i11 != -2 && !this.ignoreErrors) {
                                throw new IOException("Error in encoded stream: found valid base64 character after a padding character (=)" + recentChars());
                            }
                        }
                        i9 <<= 6;
                    }
                    int i12 = i9 >> 8;
                    if (i8 == 2) {
                        bArr[i4 + 1] = (byte) (i12 & 255);
                    }
                    bArr[i4] = (byte) ((i12 >> 8) & 255);
                    return (i4 + i8) - i2;
                }
                i5++;
                i6 = (i6 << 6) | i7;
            }
            bArr[i4 + 2] = (byte) (i6 & 255);
            int i13 = i6 >> 8;
            bArr[i4 + 1] = (byte) (i13 & 255);
            bArr[i4] = (byte) ((i13 >> 8) & 255);
            i3 -= 3;
            i4 += 3;
        }
        return i4 - i2;
    }

    public static byte[] decode(byte[] bArr) {
        int i2;
        int length = (bArr.length / 4) * 3;
        if (length == 0) {
            return bArr;
        }
        if (bArr[bArr.length - 1] == 61) {
            length--;
            if (bArr[bArr.length - 2] == 61) {
                length--;
            }
        }
        byte[] bArr2 = new byte[length];
        int length2 = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (length2 > 0) {
            byte[] bArr3 = pem_convert_array;
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            int i7 = ((bArr3[bArr[i3] & 255] << 6) | bArr3[bArr[i5] & 255]) << 6;
            if (bArr[i6] != 61) {
                i7 |= bArr3[bArr[i6] & 255];
                i6++;
                i2 = 3;
            } else {
                i2 = 2;
            }
            int i8 = i7 << 6;
            if (bArr[i6] != 61) {
                i8 |= bArr3[bArr[i6] & 255];
                i6++;
            } else {
                i2--;
            }
            if (i2 > 2) {
                bArr2[i4 + 2] = (byte) (i8 & 255);
            }
            int i9 = i8 >> 8;
            if (i2 > 1) {
                bArr2[i4 + 1] = (byte) (i9 & 255);
            }
            bArr2[i4] = (byte) ((i9 >> 8) & 255);
            i4 += i2;
            length2 -= 4;
            i3 = i6;
        }
        return bArr2;
    }

    private int getByte() throws IOException {
        byte b2;
        do {
            if (this.input_pos >= this.input_len) {
                try {
                    int read = this.in.read(this.input_buffer);
                    this.input_len = read;
                    if (read <= 0) {
                        return -1;
                    }
                    this.input_pos = 0;
                } catch (EOFException unused) {
                    return -1;
                }
            }
            byte[] bArr = this.input_buffer;
            int i2 = this.input_pos;
            this.input_pos = i2 + 1;
            byte b3 = bArr[i2] & 255;
            if (b3 == 61) {
                return -2;
            }
            b2 = pem_convert_array[b3];
        } while (b2 == -1);
        return b2;
    }

    private String recentChars() {
        String str;
        String str2;
        StringBuilder sb;
        StringBuilder sb2;
        int i2 = this.input_pos;
        if (i2 > 10) {
            i2 = 10;
        }
        if (i2 <= 0) {
            return "";
        }
        String str3 = "" + ", the " + i2 + " most recent characters were: \"";
        for (int i3 = this.input_pos - i2; i3 < this.input_pos; i3++) {
            char c2 = (char) (this.input_buffer[i3] & 255);
            if (c2 == 9) {
                sb = new StringBuilder(String.valueOf(str3));
                str2 = "\\t";
            } else if (c2 == 10) {
                sb = new StringBuilder(String.valueOf(str3));
                str2 = "\\n";
            } else if (c2 != 13) {
                if (c2 < ' ' || c2 >= 127) {
                    sb2 = new StringBuilder(String.valueOf(str3));
                    sb2.append("\\");
                    sb2.append(c2);
                } else {
                    sb2 = new StringBuilder(String.valueOf(str3));
                    sb2.append(c2);
                }
                str = sb2.toString();
                str3 = str;
            } else {
                sb = new StringBuilder(String.valueOf(str3));
                str2 = "\\r";
            }
            sb.append(str2);
            str = sb.toString();
            str3 = str;
        }
        return String.valueOf(str3) + "\"";
    }

    public int available() throws IOException {
        return ((this.in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            byte[] bArr = this.buffer;
            int decode = decode(bArr, 0, bArr.length);
            this.bufsize = decode;
            if (decode <= 0) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr2 = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        return bArr2[i2] & 255;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r0 = r7
        L_0x0001:
            int r1 = r5.index
            int r2 = r5.bufsize
            if (r1 >= r2) goto L_0x001a
            if (r8 > 0) goto L_0x000a
            goto L_0x001a
        L_0x000a:
            int r2 = r0 + 1
            byte[] r3 = r5.buffer
            int r4 = r1 + 1
            r5.index = r4
            byte r1 = r3[r1]
            r6[r0] = r1
            int r8 = r8 + -1
            r0 = r2
            goto L_0x0001
        L_0x001a:
            if (r1 < r2) goto L_0x0021
            r1 = 0
            r5.index = r1
            r5.bufsize = r1
        L_0x0021:
            int r1 = r8 / 3
            int r1 = r1 * 3
            r2 = -1
            if (r1 <= 0) goto L_0x0035
            int r3 = r5.decode(r6, r0, r1)
            int r0 = r0 + r3
            int r8 = r8 - r3
            if (r3 == r1) goto L_0x0035
            if (r0 != r7) goto L_0x0033
            return r2
        L_0x0033:
            int r0 = r0 - r7
            return r0
        L_0x0035:
            if (r8 > 0) goto L_0x0038
            goto L_0x003e
        L_0x0038:
            int r1 = r5.read()
            if (r1 != r2) goto L_0x0043
        L_0x003e:
            if (r0 != r7) goto L_0x0041
            return r2
        L_0x0041:
            int r0 = r0 - r7
            return r0
        L_0x0043:
            int r3 = r0 + 1
            byte r1 = (byte) r1
            r6[r0] = r1
            int r8 = r8 + -1
            r0 = r3
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.BASE64DecoderStream.read(byte[], int, int):int");
    }
}
