package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class MediaCodecUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f15813a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<a, List<a>> f15814b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f15815c;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f15816d;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f15817e;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f15818f;

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, Integer> f15819g;

    /* renamed from: h  reason: collision with root package name */
    private static final Map<String, Integer> f15820h;

    /* renamed from: i  reason: collision with root package name */
    private static final Map<String, Integer> f15821i;

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f15822j;

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f15823k;

    /* renamed from: l  reason: collision with root package name */
    private static int f15824l = -1;

    private interface b {
        int a();

        MediaCodecInfo a(int i2);

        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);
    }

    private static final class d implements b {

        /* renamed from: a  reason: collision with root package name */
        private final int f11658a;

        /* renamed from: b  reason: collision with root package name */
        private MediaCodecInfo[] f11659b;

        public d(boolean z2, boolean z3) {
            this.f11658a = (z2 || z3) ? 1 : 0;
        }

        @EnsuresNonNull({"mediaCodecInfos"})
        private void c() {
            if (this.f11659b == null) {
                this.f11659b = new MediaCodecList(this.f11658a).getCodecInfos();
            }
        }

        public int a() {
            c();
            return this.f11659b.length;
        }

        public MediaCodecInfo a(int i2) {
            c();
            return this.f11659b[i2];
        }

        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        public boolean b() {
            return true;
        }

        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f15825a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f15826b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f15827c;

        public a(String str, boolean z2, boolean z3) {
            this.f15825a = str;
            this.f15826b = z2;
            this.f15827c = z3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f15825a, aVar.f15825a) && this.f15826b == aVar.f15826b && this.f15827c == aVar.f15827c;
        }

        public int hashCode() {
            int i2 = 1231;
            int hashCode = (((this.f15825a.hashCode() + 31) * 31) + (this.f15826b ? 1231 : 1237)) * 31;
            if (!this.f15827c) {
                i2 = 1237;
            }
            return hashCode + i2;
        }
    }

    private static final class c implements b {
        private c() {
        }

        public int a() {
            return MediaCodecList.getCodecCount();
        }

        public MediaCodecInfo a(int i2) {
            return MediaCodecList.getCodecInfoAt(i2);
        }

        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        public boolean b() {
            return false;
        }

        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }
    }

    private interface e<T> {
        int getScore(T t2);
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15815c = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        sparseIntArray.put(110, 16);
        sparseIntArray.put(122, 32);
        sparseIntArray.put(IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 64);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f15816d = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        f15817e = sparseIntArray3;
        sparseIntArray3.put(0, 1);
        sparseIntArray3.put(1, 2);
        sparseIntArray3.put(2, 4);
        sparseIntArray3.put(3, 8);
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        f15818f = sparseIntArray4;
        sparseIntArray4.put(10, 1);
        sparseIntArray4.put(11, 2);
        sparseIntArray4.put(20, 4);
        sparseIntArray4.put(21, 8);
        sparseIntArray4.put(30, 16);
        sparseIntArray4.put(31, 32);
        sparseIntArray4.put(40, 64);
        sparseIntArray4.put(41, 128);
        sparseIntArray4.put(50, 256);
        sparseIntArray4.put(51, 512);
        sparseIntArray4.put(60, 2048);
        sparseIntArray4.put(61, 4096);
        sparseIntArray4.put(62, 8192);
        HashMap hashMap = new HashMap();
        f15819g = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", Integer.valueOf(MemoryConstants.MB));
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
        HashMap hashMap2 = new HashMap();
        f15820h = hashMap2;
        hashMap2.put("00", 1);
        hashMap2.put("01", 2);
        hashMap2.put("02", 4);
        hashMap2.put("03", 8);
        hashMap2.put("04", 16);
        hashMap2.put("05", 32);
        hashMap2.put("06", 64);
        hashMap2.put("07", 128);
        hashMap2.put("08", 256);
        hashMap2.put("09", 512);
        HashMap hashMap3 = new HashMap();
        f15821i = hashMap3;
        hashMap3.put("01", 1);
        hashMap3.put("02", 2);
        hashMap3.put("03", 4);
        hashMap3.put("04", 8);
        hashMap3.put("05", 16);
        hashMap3.put("06", 32);
        hashMap3.put("07", 64);
        hashMap3.put("08", 128);
        hashMap3.put("09", 256);
        SparseIntArray sparseIntArray5 = new SparseIntArray();
        f15822j = sparseIntArray5;
        sparseIntArray5.put(0, 1);
        sparseIntArray5.put(1, 2);
        sparseIntArray5.put(2, 4);
        sparseIntArray5.put(3, 8);
        sparseIntArray5.put(4, 16);
        sparseIntArray5.put(5, 32);
        sparseIntArray5.put(6, 64);
        sparseIntArray5.put(7, 128);
        sparseIntArray5.put(8, 256);
        sparseIntArray5.put(9, 512);
        sparseIntArray5.put(10, 1024);
        sparseIntArray5.put(11, 2048);
        sparseIntArray5.put(12, 4096);
        sparseIntArray5.put(13, 8192);
        sparseIntArray5.put(14, 16384);
        sparseIntArray5.put(15, 32768);
        sparseIntArray5.put(16, 65536);
        sparseIntArray5.put(17, 131072);
        sparseIntArray5.put(18, 262144);
        sparseIntArray5.put(19, 524288);
        sparseIntArray5.put(20, MemoryConstants.MB);
        sparseIntArray5.put(21, 2097152);
        sparseIntArray5.put(22, 4194304);
        sparseIntArray5.put(23, 8388608);
        SparseIntArray sparseIntArray6 = new SparseIntArray();
        f15823k = sparseIntArray6;
        sparseIntArray6.put(1, 1);
        sparseIntArray6.put(2, 2);
        sparseIntArray6.put(3, 3);
        sparseIntArray6.put(4, 4);
        sparseIntArray6.put(5, 5);
        sparseIntArray6.put(6, 6);
        sparseIntArray6.put(17, 17);
        sparseIntArray6.put(20, 20);
        sparseIntArray6.put(23, 23);
        sparseIntArray6.put(29, 29);
        sparseIntArray6.put(39, 39);
        sparseIntArray6.put(42, 42);
    }

    private static int a(int i2) {
        if (i2 == 1 || i2 == 2) {
            return 25344;
        }
        switch (i2) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(Format format, a aVar) {
        try {
            return aVar.a(format) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(e eVar, Object obj, Object obj2) {
        return eVar.getScore(obj2) - eVar.getScore(obj);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(a aVar) {
        return aVar.f15828a.startsWith("OMX.google") ? 1 : 0;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        if (r3.equals("av01") == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(com.google.android.exoplayer2.Format r6) {
        /*
            java.lang.String r0 = r6.f15089f
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r0 = r6.f15089f
            java.lang.String r2 = "\\."
            java.lang.String[] r0 = r0.split(r2)
            java.lang.String r2 = r6.f15092i
            java.lang.String r3 = "video/dolby-vision"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x001f
            java.lang.String r6 = r6.f15089f
            android.util.Pair r6 = a((java.lang.String) r6, (java.lang.String[]) r0)
            return r6
        L_0x001f:
            r2 = 0
            r3 = r0[r2]
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case 3004662: goto L_0x0071;
                case 3006243: goto L_0x0066;
                case 3006244: goto L_0x005b;
                case 3199032: goto L_0x0050;
                case 3214780: goto L_0x0045;
                case 3356560: goto L_0x003a;
                case 3624515: goto L_0x002f;
                default: goto L_0x002d;
            }
        L_0x002d:
            r2 = -1
            goto L_0x007a
        L_0x002f:
            java.lang.String r2 = "vp09"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0038
            goto L_0x002d
        L_0x0038:
            r2 = 6
            goto L_0x007a
        L_0x003a:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0043
            goto L_0x002d
        L_0x0043:
            r2 = 5
            goto L_0x007a
        L_0x0045:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x004e
            goto L_0x002d
        L_0x004e:
            r2 = 4
            goto L_0x007a
        L_0x0050:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0059
            goto L_0x002d
        L_0x0059:
            r2 = 3
            goto L_0x007a
        L_0x005b:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0064
            goto L_0x002d
        L_0x0064:
            r2 = 2
            goto L_0x007a
        L_0x0066:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x006f
            goto L_0x002d
        L_0x006f:
            r2 = 1
            goto L_0x007a
        L_0x0071:
            java.lang.String r5 = "av01"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x007a
            goto L_0x002d
        L_0x007a:
            switch(r2) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0093;
                case 2: goto L_0x0093;
                case 3: goto L_0x008c;
                case 4: goto L_0x008c;
                case 5: goto L_0x0085;
                case 6: goto L_0x007e;
                default: goto L_0x007d;
            }
        L_0x007d:
            return r1
        L_0x007e:
            java.lang.String r6 = r6.f15089f
            android.util.Pair r6 = d(r6, r0)
            return r6
        L_0x0085:
            java.lang.String r6 = r6.f15089f
            android.util.Pair r6 = e(r6, r0)
            return r6
        L_0x008c:
            java.lang.String r6 = r6.f15089f
            android.util.Pair r6 = b(r6, r0)
            return r6
        L_0x0093:
            java.lang.String r6 = r6.f15089f
            android.util.Pair r6 = c(r6, r0)
            return r6
        L_0x009a:
            java.lang.String r1 = r6.f15089f
            com.google.android.exoplayer2.video.ColorInfo r6 = r6.f15104u
            android.util.Pair r6 = a((java.lang.String) r1, (java.lang.String[]) r0, (com.google.android.exoplayer2.video.ColorInfo) r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.a(com.google.android.exoplayer2.Format):android.util.Pair");
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        if (strArr.length < 3) {
            String valueOf = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(valueOf) : new String("Ignoring malformed Dolby Vision codec string: "));
            return null;
        }
        Matcher matcher = f15813a.matcher(strArr[1]);
        if (!matcher.matches()) {
            String valueOf2 = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(valueOf2) : new String("Ignoring malformed Dolby Vision codec string: "));
            return null;
        }
        String group = matcher.group(1);
        Integer num = f15820h.get(group);
        if (num == null) {
            String valueOf3 = String.valueOf(group);
            k.c("MediaCodecUtil", valueOf3.length() != 0 ? "Unknown Dolby Vision profile string: ".concat(valueOf3) : new String("Unknown Dolby Vision profile string: "));
            return null;
        }
        String str2 = strArr[2];
        Integer num2 = f15821i.get(str2);
        if (num2 != null) {
            return new Pair<>(num, num2);
        }
        String valueOf4 = String.valueOf(str2);
        k.c("MediaCodecUtil", valueOf4.length() != 0 ? "Unknown Dolby Vision level string: ".concat(valueOf4) : new String("Unknown Dolby Vision level string: "));
        return null;
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr, ColorInfo colorInfo) {
        StringBuilder sb;
        String sb2;
        if (strArr.length < 4) {
            String valueOf = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(valueOf) : new String("Ignoring malformed AV1 codec string: "));
            return null;
        }
        int i2 = 1;
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                sb = new StringBuilder(32);
                sb.append("Unknown AV1 profile: ");
                sb.append(parseInt);
            } else if (parseInt3 == 8 || parseInt3 == 10) {
                if (parseInt3 != 8) {
                    i2 = (colorInfo == null || !(colorInfo.f17199d != null || colorInfo.f17198c == 7 || colorInfo.f17198c == 6)) ? 2 : 4096;
                }
                int i3 = f15822j.get(parseInt2, -1);
                if (i3 != -1) {
                    return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
                }
                sb = new StringBuilder(30);
                sb.append("Unknown AV1 level: ");
                sb.append(parseInt2);
            } else {
                StringBuilder sb3 = new StringBuilder(34);
                sb3.append("Unknown AV1 bit depth: ");
                sb3.append(parseInt3);
                sb2 = sb3.toString();
                k.c("MediaCodecUtil", sb2);
                return null;
            }
            sb2 = sb.toString();
            k.c("MediaCodecUtil", sb2);
            return null;
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(valueOf2) : new String("Ignoring malformed AV1 codec string: "));
            return null;
        }
    }

    public static a a() throws DecoderQueryException {
        a a2 = a("audio/raw", false, false);
        if (a2 == null) {
            return null;
        }
        return a.a(a2.f15828a);
    }

    public static a a(String str, boolean z2, boolean z3) throws DecoderQueryException {
        List<a> b2 = b(str, z2, z3);
        if (b2.isEmpty()) {
            return null;
        }
        return b2.get(0);
    }

    private static String a(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (!str2.equals("audio/flac") || !"OMX.lge.flac.decoder".equals(str)) {
                return null;
            }
            return "audio/x-lg-flac";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ea A[SYNTHETIC, Splitter:B:50:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.google.android.exoplayer2.mediacodec.a> a(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.a r25, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b r26) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r1 = r25
            r2 = r26
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0157 }
            r5.<init>()     // Catch:{ Exception -> 0x0157 }
            java.lang.String r15 = r1.f15825a     // Catch:{ Exception -> 0x0157 }
            int r14 = r26.a()     // Catch:{ Exception -> 0x0157 }
            boolean r13 = r26.b()     // Catch:{ Exception -> 0x0157 }
            r0 = 0
            r12 = 0
        L_0x0019:
            if (r12 >= r14) goto L_0x0156
            android.media.MediaCodecInfo r0 = r2.a(r12)     // Catch:{ Exception -> 0x0157 }
            boolean r6 = a((android.media.MediaCodecInfo) r0)     // Catch:{ Exception -> 0x0157 }
            if (r6 == 0) goto L_0x002d
        L_0x0025:
            r22 = r12
            r23 = r13
            r24 = r14
            goto L_0x0115
        L_0x002d:
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x0157 }
            boolean r6 = a(r0, r11, r13, r15)     // Catch:{ Exception -> 0x0157 }
            if (r6 != 0) goto L_0x0038
            goto L_0x0025
        L_0x0038:
            java.lang.String r10 = a((android.media.MediaCodecInfo) r0, (java.lang.String) r11, (java.lang.String) r15)     // Catch:{ Exception -> 0x0157 }
            if (r10 != 0) goto L_0x003f
            goto L_0x0025
        L_0x003f:
            android.media.MediaCodecInfo$CodecCapabilities r9 = r0.getCapabilitiesForType(r10)     // Catch:{ Exception -> 0x00d7 }
            boolean r6 = r2.a(r4, r10, r9)     // Catch:{ Exception -> 0x00d7 }
            boolean r7 = r2.b(r4, r10, r9)     // Catch:{ Exception -> 0x00d7 }
            boolean r8 = r1.f15827c     // Catch:{ Exception -> 0x00d7 }
            if (r8 != 0) goto L_0x0051
            if (r7 != 0) goto L_0x0025
        L_0x0051:
            boolean r7 = r1.f15827c     // Catch:{ Exception -> 0x00d7 }
            if (r7 == 0) goto L_0x0058
            if (r6 != 0) goto L_0x0058
            goto L_0x0025
        L_0x0058:
            boolean r6 = r2.a(r3, r10, r9)     // Catch:{ Exception -> 0x00d7 }
            boolean r7 = r2.b(r3, r10, r9)     // Catch:{ Exception -> 0x00d7 }
            boolean r8 = r1.f15826b     // Catch:{ Exception -> 0x00d7 }
            if (r8 != 0) goto L_0x0066
            if (r7 != 0) goto L_0x0025
        L_0x0066:
            boolean r7 = r1.f15826b     // Catch:{ Exception -> 0x00d7 }
            if (r7 == 0) goto L_0x006d
            if (r6 != 0) goto L_0x006d
            goto L_0x0025
        L_0x006d:
            boolean r16 = c(r0)     // Catch:{ Exception -> 0x00d7 }
            boolean r17 = e(r0)     // Catch:{ Exception -> 0x00d7 }
            boolean r0 = g(r0)     // Catch:{ Exception -> 0x00d7 }
            boolean r18 = a((java.lang.String) r11)     // Catch:{ Exception -> 0x00d7 }
            if (r13 == 0) goto L_0x0083
            boolean r7 = r1.f15826b     // Catch:{ Exception -> 0x00d7 }
            if (r7 == r6) goto L_0x0089
        L_0x0083:
            if (r13 != 0) goto L_0x00ac
            boolean r7 = r1.f15826b     // Catch:{ Exception -> 0x00d7 }
            if (r7 != 0) goto L_0x00ac
        L_0x0089:
            r19 = 0
            r6 = r11
            r7 = r15
            r8 = r10
            r20 = r10
            r10 = r16
            r21 = r11
            r11 = r17
            r22 = r12
            r12 = r0
            r23 = r13
            r13 = r18
            r24 = r14
            r14 = r19
            com.google.android.exoplayer2.mediacodec.a r0 = com.google.android.exoplayer2.mediacodec.a.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00aa }
            r5.add(r0)     // Catch:{ Exception -> 0x00aa }
            goto L_0x0115
        L_0x00aa:
            r0 = move-exception
            goto L_0x00e2
        L_0x00ac:
            r20 = r10
            r21 = r11
            r22 = r12
            r23 = r13
            r24 = r14
            if (r23 != 0) goto L_0x0115
            if (r6 == 0) goto L_0x0115
            java.lang.String r6 = java.lang.String.valueOf(r21)     // Catch:{ Exception -> 0x00aa }
            java.lang.String r7 = ".secure"
            java.lang.String r6 = r6.concat(r7)     // Catch:{ Exception -> 0x00aa }
            r14 = 1
            r7 = r15
            r8 = r20
            r10 = r16
            r11 = r17
            r12 = r0
            r13 = r18
            com.google.android.exoplayer2.mediacodec.a r0 = com.google.android.exoplayer2.mediacodec.a.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00aa }
            r5.add(r0)     // Catch:{ Exception -> 0x00aa }
            return r5
        L_0x00d7:
            r0 = move-exception
            r20 = r10
            r21 = r11
            r22 = r12
            r23 = r13
            r24 = r14
        L_0x00e2:
            int r6 = com.google.android.exoplayer2.util.ad.f11755a     // Catch:{ Exception -> 0x0157 }
            r7 = 23
            java.lang.String r8 = "MediaCodecUtil"
            if (r6 > r7) goto L_0x011d
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x0157 }
            if (r6 != 0) goto L_0x011d
            java.lang.String r0 = java.lang.String.valueOf(r21)     // Catch:{ Exception -> 0x0157 }
            int r0 = r0.length()     // Catch:{ Exception -> 0x0157 }
            int r0 = r0 + 46
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0157 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r0 = "Skipping codec "
            r6.append(r0)     // Catch:{ Exception -> 0x0157 }
            r7 = r21
            r6.append(r7)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r0 = " (failed to query capabilities)"
            r6.append(r0)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x0157 }
            com.google.android.exoplayer2.util.k.d(r8, r0)     // Catch:{ Exception -> 0x0157 }
        L_0x0115:
            int r12 = r22 + 1
            r13 = r23
            r14 = r24
            goto L_0x0019
        L_0x011d:
            r7 = r21
            java.lang.String r1 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0157 }
            int r1 = r1.length()     // Catch:{ Exception -> 0x0157 }
            int r1 = r1 + 25
            java.lang.String r2 = java.lang.String.valueOf(r20)     // Catch:{ Exception -> 0x0157 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x0157 }
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0157 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r1 = "Failed to query codec "
            r2.append(r1)     // Catch:{ Exception -> 0x0157 }
            r2.append(r7)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x0157 }
            r1 = r20
            r2.append(r1)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0157 }
            com.google.android.exoplayer2.util.k.d(r8, r1)     // Catch:{ Exception -> 0x0157 }
            throw r0     // Catch:{ Exception -> 0x0157 }
        L_0x0156:
            return r5
        L_0x0157:
            r0 = move-exception
            com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException r1 = new com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException
            r2 = 0
            r1.<init>(r0)
            goto L_0x0160
        L_0x015f:
            throw r1
        L_0x0160:
            goto L_0x015f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.a(com.google.android.exoplayer2.mediacodec.MediaCodecUtil$a, com.google.android.exoplayer2.mediacodec.MediaCodecUtil$b):java.util.ArrayList");
    }

    public static List<a> a(List<a> list, Format format) {
        ArrayList arrayList = new ArrayList(list);
        a(arrayList, new e() {
            public final int getScore(Object obj) {
                return MediaCodecUtil.a(Format.this, (a) obj);
            }
        });
        return arrayList;
    }

    private static void a(String str, List<a> list) {
        if ("audio/raw".equals(str)) {
            if (ad.f11755a < 26 && ad.f11756b.equals("R9") && list.size() == 1 && list.get(0).f15828a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(a.a("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
            }
            a(list, $$Lambda$MediaCodecUtil$JyyfymaofdRGjjT6ORc76_SRGeU.INSTANCE);
        }
        if (ad.f11755a < 21 && list.size() > 1) {
            String str2 = list.get(0).f15828a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                a(list, $$Lambda$MediaCodecUtil$Del19KmAbXWtkp8_mGC8LBkqLO8.INSTANCE);
            }
        }
        if (ad.f11755a < 30 && list.size() > 1 && "OMX.qti.audio.decoder.flac".equals(list.get(0).f15828a)) {
            list.add(list.remove(0));
        }
    }

    private static <T> void a(List<T> list, e<T> eVar) {
        Collections.sort(list, new Comparator() {
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.a(MediaCodecUtil.e.this, obj, obj2);
            }
        });
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo) {
        return ad.f11755a >= 29 && b(mediaCodecInfo);
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z2 && str.endsWith(".secure"))) {
            return false;
        }
        if (ad.f11755a < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (ad.f11755a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(ad.f11756b) || ("Xiaomi".equals(ad.f11757c) && ad.f11756b.startsWith("HM")))) {
            return false;
        }
        if (ad.f11755a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(ad.f11756b) || "protou".equals(ad.f11756b) || "ville".equals(ad.f11756b) || "villeplus".equals(ad.f11756b) || "villec2".equals(ad.f11756b) || ad.f11756b.startsWith("gee") || "C6602".equals(ad.f11756b) || "C6603".equals(ad.f11756b) || "C6606".equals(ad.f11756b) || "C6616".equals(ad.f11756b) || "L36h".equals(ad.f11756b) || "SO-02E".equals(ad.f11756b))) {
            return false;
        }
        if (ad.f11755a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(ad.f11756b) || "C1505".equals(ad.f11756b) || "C1604".equals(ad.f11756b) || "C1605".equals(ad.f11756b))) {
            return false;
        }
        if (ad.f11755a < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(ad.f11757c) && (ad.f11756b.startsWith("zeroflte") || ad.f11756b.startsWith("zerolte") || ad.f11756b.startsWith("zenlte") || "SC-05G".equals(ad.f11756b) || "marinelteatt".equals(ad.f11756b) || "404SC".equals(ad.f11756b) || "SC-04G".equals(ad.f11756b) || "SCV31".equals(ad.f11756b)))) {
            return false;
        }
        if (ad.f11755a <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(ad.f11757c) && (ad.f11756b.startsWith("d2") || ad.f11756b.startsWith("serrano") || ad.f11756b.startsWith("jflte") || ad.f11756b.startsWith("santos") || ad.f11756b.startsWith("t0"))) {
            return false;
        }
        if (ad.f11755a > 19 || !ad.f11756b.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(str)) {
            return !"audio/eac3-joc".equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str);
        }
        return false;
    }

    private static boolean a(String str) {
        return ad.f11755a <= 22 && ("ODROID-XU3".equals(ad.f11758d) || "Nexus 10".equals(ad.f11758d)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
    }

    public static int b() throws DecoderQueryException {
        if (f15824l == -1) {
            int i2 = 0;
            a a2 = a("video/avc", false, false);
            if (a2 != null) {
                MediaCodecInfo.CodecProfileLevel[] a3 = a2.a();
                int length = a3.length;
                int i3 = 0;
                while (i2 < length) {
                    i3 = Math.max(a(a3[i2].level), i3);
                    i2++;
                }
                i2 = Math.max(i3, ad.f11755a >= 21 ? 345600 : 172800);
            }
            f15824l = i2;
        }
        return f15824l;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int b(a aVar) {
        String str = aVar.f15828a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (ad.f11755a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        if (strArr.length < 4) {
            String valueOf = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf) : new String("Ignoring malformed HEVC codec string: "));
            return null;
        }
        int i2 = 1;
        Matcher matcher = f15813a.matcher(strArr[1]);
        if (!matcher.matches()) {
            String valueOf2 = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf2) : new String("Ignoring malformed HEVC codec string: "));
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            if ("2".equals(group)) {
                i2 = 2;
            } else {
                String valueOf3 = String.valueOf(group);
                k.c("MediaCodecUtil", valueOf3.length() != 0 ? "Unknown HEVC profile string: ".concat(valueOf3) : new String("Unknown HEVC profile string: "));
                return null;
            }
        }
        String str2 = strArr[3];
        Integer num = f15819g.get(str2);
        if (num != null) {
            return new Pair<>(Integer.valueOf(i2), num);
        }
        String valueOf4 = String.valueOf(str2);
        k.c("MediaCodecUtil", valueOf4.length() != 0 ? "Unknown HEVC level string: ".concat(valueOf4) : new String("Unknown HEVC level string: "));
        return null;
    }

    public static synchronized List<a> b(String str, boolean z2, boolean z3) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            a aVar = new a(str, z2, z3);
            HashMap<a, List<a>> hashMap = f15814b;
            List<a> list = hashMap.get(aVar);
            if (list != null) {
                return list;
            }
            ArrayList<a> a2 = a(aVar, ad.f11755a >= 21 ? new d(z2, z3) : new c());
            if (z2 && a2.isEmpty() && 21 <= ad.f11755a && ad.f11755a <= 23) {
                a2 = a(aVar, (b) new c());
                if (!a2.isEmpty()) {
                    String str2 = a2.get(0).f15828a;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    k.c("MediaCodecUtil", sb.toString());
                }
            }
            a(str, (List<a>) a2);
            List<a> unmodifiableList = Collections.unmodifiableList(a2);
            hashMap.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    private static boolean b(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static Pair<Integer, Integer> c(String str, String[] strArr) {
        int i2;
        int i3;
        String sb;
        if (strArr.length < 2) {
            String valueOf = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i3 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i2 = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                int parseInt = Integer.parseInt(strArr[1]);
                i2 = Integer.parseInt(strArr[2]);
                i3 = parseInt;
            } else {
                String valueOf2 = String.valueOf(str);
                k.c("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf2) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            int i4 = f15815c.get(i3, -1);
            if (i4 == -1) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown AVC profile: ");
                sb2.append(i3);
                sb = sb2.toString();
            } else {
                int i5 = f15816d.get(i2, -1);
                if (i5 != -1) {
                    return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i5));
                }
                StringBuilder sb3 = new StringBuilder(30);
                sb3.append("Unknown AVC level: ");
                sb3.append(i2);
                sb = sb3.toString();
            }
            k.c("MediaCodecUtil", sb);
            return null;
        } catch (NumberFormatException unused) {
            String valueOf3 = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf3.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf3) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    private static boolean c(MediaCodecInfo mediaCodecInfo) {
        return ad.f11755a >= 29 ? d(mediaCodecInfo) : !e(mediaCodecInfo);
    }

    private static Pair<Integer, Integer> d(String str, String[] strArr) {
        String sb;
        if (strArr.length < 3) {
            String valueOf = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(valueOf) : new String("Ignoring malformed VP9 codec string: "));
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int i2 = f15817e.get(parseInt, -1);
            if (i2 == -1) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown VP9 profile: ");
                sb2.append(parseInt);
                sb = sb2.toString();
            } else {
                int i3 = f15818f.get(parseInt2, -1);
                if (i3 != -1) {
                    return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
                }
                StringBuilder sb3 = new StringBuilder(30);
                sb3.append("Unknown VP9 level: ");
                sb3.append(parseInt2);
                sb = sb3.toString();
            }
            k.c("MediaCodecUtil", sb);
            return null;
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(valueOf2) : new String("Ignoring malformed VP9 codec string: "));
            return null;
        }
    }

    private static boolean d(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static Pair<Integer, Integer> e(String str, String[] strArr) {
        int i2;
        if (strArr.length != 3) {
            String valueOf = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(valueOf) : new String("Ignoring malformed MP4A codec string: "));
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(n.a(Integer.parseInt(strArr[1], 16))) && (i2 = f15823k.get(Integer.parseInt(strArr[2]), -1)) != -1) {
                return new Pair<>(Integer.valueOf(i2), 0);
            }
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            k.c("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(valueOf2) : new String("Ignoring malformed MP4A codec string: "));
        }
        return null;
    }

    private static boolean e(MediaCodecInfo mediaCodecInfo) {
        if (ad.f11755a >= 29) {
            return f(mediaCodecInfo);
        }
        String d2 = ad.d(mediaCodecInfo.getName());
        if (d2.startsWith("arc.")) {
            return false;
        }
        return d2.startsWith("omx.google.") || d2.startsWith("omx.ffmpeg.") || (d2.startsWith("omx.sec.") && d2.contains(".sw.")) || d2.equals("omx.qcom.video.decoder.hevcswvdec") || d2.startsWith("c2.android.") || d2.startsWith("c2.google.") || (!d2.startsWith("omx.") && !d2.startsWith("c2."));
    }

    private static boolean f(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean g(MediaCodecInfo mediaCodecInfo) {
        if (ad.f11755a >= 29) {
            return h(mediaCodecInfo);
        }
        String d2 = ad.d(mediaCodecInfo.getName());
        return !d2.startsWith("omx.google.") && !d2.startsWith("c2.android.") && !d2.startsWith("c2.google.");
    }

    private static boolean h(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }
}
