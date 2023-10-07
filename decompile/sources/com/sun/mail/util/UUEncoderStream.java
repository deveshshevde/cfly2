package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class UUEncoderStream extends FilterOutputStream {
    private byte[] buffer;
    private int bufsize;
    protected int mode;
    protected String name;
    private boolean wrotePrefix;

    public UUEncoderStream(OutputStream outputStream) {
        this(outputStream, "encoder.buf", 644);
    }

    public UUEncoderStream(OutputStream outputStream, String str) {
        this(outputStream, str, 644);
    }

    public UUEncoderStream(OutputStream outputStream, String str, int i2) {
        super(outputStream);
        this.bufsize = 0;
        this.wrotePrefix = false;
        this.name = str;
        this.mode = i2;
        this.buffer = new byte[45];
    }

    private void encode() throws IOException {
        byte b2;
        int i2;
        this.out.write((this.bufsize & 63) + 32);
        int i3 = 0;
        while (true) {
            int i4 = this.bufsize;
            if (i3 >= i4) {
                this.out.write(10);
                return;
            }
            byte[] bArr = this.buffer;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            byte b4 = 1;
            if (i5 < i4) {
                int i6 = i5 + 1;
                byte b5 = bArr[i5];
                if (i6 < i4) {
                    i2 = i6 + 1;
                    b2 = bArr[i6];
                    b4 = b5;
                    int i7 = ((b3 << 4) & 48) | ((b4 >>> 4) & 15);
                    this.out.write(((b3 >>> 2) & 63) + 32);
                    this.out.write(i7 + 32);
                    this.out.write((((b4 << 2) & 60) | ((b2 >>> 6) & 3)) + 32);
                    this.out.write((b2 & 63) + 32);
                    i3 = i2;
                } else {
                    b4 = b5;
                    i2 = i6;
                }
            } else {
                i2 = i5;
            }
            b2 = 1;
            int i72 = ((b3 << 4) & 48) | ((b4 >>> 4) & 15);
            this.out.write(((b3 >>> 2) & 63) + 32);
            this.out.write(i72 + 32);
            this.out.write((((b4 << 2) & 60) | ((b2 >>> 6) & 3)) + 32);
            this.out.write((b2 & 63) + 32);
            i3 = i2;
        }
    }

    private void writePrefix() throws IOException {
        if (!this.wrotePrefix) {
            PrintStream printStream = new PrintStream(this.out);
            printStream.println("begin " + this.mode + " " + this.name);
            printStream.flush();
            this.wrotePrefix = true;
        }
    }

    private void writeSuffix() throws IOException {
        PrintStream printStream = new PrintStream(this.out);
        printStream.println(" \nend");
        printStream.flush();
    }

    public void close() throws IOException {
        flush();
        this.out.close();
    }

    public void flush() throws IOException {
        if (this.bufsize > 0) {
            writePrefix();
            encode();
        }
        writeSuffix();
        this.out.flush();
    }

    public void setNameMode(String str, int i2) {
        this.name = str;
        this.mode = i2;
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.buffer;
        int i3 = this.bufsize;
        int i4 = i3 + 1;
        this.bufsize = i4;
        bArr[i3] = (byte) i2;
        if (i4 == 45) {
            writePrefix();
            encode();
            this.bufsize = 0;
        }
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        for (int i4 = 0; i4 < i3; i4++) {
            write((int) bArr[i2 + i4]);
        }
    }
}
