package com.google.android.exoplayer2.ui;

public interface c {

    public interface a {
        void a(c cVar, long j2);

        void a(c cVar, long j2, boolean z2);

        void b(c cVar, long j2);
    }

    void a(a aVar);

    void a(long[] jArr, boolean[] zArr, int i2);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j2);

    void setDuration(long j2);

    void setEnabled(boolean z2);

    void setPosition(long j2);
}
