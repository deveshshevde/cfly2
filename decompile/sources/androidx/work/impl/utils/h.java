package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.j;

public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private j f5395a;

    /* renamed from: b  reason: collision with root package name */
    private String f5396b;

    /* renamed from: c  reason: collision with root package name */
    private WorkerParameters.a f5397c;

    public h(j jVar, String str, WorkerParameters.a aVar) {
        this.f5395a = jVar;
        this.f5396b = str;
        this.f5397c = aVar;
    }

    public void run() {
        this.f5395a.f().a(this.f5396b, this.f5397c);
    }
}
