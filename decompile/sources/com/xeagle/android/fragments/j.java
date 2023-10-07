package com.xeagle.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.FragmentActivity;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.c;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.dialogs.al;
import en.a;

public class j extends b implements View.OnClickListener, DroneInterfaces.c {

    /* renamed from: e  reason: collision with root package name */
    private ImageButton f23403e;

    /* renamed from: f  reason: collision with root package name */
    private ImageButton f23404f;

    /* renamed from: g  reason: collision with root package name */
    private ImageButton f23405g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ImageButton f23406h;

    /* renamed from: i  reason: collision with root package name */
    private ImageButton f23407i;

    /* renamed from: j  reason: collision with root package name */
    private ImageButton f23408j;

    /* renamed from: k  reason: collision with root package name */
    private ImageButton f23409k;

    /* renamed from: l  reason: collision with root package name */
    private ImageButton f23410l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public a f23411m;

    /* renamed from: n  reason: collision with root package name */
    private XEagleApp f23412n;

    /* renamed from: com.xeagle.android.fragments.j$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23415a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23416b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23416b = r0
                r1 = 1
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r2 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.ARMING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f23416b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f23416b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = f23416b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.STATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r2 = f23416b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.MAVLink.Messages.ApmModes[] r2 = com.MAVLink.Messages.ApmModes.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f23415a = r2
                com.MAVLink.Messages.ApmModes r3 = com.MAVLink.Messages.ApmModes.ROTOR_RTL     // Catch:{ NoSuchFieldError -> 0x004f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f23415a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.MAVLink.Messages.ApmModes r2 = com.MAVLink.Messages.ApmModes.ROTOR_LAND     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.j.AnonymousClass2.<clinit>():void");
        }
    }

    private void a(View view) {
        this.f23403e = (ImageButton) view.findViewById(R.id.editor_disArm);
        this.f23404f = (ImageButton) view.findViewById(R.id.editor_arm);
        this.f23405g = (ImageButton) view.findViewById(R.id.editor_takeOff);
        this.f23406h = (ImageButton) view.findViewById(R.id.editor_land);
        this.f23407i = (ImageButton) view.findViewById(R.id.editor_rtl);
        this.f23408j = (ImageButton) view.findViewById(R.id.editor_auto);
        this.f23409k = (ImageButton) view.findViewById(R.id.editor_auto_flying);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.editor_disConnect);
        this.f23410l = imageButton;
        imageButton.setOnClickListener(this);
        this.f23403e.setOnClickListener(this);
        this.f23404f.setOnClickListener(this);
        this.f23405g.setOnClickListener(this);
        this.f23406h.setOnClickListener(this);
        this.f23407i.setOnClickListener(this);
        this.f23408j.setOnClickListener(this);
        this.f23409k.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void b() {
        al a2 = al.a(getActivity().getApplicationContext(), getString(R.string.dialog_confirm_arming_title), getString(R.string.dialog_confirm_arming_msg), new al.a() {
            public void a() {
                c.a(j.this.f23411m, true);
            }

            public void b() {
            }
        });
        if (a2 != null) {
            a2.show(getChildFragmentManager(), "Confirm arming");
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        ImageButton imageButton;
        d();
        int i2 = AnonymousClass2.f23415a[this.f23411m.d().e().ordinal()];
        if (i2 == 1) {
            imageButton = this.f23407i;
        } else if (i2 == 2) {
            imageButton = this.f23406h;
        } else {
            return;
        }
        imageButton.setActivated(true);
    }

    private void d() {
        this.f23406h.setActivated(false);
        this.f23407i.setActivated(false);
        this.f23409k.setActivated(false);
    }

    /* access modifiers changed from: private */
    public void e() {
        if (!this.f23411m.j().a()) {
            i();
        } else if (!this.f23411m.d().c()) {
            h();
        } else if (this.f23411m.d().d()) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        j();
        this.f23406h.setVisibility(0);
        this.f23407i.setVisibility(0);
        this.f23409k.setVisibility(0);
    }

    private void g() {
        j();
        this.f23403e.setVisibility(0);
        this.f23405g.setVisibility(0);
        this.f23408j.setVisibility(0);
    }

    private void h() {
        j();
        this.f23404f.setVisibility(0);
        this.f23410l.setVisibility(8);
    }

    private void i() {
        j();
        this.f23410l.setVisibility(0);
    }

