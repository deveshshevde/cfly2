package dx;

import android.util.Log;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Parser;
import en.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f13051b = "a";

    /* renamed from: a  reason: collision with root package name */
    protected final b f13052a = e();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f13053c = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final LinkedBlockingQueue<MAVLinkPacket> f13054d = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final LinkedBlockingQueue<MAVLinkPacket> f13055e = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f13056f = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f13057g;

    /* renamed from: h  reason: collision with root package name */
    private int f13058h = 0;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f13059i = new Runnable() {
        private void a(Parser parser, int i2, byte[] bArr) {
            if (i2 >= 1) {
                for (int i3 = 0; i3 < i2; i3++) {
                    MAVLinkPacket a2 = parser.a(bArr[i3] & 255);
                    if (a2 != null) {
                        a.this.a(a2.e());
                        boolean unused = a.this.c(a2);
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x006c, code lost:
            if (r2.isAlive() != false) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b5, code lost:
            if (r2.isAlive() != false) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b7, code lost:
            r2.interrupt();
         */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x009b A[Catch:{ all -> 0x00c0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00b1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                java.lang.String r0 = "CONNECT_DB"
                java.lang.String r1 = "mConnectingTask: "
                android.util.Log.i(r0, r1)
                dx.a r1 = dx.a.this
                r1.i()
                dx.a r1 = dx.a.this
                r1.h()
                r1 = 0
                dx.a r2 = dx.a.this     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                r2.f()     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                dx.a r2 = dx.a.this     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                java.util.concurrent.atomic.AtomicInteger r2 = r2.f13056f     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                r3 = 2
                r2.set(r3)     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                dx.a r2 = dx.a.this     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                r2.m()     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                java.lang.Thread r2 = new java.lang.Thread     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                dx.a r4 = dx.a.this     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                java.lang.Runnable r4 = r4.f13060j     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                java.lang.String r5 = "MavLinkConnection-Sending Thread"
                r2.<init>(r4, r5)     // Catch:{ IOException -> 0x0073, all -> 0x0071 }
                r2.start()     // Catch:{ IOException -> 0x006f }
                com.MAVLink.Parser r1 = new com.MAVLink.Parser     // Catch:{ IOException -> 0x006f }
                r1.<init>()     // Catch:{ IOException -> 0x006f }
                com.MAVLink.Messages.b r4 = r1.f6289c     // Catch:{ IOException -> 0x006f }
                r4.b()     // Catch:{ IOException -> 0x006f }
                r4 = 1024(0x400, float:1.435E-42)
                byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x006f }
            L_0x0044:
                dx.a r5 = dx.a.this     // Catch:{ IOException -> 0x006f }
                java.util.concurrent.atomic.AtomicInteger r5 = r5.f13056f     // Catch:{ IOException -> 0x006f }
                int r5 = r5.get()     // Catch:{ IOException -> 0x006f }
                if (r5 != r3) goto L_0x0068
                dx.a r5 = dx.a.this     // Catch:{ IOException -> 0x006f }
                int r5 = r5.a((byte[]) r4)     // Catch:{ IOException -> 0x006f }
                dx.a r6 = dx.a.this     // Catch:{ IOException -> 0x006f }
                boolean r6 = r6.f13057g     // Catch:{ IOException -> 0x006f }
                if (r6 != 0) goto L_0x0064
                dx.a r6 = dx.a.this     // Catch:{ IOException -> 0x006f }
                r7 = 1
                boolean unused = r6.f13057g = r7     // Catch:{ IOException -> 0x006f }
            L_0x0064:
                r9.a(r1, r5, r4)     // Catch:{ IOException -> 0x006f }
                goto L_0x0044
            L_0x0068:
                boolean r0 = r2.isAlive()
                if (r0 == 0) goto L_0x00ba
                goto L_0x00b7
            L_0x006f:
                r1 = move-exception
                goto L_0x0077
            L_0x0071:
                r0 = move-exception
                goto L_0x00c2
            L_0x0073:
                r2 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
            L_0x0077:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
                r3.<init>()     // Catch:{ all -> 0x00c0 }
                java.lang.String r4 = "run: ----udp connect error==="
                r3.append(r4)     // Catch:{ all -> 0x00c0 }
                java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x00c0 }
                r3.append(r4)     // Catch:{ all -> 0x00c0 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c0 }
                android.util.Log.e(r0, r3)     // Catch:{ all -> 0x00c0 }
                dx.a r0 = dx.a.this     // Catch:{ all -> 0x00c0 }
                java.util.concurrent.atomic.AtomicInteger r0 = r0.f13056f     // Catch:{ all -> 0x00c0 }
                int r0 = r0.get()     // Catch:{ all -> 0x00c0 }
                if (r0 == 0) goto L_0x00af
                dx.a r0 = dx.a.this     // Catch:{ all -> 0x00c0 }
                java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x00c0 }
                r0.b((java.lang.String) r3)     // Catch:{ all -> 0x00c0 }
                dx.a r0 = dx.a.this     // Catch:{ all -> 0x00c0 }
                en.b r0 = r0.f13052a     // Catch:{ all -> 0x00c0 }
                java.lang.String r3 = dx.a.f13051b     // Catch:{ all -> 0x00c0 }
                r0.a((java.lang.String) r3, (java.lang.Exception) r1)     // Catch:{ all -> 0x00c0 }
            L_0x00af:
                if (r2 == 0) goto L_0x00ba
                boolean r0 = r2.isAlive()
                if (r0 == 0) goto L_0x00ba
            L_0x00b7:
                r2.interrupt()
            L_0x00ba:
                dx.a r0 = dx.a.this
                r0.b()
                return
            L_0x00c0:
                r0 = move-exception
                r1 = r2
            L_0x00c2:
                if (r1 == 0) goto L_0x00cd
                boolean r2 = r1.isAlive()
                if (r2 == 0) goto L_0x00cd
                r1.interrupt()
            L_0x00cd:
                dx.a r1 = dx.a.this
                r1.b()
                goto L_0x00d4
            L_0x00d3:
                throw r0
            L_0x00d4:
                goto L_0x00d3
            */
            throw new UnsupportedOperationException("Method not decompiled: dx.a.AnonymousClass1.run():void");
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f13060j = new Runnable() {
        public void run() {
            int i2 = 0;
            while (a.this.f13056f.get() == 2) {
                try {
                    MAVLinkPacket mAVLinkPacket = (MAVLinkPacket) a.this.f13055e.take();
                    mAVLinkPacket.f6246b = i2;
                    try {
                        a.this.b(mAVLinkPacket.c());
                    } catch (IOException e2) {
                        a.this.b(e2.getMessage());
                        a.this.f13052a.a(a.f13051b, (Exception) e2);
                    }
                    i2 = (i2 + 1) % 256;
                } catch (InterruptedException e3) {
                    a.this.f13052a.a(a.f13051b, e3.getMessage());
                } catch (Throwable th) {
                    a.this.b();
                    throw th;
                }
            }
            a.this.b();
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f13061k = new Runnable() {
        public void run() {
            a aVar;
            String str;
            BufferedOutputStream bufferedOutputStream;
            File j2 = a.this.j();
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.order(ByteOrder.BIG_ENDIAN);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(j2));
                try {
                    synchronized (this) {
                        while (true) {
                            MAVLinkPacket mAVLinkPacket = (MAVLinkPacket) a.this.f13054d.take();
                            allocate.clear();
                            allocate.putLong(System.currentTimeMillis() * 1000);
                            bufferedOutputStream.write(allocate.array());
                            bufferedOutputStream.write(mAVLinkPacket.c());
                            a.this.b(mAVLinkPacket);
                        }
                    }
                } catch (InterruptedException e2) {
                    a.this.f13052a.a(a.f13051b, e2.getMessage());
                    bufferedOutputStream.close();
                    a.this.a(j2);
                }
            } catch (FileNotFoundException e3) {
                a.this.f13052a.a(a.f13051b, (Exception) e3);
                aVar = a.this;
                str = e3.getMessage();
                aVar.b(str);
            } catch (IOException e4) {
                a.this.f13052a.a(a.f13051b, (Exception) e4);
                aVar = a.this;
                str = e4.getMessage();
                aVar.b(str);
            } catch (Throwable th) {
                bufferedOutputStream.close();
                a.this.a(j2);
                throw th;
            }
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private Thread f13062l;

    /* access modifiers changed from: private */
    public void a(MAVLinkMessage mAVLinkMessage) {
        if (!this.f13053c.isEmpty() && mAVLinkMessage != null) {
            for (b a2 : this.f13053c.values()) {
                a2.a(mAVLinkMessage);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (!this.f13053c.isEmpty()) {
            for (b a2 : this.f13053c.values()) {
                a2.a(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean c(MAVLinkPacket mAVLinkPacket) {
        return this.f13054d.offer(mAVLinkPacket);
    }

    /* access modifiers changed from: private */
    public void m() {
        for (b a2 : this.f13053c.values()) {
            a2.a();
        }
    }

    private void n() {
        if (!this.f13053c.isEmpty()) {
            for (b b2 : this.f13053c.values()) {
                b2.b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract int a(byte[] bArr) throws IOException;

    public void a() {
        if (this.f13056f.compareAndSet(0, 1)) {
            Thread thread = new Thread(this.f13059i, "MavLinkConnection-Connecting Thread");
            this.f13062l = thread;
            thread.start();
        }
    }

    public void a(MAVLinkPacket mAVLinkPacket) {
        if (!this.f13055e.offer(mAVLinkPacket)) {
            this.f13052a.b(f13051b, "Unable to send mavlink packet. Packet queue is full!");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(File file);

    public void a(String str) {
        this.f13053c.remove(str);
    }

    public void a(String str, b bVar) {
        this.f13053c.put(str, bVar);
        if (d() == 2) {
            bVar.a();
        }
    }

    public void b() {
        if (this.f13056f.get() != 0 && this.f13062l != null) {
            try {
                this.f13056f.set(0);
                if (this.f13062l.isAlive() && !this.f13062l.isInterrupted()) {
                    this.f13062l.interrupt();
                }
                g();
                this.f13057g = false;
                n();
                Log.i(f13051b, "disconnect: ------   mavConnection");
            } catch (IOException e2) {
                this.f13052a.a(f13051b, (Exception) e2);
                b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(MAVLinkPacket mAVLinkPacket) throws IOException {
    }

    /* access modifiers changed from: protected */
    public abstract void b(byte[] bArr) throws IOException;

    public boolean c() {
        Log.i("getDataState", this.f13057g + "");
        return this.f13057g;
    }

    public int d() {
        return this.f13056f.get();
    }

    /* access modifiers changed from: protected */
    public abstract b e();

    /* access modifiers changed from: protected */
    public abstract void f() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void g() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void h();

    /* access modifiers changed from: protected */
    public abstract void i();

    /* access modifiers changed from: protected */
    public abstract File j();

    public abstract int k();
}
