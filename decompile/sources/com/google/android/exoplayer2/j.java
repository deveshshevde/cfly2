package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.f;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.text.k;
import java.util.ArrayList;

public class j implements ac {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15687a;

    /* renamed from: b  reason: collision with root package name */
    private b<f> f15688b;

    /* renamed from: c  reason: collision with root package name */
    private int f15689c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f15690d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15691e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15692f;

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.exoplayer2.mediacodec.b f15693g = com.google.android.exoplayer2.mediacodec.b.f15840a;

    public j(Context context) {
        this.f15687a = context;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0074 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r16, int r17, com.google.android.exoplayer2.mediacodec.b r18, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.f> r19, boolean r20, boolean r21, android.os.Handler r22, com.google.android.exoplayer2.video.j r23, long r24, java.util.ArrayList<com.google.android.exoplayer2.z> r26) {
        /*
            r15 = this;
            r0 = r17
            r12 = r26
            java.lang.String r13 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.video.d r14 = new com.google.android.exoplayer2.video.d
            r11 = 50
            r1 = r14
            r2 = r16
            r3 = r18
            r4 = r24
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r1.<init>(r2, r3, r4, r6, r7, r8, r9, r10, r11)
            r12.add(r14)
            if (r0 != 0) goto L_0x0024
            return
        L_0x0024:
            int r1 = r26.size()
            r2 = 2
            if (r0 != r2) goto L_0x002d
            int r1 = r1 + -1
        L_0x002d:
            r0 = 50
            r3 = 3
            r4 = 0
            r5 = 4
            r6 = 1
            java.lang.String r7 = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r4] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class<android.os.Handler> r9 = android.os.Handler.class
            r8[r6] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class<com.google.android.exoplayer2.video.j> r9 = com.google.android.exoplayer2.video.j.class
            r8[r2] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r3] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.reflect.Constructor r7 = r7.getConstructor(r8)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Long r9 = java.lang.Long.valueOf(r24)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r4] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r6] = r22     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r2] = r23     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r3] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Object r7 = r7.newInstance(r8)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            com.google.android.exoplayer2.z r7 = (com.google.android.exoplayer2.z) r7     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            int r8 = r1 + 1
            r12.add(r1, r7)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0074 }
            java.lang.String r1 = "Loaded LibvpxVideoRenderer."
            com.google.android.exoplayer2.util.k.b(r13, r1)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0074 }
            goto L_0x007e
        L_0x0072:
            r1 = r8
            goto L_0x007d
        L_0x0074:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating VP9 extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x007d:
            r8 = r1
        L_0x007e:
            java.lang.String r1 = "com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r7[r4] = r9     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class<android.os.Handler> r9 = android.os.Handler.class
            r7[r6] = r9     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class<com.google.android.exoplayer2.video.j> r9 = com.google.android.exoplayer2.video.j.class
            r7[r2] = r9     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r7[r3] = r9     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Long r7 = java.lang.Long.valueOf(r24)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r5[r4] = r7     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r5[r6] = r22     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r5[r2] = r23     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r5[r3] = r0     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.Object r0 = r1.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            com.google.android.exoplayer2.z r0 = (com.google.android.exoplayer2.z) r0     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            r12.add(r8, r0)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            java.lang.String r0 = "Loaded Libgav1VideoRenderer."
            com.google.android.exoplayer2.util.k.b(r13, r0)     // Catch:{ ClassNotFoundException -> 0x00c4, Exception -> 0x00bb }
            goto L_0x00c4
        L_0x00bb:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating AV1 extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.a(android.content.Context, int, com.google.android.exoplayer2.mediacodec.b, com.google.android.exoplayer2.drm.b, boolean, boolean, android.os.Handler, com.google.android.exoplayer2.video.j, long, java.util.ArrayList):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ae, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0069 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a6 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x0075] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r15, int r16, com.google.android.exoplayer2.mediacodec.b r17, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.f> r18, boolean r19, boolean r20, com.google.android.exoplayer2.audio.AudioProcessor[] r21, android.os.Handler r22, com.google.android.exoplayer2.audio.f r23, java.util.ArrayList<com.google.android.exoplayer2.z> r24) {
        /*
            r14 = this;
            r0 = r16
            r1 = r21
            r11 = r24
            java.lang.String r12 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.audio.n r13 = new com.google.android.exoplayer2.audio.n
            com.google.android.exoplayer2.audio.DefaultAudioSink r10 = new com.google.android.exoplayer2.audio.DefaultAudioSink
            com.google.android.exoplayer2.audio.d r2 = com.google.android.exoplayer2.audio.d.a((android.content.Context) r15)
            r10.<init>(r2, r1)
            r2 = r13
            r3 = r15
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r22
            r9 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r11.add(r13)
            if (r0 != 0) goto L_0x002a
            return
        L_0x002a:
            int r2 = r24.size()
            r3 = 2
            if (r0 != r3) goto L_0x0033
            int r2 = r2 + -1
        L_0x0033:
            r0 = 0
            r4 = 3
            r5 = 1
            java.lang.String r6 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            java.lang.Class<com.google.android.exoplayer2.audio.f> r8 = com.google.android.exoplayer2.audio.f.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioProcessor[]> r8 = com.google.android.exoplayer2.audio.AudioProcessor[].class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            r7[r0] = r22     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            r7[r5] = r23     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            r7[r3] = r1     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            com.google.android.exoplayer2.z r6 = (com.google.android.exoplayer2.z) r6     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0069 }
            int r7 = r2 + 1
            r11.add(r2, r6)     // Catch:{ ClassNotFoundException -> 0x0067, Exception -> 0x0069 }
            java.lang.String r2 = "Loaded LibopusAudioRenderer."
            com.google.android.exoplayer2.util.k.b(r12, r2)     // Catch:{ ClassNotFoundException -> 0x0067, Exception -> 0x0069 }
            goto L_0x0073
        L_0x0067:
            r2 = r7
            goto L_0x0072
        L_0x0069:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0072:
            r7 = r2
        L_0x0073:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r6[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            java.lang.Class<com.google.android.exoplayer2.audio.f> r8 = com.google.android.exoplayer2.audio.f.class
            r6[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioProcessor[]> r8 = com.google.android.exoplayer2.audio.AudioProcessor[].class
            r6[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            r6[r0] = r22     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            r6[r5] = r23     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            r6[r3] = r1     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            com.google.android.exoplayer2.z r2 = (com.google.android.exoplayer2.z) r2     // Catch:{ ClassNotFoundException -> 0x00af, Exception -> 0x00a6 }
            int r6 = r7 + 1
            r11.add(r7, r2)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x00a6 }
            java.lang.String r2 = "Loaded LibflacAudioRenderer."
            com.google.android.exoplayer2.util.k.b(r12, r2)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x00a6 }
            goto L_0x00b0
        L_0x00a4:
            r7 = r6
            goto L_0x00af
        L_0x00a6:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00af:
            r6 = r7
        L_0x00b0:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            java.lang.Class<com.google.android.exoplayer2.audio.f> r8 = com.google.android.exoplayer2.audio.f.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioProcessor[]> r8 = com.google.android.exoplayer2.audio.AudioProcessor[].class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            r4[r0] = r22     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            r4[r5] = r23     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            r4[r3] = r1     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            java.lang.Object r0 = r2.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            com.google.android.exoplayer2.z r0 = (com.google.android.exoplayer2.z) r0     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            r11.add(r6, r0)     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            com.google.android.exoplayer2.util.k.b(r12, r0)     // Catch:{ ClassNotFoundException -> 0x00e8, Exception -> 0x00df }
            goto L_0x00e8
        L_0x00df:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.a(android.content.Context, int, com.google.android.exoplayer2.mediacodec.b, com.google.android.exoplayer2.drm.b, boolean, boolean, com.google.android.exoplayer2.audio.AudioProcessor[], android.os.Handler, com.google.android.exoplayer2.audio.f, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void a(Context context, int i2, ArrayList<z> arrayList) {
        arrayList.add(new ge.b());
    }

    /* access modifiers changed from: protected */
    public void a(Context context, Handler handler, int i2, ArrayList<z> arrayList) {
    }

    /* access modifiers changed from: protected */
    public void a(Context context, d dVar, Looper looper, int i2, ArrayList<z> arrayList) {
        arrayList.add(new e(dVar, looper));
    }

    /* access modifiers changed from: protected */
    public void a(Context context, com.google.android.exoplayer2.text.j jVar, Looper looper, int i2, ArrayList<z> arrayList) {
        arrayList.add(new k(jVar, looper));
    }

    /* access modifiers changed from: protected */
    public AudioProcessor[] a() {
        return new AudioProcessor[0];
    }

    public z[] a(Handler handler, com.google.android.exoplayer2.video.j jVar, com.google.android.exoplayer2.audio.f fVar, com.google.android.exoplayer2.text.j jVar2, d dVar, b<f> bVar) {
        b<f> bVar2 = bVar == null ? this.f15688b : bVar;
        ArrayList arrayList = new ArrayList();
        b<f> bVar3 = bVar2;
        a(this.f15687a, this.f15689c, this.f15693g, bVar3, this.f15691e, this.f15692f, handler, jVar, this.f15690d, (ArrayList<z>) arrayList);
        a(this.f15687a, this.f15689c, this.f15693g, bVar3, this.f15691e, this.f15692f, a(), handler, fVar, (ArrayList<z>) arrayList);
        ArrayList arrayList2 = arrayList;
        a(this.f15687a, jVar2, handler.getLooper(), this.f15689c, (ArrayList<z>) arrayList2);
        a(this.f15687a, dVar, handler.getLooper(), this.f15689c, (ArrayList<z>) arrayList2);
        a(this.f15687a, this.f15689c, arrayList);
        a(this.f15687a, handler, this.f15689c, arrayList);
        return (z[]) arrayList.toArray(new z[0]);
    }
}
