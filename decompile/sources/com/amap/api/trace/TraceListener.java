package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

public interface TraceListener {
    void onFinished(int i2, List<LatLng> list, int i3, int i4);

    void onRequestFailed(int i2, String str);

    void onTraceProcessing(int i2, int i3, List<LatLng> list);
}
