package fn;

import fj.s;

interface d extends s {

    public static class a extends s.b implements d {
        public a() {
            super(-9223372036854775807L);
        }

        public long c() {
            return -1;
        }

        public long c(long j2) {
            return 0;
        }
    }

    long c();

    long c(long j2);
}
