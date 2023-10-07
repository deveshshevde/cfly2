package com.amap.api.trace;

import java.util.List;

public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i2, List<TraceLocation> list, int i3, TraceListener traceListener);

    void setLocationInterval(long j2);

    void setTraceStatusInterval(int i2);

    void startTrace(TraceStatusListener traceStatusListener);

    void stopTrace();
}
