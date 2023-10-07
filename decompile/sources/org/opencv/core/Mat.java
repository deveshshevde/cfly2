package org.opencv.core;

import java.nio.ByteBuffer;

public class Mat {

    /* renamed from: a  reason: collision with root package name */
    public final long f34059a;

    public Mat() {
        this.f34059a = n_Mat();
    }

    public Mat(int i2, int i3, int i4) {
        this.f34059a = n_Mat(i2, i3, i4);
    }

    public Mat(int i2, int i3, int i4, ByteBuffer byteBuffer, long j2) {
        this.f34059a = n_Mat(i2, i3, i4, byteBuffer, j2);
    }

    public Mat(long j2) {
        if (j2 != 0) {
            this.f34059a = j2;
            return;
        }
        throw new UnsupportedOperationException("Native object address is NULL");
    }

    private static native void locateROI_0(long j2, double[] dArr, double[] dArr2);

    private static native String nDump(long j2);

    private static native double[] nGet(long j2, int i2, int i3);

    private static native int nGetB(long j2, int i2, int i3, int i4, byte[] bArr);

    private static native int nGetBIdx(long j2, int[] iArr, int i2, byte[] bArr);

    private static native int nGetD(long j2, int i2, int i3, int i4, double[] dArr);

    private static native int nGetDIdx(long j2, int[] iArr, int i2, double[] dArr);

    private static native int nGetF(long j2, int i2, int i3, int i4, float[] fArr);

    private static native int nGetFIdx(long j2, int[] iArr, int i2, float[] fArr);

    private static native int nGetI(long j2, int i2, int i3, int i4, int[] iArr);

    private static native int nGetIIdx(long j2, int[] iArr, int i2, int[] iArr2);

    private static native double[] nGetIdx(long j2, int[] iArr);

    private static native int nGetS(long j2, int i2, int i3, int i4, short[] sArr);

    private static native int nGetSIdx(long j2, int[] iArr, int i2, short[] sArr);

    private static native int nPutB(long j2, int i2, int i3, int i4, byte[] bArr);

    private static native int nPutBIdx(long j2, int[] iArr, int i2, byte[] bArr);

    private static native int nPutBwIdxOffset(long j2, int[] iArr, int i2, int i3, byte[] bArr);

    private static native int nPutBwOffset(long j2, int i2, int i3, int i4, int i5, byte[] bArr);

    private static native int nPutD(long j2, int i2, int i3, int i4, double[] dArr);

    private static native int nPutDIdx(long j2, int[] iArr, int i2, double[] dArr);

    private static native int nPutF(long j2, int i2, int i3, int i4, float[] fArr);

    private static native int nPutFIdx(long j2, int[] iArr, int i2, float[] fArr);

    private static native int nPutI(long j2, int i2, int i3, int i4, int[] iArr);

    private static native int nPutIIdx(long j2, int[] iArr, int i2, int[] iArr2);

    private static native int nPutS(long j2, int i2, int i3, int i4, short[] sArr);

    private static native int nPutSIdx(long j2, int[] iArr, int i2, short[] sArr);

    private static native long n_Mat();

    private static native long n_Mat(double d2, double d3, int i2);

    private static native long n_Mat(double d2, double d3, int i2, double d4, double d5, double d6, double d7);

    private static native long n_Mat(int i2, int i3, int i4);

    private static native long n_Mat(int i2, int i3, int i4, double d2, double d3, double d4, double d5);

    private static native long n_Mat(int i2, int i3, int i4, ByteBuffer byteBuffer);

    private static native long n_Mat(int i2, int i3, int i4, ByteBuffer byteBuffer, long j2);

    private static native long n_Mat(int i2, int[] iArr, int i3);

    private static native long n_Mat(int i2, int[] iArr, int i3, double d2, double d3, double d4, double d5);

    private static native long n_Mat(long j2, int i2, int i3);

    private static native long n_Mat(long j2, int i2, int i3, int i4, int i5);

    private static native long n_Mat(long j2, Range[] rangeArr);

    private static native long n_adjustROI(long j2, int i2, int i3, int i4, int i5);

    private static native void n_assignTo(long j2, long j3);

    private static native void n_assignTo(long j2, long j3, int i2);

    private static native int n_channels(long j2);

    private static native int n_checkVector(long j2, int i2);

    private static native int n_checkVector(long j2, int i2, int i3);

    private static native int n_checkVector(long j2, int i2, int i3, boolean z2);

    private static native long n_clone(long j2);

    private static native long n_col(long j2, int i2);

    private static native long n_colRange(long j2, int i2, int i3);

    private static native int n_cols(long j2);

    private static native void n_convertTo(long j2, long j3, int i2);

    private static native void n_convertTo(long j2, long j3, int i2, double d2);

