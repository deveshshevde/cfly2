package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import com.amap.api.mapcore.util.cp;
import com.amap.api.mapcore.util.di;
import com.amap.api.mapcore.util.dl;
import com.amap.api.mapcore.util.ev;
import com.amap.api.mapcore.util.ey;
import com.amap.api.mapcore.util.ez;
import com.amap.api.mapcore.util.ff;
import com.amap.api.mapcore.util.fz;
import com.amap.api.mapcore.util.gy;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapEngine;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class AMapLoader implements gy.a {
    private static final int GET_METHOD = 0;
    private static final String NETWORK_RESPONSE_CODE_STRING = "网络异常状态码：";
    private static String mDiu;
    private gy downloadManager;
    private volatile boolean isCanceled = false;
    ADataRequestParam mDataRequestParam;
    private int mEngineID = 0;
    GLMapEngine mGLMapEngine;
    private boolean mRequestCancel = false;
    private long requestMapDataPackageSize = 0;
    private long requestMapDataTimestamp = 0;

    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    public static class AMapGridDownloadRequest extends cp {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        public String getIPV6URL() {
            return dl.a(getURL());
        }

        public Map<String, String> getParams() {
            return null;
        }

        public Map<String, String> getRequestHead() {
            ff a2 = dl.a();
            String b2 = a2 != null ? a2.b() : null;
            String f2 = ev.f(this.mContext);
            try {
                f2 = URLEncoder.encode(f2, "UTF-8");
            } catch (Throwable unused) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{b2, "3dmap"}));
            hashtable.put("x-INFO", ey.a(this.mContext));
            hashtable.put("key", f2);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        public String getURL() {
            return this.sUrl;
        }

        public boolean isSupportIPV6() {
            return true;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }
    }

    public AMapLoader(int i2, GLMapEngine gLMapEngine, ADataRequestParam aDataRequestParam) {
        this.mDataRequestParam = aDataRequestParam;
        this.mEngineID = i2;
        this.mGLMapEngine = gLMapEngine;
        this.mRequestCancel = false;
    }

    private String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String f2 = ev.f(this.mGLMapEngine.getContext());
        try {
            f2 = URLEncoder.encode(f2, "UTF-8");
        } catch (Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(f2);
        String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String a2 = ey.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a2)));
        stringBuffer.append("&scode=" + ey.a(context, a2, sortReEncoderParams));
        stringBuffer.append("&dip=16300");
        return stringBuffer.toString();
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String getNetworkFailedReason(String str) {
        return !this.mGLMapEngine.isNetworkConnected() ? "无网络" : str;
    }

    private String sortReEncoderParams(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String strReEncoder : split) {
            stringBuffer.append(strReEncoder(strReEncoder));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private void staticNetworkPerformance() {
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null) {
            di.a(gLMapEngine.getContext(), this.mGLMapEngine.hashCode(), System.currentTimeMillis() - this.requestMapDataTimestamp, this.requestMapDataPackageSize);
        }
    }

    private String strReEncoder(String str) {
        String str2;
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            str2 = "strReEncoder";
            fz.c(e, "AbstractProtocalHandler", str2);
            return "";
        } catch (Exception e3) {
            e = e3;
            str2 = "strReEncoderException";
            fz.c(e, "AbstractProtocalHandler", str2);
            return "";
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager != null && !this.isCanceled) {
            synchronized (this.downloadManager) {
                try {
                    this.isCanceled = true;
                    this.downloadManager.a();
                    this.mGLMapEngine.setMapLoaderToTask(this.mEngineID, this.mDataRequestParam.handler, (AMapLoader) null);
                } catch (Throwable th) {
                    fz.c(th, "AMapLoader", "doCancel");
                }
            }
        }
    }

    public void doRequest() {
        StringBuilder sb;
        if (!this.mRequestCancel) {
            String str = this.mDataRequestParam.requestBaseUrl;
            String str2 = this.mDataRequestParam.requestUrl;
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            String requestParams = getRequestParams(str2.replaceAll(";", getEncodeRequestParams(";").toString()), str != null && str.contains("http://m5.amap.com/"), this.mDataRequestParam.nRequestType);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.mDataRequestParam.nRequestType == 0) {
                stringBuffer.append(requestParams);
                sb = new StringBuilder("&csid=");
            } else {
                sb = new StringBuilder("csid=");
            }
            sb.append(UUID.randomUUID().toString());
            stringBuffer.append(sb.toString());
            try {
                AMapGridDownloadRequest aMapGridDownloadRequest = new AMapGridDownloadRequest(this.mGLMapEngine.getContext(), str + generateQueryString(this.mGLMapEngine.getContext(), stringBuffer.toString()), this.mGLMapEngine.getUserAgent());
                aMapGridDownloadRequest.setConnectionTimeout(30000);
                aMapGridDownloadRequest.setSoTimeout(30000);
                if (this.mDataRequestParam.nRequestType != 0) {
                    aMapGridDownloadRequest.setPostEntityBytes(requestParams.getBytes("UTF-8"));
                }
                this.requestMapDataTimestamp = System.currentTimeMillis();
                this.requestMapDataPackageSize = aMapGridDownloadRequest.getEntityBytes() == null ? 0 : (long) aMapGridDownloadRequest.getEntityBytes().length;
                gy gyVar = new gy(aMapGridDownloadRequest, 0, -1, MapsInitializer.getProtocol() == 2);
                this.downloadManager = gyVar;
                gyVar.a(this);
            } catch (Throwable th) {
                onException(th);
            } finally {
                doCancel();
            }
        }
    }

    public String getDeviceId(Context context) {
        if (context != null) {
            return ez.u(context);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String getRequestParams(String str, boolean z2, int i2) {
        String str2;
        if (mDiu == null) {
            mDiu = getDeviceId(this.mGLMapEngine.getContext());
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        if (z2) {
            str2 = "&channel=amap7&div=GNaviMap";
        } else {
            stringBuffer.append("&channel=amapapi");
            str2 = "&div=GNaviMap";
        }
        stringBuffer.append(str2);
        stringBuffer.append("&diu=");
        stringBuffer.append(mDiu);
        return stringBuffer.toString();
    }

    public void onDownload(byte[] bArr, long j2) {
        GLMapEngine gLMapEngine;
        ADataRequestParam aDataRequestParam;
        if (bArr != null && (gLMapEngine = this.mGLMapEngine) != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.receiveNetData(this.mEngineID, aDataRequestParam.handler, bArr, bArr.length);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r0 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        com.amap.api.mapcore.util.di.a(r0.getContext(), r7.mGLMapEngine.hashCode(), r7.mGLMapEngine.isNetworkConnected() ^ true ? 1 : 0, getNetworkFailedReason(r8.getMessage()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        if (r0 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
        com.amap.api.mapcore.util.fz.c(r8, "AMapLoader", "download onException");
        r0 = com.amap.api.mapcore.util.dm.f8271e;
        com.amap.api.mapcore.util.dn.b(r0, "map loader exception " + r8.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = r1.indexOf(NETWORK_RESPONSE_CODE_STRING);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onException(java.lang.Throwable r8) {
        /*
            r7 = this;
            java.lang.String r0 = "UTF-8"
            r6 = -1
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = r8.getMessage()     // Catch:{ all -> 0x0061 }
            byte[] r2 = r2.getBytes(r0)     // Catch:{ all -> 0x0061 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0061 }
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = "网络异常状态码："
            int r0 = r1.indexOf(r0)     // Catch:{ all -> 0x0061 }
            r2 = -1
            if (r0 == r2) goto L_0x002b
            int r0 = r0 + 8
            java.lang.String r0 = r1.substring(r0)     // Catch:{ all -> 0x0061 }
            int r6 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0061 }
            r5 = r6
            goto L_0x002c
        L_0x002b:
            r5 = -1
        L_0x002c:
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r7.mGLMapEngine
            if (r0 == 0) goto L_0x003f
            com.autonavi.base.amap.mapcore.maploader.AMapLoader$ADataRequestParam r1 = r7.mDataRequestParam
            if (r1 == 0) goto L_0x003f
            int r2 = r7.mEngineID
            long r3 = r1.handler
            r6 = -1
            r1 = r2
            r2 = r3
            r4 = r6
            r0.netError(r1, r2, r4, r5)
        L_0x003f:
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r7.mGLMapEngine
            if (r0 == 0) goto L_0x0076
        L_0x0043:
            android.content.Context r0 = r0.getContext()
            com.autonavi.base.ae.gmap.GLMapEngine r1 = r7.mGLMapEngine
            int r1 = r1.hashCode()
            com.autonavi.base.ae.gmap.GLMapEngine r2 = r7.mGLMapEngine
            boolean r2 = r2.isNetworkConnected()
            r2 = r2 ^ 1
            java.lang.String r3 = r8.getMessage()
            java.lang.String r3 = r7.getNetworkFailedReason(r3)
            com.amap.api.mapcore.util.di.a((android.content.Context) r0, (int) r1, (int) r2, (java.lang.String) r3)
            goto L_0x0076
        L_0x0061:
            com.autonavi.base.ae.gmap.GLMapEngine r1 = r7.mGLMapEngine
            if (r1 == 0) goto L_0x0071
            com.autonavi.base.amap.mapcore.maploader.AMapLoader$ADataRequestParam r0 = r7.mDataRequestParam
            if (r0 == 0) goto L_0x0071
            int r2 = r7.mEngineID
            long r3 = r0.handler
            r5 = -1
            r1.netError(r2, r3, r5, r6)
        L_0x0071:
            com.autonavi.base.ae.gmap.GLMapEngine r0 = r7.mGLMapEngine
            if (r0 == 0) goto L_0x0076
            goto L_0x0043
        L_0x0076:
            java.lang.String r0 = "AMapLoader"
            java.lang.String r1 = "download onException"
            com.amap.api.mapcore.util.fz.c(r8, r0, r1)
            java.lang.String r0 = com.amap.api.mapcore.util.dm.f8271e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "map loader exception "
            r1.<init>(r2)
            java.lang.String r8 = r8.getMessage()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            com.amap.api.mapcore.util.dn.b(r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.maploader.AMapLoader.onException(java.lang.Throwable):void");
    }

    public void onFinish() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (!(gLMapEngine == null || (aDataRequestParam = this.mDataRequestParam) == null)) {
            gLMapEngine.finishDownLoad(this.mEngineID, aDataRequestParam.handler);
        }
        staticNetworkPerformance();
    }

    public void onStop() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (!(gLMapEngine == null || (aDataRequestParam = this.mDataRequestParam) == null)) {
            gLMapEngine.netStop(this.mEngineID, aDataRequestParam.handler, -1);
        }
        staticNetworkPerformance();
    }
}
