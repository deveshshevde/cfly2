package com.xeagle.android.utils.file.IO;

import android.content.Context;
import java.io.PrintStream;
import kx.g;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Throwable f12771a;

    /* renamed from: b  reason: collision with root package name */
    private String f12772b;

    public b(String str, Throwable th) {
        this.f12771a = th;
        this.f12772b = str;
    }

    public void a(Context context) {
        try {
            PrintStream printStream = new PrintStream(g.b(context, this.f12772b));
            this.f12771a.printStackTrace(printStream);
            printStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
