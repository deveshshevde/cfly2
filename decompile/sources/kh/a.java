package kh;

import android.graphics.Color;
import android.location.LocationListener;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.utils.prefs.AutoPanMode;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface a extends DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13859a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f13860b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f13861c = Color.argb(80, 0, 0, 200);

    public interface b {
        void a(ef.a aVar);
    }

    public interface c {
        boolean d(b bVar);
    }

    public interface d {
        void a(b bVar);

        void b(b bVar);

        void c(b bVar);
    }

    public interface e {
        List<ef.a> getPathPoints();
    }

    /* renamed from: kh.a$a  reason: collision with other inner class name */
    public interface C0209a {
        void a(ef.a aVar, boolean z2);
    }

    static {
        String name = a.class.getPackage().getName();
        f13859a = name;
        f13860b = name + ".EXTRA_MAX_FLIGHT_PATH_SIZE";
    }

    List<ef.a> a(List<ef.a> list);

    void a();

    void a(float f2);

    void a(int i2, int i3, int i4, int i5);

    void a(LocationListener locationListener);

    void a(AutoPanMode autoPanMode);

    void a(ef.a aVar);

    void a(ef.a aVar, float f2);

    void a(eo.b bVar);

    void a(Collection<b> collection);

    void a(List<b> list, boolean z2);

    void a(C0209a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    void a(b bVar);

    void a(boolean z2);

    Set<b> b();

    void b(ef.a aVar);

    void b(eo.b bVar);

    void b(List<List<ef.a>> list);

    void b(e eVar);

    DPMapProvider c();

    void c(List<ef.a> list);

    void d();

    void d(List<ef.a> list);

    void e();

    void f();

    void g();
}
