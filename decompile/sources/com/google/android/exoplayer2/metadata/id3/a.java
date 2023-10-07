package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class a implements com.google.android.exoplayer2.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0112a f15925a = $$Lambda$a$BoRSc8ryhYVTmLVXoM1YBDgL3Vs.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final C0112a f15926b;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.a$a  reason: collision with other inner class name */
    public interface C0112a {
        boolean evaluate(int i2, int i3, int i4, int i5, int i6);
    }

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f15927a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f15928b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f15929c;

        public b(int i2, boolean z2, int i3) {
            this.f15927a = i2;
            this.f15928b = z2;
            this.f15929c = i3;
        }
    }

    public a() {
        this((C0112a) null);
    }

    public a(C0112a aVar) {
        this.f15926b = aVar;
    }

    private static int a(byte[] bArr, int i2, int i3) {
        int b2 = b(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return b2;
        }
        while (b2 < bArr.length - 1) {
            if (b2 % 2 == 0 && bArr[b2 + 1] == 0) {
                return b2;
            }
            b2 = b(bArr, b2 + 1);
        }
        return bArr.length;
    }

    private static ApicFrame a(q qVar, int i2, int i3) throws UnsupportedEncodingException {
        int i4;
        String str;
        int h2 = qVar.h();
        String a2 = a(h2);
        int i5 = i2 - 1;
        byte[] bArr = new byte[i5];
        qVar.a(bArr, 0, i5);
        if (i3 == 2) {
            String valueOf = String.valueOf(ad.d(new String(bArr, 0, 3, "ISO-8859-1")));
            str = valueOf.length() != 0 ? "image/".concat(valueOf) : new String("image/");
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            i4 = 2;
        } else {
            i4 = b(bArr, 0);
            String d2 = ad.d(new String(bArr, 0, i4, "ISO-8859-1"));
            if (d2.indexOf(47) == -1) {
                String valueOf2 = String.valueOf(d2);
                if (valueOf2.length() != 0) {
                    str = "image/".concat(valueOf2);
                } else {
                    d2 = new String("image/");
                }
            }
            str = d2;
        }
        int i6 = i4 + 2;
        int a3 = a(bArr, i6, h2);
        return new ApicFrame(str, new String(bArr, i6, a3 - i6, a2), bArr[i4 + 1] & 255, b(bArr, a3 + b(h2), i5));
    }

    private static ChapterFrame a(q qVar, int i2, int i3, boolean z2, int i4, C0112a aVar) throws UnsupportedEncodingException {
        q qVar2 = qVar;
        int d2 = qVar.d();
        int b2 = b(qVar2.f17159a, d2);
        String str = new String(qVar2.f17159a, d2, b2 - d2, "ISO-8859-1");
        qVar.c(b2 + 1);
        int p2 = qVar.p();
        int p3 = qVar.p();
        long n2 = qVar.n();
        long j2 = n2 == 4294967295L ? -1 : n2;
        long n3 = qVar.n();
        long j3 = n3 == 4294967295L ? -1 : n3;
        ArrayList arrayList = new ArrayList();
        int i5 = d2 + i2;
        while (qVar.d() < i5) {
            Id3Frame a2 = a(i3, qVar, z2, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, p2, p3, j2, j3, id3FrameArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0190, code lost:
        if (r13 == 67) goto L_0x0192;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame a(int r19, com.google.android.exoplayer2.util.q r20, boolean r21, int r22, com.google.android.exoplayer2.metadata.id3.a.C0112a r23) {
        /*
            r0 = r19
            r7 = r20
            int r8 = r20.h()
            int r9 = r20.h()
            int r10 = r20.h()
            r11 = 3
            if (r0 < r11) goto L_0x0019
            int r1 = r20.h()
            r13 = r1
            goto L_0x001a
        L_0x0019:
            r13 = 0
        L_0x001a:
            r14 = 4
            if (r0 != r14) goto L_0x003c
            int r1 = r20.v()
            if (r21 != 0) goto L_0x003a
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 7
            r2 = r2 | r3
            int r3 = r1 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 14
            r2 = r2 | r3
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 21
            r1 = r1 | r2
        L_0x003a:
            r15 = r1
            goto L_0x0048
        L_0x003c:
            if (r0 != r11) goto L_0x0043
            int r1 = r20.v()
            goto L_0x003a
        L_0x0043:
            int r1 = r20.l()
            goto L_0x003a
        L_0x0048:
            if (r0 < r11) goto L_0x0050
            int r1 = r20.i()
            r6 = r1
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            r16 = 0
            if (r8 != 0) goto L_0x0067
            if (r9 != 0) goto L_0x0067
            if (r10 != 0) goto L_0x0067
            if (r13 != 0) goto L_0x0067
            if (r15 != 0) goto L_0x0067
            if (r6 != 0) goto L_0x0067
            int r0 = r20.c()
            r7.c(r0)
            return r16
        L_0x0067:
            int r1 = r20.d()
            int r5 = r1 + r15
            int r1 = r20.c()
            java.lang.String r4 = "Id3Decoder"
            if (r5 <= r1) goto L_0x0082
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            com.google.android.exoplayer2.util.k.c(r4, r0)
            int r0 = r20.c()
            r7.c(r0)
            return r16
        L_0x0082:
            if (r23 == 0) goto L_0x009a
            r1 = r23
            r2 = r19
            r3 = r8
            r12 = r4
            r4 = r9
            r14 = r5
            r5 = r10
            r18 = r6
            r6 = r13
            boolean r1 = r1.evaluate(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x009e
            r7.c(r14)
            return r16
        L_0x009a:
            r12 = r4
            r14 = r5
            r18 = r6
        L_0x009e:
            r1 = 1
            if (r0 != r11) goto L_0x00bc
            r2 = r18
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00a9
            r3 = 1
            goto L_0x00aa
        L_0x00a9:
            r3 = 0
        L_0x00aa:
            r4 = r2 & 64
            if (r4 == 0) goto L_0x00b0
            r4 = 1
            goto L_0x00b1
        L_0x00b0:
            r4 = 0
        L_0x00b1:
            r2 = r2 & 32
            if (r2 == 0) goto L_0x00b7
            r2 = 1
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            r17 = r3
            r6 = 0
            goto L_0x00f2
        L_0x00bc:
            r2 = r18
            r3 = 4
            if (r0 != r3) goto L_0x00ec
            r3 = r2 & 64
            if (r3 == 0) goto L_0x00c7
            r3 = 1
            goto L_0x00c8
        L_0x00c7:
            r3 = 0
        L_0x00c8:
            r4 = r2 & 8
            if (r4 == 0) goto L_0x00ce
            r4 = 1
            goto L_0x00cf
        L_0x00ce:
            r4 = 0
        L_0x00cf:
            r5 = r2 & 4
            if (r5 == 0) goto L_0x00d5
            r5 = 1
            goto L_0x00d6
        L_0x00d5:
            r5 = 0
        L_0x00d6:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x00dc
            r6 = 1
            goto L_0x00dd
        L_0x00dc:
            r6 = 0
        L_0x00dd:
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00e3
            r17 = 1
            goto L_0x00e5
        L_0x00e3:
            r17 = 0
        L_0x00e5:
            r2 = r3
            r3 = r17
            r17 = r4
            r4 = r5
            goto L_0x00f2
        L_0x00ec:
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r17 = 0
        L_0x00f2:
            if (r17 != 0) goto L_0x022f
            if (r4 == 0) goto L_0x00f8
            goto L_0x022f
        L_0x00f8:
            if (r2 == 0) goto L_0x00ff
            int r15 = r15 + -1
            r7.d(r1)
        L_0x00ff:
            if (r3 == 0) goto L_0x0107
            int r15 = r15 + -4
            r1 = 4
            r7.d(r1)
        L_0x0107:
            if (r6 == 0) goto L_0x010d
            int r15 = g(r7, r15)
        L_0x010d:
            r1 = 84
            r2 = 2
            r3 = 88
            if (r8 != r1) goto L_0x0122
            if (r9 != r3) goto L_0x0122
            if (r10 != r3) goto L_0x0122
            if (r0 == r2) goto L_0x011c
            if (r13 != r3) goto L_0x0122
        L_0x011c:
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = a((com.google.android.exoplayer2.util.q) r7, (int) r15)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x0122:
            if (r8 != r1) goto L_0x0131
            java.lang.String r1 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = a((com.google.android.exoplayer2.util.q) r7, (int) r15, (java.lang.String) r1)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x012e:
            r0 = move-exception
            goto L_0x022b
        L_0x0131:
            r4 = 87
            if (r8 != r4) goto L_0x0143
            if (r9 != r3) goto L_0x0143
            if (r10 != r3) goto L_0x0143
            if (r0 == r2) goto L_0x013d
            if (r13 != r3) goto L_0x0143
        L_0x013d:
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r1 = b((com.google.android.exoplayer2.util.q) r7, (int) r15)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x0143:
            if (r8 != r4) goto L_0x014f
            java.lang.String r1 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r1 = b((com.google.android.exoplayer2.util.q) r7, (int) r15, (java.lang.String) r1)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x014f:
            r3 = 73
            r4 = 80
            if (r8 != r4) goto L_0x0165
            r5 = 82
            if (r9 != r5) goto L_0x0165
            if (r10 != r3) goto L_0x0165
            r5 = 86
            if (r13 != r5) goto L_0x0165
            com.google.android.exoplayer2.metadata.id3.PrivFrame r1 = c(r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x0165:
            r5 = 71
            r6 = 79
            if (r8 != r5) goto L_0x017d
            r5 = 69
            if (r9 != r5) goto L_0x017d
            if (r10 != r6) goto L_0x017d
            r5 = 66
            if (r13 == r5) goto L_0x0177
            if (r0 != r2) goto L_0x017d
        L_0x0177:
            com.google.android.exoplayer2.metadata.id3.GeobFrame r1 = d(r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x017d:
            r5 = 65
            r11 = 67
            if (r0 != r2) goto L_0x018a
            if (r8 != r4) goto L_0x0198
            if (r9 != r3) goto L_0x0198
            if (r10 != r11) goto L_0x0198
            goto L_0x0192
        L_0x018a:
            if (r8 != r5) goto L_0x0198
            if (r9 != r4) goto L_0x0198
            if (r10 != r3) goto L_0x0198
            if (r13 != r11) goto L_0x0198
        L_0x0192:
            com.google.android.exoplayer2.metadata.id3.ApicFrame r1 = a((com.google.android.exoplayer2.util.q) r7, (int) r15, (int) r0)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x0198:
            r3 = 77
            if (r8 != r11) goto L_0x01a9
            if (r9 != r6) goto L_0x01a9
            if (r10 != r3) goto L_0x01a9
            if (r13 == r3) goto L_0x01a4
            if (r0 != r2) goto L_0x01a9
        L_0x01a4:
            com.google.android.exoplayer2.metadata.id3.CommentFrame r1 = e(r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x01a9:
            if (r8 != r11) goto L_0x01c3
            r2 = 72
            if (r9 != r2) goto L_0x01c3
            if (r10 != r5) goto L_0x01c3
            if (r13 != r4) goto L_0x01c3
            r1 = r20
            r2 = r15
            r3 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            com.google.android.exoplayer2.metadata.id3.ChapterFrame r1 = a(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x01c3:
            if (r8 != r11) goto L_0x01db
            if (r9 != r1) goto L_0x01db
            if (r10 != r6) goto L_0x01db
            if (r13 != r11) goto L_0x01db
            r1 = r20
            r2 = r15
            r3 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            com.google.android.exoplayer2.metadata.id3.ChapterTocFrame r1 = b(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x01db:
            if (r8 != r3) goto L_0x01ea
            r2 = 76
            if (r9 != r2) goto L_0x01ea
            if (r10 != r2) goto L_0x01ea
            if (r13 != r1) goto L_0x01ea
            com.google.android.exoplayer2.metadata.id3.MlltFrame r1 = f(r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            goto L_0x01f2
        L_0x01ea:
            java.lang.String r1 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            com.google.android.exoplayer2.metadata.id3.BinaryFrame r1 = c(r7, r15, r1)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
        L_0x01f2:
            if (r1 != 0) goto L_0x021e
            java.lang.String r0 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            int r2 = r2.length()     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            int r2 = r2 + 50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            r3.<init>(r2)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            java.lang.String r2 = "Failed to decode frame: id="
            r3.append(r2)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            r3.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            java.lang.String r0 = ", frameSize="
            r3.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            r3.append(r15)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            java.lang.String r0 = r3.toString()     // Catch:{ UnsupportedEncodingException -> 0x0222 }
            com.google.android.exoplayer2.util.k.c(r12, r0)     // Catch:{ UnsupportedEncodingException -> 0x0222 }
        L_0x021e:
            r7.c(r14)
            return r1
        L_0x0222:
            java.lang.String r0 = "Unsupported character encoding"
            com.google.android.exoplayer2.util.k.c(r12, r0)     // Catch:{ all -> 0x012e }
            r7.c(r14)
            return r16
        L_0x022b:
            r7.c(r14)
            throw r0
        L_0x022f:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            com.google.android.exoplayer2.util.k.c(r12, r0)
            r7.c(r14)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.a.a(int, com.google.android.exoplayer2.util.q, boolean, int, com.google.android.exoplayer2.metadata.id3.a$a):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static TextInformationFrame a(q qVar, int i2) throws UnsupportedEncodingException {
        if (i2 < 1) {
            return null;
        }
        int h2 = qVar.h();
        String a2 = a(h2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        qVar.a(bArr, 0, i3);
        int a3 = a(bArr, 0, h2);
        String str = new String(bArr, 0, a3, a2);
        int b2 = a3 + b(h2);
        return new TextInformationFrame("TXXX", str, a(bArr, b2, a(bArr, b2, h2), a2));
    }

    private static TextInformationFrame a(q qVar, int i2, String str) throws UnsupportedEncodingException {
        if (i2 < 1) {
            return null;
        }
        int h2 = qVar.h();
        String a2 = a(h2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        qVar.a(bArr, 0, i3);
        return new TextInformationFrame(str, (String) null, new String(bArr, 0, a(bArr, 0, h2), a2));
    }

    private static b a(q qVar) {
        String sb;
        if (qVar.b() < 10) {
            sb = "Data too short to be an ID3 tag";
        } else {
            int l2 = qVar.l();
            boolean z2 = false;
            if (l2 != 4801587) {
                String valueOf = String.valueOf(String.format("%06X", new Object[]{Integer.valueOf(l2)}));
                k.c("Id3Decoder", valueOf.length() != 0 ? "Unexpected first three bytes of ID3 tag header: 0x".concat(valueOf) : new String("Unexpected first three bytes of ID3 tag header: 0x"));
                return null;
            }
            int h2 = qVar.h();
            qVar.d(1);
            int h3 = qVar.h();
            int u2 = qVar.u();
            if (h2 == 2) {
                if ((h3 & 64) != 0) {
                    sb = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme";
                }
            } else if (h2 == 3) {
                if ((h3 & 64) != 0) {
                    int p2 = qVar.p();
                    qVar.d(p2);
                    u2 -= p2 + 4;
                }
            } else if (h2 == 4) {
                if ((h3 & 64) != 0) {
                    int u3 = qVar.u();
                    qVar.d(u3 - 4);
                    u2 -= u3;
                }
                if ((h3 & 16) != 0) {
                    u2 -= 10;
                }
            } else {
                StringBuilder sb2 = new StringBuilder(57);
                sb2.append("Skipped ID3 tag with unsupported majorVersion=");
                sb2.append(h2);
                sb = sb2.toString();
            }
            if (h2 < 4 && (h3 & 128) != 0) {
                z2 = true;
            }
            return new b(h2, z2, u2);
        }
        k.c("Id3Decoder", sb);
        return null;
    }

    private static String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    private static String a(int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    private static String a(byte[] bArr, int i2, int i3, String str) throws UnsupportedEncodingException {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        if ((r10 & 128) != 0) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.google.android.exoplayer2.util.q r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.d()
        L_0x0008:
            int r3 = r18.b()     // Catch:{ all -> 0x00af }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00ab
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r18.p()     // Catch:{ all -> 0x00af }
            long r8 = r18.n()     // Catch:{ all -> 0x00af }
            int r10 = r18.i()     // Catch:{ all -> 0x00af }
            goto L_0x002c
        L_0x0022:
            int r7 = r18.l()     // Catch:{ all -> 0x00af }
            int r8 = r18.l()     // Catch:{ all -> 0x00af }
            long r8 = (long) r8
            r10 = 0
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003a
            if (r10 != 0) goto L_0x003a
            r1.c(r2)
            return r4
        L_0x003a:
            r7 = 4
            if (r0 != r7) goto L_0x006b
            if (r21 != 0) goto L_0x006b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004b
            r1.c(r2)
            return r6
        L_0x004b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006b:
            if (r0 != r7) goto L_0x007b
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0073
            r3 = 1
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0079:
            r4 = 0
            goto L_0x008b
        L_0x007b:
            if (r0 != r3) goto L_0x0089
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0083
            r3 = 1
            goto L_0x0084
        L_0x0083:
            r3 = 0
        L_0x0084:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0089:
            r3 = 0
            goto L_0x0079
        L_0x008b:
            if (r4 == 0) goto L_0x008f
            int r3 = r3 + 4
        L_0x008f:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0098
            r1.c(r2)
            return r6
        L_0x0098:
            int r3 = r18.b()     // Catch:{ all -> 0x00af }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a5
            r1.c(r2)
            return r6
        L_0x00a5:
            int r3 = (int) r8
            r1.d(r3)     // Catch:{ all -> 0x00af }
            goto L_0x0008
        L_0x00ab:
            r1.c(r2)
            return r4
        L_0x00af:
            r0 = move-exception
            r1.c(r2)
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.a.a(com.google.android.exoplayer2.util.q, int, int, boolean):boolean");
    }

    private static int b(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static int b(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    private static ChapterTocFrame b(q qVar, int i2, int i3, boolean z2, int i4, C0112a aVar) throws UnsupportedEncodingException {
        q qVar2 = qVar;
        int d2 = qVar.d();
        int b2 = b(qVar2.f17159a, d2);
        String str = new String(qVar2.f17159a, d2, b2 - d2, "ISO-8859-1");
        qVar.c(b2 + 1);
        int h2 = qVar.h();
        boolean z3 = (h2 & 2) != 0;
        boolean z4 = (h2 & 1) != 0;
        int h3 = qVar.h();
        String[] strArr = new String[h3];
        for (int i5 = 0; i5 < h3; i5++) {
            int d3 = qVar.d();
            int b3 = b(qVar2.f17159a, d3);
            strArr[i5] = new String(qVar2.f17159a, d3, b3 - d3, "ISO-8859-1");
            qVar.c(b3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i6 = d2 + i2;
        while (qVar.d() < i6) {
            Id3Frame a2 = a(i3, qVar, z2, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z3, z4, strArr, id3FrameArr);
    }

    private static UrlLinkFrame b(q qVar, int i2) throws UnsupportedEncodingException {
        if (i2 < 1) {
            return null;
        }
        int h2 = qVar.h();
        String a2 = a(h2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        qVar.a(bArr, 0, i3);
        int a3 = a(bArr, 0, h2);
        String str = new String(bArr, 0, a3, a2);
        int b2 = a3 + b(h2);
        return new UrlLinkFrame("WXXX", str, a(bArr, b2, b(bArr, b2), "ISO-8859-1"));
    }

    private static UrlLinkFrame b(q qVar, int i2, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i2];
        qVar.a(bArr, 0, i2);
        return new UrlLinkFrame(str, (String) null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean b(int i2, int i3, int i4, int i5, int i6) {
        return false;
    }

    private static byte[] b(byte[] bArr, int i2, int i3) {
        return i3 <= i2 ? ad.f11760f : Arrays.copyOfRange(bArr, i2, i3);
    }

    private static BinaryFrame c(q qVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        qVar.a(bArr, 0, i2);
        return new BinaryFrame(str, bArr);
    }

    private static PrivFrame c(q qVar, int i2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i2];
        qVar.a(bArr, 0, i2);
        int b2 = b(bArr, 0);
        return new PrivFrame(new String(bArr, 0, b2, "ISO-8859-1"), b(bArr, b2 + 1, i2));
    }

    private static GeobFrame d(q qVar, int i2) throws UnsupportedEncodingException {
        int h2 = qVar.h();
        String a2 = a(h2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        qVar.a(bArr, 0, i3);
        int b2 = b(bArr, 0);
        String str = new String(bArr, 0, b2, "ISO-8859-1");
        int i4 = b2 + 1;
        int a3 = a(bArr, i4, h2);
        String a4 = a(bArr, i4, a3, a2);
        int b3 = a3 + b(h2);
        int a5 = a(bArr, b3, h2);
        return new GeobFrame(str, a4, a(bArr, b3, a5, a2), b(bArr, a5 + b(h2), i3));
    }

    private static CommentFrame e(q qVar, int i2) throws UnsupportedEncodingException {
        if (i2 < 4) {
            return null;
        }
        int h2 = qVar.h();
        String a2 = a(h2);
        byte[] bArr = new byte[3];
        qVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        qVar.a(bArr2, 0, i3);
        int a3 = a(bArr2, 0, h2);
        String str2 = new String(bArr2, 0, a3, a2);
        int b2 = a3 + b(h2);
        return new CommentFrame(str, str2, a(bArr2, b2, a(bArr2, b2, h2), a2));
    }

    private static MlltFrame f(q qVar, int i2) {
        int i3 = qVar.i();
        int l2 = qVar.l();
        int l3 = qVar.l();
        int h2 = qVar.h();
        int h3 = qVar.h();
        p pVar = new p();
        pVar.a(qVar);
        int i4 = ((i2 - 10) * 8) / (h2 + h3);
        int[] iArr = new int[i4];
        int[] iArr2 = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int c2 = pVar.c(h2);
            int c3 = pVar.c(h3);
            iArr[i5] = c2;
            iArr2[i5] = c3;
        }
        return new MlltFrame(i3, l2, l3, iArr, iArr2);
    }

    private static int g(q qVar, int i2) {
        byte[] bArr = qVar.f17159a;
        int d2 = qVar.d();
        int i3 = d2;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= d2 + i2) {
                return i2;
            }
            if ((bArr[i3] & 255) == 255 && bArr[i4] == 0) {
                System.arraycopy(bArr, i3 + 2, bArr, i4, (i2 - (i3 - d2)) - 2);
                i2--;
            }
            i3 = i4;
        }
    }

    public Metadata a(c cVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.b(cVar.f13099b);
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata a(byte[] bArr, int i2) {
        ArrayList arrayList = new ArrayList();
        q qVar = new q(bArr, i2);
        b a2 = a(qVar);
        if (a2 == null) {
            return null;
        }
        int d2 = qVar.d();
        int i3 = a2.f15927a == 2 ? 6 : 10;
        int b2 = a2.f15929c;
        if (a2.f15928b) {
            b2 = g(qVar, a2.f15929c);
        }
        qVar.b(d2 + b2);
        boolean z2 = false;
        if (!a(qVar, a2.f15927a, i3, false)) {
            if (a2.f15927a != 4 || !a(qVar, 4, i3, true)) {
                int a3 = a2.f15927a;
                StringBuilder sb = new StringBuilder(56);
                sb.append("Failed to validate ID3 tag with majorVersion=");
                sb.append(a3);
                k.c("Id3Decoder", sb.toString());
                return null;
            }
            z2 = true;
        }
        while (qVar.b() >= i3) {
            Id3Frame a4 = a(a2.f15927a, qVar, z2, i3, this.f15926b);
            if (a4 != null) {
                arrayList.add(a4);
            }
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }
}
