package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.message.c;
import iq.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f21398a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c.b f21399b;

    public class a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final List<Integer> f21401b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final Executor f21402c;

        public a(int i2) {
            this.f21402c = b.a(1, "Flow-" + i2);
        }

        public void a(int i2) {
            this.f21401b.add(Integer.valueOf(i2));
        }

        public void a(final MessageSnapshot messageSnapshot) {
            this.f21402c.execute(new Runnable() {
                public void run() {
                    e.this.f21399b.a(messageSnapshot);
                    a.this.f21401b.remove(Integer.valueOf(messageSnapshot.m()));
                }
            });
        }
    }

    e(int i2, c.b bVar) {
        this.f21399b = bVar;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f21398a.add(new a(i3));
        }
    }

    public void a(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.f21398a) {
                int m2 = messageSnapshot.m();
                Iterator<a> it2 = this.f21398a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    a next = it2.next();
                    if (next.f21401b.contains(Integer.valueOf(m2))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i2 = 0;
                    Iterator<a> it3 = this.f21398a.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        a next2 = it3.next();
                        if (next2.f21401b.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (i2 == 0 || next2.f21401b.size() < i2) {
                            i2 = next2.f21401b.size();
                            aVar = next2;
                        }
                    }
                }
                aVar.a(m2);
            }
            aVar.a(messageSnapshot);
        } catch (Throwable th) {
            aVar.a(messageSnapshot);
            throw th;
        }
    }
}
