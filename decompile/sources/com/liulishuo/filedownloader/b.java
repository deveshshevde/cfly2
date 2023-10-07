package com.liulishuo.filedownloader;

import android.os.SystemClock;
import com.liulishuo.filedownloader.s;

public class b implements s.a, s.b {

    /* renamed from: a  reason: collision with root package name */
    private long f21166a;

    /* renamed from: b  reason: collision with root package name */
    private long f21167b;

    /* renamed from: c  reason: collision with root package name */
    private long f21168c;

    /* renamed from: d  reason: collision with root package name */
    private long f21169d;

    /* renamed from: e  reason: collision with root package name */
    private int f21170e;

    /* renamed from: f  reason: collision with root package name */
    private int f21171f = 1000;

    public void a() {
        this.f21170e = 0;
        this.f21166a = 0;
    }

    public void a(long j2) {
        this.f21169d = SystemClock.uptimeMillis();
        this.f21168c = j2;
    }

    public void b(long j2) {
        if (this.f21169d > 0) {
            long j3 = j2 - this.f21168c;
            this.f21166a = 0;
            long uptimeMillis = SystemClock.uptimeMillis() - this.f21169d;
            if (uptimeMillis > 0) {
                j3 /= uptimeMillis;
            }
            this.f21170e = (int) j3;
        }
    }

    public void c(long j2) {
        if (this.f21171f > 0) {
            boolean z2 = true;
            if (this.f21166a != 0) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.f21166a;
                if (uptimeMillis >= ((long) this.f21171f) || (this.f21170e == 0 && uptimeMillis > 0)) {
                    int i2 = (int) ((j2 - this.f21167b) / uptimeMillis);
                    this.f21170e = i2;
                    this.f21170e = Math.max(0, i2);
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                this.f21167b = j2;
                this.f21166a = SystemClock.uptimeMillis();
            }
        }
    }
}
