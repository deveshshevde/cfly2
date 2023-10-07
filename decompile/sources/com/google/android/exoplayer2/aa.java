package com.google.android.exoplayer2;

public interface aa {

    /* renamed from: com.google.android.exoplayer2.aa$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int a(int i2, int i3, int i4) {
            return i2 | i3 | i4;
        }

        public static int b(int i2) {
            return a(i2, 0, 0);
        }

        public static int c(int i2) {
            return i2 & 7;
        }

        public static int d(int i2) {
            return i2 & 24;
        }

        public static int e(int i2) {
            return i2 & 32;
        }

        public static String f(int i2) {
            if (i2 == 0) {
                return "NO";
            }
            if (i2 == 1) {
                return "NO_UNSUPPORTED_TYPE";
            }
            if (i2 == 2) {
                return "NO_UNSUPPORTED_DRM";
            }
            if (i2 == 3) {
                return "NO_EXCEEDS_CAPABILITIES";
            }
            if (i2 == 4) {
                return "YES";
            }
            throw new IllegalStateException();
        }
    }

    int a();

    int a(Format format) throws ExoPlaybackException;

    int o() throws ExoPlaybackException;
}
