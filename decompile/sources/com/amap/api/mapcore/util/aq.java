package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aq {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<OfflineMapProvince> f7860a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private bb f7861b;

    /* renamed from: c  reason: collision with root package name */
    private Context f7862c;

    public aq(Context context) {
        this.f7862c = context;
        this.f7861b = bb.a(context);
    }

    private void a(al alVar, OfflineMapCity offlineMapCity) {
        int b2 = alVar.c().b();
        if (alVar.c().equals(alVar.f7809a)) {
            b(alVar.t());
        } else {
            if (alVar.c().equals(alVar.f7814f)) {
                new StringBuilder("saveJSONObjectToFile  CITY ").append(alVar.getCity());
                b(alVar);
                alVar.t().b();
            }
            if (a(alVar.getcompleteCode(), alVar.c().b())) {
                a(alVar.t());
            }
        }
        offlineMapCity.setState(b2);
        offlineMapCity.setCompleteCode(alVar.getcompleteCode());
    }

    private void a(al alVar, OfflineMapProvince offlineMapProvince) {
        aw awVar;
        int b2 = alVar.c().b();
        if (b2 == 6) {
            offlineMapProvince.setState(b2);
            offlineMapProvince.setCompleteCode(0);
            b(new aw(offlineMapProvince, this.f7862c));
            try {
                bj.b(offlineMapProvince.getProvinceCode(), this.f7862c);
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (a(b2) && a(offlineMapProvince)) {
            boolean equals = alVar.getPinyin().equals(offlineMapProvince.getPinyin());
            offlineMapProvince.setState(b2);
            if (equals) {
                offlineMapProvince.setCompleteCode(alVar.getcompleteCode());
                offlineMapProvince.setVersion(alVar.getVersion());
                offlineMapProvince.setUrl(alVar.getUrl());
                awVar = new aw(offlineMapProvince, this.f7862c);
                awVar.a(alVar.a());
                awVar.d(alVar.getCode());
            } else {
                offlineMapProvince.setCompleteCode(100);
                awVar = new aw(offlineMapProvince, this.f7862c);
            }
            awVar.b();
            a(awVar);
            new StringBuilder("saveJSONObjectToFile  province ").append(awVar.c());
        }
    }

    private void a(aw awVar) {
        bb bbVar = this.f7861b;
        if (bbVar != null && awVar != null) {
            bbVar.a(awVar);
        }
    }

    private static void a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    private static void a(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    private static boolean a(int i2) {
        return i2 == 4;
    }

    private static boolean a(int i2, int i3) {
        return i3 != 1 || i2 <= 2 || i2 >= 98;
    }

    private static boolean a(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator<OfflineMapCity> it2 = offlineMapProvince.getCityList().iterator();
        while (it2.hasNext()) {
            if (it2.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    private void b(al alVar) {
        File[] listFiles = new File(dl.c(this.f7862c)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.exists() && file.getName().contains(alVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                    file.delete();
                }
            }
        }
    }

    private void b(aw awVar) {
        bb bbVar = this.f7861b;
        if (bbVar != null) {
            bbVar.b(awVar);
        }
    }

    private static boolean b(int i2) {
        return i2 == 0 || i2 == 2 || i2 == 3 || i2 == 1 || i2 == 102 || i2 == 101 || i2 == 103 || i2 == -1;
    }

    private void h() {
        ArrayList<OfflineMapProvince> arrayList = this.f7860a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f7860a.clear();
            }
        }
    }

    public final OfflineMapCity a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f7860a) {
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            while (it2.hasNext()) {
                Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        OfflineMapCity next = it3.next();
                        if (next.getCode().equals(str)) {
                            return next;
                        }
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapProvince> a() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.f7860a) {
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        }
        return arrayList;
    }

    public final void a(al alVar) {
        String pinyin = alVar.getPinyin();
        synchronized (this.f7860a) {
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            loop0:
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                OfflineMapProvince next = it2.next();
                if (next != null) {
                    for (OfflineMapCity next2 : next.getCityList()) {
                        if (next2.getPinyin().trim().equals(pinyin.trim())) {
                            a(alVar, next2);
                            a(alVar, next);
                            break loop0;
                        }
                    }
                    continue;
                }
            }
        }
    }

    public final void a(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        synchronized (this.f7860a) {
            if (this.f7860a.size() > 0) {
                for (int i2 = 0; i2 < this.f7860a.size(); i2++) {
                    OfflineMapProvince offlineMapProvince2 = this.f7860a.get(i2);
                    Iterator<OfflineMapProvince> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            offlineMapProvince = null;
                            break;
                        }
                        offlineMapProvince = it2.next();
                        if (offlineMapProvince2.getPinyin().equals(offlineMapProvince.getPinyin())) {
                            break;
                        } else if ((offlineMapProvince2.getPinyin().equals("quanguogaiyaotu") || offlineMapProvince2.getProvinceCode().equals("000001") || offlineMapProvince2.getProvinceCode().equals("100000")) && offlineMapProvince.getPinyin().equals("quanguogaiyaotu")) {
                            break;
                        }
                    }
                    if (offlineMapProvince != null) {
                        a(offlineMapProvince2, offlineMapProvince);
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                        for (int i3 = 0; i3 < cityList.size(); i3++) {
                            OfflineMapCity offlineMapCity2 = cityList.get(i3);
                            Iterator<OfflineMapCity> it3 = cityList2.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    offlineMapCity = null;
                                    break;
                                }
                                offlineMapCity = it3.next();
                                if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                    break;
                                }
                            }
                            if (offlineMapCity != null) {
                                a(offlineMapCity2, offlineMapCity);
                            }
                        }
                    }
                }
            } else {
                for (OfflineMapProvince add : list) {
                    this.f7860a.add(add);
                }
            }
        }
    }

    public final OfflineMapCity b(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f7860a) {
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            while (it2.hasNext()) {
                Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        OfflineMapCity next = it3.next();
                        if (next.getCity().trim().equalsIgnoreCase(str.trim())) {
                            return next;
                        }
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> b() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (this.f7860a) {
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            while (it2.hasNext()) {
                Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
                while (it3.hasNext()) {
                    arrayList.add(it3.next());
                }
            }
        }
        return arrayList;
    }

    public final OfflineMapProvince c(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f7860a) {
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            while (it2.hasNext()) {
                OfflineMapProvince next = it2.next();
                if (next.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                    return next;
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> c() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f7860a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            while (it2.hasNext()) {
                OfflineMapProvince next = it2.next();
                if (next != null) {
                    for (OfflineMapCity next2 : next.getCityList()) {
                        if (next2.getState() == 4 || next2.getState() == 7) {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> d() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f7860a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            while (it2.hasNext()) {
                OfflineMapProvince next = it2.next();
                if (next != null && (next.getState() == 4 || next.getState() == 7)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> e() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f7860a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            while (it2.hasNext()) {
                OfflineMapProvince next = it2.next();
                if (next != null) {
                    for (OfflineMapCity next2 : next.getCityList()) {
                        if (b(next2.getState())) {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> f() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f7860a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it2 = this.f7860a.iterator();
            while (it2.hasNext()) {
                OfflineMapProvince next = it2.next();
                if (next != null && b(next.getState())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final void g() {
        h();
        this.f7861b = null;
        this.f7862c = null;
    }
}
