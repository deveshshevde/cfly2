package com.huawei.android.multiscreen.mirror.sdk.api;

import com.huawei.android.multiscreen.mirror.sdk.structs.SDeviceDescription;
import com.huawei.android.multiscreen.mirror.sdk.structs.SMRDescription;
import com.huawei.android.multiscreen.mirror.sdk.structs.SSourceProperty;

public class MRSource extends a {

    /* renamed from: a  reason: collision with root package name */
    private long f20940a;

    public int a() {
        return nativeStart();
    }

    public int a(IMRSourceCallback iMRSourceCallback) {
        return nativeSetCallBack(iMRSourceCallback);
    }

    public int a(SDeviceDescription sDeviceDescription) {
        return nativeConnect(sDeviceDescription);
    }

    public int a(SSourceProperty sSourceProperty) {
        return nativeSetProperty(sSourceProperty);
    }

    /* access modifiers changed from: protected */
    public void a(long j2) {
        this.f20940a = j2;
    }

    public int b() {
        return nativeStop();
    }

    public int c() {
        return nativeDisconnect();
    }

    public EMirrorStatus d() {
        return EMirrorStatus.values()[nativeGetMirrorStatus()];
    }

    public int e() {
        return nativeMute();
    }

    /* access modifiers changed from: protected */
    public native int nativeConnect(SDeviceDescription sDeviceDescription);

    /* access modifiers changed from: protected */
    public native int nativeDisconnect();

    /* access modifiers changed from: protected */
    public native int nativeFinalize();

    /* access modifiers changed from: protected */
    public native int nativeGetAudioStatus();

    /* access modifiers changed from: protected */
    public native SDeviceDescription nativeGetConnectedDevice();

    /* access modifiers changed from: protected */
    public native SMRDescription nativeGetDescription();

    /* access modifiers changed from: protected */
    public native int nativeGetMirrorStatus();

    /* access modifiers changed from: protected */
    public native SSourceProperty nativeGetProperty();

    /* access modifiers changed from: protected */
    public native int nativeGetStatus();

    /* access modifiers changed from: protected */
    public native int nativeMute();

    /* access modifiers changed from: protected */
    public native int nativePause();

    /* access modifiers changed from: protected */
    public native int nativeRemoveCallBack();

    /* access modifiers changed from: protected */
    public native int nativeResume();

    /* access modifiers changed from: protected */
    public native int nativeSetCallBack(IMRSourceCallback iMRSourceCallback);

    /* access modifiers changed from: protected */
    public native int nativeSetProperty(SSourceProperty sSourceProperty);

    /* access modifiers changed from: protected */
    public native int nativeStart();

    /* access modifiers changed from: protected */
    public native int nativeStop();
}
