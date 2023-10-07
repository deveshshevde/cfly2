package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.xeagle.android.login.pickImage.Constants;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import java.util.ArrayList;
import java.util.Iterator;

public final class iw implements Inner_3dMap_locationManagerBase {

    /* renamed from: a  reason: collision with root package name */
    Context f9367a = null;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<Inner_3dMap_locationListener> f9368b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    Object f9369c = new Object();

    /* renamed from: d  reason: collision with root package name */
    Handler f9370d = null;

    /* renamed from: e  reason: collision with root package name */
    a f9371e = null;

    /* renamed from: f  reason: collision with root package name */
    Handler f9372f = null;

    /* renamed from: g  reason: collision with root package name */
    Inner_3dMap_locationOption f9373g = new Inner_3dMap_locationOption();

    /* renamed from: h  reason: collision with root package name */
    ja f9374h = null;

    /* renamed from: i  reason: collision with root package name */
    Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode f9375i = Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy;

    /* renamed from: j  reason: collision with root package name */
    boolean f9376j = false;

    static class a extends HandlerThread {

        /* renamed from: a  reason: collision with root package name */
        iw f9377a;

        public a(String str, iw iwVar) {
            super(str);
            this.f9377a = iwVar;
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                this.f9377a.f9374h = new ja(this.f9377a.f9367a, this.f9377a.f9370d);
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public iw(Context context) {
        if (context != null) {
            this.f9367a = context.getApplicationContext();
            e();
            return;
        }
        throw new IllegalArgumentException("Context参数不能为null");
    }

    private Handler a(Looper looper) {
        ix ixVar;
        synchronized (this.f9369c) {
            ixVar = new ix(looper, this);
            this.f9372f = ixVar;
        }
        return ixVar;
    }

    private void a(int i2) {
        synchronized (this.f9369c) {
            Handler handler = this.f9372f;
            if (handler != null) {
                handler.removeMessages(i2);
            }
        }
    }

    private void a(int i2, Object obj, long j2) {
        synchronized (this.f9369c) {
            if (this.f9372f != null) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = obj;
                this.f9372f.sendMessageDelayed(obtain, j2);
            }
        }
    }

    private void e() {
        try {
            this.f9370d = Looper.myLooper() == null ? new iy(this.f9367a.getMainLooper(), this) : new iy(this);
        } catch (Throwable th) {
            io.a(th, "MapLocationManager", "initResultHandler");
        }
        try {
            a aVar = new a("locaitonClientActionThread", this);
            this.f9371e = aVar;
            aVar.setPriority(5);
            this.f9371e.start();
            this.f9372f = a(this.f9371e.getLooper());
        } catch (Throwable th2) {
            io.a(th2, "MapLocationManager", "initActionThreadAndActionHandler");
        }
    }

