package com.shuyu.gsyvideoplayer.utils;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

class NeuQuant {
    protected static final int alphabiasshift = 10;
    protected static final int alpharadbias = 262144;
    protected static final int alpharadbshift = 18;
    protected static final int beta = 64;
    protected static final int betagamma = 65536;
    protected static final int betashift = 10;
    protected static final int gamma = 1024;
    protected static final int gammashift = 10;
    protected static final int initalpha = 1024;
    protected static final int initrad = 32;
    protected static final int initradius = 2048;
    protected static final int intbias = 65536;
    protected static final int intbiasshift = 16;
    protected static final int maxnetpos = 255;
    protected static final int minpicturebytes = 1509;
    protected static final int ncycles = 100;
    protected static final int netbiasshift = 4;
    protected static final int netsize = 256;
    protected static final int prime1 = 499;
    protected static final int prime2 = 491;
    protected static final int prime3 = 487;
    protected static final int prime4 = 503;
    protected static final int radbias = 256;
    protected static final int radbiasshift = 8;
    protected static final int radiusbias = 64;
    protected static final int radiusbiasshift = 6;
    protected static final int radiusdec = 30;
    protected int alphadec;
    protected int[] bias = new int[256];
    protected int[] freq = new int[256];
    protected int lengthcount;
    protected int[] netindex = new int[256];
    protected int[][] network;
    protected int[] radpower = new int[32];
    protected int samplefac;
    protected byte[] thepicture;

