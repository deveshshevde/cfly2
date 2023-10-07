package com.xeagle.android.utils.file.IO;

import android.content.Context;
import com.flypro.core.drone.variables.ListenerData;
import ea.e;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import jw.a;
import kx.d;
import kx.f;

public class c implements a.C0202a {

    /* renamed from: a  reason: collision with root package name */
    private e f24399a = new e();

    /* renamed from: b  reason: collision with root package name */
    private List<ListenerData> f24400b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private en.a f24401c;

    public c(en.a aVar) {
        this.f24401c = aVar;
    }

    private void a(BufferedReader bufferedReader, en.a aVar) throws IOException {
        e eVar;
        String str;
        this.f24400b.clear();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (readLine.contains("userId")) {
                String[] split = readLine.split("\t");
                if (split.length >= 22) {
                    this.f24399a.a(split[1]);
                    this.f24399a.b(split[3]);
                    this.f24399a.c(split[5]);
                    this.f24399a.d(split[7]);
                    this.f24399a.e(split[9]);
                    this.f24399a.f(split[11]);
                    this.f24399a.g(split[13]);
                    this.f24399a.h(split[15]);
                    this.f24399a.i(split[17]);
                    this.f24399a.j(split[19]);
                    eVar = this.f24399a;
                    str = split[21];
                } else {
                    this.f24399a.a(split[0]);
                    this.f24399a.b(split[1]);
                    this.f24399a.c(split[2]);
                    this.f24399a.d(split[3]);
                    this.f24399a.e(split[4]);
                    this.f24399a.f(split[5]);
                    this.f24399a.g(split[6]);
                    this.f24399a.h(split[7]);
                    this.f24399a.i(split[8]);
                    this.f24399a.j(split[9]);
                    eVar = this.f24399a;
                    str = split[10];
                }
                eVar.k(str);
            } else if (!readLine.contains("mode")) {
                String[] split2 = readLine.split("\t");
                if (split2.length > 1) {
                    try {
                        try {
                            ListenerData listenerData = new ListenerData(aVar);
                            listenerData.a(split2[0]);
                            listenerData.a(Integer.parseInt(split2[1]));
                            listenerData.a(Double.parseDouble(split2[2]));
                            listenerData.b(Integer.parseInt(split2[3]));
                            listenerData.b(Double.parseDouble(split2[4]));
                            listenerData.c(Double.parseDouble(split2[5]));
                            listenerData.d(Double.parseDouble(split2[6]));
                            listenerData.a(new ef.a(Double.parseDouble(split2[7]), Double.parseDouble(split2[8])));
                            listenerData.b(new ef.a(Double.parseDouble(split2[9]), Double.parseDouble(split2[10])));
                            listenerData.e(Double.parseDouble(split2[11]));
                            listenerData.b(split2[12]);
                            listenerData.f(Double.parseDouble(split2[13]));
                            listenerData.g(Double.parseDouble(split2[14]));
                            listenerData.h(Double.parseDouble(split2[15]));
                            listenerData.c(Integer.parseInt(split2[16]));
                            listenerData.d(Integer.parseInt(split2[17]));
                            listenerData.e(Integer.parseInt(split2[18]));
                            listenerData.f(Integer.parseInt(split2[19]));
                            listenerData.g(Integer.parseInt(split2[20]));
                            listenerData.h(Integer.parseInt(split2[21]));
                            listenerData.i(Integer.parseInt(split2[22]));
                            listenerData.j(Integer.parseInt(split2[23]));
                            listenerData.k(Integer.parseInt(split2[24]));
                            listenerData.l(Integer.parseInt(split2[25]));
                            listenerData.m(Integer.parseInt(split2[26]));
                            listenerData.n(Integer.parseInt(split2[27]));
                            listenerData.c(split2[28]);
                            listenerData.i(Double.parseDouble(split2[29]));
                            listenerData.j(Double.parseDouble(split2[30]));
                            listenerData.k(Double.parseDouble(split2[31]));
                            listenerData.l(Double.parseDouble(split2[32]));
                            listenerData.m(Double.parseDouble(split2[33]));
                            listenerData.n(Double.parseDouble(split2[34]));
                            listenerData.o(Double.parseDouble(split2[35]));
                            listenerData.p(Double.parseDouble(split2[36]));
                            listenerData.q(Double.parseDouble(split2[37]));
                            listenerData.r(Double.parseDouble(split2[38]));
                            listenerData.s(Double.parseDouble(split2[39]));
                            listenerData.t(Double.parseDouble(split2[40]));
                            listenerData.u(Double.parseDouble(split2[41]));
                            listenerData.v(Double.parseDouble(split2[42]));
                            listenerData.o(Integer.parseInt(split2[43]));
                            listenerData.d(split2[44]);
                            if (split2.length == 46) {
                                listenerData.e(split2[45]);
                            } else if (split2.length == 47) {
                                listenerData.e(split2[45]);
                                listenerData.w(Double.parseDouble(split2[46]));
                            }
                            this.f24400b.add(listenerData);
                        } catch (NumberFormatException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    } catch (NumberFormatException e3) {
                        e = e3;
                        en.a aVar2 = aVar;
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static boolean a(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().contains("userId");
    }

    public String a(Context context) {
        return d.d(context);
    }

    public List<ListenerData> a() {
        return this.f24400b;
    }

    public boolean a(String str) {
        return b(str);
    }

    public boolean b(String str) {
        if (!f.b()) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            if (!a(bufferedReader)) {
                fileInputStream.close();
                return false;
            }
            a(bufferedReader, this.f24401c);
            fileInputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public String[] b(Context context) {
        return kx.e.b(context);
    }
}
