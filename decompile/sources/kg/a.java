package kg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.c;
import com.blankj.utilcode.constant.PermissionConstants;
import com.cfly.uav_pro.R;
import com.xeagle.android.hicamera.unity.a;
import com.xeagle.android.hicamera.wifi.WifiDisconnectReceiver;
import com.xeagle.android.widgets.button.SwitchButton;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import kf.b;

public class a extends c implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private TextView A;
    /* access modifiers changed from: private */
    public TextView B;
    private String[] C;
    /* access modifiers changed from: private */
    public String[] D;
    /* access modifiers changed from: private */
    public String[] E;
    private String[] F;
    private String[] G;
    /* access modifiers changed from: private */
    public String[] H;
    /* access modifiers changed from: private */
    public String[] I;
    /* access modifiers changed from: private */
    public String[] J;
    /* access modifiers changed from: private */
    public String[] K;
    /* access modifiers changed from: private */
    public String[] L;
    private WifiDisconnectReceiver M;
    private C0208a N = null;

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog f30005a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f30006b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public SeekBar f30007c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public SeekBar f30008d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public SeekBar f30009e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public SeekBar f30010f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public SeekBar f30011g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public SeekBar f30012h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public SeekBar f30013i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public SwitchButton f30014j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public SwitchButton f30015k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public SwitchButton f30016l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public SwitchButton f30017m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Boolean f30018n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public Boolean f30019o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Boolean f30020p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public Boolean f30021q;

    /* renamed from: r  reason: collision with root package name */
    private Button f30022r;

    /* renamed from: s  reason: collision with root package name */
    private Button f30023s;

    /* renamed from: t  reason: collision with root package name */
    private Button f30024t;

    /* renamed from: u  reason: collision with root package name */
    private Button f30025u;

    /* renamed from: v  reason: collision with root package name */
    private Button f30026v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f30027w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f30028x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f30029y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f30030z;

    /* renamed from: kg.a$a  reason: collision with other inner class name */
    static class C0208a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final int[] f30068a = {R.string.event_normal, R.string.event_record_space_full, R.string.event_record_error, R.string.event_snapshot_space_full, R.string.event_snapshot_error, R.string.event_sdcard_not_exist, R.string.event_sdcard_error, R.string.event_chip_temperature_high, R.string.event_battery_temperature_high, R.string.event_low_power, R.string.event_usb_connected, R.string.event_shutdown, R.string.event_usb_disconnected, R.string.event_chip_temperature_alarm, R.string.event_battery_temperature_alarm, R.string.event_low_power_alarm, R.string.event_sdcard_mounted, R.string.event_ac_on, R.string.event_ac_off};

        C0208a() {
        }

        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("event", -1);
            if (intExtra > 0 && intExtra < 19 && intExtra != 16) {
                Toast.makeText(context, this.f30068a[intExtra], 0).show();
            }
        }
    }

    private void a() {
        if (getActivity() != null) {
            TreeMap treeMap = new TreeMap();
            int i2 = 1;
            final int i3 = 0;
            if (b.f30003b.a((Map<String, String>) treeMap) == 0) {
                String str = (String) treeMap.get("resolution");
                String str2 = (String) treeMap.get("fps");
                if (!str.equals("4K2K") || (!str2.equals("30") && !str2.equals("25"))) {
                    if (!str.equals("1080P") || !str2.equals("120")) {
                        if (str.equals("1080P") && (str2.equals("60") || str2.equals("50"))) {
                            i2 = 2;
                        }
                    }
                    b.f30003b.f29999h.f23777z = str;
                    b.f30003b.f29999h.f23753b = str2;
                    i3 = i2;
                }
                i2 = 0;
                b.f30003b.f29999h.f23777z = str;
                b.f30003b.f29999h.f23753b = str2;
                i3 = i2;
            } else {
                Toast.makeText(getActivity(), "请确认是否连接相机", 1).show();
            }
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    a aVar = a.this;
                    aVar.a(aVar.f30007c, i3, a.this.E.length);
                }
            });
        }
    }

    private void a(int i2) {
        String str;
        com.xeagle.android.hicamera.unity.c cVar;
        String h2 = b.f30003b.h();
        Log.i(PermissionConstants.CAMERA, "DV:" + h2);
        if (h2.equals("NTSC")) {
            if (b.f30003b.a(this.E[i2], Integer.parseInt(this.F[i2])) == 0) {
                b.f30003b.f29999h.f23752a = this.E[i2];
                cVar = b.f30003b.f29999h;
                str = this.F[i2];
            } else {
                return;
            }
        } else if (h2.equals("PAL") && b.f30003b.a(this.G[i2], Integer.parseInt(this.C[i2])) == 0) {
            b.f30003b.f29999h.f23752a = this.G[i2];
            cVar = b.f30003b.f29999h;
            str = this.C[i2];
        } else {
            return;
        }
        cVar.f23753b = str;
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        this.E = getActivity().getResources().getStringArray(R.array.video_resolution_values_ntsc_117);
        this.F = getActivity().getResources().getStringArray(R.array.video_fps_value_ntsc_117);
        this.G = getActivity().getResources().getStringArray(R.array.video_resolution_values_pal_117);
        this.H = getActivity().getResources().getStringArray(R.array.video_mode_values);
        this.I = getActivity().getResources().getStringArray(R.array.burst_rate_values);
        this.J = getActivity().getResources().getStringArray(R.array.timer_count_down_values);
        this.K = getActivity().getResources().getStringArray(R.array.video_timelapse_interval_values);
        this.L = getActivity().getResources().getStringArray(R.array.timelapse_interval_values);
        this.D = getActivity().getResources().getStringArray(R.array.boot_action_values);
        this.C = getActivity().getResources().getStringArray(R.array.video_fps_value_pal_117);
        this.f30007c = (SeekBar) view.findViewById(R.id.seek_record_resolution);
        this.f30008d = (SeekBar) view.findViewById(R.id.seek_tv_format);
        this.f30009e = (SeekBar) view.findViewById(R.id.seek_burst_capture);
        this.f30010f = (SeekBar) view.findViewById(R.id.seek_timer_capture);
        this.f30011g = (SeekBar) view.findViewById(R.id.seek_timelapse_capture);
        this.f30012h = (SeekBar) view.findViewById(R.id.seek_time_lapse);
        this.f30013i = (SeekBar) view.findViewById(R.id.seek_open_operate);
        this.f30014j = (SwitchButton) view.findViewById(R.id.camera_audio);
        this.f30015k = (SwitchButton) view.findViewById(R.id.camera_rotate);
        this.f30016l = (SwitchButton) view.findViewById(R.id.camera_time_osd);
        this.f30017m = (SwitchButton) view.findViewById(R.id.camera_led);
        this.f30022r = (Button) view.findViewById(R.id.camera_name_btn);
        this.f30023s = (Button) view.findViewById(R.id.camera_psd_btn);
        this.f30024t = (Button) view.findViewById(R.id.set_time);
        this.f30025u = (Button) view.findViewById(R.id.format_sd);
        this.f30026v = (Button) view.findViewById(R.id.system_default_set);
        this.f30027w = (TextView) view.findViewById(R.id.camera_name_et);
        this.f30028x = (TextView) view.findViewById(R.id.camera_psd_et);
        this.f30029y = (TextView) view.findViewById(R.id.video_fps1);
        this.f30030z = (TextView) view.findViewById(R.id.video_fps2);
        this.A = (TextView) view.findViewById(R.id.video_fps3);
        this.B = (TextView) view.findViewById(R.id.sd_remain);
        this.f30007c.setOnSeekBarChangeListener(this);
        this.f30008d.setOnSeekBarChangeListener(this);
        this.f30009e.setOnSeekBarChangeListener(this);
        this.f30011g.setOnSeekBarChangeListener(this);
        this.f30010f.setOnSeekBarChangeListener(this);
        this.f30012h.setOnSeekBarChangeListener(this);
        this.f30013i.setOnSeekBarChangeListener(this);
        this.f30022r.setOnClickListener(this);
        this.f30023s.setOnClickListener(this);
        this.f30024t.setOnClickListener(this);
        this.f30025u.setOnClickListener(this);
        this.f30026v.setOnClickListener(this);
        this.f30014j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                new Thread(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
                        if (r0 == 0) goto L_0x0022;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
                        if (r0 == 0) goto L_0x0022;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r3 = this;
                            kg.a$1 r0 = kg.a.AnonymousClass1.this
                            kg.a r0 = kg.a.this
                            java.lang.Boolean r0 = r0.f30018n
                            if (r0 != 0) goto L_0x000b
                            return
                        L_0x000b:
                            kg.a$1 r0 = kg.a.AnonymousClass1.this
                            kg.a r0 = kg.a.this
                            java.lang.Boolean r0 = r0.f30018n
                            boolean r0 = r0.booleanValue()
                            if (r0 == 0) goto L_0x002e
                            kf.a r0 = kf.b.f30003b
                            r1 = 0
                            int r0 = r0.b((boolean) r1)
                            if (r0 != 0) goto L_0x0038
                        L_0x0022:
                            kg.a$1 r2 = kg.a.AnonymousClass1.this
                            kg.a r2 = kg.a.this
                            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                            java.lang.Boolean unused = r2.f30018n = r1
                            goto L_0x0038
                        L_0x002e:
                            kf.a r0 = kf.b.f30003b
                            r1 = 1
                            int r0 = r0.b((boolean) r1)
                            if (r0 != 0) goto L_0x0038
                            goto L_0x0022
                        L_0x0038:
                            kf.a r1 = kf.b.f30003b
                            com.xeagle.android.hicamera.unity.c r1 = r1.f29999h
                            kg.a$1 r2 = kg.a.AnonymousClass1.this
                            kg.a r2 = kg.a.this
                            java.lang.Boolean r2 = r2.f30018n
                            boolean r2 = r2.booleanValue()
                            r1.f23770s = r2
                            if (r0 == 0) goto L_0x0053
                            java.lang.String r0 = "CAMERA"
                            java.lang.String r1 = "音频编码设置失败"
                            android.util.Log.i(r0, r1)
                        L_0x0053:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kg.a.AnonymousClass1.AnonymousClass1.run():void");
                    }
                }).start();
            }
        });
        this.f30015k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                new Thread(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
                        if (r0 == 0) goto L_0x0022;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
                        if (r0 == 0) goto L_0x0022;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r3 = this;
                            kg.a$10 r0 = kg.a.AnonymousClass10.this
                            kg.a r0 = kg.a.this
                            java.lang.Boolean r0 = r0.f30019o
                            if (r0 != 0) goto L_0x000b
                            return
                        L_0x000b:
                            kg.a$10 r0 = kg.a.AnonymousClass10.this
                            kg.a r0 = kg.a.this
                            java.lang.Boolean r0 = r0.f30019o
                            boolean r0 = r0.booleanValue()
                            if (r0 == 0) goto L_0x002e
                            kf.a r0 = kf.b.f30003b
                            r1 = 0
                            int r0 = r0.a((boolean) r1)
                            if (r0 != 0) goto L_0x0038
                        L_0x0022:
                            kg.a$10 r2 = kg.a.AnonymousClass10.this
                            kg.a r2 = kg.a.this
                            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                            java.lang.Boolean unused = r2.f30019o = r1
                            goto L_0x0038
                        L_0x002e:
                            kf.a r0 = kf.b.f30003b
                            r1 = 1
                            int r0 = r0.a((boolean) r1)
                            if (r0 != 0) goto L_0x0038
                            goto L_0x0022
                        L_0x0038:
                            if (r0 == 0) goto L_0x0041
                            java.lang.String r0 = "CAMERA"
                            java.lang.String r1 = "图像翻转设置失败"
                            android.util.Log.i(r0, r1)
                        L_0x0041:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kg.a.AnonymousClass10.AnonymousClass1.run():void");
                    }
                }).start();
            }
        });
        this.f30016l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                new Thread(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
                        if (r0 == 0) goto L_0x0022;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
                        if (r0 == 0) goto L_0x0022;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r3 = this;
                            kg.a$11 r0 = kg.a.AnonymousClass11.this
                            kg.a r0 = kg.a.this
                            java.lang.Boolean r0 = r0.f30020p
                            if (r0 != 0) goto L_0x000b
                            return
                        L_0x000b:
                            kg.a$11 r0 = kg.a.AnonymousClass11.this
                            kg.a r0 = kg.a.this
                            java.lang.Boolean r0 = r0.f30020p
                            boolean r0 = r0.booleanValue()
                            if (r0 == 0) goto L_0x002e
                            kf.a r0 = kf.b.f30003b
                            r1 = 0
                            int r0 = r0.c((boolean) r1)
                            if (r0 != 0) goto L_0x0038
                        L_0x0022:
                            kg.a$11 r2 = kg.a.AnonymousClass11.this
                            kg.a r2 = kg.a.this
                            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                            java.lang.Boolean unused = r2.f30020p = r1
                            goto L_0x0038
                        L_0x002e:
                            kf.a r0 = kf.b.f30003b
                            r1 = 1
                            int r0 = r0.c((boolean) r1)
                            if (r0 != 0) goto L_0x0038
                            goto L_0x0022
                        L_0x0038:
                            kf.a r1 = kf.b.f30003b
                            com.xeagle.android.hicamera.unity.c r1 = r1.f29999h
                            kg.a$11 r2 = kg.a.AnonymousClass11.this
                            kg.a r2 = kg.a.this
                            java.lang.Boolean r2 = r2.f30020p
                            boolean r2 = r2.booleanValue()
                            r1.f23774w = r2
                            if (r0 == 0) goto L_0x0053
                            java.lang.String r0 = "CAMERA"
                            java.lang.String r1 = "日期显示设置失败"
                            android.util.Log.i(r0, r1)
                        L_0x0053:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kg.a.AnonymousClass11.AnonymousClass1.run():void");
                    }
                }).start();
            }
        });
        this.f30017m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                new Thread(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
                        if (r0 == 0) goto L_0x0022;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
                        if (r0 == 0) goto L_0x0022;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r3 = this;
                            kg.a$12 r0 = kg.a.AnonymousClass12.this
                            kg.a r0 = kg.a.this
                            java.lang.Boolean r0 = r0.f30021q
                            if (r0 != 0) goto L_0x000b
                            return
                        L_0x000b:
                            kg.a$12 r0 = kg.a.AnonymousClass12.this
                            kg.a r0 = kg.a.this
                            java.lang.Boolean r0 = r0.f30021q
                            boolean r0 = r0.booleanValue()
                            if (r0 == 0) goto L_0x002e
                            kf.a r0 = kf.b.f30003b
                            r1 = 0
                            int r0 = r0.d(r1)
                            if (r0 != 0) goto L_0x0038
                        L_0x0022:
                            kg.a$12 r2 = kg.a.AnonymousClass12.this
                            kg.a r2 = kg.a.this
                            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                            java.lang.Boolean unused = r2.f30021q = r1
                            goto L_0x0038
                        L_0x002e:
                            kf.a r0 = kf.b.f30003b
                            r1 = 1
                            int r0 = r0.d(r1)
                            if (r0 != 0) goto L_0x0038
                            goto L_0x0022
                        L_0x0038:
                            kf.a r1 = kf.b.f30003b
                            com.xeagle.android.hicamera.unity.c r1 = r1.f29999h
                            kg.a$12 r2 = kg.a.AnonymousClass12.this
                            kg.a r2 = kg.a.this
                            java.lang.Boolean r2 = r2.f30021q
                            boolean r2 = r2.booleanValue()
                            r1.f23775x = r2
                            if (r0 == 0) goto L_0x0053
                            java.lang.String r0 = "CAMERA"
                            java.lang.String r1 = "LED提示设置失败"
                            android.util.Log.i(r0, r1)
                        L_0x0053:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kg.a.AnonymousClass12.AnonymousClass1.run():void");
                    }
                }).start();
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
        if (r10 == 1) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.widget.SeekBar r9, int r10, int r11) {
        /*
            r8 = this;
            r0 = 4
            r1 = 100
            r2 = 2
            r3 = 1
            r4 = 0
            if (r11 != r0) goto L_0x0021
            if (r10 != 0) goto L_0x000f
        L_0x000a:
            r9.setProgress(r4)
            goto L_0x0067
        L_0x000f:
            if (r10 != r3) goto L_0x0018
            r10 = 33
        L_0x0013:
            r9.setProgress(r10)
            goto L_0x0067
        L_0x0018:
            if (r10 != r2) goto L_0x001d
            r10 = 67
            goto L_0x0013
        L_0x001d:
            r9.setProgress(r1)
            goto L_0x0067
        L_0x0021:
            r5 = 6
            r6 = 5
            r7 = 3
            if (r11 < r5) goto L_0x0040
            if (r10 != 0) goto L_0x0029
            goto L_0x000a
        L_0x0029:
            if (r10 != r3) goto L_0x002e
            r10 = 20
            goto L_0x0013
        L_0x002e:
            if (r10 != r2) goto L_0x0033
            r10 = 40
            goto L_0x0013
        L_0x0033:
            if (r10 != r7) goto L_0x0038
            r10 = 60
            goto L_0x0013
        L_0x0038:
            if (r10 != r0) goto L_0x003d
            r10 = 80
            goto L_0x0013
        L_0x003d:
            if (r10 != r6) goto L_0x0067
            goto L_0x001d
        L_0x0040:
            r0 = 50
            if (r11 != r6) goto L_0x0054
            if (r10 != 0) goto L_0x0047
            goto L_0x000a
        L_0x0047:
            if (r10 != r3) goto L_0x004c
            r10 = 25
            goto L_0x0013
        L_0x004c:
            if (r10 != r2) goto L_0x004f
            goto L_0x005b
        L_0x004f:
            if (r10 != r7) goto L_0x001d
            r10 = 75
            goto L_0x0013
        L_0x0054:
            if (r11 != r7) goto L_0x005f
            if (r10 != 0) goto L_0x0059
            goto L_0x000a
        L_0x0059:
            if (r10 != r3) goto L_0x001d
        L_0x005b:
            r9.setProgress(r0)
            goto L_0x0067
        L_0x005f:
            if (r11 != r2) goto L_0x0067
            if (r10 != 0) goto L_0x0064
            goto L_0x000a
        L_0x0064:
            r10 = 46
            goto L_0x0013
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kg.a.a(android.widget.SeekBar, int, int):void");
    }

    private void b() {
        String h2;
        if (getActivity() != null && (h2 = b.f30003b.h()) != null) {
            final int i2 = 1;
            if (h2.equals("NTSC")) {
                this.f30029y.setText("4K_30fps");
                this.f30030z.setText("1080_120fps");
                this.A.setText("1080_60fps");
                b.f30003b.f29999h.f23755d = h2;
            } else if (h2.equals("PAL")) {
                this.f30029y.setText("4K_25fps");
                this.f30030z.setText("1080_120fps");
                this.A.setText("1080_50fps");
                b.f30003b.f29999h.f23755d = h2;
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        a aVar = a.this;
                        aVar.a(aVar.f30008d, i2, a.this.H.length);
                    }
                });
            } else {
                Toast.makeText(getActivity(), "请确认是否连接相机", 1).show();
            }
            i2 = 0;
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    a aVar = a.this;
                    aVar.a(aVar.f30008d, i2, a.this.H.length);
                }
            });
        }
    }

    private void b(int i2) {
        if (b.f30003b.c(this.H[i2]) == 0) {
            b.f30003b.f29999h.f23755d = this.H[i2];
        }
    }

    private void c() {
        if (getActivity() != null) {
            TreeMap treeMap = new TreeMap();
            final int i2 = 1;
            if (b.f30003b.b((Map<String, Integer>) treeMap) == 0) {
                Integer num = (Integer) treeMap.get("time");
                Integer num2 = (Integer) treeMap.get("count");
                if (num2 != null && num != null) {
                    b.f30003b.f29999h.f23756e = num.intValue();
                    b.f30003b.f29999h.f23757f = num2.intValue();
                    if (num2.intValue() != 3) {
                        if (num2.intValue() != 5) {
                            if (num2.intValue() == 6) {
                                i2 = 2;
                            }
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                a aVar = a.this;
                                aVar.a(aVar.f30009e, i2, a.this.I.length);
                            }
                        });
                    }
                } else {
                    return;
                }
            } else {
                Toast.makeText(getActivity(), "请确认是否连接相机", 1).show();
            }
            i2 = 0;
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    a aVar = a.this;
                    aVar.a(aVar.f30009e, i2, a.this.I.length);
                }
            });
        }
    }

    private void c(int i2) {
        if (b.f30003b.a(1, Integer.parseInt(this.I[i2])) == 0) {
            b.f30003b.f29999h.f23757f = Integer.parseInt(this.I[i2]);
            b.f30003b.f29999h.f23756e = 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r0 == 60) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r5 = this;
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            kf.a r0 = kf.b.f30003b
            int r0 = r0.c()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            if (r1 != 0) goto L_0x0014
            return
        L_0x0014:
            r1 = 5
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 != r3) goto L_0x001c
        L_0x001a:
            r1 = 0
            goto L_0x0034
        L_0x001c:
            if (r0 != r2) goto L_0x0020
            r1 = 1
            goto L_0x0034
        L_0x0020:
            if (r0 != r1) goto L_0x0024
            r1 = 2
            goto L_0x0034
        L_0x0024:
            r3 = 10
            if (r0 != r3) goto L_0x002a
            r1 = 3
            goto L_0x0034
        L_0x002a:
            r2 = 30
            if (r0 != r2) goto L_0x0030
            r1 = 4
            goto L_0x0034
        L_0x0030:
            r2 = 60
            if (r0 != r2) goto L_0x001a
        L_0x0034:
            kf.a r2 = kf.b.f30003b
            com.xeagle.android.hicamera.unity.c r2 = r2.f29999h
            r2.f23758g = r0
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            kg.a$16 r2 = new kg.a$16
            r2.<init>(r1)
            r0.runOnUiThread(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kg.a.d():void");
    }

    private void d(int i2) {
        if (b.f30003b.b(Integer.parseInt(this.J[i2])) == 0) {
            b.f30003b.f29999h.f23759h = Integer.parseInt(this.J[i2]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r0 == 60) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r5 = this;
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            kf.a r0 = kf.b.f30003b
            int r0 = r0.e()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            if (r1 != 0) goto L_0x0014
            return
        L_0x0014:
            r1 = 5
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 != r3) goto L_0x001c
        L_0x001a:
            r1 = 0
            goto L_0x0034
        L_0x001c:
            if (r0 != r2) goto L_0x0020
            r1 = 1
            goto L_0x0034
        L_0x0020:
            if (r0 != r1) goto L_0x0024
            r1 = 2
            goto L_0x0034
        L_0x0024:
            r3 = 10
            if (r0 != r3) goto L_0x002a
            r1 = 3
            goto L_0x0034
        L_0x002a:
            r2 = 30
            if (r0 != r2) goto L_0x0030
            r1 = 4
            goto L_0x0034
        L_0x0030:
            r2 = 60
            if (r0 != r2) goto L_0x001a
        L_0x0034:
            kf.a r2 = kf.b.f30003b
            com.xeagle.android.hicamera.unity.c r2 = r2.f29999h
            r2.f23760i = r0
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            kg.a$17 r2 = new kg.a$17
            r2.<init>(r1)
            r0.runOnUiThread(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kg.a.e():void");
    }

    private void e(int i2) {
        if (b.f30003b.a(Integer.parseInt(this.L[i2])) == 0) {
            b.f30003b.f29999h.f23758g = Integer.parseInt(this.L[i2]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r0 == 60) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f() {
        /*
            r5 = this;
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            kf.a r0 = kf.b.f30003b
            int r0 = r0.d()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            if (r1 != 0) goto L_0x0014
            return
        L_0x0014:
            r1 = 5
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 != r3) goto L_0x001c
        L_0x001a:
            r1 = 0
            goto L_0x0034
        L_0x001c:
            if (r0 != r2) goto L_0x0020
            r1 = 1
            goto L_0x0034
        L_0x0020:
            if (r0 != r1) goto L_0x0024
            r1 = 2
            goto L_0x0034
        L_0x0024:
            r3 = 10
            if (r0 != r3) goto L_0x002a
            r1 = 3
            goto L_0x0034
        L_0x002a:
            r2 = 30
            if (r0 != r2) goto L_0x0030
            r1 = 4
            goto L_0x0034
        L_0x0030:
            r2 = 60
            if (r0 != r2) goto L_0x001a
        L_0x0034:
            kf.a r2 = kf.b.f30003b
            com.xeagle.android.hicamera.unity.c r2 = r2.f29999h
            r2.f23759h = r0
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            kg.a$2 r2 = new kg.a$2
            r2.<init>(r1)
            r0.runOnUiThread(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kg.a.f():void");
    }

    private void f(int i2) {
        if (b.f30003b.c(Integer.parseInt(this.K[i2])) == 0) {
            b.f30003b.f29999h.f23760i = Integer.parseInt(this.K[i2]);
        }
    }

    private void g() {
        String f2;
        if (getActivity() != null && (f2 = b.f30003b.f()) != null) {
            final int i2 = 0;
            if (!f2.equals("idle")) {
                if (f2.equals("record")) {
                    i2 = 1;
                } else if (f2.equals("timelapse")) {
                    i2 = 2;
                }
            }
            b.f30003b.f29999h.f23769r = f2;
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    a aVar = a.this;
                    aVar.a(aVar.f30013i, i2, a.this.D.length);
                }
            });
        }
    }

    private void g(int i2) {
        if (b.f30003b.b(this.D[i2]) == 0) {
            b.f30003b.f29999h.f23769r = this.D[i2];
        }
    }

    private void h() {
        if (getActivity() != null) {
            this.f30018n = b.f30003b.g();
            this.f30021q = b.f30003b.k();
            this.f30019o = b.f30003b.b();
            Boolean j2 = b.f30003b.j();
            this.f30020p = j2;
            if (this.f30018n != null && this.f30021q != null && this.f30019o != null && j2 != null) {
                b.f30003b.f29999h.f23770s = this.f30018n.booleanValue();
                b.f30003b.f29999h.f23774w = this.f30020p.booleanValue();
                b.f30003b.f29999h.f23775x = this.f30021q.booleanValue();
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        a.this.f30014j.setChecked(a.this.f30018n.booleanValue());
                        a.this.f30015k.setChecked(a.this.f30019o.booleanValue());
                        a.this.f30016l.setChecked(a.this.f30020p.booleanValue());
                        a.this.f30017m.setChecked(a.this.f30021q.booleanValue());
                    }
                });
            }
        }
    }

    private void i() {
        h();
        a();
        b();
        f();
        d();
        c();
        e();
        g();
    }

    private void j() {
        final a.c a2 = kf.c.a(b.f30003b.a());
        Log.i(PermissionConstants.CAMERA, b.f30003b.a());
        if (a2 != null) {
            if (a2.f23745a == 3 || a2.f23745a == 2) {
                Toast.makeText(getActivity(), "内存卡信息有误，请确认内存卡是否正常工作", 0).show();
            } else {
                new Thread(new Runnable() {
                    public void run() {
                        StringBuilder sb;
                        String str;
                        float f2 = (float) (a2.f23746b - a2.f23747c);
                        Log.e(PermissionConstants.CAMERA, f2 + "");
                        if (f2 >= 1024.0f) {
                            sb = new StringBuilder();
                            sb.append(new DecimalFormat("#.##").format((double) (f2 / 1024.0f)));
                            str = " GB";
                        } else {
                            sb = new StringBuilder();
                            sb.append(new DecimalFormat("#.##").format((double) f2));
                            str = " MB";
                        }
                        sb.append(str);
                        final String sb2 = sb.toString();
                        if (a.this.getActivity() != null) {
                            a.this.getActivity().runOnUiThread(new Runnable() {
                                public void run() {
                                    a.this.B.setText(sb2);
                                    a.this.B.setTextColor(Color.parseColor("#FF4081"));
                                }
                            });
                        }
                    }
                }).start();
            }
        }
    }

    public void onClick(View view) {
        FragmentActivity activity;
        String str;
        int id2 = view.getId();
        if (id2 == R.id.format_sd) {
            final a.c a2 = kf.c.a(b.f30003b.a());
            Log.i(PermissionConstants.CAMERA, b.f30003b.a());
            if (a2 != null) {
                if (a2.f23745a == 3 || a2.f23745a == 2) {
                    activity = getActivity();
                    str = "内存卡信息有误，请确认内存卡是否正常工作";
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(getString(R.string.menu_format_card));
                    builder.setMessage(getString(R.string.menu_format_message));
                    builder.setPositiveButton(getString(R.string.menu_ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            new Thread(new Runnable() {
                                public void run() {
                                    final String str;
                                    if (b.f30003b.c((Map<String, String>) new TreeMap()) == 0) {
                                        int i2 = a2.f23746b - a2.f23747c;
                                        Log.e(PermissionConstants.CAMERA, i2 + "");
                                        if (i2 >= 1024) {
                                            double d2 = (double) (i2 / 1024);
                                            str = new DecimalFormat("#.##").format(d2) + " GB";
                                        } else {
                                            str = new DecimalFormat("#.##").format((long) i2) + " MB";
                                        }
                                        if (a.this.getActivity() != null) {
                                            a.this.getActivity().runOnUiThread(new Runnable() {
                                                public void run() {
                                                    a.this.B.setText(str);
                                                    a.this.B.setTextColor(Color.parseColor("#FF4081"));
                                                }
                                            });
                                        }
                                    }
                                }
                            }).start();
                        }
                    });
                    builder.setNegativeButton(getString(R.string.video_cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    builder.show();
                    return;
                }
            } else {
                return;
            }
        } else if (id2 != R.id.set_time) {
            if (id2 == R.id.system_default_set) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                builder2.setTitle(getString(R.string.menu_system_sure));
                builder2.setPositiveButton(getString(R.string.menu_ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        new Thread(new Runnable() {
                            public void run() {
                                b.f30003b.l();
                                if (a.this.getActivity() != null) {
                                    a.this.getActivity().runOnUiThread(new Runnable() {
                                        public void run() {
                                            a.this.a(a.this.f30006b);
                                        }
                                    });
                                    a.this.getActivity().finish();
                                }
                            }
                        }).start();
                    }
                });
                builder2.setNegativeButton(getString(R.string.video_cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                builder2.show();
                return;
            }
            return;
        } else if (b.f30003b.i() == 0) {
            activity = getActivity();
            str = "相机系统时间设置成功";
        } else {
            activity = getActivity();
            str = "系统君开小差了，设置失败，请重试";
        }
        Toast.makeText(activity, str, 0).show();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        this.f30005a = create;
        create.requestWindowFeature(1);
        Window window = this.f30005a.getWindow();
        window.setGravity(17);
        this.f30005a.show();
        window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 7) / 8, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 7) / 8);
        return this.f30005a;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f30006b = layoutInflater.inflate(R.layout.hicamera_setting_fragment, viewGroup, false);
        com.xeagle.android.camera.widgets.ablum.b.b(getActivity().getApplicationContext());
        a(this.f30006b);
        i();
        return this.f30006b;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        SeekBar seekBar2 = seekBar;
        int i6 = i2;
        int id2 = seekBar.getId();
        if (id2 != R.id.seek_burst_capture) {
            if (id2 != R.id.seek_open_operate) {
                if (id2 != R.id.seek_record_resolution) {
                    switch (id2) {
                        case R.id.seek_time_lapse:
                            if (i6 >= 10 && i6 < 30) {
                                seekBar2.setProgress(20);
                                f(1);
                                return;
                            } else if (i6 >= 30 && i6 < 50) {
                                seekBar2.setProgress(40);
                                f(2);
                                return;
                            } else if (i6 < 50 || i6 >= 70) {
                                if (i6 >= 70 && i6 < 90) {
                                    seekBar2.setProgress(80);
                                    i3 = 4;
                                } else if (i6 < 90 || i6 > 100) {
                                    seekBar2.setProgress(0);
                                    f(0);
                                    return;
                                } else {
                                    seekBar2.setProgress(100);
                                    i3 = 5;
                                }
                                f(i3);
                                return;
                            } else {
                                seekBar2.setProgress(60);
                                f(3);
                                return;
                            }
                        case R.id.seek_timelapse_capture:
                            if (i6 >= 10 && i6 < 30) {
                                seekBar2.setProgress(20);
                                e(1);
                                return;
                            } else if (i6 >= 30 && i6 < 50) {
                                seekBar2.setProgress(40);
                                e(2);
                                return;
                            } else if (i6 < 50 || i6 >= 70) {
                                if (i6 >= 70 && i6 < 90) {
                                    seekBar2.setProgress(80);
                                    i4 = 4;
                                } else if (i6 < 90 || i6 > 100) {
                                    seekBar2.setProgress(0);
                                    e(0);
                                    return;
                                } else {
                                    seekBar2.setProgress(100);
                                    i4 = 5;
                                }
                                e(i4);
                                return;
                            } else {
                                seekBar2.setProgress(60);
                                e(3);
                                return;
                            }
                        case R.id.seek_timer_capture:
                            if (i6 >= 10 && i6 < 30) {
                                seekBar2.setProgress(20);
                                d(1);
                                return;
                            } else if (i6 >= 30 && i6 < 50) {
                                seekBar2.setProgress(40);
                                d(2);
                                return;
                            } else if (i6 < 50 || i6 >= 70) {
                                if (i6 >= 70 && i6 < 90) {
                                    seekBar2.setProgress(80);
                                    i5 = 4;
                                } else if (i6 < 90 || i6 > 100) {
                                    seekBar2.setProgress(0);
                                    d(0);
                                    return;
                                } else {
                                    seekBar2.setProgress(100);
                                    i5 = 5;
                                }
                                d(i5);
                                return;
                            } else {
                                seekBar2.setProgress(60);
                                d(3);
                                return;
                            }
                        case R.id.seek_tv_format:
                            if (i6 < 30 || i6 > 100) {
                                seekBar2.setProgress(0);
                                b(0);
                                return;
                            }
                            seekBar2.setProgress(46);
                            b(1);
                            return;
                        default:
                            return;
                    }
                } else if (i6 >= 25 && i6 < 75) {
                    seekBar2.setProgress(50);
                    a(1);
                } else if (i6 < 75 || i6 > 100) {
                    seekBar2.setProgress(0);
                    a(0);
                } else {
                    seekBar2.setProgress(100);
                    a(2);
                }
            } else if (i6 >= 25 && i6 < 75) {
                seekBar2.setProgress(50);
                g(1);
            } else if (i6 < 75 || i6 > 100) {
                seekBar2.setProgress(0);
                g(0);
            } else {
                seekBar2.setProgress(100);
                g(2);
            }
        } else if (i6 >= 25 && i6 < 75) {
            seekBar2.setProgress(50);
            c(1);
        } else if (i6 < 75 || i6 > 100) {
            seekBar2.setProgress(0);
            c(0);
        } else {
            seekBar2.setProgress(100);
            c(2);
        }
    }

    public void onResume() {
        super.onResume();
        j();
        this.M = new WifiDisconnectReceiver(getActivity());
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("com.xeagle.DV_ISALIVE_ACTION");
        getActivity().registerReceiver(this.M, intentFilter);
    }

    public void onStart() {
        super.onStart();
        this.N = new C0208a();
        getActivity().registerReceiver(this.N, new IntentFilter("com.xeagle.MESSAGE_ACTION"));
        i();
        j();
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStop() {
        super.onStop();
        if (this.N != null) {
            getActivity().unregisterReceiver(this.N);
            this.N = null;
        }
        WifiDisconnectReceiver wifiDisconnectReceiver = this.M;
        if (wifiDisconnectReceiver != null) {
            wifiDisconnectReceiver.a();
            getActivity().unregisterReceiver(this.M);
            this.M = null;
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
