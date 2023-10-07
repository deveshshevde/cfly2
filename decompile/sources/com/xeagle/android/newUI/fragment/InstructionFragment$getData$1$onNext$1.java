package com.xeagle.android.newUI.fragment;

import com.flypro.core.database.PdfData;
import com.flypro.core.database.PdfInfo;
import com.flypro.core.database.UserLiteHelper;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.newUI.fragment.a;
import com.xeagle.android.vjoystick.beans.PdfBean;
import java.util.Iterator;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.af;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.e;
import mm.m;

@d(b = "InstructionFragment.kt", c = {101}, d = "invokeSuspend", e = "com.xeagle.android.newUI.fragment.InstructionFragment$getData$1$onNext$1")
final class InstructionFragment$getData$1$onNext$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f23980a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a.C0149a f23981b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PdfBean f23982c;

    @d(b = "InstructionFragment.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.newUI.fragment.InstructionFragment$getData$1$onNext$1$1")
    /* renamed from: com.xeagle.android.newUI.fragment.InstructionFragment$getData$1$onNext$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements m<af, c<? super l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23983a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstructionFragment$getData$1$onNext$1 f23984b;

        {
            this.f23984b = r1;
        }

        public final Object a(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
        }

        public final c<l> create(Object obj, c<?> cVar) {
            h.d(cVar, "completion");
            return new AnonymousClass1(this.f23984b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.a();
            if (this.f23983a == 0) {
                i.a(obj);
                UserLiteHelper.deleteClass(PdfData.class);
                Iterator<PdfInfo> it2 = this.f23984b.f23982c.getPdfList().iterator();
                while (it2.hasNext()) {
                    UserLiteHelper.saveData(it2.next());
                }
                return l.f30254a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstructionFragment$getData$1$onNext$1(a.C0149a aVar, PdfBean pdfBean, c cVar) {
        super(2, cVar);
        this.f23981b = aVar;
        this.f23982c = pdfBean;
    }

    public final Object a(Object obj, Object obj2) {
        return ((InstructionFragment$getData$1$onNext$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new InstructionFragment$getData$1$onNext$1(this.f23981b, this.f23982c, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = kotlin.coroutines.intrinsics.a.a();
        int i2 = this.f23980a;
        if (i2 == 0) {
            i.a(obj);
            this.f23980a = 1;
            if (e.a(ap.c(), new AnonymousClass1(this, (c) null), this) == a2) {
                return a2;
            }
        } else if (i2 == 1) {
            i.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kk.e b2 = this.f23981b.f23992a.b();
        HostManagerActivity c2 = this.f23981b.f23992a.f23988c;
        h.a((Object) c2);
        b2.setNewData(UserLiteHelper.readDatabase(c2.getApplicationContext()));
        return l.f30254a;
    }
}
