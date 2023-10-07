package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.newUI.cameraManager.AmbaClient;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import la.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class ab extends c implements View.OnClickListener, a.b {
    /* access modifiers changed from: private */
    public static List<String> B = null;
    /* access modifiers changed from: private */
    public static List<String> C = Arrays.asList(new String[]{"-2.0", "-1.7", "-1.3", "-1.0", "-0.7", "-0.3", "0.0", "+0.3", "+0.7", "+1.0", "+1.3", "+1.7", "+2.0"});
    /* access modifiers changed from: private */
    public static List<String> D = Arrays.asList(new String[]{"auto", "incandescent", "D4000", "D5000", "sunny", "clouldy", "D9000", "D10000", "fluorescent", "water"});
    /* access modifiers changed from: private */
    public static List<String> E = Arrays.asList(new String[]{"off", "date", "time", "date/time"});
    /* access modifiers changed from: private */
    public static List<String> F = Arrays.asList(new String[]{"off", "date", "time", "date/time"});
    /* access modifiers changed from: private */
    public static List<String> G = null;
    /* access modifiers changed from: private */
    public static List<String> H = Arrays.asList(new String[]{"Auto", "100", "200", "400", "800", "1600"});
    /* access modifiers changed from: private */
    public static List<String> I = Arrays.asList(new String[]{"Wide", "Normal", "Narrow"});
    /* access modifiers changed from: private */
    public static List<String> J = Arrays.asList(new String[]{"Normal", "Flash", "Night", "Sports", "Landscape", "Portrait", "Sunset"});
    /* access modifiers changed from: private */
    public static List<String> K = Arrays.asList(new String[]{"Normal", "Art", "Sepia", "Negative", "BW", "Vivid", "70film"});
    private static List<String> L = m();
    /* access modifiers changed from: private */
    public static List<String> M = Arrays.asList(new String[]{"off", "1s"});
    /* access modifiers changed from: private */
    public static String[] Y = {"video_resolution", "EV_Value", "AWB", "video_stamp", "photo_stamp", "photo_size", "ISO", "FOV", "Scene_Mode", "Effect_Mode", "video_timelapse"};

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f12378a = true;

    /* renamed from: ap  reason: collision with root package name */
    private static final String[] f12379ap = {"4K 15FPS"};

    /* renamed from: aq  reason: collision with root package name */
    private static final String[] f12380aq = {"3840x2160 15P 16:9"};

    /* renamed from: ar  reason: collision with root package name */
    private static final String[] f12381ar = {"3840x2160 30P 16:9", "2704x1520 30P 16:9", "1920x1080 60P 16:9", "1920x1080 30P 16:9", "1280x720 60P 16:9"};

    /* renamed from: as  reason: collision with root package name */
    private static final String[] f12382as = {"20M (5120x3840 4:3)", "13M (4832x2718 16:9)", "13M (4192x3104 4:3)", "10M (3648x2736 4:3)", "8M (3840x2160 16:9)"};
    /* access modifiers changed from: private */
    public LinearLayoutManager A;
    private List<String> N;
    private List<String> O;
    private List<String> P;
    private List<String> Q;
    private List<String> R;
    private List<String> S;
    private List<String> T;
    private List<String> U;
    private List<String> V;
    private List<String> W;
    private List<String> X;
    /* access modifiers changed from: private */
    public a Z;
    /* access modifiers changed from: private */

    /* renamed from: aa  reason: collision with root package name */
    public a f12383aa;
    /* access modifiers changed from: private */

    /* renamed from: ab  reason: collision with root package name */
    public a f12384ab;
    /* access modifiers changed from: private */

    /* renamed from: ac  reason: collision with root package name */
    public a f12385ac;
    /* access modifiers changed from: private */

    /* renamed from: ad  reason: collision with root package name */
    public a f12386ad;
    /* access modifiers changed from: private */

    /* renamed from: ae  reason: collision with root package name */
    public a f12387ae;
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public a f12388af;
    /* access modifiers changed from: private */

    /* renamed from: ag  reason: collision with root package name */
    public a f12389ag;
    /* access modifiers changed from: private */

    /* renamed from: ah  reason: collision with root package name */
    public a f12390ah;
    /* access modifiers changed from: private */

    /* renamed from: ai  reason: collision with root package name */
    public a f12391ai;

    /* renamed from: aj  reason: collision with root package name */
    private a f12392aj;
    /* access modifiers changed from: private */

    /* renamed from: ak  reason: collision with root package name */
    public a f12393ak;

    /* renamed from: al  reason: collision with root package name */
    private FlightActionActivity f12394al;
    /* access modifiers changed from: private */

    /* renamed from: am  reason: collision with root package name */
    public AmbaClient f12395am;

    /* renamed from: an  reason: collision with root package name */
    private String f12396an;

    /* renamed from: ao  reason: collision with root package name */
    private int f12397ao;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f12398b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f12399c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f12400d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f12401e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f12402f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f12403g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f12404h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f12405i;

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView f12406j;

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f12407k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f12408l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f12409m;

    /* renamed from: n  reason: collision with root package name */
    private IImageButton f12410n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f12411o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public LinearLayoutManager f12412p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public LinearLayoutManager f12413q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public LinearLayoutManager f12414r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public LinearLayoutManager f12415s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public LinearLayoutManager f12416t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public LinearLayoutManager f12417u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public LinearLayoutManager f12418v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public LinearLayoutManager f12419w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public LinearLayoutManager f12420x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public LinearLayoutManager f12421y;

    /* renamed from: z  reason: collision with root package name */
    private LinearLayoutManager f12422z;

    private void a(int i2, Object obj) {
        if (i2 == 128) {
            ((String) obj).contains("\"msg_id\":3");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r17, java.lang.Object r18, java.lang.String... r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = 80
            if (r0 < r3) goto L_0x000e
            r16.a(r17, r18)
            return
        L_0x000e:
            r3 = 12
            java.lang.String r4 = "photo_size"
            java.lang.String r5 = "photo_stamp"
            java.lang.String r6 = "video_stamp"
            java.lang.String r7 = "video_resolution"
            java.lang.String r8 = "type"
            r10 = 4
            r11 = 3
            r12 = 2
            r13 = 1
            r14 = 0
            r15 = -1
            java.lang.String r9 = "FOV"
            if (r0 == r3) goto L_0x0166
            r3 = 22
            if (r0 == r3) goto L_0x0081
            r3 = 40
            if (r0 == r3) goto L_0x0055
            r3 = 55
            if (r0 == r3) goto L_0x0032
            goto L_0x01de
        L_0x0032:
            r0 = r2
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r2 = "rval"
            int r2 = r0.getInt(r2)     // Catch:{ JSONException -> 0x01da }
            if (r2 >= 0) goto L_0x003f
            goto L_0x01de
        L_0x003f:
            java.lang.String r2 = "param"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x01da }
            java.lang.String r0 = r0.getString(r8)     // Catch:{ JSONException -> 0x01da }
            com.xeagle.android.activities.FlightActionActivity r3 = r1.f12394al     // Catch:{ JSONException -> 0x01da }
            com.xeagle.android.dialogs.ab$3 r4 = new com.xeagle.android.dialogs.ab$3     // Catch:{ JSONException -> 0x01da }
            r4.<init>(r0, r2)     // Catch:{ JSONException -> 0x01da }
            r3.runOnUiThread(r4)     // Catch:{ JSONException -> 0x01da }
            goto L_0x01de
        L_0x0055:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "handleCmdChannelEvent:---notification--- "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "CmdChannel"
            android.util.Log.i(r3, r0)
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0
            int r2 = r0.hashCode()
            r3 = -1963280567(0xffffffff8afab749, float:-2.4143069E-32)
            if (r2 == r3) goto L_0x0079
            goto L_0x01de
        L_0x0079:
            java.lang.String r2 = "CAMERA_VF_START_END"
            boolean r0 = r0.equals(r2)
            goto L_0x01de
        L_0x0081:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "handleCmdChannelEvent:-----stop vf==== "
            r0.append(r2)
            java.lang.String r2 = r1.f12396an
            r0.append(r2)
            java.lang.String r2 = "===STOP POS==="
            r0.append(r2)
            int r2 = r1.f12397ao
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "CameraSetting"
            android.util.Log.i(r2, r0)
            java.lang.String r0 = r1.f12396an
            r0.hashCode()
            int r2 = r0.hashCode()
            switch(r2) {
                case -1625795236: goto L_0x00e5;
                case -1610351490: goto L_0x00da;
                case -515529211: goto L_0x00cf;
                case -369341561: goto L_0x00c4;
                case 69805: goto L_0x00bb;
                case 364904517: goto L_0x00b0;
                default: goto L_0x00af;
            }
        L_0x00af:
            goto L_0x00ef
        L_0x00b0:
            java.lang.String r2 = "videoTimelapse"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00b9
            goto L_0x00ef
        L_0x00b9:
            r15 = 5
            goto L_0x00ef
        L_0x00bb:
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x00c2
            goto L_0x00ef
        L_0x00c2:
            r15 = 4
            goto L_0x00ef
        L_0x00c4:
            java.lang.String r2 = "videoResolution"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00cd
            goto L_0x00ef
        L_0x00cd:
            r15 = 3
            goto L_0x00ef
        L_0x00cf:
            java.lang.String r2 = "photoWater"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00d8
            goto L_0x00ef
        L_0x00d8:
            r15 = 2
            goto L_0x00ef
        L_0x00da:
            java.lang.String r2 = "photoResolution"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00e3
            goto L_0x00ef
        L_0x00e3:
            r15 = 1
            goto L_0x00ef
        L_0x00e5:
            java.lang.String r2 = "videoWater"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00ee
            goto L_0x00ef
        L_0x00ee:
            r15 = 0
        L_0x00ef:
            switch(r15) {
                case 0: goto L_0x0153;
                case 1: goto L_0x0140;
                case 2: goto L_0x012d;
                case 3: goto L_0x011a;
                case 4: goto L_0x0107;
                case 5: goto L_0x00f4;
                default: goto L_0x00f2;
            }
        L_0x00f2:
            goto L_0x01de
        L_0x00f4:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12395am
            if (r0 == 0) goto L_0x01de
            java.util.List<java.lang.String> r2 = M
            int r3 = r1.f12397ao
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            r0.h(r2)
            goto L_0x01de
        L_0x0107:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12395am
            if (r0 == 0) goto L_0x01de
            java.util.List<java.lang.String> r2 = I
            int r3 = r1.f12397ao
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            r0.a((java.lang.String) r9, (java.lang.String) r2)
            goto L_0x01de
        L_0x011a:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12395am
            if (r0 == 0) goto L_0x01de
            java.util.List<java.lang.String> r2 = B
            int r3 = r1.f12397ao
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            r0.a((java.lang.String) r7, (java.lang.String) r2)
            goto L_0x01de
        L_0x012d:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12395am
            if (r0 == 0) goto L_0x01de
            java.util.List<java.lang.String> r2 = F
            int r3 = r1.f12397ao
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            r0.a((java.lang.String) r5, (java.lang.String) r2)
            goto L_0x01de
        L_0x0140:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12395am
            if (r0 == 0) goto L_0x01de
            java.util.List<java.lang.String> r2 = G
            int r3 = r1.f12397ao
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            r0.a((java.lang.String) r4, (java.lang.String) r2)
            goto L_0x01de
        L_0x0153:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12395am
            if (r0 == 0) goto L_0x01de
            java.util.List<java.lang.String> r2 = E
            int r3 = r1.f12397ao
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            r0.a((java.lang.String) r6, (java.lang.String) r2)
            goto L_0x01de
        L_0x0166:
            r0 = r2
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r0 = r0.getString(r8)     // Catch:{ JSONException -> 0x01da }
            int r2 = r0.hashCode()     // Catch:{ JSONException -> 0x01da }
            switch(r2) {
                case -507614738: goto L_0x01b3;
                case 69805: goto L_0x01ab;
                case 72805: goto L_0x01a1;
                case 1385607935: goto L_0x0199;
                case 1444116342: goto L_0x0191;
                case 1612033776: goto L_0x0189;
                case 1812923459: goto L_0x017f;
                case 2091387836: goto L_0x0175;
                default: goto L_0x0174;
            }     // Catch:{ JSONException -> 0x01da }
        L_0x0174:
            goto L_0x01bb
        L_0x0175:
            java.lang.String r2 = "video_timelapse"
            boolean r2 = r0.equals(r2)     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01bb
            r9 = 1
            goto L_0x01bc
        L_0x017f:
            java.lang.String r2 = "EV_Value"
            boolean r2 = r0.equals(r2)     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01bb
            r9 = 7
            goto L_0x01bc
        L_0x0189:
            boolean r2 = r0.equals(r7)     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01bb
            r9 = 0
            goto L_0x01bc
        L_0x0191:
            boolean r2 = r0.equals(r5)     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01bb
            r9 = 3
            goto L_0x01bc
        L_0x0199:
            boolean r2 = r0.equals(r6)     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01bb
            r9 = 2
            goto L_0x01bc
        L_0x01a1:
            java.lang.String r2 = "ISO"
            boolean r2 = r0.equals(r2)     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01bb
            r9 = 6
            goto L_0x01bc
        L_0x01ab:
            boolean r2 = r0.equals(r9)     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01bb
            r9 = 5
            goto L_0x01bc
        L_0x01b3:
            boolean r2 = r0.equals(r4)     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01bb
            r9 = 4
            goto L_0x01bc
        L_0x01bb:
            r9 = -1
        L_0x01bc:
            switch(r9) {
                case 0: goto L_0x01d0;
                case 1: goto L_0x01d0;
                case 2: goto L_0x01c8;
                case 3: goto L_0x01c8;
                case 4: goto L_0x01c8;
                case 5: goto L_0x01c8;
                case 6: goto L_0x01c0;
                case 7: goto L_0x01c0;
                default: goto L_0x01bf;
            }     // Catch:{ JSONException -> 0x01da }
        L_0x01bf:
            goto L_0x01de
        L_0x01c0:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01de
        L_0x01c4:
            r2.c((java.lang.String) r0)     // Catch:{ JSONException -> 0x01da }
            goto L_0x01de
        L_0x01c8:
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r1.f12395am     // Catch:{ JSONException -> 0x01da }
            if (r0 == 0) goto L_0x01de
            r0.s()     // Catch:{ JSONException -> 0x01da }
            goto L_0x01de
        L_0x01d0:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am     // Catch:{ JSONException -> 0x01da }
            if (r2 == 0) goto L_0x01de
            r2.s()     // Catch:{ JSONException -> 0x01da }
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am     // Catch:{ JSONException -> 0x01da }
            goto L_0x01c4
        L_0x01da:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.dialogs.ab.a(int, java.lang.Object, java.lang.String[]):void");
    }

    private void a(View view) {
        this.f12398b = (RecyclerView) view.findViewById(R.id.video_resolution_wheel);
        this.f12399c = (RecyclerView) view.findViewById(R.id.ev_wheel);
        this.f12400d = (RecyclerView) view.findViewById(R.id.bw_wheel);
        this.f12401e = (RecyclerView) view.findViewById(R.id.video_water_wheel);
        this.f12402f = (RecyclerView) view.findViewById(R.id.photo_water_wheel);
        this.f12403g = (RecyclerView) view.findViewById(R.id.photo_resolution_wheel);
        this.f12404h = (RecyclerView) view.findViewById(R.id.iso_wheel);
        this.f12405i = (RecyclerView) view.findViewById(R.id.fov_wheel);
        this.f12406j = (RecyclerView) view.findViewById(R.id.scene_mode_wheel);
        this.f12407k = (RecyclerView) view.findViewById(R.id.effect_mode_wheel);
        this.f12408l = (RecyclerView) view.findViewById(R.id.saturation_wheel);
        this.f12409m = (RecyclerView) view.findViewById(R.id.video_timelapse_wheel);
        this.f12411o = (TextView) view.findViewById(R.id.video_timelapse_tv);
        this.f12410n = (IImageButton) view.findViewById(R.id.camera_cancel_ib);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12412p = linearLayoutManager;
        linearLayoutManager.b(0);
        this.f12398b.setLayoutManager(this.f12412p);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12413q = linearLayoutManager2;
        linearLayoutManager2.b(0);
        this.f12399c.setLayoutManager(this.f12413q);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12414r = linearLayoutManager3;
        linearLayoutManager3.b(0);
        this.f12400d.setLayoutManager(this.f12414r);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12415s = linearLayoutManager4;
        linearLayoutManager4.b(0);
        this.f12401e.setLayoutManager(this.f12415s);
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12416t = linearLayoutManager5;
        linearLayoutManager5.b(0);
        this.f12402f.setLayoutManager(this.f12416t);
        LinearLayoutManager linearLayoutManager6 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12417u = linearLayoutManager6;
        linearLayoutManager6.b(0);
        this.f12403g.setLayoutManager(this.f12417u);
        LinearLayoutManager linearLayoutManager7 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12418v = linearLayoutManager7;
        linearLayoutManager7.b(0);
        this.f12404h.setLayoutManager(this.f12418v);
        LinearLayoutManager linearLayoutManager8 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12419w = linearLayoutManager8;
        linearLayoutManager8.b(0);
        this.f12405i.setLayoutManager(this.f12419w);
        LinearLayoutManager linearLayoutManager9 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12420x = linearLayoutManager9;
        linearLayoutManager9.b(0);
        this.f12406j.setLayoutManager(this.f12420x);
        LinearLayoutManager linearLayoutManager10 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12421y = linearLayoutManager10;
        linearLayoutManager10.b(0);
        this.f12407k.setLayoutManager(this.f12421y);
        LinearLayoutManager linearLayoutManager11 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.A = linearLayoutManager11;
        linearLayoutManager11.b(0);
        this.f12409m.setLayoutManager(this.A);
        this.f12409m.setVisibility(8);
        this.f12411o.setVisibility(8);
        LinearLayoutManager linearLayoutManager12 = new LinearLayoutManager(this.f12394al.getApplicationContext());
        this.f12422z = linearLayoutManager12;
        linearLayoutManager12.b(0);
        this.f12408l.setLayoutManager(this.f12422z);
        this.f12410n.setOnClickListener(this);
        b(f12381ar);
        a(getResources().getStringArray(R.array.video_resolution));
        a aVar = new a(this.f12398b, this.f12394al.getApplicationContext(), this.N);
        this.Z = aVar;
        this.f12398b.setAdapter(aVar);
        this.Z.a(this.f12412p, 0);
        this.Z.a((a.b) this);
        this.O = Arrays.asList(this.f12394al.getResources().getStringArray(R.array.ev_value));
        a aVar2 = new a(this.f12399c, this.f12394al.getApplicationContext(), this.O);
        this.f12383aa = aVar2;
        this.f12399c.setAdapter(aVar2);
        this.f12383aa.a(this.f12413q, 0);
        this.f12383aa.a((a.b) this);
        this.P = Arrays.asList(this.f12394al.getResources().getStringArray(R.array.awb_value));
        a aVar3 = new a(this.f12400d, this.f12394al.getApplicationContext(), this.P);
        this.f12384ab = aVar3;
        this.f12400d.setAdapter(aVar3);
        this.f12384ab.a(this.f12414r, 0);
        this.f12384ab.a((a.b) this);
        this.Q = Arrays.asList(this.f12394al.getResources().getStringArray(R.array.video_watermark));
        a aVar4 = new a(this.f12401e, this.f12394al.getApplicationContext(), this.Q);
        this.f12385ac = aVar4;
        this.f12401e.setAdapter(aVar4);
        this.f12385ac.a(this.f12415s, 0);
        this.f12385ac.a((a.b) this);
        this.R = Arrays.asList(this.f12394al.getResources().getStringArray(R.array.photo_watermark));
        a aVar5 = new a(this.f12402f, this.f12394al.getApplicationContext(), this.R);
        this.f12386ad = aVar5;
        this.f12402f.setAdapter(aVar5);
        this.f12386ad.a(this.f12416t, 0);
        this.f12386ad.a((a.b) this);
        d(f12382as);
        this.S = Arrays.asList(c(getResources().getStringArray(R.array.photo_resolution)));
        a aVar6 = new a(this.f12403g, this.f12394al.getApplicationContext(), this.S);
        this.f12387ae = aVar6;
        this.f12403g.setAdapter(aVar6);
        this.f12387ae.a(this.f12417u, 0);
        this.f12387ae.a((a.b) this);
        this.T = Arrays.asList(this.f12394al.getResources().getStringArray(R.array.iso_value));
        a aVar7 = new a(this.f12404h, this.f12394al.getApplicationContext(), this.T);
        this.f12388af = aVar7;
        this.f12404h.setAdapter(aVar7);
        this.f12388af.a(this.f12418v, 0);
        this.f12388af.a((a.b) this);
        this.U = Arrays.asList(this.f12394al.getResources().getStringArray(R.array.fov_value));
        a aVar8 = new a(this.f12405i, this.f12394al.getApplicationContext(), this.U);
        this.f12389ag = aVar8;
        this.f12405i.setAdapter(aVar8);
        this.f12389ag.a(this.f12419w, 0);
        this.f12389ag.a((a.b) this);
        this.V = Arrays.asList(this.f12394al.getResources().getStringArray(R.array.scene_mode));
        a aVar9 = new a(this.f12406j, this.f12394al.getApplicationContext(), this.V);
        this.f12390ah = aVar9;
        this.f12406j.setAdapter(aVar9);
        this.f12390ah.a(this.f12420x, 0);
        this.f12390ah.a((a.b) this);
        this.W = Arrays.asList(this.f12394al.getResources().getStringArray(R.array.effect_mode));
        a aVar10 = new a(this.f12407k, this.f12394al.getApplicationContext(), this.W);
        this.f12391ai = aVar10;
        this.f12407k.setAdapter(aVar10);
        this.f12391ai.a(this.f12421y, 0);
        this.f12391ai.a((a.b) this);
        this.X = Arrays.asList(this.f12394al.getResources().getStringArray(R.array.video_timelapse));
        a aVar11 = new a(this.f12409m, this.f12394al.getApplicationContext(), this.X);
        this.f12393ak = aVar11;
        this.f12409m.setAdapter(aVar11);
        this.f12393ak.a(this.A, 0);
        this.f12393ak.a((a.b) this);
        a aVar12 = new a(this.f12408l, this.f12394al.getApplicationContext(), m());
        this.f12392aj = aVar12;
        this.f12408l.setAdapter(aVar12);
        this.f12392aj.a(this.f12422z, 0);
        this.f12392aj.a((a.b) this);
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                if (ab.this.f12395am != null) {
                    for (String c2 : ab.Y) {
                        ab.this.f12395am.c(c2);
                        SystemClock.sleep(200);
                    }
                }
            }
        });
    }

    private void a(String[] strArr) {
        List<String> asList;
        com.xeagle.android.utils.prefs.a j2 = ((XEagleApp) this.f12394al.getApplicationContext()).j();
        if (UserGlobal.DRONE_NAME_DF809_D.equals(j2.j())) {
            int length = strArr.length - 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 1, strArr2, 0, length);
            strArr2[0] = strArr2[0] + getResources().getString(R.string.par_default);
            asList = Arrays.asList(strArr2);
        } else if (UserGlobal.DRONE_NAME_DF812_D.equals(j2.j())) {
            int length2 = strArr.length;
            String[] strArr3 = new String[length2];
            String[] strArr4 = f12379ap;
            System.arraycopy(strArr4, 0, strArr3, 0, strArr4.length);
            System.arraycopy(strArr, 1, strArr3, 1, length2 - 1);
            strArr3[0] = strArr3[0] + getResources().getString(R.string.par_default);
            asList = Arrays.asList(strArr3);
        } else {
            asList = Arrays.asList(strArr);
        }
        this.N = asList;
    }

    private void b(String[] strArr) {
        List<String> asList;
        com.xeagle.android.utils.prefs.a j2 = XEagleApp.d().j();
        if (UserGlobal.DRONE_NAME_DF809_D.equals(j2.j())) {
            int length = strArr.length - 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 1, strArr2, 0, length);
            asList = Arrays.asList(strArr2);
        } else if (UserGlobal.DRONE_NAME_DF812_D.equals(j2.j())) {
            int length2 = strArr.length;
            String[] strArr3 = new String[length2];
            String[] strArr4 = f12380aq;
            System.arraycopy(strArr4, 0, strArr3, 0, strArr4.length);
            System.arraycopy(strArr, 1, strArr3, 1, length2 - 1);
            asList = Arrays.asList(strArr3);
        } else {
            asList = Arrays.asList(strArr);
        }
        B = asList;
    }

    private String[] c(String[] strArr) {
        String[] strArr2;
        com.xeagle.android.utils.prefs.a j2 = XEagleApp.d().j();
        if (UserGlobal.DRONE_NAME_DF809_D.equals(j2.j())) {
            int length = strArr.length - 3;
            strArr2 = new String[length];
            System.arraycopy(strArr, 3, strArr2, 0, length);
            strArr2[0] = strArr2[0] + getResources().getString(R.string.par_default);
        } else if (!UserGlobal.DRONE_NAME_DF812_D.equals(j2.j())) {
            return strArr;
        } else {
            int length2 = strArr.length - 1;
            strArr2 = new String[length2];
            System.arraycopy(strArr, 1, strArr2, 0, length2);
            strArr2[0] = strArr2[0] + getResources().getString(R.string.par_default);
        }
        return strArr2;
    }

    private void d(String[] strArr) {
        List<String> asList;
        com.xeagle.android.utils.prefs.a j2 = ((XEagleApp) this.f12394al.getApplicationContext()).j();
        if (UserGlobal.DRONE_NAME_DF809_D.equals(j2.j())) {
            int length = strArr.length - 3;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 3, strArr2, 0, length);
            asList = Arrays.asList(strArr2);
        } else if (UserGlobal.DRONE_NAME_DF812_D.equals(j2.j())) {
            int length2 = strArr.length - 1;
            String[] strArr3 = new String[length2];
            System.arraycopy(strArr, 1, strArr3, 0, length2);
            asList = Arrays.asList(strArr3);
        } else {
            asList = Arrays.asList(strArr);
        }
        G = asList;
    }

    private static ArrayList<String> m() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < 256; i2++) {
            arrayList.add(i2 + "");
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d5, code lost:
        r1.f12396an = r4;
        r1.f12397ao = r3;
        r2.t();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0124, code lost:
        r2.a(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.recyclerview.widget.RecyclerView r2, int r3, java.lang.String r4) {
        /*
            r1 = this;
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "onClick: ----v--"
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = "---pos--"
            r4.append(r0)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "Wheel"
            android.util.Log.i(r0, r4)
            int r2 = r2.getId()
            switch(r2) {
                case 2131296734: goto L_0x010d;
                case 2131297082: goto L_0x00f5;
                case 2131297115: goto L_0x00dd;
                case 2131297268: goto L_0x00c6;
                case 2131297504: goto L_0x00ae;
                case 2131298361: goto L_0x009e;
                case 2131298364: goto L_0x008e;
                case 2131298669: goto L_0x0073;
                case 2131298683: goto L_0x005a;
                case 2131299733: goto L_0x0049;
                case 2131299740: goto L_0x0038;
                case 2131299791: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0127
        L_0x0027:
            la.a r2 = r1.f12385ac
            if (r2 == 0) goto L_0x0030
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12415s
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x0030:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.lang.String r4 = "videoWater"
            goto L_0x00d5
        L_0x0038:
            la.a r2 = r1.f12393ak
            if (r2 == 0) goto L_0x0041
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.A
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x0041:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.lang.String r4 = "videoTimelapse"
            goto L_0x00d5
        L_0x0049:
            la.a r2 = r1.Z
            if (r2 == 0) goto L_0x0052
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12412p
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x0052:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.lang.String r4 = "videoResolution"
            goto L_0x00d5
        L_0x005a:
            la.a r2 = r1.f12390ah
            if (r2 == 0) goto L_0x0063
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12420x
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x0063:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.util.List<java.lang.String> r4 = J
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "Scene_Mode"
            goto L_0x0124
        L_0x0073:
            la.a r2 = r1.f12392aj
            if (r2 == 0) goto L_0x007c
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12422z
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x007c:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.util.ArrayList r4 = m()
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "Saturation"
            goto L_0x0124
        L_0x008e:
            la.a r2 = r1.f12386ad
            if (r2 == 0) goto L_0x0097
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12416t
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x0097:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.lang.String r4 = "photoWater"
            goto L_0x00d5
        L_0x009e:
            la.a r2 = r1.f12387ae
            if (r2 == 0) goto L_0x00a7
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12417u
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x00a7:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.lang.String r4 = "photoResolution"
            goto L_0x00d5
        L_0x00ae:
            la.a r2 = r1.f12388af
            if (r2 == 0) goto L_0x00b7
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12418v
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x00b7:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.util.List<java.lang.String> r4 = H
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "ISO"
            goto L_0x0124
        L_0x00c6:
            la.a r2 = r1.f12389ag
            if (r2 == 0) goto L_0x00cf
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12419w
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x00cf:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.lang.String r4 = "FOV"
        L_0x00d5:
            r1.f12396an = r4
            r1.f12397ao = r3
            r2.t()
            goto L_0x0127
        L_0x00dd:
            la.a r2 = r1.f12383aa
            if (r2 == 0) goto L_0x0127
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12413q
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.util.List<java.lang.String> r4 = C
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "EV_Value"
            goto L_0x0124
        L_0x00f5:
            la.a r2 = r1.f12391ai
            if (r2 == 0) goto L_0x00fe
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12421y
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x00fe:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.util.List<java.lang.String> r4 = K
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "Effect_Mode"
            goto L_0x0124
        L_0x010d:
            la.a r2 = r1.f12384ab
            if (r2 == 0) goto L_0x0116
            androidx.recyclerview.widget.LinearLayoutManager r4 = r1.f12414r
            r2.a((androidx.recyclerview.widget.LinearLayoutManager) r4, (int) r3)
        L_0x0116:
            com.xeagle.android.newUI.cameraManager.AmbaClient r2 = r1.f12395am
            if (r2 == 0) goto L_0x0127
            java.util.List<java.lang.String> r4 = D
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "AWB"
        L_0x0124:
            r2.a((java.lang.String) r4, (java.lang.String) r3)
        L_0x0127:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.dialogs.ab.a(androidx.recyclerview.widget.RecyclerView, int, java.lang.String):void");
    }

    @l(a = ThreadMode.MAIN)
    public void channelEvent(jo.c cVar) {
        if ((cVar.a() & IChannelListener.MSG_MASK) == 0) {
            a(cVar.a(), cVar.b(), new String[0]);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f12394al = (FlightActionActivity) context;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.camera_cancel_ib) {
            dismiss();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.newDialog).create();
        create.requestWindowFeature(8);
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(true);
        Window window = create.getWindow();
        if (f12378a || window != null) {
            window.setGravity(5);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 9) / 16, getActivity().getWindowManager().getDefaultDisplay().getHeight());
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.re_camera_dlg, viewGroup, false);
        if (((XEagleApp) this.f12394al.getApplicationContext()).m().a() == 1) {
            this.f12395am = ((XEagleApp) this.f12394al.getApplicationContext()).g();
        }
        a(inflate);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4) {
                    return false;
                }
                dialogInterface.dismiss();
                return false;
            }
        });
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }
}
