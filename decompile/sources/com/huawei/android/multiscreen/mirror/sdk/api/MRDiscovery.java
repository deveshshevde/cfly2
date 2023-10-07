package com.huawei.android.multiscreen.mirror.sdk.api;

import android.util.Log;
import com.huawei.android.multiscreen.mirror.sdk.structs.SDiscoveryProperty;
import com.huawei.android.multiscreen.mirror.sdk.structs.SMRDescription;

public class MRDiscovery extends a {

    /* renamed from: a  reason: collision with root package name */
    private long f20938a;

    public int a() {
        return nativeStart();
    }

    public int a(IMRDiscoveryCallback iMRDiscoveryCallback) {
        return nativeSetCallBack(iMRDiscoveryCallback);
    }

    public int a(SDiscoveryProperty sDiscoveryProperty) {
        return nativeSetProperty(sDiscoveryProperty);
    }

    /* access modifiers changed from: protected */
    public void a(long j2) {
        this.f20938a = j2;
        Log.d("MRDiscoveryJNI", "mNativeObject is " + this.f20938a);
    }

    public int b() {
        return nativeStop();
    }

    public int c() {
        return nativeRefresh();
    }

    /* access modifiers changed from: protected */
    public native int nativeFinalize();

    /* access modifiers changed from: protected */
    public native SMRDescription nativeGetDescription();

    /* access modifiers changed from: protected */
    public native SDiscoveryProperty nativeGetProperty();

    /* access modifiers changed from: protected */
    public native int nativeGetStatus();

    /* access modifiers changed from: protected */
    public native int nativeRefresh();

    /* access modifiers changed from: protected */
    public native int nativeRemoveCallBack();

    /* access modifiers changed from: protected */
    public native int nativeSetCallBack(IMRDiscoveryCallback iMRDiscoveryCallback);

    /* access modifiers changed from: protected */
    public native int nativeSetProperty(SDiscoveryProperty sDiscoveryProperty);

    /* access modifiers changed from: protected */
    public native int nativeStart();

    /* access modifiers changed from: protected */
    public native int nativeStop();
}
