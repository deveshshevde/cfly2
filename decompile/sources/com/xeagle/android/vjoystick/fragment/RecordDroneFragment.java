package com.xeagle.android.vjoystick.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.MAVLink.Messages.ApmModes;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.ab;
import com.recyclerview.swipe.SwipeMenuRecyclerView;
import com.recyclerview.swipe.i;
import com.recyclerview.swipe.j;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.RecordViewActivity;
import ea.g;
import ea.h;
import java.io.File;
import java.util.ArrayList;
import la.e;

public class RecordDroneFragment extends b implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    private ab f24988e;

    /* renamed from: f  reason: collision with root package name */
    private en.a f24989f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f24990g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public e f24991h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public g f24992i;

    /* renamed from: j  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f24993j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24994k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24995l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24996m;

    /* renamed from: n  reason: collision with root package name */
    private Handler f24997n = new Handler();

    /* renamed from: o  reason: collision with root package name */
    private Runnable f24998o = new Runnable() {
        public void run() {
            RecordDroneFragment.this.b();
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private i f24999p = new i() {
        public void a(com.recyclerview.swipe.g gVar, com.recyclerview.swipe.g gVar2, int i2) {
            gVar2.a(new j(RecordDroneFragment.this.getActivity().getApplicationContext()).a((int) R.drawable.selector_red).b(R.string.delete).c(-1).d(120).e(-1));
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private com.recyclerview.swipe.b f25000q = new com.recyclerview.swipe.b() {
        public void a(final com.recyclerview.swipe.a aVar, final int i2, final int i3, int i4) {
            d a2 = d.a("del", RecordDroneFragment.this.getActivity().getString(R.string.deletefile_msg), new d.a() {
                public void onNo() {
                }

                public void onYes() {
                    aVar.a();
                    if (i3 == 0) {
                        File file = new File(RecordDroneFragment.this.f24992i.a(RecordDroneFragment.this.requireActivity().getApplicationContext()) + ((String) RecordDroneFragment.this.f24990g.get(i2)));
                        if (file.exists() && file.delete()) {
                            RecordDroneFragment.this.f24990g.remove(i2);
                            RecordDroneFragment.this.f24991h.notifyItemRemoved(i2);
                        }
                    }
                }
            });
            if (a2 != null) {
                a2.show(RecordDroneFragment.this.getChildFragmentManager(), "Local");
            }
        }
    };
    @BindView(2131298528)
    IImageButton recordList;
    @BindView(2131298530)
    IImageButton recordMake;
    @BindView(2131298532)
    RelativeLayout recordRl;
    @BindView(2131298534)
    IImageButton recordStart;
    @BindView(2131298535)
    IImageButton recordStop;
    @BindView(2131298529)
    SwipeMenuRecyclerView record_recycler;
    @BindView(2131298538)
    Chronometer record_time;
    @BindView(2131298550)
    ImageView red_point;
    @BindView(2131299845)
    IImageButton waypointSet;

    /* renamed from: com.xeagle.android.vjoystick.fragment.RecordDroneFragment$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25011a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25011a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.RECORD_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25011a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.STATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f25011a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.fragment.RecordDroneFragment.AnonymousClass7.<clinit>():void");
        }
    }

    public class a extends AsyncTask<Integer, Integer, Integer> {
        public a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Integer doInBackground(Integer... numArr) {
            RecordDroneFragment.this.f24990g.clear();
            RecordDroneFragment recordDroneFragment = RecordDroneFragment.this;
            ArrayList unused = recordDroneFragment.f24990g = recordDroneFragment.f24992i.b(RecordDroneFragment.this.requireActivity().getApplicationContext());
            return 1;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            RecordDroneFragment recordDroneFragment = RecordDroneFragment.this;
            e unused = recordDroneFragment.f24991h = new e(recordDroneFragment.f24990g);
            RecordDroneFragment.this.f24991h.notifyDataSetChanged();
            RecordDroneFragment.this.record_recycler.setAdapter(RecordDroneFragment.this.f24991h);
            RecordDroneFragment.this.f24991h.a((e.a) new e.a() {
                public void a(View view, int i2) {
                    ad.a.a((Context) RecordDroneFragment.this.getActivity()).a(new Intent("compass_back_action"));
                    Intent intent = new Intent(RecordDroneFragment.this.getActivity(), RecordViewActivity.class);
                    intent.putExtra("tab_name", (String) RecordDroneFragment.this.f24990g.get(i2));
                    intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                    RecordDroneFragment.this.getActivity().getApplicationContext().startActivity(intent);
                }

                public void b(View view, int i2) {
                }

                public void c(View view, int i2) {
                    ad.a.a((Context) RecordDroneFragment.this.getActivity()).a(new Intent("compass_back_action"));
                    Intent intent = new Intent(RecordDroneFragment.this.getActivity(), RecordViewActivity.class);
                    intent.putExtra("tab_name", (String) RecordDroneFragment.this.f24990g.get(i2));
                    intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                    RecordDroneFragment.this.getActivity().getApplicationContext().startActivity(intent);
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            RecordDroneFragment.this.f24990g.clear();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.f24996m) {
            this.red_point.setVisibility(0);
            this.f24996m = false;
        } else {
            this.red_point.setVisibility(4);
            this.f24996m = true;
        }
        this.f24997n.postDelayed(this.f24998o, 1000);
    }

    private void c() {
        this.f24997n.removeCallbacks(this.f24998o);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0060, code lost:
        r7.f24988e.c(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008a, code lost:
        android.widget.Toast.makeText(r8, r0, 1).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0035, code lost:
        r8.show(getChildFragmentManager(), "show");
     */
    @butterknife.OnClick({2131298530, 2131298534, 2131298535, 2131298528, 2131299845})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
            r7 = this;
            int r8 = r8.getId()
            r0 = 2131822488(0x7f110798, float:1.9277749E38)
            r1 = 8
            java.lang.String r2 = "Alt Hold"
            java.lang.String r3 = "show"
            java.lang.String r4 = "rc"
            r5 = 0
            r6 = 1
            switch(r8) {
                case 2131298528: goto L_0x0149;
                case 2131298530: goto L_0x00b9;
                case 2131298534: goto L_0x006f;
                case 2131298535: goto L_0x005a;
                case 2131299845: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x016c
        L_0x0016:
            en.a r8 = r7.f24989f
            com.flypro.core.drone.variables.v r8 = r8.E()
            int r8 = r8.a()
            if (r8 != r6) goto L_0x003e
            com.xeagle.android.dialogs.r r8 = com.xeagle.android.dialogs.r.a()
            java.lang.String r0 = r7.getString(r0)
            com.xeagle.android.vjoystick.fragment.RecordDroneFragment$4 r1 = new com.xeagle.android.vjoystick.fragment.RecordDroneFragment$4
            r1.<init>()
            com.xeagle.android.dialogs.c r8 = r8.a((java.lang.String) r4, (java.lang.String) r0, (com.xeagle.android.dialogs.c.a) r1)
            if (r8 == 0) goto L_0x016c
        L_0x0035:
            androidx.fragment.app.FragmentManager r0 = r7.getChildFragmentManager()
            r8.show(r0, r3)
            goto L_0x016c
        L_0x003e:
            en.a r8 = r7.f24989f
            com.flypro.core.drone.variables.aa r8 = r8.d()
            com.MAVLink.Messages.ApmModes r8 = r8.e()
            java.lang.String r8 = r8.b()
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x016c
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            r0 = 2131823233(0x7f110a81, float:1.927926E38)
            goto L_0x008a
        L_0x005a:
            com.flypro.core.drone.variables.ab r8 = r7.f24988e
            boolean r8 = r8.f14275d
            if (r8 == 0) goto L_0x0067
        L_0x0060:
            com.flypro.core.drone.variables.ab r8 = r7.f24988e
            r8.c((boolean) r5)
            goto L_0x016c
        L_0x0067:
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            r0 = 2131822503(0x7f1107a7, float:1.927778E38)
            goto L_0x008a
        L_0x006f:
            en.a r8 = r7.f24989f
            com.flypro.core.drone.variables.aa r8 = r8.d()
            com.MAVLink.Messages.ApmModes r8 = r8.e()
            java.lang.String r8 = r8.b()
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0093
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            r0 = 2131822501(0x7f1107a5, float:1.9277775E38)
        L_0x008a:
            android.widget.Toast r8 = android.widget.Toast.makeText(r8, r0, r6)
            r8.show()
            goto L_0x016c
        L_0x0093:
            com.flypro.core.drone.variables.ab r8 = r7.f24988e
            boolean r8 = r8.f14275d
            if (r8 != 0) goto L_0x0060
            com.flypro.core.drone.variables.ab r8 = r7.f24988e
            r8.b()
            com.flypro.core.drone.variables.ab r8 = r7.f24988e
            r8.c()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = "yyyy.MM.dd.HH.mm.ss"
            java.lang.String r8 = com.flypro.core.util.d.a((java.lang.String) r8, (long) r0)
            com.flypro.core.drone.variables.ab r0 = r7.f24988e
            r0.a((java.lang.String) r8)
            com.flypro.core.drone.variables.ab r8 = r7.f24988e
            r8.c((boolean) r6)
            goto L_0x016c
        L_0x00b9:
            en.a r8 = r7.f24989f
            com.flypro.core.drone.variables.v r8 = r8.E()
            int r8 = r8.a()
            if (r8 != r6) goto L_0x00da
            com.xeagle.android.dialogs.r r8 = com.xeagle.android.dialogs.r.a()
            java.lang.String r0 = r7.getString(r0)
            com.xeagle.android.vjoystick.fragment.RecordDroneFragment$2 r1 = new com.xeagle.android.vjoystick.fragment.RecordDroneFragment$2
            r1.<init>()
            com.xeagle.android.dialogs.c r8 = r8.a((java.lang.String) r4, (java.lang.String) r0, (com.xeagle.android.dialogs.c.a) r1)
            if (r8 == 0) goto L_0x016c
            goto L_0x0035
        L_0x00da:
            en.a r8 = r7.f24989f
            com.flypro.core.drone.variables.aa r8 = r8.d()
            boolean r8 = r8.d()
            if (r8 == 0) goto L_0x0131
            en.a r8 = r7.f24989f
            com.flypro.core.drone.variables.aa r8 = r8.d()
            com.MAVLink.Messages.ApmModes r8 = r8.e()
            java.lang.String r8 = r8.b()
            java.lang.String r0 = "Guided"
            boolean r8 = r8.equalsIgnoreCase(r0)
            if (r8 != 0) goto L_0x0131
            en.a r8 = r7.f24989f
            com.flypro.core.drone.variables.aa r8 = r8.d()
            com.MAVLink.Messages.ApmModes r8 = r8.e()
            java.lang.String r0 = "RTL"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0131
            en.a r8 = r7.f24989f
            com.flypro.core.drone.variables.aa r8 = r8.d()
            java.lang.String r0 = "Land"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x011d
            goto L_0x0131
        L_0x011d:
            boolean r8 = r7.f24994k
            if (r8 == 0) goto L_0x0129
            android.widget.RelativeLayout r8 = r7.recordRl
            r8.setVisibility(r1)
            r7.f24994k = r5
            goto L_0x016c
        L_0x0129:
            android.widget.RelativeLayout r8 = r7.recordRl
            r8.setVisibility(r5)
            r7.f24994k = r6
            goto L_0x016c
        L_0x0131:
            com.xeagle.android.dialogs.r r8 = com.xeagle.android.dialogs.r.a()
            r0 = 2131822502(0x7f1107a6, float:1.9277777E38)
            java.lang.String r0 = r7.getString(r0)
            com.xeagle.android.vjoystick.fragment.RecordDroneFragment$3 r1 = new com.xeagle.android.vjoystick.fragment.RecordDroneFragment$3
            r1.<init>()
            com.xeagle.android.dialogs.c r8 = r8.a((java.lang.String) r4, (java.lang.String) r0, (com.xeagle.android.dialogs.c.a) r1)
            if (r8 == 0) goto L_0x016c
            goto L_0x0035
        L_0x0149:
            boolean r8 = r7.f24995l
            if (r8 == 0) goto L_0x015d
            com.xeagle.android.vjoystick.IWidgets.IImageButton r8 = r7.recordList
            r0 = 2131232181(0x7f0805b5, float:1.8080464E38)
            r8.setImageResource(r0)
            com.recyclerview.swipe.SwipeMenuRecyclerView r8 = r7.record_recycler
            r8.setVisibility(r1)
            r7.f24995l = r5
            goto L_0x016c
        L_0x015d:
            com.xeagle.android.vjoystick.IWidgets.IImageButton r8 = r7.recordList
            r0 = 2131232182(0x7f0805b6, float:1.8080466E38)
            r8.setImageResource(r0)
            com.recyclerview.swipe.SwipeMenuRecyclerView r8 = r7.record_recycler
            r8.setVisibility(r5)
            r7.f24995l = r6
        L_0x016c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.fragment.RecordDroneFragment.onClick(android.view.View):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.record_drone_fragment, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        this.f24989f = ((XEagleApp) getActivity().getApplicationContext()).k();
        this.f24993j = ((XEagleApp) getActivity().getApplicationContext()).j();
        this.f24988e = this.f24989f.D();
        g gVar = new g();
        this.f24992i = gVar;
        this.f24990g = gVar.b(requireActivity().getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.b(1);
        this.record_recycler.setLayoutManager(linearLayoutManager);
        this.record_recycler.setSwipeMenuCreator(this.f24999p);
        this.record_recycler.setSwipeMenuItemClickListener(this.f25000q);
        new a().execute(new Integer[0]);
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        super.onDroneEvent(droneEventsType, aVar);
        int i2 = AnonymousClass7.f25011a[droneEventsType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    if (this.f24988e.f14275d && !aVar.d().e().b().equalsIgnoreCase("Alt Hold")) {
                        this.f24988e.c(false);
                    }
                    if (aVar.d().e().b().equals("Guided") && this.f24994k) {
                        this.f24994k = false;
                        this.recordRl.setVisibility(8);
                        if (this.f24995l) {
                            this.recordList.setVisibility(8);
                            this.recordList.setImageResource(R.drawable.record_list_nor);
                            this.f24995l = false;
                        }
                    }
                }
            } else if (!aVar.d().d() && this.recordRl.getVisibility() == 0) {
                this.recordRl.setVisibility(8);
            }
        } else if (this.f24988e.f14275d) {
            Toast.makeText(getActivity(), R.string.record_drone_start, 0).show();
            this.recordStart.setImageResource(R.drawable.bt_record_nor);
            aVar.d().b(ApmModes.ROTOR_LOITER);
            this.f24993j.b(true);
            ad.a.a((Context) getActivity()).a(new Intent("switch_rc_gravity"));
            c();
            b();
            this.record_time.setVisibility(0);
            this.record_time.setBase(SystemClock.elapsedRealtime());
            this.record_time.start();
        } else {
            if (this.f24988e.d().size() > 0) {
                h.a(requireActivity().getApplicationContext(), this.f24988e.d(), this.f24988e.f14278g);
            }
            new a().execute(new Integer[0]);
            Toast.makeText(getActivity(), R.string.record_drone_stop, 0).show();
            this.recordStart.setImageResource(R.drawable.bt_record_pre);
            c();
            this.f24996m = false;
            this.red_point.setVisibility(8);
            this.record_time.setVisibility(8);
            this.record_time.stop();
        }
    }

    public void onResume() {
        int i2;
        IImageButton iImageButton;
        super.onResume();
        if (this.f24988e.f14275d) {
            iImageButton = this.recordStart;
            i2 = R.drawable.bt_record_nor;
        } else {
            iImageButton = this.recordStart;
            i2 = R.drawable.bt_record_pre;
        }
        iImageButton.setImageResource(i2);
    }

    public void onStop() {
        super.onStop();
        if (this.f24988e.f14275d) {
            this.f24988e.c(false);
        }
    }
}
