package com.xeagle.android.widgets.CarouselView;

import java.io.PrintStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<f> f25573a;

    /* renamed from: b  reason: collision with root package name */
    f f25574b;

    public ArrayList<f> a(String str) {
        this.f25573a = new ArrayList<>();
        PrintStream printStream = System.out;
        printStream.println("json----------------" + str);
        try {
            JSONArray jSONArray = new JSONArray(new JSONObject(str).getString("videoList"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                this.f25574b = new f();
                this.f25574b.a(jSONObject.getString("imageUrl"));
                this.f25574b.b(jSONObject.getString("videoUrl"));
                this.f25574b.c(jSONObject.getString("videoDes"));
                this.f25574b.d(jSONObject.getString("videoTime"));
                this.f25573a.add(this.f25574b);
            }
            System.out.println(str);
            return this.f25573a;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
