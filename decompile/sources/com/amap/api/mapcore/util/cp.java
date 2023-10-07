package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.MapsInitializer;
import java.util.Map;

public abstract class cp extends hd {
    protected boolean isPostFlag = true;

    public Map<String, String> getParams() {
        return null;
    }

    /* access modifiers changed from: protected */
    public byte[] makeHttpRequest() throws eu {
        he makeHttpRequestNeedHeader = makeHttpRequestNeedHeader();
        if (makeHttpRequestNeedHeader != null) {
            return makeHttpRequestNeedHeader.f9117a;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public he makeHttpRequestNeedHeader() throws eu {
        setHttpProtocol(MapsInitializer.getProtocol() == 1 ? hd.c.HTTP : hd.c.HTTPS);
        hc.c();
        return this.isPostFlag ? hc.b(this) : hc.f(this);
    }

    public byte[] makeHttpRequestWithInterrupted() throws eu {
        setDegradeAbility(hd.a.INTERRUPT_IO);
        return makeHttpRequest();
    }
}
