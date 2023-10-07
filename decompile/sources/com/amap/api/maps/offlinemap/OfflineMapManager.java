package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.mapcore.util.al;
import com.amap.api.mapcore.util.am;
import com.amap.api.mapcore.util.aq;
import com.amap.api.mapcore.util.di;
import com.amap.api.mapcore.util.dl;
import com.amap.api.mapcore.util.fb;
import com.amap.api.mapcore.util.fz;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;

public final class OfflineMapManager {

    /* renamed from: a  reason: collision with root package name */
    aq f9803a;

    /* renamed from: b  reason: collision with root package name */
    am f9804b;

    /* renamed from: c  reason: collision with root package name */
    private Context f9805c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public OfflineMapDownloadListener f9806d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public OfflineLoadedListener f9807e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Handler f9808f = new Handler(this.f9805c.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    private Handler f9809g = new Handler(this.f9805c.getMainLooper());

    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z2, String str);

        void onDownload(int i2, int i3, String str);

        void onRemove(boolean z2, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        this.f9806d = offlineMapDownloadListener;
        this.f9805c = context.getApplicationContext();
        a(context);
        fb.a().a(this.f9805c);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.f9806d = offlineMapDownloadListener;
        this.f9805c = context.getApplicationContext();
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() throws AMapException {
        if (!dl.d(this.f9805c)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    private void a(Context context) {
        this.f9805c = context.getApplicationContext();
        am.f7831b = false;
        am a2 = am.a(this.f9805c);
        this.f9804b = a2;
        a2.a((am.a) new am.a() {
            public final void a() {
                if (OfflineMapManager.this.f9807e != null) {
                    OfflineMapManager.this.f9808f.post(new Runnable() {
                        public final void run() {
                            try {
                                OfflineMapManager.this.f9807e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            public final void a(final al alVar) {
                if (OfflineMapManager.this.f9806d != null && alVar != null) {
                    OfflineMapManager.this.f9808f.post(new Runnable() {
                        public final void run() {
                            try {
                                OfflineMapManager.this.f9806d.onDownload(alVar.c().b(), alVar.getcompleteCode(), alVar.getCity());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            public final void b(final al alVar) {
                if (OfflineMapManager.this.f9806d != null && alVar != null) {
                    OfflineMapManager.this.f9808f.post(new Runnable() {
                        public final void run() {
                            try {
                                if (!alVar.c().equals(alVar.f7815g)) {
                                    if (!alVar.c().equals(alVar.f7809a)) {
                                        OfflineMapManager.this.f9806d.onCheckUpdate(false, alVar.getCity());
                                        return;
                                    }
                                }
                                OfflineMapManager.this.f9806d.onCheckUpdate(true, alVar.getCity());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            public final void c(final al alVar) {
                if (OfflineMapManager.this.f9806d != null && alVar != null) {
                    OfflineMapManager.this.f9808f.post(new Runnable() {
                        public final void run() {
                            try {
                                if (alVar.c().equals(alVar.f7809a)) {
                                    OfflineMapManager.this.f9806d.onRemove(true, alVar.getCity(), "");
                                } else {
                                    OfflineMapManager.this.f9806d.onRemove(false, alVar.getCity(), "");
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.f9804b.a();
            this.f9803a = this.f9804b.f7836f;
            di.b(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String str) throws AMapException {
        this.f9804b.a(str);
    }

    private void b() {
        this.f9806d = null;
    }

    public final void destroy() {
        try {
            am amVar = this.f9804b;
            if (amVar != null) {
                amVar.f();
            }
            b();
            Handler handler = this.f9808f;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.f9808f = null;
            Handler handler2 = this.f9809g;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages((Object) null);
            }
            this.f9809g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(String str) throws AMapException {
        try {
            this.f9804b.e(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(String str) throws AMapException {
        try {
            this.f9804b.d(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByProvinceName(String str) throws AMapException {
        try {
            a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName != null) {
                Iterator<OfflineMapCity> it2 = itemByProvinceName.getCityList().iterator();
                while (it2.hasNext()) {
                    final String city = it2.next().getCity();
                    this.f9809g.post(new Runnable() {
                        public final void run() {
                            try {
                                OfflineMapManager.this.f9804b.d(city);
                            } catch (AMapException e2) {
                                fz.c(e2, "OfflineMapManager", "downloadByProvinceName");
                            }
                        }
                    });
                }
                return;
            }
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        } catch (Throwable th) {
            if (!(th instanceof AMapException)) {
                fz.c(th, "OfflineMapManager", "downloadByProvinceName");
                return;
            }
            throw th;
        }
    }

    public final ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.f9803a.c();
    }

    public final ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.f9803a.d();
    }

    public final ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.f9803a.e();
    }

    public final ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.f9803a.f();
    }

    public final OfflineMapCity getItemByCityCode(String str) {
        return this.f9803a.a(str);
    }

    public final OfflineMapCity getItemByCityName(String str) {
        return this.f9803a.b(str);
    }

    public final OfflineMapProvince getItemByProvinceName(String str) {
        return this.f9803a.c(str);
    }

    public final ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.f9803a.b();
    }

    public final ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f9803a.a();
    }

    public final void pause() {
        this.f9804b.e();
    }

    public final void remove(String str) {
        try {
            if (this.f9804b.b(str)) {
                this.f9804b.c(str);
                return;
            }
            OfflineMapProvince c2 = this.f9803a.c(str);
            if (c2 != null) {
                if (c2.getCityList() != null) {
                    Iterator<OfflineMapCity> it2 = c2.getCityList().iterator();
                    while (it2.hasNext()) {
                        final String city = it2.next().getCity();
                        this.f9809g.post(new Runnable() {
                            public final void run() {
                                OfflineMapManager.this.f9804b.c(city);
                            }
                        });
                    }
                    return;
                }
            }
            OfflineMapDownloadListener offlineMapDownloadListener = this.f9806d;
            if (offlineMapDownloadListener != null) {
                offlineMapDownloadListener.onRemove(false, str, "没有该城市");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void restart() {
    }

    public final void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.f9807e = offlineLoadedListener;
    }

    public final void stop() {
        this.f9804b.d();
    }

    public final void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        a(itemByCityCode.getCity());
    }

    public final void updateOfflineCityByName(String str) throws AMapException {
        a(str);
    }

    public final void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str);
    }
}
