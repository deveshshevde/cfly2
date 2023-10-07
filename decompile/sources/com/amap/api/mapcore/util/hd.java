package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.amap.api.mapcore.util.gw;
import java.net.Proxy;
import java.util.Map;

public abstract class hd {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;

    /* renamed from: a  reason: collision with root package name */
    int f9085a = 20000;

    /* renamed from: b  reason: collision with root package name */
    int f9086b = 20000;

    /* renamed from: c  reason: collision with root package name */
    Proxy f9087c = null;

    /* renamed from: d  reason: collision with root package name */
    gw.a f9088d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9089e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f9090f = 20000;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9091g = true;

    /* renamed from: h  reason: collision with root package name */
    private String f9092h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9093i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9094j;

    /* renamed from: k  reason: collision with root package name */
    private a f9095k = a.NORMAL;

    /* renamed from: l  reason: collision with root package name */
    private b f9096l = b.FIRST_NONDEGRADE;

    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);
        

        /* renamed from: f  reason: collision with root package name */
        private int f9103f;

        private a(int i2) {
            this.f9103f = i2;
        }
    }

    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);
        

        /* renamed from: h  reason: collision with root package name */
        private int f9112h;

        private b(int i2) {
            this.f9112h = i2;
        }

        public final int a() {
            return this.f9112h;
        }

        public final boolean b() {
            int i2 = this.f9112h;
            return i2 == FIRST_NONDEGRADE.f9112h || i2 == NEVER_GRADE.f9112h || i2 == FIX_NONDEGRADE.f9112h;
        }

        public final boolean c() {
            int i2 = this.f9112h;
            return i2 == DEGRADE_BYERROR.f9112h || i2 == DEGRADE_ONLY.f9112h || i2 == FIX_DEGRADE_BYERROR.f9112h || i2 == FIX_DEGRADE_ONLY.f9112h;
        }

        public final boolean d() {
            int i2 = this.f9112h;
            return i2 == DEGRADE_BYERROR.f9112h || i2 == FIX_DEGRADE_BYERROR.f9112h;
        }

        public final boolean e() {
            return this.f9112h == NEVER_GRADE.f9112h;
        }
    }

    public enum c {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: c  reason: collision with root package name */
        private int f9116c;

        private c(int i2) {
            this.f9116c = i2;
        }
    }

    private String a(String str) {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0) {
            return str;
        }
        Map params = getParams();
        if (gw.f8985e != null) {
            if (params != null) {
                params.putAll(gw.f8985e);
            } else {
                params = gw.f8985e;
            }
        }
        if (params == null) {
            return str;
        }
        String a2 = ha.a((Map<String, String>) params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(a2);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return a(getURL());
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return a(getIPV6URL());
    }

    public int getConntectionTimeout() {
        return this.f9085a;
    }

    /* access modifiers changed from: protected */
    public a getDegradeAbility() {
        return this.f9095k;
    }

    /* access modifiers changed from: protected */
    public b getDegradeType() {
        return this.f9096l;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getIPDNSName() {
        return "";
    }

    public String getIPV6URL() {
        return getURL();
    }

    /* access modifiers changed from: protected */
    public String getNon_degrade_final_Host() {
        return this.f9092h;
    }

    public abstract Map<String, String> getParams();

    public Proxy getProxy() {
        return this.f9087c;
    }

    /* access modifiers changed from: protected */
    public int getReal_max_timeout() {
        return this.f9090f;
    }

    public abstract Map<String, String> getRequestHead();

    public String getSDKName() {
        return "";
    }

    public int getSoTimeout() {
        return this.f9086b;
    }

    public abstract String getURL();

    public gw.a getUrlConnectionImpl() {
        return this.f9088d;
    }

    /* access modifiers changed from: protected */
    public boolean isBinary() {
        return this.f9089e;
    }

    /* access modifiers changed from: protected */
    public boolean isHostToIP() {
        return this.f9091g;
    }

    /* access modifiers changed from: protected */
    public boolean isHttps() {
        return this.f9094j;
    }

    /* access modifiers changed from: protected */
    public boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    /* access modifiers changed from: protected */
    public boolean isIPV6Request() {
        return this.f9093i;
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    /* access modifiers changed from: protected */
    public String parseSDKNameFromPlatInfo(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i2 = 0;
                    String str4 = str3;
                    while (true) {
                        if (i2 >= length) {
                            str2 = str3;
                            break;
                        }
                        str2 = split[i2];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i2++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(fv.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    fv.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            fw.a(th, "ht", "pnfp");
        }
        return str3;
    }

    /* access modifiers changed from: protected */
    public String parseSdkNameFromHeader(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return parseSDKNameFromPlatInfo(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            fw.a(th, "ht", "pnfh");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String parseSdkNameFromRequest() {
        String str;
        try {
            str = getSDKName();
            try {
                return TextUtils.isEmpty(str) ? this.f9089e ? parseSDKNameFromPlatInfo(((gx) this).g()) : parseSdkNameFromHeader(getRequestHead()) : str;
            } catch (Throwable th) {
                th = th;
                fw.a(th, "ht", "pnfr");
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
            fw.a(th, "ht", "pnfr");
            return str;
        }
    }

    public void setBinary(boolean z2) {
        this.f9089e = z2;
    }

    public final void setConnectionTimeout(int i2) {
        this.f9085a = i2;
    }

    public void setDegradeAbility(a aVar) {
        this.f9095k = aVar;
    }

    public void setDegradeType(b bVar) {
        this.f9096l = bVar;
    }

    public void setHostToIP(boolean z2) {
        this.f9091g = z2;
    }

    public void setHttpProtocol(c cVar) {
        this.f9094j = cVar == c.HTTPS;
    }

    public void setIPV6Request(boolean z2) {
        this.f9093i = z2;
    }

    public void setNon_degrade_final_Host(String str) {
        this.f9092h = str;
    }

    public final void setProxy(Proxy proxy) {
        this.f9087c = proxy;
    }

    public void setReal_max_timeout(int i2) {
        this.f9090f = i2;
    }

    public final void setSoTimeout(int i2) {
        this.f9086b = i2;
    }

    public void setUrlConnectionImpl(gw.a aVar) {
        this.f9088d = aVar;
    }
}
