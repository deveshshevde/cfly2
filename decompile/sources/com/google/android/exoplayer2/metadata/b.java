package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.icy.a;

public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f15842a = new b() {
        public boolean a(Format format) {
            String str = format.f15092i;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str);
        }

        public a b(Format format) {
            String str = format.f15092i;
            if (str != null) {
                str.hashCode();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1348231605:
                        if (str.equals("application/x-icy")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1248341703:
                        if (str.equals("application/id3")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1154383568:
                        if (str.equals("application/x-emsg")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1652648887:
                        if (str.equals("application/x-scte35")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return new a();
                    case 1:
                        return new com.google.android.exoplayer2.metadata.id3.a();
                    case 2:
                        return new com.google.android.exoplayer2.metadata.emsg.a();
                    case 3:
                        return new com.google.android.exoplayer2.metadata.scte35.a();
                }
            }
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    };

    boolean a(Format format);

    a b(Format format);
}
