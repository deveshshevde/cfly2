package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import fw.c;
import fx.a;
import gd.b;

public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f16601a = new g() {
        public boolean a(Format format) {
            String str = format.f15092i;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        public f b(Format format) {
            String str = format.f15092i;
            if (str != null) {
                str.hashCode();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1248334819:
                        if (str.equals("application/pgs")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 822864842:
                        if (str.equals("text/x-ssa")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            c2 = 8;
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            c2 = 9;
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            c2 = 10;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return new a(format.f15094k);
                    case 1:
                        return new fy.a();
                    case 2:
                        return new b();
                    case 3:
                        return new gd.g();
                    case 4:
                        return new gc.a(format.f15094k);
                    case 5:
                        return new fz.a(format.f15094k);
                    case 6:
                    case 7:
                        return new fw.a(str, format.B);
                    case 8:
                        return new c(format.B, format.f15094k);
                    case 9:
                        return new ga.a();
                    case 10:
                        return new gb.a();
                }
            }
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    };

    boolean a(Format format);

    f b(Format format);
}
