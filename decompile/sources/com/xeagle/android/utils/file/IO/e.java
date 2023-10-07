package com.xeagle.android.utils.file.IO;

import android.content.Context;
import com.MAVLink.common.msg_mission_item;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kx.f;
import kx.g;

public class e {
    private static void a(FileOutputStream fileOutputStream) throws IOException {
        fileOutputStream.write(String.format(Locale.ENGLISH, "QGC WPL 110\n", new Object[0]).getBytes());
    }

    private static void a(FileOutputStream fileOutputStream, List<msg_mission_item> list) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            msg_mission_item msg_mission_item = list.get(i2);
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[12];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i2 == 0 ? 1 : 0);
            objArr[2] = Byte.valueOf(msg_mission_item.f6942o);
            objArr[3] = Short.valueOf(msg_mission_item.f6939l);
            objArr[4] = Float.valueOf(msg_mission_item.f6931d);
            objArr[5] = Float.valueOf(msg_mission_item.f6932e);
            objArr[6] = Float.valueOf(msg_mission_item.f6933f);
            objArr[7] = Float.valueOf(msg_mission_item.f6934g);
            objArr[8] = Float.valueOf(msg_mission_item.f6935h);
            objArr[9] = Float.valueOf(msg_mission_item.f6936i);
            objArr[10] = Float.valueOf(msg_mission_item.f6937j);
            objArr[11] = Byte.valueOf(msg_mission_item.f6944q);
            fileOutputStream.write(String.format(locale, "%d\t%d\t%d\t%d\t%f\t%f\t%f\t%f\t%f\t%f\t%f\t%d\n", objArr).getBytes());
            i2++;
        }
    }

    public static boolean a(Context context, List<msg_mission_item> list, String str) {
        try {
            if (!f.b()) {
                return false;
            }
            if (!str.endsWith(".txt")) {
                str = str + ".txt";
            }
            FileOutputStream c2 = g.c(context, str);
            a(c2);
            a(c2, list);
            c2.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
