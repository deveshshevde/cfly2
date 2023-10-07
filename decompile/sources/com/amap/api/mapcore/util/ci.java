package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.ch;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;

public final class ci extends ie {

    /* renamed from: a  reason: collision with root package name */
    private Context f8153a;

    /* renamed from: b  reason: collision with root package name */
    private ch f8154b;

    /* renamed from: c  reason: collision with root package name */
    private co f8155c;

    /* renamed from: d  reason: collision with root package name */
    private a f8156d;

    public interface a {
        void a(String str, co coVar);
    }

    public ci(Context context) {
        this.f8153a = context;
        if (this.f8154b == null) {
            this.f8154b = new ch(context, "");
        }
    }

    private static String a(Context context) {
        return FileUtil.getMapBaseStorage(context);
    }

    private static void a(String str, byte[] bArr) {
        FileUtil.writeDatasToFile(str, bArr);
    }

    public final void a() {
        this.f8153a = null;
        if (this.f8154b != null) {
            this.f8154b = null;
        }
    }

    public final void a(a aVar) {
        this.f8156d = aVar;
    }

    public final void a(co coVar) {
        this.f8155c = coVar;
    }

    public final void a(String str) {
        ch chVar = this.f8154b;
        if (chVar != null) {
            chVar.b(str);
        }
    }

    public final void b() {
        dj.a().a(this);
    }

    public final void runTask() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                ch chVar = this.f8154b;
                if (chVar != null) {
                    ch.a aVar = (ch.a) chVar.d();
                    String str = null;
                    if (!(aVar == null || aVar.f8151a == null)) {
                        str = a(this.f8153a) + "/custom_texture_data";
                        a(str, aVar.f8151a);
                    }
                    a aVar2 = this.f8156d;
                    if (aVar2 != null) {
                        aVar2.a(str, this.f8155c);
                    }
                }
                fz.a(this.f8153a, dl.a());
            }
        } catch (Throwable th) {
            fz.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
