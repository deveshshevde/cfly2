package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    protected final i f17414a;

    protected LifecycleCallback(i iVar) {
        this.f17414a = iVar;
    }

    public static i a(Activity activity) {
        return a(new h(activity));
    }

    protected static i a(h hVar) {
        if (hVar.d()) {
            return dj.a(hVar.b());
        }
        if (hVar.c()) {
            return dh.a(hVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    private static i getChimeraLifecycleFragmentImpl(h hVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public Activity a() {
        Activity a2 = this.f17414a.a();
        m.a(a2);
        return a2;
    }

    public void a(int i2, int i3, Intent intent) {
    }

    public void a(Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void b() {
    }

    public void b(Bundle bundle) {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }
}
