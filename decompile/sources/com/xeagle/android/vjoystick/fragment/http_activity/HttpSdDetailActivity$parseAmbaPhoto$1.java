package com.xeagle.android.vjoystick.fragment.http_activity;

import java.util.ArrayList;
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

@d(b = "HttpSdDetailActivity.kt", c = {214}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$parseAmbaPhoto$1")
final class HttpSdDetailActivity$parseAmbaPhoto$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25139a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HttpSdDetailActivity f25140b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f25141c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f25142d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpSdDetailActivity$parseAmbaPhoto$1(HttpSdDetailActivity httpSdDetailActivity, String str, String str2, c cVar) {
        super(2, cVar);
        this.f25140b = httpSdDetailActivity;
        this.f25141c = str;
        this.f25142d = str2;
    }

    public final Object a(Object obj, Object obj2) {
        return ((HttpSdDetailActivity$parseAmbaPhoto$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new HttpSdDetailActivity$parseAmbaPhoto$1(this.f25140b, this.f25141c, this.f25142d, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = a.a();
        int i2 = this.f25139a;
        if (i2 == 0) {
            i.a(obj);
            this.f25139a = 1;
            obj = e.a(ap.c(), new HttpSdDetailActivity$parseAmbaPhoto$1$photoModels$1(this, (c) null), this);
            if (obj == a2) {
                return a2;
            }
        } else if (i2 == 1) {
            i.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f25140b.a((ArrayList<lc.a>) (ArrayList) obj);
        return l.f30254a;
    }
}
