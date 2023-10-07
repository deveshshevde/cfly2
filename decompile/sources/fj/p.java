package fj;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.util.q;
import java.io.EOFException;
import java.io.IOException;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final q f27386a = new q(10);

    public Metadata a(h hVar, a.C0112a aVar) throws IOException, InterruptedException {
        Metadata metadata = null;
        int i2 = 0;
        while (true) {
            try {
                hVar.d(this.f27386a.f17159a, 0, 10);
                this.f27386a.c(0);
                if (this.f27386a.l() != 4801587) {
                    break;
                }
                this.f27386a.d(3);
                int u2 = this.f27386a.u();
                int i3 = u2 + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.f27386a.f17159a, 0, bArr, 0, 10);
                    hVar.d(bArr, 10, u2);
                    metadata = new a(aVar).a(bArr, i3);
                } else {
                    hVar.c(u2);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        hVar.a();
        hVar.c(i2);
        return metadata;
    }
}
