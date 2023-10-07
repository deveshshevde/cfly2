package com.amap.api.trace;

import android.content.Context;
import com.amap.api.mapcore.util.er;
import java.util.List;

public class LBSTraceClient {
    public static final String LOCATE_TIMEOUT_ERROR = "定位超时";
    public static final String MIN_GRASP_POINT_ERROR = "轨迹点太少或距离太近,轨迹纠偏失败";
    public static final String TRACE_SUCCESS = "纠偏成功";
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;

    /* renamed from: a  reason: collision with root package name */
    private static LBSTraceBase f9850a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile LBSTraceClient f9851b;

    private LBSTraceClient() {
    }

    public LBSTraceClient(Context context) {
        a(context);
    }

    private static void a() {
        f9850a = null;
        f9851b = null;
    }

    private static void a(Context context) {
        if (context != null) {
            f9850a = new er(context.getApplicationContext());
        }
    }

    public static LBSTraceClient getInstance(Context context) {
        if (f9851b == null) {
            synchronized (LBSTraceClient.class) {
                if (f9851b == null) {
                    a(context);
                    f9851b = new LBSTraceClient();
                }
            }
        }
        return f9851b;
    }

    public void destroy() {
        LBSTraceBase lBSTraceBase = f9850a;
        if (lBSTraceBase != null) {
            lBSTraceBase.destroy();
            a();
        }
    }

    public void queryProcessedTrace(int i2, List<TraceLocation> list, int i3, TraceListener traceListener) {
        LBSTraceBase lBSTraceBase = f9850a;
        if (lBSTraceBase != null) {
            lBSTraceBase.queryProcessedTrace(i2, list, i3, traceListener);
        }
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        LBSTraceBase lBSTraceBase = f9850a;
        if (lBSTraceBase != null) {
            lBSTraceBase.startTrace(traceStatusListener);
        }
    }

    public void stopTrace() {
        LBSTraceBase lBSTraceBase = f9850a;
        if (lBSTraceBase != null) {
            lBSTraceBase.stopTrace();
        }
    }
}
