package kk;

import android.os.CountDownTimer;
import android.util.SparseArray;
import ci.b;
import com.flypro.core.database.DroneInfoData;
import com.flypro.core.database.UserLiteHelper;
import com.xeagle.android.login.beans.DroneInfoInDevice;
import com.xeagle.android.newUI.activity.DeviceManageActivity;
import java.util.List;
import org.litepal.crud.callback.FindMultiCallback;

public class a extends ci.a<DroneInfoInDevice, b> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public en.a f30123a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public DeviceManageActivity f30124b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<CountDownTimer> f30125c = new SparseArray<>();

    public a(DeviceManageActivity deviceManageActivity, en.a aVar, int i2, List<DroneInfoInDevice> list) {
        super(i2, list);
        this.f30123a = aVar;
        this.f30124b = deviceManageActivity;
    }

    public void a() {
        if (this.f30125c != null) {
            for (int i2 = 0; i2 < this.f30125c.size(); i2++) {
                SparseArray<CountDownTimer> sparseArray = this.f30125c;
                CountDownTimer countDownTimer = sparseArray.get(sparseArray.keyAt(i2));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
            this.f30125c.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final b bVar, final DroneInfoInDevice droneInfoInDevice) {
        if (droneInfoInDevice != null) {
            UserLiteHelper.requestDroneInfo(new FindMultiCallback<DroneInfoData>() {
                /* JADX WARNING: Removed duplicated region for block: B:32:0x00e1  */
                /* JADX WARNING: Removed duplicated region for block: B:33:0x00e7  */
                /* JADX WARNING: Removed duplicated region for block: B:36:0x0185  */
                /* JADX WARNING: Removed duplicated region for block: B:37:0x01df  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onFinish(java.util.List<com.flypro.core.database.DroneInfoData> r12) {
                    /*
                        r11 = this;
                        int r0 = r12.size()
                        r1 = 2131821039(0x7f1101ef, float:1.927481E38)
                        r2 = 2131297396(0x7f090474, float:1.8212736E38)
                        r3 = 0
                        if (r0 <= 0) goto L_0x0035
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getSn()
                        java.lang.Object r4 = r12.get(r3)
                        com.flypro.core.database.DroneInfoData r4 = (com.flypro.core.database.DroneInfoData) r4
                        java.lang.String r4 = r4.getDroneSnId()
                        boolean r0 = r0.equalsIgnoreCase(r4)
                        if (r0 == 0) goto L_0x0035
                        kk.a r0 = kk.a.this
                        en.a r0 = r0.f30123a
                        boolean r0 = r0.a()
                        if (r0 == 0) goto L_0x0035
                        ci.b r0 = r2
                        r1 = 2131820965(0x7f1101a5, float:1.927466E38)
                        goto L_0x0037
                    L_0x0035:
                        ci.b r0 = r2
                    L_0x0037:
                        r0.a((int) r2, (int) r1)
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getModel()
                        java.lang.String r1 = "DF808-D"
                        boolean r0 = r0.equalsIgnoreCase(r1)
                        r1 = 2131297595(0x7f09053b, float:1.821314E38)
                        if (r0 == 0) goto L_0x0055
                        ci.b r0 = r2
                        r2 = 2131231113(0x7f080189, float:1.8078298E38)
                    L_0x0050:
                        r0.b((int) r1, (int) r2)
                        goto L_0x00cd
                    L_0x0055:
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getModel()
                        java.lang.String r2 = "816"
                        boolean r0 = r0.contains(r2)
                        if (r0 == 0) goto L_0x0069
                        ci.b r0 = r2
                        r2 = 2131231118(0x7f08018e, float:1.8078308E38)
                        goto L_0x0050
                    L_0x0069:
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getModel()
                        java.lang.String r2 = "DF808"
                        boolean r0 = r0.equalsIgnoreCase(r2)
                        if (r0 == 0) goto L_0x007d
                        ci.b r0 = r2
                        r2 = 2131231112(0x7f080188, float:1.8078296E38)
                        goto L_0x0050
                    L_0x007d:
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getModel()
                        java.lang.String r2 = "DF809-D"
                        boolean r0 = r0.equalsIgnoreCase(r2)
                        if (r0 == 0) goto L_0x0091
                        ci.b r0 = r2
                        r2 = 2131231114(0x7f08018a, float:1.80783E38)
                        goto L_0x0050
                    L_0x0091:
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getModel()
                        java.lang.String r2 = "DF812-D"
                        boolean r0 = r0.equalsIgnoreCase(r2)
                        if (r0 == 0) goto L_0x00a5
                        ci.b r0 = r2
                        r2 = 2131231116(0x7f08018c, float:1.8078304E38)
                        goto L_0x0050
                    L_0x00a5:
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getModel()
                        java.lang.String r2 = "DF812-E"
                        boolean r0 = r0.equalsIgnoreCase(r2)
                        if (r0 == 0) goto L_0x00b9
                        ci.b r0 = r2
                        r2 = 2131231117(0x7f08018d, float:1.8078306E38)
                        goto L_0x0050
                    L_0x00b9:
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getModel()
                        java.lang.String r2 = "DF809-E"
                        boolean r0 = r0.equalsIgnoreCase(r2)
                        if (r0 == 0) goto L_0x00cd
                        ci.b r0 = r2
                        r2 = 2131231115(0x7f08018b, float:1.8078302E38)
                        goto L_0x0050
                    L_0x00cd:
                        kk.a r0 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r0 = r0.f30124b
                        android.content.Context r0 = r0.getApplicationContext()
                        boolean r0 = com.xeagle.android.utils.c.b((android.content.Context) r0)
                        r1 = 2131298607(0x7f09092f, float:1.8215192E38)
                        r2 = 1
                        if (r0 == 0) goto L_0x00e7
                        ci.b r0 = r2
                        r0.b((int) r1, (boolean) r2)
                        goto L_0x00ec
                    L_0x00e7:
                        ci.b r0 = r2
                        r0.b((int) r1, (boolean) r3)
                    L_0x00ec:
                        ci.b r0 = r2
                        java.util.Locale r1 = java.util.Locale.US
                        r4 = 2
                        java.lang.Object[] r5 = new java.lang.Object[r4]
                        kk.a r6 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r6 = r6.f30124b
                        android.content.Context r6 = r6.getApplicationContext()
                        r7 = 2131820687(0x7f11008f, float:1.9274096E38)
                        java.lang.String r6 = r6.getString(r7)
                        r5[r3] = r6
                        com.xeagle.android.login.beans.DroneInfoInDevice r6 = r3
                        java.lang.String r6 = r6.getSn()
                        r5[r2] = r6
                        java.lang.String r6 = "%s%s"
                        java.lang.String r1 = java.lang.String.format(r1, r6, r5)
                        r5 = 2131296388(0x7f090084, float:1.8210691E38)
                        ci.b r0 = r0.a((int) r5, (java.lang.CharSequence) r1)
                        r0.b((int) r5)
                        ci.b r0 = r2
                        r1 = 2131296389(0x7f090085, float:1.8210693E38)
                        java.util.Locale r5 = java.util.Locale.US
                        java.lang.Object[] r7 = new java.lang.Object[r4]
                        kk.a r8 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r8 = r8.f30124b
                        android.content.Context r8 = r8.getApplicationContext()
                        r9 = 2131820688(0x7f110090, float:1.9274098E38)
                        java.lang.String r8 = r8.getString(r9)
                        r7[r3] = r8
                        com.xeagle.android.login.beans.DroneInfoInDevice r8 = r3
                        java.lang.String r8 = r8.getActivated_at()
                        r7[r2] = r8
                        java.lang.String r5 = java.lang.String.format(r5, r6, r7)
                        r0.a((int) r1, (java.lang.CharSequence) r5)
                        ci.b r0 = r2
                        r1 = 2131299306(0x7f090bea, float:1.821661E38)
                        java.util.Locale r5 = java.util.Locale.US
                        java.lang.Object[] r4 = new java.lang.Object[r4]
                        kk.a r7 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r7 = r7.f30124b
                        android.content.Context r7 = r7.getApplicationContext()
                        r8 = 2131823014(0x7f1109a6, float:1.9278816E38)
                        java.lang.String r7 = r7.getString(r8)
                        r4[r3] = r7
                        com.xeagle.android.login.beans.DroneInfoInDevice r7 = r3
                        java.lang.String r7 = r7.getUid()
                        r4[r2] = r7
                        java.lang.String r4 = java.lang.String.format(r5, r6, r4)
                        r0.a((int) r1, (java.lang.CharSequence) r4)
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        int r0 = r0.getInsured()
                        r1 = 2131099695(0x7f06002f, float:1.781175E38)
                        r4 = 2131299515(0x7f090cbb, float:1.8217034E38)
                        r6 = 2131297386(0x7f09046a, float:1.8212715E38)
                        if (r0 != r2) goto L_0x01df
                        ci.b r0 = r2
                        r0.b((int) r6, (boolean) r2)
                        ci.b r0 = r2
                        kk.a r2 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r2 = r2.f30124b
                        android.content.Context r2 = r2.getApplicationContext()
                        r3 = 2131822490(0x7f11079a, float:1.9277753E38)
                        java.lang.String r2 = r2.getString(r3)
                        r0.a((int) r6, (java.lang.CharSequence) r2)
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getInsured_valid_at()
                        long r2 = com.xeagle.android.utils.y.a((java.lang.String) r0)
                        long r6 = java.lang.System.currentTimeMillis()
                        long r2 = r2 - r6
                        ci.b r0 = r2
                        kk.a r5 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r5 = r5.f30124b
                        android.content.Context r5 = r5.getApplicationContext()
                        int r1 = r5.getColor(r1)
                        r0.c(r4, r1)
                        kk.a$1$1 r6 = new kk.a$1$1
                        r4 = 1000(0x3e8, double:4.94E-321)
                        r0 = r6
                        r1 = r11
                        r0.<init>(r2, r4)
                        kk.a r0 = kk.a.this
                        android.util.SparseArray r0 = r0.f30125c
                        ci.b r1 = r2
                        int r1 = r1.getPosition()
                        r0.put(r1, r6)
                        r6.start()
                        goto L_0x0290
                    L_0x01df:
                        com.xeagle.android.login.beans.DroneInfoInDevice r0 = r3
                        java.lang.String r0 = r0.getInsurable_stop_time()
                        long r7 = com.xeagle.android.utils.y.a((java.lang.String) r0)
                        long r9 = java.lang.System.currentTimeMillis()
                        long r7 = r7 - r9
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r5 = "onFinish: ===remain=="
                        r0.append(r5)
                        r0.append(r7)
                        java.lang.String r0 = r0.toString()
                        java.lang.String r5 = "ServeTest"
                        android.util.Log.i(r5, r0)
                        r9 = 0
                        int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                        if (r0 >= 0) goto L_0x023c
                        ci.b r0 = r2
                        r0.a((int) r6, (boolean) r3)
                        ci.b r0 = r2
                        kk.a r1 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r1 = r1.f30124b
                        android.content.Context r1 = r1.getApplicationContext()
                        r2 = 2131099824(0x7f0600b0, float:1.7812012E38)
                        int r1 = r1.getColor(r2)
                        r0.c(r4, r1)
                        ci.b r0 = r2
                        kk.a r1 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r1 = r1.f30124b
                        android.content.Context r1 = r1.getApplicationContext()
                        r2 = 2131820701(0x7f11009d, float:1.9274124E38)
                        java.lang.String r1 = r1.getString(r2)
                        r0.a((int) r4, (java.lang.CharSequence) r1)
                        goto L_0x0286
                    L_0x023c:
                        ci.b r0 = r2
                        r0.b((int) r6, (boolean) r2)
                        ci.b r0 = r2
                        kk.a r2 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r2 = r2.f30124b
                        android.content.Context r2 = r2.getApplicationContext()
                        int r1 = r2.getColor(r1)
                        r0.c(r4, r1)
                        ci.b r0 = r2
                        kk.a r1 = kk.a.this
                        com.xeagle.android.newUI.activity.DeviceManageActivity r1 = r1.f30124b
                        android.content.Context r1 = r1.getApplicationContext()
                        r2 = 2131820774(0x7f1100e6, float:1.9274272E38)
                        java.lang.String r1 = r1.getString(r2)
                        r0.a((int) r6, (java.lang.CharSequence) r1)
                        kk.a$1$2 r9 = new kk.a$1$2
                        r4 = 1000(0x3e8, double:4.94E-321)
                        r0 = r9
                        r1 = r11
                        r2 = r7
                        r0.<init>(r2, r4)
                        kk.a r0 = kk.a.this
                        android.util.SparseArray r0 = r0.f30125c
                        ci.b r1 = r2
                        int r1 = r1.getPosition()
                        r0.put(r1, r9)
                        r9.start()
                    L_0x0286:
                        ci.b r0 = r2
                        kk.a$1$3 r1 = new kk.a$1$3
                        r1.<init>()
                        r0.a((int) r6, (android.view.View.OnClickListener) r1)
                    L_0x0290:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kk.a.AnonymousClass1.onFinish(java.util.List):void");
                }
            });
        }
    }
}
