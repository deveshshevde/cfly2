package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import bl.b;
import cc.g;
import cc.l;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.q;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final e<DecodeFormat> f10470a = e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f10135c);

    /* renamed from: b  reason: collision with root package name */
    public static final e<PreferredColorSpace> f10471b = e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final e<DownsampleStrategy> f10472c = DownsampleStrategy.f10435h;

    /* renamed from: d  reason: collision with root package name */
    public static final e<Boolean> f10473d = e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);

    /* renamed from: e  reason: collision with root package name */
    public static final e<Boolean> f10474e = e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f10475f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: g  reason: collision with root package name */
    private static final a f10476g = new a() {
        public void a() {
        }

        public void a(bl.e eVar, Bitmap bitmap) {
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f10477h = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: i  reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f10478i = l.a(0);

    /* renamed from: j  reason: collision with root package name */
    private final bl.e f10479j;

    /* renamed from: k  reason: collision with root package name */
    private final DisplayMetrics f10480k;

    /* renamed from: l  reason: collision with root package name */
    private final b f10481l;

    /* renamed from: m  reason: collision with root package name */
    private final List<ImageHeaderParser> f10482m;

    /* renamed from: n  reason: collision with root package name */
    private final p f10483n = p.a();

    public interface a {
        void a();

        void a(bl.e eVar, Bitmap bitmap) throws IOException;
    }

    public k(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, bl.e eVar, b bVar) {
        this.f10482m = list;
        this.f10480k = (DisplayMetrics) cc.k.a(displayMetrics);
        this.f10479j = (bl.e) cc.k.a(eVar);
        this.f10481l = (b) cc.k.a(bVar);
    }

    private static int a(double d2) {
        int b2 = b(d2);
        double d3 = (double) b2;
        Double.isNaN(d3);
        int c2 = c(d3 * d2);
        double d4 = (double) (((float) c2) / ((float) b2));
        Double.isNaN(d4);
        double d5 = (double) c2;
        Double.isNaN(d5);
        return c((d2 / d4) * d5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x017b, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L_0x017d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(com.bumptech.glide.load.resource.bitmap.q r28, android.graphics.BitmapFactory.Options r29, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r30, com.bumptech.glide.load.DecodeFormat r31, com.bumptech.glide.load.PreferredColorSpace r32, boolean r33, int r34, int r35, boolean r36, com.bumptech.glide.load.resource.bitmap.k.a r37) throws java.io.IOException {
        /*
            r27 = this;
            r8 = r27
            r7 = r28
            r6 = r29
            r5 = r32
            r4 = r37
            long r20 = cc.g.a()
            bl.e r0 = r8.f10479j
            int[] r0 = a((com.bumptech.glide.load.resource.bitmap.q) r7, (android.graphics.BitmapFactory.Options) r6, (com.bumptech.glide.load.resource.bitmap.k.a) r4, (bl.e) r0)
            r22 = 0
            r3 = r0[r22]
            r2 = 1
            r1 = r0[r2]
            java.lang.String r0 = r6.outMimeType
            r9 = -1
            if (r3 == r9) goto L_0x0026
            if (r1 != r9) goto L_0x0023
            goto L_0x0026
        L_0x0023:
            r23 = r33
            goto L_0x0028
        L_0x0026:
            r23 = 0
        L_0x0028:
            int r15 = r28.b()
            int r14 = com.bumptech.glide.load.resource.bitmap.x.a((int) r15)
            boolean r24 = com.bumptech.glide.load.resource.bitmap.x.b((int) r15)
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r13 = r34
            if (r13 != r9) goto L_0x0048
            boolean r10 = a((int) r14)
            r12 = r35
            if (r10 == 0) goto L_0x0045
            r25 = r1
            goto L_0x004c
        L_0x0045:
            r25 = r3
            goto L_0x004c
        L_0x0048:
            r12 = r35
            r25 = r13
        L_0x004c:
            if (r12 != r9) goto L_0x005a
            boolean r9 = a((int) r14)
            if (r9 == 0) goto L_0x0057
            r26 = r3
            goto L_0x005c
        L_0x0057:
            r26 = r1
            goto L_0x005c
        L_0x005a:
            r26 = r12
        L_0x005c:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r11 = r28.a()
            bl.e r10 = r8.f10479j
            r9 = r11
            r16 = r10
            r10 = r28
            r8 = r11
            r11 = r37
            r12 = r16
            r13 = r30
            r33 = r8
            r8 = r15
            r15 = r3
            r16 = r1
            r17 = r25
            r18 = r26
            r19 = r29
            a(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r11 = r0
            r0 = r27
            r10 = r1
            r1 = r28
            r9 = 1
            r2 = r31
            r12 = r3
            r3 = r23
            r13 = r4
            r4 = r24
            r14 = r5
            r5 = r29
            r15 = r6
            r6 = r25
            r7 = r26
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto L_0x009f
            r2 = 1
            goto L_0x00a0
        L_0x009f:
            r2 = 0
        L_0x00a0:
            int r0 = r15.inSampleSize
            java.lang.String r3 = "Downsampler"
            if (r0 == r9) goto L_0x00ad
            if (r2 == 0) goto L_0x00a9
            goto L_0x00ad
        L_0x00a9:
            r0 = r27
            goto L_0x0158
        L_0x00ad:
            r0 = r27
            r4 = r33
            boolean r4 = r0.a((com.bumptech.glide.load.ImageHeaderParser.ImageType) r4)
            if (r4 == 0) goto L_0x0158
            if (r12 < 0) goto L_0x00c5
            if (r10 < 0) goto L_0x00c5
            if (r36 == 0) goto L_0x00c5
            if (r2 == 0) goto L_0x00c5
            r1 = r25
            r2 = r26
            goto L_0x014f
        L_0x00c5:
            boolean r2 = a((android.graphics.BitmapFactory.Options) r29)
            if (r2 == 0) goto L_0x00d3
            int r2 = r15.inTargetDensity
            float r2 = (float) r2
            int r4 = r15.inDensity
            float r4 = (float) r4
            float r2 = r2 / r4
            goto L_0x00d5
        L_0x00d3:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x00d5:
            int r4 = r15.inSampleSize
            float r5 = (float) r12
            float r6 = (float) r4
            float r5 = r5 / r6
            r31 = r2
            double r1 = (double) r5
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            float r2 = (float) r10
            float r2 = r2 / r6
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            int r2 = (int) r5
            float r1 = (float) r1
            float r1 = r1 * r31
            int r1 = java.lang.Math.round(r1)
            float r2 = (float) r2
            float r2 = r2 * r31
            int r2 = java.lang.Math.round(r2)
            r5 = 2
            boolean r6 = android.util.Log.isLoggable(r3, r5)
            if (r6 == 0) goto L_0x014f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Calculated target ["
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = "x"
            r5.append(r6)
            r5.append(r2)
            java.lang.String r7 = "] for source ["
            r5.append(r7)
            r5.append(r12)
            r5.append(r6)
            r5.append(r10)
            java.lang.String r6 = "], sampleSize: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = ", targetDensity: "
            r5.append(r4)
            int r4 = r15.inTargetDensity
            r5.append(r4)
            java.lang.String r4 = ", density: "
            r5.append(r4)
            int r4 = r15.inDensity
            r5.append(r4)
            java.lang.String r4 = ", density multiplier: "
            r5.append(r4)
            r4 = r31
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.util.Log.v(r3, r4)
        L_0x014f:
            if (r1 <= 0) goto L_0x0158
            if (r2 <= 0) goto L_0x0158
            bl.e r4 = r0.f10479j
            a((android.graphics.BitmapFactory.Options) r15, (bl.e) r4, (int) r1, (int) r2)
        L_0x0158:
            if (r14 == 0) goto L_0x0185
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0177
            com.bumptech.glide.load.PreferredColorSpace r1 = com.bumptech.glide.load.PreferredColorSpace.DISPLAY_P3
            if (r14 != r1) goto L_0x0172
            android.graphics.ColorSpace r1 = r15.outColorSpace
            if (r1 == 0) goto L_0x0172
            android.graphics.ColorSpace r1 = r15.outColorSpace
            boolean r1 = r1.isWideGamut()
            if (r1 == 0) goto L_0x0172
            r22 = 1
        L_0x0172:
            if (r22 == 0) goto L_0x017d
            android.graphics.ColorSpace$Named r1 = android.graphics.ColorSpace.Named.DISPLAY_P3
            goto L_0x017f
        L_0x0177:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x0185
        L_0x017d:
            android.graphics.ColorSpace$Named r1 = android.graphics.ColorSpace.Named.SRGB
        L_0x017f:
            android.graphics.ColorSpace r1 = android.graphics.ColorSpace.get(r1)
            r15.inPreferredColorSpace = r1
        L_0x0185:
            bl.e r1 = r0.f10479j
            r2 = r28
            android.graphics.Bitmap r1 = b(r2, r15, r13, r1)
            bl.e r2 = r0.f10479j
            r13.a(r2, r1)
            r2 = 2
            boolean r2 = android.util.Log.isLoggable(r3, r2)
            if (r2 == 0) goto L_0x01a6
            r9 = r12
            r12 = r29
            r13 = r1
            r14 = r34
            r15 = r35
            r16 = r20
            a(r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x01a6:
            r2 = 0
            if (r1 == 0) goto L_0x01c1
            android.util.DisplayMetrics r2 = r0.f10480k
            int r2 = r2.densityDpi
            r1.setDensity(r2)
            bl.e r2 = r0.f10479j
            android.graphics.Bitmap r2 = com.bumptech.glide.load.resource.bitmap.x.a((bl.e) r2, (android.graphics.Bitmap) r1, (int) r8)
            boolean r3 = r1.equals(r2)
            if (r3 != 0) goto L_0x01c1
            bl.e r3 = r0.f10479j
            r3.a((android.graphics.Bitmap) r1)
        L_0x01c1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.k.a(com.bumptech.glide.load.resource.bitmap.q, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.DecodeFormat, com.bumptech.glide.load.PreferredColorSpace, boolean, int, int, boolean, com.bumptech.glide.load.resource.bitmap.k$a):android.graphics.Bitmap");
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (k.class) {
            Queue<BitmapFactory.Options> queue = f10478i;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }

    private s<Bitmap> a(q qVar, int i2, int i3, f fVar, a aVar) throws IOException {
        f fVar2 = fVar;
        byte[] bArr = (byte[]) this.f10481l.a(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) fVar2.a(f10470a);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) fVar2.a(f10471b);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar2.a(DownsampleStrategy.f10435h);
        boolean booleanValue = ((Boolean) fVar2.a(f10473d)).booleanValue();
        e eVar = f10474e;
        try {
            return e.a(a(qVar, a2, downsampleStrategy, decodeFormat, preferredColorSpace, fVar2.a(eVar) != null && ((Boolean) fVar2.a(eVar)).booleanValue(), i2, i3, booleanValue, aVar), this.f10479j);
        } finally {
            c(a2);
            this.f10481l.a(bArr);
        }
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + b(options), illegalArgumentException);
    }

    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + b(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + g.a(j2));
    }

    private static void a(BitmapFactory.Options options, bl.e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.b(i2, i3, config);
    }

    private static void a(ImageHeaderParser.ImageType imageType, q qVar, a aVar, bl.e eVar, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        BitmapFactory.Options options2 = options;
        if (i12 <= 0 || i13 <= 0) {
            String str = "x";
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType2 + " with target [" + i14 + str + i15 + "]");
                return;
            }
            return;
        }
        if (a(i2)) {
            i7 = i12;
            i8 = i13;
        } else {
            i8 = i12;
            i7 = i13;
        }
        float a2 = downsampleStrategy2.a(i8, i7, i14, i15);
        if (a2 > 0.0f) {
            DownsampleStrategy.SampleSizeRounding b2 = downsampleStrategy2.b(i8, i7, i14, i15);
            if (b2 != null) {
                float f2 = (float) i8;
                float f3 = (float) i7;
                int c2 = i8 / c((double) (a2 * f2));
                int c3 = i7 / c((double) (a2 * f3));
                int max = b2 == DownsampleStrategy.SampleSizeRounding.MEMORY ? Math.max(c2, c3) : Math.min(c2, c3);
                String str2 = "x";
                if (Build.VERSION.SDK_INT > 23 || !f10475f.contains(options2.outMimeType)) {
                    i9 = Math.max(1, Integer.highestOneBit(max));
                    if (b2 == DownsampleStrategy.SampleSizeRounding.MEMORY && ((float) i9) < 1.0f / a2) {
                        i9 <<= 1;
                    }
                } else {
                    i9 = 1;
                }
                options2.inSampleSize = i9;
                if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                    float min = (float) Math.min(i9, 8);
                    i10 = (int) Math.ceil((double) (f2 / min));
                    i11 = (int) Math.ceil((double) (f3 / min));
                    int i16 = i9 / 8;
                    if (i16 > 0) {
                        i10 /= i16;
                        i11 /= i16;
                    }
                } else {
                    if (!(imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A)) {
                        if (imageType.isWebp()) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                float f4 = (float) i9;
                                i10 = Math.round(f2 / f4);
                                i11 = Math.round(f3 / f4);
                            }
                        } else if (i8 % i9 == 0 && i7 % i9 == 0) {
                            i10 = i8 / i9;
                            i11 = i7 / i9;
                        } else {
                            int[] a3 = a(qVar, options2, aVar, eVar);
                            i10 = a3[0];
                            i11 = a3[1];
                        }
                    }
                    float f5 = (float) i9;
                    i10 = (int) Math.floor((double) (f2 / f5));
                    i11 = (int) Math.floor((double) (f3 / f5));
                }
                double a4 = (double) downsampleStrategy2.a(i10, i11, i14, i15);
                if (Build.VERSION.SDK_INT >= 19) {
                    options2.inTargetDensity = a(a4);
                    options2.inDensity = b(a4);
                }
                if (a(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                if (Log.isLoggable("Downsampler", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculate scaling, source: [");
                    sb.append(i3);
                    String str3 = str2;
                    sb.append(str3);
                    sb.append(i4);
                    sb.append("], degreesToRotate: ");
                    sb.append(i2);
                    sb.append(", target: [");
                    sb.append(i14);
                    sb.append(str3);
                    sb.append(i15);
                    sb.append("], power of two scaled: [");
                    sb.append(i10);
                    sb.append(str3);
                    sb.append(i11);
                    sb.append("], exact scale factor: ");
                    sb.append(a2);
                    sb.append(", power of 2 sample size: ");
                    sb.append(i9);
                    sb.append(", adjusted scale factor: ");
                    sb.append(a4);
                    sb.append(", target density: ");
                    sb.append(options2.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options2.inDensity);
                    Log.v("Downsampler", sb.toString());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        String str4 = "x";
        int i17 = i12;
        throw new IllegalArgumentException("Cannot scale with factor: " + a2 + " from: " + downsampleStrategy2 + ", source: [" + i17 + str4 + i13 + "], target: [" + i14 + str4 + i15 + "]");
    }

    private void a(q qVar, DecodeFormat decodeFormat, boolean z2, boolean z3, BitmapFactory.Options options, int i2, int i3) {
        if (!this.f10483n.a(i2, i3, options, z2, z3)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z4 = false;
            try {
                z4 = qVar.a().hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                }
            }
            options.inPreferredConfig = z4 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f10477h.contains(imageType);
    }

    private static int[] a(q qVar, BitmapFactory.Options options, a aVar, bl.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        b(qVar, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0050 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap b(com.bumptech.glide.load.resource.bitmap.q r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.k.a r7, bl.e r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto L_0x000c
            r7.a()
            r5.c()
        L_0x000c:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.x.a()
            r4.lock()
            android.graphics.Bitmap r5 = r5.a(r6)     // Catch:{ IllegalArgumentException -> 0x0027 }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.x.a()
            r6.unlock()
            return r5
        L_0x0025:
            r5 = move-exception
            goto L_0x0052
        L_0x0027:
            r4 = move-exception
            java.io.IOException r1 = a((java.lang.IllegalArgumentException) r4, (int) r1, (int) r2, (java.lang.String) r3, (android.graphics.BitmapFactory.Options) r6)     // Catch:{ all -> 0x0025 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0025 }
        L_0x0038:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0051
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ IOException -> 0x0050 }
            r8.a((android.graphics.Bitmap) r0)     // Catch:{ IOException -> 0x0050 }
            r0 = 0
            r6.inBitmap = r0     // Catch:{ IOException -> 0x0050 }
            android.graphics.Bitmap r5 = b(r5, r6, r7, r8)     // Catch:{ IOException -> 0x0050 }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.x.a()
            r6.unlock()
            return r5
        L_0x0050:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0051:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0052:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.x.a()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.k.b(com.bumptech.glide.load.resource.bitmap.q, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.k$a, bl.e):android.graphics.Bitmap");
    }

    private static String b(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        Queue<BitmapFactory.Options> queue = f10478i;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public s<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, f fVar) throws IOException {
        return a((q) new q.c(parcelFileDescriptor, this.f10482m, this.f10481l), i2, i3, fVar, f10476g);
    }

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, f fVar, a aVar) throws IOException {
        return a((q) new q.b(inputStream, this.f10482m, this.f10481l), i2, i3, fVar, aVar);
    }

    public s<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, f fVar) throws IOException {
        return a((q) new q.a(byteBuffer, this.f10482m, this.f10481l), i2, i3, fVar, f10476g);
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }
}
