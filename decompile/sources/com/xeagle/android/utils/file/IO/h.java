package com.xeagle.android.utils.file.IO;

import android.content.Context;
import com.flypro.core.parameters.Parameter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kx.f;
import kx.g;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private List<Parameter> f24405a;

    public h(List<Parameter> list) {
        this.f24405a = list;
    }

    private void a(FileOutputStream fileOutputStream) throws IOException {
        fileOutputStream.write(("#NOTE: " + f.a() + "\n").getBytes());
    }

    private void b(FileOutputStream fileOutputStream) throws IOException {
        for (Parameter next : this.f24405a) {
            fileOutputStream.write(String.format(Locale.ENGLISH, "%s , %f\n", new Object[]{next.f14455a, Double.valueOf(next.f14456b)}).getBytes());
        }
    }

    public boolean a(Context context, String str) {
        try {
            if (!f.b()) {
                return false;
            }
            if (!str.endsWith(".param")) {
                str = str + ".param";
            }
            FileOutputStream a2 = g.a(context, str);
            a(a2);
            b(a2);
            a2.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
