package com.xeagle.android.vjoystick.fragment.http_activity;

import android.content.Context;
import android.os.Build;
import com.blankj.utilcode.util.ToastUtils;
import com.xeagle.android.utils.n;
import java.io.File;
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
import ku.b;
import mm.m;

@d(b = "HttpSdDetailActivity.kt", c = {1198}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$notifyVideo$1")
final class HttpSdDetailActivity$notifyVideo$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25131a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HttpSdDetailActivity f25132b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f25133c;

    @d(b = "HttpSdDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$notifyVideo$1$1")
    /* renamed from: com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$notifyVideo$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements m<af, c<? super l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f25134a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity$notifyVideo$1 f25135b;

        {
            this.f25135b = r1;
        }

        public final Object a(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
        }

        public final c<l> create(Object obj, c<?> cVar) {
            h.d(cVar, "completion");
            return new AnonymousClass1(this.f25135b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            a.a();
            if (this.f25134a == 0) {
                i.a(obj);
                ToastUtils.showShort("下载成功", new Object[0]);
                n.b(this.f25135b.f25132b);
                if (Build.VERSION.SDK_INT >= 30) {
                    b.a(this.f25135b.f25133c, (Context) HttpSdDetailActivity.t(this.f25135b.f25132b));
                } else {
                    b.b(HttpSdDetailActivity.t(this.f25135b.f25132b), new File(this.f25135b.f25133c));
                }
                return l.f30254a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpSdDetailActivity$notifyVideo$1(HttpSdDetailActivity httpSdDetailActivity, String str, c cVar) {
        super(2, cVar);
        this.f25132b = httpSdDetailActivity;
        this.f25133c = str;
    }

    public final Object a(Object obj, Object obj2) {
        return ((HttpSdDetailActivity$notifyVideo$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new HttpSdDetailActivity$notifyVideo$1(this.f25132b, this.f25133c, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = a.a();
        int i2 = this.f25131a;
        if (i2 == 0) {
            i.a(obj);
            this.f25131a = 1;
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
