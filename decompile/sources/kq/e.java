package kq;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.MissionItemType;
import com.flypro.core.mission.b;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.spinners.SpinnerSelfSelect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import jo.bf;
import jo.f;
import kp.a;

public class e extends c implements SpinnerSelfSelect.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f30523c = "e";

    /* renamed from: a  reason: collision with root package name */
    protected SpinnerSelfSelect f30524a;

    /* renamed from: b  reason: collision with root package name */
    protected a f30525b;

    /* renamed from: d  reason: collision with root package name */
    private kn.a f30526d;

    /* renamed from: e  reason: collision with root package name */
    private List<b> f30527e;

    /* renamed from: f  reason: collision with root package name */
    private List<ko.a> f30528f;

    /* renamed from: kq.e$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30529a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flypro.core.mission.MissionItemType[] r0 = com.flypro.core.mission.MissionItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30529a = r0
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30529a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.CIRCLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30529a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.CHANGE_SPEED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f30529a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.RTL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f30529a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f30529a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f30529a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.SPLINE_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kq.e.AnonymousClass1.<clinit>():void");
        }
    }

    public static e a(MissionItemType missionItemType) {
        switch (AnonymousClass1.f30529a[missionItemType.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return new c();
            case 3:
                return new b();
            case 4:
                return new h();
            case 5:
                return new m();
            case 6:
                return new n();
            case 7:
                return new j();
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.fragment_editor_detail_generic;
    }

    public void a(Spinner spinner, int i2) {
        MissionItemType missionItemType = (MissionItemType) this.f30525b.getItem(i2);
        try {
            List<ko.a> list = this.f30528f;
            if (list == null) {
                return;
            }
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f30528f.size());
                for (ko.a next : this.f30528f) {
                    b b2 = next.b();
                    if (b2.a() != missionItemType) {
                        arrayList.add(com.flypro.core.util.b.a(next, new ko.a(this.f30526d, missionItemType.a(b2))));
                    }
                }
                if (!arrayList.isEmpty()) {
                    org.greenrobot.eventbus.c.a().d(new bf(arrayList));
                    dismiss();
                }
            }
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public kn.a b() {
        return this.f30526d;
    }

    /* access modifiers changed from: protected */
    public List<? extends b> c() {
        return this.f30527e;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f30526d = ((XEagleApp) getActivity().getApplication()).o();
        ArrayList arrayList = new ArrayList(this.f30526d.f13910a.a());
        this.f30528f = arrayList;
        if (arrayList.isEmpty()) {
            return null;
        }
        this.f30527e = new ArrayList(this.f30528f.size());
        for (ko.a b2 : this.f30528f) {
            this.f30527e.add(b2.b());
        }
        return layoutInflater.inflate(a(), viewGroup, false);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        org.greenrobot.eventbus.c.a().d(new f(this.f30528f));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LinkedList linkedList = new LinkedList(Arrays.asList(MissionItemType.values()));
        if (this.f30528f.size() == 1) {
            ko.a aVar = this.f30528f.get(0);
            b b2 = aVar.b();
            if (this.f30526d.b().indexOf(aVar) != 0) {
                linkedList.remove(MissionItemType.TAKEOFF);
            }
            if (this.f30526d.b().indexOf(aVar) != this.f30526d.b().size() - 1) {
                linkedList.remove(MissionItemType.LAND);
                linkedList.remove(MissionItemType.RTL);
            }
            if (b2 instanceof ek.e) {
                linkedList.remove(MissionItemType.LAND);
                linkedList.remove(MissionItemType.SPLINE_WAYPOINT);
                linkedList.remove(MissionItemType.CIRCLE);
                linkedList.remove(MissionItemType.WAYPOINT);
            }
            TextView textView = (TextView) view.findViewById(R.id.WaypointIndex);
            if (textView != null) {
                textView.setText(String.valueOf(this.f30526d.b(aVar)));
            }
            TextView textView2 = (TextView) view.findViewById(R.id.DistanceValue);
            if (textView2 != null) {
                try {
                    textView2.setText(this.f30526d.d(aVar).toString());
                } catch (IllegalArgumentException e2) {
                    Log.w(f30523c, e2.getMessage(), e2);
                }
            }
            TextView textView3 = (TextView) view.findViewById(R.id.DistanceLabel);
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else if (this.f30528f.size() > 1) {
            linkedList.remove(MissionItemType.TAKEOFF);
            linkedList.remove(MissionItemType.LAND);
            linkedList.remove(MissionItemType.RTL);
        } else {
            throw new IllegalStateException("Mission Detail Fragment cannot be shown when no mission items is selected.");
        }
        this.f30525b = new a(getActivity(), 17367043, (MissionItemType[]) linkedList.toArray(new MissionItemType[linkedList.size()]));
        SpinnerSelfSelect spinnerSelfSelect = (SpinnerSelfSelect) view.findViewById(R.id.spinnerWaypointType);
        this.f30524a = spinnerSelfSelect;
        spinnerSelfSelect.setAdapter(this.f30525b);
        this.f30524a.setOnSpinnerItemSelectedListener(this);
    }
}
