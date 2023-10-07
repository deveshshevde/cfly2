package com.xeagle.android.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.widgets.button.NumberSeek;
import en.a;

public class k extends b implements SeekBar.OnSeekBarChangeListener, DroneInterfaces.c {

    /* renamed from: e  reason: collision with root package name */
    protected final Handler f23424e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    protected Runnable f23425f = new Runnable() {
        public void run() {
            k.this.f23424e.removeCallbacks(this);
            if (k.this.f23432m != null) {
                long n2 = k.this.f23432m.d().n();
                k.this.f23431l.setText(String.format("FlightTime:%02d:%02d", new Object[]{Long.valueOf(n2 / 60), Long.valueOf(n2 % 60)}));
                k.this.f23424e.postDelayed(this, 5001);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f23426g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f23427h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f23428i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f23429j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f23430k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public NumberSeek f23431l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public a f23432m;

    /* renamed from: com.xeagle.android.fragments.k$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23446a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23446a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23446a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23446a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.BATTERY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23446a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.NAVIGATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23446a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.SPEED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23446a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.GPS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f23446a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.HOME     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f23446a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.STATE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.k.AnonymousClass8.<clinit>():void");
        }
    }

    private void a(View view) {
        this.f23427h = (TextView) view.findViewById(R.id.distanceToHome);
        this.f23428i = (TextView) view.findViewById(R.id.tv_altitude);
        this.f23429j = (TextView) view.findViewById(R.id.tv_airSpeed);
        this.f23430k = (TextView) view.findViewById(R.id.tv_climbSpeed);
        this.f23431l = (NumberSeek) view.findViewById(R.id.info_time);
        this.f23432m = ((XEagleApp) getActivity().getApplication()).k();
        this.f23431l.setOnSeekBarChangeListener(this);
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        this.f23424e.removeCallbacks(this.f23425f);
        if (aVar != null) {
            this.f23425f.run();
        } else {
            this.f23431l.setText("00:00");
        }
    }

    /* access modifiers changed from: private */
    public void b(a aVar) {
        String str;
        if (this.f23427h != null) {
            if (aVar == null) {
                str = "--";
            } else {
                str = String.format("D:%s", new Object[]{aVar.q().b().toString()});
            }
            this.f23427h.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public void c(a aVar) {
        this.f23429j.setText(String.format("S:%3.1f", new Object[]{Double.valueOf(aVar.n().c().a())}));
        this.f23428i.setText(String.format("H:%3.1f", new Object[]{Double.valueOf(aVar.t().a())}));
        this.f23430k.setText(String.format("V:%3.1f", new Object[]{Double.valueOf(aVar.n().a().a())}));
    }

    /* access modifiers changed from: private */
    public double d(a aVar) {
        return aVar.o().b();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.xeagle_flight_time, viewGroup, false);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, final a aVar) {
        FragmentActivity fragmentActivity;
        Runnable runnable;
        if (getActivity() != null) {
            switch (AnonymousClass8.f23446a[droneEventsType.ordinal()]) {
                case 1:
                    fragmentActivity = getActivity();
                    runnable = new Runnable() {
                        public void run() {
                            k.this.c(aVar);
                            k.this.a(aVar);
                            k.this.b(aVar);
                            double unused = k.this.d(aVar);
                        }
                    };
                    break;
                case 2:
                    fragmentActivity = getActivity();
                    runnable = new Runnable() {
                        public void run() {
                            k.this.c(aVar);
                            k.this.a(aVar);
                            k.this.b(aVar);
                            double unused = k.this.d(aVar);
                        }
                    };
                    break;
                case 3:
                    fragmentActivity = getActivity();
                    runnable = new Runnable() {
                        public void run() {
                            double unused = k.this.d(aVar);
                        }
                    };
                    break;
                case 5:
                    fragmentActivity = getActivity();
                    runnable = new Runnable() {
                        public void run() {
                            k.this.c(aVar);
                        }
                    };
                    break;
                case 6:
                case 7:
                    fragmentActivity = getActivity();
                    runnable = new Runnable() {
                        public void run() {
                            if (k.this.f23427h != null) {
                                k.this.b(aVar);
                            }
                        }
                    };
                    break;
                case 8:
                    fragmentActivity = getActivity();
                    runnable = new Runnable() {
                        public void run() {
                            if (k.this.f23426g != null) {
                                k.this.a(aVar);
                            }
                        }
                    };
                    break;
                default:
                    return;
            }
            fragmentActivity.runOnUiThread(runnable);
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        seekBar.setProgress((int) d(this.f23432m));
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        this.f23432m.a((DroneInterfaces.c) this);
        if (getActivity() != null) {
            d(this.f23432m);
            c(this.f23432m);
            a(this.f23432m);
            b(this.f23432m);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStop() {
        super.onStop();
        this.f23432m.b((DroneInterfaces.c) this);
        if (getActivity() != null) {
            d(this.f23432m);
            c(this.f23432m);
            a(this.f23432m);
            b(this.f23432m);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
