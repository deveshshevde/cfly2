package org.opencv.core;

public class Core {

    /* renamed from: a  reason: collision with root package name */
    public static final String f34053a = d();

    /* renamed from: b  reason: collision with root package name */
    public static final String f34054b = e();

    /* renamed from: c  reason: collision with root package name */
    public static final int f34055c = f();

    /* renamed from: d  reason: collision with root package name */
    public static final int f34056d = g();

    /* renamed from: e  reason: collision with root package name */
    public static final int f34057e = h();

    /* renamed from: f  reason: collision with root package name */
    public static final String f34058f = i();

    private static native void LUT_0(long j2, long j3, long j4);

    private static native double Mahalanobis_0(long j2, long j3, long j4);

    private static native void PCABackProject_0(long j2, long j3, long j4, long j5);

    private static native void PCACompute2_0(long j2, long j3, long j4, long j5, int i2);

    private static native void PCACompute2_1(long j2, long j3, long j4, long j5);

    private static native void PCACompute2_2(long j2, long j3, long j4, long j5, double d2);

    private static native void PCACompute_0(long j2, long j3, long j4, int i2);

    private static native void PCACompute_1(long j2, long j3, long j4);

    private static native void PCACompute_2(long j2, long j3, long j4, double d2);

    private static native void PCAProject_0(long j2, long j3, long j4, long j5);

    private static native double PSNR_0(long j2, long j3, double d2);

    private static native double PSNR_1(long j2, long j3);

    private static native void SVBackSubst_0(long j2, long j3, long j4, long j5, long j6);

    private static native void SVDecomp_0(long j2, long j3, long j4, long j5, int i2);

    private static native void SVDecomp_1(long j2, long j3, long j4, long j5);

    public static String a() {
        return getBuildInformation_0();
    }

    private static native void absdiff_0(long j2, long j3, long j4);

    private static native void absdiff_1(long j2, double d2, double d3, double d4, double d5, long j3);

    private static native void addSamplesDataSearchPath_0(String str);

    private static native void addSamplesDataSearchSubDirectory_0(String str);

    private static native void addWeighted_0(long j2, double d2, long j3, double d3, double d4, long j4, int i2);

    private static native void addWeighted_1(long j2, double d2, long j3, double d3, double d4, long j4);

    private static native void add_0(long j2, long j3, long j4, long j5, int i2);

    private static native void add_1(long j2, long j3, long j4, long j5);

    private static native void add_2(long j2, long j3, long j4);

    private static native void add_3(long j2, double d2, double d3, double d4, double d5, long j3, long j4, int i2);

    private static native void add_4(long j2, double d2, double d3, double d4, double d5, long j3, long j4);

    private static native void add_5(long j2, double d2, double d3, double d4, double d5, long j3);

    public static long b() {
        return getTickCount_0();
    }

    private static native void batchDistance_0(long j2, long j3, long j4, int i2, long j5, int i3, int i4, long j6, int i5, boolean z2);

    private static native void batchDistance_1(long j2, long j3, long j4, int i2, long j5, int i3, int i4, long j6, int i5);

    private static native void batchDistance_2(long j2, long j3, long j4, int i2, long j5, int i3, int i4, long j6);

    private static native void batchDistance_3(long j2, long j3, long j4, int i2, long j5, int i3, int i4);

    private static native void batchDistance_4(long j2, long j3, long j4, int i2, long j5, int i3);

    private static native void batchDistance_5(long j2, long j3, long j4, int i2, long j5);

    private static native void bitwise_and_0(long j2, long j3, long j4, long j5);

    private static native void bitwise_and_1(long j2, long j3, long j4);

    private static native void bitwise_not_0(long j2, long j3, long j4);

    private static native void bitwise_not_1(long j2, long j3);

    private static native void bitwise_or_0(long j2, long j3, long j4, long j5);

    private static native void bitwise_or_1(long j2, long j3, long j4);

    private static native void bitwise_xor_0(long j2, long j3, long j4, long j5);

    private static native void bitwise_xor_1(long j2, long j3, long j4);

    private static native int borderInterpolate_0(int i2, int i3, int i4);

    public static double c() {
        return getTickFrequency_0();
    }

    private static native void calcCovarMatrix_0(long j2, long j3, long j4, int i2, int i3);

    private static native void calcCovarMatrix_1(long j2, long j3, long j4, int i2);

    private static native void cartToPolar_0(long j2, long j3, long j4, long j5, boolean z2);

    private static native void cartToPolar_1(long j2, long j3, long j4, long j5);

    private static native boolean checkRange_0(long j2, boolean z2, double d2, double d3);

    private static native boolean checkRange_1(long j2, boolean z2, double d2);

    private static native boolean checkRange_2(long j2, boolean z2);

    private static native boolean checkRange_4(long j2);

    private static native void compare_0(long j2, long j3, long j4, int i2);

    private static native void compare_1(long j2, double d2, double d3, double d4, double d5, long j3, int i2);

