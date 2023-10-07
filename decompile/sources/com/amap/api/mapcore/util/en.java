package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

public abstract class en<T, V> extends cp {

    /* renamed from: e  reason: collision with root package name */
    protected T f8539e;

    /* renamed from: f  reason: collision with root package name */
    protected int f8540f = 1;

    /* renamed from: g  reason: collision with root package name */
    protected Context f8541g;

    /* renamed from: h  reason: collision with root package name */
    protected String f8542h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f8543i = false;

    public en(Context context, T t2) {
        a(context, t2);
    }

    private void a(Context context, T t2) {
        this.f8541g = context;
        this.f8539e = t2;
        this.f8540f = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    private V b(he heVar) throws em {
        return a(heVar);
    }

    private V b(byte[] bArr) throws em {
        return a(bArr);
    }

    private V e() throws em {
        V v2 = null;
        int i2 = 0;
        while (i2 < this.f8540f) {
            try {
                setProxy(fe.a(this.f8541g));
                v2 = this.f8543i ? b(makeHttpRequestNeedHeader()) : b(makeHttpRequest());
                i2 = this.f8540f;
            } catch (eu e2) {
                i2++;
                if (i2 < this.f8540f) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException unused) {
                        if (AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || AMapException.ERROR_SOCKET.equals(e2.getMessage()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                            throw new em("http或socket连接失败 - ConnectionException");
                        }
                        throw new em(e2.a());
                    }
                } else if (AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || AMapException.ERROR_SOCKET.equals(e2.getMessage()) || AMapException.ERROR_UNKNOWN.equals(e2.a()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                    throw new em("http或socket连接失败 - ConnectionException");
                } else {
                    throw new em(e2.a());
                }
            } catch (em e3) {
                i2++;
                if (i2 >= this.f8540f) {
                    throw new em(e3.a());
                }
            } catch (Throwable unused2) {
                throw new em("未知错误");
            }
        }
        return v2;
    }

    /* access modifiers changed from: protected */
    public V a(he heVar) throws em {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws em;

    /* access modifiers changed from: protected */
    public V a(byte[] bArr) throws em {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        ep.a(str);
        return a(str);
    }

    /* access modifiers changed from: protected */
    public abstract String c();

    public final V d() throws em {
        if (this.f8539e == null) {
            return null;
        }
        try {
            return e();
        } catch (em e2) {
            dl.a((Throwable) e2);
            throw e2;
        }
    }

    public Map<String, String> getRequestHead() {
        ff a2 = dl.a();
        String b2 = a2 != null ? a2.b() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", l.f9556c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{b2, "3dmap"}));
        hashtable.put("X-INFO", ey.b(this.f8541g));
        hashtable.put("key", ev.f(this.f8541g));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }
}
