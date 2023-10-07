package com.hoho.android.usb.usb.data_proxy;

import com.myusb.proxy.proto.Proxy;
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

@d(b = "UsbDataProxy.kt", c = {354}, d = "invokeSuspend", e = "com.hoho.android.usb.usb.data_proxy.UsbDataProxy$sendThread$1")
final class UsbDataProxy$sendThread$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20260a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f20261b;

    @d(b = "UsbDataProxy.kt", c = {}, d = "invokeSuspend", e = "com.hoho.android.usb.usb.data_proxy.UsbDataProxy$sendThread$1$1")
    /* renamed from: com.hoho.android.usb.usb.data_proxy.UsbDataProxy$sendThread$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements m<af, c<? super l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f20262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UsbDataProxy$sendThread$1 f20263b;

        {
            this.f20263b = r1;
        }

        public final Object a(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
        }

        public final c<l> create(Object obj, c<?> cVar) {
            h.d(cVar, "completion");
            return new AnonymousClass1(this.f20263b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            a.a();
            if (this.f20262a == 0) {
                i.a(obj);
                while (true) {
                    try {
                        Proxy.c cVar = (Proxy.c) this.f20263b.f20261b.f11914o.take();
                        if (cVar != null) {
                            kotlin.coroutines.jvm.internal.a.a(this.f20263b.f20261b.a(cVar));
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UsbDataProxy$sendThread$1(d dVar, c cVar) {
        super(2, cVar);
        this.f20261b = dVar;
    }

    public final Object a(Object obj, Object obj2) {
        return ((UsbDataProxy$sendThread$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new UsbDataProxy$sendThread$1(this.f20261b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = a.a();
        int i2 = this.f20260a;
        if (i2 == 0) {
            i.a(obj);
            this.f20260a = 1;
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