    private static native void completeSymm_0(long j2, boolean z2);

    private static native void completeSymm_1(long j2);

    private static native void convertFp16_0(long j2, long j3);

    private static native void convertScaleAbs_0(long j2, long j3, double d2, double d3);

    private static native void convertScaleAbs_1(long j2, long j3, double d2);

    private static native void convertScaleAbs_2(long j2, long j3);

    private static native void copyMakeBorder_0(long j2, long j3, int i2, int i3, int i4, int i5, int i6, double d2, double d3, double d4, double d5);

    private static native void copyMakeBorder_1(long j2, long j3, int i2, int i3, int i4, int i5, int i6);

    private static native void copyTo_0(long j2, long j3, long j4);

    private static native int countNonZero_0(long j2);

    private static native float cubeRoot_0(float f2);

    private static String d() {
        return "4.5.4";
    }

    private static native void dct_0(long j2, long j3, int i2);

    private static native void dct_1(long j2, long j3);

    private static native double determinant_0(long j2);

    private static native void dft_0(long j2, long j3, int i2, int i3);

    private static native void dft_1(long j2, long j3, int i2);

    private static native void dft_2(long j2, long j3);

    private static native void divide_0(long j2, long j3, long j4, double d2, int i2);

    private static native void divide_1(long j2, long j3, long j4, double d2);

    private static native void divide_2(long j2, long j3, long j4);

    private static native void divide_3(double d2, long j2, long j3, int i2);

    private static native void divide_4(double d2, long j2, long j3);

    private static native void divide_5(long j2, double d2, double d3, double d4, double d5, long j3, double d6, int i2);

    private static native void divide_6(long j2, double d2, double d3, double d4, double d5, long j3, double d6);

    private static native void divide_7(long j2, double d2, double d3, double d4, double d5, long j3);

    private static String e() {
        return "opencv_java454";
    }

    private static native void eigenNonSymmetric_0(long j2, long j3, long j4);

    private static native boolean eigen_0(long j2, long j3, long j4);

    private static native boolean eigen_1(long j2, long j3);

    private static native void exp_0(long j2, long j3);

    private static native void extractChannel_0(long j2, long j3, int i2);

    private static int f() {
        return 4;
    }

    private static native float fastAtan2_0(float f2, float f3);

    private static native String findFileOrKeep_0(String str, boolean z2);

    private static native String findFileOrKeep_1(String str);

    private static native String findFile_0(String str, boolean z2, boolean z3);

    private static native String findFile_1(String str, boolean z2);

    private static native String findFile_2(String str);

    private static native void findNonZero_0(long j2, long j3);

    private static native void flip_0(long j2, long j3, int i2);

    private static int g() {
        return 5;
    }

    private static native void gemm_0(long j2, long j3, double d2, long j4, double d3, long j5, int i2);

    private static native void gemm_1(long j2, long j3, double d2, long j4, double d3, long j5);

    private static native String getBuildInformation_0();

    private static native String getCPUFeaturesLine_0();

    private static native long getCPUTickCount_0();

    private static native String getHardwareFeatureName_0(int i2);

    private static native String getIppVersion_0();

    private static native int getNumThreads_0();

    private static native int getNumberOfCPUs_0();

    private static native int getOptimalDFTSize_0(int i2);

    private static native int getThreadNum_0();

    private static native long getTickCount_0();

    private static native double getTickFrequency_0();

    private static native int getVersionMajor_0();

    private static native int getVersionMinor_0();

    private static native int getVersionRevision_0();

    private static native String getVersionString_0();

    private static int h() {
        return 4;
    }

    private static native void hconcat_0(long j2, long j3);

    private static String i() {
        return "";
    }

    private static native void idct_0(long j2, long j3, int i2);

    private static native void idct_1(long j2, long j3);

    private static native void idft_0(long j2, long j3, int i2, int i3);

    private static native void idft_1(long j2, long j3, int i2);

    private static native void idft_2(long j2, long j3);

    private static native void inRange_0(long j2, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, long j3);

    private static native void insertChannel_0(long j2, long j3, int i2);

    private static native double invert_0(long j2, long j3, int i2);

    private static native double invert_1(long j2, long j3);

    private static native double kmeans_0(long j2, int i2, long j3, int i3, int i4, double d2, int i5, int i6, long j4);

    private static native double kmeans_1(long j2, int i2, long j3, int i3, int i4, double d2, int i5, int i6);

    private static native void log_0(long j2, long j3);

    private static native void magnitude_0(long j2, long j3, long j4);

    private static native void max_0(long j2, long j3, long j4);

    private static native void max_1(long j2, double d2, double d3, double d4, double d5, long j3);

    private static native void meanStdDev_0(long j2, long j3, long j4, long j5);

    private static native void meanStdDev_1(long j2, long j3, long j4);

    private static native double[] mean_0(long j2, long j3);

    private static native double[] mean_1(long j2);

    private static native void merge_0(long j2, long j3);

