package gd;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import gd.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final q f28431a = new q();

    /* renamed from: b  reason: collision with root package name */
    private final e.a f28432b = new e.a();

    public b() {
        super("Mp4WebvttDecoder");
    }

    private static com.google.android.exoplayer2.text.b a(q qVar, e.a aVar, int i2) throws SubtitleDecoderException {
        aVar.a();
        while (i2 > 0) {
            if (i2 >= 8) {
                int p2 = qVar.p();
                int p3 = qVar.p();
                int i3 = p2 - 8;
                String a2 = ad.a(qVar.f17159a, qVar.d(), i3);
                qVar.d(i3);
                i2 = (i2 - 8) - i3;
                if (p3 == 1937011815) {
                    f.a(a2, aVar);
                } else if (p3 == 1885436268) {
                    f.a((String) null, a2.trim(), aVar, (List<d>) Collections.emptyList());
                }
            } else {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
        }
        return aVar.b();
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.text.e a(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException {
        this.f28431a.a(bArr, i2);
        ArrayList arrayList = new ArrayList();
        while (this.f28431a.b() > 0) {
            if (this.f28431a.b() >= 8) {
                int p2 = this.f28431a.p();
                if (this.f28431a.p() == 1987343459) {
                    arrayList.add(a(this.f28431a, this.f28432b, p2 - 8));
                } else {
                    this.f28431a.d(p2 - 8);
                }
            } else {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new c(arrayList);
    }
}
