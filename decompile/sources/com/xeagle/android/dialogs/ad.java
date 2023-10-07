package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import dy.av;
import en.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class ad extends a implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f12423c = true;

    /* renamed from: d  reason: collision with root package name */
    private static ad f12424d;

    /* renamed from: b  reason: collision with root package name */
    Runnable f12425b = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x01a6, code lost:
            if (r6 == ((java.lang.Integer) r7.get(4)).intValue()) goto L_0x01a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x01a8, code lost:
            r0 = com.xeagle.android.dialogs.ad.m(r12.f22515a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x01ee, code lost:
            if (r6 == ((java.lang.Integer) r7.get(4)).intValue()) goto L_0x01a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x022b, code lost:
            if (r6 == ((java.lang.Integer) r7.get(4)).intValue()) goto L_0x01a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x026a, code lost:
            if (r6 == ((java.lang.Integer) r7.get(4)).intValue()) goto L_0x01d0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0287  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x02aa  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a() {
            /*
                r12 = this;
                long r0 = java.lang.System.currentTimeMillis()
                com.xeagle.android.dialogs.ad r2 = com.xeagle.android.dialogs.ad.this
                long r2 = r2.f12445x
                long r0 = r0 - r2
                r2 = 5000(0x1388, double:2.4703E-320)
                long r2 = r2 - r0
                int r0 = (int) r2
                long r0 = (long) r0
                r2 = 1
                r3 = 3
                r4 = 0
                r5 = 0
                int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r7 < 0) goto L_0x0086
                r5 = 1000(0x3e8, double:4.94E-321)
                long r5 = r0 / r5
                int r6 = (int) r5
                int r6 = r6 + r2
                com.xeagle.android.dialogs.ad r5 = com.xeagle.android.dialogs.ad.this
                android.widget.ProgressBar r5 = r5.f12431j
                r5.setIndeterminate(r4)
                com.xeagle.android.dialogs.ad r5 = com.xeagle.android.dialogs.ad.this
                android.widget.ProgressBar r5 = r5.f12431j
                r7 = 5000(0x1388, float:7.006E-42)
                r5.setMax(r7)
                com.xeagle.android.dialogs.ad r5 = com.xeagle.android.dialogs.ad.this
                android.widget.ProgressBar r5 = r5.f12431j
                int r1 = (int) r0
                r5.setProgress(r1)
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12432k
                java.util.Locale r1 = java.util.Locale.US
                java.lang.Object[] r5 = new java.lang.Object[r2]
                java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
                r5[r4] = r7
                java.lang.String r4 = "剩余检测时间：%d s"
                java.lang.String r1 = java.lang.String.format(r1, r4, r5)
                r0.setText(r1)
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.ProgressBar r0 = r0.f12431j
                com.xeagle.android.dialogs.ad r1 = com.xeagle.android.dialogs.ad.this
                android.content.res.Resources r1 = r1.getResources()
                if (r6 <= r3) goto L_0x006f
                r2 = 2131232140(0x7f08058c, float:1.808038E38)
            L_0x0067:
                android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
                r0.setProgressDrawable(r1)
                goto L_0x0079
            L_0x006f:
                if (r6 <= r2) goto L_0x0075
                r2 = 2131232142(0x7f08058e, float:1.8080385E38)
                goto L_0x0067
            L_0x0075:
                r2 = 2131232141(0x7f08058d, float:1.8080383E38)
                goto L_0x0067
            L_0x0079:
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.os.Handler r0 = r0.f12446y
                r1 = 100
                r0.postDelayed(r12, r1)
                goto L_0x02c9
            L_0x0086:
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                boolean unused = r0.f12439r = r4
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12432k
                java.lang.String r1 = "检测完成！"
                r0.setText(r1)
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12433l
                r0.setVisibility(r4)
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.ProgressBar r0 = r0.f12431j
                r1 = 8
                r0.setVisibility(r1)
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                java.util.ArrayList r1 = r0.f12441t
                int r0 = r0.a((java.util.ArrayList<java.lang.Integer>) r1)
                com.xeagle.android.dialogs.ad r1 = com.xeagle.android.dialogs.ad.this
                java.util.ArrayList r5 = r1.f12442u
                int r1 = r1.a((java.util.ArrayList<java.lang.Integer>) r5)
                com.xeagle.android.dialogs.ad r5 = com.xeagle.android.dialogs.ad.this
                java.util.ArrayList r6 = r5.f12443v
                int r5 = r5.a((java.util.ArrayList<java.lang.Integer>) r6)
                com.xeagle.android.dialogs.ad r6 = com.xeagle.android.dialogs.ad.this
                java.util.ArrayList r7 = r6.f12444w
                int r6 = r6.a((java.util.ArrayList<java.lang.Integer>) r7)
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
                r7.add(r8)
                java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
                r7.add(r8)
                java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
                r7.add(r8)
                java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
                r7.add(r8)
                java.util.Collections.sort(r7)
                com.xeagle.android.dialogs.ad r8 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r8 = r8.f12427f
                java.util.Locale r9 = java.util.Locale.US
                java.lang.Object[] r10 = new java.lang.Object[r2]
                java.lang.Integer r11 = java.lang.Integer.valueOf(r0)
                r10[r4] = r11
                java.lang.String r11 = "右前，均值:%d"
                java.lang.String r9 = java.lang.String.format(r9, r11, r10)
                r8.setText(r9)
                com.xeagle.android.dialogs.ad r8 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r8 = r8.f12428g
                java.util.Locale r9 = java.util.Locale.US
                java.lang.Object[] r10 = new java.lang.Object[r2]
                java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
                r10[r4] = r11
                java.lang.String r11 = "左后，均值:%d"
                java.lang.String r9 = java.lang.String.format(r9, r11, r10)
                r8.setText(r9)
                com.xeagle.android.dialogs.ad r8 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r8 = r8.f12429h
                java.util.Locale r9 = java.util.Locale.US
                java.lang.Object[] r10 = new java.lang.Object[r2]
                java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
                r10[r4] = r11
                java.lang.String r11 = "左前，均值:%d"
                java.lang.String r9 = java.lang.String.format(r9, r11, r10)
                r8.setText(r9)
                com.xeagle.android.dialogs.ad r8 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r8 = r8.f12430i
                java.util.Locale r9 = java.util.Locale.US
                java.lang.Object[] r10 = new java.lang.Object[r2]
                java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
                r10[r4] = r11
                java.lang.String r11 = "右后，均值:%d"
                java.lang.String r9 = java.lang.String.format(r9, r11, r10)
                r8.setText(r9)
                java.lang.Object r8 = r7.get(r4)
                java.lang.Integer r8 = (java.lang.Integer) r8
                int r8 = r8.intValue()
                r9 = 4
                r10 = -65536(0xffffffffffff0000, float:NaN)
                if (r0 != r8) goto L_0x01af
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12427f
                r0.setTextColor(r10)
                java.lang.Object r0 = r7.get(r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r1 != r0) goto L_0x0189
            L_0x017e:
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12428g
            L_0x0184:
                r0.setTextColor(r10)
                goto L_0x026e
            L_0x0189:
                java.lang.Object r0 = r7.get(r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r5 != r0) goto L_0x019c
            L_0x0195:
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12429h
                goto L_0x0184
            L_0x019c:
                java.lang.Object r0 = r7.get(r9)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r6 != r0) goto L_0x026e
            L_0x01a8:
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12430i
                goto L_0x0184
            L_0x01af:
                java.lang.Object r8 = r7.get(r4)
                java.lang.Integer r8 = (java.lang.Integer) r8
                int r8 = r8.intValue()
                if (r1 != r8) goto L_0x01f1
                com.xeagle.android.dialogs.ad r1 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r1 = r1.f12428g
                r1.setTextColor(r10)
                java.lang.Object r1 = r7.get(r3)
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                if (r0 != r1) goto L_0x01d7
            L_0x01d0:
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12427f
                goto L_0x0184
            L_0x01d7:
                java.lang.Object r0 = r7.get(r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r5 != r0) goto L_0x01e4
                goto L_0x0195
            L_0x01e4:
                java.lang.Object r0 = r7.get(r9)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r6 != r0) goto L_0x026e
                goto L_0x01a8
            L_0x01f1:
                java.lang.Object r8 = r7.get(r4)
                java.lang.Integer r8 = (java.lang.Integer) r8
                int r8 = r8.intValue()
                if (r5 != r8) goto L_0x022f
                com.xeagle.android.dialogs.ad r5 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r5 = r5.f12429h
                r5.setTextColor(r10)
                java.lang.Object r5 = r7.get(r3)
                java.lang.Integer r5 = (java.lang.Integer) r5
                int r5 = r5.intValue()
                if (r1 != r5) goto L_0x0214
                goto L_0x017e
            L_0x0214:
                java.lang.Object r1 = r7.get(r3)
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                if (r0 != r1) goto L_0x0221
                goto L_0x01d0
            L_0x0221:
                java.lang.Object r0 = r7.get(r9)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r6 != r0) goto L_0x026e
                goto L_0x01a8
            L_0x022f:
                java.lang.Object r0 = r7.get(r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r6 != r0) goto L_0x026e
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12430i
                r0.setTextColor(r10)
                java.lang.Object r0 = r7.get(r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r1 != r0) goto L_0x0252
                goto L_0x017e
            L_0x0252:
                java.lang.Object r0 = r7.get(r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r5 != r0) goto L_0x0260
                goto L_0x0195
            L_0x0260:
                java.lang.Object r0 = r7.get(r9)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r6 != r0) goto L_0x026e
                goto L_0x01d0
            L_0x026e:
                java.lang.Object r0 = r7.get(r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                java.lang.Object r1 = r7.get(r4)
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                int r0 = r0 - r1
                r1 = 100
                if (r0 < r1) goto L_0x02aa
                com.xeagle.android.dialogs.ad r1 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r1 = r1.f12433l
                r1.setTextColor(r10)
                com.xeagle.android.dialogs.ad r1 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r1 = r1.f12433l
                java.util.Locale r3 = java.util.Locale.US
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r2[r4] = r0
                java.lang.String r0 = "电机异常，相差：%d"
                java.lang.String r0 = java.lang.String.format(r3, r0, r2)
                r1.setText(r0)
                goto L_0x02b5
            L_0x02aa:
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                android.widget.TextView r0 = r0.f12433l
                java.lang.String r1 = "电机正常！"
                r0.setText(r1)
            L_0x02b5:
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                com.xeagle.android.vjoystick.IWidgets.IButton r0 = r0.f12434m
                r0.setVisibility(r4)
                com.xeagle.android.dialogs.ad r0 = com.xeagle.android.dialogs.ad.this
                com.xeagle.android.vjoystick.IWidgets.IButton r0 = r0.f12434m
                java.lang.String r1 = "重新检测"
                r0.setText(r1)
            L_0x02c9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.dialogs.ad.AnonymousClass1.a():void");
        }

        public void run() {
            ad.this.f12446y.removeCallbacks(this);
            a();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private TextView f12426e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f12427f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f12428g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f12429h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f12430i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public ProgressBar f12431j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public TextView f12432k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public TextView f12433l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public IButton f12434m;

    /* renamed from: n  reason: collision with root package name */
    private IImageButton f12435n;

    /* renamed from: o  reason: collision with root package name */
    private Context f12436o;

    /* renamed from: p  reason: collision with root package name */
    private XEagleApp f12437p;

    /* renamed from: q  reason: collision with root package name */
    private a f12438q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f12439r;

    /* renamed from: s  reason: collision with root package name */
    private int[] f12440s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public ArrayList<Integer> f12441t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public ArrayList<Integer> f12442u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public ArrayList<Integer> f12443v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public ArrayList<Integer> f12444w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public long f12445x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final Handler f12446y = new Handler(Looper.myLooper());

    /* access modifiers changed from: private */
    public int a(ArrayList<Integer> arrayList) {
        Iterator<Integer> it2 = arrayList.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += it2.next().intValue();
        }
        return i2 / arrayList.size();
    }

    public static ad a() {
        if (f12424d == null) {
            f12424d = new ad();
        }
        return f12424d;
    }

    private void a(View view) {
        this.f12426e = (TextView) view.findViewById(R.id.textViewStep);
        this.f12427f = (TextView) view.findViewById(R.id.servo1);
        this.f12428g = (TextView) view.findViewById(R.id.servo2);
        this.f12429h = (TextView) view.findViewById(R.id.servo3);
        this.f12430i = (TextView) view.findViewById(R.id.servo4);
        this.f12431j = (ProgressBar) view.findViewById(R.id.servo_pb);
        this.f12432k = (TextView) view.findViewById(R.id.servo_progress_tv);
        this.f12433l = (TextView) view.findViewById(R.id.textViewResult);
        this.f12434m = (IButton) view.findViewById(R.id.start_check);
        this.f12435n = (IImageButton) view.findViewById(R.id.ib_cancel);
        this.f12441t = new ArrayList<>();
        this.f12442u = new ArrayList<>();
        this.f12443v = new ArrayList<>();
        this.f12444w = new ArrayList<>();
        this.f12434m.setOnClickListener(this);
        this.f12435n.setOnClickListener(this);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f12436o = context;
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.ib_cancel) {
            this.f12439r = false;
            dismiss();
        } else if (id2 == R.id.start_check) {
            if (!this.f12438q.d().c()) {
                ToastUtils.showShort((CharSequence) "请确认飞机已解锁再开始检测");
            } else if (!this.f12439r) {
                this.f12439r = true;
                this.f12445x = System.currentTimeMillis();
                this.f12427f.setTextColor(-16711936);
                this.f12428g.setTextColor(-16711936);
                this.f12429h.setTextColor(-16711936);
                this.f12430i.setTextColor(-16711936);
                this.f12434m.setVisibility(8);
                this.f12431j.setVisibility(0);
                this.f12432k.setVisibility(0);
                this.f12441t.clear();
                this.f12442u.clear();
                this.f12443v.clear();
                this.f12444w.clear();
                this.f12446y.removeCallbacks(this.f12425b);
                this.f12446y.postDelayed(this.f12425b, 100);
                if (this.f12433l.getVisibility() == 0) {
                    this.f12433l.setVisibility(8);
                }
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i2;
        int i3;
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f12423c || window != null) {
            window.setGravity(17);
            create.show();
            int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
            if (width >= height) {
                i3 = (width / 3) * 2;
                i2 = height * 4;
            } else {
                i3 = (width * 4) / 5;
                i2 = height * 2;
            }
            window.setLayout(i3, i2 / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.servo_check_dlg, viewGroup, false);
        XEagleApp xEagleApp = (XEagleApp) this.f12436o.getApplicationContext();
        this.f12437p = xEagleApp;
        this.f12438q = xEagleApp.k();
        a(inflate);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        if (c.a().b(this)) {
            c.a().c(this);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void rcOutEvent(av avVar) {
        if (avVar.a() == 18 && this.f12439r) {
            a aVar = this.f12438q;
            if (aVar == null || aVar.m() == null) {
                int[] iArr = new int[4];
                this.f12440s = iArr;
                Arrays.fill(iArr, 0);
            } else {
                this.f12440s = this.f12438q.m().a();
            }
            this.f12441t.add(Integer.valueOf(this.f12440s[0]));
            this.f12442u.add(Integer.valueOf(this.f12440s[1]));
            this.f12443v.add(Integer.valueOf(this.f12440s[2]));
            this.f12444w.add(Integer.valueOf(this.f12440s[3]));
            TextView textView = this.f12427f;
            textView.setText("右前:" + this.f12440s[0]);
            TextView textView2 = this.f12428g;
            textView2.setText("左后:" + this.f12440s[1]);
            TextView textView3 = this.f12429h;
            textView3.setText("左前:" + this.f12440s[2]);
            TextView textView4 = this.f12430i;
            textView4.setText("右后:" + this.f12440s[3]);
        }
    }
}
