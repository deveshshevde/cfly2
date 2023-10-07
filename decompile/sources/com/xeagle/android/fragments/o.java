package com.xeagle.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.s;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.b;
import en.a;

public class o extends b implements View.OnClickListener, DroneInterfaces.c {

    /* renamed from: e  reason: collision with root package name */
    int f23452e;

    /* renamed from: f  reason: collision with root package name */
    private ImageButton f23453f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f23454g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Button f23455h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f23456i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f23457j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23458k;

    /* renamed from: l  reason: collision with root package name */
    private a f23459l;

    /* renamed from: com.xeagle.android.fragments.o$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23461a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f23461a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.REMOTE_SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a(View view) {
        this.f23453f = (ImageButton) view.findViewById(R.id.start_calibrate_ib);
        this.f23454g = (TextView) view.findViewById(R.id.progress_four);
        this.f23455h = (Button) view.findViewById(R.id.remote_calibrate_complete);
        this.f23453f.setOnClickListener(this);
        this.f23455h.setOnClickListener(this);
    }

    private void a(a aVar) {
        Toast makeText;
        if (aVar != null) {
            int a2 = aVar.J().a();
            int b2 = aVar.J().b();
            if (a2 != 0 && b2 != 0) {
                if (!this.f23457j) {
                    if (this.f23458k) {
                        if (a2 == 4 && b2 == 2) {
                            makeText = Toast.makeText(getActivity(), "校准失败，请重试", 0);
                        } else if (a2 == 4 && b2 == 1) {
                            makeText = Toast.makeText(getActivity(), "校准成功！", 1);
                        } else {
                            this.f23456i = false;
                            int i2 = this.f23452e;
                            if (i2 < 3) {
                                this.f23452e = i2 + 1;
                                s.a(aVar, 4, 2);
                            }
                            Toast.makeText(getActivity(), "请确认是否连接无人机", 1).show();
                        }
                        makeText.show();
                        this.f23456i = false;
                    }
                    b();
                } else if (a2 == 4 && b2 == 1) {
                    this.f23452e = 0;
                    this.f23456i = true;
                    b();
                } else {
                    this.f23456i = false;
                    int i3 = this.f23452e;
                    if (i3 < 3) {
                        this.f23452e = i3 + 1;
                        s.a(aVar, 4, 1);
                    }
                    Toast.makeText(getActivity(), "请确认是否连接无人机", 1).show();
                    b();
                }
                a(aVar);
                b();
            }
        }
    }

    private void b() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    int i2;
                    TextView textView;
                    if (!o.this.f23456i) {
                        textView = o.this.f23454g;
                        i2 = 0;
                    } else {
                        textView = o.this.f23454g;
                        i2 = 8;
                    }
                    textView.setVisibility(i2);
                    o.this.f23455h.setVisibility(i2);
                }
            });
        }
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.remote_calibrate_complete) {
            this.f23458k = true;
            this.f23457j = false;
            s.a(this.f23459l, 4, 2);
        } else if (id2 == R.id.start_calibrate_ib) {
            this.f23457j = true;
            this.f23458k = false;
            s.a(this.f23459l, 4, 1);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.remote_calibrate_fragment, viewGroup, false);
        this.f23459l = ((XEagleApp) getActivity().getApplication()).k();
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        super.onDroneEvent(droneEventsType, aVar);
        if (AnonymousClass2.f23461a[droneEventsType.ordinal()] == 1) {
            a(aVar);
        }
    }

    public void onResume() {
        super.onResume();
        a(this.f23459l);
    }

    public void onStart() {
        super.onStart();
        this.f23459l.a((DroneInterfaces.c) this);
        a(this.f23459l);
    }

    public void onStop() {
        super.onStop();
        this.f23459l.b((DroneInterfaces.c) this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
