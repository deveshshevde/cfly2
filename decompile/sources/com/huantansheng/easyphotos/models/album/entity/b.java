package com.huantansheng.easyphotos.models.album.entity;

import android.net.Uri;
import java.util.ArrayList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f20315a;

    /* renamed from: b  reason: collision with root package name */
    public String f20316b;

    /* renamed from: c  reason: collision with root package name */
    public String f20317c;

    /* renamed from: d  reason: collision with root package name */
    public Uri f20318d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Photo> f20319e = new ArrayList<>();

    b(String str, String str2, String str3, Uri uri) {
        this.f20315a = str;
        this.f20316b = str2;
        this.f20317c = str3;
        this.f20318d = uri;
    }

    public void a(int i2, Photo photo) {
        this.f20319e.add(i2, photo);
    }

    public void a(Photo photo) {
        this.f20319e.add(photo);
    }
}