    private static native void n_convertTo(long j2, long j3, int i2, double d2, double d3);

    private static native void n_copySize(long j2, long j3);

    private static native void n_copyTo(long j2, long j3);

    private static native void n_copyTo(long j2, long j3, long j4);

    private static native void n_create(long j2, double d2, double d3, int i2);

    private static native void n_create(long j2, int i2, int i3, int i4);

    private static native void n_create(long j2, int i2, int[] iArr, int i3);

    private static native long n_cross(long j2, long j3);

    private static native long n_dataAddr(long j2);

    private static native void n_delete(long j2);

    private static native int n_depth(long j2);

    private static native long n_diag(long j2);

    private static native long n_diag(long j2, int i2);

    private static native int n_dims(long j2);

    private static native double n_dot(long j2, long j3);

    private static native long n_elemSize(long j2);

    private static native long n_elemSize1(long j2);

    private static native boolean n_empty(long j2);

    private static native long n_eye(double d2, double d3, int i2);

    private static native long n_eye(int i2, int i3, int i4);

    private static native long n_inv(long j2);

    private static native long n_inv(long j2, int i2);

    private static native boolean n_isContinuous(long j2);

    private static native boolean n_isSubmatrix(long j2);

    private static native long n_matMul(long j2, long j3);

    private static native long n_mul(long j2, long j3);

    private static native long n_mul(long j2, long j3, double d2);

    private static native long n_ones(double d2, double d3, int i2);

    private static native long n_ones(int i2, int i3, int i4);

    private static native long n_ones(int i2, int[] iArr, int i3);

    private static native void n_push_back(long j2, long j3);

    private static native void n_release(long j2);

    private static native long n_reshape(long j2, int i2);

    private static native long n_reshape(long j2, int i2, int i3);

    private static native long n_reshape_1(long j2, int i2, int i3, int[] iArr);

    private static native long n_row(long j2, int i2);

    private static native long n_rowRange(long j2, int i2, int i3);

    private static native int n_rows(long j2);

    private static native long n_setTo(long j2, double d2, double d3, double d4, double d5);

    private static native long n_setTo(long j2, double d2, double d3, double d4, double d5, long j3);

    private static native long n_setTo(long j2, long j3);

    private static native long n_setTo(long j2, long j3, long j4);

    private static native double[] n_size(long j2);

    private static native int n_size_i(long j2, int i2);

    private static native long n_step1(long j2);

    private static native long n_step1(long j2, int i2);

    private static native long n_submat(long j2, int i2, int i3, int i4, int i5);

    private static native long n_submat_ranges(long j2, Range[] rangeArr);

    private static native long n_submat_rr(long j2, int i2, int i3, int i4, int i5);

    private static native long n_t(long j2);

    private static native long n_total(long j2);

    private static native int n_type(long j2);

    private static native long n_zeros(double d2, double d3, int i2);

    private static native long n_zeros(int i2, int i3, int i4);

    private static native long n_zeros(int i2, int[] iArr, int i3);

    public int a(int i2) {
        return n_size_i(this.f34059a, i2);
    }

    public int a(int i2, int i3, byte[] bArr) {
        int h2 = h();
        if (bArr == null || bArr.length % a.i(h2) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Provided data element number (");
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(a.i(h2));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        } else if (a.j(h2) == 0 || a.j(h2) == 1) {
            return nPutB(this.f34059a, i2, i3, bArr.length, bArr);
        } else {
            throw new UnsupportedOperationException("Mat data type is not compatible: " + h2);
        }
    }

    /* renamed from: a */
    public Mat clone() {
        return new Mat(n_clone(this.f34059a));
    }

    public Mat a(int i2, int i3, int i4, int i5) {
        return new Mat(n_submat_rr(this.f34059a, i2, i3, i4, i5));
    }

    public int b() {
        return n_dims(this.f34059a);
    }

    public long c() {
        return n_dataAddr(this.f34059a);
    }

    public boolean d() {
        return n_empty(this.f34059a);
    }

    public boolean e() {
        return n_isContinuous(this.f34059a);
    }

    public boolean f() {
        return n_isSubmatrix(this.f34059a);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        n_delete(this.f34059a);
        super.finalize();
    }

    public void g() {
        n_release(this.f34059a);
    }

    public int h() {
        return n_type(this.f34059a);
    }

    public String toString() {
        String str = b() > 0 ? "" : "-1*-1*";
        for (int i2 = 0; i2 < b(); i2++) {
            str = str + a(i2) + "*";
        }
        return "Mat [ " + str + a.k(h()) + ", isCont=" + e() + ", isSubmat=" + f() + ", nativeObj=0x" + Long.toHexString(this.f34059a) + ", dataAddr=0x" + Long.toHexString(c()) + " ]";
    }
}
