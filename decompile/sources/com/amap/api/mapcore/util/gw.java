package com.amap.api.mapcore.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class gw {

    /* renamed from: a  reason: collision with root package name */
    public static int f8981a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static String f8982b = "";

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, String> f8983c;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, String> f8984d;

    /* renamed from: e  reason: collision with root package name */
    public static HashMap<String, String> f8985e;

    /* renamed from: f  reason: collision with root package name */
    private static gw f8986f;

    public interface a {
        URLConnection a();
    }

    public gw() {
        ew.d();
    }

    protected static int a(hd hdVar, long j2) {
        try {
            e(hdVar);
            long j3 = 0;
            if (j2 != 0) {
                j3 = SystemClock.elapsedRealtime() - j2;
            }
            int conntectionTimeout = hdVar.getConntectionTimeout();
            if (hdVar.getDegradeAbility() != hd.a.FIX) {
                if (hdVar.getDegradeAbility() != hd.a.SINGLE) {
                    long j4 = (long) conntectionTimeout;
                    if (j3 < j4) {
                        long j5 = j4 - j3;
                        if (j5 >= 1000) {
                            return (int) j5;
                        }
                    }
                    return Math.min(1000, hdVar.getConntectionTimeout());
                }
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    public static gw a() {
        if (f8986f == null) {
            f8986f = new gw();
        }
        return f8986f;
    }

    private static he a(hd hdVar, hd.b bVar, int i2) throws eu {
        try {
            e(hdVar);
            hdVar.setDegradeType(bVar);
            hdVar.setReal_max_timeout(i2);
            return new ha().c(hdVar);
        } catch (eu e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new eu(AMapException.ERROR_UNKNOWN);
        }
    }

    @Deprecated
    public static he a(hd hdVar, boolean z2) throws eu {
        e(hdVar);
        hdVar.setHttpProtocol(z2 ? hd.c.HTTPS : hd.c.HTTP);
        he heVar = null;
        long j2 = 0;
        boolean z3 = false;
        if (c(hdVar)) {
            boolean d2 = d(hdVar);
            try {
                j2 = SystemClock.elapsedRealtime();
                heVar = a(hdVar, b(hdVar, d2), d(hdVar, d2));
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
            return a(hdVar, c(hdVar, z3), a(hdVar, j2));
        } catch (eu e3) {
            throw e3;
        }
    }

    protected static hd.b b(hd hdVar, boolean z2) {
        return hdVar.getDegradeAbility() == hd.a.FIX ? hd.b.FIX_NONDEGRADE : hdVar.getDegradeAbility() == hd.a.SINGLE ? hd.b.NEVER_GRADE : z2 ? hd.b.FIRST_NONDEGRADE : hd.b.NEVER_GRADE;
    }

    public static he b(hd hdVar) throws eu {
        return a(hdVar, hdVar.isHttps());
    }

    protected static hd.b c(hd hdVar, boolean z2) {
        return hdVar.getDegradeAbility() == hd.a.FIX ? z2 ? hd.b.FIX_DEGRADE_BYERROR : hd.b.FIX_DEGRADE_ONLY : z2 ? hd.b.DEGRADE_BYERROR : hd.b.DEGRADE_ONLY;
    }

    protected static boolean c(hd hdVar) throws eu {
        e(hdVar);
        try {
            String ipv6url = hdVar.getIPV6URL();
            if (TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            String host = new URL(ipv6url).getHost();
            if (!TextUtils.isEmpty(hdVar.getIPDNSName())) {
                host = hdVar.getIPDNSName();
            }
            return ew.d(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    protected static int d(hd hdVar, boolean z2) {
        try {
            e(hdVar);
            int conntectionTimeout = hdVar.getConntectionTimeout();
            int i2 = ew.f8615e;
            return (hdVar.getDegradeAbility() == hd.a.FIX || hdVar.getDegradeAbility() == hd.a.SINGLE || conntectionTimeout < i2 || !z2) ? conntectionTimeout : i2;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    protected static boolean d(hd hdVar) throws eu {
        e(hdVar);
        try {
            if (!c(hdVar)) {
                return true;
            }
            return !hdVar.getURL().equals(hdVar.getIPV6URL()) && hdVar.getDegradeAbility() != hd.a.SINGLE && ew.f8618h;
        } catch (Throwable unused) {
        }
    }

    protected static void e(hd hdVar) throws eu {
        if (hdVar == null) {
            throw new eu("requeust is null");
        } else if (hdVar.getURL() == null || "".equals(hdVar.getURL())) {
            throw new eu("request url is empty");
        }
    }

    @Deprecated
    public byte[] a(hd hdVar) throws eu {
        try {
            he a2 = a(hdVar, false);
            if (a2 != null) {
                return a2.f9117a;
            }
            return null;
        } catch (eu e2) {
            throw e2;
        } catch (Throwable th) {
            fw.a(th, "bm", "msp");
            throw new eu(AMapException.ERROR_UNKNOWN);
        }
    }
}
