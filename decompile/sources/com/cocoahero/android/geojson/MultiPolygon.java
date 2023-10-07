package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiPolygon extends Geometry {
    public static final Parcelable.Creator<MultiPolygon> CREATOR = new Parcelable.Creator<MultiPolygon>() {
        /* renamed from: a */
        public MultiPolygon createFromParcel(Parcel parcel) {
            return (MultiPolygon) GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public MultiPolygon[] newArray(int i2) {
            return new MultiPolygon[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<Polygon> f10767a = new ArrayList();

    public MultiPolygon() {
    }

    public MultiPolygon(JSONObject jSONObject) {
        super(jSONObject);
        a(jSONObject.optJSONArray("coordinates"));
    }

    public String a() {
        return "MultiPolygon";
    }

    public void a(JSONArray jSONArray) {
        this.f10767a.clear();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONArray optJSONArray = jSONArray.optJSONArray(i2);
                if (optJSONArray != null) {
                    this.f10767a.add(new Polygon(optJSONArray));
                }
            }
        }
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        JSONArray jSONArray = new JSONArray();
        for (Polygon c2 : this.f10767a) {
            JSONArray jSONArray2 = new JSONArray();
            for (Ring b3 : c2.c()) {
                jSONArray2.put(b3.b());
            }
            jSONArray.put(jSONArray2);
        }
        b2.put("coordinates", jSONArray);
        return b2;
    }
}
