package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class QPDecoderStream extends FilterInputStream {

    /* renamed from: ba  reason: collision with root package name */
    protected byte[] f21763ba = new byte[2];
    protected int spaces = 0;

    public QPDecoderStream(InputStream inputStream) {
        super(new PushbackInputStream(inputStream, 2));
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int read;
        int i2 = this.spaces;
        if (i2 > 0) {
            this.spaces = i2 - 1;
            return 32;
        }
        int read2 = this.in.read();
        if (read2 == 32) {
            while (true) {
                read = this.in.read();
                if (read != 32) {
                    break;
                }
                this.spaces++;
            }
            if (read == 13 || read == 10 || read == -1) {
                this.spaces = 0;
                return read;
            }
            ((PushbackInputStream) this.in).unread(read);
            return 32;
        }
        if (read2 == 61) {
            int read3 = this.in.read();
            if (read3 == 10) {
                return read();
            }
            if (read3 == 13) {
                int read4 = this.in.read();
                if (read4 != 10) {
                    ((PushbackInputStream) this.in).unread(read4);
                }
                return read();
            } else if (read3 == -1) {
                return -1;
            } else {
                byte[] bArr = this.f21763ba;
                bArr[0] = (byte) read3;
                bArr[1] = (byte) this.in.read();
                try {
                    return ASCIIUtility.parseInt(this.f21763ba, 0, 2, 16);
                } catch (NumberFormatException unused) {
                    ((PushbackInputStream) this.in).unread(this.f21763ba);
                }
            }
        }
        return read2;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        while (i4 < i3) {
            int read = read();
            if (read != -1) {
                bArr[i2 + i4] = (byte) read;
                i4++;
            } else if (i4 == 0) {
                return -1;
            } else {
                return i4;
            }
        }
        return i4;
    }
}
