package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.util.aa;
import com.amap.api.mapcore.util.de;
import com.amap.api.mapcore.util.di;
import com.amap.api.mapcore.util.fz;
import com.amap.api.maps.model.LatLng;

public class CoordinateConverter {
    private static final String TAG = "CoordinateConverter";
    private CoordType coordType = null;
    private Context ctx;
    private LatLng sourceLatLng = null;

    /* renamed from: com.amap.api.maps.CoordinateConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9720a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.amap.api.maps.CoordinateConverter$CoordType[] r0 = com.amap.api.maps.CoordinateConverter.CoordType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9720a = r0
                com.amap.api.maps.CoordinateConverter$CoordType r1 = com.amap.api.maps.CoordinateConverter.CoordType.BAIDU     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9720a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amap.api.maps.CoordinateConverter$CoordType r1 = com.amap.api.maps.CoordinateConverter.CoordType.MAPBAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9720a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amap.api.maps.CoordinateConverter$CoordType r1 = com.amap.api.maps.CoordinateConverter.CoordType.MAPABC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9720a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.amap.api.maps.CoordinateConverter$CoordType r1 = com.amap.api.maps.CoordinateConverter.CoordType.SOSOMAP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9720a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.amap.api.maps.CoordinateConverter$CoordType r1 = com.amap.api.maps.CoordinateConverter.CoordType.ALIYUN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9720a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.amap.api.maps.CoordinateConverter$CoordType r1 = com.amap.api.maps.CoordinateConverter.CoordType.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9720a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.amap.api.maps.CoordinateConverter$CoordType r1 = com.amap.api.maps.CoordinateConverter.CoordType.GPS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.CoordinateConverter.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.ctx = context;
    }

    public static boolean isAMapDataAvailable(double d2, double d3) {
        return de.a(d2, d3);
    }

    public LatLng convert() {
        LatLng latLng = null;
        if (this.coordType == null || this.sourceLatLng == null) {
            return null;
        }
        String str = "";
        try {
            switch (AnonymousClass1.f9720a[this.coordType.ordinal()]) {
                case 1:
                    latLng = aa.a(this.sourceLatLng);
                    str = "baidu";
                    break;
                case 2:
                    latLng = aa.b(this.ctx, this.sourceLatLng);
                    str = "mapbar";
                    break;
                case 3:
                    str = "mapabc";
                    break;
                case 4:
                    str = "sosomap";
                    break;
                case 5:
                    str = "aliyun";
                    break;
                case 6:
                    str = "google";
                    break;
                case 7:
                    str = "gps";
                    latLng = aa.a(this.ctx, this.sourceLatLng);
                    break;
            }
            latLng = this.sourceLatLng;
            di.a(this.ctx, str);
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            fz.c(th, TAG, "convert");
            return this.sourceLatLng;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.sourceLatLng = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType2) {
        this.coordType = coordType2;
        return this;
    }
}
