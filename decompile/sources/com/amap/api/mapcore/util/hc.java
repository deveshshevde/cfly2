package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.mapcore.util.hd;
import com.amap.api.mapcore.util.ic;
import com.amap.api.maps.AMapException;
import java.util.Map;

public final class hc extends gw {

    /* renamed from: f  reason: collision with root package name */
    private static hc f9082f;

    /* renamed from: g  reason: collision with root package name */
    private id f9083g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f9084h;

    static class a extends Handler {
        public a() {
        }

        private a(Looper looper) {
            super(looper);
        }

        /* synthetic */ a(Looper looper, byte b2) {
            this(looper);
        }

        public final void handleMessage(Message message) {
            try {
                int i2 = message.what;
                if (i2 == 0) {
                    Object obj = message.obj;
                } else if (i2 == 1) {
                    Object obj2 = message.obj;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private hc(boolean z2) {
        if (z2) {
            try {
                this.f9083g = id.a(new ic.a().a("amap-netmanger-threadpool-%d").b());
            } catch (Throwable th) {
                fz.c(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f9084h = new a(Looper.getMainLooper(), (byte) 0);
        } else {
            this.f9084h = new a();
        }
    }

    private static synchronized hc a(boolean z2) {
        hc hcVar;
        synchronized (hc.class) {
            try {
                hc hcVar2 = f9082f;
                if (hcVar2 == null) {
                    f9082f = new hc(z2);
                } else if (z2 && hcVar2.f9083g == null) {
                    hcVar2.f9083g = id.a(new ic.a().a("amap-netmanger-threadpool-%d").b());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            hcVar = f9082f;
        }
        return hcVar;
    }

    private static Map<String, String> a(hd hdVar, hd.b bVar, int i2) throws eu {
        try {
            e(hdVar);
            hdVar.setDegradeType(bVar);
            hdVar.setReal_max_timeout(i2);
            return new ha().a(hdVar);
        } catch (eu e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new eu(AMapException.ERROR_UNKNOWN);
        }
    }

    public static hc b() {
        return a(true);
    }

    private static he b(hd hdVar, hd.b bVar, int i2) throws eu {
        try {
            e(hdVar);
            hdVar.setDegradeType(bVar);
            hdVar.setReal_max_timeout(i2);
            return new ha().b(hdVar);
        } catch (eu e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new eu(AMapException.ERROR_UNKNOWN);
        }
    }

    public static hc c() {
        return a(false);
    }

    @Deprecated
    public static Map<String, String> e(hd hdVar, boolean z2) throws eu {
        e(hdVar);
        hdVar.setHttpProtocol(z2 ? hd.c.HTTPS : hd.c.HTTP);
        Map<String, String> map = null;
        long j2 = 0;
        boolean z3 = false;
        if (c(hdVar)) {
            boolean d2 = d(hdVar);
            try {
                j2 = SystemClock.elapsedRealtime();
                map = a(hdVar, b(hdVar, d2), d(hdVar, d2));
            } catch (eu e2) {
                if (d2) {
                    z3 = true;
                } else {
                    throw e2;
                }
            }
        }
        if (map != null) {
            return map;
        }
        try {
            return a(hdVar, c(hdVar, z3), a(hdVar, j2));
        } catch (eu e3) {
            throw e3;
        }
    }

    public static he f(hd hdVar) throws eu {
        return f(hdVar, hdVar.isHttps());
    }

    @Deprecated
    private static he f(hd hdVar, boolean z2) throws eu {
        e(hdVar);
        hdVar.setHttpProtocol(z2 ? hd.c.HTTPS : hd.c.HTTP);
        he heVar = null;
        long j2 = 0;
        boolean z3 = false;
        if (c(hdVar)) {
            boolean d2 = d(hdVar);
            try {
                j2 = SystemClock.elapsedRealtime();
                heVar = b(hdVar, b(hdVar, d2), d(hdVar, d2));
            } catch (eu e2) {
                if (e2.f() == 21 && hdVar.getDegradeAbility() == hd.a.INTERRUPT_IO) {
                    throw e2;
                } else if (d2) {
                    z3 = true;
                } else {
                    throw e2;
                }
            }
        }
        if (heVar != null && heVar.f9117a != null && heVar.f9117a.length > 0) {
            return heVar;
        }
        try {
            return b(hdVar, c(hdVar, z3), a(hdVar, j2));
        } catch (eu e3) {
            throw e3;
        }
    }

    @Deprecated
    public final byte[] a(hd hdVar) throws eu {
        try {
            he a2 = a(hdVar, false);
            if (a2 != null) {
                return a2.f9117a;
            }
            return null;
        } catch (eu e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            fz.e().b(th, "NetManager", "makeSyncPostRequest");
            throw new eu(AMapException.ERROR_UNKNOWN);
        }
    }
}
