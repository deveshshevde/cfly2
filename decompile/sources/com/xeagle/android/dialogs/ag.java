package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.AttitudeIndicator;
import en.a;

public class ag extends c implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    private AttitudeIndicator f22519a;

    /* renamed from: b  reason: collision with root package name */
    private a f22520b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22521c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22522d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22523e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22524f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22525g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22526h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f22527i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f22528j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22529k;

    /* renamed from: l  reason: collision with root package name */
    private int f22530l;

    /* renamed from: m  reason: collision with root package name */
    private int f22531m;

    /* renamed from: com.xeagle.android.dialogs.ag$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22533a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22533a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.NAVIGATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22533a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.ATTITUDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22533a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.SPEED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.dialogs.ag.AnonymousClass2.<clinit>():void");
        }
    }

    public void a(a aVar) {
        float a2 = (float) aVar.u().a();
        float b2 = (float) aVar.u().b();
        float c2 = (float) aVar.u().c();
        if ((!this.f22529k) && (c2 < 0.0f)) {
            c2 += 360.0f;
        }
        this.f22519a.a(a2, b2, c2);
        this.f22521c.setText(String.format("%3.0f°", new Object[]{Float.valueOf(a2)}));
        this.f22523e.setText(String.format("%3.0f°", new Object[]{Float.valueOf(b2)}));
        this.f22522d.setText(String.format("%3.0f°", new Object[]{Float.valueOf(c2)}));
    }

    public void b(a aVar) {
        this.f22525g.setText(String.format("%3.1f", new Object[]{Double.valueOf(aVar.n().c().a())}));
        this.f22524f.setText(String.format("%3.1f", new Object[]{Double.valueOf(aVar.n().b().a())}));
        this.f22526h.setText(String.format("%3.1f", new Object[]{Double.valueOf(aVar.n().a().a())}));
        double a2 = aVar.t().a();
        double c2 = aVar.t().c();
        this.f22527i.setText(String.format("%3.1f", new Object[]{Double.valueOf(a2)}));
        this.f22528j.setText(String.format("%3.1f", new Object[]{Double.valueOf(c2)}));
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int height;
        FragmentActivity activity = getActivity();
        getActivity();
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.telemetry_dialog, (ViewGroup) null, false);
        this.f22519a = (AttitudeIndicator) inflate.findViewById(R.id.aiView);
        this.f22521c = (TextView) inflate.findViewById(R.id.rollValueText);
        this.f22522d = (TextView) inflate.findViewById(R.id.yawValueText);
        this.f22523e = (TextView) inflate.findViewById(R.id.pitchValueText);
        this.f22524f = (TextView) inflate.findViewById(R.id.groundSpeedValue);
        this.f22525g = (TextView) inflate.findViewById(R.id.airSpeedValue);
        this.f22526h = (TextView) inflate.findViewById(R.id.climbRateValue);
        this.f22527i = (TextView) inflate.findViewById(R.id.altitudeValue);
        this.f22528j = (TextView) inflate.findViewById(R.id.targetAltitudeValue);
        this.f22520b = ((XEagleApp) getActivity().getApplication()).k();
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.AnimationStyle).setView(inflate).setNegativeButton(R.string.telemetry_dialog_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).create();
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        window.setGravity(80);
        create.requestWindowFeature(1);
        create.show();
        if (getActivity().getResources().getConfiguration().orientation == 1) {
            this.f22530l = getActivity().getWindowManager().getDefaultDisplay().getWidth();
            height = (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 4) / 9;
        } else {
            if (getActivity().getResources().getConfiguration().orientation == 2) {
                this.f22530l = (getActivity().getWindowManager().getDefaultDisplay().getWidth() * 3) / 5;
                height = (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 4) / 5;
            }
            window.setLayout(this.f22530l, this.f22531m);
            return create;
        }
        this.f22531m = height;
        window.setLayout(this.f22530l, this.f22531m);
        return create;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        int i2 = AnonymousClass2.f22533a[droneEventsType.ordinal()];
        if (i2 == 2) {
            a(aVar);
        } else if (i2 == 3) {
            b(aVar);
        }
    }

    public void onStart() {
        super.onStart();
        this.f22520b.a((DroneInterfaces.c) this);
        this.f22529k = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext()).getBoolean("pref_heading_mode", false);
    }

    public void onStop() {
        super.onStop();
        this.f22520b.b((DroneInterfaces.c) this);
    }
}
