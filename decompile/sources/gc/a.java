package gc;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import java.nio.charset.Charset;
import java.util.List;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final q f28419a = new q();

    /* renamed from: b  reason: collision with root package name */
    private boolean f28420b;

    /* renamed from: c  reason: collision with root package name */
    private int f28421c;

    /* renamed from: d  reason: collision with root package name */
    private int f28422d;

    /* renamed from: e  reason: collision with root package name */
    private String f28423e;

    /* renamed from: f  reason: collision with root package name */
    private float f28424f;

    /* renamed from: g  reason: collision with root package name */
    private int f28425g;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        String str = "sans-serif";
        boolean z2 = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f28421c = bArr[24];
            this.f28422d = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f28423e = "Serif".equals(ad.a(bArr, 43, bArr.length - 43)) ? "serif" : str;
            int i2 = bArr[25] * 20;
            this.f28425g = i2;
            z2 = (bArr[0] & 32) != 0 ? true : z2;
            this.f28420b = z2;
            if (z2) {
                float f2 = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i2);
                this.f28424f = f2;
                this.f28424f = ad.a(f2, 0.0f, 0.95f);
                return;
            }
        } else {
            this.f28421c = 0;
            this.f28422d = -1;
            this.f28423e = str;
            this.f28420b = false;
        }
        this.f28424f = 0.85f;
    }

    private static String a(q qVar) throws SubtitleDecoderException {
        char g2;
        a(qVar.b() >= 2);
        int i2 = qVar.i();
        if (i2 == 0) {
            return "";
        }
        return qVar.a(i2, Charset.forName((qVar.b() < 2 || !((g2 = qVar.g()) == 65279 || g2 == 65534)) ? "UTF-8" : "UTF-16"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.text.SpannableStringBuilder r5, int r6, int r7, int r8, int r9, int r10) {
        /*
            if (r6 == r7) goto L_0x004c
            r7 = r10 | 33
            r10 = r6 & 1
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L_0x000c
            r10 = 1
            goto L_0x000d
        L_0x000c:
            r10 = 0
        L_0x000d:
            r2 = r6 & 2
            if (r2 == 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            if (r10 == 0) goto L_0x0023
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            if (r2 == 0) goto L_0x001f
            r4 = 3
            r3.<init>(r4)
            goto L_0x002b
        L_0x001f:
            r3.<init>(r1)
            goto L_0x002b
        L_0x0023:
            if (r2 == 0) goto L_0x002e
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r4 = 2
            r3.<init>(r4)
        L_0x002b:
            r5.setSpan(r3, r8, r9, r7)
        L_0x002e:
            r6 = r6 & 4
            if (r6 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            if (r1 == 0) goto L_0x003e
            android.text.style.UnderlineSpan r6 = new android.text.style.UnderlineSpan
            r6.<init>()
            r5.setSpan(r6, r8, r9, r7)
        L_0x003e:
            if (r1 != 0) goto L_0x004c
            if (r10 != 0) goto L_0x004c
            if (r2 != 0) goto L_0x004c
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r6.<init>(r0)
            r5.setSpan(r6, r8, r9, r7)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gc.a.a(android.text.SpannableStringBuilder, int, int, int, int, int):void");
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i2, int i3, int i4) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i2, i3, i4 | 33);
        }
    }

    private void a(q qVar, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        a(qVar.b() >= 12);
        int i2 = qVar.i();
        int i3 = qVar.i();
        qVar.d(2);
        int h2 = qVar.h();
        qVar.d(1);
        int p2 = qVar.p();
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i4 = i2;
        int i5 = i3;
        a(spannableStringBuilder2, h2, this.f28421c, i4, i5, 0);
        b(spannableStringBuilder2, p2, this.f28422d, i4, i5, 0);
    }

    private static void a(boolean z2) throws SubtitleDecoderException {
        if (!z2) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
        }
    }

    /* access modifiers changed from: protected */
    public e a(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException {
        this.f28419a.a(bArr, i2);
        String a2 = a(this.f28419a);
        if (a2.isEmpty()) {
            return b.f28426a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        a(spannableStringBuilder2, this.f28421c, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder2, this.f28422d, -1, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder2, this.f28423e, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float f2 = this.f28424f;
        while (this.f28419a.b() >= 8) {
            int d2 = this.f28419a.d();
            int p2 = this.f28419a.p();
            int p3 = this.f28419a.p();
            boolean z3 = true;
            if (p3 == 1937013100) {
                if (this.f28419a.b() < 2) {
                    z3 = false;
                }
                a(z3);
                int i3 = this.f28419a.i();
                for (int i4 = 0; i4 < i3; i4++) {
                    a(this.f28419a, spannableStringBuilder);
                }
            } else if (p3 == 1952608120 && this.f28420b) {
                if (this.f28419a.b() < 2) {
                    z3 = false;
                }
                a(z3);
                f2 = ad.a(((float) this.f28419a.i()) / ((float) this.f28425g), 0.0f, 0.95f);
            }
            this.f28419a.c(d2 + p2);
        }
        return new b(new b(spannableStringBuilder, (Layout.Alignment) null, f2, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f));
    }
}