    private void f() {
        synchronized (this.f9369c) {
            Handler handler = this.f9372f;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.f9372f = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            if (!this.f9376j) {
                this.f9376j = true;
                a(1005, (Object) null, 0);
            }
        } catch (Throwable th) {
            io.a(th, "MapLocationManager", "doStartLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Inner_3dMap_location inner_3dMap_location) {
        if (inner_3dMap_location != null) {
            try {
                if (jd.a(inner_3dMap_location)) {
                    iu.f9359a = inner_3dMap_location;
                }
            } catch (Throwable th) {
                io.a(th, "MapLocationManager", "callBackLocation");
                return;
            }
        }
        if (this.f9376j) {
            if (!"gps".equalsIgnoreCase(inner_3dMap_location.getProvider())) {
                inner_3dMap_location.setProvider("lbs");
            }
            inner_3dMap_location.setAltitude(is.b(inner_3dMap_location.getAltitude()));
            inner_3dMap_location.setBearing(is.a(inner_3dMap_location.getBearing()));
            inner_3dMap_location.setSpeed(is.a(inner_3dMap_location.getSpeed()));
            Iterator<Inner_3dMap_locationListener> it2 = this.f9368b.iterator();
            while (it2.hasNext()) {
                try {
                    it2.next().onLocationChanged(inner_3dMap_location);
                } catch (Throwable unused) {
                }
            }
        }
        if (this.f9373g.isOnceLocation()) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (this.f9368b == null) {
                    this.f9368b = new ArrayList<>();
                }
                if (!this.f9368b.contains(inner_3dMap_locationListener)) {
                    this.f9368b.add(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                io.a(th, "MapLocationManager", "doSetLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.f9373g = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.f9373g = new Inner_3dMap_locationOption();
        }
        ja jaVar = this.f9374h;
        if (jaVar != null) {
            jaVar.a(this.f9373g);
        }
        if (this.f9376j && !this.f9375i.equals(inner_3dMap_locationOption.getLocationMode())) {
            c();
            a();
        }
        this.f9375i = this.f9373g.getLocationMode();
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        long j2 = 1000;
        try {
            ja jaVar = this.f9374h;
            if (jaVar != null) {
                jaVar.a();
            }
            if (!this.f9373g.isOnceLocation()) {
                if (this.f9373g.getInterval() >= 1000) {
                    j2 = this.f9373g.getInterval();
                }
                a(1005, (Object) null, j2);
            }
        } catch (Throwable th) {
            if (!this.f9373g.isOnceLocation()) {
                if (this.f9373g.getInterval() >= 1000) {
                    j2 = this.f9373g.getInterval();
                }
                a(1005, (Object) null, j2);
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (!this.f9368b.isEmpty() && this.f9368b.contains(inner_3dMap_locationListener)) {
                    this.f9368b.remove(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                io.a(th, "MapLocationManager", "doUnregisterListener");
                return;
            }
        }
        if (this.f9368b.isEmpty()) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        try {
            this.f9376j = false;
            a((int) CameraGlobal.SET_VIDEO_EXPROTION);
            a(1005);
            ja jaVar = this.f9374h;
            if (jaVar != null) {
                jaVar.c();
            }
        } catch (Throwable th) {
            io.a(th, "MapLocationManager", "doStopLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        c();
        ja jaVar = this.f9374h;
        if (jaVar != null) {
            jaVar.d();
        }
        ArrayList<Inner_3dMap_locationListener> arrayList = this.f9368b;
        if (arrayList != null) {
            arrayList.clear();
            this.f9368b = null;
        }
        f();
        if (this.f9371e != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    iq.a((Object) this.f9371e, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                }
            }
            this.f9371e.quit();
        }
        this.f9371e = null;
        Handler handler = this.f9370d;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f9370d = null;
        }
    }

    public final void destroy() {
        try {
            a(Constants.RESULT_CODE_CHOOSE_VIDEO, (Object) null, 0);
        } catch (Throwable th) {
            io.a(th, "MapLocationManager", "stopLocation");
        }
    }

    public final Inner_3dMap_location getLastKnownLocation() {
        return iu.f9359a;
    }

    public final void setLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1002, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            io.a(th, "MapLocationManager", "setLocationListener");
        }
    }

    public final void setLocationOption(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        try {
            a(1001, inner_3dMap_locationOption, 0);
        } catch (Throwable th) {
            io.a(th, "LocationClientManager", "setLocationOption");
        }
    }

    public final void startLocation() {
        try {
            a(CameraGlobal.SET_VIDEO_EXPROTION, (Object) null, 0);
        } catch (Throwable th) {
            io.a(th, "MapLocationManager", "startLocation");
        }
    }

    public final void stopLocation() {
        try {
            a(Constants.RESULT_CODE_RECORD_VIDEO, (Object) null, 0);
        } catch (Throwable th) {
            io.a(th, "MapLocationManager", "stopLocation");
        }
    }

    public final void unRegisterLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1003, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            io.a(th, "MapLocationManager", "stopLocation");
        }
    }
}
