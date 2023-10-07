package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TraceOutputStream extends FilterOutputStream {
    private boolean quote = false;
    private boolean trace = false;
    private OutputStream traceOut;

    public TraceOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.traceOut = outputStream2;
    }

    private final void writeByte(int i2) throws IOException {
        int i3;
        OutputStream outputStream;
        OutputStream outputStream2;
        int i4 = i2 & 255;
        if (i4 > 127) {
            this.traceOut.write(77);
            this.traceOut.write(45);
            i4 &= 127;
        }
        if (i4 == 13) {
            this.traceOut.write(92);
            outputStream2 = this.traceOut;
            i3 = 114;
        } else {
            i3 = 10;
            if (i4 == 10) {
                this.traceOut.write(92);
                this.traceOut.write(110);
                outputStream2 = this.traceOut;
            } else if (i4 == 9) {
                this.traceOut.write(92);
                outputStream2 = this.traceOut;
                i3 = 116;
            } else {
                if (i4 < 32) {
                    this.traceOut.write(94);
                    outputStream = this.traceOut;
                    i4 += 64;
                } else {
                    outputStream = this.traceOut;
                }
                outputStream.write(i4);
                return;
            }
        }
        outputStream2.write(i3);
    }

    public void setQuote(boolean z2) {
        this.quote = z2;
    }

    public void setTrace(boolean z2) {
        this.trace = z2;
    }

    public void write(int i2) throws IOException {
        if (this.trace) {
            if (this.quote) {
                writeByte(i2);
            } else {
                this.traceOut.write(i2);
            }
        }
        this.out.write(i2);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.trace) {
            if (this.quote) {
                for (int i4 = 0; i4 < i3; i4++) {
                    writeByte(bArr[i2 + i4]);
                }
            } else {
                this.traceOut.write(bArr, i2, i3);
            }
        }
        this.out.write(bArr, i2, i3);
    }
}
