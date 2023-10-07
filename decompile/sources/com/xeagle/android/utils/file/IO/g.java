package com.xeagle.android.utils.file.IO;

import android.content.Context;
import com.flypro.core.parameters.Parameter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import jw.a;
import kx.d;
import kx.e;
import kx.f;

public class g implements a.C0202a {

    /* renamed from: a  reason: collision with root package name */
    private List<Parameter> f24404a = new ArrayList();

    private void a(BufferedReader bufferedReader) throws IOException {
        this.f24404a.clear();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                try {
                    b(readLine);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    private void b(String str) throws Exception {
        String[] c2 = c(str);
        String str2 = c2[0];
        Double valueOf = Double.valueOf(c2[1]);
        Parameter.a(str2);
        this.f24404a.add(new Parameter(str2, valueOf));
    }

    private static boolean b(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().contains("#NOTE");
    }

    private String[] c(String str) throws Exception {
        String[] split = str.split(",");
        if (split.length == 2) {
            split[0] = split[0].trim();
            return split;
        }
        throw new Exception("Invalid Length");
    }

    public String a(Context context) {
        return d.b(context);
    }

    public List<Parameter> a() {
        return this.f24404a;
    }

    public boolean a(String str) {
        if (!f.b()) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            if (!b(bufferedReader)) {
                fileInputStream.close();
                return false;
            }
            a(bufferedReader);
            fileInputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public String[] b(Context context) {
        return e.c(context);
    }
}
