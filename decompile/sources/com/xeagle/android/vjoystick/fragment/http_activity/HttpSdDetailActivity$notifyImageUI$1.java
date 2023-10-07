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

@d(b = "HttpSdDetailActivity.kt", c = {1403}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$notifyImageUI$1")
final class HttpSdDetailActivity$notifyImageUI$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25125a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HttpSdDetailActivity f25126b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f25127c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f25128d;

    @d(b = "HttpSdDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$notifyImageUI$1$1")
    /* renamed from: com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$notifyImageUI$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements m<af, c<? super l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f25129a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity$notifyImageUI$1 f25130b;

        {
            this.f25130b = r1;
        }

        public final Object a(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
        }

        public final c<l> create(Object obj, c<?> cVar) {
            h.d(cVar, "completion");
            return new AnonymousClass1(this.f25130b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            a.a();
            if (this.f25129a == 0) {
                i.a(obj);
                ToastUtils.showShort("下载成功", new Object[0]);
                HttpSdDetailActivity.g(this.f25130b.f25126b).notifyItemChanged(this.f25130b.f25127c);
                n.b(this.f25130b.f25126b);
                if (Build.VERSION.SDK_INT >= 30) {
                    b.a(new File(this.f25130b.f25128d), (Context) HttpSdDetailActivity.t(this.f25130b.f25126b));
                } else {
                    b.a((Context) HttpSdDetailActivity.t(this.f25130b.f25126b), new File(this.f25130b.f25128d));
                }
                return l.f30254a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpSdDetailActivity$notifyImageUI$1(HttpSdDetailActivity httpSdDetailActivity, int i2, String str, c cVar) {
        super(2, cVar);
        this.f25126b = httpSdDetailActivity;
        this.f25127c = i2;
        this.f25128d = str;
    }

    public final Object a(Object obj, Object obj2) {
        return ((HttpSdDetailActivity$notifyImageUI$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new HttpSdDetailActivity$notifyImageUI$1(this.f25126b, this.f25127c, this.f25128d, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = a.a();
        int i2 = this.f25125a;
        if (i2 == 0) {
            i.a(obj);
            this.f25125a = 1;
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
