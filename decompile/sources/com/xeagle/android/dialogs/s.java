package com.xeagle.android.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import ix.b;
import java.util.List;

public class s extends b {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f22731a;

    /* renamed from: b  reason: collision with root package name */
    private String f22732b;

    /* renamed from: c  reason: collision with root package name */
    private String f22733c;

    /* renamed from: d  reason: collision with root package name */
    private String f22734d;

    /* renamed from: e  reason: collision with root package name */
    private Button f22735e;

    /* renamed from: f  reason: collision with root package name */
    private Button f22736f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22737g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f22738h;

    /* renamed from: i  reason: collision with root package name */
    private Context f22739i;

    public s(Context context, int i2, String str, String str2, String str3, List<String> list) {
        super(context, i2);
        this.f22739i = context;
        this.f22732b = str;
        this.f22733c = str2;
        this.f22734d = str3;
        this.f22731a = list;
    }

    private void d() {
        this.f22737g.setText(this.f22732b);
        this.f22736f.setText(this.f22733c);
        this.f22735e.setText(this.f22734d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092 A[SYNTHETIC, Splitter:B:22:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b8 A[Catch:{ NameNotFoundException -> 0x0147 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r14 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            java.util.List<java.lang.String> r2 = r14.f22731a
            java.util.Iterator r2 = r2.iterator()
            java.lang.String r3 = ""
        L_0x000f:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0155
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            r5 = 29
            r6 = 0
            if (r1 != r5) goto L_0x002b
            java.util.Map r3 = ix.a.a()
        L_0x0024:
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0045
        L_0x002b:
            r5 = 30
            if (r1 != r5) goto L_0x0034
            java.util.Map r3 = ix.a.b()
            goto L_0x0024
        L_0x0034:
            android.content.Context r5 = r14.f22739i     // Catch:{ NameNotFoundException -> 0x0041 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0041 }
            android.content.pm.PermissionInfo r4 = r5.getPermissionInfo(r4, r6)     // Catch:{ NameNotFoundException -> 0x0041 }
            java.lang.String r3 = r4.group     // Catch:{ NameNotFoundException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0045:
            if (r3 == 0) goto L_0x000f
            boolean r4 = r0.contains(r3)
            if (r4 != 0) goto L_0x000f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "buildPermissionLayout:--- "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "newUI"
            android.util.Log.i(r5, r4)
            android.content.Context r4 = r14.f22739i
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r5 = 2131493363(0x7f0c01f3, float:1.8610204E38)
            android.widget.LinearLayout r7 = r14.f22738h
            android.view.View r4 = r4.inflate(r5, r7, r6)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r5 = 2131296649(0x7f090189, float:1.821122E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r7 = 2131297617(0x7f090551, float:1.8213184E38)
            android.view.View r7 = r4.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            java.lang.String r8 = "android.permission-group.STORAGE"
            boolean r8 = r3.equalsIgnoreCase(r8)     // Catch:{ NameNotFoundException -> 0x0147 }
            r9 = 2
            java.lang.String r10 = "%s\t(%s)"
            r11 = 1
            if (r8 == 0) goto L_0x00b8
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.Context r12 = r14.f22739i     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.pm.PackageManager r13 = r12.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.pm.PermissionGroupInfo r13 = r13.getPermissionGroupInfo(r3, r6)     // Catch:{ NameNotFoundException -> 0x0147 }
            int r13 = r13.labelRes     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.String r12 = r12.getString(r13)     // Catch:{ NameNotFoundException -> 0x0147 }
            r9[r6] = r12     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.Context r12 = r14.f22739i     // Catch:{ NameNotFoundException -> 0x0147 }
            r13 = 2131822159(0x7f11064f, float:1.9277082E38)
            java.lang.String r12 = r12.getString(r13)     // Catch:{ NameNotFoundException -> 0x0147 }
            r9[r11] = r12     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.String r8 = java.lang.String.format(r8, r10, r9)     // Catch:{ NameNotFoundException -> 0x0147 }
            goto L_0x0129
        L_0x00b8:
            java.lang.String r8 = "android.permission-group.LOCATION"
            boolean r8 = r3.equalsIgnoreCase(r8)     // Catch:{ NameNotFoundException -> 0x0147 }
            if (r8 == 0) goto L_0x00e6
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.Context r12 = r14.f22739i     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.pm.PackageManager r13 = r12.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.pm.PermissionGroupInfo r13 = r13.getPermissionGroupInfo(r3, r6)     // Catch:{ NameNotFoundException -> 0x0147 }
            int r13 = r13.labelRes     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.String r12 = r12.getString(r13)     // Catch:{ NameNotFoundException -> 0x0147 }
            r9[r6] = r12     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.Context r12 = r14.f22739i     // Catch:{ NameNotFoundException -> 0x0147 }
            r13 = 2131822155(0x7f11064b, float:1.9277073E38)
            java.lang.String r12 = r12.getString(r13)     // Catch:{ NameNotFoundException -> 0x0147 }
            r9[r11] = r12     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.String r8 = java.lang.String.format(r8, r10, r9)     // Catch:{ NameNotFoundException -> 0x0147 }
            goto L_0x0129
        L_0x00e6:
            java.lang.String r8 = "android.permission-group.CAMERA"
            boolean r8 = r3.equalsIgnoreCase(r8)     // Catch:{ NameNotFoundException -> 0x0147 }
            if (r8 == 0) goto L_0x0114
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.Context r12 = r14.f22739i     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.pm.PackageManager r13 = r12.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.pm.PermissionGroupInfo r13 = r13.getPermissionGroupInfo(r3, r6)     // Catch:{ NameNotFoundException -> 0x0147 }
            int r13 = r13.labelRes     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.String r12 = r12.getString(r13)     // Catch:{ NameNotFoundException -> 0x0147 }
            r9[r6] = r12     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.Context r12 = r14.f22739i     // Catch:{ NameNotFoundException -> 0x0147 }
            r13 = 2131822152(0x7f110648, float:1.9277067E38)
            java.lang.String r12 = r12.getString(r13)     // Catch:{ NameNotFoundException -> 0x0147 }
            r9[r11] = r12     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.String r8 = java.lang.String.format(r8, r10, r9)     // Catch:{ NameNotFoundException -> 0x0147 }
            goto L_0x0129
        L_0x0114:
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.String r9 = "%s"
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.Context r11 = r14.f22739i     // Catch:{ NameNotFoundException -> 0x0147 }
            r12 = 2131820721(0x7f1100b1, float:1.9274165E38)
            java.lang.String r11 = r11.getString(r12)     // Catch:{ NameNotFoundException -> 0x0147 }
            r10[r6] = r11     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.String r8 = java.lang.String.format(r8, r9, r10)     // Catch:{ NameNotFoundException -> 0x0147 }
        L_0x0129:
            r5.setText(r8)     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.Context r5 = r14.f22739i     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0147 }
            android.content.pm.PermissionGroupInfo r5 = r5.getPermissionGroupInfo(r3, r6)     // Catch:{ NameNotFoundException -> 0x0147 }
            int r5 = r5.icon     // Catch:{ NameNotFoundException -> 0x0147 }
            r7.setImageResource(r5)     // Catch:{ NameNotFoundException -> 0x0147 }
            java.lang.String r5 = "#83e8dd"
            int r5 = android.graphics.Color.parseColor(r5)     // Catch:{ NameNotFoundException -> 0x0147 }
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SRC_ATOP     // Catch:{ NameNotFoundException -> 0x0147 }
            r7.setColorFilter(r5, r6)     // Catch:{ NameNotFoundException -> 0x0147 }
            goto L_0x014b
        L_0x0147:
            r5 = move-exception
            r5.printStackTrace()
        L_0x014b:
            android.widget.LinearLayout r5 = r14.f22738h
            r5.addView(r4)
            r0.add(r3)
            goto L_0x000f
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.dialogs.s.e():void");
    }

    private void f() {
        double d2;
        double d3;
        WindowManager.LayoutParams layoutParams;
        int i2 = this.f22739i.getResources().getDisplayMetrics().widthPixels;
        if (i2 < this.f22739i.getResources().getDisplayMetrics().heightPixels) {
            layoutParams = getWindow().getAttributes();
            getWindow().setGravity(17);
            d3 = (double) i2;
            d2 = 0.86d;
        } else {
            layoutParams = getWindow().getAttributes();
            getWindow().setGravity(17);
            d3 = (double) i2;
            d2 = 0.6d;
        }
        Double.isNaN(d3);
        layoutParams.width = (int) (d3 * d2);
        getWindow().setAttributes(layoutParams);
    }

    public View a() {
        return this.f22736f;
    }

    public View b() {
        return this.f22735e;
    }

    public List<String> c() {
        return this.f22731a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.permission_dlg);
        this.f22735e = (Button) findViewById(R.id.negativeBtn);
        this.f22736f = (Button) findViewById(R.id.positiveBtn);
        this.f22737g = (TextView) findViewById(R.id.messageText);
        this.f22738h = (LinearLayout) findViewById(R.id.permissionsLayout);
        d();
        e();
        f();
    }
}
