package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.cg;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public final class a implements cg.a {
    private boolean A = false;
    private HashMap<String, byte[]> B = new HashMap<>();
    private MyTrafficStyle C = new MyTrafficStyle();
    private C0072a D;

    /* renamed from: a  reason: collision with root package name */
    private final String f7677a = "__MACOSX";

    /* renamed from: b  reason: collision with root package name */
    private IAMapDelegate f7678b;

    /* renamed from: c  reason: collision with root package name */
    private CustomMapStyleOptions f7679c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7680d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7681e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7682f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7683g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7684h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f7685i = 1;

    /* renamed from: j  reason: collision with root package name */
    private Context f7686j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f7687k = null;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f7688l = null;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f7689m = null;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f7690n = null;

    /* renamed from: o  reason: collision with root package name */
    private byte[] f7691o = null;

    /* renamed from: p  reason: collision with root package name */
    private boolean f7692p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f7693q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f7694r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f7695s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f7696t = false;

    /* renamed from: u  reason: collision with root package name */
    private cg f7697u;

    /* renamed from: v  reason: collision with root package name */
    private cg f7698v;

    /* renamed from: w  reason: collision with root package name */
    private byte[] f7699w = null;

    /* renamed from: x  reason: collision with root package name */
    private byte[] f7700x = null;

    /* renamed from: y  reason: collision with root package name */
    private byte[] f7701y = null;

    /* renamed from: z  reason: collision with root package name */
    private boolean f7702z = false;

    /* renamed from: com.amap.api.mapcore.util.a$a  reason: collision with other inner class name */
    public interface C0072a {
        void a();
    }

    public a(IAMapDelegate iAMapDelegate, Context context, boolean z2) {
        this.f7678b = iAMapDelegate;
        this.f7686j = context;
        this.f7692p = false;
        this.f7693q = false;
        this.A = z2;
    }

    private void a(MapConfig mapConfig) {
        byte[] bArr;
        if (!mapConfig.isProFunctionAuthEnable()) {
            this.B.clear();
            return;
        }
        String styleResDataPath = this.f7679c.getStyleResDataPath();
        if (this.f7679c.getStyleResData() == null && !TextUtils.isEmpty(styleResDataPath)) {
            this.f7679c.setStyleResData(FileUtil.readFileContents(styleResDataPath));
        }
        if (this.f7679c.getStyleResData() != null || this.f7701y != null) {
            byte[] bArr2 = this.f7701y;
            if (bArr2 == null) {
                bArr2 = this.f7679c.getStyleResData();
            }
            if (bArr2 != null) {
                mapConfig.setUseProFunction(true);
                this.B.clear();
                Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr2, (String[]) null);
                if (uncompressToByteWithKeys != null) {
                    for (String next : uncompressToByteWithKeys.keySet()) {
                        if (!(next == null || next.contains("__MACOSX") || (bArr = uncompressToByteWithKeys.get(next)) == null)) {
                            if (FileUtil.isGzip(bArr)) {
                                this.B.put(next, bArr);
                            } else {
                                this.B.put(next, FileUtil.compress(bArr));
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(String str, boolean z2) {
        boolean z3;
        int a2 = !TextUtils.isEmpty(str) ? cn.a(str) : Integer.MIN_VALUE;
        IAMapDelegate iAMapDelegate = this.f7678b;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null) {
            if (this.f7689m == null) {
                Context context = this.f7686j;
                this.f7689m = FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
            }
            byte[] bArr = this.f7689m;
            if (bArr != null) {
                if (!z2) {
                    a2 = 0;
                } else if (a2 == Integer.MIN_VALUE) {
                    z3 = true;
                    this.f7678b.getGLMapEngine().setBackgroundTexture(this.f7685i, dl.a((byte[]) bArr.clone(), 0, a2, z3));
                }
                z3 = false;
                this.f7678b.getGLMapEngine().setBackgroundTexture(this.f7685i, dl.a((byte[]) bArr.clone(), 0, a2, z3));
            }
        }
    }

    private void a(byte[] bArr) {
        ck a2;
        JSONObject optJSONObject;
        if (bArr != null && (a2 = cn.a(bArr)) != null && a2.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(a2.a());
                JSONObject optJSONObject2 = jSONObject.optJSONObject("bg");
                String str = null;
                boolean z2 = true;
                if (optJSONObject2 != null) {
                    z2 = optJSONObject2.optBoolean("visible", true);
                    str = optJSONObject2.optString("lineColor", (String) null);
                }
                a(str, z2);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("traffic");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("multiFillColors")) != null) {
                    int a3 = cn.a(optJSONObject.optString("smooth"));
                    int a4 = cn.a(optJSONObject.optString("slow"));
                    int a5 = cn.a(optJSONObject.optString("congested"));
                    int a6 = cn.a(optJSONObject.optString("seriousCongested"));
                    this.C.setSmoothColor(a3);
                    this.C.setSlowColor(a4);
                    this.C.setCongestedColor(a5);
                    this.C.setSeriousCongestedColor(a6);
                }
            } catch (Throwable th) {
                fz.c(th, "AMapCustomStyleManager", "setExtraStyle");
                dl.a(th);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r3.indexOf("99999_");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r3) {
        /*
            if (r3 != 0) goto L_0x0003
            return r3
        L_0x0003:
            java.lang.String r0 = "99999_"
            int r1 = r3.indexOf(r0)
            r2 = -1
            if (r1 != r2) goto L_0x000d
            return r3
        L_0x000d:
            r2 = 0
            java.lang.String r3 = r3.substring(r2, r1)
            java.lang.String r1 = ""
            java.lang.String r3 = r3.replace(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.a.b(java.lang.String):java.lang.String");
    }

    private static boolean b(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            if (bArr.length < 8) {
                return false;
            }
            return ((bArr[4] & 255) | ((((bArr[7] << 24) & -16777216) | ((bArr[6] << 16) & 16711680)) | ((bArr[5] << 8) & 65280))) == 2001;
        } catch (Throwable th) {
            fz.c(th, "AMapCustomStyleManager", "checkData");
            dl.a(th);
        }
    }

    private static byte[] c(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read >= 0) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        GLFileUtil.closeQuietly(byteArrayOutputStream);
                        GLFileUtil.closeQuietly(byteArrayInputStream);
                        GLFileUtil.closeQuietly(gZIPInputStream);
                        return byteArray;
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    dl.a(th);
                    th.printStackTrace();
                    return null;
                } finally {
                    GLFileUtil.closeQuietly(byteArrayOutputStream);
                    GLFileUtil.closeQuietly(byteArrayInputStream);
                    GLFileUtil.closeQuietly(gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream = null;
            dl.a(th);
            th.printStackTrace();
            return null;
        }
    }

    private void f() {
        IAMapDelegate iAMapDelegate = this.f7678b;
        if (!(iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null || this.f7689m == null)) {
            this.f7678b.getGLMapEngine().setBackgroundTexture(this.f7685i, this.f7689m);
        }
        this.f7696t = false;
    }

    private void g() {
        if (this.A) {
            if (this.f7688l == null) {
                Context context = this.f7686j;
                this.f7688l = c(FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_ABROAD));
            }
        } else if (this.f7688l == null) {
            Context context2 = this.f7686j;
            this.f7688l = c(FileUtil.readFileContentsFromAssets(context2, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA));
        }
        this.f7678b.getGLMapEngine().setCustomStyleData(this.f7685i, this.f7688l, this.f7687k);
        this.f7695s = false;
        this.B.clear();
    }

    private void h() {
        if (this.f7694r) {
            if (this.f7690n == null) {
                Context context = this.f7686j;
                this.f7690n = FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
            }
            this.f7694r = false;
            this.f7678b.getGLMapEngine().setCustomStyleTexture(this.f7685i, this.f7690n);
        }
    }

    private void i() {
        CustomMapStyleOptions customMapStyleOptions = this.f7679c;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId((String) null);
            this.f7679c.setStyleDataPath((String) null);
            this.f7679c.setStyleData((byte[]) null);
            this.f7679c.setStyleTexturePath((String) null);
            this.f7679c.setStyleTextureData((byte[]) null);
            this.f7679c.setStyleExtraData((byte[]) null);
            this.f7679c.setStyleExtraPath((String) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01f2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r12 = this;
            com.amap.api.maps.model.CustomMapStyleOptions r0 = r12.f7679c
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r12.f7693q
            if (r0 == 0) goto L_0x000a
            return
        L_0x000a:
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = r12.f7678b     // Catch:{ all -> 0x01f6 }
            com.autonavi.base.amap.mapcore.MapConfig r0 = r0.getMapConfig()     // Catch:{ all -> 0x01f6 }
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            monitor-enter(r12)     // Catch:{ all -> 0x01f6 }
            boolean r1 = r0.isHideLogoEnable()     // Catch:{ all -> 0x01f3 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x005d
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x005d
            com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate r1 = r1.getUiSettings()     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x005d
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate r1 = r1.getUiSettings()     // Catch:{ all -> 0x01f3 }
            boolean r1 = r1.isLogoEnable()     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x0052
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            boolean r1 = r1.isEnable()     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x0048
            boolean r1 = r12.f7695s     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x005d
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate r1 = r1.getUiSettings()     // Catch:{ all -> 0x01f3 }
            r1.setLogoEnable(r3)     // Catch:{ all -> 0x01f3 }
            goto L_0x005d
        L_0x0048:
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate r1 = r1.getUiSettings()     // Catch:{ all -> 0x01f3 }
        L_0x004e:
            r1.setLogoEnable(r2)     // Catch:{ all -> 0x01f3 }
            goto L_0x005d
        L_0x0052:
            boolean r1 = r12.f7695s     // Catch:{ all -> 0x01f3 }
            if (r1 != 0) goto L_0x005d
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate r1 = r1.getUiSettings()     // Catch:{ all -> 0x01f3 }
            goto L_0x004e
        L_0x005d:
            boolean r1 = r12.f7680d     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x00c8
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            boolean r1 = r1.isEnable()     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x0080
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.ae.gmap.GLMapEngine r4 = r1.getGLMapEngine()     // Catch:{ all -> 0x01f3 }
            int r5 = r12.f7685i     // Catch:{ all -> 0x01f3 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4.setNativeMapModeAndStyle(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01f3 }
            r0.setCustomStyleEnable(r2)     // Catch:{ all -> 0x01f3 }
            r12.f7680d = r3     // Catch:{ all -> 0x01f3 }
            goto L_0x00c8
        L_0x0080:
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.ae.gmap.GLMapEngine r4 = r1.getGLMapEngine()     // Catch:{ all -> 0x01f3 }
            int r5 = r12.f7685i     // Catch:{ all -> 0x01f3 }
            int r6 = r0.getMapStyleMode()     // Catch:{ all -> 0x01f3 }
            int r7 = r0.getMapStyleTime()     // Catch:{ all -> 0x01f3 }
            int r8 = r0.getMapStyleState()     // Catch:{ all -> 0x01f3 }
            r9 = 0
            r10 = 0
            r11 = 0
            r4.setNativeMapModeAndStyle(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01f3 }
            r12.f7695s = r3     // Catch:{ all -> 0x01f3 }
            boolean r1 = r0.isCustomStyleEnable()     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x00c4
            int r1 = r0.getMapStyleMode()     // Catch:{ all -> 0x01f3 }
            if (r1 != 0) goto L_0x00b7
            int r1 = r0.getMapStyleTime()     // Catch:{ all -> 0x01f3 }
            if (r1 != 0) goto L_0x00b7
            int r1 = r0.getMapStyleState()     // Catch:{ all -> 0x01f3 }
            if (r1 != 0) goto L_0x00b7
            r12.g()     // Catch:{ all -> 0x01f3 }
        L_0x00b7:
            r12.h()     // Catch:{ all -> 0x01f3 }
            boolean r1 = r12.f7696t     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x00c1
            r12.f()     // Catch:{ all -> 0x01f3 }
        L_0x00c1:
            r0.setCustomStyleEnable(r3)     // Catch:{ all -> 0x01f3 }
        L_0x00c4:
            r12.f7680d = r3     // Catch:{ all -> 0x01f3 }
            monitor-exit(r12)     // Catch:{ all -> 0x01f3 }
            return
        L_0x00c8:
            boolean r1 = r12.f7682f     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x011b
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            java.lang.String r1 = r1.getStyleTexturePath()     // Catch:{ all -> 0x01f3 }
            com.amap.api.maps.model.CustomMapStyleOptions r4 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            byte[] r4 = r4.getStyleTextureData()     // Catch:{ all -> 0x01f3 }
            if (r4 != 0) goto L_0x00e9
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01f3 }
            if (r4 != 0) goto L_0x00e9
            byte[] r1 = com.autonavi.base.amap.mapcore.FileUtil.readFileContents(r1)     // Catch:{ all -> 0x01f3 }
            com.amap.api.maps.model.CustomMapStyleOptions r4 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            r4.setStyleTextureData(r1)     // Catch:{ all -> 0x01f3 }
        L_0x00e9:
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            byte[] r1 = r1.getStyleTextureData()     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x0114
            r12.f7702z = r2     // Catch:{ all -> 0x01f3 }
            boolean r1 = r0.isProFunctionAuthEnable()     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x0110
            r12.f7694r = r2     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.ae.gmap.GLMapEngine r1 = r1.getGLMapEngine()     // Catch:{ all -> 0x01f3 }
            int r4 = r12.f7685i     // Catch:{ all -> 0x01f3 }
            com.amap.api.maps.model.CustomMapStyleOptions r5 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            byte[] r5 = r5.getStyleTextureData()     // Catch:{ all -> 0x01f3 }
            r1.setCustomStyleTexture(r4, r5)     // Catch:{ all -> 0x01f3 }
            r0.setUseProFunction(r2)     // Catch:{ all -> 0x01f3 }
            goto L_0x0119
        L_0x0110:
            r12.h()     // Catch:{ all -> 0x01f3 }
            goto L_0x0119
        L_0x0114:
            r12.h()     // Catch:{ all -> 0x01f3 }
            r12.f7702z = r3     // Catch:{ all -> 0x01f3 }
        L_0x0119:
            r12.f7682f = r3     // Catch:{ all -> 0x01f3 }
        L_0x011b:
            boolean r1 = r12.f7681e     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x01a7
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            java.lang.String r1 = r1.getStyleDataPath()     // Catch:{ all -> 0x01f3 }
            com.amap.api.maps.model.CustomMapStyleOptions r4 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            byte[] r4 = r4.getStyleData()     // Catch:{ all -> 0x01f3 }
            if (r4 != 0) goto L_0x013c
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01f3 }
            if (r4 != 0) goto L_0x013c
            byte[] r1 = com.autonavi.base.amap.mapcore.FileUtil.readFileContents(r1)     // Catch:{ all -> 0x01f3 }
            com.amap.api.maps.model.CustomMapStyleOptions r4 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            r4.setStyleData(r1)     // Catch:{ all -> 0x01f3 }
        L_0x013c:
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            byte[] r1 = r1.getStyleData()     // Catch:{ all -> 0x01f3 }
            if (r1 != 0) goto L_0x0155
            byte[] r1 = r12.f7699w     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x0149
            goto L_0x0155
        L_0x0149:
            boolean r1 = r12.f7695s     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x01a5
            r12.f7680d = r2     // Catch:{ all -> 0x01f3 }
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            r1.setEnable(r3)     // Catch:{ all -> 0x01f3 }
            goto L_0x01a5
        L_0x0155:
            byte[] r1 = r12.f7691o     // Catch:{ all -> 0x01f3 }
            if (r1 != 0) goto L_0x017a
            android.content.Context r1 = r12.f7686j     // Catch:{ all -> 0x01f3 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f3 }
            java.lang.String r5 = "map_assets"
            r4.<init>(r5)     // Catch:{ all -> 0x01f3 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ all -> 0x01f3 }
            r4.append(r5)     // Catch:{ all -> 0x01f3 }
            java.lang.String r5 = "style-for-custom_0_17_1594719935.data"
            r4.append(r5)     // Catch:{ all -> 0x01f3 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01f3 }
            byte[] r1 = com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(r1, r4)     // Catch:{ all -> 0x01f3 }
            byte[] r1 = c(r1)     // Catch:{ all -> 0x01f3 }
            r12.f7691o = r1     // Catch:{ all -> 0x01f3 }
        L_0x017a:
            byte[] r1 = r12.f7699w     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x017f
            goto L_0x0185
        L_0x017f:
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            byte[] r1 = r1.getStyleData()     // Catch:{ all -> 0x01f3 }
        L_0x0185:
            boolean r4 = b((byte[]) r1)     // Catch:{ all -> 0x01f3 }
            if (r4 != 0) goto L_0x018f
            com.amap.api.mapcore.util.cr.a()     // Catch:{ all -> 0x01f3 }
            goto L_0x01a5
        L_0x018f:
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r4 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.ae.gmap.GLMapEngine r4 = r4.getGLMapEngine()     // Catch:{ all -> 0x01f3 }
            int r5 = r12.f7685i     // Catch:{ all -> 0x01f3 }
            byte[] r6 = r12.f7691o     // Catch:{ all -> 0x01f3 }
            r4.setCustomStyleData(r5, r1, r6)     // Catch:{ all -> 0x01f3 }
            r12.f7695s = r2     // Catch:{ all -> 0x01f3 }
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r1 = r12.f7678b     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x01a5
            r1.resetRenderTime()     // Catch:{ all -> 0x01f3 }
        L_0x01a5:
            r12.f7681e = r3     // Catch:{ all -> 0x01f3 }
        L_0x01a7:
            boolean r1 = r12.f7683g     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x01e8
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            java.lang.String r1 = r1.getStyleExtraPath()     // Catch:{ all -> 0x01f3 }
            com.amap.api.maps.model.CustomMapStyleOptions r4 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            byte[] r4 = r4.getStyleExtraData()     // Catch:{ all -> 0x01f3 }
            if (r4 != 0) goto L_0x01c8
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01f3 }
            if (r4 != 0) goto L_0x01c8
            byte[] r1 = com.autonavi.base.amap.mapcore.FileUtil.readFileContents(r1)     // Catch:{ all -> 0x01f3 }
            com.amap.api.maps.model.CustomMapStyleOptions r4 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            r4.setStyleExtraData(r1)     // Catch:{ all -> 0x01f3 }
        L_0x01c8:
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            byte[] r1 = r1.getStyleExtraData()     // Catch:{ all -> 0x01f3 }
            if (r1 != 0) goto L_0x01d4
            byte[] r1 = r12.f7700x     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x01e6
        L_0x01d4:
            byte[] r1 = r12.f7700x     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x01d9
            goto L_0x01df
        L_0x01d9:
            com.amap.api.maps.model.CustomMapStyleOptions r1 = r12.f7679c     // Catch:{ all -> 0x01f3 }
            byte[] r1 = r1.getStyleExtraData()     // Catch:{ all -> 0x01f3 }
        L_0x01df:
            if (r1 == 0) goto L_0x01e6
            r12.a((byte[]) r1)     // Catch:{ all -> 0x01f3 }
            r12.f7696t = r2     // Catch:{ all -> 0x01f3 }
        L_0x01e6:
            r12.f7683g = r3     // Catch:{ all -> 0x01f3 }
        L_0x01e8:
            boolean r1 = r12.f7684h     // Catch:{ all -> 0x01f3 }
            if (r1 == 0) goto L_0x01f1
            r12.a((com.autonavi.base.amap.mapcore.MapConfig) r0)     // Catch:{ all -> 0x01f3 }
            r12.f7684h = r3     // Catch:{ all -> 0x01f3 }
        L_0x01f1:
            monitor-exit(r12)     // Catch:{ all -> 0x01f3 }
            return
        L_0x01f3:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x01f3 }
            throw r0     // Catch:{ all -> 0x01f6 }
        L_0x01f6:
            r0 = move-exception
            java.lang.String r1 = "AMapCustomStyleManager"
            java.lang.String r2 = "updateStyle"
            com.amap.api.mapcore.util.fz.c(r0, r1, r2)
            com.amap.api.mapcore.util.dl.a((java.lang.Throwable) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.a.a():void");
    }

    public final void a(C0072a aVar) {
        this.D = aVar;
    }

    public final void a(CustomMapStyleOptions customMapStyleOptions) {
        IAMapDelegate iAMapDelegate;
        if (this.f7679c != null && customMapStyleOptions != null) {
            synchronized (this) {
                if (!this.f7692p) {
                    this.f7692p = true;
                    if (this.f7679c.isEnable()) {
                        this.f7680d = true;
                    }
                }
                if (this.f7679c.isEnable() != customMapStyleOptions.isEnable()) {
                    this.f7679c.setEnable(customMapStyleOptions.isEnable());
                    this.f7680d = true;
                    di.b(this.f7686j, customMapStyleOptions.isEnable());
                }
                if (this.f7679c.isEnable()) {
                    if (!TextUtils.equals(this.f7679c.getStyleId(), customMapStyleOptions.getStyleId())) {
                        this.f7679c.setStyleId(customMapStyleOptions.getStyleId());
                        String styleId = this.f7679c.getStyleId();
                        if (!TextUtils.isEmpty(styleId) && (iAMapDelegate = this.f7678b) != null && iAMapDelegate.getMapConfig() != null && this.f7678b.getMapConfig().isProFunctionAuthEnable()) {
                            if (this.f7697u == null) {
                                this.f7697u = this.A ? new cg(this.f7686j, this, 2, "abroad_sdk_json_sdk_780_zip") : new cg(this.f7686j, this, 1, "sdk_780");
                            }
                            this.f7697u.a(styleId);
                            this.f7697u.b();
                            if (this.f7698v == null) {
                                this.f7698v = new cg(this.f7686j, this, 0, (String) null);
                            }
                            this.f7698v.a(styleId);
                            this.f7698v.b();
                        }
                    }
                    if (!TextUtils.equals(this.f7679c.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                        this.f7679c.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                        this.f7681e = true;
                    }
                    if (this.f7679c.getStyleData() != customMapStyleOptions.getStyleData()) {
                        this.f7679c.setStyleData(customMapStyleOptions.getStyleData());
                        this.f7681e = true;
                    }
                    if (!TextUtils.equals(this.f7679c.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                        this.f7679c.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                        this.f7682f = true;
                    }
                    if (this.f7679c.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                        this.f7679c.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                        this.f7682f = true;
                    }
                    if (!TextUtils.equals(this.f7679c.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                        this.f7679c.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                        this.f7683g = true;
                    }
                    if (this.f7679c.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                        this.f7679c.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                        this.f7683g = true;
                    }
                    if (!TextUtils.equals(this.f7679c.getStyleResDataPath(), customMapStyleOptions.getStyleResDataPath())) {
                        this.f7679c.setStyleResDataPath(customMapStyleOptions.getStyleResDataPath());
                        this.f7684h = true;
                    }
                    if (this.f7679c.getStyleResData() != customMapStyleOptions.getStyleResData()) {
                        this.f7679c.setStyleResData(customMapStyleOptions.getStyleResData());
                        this.f7684h = true;
                    }
                    di.a(this.f7686j, true);
                } else {
                    i();
                    di.a(this.f7686j, false);
                }
            }
        }
    }

    public final void a(byte[] bArr, int i2) {
        b(bArr, i2);
    }

    public final byte[] a(String str) {
        MapConfig mapConfig;
        if (str == null || (mapConfig = this.f7678b.getMapConfig()) == null) {
            return null;
        }
        if (!mapConfig.isProFunctionAuthEnable()) {
            return FileUtil.readFileContentsFromAssetsByPreName(this.f7686j, AMapEngineUtils.MAP_MAP_ASSETS_NAME, b(str));
        }
        for (String next : this.B.keySet()) {
            if (str.contains(next)) {
                return this.B.get(next);
            }
        }
        return null;
    }

    public final void b() {
        if (this.f7679c != null) {
            synchronized (this) {
                IAMapDelegate iAMapDelegate = this.f7678b;
                if (!(iAMapDelegate == null || iAMapDelegate.getMapConfig() == null || this.f7678b.getMapConfig().isProFunctionAuthEnable())) {
                    this.f7679c.setStyleId((String) null);
                    this.f7699w = null;
                    this.f7700x = null;
                    this.f7701y = null;
                }
                this.f7682f = true;
                this.f7681e = true;
                if (this.f7696t) {
                    this.f7683g = true;
                }
                this.f7680d = true;
                this.f7684h = true;
            }
        }
    }

    public final void b(byte[] bArr, int i2) {
        MapConfig mapConfig;
        C0072a aVar;
        if (this.f7679c != null) {
            synchronized (this) {
                IAMapDelegate iAMapDelegate = this.f7678b;
                if (!(iAMapDelegate == null || (mapConfig = iAMapDelegate.getMapConfig()) == null || !mapConfig.isProFunctionAuthEnable())) {
                    mapConfig.setUseProFunction(true);
                    if (i2 == 1) {
                        this.f7699w = bArr;
                        this.f7681e = true;
                    } else if (i2 == 0) {
                        this.f7700x = bArr;
                        this.f7683g = true;
                    } else if (i2 == 2) {
                        String str = this.f7679c.getStyleId() + "_sdk_780.data";
                        String str2 = this.f7679c.getStyleId() + "_abroad_sdk.json";
                        Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr, new String[]{str, str2});
                        if (uncompressToByteWithKeys != null) {
                            byte[] bArr2 = uncompressToByteWithKeys.get(str);
                            if (bArr2 != null) {
                                this.f7699w = bArr2;
                                this.f7681e = true;
                            }
                            if (!(uncompressToByteWithKeys.get(str2) == null || (aVar = this.D) == null)) {
                                aVar.a();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c() {
        if (this.f7679c == null) {
            this.f7679c = new CustomMapStyleOptions();
        }
    }

    public final boolean d() {
        return this.f7679c != null;
    }

    public final void e() {
        synchronized (this) {
            CustomMapStyleOptions customMapStyleOptions = this.f7679c;
            if (customMapStyleOptions != null) {
                customMapStyleOptions.setEnable(false);
                i();
                this.f7680d = true;
            }
        }
    }
}
