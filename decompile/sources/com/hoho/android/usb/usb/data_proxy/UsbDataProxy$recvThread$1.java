package com.hoho.android.usb.usb.data_proxy;

import android.os.ParcelFileDescriptor;
import com.hoho.android.usb.usb.data_proxy.log.b;
import com.myusb.proxy.proto.Proxy;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.af;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.e;
import mm.m;

@d(b = "UsbDataProxy.kt", c = {369}, d = "invokeSuspend", e = "com.hoho.android.usb.usb.data_proxy.UsbDataProxy$recvThread$1")
final class UsbDataProxy$recvThread$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20256a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f20257b;

    @d(b = "UsbDataProxy.kt", c = {}, d = "invokeSuspend", e = "com.hoho.android.usb.usb.data_proxy.UsbDataProxy$recvThread$1$1")
    /* renamed from: com.hoho.android.usb.usb.data_proxy.UsbDataProxy$recvThread$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements m<af, c<? super l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f20258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UsbDataProxy$recvThread$1 f20259b;

        {
            this.f20259b = r1;
        }

        public final Object a(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
        }

        public final c<l> create(Object obj, c<?> cVar) {
            h.d(cVar, "completion");
            return new AnonymousClass1(this.f20259b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            a.a();
            if (this.f20258a == 0) {
                i.a(obj);
                b.e("UsbDataProxy", "receive thread started", new Object[0]);
                try {
                    ParcelFileDescriptor d2 = this.f20259b.f20257b.f11907h;
                    h.a((Object) d2);
                    InputStream fileInputStream = new FileInputStream(d2.getFileDescriptor());
                    byte[] bArr = new byte[16384];
                    byte[] bArr2 = new byte[17];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        this.f20259b.f20257b.f11919t.a(bArr, 0, read);
                        while (true) {
                            if (17 != this.f20259b.f20257b.f11919t.b(bArr2, 0, 17)) {
                                break;
                            }
                            byte[] bytes = "#frame-begin#".getBytes(kotlin.text.d.f30261a);
                            h.b(bytes, "(this as java.lang.String).getBytes(charset)");
                            if (!he.a.a(bytes, bArr2, 13)) {
                                b.h("UsbDataProxy", "wrong frame header", new Object[0]);
                                this.f20259b.f20257b.f11919t.d();
                                break;
                            }
                            int a2 = he.a.a(bArr2, 13);
                            if (a2 + 17 > this.f20259b.f20257b.f11919t.b()) {
                                break;
                            }
                            this.f20259b.f20257b.f11919t.a(17);
                            Proxy.c a3 = Proxy.c.a(this.f20259b.f20257b.f11919t.a(a2));
                            d dVar = this.f20259b.f20257b;
                            h.b(a3, "proxyMsg");
                            dVar.b(a3);
                        }
                    }
                    fileInputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                b.e("UsbDataProxy", "receive thread stopped", new Object[0]);
                return l.f30254a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UsbDataProxy$recvThread$1(d dVar, c cVar) {
        super(2, cVar);
        this.f20257b = dVar;
    }

    public final Object a(Object obj, Object obj2) {
        return ((UsbDataProxy$recvThread$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new UsbDataProxy$recvThread$1(this.f20257b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = a.a();
        int i2 = this.f20256a;
        if (i2 == 0) {
            i.a(obj);
            this.f20256a = 1;
            if (e.a(ap.c(), new AnonymousClass1(this, (c) null), this) == a2) {
                return a2;
            }
        } else if (i2 == 1) {
            i.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return l.f30254a;
    }
}
