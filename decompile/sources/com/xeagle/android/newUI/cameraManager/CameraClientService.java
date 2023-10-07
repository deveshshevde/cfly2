package com.xeagle.android.newUI.cameraManager;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.retrofitLogin.sochip.SochipContract;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.newUI.cameraManager.a;
import java.lang.ref.WeakReference;

public class CameraClientService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f23961a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final String f23962b = "CameraClientService";

    /* renamed from: c  reason: collision with root package name */
    private final a f23963c = new a(this);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f23964d;

    public static class a extends Binder {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<CameraClientService> f23965a;

        public a(CameraClientService cameraClientService) {
            this.f23965a = new WeakReference<>(cameraClientService);
        }

        public a a() {
            CameraClientService cameraClientService = (CameraClientService) this.f23965a.get();
            if (cameraClientService == null || cameraClientService.f23964d == null) {
                return null;
            }
            return cameraClientService.f23964d;
        }

        public void a(int i2, DroneInterfaces.b bVar, IChannelListener iChannelListener, SochipContract.loadView loadview, SochipPresenter.SochipTcpListener sochipTcpListener) {
            CameraClientService cameraClientService = (CameraClientService) this.f23965a.get();
            if (cameraClientService != null) {
                if (i2 == 1) {
                    cameraClientService.a(bVar, iChannelListener);
                } else if (i2 == 2) {
                    cameraClientService.a(bVar, sochipTcpListener, loadview);
                }
            }
        }

        public void a(String str) {
            CameraClientService cameraClientService = (CameraClientService) this.f23965a.get();
            if (cameraClientService != null && cameraClientService.f23964d != null) {
                cameraClientService.f23964d.removeTcpConnectionListener(str);
            }
        }

        public void a(String str, a.b bVar) {
            CameraClientService cameraClientService = (CameraClientService) this.f23965a.get();
            if (cameraClientService != null && cameraClientService.f23964d != null) {
                cameraClientService.f23964d.addTcpConnectionStatusListener(str, bVar);
            }
        }

        public int b() {
            CameraClientService cameraClientService = (CameraClientService) this.f23965a.get();
            if (cameraClientService == null || cameraClientService.f23964d == null) {
                return 0;
            }
            return cameraClientService.f23964d.getConnectionStatus();
        }

        public void c() {
            CameraClientService cameraClientService = (CameraClientService) this.f23965a.get();
            if (cameraClientService != null) {
                cameraClientService.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        a aVar = this.f23964d;
        if (aVar != null) {
            aVar.disconnect();
        }
    }

    /* access modifiers changed from: private */
    public void a(DroneInterfaces.b bVar, IChannelListener iChannelListener) {
        AmbaClient a2 = AmbaClient.a(getApplicationContext(), bVar, iChannelListener);
        this.f23964d = a2;
        if (a2.getConnectionStatus() == 0) {
            this.f23964d.connect(3);
        }
    }

    /* access modifiers changed from: private */
    public void a(DroneInterfaces.b bVar, SochipPresenter.SochipTcpListener sochipTcpListener, SochipContract.loadView loadview) {
        SochipPresenter sochipPresenter = new SochipPresenter(getApplicationContext(), bVar);
        this.f23964d = sochipPresenter;
        sochipPresenter.setSochipListener(sochipTcpListener);
        ((SochipPresenter) this.f23964d).setlLoadView(loadview);
        if (!f23961a && this.f23964d == null) {
            throw new AssertionError();
        } else if (this.f23964d.getConnectionStatus() == 0) {
            this.f23964d.connect(1);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f23963c;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        a();
    }
}
