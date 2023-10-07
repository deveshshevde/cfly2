package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.b;
import com.liulishuo.filedownloader.s;
import com.liulishuo.filedownloader.x;
import iq.f;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class d implements a.d, x, x.a, x.b {

    /* renamed from: a  reason: collision with root package name */
    private t f21195a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f21196b;

    /* renamed from: c  reason: collision with root package name */
    private final a f21197c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte f21198d = 0;

    /* renamed from: e  reason: collision with root package name */
    private Throwable f21199e = null;

    /* renamed from: f  reason: collision with root package name */
    private final s.b f21200f;

    /* renamed from: g  reason: collision with root package name */
    private final s.a f21201g;

    /* renamed from: h  reason: collision with root package name */
    private long f21202h;

    /* renamed from: i  reason: collision with root package name */
    private long f21203i;

    /* renamed from: j  reason: collision with root package name */
    private int f21204j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f21205k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21206l;

    /* renamed from: m  reason: collision with root package name */
    private String f21207m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21208n = false;

    interface a {
        FileDownloadHeader N();

        a.b O();

        ArrayList<a.C0139a> P();

        void b(String str);
    }

    d(a aVar, Object obj) {
        this.f21196b = obj;
        this.f21197c = aVar;
        b bVar = new b();
        this.f21200f = bVar;
        this.f21201g = bVar;
        this.f21195a = new k(aVar.O(), this);
    }

    private void e(MessageSnapshot messageSnapshot) {
        t tVar;
        a A = this.f21197c.O().A();
        byte b2 = messageSnapshot.b();
        this.f21198d = b2;
        this.f21205k = messageSnapshot.n();
        if (b2 != -4) {
            if (b2 == -3) {
                this.f21208n = messageSnapshot.e();
                this.f21202h = messageSnapshot.d();
                this.f21203i = messageSnapshot.d();
            } else if (b2 == -1) {
                this.f21199e = messageSnapshot.j();
                this.f21202h = messageSnapshot.i();
            } else if (b2 == 1) {
                this.f21202h = messageSnapshot.i();
                this.f21203i = messageSnapshot.d();
                tVar = this.f21195a;
            } else if (b2 == 2) {
                this.f21203i = messageSnapshot.d();
                this.f21206l = messageSnapshot.g();
                this.f21207m = messageSnapshot.h();
                String f2 = messageSnapshot.f();
                if (f2 != null) {
                    if (A.k() != null) {
                        iq.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", A.k(), f2);
                    }
                    this.f21197c.b(f2);
                }
                this.f21200f.a(this.f21202h);
                this.f21195a.c(messageSnapshot);
                return;
            } else if (b2 == 3) {
                this.f21202h = messageSnapshot.i();
                this.f21200f.c(messageSnapshot.i());
                this.f21195a.d(messageSnapshot);
                return;
            } else if (b2 == 5) {
                this.f21202h = messageSnapshot.i();
                this.f21199e = messageSnapshot.j();
                this.f21204j = messageSnapshot.k();
                this.f21200f.a();
                this.f21195a.f(messageSnapshot);
                return;
            } else if (b2 == 6) {
                this.f21195a.b(messageSnapshot);
                return;
            } else {
                return;
            }
            h.a().a(this.f21197c.O(), messageSnapshot);
            return;
        }
        this.f21200f.a();
        int a2 = h.a().a(A.e());
        if (a2 + ((a2 > 1 || !A.j()) ? 0 : h.a().a(f.b(A.f(), A.l()))) <= 1) {
            byte b3 = m.a().b(A.e());
            iq.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(A.e()), Integer.valueOf(b3));
            if (b.b(b3)) {
                this.f21198d = 1;
                this.f21203i = messageSnapshot.d();
                long i2 = messageSnapshot.i();
                this.f21202h = i2;
                this.f21200f.a(i2);
                tVar = this.f21195a;
                messageSnapshot = ((MessageSnapshot.a) messageSnapshot).l();
            }
        }
        h.a().a(this.f21197c.O(), messageSnapshot);
        return;
        tVar.a(messageSnapshot);
    }

    private void o() throws IOException {
        File file;
        a A = this.f21197c.O().A();
        if (A.i() == null) {
            A.a(f.b(A.f()));
            if (iq.d.f29057a) {
                iq.d.c(this, "save Path is null to %s", A.i());
            }
        }
        if (A.j()) {
            file = new File(A.i());
        } else {
            String i2 = f.i(A.i());
            if (i2 != null) {
                file = new File(i2);
            } else {
                throw new InvalidParameterException(f.a("the provided mPath[%s] is invalid, can't find its directory", A.i()));
            }
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(f.a("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    private int p() {
        return this.f21197c.O().A().e();
    }

    public MessageSnapshot a(Throwable th) {
        this.f21198d = -1;
        this.f21199e = th;
        return com.liulishuo.filedownloader.message.d.a(p(), h(), th);
    }

    public void a() {
        if (l.b()) {
            l.a().b(this.f21197c.O().A());
        }
        if (iq.d.f29057a) {
            iq.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(g()));
        }
    }

    public boolean a(MessageSnapshot messageSnapshot) {
        if (!b.a(g(), messageSnapshot.b())) {
            if (iq.d.f29057a) {
                iq.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f21198d), Byte.valueOf(g()), Integer.valueOf(p()));
            }
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    public void b() {
        if (l.b() && g() == 6) {
            l.a().c(this.f21197c.O().A());
        }
    }

    public boolean b(MessageSnapshot messageSnapshot) {
        byte g2 = g();
        byte b2 = messageSnapshot.b();
        if (-2 == g2 && b.b(b2)) {
            if (iq.d.f29057a) {
                iq.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(p()));
            }
            return true;
        } else if (!b.b(g2, b2)) {
            if (iq.d.f29057a) {
                iq.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f21198d), Byte.valueOf(g()), Integer.valueOf(p()));
            }
            return false;
        } else {
            e(messageSnapshot);
            return true;
        }
    }

    public void c() {
        a A = this.f21197c.O().A();
        if (l.b()) {
            l.a().d(A);
        }
        if (iq.d.f29057a) {
            iq.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(g()));
        }
        this.f21200f.b(this.f21202h);
        if (this.f21197c.P() != null) {
            ArrayList arrayList = (ArrayList) this.f21197c.P().clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a.C0139a) arrayList.get(i2)).a(A);
            }
        }
        q.a().h().b(this.f21197c.O());
    }

    public boolean c(MessageSnapshot messageSnapshot) {
        if (!b.a(this.f21197c.O().A())) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    public t d() {
        return this.f21195a;
    }

    public boolean d(MessageSnapshot messageSnapshot) {
        if (!this.f21197c.O().A().j() || messageSnapshot.b() != -4 || g() != 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r0 = r8.f21197c.O();
        r1 = r0.A();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.liulishuo.filedownloader.l.b() == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        com.liulishuo.filedownloader.l.a().a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (iq.d.f29057a == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        iq.d.e(r8, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", r1.f(), r1.i(), r1.m(), r1.u());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        com.liulishuo.filedownloader.h.a().b(r0);
        com.liulishuo.filedownloader.h.a().a(r0, a(r1));
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f21196b
            monitor-enter(r0)
            byte r1 = r8.f21198d     // Catch:{ all -> 0x009e }
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x009e }
            int r5 = r8.p()     // Catch:{ all -> 0x009e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x009e }
            r2[r4] = r5     // Catch:{ all -> 0x009e }
            byte r4 = r8.f21198d     // Catch:{ all -> 0x009e }
            java.lang.Byte r4 = java.lang.Byte.valueOf(r4)     // Catch:{ all -> 0x009e }
            r2[r3] = r4     // Catch:{ all -> 0x009e }
            iq.d.d(r8, r1, r2)     // Catch:{ all -> 0x009e }
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            return
        L_0x0025:
            r1 = 10
            r8.f21198d = r1     // Catch:{ all -> 0x009e }
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            com.liulishuo.filedownloader.d$a r0 = r8.f21197c
            com.liulishuo.filedownloader.a$b r0 = r0.O()
            com.liulishuo.filedownloader.a r1 = r0.A()
            boolean r5 = com.liulishuo.filedownloader.l.b()
            if (r5 == 0) goto L_0x0041
            com.liulishuo.filedownloader.l$a r5 = com.liulishuo.filedownloader.l.a()
            r5.a(r1)
        L_0x0041:
            boolean r5 = iq.d.f29057a
            if (r5 == 0) goto L_0x0066
            java.lang.String r5 = "call start Url[%s], Path[%s] Listener[%s], Tag[%s]"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = r1.f()
            r6[r4] = r7
            java.lang.String r7 = r1.i()
            r6[r3] = r7
            com.liulishuo.filedownloader.i r7 = r1.m()
            r6[r2] = r7
            r2 = 3
            java.lang.Object r1 = r1.u()
            r6[r2] = r1
            iq.d.e(r8, r5, r6)
        L_0x0066:
            r8.o()     // Catch:{ all -> 0x006b }
            r0 = 1
            goto L_0x007f
        L_0x006b:
            r1 = move-exception
            com.liulishuo.filedownloader.h r2 = com.liulishuo.filedownloader.h.a()
            r2.b((com.liulishuo.filedownloader.a.b) r0)
            com.liulishuo.filedownloader.h r2 = com.liulishuo.filedownloader.h.a()
            com.liulishuo.filedownloader.message.MessageSnapshot r1 = r8.a((java.lang.Throwable) r1)
            r2.a(r0, r1)
            r0 = 0
        L_0x007f:
            if (r0 == 0) goto L_0x0088
            com.liulishuo.filedownloader.p r0 = com.liulishuo.filedownloader.p.a()
            r0.a(r8)
        L_0x0088:
            boolean r0 = iq.d.f29057a
            if (r0 == 0) goto L_0x009d
            java.lang.String r0 = "the task[%d] has been into the launch pool."
            java.lang.Object[] r1 = new java.lang.Object[r3]
            int r2 = r8.p()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1[r4] = r2
            iq.d.e(r8, r0, r1)
        L_0x009d:
            return
        L_0x009e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.d.e():void");
    }

    public boolean f() {
        if (b.a((int) g())) {
            if (iq.d.f29057a) {
                iq.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(g()), Integer.valueOf(this.f21197c.O().A().e()));
            }
            return false;
        }
        this.f21198d = -2;
        a.b O = this.f21197c.O();
        a A = O.A();
        p.a().b(this);
        if (iq.d.f29057a) {
            iq.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(p()));
        }
        if (q.a().f()) {
            m.a().a(A.e());
        } else if (iq.d.f29057a) {
            iq.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(A.e()));
        }
        h.a().b(O);
        h.a().a(O, com.liulishuo.filedownloader.message.d.a(A));
        q.a().h().b(O);
        return true;
    }

    public byte g() {
        return this.f21198d;
    }

    public long h() {
        return this.f21202h;
    }

    public long i() {
        return this.f21203i;
    }

    public Throwable j() {
        return this.f21199e;
    }

    public int k() {
        return this.f21204j;
    }

    public boolean l() {
        return this.f21205k;
    }

    public void m() {
        if (iq.d.f29057a) {
            iq.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(p()), Byte.valueOf(this.f21198d));
        }
        this.f21198d = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        com.liulishuo.filedownloader.h.a().b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (iq.c.a(r0.e(), r0.l(), r0.s(), true) == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
        r0 = com.liulishuo.filedownloader.m.a().a(r0.f(), r0.i(), r0.j(), r0.g(), r0.h(), r0.v(), r0.s(), r1.f21197c.N(), r0.z());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b0, code lost:
        if (r1.f21198d != -2) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b2, code lost:
        iq.d.d(r1, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", java.lang.Integer.valueOf(p()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c3, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c5, code lost:
        com.liulishuo.filedownloader.m.a().a(p());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d1, code lost:
        if (r0 != false) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d7, code lost:
        if (r7.c(r6) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d9, code lost:
        r0 = a((java.lang.Throwable) new java.lang.RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ec, code lost:
        if (com.liulishuo.filedownloader.h.a().a(r6) == false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ee, code lost:
        r7.b(r6);
        com.liulishuo.filedownloader.h.a().b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f8, code lost:
        com.liulishuo.filedownloader.h.a().a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0100, code lost:
        r7.b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
            r18 = this;
            r1 = r18
            byte r0 = r1.f21198d
            r2 = 2
            r3 = 10
            r4 = 0
            r5 = 1
            if (r0 == r3) goto L_0x0025
            java.lang.String r0 = "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            int r3 = r18.p()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r4] = r3
            byte r3 = r1.f21198d
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r5] = r3
            iq.d.d(r1, r0, r2)
            return
        L_0x0025:
            com.liulishuo.filedownloader.d$a r0 = r1.f21197c
            com.liulishuo.filedownloader.a$b r6 = r0.O()
            com.liulishuo.filedownloader.a r0 = r6.A()
            com.liulishuo.filedownloader.q r7 = com.liulishuo.filedownloader.q.a()
            com.liulishuo.filedownloader.v r7 = r7.h()
            boolean r8 = r7.c(r6)     // Catch:{ all -> 0x0107 }
            if (r8 == 0) goto L_0x003e
            return
        L_0x003e:
            java.lang.Object r8 = r1.f21196b     // Catch:{ all -> 0x0107 }
            monitor-enter(r8)     // Catch:{ all -> 0x0107 }
            byte r9 = r1.f21198d     // Catch:{ all -> 0x0104 }
            if (r9 == r3) goto L_0x0060
            java.lang.String r0 = "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0104 }
            int r3 = r18.p()     // Catch:{ all -> 0x0104 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0104 }
            r2[r4] = r3     // Catch:{ all -> 0x0104 }
            byte r3 = r1.f21198d     // Catch:{ all -> 0x0104 }
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)     // Catch:{ all -> 0x0104 }
            r2[r5] = r3     // Catch:{ all -> 0x0104 }
            iq.d.d(r1, r0, r2)     // Catch:{ all -> 0x0104 }
            monitor-exit(r8)     // Catch:{ all -> 0x0104 }
            return
        L_0x0060:
            r2 = 11
            r1.f21198d = r2     // Catch:{ all -> 0x0104 }
            monitor-exit(r8)     // Catch:{ all -> 0x0104 }
            com.liulishuo.filedownloader.h r2 = com.liulishuo.filedownloader.h.a()     // Catch:{ all -> 0x0107 }
            r2.b((com.liulishuo.filedownloader.a.b) r6)     // Catch:{ all -> 0x0107 }
            int r2 = r0.e()     // Catch:{ all -> 0x0107 }
            java.lang.String r3 = r0.l()     // Catch:{ all -> 0x0107 }
            boolean r8 = r0.s()     // Catch:{ all -> 0x0107 }
            boolean r2 = iq.c.a((int) r2, (java.lang.String) r3, (boolean) r8, (boolean) r5)     // Catch:{ all -> 0x0107 }
            if (r2 == 0) goto L_0x007f
            return
        L_0x007f:
            com.liulishuo.filedownloader.m r8 = com.liulishuo.filedownloader.m.a()     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r0.f()     // Catch:{ all -> 0x0107 }
            java.lang.String r10 = r0.i()     // Catch:{ all -> 0x0107 }
            boolean r11 = r0.j()     // Catch:{ all -> 0x0107 }
            int r12 = r0.g()     // Catch:{ all -> 0x0107 }
            int r13 = r0.h()     // Catch:{ all -> 0x0107 }
            int r14 = r0.v()     // Catch:{ all -> 0x0107 }
            boolean r15 = r0.s()     // Catch:{ all -> 0x0107 }
            com.liulishuo.filedownloader.d$a r2 = r1.f21197c     // Catch:{ all -> 0x0107 }
            com.liulishuo.filedownloader.model.FileDownloadHeader r16 = r2.N()     // Catch:{ all -> 0x0107 }
            boolean r17 = r0.z()     // Catch:{ all -> 0x0107 }
            boolean r0 = r8.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0107 }
            byte r2 = r1.f21198d     // Catch:{ all -> 0x0107 }
            r3 = -2
            if (r2 != r3) goto L_0x00d1
            java.lang.String r2 = "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x0107 }
            int r5 = r18.p()     // Catch:{ all -> 0x0107 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0107 }
            r3[r4] = r5     // Catch:{ all -> 0x0107 }
            iq.d.d(r1, r2, r3)     // Catch:{ all -> 0x0107 }
            if (r0 == 0) goto L_0x00d0
            com.liulishuo.filedownloader.m r0 = com.liulishuo.filedownloader.m.a()     // Catch:{ all -> 0x0107 }
            int r2 = r18.p()     // Catch:{ all -> 0x0107 }
            r0.a((int) r2)     // Catch:{ all -> 0x0107 }
        L_0x00d0:
            return
        L_0x00d1:
            if (r0 != 0) goto L_0x0100
            boolean r0 = r7.c(r6)     // Catch:{ all -> 0x0107 }
            if (r0 != 0) goto L_0x0116
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0107 }
            java.lang.String r2 = "Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."
            r0.<init>(r2)     // Catch:{ all -> 0x0107 }
            com.liulishuo.filedownloader.message.MessageSnapshot r0 = r1.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0107 }
            com.liulishuo.filedownloader.h r2 = com.liulishuo.filedownloader.h.a()     // Catch:{ all -> 0x0107 }
            boolean r2 = r2.a((com.liulishuo.filedownloader.a.b) r6)     // Catch:{ all -> 0x0107 }
            if (r2 == 0) goto L_0x00f8
            r7.b(r6)     // Catch:{ all -> 0x0107 }
            com.liulishuo.filedownloader.h r2 = com.liulishuo.filedownloader.h.a()     // Catch:{ all -> 0x0107 }
            r2.b((com.liulishuo.filedownloader.a.b) r6)     // Catch:{ all -> 0x0107 }
        L_0x00f8:
            com.liulishuo.filedownloader.h r2 = com.liulishuo.filedownloader.h.a()     // Catch:{ all -> 0x0107 }
            r2.a(r6, r0)     // Catch:{ all -> 0x0107 }
            goto L_0x0116
        L_0x0100:
            r7.b(r6)     // Catch:{ all -> 0x0107 }
            goto L_0x0116
        L_0x0104:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0104 }
            throw r0     // Catch:{ all -> 0x0107 }
        L_0x0107:
            r0 = move-exception
            r0.printStackTrace()
            com.liulishuo.filedownloader.h r2 = com.liulishuo.filedownloader.h.a()
            com.liulishuo.filedownloader.message.MessageSnapshot r0 = r1.a((java.lang.Throwable) r0)
            r2.a(r6, r0)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.d.n():void");
    }
}
