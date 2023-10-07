package com.xeagle.android.newUI.widgets;

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

@d(b = "NiceMarqueeText.kt", c = {176}, d = "invokeSuspend", e = "com.xeagle.android.newUI.widgets.NiceMarqueeText$continueRoll$1")
final class NiceMarqueeText$continueRoll$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f24064a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NiceMarqueeText f24065b;

    @d(b = "NiceMarqueeText.kt", c = {178}, d = "invokeSuspend", e = "com.xeagle.android.newUI.widgets.NiceMarqueeText$continueRoll$1$1")
    /* renamed from: com.xeagle.android.newUI.widgets.NiceMarqueeText$continueRoll$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements m<af, c<? super l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24066a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NiceMarqueeText$continueRoll$1 f24067b;

        {
            this.f24067b = r1;
        }

        public final Object a(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
        }

        public final c<l> create(Object obj, c<?> cVar) {
            h.d(cVar, "completion");
            return new AnonymousClass1(this.f24067b, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.a()
                int r1 = r5.f24066a
                r2 = 1
                if (r1 == 0) goto L_0x0018
                if (r1 != r2) goto L_0x0010
                kotlin.i.a((java.lang.Object) r6)
                r6 = r5
                goto L_0x0041
            L_0x0010:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0018:
                kotlin.i.a((java.lang.Object) r6)
                r6 = r5
            L_0x001c:
                com.xeagle.android.newUI.widgets.NiceMarqueeText$continueRoll$1 r1 = r6.f24067b
                com.xeagle.android.newUI.widgets.NiceMarqueeText r1 = r1.f24065b
                boolean r1 = r1.f24055p
                if (r1 == 0) goto L_0x005d
                com.xeagle.android.newUI.widgets.NiceMarqueeText$continueRoll$1 r1 = r6.f24067b
                com.xeagle.android.newUI.widgets.NiceMarqueeText r1 = r1.f24065b
                java.lang.String r1 = r1.f24061v
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x005d
                r3 = 10
                r6.f24066a = r2
                java.lang.Object r1 = kotlinx.coroutines.al.a(r3, r6)
                if (r1 != r0) goto L_0x0041
                return r0
            L_0x0041:
                com.xeagle.android.newUI.widgets.NiceMarqueeText$continueRoll$1 r1 = r6.f24067b
                com.xeagle.android.newUI.widgets.NiceMarqueeText r1 = r1.f24065b
                float r3 = r1.f24053n
                com.xeagle.android.newUI.widgets.NiceMarqueeText$continueRoll$1 r4 = r6.f24067b
                com.xeagle.android.newUI.widgets.NiceMarqueeText r4 = r4.f24065b
                float r4 = r4.f24043d
                float r3 = r3 - r4
                r1.f24053n = r3
                com.xeagle.android.newUI.widgets.NiceMarqueeText$continueRoll$1 r1 = r6.f24067b
                com.xeagle.android.newUI.widgets.NiceMarqueeText r1 = r1.f24065b
                r1.postInvalidate()
                goto L_0x001c
            L_0x005d:
                kotlin.l r6 = kotlin.l.f30254a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.widgets.NiceMarqueeText$continueRoll$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NiceMarqueeText$continueRoll$1(NiceMarqueeText niceMarqueeText, c cVar) {
        super(2, cVar);
        this.f24065b = niceMarqueeText;
    }

    public final Object a(Object obj, Object obj2) {
        return ((NiceMarqueeText$continueRoll$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new NiceMarqueeText$continueRoll$1(this.f24065b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = a.a();
        int i2 = this.f24064a;
        if (i2 == 0) {
            i.a(obj);
            this.f24064a = 1;
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
