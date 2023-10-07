package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResponseInputStream {
    private static final int incrementSlop = 16;
    private static final int maxIncrement = 262144;
    private static final int minIncrement = 256;
    private BufferedInputStream bin;

    public ResponseInputStream(InputStream inputStream) {
        this.bin = new BufferedInputStream(inputStream, 2048);
    }

    public ByteArray readResponse() throws IOException {
        return readResponse((ByteArray) null);
    }

    public ByteArray readResponse(ByteArray byteArray) throws IOException {
        if (byteArray == null) {
            byteArray = new ByteArray(new byte[128], 0, 128);
        }
        byte[] bytes = byteArray.getBytes();
        int i2 = 0;
        while (true) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2 && (i3 = this.bin.read()) != -1) {
                if (i3 == 10 && i2 > 0 && bytes[i2 - 1] == 13) {
                    z2 = true;
                }
                if (i2 >= bytes.length) {
                    int length = bytes.length;
                    if (length > maxIncrement) {
                        length = maxIncrement;
                    }
                    byteArray.grow(length);
                    bytes = byteArray.getBytes();
                }
                bytes[i2] = (byte) i3;
                i2++;
            }
            if (i3 != -1) {
                if (i2 < 5) {
                    break;
                }
                int i4 = i2 - 3;
                if (bytes[i4] != 125) {
                    break;
                }
                int i5 = i2 - 4;
                while (i5 >= 0 && bytes[i5] != 123) {
                    i5--;
                }
                if (i5 < 0) {
                    break;
                }
                try {
                    int parseInt = ASCIIUtility.parseInt(bytes, i5 + 1, i4);
                    if (parseInt > 0) {
                        int length2 = bytes.length - i2;
                        int i6 = parseInt + 16;
                        if (i6 > length2) {
                            int i7 = i6 - length2;
                            if (256 > i7) {
                                i7 = 256;
                            }
                            byteArray.grow(i7);
                            bytes = byteArray.getBytes();
                        }
                        while (parseInt > 0) {
                            int read = this.bin.read(bytes, i2, parseInt);
                            parseInt -= read;
                            i2 += read;
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            } else {
                throw new IOException();
            }
        }
        byteArray.setCount(i2);
        return byteArray;
    }
}
