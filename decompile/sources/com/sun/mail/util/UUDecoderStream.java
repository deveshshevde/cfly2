package com.sun.mail.util;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UUDecoderStream extends FilterInputStream {
    private byte[] buffer;
    private int bufsize = 0;
    private boolean gotEnd = false;
    private boolean gotPrefix = false;
    private int index = 0;
    private LineInputStream lin;
    private int mode;
    private String name;

    public UUDecoderStream(InputStream inputStream) {
        super(inputStream);
        this.lin = new LineInputStream(inputStream);
        this.buffer = new byte[45];
    }

    private boolean decode() throws IOException {
        String readLine;
        if (this.gotEnd) {
            return false;
        }
        this.bufsize = 0;
        do {
            readLine = this.lin.readLine();
            if (readLine == null) {
                throw new IOException("Missing End");
            } else if (readLine.regionMatches(true, 0, "end", 0, 3)) {
                this.gotEnd = true;
                return false;
            }
        } while (readLine.length() == 0);
        char charAt = readLine.charAt(0);
        if (charAt >= ' ') {
            int i2 = (charAt - ' ') & 63;
            if (i2 == 0) {
                String readLine2 = this.lin.readLine();
                if (readLine2 == null || !readLine2.regionMatches(true, 0, "end", 0, 3)) {
                    throw new IOException("Missing End");
                }
                this.gotEnd = true;
                return false;
            } else if (readLine.length() >= (((i2 * 8) + 5) / 6) + 1) {
                int i3 = 1;
                while (this.bufsize < i2) {
                    int i4 = i3 + 1;
                    int i5 = i4 + 1;
                    byte charAt2 = (byte) ((readLine.charAt(i4) - ' ') & 63);
                    byte[] bArr = this.buffer;
                    int i6 = this.bufsize;
                    int i7 = i6 + 1;
                    this.bufsize = i7;
                    bArr[i6] = (byte) (((((byte) ((readLine.charAt(i3) - ' ') & 63)) << 2) & 252) | ((charAt2 >>> 4) & 3));
                    if (i7 < i2) {
                        i3 = i5 + 1;
                        byte charAt3 = (byte) ((readLine.charAt(i5) - ' ') & 63);
                        byte[] bArr2 = this.buffer;
                        int i8 = this.bufsize;
                        this.bufsize = i8 + 1;
                        bArr2[i8] = (byte) (((charAt2 << 4) & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) | ((charAt3 >>> 2) & 15));
                        charAt2 = charAt3;
                    } else {
                        i3 = i5;
                    }
                    if (this.bufsize < i2) {
                        int i9 = i3 + 1;
                        byte[] bArr3 = this.buffer;
                        int i10 = this.bufsize;
                        this.bufsize = i10 + 1;
                        bArr3[i10] = (byte) ((((byte) ((readLine.charAt(i3) - ' ') & 63)) & 63) | ((charAt2 << 6) & 192));
                        i3 = i9;
                    }
                }
                return true;
            } else {
                throw new IOException("Short buffer error");
            }
        } else {
            throw new IOException("Buffer format error");
        }
    }

    private void readPrefix() throws IOException {
        String readLine;
        if (!this.gotPrefix) {
            do {
                readLine = this.lin.readLine();
                if (readLine == null) {
                    throw new IOException("UUDecoder error: No Begin");
                }
            } while (!readLine.regionMatches(true, 0, "begin", 0, 5));
            try {
                this.mode = Integer.parseInt(readLine.substring(6, 9));
                this.name = readLine.substring(10);
                this.gotPrefix = true;
            } catch (NumberFormatException e2) {
                throw new IOException("UUDecoder error: " + e2.toString());
            }
        }
    }

    public int available() throws IOException {
        return ((this.in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    public int getMode() throws IOException {
        readPrefix();
        return this.mode;
    }

    public String getName() throws IOException {
        readPrefix();
        return this.name;
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            readPrefix();
            if (!decode()) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        return bArr[i2] & 255;
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
