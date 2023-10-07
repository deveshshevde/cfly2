package com.xeagle.android.proxy.updateFirmware;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class UploadFirmwareActivity extends SuperUI implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextView f12757a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f12758b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f12759c;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public TextView f12760k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public IButton f12761l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public FirmwareManager f12762m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public TextView f12763n;

    private void a() {
        this.f12762m = FirmwareManager.a(getApplicationContext(), this.f12358g);
        this.f12757a = (TextView) findViewById(R.id.notify_title);
        this.f12758b = (ProgressBar) findViewById(R.id.upload_pb);
        this.f12759c = (TextView) findViewById(R.id.upload_progress);
        this.f12760k = (TextView) findViewById(R.id.upload_pb_total);
        this.f12761l = (IButton) findViewById(R.id.ib_complete);
        this.f12763n = (TextView) findViewById(R.id.upload_txt_warn);
        runOnUiThread(new Runnable() {
            public void run() {
                UploadFirmwareActivity.this.f12761l.setText(UploadFirmwareActivity.this.getString(R.string.upload_txt_uploading));
                UploadFirmwareActivity.this.f12761l.setVisibility(8);
                UploadFirmwareActivity.this.f12758b.setVisibility(4);
                UploadFirmwareActivity.this.f12760k.setVisibility(4);
                UploadFirmwareActivity.this.f12759c.setVisibility(4);
                UploadFirmwareActivity.this.f12763n.setVisibility(8);
            }
        });
        this.f12761l.setOnClickListener(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009a, code lost:
        if (r3 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (r3 != null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r3) {
        /*
            r2 = this;
            int r3 = r3.getId()
            r0 = 2131297394(0x7f090472, float:1.8212732E38)
            if (r3 == r0) goto L_0x000b
            goto L_0x009d
        L_0x000b:
            com.xeagle.android.vjoystick.IWidgets.IButton r3 = r2.f12761l
            java.lang.CharSequence r3 = r3.getText()
            r0 = 2131823075(0x7f1109e3, float:1.927894E38)
            java.lang.String r0 = r2.getString(r0)
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x002c
            com.xeagle.android.proxy.updateFirmware.FirmwareManager r3 = r2.f12762m
            if (r3 == 0) goto L_0x0025
        L_0x0022:
            r3.a()
        L_0x0025:
            r2.finish()
            r2.i()
            goto L_0x009d
        L_0x002c:
            com.xeagle.android.vjoystick.IWidgets.IButton r3 = r2.f12761l
            java.lang.CharSequence r3 = r3.getText()
            r0 = 2131823076(0x7f1109e4, float:1.9278941E38)
            java.lang.String r0 = r2.getString(r0)
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0085
            com.xeagle.android.proxy.updateFirmware.FirmwareManager r3 = r2.f12762m
            if (r3 == 0) goto L_0x0046
            r3.a()
        L_0x0046:
            com.xeagle.android.XEagleApp r3 = new com.xeagle.android.XEagleApp
            r3.<init>()
            r3.onCreate()
            r0 = 100
            android.os.SystemClock.sleep(r0)
            en.a r3 = r2.f12358g
            com.flypro.core.MAVLink.r.a(r3)
            r0 = 20
            android.os.SystemClock.sleep(r0)
            en.a r3 = r2.f12358g
            com.flypro.core.MAVLink.r.a(r3)
            com.xeagle.android.utils.prefs.a r3 = r2.f12360i
            r0 = 1
            r3.j((boolean) r0)
            r2.i()
            r0 = 300(0x12c, double:1.48E-321)
            android.os.SystemClock.sleep(r0)
            android.content.Context r3 = r2.getApplicationContext()
            en.a r0 = r2.f12358g
            com.xeagle.android.proxy.updateFirmware.FirmwareManager r3 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.a((android.content.Context) r3, (en.a) r0)
            r2.f12762m = r3
            com.xeagle.android.proxy.updateFirmware.UploadFirmwareActivity$5 r3 = new com.xeagle.android.proxy.updateFirmware.UploadFirmwareActivity$5
            r3.<init>()
            r2.runOnUiThread(r3)
            goto L_0x009d
        L_0x0085:
            com.xeagle.android.vjoystick.IWidgets.IButton r3 = r2.f12761l
            java.lang.CharSequence r3 = r3.getText()
            r0 = 2131823082(0x7f1109ea, float:1.9278954E38)
            java.lang.String r0 = r2.getString(r0)
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x009d
            com.xeagle.android.proxy.updateFirmware.FirmwareManager r3 = r2.f12762m
            if (r3 == 0) goto L_0x0025
            goto L_0x0022
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.proxy.updateFirmware.UploadFirmwareActivity.onClick(android.view.View):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.upload_firmware_activity);
        a();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.f12761l.getText().equals(getString(R.string.upload_txt_btn_complete)) || this.f12761l.getText().equals(getString(R.string.upload_txt_quit)) || this.f12761l.getText().equals(getString(R.string.upload_txt_btn_retry))) {
            FirmwareManager firmwareManager = this.f12762m;
            if (firmwareManager != null) {
                firmwareManager.a();
            }
            finish();
            i();
            return true;
        }
        c a2 = r.a().a(getString(R.string.warning), getString(R.string.upload_back_warn), (c.a) new c.a() {
            public void onYes() {
            }
        });
        if (a2 == null) {
            return true;
        }
        a2.show(getSupportFragmentManager(), "upload_warning");
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        runOnUiThread(new Runnable() {
            public void run() {
                if (UploadFirmwareActivity.this.f12760k != null && UploadFirmwareActivity.this.f12762m != null) {
                    TextView a2 = UploadFirmwareActivity.this.f12760k;
                    a2.setText("/" + UploadFirmwareActivity.this.f12762m.f24229a);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x015d, code lost:
        r0 = getString(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x01a3, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x01a7, code lost:
        r8.setText(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadFirmwareEvent(jo.bb r8) {
        /*
            r7 = this;
            int r0 = r8.a()
            r1 = 2131823076(0x7f1109e4, float:1.9278941E38)
            r2 = 2131823080(0x7f1109e8, float:1.927895E38)
            r3 = 1
            r4 = 4
            r5 = 0
            switch(r0) {
                case 111: goto L_0x0162;
                case 112: goto L_0x0010;
                case 113: goto L_0x0158;
                case 114: goto L_0x00db;
                case 115: goto L_0x0098;
                case 116: goto L_0x0091;
                case 117: goto L_0x0045;
                case 118: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x01aa
        L_0x0012:
            android.widget.TextView r8 = r7.f12757a
            r0 = 2131823081(0x7f1109e9, float:1.9278952E38)
            java.lang.String r0 = r7.getString(r0)
            r8.setText(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = r7.f12761l
            r0 = 2131823082(0x7f1109ea, float:1.9278954E38)
            java.lang.String r0 = r7.getString(r0)
            r8.setText(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = r7.f12761l
            r8.setVisibility(r5)
            android.widget.ProgressBar r8 = r7.f12758b
            r8.setVisibility(r4)
            android.widget.TextView r8 = r7.f12760k
            r8.setVisibility(r4)
            android.widget.TextView r8 = r7.f12759c
            r8.setVisibility(r4)
            android.widget.TextView r8 = r7.f12763n
            r8.setVisibility(r5)
            goto L_0x01aa
        L_0x0045:
            android.widget.TextView r8 = r7.f12757a
            java.lang.String r0 = r7.getString(r2)
            r8.setText(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = r7.f12761l
            java.lang.String r0 = r7.getString(r1)
            r8.setText(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = r7.f12761l
            r8.setVisibility(r5)
            com.xeagle.android.utils.prefs.a r8 = r7.f12360i
            r8.j((boolean) r5)
            r0 = 10
            android.os.SystemClock.sleep(r0)
            r7.i()
            com.xeagle.android.dialogs.r r8 = com.xeagle.android.dialogs.r.a()
            r0 = 2131821035(0x7f1101eb, float:1.9274802E38)
            java.lang.String r0 = r7.getString(r0)
            r1 = 2131823065(0x7f1109d9, float:1.927892E38)
            java.lang.String r1 = r7.getString(r1)
            com.xeagle.android.proxy.updateFirmware.UploadFirmwareActivity$3 r2 = new com.xeagle.android.proxy.updateFirmware.UploadFirmwareActivity$3
            r2.<init>()
            com.xeagle.android.dialogs.c r8 = r8.a((java.lang.String) r0, (java.lang.String) r1, (com.xeagle.android.dialogs.c.a) r2)
            if (r8 == 0) goto L_0x01aa
            androidx.fragment.app.FragmentManager r0 = r7.getSupportFragmentManager()
            java.lang.String r1 = "fail_tips"
            r8.show(r0, r1)
            goto L_0x01aa
        L_0x0091:
            android.widget.TextView r8 = r7.f12757a
            r0 = 2131823083(0x7f1109eb, float:1.9278956E38)
            goto L_0x015d
        L_0x0098:
            int r8 = r8.b()
            if (r8 != r3) goto L_0x00c2
            android.widget.TextView r8 = r7.f12757a
            r0 = 2131823077(0x7f1109e5, float:1.9278943E38)
            java.lang.String r0 = r7.getString(r0)
            r8.setText(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = r7.f12761l
            r8.setVisibility(r5)
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = r7.f12761l
            r0 = 2131823075(0x7f1109e3, float:1.927894E38)
            java.lang.String r0 = r7.getString(r0)
            r8.setText(r0)
            com.xeagle.android.utils.prefs.a r8 = r7.f12360i
            r8.j((boolean) r5)
            goto L_0x01aa
        L_0x00c2:
            android.widget.TextView r8 = r7.f12757a
            java.lang.String r0 = r7.getString(r2)
            r8.setText(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = r7.f12761l
            java.lang.String r0 = r7.getString(r1)
            r8.setText(r0)
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = r7.f12761l
            r8.setVisibility(r5)
            goto L_0x01aa
        L_0x00db:
            android.widget.ProgressBar r0 = r7.f12758b
            int r0 = r0.getVisibility()
            if (r0 != r4) goto L_0x00f2
            android.widget.ProgressBar r0 = r7.f12758b
            r0.setVisibility(r5)
            android.widget.TextView r0 = r7.f12760k
            r0.setVisibility(r5)
            android.widget.TextView r0 = r7.f12759c
            r0.setVisibility(r5)
        L_0x00f2:
            android.widget.TextView r0 = r7.f12757a
            r1 = 2131823087(0x7f1109ef, float:1.9278964E38)
            java.lang.String r1 = r7.getString(r1)
            r0.setText(r1)
            android.widget.ProgressBar r0 = r7.f12758b
            int r1 = r8.b()
            int r1 = r1 + r3
            int r1 = r1 * 96
            double r1 = (double) r1
            com.xeagle.android.proxy.updateFirmware.FirmwareManager r4 = r7.f12762m
            double r4 = r4.f24229a
            java.lang.Double.isNaN(r1)
            double r1 = r1 / r4
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r1 = r1 * r4
            int r1 = (int) r1
            r0.setProgress(r1)
            int r0 = r8.b()
            int r0 = r0 + r3
            int r0 = r0 * 96
            double r0 = (double) r0
            com.xeagle.android.proxy.updateFirmware.FirmwareManager r2 = r7.f12762m
            double r4 = r2.f24229a
            java.lang.String r2 = ""
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x013c
            android.widget.TextView r8 = r7.f12759c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.xeagle.android.proxy.updateFirmware.FirmwareManager r1 = r7.f12762m
            double r3 = r1.f24229a
            r0.append(r3)
            r0.append(r2)
            goto L_0x01a3
        L_0x013c:
            android.widget.TextView r0 = r7.f12759c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r8 = r8.b()
            int r8 = r8 + r3
            int r8 = r8 * 96
            r1.append(r8)
            r1.append(r2)
            java.lang.String r8 = r1.toString()
            r0.setText(r8)
            goto L_0x01aa
        L_0x0158:
            android.widget.TextView r8 = r7.f12757a
            r0 = 2131823078(0x7f1109e6, float:1.9278946E38)
        L_0x015d:
            java.lang.String r0 = r7.getString(r0)
            goto L_0x01a7
        L_0x0162:
            android.widget.TextView r8 = r7.f12757a
            r0 = 2131823085(0x7f1109ed, float:1.927896E38)
            java.lang.String r0 = r7.getString(r0)
            r8.setText(r0)
            android.widget.ProgressBar r8 = r7.f12758b
            r8.setVisibility(r5)
            android.widget.ProgressBar r8 = r7.f12758b
            r0 = 100
            r8.setMax(r0)
            android.widget.ProgressBar r8 = r7.f12758b
            r8.setProgress(r5)
            android.widget.TextView r8 = r7.f12759c
            r8.setVisibility(r5)
            android.widget.TextView r8 = r7.f12760k
            r8.setVisibility(r5)
            android.widget.TextView r8 = r7.f12759c
            java.lang.String r0 = "0"
            r8.setText(r0)
            android.widget.TextView r8 = r7.f12760k
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "/"
            r0.append(r1)
            com.xeagle.android.proxy.updateFirmware.FirmwareManager r1 = r7.f12762m
            double r1 = r1.f24229a
            r0.append(r1)
        L_0x01a3:
            java.lang.String r0 = r0.toString()
        L_0x01a7:
            r8.setText(r0)
        L_0x01aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.proxy.updateFirmware.UploadFirmwareActivity.uploadFirmwareEvent(jo.bb):void");
    }
}
