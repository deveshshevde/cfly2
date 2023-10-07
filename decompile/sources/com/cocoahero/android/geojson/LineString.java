package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LineString extends Geometry {
    public static final Parcelable.Creator<LineString> CREATOR = new Parcelable.Creator<LineString>() {
        /* renamed from: a */
        public LineString createFromParcel(Parcel parcel) {
            return (LineString) GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public LineString[] newArray(int i2) {
            return new LineString[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final PositionList f10764a = new PositionList();

    public LineString() {
    }

    public LineString(JSONArray jSONArray) {
        a(jSONArray);
    }

    public LineString(JSONObject jSONObject) {
        super(jSONObject);
        a(jSONObject.optJSONArray("coordinates"));
    }

    public String a() {
        return "LineString";
    }

    public void a(JSONArray jSONArray) {
        this.f10764a.a(jSONArray);
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        b2.put("coordinates", this.f10764a.b());
        return b2;
    }

    public List<Position> c() {
        return this.f10764a.a();
    }
}
