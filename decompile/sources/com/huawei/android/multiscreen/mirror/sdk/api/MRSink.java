package com.huawei.android.multiscreen.mirror.sdk.api;

import com.huawei.android.multiscreen.mirror.sdk.structs.SMRDescription;
import com.huawei.android.multiscreen.mirror.sdk.structs.SSinkProperty;

public class MRSink extends a {

    /* renamed from: a  reason: collision with root package name */
    private long f20939a;

    public int a() {
        return nativeStart();
    }

    public int a(IMRSinkCallback iMRSinkCallback) {
        return nativeSetCallBack(iMRSinkCallback);
    }

    public int a(SSinkProperty sSinkProperty) {
        return nativeSetProperty(sSinkProperty);
    }

    /* access modifiers changed from: protected */
    public void a(long j2) {
        this.f20939a = j2;
    }

    public int b() {
        return nativeStop();
    }

    public int c() {
        return nativeDisonnect();
    }

    public SSinkProperty d() {
        return nativeGetProperty();
    }

    public EMirrorStatus e() {
        return EMirrorStatus.values()[nativeGetMirrorStatus()];
    }

    /* access modifiers changed from: protected */
    public native int nativeDisonnect();

    /* access modifiers changed from: protected */
    public native int nativeFinalize();

    /* access modifiers changed from: protected */
    public native SMRDescription nativeGetDescription();

    /* access modifiers changed from: protected */
    public native int nativeGetMirrorStatus();

    /* access modifiers changed from: protected */
    public native SSinkProperty nativeGetProperty();

    /* access modifiers changed from: protected */
    public native int nativeGetStatus();

    /* access modifiers changed from: protected */
    public native int nativePause();

    /* access modifiers changed from: protected */
    public native int nativeRemoveCallBack();

    /* access modifiers changed from: protected */
    public native int nativeResume();

    /* access modifiers changed from: protected */
    public native int nativeSetCallBack(IMRSinkCallback iMRSinkCallback);

    /* access modifiers changed from: protected */
    public native int nativeSetProperty(SSinkProperty sSinkProperty);

    /* access modifiers changed from: protected */
    public native int nativeStart();

    /* access modifiers changed from: protected */
    public native int nativeStop();
}
