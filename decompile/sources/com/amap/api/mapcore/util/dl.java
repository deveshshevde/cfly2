package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.mapcore.util.ff;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import fg.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dl {

    /* renamed from: a  reason: collision with root package name */
    private static FPoint[] f8264a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};

    /* renamed from: b  reason: collision with root package name */
    private static List<Float> f8265b = new ArrayList(4);

    /* renamed from: c  reason: collision with root package name */
    private static List<Float> f8266c = new ArrayList(4);

    private static double a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return ((d4 - d2) * (d7 - d3)) - ((d6 - d2) * (d5 - d3));
    }

    private static double a(float f2, double d2, double d3) {
        double d4 = (double) f2;
        Double.isNaN(d4);
        return 20.0d - (Math.log(d3 / (d2 * d4)) / Math.log(2.0d));
    }

    private static float a(float f2, float f3, double d2) {
        double pow = Math.pow(2.0d, (double) (20.0f - f3));
        double d3 = (double) f2;
        Double.isNaN(d3);
        return (float) (d2 / (pow * d3));
    }

    private static float a(float f2, float f3, float f4) {
        double d2 = (double) f4;
        double pow = Math.pow(2.0d, (double) (20.0f - f3));
        Double.isNaN(d2);
        double d3 = (double) f2;
        Double.isNaN(d3);
        return (float) (d2 * pow * d3);
    }

    public static float a(IGLMapState iGLMapState, int i2, int i3, double d2, double d3, int i4) {
        IPoint obtain = IPoint.obtain();
        VirtualEarthProjection.latLongToPixels(d2, d3, 20, obtain);
        float a2 = a(iGLMapState, i2, i3, obtain.x, obtain.y, i4);
        obtain.recycle();
        return a2;
    }

    private static float a(IGLMapState iGLMapState, int i2, int i3, int i4, int i5, int i6) {
        if (iGLMapState != null) {
            return iGLMapState.calculateMapZoomer(i2, i3, i4, i5, i6);
        }
        return 3.0f;
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d2 = dPoint.f10009x;
        double d3 = dPoint2.f10009x;
        return (float) ((Math.atan2(dPoint2.f10010y - dPoint.f10010y, d3 - d2) / 3.141592653589793d) * 180.0d);
    }

    public static float a(IMapConfig iMapConfig, float f2) {
        if (iMapConfig != null) {
            return f2 > iMapConfig.getMaxZoomLevel() ? iMapConfig.getMaxZoomLevel() : f2 < iMapConfig.getMinZoomLevel() ? iMapConfig.getMinZoomLevel() : f2;
        }
        if (f2 > 20.0f) {
            return 20.0f;
        }
        if (f2 < 3.0f) {
            return 3.0f;
        }
        return f2;
    }

    public static float a(IMapConfig iMapConfig, float f2, float f3) {
        boolean z2;
        boolean z3 = false;
        if (iMapConfig != null) {
            boolean isAbroadEnable = iMapConfig.isAbroadEnable();
            if (iMapConfig.getAbroadState() != 1) {
                z3 = true;
            }
            boolean z4 = isAbroadEnable;
            z2 = z3;
            z3 = z4;
        } else {
            z2 = false;
        }
        float f4 = 0.0f;
        if (f2 >= 0.0f) {
            f4 = f2;
        }
        if (!z3 || !z2) {
            if (iMapConfig == null || !iMapConfig.isTerrainEnable()) {
                if (f2 <= 40.0f) {
                    return f4;
                }
                float f5 = (float) (f3 <= 15.0f ? 40 : f3 <= 16.0f ? 56 : f3 <= 17.0f ? 66 : f3 <= 18.0f ? 74 : f3 <= 18.0f ? 78 : 80);
                return f4 > f5 ? f5 : f4;
            } else if (f4 > 80.0f) {
                return 80.0f;
            } else {
                return f4;
            }
        } else if (f4 > 40.0f) {
            return 40.0f;
        } else {
            return f4;
        }
    }

    public static float a(IMapConfig iMapConfig, int i2, int i3, int i4, int i5, int i6, int i7) {
        float sz = iMapConfig.getSZ();
        if (i2 == i4 || i3 == i5) {
            return sz;
        }
        return Math.max((float) a(iMapConfig.getMapZoomScale(), (double) i6, (double) Math.abs(i4 - i2)), (float) a(iMapConfig.getMapZoomScale(), (double) i7, (double) Math.abs(i5 - i3)));
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Context context, String str) {
        try {
            InputStream open = df.a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            fz.c(th, "Util", "fromAsset");
            a(th);
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f2), (int) (((float) bitmap.getHeight()) * f2), true);
    }

    public static Bitmap a(View view) {
        try {
            c(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            fz.c(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap a(int[] iArr, int i2, int i3) {
        return a(iArr, i2, i3, false);
    }

    public static Bitmap a(int[] iArr, int i2, int i3, boolean z2) {
        try {
            int[] iArr2 = new int[iArr.length];
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = (i4 * i2) + i5;
                    int i7 = iArr[i6];
                    int i8 = (i7 & -16711936) | ((i7 << 16) & 16711680) | ((i7 >> 16) & 255);
                    if (z2) {
                        iArr2[(((i3 - i4) - 1) * i2) + i5] = i8;
                    } else {
                        iArr2[i6] = i8;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i2, 0, 0, i2, i3);
            return createBitmap;
        } catch (Throwable th) {
            fz.c(th, "Util", "rgbaToArgb");
            th.printStackTrace();
            return null;
        }
    }

    public static Pair<Float, IPoint> a(AbstractCameraUpdateMessage abstractCameraUpdateMessage, IMapConfig iMapConfig) {
        LatLngBounds latLngBounds = abstractCameraUpdateMessage.bounds;
        int i2 = abstractCameraUpdateMessage.width;
        int i3 = abstractCameraUpdateMessage.height;
        return a(iMapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), latLngBounds, i2, i3);
    }

    public static Pair<Float, IPoint> a(IMapConfig iMapConfig, int i2, int i3, int i4, int i5, LatLngBounds latLngBounds, int i6, int i7) {
        float f2;
        int i8;
        float f3;
        float f4;
        float f5;
        LatLngBounds latLngBounds2 = latLngBounds;
        if (latLngBounds2 == null || latLngBounds2.northeast == null || latLngBounds2.southwest == null || iMapConfig == null) {
            return null;
        }
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLngBounds2.northeast.latitude, latLngBounds2.northeast.longitude, 20);
        Point latLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLngBounds2.southwest.latitude, latLngBounds2.southwest.longitude, 20);
        int i9 = latLongToPixels.x - latLongToPixels2.x;
        int i10 = latLongToPixels2.y - latLongToPixels.y;
        int i11 = i6 - (i2 + i3);
        int i12 = i7 - (i4 + i5);
        if (i9 < 0 && i10 < 0) {
            return null;
        }
        int i13 = i9 <= 0 ? 1 : i9;
        int i14 = i10 <= 0 ? 1 : i10;
        Pair<Float, Boolean> b2 = b(iMapConfig, latLongToPixels.x, latLongToPixels.y, latLongToPixels2.x, latLongToPixels2.y, i11 <= 0 ? 1 : i11, i12 <= 0 ? 1 : i12);
        float floatValue = ((Float) b2.first).floatValue();
        boolean booleanValue = ((Boolean) b2.second).booleanValue();
        float a2 = a(iMapConfig.getMapZoomScale(), floatValue, (double) i13);
        float a3 = a(iMapConfig.getMapZoomScale(), floatValue, (double) i14);
        if (floatValue >= iMapConfig.getMaxZoomLevel()) {
            f2 = (float) latLongToPixels2.x;
            f5 = ((((float) (i3 - i2)) + a2) * ((float) i13)) / (a2 * 2.0f);
        } else {
            f2 = (float) latLongToPixels2.x;
            if (booleanValue) {
                f5 = (((float) ((i6 / 2) - i2)) / a2) * ((float) i13);
            } else {
                i8 = (int) (f2 + (((((float) (i3 - i2)) + a2) * ((float) i13)) / (a2 * 2.0f)));
                f3 = (float) latLongToPixels.y;
                f4 = (((float) ((i7 / 2) - i4)) / a3) * ((float) i14);
                return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (((float) i8) + a(iMapConfig.getMapZoomScale(), floatValue, (float) (iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1)))), (int) (((float) ((int) (f3 + f4))) + a(iMapConfig.getMapZoomScale(), floatValue, (float) (iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1))))));
            }
        }
        i8 = (int) (f2 + f5);
        f3 = (float) latLongToPixels.y;
        f4 = ((((float) (i5 - i4)) + a3) * ((float) i14)) / (a3 * 2.0f);
        return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (((float) i8) + a(iMapConfig.getMapZoomScale(), floatValue, (float) (iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1)))), (int) (((float) ((int) (f3 + f4))) + a(iMapConfig.getMapZoomScale(), floatValue, (float) (iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1))))));
    }

    public static ff a() {
        try {
            if (l.f9558e == null) {
                l.f9558e = new ff.a("3dmap", "8.0.0", l.f9556c).a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("8.0.0").a();
            }
            return l.f9558e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static DPoint a(LatLng latLng) {
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(((latLng.longitude / 360.0d) + 0.5d) * 1.0d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * 1.0d);
    }

    public static String a(int i2) {
        if (i2 < 1000) {
            return i2 + "m";
        }
        return (i2 / 1000) + "km";
    }

    public static String a(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file.toString() + File.separator);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + File.separator;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x00e4 A[SYNTHETIC, Splitter:B:107:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006a A[SYNTHETIC, Splitter:B:43:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0087 A[SYNTHETIC, Splitter:B:59:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0099 A[SYNTHETIC, Splitter:B:67:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00b6 A[SYNTHETIC, Splitter:B:83:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00c2 A[SYNTHETIC, Splitter:B:89:0x00c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r7) {
        /*
            java.lang.String r0 = "Util"
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x005c, all -> 0x0058 }
            r3.<init>(r7)     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x005c, all -> 0x0058 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x004e, all -> 0x0049 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x004e, all -> 0x0049 }
            java.lang.String r5 = "utf-8"
            r4.<init>(r3, r5)     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x004e, all -> 0x0049 }
            r7.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x004e, all -> 0x0049 }
        L_0x0019:
            java.lang.String r2 = r7.readLine()     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0045 }
            if (r2 == 0) goto L_0x0023
            r1.append(r2)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0045 }
            goto L_0x0019
        L_0x0023:
            r3.close()     // Catch:{ IOException -> 0x0033 }
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x00b9
        L_0x002b:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x00b9
        L_0x0031:
            r0 = move-exception
            goto L_0x003c
        L_0x0033:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0031 }
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x00b9
        L_0x003c:
            r7.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0044:
            throw r0
        L_0x0045:
            r2 = move-exception
            goto L_0x0060
        L_0x0047:
            r2 = move-exception
            goto L_0x008f
        L_0x0049:
            r0 = move-exception
            r7 = r2
        L_0x004b:
            r2 = r3
            goto L_0x00c0
        L_0x004e:
            r7 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
            goto L_0x0060
        L_0x0053:
            r7 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
            goto L_0x008f
        L_0x0058:
            r0 = move-exception
            r7 = r2
            goto L_0x00c0
        L_0x005c:
            r7 = move-exception
            r3 = r2
            r2 = r7
            r7 = r3
        L_0x0060:
            java.lang.String r4 = "readFile io"
            com.amap.api.mapcore.util.fz.c(r2, r0, r4)     // Catch:{ all -> 0x00be }
            r2.printStackTrace()     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x0085
            r3.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0085
        L_0x006e:
            r0 = move-exception
            goto L_0x007a
        L_0x0070:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x006e }
            if (r7 == 0) goto L_0x00b9
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x00b9
        L_0x007a:
            if (r7 == 0) goto L_0x0084
            r7.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0084:
            throw r0
        L_0x0085:
            if (r7 == 0) goto L_0x00b9
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x00b9
        L_0x008b:
            r7 = move-exception
            r3 = r2
            r2 = r7
            r7 = r3
        L_0x008f:
            java.lang.String r4 = "readFile fileNotFound"
            com.amap.api.mapcore.util.fz.c(r2, r0, r4)     // Catch:{ all -> 0x00be }
            r2.printStackTrace()     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x00b4
            r3.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00b4
        L_0x009d:
            r0 = move-exception
            goto L_0x00a9
        L_0x009f:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x009d }
            if (r7 == 0) goto L_0x00b9
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x00b9
        L_0x00a9:
            if (r7 == 0) goto L_0x00b3
            r7.close()     // Catch:{ IOException -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00b3:
            throw r0
        L_0x00b4:
            if (r7 == 0) goto L_0x00b9
            r7.close()     // Catch:{ IOException -> 0x002b }
        L_0x00b9:
            java.lang.String r7 = r1.toString()
            return r7
        L_0x00be:
            r0 = move-exception
            goto L_0x004b
        L_0x00c0:
            if (r2 == 0) goto L_0x00e2
            r2.close()     // Catch:{ IOException -> 0x00c8 }
            goto L_0x00e2
        L_0x00c6:
            r0 = move-exception
            goto L_0x00d7
        L_0x00c8:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x00c6 }
            if (r7 == 0) goto L_0x00e7
            r7.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00e7
        L_0x00d2:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x00e7
        L_0x00d7:
            if (r7 == 0) goto L_0x00e1
            r7.close()     // Catch:{ IOException -> 0x00dd }
            goto L_0x00e1
        L_0x00dd:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00e1:
            throw r0
        L_0x00e2:
            if (r7 == 0) goto L_0x00e7
            r7.close()     // Catch:{ IOException -> 0x00d2 }
        L_0x00e7:
            goto L_0x00e9
        L_0x00e8:
            throw r0
        L_0x00e9:
            goto L_0x00e8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dl.a(java.io.File):java.lang.String");
    }

    public static String a(InputStream inputStream) {
        try {
            return new String(b(inputStream), "utf-8");
        } catch (Throwable th) {
            fz.c(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse.getAuthority() != null) {
                if (parse.getAuthority().startsWith("dualstack-")) {
                    return str;
                }
            }
            if (parse.getAuthority() != null && parse.getAuthority().startsWith("restsdk.amap.com")) {
                return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
            }
            Uri.Builder buildUpon = parse.buildUpon();
            return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String append : strArr) {
            sb.append(append);
            if (i2 != strArr.length - 1) {
                sb.append(",");
            }
            i2++;
        }
        return sb.toString();
    }

    public static void a(Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT <= 10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public static void a(Throwable th) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d4 - d2;
        double d10 = d8 - d7;
        double d11 = d5 - d3;
        double d12 = 180.0d - d6;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 != i.f27244a) {
            double d14 = d3 - d7;
            double d15 = d2 - d6;
            double d16 = ((d12 * d14) - (d10 * d15)) / d13;
            double d17 = ((d14 * d9) - (d15 * d11)) / d13;
            return d16 >= i.f27244a && d16 <= 1.0d && d17 >= i.f27244a && d17 <= 1.0d;
        }
    }

    public static boolean a(double d2, LatLng latLng, CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), latLng)) <= d2 - circleHoleOptions.getRadius();
        } catch (Throwable th) {
            fz.c(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private static boolean a(double d2, LatLng latLng, List<BaseHoleOptions> list, LatLng latLng2) throws RemoteException {
        if (list != null && list.size() > 0) {
            for (BaseHoleOptions a2 : list) {
                if (a(a2, latLng2)) {
                    return false;
                }
            }
        }
        return d2 >= ((double) AMapUtils.calculateLineDistance(latLng, latLng2));
    }

    public static boolean a(double d2, LatLng latLng, List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z2 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            int i2 = 0;
            while (i2 < points.size() && (z2 = a(d2, latLng, list, points.get(i2)))) {
                i2++;
            }
        } catch (Throwable th) {
            fz.c(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
        }
        return z2;
    }

    public static boolean a(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            return true;
        }
        Log.w("3dmap", "the map must have a size");
        return false;
    }

    public static boolean a(Rect rect, int i2, int i3) {
        return rect.contains(i2, i3);
    }

    public static boolean a(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return a(latLng, points);
    }

    private static boolean a(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius();
        } catch (Throwable th) {
            fz.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.amap.api.maps.model.LatLng r32, java.util.List<com.amap.api.maps.model.LatLng> r33) {
        /*
            r0 = r32
            r1 = r33
            r2 = 0
            if (r0 == 0) goto L_0x0119
            if (r1 != 0) goto L_0x000b
            goto L_0x0119
        L_0x000b:
            double r13 = r0.longitude
            double r11 = r0.latitude
            double r9 = r0.latitude
            int r0 = r33.size()
            r3 = 3
            if (r0 >= r3) goto L_0x0019
            return r2
        L_0x0019:
            java.lang.Object r0 = r1.get(r2)
            com.amap.api.maps.model.LatLng r0 = (com.amap.api.maps.model.LatLng) r0
            int r3 = r33.size()
            r17 = 1
            int r3 = r3 + -1
            java.lang.Object r3 = r1.get(r3)
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x003b
            java.lang.Object r0 = r1.get(r2)
            r1.add(r0)
            r18 = 1
            goto L_0x003d
        L_0x003b:
            r18 = 0
        L_0x003d:
            r0 = 0
            r19 = 0
        L_0x0040:
            int r3 = r33.size()     // Catch:{ all -> 0x010c }
            int r3 = r3 + -1
            if (r0 >= r3) goto L_0x00fb
            java.lang.Object r3 = r1.get(r0)     // Catch:{ all -> 0x010c }
            com.amap.api.maps.model.LatLng r3 = (com.amap.api.maps.model.LatLng) r3     // Catch:{ all -> 0x010c }
            double r7 = r3.longitude     // Catch:{ all -> 0x010c }
            java.lang.Object r3 = r1.get(r0)     // Catch:{ all -> 0x010c }
            com.amap.api.maps.model.LatLng r3 = (com.amap.api.maps.model.LatLng) r3     // Catch:{ all -> 0x010c }
            double r5 = r3.latitude     // Catch:{ all -> 0x010c }
            int r0 = r0 + 1
            java.lang.Object r3 = r1.get(r0)     // Catch:{ all -> 0x010c }
            com.amap.api.maps.model.LatLng r3 = (com.amap.api.maps.model.LatLng) r3     // Catch:{ all -> 0x010c }
            double r3 = r3.longitude     // Catch:{ all -> 0x010c }
            java.lang.Object r15 = r1.get(r0)     // Catch:{ all -> 0x010c }
            com.amap.api.maps.model.LatLng r15 = (com.amap.api.maps.model.LatLng) r15     // Catch:{ all -> 0x010c }
            r32 = r0
            double r0 = r15.latitude     // Catch:{ all -> 0x00f7 }
            r15 = r3
            r3 = r13
            r20 = r5
            r5 = r11
            r22 = r7
            r24 = r9
            r9 = r20
            r26 = r11
            r11 = r15
            r28 = r13
            r13 = r0
            boolean r3 = b(r3, r5, r7, r9, r11, r13)     // Catch:{ all -> 0x00f7 }
            if (r3 == 0) goto L_0x0091
            if (r18 == 0) goto L_0x0090
            int r0 = r33.size()
            int r0 = r0 + -1
            r1 = r33
            r1.remove(r0)
        L_0x0090:
            return r17
        L_0x0091:
            r30 = r0
            r1 = r33
            double r3 = r30 - r20
            double r3 = java.lang.Math.abs(r3)     // Catch:{ all -> 0x010c }
            r5 = 4472406533629990549(0x3e112e0be826d695, double:1.0E-9)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00ed
            r11 = 4640537203540230144(0x4066800000000000, double:180.0)
            r3 = r22
            r5 = r20
            r7 = r28
            r9 = r26
            r13 = r24
            boolean r0 = b(r3, r5, r7, r9, r11, r13)     // Catch:{ all -> 0x010c }
            if (r0 == 0) goto L_0x00c0
            int r0 = (r20 > r30 ? 1 : (r20 == r30 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ed
        L_0x00bd:
            int r19 = r19 + 1
            goto L_0x00ed
        L_0x00c0:
            r11 = 4640537203540230144(0x4066800000000000, double:180.0)
            r3 = r15
            r5 = r30
            r7 = r28
            r9 = r26
            r13 = r24
            boolean r0 = b(r3, r5, r7, r9, r11, r13)     // Catch:{ all -> 0x010c }
            if (r0 == 0) goto L_0x00d9
            int r0 = (r30 > r20 ? 1 : (r30 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ed
            goto L_0x00bd
        L_0x00d9:
            r3 = r22
            r5 = r20
            r7 = r15
            r9 = r30
            r11 = r28
            r13 = r26
            r15 = r24
            boolean r0 = a((double) r3, (double) r5, (double) r7, (double) r9, (double) r11, (double) r13, (double) r15)     // Catch:{ all -> 0x010c }
            if (r0 == 0) goto L_0x00ed
            goto L_0x00bd
        L_0x00ed:
            r0 = r32
            r9 = r24
            r11 = r26
            r13 = r28
            goto L_0x0040
        L_0x00f7:
            r0 = move-exception
            r1 = r33
            goto L_0x010d
        L_0x00fb:
            int r19 = r19 % 2
            if (r19 == 0) goto L_0x0100
            r2 = 1
        L_0x0100:
            if (r18 == 0) goto L_0x010b
            int r0 = r33.size()
            int r0 = r0 + -1
            r1.remove(r0)
        L_0x010b:
            return r2
        L_0x010c:
            r0 = move-exception
        L_0x010d:
            if (r18 == 0) goto L_0x0118
            int r2 = r33.size()
            int r2 = r2 + -1
            r1.remove(r2)
        L_0x0118:
            throw r0
        L_0x0119:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dl.a(com.amap.api.maps.model.LatLng, java.util.List):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        r1 = a(r6, (com.amap.api.maps.model.CircleHoleOptions) r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.util.List<com.amap.api.maps.model.BaseHoleOptions> r5, com.amap.api.maps.model.CircleHoleOptions r6) {
        /*
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r5.size()
            if (r0 >= r2) goto L_0x0030
            java.lang.Object r2 = r5.get(r0)
            com.amap.api.maps.model.BaseHoleOptions r2 = (com.amap.api.maps.model.BaseHoleOptions) r2
            boolean r3 = r2 instanceof com.amap.api.maps.model.PolygonHoleOptions
            r4 = 1
            if (r3 == 0) goto L_0x0020
            com.amap.api.maps.model.PolygonHoleOptions r2 = (com.amap.api.maps.model.PolygonHoleOptions) r2
            java.util.List r1 = r2.getPoints()
            boolean r1 = b((java.util.List<com.amap.api.maps.model.LatLng>) r1, (com.amap.api.maps.model.CircleHoleOptions) r6)
            if (r1 == 0) goto L_0x002d
            return r4
        L_0x0020:
            boolean r3 = r2 instanceof com.amap.api.maps.model.CircleHoleOptions
            if (r3 == 0) goto L_0x002d
            com.amap.api.maps.model.CircleHoleOptions r2 = (com.amap.api.maps.model.CircleHoleOptions) r2
            boolean r1 = a((com.amap.api.maps.model.CircleHoleOptions) r6, (com.amap.api.maps.model.CircleHoleOptions) r2)
            if (r1 == 0) goto L_0x002d
            return r4
        L_0x002d:
            int r0 = r0 + 1
            goto L_0x0002
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dl.a(java.util.List, com.amap.api.maps.model.CircleHoleOptions):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        r1 = b(r6.getPoints(), (com.amap.api.maps.model.CircleHoleOptions) r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.util.List<com.amap.api.maps.model.BaseHoleOptions> r5, com.amap.api.maps.model.PolygonHoleOptions r6) {
        /*
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r5.size()
            if (r0 >= r2) goto L_0x0038
            java.lang.Object r2 = r5.get(r0)
            com.amap.api.maps.model.BaseHoleOptions r2 = (com.amap.api.maps.model.BaseHoleOptions) r2
            boolean r3 = r2 instanceof com.amap.api.maps.model.PolygonHoleOptions
            r4 = 1
            if (r3 == 0) goto L_0x0024
            com.amap.api.maps.model.PolygonHoleOptions r2 = (com.amap.api.maps.model.PolygonHoleOptions) r2
            java.util.List r1 = r2.getPoints()
            java.util.List r2 = r6.getPoints()
            boolean r1 = a((java.util.List<com.amap.api.maps.model.LatLng>) r1, (java.util.List<com.amap.api.maps.model.LatLng>) r2)
            if (r1 == 0) goto L_0x0035
            return r4
        L_0x0024:
            boolean r3 = r2 instanceof com.amap.api.maps.model.CircleHoleOptions
            if (r3 == 0) goto L_0x0035
            com.amap.api.maps.model.CircleHoleOptions r2 = (com.amap.api.maps.model.CircleHoleOptions) r2
            java.util.List r1 = r6.getPoints()
            boolean r1 = b((java.util.List<com.amap.api.maps.model.LatLng>) r1, (com.amap.api.maps.model.CircleHoleOptions) r2)
            if (r1 == 0) goto L_0x0035
            return r4
        L_0x0035:
            int r0 = r0 + 1
            goto L_0x0002
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dl.a(java.util.List, com.amap.api.maps.model.PolygonHoleOptions):boolean");
    }

    private static boolean a(List<LatLng> list, List<LatLng> list2) {
        int i2 = 0;
        while (i2 < list2.size()) {
            try {
                if (a(list2.get(i2), list)) {
                    return true;
                }
                i2++;
            } catch (Throwable th) {
                fz.c(th, "Util", "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (a(list.get(i3), list2)) {
                return true;
            }
        }
        return b(list, list2);
    }

    public static boolean a(List<LatLng> list, List<BaseHoleOptions> list2, CircleHoleOptions circleHoleOptions) {
        try {
            return !b(list, circleHoleOptions) && a(list, list2, circleHoleOptions.getCenter());
        } catch (Throwable th) {
            fz.c(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    private static boolean a(List<LatLng> list, List<BaseHoleOptions> list2, LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    for (BaseHoleOptions a2 : list2) {
                        if (a(a2, latLng)) {
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                fz.c(th, "PolygonDelegateImp", "contains");
                th.printStackTrace();
                return false;
            }
        }
        return a(latLng, list);
    }

    public static byte[] a(byte[] bArr, int i2) {
        return a(bArr, i2, i2, true);
    }

    public static byte[] a(byte[] bArr, int i2, int i3, boolean z2) {
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Bitmap copy = decodeByteArray.copy(decodeByteArray.getConfig(), true);
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            for (int i4 = 0; i4 < width; i4++) {
                for (int i5 = 0; i5 < height; i5++) {
                    if (i4 != 0) {
                        if (i5 != 0) {
                            copy.setPixel(i4, i5, i2);
                        }
                    }
                    if (!z2) {
                        copy.setPixel(i4, i5, i3);
                    }
                }
            }
            byte[] b2 = b(copy);
            if (b2 == null) {
                b2 = bArr;
            }
            a(copy);
            a(decodeByteArray);
            return b2;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public static synchronized int[] a(int i2, int i3, int i4, int i5, IMapConfig iMapConfig, IGLMapState iGLMapState, int i6, int i7) {
        int[] iArr;
        synchronized (dl.class) {
            int mapWidth = iMapConfig.getMapWidth();
            int mapHeight = iMapConfig.getMapHeight();
            int anchorX = iMapConfig.getAnchorX();
            int anchorY = iMapConfig.getAnchorY();
            float f2 = (float) i6;
            iArr = new int[]{(int) Math.max(((float) i4) + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), (float) anchorX), Math.min(f2, ((float) i2) - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), (float) (mapWidth - anchorX)))), (int) Math.max(((float) i3) + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), (float) anchorY), Math.min((float) i7, ((float) i5) - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), (float) (mapHeight - anchorY))))};
        }
        return iArr;
    }

    public static FPoint[] a(IAMapDelegate iAMapDelegate) {
        float skyHeight = iAMapDelegate.getSkyHeight();
        FPoint obtain = FPoint.obtain();
        int i2 = (int) (skyHeight - 10.0f);
        iAMapDelegate.pixel2Map(-100, i2, obtain);
        f8264a[0].set(obtain.x, obtain.y);
        FPoint obtain2 = FPoint.obtain();
        iAMapDelegate.pixel2Map(iAMapDelegate.getMapWidth() + 100, i2, obtain2);
        f8264a[1].set(obtain2.x, obtain2.y);
        FPoint obtain3 = FPoint.obtain();
        iAMapDelegate.pixel2Map(iAMapDelegate.getMapWidth() + 100, iAMapDelegate.getMapHeight() + 100, obtain3);
        f8264a[2].set(obtain3.x, obtain3.y);
        FPoint obtain4 = FPoint.obtain();
        iAMapDelegate.pixel2Map(-100, iAMapDelegate.getMapHeight() + 100, obtain4);
        f8264a[3].set(obtain4.x, obtain4.y);
        obtain.recycle();
        obtain2.recycle();
        obtain3.recycle();
        obtain4.recycle();
        return f8264a;
    }

    private static Pair<Float, Boolean> b(IMapConfig iMapConfig, int i2, int i3, int i4, int i5, int i6, int i7) {
        float f2;
        iMapConfig.getSZ();
        boolean z2 = true;
        if (i2 == i4 && i3 == i5) {
            f2 = iMapConfig.getMaxZoomLevel();
        } else {
            float a2 = (float) a(iMapConfig.getMapZoomScale(), (double) i7, (double) Math.abs(i5 - i3));
            float a3 = (float) a(iMapConfig.getMapZoomScale(), (double) i6, (double) Math.abs(i4 - i2));
            float min = Math.min(a3, a2);
            if (min != a3) {
                z2 = false;
            }
            f2 = Math.min(iMapConfig.getMaxZoomLevel(), Math.max(iMapConfig.getMinZoomLevel(), min));
        }
        return new Pair<>(Float.valueOf(f2), Boolean.valueOf(z2));
    }

    public static String b(Context context) {
        return FileUtil.getMapBaseStorage(context) + File.separator + AeUtil.ROOT_DATA_PATH_OLD_NAME + File.separator;
    }

    public static String b(View view) {
        StringBuilder sb = new StringBuilder();
        if (view != null) {
            try {
                if (view instanceof TextView) {
                    sb = new StringBuilder(((TextView) view).getText().toString());
                }
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        String b2 = b(((ViewGroup) view).getChildAt(i2));
                        if (!TextUtils.isEmpty(b2)) {
                            sb.append("--");
                            sb.append(b2);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sb.toString();
    }

    private static boolean b(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Math.abs(a(d2, d3, d4, d5, d6, d7)) < 1.0E-9d && (d2 - d4) * (d2 - d6) <= i.f27244a && (d3 - d5) * (d3 - d7) <= i.f27244a;
    }

    private static boolean b(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        int i2;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                arrayList.add(list.get(i3));
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            while (i4 < arrayList.size() && (i2 = i4 + 1) < arrayList.size()) {
                if (circleHoleOptions.getRadius() < ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i4)))) {
                    if (circleHoleOptions.getRadius() < ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i2)))) {
                        arrayList2.clear();
                        arrayList2.add(arrayList.get(i4));
                        arrayList2.add(arrayList.get(i2));
                        if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint((List<LatLng>) arrayList2, circleHoleOptions.getCenter()).second))) {
                            return true;
                        }
                        i4 = i2;
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            fz.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.util.List<com.amap.api.maps.model.LatLng> r3, com.amap.api.maps.model.PolygonHoleOptions r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0030
            if (r4 != 0) goto L_0x0006
            goto L_0x0030
        L_0x0006:
            java.util.List r4 = r4.getPoints()     // Catch:{ all -> 0x0023 }
            r1 = 0
        L_0x000b:
            int r2 = r4.size()     // Catch:{ all -> 0x0020 }
            if (r0 >= r2) goto L_0x002f
            java.lang.Object r2 = r4.get(r0)     // Catch:{ all -> 0x0020 }
            com.amap.api.maps.model.LatLng r2 = (com.amap.api.maps.model.LatLng) r2     // Catch:{ all -> 0x0020 }
            boolean r1 = a((com.amap.api.maps.model.LatLng) r2, (java.util.List<com.amap.api.maps.model.LatLng>) r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x002f
            int r0 = r0 + 1
            goto L_0x000b
        L_0x0020:
            r3 = move-exception
            r0 = r1
            goto L_0x0024
        L_0x0023:
            r3 = move-exception
        L_0x0024:
            java.lang.String r4 = "PolygonDelegateImp"
            java.lang.String r1 = "isPolygonInPolygon"
            com.amap.api.mapcore.util.fz.c(r3, r4, r1)
            r3.printStackTrace()
            r1 = r0
        L_0x002f:
            return r1
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dl.b(java.util.List, com.amap.api.maps.model.PolygonHoleOptions):boolean");
    }

    private static boolean b(List<LatLng> list, List<LatLng> list2) {
        int i2;
        int i3;
        int i4 = 0;
        while (i4 < list.size() && (i2 = i4 + 1) < list.size()) {
            try {
                int i5 = 0;
                while (i5 < list2.size() && (i3 = i5 + 1) < list2.size()) {
                    boolean a2 = dg.a(list.get(i4), list.get(i2), list2.get(i5), list2.get(i3));
                    if (a2) {
                        return a2;
                    }
                    i5 = i3;
                }
                i4 = i2;
            } catch (Throwable th) {
                fz.c(th, "Util", "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001d A[SYNTHETIC, Splitter:B:14:0x001d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x001a }
            r1.<init>()     // Catch:{ all -> 0x001a }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x001b }
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch:{ all -> 0x001b }
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x001b }
            r1.close()     // Catch:{ all -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0019:
            return r4
        L_0x001a:
            r1 = r0
        L_0x001b:
            if (r1 == 0) goto L_0x0025
            r1.close()     // Catch:{ all -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dl.b(android.graphics.Bitmap):byte[]");
    }

    private static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String c(Context context) {
        String a2 = a(context);
        if (a2 == null) {
            return null;
        }
        File file = new File(a2, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    private static void c(View view) {
        int i2 = 0;
        if (view instanceof ViewGroup) {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 < viewGroup.getChildCount()) {
                    c(viewGroup.getChildAt(i2));
                    i2++;
                } else {
                    return;
                }
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setHorizontallyScrolling(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r2 = (r2 = (r2 = (android.net.ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo()).getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(android.content.Context r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            if (r2 != 0) goto L_0x000f
            return r0
        L_0x000f:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()
            if (r2 != 0) goto L_0x0016
            return r0
        L_0x0016:
            android.net.NetworkInfo$State r2 = r2.getState()
            if (r2 == 0) goto L_0x0027
            android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.DISCONNECTED
            if (r2 == r1) goto L_0x0027
            android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.DISCONNECTING
            if (r2 != r1) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r2 = 1
            return r2
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dl.d(android.content.Context):boolean");
    }

    public static boolean e(Context context) {
        File file = new File(b(context));
        if (!file.exists()) {
            return true;
        }
        return FileUtil.deleteFile(file);
    }
}
