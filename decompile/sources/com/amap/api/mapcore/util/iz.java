package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import org.json.JSONObject;

public final class iz extends Inner_3dMap_location {

    /* renamed from: a  reason: collision with root package name */
    boolean f9380a = true;

    /* renamed from: b  reason: collision with root package name */
    private String f9381b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f9382c = "";

    /* renamed from: d  reason: collision with root package name */
    private int f9383d;

    /* renamed from: e  reason: collision with root package name */
    private String f9384e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f9385f = "new";

    /* renamed from: g  reason: collision with root package name */
    private JSONObject f9386g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f9387h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f9388i = "";

    /* renamed from: j  reason: collision with root package name */
    private long f9389j = 0;

    /* renamed from: k  reason: collision with root package name */
    private String f9390k = null;

    public iz(String str) {
        super(str);
    }

    public final String a() {
        return this.f9381b;
    }

    public final void a(String str) {
        this.f9381b = str;
    }

    public final String b() {
        return this.f9382c;
    }

    public final void b(String str) {
        this.f9382c = str;
    }

    public final int c() {
        return this.f9383d;
    }

    public final void c(String str) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (getProvider().equals("gps")) {
                this.f9383d = 0;
                return;
            } else if (str.equals("0")) {
                this.f9383d = 0;
                return;
            } else if (str.equals("1")) {
                i2 = 1;
                this.f9383d = i2;
            }
        }
        i2 = -1;
        this.f9383d = i2;
    }

    public final String d() {
        return this.f9384e;
    }

    public final void d(String str) {
        this.f9384e = str;
    }

    public final JSONObject e() {
        return this.f9386g;
    }

    public final void e(String str) {
        this.desc = str;
    }

    public final void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                io.a(th, "MapLocationModel", "setFloor");
                str = null;
            }
        }
        this.floor = str;
    }

    public final JSONObject toJson(int i2) {
        try {
            JSONObject json = super.toJson(i2);
            if (i2 == 1) {
                json.put("retype", this.f9384e);
                json.put("cens", this.f9388i);
                json.put("poiid", this.buildingId);
                json.put("floor", this.floor);
                json.put("coord", this.f9383d);
                json.put("mcell", this.f9387h);
                json.put("desc", this.desc);
                json.put("address", getAddress());
                if (this.f9386g != null && is.a(json, "offpct")) {
                    json.put("offpct", this.f9386g.getString("offpct"));
                }
            } else if (!(i2 == 2 || i2 == 3)) {
                return json;
            }
            json.put("type", this.f9385f);
            json.put("isReversegeo", this.f9380a);
            return json;
        } catch (Throwable th) {
            io.a(th, "MapLocationModel", "toStr");
            return null;
        }
    }

    public final String toStr(int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = super.toJson(i2);
            jSONObject.put("nb", this.f9390k);
        } catch (Throwable th) {
            io.a(th, "MapLocationModel", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
