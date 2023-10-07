package com.amap.api.mapcore.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class es {

    /* renamed from: b  reason: collision with root package name */
    private static volatile es f8582b;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, a> f8583a;

    class a {

        /* renamed from: b  reason: collision with root package name */
        private int f8585b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f8586c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f8587d = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f8588e = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f8589f = 0;

        /* renamed from: g  reason: collision with root package name */
        private HashMap<Integer, List<LatLng>> f8590g;

        /* renamed from: h  reason: collision with root package name */
        private List<LatLng> f8591h = new ArrayList();

        public a(int i2, int i3, int i4, HashMap<Integer, List<LatLng>> hashMap) {
            this.f8585b = i3;
            this.f8590g = hashMap;
            this.f8586c = i2;
            this.f8588e = i4;
        }

        private void a(Handler handler, List<LatLng> list) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = list;
            obtainMessage.what = 100;
            obtainMessage.arg1 = this.f8587d;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.f8586c);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
            this.f8587d++;
            this.f8589f++;
        }

        private void b(Handler handler) {
            if (this.f8589f > 0) {
                int a2 = ep.a(this.f8591h);
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = this.f8591h;
                obtainMessage.what = 101;
                obtainMessage.arg1 = a2;
                obtainMessage.arg2 = this.f8588e;
                Bundle bundle = new Bundle();
                bundle.putInt("lineID", this.f8586c);
                obtainMessage.setData(bundle);
                handler.sendMessage(obtainMessage);
                return;
            }
            es.a(handler, this.f8586c, LBSTraceClient.MIN_GRASP_POINT_ERROR);
        }

        public final HashMap<Integer, List<LatLng>> a() {
            return this.f8590g;
        }

        public final void a(Handler handler) {
            List list;
            int i2 = this.f8587d;
            while (i2 <= this.f8585b && (list = this.f8590g.get(Integer.valueOf(i2))) != null) {
                this.f8591h.addAll(list);
                a(handler, list);
                i2++;
            }
            if (this.f8587d == this.f8585b + 1) {
                b(handler);
            }
        }
    }

    public es() {
        this.f8583a = null;
        this.f8583a = Collections.synchronizedMap(new HashMap());
    }

    public static es a() {
        if (f8582b == null) {
            synchronized (es.class) {
                if (f8582b == null) {
                    f8582b = new es();
                }
            }
        }
        return f8582b;
    }

    public static void a(Handler handler, int i2, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i2);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }

    public final synchronized a a(String str) {
        Map<String, a> map = this.f8583a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final synchronized void a(String str, int i2, int i3, int i4) {
        Map<String, a> map = this.f8583a;
        if (map != null) {
            map.put(str, new a(i2, i3, i4, new HashMap(16)));
        }
    }

    public final synchronized void a(String str, int i2, List<LatLng> list) {
        Map<String, a> map = this.f8583a;
        if (map != null) {
            map.get(str).a().put(Integer.valueOf(i2), list);
        }
    }
}
