package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    protected final File f11398a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f11399b;

    public b(File file, int i2) {
        this.f11398a = file;
        this.f11399b = i2;
    }

    private void a(File file, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] a2 = a(file);
        Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(a2));
        for (String str : a2) {
            if (!str.startsWith("/")) {
                SoLoader.a(str, i2 | 1, threadPolicy);
            }
        }
    }

    private static String[] a(File file) throws IOException {
        if (SoLoader.f11384a) {
            Api18TraceUtils.a("SoLoader.getElfDependencies[" + file.getName() + "]");
        }
        try {
            return MinElf.a(file);
        } finally {
            if (SoLoader.f11384a) {
                Api18TraceUtils.a();
            }
        }
    }

    public int a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return a(str, i2, this.f11398a, threadPolicy);
    }

    /* access modifiers changed from: protected */
    public int a(String str, int i2, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            Log.d("SoLoader", str + " not found on " + file.getCanonicalPath());
            return 0;
        }
        Log.d("SoLoader", str + " found on " + file.getCanonicalPath());
        if ((i2 & 1) == 0 || (this.f11399b & 2) == 0) {
            if ((this.f11399b & 1) != 0) {
                a(file2, i2, threadPolicy);
            } else {
                Log.d("SoLoader", "Not resolving dependencies for " + str);
            }
            try {
                SoLoader.f11385b.a(file2.getAbsolutePath(), i2);
                return 1;
            } catch (UnsatisfiedLinkError e2) {
                if (e2.getMessage().contains("bad ELF magic")) {
                    Log.d("SoLoader", "Corrupted lib file detected");
                    return 3;
                }
                throw e2;
            }
        } else {
            Log.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
    }

    public String toString() {
        String str;
        try {
            str = String.valueOf(this.f11398a.getCanonicalPath());
        } catch (IOException unused) {
            str = this.f11398a.getName();
        }
        return getClass().getName() + "[root = " + str + " flags = " + this.f11399b + ']';
    }
}
