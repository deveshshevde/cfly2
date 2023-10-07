package com.xeagle.android.login.listener;

import android.content.Context;
import android.util.Log;
import com.flypro.core.drone.variables.ListenerData;
import com.xeagle.android.utils.c;
import ea.e;
import en.a;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import kx.f;

public class ListenerReader {
    private Context context;
    private ArrayList<ListenerData> listenerDatas = new ArrayList<>();
    private e listenerInfo = new e();

    public interface OnListenerParse {
        void onParseFail(String str);

        void onParseSuccess();
    }

    public ListenerReader(Context context2) {
        this.context = context2;
    }

    private void parseLines(BufferedReader bufferedReader, a aVar) throws IOException {
        e eVar;
        String str;
        this.listenerDatas.clear();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (readLine.contains("userId")) {
                String[] split = readLine.split("\t");
                if (split.length >= 22) {
                    this.listenerInfo.a(split[1]);
                    this.listenerInfo.b(split[3]);
                    this.listenerInfo.c(split[5]);
                    this.listenerInfo.d(split[7]);
                    this.listenerInfo.e(split[9]);
                    this.listenerInfo.f(split[11]);
                    this.listenerInfo.g(split[13]);
                    this.listenerInfo.h(split[15]);
                    this.listenerInfo.i(split[17]);
                    this.listenerInfo.j(split[19]);
                    eVar = this.listenerInfo;
                    str = split[21];
                } else {
                    this.listenerInfo.a(split[0]);
                    this.listenerInfo.b(split[1]);
                    this.listenerInfo.c(split[2]);
                    this.listenerInfo.d(split[3]);
                    this.listenerInfo.e(split[4]);
                    this.listenerInfo.f(split[5]);
                    this.listenerInfo.g(split[6]);
                    this.listenerInfo.h(split[7]);
                    this.listenerInfo.i(split[8]);
                    this.listenerInfo.j(split[9]);
                    eVar = this.listenerInfo;
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
                            this.listenerDatas.add(listenerData);
                        } catch (NumberFormatException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    } catch (NumberFormatException e3) {
                        e = e3;
                        a aVar2 = aVar;
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public ArrayList<ListenerData> getListenerDatas() {
        return this.listenerDatas;
    }

    public e getListenerInfo() {
        return this.listenerInfo;
    }

    public boolean openListener(String str, a aVar, OnListenerParse onListenerParse) {
        String message;
        if (!f.b()) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            String c2 = c.c(str);
            Log.i("TAG", "openListener: ====code===" + c2);
            parseLines(new BufferedReader(new InputStreamReader(fileInputStream, c2)), aVar);
            fileInputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            message = e2.getMessage();
        } catch (IOException e3) {
            e3.printStackTrace();
            message = e3.getMessage();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        onListenerParse.onParseSuccess();
        return true;
        onListenerParse.onParseFail(message);
        return false;
    }
}
