package fx;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.q;
import java.util.List;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final b f28251a;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        q qVar = new q(list.get(0));
        this.f28251a = new b(qVar.i(), qVar.i());
    }

    /* access modifiers changed from: protected */
    public e a(byte[] bArr, int i2, boolean z2) {
        if (z2) {
            this.f28251a.a();
        }
        return new c(this.f28251a.a(bArr, i2));
    }
}
