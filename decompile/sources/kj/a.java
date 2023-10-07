package kj;

import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.f;
import com.google.android.gms.location.h;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.i;
import com.google.android.gms.maps.k;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.b;
import com.google.android.gms.maps.model.d;
import com.google.android.gms.maps.model.e;
import com.google.android.gms.maps.model.g;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.helpers.LocalMapTileProvider;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.utils.j;
import com.xeagle.android.utils.prefs.AutoPanMode;
import com.xeagle.android.vjoystick.fragment.WaypointToolFragment;
import dy.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import jo.y;
import kh.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class a extends i implements j.b, kh.a {
    private static final com.google.android.gms.common.api.a<? extends a.d.e>[] E = {h.f18096a};

    /* renamed from: d  reason: collision with root package name */
    public static String f13885d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f13886e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f13887f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f13888g = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f13889h = "";

    /* renamed from: j  reason: collision with root package name */
    private static final String f13890j = "a";
    private boolean A = false;
    private List<e> B = new ArrayList();
    private e C;
    /* access modifiers changed from: private */
    public d D;
    /* access modifiers changed from: private */
    public final Handler F = new Handler();
    /* access modifiers changed from: private */
    public c G;
    private com.google.android.gms.maps.model.c H;
    /* access modifiers changed from: private */
    public double I;
    /* access modifiers changed from: private */
    public double J;
    /* access modifiers changed from: private */
    public String K;
    /* access modifiers changed from: private */
    public final f L = new f() {
        public void a(LocationAvailability locationAvailability) {
            super.a(locationAvailability);
        }

        public void a(LocationResult locationResult) {
            com.google.android.gms.maps.model.a aVar;
            d dVar;
            com.google.android.gms.maps.model.a aVar2;
            super.a(locationResult);
            Location a2 = locationResult.a();
            if (a2 != null) {
                if (a.this.D == null) {
                    final MarkerOptions a3 = new MarkerOptions().a(new LatLng(a2.getLatitude(), a2.getLongitude())).a(false).c(true).b(true).a(0.1f, 0.1f);
                    FragmentActivity activity = a.this.getActivity();
                    Objects.requireNonNull(activity);
                    if (activity instanceof SuperUI) {
                        FragmentActivity activity2 = a.this.getActivity();
                        Objects.requireNonNull(activity2);
                        if (((SuperUI) activity2).f12359h) {
                            aVar2 = b.a((int) R.drawable.user_loc_hide);
                            a3.a(aVar2);
                            a.this.a(new com.google.android.gms.maps.e() {
                                public void a(c cVar) {
                                    d unused = a.this.D = cVar.a(a3);
                                }
                            });
                        }
                    }
                    aVar2 = b.a((int) R.drawable.location_map_gps_3d);
                    a3.a(aVar2);
                    a.this.a(new com.google.android.gms.maps.e() {
                        public void a(c cVar) {
                            d unused = a.this.D = cVar.a(a3);
                        }
                    });
                } else {
                    FragmentActivity activity3 = a.this.getActivity();
                    Objects.requireNonNull(activity3);
                    if (activity3 instanceof SuperUI) {
                        FragmentActivity activity4 = a.this.getActivity();
                        Objects.requireNonNull(activity4);
                        if (((SuperUI) activity4).f12359h) {
                            dVar = a.this.D;
                            aVar = b.a((int) R.drawable.user_loc_hide);
                            dVar.a(aVar);
                            a.this.D.a(new LatLng(a2.getLatitude(), a2.getLongitude()));
                        }
                    }
                    dVar = a.this.D;
                    aVar = b.a((int) R.drawable.location_map_gps_3d);
                    dVar.a(aVar);
                    a.this.D.a(new LatLng(a2.getLatitude(), a2.getLongitude()));
                }
                a.this.a(com.xeagle.android.utils.f.a(a2), 21.0f);
                if (a.this.f13907z != null) {
                    a.this.f13907z.onLocationChanged(a2);
                }
            }
        }
    };
    private final j.a M = new j.a() {
        public void a() {
            Location lastLocation;
            FragmentActivity activity = a.this.getActivity();
            Objects.requireNonNull(activity);
            if ((androidx.core.app.a.b(activity.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.b(a.this.getActivity().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) && (lastLocation = h.f18097b.getLastLocation(b())) != null) {
                a.this.a(com.xeagle.android.utils.f.a(lastLocation), 20.0f);
                if (a.this.f13907z != null) {
                    a.this.f13907z.onLocationChanged(lastLocation);
                }
            }
        }
    };
    private final j.a N = new j.a() {
        public void a() {
            h.f18097b.removeLocationUpdates(b(), a.this.L);
        }
    };
    private final j.a O = new j.a() {
        public void a() {
            LocationRequest a2 = LocationRequest.a().a(100).b(10000).a(30000).a(20.0f);
            if (androidx.core.app.a.b(a.this.getActivity().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.b(a.this.getActivity().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                h.f18097b.requestLocationUpdates(b(), a2, a.this.L, a.this.F.getLooper());
            }
        }
    };
    private final j.a P = new j.a() {
        /* access modifiers changed from: protected */
        public void a() {
            Location lastLocation;
            if ((androidx.core.app.a.b(a.this.getActivity().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.b(a.this.getActivity().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) && (lastLocation = h.f18097b.getLastLocation(b())) != null && a.this.f13907z != null) {
                a.this.f13907z.onLocationChanged(lastLocation);
            }
        }
    };
    private final com.google.android.gms.maps.e Q = new com.google.android.gms.maps.e() {
        public void a(c cVar) {
            SharedPreferences sharedPreferences = a.this.f13894m.f12775b;
            CameraPosition.a aVar = new CameraPosition.a();
            aVar.c(sharedPreferences.getFloat("pref_map_bea", 0.0f));
            aVar.b(sharedPreferences.getFloat("pref_map_tilt", 0.0f));
            aVar.a(sharedPreferences.getFloat("pref_map_zoom", 18.0f));
            aVar.a(new LatLng((double) sharedPreferences.getFloat("pref_map_lat", 37.85755f), (double) sharedPreferences.getFloat("pref_map_lng", 122.29277f)));
            cVar.a(com.google.android.gms.maps.b.a(aVar.a()));
        }
    };
    private final com.google.android.gms.maps.e R = new com.google.android.gms.maps.e() {
        public void a(c cVar) {
            a.this.b(cVar);
            a.this.c(cVar);
            a.this.a(cVar);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    protected boolean f13891i = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final kv.a<kh.b, d> f13892k = new kv.a<>();

    /* renamed from: l  reason: collision with root package name */
    private en.a f13893l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public com.xeagle.android.utils.prefs.a f13894m;

    /* renamed from: n  reason: collision with root package name */
    private final LinkedList<Runnable> f13895n = new LinkedList<>();

    /* renamed from: o  reason: collision with root package name */
    private final AtomicReference<AutoPanMode> f13896o = new AtomicReference<>(AutoPanMode.USER);

    /* renamed from: p  reason: collision with root package name */
    private j f13897p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public com.google.android.gms.maps.model.f f13898q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public com.google.android.gms.maps.model.f f13899r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public com.google.android.gms.maps.model.f f13900s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public com.google.android.gms.maps.model.f f13901t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f13902u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public a.C0209a f13903v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public a.b f13904w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public a.c f13905x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public a.d f13906y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public LocationListener f13907z;

    /* renamed from: kj.a$16  reason: invalid class name */
    static /* synthetic */ class AnonymousClass16 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30094a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f30095b;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30095b = r0
                r1 = 1
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r2 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.xeagle.android.utils.prefs.AutoPanMode[] r0 = com.xeagle.android.utils.prefs.AutoPanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30094a = r0
                com.xeagle.android.utils.prefs.AutoPanMode r2 = com.xeagle.android.utils.prefs.AutoPanMode.DRONE     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f30094a     // Catch:{ NoSuchFieldError -> 0x002e }
                com.xeagle.android.utils.prefs.AutoPanMode r1 = com.xeagle.android.utils.prefs.AutoPanMode.USER     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r0 = f30094a     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.xeagle.android.utils.prefs.AutoPanMode r1 = com.xeagle.android.utils.prefs.AutoPanMode.DISABLED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kj.a.AnonymousClass16.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void a(c cVar) {
        final AnonymousClass8 r0 = new c.a() {
            public void a(LatLng latLng) {
                ef.a aVar;
                boolean z2;
                a.C0209a aVar2;
                if (a.this.f13903v != null) {
                    if (a.this.K.equalsIgnoreCase(WaypointToolFragment.EditorTools.NONE.name())) {
                        aVar2 = a.this.f13903v;
                        aVar = com.xeagle.android.utils.f.a(latLng);
                        z2 = false;
                    } else if (a.this.I != fg.i.f27244a && a.this.J != fg.i.f27244a) {
                        if (eg.a.c(com.xeagle.android.utils.f.a(latLng), new ef.a(a.this.I, a.this.J)).a() <= 100.0d) {
                            aVar2 = a.this.f13903v;
                            aVar = com.xeagle.android.utils.f.a(latLng);
                            z2 = true;
                        } else {
                            com.xeagle.android.dialogs.c a2 = r.a().a(a.this.getActivity().getString(R.string.dialog_tips), a.this.getActivity().getString(R.string.replan_warning), (c.a) new c.a() {
                                public void onYes() {
                                }
                            });
                            if (a2 != null) {
                                a2.show(a.this.getChildFragmentManager(), "waypoint");
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
        cVar.a((c.a) r0);
        cVar.a((c.b) new c.b() {
            public void a(LatLng latLng) {
                if (a.this.f13904w != null) {
                    a.this.f13904w.a(com.xeagle.android.utils.f.a(latLng));
                }
            }
        });
        cVar.a((c.d) new c.d() {
            public void a(d dVar) {
                if (a.this.f13906y != null) {
                    kh.b bVar = (kh.b) a.this.f13892k.c(dVar);
                    bVar.setPosition(com.xeagle.android.utils.f.a(dVar.b()));
                    a.this.f13906y.b(bVar);
                }
            }

            public void b(d dVar) {
                if (a.this.f13906y != null) {
                    kh.b bVar = (kh.b) a.this.f13892k.c(dVar);
                    bVar.setPosition(com.xeagle.android.utils.f.a(dVar.b()));
                    a.this.f13906y.a(bVar);
                }
            }

            public void c(d dVar) {
                if (a.this.f13906y != null) {
                    kh.b bVar = (kh.b) a.this.f13892k.c(dVar);
                    bVar.setPosition(com.xeagle.android.utils.f.a(dVar.b()));
                    a.this.f13906y.c(bVar);
                }
            }
        });
        cVar.a((c.C0125c) new c.C0125c() {
            public boolean a(d dVar) {
                if (a.this.f13891i) {
                    r0.a(dVar.b());
                    return true;
                } else if (a.this.f13905x != null) {
                    return a.this.f13905x.d((kh.b) a.this.f13892k.c(dVar));
                } else {
                    return false;
                }
            }
        });
    }

    private void a(d dVar, kh.b bVar, LatLng latLng, boolean z2) {
        Bitmap icon = bVar.getIcon(getResources());
        if (icon != null) {
            dVar.a(b.a(icon));
        }
        dVar.b(bVar.getAlpha());
        dVar.a(bVar.getAnchorU(), bVar.getAnchorV());
        dVar.b(bVar.getInfoWindowAnchorU(), bVar.getInfoWindowAnchorV());
        dVar.a(latLng);
        dVar.a(bVar.getRotation());
        dVar.b(bVar.getSnippet());
        dVar.a(bVar.getTitle());
        dVar.a(z2);
        dVar.c(bVar.isFlat());
        dVar.b(bVar.isVisible());
        if (bVar.getTitle() != null) {
            if (!bVar.getTitle().equals("-")) {
                dVar.c();
            } else {
                dVar.d();
            }
        }
    }

    private void a(AutoPanMode autoPanMode, AutoPanMode autoPanMode2) {
        if (this.f13896o.compareAndSet(autoPanMode, autoPanMode2)) {
            int i2 = AnonymousClass16.f30094a[autoPanMode.ordinal()];
            if (i2 == 1) {
                this.f13893l.b((DroneInterfaces.c) this);
            } else if (i2 == 2 && !this.f13897p.a(this.N)) {
                Log.e(f13890j, "Unable to add google api client task.");
            }
            int i3 = AnonymousClass16.f30094a[autoPanMode2.ordinal()];
            if (i3 == 1) {
                this.f13893l.a((DroneInterfaces.c) this);
            } else if (i3 == 2 && !this.f13897p.a(this.O)) {
                Log.e(f13890j, "Unable to add google api client task.");
            }
        }
    }

    private void a(kh.b bVar, LatLng latLng, boolean z2) {
        com.google.android.gms.maps.c l2 = l();
        if (l2 != null) {
            MarkerOptions b2 = new MarkerOptions().a(latLng).a(z2).b(bVar.getAlpha()).a(bVar.getAnchorU(), bVar.getAnchorV()).b(bVar.getInfoWindowAnchorU(), bVar.getInfoWindowAnchorV()).a(bVar.getRotation()).b(bVar.getSnippet()).a(bVar.getTitle()).c(bVar.isFlat()).b(bVar.isVisible());
            Bitmap icon = bVar.getIcon(getResources());
            if (icon != null) {
                b2.a(b.a(icon));
            }
            this.f13892k.a(bVar, l2.a(b2));
        }
    }

    /* access modifiers changed from: private */
    public void b(com.google.android.gms.maps.c cVar) {
        l().a(false);
        k b2 = cVar.b();
        b2.c(false);
        b2.g(false);
        b2.b(false);
        b2.e(false);
        b2.a(false);
        b2.d(true);
        b2.f(false);
        if (androidx.core.app.a.b(getActivity().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.b(getActivity().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
        }
    }

    /* access modifiers changed from: private */
    public void c(com.google.android.gms.maps.c cVar) {
        if (this.f13894m.O()) {
            e(cVar);
        } else {
            d(cVar);
        }
    }

    /* access modifiers changed from: private */
    public void d(com.google.android.gms.maps.c cVar) {
        cVar.a(n());
    }

    private LatLngBounds e(List<LatLng> list) {
        LatLngBounds.a aVar = new LatLngBounds.a();
        for (LatLng a2 : list) {
            aVar.a(a2);
        }
        return aVar.a();
    }

    private void e(com.google.android.gms.maps.c cVar) {
        cVar.a(0);
        g a2 = l().a(new TileOverlayOptions().a((com.google.android.gms.maps.model.h) new LocalMapTileProvider(getActivity().getApplicationContext())));
        a2.a(-1.0f);
        a2.a();
    }

    /* access modifiers changed from: private */
    public com.google.android.gms.maps.c l() {
        a(new com.google.android.gms.maps.e() {
            public void a(com.google.android.gms.maps.c cVar) {
                com.google.android.gms.maps.c unused = a.this.G = cVar;
            }
        });
        return this.G;
    }

    private void m() {
        com.google.android.gms.maps.d.a(getActivity().getApplicationContext());
        a(this.R);
    }

    private int n() {
        String P2 = this.f13894m.P();
        f13888g = getString(R.string.menu_map_type_terrain);
        f13885d = getString(R.string.menu_map_type_satellite);
        f13887f = getString(R.string.menu_map_type_normal);
        f13886e = getString(R.string.menu_map_type_hybrid);
        if (P2.equalsIgnoreCase(f13885d)) {
            return 2;
        }
        if (P2.equalsIgnoreCase(f13886e)) {
            return 4;
        }
        return (!P2.equalsIgnoreCase(f13887f) && P2.equalsIgnoreCase(f13888g)) ? 3 : 1;
    }

    public List<ef.a> a(List<ef.a> list) {
        ArrayList arrayList = new ArrayList();
        com.google.android.gms.maps.g c2 = l().c();
        for (ef.a next : list) {
            arrayList.add(com.xeagle.android.utils.f.a(c2.a(new Point((int) next.a(), (int) next.b()))));
        }
        return arrayList;
    }

    public void a() {
        com.google.android.gms.maps.model.f fVar = this.f13898q;
        if (fVar != null) {
            List<LatLng> a2 = fVar.a();
            a2.clear();
            this.f13898q.a(a2);
        }
    }

    public void a(float f2) {
        if (h() != null) {
            l().b(com.google.android.gms.maps.b.a(new CameraPosition(com.xeagle.android.utils.f.a(h()), i(), 0.0f, f2)));
        }
    }

    public void a(int i2) {
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            com.google.android.gms.common.e.a(i2, getActivity(), 0, new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    activity.finish();
                }
            });
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        l().a(i2, i3, i4, i5);
    }

    public void a(LocationListener locationListener) {
        this.f13907z = locationListener;
        if (locationListener != null && this.f13894m.aF()) {
            this.f13897p.a(this.P);
        }
    }

    public void a(ConnectionResult connectionResult) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (connectionResult.d()) {
                try {
                    connectionResult.a(activity, 0);
                } catch (IntentSender.SendIntentException unused) {
                    if (this.f13897p != null) {
                        this.f13897p.a();
                    }
                }
            } else {
                a(connectionResult.a());
            }
        }
    }

    public void a(AutoPanMode autoPanMode) {
        AutoPanMode autoPanMode2 = this.f13896o.get();
        if (autoPanMode2 != autoPanMode) {
            a(autoPanMode2, autoPanMode);
        }
    }

    public void a(ef.a aVar) {
        if (aVar.d() != fg.i.f27244a && aVar.c() != fg.i.f27244a) {
            final LatLng a2 = com.xeagle.android.utils.f.a(aVar);
            a(new com.google.android.gms.maps.e() {
                public void a(com.google.android.gms.maps.c cVar) {
                    if (a.this.f13902u > 0) {
                        if (a.this.f13898q == null) {
                            PolylineOptions polylineOptions = new PolylineOptions();
                            polylineOptions.a(-169665).a(6.0f).b(1.0f);
                            com.google.android.gms.maps.model.f unused = a.this.f13898q = cVar.a(polylineOptions);
                        }
                        List<LatLng> a2 = a.this.f13898q.a();
                        a2.add(a2);
                        a.this.f13898q.a(a2);
                    }
                }
            });
        }
    }

    public void a(final ef.a aVar, final float f2) {
        if (aVar != null) {
            a(new com.google.android.gms.maps.e() {
                public void a(com.google.android.gms.maps.c cVar) {
                    cVar.b(com.google.android.gms.maps.b.a(com.xeagle.android.utils.f.b(aVar), f2));
                }
            });
        }
    }

    public void a(eo.b bVar) {
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.a(0).a(2.0f);
        polygonOptions.b(f13861c);
        for (ef.a a2 : bVar.b()) {
            polygonOptions.a(com.xeagle.android.utils.f.a(a2));
        }
        l().a(polygonOptions);
    }

    public void a(Collection<kh.b> collection) {
        if (collection != null && !collection.isEmpty()) {
            for (kh.b next : collection) {
                d b2 = this.f13892k.b(next);
                if (b2 != null) {
                    b2.a();
                    this.f13892k.a(next);
                }
            }
        }
    }

    public void a(List<kh.b> list, boolean z2) {
        for (kh.b a2 : list) {
            a(a2, z2);
        }
    }

    public void a(a.C0209a aVar) {
        this.f13903v = aVar;
    }

    public void a(a.b bVar) {
        this.f13904w = bVar;
    }

    public void a(a.c cVar) {
        this.f13905x = cVar;
    }

    public void a(a.d dVar) {
        this.f13906y = dVar;
    }

    public void a(a.e eVar) {
        if (eVar.getPathPoints().size() != 0) {
            List<ef.a> pathPoints = eVar.getPathPoints();
            final ArrayList arrayList = new ArrayList(pathPoints.size());
            for (ef.a next : pathPoints) {
                if (!(next.d() == fg.i.f27244a || next.c() == fg.i.f27244a)) {
                    arrayList.add(com.xeagle.android.utils.f.a(next));
                }
            }
            com.google.android.gms.maps.model.f fVar = this.f13900s;
            if (fVar == null) {
                final PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.a(-1).a((float) com.xeagle.android.utils.f.a(2.0d, getResources()));
                a(new com.google.android.gms.maps.e() {
                    public void a(com.google.android.gms.maps.c cVar) {
                        a aVar = a.this;
                        com.google.android.gms.maps.model.f unused = aVar.f13900s = aVar.l().a(polylineOptions);
                        a.this.f13900s.a(arrayList);
                    }
                });
                return;
            }
            fVar.a(arrayList);
        }
    }

    public void a(kh.b bVar) {
        a(bVar, bVar.isDraggable());
    }

    public void a(kh.b bVar, boolean z2) {
        ef.a position = bVar.getPosition();
        if (position != null && position.d() != fg.i.f27244a && position.c() != fg.i.f27244a) {
            LatLng a2 = com.xeagle.android.utils.f.a(position);
            d b2 = this.f13892k.b(bVar);
            if (b2 == null) {
                a(bVar, a2, z2);
            } else {
                a(b2, bVar, a2, z2);
            }
        }
    }

    public void a(boolean z2) {
        this.f13891i = z2;
    }

    public Set<kh.b> b() {
        return new HashSet(this.f13892k.a());
    }

    public void b(final ef.a aVar) {
        this.f13897p.a((j.a) new j.a() {
            /* access modifiers changed from: protected */
            public void a() {
                Location lastLocation;
                if ((androidx.core.app.a.b(a.this.getActivity().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.b(a.this.getActivity().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) && (lastLocation = h.f18097b.getLastLocation(b())) != null && aVar != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(aVar);
                    arrayList.add(new ef.a(lastLocation.getLatitude(), lastLocation.getLongitude()));
                    final ArrayList arrayList2 = new ArrayList(arrayList.size());
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(com.xeagle.android.utils.f.a((ef.a) it2.next()));
                    }
                    if (a.this.f13901t == null) {
                        final PolylineOptions polylineOptions = new PolylineOptions();
                        polylineOptions.a(-1).a((float) com.xeagle.android.utils.f.a(2.0d, a.this.getResources()));
                        a.this.a(new com.google.android.gms.maps.e() {
                            public void a(com.google.android.gms.maps.c cVar) {
                                com.google.android.gms.maps.model.f unused = a.this.f13901t = a.this.l().a(polylineOptions);
                                a.this.f13901t.a(arrayList2);
                            }
                        });
                        return;
                    }
                    a.this.f13901t.a(arrayList2);
                }
            }
        });
    }

    public void b(eo.b bVar) {
        e a2;
        List<ef.a> emptyList = bVar == null ? Collections.emptyList() : bVar.b();
        if (emptyList.isEmpty()) {
            e eVar = this.C;
            if (eVar != null) {
                eVar.a();
                a2 = null;
            } else {
                return;
            }
        } else if (this.C == null) {
            PolygonOptions b2 = new PolygonOptions().a(0).a(2.0f).b(f13861c);
            for (ef.a b3 : emptyList) {
                b2.a(com.xeagle.android.utils.f.b(b3));
            }
            a2 = l().a(b2);
        } else {
            ArrayList arrayList = new ArrayList();
            for (ef.a b4 : emptyList) {
                arrayList.add(com.xeagle.android.utils.f.b(b4));
            }
            this.C.a(arrayList);
            return;
        }
        this.C = a2;
    }

    public void b(List<List<ef.a>> list) {
        com.google.android.gms.maps.c l2 = l();
        if (l2 != null) {
            for (e a2 : this.B) {
                a2.a();
            }
            for (List<ef.a> next : list) {
                PolygonOptions polygonOptions = new PolygonOptions();
                polygonOptions.a(-65536).a(4.0f);
                ArrayList arrayList = new ArrayList(next.size());
                for (ef.a a3 : next) {
                    arrayList.add(com.xeagle.android.utils.f.a(a3));
                }
                polygonOptions.a((Iterable<LatLng>) arrayList);
                this.B.add(l2.a(polygonOptions));
            }
        }
    }

    public void b(a.e eVar) {
        List<ef.a> pathPoints = eVar.getPathPoints();
        final ArrayList arrayList = new ArrayList(pathPoints.size());
        for (ef.a a2 : pathPoints) {
            arrayList.add(com.xeagle.android.utils.f.a(a2));
        }
        com.google.android.gms.maps.model.f fVar = this.f13899r;
        if (fVar == null) {
            final PolylineOptions polylineOptions = new PolylineOptions();
            polylineOptions.a(-169665).a(6.0f);
            a(new com.google.android.gms.maps.e() {
                public void a(com.google.android.gms.maps.c cVar) {
                    a aVar = a.this;
                    com.google.android.gms.maps.model.f unused = aVar.f13899r = aVar.l().a(polylineOptions);
                    a.this.f13899r.a(arrayList);
                }
            });
            return;
        }
        fVar.a(arrayList);
    }

    public DPMapProvider c() {
        return this.f13894m != null ? DPMapProvider.GOOGLE_MAP.name().equalsIgnoreCase(this.f13894m.V()) ? DPMapProvider.GOOGLE_MAP : DPMapProvider.SYSTEM_LOC.name().equalsIgnoreCase(this.f13894m.V()) ? DPMapProvider.SYSTEM_LOC : DPMapProvider.GOOGLE_MAP : DPMapProvider.GOOGLE_MAP;
    }

    public void c(List<ef.a> list) {
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ef.a a2 : list) {
                arrayList.add(com.xeagle.android.utils.f.a(a2));
            }
            final LatLngBounds e2 = e((List<LatLng>) arrayList);
            a(new com.google.android.gms.maps.e() {
                public void a(com.google.android.gms.maps.c cVar) {
                    View childAt;
                    FragmentActivity activity = a.this.getActivity();
                    if (activity != null && (childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0)) != null) {
                        int height = childAt.getHeight();
                        int width = childAt.getWidth();
                        if (height > 0 && width > 0) {
                            cVar.b(com.google.android.gms.maps.b.a(e2, width, height, 100));
                        }
                    }
                }
            });
        }
    }

    public void d() {
        if (this.f13893l.b().a() && l() != null) {
            a(this.f13893l.b().b(), (float) ((int) l().a().f18189b));
        }
    }

    public void d(final List<ef.a> list) {
        this.f13897p.a((j.a) new j.a() {
            /* access modifiers changed from: protected */
            public void a() {
                List list;
                a aVar;
                if (androidx.core.app.a.b(a.this.getActivity().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.b(a.this.getActivity().getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    Location lastLocation = h.f18097b.getLastLocation(b());
                    if (lastLocation == null) {
                        aVar = a.this;
                        list = list;
                    } else {
                        list = new ArrayList(list);
                        list.add(com.xeagle.android.utils.f.a(lastLocation));
                        aVar = a.this;
                    }
                    aVar.c((List<ef.a>) list);
                }
            }
        });
    }

    public void e() {
        if (!this.f13897p.a(this.M)) {
            Log.e(f13890j, "Unable to add google api client task.");
        }
    }

    public void f() {
        a(this.Q);
    }

    public void g() {
        com.google.android.gms.maps.c l2 = l();
        if (l2 != null) {
            CameraPosition a2 = l2.a();
            this.f13894m.f12775b.edit().putFloat("pref_map_lat", (float) a2.f18188a.f18225a).putFloat("pref_map_lng", (float) a2.f18188a.f18226b).putFloat("pref_map_bea", a2.f18191d).putFloat("pref_map_tilt", a2.f18190c).putFloat("pref_map_zoom", a2.f18189b).apply();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void gpsEvent(p pVar) {
        if (pVar.a() == 23 && this.f13893l.b().a()) {
            ef.a b2 = this.f13893l.b().b();
            LatLng b3 = com.xeagle.android.utils.f.b(b2);
            if (l() != null) {
                com.google.android.gms.maps.model.c cVar = this.H;
                if (cVar == null) {
                    this.I = b2.d();
                    this.J = b2.c();
                    this.f13893l.L().b(this.J);
                    this.f13893l.L().a(this.I);
                    org.greenrobot.eventbus.c.a().d(new jo.j(this.I, this.J));
                    this.H = l().a(new CircleOptions().a(b3).a(100.0d).a(1.0f).a(-1426122940).b(AMapEngineUtils.MAX_P20_WIDTH).a(false));
                    return;
                }
                cVar.a(b3);
            }
        }
    }

    public ef.a h() {
        if (l() == null) {
            return null;
        }
        return com.xeagle.android.utils.f.a(l().a().f18188a);
    }

    public float i() {
        return l().a().f18189b;
    }

    public void j() {
    }

    public void k() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        Context applicationContext = activity.getApplicationContext();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        j jVar = new j(applicationContext, new Handler(), E);
        this.f13897p = jVar;
        jVar.a((j.b) this);
        this.f13893l = ((XEagleApp) activity.getApplication()).k();
        this.f13894m = new com.xeagle.android.utils.prefs.a(applicationContext);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13902u = arguments.getInt(f13860b);
        }
        a(new com.google.android.gms.maps.e() {
            public void a(com.google.android.gms.maps.c cVar) {
                com.google.android.gms.maps.c unused = a.this.G = cVar;
            }
        });
        return onCreateView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.A = false;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        if (AnonymousClass16.f30095b[droneEventsType.ordinal()] == 1 && aVar.b().a()) {
            ef.a b2 = aVar.b().b();
            LatLng b3 = com.xeagle.android.utils.f.b(b2);
            if (l() != null) {
                com.google.android.gms.maps.model.c cVar = this.H;
                if (cVar == null) {
                    this.I = b2.d();
                    this.J = b2.c();
                    aVar.L().b(this.J);
                    aVar.L().a(this.I);
                    org.greenrobot.eventbus.c.a().d(new jo.j(this.I, this.J));
                    this.H = l().a(new CircleOptions().a(b3).a(100.0d).a(1.0f).a(-1426122940).b(AMapEngineUtils.MAX_P20_WIDTH).a(false));
                    return;
                }
                cVar.a(b3);
            }
        }
    }

    public void onResume() {
        super.onResume();
        m();
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        this.f13893l.a((DroneInterfaces.c) this);
        this.f13897p.a();
        this.f13897p.a(this.O);
        m();
    }

    public void onStop() {
        super.onStop();
        org.greenrobot.eventbus.c.a().c(this);
        this.f13893l.b((DroneInterfaces.c) this);
        this.f13897p.a(this.N);
        this.f13897p.b();
    }

    @l(a = ThreadMode.BACKGROUND)
    public void onWaypointChange(jo.l lVar) {
        this.K = lVar.a().name();
    }

    @l(a = ThreadMode.MAIN)
    public void updateMapType(y yVar) {
        a(new com.google.android.gms.maps.e() {
            public void a(com.google.android.gms.maps.c cVar) {
                a.this.d(cVar);
            }
        });
    }
}
