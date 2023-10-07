package gd;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.q;
import gd.e;
import java.util.ArrayList;
import java.util.List;

public final class g extends c {

    /* renamed from: a  reason: collision with root package name */
    private final f f28456a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final q f28457b = new q();

    /* renamed from: c  reason: collision with root package name */
    private final e.a f28458c = new e.a();

    /* renamed from: d  reason: collision with root package name */
    private final a f28459d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final List<d> f28460e = new ArrayList();

    public g() {
        super("WebvttDecoder");
    }

    private static int a(q qVar) {
        int i2 = -1;
        int i3 = 0;
        while (i2 == -1) {
            i3 = qVar.d();
            String B = qVar.B();
            i2 = B == null ? 0 : "STYLE".equals(B) ? 2 : B.startsWith("NOTE") ? 1 : 3;
        }
        qVar.c(i3);
        return i2;
    }

    private static void b(q qVar) {
        do {
        } while (!TextUtils.isEmpty(qVar.B()));
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.text.e a(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException {
        this.f28457b.a(bArr, i2);
        this.f28458c.a();
        this.f28460e.clear();
        try {
            h.a(this.f28457b);
            do {
            } while (!TextUtils.isEmpty(this.f28457b.B()));
            ArrayList arrayList = new ArrayList();
            while (true) {
                int a2 = a(this.f28457b);
                if (a2 == 0) {
                    return new i(arrayList);
                }
                if (a2 == 1) {
                    b(this.f28457b);
                } else if (a2 == 2) {
                    if (arrayList.isEmpty()) {
                        this.f28457b.B();
                        this.f28460e.addAll(this.f28459d.a(this.f28457b));
                    } else {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                } else if (a2 == 3 && this.f28456a.a(this.f28457b, this.f28458c, this.f28460e)) {
                    arrayList.add(this.f28458c.b());
                    this.f28458c.a();
                }
            }
        } catch (ParserException e2) {
            throw new SubtitleDecoderException((Exception) e2);
        }
    }
}
