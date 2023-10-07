package com.huantansheng.easyphotos.models.album.entity;

import android.net.Uri;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f20313a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private LinkedHashMap<String, b> f20314b = new LinkedHashMap<>();

    private void a(b bVar) {
        this.f20314b.put(bVar.f20315a, bVar);
        this.f20313a.add(bVar);
    }

    public b a(int i2) {
        return this.f20313a.get(i2);
    }

    public b a(String str) {
        return this.f20314b.get(str);
    }

    public void a(String str, String str2, String str3, Uri uri) {
        if (this.f20314b.get(str) == null) {
            a(new b(str, str2, str3, uri));
        }
    }

    public boolean a() {
        return this.f20313a.isEmpty();
    }

    public void b() {
        this.f20313a.clear();
        this.f20314b.clear();
    }
}
