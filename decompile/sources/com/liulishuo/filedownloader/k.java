package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.message.BlockCompleteMessage;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.b;
import com.liulishuo.filedownloader.x;
import iq.d;
import iq.f;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class k implements t {

    /* renamed from: a  reason: collision with root package name */
    private a.b f21361a;

    /* renamed from: b  reason: collision with root package name */
    private a.d f21362b;

    /* renamed from: c  reason: collision with root package name */
    private Queue<MessageSnapshot> f21363c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21364d = false;

    k(a.b bVar, a.d dVar) {
        a(bVar, dVar);
    }

    private void a(int i2) {
        if (b.a(i2)) {
            if (!this.f21363c.isEmpty()) {
                MessageSnapshot peek = this.f21363c.peek();
                d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.m()), Integer.valueOf(this.f21363c.size()), Byte.valueOf(peek.b()));
            }
            this.f21361a = null;
        }
    }

    private void a(a.b bVar, a.d dVar) {
        this.f21361a = bVar;
        this.f21362b = dVar;
        this.f21363c = new LinkedBlockingQueue();
    }

    private void k(MessageSnapshot messageSnapshot) {
        a.b bVar = this.f21361a;
        if (bVar == null) {
            if (d.f29057a) {
                d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b()));
            }
        } else if (this.f21364d || bVar.A().m() == null) {
            if ((l.b() || this.f21361a.K()) && messageSnapshot.b() == 4) {
                this.f21362b.c();
            }
            a((int) messageSnapshot.b());
        } else {
            this.f21363c.offer(messageSnapshot);
            j.a().a((t) this);
        }
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (d.f29057a) {
            d.c(this, "notify pending %s", this.f21361a);
        }
        this.f21362b.b();
        k(messageSnapshot);
    }

    public boolean a() {
        if (d.f29057a) {
            d.c(this, "notify begin %s", this.f21361a);
        }
        if (this.f21361a == null) {
            d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.f21363c.size()));
            return false;
        }
        this.f21362b.a();
        return true;
    }

    public void b() {
        if (!this.f21364d) {
            MessageSnapshot poll = this.f21363c.poll();
            byte b2 = poll.b();
            a.b bVar = this.f21361a;
            if (bVar != null) {
                a A = bVar.A();
                i m2 = A.m();
                x.a B = bVar.B();
                a((int) b2);
                if (m2 != null && !m2.a()) {
                    if (b2 == 4) {
                        try {
                            m2.b(A);
                            j(((BlockCompleteMessage) poll).t_());
                        } catch (Throwable th) {
                            h(B.a(th));
                        }
                    } else {
                        g gVar = null;
                        if (m2 instanceof g) {
                            gVar = (g) m2;
                        }
                        if (b2 == -4) {
                            m2.d(A);
                        } else if (b2 == -3) {
                            m2.c(A);
                        } else if (b2 != -2) {
                            if (b2 == -1) {
                                m2.a(A, poll.j());
                            } else if (b2 != 1) {
                                if (b2 == 2) {
                                    String h2 = poll.h();
                                    boolean g2 = poll.g();
                                    if (gVar != null) {
                                        gVar.a(A, h2, g2, A.o(), poll.d());
                                        return;
                                    }
                                    m2.a(A, h2, g2, A.n(), poll.c());
                                } else if (b2 != 3) {
                                    if (b2 != 5) {
                                        if (b2 == 6) {
                                            m2.a(A);
                                        }
                                    } else if (gVar != null) {
                                        gVar.a(A, poll.j(), poll.k(), poll.i());
                                    } else {
                                        m2.a(A, poll.j(), poll.k(), poll.a());
                                    }
                                } else if (gVar != null) {
                                    gVar.b(A, poll.i(), A.q());
                                } else {
                                    m2.b(A, poll.a(), A.p());
                                }
                            } else if (gVar != null) {
                                gVar.a(A, poll.i(), poll.d());
                            } else {
                                m2.a(A, poll.a(), poll.c());
                            }
                        } else if (gVar != null) {
                            gVar.c(A, poll.i(), poll.d());
                        } else {
                            m2.c(A, poll.a(), poll.c());
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException(f.a("can't handover the message, no master to receive this message(status[%d]) size[%d]", Integer.valueOf(b2), Integer.valueOf(this.f21363c.size())));
            }
        }
    }

    public void b(MessageSnapshot messageSnapshot) {
        if (d.f29057a) {
            d.c(this, "notify started %s", this.f21361a);
        }
        this.f21362b.b();
        k(messageSnapshot);
    }

    public void c(MessageSnapshot messageSnapshot) {
        if (d.f29057a) {
            d.c(this, "notify connected %s", this.f21361a);
        }
        this.f21362b.b();
        k(messageSnapshot);
    }

    public boolean c() {
        return this.f21361a.A().x();
    }

    public void d(MessageSnapshot messageSnapshot) {
        a A = this.f21361a.A();
        if (d.f29057a) {
            d.c(this, "notify progress %s %d %d", A, Long.valueOf(A.o()), Long.valueOf(A.q()));
        }
        if (A.g() > 0) {
            this.f21362b.b();
            k(messageSnapshot);
        } else if (d.f29057a) {
            d.c(this, "notify progress but client not request notify %s", this.f21361a);
        }
    }

    public boolean d() {
        return this.f21363c.peek().b() == 4;
    }

    public void e(MessageSnapshot messageSnapshot) {
        if (d.f29057a) {
            d.c(this, "notify block completed %s %s", this.f21361a, Thread.currentThread().getName());
        }
        this.f21362b.b();
        k(messageSnapshot);
    }

    public void f(MessageSnapshot messageSnapshot) {
        if (d.f29057a) {
            a A = this.f21361a.A();
            d.c(this, "notify retry %s %d %d %s", this.f21361a, Integer.valueOf(A.v()), Integer.valueOf(A.w()), A.t());
        }
        this.f21362b.b();
        k(messageSnapshot);
    }

    public void g(MessageSnapshot messageSnapshot) {
        if (d.f29057a) {
            d.c(this, "notify warn %s", this.f21361a);
        }
        this.f21362b.c();
        k(messageSnapshot);
    }

    public void h(MessageSnapshot messageSnapshot) {
        if (d.f29057a) {
            a.b bVar = this.f21361a;
            d.c(this, "notify error %s %s", bVar, bVar.A().t());
        }
        this.f21362b.c();
        k(messageSnapshot);
    }

    public void i(MessageSnapshot messageSnapshot) {
        if (d.f29057a) {
            d.c(this, "notify paused %s", this.f21361a);
        }
        this.f21362b.c();
        k(messageSnapshot);
    }

    public void j(MessageSnapshot messageSnapshot) {
        if (d.f29057a) {
            d.c(this, "notify completed %s", this.f21361a);
        }
        this.f21362b.c();
        k(messageSnapshot);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        a.b bVar = this.f21361a;
        objArr[0] = Integer.valueOf(bVar == null ? -1 : bVar.A().e());
        objArr[1] = super.toString();
        return f.a("%d:%s", objArr);
    }
}
