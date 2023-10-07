package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Point extends Geometry {
    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() {
        /* renamed from: a */
        public Point createFromParcel(Parcel parcel) {
            return (Point) GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public Point[] newArray(int i2) {
            return new Point[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Position f10768a;

    public Point() {
    }

    public Point(JSONObject jSONObject) {
        super(jSONObject);
        a(jSONObject.optJSONArray("coordinates"));
    }

    public String a() {
        return "Point";
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.f10768a = new Position(jSONArray);
        } else {
            this.f10768a = null;
        }
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        Position position = this.f10768a;
        if (position != null) {
            b2.put("coordinates", position.d());
        }
        return b2;
    }
}
