package kc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.wheelVerticalView.CardWheelVerticalView;
import com.xeagle.android.widgets.wheelView.widget.WheelView;
import en.a;
import java.util.ArrayList;

public class i extends Fragment implements CardWheelVerticalView.a {

    /* renamed from: a  reason: collision with root package name */
    public a f13828a;

    /* renamed from: b  reason: collision with root package name */
    private WheelView f13829b;

    /* renamed from: c  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f13830c;

    /* access modifiers changed from: private */
    public ArrayList<Integer> a() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i2 = 2; i2 < 51; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    public void a(CardWheelVerticalView cardWheelVerticalView, int i2, int i3) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13828a = ((XEagleApp) getActivity().getApplication()).k();
        return layoutInflater.inflate(R.layout.fragment_mode_guided, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x009f, code lost:
        if ((r1.f13828a.t().a() / 100.0d) < -100.0d) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d7, code lost:
        if ((r1.f13828a.t().a() / 10.0d) < -100.0d) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0144, code lost:
        if ((r1.f13828a.t().a() / 100.0d) < -100.0d) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0166, code lost:
        if ((r1.f13828a.t().a() / 10.0d) < -100.0d) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0185, code lost:
        if ((r1.f13828a.t().a() / 10.0d) < -100.0d) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0187, code lost:
        r5 = r1.f13828a.t().a() / r11;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r18, android.os.Bundle r19) {
        /*
            r17 = this;
            r1 = r17
            super.onViewCreated(r18, r19)
            androidx.fragment.app.FragmentActivity r0 = r17.getActivity()
            android.app.Application r0 = r0.getApplication()
            com.xeagle.android.XEagleApp r0 = (com.xeagle.android.XEagleApp) r0
            com.xeagle.android.utils.prefs.a r0 = r0.j()
            r1.f13830c = r0
            r0 = 2131299855(0x7f090e0f, float:1.8217723E38)
            r2 = r18
            android.view.View r0 = r2.findViewById(r0)
            com.xeagle.android.widgets.wheelView.widget.WheelView r0 = (com.xeagle.android.widgets.wheelView.widget.WheelView) r0
            r1.f13829b = r0
            com.xeagle.android.utils.prefs.a r0 = r1.f13830c
            java.lang.String r0 = r0.j()
            java.lang.String r2 = "350"
            boolean r0 = r0.equalsIgnoreCase(r2)
            java.lang.String r2 = "version"
            r3 = 4648975823342015611(0x40847ae147ae147b, double:655.36)
            r5 = -4586634745500139520(0xc059000000000000, double:-100.0)
            r7 = 0
            r9 = 4636737291354636288(0x4059000000000000, double:100.0)
            r11 = 4621819117588971520(0x4024000000000000, double:10.0)
            if (r0 == 0) goto L_0x00db
            en.a r0 = r1.f13828a
            java.lang.String r0 = r0.y()
            if (r0 != 0) goto L_0x004d
            r13 = 4615964438073389875(0x400f333333333333, double:3.9)
            goto L_0x007a
        L_0x004d:
            en.a r0 = r1.f13828a     // Catch:{ NumberFormatException -> 0x0060 }
            java.lang.String r0 = r0.y()     // Catch:{ NumberFormatException -> 0x0060 }
            r13 = 8
            r14 = 11
            java.lang.String r0 = r0.substring(r13, r14)     // Catch:{ NumberFormatException -> 0x0060 }
            double r13 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x0060 }
            goto L_0x007a
        L_0x0060:
            r0 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "run: ---->>>>error:::"
            r13.append(r14)
            java.lang.String r0 = r0.getMessage()
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            android.util.Log.i(r2, r0)
            r13 = r7
        L_0x007a:
            r15 = 4616302208045442662(0x4010666666666666, double:4.1)
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x00bb
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r11 = r0.a()
            double r11 = r11 / r9
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ae
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r7 = r0.a()
            double r7 = r7 / r9
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ae
        L_0x00a1:
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r5 = r0.a()
            double r5 = r5 / r9
            goto L_0x0192
        L_0x00ae:
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r3 = r0.a()
            double r3 = r3 / r9
            goto L_0x01a3
        L_0x00bb:
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r9 = r0.a()
            double r9 = r9 / r11
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0198
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r7 = r0.a()
            double r7 = r7 / r11
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0198
            goto L_0x0187
        L_0x00db:
            com.xeagle.android.utils.prefs.a r0 = r1.f13830c
            java.lang.String r0 = r0.j()
            java.lang.String r13 = "U21"
            boolean r0 = r0.equalsIgnoreCase(r13)
            if (r0 == 0) goto L_0x0169
            en.a r0 = r1.f13828a
            java.lang.String r0 = r0.y()
            r13 = 4614388178203810202(0x400999999999999a, double:3.2)
            if (r0 != 0) goto L_0x00f8
            r11 = r13
            goto L_0x0124
        L_0x00f8:
            en.a r0 = r1.f13828a     // Catch:{ NumberFormatException -> 0x010a }
            java.lang.String r0 = r0.y()     // Catch:{ NumberFormatException -> 0x010a }
            r15 = 7
            r11 = 10
            java.lang.String r0 = r0.substring(r15, r11)     // Catch:{ NumberFormatException -> 0x010a }
            double r11 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x010a }
            goto L_0x0124
        L_0x010a:
            r0 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "run: ---->>>>>error::::"
            r11.append(r12)
            java.lang.String r0 = r0.getMessage()
            r11.append(r0)
            java.lang.String r0 = r11.toString()
            android.util.Log.i(r2, r0)
            r11 = r7
        L_0x0124:
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 >= 0) goto L_0x0148
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r11 = r0.a()
            double r11 = r11 / r9
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ae
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r7 = r0.a()
            double r7 = r7 / r9
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ae
            goto L_0x00a1
        L_0x0148:
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r9 = r0.a()
            r11 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r9 = r9 / r11
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0198
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r7 = r0.a()
            double r7 = r7 / r11
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0198
            goto L_0x0187
        L_0x0169:
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r9 = r0.a()
            double r9 = r9 / r11
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0198
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r7 = r0.a()
            double r7 = r7 / r11
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0198
        L_0x0187:
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r5 = r0.a()
            double r5 = r5 / r11
        L_0x0192:
            double r5 = java.lang.Math.abs(r5)
            double r3 = r3 - r5
            goto L_0x01a3
        L_0x0198:
            en.a r0 = r1.f13828a
            com.flypro.core.drone.variables.a r0 = r0.t()
            double r3 = r0.a()
            double r3 = r3 / r11
        L_0x01a3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "onViewCreated: --->>>follow alt::::"
            r0.append(r5)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r2, r0)
            r5 = 4617315517961601024(0x4014000000000000, double:5.0)
            r0 = 5
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 > 0) goto L_0x01c0
            r2 = 5
            goto L_0x01ce
        L_0x01c0:
            int r2 = (int) r3
            double r5 = (double) r2
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            java.lang.Double.isNaN(r5)
            double r5 = r5 + r7
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x01ce
            int r2 = r2 + 1
        L_0x01ce:
            r3 = 50
            if (r2 <= r3) goto L_0x01d4
            r2 = 50
        L_0x01d4:
            com.xeagle.android.widgets.wheelView.widget.WheelView r3 = r1.f13829b
            lm.a r4 = new lm.a
            androidx.fragment.app.FragmentActivity r5 = r17.getActivity()
            r4.<init>(r5)
            r3.setWheelAdapter(r4)
            com.xeagle.android.widgets.wheelView.widget.WheelView r3 = r1.f13829b
            com.xeagle.android.widgets.wheelView.widget.WheelView$Skin r4 = com.xeagle.android.widgets.wheelView.widget.WheelView.Skin.Holo
            r3.setSkin(r4)
            com.xeagle.android.widgets.wheelView.widget.WheelView r3 = r1.f13829b
            java.util.ArrayList r4 = r17.a()
            r3.setWheelData(r4)
            com.xeagle.android.widgets.wheelView.widget.WheelView r3 = r1.f13829b
            r4 = 2
            int r2 = r2 - r4
            r3.setSelection(r2)
            com.xeagle.android.widgets.wheelView.widget.WheelView r2 = r1.f13829b
            r3 = 180(0xb4, float:2.52E-43)
            r2.setMinimumHeight(r3)
            com.xeagle.android.widgets.wheelView.widget.WheelView r2 = r1.f13829b
            r2.setDividerHeight(r4)
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r2 = new com.xeagle.android.widgets.wheelView.widget.WheelView$c
            r2.<init>()
            r3 = 18
            r2.f26195g = r3
            r3 = 14
            r2.f26194f = r3
            com.xeagle.android.widgets.wheelView.widget.WheelView r3 = r1.f13829b
            r3.setWheelSize(r0)
            com.xeagle.android.widgets.wheelView.widget.WheelView r0 = r1.f13829b
            r0.setStyle(r2)
            com.xeagle.android.widgets.wheelView.widget.WheelView r0 = r1.f13829b
            kc.i$1 r2 = new kc.i$1
            r2.<init>()
            r0.setOnWheelItemSelectedListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.i.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
