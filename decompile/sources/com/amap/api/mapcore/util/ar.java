package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.mapcore.util.bg;
import com.amap.api.mapcore.util.bm;
import java.io.IOException;

public final class ar extends ie implements bg.a {

    /* renamed from: a  reason: collision with root package name */
    private bg f7863a;

    /* renamed from: b  reason: collision with root package name */
    private bi f7864b;

    /* renamed from: c  reason: collision with root package name */
    private bl f7865c;

    /* renamed from: d  reason: collision with root package name */
    private Context f7866d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f7867e;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7868g;

    private ar(bl blVar, Context context) {
        this.f7867e = new Bundle();
        this.f7868g = false;
        this.f7865c = blVar;
        this.f7866d = context;
    }

    public ar(bl blVar, Context context, byte b2) {
        this(blVar, context);
    }

    private String d() {
        return dl.c(this.f7866d);
    }

    private void e() throws IOException {
        bg bgVar = new bg(new bh(this.f7865c.getUrl(), d(), this.f7865c.v(), this.f7865c.w()), this.f7865c.getUrl(), this.f7866d, this.f7865c);
        this.f7863a = bgVar;
        bgVar.a((bg.a) this);
        bl blVar = this.f7865c;
        this.f7864b = new bi(blVar, blVar);
        if (!this.f7868g) {
            this.f7863a.a();
        }
    }

    public final void a() {
        this.f7868g = true;
        bg bgVar = this.f7863a;
        if (bgVar != null) {
            bgVar.b();
        } else {
            cancelTask();
        }
        bi biVar = this.f7864b;
        if (biVar != null) {
            biVar.a();
        }
    }

    public final void b() {
        Bundle bundle = this.f7867e;
        if (bundle != null) {
            bundle.clear();
            this.f7867e = null;
        }
    }

    public final void c() {
        bi biVar = this.f7864b;
        if (biVar != null) {
            biVar.b();
        }
    }

    public final void runTask() {
        if (this.f7865c.u()) {
            this.f7865c.a(bm.a.file_io_exception);
            return;
        }
        try {
            e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
