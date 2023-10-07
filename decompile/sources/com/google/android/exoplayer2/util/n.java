package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.util.ArrayList;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<a> f17131a = new ArrayList<>();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f17132a;

        /* renamed from: b  reason: collision with root package name */
        public final String f17133b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17134c;
    }

    public static String a(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return "video/avc";
        }
        if (i2 == 35) {
            return "video/hevc";
        }
        if (i2 == 64) {
            return "audio/mp4a-latm";
        }
        if (i2 == 163) {
            return "video/wvc1";
        }
        if (i2 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i2 == 165) {
            return "audio/ac3";
        }
        if (i2 == 166) {
            return "audio/eac3";
        }
        switch (i2) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i2) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static boolean a(String str) {
        return "audio".equals(k(str));
    }

    public static boolean b(String str) {
        return "video".equals(k(str));
    }

    public static boolean c(String str) {
        return "text".equals(k(str));
    }

    public static boolean d(String str) {
        if (str == null) {
            return false;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c2 = 1;
                    break;
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c2 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 3;
                    break;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c2 = 10;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            default:
                return false;
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        for (String g2 : ad.g(str)) {
            String g3 = g(g2);
            if (g3 != null && b(g3)) {
                return g3;
            }
        }
        return null;
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        for (String g2 : ad.g(str)) {
            String g3 = g(g2);
            if (g3 != null && a(g3)) {
                return g3;
            }
        }
        return null;
    }

    public static String g(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String d2 = ad.d(str.trim());
        if (d2.startsWith("avc1") || d2.startsWith("avc3")) {
            return "video/avc";
        }
        if (d2.startsWith("hev1") || d2.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (d2.startsWith("dvav") || d2.startsWith("dva1") || d2.startsWith("dvhe") || d2.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (d2.startsWith("av01")) {
            return "video/av01";
        }
        if (d2.startsWith("vp9") || d2.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (d2.startsWith("vp8") || d2.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (!d2.startsWith("mp4a")) {
            return (d2.startsWith("ac-3") || d2.startsWith("dac3")) ? "audio/ac3" : (d2.startsWith("ec-3") || d2.startsWith("dec3")) ? "audio/eac3" : d2.startsWith("ec+3") ? "audio/eac3-joc" : (d2.startsWith("ac-4") || d2.startsWith("dac4")) ? "audio/ac4" : (d2.startsWith("dtsc") || d2.startsWith("dtse")) ? "audio/vnd.dts" : (d2.startsWith("dtsh") || d2.startsWith("dtsl")) ? "audio/vnd.dts.hd" : d2.startsWith("opus") ? "audio/opus" : d2.startsWith("vorbis") ? "audio/vorbis" : d2.startsWith("flac") ? "audio/flac" : d2.startsWith("stpp") ? "application/ttml+xml" : d2.startsWith("wvtt") ? "text/vtt" : l(d2);
        }
        if (d2.startsWith("mp4a.")) {
            String substring = d2.substring(5);
            if (substring.length() >= 2) {
                try {
                    str2 = a(Integer.parseInt(ad.e(substring.substring(0, 2)), 16));
                } catch (NumberFormatException unused) {
                }
            }
        }
        return str2 == null ? "audio/mp4a-latm" : str2;
    }

    public static int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (a(str)) {
            return 1;
        }
        if (b(str)) {
            return 2;
        }
        if (c(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 5;
        }
        return m(str);
    }

    public static int i(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c2 = 1;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 18;
            case 1:
                return 7;
            case 2:
                return 5;
            case 3:
                return 17;
            case 4:
                return 6;
            case 5:
                return 9;
            case 6:
                return 8;
            case 7:
                return 14;
            default:
                return 0;
        }
    }

    public static int j(String str) {
        return h(g(str));
    }

    private static String k(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    private static String l(String str) {
        int size = f17131a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = f17131a.get(i2);
            if (str.startsWith(aVar.f17133b)) {
                return aVar.f17132a;
            }
        }
        return null;
    }

    private static int m(String str) {
        int size = f17131a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = f17131a.get(i2);
            if (str.equals(aVar.f17132a)) {
                return aVar.f17134c;
            }
        }
        return -1;
    }
}
