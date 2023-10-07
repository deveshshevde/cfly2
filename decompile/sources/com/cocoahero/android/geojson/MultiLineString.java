package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiLineString extends Geometry {
    public static final Parcelable.Creator<MultiLineString> CREATOR = new Parcelable.Creator<MultiLineString>() {
        /* renamed from: a */
        public MultiLineString createFromParcel(Parcel parcel) {
            return (MultiLineString) GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public MultiLineString[] newArray(int i2) {
            return new MultiLineString[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<LineString> f10765a = new ArrayList();

    public MultiLineString() {
    }

    public MultiLineString(JSONObject jSONObject) {
        super(jSONObject);
        a(jSONObject.optJSONArray("coordinates"));
    }

    public String a() {
        return "MultiLineString";
    }

    public void a(JSONArray jSONArray) {
        this.f10765a.clear();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONArray optJSONArray = jSONArray.optJSONArray(i2);
                if (optJSONArray != null) {
                    this.f10765a.add(new LineString(optJSONArray));
                }
            }
        }
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        JSONArray jSONArray = new JSONArray();
        for (LineString c2 : this.f10765a) {
            JSONArray jSONArray2 = new JSONArray();
            for (Position d2 : c2.c()) {
                jSONArray2.put(d2.d());
            }
            jSONArray.put(jSONArray2);
        }
        b2.put("coordinates", jSONArray);
        return b2;
    }
}
