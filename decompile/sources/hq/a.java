package hq;

import android.view.View;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class a {
    public static boolean A = false;
    public static boolean B = false;
    public static int C = 0;
    public static int D = 0;

    /* renamed from: a  reason: collision with root package name */
    public static int f13377a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f13378b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static long f13379c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f13380d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static WeakReference<View> f13381e = null;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<View> f13382f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13383g = false;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f13384h = false;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f13385i = false;

    /* renamed from: j  reason: collision with root package name */
    public static ArrayList<Photo> f13386j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    public static boolean f13387k = false;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f13388l = false;

    /* renamed from: m  reason: collision with root package name */
    public static String f13389m = "";

    /* renamed from: n  reason: collision with root package name */
    public static boolean f13390n = false;

    /* renamed from: o  reason: collision with root package name */
    public static String f13391o = null;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f13392p = false;

    /* renamed from: q  reason: collision with root package name */
    public static int f13393q = 1;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f13394r = false;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f13395s = true;

    /* renamed from: t  reason: collision with root package name */
    public static List<String> f13396t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    public static boolean f13397u = false;

    /* renamed from: v  reason: collision with root package name */
    public static boolean f13398v = false;

    /* renamed from: w  reason: collision with root package name */
    public static boolean f13399w = true;

    /* renamed from: x  reason: collision with root package name */
    public static long f13400x = 0;

    /* renamed from: y  reason: collision with root package name */
    public static long f13401y = Long.MAX_VALUE;

    /* renamed from: z  reason: collision with root package name */
    public static hh.a f13402z = null;

    public static void a() {
        f13377a = 1;
        f13378b = 1;
        f13379c = 1;
        f13380d = 1;
        f13381e = null;
        f13382f = null;
        f13383g = false;
        f13384h = false;
        f13386j.clear();
        f13387k = false;
        f13388l = false;
        f13389m = "";
        f13390n = false;
        f13393q = 1;
        f13392p = false;
        f13394r = false;
        f13395s = true;
        f13396t = new ArrayList();
        f13397u = false;
        f13398v = false;
        f13399w = true;
        f13400x = 0;
        f13401y = Long.MAX_VALUE;
        A = false;
        B = false;
        C = 0;
        D = 0;
    }

    public static boolean a(String str) {
        String lowerCase = str.toLowerCase();
        for (String contains : f13396t) {
            if (lowerCase.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        return f13396t.size() == 1 && f13396t.get(0).equals("video");
    }

    public static boolean c() {
        WeakReference<View> weakReference = f13381e;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public static boolean d() {
        WeakReference<View> weakReference = f13382f;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public static boolean e() {
        return f13393q == 1;
    }
}
