package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

final class u implements IUiSettingsDelegate {

    /* renamed from: a  reason: collision with root package name */
    final Handler f9700a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message != null && u.this.f9701b != null) {
                try {
                    switch (message.what) {
                        case 0:
                            u.this.f9701b.showZoomControlsEnabled(u.this.f9707h);
                            return;
                        case 1:
                            u.this.f9701b.showScaleEnabled(u.this.f9709j);
                            return;
                        case 2:
                            u.this.f9701b.showCompassEnabled(u.this.f9708i);
                            return;
                        case 3:
                            u.this.f9701b.showMyLocationButtonEnabled(u.this.f9705f);
                            return;
                        case 4:
                            u.this.f9701b.showIndoorSwitchControlsEnabled(u.this.f9713n);
                            return;
                        case 5:
                            u.this.f9701b.showLogoEnabled(u.this.f9710k);
                            return;
                        case 6:
                            u.this.f9701b.refreshLogo();
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th) {
                    fz.c(th, "UiSettingsDelegateImp", "handleMessage");
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public IAMapDelegate f9701b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9702c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9703d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9704e = true;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f9705f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9706g = true;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f9707h = true;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f9708i = true;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f9709j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f9710k = true;

    /* renamed from: l  reason: collision with root package name */
    private int f9711l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f9712m = 1;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f9713n = true;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9714o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9715p = false;

    u(IAMapDelegate iAMapDelegate) {
        this.f9701b = iAMapDelegate;
    }

    public final float getLogoMarginRate(int i2) {
        return this.f9701b.getLogoMarginRate(i2);
    }

    public final int getLogoPosition() throws RemoteException {
        return this.f9711l;
    }

    public final int getZoomPosition() throws RemoteException {
        return this.f9712m;
    }

    public final boolean isCompassEnabled() throws RemoteException {
        return this.f9708i;
    }

    public final boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.f9715p;
    }

    public final boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.f9713n;
    }

    public final boolean isLogoEnable() {
        return this.f9710k;
    }

    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.f9705f;
    }

    public final boolean isRotateGesturesEnabled() throws RemoteException {
        return this.f9702c;
    }

    public final boolean isScaleControlsEnabled() throws RemoteException {
        return this.f9709j;
    }

    public final boolean isScrollGesturesEnabled() throws RemoteException {
        return this.f9703d;
    }

    public final boolean isTiltGesturesEnabled() throws RemoteException {
        return this.f9704e;
    }

    public final boolean isZoomControlsEnabled() throws RemoteException {
        return this.f9707h;
    }

    public final boolean isZoomGesturesEnabled() throws RemoteException {
        return this.f9706g;
    }

    public final boolean isZoomInByScreenCenter() {
        return this.f9714o;
    }

    public final void requestRefreshLogo() {
        this.f9700a.obtainMessage(6).sendToTarget();
    }

    public final void setAllGesturesEnabled(boolean z2) throws RemoteException {
        setRotateGesturesEnabled(z2);
        setTiltGesturesEnabled(z2);
        setZoomGesturesEnabled(z2);
        setScrollGesturesEnabled(z2);
    }

    public final void setCompassEnabled(boolean z2) throws RemoteException {
        this.f9708i = z2;
        this.f9700a.obtainMessage(2).sendToTarget();
    }

    public final void setGestureScaleByMapCenter(boolean z2) throws RemoteException {
        this.f9715p = z2;
    }

    public final void setIndoorSwitchEnabled(boolean z2) throws RemoteException {
        this.f9713n = z2;
        this.f9700a.obtainMessage(4).sendToTarget();
    }

    public final void setLogoBottomMargin(int i2) {
        this.f9701b.setLogoBottomMargin(i2);
    }

    public final void setLogoEnable(boolean z2) {
        this.f9710k = z2;
        this.f9700a.obtainMessage(5).sendToTarget();
    }

    public final void setLogoLeftMargin(int i2) {
        this.f9701b.setLogoLeftMargin(i2);
    }

    public final void setLogoMarginRate(int i2, float f2) {
        this.f9701b.setLogoMarginRate(i2, f2);
    }

    public final void setLogoPosition(int i2) throws RemoteException {
        this.f9711l = i2;
        this.f9701b.setLogoPosition(i2);
    }

    public final void setMyLocationButtonEnabled(boolean z2) throws RemoteException {
        this.f9705f = z2;
        this.f9700a.obtainMessage(3).sendToTarget();
    }

    public final void setRotateGesturesEnabled(boolean z2) throws RemoteException {
        this.f9702c = z2;
    }

    public final void setScaleControlsEnabled(boolean z2) throws RemoteException {
        this.f9709j = z2;
        this.f9700a.obtainMessage(1).sendToTarget();
    }

    public final void setScrollGesturesEnabled(boolean z2) throws RemoteException {
        this.f9703d = z2;
    }

    public final void setTiltGesturesEnabled(boolean z2) throws RemoteException {
        this.f9704e = z2;
    }

    public final void setZoomControlsEnabled(boolean z2) throws RemoteException {
        this.f9707h = z2;
        this.f9700a.obtainMessage(0).sendToTarget();
    }

    public final void setZoomGesturesEnabled(boolean z2) throws RemoteException {
        this.f9706g = z2;
    }

    public final void setZoomInByScreenCenter(boolean z2) {
        this.f9714o = z2;
    }

    public final void setZoomPosition(int i2) throws RemoteException {
        this.f9712m = i2;
        this.f9701b.setZoomPosition(i2);
    }
}
