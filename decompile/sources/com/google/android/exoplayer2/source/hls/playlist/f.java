package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.extractor.mp4.h;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.util.ad;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class f implements r.a<e> {
    private static final Pattern A = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern B = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern C = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern D = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern E = c("AUTOSELECT");
    private static final Pattern F = c("DEFAULT");
    private static final Pattern G = c("FORCED");
    private static final Pattern H = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern I = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f16341a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f16342b = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f16343c = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f16344d = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f16345e = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f16346f = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f16347g = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f16348h = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f16349i = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f16350j = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f16351k = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f16352l = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f16353m = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: n  reason: collision with root package name */
    private static final Pattern f16354n = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: o  reason: collision with root package name */
    private static final Pattern f16355o = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: p  reason: collision with root package name */
    private static final Pattern f16356p = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");

    /* renamed from: q  reason: collision with root package name */
    private static final Pattern f16357q = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f16358r = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f16359s = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* renamed from: t  reason: collision with root package name */
    private static final Pattern f16360t = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");

    /* renamed from: u  reason: collision with root package name */
    private static final Pattern f16361u = Pattern.compile("KEYFORMAT=\"(.+?)\"");

    /* renamed from: v  reason: collision with root package name */
    private static final Pattern f16362v = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");

    /* renamed from: w  reason: collision with root package name */
    private static final Pattern f16363w = Pattern.compile("URI=\"(.+?)\"");

    /* renamed from: x  reason: collision with root package name */
    private static final Pattern f16364x = Pattern.compile("IV=([^,.*]+)");

    /* renamed from: y  reason: collision with root package name */
    private static final Pattern f16365y = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");

    /* renamed from: z  reason: collision with root package name */
    private static final Pattern f16366z = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private final c K;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedReader f11711a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue<String> f11712b;

        /* renamed from: c  reason: collision with root package name */
        private String f11713c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f11712b = queue;
            this.f11711a = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean a() throws IOException {
            String trim;
            if (this.f11713c != null) {
                return true;
            }
            if (!this.f11712b.isEmpty()) {
                this.f11713c = (String) com.google.android.exoplayer2.util.a.b(this.f11712b.poll());
                return true;
            }
            do {
                String readLine = this.f11711a.readLine();
                this.f11713c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f11713c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (a()) {
                String str = this.f11713c;
                this.f11713c = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    public f() {
        this(c.f16292a);
    }

    public f(c cVar) {
        this.K = cVar;
    }

    private static int a(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !ad.a(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    private static int a(String str) {
        int i2 = a(str, F, false) ? 1 : 0;
        if (a(str, G, false)) {
            i2 |= 2;
        }
        return a(str, E, false) ? i2 | 4 : i2;
    }

    private static int a(String str, Map<String, String> map) {
        String b2 = b(str, C, map);
        int i2 = 0;
        if (TextUtils.isEmpty(b2)) {
            return 0;
        }
        String[] a2 = ad.a(b2, ",");
        if (ad.a((Object[]) a2, (Object) "public.accessibility.describes-video")) {
            i2 = 512;
        }
        if (ad.a((Object[]) a2, (Object) "public.accessibility.transcribes-spoken-dialog")) {
            i2 |= 4096;
        }
        if (ad.a((Object[]) a2, (Object) "public.accessibility.describes-music-and-sound")) {
            i2 |= 1024;
        }
        return ad.a((Object[]) a2, (Object) "public.easy-to-read") ? i2 | 8192 : i2;
    }

    private static int a(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(a(str, pattern, (Map<String, String>) Collections.emptyMap()));
    }

    private static int a(String str, Pattern pattern, int i2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt(matcher.group(1)) : i2;
    }

    private static DrmInitData.SchemeData a(String str, String str2, Map<String, String> map) throws ParserException {
        String a2 = a(str, f16362v, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String a3 = a(str, f16363w, map);
            return new DrmInitData.SchemeData(e.f15480d, "video/mp4", Base64.decode(a3.substring(a3.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(e.f15480d, "hls", ad.c(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(a2)) {
                return null;
            }
            String a4 = a(str, f16363w, map);
            return new DrmInitData.SchemeData(e.f15481e, "video/mp4", h.a(e.f15481e, Base64.decode(a4.substring(a4.indexOf(44)), 0)));
        }
    }

    private static c.b a(ArrayList<c.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.b bVar = arrayList.get(i2);
            if (str.equals(bVar.f16310d)) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.hls.playlist.c a(com.google.android.exoplayer2.source.hls.playlist.f.a r41, java.lang.String r42) throws java.io.IOException {
        /*
            r1 = r42
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r13 = 0
            r14 = 0
        L_0x0036:
            boolean r15 = r41.a()
            r16 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r15 == 0) goto L_0x01be
            java.lang.String r15 = r41.b()
            java.lang.String r10 = "#EXT"
            boolean r10 = r15.startsWith(r10)
            if (r10 == 0) goto L_0x004d
            r8.add(r15)
        L_0x004d:
            java.lang.String r10 = "#EXT-X-DEFINE"
            boolean r10 = r15.startsWith(r10)
            if (r10 == 0) goto L_0x006e
            java.util.regex.Pattern r10 = A
            java.lang.String r10 = a((java.lang.String) r15, (java.util.regex.Pattern) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.util.regex.Pattern r9 = H
            java.lang.String r9 = a((java.lang.String) r15, (java.util.regex.Pattern) r9, (java.util.Map<java.lang.String, java.lang.String>) r11)
            r11.put(r10, r9)
        L_0x0064:
            r21 = r7
            r23 = r8
            r22 = r12
            r20 = r13
            goto L_0x01b4
        L_0x006e:
            java.lang.String r9 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L_0x0078
            r13 = 1
            goto L_0x0036
        L_0x0078:
            java.lang.String r9 = "#EXT-X-MEDIA"
            boolean r9 = r15.startsWith(r9)
            if (r9 == 0) goto L_0x0084
            r3.add(r15)
            goto L_0x0064
        L_0x0084:
            java.lang.String r9 = "#EXT-X-SESSION-KEY"
            boolean r9 = r15.startsWith(r9)
            if (r9 == 0) goto L_0x00be
            java.util.regex.Pattern r9 = f16361u
            java.lang.String r10 = "identity"
            java.lang.String r9 = a(r15, r9, r10, r11)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r9 = a((java.lang.String) r15, (java.lang.String) r9, (java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r9 == 0) goto L_0x00b8
            java.util.regex.Pattern r10 = f16360t
            java.lang.String r10 = a((java.lang.String) r15, (java.util.regex.Pattern) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.lang.String r10 = b(r10)
            com.google.android.exoplayer2.drm.DrmInitData r15 = new com.google.android.exoplayer2.drm.DrmInitData
            r21 = r7
            r20 = r13
            r13 = 1
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r7 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r13]
            r13 = 0
            r7[r13] = r9
            r15.<init>((java.lang.String) r10, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r7)
            r12.add(r15)
            goto L_0x01b0
        L_0x00b8:
            r21 = r7
            r20 = r13
            goto L_0x01b0
        L_0x00be:
            r21 = r7
            r20 = r13
            java.lang.String r7 = "#EXT-X-STREAM-INF"
            boolean r7 = r15.startsWith(r7)
            if (r7 == 0) goto L_0x01b0
            java.lang.String r7 = "CLOSED-CAPTIONS=NONE"
            boolean r7 = r15.contains(r7)
            r14 = r14 | r7
            java.util.regex.Pattern r7 = f16346f
            int r7 = a((java.lang.String) r15, (java.util.regex.Pattern) r7)
            java.util.regex.Pattern r9 = f16341a
            r13 = -1
            a((java.lang.String) r15, (java.util.regex.Pattern) r9, (int) r13)
            java.util.regex.Pattern r9 = f16348h
            java.lang.String r26 = b(r15, r9, r11)
            java.util.regex.Pattern r9 = f16349i
            java.lang.String r9 = b(r15, r9, r11)
            if (r9 == 0) goto L_0x010b
            java.lang.String r10 = "x"
            java.lang.String[] r9 = r9.split(r10)
            r10 = 0
            r18 = r9[r10]
            int r10 = java.lang.Integer.parseInt(r18)
            r18 = 1
            r9 = r9[r18]
            int r9 = java.lang.Integer.parseInt(r9)
            if (r10 <= 0) goto L_0x0104
            if (r9 > 0) goto L_0x0106
        L_0x0104:
            r9 = -1
            r10 = -1
        L_0x0106:
            r30 = r9
            r29 = r10
            goto L_0x010f
        L_0x010b:
            r29 = -1
            r30 = -1
        L_0x010f:
            java.util.regex.Pattern r9 = f16350j
            java.lang.String r9 = b(r15, r9, r11)
            if (r9 == 0) goto L_0x011e
            float r16 = java.lang.Float.parseFloat(r9)
            r31 = r16
            goto L_0x0120
        L_0x011e:
            r31 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0120:
            java.util.regex.Pattern r9 = f16342b
            java.lang.String r9 = b(r15, r9, r11)
            java.util.regex.Pattern r10 = f16343c
            java.lang.String r10 = b(r15, r10, r11)
            java.util.regex.Pattern r13 = f16344d
            java.lang.String r13 = b(r15, r13, r11)
            r18 = r14
            java.util.regex.Pattern r14 = f16345e
            java.lang.String r14 = b(r15, r14, r11)
            boolean r15 = r41.a()
            if (r15 == 0) goto L_0x01a8
            java.lang.String r15 = r41.b()
            java.lang.String r15 = b((java.lang.String) r15, (java.util.Map<java.lang.String, java.lang.String>) r11)
            android.net.Uri r15 = com.google.android.exoplayer2.util.ac.a(r1, r15)
            int r16 = r2.size()
            java.lang.String r22 = java.lang.Integer.toString(r16)
            r23 = 0
            r25 = 0
            r27 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            java.lang.String r24 = "application/x-mpegURL"
            r28 = r7
            com.google.android.exoplayer2.Format r34 = com.google.android.exoplayer2.Format.a((java.lang.String) r22, (java.lang.String) r23, (java.lang.String) r24, (java.lang.String) r25, (java.lang.String) r26, (com.google.android.exoplayer2.metadata.Metadata) r27, (int) r28, (int) r29, (int) r30, (float) r31, (java.util.List<byte[]>) r32, (int) r33, (int) r34)
            r22 = r12
            com.google.android.exoplayer2.source.hls.playlist.c$b r12 = new com.google.android.exoplayer2.source.hls.playlist.c$b
            r32 = r12
            r33 = r15
            r35 = r9
            r36 = r10
            r37 = r13
            r38 = r14
            r32.<init>(r33, r34, r35, r36, r37, r38)
            r2.add(r12)
            java.lang.Object r12 = r0.get(r15)
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            if (r12 != 0) goto L_0x018e
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r0.put(r15, r12)
        L_0x018e:
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo r15 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo
            r23 = r8
            long r7 = (long) r7
            r32 = r15
            r33 = r7
            r35 = r9
            r36 = r10
            r37 = r13
            r38 = r14
            r32.<init>(r33, r35, r36, r37, r38)
            r12.add(r15)
            r14 = r18
            goto L_0x01b4
        L_0x01a8:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "#EXT-X-STREAM-INF tag must be followed by another line"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x01b0:
            r23 = r8
            r22 = r12
        L_0x01b4:
            r13 = r20
            r7 = r21
            r12 = r22
            r8 = r23
            goto L_0x0036
        L_0x01be:
            r21 = r7
            r23 = r8
            r22 = r12
            r20 = r13
            r13 = -1
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            r9 = 0
        L_0x01d2:
            int r10 = r2.size()
            r12 = 0
            if (r9 >= r10) goto L_0x022f
            java.lang.Object r10 = r2.get(r9)
            com.google.android.exoplayer2.source.hls.playlist.c$b r10 = (com.google.android.exoplayer2.source.hls.playlist.c.b) r10
            android.net.Uri r15 = r10.f16307a
            boolean r15 = r8.add(r15)
            if (r15 == 0) goto L_0x0223
            com.google.android.exoplayer2.Format r15 = r10.f16308b
            com.google.android.exoplayer2.metadata.Metadata r15 = r15.f15090g
            if (r15 != 0) goto L_0x01ef
            r15 = 1
            goto L_0x01f0
        L_0x01ef:
            r15 = 0
        L_0x01f0:
            com.google.android.exoplayer2.util.a.b((boolean) r15)
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r15 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            android.net.Uri r13 = r10.f16307a
            java.lang.Object r13 = r0.get(r13)
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Object r13 = com.google.android.exoplayer2.util.a.b(r13)
            java.util.List r13 = (java.util.List) r13
            r15.<init>(r12, r12, r13)
            com.google.android.exoplayer2.Format r12 = r10.f16308b
            com.google.android.exoplayer2.metadata.Metadata r13 = new com.google.android.exoplayer2.metadata.Metadata
            r24 = r0
            r41 = r8
            r0 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r8 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r0]
            r0 = 0
            r8[r0] = r15
            r13.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r8)
            com.google.android.exoplayer2.Format r0 = r12.a((com.google.android.exoplayer2.metadata.Metadata) r13)
            com.google.android.exoplayer2.source.hls.playlist.c$b r0 = r10.a((com.google.android.exoplayer2.Format) r0)
            r7.add(r0)
            goto L_0x0227
        L_0x0223:
            r24 = r0
            r41 = r8
        L_0x0227:
            int r9 = r9 + 1
            r8 = r41
            r0 = r24
            r13 = -1
            goto L_0x01d2
        L_0x022f:
            r0 = r12
            r8 = r0
            r13 = 0
        L_0x0232:
            int r9 = r3.size()
            if (r13 >= r9) goto L_0x044e
            java.lang.Object r9 = r3.get(r13)
            java.lang.String r9 = (java.lang.String) r9
            java.util.regex.Pattern r10 = B
            java.lang.String r10 = a((java.lang.String) r9, (java.util.regex.Pattern) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.util.regex.Pattern r15 = A
            java.lang.String r15 = a((java.lang.String) r9, (java.util.regex.Pattern) r15, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.util.regex.Pattern r12 = f16363w
            java.lang.String r12 = b(r9, r12, r11)
            if (r12 != 0) goto L_0x0254
            r12 = 0
            goto L_0x0258
        L_0x0254:
            android.net.Uri r12 = com.google.android.exoplayer2.util.ac.a(r1, r12)
        L_0x0258:
            java.util.regex.Pattern r1 = f16366z
            java.lang.String r1 = b(r9, r1, r11)
            int r35 = a((java.lang.String) r9)
            int r36 = a((java.lang.String) r9, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.lang.String r24 = java.lang.String.valueOf(r10)
            int r24 = r24.length()
            r19 = 1
            int r24 = r24 + 1
            java.lang.String r25 = java.lang.String.valueOf(r15)
            int r25 = r25.length()
            r37 = r3
            int r3 = r24 + r25
            r38 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            r8.append(r10)
            java.lang.String r3 = ":"
            r8.append(r3)
            r8.append(r15)
            java.lang.String r24 = r8.toString()
            com.google.android.exoplayer2.metadata.Metadata r3 = new com.google.android.exoplayer2.metadata.Metadata
            r39 = r7
            r8 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r8]
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r8 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            r40 = r14
            java.util.List r14 = java.util.Collections.emptyList()
            r8.<init>(r10, r15, r14)
            r14 = 0
            r7[r14] = r8
            r3.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r7)
            java.util.regex.Pattern r7 = f16365y
            java.lang.String r7 = a((java.lang.String) r9, (java.util.regex.Pattern) r7, (java.util.Map<java.lang.String, java.lang.String>) r11)
            r7.hashCode()
            int r8 = r7.hashCode()
            r14 = 2
            switch(r8) {
                case -959297733: goto L_0x02e0;
                case -333210994: goto L_0x02d5;
                case 62628790: goto L_0x02ca;
                case 81665115: goto L_0x02bf;
                default: goto L_0x02bd;
            }
        L_0x02bd:
            r7 = -1
            goto L_0x02ea
        L_0x02bf:
            java.lang.String r8 = "VIDEO"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x02c8
            goto L_0x02bd
        L_0x02c8:
            r7 = 3
            goto L_0x02ea
        L_0x02ca:
            java.lang.String r8 = "AUDIO"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x02d3
            goto L_0x02bd
        L_0x02d3:
            r7 = 2
            goto L_0x02ea
        L_0x02d5:
            java.lang.String r8 = "CLOSED-CAPTIONS"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x02de
            goto L_0x02bd
        L_0x02de:
            r7 = 1
            goto L_0x02ea
        L_0x02e0:
            java.lang.String r8 = "SUBTITLES"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x02e9
            goto L_0x02bd
        L_0x02e9:
            r7 = 0
        L_0x02ea:
            switch(r7) {
                case 0: goto L_0x03ff;
                case 1: goto L_0x03b8;
                case 2: goto L_0x033f;
                case 3: goto L_0x02f1;
                default: goto L_0x02ed;
            }
        L_0x02ed:
            r17 = 0
            goto L_0x043f
        L_0x02f1:
            com.google.android.exoplayer2.source.hls.playlist.c$b r1 = b((java.util.ArrayList<com.google.android.exoplayer2.source.hls.playlist.c.b>) r2, (java.lang.String) r10)
            if (r1 == 0) goto L_0x030e
            com.google.android.exoplayer2.Format r1 = r1.f16308b
            java.lang.String r7 = r1.f15089f
            java.lang.String r7 = com.google.android.exoplayer2.util.ad.a((java.lang.String) r7, (int) r14)
            int r8 = r1.f15097n
            int r9 = r1.f15098o
            float r1 = r1.f15099p
            r33 = r1
            r28 = r7
            r31 = r8
            r32 = r9
            goto L_0x0316
        L_0x030e:
            r28 = 0
            r31 = -1
            r32 = -1
            r33 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0316:
            if (r28 == 0) goto L_0x031f
            java.lang.String r1 = com.google.android.exoplayer2.util.n.g(r28)
            r27 = r1
            goto L_0x0321
        L_0x031f:
            r27 = 0
        L_0x0321:
            r29 = 0
            r30 = -1
            r34 = 0
            java.lang.String r26 = "application/x-mpegURL"
            r25 = r15
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r24, (java.lang.String) r25, (java.lang.String) r26, (java.lang.String) r27, (java.lang.String) r28, (com.google.android.exoplayer2.metadata.Metadata) r29, (int) r30, (int) r31, (int) r32, (float) r33, (java.util.List<byte[]>) r34, (int) r35, (int) r36)
            com.google.android.exoplayer2.Format r1 = r1.a((com.google.android.exoplayer2.metadata.Metadata) r3)
            if (r12 != 0) goto L_0x0336
            goto L_0x02ed
        L_0x0336:
            com.google.android.exoplayer2.source.hls.playlist.c$a r3 = new com.google.android.exoplayer2.source.hls.playlist.c$a
            r3.<init>(r12, r1, r10, r15)
            r4.add(r3)
            goto L_0x02ed
        L_0x033f:
            com.google.android.exoplayer2.source.hls.playlist.c$b r7 = a((java.util.ArrayList<com.google.android.exoplayer2.source.hls.playlist.c.b>) r2, (java.lang.String) r10)
            if (r7 == 0) goto L_0x0351
            com.google.android.exoplayer2.Format r7 = r7.f16308b
            java.lang.String r7 = r7.f15089f
            r8 = 1
            java.lang.String r7 = com.google.android.exoplayer2.util.ad.a((java.lang.String) r7, (int) r8)
            r28 = r7
            goto L_0x0354
        L_0x0351:
            r8 = 1
            r28 = 0
        L_0x0354:
            if (r28 == 0) goto L_0x035b
            java.lang.String r7 = com.google.android.exoplayer2.util.n.g(r28)
            goto L_0x035c
        L_0x035b:
            r7 = 0
        L_0x035c:
            java.util.regex.Pattern r14 = f16347g
            java.lang.String r9 = b(r9, r14, r11)
            if (r9 == 0) goto L_0x0389
            java.lang.String r14 = "/"
            java.lang.String[] r14 = com.google.android.exoplayer2.util.ad.b((java.lang.String) r9, (java.lang.String) r14)
            r17 = 0
            r14 = r14[r17]
            int r14 = java.lang.Integer.parseInt(r14)
            java.lang.String r8 = "audio/eac3"
            boolean r8 = r8.equals(r7)
            if (r8 == 0) goto L_0x0384
            java.lang.String r8 = "/JOC"
            boolean r8 = r9.endsWith(r8)
            if (r8 == 0) goto L_0x0384
            java.lang.String r7 = "audio/eac3-joc"
        L_0x0384:
            r27 = r7
            r31 = r14
            goto L_0x038f
        L_0x0389:
            r17 = 0
            r27 = r7
            r31 = -1
        L_0x038f:
            r29 = 0
            r30 = -1
            r32 = -1
            r33 = 0
            java.lang.String r26 = "application/x-mpegURL"
            r25 = r15
            r34 = r35
            r35 = r36
            r36 = r1
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r24, (java.lang.String) r25, (java.lang.String) r26, (java.lang.String) r27, (java.lang.String) r28, (com.google.android.exoplayer2.metadata.Metadata) r29, (int) r30, (int) r31, (int) r32, (java.util.List<byte[]>) r33, (int) r34, (int) r35, (java.lang.String) r36)
            if (r12 != 0) goto L_0x03aa
            r8 = r1
            goto L_0x0441
        L_0x03aa:
            com.google.android.exoplayer2.source.hls.playlist.c$a r7 = new com.google.android.exoplayer2.source.hls.playlist.c$a
            com.google.android.exoplayer2.Format r1 = r1.a((com.google.android.exoplayer2.metadata.Metadata) r3)
            r7.<init>(r12, r1, r10, r15)
            r5.add(r7)
            goto L_0x043f
        L_0x03b8:
            r17 = 0
            java.util.regex.Pattern r3 = D
            java.lang.String r3 = a((java.lang.String) r9, (java.util.regex.Pattern) r3, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.lang.String r7 = "CC"
            boolean r7 = r3.startsWith(r7)
            if (r7 == 0) goto L_0x03d3
            java.lang.String r3 = r3.substring(r14)
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.String r7 = "application/cea-608"
            goto L_0x03de
        L_0x03d3:
            r7 = 7
            java.lang.String r3 = r3.substring(r7)
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.String r7 = "application/cea-708"
        L_0x03de:
            r33 = r3
            r27 = r7
            if (r0 != 0) goto L_0x03e9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x03e9:
            r26 = 0
            r28 = 0
            r29 = -1
            r25 = r15
            r30 = r35
            r31 = r36
            r32 = r1
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r24, (java.lang.String) r25, (java.lang.String) r26, (java.lang.String) r27, (java.lang.String) r28, (int) r29, (int) r30, (int) r31, (java.lang.String) r32, (int) r33)
            r0.add(r1)
            goto L_0x043f
        L_0x03ff:
            r17 = 0
            com.google.android.exoplayer2.source.hls.playlist.c$b r7 = c((java.util.ArrayList<com.google.android.exoplayer2.source.hls.playlist.c.b>) r2, (java.lang.String) r10)
            if (r7 == 0) goto L_0x0417
            com.google.android.exoplayer2.Format r7 = r7.f16308b
            java.lang.String r7 = r7.f15089f
            r8 = 3
            java.lang.String r7 = com.google.android.exoplayer2.util.ad.a((java.lang.String) r7, (int) r8)
            java.lang.String r8 = com.google.android.exoplayer2.util.n.g(r7)
            r28 = r7
            goto L_0x041a
        L_0x0417:
            r8 = 0
            r28 = 0
        L_0x041a:
            if (r8 != 0) goto L_0x0421
            java.lang.String r7 = "text/vtt"
            r27 = r7
            goto L_0x0423
        L_0x0421:
            r27 = r8
        L_0x0423:
            r29 = -1
            java.lang.String r26 = "application/x-mpegURL"
            r25 = r15
            r30 = r35
            r31 = r36
            r32 = r1
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a(r24, r25, r26, r27, r28, r29, r30, r31, r32)
            com.google.android.exoplayer2.Format r1 = r1.a((com.google.android.exoplayer2.metadata.Metadata) r3)
            com.google.android.exoplayer2.source.hls.playlist.c$a r3 = new com.google.android.exoplayer2.source.hls.playlist.c$a
            r3.<init>(r12, r1, r10, r15)
            r6.add(r3)
        L_0x043f:
            r8 = r38
        L_0x0441:
            int r13 = r13 + 1
            r1 = r42
            r3 = r37
            r7 = r39
            r14 = r40
            r12 = 0
            goto L_0x0232
        L_0x044e:
            r39 = r7
            r38 = r8
            r40 = r14
            if (r40 == 0) goto L_0x045a
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x045a:
            r9 = r0
            com.google.android.exoplayer2.source.hls.playlist.c r13 = new com.google.android.exoplayer2.source.hls.playlist.c
            r0 = r13
            r1 = r42
            r2 = r23
            r3 = r39
            r7 = r21
            r8 = r38
            r10 = r20
            r12 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.f.a(com.google.android.exoplayer2.source.hls.playlist.f$a, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0141, code lost:
        if (r8 != null) goto L_0x0150;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.hls.playlist.d a(com.google.android.exoplayer2.source.hls.playlist.c r60, com.google.android.exoplayer2.source.hls.playlist.f.a r61, java.lang.String r62) throws java.io.IOException {
        /*
            r0 = r60
            boolean r1 = r0.f16340p
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.TreeMap r3 = new java.util.TreeMap
            r3.<init>()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.lang.String r7 = ""
            r13 = 0
            r14 = 1
            r26 = r1
            r16 = r4
            r24 = r16
            r37 = r7
            r1 = 0
            r4 = 0
            r5 = 0
            r12 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r23 = 1
            r27 = 0
            r28 = 0
            r29 = 0
            r38 = 0
            r40 = 0
            r45 = 0
            r46 = 0
            r47 = -1
            r49 = 0
            r50 = 0
            r52 = 0
        L_0x004b:
            r53 = 0
        L_0x004d:
            boolean r31 = r61.a()
            if (r31 == 0) goto L_0x0328
            java.lang.String r8 = r61.b()
            java.lang.String r9 = "#EXT"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0062
            r6.add(r8)
        L_0x0062:
            java.lang.String r9 = "#EXT-X-PLAYLIST-TYPE"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0084
            java.util.regex.Pattern r9 = f16353m
            java.lang.String r8 = a((java.lang.String) r8, (java.util.regex.Pattern) r9, (java.util.Map<java.lang.String, java.lang.String>) r2)
            java.lang.String r9 = "VOD"
            boolean r9 = r9.equals(r8)
            if (r9 == 0) goto L_0x007a
            r4 = 1
            goto L_0x004d
        L_0x007a:
            java.lang.String r9 = "EVENT"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x004d
            r4 = 2
            goto L_0x004d
        L_0x0084:
            java.lang.String r9 = "#EXT-X-START"
            boolean r9 = r8.startsWith(r9)
            r31 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            if (r9 == 0) goto L_0x009d
            java.util.regex.Pattern r9 = f16357q
            double r8 = c((java.lang.String) r8, (java.util.regex.Pattern) r9)
            double r8 = r8 * r31
            long r8 = (long) r8
            r16 = r8
            goto L_0x004d
        L_0x009d:
            java.lang.String r9 = "#EXT-X-MAP"
            boolean r9 = r8.startsWith(r9)
            java.lang.String r10 = "@"
            if (r9 == 0) goto L_0x00f2
            java.util.regex.Pattern r9 = f16363w
            java.lang.String r9 = a((java.lang.String) r8, (java.util.regex.Pattern) r9, (java.util.Map<java.lang.String, java.lang.String>) r2)
            java.util.regex.Pattern r11 = f16359s
            java.lang.String r8 = b(r8, r11, r2)
            if (r8 == 0) goto L_0x00cd
            java.lang.String[] r8 = r8.split(r10)
            r10 = r8[r13]
            long r10 = java.lang.Long.parseLong(r10)
            int r13 = r8.length
            if (r13 <= r14) goto L_0x00c8
            r8 = r8[r14]
            long r29 = java.lang.Long.parseLong(r8)
        L_0x00c8:
            r33 = r10
            r31 = r29
            goto L_0x00d1
        L_0x00cd:
            r31 = r29
            r33 = r47
        L_0x00d1:
            if (r5 == 0) goto L_0x00de
            if (r46 == 0) goto L_0x00d6
            goto L_0x00de
        L_0x00d6:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x00de:
            com.google.android.exoplayer2.source.hls.playlist.d$a r52 = new com.google.android.exoplayer2.source.hls.playlist.d$a
            r29 = r52
            r30 = r9
            r35 = r5
            r36 = r46
            r29.<init>(r30, r31, r33, r35, r36)
            r13 = 0
            r29 = 0
            r47 = -1
            goto L_0x004d
        L_0x00f2:
            java.lang.String r9 = "#EXT-X-TARGETDURATION"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0109
            java.util.regex.Pattern r9 = f16351k
            int r8 = a((java.lang.String) r8, (java.util.regex.Pattern) r9)
            long r8 = (long) r8
            r10 = 1000000(0xf4240, double:4.940656E-318)
            long r24 = r8 * r10
        L_0x0106:
            r13 = 0
            goto L_0x004d
        L_0x0109:
            java.lang.String r9 = "#EXT-X-MEDIA-SEQUENCE"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x011a
            java.util.regex.Pattern r9 = f16354n
            long r38 = b((java.lang.String) r8, (java.util.regex.Pattern) r9)
            r21 = r38
            goto L_0x0106
        L_0x011a:
            java.lang.String r9 = "#EXT-X-VERSION"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0129
            java.util.regex.Pattern r9 = f16352l
            int r23 = a((java.lang.String) r8, (java.util.regex.Pattern) r9)
            goto L_0x0106
        L_0x0129:
            java.lang.String r9 = "#EXT-X-DEFINE"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x015c
            java.util.regex.Pattern r9 = I
            java.lang.String r9 = b(r8, r9, r2)
            if (r9 == 0) goto L_0x0144
            java.util.Map<java.lang.String, java.lang.String> r8 = r0.f16301j
            java.lang.Object r8 = r8.get(r9)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x0153
            goto L_0x0150
        L_0x0144:
            java.util.regex.Pattern r9 = A
            java.lang.String r9 = a((java.lang.String) r8, (java.util.regex.Pattern) r9, (java.util.Map<java.lang.String, java.lang.String>) r2)
            java.util.regex.Pattern r10 = H
            java.lang.String r8 = a((java.lang.String) r8, (java.util.regex.Pattern) r10, (java.util.Map<java.lang.String, java.lang.String>) r2)
        L_0x0150:
            r2.put(r9, r8)
        L_0x0153:
            r58 = r3
            r59 = r7
            r0 = 0
            r7 = -1
            goto L_0x031e
        L_0x015c:
            java.lang.String r9 = "#EXTINF"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0176
            java.util.regex.Pattern r9 = f16355o
            double r9 = c((java.lang.String) r8, (java.util.regex.Pattern) r9)
            double r9 = r9 * r31
            long r9 = (long) r9
            java.util.regex.Pattern r11 = f16356p
            java.lang.String r37 = a(r8, r11, r7, r2)
            r53 = r9
            goto L_0x0106
        L_0x0176:
            java.lang.String r9 = "#EXT-X-KEY"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x01d7
            java.util.regex.Pattern r5 = f16360t
            java.lang.String r5 = a((java.lang.String) r8, (java.util.regex.Pattern) r5, (java.util.Map<java.lang.String, java.lang.String>) r2)
            java.util.regex.Pattern r9 = f16361u
            java.lang.String r10 = "identity"
            java.lang.String r9 = a(r8, r9, r10, r2)
            java.lang.String r11 = "NONE"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x019e
            r3.clear()
            r5 = 0
            r40 = 0
            r46 = 0
            goto L_0x0106
        L_0x019e:
            java.util.regex.Pattern r11 = f16364x
            java.lang.String r11 = b(r8, r11, r2)
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x01c1
            java.lang.String r9 = "AES-128"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x01bc
            java.util.regex.Pattern r5 = f16363w
            java.lang.String r5 = a((java.lang.String) r8, (java.util.regex.Pattern) r5, (java.util.Map<java.lang.String, java.lang.String>) r2)
            r46 = r11
            goto L_0x0106
        L_0x01bc:
            r46 = r11
            r5 = 0
            goto L_0x0106
        L_0x01c1:
            if (r12 != 0) goto L_0x01c7
            java.lang.String r12 = b(r5)
        L_0x01c7:
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r5 = a((java.lang.String) r8, (java.lang.String) r9, (java.util.Map<java.lang.String, java.lang.String>) r2)
            if (r5 == 0) goto L_0x01bc
            r3.put(r9, r5)
            r46 = r11
            r5 = 0
            r40 = 0
            goto L_0x0106
        L_0x01d7:
            java.lang.String r9 = "#EXT-X-BYTERANGE"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x01fb
            java.util.regex.Pattern r9 = f16358r
            java.lang.String r8 = a((java.lang.String) r8, (java.util.regex.Pattern) r9, (java.util.Map<java.lang.String, java.lang.String>) r2)
            java.lang.String[] r8 = r8.split(r10)
            r9 = 0
            r10 = r8[r9]
            long r47 = java.lang.Long.parseLong(r10)
            int r9 = r8.length
            if (r9 <= r14) goto L_0x0106
            r8 = r8[r14]
            long r29 = java.lang.Long.parseLong(r8)
            goto L_0x0106
        L_0x01fb:
            java.lang.String r9 = "#EXT-X-DISCONTINUITY-SEQUENCE"
            boolean r9 = r8.startsWith(r9)
            r10 = 58
            if (r9 == 0) goto L_0x0215
            int r1 = r8.indexOf(r10)
            int r1 = r1 + r14
            java.lang.String r1 = r8.substring(r1)
            int r20 = java.lang.Integer.parseInt(r1)
            r1 = 1
            goto L_0x0106
        L_0x0215:
            java.lang.String r9 = "#EXT-X-DISCONTINUITY"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0221
            int r49 = r49 + 1
            goto L_0x0106
        L_0x0221:
            java.lang.String r9 = "#EXT-X-PROGRAM-DATE-TIME"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0244
            r31 = 0
            int r9 = (r18 > r31 ? 1 : (r18 == r31 ? 0 : -1))
            if (r9 != 0) goto L_0x0153
            int r9 = r8.indexOf(r10)
            int r9 = r9 + r14
            java.lang.String r8 = r8.substring(r9)
            long r8 = com.google.android.exoplayer2.util.ad.f((java.lang.String) r8)
            long r8 = com.google.android.exoplayer2.e.b(r8)
            long r18 = r8 - r50
            goto L_0x0106
        L_0x0244:
            java.lang.String r9 = "#EXT-X-GAP"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0251
            r13 = 0
            r45 = 1
            goto L_0x004d
        L_0x0251:
            java.lang.String r9 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x025e
            r13 = 0
            r26 = 1
            goto L_0x004d
        L_0x025e:
            java.lang.String r9 = "#EXT-X-ENDLIST"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x026b
            r13 = 0
            r27 = 1
            goto L_0x004d
        L_0x026b:
            java.lang.String r9 = "#"
            boolean r9 = r8.startsWith(r9)
            if (r9 != 0) goto L_0x0153
            if (r5 != 0) goto L_0x0277
            r9 = 0
            goto L_0x0280
        L_0x0277:
            if (r46 == 0) goto L_0x027c
            r9 = r46
            goto L_0x0280
        L_0x027c:
            java.lang.String r9 = java.lang.Long.toHexString(r38)
        L_0x0280:
            r10 = 1
            long r10 = r38 + r10
            r31 = -1
            int r13 = (r47 > r31 ? 1 : (r47 == r31 ? 0 : -1))
            if (r13 != 0) goto L_0x028d
            r55 = 0
            goto L_0x028f
        L_0x028d:
            r55 = r29
        L_0x028f:
            if (r40 != 0) goto L_0x02d5
            boolean r13 = r3.isEmpty()
            if (r13 != 0) goto L_0x02d5
            java.util.Collection r13 = r3.values()
            r14 = 0
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r0 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r14]
            java.lang.Object[] r0 = r13.toArray(r0)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r0 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r0
            com.google.android.exoplayer2.drm.DrmInitData r13 = new com.google.android.exoplayer2.drm.DrmInitData
            r13.<init>((java.lang.String) r12, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r0)
            if (r28 != 0) goto L_0x02cf
            int r14 = r0.length
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r14 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r14]
            r58 = r3
            r59 = r7
            r3 = 0
        L_0x02b3:
            int r7 = r0.length
            if (r3 >= r7) goto L_0x02c6
            r7 = r0[r3]
            r29 = r0
            r0 = 0
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r7 = r7.a((byte[]) r0)
            r14[r3] = r7
            int r3 = r3 + 1
            r0 = r29
            goto L_0x02b3
        L_0x02c6:
            r0 = 0
            com.google.android.exoplayer2.drm.DrmInitData r3 = new com.google.android.exoplayer2.drm.DrmInitData
            r3.<init>((java.lang.String) r12, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r14)
            r28 = r3
            goto L_0x02dc
        L_0x02cf:
            r58 = r3
            r59 = r7
            r0 = 0
            goto L_0x02dc
        L_0x02d5:
            r58 = r3
            r59 = r7
            r0 = 0
            r13 = r40
        L_0x02dc:
            com.google.android.exoplayer2.source.hls.playlist.d$a r3 = new com.google.android.exoplayer2.source.hls.playlist.d$a
            r29 = r3
            java.lang.String r30 = b((java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.String>) r2)
            r31 = r52
            r32 = r37
            r33 = r53
            r35 = r49
            r36 = r50
            r38 = r13
            r39 = r5
            r40 = r9
            r41 = r55
            r43 = r47
            r29.<init>(r30, r31, r32, r33, r35, r36, r38, r39, r40, r41, r43, r45)
            r15.add(r3)
            long r50 = r50 + r53
            r7 = -1
            int r3 = (r47 > r7 ? 1 : (r47 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0308
            long r55 = r55 + r47
        L_0x0308:
            r29 = r55
            r0 = r60
            r47 = r7
            r38 = r10
            r40 = r13
            r3 = r58
            r7 = r59
            r37 = r7
            r13 = 0
            r14 = 1
            r45 = 0
            goto L_0x004b
        L_0x031e:
            r0 = r60
            r3 = r58
            r7 = r59
            r13 = 0
            r14 = 1
            goto L_0x004d
        L_0x0328:
            com.google.android.exoplayer2.source.hls.playlist.d r0 = new com.google.android.exoplayer2.source.hls.playlist.d
            r2 = 0
            int r5 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0333
            r57 = 1
            goto L_0x0335
        L_0x0333:
            r57 = 0
        L_0x0335:
            r3 = r0
            r5 = r62
            r7 = r16
            r9 = r18
            r11 = r1
            r12 = r20
            r13 = r21
            r1 = r15
            r15 = r23
            r16 = r24
            r18 = r26
            r19 = r27
            r20 = r57
            r21 = r28
            r22 = r1
            r3.<init>(r4, r5, r6, r7, r9, r11, r12, r13, r15, r16, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.f.a(com.google.android.exoplayer2.source.hls.playlist.c, com.google.android.exoplayer2.source.hls.playlist.f$a, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.d");
    }

    private static String a(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
        }
        return (map.isEmpty() || str2 == null) ? str2 : b(str2, map);
    }

    private static String a(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String b2 = b(str, pattern, map);
        if (b2 != null) {
            return b2;
        }
        String pattern2 = pattern.pattern();
        StringBuilder sb = new StringBuilder(String.valueOf(pattern2).length() + 19 + String.valueOf(str).length());
        sb.append("Couldn't match ");
        sb.append(pattern2);
        sb.append(" in ");
        sb.append(str);
        throw new ParserException(sb.toString());
    }

    private static boolean a(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int a2 = a(bufferedReader, true, read);
        for (int i2 = 0; i2 < 7; i2++) {
            if (a2 != "#EXTM3U".charAt(i2)) {
                return false;
            }
            a2 = bufferedReader.read();
        }
        return ad.a(a(bufferedReader, false, a2));
    }

    private static boolean a(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1).equals("YES") : z2;
    }

    private static long b(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(a(str, pattern, (Map<String, String>) Collections.emptyMap()));
    }

    private static c.b b(ArrayList<c.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.b bVar = arrayList.get(i2);
            if (str.equals(bVar.f16309c)) {
                return bVar;
            }
        }
        return null;
    }

    private static String b(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static String b(String str, Map<String, String> map) {
        Matcher matcher = J.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static String b(String str, Pattern pattern, Map<String, String> map) {
        return a(str, pattern, (String) null, map);
    }

    private static double c(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(a(str, pattern, (Map<String, String>) Collections.emptyMap()));
    }

    private static c.b c(ArrayList<c.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.b bVar = arrayList.get(i2);
            if (str.equals(bVar.f16311e)) {
                return bVar;
            }
        }
        return null;
    }

    private static Pattern c(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 9);
        sb.append(str);
        sb.append("=(");
        sb.append("NO");
        sb.append("|");
        sb.append("YES");
        sb.append(")");
        return Pattern.compile(sb.toString());
    }

    /* renamed from: a */
    public e b(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (a(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                    break;
                                } else if (trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                } else {
                                    arrayDeque.add(trim);
                                }
                            } else {
                                arrayDeque.add(trim);
                                c a2 = a(new a(arrayDeque, bufferedReader), uri.toString());
                                ad.a((Closeable) bufferedReader);
                                return a2;
                            }
                        }
                    } else {
                        ad.a((Closeable) bufferedReader);
                        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                arrayDeque.add(trim);
                return a(this.K, new a(arrayDeque, bufferedReader), uri.toString());
            }
            throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
        } finally {
            ad.a((Closeable) bufferedReader);
        }
    }
}
