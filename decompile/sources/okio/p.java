package okio;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

final class p {

    /* renamed from: a  reason: collision with root package name */
    static o f32472a;

    /* renamed from: b  reason: collision with root package name */
    static long f32473b;

    private p() {
    }

    static o a() {
        synchronized (p.class) {
            o oVar = f32472a;
            if (oVar == null) {
                return new o();
            }
            f32472a = oVar.f32470f;
            oVar.f32470f = null;
            f32473b -= IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
            return oVar;
        }
    }

    static void a(o oVar) {
        if (oVar.f32470f != null || oVar.f32471g != null) {
            throw new IllegalArgumentException();
        } else if (!oVar.f32468d) {
            synchronized (p.class) {
                long j2 = f32473b;
                if (j2 + IjkMediaMeta.AV_CH_TOP_FRONT_CENTER <= IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                    f32473b = j2 + IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
                    oVar.f32470f = f32472a;
                    oVar.f32467c = 0;
                    oVar.f32466b = 0;
                    f32472a = oVar;
                }
            }
        }
    }
}
