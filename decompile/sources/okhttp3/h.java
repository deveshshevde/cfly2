package okhttp3;

import com.xeagle.android.login.amba.connectivity.IChannelListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class h {
    public static final h A = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final h B = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final h C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final h D = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final h E = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final h F = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final h G = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final h H = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final h I = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final h J = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final h K = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final h L = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final h M = a("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final h N = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final h O = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final h P = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final h Q = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final h R = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final h S = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final h T = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final h U = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final h V = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final h W = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final h X = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final h Y = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", (int) IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL);
    public static final h Z = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", (int) IChannelListener.CMD_CHANNEL_NO_MORE_SPACE);

    /* renamed from: a  reason: collision with root package name */
    static final Comparator<String> f31903a = $$Lambda$h$VcoQZDjW1oRdHUWoGWCf6_6hu4M.INSTANCE;
    public static final h aA = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final h aB = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final h aC = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final h aD = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final h aE = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final h aF = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final h aG = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final h aH = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final h aI = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final h aJ = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final h aK = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final h aL = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final h aM = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final h aN = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final h aO = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final h aP = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final h aQ = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final h aR = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final h aS = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final h aT = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final h aU = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final h aV = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final h aW = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final h aX = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final h aY = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final h aZ = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: aa  reason: collision with root package name */
    public static final h f31904aa = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", (int) IChannelListener.CMD_CHANNEL_CARD_PROTECTED);

    /* renamed from: ab  reason: collision with root package name */
    public static final h f31905ab = a("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* renamed from: ac  reason: collision with root package name */
    public static final h f31906ac = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: ad  reason: collision with root package name */
    public static final h f31907ad = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: ae  reason: collision with root package name */
    public static final h f31908ae = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: af  reason: collision with root package name */
    public static final h f31909af = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* renamed from: ag  reason: collision with root package name */
    public static final h f31910ag = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: ah  reason: collision with root package name */
    public static final h f31911ah = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: ai  reason: collision with root package name */
    public static final h f31912ai = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: aj  reason: collision with root package name */
    public static final h f31913aj = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: ak  reason: collision with root package name */
    public static final h f31914ak = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: al  reason: collision with root package name */
    public static final h f31915al = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: am  reason: collision with root package name */
    public static final h f31916am = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: an  reason: collision with root package name */
    public static final h f31917an = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* renamed from: ao  reason: collision with root package name */
    public static final h f31918ao = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* renamed from: ap  reason: collision with root package name */
    public static final h f31919ap = a("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: aq  reason: collision with root package name */
    public static final h f31920aq = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: ar  reason: collision with root package name */
    public static final h f31921ar = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: as  reason: collision with root package name */
    public static final h f31922as = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: at  reason: collision with root package name */
    public static final h f31923at = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: au  reason: collision with root package name */
    public static final h f31924au = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: av  reason: collision with root package name */
    public static final h f31925av = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: aw  reason: collision with root package name */
    public static final h f31926aw = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: ax  reason: collision with root package name */
    public static final h f31927ax = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: ay  reason: collision with root package name */
    public static final h f31928ay = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: az  reason: collision with root package name */
    public static final h f31929az = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: b  reason: collision with root package name */
    public static final h f31930b = a("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: ba  reason: collision with root package name */
    public static final h f31931ba = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: bb  reason: collision with root package name */
    public static final h f31932bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: bc  reason: collision with root package name */
    public static final h f31933bc = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: bd  reason: collision with root package name */
    public static final h f31934bd = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: be  reason: collision with root package name */
    public static final h f31935be = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: bf  reason: collision with root package name */
    public static final h f31936bf = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: bg  reason: collision with root package name */
    public static final h f31937bg = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: bh  reason: collision with root package name */
    public static final h f31938bh = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: bi  reason: collision with root package name */
    public static final h f31939bi = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: bj  reason: collision with root package name */
    public static final h f31940bj = a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* renamed from: bk  reason: collision with root package name */
    public static final h f31941bk = a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: bl  reason: collision with root package name */
    public static final h f31942bl = a("TLS_AES_128_GCM_SHA256", 4865);

    /* renamed from: bm  reason: collision with root package name */
    public static final h f31943bm = a("TLS_AES_256_GCM_SHA384", 4866);

    /* renamed from: bn  reason: collision with root package name */
    public static final h f31944bn = a("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* renamed from: bo  reason: collision with root package name */
    public static final h f31945bo = a("TLS_AES_128_CCM_SHA256", 4868);

    /* renamed from: bp  reason: collision with root package name */
    public static final h f31946bp = a("TLS_AES_128_CCM_8_SHA256", 4869);

    /* renamed from: br  reason: collision with root package name */
    private static final Map<String, h> f31947br = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final h f31948c = a("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final h f31949d = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: e  reason: collision with root package name */
    public static final h f31950e = a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: f  reason: collision with root package name */
    public static final h f31951f = a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: g  reason: collision with root package name */
    public static final h f31952g = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: h  reason: collision with root package name */
    public static final h f31953h = a("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: i  reason: collision with root package name */
    public static final h f31954i = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: j  reason: collision with root package name */
    public static final h f31955j = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: k  reason: collision with root package name */
    public static final h f31956k = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: l  reason: collision with root package name */
    public static final h f31957l = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: m  reason: collision with root package name */
    public static final h f31958m = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: n  reason: collision with root package name */
    public static final h f31959n = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: o  reason: collision with root package name */
    public static final h f31960o = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: p  reason: collision with root package name */
    public static final h f31961p = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: q  reason: collision with root package name */
    public static final h f31962q = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: r  reason: collision with root package name */
    public static final h f31963r = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: s  reason: collision with root package name */
    public static final h f31964s = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: t  reason: collision with root package name */
    public static final h f31965t = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: u  reason: collision with root package name */
    public static final h f31966u = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: v  reason: collision with root package name */
    public static final h f31967v = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: w  reason: collision with root package name */
    public static final h f31968w = a("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: x  reason: collision with root package name */
    public static final h f31969x = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: y  reason: collision with root package name */
    public static final h f31970y = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: z  reason: collision with root package name */
    public static final h f31971z = a("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: bq  reason: collision with root package name */
    final String f31972bq;

    private h(String str) {
        Objects.requireNonNull(str);
        this.f31972bq = str;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(String str, String str2) {
        int min = Math.min(str.length(), str2.length());
        for (int i2 = 4; i2 < min; i2++) {
            char charAt = str.charAt(i2);
            char charAt2 = str2.charAt(i2);
            if (charAt != charAt2) {
                return charAt < charAt2 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }

    static List<h> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a2 : strArr) {
            arrayList.add(a(a2));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static synchronized h a(String str) {
        h hVar;
        synchronized (h.class) {
            Map<String, h> map = f31947br;
            hVar = map.get(str);
            if (hVar == null) {
                hVar = map.get(b(str));
                if (hVar == null) {
                    hVar = new h(str);
                }
                map.put(str, hVar);
            }
        }
        return hVar;
    }

    private static h a(String str, int i2) {
        h hVar = new h(str);
        f31947br.put(str, hVar);
        return hVar;
    }

    private static String b(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        } else if (!str.startsWith("SSL_")) {
            return str;
        } else {
            return "TLS_" + str.substring(4);
        }
    }

    public String toString() {
        return this.f31972bq;
    }
}
