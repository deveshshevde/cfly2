package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.cf;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.File;
import java.util.Arrays;

public final class cg extends ie {

    /* renamed from: a  reason: collision with root package name */
    private Context f8143a;

    /* renamed from: b  reason: collision with root package name */
    private IAMapDelegate f8144b;

    /* renamed from: c  reason: collision with root package name */
    private cf f8145c;

    /* renamed from: d  reason: collision with root package name */
    private String f8146d;

    /* renamed from: e  reason: collision with root package name */
    private String f8147e;

    /* renamed from: g  reason: collision with root package name */
    private String f8148g;

    /* renamed from: h  reason: collision with root package name */
    private a f8149h;

    /* renamed from: i  reason: collision with root package name */
    private int f8150i;

    public interface a {
        void a(byte[] bArr, int i2);

        void b(byte[] bArr, int i2);
    }

    public cg(Context context, a aVar, int i2, String str) {
        this.f8146d = null;
        this.f8147e = null;
        this.f8148g = null;
        boolean z2 = false;
        this.f8150i = 0;
        this.f8143a = context;
        this.f8149h = aVar;
        this.f8150i = i2;
        if (this.f8145c == null) {
            this.f8145c = new cf(context, "", i2 != 0 ? true : z2);
        }
        this.f8145c.b(str);
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(str == null ? "" : str);
        sb.append(".amapstyle");
        this.f8146d = sb.toString();
        this.f8147e = context.getCacheDir().getPath();
    }

    public cg(Context context, IAMapDelegate iAMapDelegate) {
        this.f8146d = null;
        this.f8147e = null;
        this.f8148g = null;
        this.f8150i = 0;
        this.f8143a = context;
        this.f8144b = iAMapDelegate;
        if (this.f8145c == null) {
            this.f8145c = new cf(context, "");
        }
    }

    private void a(String str, String str2) {
        if (str != null && str2 != null) {
            dh.a(this.f8143a, "amap_style_config", "lastModified".concat(String.valueOf(str)), str2);
        }
    }

    private void a(String str, byte[] bArr) {
        if (str != null && bArr != null && this.f8147e != null) {
            FileUtil.saveFileContents(this.f8147e + File.separator + str, bArr);
        }
    }

    private byte[] b(String str) {
        if (str == null || this.f8147e == null) {
            return null;
        }
        return FileUtil.readFileContents(this.f8147e + File.separator + str);
    }

    private String c(String str) {
        if (str == null) {
            return null;
        }
        Object b2 = dh.b(this.f8143a, "amap_style_config", "lastModified".concat(String.valueOf(str)), "");
        if (!(b2 instanceof String) || b2 == "") {
            return null;
        }
        return (String) b2;
    }

    public final void a() {
        this.f8143a = null;
        if (this.f8145c != null) {
            this.f8145c = null;
        }
    }

    public final void a(String str) {
        cf cfVar = this.f8145c;
        if (cfVar != null) {
            cfVar.c(str);
        }
        this.f8148g = str;
    }

    public final void b() {
        dj.a().a(this);
    }

    public final void runTask() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.f8145c != null) {
                    String str = this.f8148g + this.f8146d;
                    String c2 = c(str);
                    if (c2 != null) {
                        this.f8145c.d(c2);
                    }
                    byte[] b2 = b(str);
                    a aVar = this.f8149h;
                    if (!(aVar == null || b2 == null)) {
                        aVar.a(b2, this.f8150i);
                    }
                    cf.a aVar2 = (cf.a) this.f8145c.d();
                    if (!(aVar2 == null || aVar2.f8139a == null)) {
                        if (this.f8149h == null) {
                            IAMapDelegate iAMapDelegate = this.f8144b;
                            if (iAMapDelegate != null) {
                                iAMapDelegate.setCustomMapStyle(iAMapDelegate.getMapConfig().isCustomStyleEnable(), aVar2.f8139a);
                            }
                        } else if (!Arrays.equals(aVar2.f8139a, b2)) {
                            this.f8149h.b(aVar2.f8139a, this.f8150i);
                        }
                        a(str, aVar2.f8139a);
                        a(str, aVar2.f8141c);
                    }
                }
                fz.a(this.f8143a, dl.a());
                IAMapDelegate iAMapDelegate2 = this.f8144b;
                if (iAMapDelegate2 != null) {
                    iAMapDelegate2.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            fz.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
