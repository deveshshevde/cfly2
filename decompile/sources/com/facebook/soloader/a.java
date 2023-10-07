package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    private Context f11395a;

    /* renamed from: b  reason: collision with root package name */
    private int f11396b;

    /* renamed from: c  reason: collision with root package name */
    private b f11397c;

    public int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.f11397c.a(str, i2, threadPolicy);
    }

    /* access modifiers changed from: protected */
    public void a(int i2) throws IOException {
        this.f11397c.a(i2);
    }

    public boolean a() throws IOException {
        try {
            File file = this.f11397c.f11398a;
            Context context = this.f11395a;
            Context createPackageContext = context.createPackageContext(context.getPackageName(), 0);
            File file2 = new File(createPackageContext.getApplicationInfo().nativeLibraryDir);
            if (file.equals(file2)) {
                return false;
            }
            Log.d("SoLoader", "Native library directory updated from " + file + " to " + file2);
            int i2 = this.f11396b | 1;
            this.f11396b = i2;
            b bVar = new b(file2, i2);
            this.f11397c = bVar;
            bVar.a(this.f11396b);
            this.f11395a = createPackageContext;
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString() {
        return this.f11397c.toString();
    }
}
