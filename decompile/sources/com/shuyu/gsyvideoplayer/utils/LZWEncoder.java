package com.shuyu.gsyvideoplayer.utils;

import java.io.IOException;
import java.io.OutputStream;

class LZWEncoder {
    static final int BITS = 12;
    private static final int EOF = -1;
    static final int HSIZE = 5003;
    int ClearCode;
    int EOFCode;
    int a_count;
    byte[] accum = new byte[256];
    boolean clear_flg = false;
    int[] codetab = new int[HSIZE];
    private int curPixel;
    int cur_accum = 0;
    int cur_bits = 0;
    int free_ent = 0;
    int g_init_bits;
    int hsize = HSIZE;
    int[] htab = new int[HSIZE];
    private int imgH;
    private int imgW;
    private int initCodeSize;
    int[] masks = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    int maxbits = 12;
    int maxcode;
    int maxmaxcode = 4096;
    int n_bits;
    private byte[] pixAry;
    private int remaining;

    LZWEncoder(int i2, int i3, byte[] bArr, int i4) {
        this.imgW = i2;
        this.imgH = i3;
        this.pixAry = bArr;
        this.initCodeSize = Math.max(2, i4);
    }

    private int nextPixel() {
        int i2 = this.remaining;
        if (i2 == 0) {
            return -1;
        }
        this.remaining = i2 - 1;
        byte[] bArr = this.pixAry;
        int i3 = this.curPixel;
        this.curPixel = i3 + 1;
        return bArr[i3] & 255;
    }

    /* access modifiers changed from: package-private */
    public final int MAXCODE(int i2) {
        return (1 << i2) - 1;
    }

    /* access modifiers changed from: package-private */
    public void char_out(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.accum;
        int i2 = this.a_count;
        int i3 = i2 + 1;
        this.a_count = i3;
        bArr[i2] = b2;
        if (i3 >= 254) {
            flush_char(outputStream);
        }
    }

    /* access modifiers changed from: package-private */
    public void cl_block(OutputStream outputStream) throws IOException {
        cl_hash(this.hsize);
        int i2 = this.ClearCode;
        this.free_ent = i2 + 2;
        this.clear_flg = true;
        output(i2, outputStream);
    }

    /* access modifiers changed from: package-private */
    public void cl_hash(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.htab[i3] = -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void compress(int r10, java.io.OutputStream r11) throws java.io.IOException {
        /*
            r9 = this;
            r9.g_init_bits = r10
            r0 = 0
            r9.clear_flg = r0
            r9.n_bits = r10
            int r1 = r9.MAXCODE(r10)
            r9.maxcode = r1
            r1 = 1
            int r10 = r10 - r1
            int r10 = r1 << r10
            r9.ClearCode = r10
            int r2 = r10 + 1
            r9.EOFCode = r2
            int r10 = r10 + 2
            r9.free_ent = r10
            r9.a_count = r0
            int r10 = r9.nextPixel()
            int r2 = r9.hsize
        L_0x0023:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r3) goto L_0x002c
            int r0 = r0 + 1
            int r2 = r2 * 2
            goto L_0x0023
        L_0x002c:
            int r0 = 8 - r0
            int r2 = r9.hsize
            r9.cl_hash(r2)
            int r3 = r9.ClearCode
            r9.output(r3, r11)
        L_0x0038:
            int r3 = r9.nextPixel()
            r4 = -1
            if (r3 == r4) goto L_0x0089
            int r4 = r9.maxbits
            int r4 = r3 << r4
            int r4 = r4 + r10
            int r5 = r3 << r0
            r5 = r5 ^ r10
            int[] r6 = r9.htab
            r7 = r6[r5]
            if (r7 != r4) goto L_0x0052
            int[] r10 = r9.codetab
            r10 = r10[r5]
            goto L_0x0038
        L_0x0052:
            r6 = r6[r5]
            if (r6 < 0) goto L_0x006e
            int r6 = r2 - r5
            if (r5 != 0) goto L_0x005b
            r6 = 1
        L_0x005b:
            int r5 = r5 - r6
            if (r5 >= 0) goto L_0x005f
            int r5 = r5 + r2
        L_0x005f:
            int[] r7 = r9.htab
            r8 = r7[r5]
            if (r8 != r4) goto L_0x006a
            int[] r10 = r9.codetab
            r10 = r10[r5]
            goto L_0x0038
        L_0x006a:
            r7 = r7[r5]
            if (r7 >= 0) goto L_0x005b
        L_0x006e:
            r9.output(r10, r11)
            int r10 = r9.free_ent
            int r6 = r9.maxmaxcode
            if (r10 >= r6) goto L_0x0084
            int[] r6 = r9.codetab
            int r7 = r10 + 1
            r9.free_ent = r7
            r6[r5] = r10
            int[] r10 = r9.htab
            r10[r5] = r4
            goto L_0x0087
        L_0x0084:
            r9.cl_block(r11)
        L_0x0087:
            r10 = r3
            goto L_0x0038
        L_0x0089:
            r9.output(r10, r11)
            int r10 = r9.EOFCode
            r9.output(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuyu.gsyvideoplayer.utils.LZWEncoder.compress(int, java.io.OutputStream):void");
    }

    /* access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.initCodeSize);
        this.remaining = this.imgW * this.imgH;
        this.curPixel = 0;
        compress(this.initCodeSize + 1, outputStream);
        outputStream.write(0);
    }

    /* access modifiers changed from: package-private */
    public void flush_char(OutputStream outputStream) throws IOException {
        int i2 = this.a_count;
        if (i2 > 0) {
            outputStream.write(i2);
            outputStream.write(this.accum, 0, this.a_count);
            this.a_count = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void output(int i2, OutputStream outputStream) throws IOException {
        int i3 = this.cur_accum;
        int[] iArr = this.masks;
        int i4 = this.cur_bits;
        int i5 = i3 & iArr[i4];
        this.cur_accum = i5;
        if (i4 > 0) {
            this.cur_accum = i5 | (i2 << i4);
        } else {
            this.cur_accum = i2;
        }
        this.cur_bits = i4 + this.n_bits;
        while (this.cur_bits >= 8) {
            char_out((byte) (this.cur_accum & 255), outputStream);
            this.cur_accum >>= 8;
            this.cur_bits -= 8;
        }
        if (this.free_ent > this.maxcode || this.clear_flg) {
            if (this.clear_flg) {
                int i6 = this.g_init_bits;
                this.n_bits = i6;
                this.maxcode = MAXCODE(i6);
                this.clear_flg = false;
            } else {
                int i7 = this.n_bits + 1;
                this.n_bits = i7;
                this.maxcode = i7 == this.maxbits ? this.maxmaxcode : MAXCODE(i7);
            }
        }
        if (i2 == this.EOFCode) {
            while (this.cur_bits > 0) {
                char_out((byte) (this.cur_accum & 255), outputStream);
                this.cur_accum >>= 8;
                this.cur_bits -= 8;
            }
            flush_char(outputStream);
        }
    }
}
