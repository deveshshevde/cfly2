package ks;

import android.content.Context;
import java.io.File;
import ku.a;
import kx.d;

public class e {
    public static File a(Context context) {
        String y2 = d.y(context);
        File file = new File(y2 + "coco.name");
        if (!file.exists()) {
            a.a(context, "yolo/coco.name", file);
        }
        return file;
    }

    public static File b(Context context) {
        String y2 = d.y(context);
        File file = new File(y2 + "yolo-fastest-xl.cfg");
        if (!file.exists()) {
            a.a(context, "yolo/yolo-fastest-xl.cfg", file);
        }
        return file;
    }

    public static File c(Context context) {
        String y2 = d.y(context);
        File file = new File(y2 + "yolo-fastest-xl.weights");
        if (!file.exists()) {
            a.a(context, "yolo/yolo-fastest-xl.weights", file);
        }
        return file;
    }

    public static File d(Context context) {
        String y2 = d.y(context);
        return new File(y2 + "yolo-full-cg.cfg");
    }

    public static File e(Context context) {
        String y2 = d.y(context);
        return new File(y2 + "yolo-full-wg.weights");
    }
}
