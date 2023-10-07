package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.n;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f15828a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15829b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15830c;

    /* renamed from: d  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f15831d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15832e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f15833f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f15834g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f15835h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f15836i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f15837j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f15838k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f15839l;

    private a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f15828a = (String) com.google.android.exoplayer2.util.a.b(str);
        this.f15829b = str2;
        this.f15830c = str3;
        this.f15831d = codecCapabilities;
        this.f15835h = z2;
        this.f15836i = z3;
        this.f15837j = z4;
        this.f15838k = z5;
        boolean z8 = true;
        this.f15832e = !z6 && codecCapabilities != null && a(codecCapabilities);
        this.f15833f = codecCapabilities != null && c(codecCapabilities);
        if (!z7 && (codecCapabilities == null || !e(codecCapabilities))) {
            z8 = false;
        }
        this.f15834g = z8;
        this.f15839l = n.b(str2);
    }

    private static int a(String str, String str2, int i2) {
        if (i2 > 1 || ((ad.f11755a >= 26 && i2 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i2;
        }
        int i3 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("AssumedMaxChannelAdjustment: ");
        sb.append(str);
        sb.append(", [");
        sb.append(i2);
        sb.append(" to ");
        sb.append(i3);
        sb.append("]");
        k.c("MediaCodecInfo", sb.toString());
        return i3;
    }

    private static Point a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(ad.a(i2, widthAlignment) * widthAlignment, ad.a(i3, heightAlignment) * heightAlignment);
    }

    public static a a(String str) {
        return new a(str, (String) null, (String) null, (MediaCodecInfo.CodecCapabilities) null, true, false, true, false, false, false);
    }

    public static a a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return new a(str, str2, str3, codecCapabilities, false, z2, z3, z4, z5, z6);
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return ad.f11755a >= 19 && b(codecCapabilities);
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        Point a2 = a(videoCapabilities, i2, i3);
        int i4 = a2.x;
        int i5 = a2.y;
        return (d2 == -1.0d || d2 < 1.0d) ? videoCapabilities.isSizeSupported(i4, i5) : videoCapabilities.areSizeAndRateSupported(i4, i5, Math.floor(d2));
    }

    private void b(String str) {
        String str2 = this.f15828a;
        String str3 = this.f15829b;
        String str4 = ad.f11759e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        k.a("MediaCodecInfo", sb.toString());
    }

    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private void c(String str) {
        String str2 = this.f15828a;
        String str3 = this.f15829b;
        String str4 = ad.f11759e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("AssumedSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        k.a("MediaCodecInfo", sb.toString());
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return ad.f11755a >= 21 && d(codecCapabilities);
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static final boolean d(String str) {
        return !"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(ad.f11756b);
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return ad.f11755a >= 21 && f(codecCapabilities);
    }

    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public Point a(int i2, int i3) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f15831d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return a(videoCapabilities, i2, i3);
    }

    public boolean a(int i2) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f15831d;
        if (codecCapabilities == null) {
            sb = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                sb = "sampleRate.aCaps";
            } else if (audioCapabilities.isSampleRateSupported(i2)) {
                return true;
            } else {
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("sampleRate.support, ");
                sb2.append(i2);
                sb = sb2.toString();
            }
        }
        b(sb);
        return false;
    }

    public boolean a(int i2, int i3, double d2) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f15831d;
        if (codecCapabilities == null) {
            sb = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                sb = "sizeAndRate.vCaps";
            } else if (a(videoCapabilities, i2, i3, d2)) {
                return true;
            } else {
                if (i2 >= i3 || !d(this.f15828a) || !a(videoCapabilities, i3, i2, d2)) {
                    StringBuilder sb2 = new StringBuilder(69);
                    sb2.append("sizeAndRate.support, ");
                    sb2.append(i2);
                    sb2.append("x");
                    sb2.append(i3);
                    sb2.append("x");
                    sb2.append(d2);
                    sb = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder(69);
                    sb3.append("sizeAndRate.rotated, ");
                    sb3.append(i2);
                    sb3.append("x");
                    sb3.append(i3);
                    sb3.append("x");
                    sb3.append(d2);
                    c(sb3.toString());
                    return true;
                }
            }
        }
        b(sb);
        return false;
    }

    public boolean a(Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z2 = false;
        if (!b(format)) {
            return false;
        }
        if (!this.f15839l) {
            if (ad.f11755a >= 21) {
                if (format.f15106w == -1 || a(format.f15106w)) {
                    return format.f15105v == -1 || b(format.f15105v);
                }
                return false;
            }
        } else if (format.f15097n <= 0 || format.f15098o <= 0) {
            return true;
        } else {
            if (ad.f11755a >= 21) {
                return a(format.f15097n, format.f15098o, (double) format.f15099p);
            }
            if (format.f15097n * format.f15098o <= MediaCodecUtil.b()) {
                z2 = true;
            }
            if (!z2) {
                int i2 = format.f15097n;
                int i3 = format.f15098o;
                StringBuilder sb = new StringBuilder(40);
                sb.append("legacyFrameSize, ");
                sb.append(i2);
                sb.append("x");
                sb.append(i3);
                b(sb.toString());
            }
            return z2;
        }
    }

    public boolean a(Format format, Format format2, boolean z2) {
        if (this.f15839l) {
            return format.f15092i.equals(format2.f15092i) && format.f15100q == format2.f15100q && (this.f15832e || (format.f15097n == format2.f15097n && format.f15098o == format2.f15098o)) && ((!z2 && format2.f15104u == null) || ad.a((Object) format.f15104u, (Object) format2.f15104u));
        }
        if ("audio/mp4a-latm".equals(this.f15829b) && format.f15092i.equals(format2.f15092i) && format.f15105v == format2.f15105v && format.f15106w == format2.f15106w) {
            Pair<Integer, Integer> a2 = MediaCodecUtil.a(format);
            Pair<Integer, Integer> a3 = MediaCodecUtil.a(format2);
            if (!(a2 == null || a3 == null)) {
                return ((Integer) a2.first).intValue() == 42 && ((Integer) a3.first).intValue() == 42;
            }
        }
        return false;
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f15831d;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.f15831d.profileLevels;
    }

    public boolean b() {
        if (ad.f11755a >= 29 && "video/x-vnd.on2.vp9".equals(this.f15829b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b(int i2) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f15831d;
        if (codecCapabilities == null) {
            sb = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                sb = "channelCount.aCaps";
            } else if (a(this.f15828a, this.f15829b, audioCapabilities.getMaxInputChannelCount()) >= i2) {
                return true;
            } else {
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("channelCount.support, ");
                sb2.append(i2);
                sb = sb2.toString();
            }
        }
        b(sb);
        return false;
    }

    public boolean b(Format format) {
        String g2;
        String str;
        StringBuilder sb;
        String str2;
        if (format.f15089f == null || this.f15829b == null || (g2 = n.g(format.f15089f)) == null) {
            return true;
        }
        if (!this.f15829b.equals(g2)) {
            str = format.f15089f;
            sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(g2).length());
            str2 = "codec.mime ";
        } else {
            Pair<Integer, Integer> a2 = MediaCodecUtil.a(format);
            if (a2 == null) {
                return true;
            }
            int intValue = ((Integer) a2.first).intValue();
            int intValue2 = ((Integer) a2.second).intValue();
            if (!this.f15839l && intValue != 42) {
                return true;
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
                if (codecProfileLevel.profile == intValue && codecProfileLevel.level >= intValue2) {
                    return true;
                }
            }
            str = format.f15089f;
            sb = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(g2).length());
            str2 = "codec.profileLevel, ";
        }
        sb.append(str2);
        sb.append(str);
        sb.append(", ");
        sb.append(g2);
        b(sb.toString());
        return false;
    }

    public boolean c(Format format) {
        if (this.f15839l) {
            return this.f15832e;
        }
        Pair<Integer, Integer> a2 = MediaCodecUtil.a(format);
        return a2 != null && ((Integer) a2.first).intValue() == 42;
    }

    public String toString() {
        return this.f15828a;
    }
}
