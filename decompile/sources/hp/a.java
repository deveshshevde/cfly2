package hp;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import java.util.ArrayList;
import java.util.Iterator;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Photo> f13376a = new ArrayList<>();

    public static int a(Photo photo) {
        if (!f13376a.isEmpty() && hq.a.A) {
            if (hq.a.B) {
                if (f13376a.get(0).f20304d.contains("video") && !photo.f20304d.contains("video")) {
                    return -3;
                }
                if (!f13376a.get(0).f20304d.contains("video") && photo.f20304d.contains("video")) {
                    return -3;
                }
            }
            int f2 = f();
            if (photo.f20304d.contains("video") && f2 >= hq.a.C) {
                return -2;
            }
            int size = f13376a.size() - f2;
            if (!photo.f20304d.contains("video") && size >= hq.a.D) {
                return -1;
            }
        }
        photo.f20311k = true;
        f13376a.add(photo);
        return 0;
    }

    public static void a() {
        int size = f13376a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(0);
        }
    }

    public static void a(int i2) {
        b(f13376a.get(i2));
    }

    public static String b(int i2) {
        return f13376a.get(i2).f20303c;
    }

    public static void b() {
        boolean z2 = Build.VERSION.SDK_INT == 15;
        if (hq.a.f13387k && hq.a.f13388l) {
            Iterator<Photo> it2 = f13376a.iterator();
            while (it2.hasNext()) {
                Photo next = it2.next();
                next.f20312l = hq.a.f13390n;
                if (z2 && next.f20305e == 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(next.f20303c, options);
                    next.f20305e = options.outWidth;
                    next.f20306f = options.outHeight;
                }
            }
        }
    }

    public static void b(Photo photo) {
        photo.f20311k = false;
        f13376a.remove(photo);
    }

    public static Uri c(int i2) {
        return f13376a.get(i2).f20301a;
    }

    public static String c(Photo photo) {
        return String.valueOf(f13376a.indexOf(photo) + 1);
    }

    public static void c() {
        f13376a.clear();
    }

    public static String d(int i2) {
        return f13376a.get(i2).f20304d;
    }

    public static boolean d() {
        return f13376a.isEmpty();
    }

    public static int e() {
        return f13376a.size();
    }

    public static long e(int i2) {
        return f13376a.get(i2).f20309i;
    }

    private static int f() {
        Iterator<Photo> it2 = f13376a.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            if (it2.next().f20304d.contains("video")) {
                i2++;
            }
        }
        return i2;
    }
}
