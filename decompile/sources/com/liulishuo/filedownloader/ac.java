package com.liulishuo.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;

class ac implements w {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<Handler> f21165a = new SparseArray<>();

    ac() {
    }

    private void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    public void a() {
        for (int i2 = 0; i2 < this.f21165a.size(); i2++) {
            a(this.f21165a.get(this.f21165a.keyAt(i2)));
        }
    }

    public void a(List<Integer> list) {
        for (Integer intValue : list) {
            b(this.f21165a.get(intValue.intValue()));
        }
    }

    public boolean a(int i2) {
        return this.f21165a.get(i2) != null;
    }

    public int b() {
        return this.f21165a.size();
    }
}