    private static native void min_0(long j2, long j3, long j4);

    private static native void min_1(long j2, double d2, double d3, double d4, double d5, long j3);

    private static native void mixChannels_0(long j2, long j3, long j4);

    private static native void mulSpectrums_0(long j2, long j3, long j4, int i2, boolean z2);

    private static native void mulSpectrums_1(long j2, long j3, long j4, int i2);

    private static native void mulTransposed_0(long j2, long j3, boolean z2, long j4, double d2, int i2);

    private static native void mulTransposed_1(long j2, long j3, boolean z2, long j4, double d2);

    private static native void mulTransposed_2(long j2, long j3, boolean z2, long j4);

    private static native void mulTransposed_3(long j2, long j3, boolean z2);

    private static native void multiply_0(long j2, long j3, long j4, double d2, int i2);

    private static native void multiply_1(long j2, long j3, long j4, double d2);

    private static native void multiply_2(long j2, long j3, long j4);

    private static native void multiply_3(long j2, double d2, double d3, double d4, double d5, long j3, double d6, int i2);

    private static native void multiply_4(long j2, double d2, double d3, double d4, double d5, long j3, double d6);

    private static native void multiply_5(long j2, double d2, double d3, double d4, double d5, long j3);

    private static native double[] n_minMaxLocManual(long j2, long j3);

    private static native double norm_0(long j2, int i2, long j3);

    private static native double norm_1(long j2, int i2);

    private static native double norm_2(long j2);

    private static native double norm_3(long j2, long j3, int i2, long j4);

    private static native double norm_4(long j2, long j3, int i2);

    private static native double norm_5(long j2, long j3);

    private static native void normalize_0(long j2, long j3, double d2, double d3, int i2, int i3, long j4);

    private static native void normalize_1(long j2, long j3, double d2, double d3, int i2, int i3);

    private static native void normalize_2(long j2, long j3, double d2, double d3, int i2);

    private static native void normalize_3(long j2, long j3, double d2, double d3);

    private static native void normalize_4(long j2, long j3, double d2);

    private static native void normalize_5(long j2, long j3);

    private static native void patchNaNs_0(long j2, double d2);

    private static native void patchNaNs_1(long j2);

    private static native void perspectiveTransform_0(long j2, long j3, long j4);

    private static native void phase_0(long j2, long j3, long j4, boolean z2);

    private static native void phase_1(long j2, long j3, long j4);

    private static native void polarToCart_0(long j2, long j3, long j4, long j5, boolean z2);

    private static native void polarToCart_1(long j2, long j3, long j4, long j5);

    private static native void pow_0(long j2, double d2, long j3);

    private static native void randShuffle_0(long j2, double d2);

    private static native void randShuffle_2(long j2);

    private static native void randn_0(long j2, double d2, double d3);

    private static native void randu_0(long j2, double d2, double d3);

    private static native void reduce_0(long j2, long j3, int i2, int i3, int i4);

    private static native void reduce_1(long j2, long j3, int i2, int i3);

    private static native void repeat_0(long j2, int i2, int i3, long j3);

    private static native void rotate_0(long j2, long j3, int i2);

    private static native void scaleAdd_0(long j2, double d2, long j3, long j4);

    private static native void setErrorVerbosity_0(boolean z2);

    private static native void setIdentity_0(long j2, double d2, double d3, double d4, double d5);

    private static native void setIdentity_1(long j2);

    private static native void setNumThreads_0(int i2);

    private static native void setRNGSeed_0(int i2);

    private static native void setUseIPP_0(boolean z2);

    private static native void setUseIPP_NotExact_0(boolean z2);

    private static native int solveCubic_0(long j2, long j3);

    private static native double solvePoly_0(long j2, long j3, int i2);

    private static native double solvePoly_1(long j2, long j3);

    private static native boolean solve_0(long j2, long j3, long j4, int i2);

    private static native boolean solve_1(long j2, long j3, long j4);

    private static native void sortIdx_0(long j2, long j3, int i2);

    private static native void sort_0(long j2, long j3, int i2);

    private static native void split_0(long j2, long j3);

    private static native void sqrt_0(long j2, long j3);

    private static native void subtract_0(long j2, long j3, long j4, long j5, int i2);

    private static native void subtract_1(long j2, long j3, long j4, long j5);

    private static native void subtract_2(long j2, long j3, long j4);

    private static native void subtract_3(long j2, double d2, double d3, double d4, double d5, long j3, long j4, int i2);

    private static native void subtract_4(long j2, double d2, double d3, double d4, double d5, long j3, long j4);

    private static native void subtract_5(long j2, double d2, double d3, double d4, double d5, long j3);

    private static native double[] sumElems_0(long j2);

    private static native double[] trace_0(long j2);

    private static native void transform_0(long j2, long j3, long j4);

    private static native void transpose_0(long j2, long j3);

    private static native boolean useIPP_0();

    private static native boolean useIPP_NotExact_0();

    private static native void vconcat_0(long j2, long j3);
}