    private void j() {
        this.f23403e.setVisibility(8);
        this.f23404f.setVisibility(8);
        this.f23405g.setVisibility(8);
        this.f23408j.setVisibility(8);
        this.f23409k.setVisibility(8);
        this.f23407i.setVisibility(8);
        this.f23406h.setVisibility(8);
        this.f23406h.setBackgroundResource(R.drawable.land_nor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005d, code lost:
        r1 = r1.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0094, code lost:
        r4.setLabel(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0097, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0099, code lost:
        kt.a.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r4) {
        /*
            r3 = this;
            com.google.android.gms.analytics.HitBuilders$EventBuilder r0 = new com.google.android.gms.analytics.HitBuilders$EventBuilder
            r0.<init>()
            java.lang.String r1 = "Flight"
            com.google.android.gms.analytics.HitBuilders$EventBuilder r0 = r0.setCategory(r1)
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            if (r1 != 0) goto L_0x0012
            return
        L_0x0012:
            int r4 = r4.getId()
            java.lang.String r1 = "Copter flight action button"
            switch(r4) {
                case 2131297062: goto L_0x0082;
                case 2131297065: goto L_0x006f;
                case 2131297066: goto L_0x0062;
                case 2131297068: goto L_0x004b;
                case 2131297070: goto L_0x0038;
                case 2131297072: goto L_0x0025;
                case 2131298056: goto L_0x001e;
                default: goto L_0x001b;
            }
        L_0x001b:
            r0 = 0
            goto L_0x0097
        L_0x001e:
            com.google.android.gms.analytics.HitBuilders$EventBuilder r4 = r0.setAction(r1)
            java.lang.String r1 = "Selfie uploaded"
            goto L_0x0094
        L_0x0025:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            com.xeagle.android.fragments.j$5 r2 = new com.xeagle.android.fragments.j$5
            r2.<init>()
            r4.runOnUiThread(r2)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r4 = r0.setAction(r1)
            java.lang.String r1 = "TakeOff"
            goto L_0x0094
        L_0x0038:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            com.xeagle.android.fragments.j$7 r2 = new com.xeagle.android.fragments.j$7
            r2.<init>()
            r4.runOnUiThread(r2)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r4 = r0.setAction(r1)
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.ROTOR_RTL
            goto L_0x005d
        L_0x004b:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            com.xeagle.android.fragments.j$6 r2 = new com.xeagle.android.fragments.j$6
            r2.<init>()
            r4.runOnUiThread(r2)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r4 = r0.setAction(r1)
            com.MAVLink.Messages.ApmModes r1 = com.MAVLink.Messages.ApmModes.ROTOR_LAND
        L_0x005d:
            java.lang.String r1 = r1.b()
            goto L_0x0094
        L_0x0062:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            com.xeagle.android.fragments.j$1 r1 = new com.xeagle.android.fragments.j$1
            r1.<init>()
            r4.runOnUiThread(r1)
            goto L_0x0097
        L_0x006f:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            com.xeagle.android.fragments.j$3 r2 = new com.xeagle.android.fragments.j$3
            r2.<init>()
            r4.runOnUiThread(r2)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r4 = r0.setAction(r1)
            java.lang.String r1 = "DisArm"
            goto L_0x0094
        L_0x0082:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            com.xeagle.android.fragments.j$4 r2 = new com.xeagle.android.fragments.j$4
            r2.<init>()
            r4.runOnUiThread(r2)
            com.google.android.gms.analytics.HitBuilders$EventBuilder r4 = r0.setAction(r1)
            java.lang.String r1 = "Arm"
        L_0x0094:
            r4.setLabel(r1)
        L_0x0097:
            if (r0 == 0) goto L_0x009c
            kt.a.a((com.google.android.gms.analytics.HitBuilders.EventBuilder) r0)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.j.onClick(android.view.View):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.editor_operate_fragment, viewGroup, false);
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f23412n = xEagleApp;
        this.f23411m = xEagleApp.k();
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        Runnable runnable;
        FragmentActivity fragmentActivity;
        if (getActivity() != null) {
            int i2 = AnonymousClass2.f23416b[droneEventsType.ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                fragmentActivity = getActivity();
                runnable = new Runnable() {
                    public void run() {
                        j.this.e();
                    }
                };
            } else if (i2 == 5) {
                fragmentActivity = getActivity();
                runnable = new Runnable() {
                    public void run() {
                        j.this.c();
                    }
                };
            } else {
                return;
            }
            fragmentActivity.runOnUiThread(runnable);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        e();
        c();
        this.f23411m.a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onStop();
        this.f23411m.b((DroneInterfaces.c) this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
