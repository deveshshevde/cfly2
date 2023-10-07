package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class gx extends fc {

    /* renamed from: e  reason: collision with root package name */
    protected Context f8987e;

    /* renamed from: f  reason: collision with root package name */
    protected ff f8988f;

    public gx(Context context, ff ffVar) {
        if (context != null) {
            this.f8987e = context.getApplicationContext();
        }
        this.f8988f = ffVar;
        setBinary(true);
    }

    private static byte[] a(byte[] bArr) {
        return fg.a(bArr.length);
    }

    private static byte[] i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(fg.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                fw.a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            fw.a(th2, "bre", "gbh");
            return null;
        }
    }

    private byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (f()) {
                Context context = this.f8987e;
                boolean h2 = h();
                ff ffVar = this.f8988f;
                byte[] a2 = ey.a(context, h2, ffVar != null && "navi".equals(ffVar.a()));
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a3 = fg.a(e());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] a4 = fg.a(g());
            if (a4 == null || a4.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a4));
                byteArrayOutputStream.write(a4);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                fw.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            fw.a(th2, "bre", "gred");
        }
        return new byte[]{0};
    }

    private byte[] k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c2 = c();
            if (c2 != null) {
                if (c2.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(a(c2));
                    byteArrayOutputStream.write(c2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        fw.a(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                fw.a(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            fw.a(th3, "bre", "grrd");
        }
        return new byte[]{0};
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] d2 = d();
            if (d2 != null) {
                if (d2.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] a2 = ey.a(d2);
                    byteArrayOutputStream.write(a(a2));
                    byteArrayOutputStream.write(a2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        fw.a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                fw.a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            fw.a(th3, "bre", "gred");
        }
        return new byte[]{0};
    }

    public abstract byte[] c();

    public abstract byte[] d();

    /* access modifiers changed from: protected */
    public String e() {
        return "2.1";
    }

    public boolean f() {
        return true;
    }

    public String g() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.f8988f.c(), this.f8988f.a()});
    }

    public final byte[] getEntityBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(i());
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(k());
            byteArrayOutputStream.write(l());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                fw.a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            fw.a(th2, "bre", "geb");
            return null;
        }
    }

    public Map<String, String> getParams() {
        String f2 = ev.f(this.f8987e);
        String a2 = ey.a();
        String a3 = ey.a(this.f8987e, a2, "key=".concat(String.valueOf(f2)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a2);
        hashMap.put("key", f2);
        hashMap.put("scode", a3);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return false;
    }
}
