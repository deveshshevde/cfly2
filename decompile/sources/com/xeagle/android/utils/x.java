package com.xeagle.android.utils;

import android.util.Log;
import com.xeagle.android.utils.x;
import io.reactivex.f;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import lv.d;

public class x {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, io.reactivex.disposables.b> f24540a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f24541b;

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f24542c;

    public static abstract class a implements Runnable {
        /* access modifiers changed from: protected */
        public abstract void a();

        public void run() {
            a();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final x f24543a = new x();
    }

    public interface c {
        void a(String str);

        void a(String str, int i2);
    }

    private x() {
        this.f24540a = new ConcurrentHashMap<>();
        this.f24541b = new ConcurrentHashMap<>();
        this.f24542c = new ConcurrentHashMap<>();
    }

    public static x a() {
        return b.f24543a;
    }

    private void a(String str) {
        if (!this.f24541b.isEmpty()) {
            for (c a2 : this.f24541b.values()) {
                a2.a(str);
            }
        }
    }

    private void a(String str, int i2) {
        if (!this.f24541b.isEmpty()) {
            for (c a2 : this.f24541b.values()) {
                a2.a(str, i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, int i2, long j2, c cVar, a aVar, Long l2) throws Exception {
        Integer num;
        if (this.f24540a.containsKey(str) && this.f24542c.containsKey(str) && (num = this.f24542c.get(str)) != null) {
            int intValue = num.intValue() + 1;
            if (intValue < i2) {
                a(str, intValue);
                this.f24542c.put(str, Integer.valueOf(intValue));
                b(str, i2, j2, cVar, aVar);
                return;
            }
            a(str, i2);
            a(str, false);
        }
    }

    private void b(String str, int i2, long j2, c cVar, a aVar) {
        io.reactivex.disposables.b bVar = this.f24540a.get(str);
        if (bVar != null && !bVar.isDisposed()) {
            bVar.dispose();
        }
        this.f24540a.remove(str);
        a(str, i2, j2, cVar, aVar);
    }

    public void a(String str, int i2, long j2, c cVar, a aVar) {
        String str2 = str;
        c cVar2 = cVar;
        if (!this.f24540a.containsKey(str)) {
            if (!this.f24542c.containsKey(str)) {
                this.f24542c.put(str, 0);
            }
            a aVar2 = aVar;
            ka.a.a().b().execute(aVar2);
            long j3 = j2;
            this.f24540a.put(str, f.a(j3, TimeUnit.MILLISECONDS).a(new d(str, i2, j3, cVar, aVar2) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ int f$2;
                public final /* synthetic */ long f$3;
                public final /* synthetic */ x.c f$4;
                public final /* synthetic */ x.a f$5;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r6;
                    this.f$5 = r7;
                }

                public final void accept(Object obj) {
                    x.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Long) obj);
                }
            }));
            if (cVar2 != null && !this.f24541b.containsKey(str)) {
                this.f24541b.put(str, cVar2);
            }
        }
    }

    public void a(String str, boolean z2) {
        Log.i("RcSpeed", "removeTimeoutQueue: ====isComplete===" + z2);
        if (z2) {
            a(str);
        }
        io.reactivex.disposables.b bVar = this.f24540a.get(str);
        if (bVar != null && !bVar.isDisposed()) {
            bVar.dispose();
        }
        this.f24540a.remove(str);
        this.f24541b.remove(str);
        this.f24542c.remove(str);
    }
}
