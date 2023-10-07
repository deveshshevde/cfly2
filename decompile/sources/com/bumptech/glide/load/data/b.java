package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

public abstract class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f10161a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f10162b;

    /* renamed from: c  reason: collision with root package name */
    private T f10163c;

    public b(AssetManager assetManager, String str) {
        this.f10162b = assetManager;
        this.f10161a = str;
    }

    /* access modifiers changed from: protected */
    public abstract T a(AssetManager assetManager, String str) throws IOException;

    public void a(Priority priority, d.a<? super T> aVar) {
        try {
            T a2 = a(this.f10162b, this.f10161a);
            this.f10163c = a2;
            aVar.a(a2);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t2) throws IOException;

    public void b() {
        T t2 = this.f10163c;
        if (t2 != null) {
            try {
                a(t2);
            } catch (IOException unused) {
            }
        }
    }

    public void c() {
    }

    public DataSource d() {
        return DataSource.LOCAL;
    }
}
