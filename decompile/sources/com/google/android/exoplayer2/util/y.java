package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class y implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f17186a;

    public y(Handler handler) {
        this.f17186a = handler;
    }

    public Looper a() {
        return this.f17186a.getLooper();
    }

    public Message a(int i2, int i3, int i4) {
        return this.f17186a.obtainMessage(i2, i3, i4);
    }

    public Message a(int i2, int i3, int i4, Object obj) {
        return this.f17186a.obtainMessage(i2, i3, i4, obj);
    }

    public Message a(int i2, Object obj) {
        return this.f17186a.obtainMessage(i2, obj);
    }

    public boolean a(int i2) {
        return this.f17186a.sendEmptyMessage(i2);
    }

    public boolean a(int i2, long j2) {
        return this.f17186a.sendEmptyMessageAtTime(i2, j2);
    }

    public void b(int i2) {
        this.f17186a.removeMessages(i2);
    }
}