    public NeuQuant(byte[] bArr, int i2, int i3) {
        this.thepicture = bArr;
        this.lengthcount = i2;
        this.samplefac = i3;
        this.network = new int[256][];
        for (int i4 = 0; i4 < 256; i4++) {
            int[][] iArr = this.network;
            iArr[i4] = new int[4];
            int[] iArr2 = iArr[i4];
            int i5 = (i4 << 12) / 256;
            iArr2[2] = i5;
            iArr2[1] = i5;
            iArr2[0] = i5;
            this.freq[i4] = 256;
            this.bias[i4] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void alterneigh(int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3 - i2;
        if (i7 < -1) {
            i7 = -1;
        }
        int i8 = i3 + i2;
        if (i8 > 256) {
            i8 = 256;
        }
        int i9 = i3 + 1;
        int i10 = i3 - 1;
        int i11 = 1;
        while (true) {
            if (i9 < i8 || i10 > i7) {
                int i12 = i11 + 1;
                int i13 = this.radpower[i11];
                if (i9 < i8) {
                    int i14 = i9 + 1;
                    int[] iArr = this.network[i9];
                    try {
                        iArr[0] = iArr[0] - (((iArr[0] - i4) * i13) / alpharadbias);
                        iArr[1] = iArr[1] - (((iArr[1] - i5) * i13) / alpharadbias);
                        iArr[2] = iArr[2] - (((iArr[2] - i6) * i13) / alpharadbias);
                    } catch (Exception unused) {
                    }
                    i9 = i14;
                }
                if (i10 > i7) {
                    int i15 = i10 - 1;
                    int[] iArr2 = this.network[i10];
                    try {
                        iArr2[0] = iArr2[0] - (((iArr2[0] - i4) * i13) / alpharadbias);
                        iArr2[1] = iArr2[1] - (((iArr2[1] - i5) * i13) / alpharadbias);
                        iArr2[2] = iArr2[2] - ((i13 * (iArr2[2] - i6)) / alpharadbias);
                    } catch (Exception unused2) {
                    }
                    i11 = i12;
                    i10 = i15;
                } else {
                    i11 = i12;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void altersingle(int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.network[i3];
        iArr[0] = iArr[0] - (((iArr[0] - i4) * i2) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i5) * i2) / 1024);
        iArr[2] = iArr[2] - ((i2 * (iArr[2] - i6)) / 1024);
    }

    public byte[] colorMap() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[this.network[i2][3]] = i2;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < 256) {
            int i5 = iArr[i3];
            int i6 = i4 + 1;
            int[][] iArr2 = this.network;
            bArr[i4] = (byte) iArr2[i5][0];
            int i7 = i6 + 1;
            bArr[i6] = (byte) iArr2[i5][1];
            bArr[i7] = (byte) iArr2[i5][2];
            i3++;
            i4 = i7 + 1;
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public int contest(int i2, int i3, int i4) {
        int i5 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int i6 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < 256; i9++) {
            int[] iArr = this.network[i9];
            int i10 = iArr[0] - i2;
            if (i10 < 0) {
                i10 = -i10;
            }
            int i11 = iArr[1] - i3;
            if (i11 < 0) {
                i11 = -i11;
            }
            int i12 = i10 + i11;
            int i13 = iArr[2] - i4;
            if (i13 < 0) {
                i13 = -i13;
            }
            int i14 = i12 + i13;
            if (i14 < i5) {
                i7 = i9;
                i5 = i14;
            }
            int[] iArr2 = this.bias;
            int i15 = i14 - (iArr2[i9] >> 12);
            if (i15 < i6) {
                i8 = i9;
                i6 = i15;
            }
            int[] iArr3 = this.freq;
            int i16 = iArr3[i9] >> 10;
            iArr3[i9] = iArr3[i9] - i16;
            iArr2[i9] = iArr2[i9] + (i16 << 10);
        }
        int[] iArr4 = this.freq;
        iArr4[i7] = iArr4[i7] + 64;
        int[] iArr5 = this.bias;
        iArr5[i7] = iArr5[i7] - 65536;
        return i8;
    }

    public void inxbuild() {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < 256) {
            int[] iArr = this.network[i2];
            int i5 = iArr[1];
            int i6 = i2 + 1;
            int i7 = i2;
            for (int i8 = i6; i8 < 256; i8++) {
                int[] iArr2 = this.network[i8];
                if (iArr2[1] < i5) {
                    i5 = iArr2[1];
                    i7 = i8;
                }
            }
            int[] iArr3 = this.network[i7];
            if (i2 != i7) {
                int i9 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i9;
                int i10 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i10;
                int i11 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i11;
                int i12 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i12;
            }
            if (i5 != i3) {
                this.netindex[i3] = (i4 + i2) >> 1;
                while (true) {
                    i3++;
                    if (i3 >= i5) {
                        break;
                    }
                    this.netindex[i3] = i2;
                }
                i4 = i2;
                i3 = i5;
            }
            i2 = i6;
        }
        this.netindex[i3] = (i4 + maxnetpos) >> 1;
        for (int i13 = i3 + 1; i13 < 256; i13++) {
            this.netindex[i13] = maxnetpos;
        }
    }

    public void learn() {
        int i2 = this.lengthcount;
        if (i2 < minpicturebytes) {
            this.samplefac = 1;
        }
        int i3 = this.samplefac;
        this.alphadec = ((i3 - 1) / 3) + 30;
        byte[] bArr = this.thepicture;
        int i4 = i2 / (i3 * 3);
        int i5 = i4 / 100;
        for (int i6 = 0; i6 < 32; i6++) {
            this.radpower[i6] = 1024 * (((1024 - (i6 * i6)) * 256) / 1024);
        }
        int i7 = this.lengthcount;
        int i8 = i7 < minpicturebytes ? 3 : i7 % prime1 != 0 ? 1497 : i7 % prime2 != 0 ? 1473 : i7 % prime3 != 0 ? 1461 : minpicturebytes;
        int i9 = i5;
        int i10 = 0;
        int i11 = 2048;
        int i12 = 32;
        int i13 = 1024;
        int i14 = 0;
        while (i10 < i4) {
            int i15 = (bArr[i14 + 0] & 255) << 4;
            int i16 = (bArr[i14 + 1] & 255) << 4;
            int i17 = (bArr[i14 + 2] & 255) << 4;
            int contest = contest(i15, i16, i17);
            int i18 = i17;
            int i19 = i16;
            int i20 = i15;
            int i21 = i10;
            altersingle(i13, contest, i15, i19, i18);
            if (i12 != 0) {
                alterneigh(i12, contest, i20, i19, i18);
            }
            int i22 = i14 + i8;
            if (i22 >= i2) {
                i22 -= this.lengthcount;
            }
            i14 = i22;
            i10 = i21 + 1;
            if (i9 == 0) {
                i9 = 1;
            }
            if (i10 % i9 == 0) {
                i13 -= i13 / this.alphadec;
                i11 -= i11 / 30;
                int i23 = i11 >> 6;
                i12 = i23 <= 1 ? 0 : i23;
                for (int i24 = 0; i24 < i12; i24++) {
                    int i25 = i12 * i12;
                    this.radpower[i24] = (((i25 - (i24 * i24)) * 256) / i25) * i13;
                }
            }
        }
    }

    public int map(int i2, int i3, int i4) {
        int i5 = this.netindex[i3];
        int i6 = i5 - 1;
        int i7 = 1000;
        int i8 = -1;
        while (true) {
            if (i5 >= 256 && i6 < 0) {
                return i8;
            }
            if (i5 < 256) {
                int[] iArr = this.network[i5];
                int i9 = iArr[1] - i3;
                if (i9 >= i7) {
                    i5 = 256;
                } else {
                    i5++;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    int i10 = iArr[0] - i2;
                    if (i10 < 0) {
                        i10 = -i10;
                    }
                    int i11 = i9 + i10;
                    if (i11 < i7) {
                        int i12 = iArr[2] - i4;
                        if (i12 < 0) {
                            i12 = -i12;
                        }
                        int i13 = i11 + i12;
                        if (i13 < i7) {
                            i8 = iArr[3];
                            i7 = i13;
                        }
                    }
                }
            }
            if (i6 >= 0) {
                int[] iArr2 = this.network[i6];
                int i14 = i3 - iArr2[1];
                if (i14 >= i7) {
                    i6 = -1;
                } else {
                    i6--;
                    if (i14 < 0) {
                        i14 = -i14;
                    }
                    int i15 = iArr2[0] - i2;
                    if (i15 < 0) {
                        i15 = -i15;
                    }
                    int i16 = i14 + i15;
                    if (i16 < i7) {
                        int i17 = iArr2[2] - i4;
                        if (i17 < 0) {
                            i17 = -i17;
                        }
                        int i18 = i17 + i16;
                        if (i18 < i7) {
                            i8 = iArr2[3];
                            i7 = i18;
                        }
                    }
                }
            }
        }
    }

    public byte[] process() {
        learn();
        unbiasnet();
        inxbuild();
        return colorMap();
    }

    public void unbiasnet() {
        for (int i2 = 0; i2 < 256; i2++) {
            int[][] iArr = this.network;
            int[] iArr2 = iArr[i2];
            iArr2[0] = iArr2[0] >> 4;
            int[] iArr3 = iArr[i2];
            iArr3[1] = iArr3[1] >> 4;
            int[] iArr4 = iArr[i2];
            iArr4[2] = iArr4[2] >> 4;
            iArr[i2][3] = i2;
        }
    }
}
