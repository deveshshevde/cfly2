package org.jcodec.common.model;

public enum ColorSpace {
    RGB(3, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV420(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 1, 1}),
    YUV420J(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 1, 1}),
    YUV422(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    YUV422J(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    YUV444(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV444J(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV422_10(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    GREY(1, r16, r17, new int[]{0}),
    MONO(1, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV444_10(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0});
    

    /* renamed from: l  reason: collision with root package name */
    public int f33206l;

    /* renamed from: m  reason: collision with root package name */
    public int[] f33207m;

    /* renamed from: n  reason: collision with root package name */
    public int[] f33208n;

    /* renamed from: o  reason: collision with root package name */
    public int[] f33209o;

    private ColorSpace(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f33206l = i2;
        this.f33207m = iArr;
        this.f33208n = iArr2;
        this.f33209o = iArr3;
    }
}
