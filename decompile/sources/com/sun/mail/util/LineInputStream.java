package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class LineInputStream extends FilterInputStream {
    private char[] lineBuffer = null;

    public LineInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public String readLine() throws IOException {
        int read;
        InputStream inputStream = this.in;
        char[] cArr = this.lineBuffer;
        if (cArr == null) {
            cArr = new char[128];
            this.lineBuffer = cArr;
        }
        int length = cArr.length;
        int i2 = 0;
        while (true) {
            read = inputStream.read();
            if (read == -1 || read == 10) {
                break;
            } else if (read == 13) {
                int read2 = inputStream.read();
                if (read2 == 13) {
                    read2 = inputStream.read();
                }
                if (read2 != 10) {
                    if (!(inputStream instanceof PushbackInputStream)) {
                        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
                        this.in = pushbackInputStream;
                        inputStream = pushbackInputStream;
                    }
                    ((PushbackInputStream) inputStream).unread(read2);
                }
            } else {
                length--;
                if (length < 0) {
                    int i3 = i2 + 128;
                    char[] cArr2 = new char[i3];
                    System.arraycopy(this.lineBuffer, 0, cArr2, 0, i2);
                    this.lineBuffer = cArr2;
                    char[] cArr3 = cArr2;
                    length = (i3 - i2) - 1;
                    cArr = cArr3;
                }
                cArr[i2] = (char) read;
                i2++;
            }
        }
        if (read == -1 && i2 == 0) {
            return null;
        }
        return String.copyValueOf(cArr, 0, i2);
    }
}
