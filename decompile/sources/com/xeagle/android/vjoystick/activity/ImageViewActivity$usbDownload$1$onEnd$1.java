package com.xeagle.android.vjoystick.activity;

import com.flypro.photoview_library.PhotoView;
import com.xeagle.R;
import com.xeagle.android.newUI.widgets.RoundProgressBar;
import com.xeagle.android.vjoystick.activity.ImageViewActivity;
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

@d(b = "ImageViewActivity.kt", c = {187}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.activity.ImageViewActivity$usbDownload$1$onEnd$1")
final class ImageViewActivity$usbDownload$1$onEnd$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f24965a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ImageViewActivity.d f24966b;

    @d(b = "ImageViewActivity.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.activity.ImageViewActivity$usbDownload$1$onEnd$1$1")
    /* renamed from: com.xeagle.android.vjoystick.activity.ImageViewActivity$usbDownload$1$onEnd$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements m<af, c<? super l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24967a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImageViewActivity$usbDownload$1$onEnd$1 f24968b;

        {
            this.f24968b = r1;
        }

        public final Object a(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
        }

        public final c<l> create(Object obj, c<?> cVar) {
            h.d(cVar, "completion");
            return new AnonymousClass1(this.f24968b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            a.a();
            if (this.f24967a == 0) {
                i.a(obj);
                RoundProgressBar roundProgressBar = (RoundProgressBar) this.f24968b.f24966b.f24961a.a(R.id.image_pb);
                if (roundProgressBar != null) {
                    roundProgressBar.setVisibility(8);
                }
                PhotoView photoView = this.f24968b.f24966b.f24963c;
                h.a((Object) photoView);
                photoView.setImageBitmap(com.xeagle.android.utils.c.b(kx.d.g(this.f24968b.f24966b.f24961a.getApplicationContext())));
                return l.f30254a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageViewActivity$usbDownload$1$onEnd$1(ImageViewActivity.d dVar, c cVar) {
        super(2, cVar);
        this.f24966b = dVar;
    }

    public final Object a(Object obj, Object obj2) {
        return ((ImageViewActivity$usbDownload$1$onEnd$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new ImageViewActivity$usbDownload$1$onEnd$1(this.f24966b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = a.a();
        int i2 = this.f24965a;
        if (i2 == 0) {
            i.a(obj);
            this.f24965a = 1;
            if (e.a(ap.b(), new AnonymousClass1(this, (c) null), this) == a2) {
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
