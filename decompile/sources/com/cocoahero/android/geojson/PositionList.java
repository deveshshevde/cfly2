package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class PositionList implements Parcelable {
    public static final Parcelable.Creator<PositionList> CREATOR = new Parcelable.Creator<PositionList>() {
        /* renamed from: a */
        public PositionList createFromParcel(Parcel parcel) {
            return new PositionList(parcel);
        }

        /* renamed from: a */
        public PositionList[] newArray(int i2) {
            return new PositionList[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<Position> f10771a = new ArrayList();

    public PositionList() {
    }

    protected PositionList(Parcel parcel) {
        a((List<Position>) parcel.createTypedArrayList(Position.CREATOR));
    }

    public PositionList(JSONArray jSONArray) {
        a(jSONArray);
    }

    public List<Position> a() {
        return this.f10771a;
    }

    public void a(List<Position> list) {
        this.f10771a.clear();
        if (list != null) {
            this.f10771a.addAll(list);
        }
    }

    public void a(JSONArray jSONArray) {
        this.f10771a.clear();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONArray optJSONArray = jSONArray.optJSONArray(i2);
                if (optJSONArray != null) {
                    this.f10771a.add(new Position(optJSONArray));
                }
            }
        }
    }

    public JSONArray b() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Position d2 : this.f10771a) {
            jSONArray.put(d2.d());
        }
        return jSONArray;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f10771a);
    }
}
