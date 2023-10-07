package ki;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.Projection;
import com.amap.api.maps.TextureSupportMapFragment;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.j;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.utils.f;
import com.xeagle.android.utils.prefs.AutoPanMode;
import com.xeagle.android.vjoystick.fragment.WaypointToolFragment;
import dy.p;
import fg.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import jo.w;
import jo.y;
import kh.a;
import kh.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class a extends TextureSupportMapFragment implements kh.a {

    /* renamed from: d  reason: collision with root package name */
    public static String f13862d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f13863e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f13864f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f13865g = "";
    /* access modifiers changed from: private */
    public double A;
    /* access modifiers changed from: private */
    public double B;
    /* access modifiers changed from: private */
    public String C;
    private boolean D = true;
    private Marker E;
    private Circle F;
    private Location G;
    /* access modifiers changed from: private */
    public AppCompatActivity H;
    private float I = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    List<LatLng> f13866h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    protected boolean f13867i = false;

    /* renamed from: j  reason: collision with root package name */
    protected XEagleApp f13868j;

    /* renamed from: k  reason: collision with root package name */
    private en.a f13869k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final kv.a<b, Marker> f13870l = new kv.a<>();

    /* renamed from: m  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f13871m;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicReference<AutoPanMode> f13872n = new AtomicReference<>(AutoPanMode.USER);

    /* renamed from: o  reason: collision with root package name */
    private Polyline f13873o;

    /* renamed from: p  reason: collision with root package name */
    private Polyline f13874p;

    /* renamed from: q  reason: collision with root package name */
    private Polyline f13875q;

    /* renamed from: r  reason: collision with root package name */
    private Polyline f13876r;

    /* renamed from: s  reason: collision with root package name */
    private int f13877s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public a.C0209a f13878t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public a.b f13879u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public a.c f13880v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public a.d f13881w;

    /* renamed from: x  reason: collision with root package name */
    private List<Polygon> f13882x = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    private Polygon f13883y;

    /* renamed from: z  reason: collision with root package name */
    private Circle f13884z;

    /* renamed from: ki.a$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30077a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f30078b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        static {
            /*
                com.xeagle.android.utils.prefs.AutoPanMode[] r0 = com.xeagle.android.utils.prefs.AutoPanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30078b = r0
                r1 = 1
                com.xeagle.android.utils.prefs.AutoPanMode r2 = com.xeagle.android.utils.prefs.AutoPanMode.DRONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f30078b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.utils.prefs.AutoPanMode r3 = com.xeagle.android.utils.prefs.AutoPanMode.USER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f30078b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.utils.prefs.AutoPanMode r3 = com.xeagle.android.utils.prefs.AutoPanMode.DISABLED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r2 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f30077a = r2
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f30077a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r2 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HOME     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ki.a.AnonymousClass7.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void a(AMap aMap) {
        UiSettings uiSettings = aMap.getUiSettings();
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomGesturesEnabled(true);
        uiSettings.setScrollGesturesEnabled(true);
        uiSettings.setTiltGesturesEnabled(false);
        uiSettings.setRotateGesturesEnabled(true);
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setMyLocationButtonEnabled(false);
        uiSettings.setScaleControlsEnabled(true);
        getMap().moveCamera(CameraUpdateFactory.zoomTo(19.0f));
    }

    private void a(Marker marker, b bVar, LatLng latLng, boolean z2) {
        Bitmap icon = bVar.getIcon(this.H.getResources());
        if (icon != null) {
            marker.setIcon(BitmapDescriptorFactory.fromBitmap(icon));
        }
        marker.setAnchor(bVar.getAnchorU(), bVar.getAnchorV());
        marker.setPosition(latLng);
        marker.setRotateAngle(-bVar.getRotation());
        marker.setTitle(bVar.getTitle());
        marker.setDraggable(z2);
        marker.setVisible(bVar.isVisible());
        if (bVar.getTitle() != null) {
            if (!bVar.getTitle().equals("-")) {
                marker.showInfoWindow();
            } else {
                marker.hideInfoWindow();
            }
        }
    }

    private void a(AutoPanMode autoPanMode, AutoPanMode autoPanMode2) {
        if (this.f13872n.compareAndSet(autoPanMode, autoPanMode2)) {
            if (AnonymousClass7.f30078b[autoPanMode.ordinal()] == 1) {
                this.f13869k.b((DroneInterfaces.c) this);
            }
            if (AnonymousClass7.f30078b[autoPanMode2.ordinal()] == 1) {
                this.f13869k.a((DroneInterfaces.c) this);
            }
        }
    }

    private void a(b bVar, LatLng latLng, boolean z2) {
        BitmapDescriptor bitmapDescriptor;
        MarkerOptions title = new MarkerOptions().position(latLng).draggable(z2).anchor(bVar.getAnchorU(), bVar.getAnchorV()).title(bVar.getSnippet()).title(bVar.getTitle());
        Bitmap icon = bVar.getIcon(this.H.getResources());
        if (icon != null) {
            Log.i("Listener", "generateMarker:--icon--- " + icon.getGenerationId());
            bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(icon);
        } else {
            bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_white);
        }
        title.icon(bitmapDescriptor);
        this.f13870l.a(bVar, getMap().addMarker(title));
    }

    private void c(ef.a aVar) {
        if (aVar != null) {
            a(aVar, getMap().getCameraPosition().zoom);
        }
    }

    private LatLngBounds e(List<LatLng> list) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng include : list) {
            builder.include(include);
        }
        return builder.build();
    }

    /* access modifiers changed from: private */
    public void h() {
        final AnonymousClass1 r0 = new AMap.OnMapClickListener() {
            public void onMapClick(LatLng latLng) {
                ef.a aVar;
                boolean z2;
                a.C0209a aVar2;
                Log.i("AMapTouch", "onMapClick:====33333333333 ");
                if (a.this.f13878t != null) {
                    ef.a a2 = f.a(a.this.H.getApplicationContext(), latLng);
                    if (a.this.C.equalsIgnoreCase(WaypointToolFragment.EditorTools.NONE.name())) {
                        aVar2 = a.this.f13878t;
                        aVar = f.a(a.this.H.getApplicationContext(), latLng);
                        z2 = false;
                    } else if (a.this.A != i.f27244a && a.this.B != i.f27244a) {
                        if (eg.a.c(a2, new ef.a(a.this.A, a.this.B)).a() <= 100.0d) {
                            aVar2 = a.this.f13878t;
                            aVar = f.a(a.this.H.getApplicationContext(), latLng);
                            z2 = true;
                        } else {
                            c a3 = r.a().a(a.this.H.getString(R.string.dialog_tips), a.this.H.getString(R.string.replan_warning), (c.a) new c.a() {
                                public void onYes() {
                                }
                            });
                            if (a3 != null) {
                                a3.show(a.this.getChildFragmentManager(), "waypoint");
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                    aVar2.a(aVar, z2);
                }
            }
        };
        getMap().setOnMapClickListener(r0);
        getMap().setOnMapLongClickListener(new AMap.OnMapLongClickListener() {
            public void onMapLongClick(LatLng latLng) {
                if (a.this.f13879u != null) {
                    a.this.f13879u.a(f.a(a.this.H.getApplicationContext(), latLng));
                }
            }
        });
        getMap().setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                if (a.this.f13867i) {
                    r0.onMapClick(marker.getPosition());
                    return true;
                } else if (a.this.f13880v != null) {
                    return a.this.f13880v.d((b) a.this.f13870l.c(marker));
                } else {
                    return false;
                }
            }
        });
        getMap().setOnMarkerDragListener(new AMap.OnMarkerDragListener() {
            public void onMarkerDrag(Marker marker) {
                if (a.this.f13881w != null) {
                    b bVar = (b) a.this.f13870l.c(marker);
                    bVar.setPosition(f.a(a.this.H.getApplicationContext(), marker.getPosition()));
                    a.this.f13881w.a(bVar);
                }
            }

            public void onMarkerDragEnd(Marker marker) {
                if (a.this.f13881w != null) {
                    b bVar = (b) a.this.f13870l.c(marker);
                    bVar.setPosition(f.a(a.this.H.getApplicationContext(), marker.getPosition()));
                    a.this.f13881w.c(bVar);
                }
            }

            public void onMarkerDragStart(Marker marker) {
                if (a.this.f13881w != null) {
                    b bVar = (b) a.this.f13870l.c(marker);
                    bVar.setPosition(f.a(a.this.H.getApplicationContext(), marker.getPosition()));
                    a.this.f13881w.b(bVar);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void i() {
        getMap().setMapType(j());
        new Thread(new Runnable() {
            public void run() {
                a.this.getMap().reloadMap();
            }
        }).start();
    }

    private int j() {
        String P = this.f13871m.P();
        f13865g = this.H.getString(R.string.menu_map_type_terrain);
        f13862d = this.H.getString(R.string.menu_map_type_satellite);
        f13864f = this.H.getString(R.string.menu_map_type_normal);
        f13863e = this.H.getString(R.string.menu_map_type_hybrid);
        if (!P.equalsIgnoreCase(f13862d) && !P.equalsIgnoreCase(f13863e)) {
            return (!P.equalsIgnoreCase(f13864f) && !P.equalsIgnoreCase(f13865g)) ? 2 : 1;
        }
        return 2;
    }

    public List<ef.a> a(List<ef.a> list) {
        ArrayList arrayList = new ArrayList();
        Projection projection = getMap().getProjection();
        for (ef.a next : list) {
            arrayList.add(f.a(this.H.getApplicationContext(), projection.fromScreenLocation(new Point((int) next.d(), (int) next.c()))));
        }
        return arrayList;
    }

    public void a() {
        if (this.f13873o != null) {
            this.f13866h.clear();
            this.f13873o.remove();
            this.f13873o = null;
        }
    }

    public void a(float f2) {
        getMap().animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(getMap().getCameraPosition()).bearing(f2 % 360.0f).build()));
    }

    public void a(int i2, int i3, int i4, int i5) {
    }

    public void a(LocationListener locationListener) {
    }

    public void a(AutoPanMode autoPanMode) {
        AutoPanMode autoPanMode2 = this.f13872n.get();
        if (autoPanMode2 != autoPanMode) {
            a(autoPanMode2, autoPanMode);
        }
    }

    public void a(ef.a aVar) {
        if (aVar.d() != i.f27244a && aVar.c() != i.f27244a && aVar.c() != i.f27244a && aVar.d() != i.f27244a) {
            LatLng a2 = f.a(this.H.getApplicationContext(), aVar);
            if (this.f13877s > 0) {
                this.f13866h.add(a2);
                if (this.f13866h.size() >= 2) {
                    if (this.f13873o == null) {
                        Log.i("Listener", "addFlightPathPoint: --- add Flight");
                        PolylineOptions zIndex = new PolylineOptions().color(-169665).width(6.0f).zIndex(1.0f);
                        zIndex.setPoints(this.f13866h);
                        this.f13873o = getMap().addPolyline(zIndex);
                    }
                    this.f13873o.setPoints(this.f13866h);
                } else if (this.f13873o != null) {
                    Log.i("AMap", "addFlightPathPoint: =====remove");
                    this.f13873o.remove();
                    this.f13873o = null;
                }
            }
        }
    }

    public void a(ef.a aVar, float f2) {
        if (aVar != null) {
            getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(f.a(this.H.getApplicationContext(), aVar), f2));
        }
    }

    public void a(eo.b bVar) {
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.strokeColor(0);
        polygonOptions.strokeWidth(2.0f);
        ArrayList arrayList = new ArrayList();
        for (ef.a a2 : bVar.b()) {
            arrayList.add(f.a(this.H.getApplicationContext(), a2));
        }
        polygonOptions.addAll(arrayList);
        getMap().addPolygon(polygonOptions);
    }

    public void a(Collection<b> collection) {
        if (collection != null && !collection.isEmpty()) {
            for (b next : collection) {
                Marker b2 = this.f13870l.b(next);
                if (b2 != null) {
                    b2.remove();
                    this.f13870l.a(next);
                }
            }
        }
    }

    public void a(List<b> list, boolean z2) {
        for (b a2 : list) {
            a(a2, z2);
        }
    }

    public void a(a.C0209a aVar) {
        this.f13878t = aVar;
    }

    public void a(a.b bVar) {
        this.f13879u = bVar;
    }

    public void a(a.c cVar) {
        this.f13880v = cVar;
    }

    public void a(a.d dVar) {
        this.f13881w = dVar;
    }

    public void a(a.e eVar) {
        if (eVar.getPathPoints().size() != 0) {
            List<ef.a> pathPoints = eVar.getPathPoints();
            ArrayList arrayList = new ArrayList(pathPoints.size());
            for (ef.a next : pathPoints) {
                if (!(next.d() == i.f27244a || next.c() == i.f27244a)) {
                    arrayList.add(f.a(this.H.getApplicationContext(), next));
                }
            }
            if (arrayList.size() < 2) {
                Log.i("AMap", "updateDroneLeashPath: 222222222222222222");
                Polyline polyline = this.f13875q;
                if (polyline != null) {
                    polyline.remove();
                    this.f13875q = null;
                    return;
                }
                return;
            }
            if (this.f13875q == null) {
                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.color(-1).width((float) f.a(2.0d, this.H.getResources()));
                polylineOptions.setPoints(arrayList);
                this.f13875q = getMap().addPolyline(polylineOptions);
            }
            this.f13875q.setPoints(arrayList);
        }
    }

    public void a(b bVar) {
        a(bVar, bVar.isDraggable());
    }

    public void a(b bVar, boolean z2) {
        ef.a position = bVar.getPosition();
        if (position != null && position.d() != i.f27244a && position.c() != i.f27244a) {
            LatLng a2 = f.a(this.H.getApplicationContext(), position);
            Marker b2 = this.f13870l.b(bVar);
            if (b2 == null) {
                a(bVar, a2, z2);
            } else {
                a(b2, bVar, a2, z2);
            }
        }
    }

    public void a(boolean z2) {
        this.f13867i = z2;
    }

    public Set<b> b() {
        return new HashSet(this.f13870l.a());
    }

    public void b(ef.a aVar) {
        LatLng a2 = f.a(this.H.getApplicationContext(), aVar);
        if (a2 != null && this.G != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f.a(this.G));
            arrayList.add(f.a(this.H.getApplicationContext(), a2));
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(f.a(this.H.getApplicationContext(), (ef.a) it2.next()));
            }
            if (this.f13876r == null) {
                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.color(-65536).width((float) f.a(2.0d, this.H.getResources()));
                polylineOptions.setPoints(arrayList2);
                this.f13876r = getMap().addPolyline(polylineOptions);
            }
            this.f13876r.setPoints(arrayList2);
        }
    }

    public void b(eo.b bVar) {
        if (this.f13883y == null) {
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.strokeWidth(2.0f);
            polygonOptions.strokeColor(0);
            ArrayList arrayList = new ArrayList();
            for (ef.a a2 : bVar.b()) {
                arrayList.add(f.a(this.H.getApplicationContext(), a2));
            }
            polygonOptions.addAll(arrayList);
            this.f13883y = getMap().addPolygon(polygonOptions);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (ef.a a3 : bVar.b()) {
            arrayList2.add(f.a(this.H.getApplicationContext(), a3));
        }
        this.f13883y.setPoints(arrayList2);
    }

    public void b(List<List<ef.a>> list) {
        for (Polygon remove : this.f13882x) {
            remove.remove();
        }
        for (List<ef.a> next : list) {
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.strokeWidth(4.0f);
            polygonOptions.strokeColor(-65536);
            ArrayList arrayList = new ArrayList(next.size());
            for (ef.a a2 : next) {
                arrayList.add(f.a(this.H.getApplicationContext(), a2));
            }
            polygonOptions.addAll(arrayList);
            this.f13882x.add(getMap().addPolygon(polygonOptions));
        }
    }

    public void b(a.e eVar) {
        List<ef.a> pathPoints = eVar.getPathPoints();
        ArrayList arrayList = new ArrayList(pathPoints.size());
        for (ef.a a2 : pathPoints) {
            arrayList.add(f.a(this.H.getApplicationContext(), a2));
        }
        if (arrayList.size() < 2) {
            Polyline polyline = this.f13874p;
            if (polyline != null) {
                polyline.remove();
                this.f13874p = null;
                return;
            }
            return;
        }
        if (this.f13874p == null) {
            PolylineOptions polylineOptions = new PolylineOptions();
            polylineOptions.color(-169665).width(6.0f);
            polylineOptions.setPoints(arrayList);
            this.f13874p = getMap().addPolyline(polylineOptions);
        }
        this.f13874p.setPoints(arrayList);
    }

    public DPMapProvider c() {
        return this.f13871m != null ? DPMapProvider.LBS_AMAP.name().equalsIgnoreCase(this.f13871m.V()) ? DPMapProvider.LBS_AMAP : DPMapProvider.SYSTEM_LOC.name().equalsIgnoreCase(this.f13871m.V()) ? DPMapProvider.SYSTEM_LOC : DPMapProvider.LBS_AMAP : DPMapProvider.LBS_AMAP;
    }

    public void c(List<ef.a> list) {
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ef.a a2 : list) {
                arrayList.add(f.a((Context) this.H, a2));
            }
            getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(e((List<LatLng>) arrayList), 1));
        }
    }

    public void d() {
        en.a k2 = this.f13868j.k();
        if (k2.j().a()) {
            Log.i("AMap", "goToDroneLocation: ");
            j b2 = k2.b();
            if (b2.a() && getMap().getCameraPosition() != null) {
                a(b2.b(), getMap().getCameraPosition().zoom);
            }
        }
    }

    public void d(List<ef.a> list) {
        Location location = this.G;
        if (!(location == null || (location.getLatitude() == i.f27244a && this.G.getLongitude() == i.f27244a))) {
            list = new ArrayList<>();
            list.add(new ef.a(this.G.getLatitude(), this.G.getLongitude()));
        }
        c(list);
    }

    public void e() {
        Log.i("Map", "goToMyLocation: ");
        Location location = this.G;
        if (location == null) {
            return;
        }
        if (location.getLatitude() != i.f27244a || this.G.getLongitude() != i.f27244a) {
            c(new ef.a(this.G.getLatitude(), this.G.getLongitude()));
        }
    }

    public void f() {
        SharedPreferences sharedPreferences = this.f13871m.f12775b;
        CameraPosition.Builder builder = new CameraPosition.Builder();
        builder.tilt(sharedPreferences.getFloat("AMAP_TILT", 0.0f));
        builder.zoom(sharedPreferences.getFloat("AMAP_ZOOM", 18.0f));
        builder.target(new LatLng((double) sharedPreferences.getFloat("AMAP_LAT", 37.85755f), (double) sharedPreferences.getFloat("AMAP_LNG", 122.29277f)));
        builder.bearing(sharedPreferences.getFloat("AMAP_BEAR", 0.0f));
        getMap().animateCamera(CameraUpdateFactory.newCameraPosition(builder.build()));
    }

    public void g() {
        CameraPosition cameraPosition = getMap().getCameraPosition();
        this.f13871m.f12775b.edit().putFloat("AMAP_LAT", (float) cameraPosition.target.latitude).putFloat("AMAP_LNG", (float) cameraPosition.target.longitude).putFloat("AMAP_TILT", cameraPosition.tilt).putFloat("AMAP_BEAR", cameraPosition.bearing).putFloat("AMAP_ZOOM", cameraPosition.zoom).apply();
    }

    @l(a = ThreadMode.MAIN)
    public void gpsEvent(p pVar) {
        if (pVar.a() == 23 && this.f13869k.b().a()) {
            ef.a b2 = this.f13869k.b().b();
            f.a(this.H.getApplicationContext(), f.a(this.H.getApplicationContext(), b2));
            LatLng a2 = f.a(this.H.getApplicationContext(), b2);
            if (this.f13884z == null) {
                c(b2);
                this.A = b2.d();
                this.B = b2.c();
                this.f13869k.L().a(this.A);
                this.f13869k.L().b(this.B);
                org.greenrobot.eventbus.c.a().d(new jo.j(this.A, this.B));
                this.f13884z = getMap().addCircle(new CircleOptions().fillColor(AMapEngineUtils.MAX_P20_WIDTH).center(a2).strokeWidth(2.0f).strokeColor(-1426122940).radius(100.0d));
            }
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13868j = (XEagleApp) activity.getApplication();
        this.H = (AppCompatActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13869k = ((XEagleApp) this.f13868j.getApplicationContext()).k();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f13871m = this.f13868j.j();
        this.f13877s = 300;
        return onCreateView;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        if (AnonymousClass7.f30077a[droneEventsType.ordinal()] == 1 && aVar.b().a()) {
            getMap().moveCamera(CameraUpdateFactory.zoomTo(19.0f));
            ef.a b2 = aVar.b().b();
            f.a(this.H.getApplicationContext(), f.a(this.H.getApplicationContext(), b2));
            LatLng a2 = f.a(this.H.getApplicationContext(), b2);
            if (this.f13884z == null) {
                c(b2);
                this.A = b2.d();
                this.B = b2.c();
                aVar.L().a(this.A);
                aVar.L().b(this.B);
                org.greenrobot.eventbus.c.a().d(new jo.j(this.A, this.B));
                this.f13884z = getMap().addCircle(new CircleOptions().fillColor(AMapEngineUtils.MAX_P20_WIDTH).center(a2).strokeWidth(2.0f).strokeColor(-1426122940).radius(100.0d));
            }
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (getMap() != null) {
            getMap().setOnMapLoadedListener(new AMap.OnMapLoadedListener() {
                public void onMapLoaded() {
                    a aVar = a.this;
                    aVar.a(aVar.getMap());
                    a.this.i();
                    a.this.h();
                    a.this.e();
                }
            });
        }
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void onWaypointChange(jo.l lVar) {
        this.C = lVar.a().name();
    }

    @l(a = ThreadMode.ASYNC)
    public void updateMapType(y yVar) {
        i();
    }

    @l(a = ThreadMode.MAIN)
    public void updateSelfLoc(w wVar) {
        BitmapDescriptor bitmapDescriptor;
        if (this.f13871m.aF()) {
            Location a2 = wVar.a();
            this.G = a2;
            LatLng a3 = f.a(this.H.getApplicationContext(), a2);
            if (this.D) {
                a(new ef.a(a2.getLatitude(), a2.getLongitude()), 18.0f);
                this.D = false;
                SystemClock.sleep(1000);
                a(new ef.a(a2.getLatitude(), a2.getLongitude()), 18.0f);
            }
            Circle circle = this.F;
            if (circle == null) {
                this.F = getMap().addCircle(new CircleOptions().center(a3).radius((double) (a2.getAccuracy() / 5.0f)).strokeWidth(1.0f).fillColor(1292281839).strokeColor(436207));
            } else {
                circle.setCenter(a3);
                this.F.setRadius((double) (a2.getAccuracy() / 5.0f));
            }
            Marker marker = this.E;
            if (marker == null) {
                MarkerOptions rotateAngle = new MarkerOptions().position(a3).draggable(false).setFlat(true).visible(true).anchor(0.5f, 0.5f).rotateAngle(-a2.getBearing());
                AppCompatActivity appCompatActivity = this.H;
                rotateAngle.icon((!(appCompatActivity instanceof SuperUI) || !((SuperUI) appCompatActivity).f12359h) ? BitmapDescriptorFactory.fromResource(R.drawable.location_map_gps_3d) : BitmapDescriptorFactory.fromResource(R.drawable.user_loc_hide));
                this.E = getMap().addMarker(rotateAngle);
                return;
            }
            AppCompatActivity appCompatActivity2 = this.H;
            if (appCompatActivity2 instanceof SuperUI) {
                if (((SuperUI) appCompatActivity2).f12359h) {
                    marker = this.E;
                    bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.user_loc_hide);
                    marker.setIcon(bitmapDescriptor);
                    this.E.setPosition(a3);
                    this.E.setRotateAngle(-a2.getBearing());
                }
                marker = this.E;
            }
            bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.location_map_gps_3d);
            marker.setIcon(bitmapDescriptor);
            this.E.setPosition(a3);
            this.E.setRotateAngle(-a2.getBearing());
        }
    }
}
