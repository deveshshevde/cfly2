package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f10185a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f10186b;

    /* renamed from: c  reason: collision with root package name */
    private T f10187c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f10186b = contentResolver;
        this.f10185a = uri;
    }

    public final void a(Priority priority, d.a<? super T> aVar) {
        try {
            T b2 = b(this.f10185a, this.f10186b);
            this.f10187c = b2;
            aVar.a(b2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t2) throws IOException;

    /* access modifiers changed from: protected */
    public abstract T b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public void b() {
        T t2 = this.f10187c;
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
