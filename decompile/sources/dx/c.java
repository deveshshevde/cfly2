package dx;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.t;
import com.hoho.android.usb.rtsp.a;
import ha.b;
import ha.g;
import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.LinkedBlockingQueue;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public abstract class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private final t<Object> f13063b;

    /* renamed from: c  reason: collision with root package name */
    private DatagramSocket f13064c;

    /* renamed from: d  reason: collision with root package name */
    private int f13065d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f13066e;

    /* renamed from: f  reason: collision with root package name */
    private Context f13067f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f13068g;

    /* renamed from: h  reason: collision with root package name */
    private LinkedBlockingQueue<byte[]> f13069h = new LinkedBlockingQueue<>();

    /* renamed from: i  reason: collision with root package name */
    private boolean f13070i = false;

    public c(Context context) {
        AnonymousClass1 r0 = new t<Object>() {
            public void onChanged(Object obj) {
                boolean unused = c.this.f13066e = ((Boolean) obj).booleanValue();
                if (c.this.f13066e) {
                    c cVar = c.this;
                    a unused2 = cVar.f13068g = cVar.o();
                }
            }
        };
        this.f13063b = r0;
        b.a().a("USB_STATE").a(r0);
        this.f13067f = context;
    }

    private void p() throws IOException {
        if (this.f13066e) {
            if (!org.greenrobot.eventbus.c.a().b(this)) {
                org.greenrobot.eventbus.c.a().a((Object) this);
            }
            a aVar = this.f13068g;
            if (aVar != null) {
                aVar.n();
                return;
            }
            return;
        }
        try {
            DatagramSocket datagramSocket = new DatagramSocket(this.f13065d);
            this.f13064c = datagramSocket;
            datagramSocket.setBroadcast(true);
            this.f13064c.setReuseAddress(true);
        } catch (BindException e2) {
            e2.printStackTrace();
            Log.i("UDP", "getUdpStream:---bind error--- ");
        }
    }

    public final int a(byte[] bArr) throws IOException {
        if (this.f13066e) {
            byte[] poll = this.f13069h.poll();
            if (poll == null) {
                return 0;
            }
            System.arraycopy(poll, 0, bArr, 0, poll.length);
            return poll.length;
        }
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
        DatagramSocket datagramSocket = this.f13064c;
        if (datagramSocket != null) {
            datagramSocket.receive(datagramPacket);
            if (datagramPacket.getLength() > 0) {
                this.f13070i = true;
            }
        }
        return datagramPacket.getLength();
    }

    /* access modifiers changed from: protected */
    public void a(File file) {
    }

    public final void b(byte[] bArr) {
        if (this.f13066e) {
            a aVar = this.f13068g;
            if (aVar != null) {
                aVar.d(bArr);
                return;
            }
            return;
        }
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, InetAddress.getByName("172.50.10.1"), IMediaPlayer.MEDIA_INFO_OPEN_INPUT);
            DatagramSocket datagramSocket = this.f13064c;
            if (datagramSocket != null) {
                datagramSocket.send(datagramPacket);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public en.b e() {
        return null;
    }

    public final void f() throws IOException {
        p();
    }

    public final void g() throws IOException {
        if (this.f13063b == null) {
            return;
        }
        if (this.f13066e) {
            this.f13069h.clear();
            if (this.f13068g != null && org.greenrobot.eventbus.c.a().b(this)) {
                org.greenrobot.eventbus.c.a().c(this);
                return;
            }
            return;
        }
        DatagramSocket datagramSocket = this.f13064c;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f13070i = false;
        }
    }

    public final void h() {
        this.f13065d = m();
    }

    public void i() {
        if (this.f13066e) {
            this.f13068g = o();
        }
    }

    /* access modifiers changed from: protected */
    public File j() {
        return null;
    }

    public final int k() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public abstract int m();

    public abstract boolean n();

    /* access modifiers changed from: protected */
    public abstract a o();

    @l(a = ThreadMode.BACKGROUND)
    public void usbUdpRecDataEvent(g gVar) {
        if (gVar.a() == 3 && !this.f13069h.offer(gVar.b())) {
            Log.i("UDP", "recData:==获取失败== ");
        }
    }
}
