package ko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.flypro.core.mission.b;
import ek.h;
import em.d;
import em.e;
import fg.i;
import java.util.ArrayList;
import java.util.List;
import kr.c;

public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    private final b f30161a;

    /* renamed from: b  reason: collision with root package name */
    private final kn.a f30162b;

    /* renamed from: c  reason: collision with root package name */
    private final List<kh.b> f30163c = c.a(this);

    /* renamed from: ko.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30164a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flypro.core.mission.MissionItemType[] r0 = com.flypro.core.mission.MissionItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30164a = r0
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30164a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30164a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.SPLINE_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f30164a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f30164a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ko.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(kn.a aVar, b bVar) {
        this.f30162b = aVar;
        this.f30161a = bVar;
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        return this.f30161a.compareTo(aVar.f30161a);
    }

    public View a(Context context, ViewGroup viewGroup) {
        String str;
        ej.a c2;
        int i2;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.fragment_editor_list_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.rowAltitudeView);
        ((TextView) inflate.findViewById(R.id.rowNameView)).setText(String.format("%3d", new Object[]{Integer.valueOf(this.f30161a.b().c(this.f30161a))}));
        textView.setCompoundDrawablesWithIntrinsicBounds(this.f30161a instanceof e ? R.drawable.ic_mission_spline_wp : R.drawable.ic_mission_wp, 0, 0, 0);
        b bVar = this.f30161a;
        if (bVar instanceof d) {
            d dVar = (d) bVar;
            textView.setText(String.format("%3.0fm", new Object[]{Double.valueOf(dVar.e().g().a())}));
            try {
                ej.c a2 = dVar.b().a(dVar);
                if (a2.a() > i.f27244a) {
                    i2 = -65536;
                } else if (a2.a() < i.f27244a) {
                    i2 = -16776961;
                }
                textView.setTextColor(i2);
            } catch (Exception unused) {
            }
        } else {
            if (bVar instanceof el.a) {
                c2 = ((el.a) bVar).f26910c.f();
            } else if (bVar instanceof h) {
                c2 = ((h) bVar).c();
            } else {
                str = "";
                textView.setText(str);
            }
            str = c2.toString();
            textView.setText(str);
        }
        return inflate;
    }

    public List<ef.a> a(ef.a aVar) {
        ArrayList arrayList = new ArrayList();
        int i2 = AnonymousClass1.f30164a[this.f30161a.a().ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            arrayList.add(((d) this.f30161a).e());
        } else if (i2 == 4) {
            for (int i3 = 0; i3 <= 360; i3 += 10) {
                em.a aVar2 = (em.a) this.f30161a;
                double d2 = i.f27244a;
                if (aVar != null) {
                    d2 = eg.a.d(aVar2.e(), aVar);
                }
                ef.b e2 = aVar2.e();
                double d3 = (double) i3;
                Double.isNaN(d3);
                arrayList.add(eg.a.a((ef.a) e2, d2 + d3, aVar2.d()));
            }
        }
        return arrayList;
    }

    public kn.a a() {
        return this.f30162b;
    }

    public b b() {
        return this.f30161a;
    }

    public List<kh.b> c() {
        return this.f30163c;
    }
}
