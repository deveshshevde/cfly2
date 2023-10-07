package fj;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.q;
import fj.u;
import java.io.EOFException;
import java.io.IOException;

public final class f implements u {
    public int a(h hVar, int i2, boolean z2) throws IOException, InterruptedException {
        int a2 = hVar.a(i2);
        if (a2 != -1) {
            return a2;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    public void a(long j2, int i2, int i3, int i4, u.a aVar) {
    }

    public void a(Format format) {
    }

    public void a(q qVar, int i2) {
        qVar.d(i2);
    }
}
