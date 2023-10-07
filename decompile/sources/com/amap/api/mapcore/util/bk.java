package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.ew;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

public abstract class bk<T, V> {

    /* renamed from: a  reason: collision with root package name */
    protected T f8079a;

    /* renamed from: b  reason: collision with root package name */
    protected int f8080b = 3;

    /* renamed from: c  reason: collision with root package name */
    protected Context f8081c;

    public bk(Context context, T t2) {
        a(context, t2);
    }

    private void a(Context context, T t2) {
        this.f8081c = context;
        this.f8079a = t2;
    }

    private V d() throws AMapException {
        int i2 = 0;
        V v2 = null;
        ew.a aVar = null;
        while (i2 < this.f8080b) {
            try {
                aVar = ew.a(this.f8081c, dl.a(), a(), b());
                v2 = a(a(aVar));
                i2 = this.f8080b;
            } catch (Throwable th) {
                fz.c(th, "AbstractProtocalHandler", "getDataMayThrow AMapException");
                th.printStackTrace();
                i2++;
                if (i2 < this.f8080b) {
                    continue;
                } else if (aVar == null || aVar.f8643c == null) {
                    v2 = null;
                } else {
                    throw new AMapException(aVar.f8643c);
                }
            }
        }
        return v2;
    }

    /* access modifiers changed from: protected */
    public abstract V a(JSONObject jSONObject) throws AMapException;

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract JSONObject a(ew.a aVar);

    /* access modifiers changed from: protected */
    public abstract Map<String, String> b();

    public final V c() throws AMapException {
        if (this.f8079a != null) {
            return d();
        }
        return null;
    }
}
