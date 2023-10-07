package ky;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kx.d;
import kx.e;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f30588a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, String> f30589b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, String> f30590c = new HashMap<>();

    public a(Context context) {
        this.f30588a = context;
    }

    private List<String> a() {
        try {
            String[] list = this.f30588a.getAssets().list("CameraInfo");
            this.f30590c.clear();
            for (String str : list) {
                this.f30590c.put(str, "CameraInfo/" + str);
            }
            return Arrays.asList(list);
        } catch (IOException unused) {
            return new ArrayList();
        }
    }

    private eo.a b(String str) throws Exception {
        com.xeagle.android.utils.file.IO.a aVar = new com.xeagle.android.utils.file.IO.a();
        FileInputStream fileInputStream = new FileInputStream(this.f30589b.get(str));
        aVar.a((InputStream) fileInputStream);
        fileInputStream.close();
        return aVar.a();
    }

    private List<String> b(Context context) {
        List<String> asList = Arrays.asList(e.d(context));
        this.f30589b.clear();
        for (String next : asList) {
            HashMap<String, String> hashMap = this.f30589b;
            hashMap.put(next, d.w(context) + next);
        }
        return asList;
    }

    private eo.a c(String str) throws Exception {
        com.xeagle.android.utils.file.IO.a aVar = new com.xeagle.android.utils.file.IO.a();
        InputStream open = this.f30588a.getAssets().open(this.f30590c.get(str));
        aVar.a(open);
        open.close();
        return aVar.a();
    }

    public eo.a a(String str) throws Exception {
        if (this.f30589b.containsKey(str)) {
            return b(str);
        }
        if (this.f30590c.containsKey(str)) {
            return c(str);
        }
        throw new FileNotFoundException();
    }

    public List<String> a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(b(context));
        arrayList.addAll(a());
        return arrayList;
    }
}
