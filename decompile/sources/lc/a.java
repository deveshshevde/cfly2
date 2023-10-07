package lc;

import com.xeagle.android.login.gsy.recycleView.VideoModel;
import com.xeagle.android.login.pickImage.data.GLImage;
import kotlin.jvm.internal.h;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class a extends VideoModel {

    /* renamed from: a  reason: collision with root package name */
    private boolean f30748a;

    /* renamed from: b  reason: collision with root package name */
    private String f30749b;

    /* renamed from: c  reason: collision with root package name */
    private String f30750c;

    /* renamed from: d  reason: collision with root package name */
    private String f30751d;

    /* renamed from: e  reason: collision with root package name */
    private String f30752e;

    /* renamed from: f  reason: collision with root package name */
    private int f30753f;

    /* renamed from: g  reason: collision with root package name */
    private int f30754g;

    public a() {
        this(false, (String) null, (String) null, (String) null, (String) null, 0, 0, 127, (f) null);
    }

    public a(boolean z2, String str, String str2, String str3, String str4, int i2, int i3) {
        h.d(str, GLImage.KEY_SIZE);
        h.d(str2, "name");
        h.d(str3, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        this.f30748a = z2;
        this.f30749b = str;
        this.f30750c = str2;
        this.f30751d = str3;
        this.f30752e = str4;
        this.f30753f = i2;
        this.f30754g = i3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(boolean r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, int r13, int r14, kotlin.jvm.internal.f r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = 0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            java.lang.String r1 = ""
            if (r7 == 0) goto L_0x0010
            r2 = r1
            goto L_0x0011
        L_0x0010:
            r2 = r8
        L_0x0011:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0017
            r3 = r1
            goto L_0x0018
        L_0x0017:
            r3 = r9
        L_0x0018:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = r10
        L_0x001e:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0026
            r7 = 0
            r11 = r7
            java.lang.String r11 = (java.lang.String) r11
        L_0x0026:
            r4 = r11
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002e
            r12 = 1
            r5 = 1
            goto L_0x002f
        L_0x002e:
            r5 = r12
        L_0x002f:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0035
            r14 = 0
            goto L_0x0036
        L_0x0035:
            r14 = r13
        L_0x0036:
            r7 = r6
            r8 = r15
            r9 = r2
            r10 = r3
            r11 = r1
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.a.<init>(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, kotlin.jvm.internal.f):void");
    }

    public final void a(int i2) {
        this.f30753f = i2;
    }

    public final void a(String str) {
        h.d(str, "<set-?>");
        this.f30751d = str;
    }

    public final boolean a() {
        return this.f30748a;
    }

    public final String b() {
        return this.f30749b;
    }

    public final void b(int i2) {
        this.f30754g = i2;
    }

    public final String c() {
        return this.f30750c;
    }

    public final String d() {
        return this.f30751d;
    }

    public final int e() {
        return this.f30753f;
    }

    public final int f() {
        return this.f30754g;
    }

    public int hashCode() {
        String str = this.f30750c;
        return str == null ? hashCode() : str.hashCode();
    }
}
