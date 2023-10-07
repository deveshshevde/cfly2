package com.xeagle.android.utils.file.IO;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import jw.a;
import kx.e;
import kx.f;

public class d implements a.C0202a {

    /* renamed from: a  reason: collision with root package name */
    private List<msg_mission_item> f24402a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Context f24403b;

    public d(Context context) {
        this.f24403b = context;
    }

    private void a(BufferedReader bufferedReader) throws IOException {
        this.f24402a.clear();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\t");
                msg_mission_item msg_mission_item = new msg_mission_item(this.f24403b);
                msg_mission_item.f6938k = Short.parseShort(split[0]);
                msg_mission_item.f6943p = Byte.parseByte(split[1]);
                msg_mission_item.f6942o = Byte.parseByte(split[2]);
                msg_mission_item.f6939l = Short.parseShort(split[3]);
                msg_mission_item.f6931d = Float.parseFloat(split[4]);
                msg_mission_item.f6932e = Float.parseFloat(split[5]);
                msg_mission_item.f6933f = Float.parseFloat(split[6]);
                msg_mission_item.f6934g = Float.parseFloat(split[7]);
                msg_mission_item.f6935h = Float.parseFloat(split[8]);
                msg_mission_item.f6936i = Float.parseFloat(split[9]);
                msg_mission_item.f6937j = Float.parseFloat(split[10]);
                msg_mission_item.f6944q = Byte.parseByte(split[11]);
                this.f24402a.add(msg_mission_item);
            } else {
                return;
            }
        }
    }

    private static boolean b(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().contains("QGC WPL 110");
    }

    public String a(Context context) {
        return kx.d.c(context);
    }

    public List<msg_mission_item> a() {
        return this.f24402a;
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
        return e.a(context);
    }
}
