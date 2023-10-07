package com.google.android.exoplayer2.util;

import java.util.Collections;
import java.util.PriorityQueue;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17166a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Integer> f17167b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c  reason: collision with root package name */
    private int f17168c = Integer.MIN_VALUE;

    public void a(int i2) {
        synchronized (this.f17166a) {
            this.f17167b.add(Integer.valueOf(i2));
            this.f17168c = Math.max(this.f17168c, i2);
        }
    }

    public void b(int i2) {
        synchronized (this.f17166a) {
            this.f17167b.remove(Integer.valueOf(i2));
            this.f17168c = this.f17167b.isEmpty() ? Integer.MIN_VALUE : ((Integer) ad.a(this.f17167b.peek())).intValue();
            this.f17166a.notifyAll();
        }
    }
}
