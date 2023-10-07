package com.xeagle.android.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.s;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.enums.StickModes;
import com.xeagle.android.widgets.spinners.SpinnerSelfSelect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p extends b implements DroneInterfaces.c {

    /* renamed from: e  reason: collision with root package name */
    private SpinnerSelfSelect f23462e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f23463f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f23464g;

    /* renamed from: h  reason: collision with root package name */
    private en.a f23465h;

    /* renamed from: i  reason: collision with root package name */
    private a f23466i;

    /* renamed from: j  reason: collision with root package name */
    private int f23467j = -1;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<Integer> f23468k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<Integer> f23469l;

    /* renamed from: com.xeagle.android.fragments.p$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23472a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23472a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23472a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23472a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.REMOTE_SET     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23472a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.p.AnonymousClass2.<clinit>():void");
        }
    }

    public class a extends ArrayAdapter<StickModes> {
        public a(Context context, int i2) {
            super(context, i2);
        }

        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            return getView(i2, view, viewGroup);
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) super.getView(i2, view, viewGroup);
            textView.setText(((StickModes) getItem(i2)).b());
            return textView;
        }
    }

    private void a(Context context, final en.a aVar) {
        this.f23465h = aVar;
        a aVar2 = new a(context, R.layout.remote_spinner_text);
        this.f23466i = aVar2;
        this.f23462e.setAdapter(aVar2);
        this.f23462e.setOnSpinnerItemSelectedListener(new SpinnerSelfSelect.a() {
            public void a(Spinner spinner, int i2) {
                if (aVar != null) {
                    s.a(aVar, 3, ((StickModes) spinner.getItemAtPosition(i2)).a());
                    s.a(aVar, 2, 0);
                    p.this.f23463f.setImageResource(((Integer) p.this.f23468k.get(i2)).intValue());
                    p.this.f23464g.setImageResource(((Integer) p.this.f23469l.get(i2)).intValue());
                }
            }
        });
        a(aVar);
    }

    private void a(View view) {
        this.f23462e = (SpinnerSelfSelect) view.findViewById(R.id.remote_spinner);
        this.f23463f = (ImageView) view.findViewById(R.id.remote_left);
        this.f23464g = (ImageView) view.findViewById(R.id.remote_right);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f23468k = arrayList;
        arrayList.add(Integer.valueOf(R.drawable.remote_japan_left));
        this.f23468k.add(Integer.valueOf(R.drawable.remote_usa_left));
        this.f23468k.add(Integer.valueOf(R.drawable.remote_china_left));
        this.f23468k.add(Integer.valueOf(R.drawable.remote_europe_left));
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        this.f23469l = arrayList2;
        arrayList2.add(Integer.valueOf(R.drawable.remote_japan_right));
        this.f23469l.add(Integer.valueOf(R.drawable.remote_usa_right));
        this.f23469l.add(Integer.valueOf(R.drawable.remote_china_right));
        this.f23469l.add(Integer.valueOf(R.drawable.remote_europe_right));
        a(getActivity(), this.f23465h);
    }

    private void a(en.a aVar) {
        this.f23465h = aVar;
        int f2 = aVar == null ? -1 : aVar.f();
        if (f2 != this.f23467j) {
            List<StickModes> emptyList = f2 == -1 ? Collections.emptyList() : StickModes.b(f2);
            this.f23466i.clear();
            this.f23466i.addAll(emptyList);
            this.f23466i.notifyDataSetChanged();
            this.f23467j = f2;
        }
        if (aVar != null) {
            int a2 = aVar.J().a();
            int b2 = aVar.J().b();
            if (a2 != 2 || b2 == 0) {
                this.f23462e.a(this.f23466i.getPosition(StickModes.UNKNOWN));
                this.f23463f.setImageResource(this.f23468k.get(0).intValue());
                this.f23464g.setImageResource(this.f23469l.get(0).intValue());
                return;
            }
            StickModes a3 = StickModes.a(b2);
            int i2 = b2 - 1;
            this.f23463f.setImageResource(this.f23468k.get(i2).intValue());
            this.f23464g.setImageResource(this.f23469l.get(i2).intValue());
            this.f23462e.a(this.f23466i.getPosition(a3));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.remote_switch_handle, viewGroup, false);
        this.f23465h = ((XEagleApp) getActivity().getApplication()).k();
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        this.f23465h = aVar;
        int i2 = AnonymousClass2.f23472a[droneEventsType.ordinal()];
        if (i2 == 1) {
            s.a(aVar, 2, 0);
        } else if (i2 == 2) {
            this.f23465h = null;
        } else if (!(i2 == 3 || i2 == 4) || aVar == null) {
            return;
        }
        a(aVar);
    }

    public void onStart() {
        super.onStart();
        this.f23465h.a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onStop();
        this.f23465h.b((DroneInterfaces.c) this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
    }
}
